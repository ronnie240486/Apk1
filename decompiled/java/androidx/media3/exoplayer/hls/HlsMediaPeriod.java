package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.C0565C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Label;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p000a.AbstractC0004e;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p055ea.AbstractC2460q;
import p187r4.AbstractC3612b;

final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private int audioVideoSampleStreamWrapperCount;
    private final CmcdConfiguration cmcdConfiguration;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private MediaPeriod.Callback mediaPeriodCallback;
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private int pendingPrepareCount;
    private final PlayerId playerId;
    private final HlsPlaylistTracker playlistTracker;
    private final long timestampAdjusterInitializationTimeoutMs;
    private TrackGroupArray trackGroups;
    private final boolean useSessionKeys;
    private final HlsSampleStreamWrapper.Callback sampleStreamWrapperCallback = new SampleStreamWrapperCallback();
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices = new IdentityHashMap<>();
    private final TimestampAdjusterProvider timestampAdjusterProvider = new TimestampAdjusterProvider();
    private HlsSampleStreamWrapper[] sampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private int[][] manifestUrlIndicesPerWrapper = new int[0][];

    public class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        @Override
        public void onPlaylistRefreshRequired(Uri uri) {
            HlsMediaPeriod.this.playlistTracker.refreshPlaylist(uri);
        }

        @Override
        public void onPrepared() {
            if (HlsMediaPeriod.access$106(HlsMediaPeriod.this) > 0) {
                return;
            }
            int i6 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.sampleStreamWrappers) {
                i6 += hlsSampleStreamWrapper.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i6];
            int i10 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : HlsMediaPeriod.this.sampleStreamWrappers) {
                int i11 = hlsSampleStreamWrapper2.getTrackGroups().length;
                int i12 = 0;
                while (i12 < i11) {
                    trackGroupArr[i10] = hlsSampleStreamWrapper2.getTrackGroups().get(i12);
                    i12++;
                    i10++;
                }
            }
            HlsMediaPeriod.this.trackGroups = new TrackGroupArray(trackGroupArr);
            HlsMediaPeriod.this.mediaPeriodCallback.onPrepared(HlsMediaPeriod.this);
        }

        @Override
        public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.mediaPeriodCallback.onContinueLoadingRequested(HlsMediaPeriod.this);
        }
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z7, int i6, boolean z10, PlayerId playerId, long j10) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.cmcdConfiguration = cmcdConfiguration;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher2;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.allowChunklessPreparation = z7;
        this.metadataType = i6;
        this.useSessionKeys = z10;
        this.playerId = playerId;
        this.timestampAdjusterInitializationTimeoutMs = j10;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.empty();
    }

    public static int access$106(HlsMediaPeriod hlsMediaPeriod) {
        int i6 = hlsMediaPeriod.pendingPrepareCount - 1;
        hlsMediaPeriod.pendingPrepareCount = i6;
        return i6;
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long j10, List<HlsMultivariantPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6).name;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z7 = true;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (Objects.equals(str, list.get(i10).name)) {
                        HlsMultivariantPlaylist.Rendition rendition = list.get(i10);
                        arrayList3.add(Integer.valueOf(i10));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        z7 &= Util.getCodecCountOfType(rendition.format.codecs, 1) == 1;
                    }
                }
                String strM5501o = AbstractC2460q.m5501o("audio:", str);
                HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper = buildSampleStreamWrapper(strM5501o, 1, (Uri[]) arrayList.toArray((Uri[]) Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), null, Collections.emptyList(), map, j10);
                list3.add(AbstractC3612b.m7258N(arrayList3));
                list2.add(hlsSampleStreamWrapperBuildSampleStreamWrapper);
                if (this.allowChunklessPreparation && z7) {
                    hlsSampleStreamWrapperBuildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo(new TrackGroup[]{new TrackGroup(strM5501o, (Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private void buildAndPrepareMainSampleStreamWrapper(HlsMultivariantPlaylist hlsMultivariantPlaylist, long j10, List<HlsSampleStreamWrapper> list, List<int[]> list2, Map<String, DrmInitData> map) {
        int i6;
        boolean z7;
        boolean z10;
        Uri[] uriArr;
        Format[] formatArr;
        int[] iArr;
        int i10;
        int i11;
        int i12;
        int size = hlsMultivariantPlaylist.variants.size();
        int[] iArr2 = new int[size];
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < hlsMultivariantPlaylist.variants.size(); i15++) {
            Format format = hlsMultivariantPlaylist.variants.get(i15).format;
            if (format.height > 0 || Util.getCodecsOfType(format.codecs, 2) != null) {
                iArr2[i15] = 2;
                i13++;
            } else if (Util.getCodecsOfType(format.codecs, 1) != null) {
                iArr2[i15] = 1;
                i14++;
            } else {
                iArr2[i15] = -1;
            }
        }
        if (i13 <= 0) {
            if (i14 < size) {
                i6 = size - i14;
                z7 = false;
                z10 = true;
            } else {
                i6 = size;
                z7 = false;
            }
            uriArr = new Uri[i6];
            formatArr = new Format[i6];
            iArr = new int[i6];
            i11 = 0;
            for (i10 = 0; i10 < hlsMultivariantPlaylist.variants.size(); i10++) {
                if ((z7 || iArr2[i10] == 2) && (!z10 || iArr2[i10] != 1)) {
                    HlsMultivariantPlaylist.Variant variant = hlsMultivariantPlaylist.variants.get(i10);
                    uriArr[i11] = variant.url;
                    formatArr[i11] = variant.format;
                    iArr[i11] = i10;
                    i11++;
                }
            }
            String str = formatArr[0].codecs;
            int codecCountOfType = Util.getCodecCountOfType(str, 2);
            int codecCountOfType2 = Util.getCodecCountOfType(str, 1);
            boolean z11 = (codecCountOfType2 != 1 || (codecCountOfType2 == 0 && hlsMultivariantPlaylist.audios.isEmpty())) && codecCountOfType <= 1 && codecCountOfType2 + codecCountOfType > 0;
            if (!z7 || codecCountOfType2 <= 0) {
                i12 = 0;
            } else {
                i12 = 1;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper = buildSampleStreamWrapper("main", i12, uriArr, formatArr, hlsMultivariantPlaylist.muxedAudioFormat, hlsMultivariantPlaylist.muxedCaptionFormats, map, j10);
            list.add(hlsSampleStreamWrapperBuildSampleStreamWrapper);
            list2.add(iArr);
            if (this.allowChunklessPreparation || !z11) {
            }
            ArrayList arrayList = new ArrayList();
            if (codecCountOfType > 0) {
                Format[] formatArr2 = new Format[i6];
                for (int i16 = 0; i16 < i6; i16++) {
                    formatArr2[i16] = deriveVideoFormat(formatArr[i16]);
                }
                arrayList.add(new TrackGroup("main", formatArr2));
                if (codecCountOfType2 > 0 && (hlsMultivariantPlaylist.muxedAudioFormat != null || hlsMultivariantPlaylist.audios.isEmpty())) {
                    arrayList.add(new TrackGroup("main:audio", deriveAudioFormat(formatArr[0], hlsMultivariantPlaylist.muxedAudioFormat, false)));
                }
                List<Format> list3 = hlsMultivariantPlaylist.muxedCaptionFormats;
                if (list3 != null) {
                    for (int i17 = 0; i17 < list3.size(); i17++) {
                        arrayList.add(new TrackGroup(AbstractC0004e.m20n(i17, "main:cc:"), this.extractorFactory.getOutputTextFormat(list3.get(i17))));
                    }
                }
            } else {
                Format[] formatArr3 = new Format[i6];
                for (int i18 = 0; i18 < i6; i18++) {
                    formatArr3[i18] = deriveAudioFormat(formatArr[i18], hlsMultivariantPlaylist.muxedAudioFormat, true);
                }
                arrayList.add(new TrackGroup("main", formatArr3));
            }
            TrackGroup trackGroup = new TrackGroup("main:id3", new Format.Builder().setId("ID3").setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
            arrayList.add(trackGroup);
            hlsSampleStreamWrapperBuildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo((TrackGroup[]) arrayList.toArray(new TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
            return;
        }
        i6 = i13;
        z7 = true;
        z10 = false;
        uriArr = new Uri[i6];
        formatArr = new Format[i6];
        iArr = new int[i6];
        i11 = 0;
        while (i10 < hlsMultivariantPlaylist.variants.size()) {
            if (z7) {
                HlsMultivariantPlaylist.Variant variant2 = hlsMultivariantPlaylist.variants.get(i10);
                uriArr[i11] = variant2.url;
                formatArr[i11] = variant2.format;
                iArr[i11] = i10;
                i11++;
            } else {
                HlsMultivariantPlaylist.Variant variant3 = hlsMultivariantPlaylist.variants.get(i10);
                uriArr[i11] = variant3.url;
                formatArr[i11] = variant3.format;
                iArr[i11] = i10;
                i11++;
            }
        }
        String str2 = formatArr[0].codecs;
        int codecCountOfType3 = Util.getCodecCountOfType(str2, 2);
        int codecCountOfType4 = Util.getCodecCountOfType(str2, 1);
        if (codecCountOfType4 != 1) {
        }
        if (z7) {
            i12 = 0;
        } else {
            i12 = 0;
        }
        HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper2 = buildSampleStreamWrapper("main", i12, uriArr, formatArr, hlsMultivariantPlaylist.muxedAudioFormat, hlsMultivariantPlaylist.muxedCaptionFormats, map, j10);
        list.add(hlsSampleStreamWrapperBuildSampleStreamWrapper2);
        list2.add(iArr);
        if (this.allowChunklessPreparation) {
        }
    }

    private void buildAndPrepareSampleStreamWrappers(long j10) {
        char c5 = 0;
        int i6 = 1;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(this.playlistTracker.getMultivariantPlaylist());
        Map<String, DrmInitData> mapDeriveOverridingDrmInitData = this.useSessionKeys ? deriveOverridingDrmInitData(hlsMultivariantPlaylist.sessionKeyDrmInitData) : Collections.emptyMap();
        boolean zIsEmpty = hlsMultivariantPlaylist.variants.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list = hlsMultivariantPlaylist.audios;
        List<HlsMultivariantPlaylist.Rendition> list2 = hlsMultivariantPlaylist.subtitles;
        this.pendingPrepareCount = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!zIsEmpty) {
            buildAndPrepareMainSampleStreamWrapper(hlsMultivariantPlaylist, j10, arrayList, arrayList2, mapDeriveOverridingDrmInitData);
        }
        buildAndPrepareAudioSampleStreamWrappers(j10, list, arrayList, arrayList2, mapDeriveOverridingDrmInitData);
        this.audioVideoSampleStreamWrapperCount = arrayList.size();
        int i10 = 0;
        while (i10 < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = list2.get(i10);
            StringBuilder sbM27u = AbstractC0004e.m27u(i10, "subtitle:", ":");
            sbM27u.append(rendition.name);
            String string = sbM27u.toString();
            Format format = rendition.format;
            Uri[] uriArr = new Uri[i6];
            uriArr[c5] = rendition.url;
            Format[] formatArr = new Format[i6];
            formatArr[c5] = format;
            ArrayList arrayList3 = arrayList2;
            int i11 = i10;
            HlsSampleStreamWrapper hlsSampleStreamWrapperBuildSampleStreamWrapper = buildSampleStreamWrapper(string, 3, uriArr, formatArr, null, Collections.emptyList(), mapDeriveOverridingDrmInitData, j10);
            arrayList3.add(new int[]{i11});
            arrayList.add(hlsSampleStreamWrapperBuildSampleStreamWrapper);
            hlsSampleStreamWrapperBuildSampleStreamWrapper.prepareWithMultivariantPlaylistInfo(new TrackGroup[]{new TrackGroup(string, this.extractorFactory.getOutputTextFormat(format))}, 0, new int[0]);
            i10 = i11 + 1;
            arrayList2 = arrayList3;
            c5 = 0;
            i6 = 1;
        }
        this.sampleStreamWrappers = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.manifestUrlIndicesPerWrapper = (int[][]) arrayList2.toArray(new int[0][]);
        this.pendingPrepareCount = this.sampleStreamWrappers.length;
        for (int i12 = 0; i12 < this.audioVideoSampleStreamWrapperCount; i12++) {
            this.sampleStreamWrappers[i12].setIsPrimaryTimestampSource(true);
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.continuePreparing();
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(String str, int i6, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j10) {
        return new HlsSampleStreamWrapper(str, i6, this.sampleStreamWrapperCallback, new HlsChunkSource(this.extractorFactory, this.playlistTracker, uriArr, formatArr, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, this.timestampAdjusterInitializationTimeoutMs, list, this.playerId, this.cmcdConfiguration), map, this.allocator, j10, format, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.eventDispatcher, this.metadataType);
    }

    private static Format deriveAudioFormat(Format format, Format format2, boolean z7) {
        Metadata metadata;
        int i6;
        String str;
        String str2;
        int i10;
        int i11;
        String str3;
        List<Label> list;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        List<Label> list2 = C2180c5.f7862e;
        if (format2 != null) {
            str3 = format2.codecs;
            metadata = format2.metadata;
            i10 = format2.channelCount;
            i6 = format2.selectionFlags;
            i11 = format2.roleFlags;
            str = format2.language;
            str2 = format2.label;
            list = format2.labels;
        } else {
            String codecsOfType = Util.getCodecsOfType(format.codecs, 1);
            metadata = format.metadata;
            if (z7) {
                i10 = format.channelCount;
                i6 = format.selectionFlags;
                i11 = format.roleFlags;
                str = format.language;
                str2 = format.label;
                list2 = format.labels;
            } else {
                i6 = 0;
                str = null;
                str2 = null;
                i10 = -1;
                i11 = 0;
            }
            List<Label> list3 = list2;
            str3 = codecsOfType;
            list = list3;
        }
        return new Format.Builder().setId(format.f2579id).setLabel(str2).setLabels(list).setContainerMimeType(format.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(str3)).setCodecs(str3).setMetadata(metadata).setAverageBitrate(z7 ? format.averageBitrate : -1).setPeakBitrate(z7 ? format.peakBitrate : -1).setChannelCount(i10).setSelectionFlags(i6).setRoleFlags(i11).setLanguage(str).build();
    }

    private static Map<String, DrmInitData> deriveOverridingDrmInitData(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i6 = 0;
        while (i6 < arrayList.size()) {
            DrmInitData drmInitDataMerge = list.get(i6);
            String str = drmInitDataMerge.schemeType;
            i6++;
            int i10 = i6;
            while (i10 < arrayList.size()) {
                DrmInitData drmInitData = (DrmInitData) arrayList.get(i10);
                if (TextUtils.equals(drmInitData.schemeType, str)) {
                    drmInitDataMerge = drmInitDataMerge.merge(drmInitData);
                    arrayList.remove(i10);
                } else {
                    i10++;
                }
            }
            map.put(str, drmInitDataMerge);
        }
        return map;
    }

    private static Format deriveVideoFormat(Format format) {
        String codecsOfType = Util.getCodecsOfType(format.codecs, 2);
        return new Format.Builder().setId(format.f2579id).setLabel(format.label).setLabels(format.labels).setContainerMimeType(format.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format.metadata).setAverageBitrate(format.averageBitrate).setPeakBitrate(format.peakBitrate).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).build();
    }

    public static List lambda$selectTracks$0(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        return hlsSampleStreamWrapper.getTrackGroups().getTrackTypes();
    }

    @Override
    public boolean continueLoading(LoadingInfo loadingInfo) {
        if (this.trackGroups != null) {
            return this.compositeSequenceableLoader.continueLoading(loadingInfo);
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.continuePreparing();
        }
        return false;
    }

    @Override
    public void discardBuffer(long j10, boolean z7) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            hlsSampleStreamWrapper.discardBuffer(j10, z7);
        }
    }

    @Override
    public long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            if (hlsSampleStreamWrapper.isVideoSampleStream()) {
                return hlsSampleStreamWrapper.getAdjustedSeekPositionUs(j10, seekParameters);
            }
        }
        return j10;
    }

    @Override
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        int[] iArr;
        TrackGroupArray trackGroups;
        int primaryTrackGroupIndex;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.checkNotNull(hlsMediaPeriod.playlistTracker.getMultivariantPlaylist());
        boolean zIsEmpty = hlsMultivariantPlaylist.variants.isEmpty();
        boolean z7 = !zIsEmpty;
        int length = hlsMediaPeriod.sampleStreamWrappers.length - hlsMultivariantPlaylist.subtitles.size();
        int i6 = 0;
        if (zIsEmpty) {
            iArr = new int[0];
            trackGroups = TrackGroupArray.EMPTY;
            primaryTrackGroupIndex = 0;
        } else {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.sampleStreamWrappers[0];
            iArr = hlsMediaPeriod.manifestUrlIndicesPerWrapper[0];
            trackGroups = hlsSampleStreamWrapper.getTrackGroups();
            primaryTrackGroupIndex = hlsSampleStreamWrapper.getPrimaryTrackGroupIndex();
        }
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        boolean z11 = false;
        for (ExoTrackSelection exoTrackSelection : list) {
            TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
            int iIndexOf = trackGroups.indexOf(trackGroup);
            if (iIndexOf == -1) {
                ?? r15 = z7;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.sampleStreamWrappers;
                    if (r15 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[r15].getTrackGroups().indexOf(trackGroup) != -1) {
                        int i10 = r15 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.manifestUrlIndicesPerWrapper[r15];
                        for (int i11 = 0; i11 < exoTrackSelection.length(); i11++) {
                            arrayList.add(new StreamKey(i10, iArr2[exoTrackSelection.getIndexInTrackGroup(i11)]));
                        }
                        break;
                    }
                    hlsMediaPeriod = this;
                    r15++;
                }
            } else if (iIndexOf == primaryTrackGroupIndex) {
                for (int i12 = 0; i12 < exoTrackSelection.length(); i12++) {
                    arrayList.add(new StreamKey(i6, iArr[exoTrackSelection.getIndexInTrackGroup(i12)]));
                }
                z11 = true;
            } else {
                z10 = true;
            }
            hlsMediaPeriod = this;
            i6 = 0;
        }
        if (z10 && !z11) {
            int i13 = iArr[0];
            int i14 = hlsMultivariantPlaylist.variants.get(i13).format.bitrate;
            for (int i15 = 1; i15 < iArr.length; i15++) {
                int i16 = hlsMultivariantPlaylist.variants.get(iArr[i15]).format.bitrate;
                if (i16 < i14) {
                    i13 = iArr[i15];
                    i14 = i16;
                }
            }
            arrayList.add(new StreamKey(0, i13));
        }
        return arrayList;
    }

    @Override
    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    @Override
    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    @Override
    public void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    @Override
    public void onPlaylistChanged() {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.onPlaylistUpdated();
        }
        this.mediaPeriodCallback.onContinueLoadingRequested(this);
    }

    @Override
    public boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z7) {
        boolean zOnPlaylistError = true;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            zOnPlaylistError &= hlsSampleStreamWrapper.onPlaylistError(uri, loadErrorInfo, z7);
        }
        this.mediaPeriodCallback.onContinueLoadingRequested(this);
        return zOnPlaylistError;
    }

    @Override
    public void prepare(MediaPeriod.Callback callback, long j10) {
        this.mediaPeriodCallback = callback;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j10);
    }

    @Override
    public long readDiscontinuity() {
        return C0565C.TIME_UNSET;
    }

    @Override
    public void reevaluateBuffer(long j10) {
        this.compositeSequenceableLoader.reevaluateBuffer(j10);
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.release();
        }
        this.mediaPeriodCallback = null;
    }

    @Override
    public long seekToUs(long j10) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean zSeekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j10, false);
            int i6 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i6 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i6].seekToUs(j10, zSeekToUs);
                i6++;
            }
            if (zSeekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j10;
    }

    @Override
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        for (int i6 = 0; i6 < exoTrackSelectionArr.length; i6++) {
            SampleStream sampleStream = sampleStreamArr2[i6];
            iArr[i6] = sampleStream == null ? -1 : this.streamWrapperIndices.get(sampleStream).intValue();
            iArr2[i6] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i6];
            if (exoTrackSelection != null) {
                TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
                int i10 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                    if (i10 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[i10].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i6] = i10;
                        break;
                    }
                    i10++;
                }
            }
        }
        this.streamWrapperIndices.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int i11 = 0;
        int i12 = 0;
        boolean z7 = false;
        while (i12 < this.sampleStreamWrappers.length) {
            for (int i13 = 0; i13 < exoTrackSelectionArr.length; i13++) {
                ExoTrackSelection exoTrackSelection2 = null;
                sampleStreamArr4[i13] = iArr[i13] == i12 ? sampleStreamArr2[i13] : null;
                if (iArr2[i13] == i12) {
                    exoTrackSelection2 = exoTrackSelectionArr[i13];
                }
                exoTrackSelectionArr2[i13] = exoTrackSelection2;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i12];
            int i14 = i11;
            int i15 = length;
            int i16 = i12;
            ExoTrackSelection[] exoTrackSelectionArr3 = exoTrackSelectionArr2;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean zSelectTracks = hlsSampleStreamWrapper.selectTracks(exoTrackSelectionArr2, zArr, sampleStreamArr4, zArr2, j10, z7);
            int i17 = 0;
            boolean z10 = false;
            while (true) {
                if (i17 >= exoTrackSelectionArr.length) {
                    break;
                }
                SampleStream sampleStream2 = sampleStreamArr4[i17];
                if (iArr2[i17] == i16) {
                    Assertions.checkNotNull(sampleStream2);
                    sampleStreamArr3[i17] = sampleStream2;
                    this.streamWrapperIndices.put(sampleStream2, Integer.valueOf(i16));
                    z10 = true;
                } else if (iArr[i17] == i16) {
                    Assertions.checkState(sampleStream2 == null);
                }
                i17++;
            }
            if (z10) {
                hlsSampleStreamWrapperArr3[i14] = hlsSampleStreamWrapper;
                i11 = i14 + 1;
                if (i14 == 0) {
                    hlsSampleStreamWrapper.setIsPrimaryTimestampSource(true);
                    if (zSelectTracks) {
                        this.timestampAdjusterProvider.reset();
                        z7 = true;
                    } else {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.enabledSampleStreamWrappers;
                        if (hlsSampleStreamWrapperArr4.length == 0 || hlsSampleStreamWrapper != hlsSampleStreamWrapperArr4[0]) {
                            this.timestampAdjusterProvider.reset();
                            z7 = true;
                        }
                    }
                } else {
                    hlsSampleStreamWrapper.setIsPrimaryTimestampSource(i16 < this.audioVideoSampleStreamWrapperCount);
                }
            } else {
                i11 = i14;
            }
            i12 = i16 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            length = i15;
            exoTrackSelectionArr2 = exoTrackSelectionArr3;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (HlsSampleStreamWrapper[]) Util.nullSafeArrayCopy(hlsSampleStreamWrapperArr2, i11);
        this.enabledSampleStreamWrappers = hlsSampleStreamWrapperArr5;
        C2180c5 c2180c5M5273o = AbstractC2301u1.m5273o(hlsSampleStreamWrapperArr5);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.create(c2180c5M5273o, AbstractC2182d0.m5136H(c2180c5M5273o, new C0780g()));
        return j10;
    }
}
