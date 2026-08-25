package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.AbstractC0947u0;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.source.MediaSource;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

@UnstableApi
public class ImageRenderer extends BaseRenderer {
    private static final long IMAGE_PRESENTATION_WINDOW_THRESHOLD_US = 30000;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM_THEN_WAIT = 2;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 3;
    private static final String TAG = "ImageRenderer";
    private boolean codecNeedsInitialization;
    private int currentTileIndex;
    private ImageDecoder decoder;
    private final ImageDecoder.Factory decoderFactory;
    private int decoderReinitializationState;
    private int firstFrameState;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private ImageOutput imageOutput;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long largestQueuedPresentationTimeUs;
    private long lastProcessedOutputBufferTimeUs;
    private TileInfo nextTileInfo;
    private Bitmap outputBitmap;
    private boolean outputStreamEnded;
    private OutputStreamInfo outputStreamInfo;
    private final ArrayDeque<OutputStreamInfo> pendingOutputStreamChanges;
    private boolean readyToOutputTiles;
    private TileInfo tileInfo;

    public static final class OutputStreamInfo {
        public static final OutputStreamInfo UNSET = new OutputStreamInfo(C0565C.TIME_UNSET, C0565C.TIME_UNSET);
        public final long previousStreamLastBufferTimeUs;
        public final long streamOffsetUs;

        public OutputStreamInfo(long j10, long j11) {
            this.previousStreamLastBufferTimeUs = j10;
            this.streamOffsetUs = j11;
        }
    }

    public static class TileInfo {
        private final long presentationTimeUs;
        private Bitmap tileBitmap;
        private final int tileIndex;

        public TileInfo(int i6, long j10) {
            this.tileIndex = i6;
            this.presentationTimeUs = j10;
        }

        public long getPresentationTimeUs() {
            return this.presentationTimeUs;
        }

        public Bitmap getTileBitmap() {
            return this.tileBitmap;
        }

        public int getTileIndex() {
            return this.tileIndex;
        }

        public boolean hasTileBitmap() {
            return this.tileBitmap != null;
        }

        public void setTileBitmap(Bitmap bitmap) {
            this.tileBitmap = bitmap;
        }
    }

    public ImageRenderer(ImageDecoder.Factory factory, ImageOutput imageOutput) {
        super(4);
        this.decoderFactory = factory;
        this.imageOutput = getImageOutput(imageOutput);
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        this.pendingOutputStreamChanges = new ArrayDeque<>();
        this.largestQueuedPresentationTimeUs = C0565C.TIME_UNSET;
        this.lastProcessedOutputBufferTimeUs = C0565C.TIME_UNSET;
        this.decoderReinitializationState = 0;
        this.firstFrameState = 1;
    }

    private boolean canCreateDecoderForFormat(Format format) {
        int iSupportsFormat = this.decoderFactory.supportsFormat(format);
        return iSupportsFormat == AbstractC0947u0.m2577c(4) || iSupportsFormat == AbstractC0947u0.m2577c(3);
    }

    private Bitmap cropTileFromImageGrid(int i6) {
        Assertions.checkStateNotNull(this.outputBitmap);
        int width = this.outputBitmap.getWidth() / ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountHorizontal;
        int height = this.outputBitmap.getHeight() / ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountVertical;
        int i10 = this.inputFormat.tileCountHorizontal;
        return Bitmap.createBitmap(this.outputBitmap, (i6 % i10) * width, (i6 / i10) * height, width, height);
    }

    private boolean drainOutput(long j10, long j11) throws ExoPlaybackException, ImageDecoderException {
        if (this.outputBitmap != null && this.tileInfo == null) {
            return false;
        }
        if (this.firstFrameState == 0 && getState() != 2) {
            return false;
        }
        if (this.outputBitmap == null) {
            Assertions.checkStateNotNull(this.decoder);
            ImageOutputBuffer imageOutputBufferDequeueOutputBuffer = this.decoder.dequeueOutputBuffer();
            if (imageOutputBufferDequeueOutputBuffer == null) {
                return false;
            }
            if (((ImageOutputBuffer) Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer)).isEndOfStream()) {
                if (this.decoderReinitializationState == 3) {
                    releaseDecoderResources();
                    Assertions.checkStateNotNull(this.inputFormat);
                    maybeInitCodec();
                } else {
                    ((ImageOutputBuffer) Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer)).release();
                    if (this.pendingOutputStreamChanges.isEmpty()) {
                        this.outputStreamEnded = true;
                    }
                }
                return false;
            }
            Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer.bitmap, "Non-EOS buffer came back from the decoder without bitmap.");
            this.outputBitmap = imageOutputBufferDequeueOutputBuffer.bitmap;
            ((ImageOutputBuffer) Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer)).release();
        }
        if (!this.readyToOutputTiles || this.outputBitmap == null || this.tileInfo == null) {
            return false;
        }
        Assertions.checkStateNotNull(this.inputFormat);
        Format format = this.inputFormat;
        int i6 = format.tileCountHorizontal;
        boolean z7 = ((i6 == 1 && format.tileCountVertical == 1) || i6 == -1 || format.tileCountVertical == -1) ? false : true;
        if (!this.tileInfo.hasTileBitmap()) {
            TileInfo tileInfo = this.tileInfo;
            tileInfo.setTileBitmap(z7 ? cropTileFromImageGrid(tileInfo.getTileIndex()) : (Bitmap) Assertions.checkStateNotNull(this.outputBitmap));
        }
        if (!processOutputBuffer(j10, j11, (Bitmap) Assertions.checkStateNotNull(this.tileInfo.getTileBitmap()), this.tileInfo.getPresentationTimeUs())) {
            return false;
        }
        onProcessedOutputBuffer(((TileInfo) Assertions.checkStateNotNull(this.tileInfo)).getPresentationTimeUs());
        this.firstFrameState = 3;
        if (!z7 || ((TileInfo) Assertions.checkStateNotNull(this.tileInfo)).getTileIndex() == (((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountVertical * ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountHorizontal) - 1) {
            this.outputBitmap = null;
        }
        this.tileInfo = this.nextTileInfo;
        this.nextTileInfo = null;
        return true;
    }

    private boolean feedInputBuffer(long j10) throws DecoderException {
        if (this.readyToOutputTiles && this.tileInfo != null) {
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder == null || this.decoderReinitializationState == 3 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer decoderInputBufferDequeueInputBuffer = imageDecoder.dequeueInputBuffer();
            this.inputBuffer = decoderInputBufferDequeueInputBuffer;
            if (decoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 2) {
            Assertions.checkStateNotNull(this.inputBuffer);
            this.inputBuffer.setFlags(4);
            ((ImageDecoder) Assertions.checkStateNotNull(this.decoder)).queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 3;
            return false;
        }
        int source = readSource(formatHolder, this.inputBuffer, 0);
        if (source == -5) {
            this.inputFormat = (Format) Assertions.checkStateNotNull(formatHolder.format);
            this.codecNeedsInitialization = true;
            this.decoderReinitializationState = 2;
            return true;
        }
        if (source != -4) {
            if (source == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        this.inputBuffer.flip();
        ByteBuffer byteBuffer = this.inputBuffer.data;
        boolean z7 = (byteBuffer != null && byteBuffer.remaining() > 0) || ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).isEndOfStream();
        if (z7) {
            ((ImageDecoder) Assertions.checkStateNotNull(this.decoder)).queueInputBuffer((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer));
            this.currentTileIndex = 0;
        }
        maybeAdvanceTileInfo(j10, (DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer));
        if (((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).isEndOfStream()) {
            this.inputStreamEnded = true;
            this.inputBuffer = null;
            return false;
        }
        this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).timeUs);
        if (z7) {
            this.inputBuffer = null;
        } else {
            ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).clear();
        }
        return !this.readyToOutputTiles;
    }

    private static ImageOutput getImageOutput(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.NO_OP : imageOutput;
    }

    private boolean isTileLastInGrid(TileInfo tileInfo) {
        return ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountHorizontal == -1 || this.inputFormat.tileCountVertical == -1 || tileInfo.getTileIndex() == (((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountVertical * this.inputFormat.tileCountHorizontal) - 1;
    }

    private void lowerFirstFrameState(int i6) {
        this.firstFrameState = Math.min(this.firstFrameState, i6);
    }

    private void maybeAdvanceTileInfo(long j10, DecoderInputBuffer decoderInputBuffer) {
        boolean z7 = true;
        if (decoderInputBuffer.isEndOfStream()) {
            this.readyToOutputTiles = true;
            return;
        }
        TileInfo tileInfo = new TileInfo(this.currentTileIndex, decoderInputBuffer.timeUs);
        this.nextTileInfo = tileInfo;
        this.currentTileIndex++;
        if (!this.readyToOutputTiles) {
            long presentationTimeUs = tileInfo.getPresentationTimeUs();
            boolean z10 = presentationTimeUs - 30000 <= j10 && j10 <= 30000 + presentationTimeUs;
            TileInfo tileInfo2 = this.tileInfo;
            boolean z11 = tileInfo2 != null && tileInfo2.getPresentationTimeUs() <= j10 && j10 < presentationTimeUs;
            boolean zIsTileLastInGrid = isTileLastInGrid((TileInfo) Assertions.checkStateNotNull(this.nextTileInfo));
            if (!z10 && !z11 && !zIsTileLastInGrid) {
                z7 = false;
            }
            this.readyToOutputTiles = z7;
            if (z11 && !z10) {
                return;
            }
        }
        this.tileInfo = this.nextTileInfo;
        this.nextTileInfo = null;
    }

    private boolean maybeInitCodec() throws ExoPlaybackException {
        if (!maybeInitializeProcessingPipeline()) {
            return false;
        }
        if (!this.codecNeedsInitialization) {
            return true;
        }
        if (!canCreateDecoderForFormat((Format) Assertions.checkNotNull(this.inputFormat))) {
            throw createRendererException(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.inputFormat, PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED);
        }
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder != null) {
            imageDecoder.release();
        }
        this.decoder = this.decoderFactory.createImageDecoder();
        this.codecNeedsInitialization = false;
        return true;
    }

    private void onProcessedOutputBuffer(long j10) {
        this.lastProcessedOutputBufferTimeUs = j10;
        while (!this.pendingOutputStreamChanges.isEmpty() && j10 >= this.pendingOutputStreamChanges.peek().previousStreamLastBufferTimeUs) {
            this.outputStreamInfo = this.pendingOutputStreamChanges.removeFirst();
        }
    }

    private void releaseDecoderResources() {
        this.inputBuffer = null;
        this.decoderReinitializationState = 0;
        this.largestQueuedPresentationTimeUs = C0565C.TIME_UNSET;
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder != null) {
            imageDecoder.release();
            this.decoder = null;
        }
    }

    private void setImageOutput(ImageOutput imageOutput) {
        this.imageOutput = getImageOutput(imageOutput);
    }

    private boolean shouldForceRender() {
        boolean z7 = getState() == 2;
        int i6 = this.firstFrameState;
        if (i6 == 0) {
            return z7;
        }
        if (i6 == 1) {
            return true;
        }
        if (i6 == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    @Override
    public String getName() {
        return TAG;
    }

    @Override
    public void handleMessage(int i6, Object obj) throws ExoPlaybackException {
        if (i6 != 15) {
            super.handleMessage(i6, obj);
        } else {
            setImageOutput(obj instanceof ImageOutput ? (ImageOutput) obj : null);
        }
    }

    @Override
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override
    public boolean isReady() {
        int i6 = this.firstFrameState;
        return i6 == 3 || (i6 == 0 && this.readyToOutputTiles);
    }

    public boolean maybeInitializeProcessingPipeline() throws ExoPlaybackException {
        return true;
    }

    @Override
    public void onDisabled() {
        this.inputFormat = null;
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        this.pendingOutputStreamChanges.clear();
        releaseDecoderResources();
        this.imageOutput.onDisabled();
    }

    @Override
    public void onEnabled(boolean z7, boolean z10) throws ExoPlaybackException {
        this.firstFrameState = z10 ? 1 : 0;
    }

    @Override
    public void onPositionReset(long j10, boolean z7) throws ExoPlaybackException {
        lowerFirstFrameState(1);
        this.outputStreamEnded = false;
        this.inputStreamEnded = false;
        this.outputBitmap = null;
        this.tileInfo = null;
        this.nextTileInfo = null;
        this.readyToOutputTiles = false;
        this.inputBuffer = null;
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder != null) {
            imageDecoder.flush();
        }
        this.pendingOutputStreamChanges.clear();
    }

    @Override
    public void onRelease() {
        releaseDecoderResources();
    }

    @Override
    public void onReset() {
        releaseDecoderResources();
        lowerFirstFrameState(1);
    }

    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStreamChanged(Format[] formatArr, long j10, long j11, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j10, j11, mediaPeriodId);
        if (this.outputStreamInfo.streamOffsetUs != C0565C.TIME_UNSET) {
            if (this.pendingOutputStreamChanges.isEmpty()) {
                long j12 = this.largestQueuedPresentationTimeUs;
                if (j12 != C0565C.TIME_UNSET) {
                    long j13 = this.lastProcessedOutputBufferTimeUs;
                    if (j13 != C0565C.TIME_UNSET) {
                    }
                }
            }
            this.pendingOutputStreamChanges.add(new OutputStreamInfo(this.largestQueuedPresentationTimeUs, j11));
            return;
        }
        this.outputStreamInfo = new OutputStreamInfo(C0565C.TIME_UNSET, j11);
    }

    public boolean processOutputBuffer(long j10, long j11, Bitmap bitmap, long j12) throws ExoPlaybackException {
        long j13 = j12 - j10;
        if (!shouldForceRender() && j13 >= 30000) {
            return false;
        }
        this.imageOutput.onImageAvailable(j12 - this.outputStreamInfo.streamOffsetUs, bitmap);
        return true;
    }

    @Override
    public void render(long j10, long j11) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.inputFormat == null) {
            FormatHolder formatHolder = getFormatHolder();
            this.flagsOnlyBuffer.clear();
            int source = readSource(formatHolder, this.flagsOnlyBuffer, 2);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            this.inputFormat = (Format) Assertions.checkStateNotNull(formatHolder.format);
            this.codecNeedsInitialization = true;
        }
        if (this.decoder != null || maybeInitCodec()) {
            try {
                TraceUtil.beginSection("drainAndFeedDecoder");
                while (drainOutput(j10, j11)) {
                }
                while (feedInputBuffer(j10)) {
                }
                TraceUtil.endSection();
            } catch (ImageDecoderException e5) {
                throw createRendererException(e5, null, PlaybackException.ERROR_CODE_DECODING_FAILED);
            }
        }
    }

    @Override
    public int supportsFormat(Format format) {
        return this.decoderFactory.supportsFormat(format);
    }
}
