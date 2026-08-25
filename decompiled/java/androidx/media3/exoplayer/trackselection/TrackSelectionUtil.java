package androidx.media3.exoplayer.trackselection;

import android.graphics.Point;
import android.os.SystemClock;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.util.Arrays;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;

@UnstableApi
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        C2180c5 c2180c5M5275r;
        List[] listArr = new List[trackSelectionArr.length];
        for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
            TrackSelection trackSelection = trackSelectionArr[i6];
            if (trackSelection != null) {
                c2180c5M5275r = AbstractC2301u1.m5275r(trackSelection);
            } else {
                C2204g1 c2204g1 = AbstractC2301u1.f8069b;
                c2180c5M5275r = C2180c5.f7862e;
            }
            listArr[i6] = c2180c5M5275r;
        }
        return buildTracks(mappedTrackInfo, (List<? extends TrackSelection>[]) listArr);
    }

    public static LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions(ExoTrackSelection exoTrackSelection) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i6 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if (exoTrackSelection.isTrackExcluded(i10, jElapsedRealtime)) {
                i6++;
            }
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, i6);
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z7 = false;
        for (int i6 = 0; i6 < definitionArr.length; i6++) {
            ExoTrackSelection.Definition definition = definitionArr[i6];
            if (definition != null) {
                int[] iArr = definition.tracks;
                if (iArr.length <= 1 || z7) {
                    exoTrackSelectionArr[i6] = new FixedTrackSelection(definition.group, iArr[0], definition.type);
                } else {
                    exoTrackSelectionArr[i6] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z7 = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    public static Point getMaxVideoSizeInViewport(boolean z7, int i6, int i10, int i11, int i12) {
        if (z7) {
            if ((i11 > i12) == (i6 > i10)) {
                i10 = i6;
                i6 = i10;
            }
        } else {
            i10 = i6;
            i6 = i10;
        }
        int i13 = i11 * i6;
        int i14 = i12 * i10;
        return i13 >= i14 ? new Point(i10, Util.ceilDivide(i14, i11)) : new Point(Util.ceilDivide(i13, i12), i6);
    }

    @Deprecated
    public static DefaultTrackSelector.Parameters updateParametersWithOverride(DefaultTrackSelector.Parameters parameters, int i6, TrackGroupArray trackGroupArray, boolean z7, DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.Parameters.Builder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i6).setRendererDisabled(i6, z7);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i6, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z7;
        C2288s1 c2288s1 = new C2288s1(4);
        for (int i6 = 0; i6 < mappedTrackInfo.getRendererCount(); i6++) {
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i6);
            List<? extends TrackSelection> list = listArr[i6];
            for (int i10 = 0; i10 < trackGroups.length; i10++) {
                TrackGroup trackGroup = trackGroups.get(i10);
                boolean z10 = mappedTrackInfo.getAdaptiveSupport(i6, i10, false) != 0;
                int i11 = trackGroup.length;
                int[] iArr = new int[i11];
                boolean[] zArr = new boolean[i11];
                for (int i12 = 0; i12 < trackGroup.length; i12++) {
                    iArr[i12] = mappedTrackInfo.getTrackSupport(i6, i10, i12);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            z7 = false;
                            break;
                        }
                        TrackSelection trackSelection = list.get(i13);
                        if (trackSelection.getTrackGroup().equals(trackGroup) && trackSelection.indexOf(i12) != -1) {
                            z7 = true;
                            break;
                        }
                        i13++;
                    }
                    zArr[i12] = z7;
                }
                c2288s1.m5255a(new Tracks.Group(trackGroup, z10, iArr, zArr));
            }
        }
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo.getUnmappedTrackGroups();
        for (int i14 = 0; i14 < unmappedTrackGroups.length; i14++) {
            TrackGroup trackGroup2 = unmappedTrackGroups.get(i14);
            int[] iArr2 = new int[trackGroup2.length];
            Arrays.fill(iArr2, 0);
            c2288s1.m5255a(new Tracks.Group(trackGroup2, false, iArr2, new boolean[trackGroup2.length]));
        }
        return new Tracks(c2288s1.m5262g());
    }
}
