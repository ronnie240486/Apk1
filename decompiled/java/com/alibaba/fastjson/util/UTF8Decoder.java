package com.alibaba.fastjson.util;

import androidx.media3.common.C0565C;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import okio.Utf8;

public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i6;
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iLimit = byteBuffer.limit() + byteBuffer.arrayOffset();
        char[] cArrArray = charBuffer.array();
        int iPosition2 = charBuffer.position() + charBuffer.arrayOffset();
        int iLimit2 = charBuffer.limit() + charBuffer.arrayOffset();
        int iMin = Math.min(iLimit - iPosition, iLimit2 - iPosition2) + iPosition2;
        while (iPosition2 < iMin) {
            byte b8 = bArrArray[iPosition];
            if (b8 < 0) {
                break;
            }
            iPosition++;
            cArrArray[iPosition2] = (char) b8;
            iPosition2++;
        }
        while (true) {
            int i10 = iPosition2;
            while (iPosition < iLimit) {
                byte b10 = bArrArray[iPosition];
                if (b10 < 0) {
                    if ((b10 >> 5) == -2) {
                        if (iLimit - iPosition < 2 || i10 >= iLimit2) {
                            return xflow(byteBuffer, iPosition, iLimit, charBuffer, i10, 2);
                        }
                        byte b11 = bArrArray[iPosition + 1];
                        if (isMalformed2(b10, b11)) {
                            return malformed(byteBuffer, iPosition, charBuffer, i10, 2);
                        }
                        i6 = i10 + 1;
                        cArrArray[i10] = (char) (((b10 << 6) ^ b11) ^ Utf8.MASK_2BYTES);
                        iPosition += 2;
                    } else if ((b10 >> 4) == -2) {
                        if (iLimit - iPosition < 3 || i10 >= iLimit2) {
                            return xflow(byteBuffer, iPosition, iLimit, charBuffer, i10, 3);
                        }
                        byte b12 = bArrArray[iPosition + 1];
                        byte b13 = bArrArray[iPosition + 2];
                        if (isMalformed3(b10, b12, b13)) {
                            return malformed(byteBuffer, iPosition, charBuffer, i10, 3);
                        }
                        i6 = i10 + 1;
                        cArrArray[i10] = (char) ((((b10 << 12) ^ (b12 << 6)) ^ b13) ^ 8064);
                        iPosition += 3;
                    } else {
                        if ((b10 >> 3) != -2) {
                            return malformed(byteBuffer, iPosition, charBuffer, i10, 1);
                        }
                        if (iLimit - iPosition < 4 || iLimit2 - i10 < 2) {
                            return xflow(byteBuffer, iPosition, iLimit, charBuffer, i10, 4);
                        }
                        byte b14 = bArrArray[iPosition + 1];
                        byte b15 = bArrArray[iPosition + 2];
                        byte b16 = bArrArray[iPosition + 3];
                        int i11 = ((b10 & 7) << 18) | ((b14 & Utf8.REPLACEMENT_BYTE) << 12) | ((b15 & Utf8.REPLACEMENT_BYTE) << 6) | (b16 & Utf8.REPLACEMENT_BYTE);
                        if (isMalformed4(b14, b15, b16) || i11 < 65536 || i11 > 1114111) {
                            return malformed(byteBuffer, iPosition, charBuffer, i10, 4);
                        }
                        int i12 = i10 + 1;
                        int i13 = i11 - C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
                        cArrArray[i10] = (char) (((i13 >> 10) & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | 55296);
                        i10 += 2;
                        cArrArray[i12] = (char) ((i13 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | Utf8.LOG_SURROGATE_HEADER);
                        iPosition += 4;
                    }
                    i10 = i6;
                } else {
                    if (i10 >= iLimit2) {
                        return xflow(byteBuffer, iPosition, iLimit, charBuffer, i10, 1);
                    }
                    iPosition2 = i10 + 1;
                    cArrArray[i10] = (char) b10;
                    iPosition++;
                }
            }
            return xflow(byteBuffer, iPosition, iLimit, charBuffer, i10, 0);
        }
    }

    private static boolean isMalformed2(int i6, int i10) {
        return (i6 & 30) == 0 || (i10 & 192) != 128;
    }

    private static boolean isMalformed3(int i6, int i10, int i11) {
        return ((i6 != -32 || (i10 & 224) != 128) && (i10 & 192) == 128 && (i11 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i6, int i10, int i11) {
        return ((i6 & 192) == 128 && (i10 & 192) == 128 && (i11 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i6) {
        return (i6 & 192) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i6) {
        for (int i10 = 1; i10 < i6; i10++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i10);
            }
        }
        return CoderResult.malformedForLength(i6);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i6, CharBuffer charBuffer, int i10, int i11) {
        byteBuffer.position(i6 - byteBuffer.arrayOffset());
        CoderResult coderResultMalformedN = malformedN(byteBuffer, i11);
        byteBuffer.position(i6);
        charBuffer.position(i10);
        return coderResultMalformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i6) {
        int i10 = 1;
        if (i6 == 1) {
            byte b8 = byteBuffer.get();
            if ((b8 >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            }
            if ((b8 >> 1) == -2) {
                return byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 6);
            }
            return CoderResult.malformedForLength(1);
        }
        if (i6 == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i6 == 3) {
            byte b10 = byteBuffer.get();
            byte b11 = byteBuffer.get();
            if ((b10 != -32 || (b11 & 224) != 128) && !isNotContinuation(b11)) {
                i10 = 2;
            }
            return CoderResult.malformedForLength(i10);
        }
        if (i6 != 4) {
            throw new IllegalStateException();
        }
        int i11 = byteBuffer.get() & 255;
        byte b12 = byteBuffer.get();
        int i12 = b12 & 255;
        if (i11 > 244 || ((i11 == 240 && (i12 < 144 || i12 > 191)) || ((i11 == 244 && (b12 & 240) != 128) || isNotContinuation(i12)))) {
            return CoderResult.malformedForLength(1);
        }
        return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
    }

    private static CoderResult xflow(Buffer buffer, int i6, int i10, Buffer buffer2, int i11, int i12) {
        buffer.position(i6);
        buffer2.position(i11);
        return (i12 == 0 || i10 - i6 < i12) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
