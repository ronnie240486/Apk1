package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.media3.common.C0565C;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.AbstractC1011d;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import java.util.Objects;

@UnstableApi
public class SampleQueue implements TrackOutput {
    static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static final String TAG = "SampleQueue";
    private int absoluteFirstIndex;
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private boolean isLastSampleQueued;
    private int length;
    private boolean loggedUnexpectedNonSyncSample;
    private boolean pendingSplice;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private Format unadjustedUpstreamFormat;
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private long upstreamSourceId;
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private int capacity = 1000;
    private long[] sourceIds = new long[1000];
    private long[] offsets = new long[1000];
    private long[] timesUs = new long[1000];
    private int[] flags = new int[1000];
    private int[] sizes = new int[1000];
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private final SpannedData<SharedSampleMetadata> sharedSampleMetadata = new SpannedData<>(new C0918p(0));
    private long startTimeUs = Long.MIN_VALUE;
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;
    private boolean allSamplesAreSyncSamples = true;

    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    public static final class SharedSampleMetadata {
        public final DrmSessionManager.DrmSessionReference drmSessionReference;
        public final Format format;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.format = format;
            this.drmSessionReference = drmSessionReference;
        }
    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = eventDispatcher;
        this.sampleDataQueue = new SampleDataQueue(allocator);
    }

    private synchronized boolean attemptSplice(long j10) {
        if (this.length == 0) {
            return j10 > this.largestDiscardedTimestampUs;
        }
        if (getLargestReadTimestampUs() >= j10) {
            return false;
        }
        discardUpstreamSampleMetadata(this.absoluteFirstIndex + countUnreadSamplesBefore(j10));
        return true;
    }

    private synchronized void commitSample(long j10, int i6, long j11, int i10, TrackOutput.CryptoData cryptoData) {
        try {
            int i11 = this.length;
            if (i11 > 0) {
                int relativeIndex = getRelativeIndex(i11 - 1);
                Assertions.checkArgument(this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]) <= j11);
            }
            this.isLastSampleQueued = (536870912 & i6) != 0;
            this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j10);
            int relativeIndex2 = getRelativeIndex(this.length);
            this.timesUs[relativeIndex2] = j10;
            this.offsets[relativeIndex2] = j11;
            this.sizes[relativeIndex2] = i10;
            this.flags[relativeIndex2] = i6;
            this.cryptoDatas[relativeIndex2] = cryptoData;
            this.sourceIds[relativeIndex2] = this.upstreamSourceId;
            if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(this.upstreamFormat)) {
                Format format = (Format) Assertions.checkNotNull(this.upstreamFormat);
                DrmSessionManager drmSessionManager = this.drmSessionManager;
                this.sharedSampleMetadata.appendSpan(getWriteIndex(), new SharedSampleMetadata(format, drmSessionManager != null ? drmSessionManager.preacquireSession(this.drmEventDispatcher, format) : DrmSessionManager.DrmSessionReference.EMPTY));
            }
            int i12 = this.length + 1;
            this.length = i12;
            int i13 = this.capacity;
            if (i12 == i13) {
                int i14 = i13 + 1000;
                long[] jArr = new long[i14];
                long[] jArr2 = new long[i14];
                long[] jArr3 = new long[i14];
                int[] iArr = new int[i14];
                int[] iArr2 = new int[i14];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i14];
                int i15 = this.relativeFirstIndex;
                int i16 = i13 - i15;
                System.arraycopy(this.offsets, i15, jArr2, 0, i16);
                System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr3, 0, i16);
                System.arraycopy(this.flags, this.relativeFirstIndex, iArr, 0, i16);
                System.arraycopy(this.sizes, this.relativeFirstIndex, iArr2, 0, i16);
                System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i16);
                System.arraycopy(this.sourceIds, this.relativeFirstIndex, jArr, 0, i16);
                int i17 = this.relativeFirstIndex;
                System.arraycopy(this.offsets, 0, jArr2, i16, i17);
                System.arraycopy(this.timesUs, 0, jArr3, i16, i17);
                System.arraycopy(this.flags, 0, iArr, i16, i17);
                System.arraycopy(this.sizes, 0, iArr2, i16, i17);
                System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i16, i17);
                System.arraycopy(this.sourceIds, 0, jArr, i16, i17);
                this.offsets = jArr2;
                this.timesUs = jArr3;
                this.flags = iArr;
                this.sizes = iArr2;
                this.cryptoDatas = cryptoDataArr;
                this.sourceIds = jArr;
                this.relativeFirstIndex = 0;
                this.capacity = i14;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private int countUnreadSamplesBefore(long j10) {
        int i6 = this.length;
        int relativeIndex = getRelativeIndex(i6 - 1);
        while (i6 > this.readPosition && this.timesUs[relativeIndex] >= j10) {
            i6--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return i6;
    }

    public static SampleQueue createWithDrm(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        return new SampleQueue(allocator, null, null);
    }

    private synchronized long discardSampleMetadataTo(long j10, boolean z7, boolean z10) {
        int i6;
        try {
            int i10 = this.length;
            if (i10 != 0) {
                long[] jArr = this.timesUs;
                int i11 = this.relativeFirstIndex;
                if (j10 >= jArr[i11]) {
                    if (z10 && (i6 = this.readPosition) != i10) {
                        i10 = i6 + 1;
                    }
                    int iFindSampleBefore = findSampleBefore(i11, i10, j10, z7);
                    if (iFindSampleBefore == -1) {
                        return -1L;
                    }
                    return discardSamples(iFindSampleBefore);
                }
            }
            return -1L;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized long discardSampleMetadataToEnd() {
        int i6 = this.length;
        if (i6 == 0) {
            return -1L;
        }
        return discardSamples(i6);
    }

    private long discardSamples(int i6) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i6));
        this.length -= i6;
        int i10 = this.absoluteFirstIndex + i6;
        this.absoluteFirstIndex = i10;
        int i11 = this.relativeFirstIndex + i6;
        this.relativeFirstIndex = i11;
        int i12 = this.capacity;
        if (i11 >= i12) {
            this.relativeFirstIndex = i11 - i12;
        }
        int i13 = this.readPosition - i6;
        this.readPosition = i13;
        if (i13 < 0) {
            this.readPosition = 0;
        }
        this.sharedSampleMetadata.discardTo(i10);
        if (this.length != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i14 = this.relativeFirstIndex;
        if (i14 == 0) {
            i14 = this.capacity;
        }
        int i15 = i14 - 1;
        return this.offsets[i15] + ((long) this.sizes[i15]);
    }

    private long discardUpstreamSampleMetadata(int i6) {
        int writeIndex = getWriteIndex() - i6;
        boolean z7 = false;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        int i10 = this.length - writeIndex;
        this.length = i10;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i10));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z7 = true;
        }
        this.isLastSampleQueued = z7;
        this.sharedSampleMetadata.discardFrom(i6);
        int i11 = this.length;
        if (i11 == 0) {
            return 0L;
        }
        int relativeIndex = getRelativeIndex(i11 - 1);
        return this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]);
    }

    private int findSampleAfter(int i6, int i10, long j10, boolean z7) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.timesUs[i6] >= j10) {
                return i11;
            }
            i6++;
            if (i6 == this.capacity) {
                i6 = 0;
            }
        }
        if (z7) {
            return i10;
        }
        return -1;
    }

    private int findSampleBefore(int i6, int i10, long j10, boolean z7) {
        int i11 = -1;
        for (int i12 = 0; i12 < i10; i12++) {
            long j11 = this.timesUs[i6];
            if (j11 > j10) {
                return i11;
            }
            if (!z7 || (this.flags[i6] & 1) != 0) {
                if (j11 == j10) {
                    return i12;
                }
                i11 = i12;
            }
            i6++;
            if (i6 == this.capacity) {
                i6 = 0;
            }
        }
        return i11;
    }

    private long getLargestTimestamp(int i6) {
        long jMax = Long.MIN_VALUE;
        if (i6 == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i6 - 1);
        for (int i10 = 0; i10 < i6; i10++) {
            jMax = Math.max(jMax, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return jMax;
    }

    private int getRelativeIndex(int i6) {
        int i10 = this.relativeFirstIndex + i6;
        int i11 = this.capacity;
        return i10 < i11 ? i10 : i10 - i11;
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    public static void lambda$new$0(SharedSampleMetadata sharedSampleMetadata) {
        sharedSampleMetadata.drmSessionReference.release();
    }

    private boolean mayReadSample(int i6) {
        DrmSession drmSession = this.currentDrmSession;
        return drmSession == null || drmSession.getState() == 4 || ((this.flags[i6] & 1073741824) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys());
    }

    private void onFormatResult(Format format, FormatHolder formatHolder) {
        Format format2 = this.downstreamFormat;
        boolean z7 = format2 == null;
        DrmInitData drmInitData = format2 == null ? null : format2.drmInitData;
        this.downstreamFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        formatHolder.format = drmSessionManager != null ? format.copyWithCryptoType(drmSessionManager.getCryptoType(format)) : format;
        formatHolder.drmSession = this.currentDrmSession;
        if (this.drmSessionManager == null) {
            return;
        }
        if (z7 || !Objects.equals(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.currentDrmSession;
            DrmSession drmSessionAcquireSession = this.drmSessionManager.acquireSession(this.drmEventDispatcher, format);
            this.currentDrmSession = drmSessionAcquireSession;
            formatHolder.drmSession = drmSessionAcquireSession;
            if (drmSession != null) {
                drmSession.release(this.drmEventDispatcher);
            }
        }
    }

    private synchronized int peekSampleMetadata(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z7, boolean z10, SampleExtrasHolder sampleExtrasHolder) {
        try {
            decoderInputBuffer.waitingForKeys = false;
            if (!hasNextSample()) {
                if (!z10 && !this.isLastSampleQueued) {
                    Format format = this.upstreamFormat;
                    if (format == null || (!z7 && format == this.downstreamFormat)) {
                        return -3;
                    }
                    onFormatResult((Format) Assertions.checkNotNull(format), formatHolder);
                    return -5;
                }
                decoderInputBuffer.setFlags(4);
                decoderInputBuffer.timeUs = Long.MIN_VALUE;
                return -4;
            }
            Format format2 = this.sharedSampleMetadata.get(getReadIndex()).format;
            if (!z7 && format2 == this.downstreamFormat) {
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (!mayReadSample(relativeIndex)) {
                    decoderInputBuffer.waitingForKeys = true;
                    return -3;
                }
                decoderInputBuffer.setFlags(this.flags[relativeIndex]);
                if (this.readPosition == this.length - 1 && (z10 || this.isLastSampleQueued)) {
                    decoderInputBuffer.addFlag(C0565C.BUFFER_FLAG_LAST_SAMPLE);
                }
                decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
                sampleExtrasHolder.size = this.sizes[relativeIndex];
                sampleExtrasHolder.offset = this.offsets[relativeIndex];
                sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
                return -4;
            }
            onFormatResult(format2, formatHolder);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            drmSession.release(this.drmEventDispatcher);
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    private synchronized void rewind() {
        this.readPosition = 0;
        this.sampleDataQueue.rewind();
    }

    private synchronized boolean setUpstreamFormat(Format format) {
        try {
            this.upstreamFormatRequired = false;
            if (Objects.equals(format, this.upstreamFormat)) {
                return false;
            }
            if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(format)) {
                this.upstreamFormat = format;
            } else {
                this.upstreamFormat = this.sharedSampleMetadata.getEndValue().format;
            }
            boolean z7 = this.allSamplesAreSyncSamples;
            Format format2 = this.upstreamFormat;
            this.allSamplesAreSyncSamples = z7 & MimeTypes.allSamplesAreSyncSamples(format2.sampleMimeType, format2.codecs);
            this.loggedUnexpectedNonSyncSample = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long discardSampleMetadataToRead() {
        int i6 = this.readPosition;
        if (i6 == 0) {
            return -1L;
        }
        return discardSamples(i6);
    }

    public final void discardTo(long j10, boolean z7, boolean z10) {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataTo(j10, z7, z10));
    }

    public final void discardToEnd() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToEnd());
    }

    public final void discardToRead() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToRead());
    }

    public final void discardUpstreamFrom(long j10) {
        if (this.length == 0) {
            return;
        }
        Assertions.checkArgument(j10 > getLargestReadTimestampUs());
        discardUpstreamSamples(this.absoluteFirstIndex + countUnreadSamplesBefore(j10));
    }

    public final void discardUpstreamSamples(int i6) {
        this.sampleDataQueue.discardUpstreamSampleBytes(discardUpstreamSampleMetadata(i6));
    }

    @Override
    public void durationUs(long j10) {
        AbstractC1011d.m2652a(this, j10);
    }

    @Override
    public final void format(Format format) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = format;
        boolean upstreamFormat = setUpstreamFormat(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !upstreamFormat) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
    }

    public Format getAdjustedUpstreamFormat(Format format) {
        return (this.sampleOffsetUs == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.sampleOffsetUs).build();
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.length == 0 ? Long.MIN_VALUE : this.timesUs[this.relativeFirstIndex];
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition));
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized int getSkipCount(long j10, boolean z7) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && j10 >= this.timesUs[relativeIndex]) {
            if (j10 > this.largestQueuedTimestampUs && z7) {
                return this.length - this.readPosition;
            }
            int iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j10, true);
            if (iFindSampleBefore == -1) {
                return 0;
            }
            return iFindSampleBefore;
        }
        return 0;
    }

    public final synchronized Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    public synchronized boolean isReady(boolean z7) {
        Format format;
        boolean z10 = true;
        if (hasNextSample()) {
            if (this.sharedSampleMetadata.get(getReadIndex()).format != this.downstreamFormat) {
                return true;
            }
            return mayReadSample(getRelativeIndex(this.readPosition));
        }
        if (!z7 && !this.isLastSampleQueued && ((format = this.upstreamFormat) == null || format == this.downstreamFormat)) {
            z10 = false;
        }
        return z10;
    }

    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.currentDrmSession.getError()));
        }
    }

    public final synchronized long peekSourceId() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return hasNextSample() ? this.sourceIds[getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
    }

    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i6, boolean z7) {
        int iPeekSampleMetadata = peekSampleMetadata(formatHolder, decoderInputBuffer, (i6 & 2) != 0, z7, this.extrasHolder);
        if (iPeekSampleMetadata == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z10 = (i6 & 1) != 0;
            if ((i6 & 4) == 0) {
                if (z10) {
                    this.sampleDataQueue.peekToBuffer(decoderInputBuffer, this.extrasHolder);
                } else {
                    this.sampleDataQueue.readToBuffer(decoderInputBuffer, this.extrasHolder);
                }
            }
            if (!z10) {
                this.readPosition++;
            }
        }
        return iPeekSampleMetadata;
    }

    public void release() {
        reset(true);
        releaseDrmSessionReferences();
    }

    public final void reset() {
        reset(false);
    }

    @Override
    public final int sampleData(DataReader dataReader, int i6, boolean z7) {
        return AbstractC1011d.m2653b(this, dataReader, i6, z7);
    }

    @Override
    public void sampleMetadata(long j10, int i6, int i10, int i11, TrackOutput.CryptoData cryptoData) {
        int i12;
        if (this.upstreamFormatAdjustmentRequired) {
            format((Format) Assertions.checkStateNotNull(this.unadjustedUpstreamFormat));
        }
        int i13 = i6 & 1;
        boolean z7 = i13 != 0;
        if (this.upstreamKeyframeRequired) {
            if (!z7) {
                return;
            } else {
                this.upstreamKeyframeRequired = false;
            }
        }
        long j11 = this.sampleOffsetUs + j10;
        if (!this.allSamplesAreSyncSamples) {
            i12 = i6;
        } else {
            if (j11 < this.startTimeUs) {
                return;
            }
            if (i13 == 0) {
                if (!this.loggedUnexpectedNonSyncSample) {
                    Log.m1719w(TAG, "Overriding unexpected non-sync sample for format: " + this.upstreamFormat);
                    this.loggedUnexpectedNonSyncSample = true;
                }
                i12 = i6 | 1;
            } else {
                i12 = i6;
            }
        }
        if (this.pendingSplice) {
            if (!z7 || !attemptSplice(j11)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        commitSample(j11, i12, (this.sampleDataQueue.getTotalBytesWritten() - ((long) i10)) - ((long) i11), i10, cryptoData);
    }

    public final synchronized boolean seekTo(int i6) {
        rewind();
        int i10 = this.absoluteFirstIndex;
        if (i6 >= i10 && i6 <= this.length + i10) {
            this.startTimeUs = Long.MIN_VALUE;
            this.readPosition = i6 - i10;
            return true;
        }
        return false;
    }

    public final void setSampleOffsetUs(long j10) {
        if (this.sampleOffsetUs != j10) {
            this.sampleOffsetUs = j10;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setStartTimeUs(long j10) {
        this.startTimeUs = j10;
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final synchronized void skip(int i6) {
        boolean z7;
        if (i6 >= 0) {
            try {
                if (this.readPosition + i6 <= this.length) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z7 = false;
        }
        Assertions.checkArgument(z7);
        this.readPosition += i6;
    }

    public final void sourceId(long j10) {
        this.upstreamSourceId = j10;
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public void reset(boolean z7) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.startTimeUs = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        this.sharedSampleMetadata.clear();
        if (z7) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
            this.allSamplesAreSyncSamples = true;
        }
    }

    @Override
    public final void sampleData(ParsableByteArray parsableByteArray, int i6) {
        AbstractC1011d.m2654c(this, parsableByteArray, i6);
    }

    @Override
    public final int sampleData(DataReader dataReader, int i6, boolean z7, int i10) throws IOException {
        return this.sampleDataQueue.sampleData(dataReader, i6, z7);
    }

    @Deprecated
    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager.setPlayer(looper, PlayerId.UNSET);
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    @Override
    public final void sampleData(ParsableByteArray parsableByteArray, int i6, int i10) {
        this.sampleDataQueue.sampleData(parsableByteArray, i6);
    }

    public final synchronized boolean seekTo(long j10, boolean z7) {
        int iFindSampleBefore;
        try {
            rewind();
            int relativeIndex = getRelativeIndex(this.readPosition);
            if (hasNextSample() && j10 >= this.timesUs[relativeIndex] && (j10 <= this.largestQueuedTimestampUs || z7)) {
                if (this.allSamplesAreSyncSamples) {
                    iFindSampleBefore = findSampleAfter(relativeIndex, this.length - this.readPosition, j10, z7);
                } else {
                    iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j10, true);
                }
                if (iFindSampleBefore == -1) {
                    return false;
                }
                this.startTimeUs = j10;
                this.readPosition += iFindSampleBefore;
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }
}
