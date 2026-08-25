package androidx.media3.exoplayer.source;

import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import p041d7.AbstractC2182d0;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final MediaPeriod[] periods;
    private final boolean[] periodsWithTimeOffsets;
    private TrackGroupArray trackGroups;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private final HashMap<TrackGroup, TrackGroup> childTrackGroupByMergedTrackGroup = new HashMap<>();
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices = new IdentityHashMap<>();
    private MediaPeriod[] enabledPeriods = new MediaPeriod[0];

    public static final class ForwardingTrackSelection implements ExoTrackSelection {
        private final TrackGroup trackGroup;
        private final ExoTrackSelection trackSelection;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
            this.trackSelection = exoTrackSelection;
            this.trackGroup = trackGroup;
        }

        @Override
        public void disable() {
            this.trackSelection.disable();
        }

        @Override
        public void enable() {
            this.trackSelection.enable();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            return this.trackSelection.equals(forwardingTrackSelection.trackSelection) && this.trackGroup.equals(forwardingTrackSelection.trackGroup);
        }

        @Override
        public int evaluateQueueSize(long j10, List<? extends MediaChunk> list) {
            return this.trackSelection.evaluateQueueSize(j10, list);
        }

        @Override
        public boolean excludeTrack(int i6, long j10) {
            return this.trackSelection.excludeTrack(i6, j10);
        }

        @Override
        public Format getFormat(int i6) {
            return this.trackGroup.getFormat(this.trackSelection.getIndexInTrackGroup(i6));
        }

        @Override
        public int getIndexInTrackGroup(int i6) {
            return this.trackSelection.getIndexInTrackGroup(i6);
        }

        @Override
        public long getLatestBitrateEstimate() {
            return this.trackSelection.getLatestBitrateEstimate();
        }

        @Override
        public Format getSelectedFormat() {
            return this.trackGroup.getFormat(this.trackSelection.getSelectedIndexInTrackGroup());
        }

        @Override
        public int getSelectedIndex() {
            return this.trackSelection.getSelectedIndex();
        }

        @Override
        public int getSelectedIndexInTrackGroup() {
            return this.trackSelection.getSelectedIndexInTrackGroup();
        }

        @Override
        public Object getSelectionData() {
            return this.trackSelection.getSelectionData();
        }

        @Override
        public int getSelectionReason() {
            return this.trackSelection.getSelectionReason();
        }

        @Override
        public TrackGroup getTrackGroup() {
            return this.trackGroup;
        }

        @Override
        public int getType() {
            return this.trackSelection.getType();
        }

        public int hashCode() {
            return this.trackSelection.hashCode() + ((this.trackGroup.hashCode() + 527) * 31);
        }

        @Override
        public int indexOf(Format format) {
            return this.trackSelection.indexOf(this.trackGroup.indexOf(format));
        }

        @Override
        public boolean isTrackExcluded(int i6, long j10) {
            return this.trackSelection.isTrackExcluded(i6, j10);
        }

        @Override
        public int length() {
            return this.trackSelection.length();
        }

        @Override
        public void onDiscontinuity() {
            this.trackSelection.onDiscontinuity();
        }

        @Override
        public void onPlayWhenReadyChanged(boolean z7) {
            this.trackSelection.onPlayWhenReadyChanged(z7);
        }

        @Override
        public void onPlaybackSpeed(float f) {
            this.trackSelection.onPlaybackSpeed(f);
        }

        @Override
        public void onRebuffer() {
            this.trackSelection.onRebuffer();
        }

        @Override
        public boolean shouldCancelChunkLoad(long j10, Chunk chunk, List<? extends MediaChunk> list) {
            return this.trackSelection.shouldCancelChunkLoad(j10, chunk, list);
        }

        @Override
        public void updateSelectedTrack(long j10, long j11, long j12, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.trackSelection.updateSelectedTrack(j10, j11, j12, list, mediaChunkIteratorArr);
        }

        @Override
        public int indexOf(int i6) {
            return this.trackSelection.indexOf(i6);
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.empty();
        this.periodsWithTimeOffsets = new boolean[mediaPeriodArr.length];
        for (int i6 = 0; i6 < mediaPeriodArr.length; i6++) {
            long j10 = jArr[i6];
            if (j10 != 0) {
                this.periodsWithTimeOffsets[i6] = true;
                this.periods[i6] = new TimeOffsetMediaPeriod(mediaPeriodArr[i6], j10);
            }
        }
    }

    public static List lambda$selectTracks$0(MediaPeriod mediaPeriod) {
        return mediaPeriod.getTrackGroups().getTrackTypes();
    }

    @Override
    public boolean continueLoading(LoadingInfo loadingInfo) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(loadingInfo);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.childrenPendingPreparation.get(i6).continueLoading(loadingInfo);
        }
        return false;
    }

    @Override
    public void discardBuffer(long j10, boolean z7) {
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            mediaPeriod.discardBuffer(j10, z7);
        }
    }

    @Override
    public long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.periods[0]).getAdjustedSeekPositionUs(j10, seekParameters);
    }

    @Override
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public MediaPeriod getChildPeriod(int i6) {
        return this.periodsWithTimeOffsets[i6] ? ((TimeOffsetMediaPeriod) this.periods[i6]).getWrappedMediaPeriod() : this.periods[i6];
    }

    @Override
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override
    public final List getStreamKeys(List list) {
        return AbstractC0906f.m2478a(this, list);
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
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (!this.childrenPendingPreparation.isEmpty()) {
            return;
        }
        int i6 = 0;
        for (MediaPeriod mediaPeriod2 : this.periods) {
            i6 += mediaPeriod2.getTrackGroups().length;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i6];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.periods;
            if (i10 >= mediaPeriodArr.length) {
                this.trackGroups = new TrackGroupArray(trackGroupArr);
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
                return;
            }
            TrackGroupArray trackGroups = mediaPeriodArr[i10].getTrackGroups();
            int i12 = trackGroups.length;
            int i13 = 0;
            while (i13 < i12) {
                TrackGroup trackGroup = trackGroups.get(i13);
                Format[] formatArr = new Format[trackGroup.length];
                for (int i14 = 0; i14 < trackGroup.length; i14++) {
                    Format format = trackGroup.getFormat(i14);
                    Format.Builder builderBuildUpon = format.buildUpon();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i10);
                    sb.append(":");
                    String str = format.f2579id;
                    if (str == null) {
                        str = "";
                    }
                    sb.append(str);
                    formatArr[i14] = builderBuildUpon.setId(sb.toString()).build();
                }
                TrackGroup trackGroup2 = new TrackGroup(i10 + ":" + trackGroup.f2584id, formatArr);
                this.childTrackGroupByMergedTrackGroup.put(trackGroup2, trackGroup);
                trackGroupArr[i11] = trackGroup2;
                i13++;
                i11++;
            }
            i10++;
        }
    }

    @Override
    public void prepare(MediaPeriod.Callback callback, long j10) {
        this.callback = callback;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.prepare(this, j10);
        }
    }

    @Override
    public long readDiscontinuity() {
        long j10 = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            long discontinuity = mediaPeriod.readDiscontinuity();
            if (discontinuity == C0565C.TIME_UNSET) {
                if (j10 != C0565C.TIME_UNSET && mediaPeriod.seekToUs(j10) != j10) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j10 == C0565C.TIME_UNSET) {
                for (MediaPeriod mediaPeriod2 : this.enabledPeriods) {
                    if (mediaPeriod2 == mediaPeriod) {
                        break;
                    }
                    if (mediaPeriod2.seekToUs(discontinuity) != discontinuity) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j10 = discontinuity;
            } else if (discontinuity != j10) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j10;
    }

    @Override
    public void reevaluateBuffer(long j10) {
        this.compositeSequenceableLoader.reevaluateBuffer(j10);
    }

    @Override
    public long seekToUs(long j10) {
        long jSeekToUs = this.enabledPeriods[0].seekToUs(j10);
        int i6 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i6 >= mediaPeriodArr.length) {
                return jSeekToUs;
            }
            if (mediaPeriodArr[i6].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i6++;
        }
    }

    @Override
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        Integer num;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        int i6 = 0;
        while (true) {
            num = null;
            if (i6 >= exoTrackSelectionArr.length) {
                break;
            }
            SampleStream sampleStream = sampleStreamArr[i6];
            num = sampleStream != null ? this.streamPeriodIndices.get(sampleStream) : null;
            iArr[i6] = num == null ? -1 : num.intValue();
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i6];
            if (exoTrackSelection != null) {
                String str = exoTrackSelection.getTrackGroup().f2584id;
                iArr2[i6] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i6] = -1;
            }
            i6++;
        }
        this.streamPeriodIndices.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[exoTrackSelectionArr.length];
        Object[] objArr = new ExoTrackSelection[exoTrackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j11 = j10;
        int i10 = 0;
        while (i10 < this.periods.length) {
            for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
                sampleStreamArr3[i11] = iArr[i11] == i10 ? sampleStreamArr[i11] : num;
                if (iArr2[i11] == i10) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.checkNotNull(exoTrackSelectionArr[i11]);
                    objArr[i11] = new ForwardingTrackSelection(exoTrackSelection2, (TrackGroup) Assertions.checkNotNull(this.childTrackGroupByMergedTrackGroup.get(exoTrackSelection2.getTrackGroup())));
                } else {
                    objArr[i11] = num;
                }
            }
            int i12 = i10;
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = objArr;
            long jSelectTracks = this.periods[i10].selectTracks(objArr, zArr, sampleStreamArr3, zArr2, j11);
            if (i12 == 0) {
                j11 = jSelectTracks;
            } else if (jSelectTracks != j11) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z7 = false;
            for (int i13 = 0; i13 < exoTrackSelectionArr.length; i13++) {
                if (iArr2[i13] == i12) {
                    SampleStream sampleStream2 = (SampleStream) Assertions.checkNotNull(sampleStreamArr3[i13]);
                    sampleStreamArr2[i13] = sampleStreamArr3[i13];
                    this.streamPeriodIndices.put(sampleStream2, Integer.valueOf(i12));
                    z7 = true;
                } else if (iArr[i13] == i12) {
                    Assertions.checkState(sampleStreamArr3[i13] == 0);
                }
            }
            if (z7) {
                arrayList2.add(this.periods[i12]);
            }
            i10 = i12 + 1;
            arrayList = arrayList2;
            objArr = objArr2;
            num = null;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length);
        this.enabledPeriods = (MediaPeriod[]) arrayList3.toArray(new MediaPeriod[0]);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.create(arrayList3, AbstractC2182d0.m5136H(arrayList3, new C0911k(0)));
        return j11;
    }

    @Override
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }
}
