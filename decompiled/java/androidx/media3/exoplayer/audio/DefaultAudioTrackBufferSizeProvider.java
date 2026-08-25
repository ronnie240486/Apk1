package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;
import com.bumptech.glide.AbstractC1465c;
import java.math.RoundingMode;
import p060f7.AbstractC2499c;
import p187r4.AbstractC3612b;

@UnstableApi
public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int DTSHD_BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int MAX_PCM_BUFFER_DURATION_US = 750000;
    private static final int MIN_PCM_BUFFER_DURATION_US = 250000;
    private static final int OFFLOAD_BUFFER_DURATION_US = 50000000;
    private static final int PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int PCM_BUFFER_MULTIPLICATION_FACTOR = 4;
    public final int ac3BufferMultiplicationFactor;
    public final int dtshdBufferMultiplicationFactor;
    protected final int maxPcmBufferDurationUs;
    protected final int minPcmBufferDurationUs;
    protected final int offloadBufferDurationUs;
    protected final int passthroughBufferDurationUs;
    protected final int pcmBufferMultiplicationFactor;

    public static class Builder {
        private int minPcmBufferDurationUs = 250000;
        private int maxPcmBufferDurationUs = DefaultAudioTrackBufferSizeProvider.MAX_PCM_BUFFER_DURATION_US;
        private int pcmBufferMultiplicationFactor = 4;
        private int passthroughBufferDurationUs = 250000;
        private int offloadBufferDurationUs = DefaultAudioTrackBufferSizeProvider.OFFLOAD_BUFFER_DURATION_US;
        private int ac3BufferMultiplicationFactor = 2;
        private int dtshdBufferMultiplicationFactor = 4;

        public DefaultAudioTrackBufferSizeProvider build() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }

        public Builder setAc3BufferMultiplicationFactor(int i6) {
            this.ac3BufferMultiplicationFactor = i6;
            return this;
        }

        public Builder setDtshdBufferMultiplicationFactor(int i6) {
            this.dtshdBufferMultiplicationFactor = i6;
            return this;
        }

        public Builder setMaxPcmBufferDurationUs(int i6) {
            this.maxPcmBufferDurationUs = i6;
            return this;
        }

        public Builder setMinPcmBufferDurationUs(int i6) {
            this.minPcmBufferDurationUs = i6;
            return this;
        }

        public Builder setOffloadBufferDurationUs(int i6) {
            this.offloadBufferDurationUs = i6;
            return this;
        }

        public Builder setPassthroughBufferDurationUs(int i6) {
            this.passthroughBufferDurationUs = i6;
            return this;
        }

        public Builder setPcmBufferMultiplicationFactor(int i6) {
            this.pcmBufferMultiplicationFactor = i6;
            return this;
        }
    }

    public DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.minPcmBufferDurationUs = builder.minPcmBufferDurationUs;
        this.maxPcmBufferDurationUs = builder.maxPcmBufferDurationUs;
        this.pcmBufferMultiplicationFactor = builder.pcmBufferMultiplicationFactor;
        this.passthroughBufferDurationUs = builder.passthroughBufferDurationUs;
        this.offloadBufferDurationUs = builder.offloadBufferDurationUs;
        this.ac3BufferMultiplicationFactor = builder.ac3BufferMultiplicationFactor;
        this.dtshdBufferMultiplicationFactor = builder.dtshdBufferMultiplicationFactor;
    }

    public static int durationUsToBytes(int i6, int i10, int i11) {
        return AbstractC3612b.m7263c(((((long) i6) * ((long) i10)) * ((long) i11)) / 1000000);
    }

    public static int getMaximumEncodedRateBytesPerSecond(int i6) {
        if (i6 == 20) {
            return OpusUtil.MAX_BYTES_PER_SECOND;
        }
        if (i6 == 30) {
            return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
        }
        switch (i6) {
            case 5:
                return Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
            case 6:
                return 768000;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return 100000;
            case 11:
                return AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
            case 12:
                return 7000;
            default:
                switch (i6) {
                    case 14:
                        return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
                    case 15:
                        return 8000;
                    case 16:
                        return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
                    case 17:
                        return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
                    case 18:
                        return 768000;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int get1xBufferSizeInBytes(int i6, int i10, int i11, int i12, int i13, int i14) {
        if (i11 == 0) {
            return getPcmBufferSizeInBytes(i6, i13, i12);
        }
        if (i11 == 1) {
            return getOffloadBufferSizeInBytes(i10);
        }
        if (i11 == 2) {
            return getPassthroughBufferSizeInBytes(i10, i14);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getBufferSizeInBytes(int i6, int i10, int i11, int i12, int i13, int i14, double d) {
        return (((Math.max(i6, (int) (((double) get1xBufferSizeInBytes(i6, i10, i11, i12, i13, i14)) * d)) + i12) - 1) / i12) * i12;
    }

    public int getOffloadBufferSizeInBytes(int i6) {
        return AbstractC3612b.m7263c((((long) this.offloadBufferDurationUs) * ((long) getMaximumEncodedRateBytesPerSecond(i6))) / 1000000);
    }

    public int getPassthroughBufferSizeInBytes(int i6, int i10) {
        int i11;
        int maximumEncodedRateBytesPerSecond;
        RoundingMode roundingMode;
        int i12;
        int i13;
        int iAbs;
        boolean z7;
        int i14 = this.passthroughBufferDurationUs;
        if (i6 != 5) {
            if (i6 == 8) {
                i11 = this.dtshdBufferMultiplicationFactor;
            }
            if (i10 != -1) {
                roundingMode = RoundingMode.CEILING;
                roundingMode.getClass();
                maximumEncodedRateBytesPerSecond = i10 / 8;
                i12 = i10 - (8 * maximumEncodedRateBytesPerSecond);
                if (i12 != 0) {
                    i13 = ((i10 ^ 8) >> 31) | 1;
                    switch (AbstractC2499c.f8729a[roundingMode.ordinal()]) {
                        case 1:
                            AbstractC1465c.m3469d(i12 == 0);
                            break;
                        case 2:
                            break;
                        case 3:
                            if (i13 < 0) {
                                maximumEncodedRateBytesPerSecond += i13;
                            }
                            break;
                        case 4:
                            maximumEncodedRateBytesPerSecond += i13;
                            break;
                        case 5:
                            if (i13 > 0) {
                                maximumEncodedRateBytesPerSecond += i13;
                            }
                            break;
                        case 6:
                        case 7:
                        case 8:
                            int iAbs2 = Math.abs(i12);
                            iAbs = iAbs2 - (Math.abs(8) - iAbs2);
                            if (iAbs == 0) {
                                if (iAbs > 0) {
                                    maximumEncodedRateBytesPerSecond += i13;
                                }
                            } else if (roundingMode == RoundingMode.HALF_UP) {
                                if (roundingMode == RoundingMode.HALF_EVEN) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (z7 & ((maximumEncodedRateBytesPerSecond & 1) != 0)) {
                                    maximumEncodedRateBytesPerSecond += i13;
                                }
                            } else {
                                maximumEncodedRateBytesPerSecond += i13;
                            }
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            } else {
                maximumEncodedRateBytesPerSecond = getMaximumEncodedRateBytesPerSecond(i6);
            }
            return AbstractC3612b.m7263c((((long) i14) * ((long) maximumEncodedRateBytesPerSecond)) / 1000000);
        }
        i11 = this.ac3BufferMultiplicationFactor;
        i14 *= i11;
        if (i10 != -1) {
            roundingMode = RoundingMode.CEILING;
            roundingMode.getClass();
            maximumEncodedRateBytesPerSecond = i10 / 8;
            i12 = i10 - (8 * maximumEncodedRateBytesPerSecond);
            if (i12 != 0) {
                i13 = ((i10 ^ 8) >> 31) | 1;
                switch (AbstractC2499c.f8729a[roundingMode.ordinal()]) {
                    case 1:
                        AbstractC1465c.m3469d(i12 == 0);
                        break;
                    case 2:
                        break;
                    case 3:
                        if (i13 < 0) {
                            maximumEncodedRateBytesPerSecond += i13;
                        }
                        break;
                    case 4:
                        maximumEncodedRateBytesPerSecond += i13;
                        break;
                    case 5:
                        if (i13 > 0) {
                            maximumEncodedRateBytesPerSecond += i13;
                        }
                        break;
                    case 6:
                    case 7:
                    case 8:
                        int iAbs3 = Math.abs(i12);
                        iAbs = iAbs3 - (Math.abs(8) - iAbs3);
                        if (iAbs == 0) {
                            if (iAbs > 0) {
                                maximumEncodedRateBytesPerSecond += i13;
                            }
                        } else if (roundingMode == RoundingMode.HALF_UP) {
                            if (roundingMode == RoundingMode.HALF_EVEN) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7 & ((maximumEncodedRateBytesPerSecond & 1) != 0)) {
                                maximumEncodedRateBytesPerSecond += i13;
                            }
                        } else {
                            maximumEncodedRateBytesPerSecond += i13;
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } else {
            maximumEncodedRateBytesPerSecond = getMaximumEncodedRateBytesPerSecond(i6);
        }
        return AbstractC3612b.m7263c((((long) i14) * ((long) maximumEncodedRateBytesPerSecond)) / 1000000);
    }

    public int getPcmBufferSizeInBytes(int i6, int i10, int i11) {
        return Util.constrainValue(i6 * this.pcmBufferMultiplicationFactor, durationUsToBytes(this.minPcmBufferDurationUs, i10, i11), durationUsToBytes(this.maxPcmBufferDurationUs, i10, i11));
    }
}
