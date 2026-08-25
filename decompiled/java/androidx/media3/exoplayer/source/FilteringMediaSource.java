package androidx.media3.exoplayer.source;

import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import p041d7.AbstractC2233k2;
import p041d7.AbstractC2301u1;
import p041d7.C2247m2;
import p041d7.C2288s1;

@UnstableApi
public class FilteringMediaSource extends WrappingMediaSource {
    private final AbstractC2233k2 trackTypes;

    public static final class FilteringMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        private MediaPeriod.Callback callback;
        private TrackGroupArray filteredTrackGroups;
        public final MediaPeriod mediaPeriod;
        private final AbstractC2233k2 trackTypes;

        public FilteringMediaPeriod(MediaPeriod mediaPeriod, AbstractC2233k2 abstractC2233k2) {
            this.mediaPeriod = mediaPeriod;
            this.trackTypes = abstractC2233k2;
        }

        @Override
        public boolean continueLoading(LoadingInfo loadingInfo) {
            return this.mediaPeriod.continueLoading(loadingInfo);
        }

        @Override
        public void discardBuffer(long j10, boolean z7) {
            this.mediaPeriod.discardBuffer(j10, z7);
        }

        @Override
        public long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
            return this.mediaPeriod.getAdjustedSeekPositionUs(j10, seekParameters);
        }

        @Override
        public long getBufferedPositionUs() {
            return this.mediaPeriod.getBufferedPositionUs();
        }

        @Override
        public long getNextLoadPositionUs() {
            return this.mediaPeriod.getNextLoadPositionUs();
        }

        @Override
        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.mediaPeriod.getStreamKeys(list);
        }

        @Override
        public TrackGroupArray getTrackGroups() {
            return (TrackGroupArray) Assertions.checkNotNull(this.filteredTrackGroups);
        }

        @Override
        public boolean isLoading() {
            return this.mediaPeriod.isLoading();
        }

        @Override
        public void maybeThrowPrepareError() throws IOException {
            this.mediaPeriod.maybeThrowPrepareError();
        }

        @Override
        public void onPrepared(MediaPeriod mediaPeriod) {
            TrackGroupArray trackGroups = mediaPeriod.getTrackGroups();
            C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
            for (int i6 = 0; i6 < trackGroups.length; i6++) {
                TrackGroup trackGroup = trackGroups.get(i6);
                if (this.trackTypes.contains(Integer.valueOf(trackGroup.type))) {
                    c2288s1M5269k.m5255a(trackGroup);
                }
            }
            this.filteredTrackGroups = new TrackGroupArray((TrackGroup[]) c2288s1M5269k.m5262g().toArray(new TrackGroup[0]));
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }

        @Override
        public void prepare(MediaPeriod.Callback callback, long j10) {
            this.callback = callback;
            this.mediaPeriod.prepare(this, j10);
        }

        @Override
        public long readDiscontinuity() {
            return this.mediaPeriod.readDiscontinuity();
        }

        @Override
        public void reevaluateBuffer(long j10) {
            this.mediaPeriod.reevaluateBuffer(j10);
        }

        @Override
        public long seekToUs(long j10) {
            return this.mediaPeriod.seekToUs(j10);
        }

        @Override
        public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
            return this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j10);
        }

        @Override
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    public FilteringMediaSource(MediaSource mediaSource, int i6) {
        Integer numValueOf = Integer.valueOf(i6);
        int i10 = AbstractC2233k2.f7972c;
        this(mediaSource, new C2247m2(numValueOf));
    }

    @Override
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j10) {
        return new FilteringMediaPeriod(super.createPeriod(mediaPeriodId, allocator, j10), this.trackTypes);
    }

    @Override
    public void releasePeriod(MediaPeriod mediaPeriod) {
        super.releasePeriod(((FilteringMediaPeriod) mediaPeriod).mediaPeriod);
    }

    public FilteringMediaSource(MediaSource mediaSource, Set<Integer> set) {
        super(mediaSource);
        this.trackTypes = AbstractC2233k2.m5236l(set);
    }
}
