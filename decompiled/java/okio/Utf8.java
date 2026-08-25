package okio;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.p010ts.PsExtractor;
import p000a.AbstractC0004e;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;

public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i6) {
        return (i6 >= 0 && i6 < 32) || (127 <= i6 && i6 < 160);
    }

    public static final boolean isUtf8Continuation(byte b8) {
        return (b8 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i6, int i10, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "yield");
        int i11 = i6 + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i10 <= i11) {
            interfaceC2724l.invoke(numValueOf);
            return 1;
        }
        byte b8 = bArr[i6];
        byte b10 = bArr[i11];
        if ((b10 & 192) != 128) {
            interfaceC2724l.invoke(numValueOf);
            return 1;
        }
        int i12 = (b10 ^ 3968) ^ (b8 << 6);
        if (i12 < 128) {
            interfaceC2724l.invoke(numValueOf);
            return 2;
        }
        interfaceC2724l.invoke(Integer.valueOf(i12));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i6, int i10, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "yield");
        int i11 = i6 + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i10 <= i11) {
            interfaceC2724l.invoke(numValueOf);
            int i12 = i6 + 1;
            return (i10 <= i12 || (bArr[i12] & 192) != 128) ? 1 : 2;
        }
        byte b8 = bArr[i6];
        byte b10 = bArr[i6 + 1];
        if ((b10 & 192) != 128) {
            interfaceC2724l.invoke(numValueOf);
            return 1;
        }
        byte b11 = bArr[i11];
        if ((b11 & 192) != 128) {
            interfaceC2724l.invoke(numValueOf);
            return 2;
        }
        int i13 = ((b11 ^ (-123008)) ^ (b10 << 6)) ^ (b8 << 12);
        if (i13 < 2048) {
            interfaceC2724l.invoke(numValueOf);
            return 3;
        }
        if (55296 > i13 || i13 >= 57344) {
            interfaceC2724l.invoke(Integer.valueOf(i13));
            return 3;
        }
        interfaceC2724l.invoke(numValueOf);
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i6, int i10, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "yield");
        int i11 = i6 + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i10 <= i11) {
            interfaceC2724l.invoke(numValueOf);
            int i12 = i6 + 1;
            if (i10 <= i12 || (bArr[i12] & 192) != 128) {
                return 1;
            }
            int i13 = i6 + 2;
            return (i10 <= i13 || (bArr[i13] & 192) != 128) ? 2 : 3;
        }
        byte b8 = bArr[i6];
        byte b10 = bArr[i6 + 1];
        if ((b10 & 192) != 128) {
            interfaceC2724l.invoke(numValueOf);
            return 1;
        }
        byte b11 = bArr[i6 + 2];
        if ((b11 & 192) != 128) {
            interfaceC2724l.invoke(numValueOf);
            return 2;
        }
        byte b12 = bArr[i11];
        if ((b12 & 192) != 128) {
            interfaceC2724l.invoke(numValueOf);
            return 3;
        }
        int i14 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b8 << 18);
        if (i14 > 1114111) {
            interfaceC2724l.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i14 && i14 < 57344) {
            interfaceC2724l.invoke(numValueOf);
            return 4;
        }
        if (i14 < 65536) {
            interfaceC2724l.invoke(numValueOf);
            return 4;
        }
        interfaceC2724l.invoke(Integer.valueOf(i14));
        return 4;
    }

    public static final void processUtf16Chars(byte[] bArr, int i6, int i10, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "yield");
        while (i6 < i10) {
            byte b8 = bArr[i6];
            if (b8 >= 0) {
                interfaceC2724l.invoke(Character.valueOf((char) b8));
                i6++;
                while (i6 < i10) {
                    byte b10 = bArr[i6];
                    if (b10 < 0) {
                        break;
                    }
                    i6++;
                    interfaceC2724l.invoke(Character.valueOf((char) b10));
                }
            } else {
                int i11 = 2;
                if ((b8 >> 5) == -2) {
                    int i12 = i6 + 1;
                    if (i10 > i12) {
                        byte b11 = bArr[i12];
                        if ((b11 & 192) == 128) {
                            int i13 = (b8 << 6) ^ (b11 ^ 3968);
                            interfaceC2724l.invoke(Character.valueOf(i13 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i13));
                        }
                        i6 += i11;
                    }
                    interfaceC2724l.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    i11 = 1;
                    i6 += i11;
                } else if ((b8 >> 4) == -2) {
                    int i14 = i6 + 2;
                    if (i10 <= i14) {
                        interfaceC2724l.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        int i15 = i6 + 1;
                        if (i10 <= i15 || (bArr[i15] & 192) != 128) {
                            i11 = 1;
                        }
                    } else {
                        byte b12 = bArr[i6 + 1];
                        if ((b12 & 192) == 128) {
                            byte b13 = bArr[i14];
                            if ((b13 & 192) == 128) {
                                int i16 = (b8 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                                interfaceC2724l.invoke(Character.valueOf((i16 >= 2048 && (55296 > i16 || i16 >= 57344)) ? (char) i16 : (char) REPLACEMENT_CODE_POINT));
                                i11 = 3;
                            } else {
                                interfaceC2724l.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            }
                        } else {
                            interfaceC2724l.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            i11 = 1;
                        }
                    }
                    i6 += i11;
                } else if ((b8 >> 3) == -2) {
                    int i17 = i6 + 3;
                    if (i10 <= i17) {
                        interfaceC2724l.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        int i18 = i6 + 1;
                        if (i10 <= i18 || (bArr[i18] & 192) != 128) {
                            i11 = 1;
                        } else {
                            int i19 = i6 + 2;
                            if (i10 > i19 && (bArr[i19] & 192) == 128) {
                                i11 = 3;
                            }
                        }
                    } else {
                        byte b14 = bArr[i6 + 1];
                        if ((b14 & 192) == 128) {
                            byte b15 = bArr[i6 + 2];
                            if ((b15 & 192) == 128) {
                                byte b16 = bArr[i17];
                                if ((b16 & 192) == 128) {
                                    int i20 = (b8 << 18) ^ (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12));
                                    if (i20 <= 1114111 && ((55296 > i20 || i20 >= 57344) && i20 >= 65536 && i20 != 65533)) {
                                        interfaceC2724l.invoke(Character.valueOf((char) ((i20 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        interfaceC2724l.invoke(Character.valueOf((char) ((i20 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + LOG_SURROGATE_HEADER)));
                                    } else {
                                        interfaceC2724l.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    }
                                    i11 = 4;
                                } else {
                                    interfaceC2724l.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    i11 = 3;
                                }
                            } else {
                                interfaceC2724l.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            }
                        } else {
                            interfaceC2724l.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            i11 = 1;
                        }
                    }
                    i6 += i11;
                } else {
                    interfaceC2724l.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i6++;
                }
            }
        }
    }

    public static final void processUtf8Bytes(String str, int i6, int i10, InterfaceC2724l interfaceC2724l) {
        int i11;
        char cCharAt;
        AbstractC2796i.m5785f(str, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "yield");
        while (i6 < i10) {
            char cCharAt2 = str.charAt(i6);
            if (AbstractC2796i.m5787h(cCharAt2, 128) < 0) {
                interfaceC2724l.invoke(Byte.valueOf((byte) cCharAt2));
                i6++;
                while (i6 < i10 && AbstractC2796i.m5787h(str.charAt(i6), 128) < 0) {
                    interfaceC2724l.invoke(Byte.valueOf((byte) str.charAt(i6)));
                    i6++;
                }
            } else {
                if (AbstractC2796i.m5787h(cCharAt2, 2048) < 0) {
                    interfaceC2724l.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | 192)));
                    interfaceC2724l.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || cCharAt2 >= 57344) {
                    interfaceC2724l.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    interfaceC2724l.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    interfaceC2724l.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (AbstractC2796i.m5787h(cCharAt2, 56319) > 0 || i10 <= (i11 = i6 + 1) || 56320 > (cCharAt = str.charAt(i11)) || cCharAt >= 57344) {
                    interfaceC2724l.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = (str.charAt(i11) + (cCharAt2 << '\n')) - 56613888;
                    interfaceC2724l.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | PsExtractor.VIDEO_STREAM_MASK)));
                    interfaceC2724l.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    interfaceC2724l.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    interfaceC2724l.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i6 += 2;
                }
                i6++;
            }
        }
    }

    public static final void processUtf8CodePoints(byte[] bArr, int i6, int i10, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(bArr, "<this>");
        AbstractC2796i.m5785f(interfaceC2724l, "yield");
        while (i6 < i10) {
            byte b8 = bArr[i6];
            if (b8 >= 0) {
                interfaceC2724l.invoke(Integer.valueOf(b8));
                i6++;
                while (i6 < i10) {
                    byte b10 = bArr[i6];
                    if (b10 < 0) {
                        break;
                    }
                    i6++;
                    interfaceC2724l.invoke(Integer.valueOf(b10));
                }
            } else {
                int i11 = 2;
                if ((b8 >> 5) == -2) {
                    int i12 = i6 + 1;
                    if (i10 > i12) {
                        byte b11 = bArr[i12];
                        if ((b11 & 192) == 128) {
                            int i13 = (b8 << 6) ^ (b11 ^ 3968);
                            interfaceC2724l.invoke(i13 < 128 ? Integer.valueOf(REPLACEMENT_CODE_POINT) : Integer.valueOf(i13));
                        }
                        i6 += i11;
                    }
                    interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i11 = 1;
                    i6 += i11;
                } else if ((b8 >> 4) == -2) {
                    int i14 = i6 + 2;
                    if (i10 <= i14) {
                        interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i15 = i6 + 1;
                        if (i10 <= i15 || (bArr[i15] & 192) != 128) {
                            i11 = 1;
                        }
                    } else {
                        byte b12 = bArr[i6 + 1];
                        if ((b12 & 192) == 128) {
                            byte b13 = bArr[i14];
                            if ((b13 & 192) == 128) {
                                int i16 = (b8 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                                interfaceC2724l.invoke((i16 >= 2048 && (55296 > i16 || i16 >= 57344)) ? Integer.valueOf(i16) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i11 = 3;
                            } else {
                                interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            }
                        } else {
                            interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i11 = 1;
                        }
                    }
                    i6 += i11;
                } else if ((b8 >> 3) == -2) {
                    int i17 = i6 + 3;
                    if (i10 <= i17) {
                        interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i18 = i6 + 1;
                        if (i10 <= i18 || (bArr[i18] & 192) != 128) {
                            i11 = 1;
                        } else {
                            int i19 = i6 + 2;
                            if (i10 > i19 && (bArr[i19] & 192) == 128) {
                                i11 = 3;
                            }
                        }
                    } else {
                        byte b14 = bArr[i6 + 1];
                        if ((b14 & 192) == 128) {
                            byte b15 = bArr[i6 + 2];
                            if ((b15 & 192) == 128) {
                                byte b16 = bArr[i17];
                                if ((b16 & 192) == 128) {
                                    int i20 = (b8 << 18) ^ (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12));
                                    interfaceC2724l.invoke((i20 <= 1114111 && (55296 > i20 || i20 >= 57344) && i20 >= 65536) ? Integer.valueOf(i20) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i11 = 4;
                                } else {
                                    interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i11 = 3;
                                }
                            } else {
                                interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            }
                        } else {
                            interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i11 = 1;
                        }
                    }
                    i6 += i11;
                } else {
                    interfaceC2724l.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i6++;
                }
            }
        }
    }

    public static final long size(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static long size$default(String str, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i6 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return size(str, i6, i10);
    }

    public static final long size(String str, int i6) {
        AbstractC2796i.m5785f(str, "<this>");
        return size$default(str, i6, 0, 2, null);
    }

    public static final long size(String str, int i6, int i10) {
        int i11;
        AbstractC2796i.m5785f(str, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "beginIndex < 0: ").toString());
        }
        if (i10 >= i6) {
            if (i10 > str.length()) {
                StringBuilder sbM27u = AbstractC0004e.m27u(i10, "endIndex > string.length: ", " > ");
                sbM27u.append(str.length());
                throw new IllegalArgumentException(sbM27u.toString().toString());
            }
            long j10 = 0;
            while (i6 < i10) {
                char cCharAt = str.charAt(i6);
                if (cCharAt < 128) {
                    j10++;
                } else {
                    if (cCharAt < 2048) {
                        i11 = 2;
                    } else if (cCharAt < 55296 || cCharAt > 57343) {
                        i11 = 3;
                    } else {
                        int i12 = i6 + 1;
                        char cCharAt2 = i12 < i10 ? str.charAt(i12) : (char) 0;
                        if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                            j10++;
                            i6 = i12;
                        } else {
                            j10 += (long) 4;
                            i6 += 2;
                        }
                    }
                    j10 += (long) i11;
                }
                i6++;
            }
            return j10;
        }
        throw new IllegalArgumentException(AbstractC0004e.m19m(i10, i6, "endIndex < beginIndex: ", " < ").toString());
    }
}
