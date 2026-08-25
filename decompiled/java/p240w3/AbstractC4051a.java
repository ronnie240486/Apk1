package p240w3;

public abstract class AbstractC4051a {

    public static final int[] f13716a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m8054a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i6 = (length * 3) / 4;
        byte[] bArr = new byte[i6];
        int[] iArr = f13716a;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i10 < length) {
            if (i11 == 0) {
                while (true) {
                    int i14 = i10 + 4;
                    if (i14 > length || (i12 = (iArr[bytes[i10] & 255] << 18) | (iArr[bytes[i10 + 1] & 255] << 12) | (iArr[bytes[i10 + 2] & 255] << 6) | iArr[bytes[i10 + 3] & 255]) < 0) {
                        break;
                    }
                    bArr[i13 + 2] = (byte) i12;
                    bArr[i13 + 1] = (byte) (i12 >> 8);
                    bArr[i13] = (byte) (i12 >> 16);
                    i13 += 3;
                    i10 = i14;
                }
                if (i10 >= length) {
                    break;
                }
                throw new IllegalArgumentException("bad base-64");
            }
            int i15 = i10 + 1;
            int i16 = iArr[bytes[i10] & 255];
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 != 4) {
                                if (i11 == 5 && i16 != -1) {
                                    throw new IllegalArgumentException("bad base-64");
                                }
                            } else if (i16 == -2) {
                                i11++;
                            } else if (i16 != -1) {
                                throw new IllegalArgumentException("bad base-64");
                            }
                        } else if (i16 >= 0) {
                            int i17 = i16 | (i12 << 6);
                            bArr[i13 + 2] = (byte) i17;
                            bArr[i13 + 1] = (byte) (i17 >> 8);
                            bArr[i13] = (byte) (i17 >> 16);
                            i13 += 3;
                            i12 = i17;
                            i11 = 0;
                        } else if (i16 == -2) {
                            bArr[i13 + 1] = (byte) (i12 >> 2);
                            bArr[i13] = (byte) (i12 >> 10);
                            i13 += 2;
                            i11 = 5;
                        } else if (i16 != -1) {
                            throw new IllegalArgumentException("bad base-64");
                        }
                    } else if (i16 >= 0) {
                        i16 |= i12 << 6;
                    } else if (i16 == -2) {
                        bArr[i13] = (byte) (i12 >> 4);
                        i13++;
                        i11 = 4;
                    } else if (i16 != -1) {
                        throw new IllegalArgumentException("bad base-64");
                    }
                } else if (i16 >= 0) {
                    i16 |= i12 << 6;
                } else if (i16 != -1) {
                    throw new IllegalArgumentException("bad base-64");
                }
                i11++;
                i12 = i16;
            } else if (i16 >= 0) {
                i11++;
                i12 = i16;
            } else if (i16 != -1) {
                throw new IllegalArgumentException("bad base-64");
            }
            i10 = i15;
        }
        if (i11 != 1) {
            if (i11 == 2) {
                bArr[i13] = (byte) (i12 >> 4);
                i13++;
            } else if (i11 == 3) {
                int i18 = i13 + 1;
                bArr[i13] = (byte) (i12 >> 10);
                i13 += 2;
                bArr[i18] = (byte) (i12 >> 2);
            }
            if (i13 == i6) {
                return bArr;
            }
            byte[] bArr2 = new byte[i13];
            System.arraycopy(bArr, 0, bArr2, 0, i13);
            return bArr2;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
