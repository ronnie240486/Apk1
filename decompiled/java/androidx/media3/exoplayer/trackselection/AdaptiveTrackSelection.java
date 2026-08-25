package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2166a5;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2277q4;
import p041d7.C2284r4;
import p041d7.C2288s1;

@UnstableApi
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_HEIGHT_TO_DISCARD = 719;
    public static final int DEFAULT_MAX_WIDTH_TO_DISCARD = 1279;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private static final long MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 1000;
    private static final String TAG = "AdaptiveTrackSelection";
    private final AbstractC2301u1 adaptationCheckpoints;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private MediaChunk lastBufferEvaluationMediaChunk;
    private long lastBufferEvaluationMs;
    private long latestBitrateEstimate;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxHeightToDiscard;
    private final int maxWidthToDiscard;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    public static final class AdaptationCheckpoint {
        public final long allocatedBandwidth;
        public final long totalBandwidth;

        public AdaptationCheckpoint(long j10, long j11) {
            this.totalBandwidth = j10;
            this.allocatedBandwidth = j11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            return this.totalBandwidth == adaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptationCheckpoint.allocatedBandwidth;
        }

        public int hashCode() {
            return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {
        private final float bandwidthFraction;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int maxHeightToDiscard;
        private final int maxWidthToDiscard;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i6, BandwidthMeter bandwidthMeter, AbstractC2301u1 abstractC2301u1) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i6, bandwidthMeter, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.maxWidthToDiscard, this.maxHeightToDiscard, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, abstractC2301u1, this.clock);
        }

        @Override
        public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            AbstractC2301u1 adaptationCheckpoints = AdaptiveTrackSelection.getAdaptationCheckpoints(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i6 = 0; i6 < definitionArr.length; i6++) {
                ExoTrackSelection.Definition definition = definitionArr[i6];
                if (definition != null) {
                    int[] iArr = definition.tracks;
                    if (iArr.length != 0) {
                        exoTrackSelectionArr[i6] = iArr.length == 1 ? new FixedTrackSelection(definition.group, iArr[0], definition.type) : createAdaptiveTrackSelection(definition.group, iArr, definition.type, bandwidthMeter, (AbstractC2301u1) adaptationCheckpoints.get(i6));
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        public Factory(int i6, int i10, int i11, float f) {
            this(i6, i10, i11, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i6, int i10, int i11, int i12, int i13, float f) {
            this(i6, i10, i11, i12, i13, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i6, int i10, int i11, float f, float f3, Clock clock) {
            this(i6, i10, i11, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, f3, clock);
        }

        public Factory(int i6, int i10, int i11, int i12, int i13, float f, float f3, Clock clock) {
            this.minDurationForQualityIncreaseMs = i6;
            this.maxDurationForQualityDecreaseMs = i10;
            this.minDurationToRetainAfterDiscardMs = i11;
            this.maxWidthToDiscard = i12;
            this.maxHeightToDiscard = i13;
            this.bandwidthFraction = f;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f3;
            this.clock = clock;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, 0, bandwidthMeter, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, 25000L, 25000L, DEFAULT_MAX_WIDTH_TO_DISCARD, DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, C2180c5.f7862e, Clock.DEFAULT);
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
    }

    private static void addCheckpoint(List<C2288s1> list, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            C2288s1 c2288s1 = list.get(i6);
            if (c2288s1 != null) {
                c2288s1.m5255a(new AdaptationCheckpoint(j10, jArr[i6]));
            }
        }
    }

    private int determineIdealSelectedIndex(long j10, long j11) {
        long allocatedBandwidth = getAllocatedBandwidth(j11);
        int i6 = 0;
        for (int i10 = 0; i10 < this.length; i10++) {
            if (j10 == Long.MIN_VALUE || !isTrackExcluded(i10, j10)) {
                Format format = getFormat(i10);
                if (canSelectFormat(format, format.bitrate, allocatedBandwidth)) {
                    return i10;
                }
                i6 = i10;
            }
        }
        return i6;
    }

    public static AbstractC2301u1 getAdaptationCheckpoints(ExoTrackSelection.Definition[] definitionArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.tracks.length <= 1) {
                arrayList.add(null);
            } else {
                C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
                c2288s1M5269k.m5256c(new AdaptationCheckpoint(0L, 0L));
                arrayList.add(c2288s1M5269k);
            }
        }
        long[][] sortedTrackBitrates = getSortedTrackBitrates(definitionArr);
        int[] iArr = new int[sortedTrackBitrates.length];
        long[] jArr = new long[sortedTrackBitrates.length];
        for (int i6 = 0; i6 < sortedTrackBitrates.length; i6++) {
            long[] jArr2 = sortedTrackBitrates[i6];
            jArr[i6] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        addCheckpoint(arrayList, jArr);
        AbstractC2301u1 switchOrder = getSwitchOrder(sortedTrackBitrates);
        for (int i10 = 0; i10 < switchOrder.size(); i10++) {
            int iIntValue = ((Integer) switchOrder.get(i10)).intValue();
            int i11 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i11;
            jArr[iIntValue] = sortedTrackBitrates[iIntValue][i11];
            addCheckpoint(arrayList, jArr);
        }
        for (int i12 = 0; i12 < definitionArr.length; i12++) {
            if (arrayList.get(i12) != null) {
                jArr[i12] = jArr[i12] * 2;
            }
        }
        addCheckpoint(arrayList, jArr);
        C2288s1 c2288s1M5269k2 = AbstractC2301u1.m5269k();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            C2288s1 c2288s1 = (C2288s1) arrayList.get(i13);
            c2288s1M5269k2.m5256c(c2288s1 == null ? AbstractC2301u1.m5274q() : c2288s1.m5262g());
        }
        return c2288s1M5269k2.m5262g();
    }

    private long getAllocatedBandwidth(long j10) {
        long totalAllocatableBandwidth = getTotalAllocatableBandwidth(j10);
        if (this.adaptationCheckpoints.isEmpty()) {
            return totalAllocatableBandwidth;
        }
        int i6 = 1;
        while (i6 < this.adaptationCheckpoints.size() - 1 && ((AdaptationCheckpoint) this.adaptationCheckpoints.get(i6)).totalBandwidth < totalAllocatableBandwidth) {
            i6++;
        }
        AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) this.adaptationCheckpoints.get(i6 - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = (AdaptationCheckpoint) this.adaptationCheckpoints.get(i6);
        long j11 = adaptationCheckpoint.totalBandwidth;
        float f = (totalAllocatableBandwidth - j11) / (adaptationCheckpoint2.totalBandwidth - j11);
        long j12 = adaptationCheckpoint.allocatedBandwidth;
        return j12 + ((long) (f * (adaptationCheckpoint2.allocatedBandwidth - j12)));
    }

    private long getLastChunkDurationUs(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return C0565C.TIME_UNSET;
        }
        MediaChunk mediaChunk = (MediaChunk) AbstractC2182d0.m5151n(list);
        long j10 = mediaChunk.startTimeUs;
        if (j10 == C0565C.TIME_UNSET) {
            return C0565C.TIME_UNSET;
        }
        long j11 = mediaChunk.endTimeUs;
        return j11 != C0565C.TIME_UNSET ? j11 - j10 : C0565C.TIME_UNSET;
    }

    private long getNextChunkDurationUs(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i6 = this.selectedIndex;
        if (i6 < mediaChunkIteratorArr.length && mediaChunkIteratorArr[i6].next()) {
            MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[this.selectedIndex];
            return mediaChunkIterator.getChunkEndTimeUs() - mediaChunkIterator.getChunkStartTimeUs();
        }
        for (MediaChunkIterator mediaChunkIterator2 : mediaChunkIteratorArr) {
            if (mediaChunkIterator2.next()) {
                return mediaChunkIterator2.getChunkEndTimeUs() - mediaChunkIterator2.getChunkStartTimeUs();
            }
        }
        return getLastChunkDurationUs(list);
    }

    private static long[][] getSortedTrackBitrates(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i6 = 0; i6 < definitionArr.length; i6++) {
            ExoTrackSelection.Definition definition = definitionArr[i6];
            if (definition == null) {
                jArr[i6] = new long[0];
            } else {
                jArr[i6] = new long[definition.tracks.length];
                int i10 = 0;
                while (true) {
                    int[] iArr = definition.tracks;
                    if (i10 >= iArr.length) {
                        break;
                    }
                    long j10 = definition.group.getFormat(iArr[i10]).bitrate;
                    long[] jArr2 = jArr[i6];
                    if (j10 == -1) {
                        j10 = 0;
                    }
                    jArr2[i10] = j10;
                    i10++;
                }
                Arrays.sort(jArr[i6]);
            }
        }
        return jArr;
    }

    private static AbstractC2301u1 getSwitchOrder(long[][] jArr) {
        C2166a5 c2166a5 = C2166a5.f7831a;
        c2166a5.getClass();
        AbstractC2182d0.m5141d(2, "expectedValuesPerKey");
        TreeMap treeMap = new TreeMap(c2166a5);
        C2277q4 c2277q4 = new C2277q4(0);
        C2284r4 c2284r4 = new C2284r4(treeMap);
        c2284r4.f8043h = c2277q4;
        for (int i6 = 0; i6 < jArr.length; i6++) {
            long[] jArr2 = jArr[i6];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i10 = 0;
                while (true) {
                    long[] jArr3 = jArr[i6];
                    double dLog = 0.0d;
                    if (i10 >= jArr3.length) {
                        break;
                    }
                    long j10 = jArr3[i10];
                    if (j10 != -1) {
                        dLog = Math.log(j10);
                    }
                    dArr[i10] = dLog;
                    i10++;
                }
                int i11 = length - 1;
                double d = dArr[i11] - dArr[0];
                int i12 = 0;
                while (i12 < i11) {
                    double d10 = dArr[i12];
                    i12++;
                    c2284r4.put(Double.valueOf(d == 0.0d ? 1.0d : (((d10 + dArr[i12]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i6));
                }
            }
        }
        return AbstractC2301u1.m5272n(c2284r4.values());
    }

    private long getTotalAllocatableBandwidth(long j10) {
        long bitrateEstimate = this.bandwidthMeter.getBitrateEstimate();
        this.latestBitrateEstimate = bitrateEstimate;
        long j11 = (long) (bitrateEstimate * this.bandwidthFraction);
        long timeToFirstByteEstimateUs = this.bandwidthMeter.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == C0565C.TIME_UNSET || j10 == C0565C.TIME_UNSET) {
            return (long) (j11 / this.playbackSpeed);
        }
        float f = j10;
        return (long) ((j11 * Math.max((f / this.playbackSpeed) - timeToFirstByteEstimateUs, 0.0f)) / f);
    }

    private long minDurationForQualityIncreaseUs(long j10, long j11) {
        if (j10 == C0565C.TIME_UNSET) {
            return this.minDurationForQualityIncreaseUs;
        }
        if (j11 != C0565C.TIME_UNSET) {
            j10 -= j11;
        }
        return Math.min((long) (j10 * this.bufferedFractionToLiveEdgeForQualityIncrease), this.minDurationForQualityIncreaseUs);
    }

    public boolean canSelectFormat(Format format, int i6, long j10) {
        return ((long) i6) <= j10;
    }

    @Override
    public void disable() {
        this.lastBufferEvaluationMediaChunk = null;
    }

    @Override
    public void enable() {
        this.lastBufferEvaluationMs = C0565C.TIME_UNSET;
        this.lastBufferEvaluationMediaChunk = null;
    }

    @Override
    public int evaluateQueueSize(long j10, List<? extends MediaChunk> list) {
        int i6;
        int i10;
        long jElapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(jElapsedRealtime, list)) {
            return list.size();
        }
        this.lastBufferEvaluationMs = jElapsedRealtime;
        this.lastBufferEvaluationMediaChunk = list.isEmpty() ? null : (MediaChunk) AbstractC2182d0.m5151n(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j10, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(jElapsedRealtime, getLastChunkDurationUs(list)));
        for (int i11 = 0; i11 < size; i11++) {
            MediaChunk mediaChunk = list.get(i11);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j10, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i6 = format2.height) != -1 && i6 <= this.maxHeightToDiscard && (i10 = format2.width) != -1 && i10 <= this.maxWidthToDiscard && i6 < format.height) {
                return i11;
            }
        }
        return size;
    }

    @Override
    public long getLatestBitrateEstimate() {
        return this.latestBitrateEstimate;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    @Override
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override
    public Object getSelectionData() {
        return null;
    }

    @Override
    public int getSelectionReason() {
        return this.reason;
    }

    @Override
    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    public boolean shouldEvaluateQueueSize(long j10, List<? extends MediaChunk> list) {
        long j11 = this.lastBufferEvaluationMs;
        return j11 == C0565C.TIME_UNSET || j10 - j11 >= 1000 || !(list.isEmpty() || ((MediaChunk) AbstractC2182d0.m5151n(list)).equals(this.lastBufferEvaluationMediaChunk));
    }

    @Override
    public void updateSelectedTrack(long j10, long j11, long j12, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = this.clock.elapsedRealtime();
        long nextChunkDurationUs = getNextChunkDurationUs(mediaChunkIteratorArr, list);
        int i6 = this.reason;
        if (i6 == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(jElapsedRealtime, nextChunkDurationUs);
            return;
        }
        int i10 = this.selectedIndex;
        int iIndexOf = list.isEmpty() ? -1 : indexOf(((MediaChunk) AbstractC2182d0.m5151n(list)).trackFormat);
        if (iIndexOf != -1) {
            i6 = ((MediaChunk) AbstractC2182d0.m5151n(list)).trackSelectionReason;
            i10 = iIndexOf;
        }
        int iDetermineIdealSelectedIndex = determineIdealSelectedIndex(jElapsedRealtime, nextChunkDurationUs);
        if (iDetermineIdealSelectedIndex != i10 && !isTrackExcluded(i10, jElapsedRealtime)) {
            Format format = getFormat(i10);
            Format format2 = getFormat(iDetermineIdealSelectedIndex);
            long jMinDurationForQualityIncreaseUs = minDurationForQualityIncreaseUs(j12, nextChunkDurationUs);
            int i11 = format2.bitrate;
            int i12 = format.bitrate;
            if ((i11 > i12 && j11 < jMinDurationForQualityIncreaseUs) || (i11 < i12 && j11 >= this.maxDurationForQualityDecreaseUs)) {
                iDetermineIdealSelectedIndex = i10;
            }
        }
        if (iDetermineIdealSelectedIndex != i10) {
            i6 = 3;
        }
        this.reason = i6;
        this.selectedIndex = iDetermineIdealSelectedIndex;
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i6, BandwidthMeter bandwidthMeter, long j10, long j11, long j12, int i10, int i11, float f, float f3, List<AdaptationCheckpoint> list, Clock clock) {
        long j13;
        super(trackGroup, iArr, i6);
        if (j12 < j10) {
            Log.m1719w(TAG, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j13 = j10;
        } else {
            j13 = j12;
        }
        this.bandwidthMeter = bandwidthMeter;
        this.minDurationForQualityIncreaseUs = j10 * 1000;
        this.maxDurationForQualityDecreaseUs = j11 * 1000;
        this.minDurationToRetainAfterDiscardUs = j13 * 1000;
        this.maxWidthToDiscard = i10;
        this.maxHeightToDiscard = i11;
        this.bandwidthFraction = f;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f3;
        this.adaptationCheckpoints = AbstractC2301u1.m5272n(list);
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = C0565C.TIME_UNSET;
        this.latestBitrateEstimate = -2147483647L;
    }
}
