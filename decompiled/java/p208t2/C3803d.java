package p208t2;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import p007a7.C0069f;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;

public final class C3803d {

    public int[] f12821a;

    public final C0069f f12823c;

    public ByteBuffer f12824d;

    public byte[] f12825e;

    public short[] f12826f;

    public byte[] f12827g;

    public byte[] f12828h;

    public byte[] f12829i;

    public final int[] f12830j;

    public int f12831k;

    public C3801b f12832l;

    public Bitmap f12833m;

    public final boolean f12834n;

    public int f12835o;

    public final int f12836p;

    public final int f12837q;

    public final int f12838r;

    public Boolean f12839s;

    public final int[] f12822b = new int[256];

    public Bitmap.Config f12840t = Bitmap.Config.ARGB_8888;

    public C3803d(C0069f c0069f, C3801b c3801b, ByteBuffer byteBuffer, int i6) {
        this.f12823c = c0069f;
        this.f12832l = new C3801b();
        synchronized (this) {
            try {
                if (i6 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i6);
                }
                int iHighestOneBit = Integer.highestOneBit(i6);
                this.f12835o = 0;
                this.f12832l = c3801b;
                this.f12831k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f12824d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.f12824d.order(ByteOrder.LITTLE_ENDIAN);
                this.f12834n = false;
                Iterator it = c3801b.f12810e.iterator();
                while (it.hasNext()) {
                    if (((C3800a) it.next()).f12801g == 3) {
                        this.f12834n = true;
                        break;
                    }
                }
                this.f12836p = iHighestOneBit;
                int i10 = c3801b.f12811f;
                this.f12838r = i10 / iHighestOneBit;
                int i11 = c3801b.f12812g;
                this.f12837q = i11 / iHighestOneBit;
                int i12 = i10 * i11;
                C4243f c4243f = (C4243f) this.f12823c.f197c;
                this.f12829i = c4243f == null ? new byte[i12] : (byte[]) c4243f.m8287d(i12, byte[].class);
                C0069f c0069f2 = this.f12823c;
                int i13 = this.f12838r * this.f12837q;
                C4243f c4243f2 = (C4243f) c0069f2.f197c;
                this.f12830j = c4243f2 == null ? new int[i13] : (int[]) c4243f2.m8287d(i13, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap m7577a() {
        Boolean bool = this.f12839s;
        Bitmap bitmapMo6924d = ((InterfaceC4238a) this.f12823c.f196b).mo6924d(this.f12838r, this.f12837q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f12840t);
        bitmapMo6924d.setHasAlpha(true);
        return bitmapMo6924d;
    }

    public final synchronized Bitmap m7578b() {
        try {
            if (this.f12832l.f12808c <= 0 || this.f12831k < 0) {
                if (Log.isLoggable("d", 3)) {
                    Log.d("d", "Unable to decode frame, frameCount=" + this.f12832l.f12808c + ", framePointer=" + this.f12831k);
                }
                this.f12835o = 1;
            }
            int i6 = this.f12835o;
            if (i6 != 1 && i6 != 2) {
                this.f12835o = 0;
                if (this.f12825e == null) {
                    C4243f c4243f = (C4243f) this.f12823c.f197c;
                    this.f12825e = c4243f == null ? new byte[255] : (byte[]) c4243f.m8287d(255, byte[].class);
                }
                C3800a c3800a = (C3800a) this.f12832l.f12810e.get(this.f12831k);
                int i10 = this.f12831k - 1;
                C3800a c3800a2 = i10 >= 0 ? (C3800a) this.f12832l.f12810e.get(i10) : null;
                int[] iArr = c3800a.f12805k;
                if (iArr == null) {
                    iArr = this.f12832l.f12806a;
                }
                this.f12821a = iArr;
                if (iArr == null) {
                    if (Log.isLoggable("d", 3)) {
                        Log.d("d", "No valid color table found for frame #" + this.f12831k);
                    }
                    this.f12835o = 1;
                    return null;
                }
                if (c3800a.f12800f) {
                    System.arraycopy(iArr, 0, this.f12822b, 0, iArr.length);
                    int[] iArr2 = this.f12822b;
                    this.f12821a = iArr2;
                    iArr2[c3800a.f12802h] = 0;
                    if (c3800a.f12801g == 2 && this.f12831k == 0) {
                        this.f12839s = Boolean.TRUE;
                    }
                }
                return m7580d(c3800a, c3800a2);
            }
            if (Log.isLoggable("d", 3)) {
                Log.d("d", "Unable to decode frame, status=" + this.f12835o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void m7579c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f12840t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public final Bitmap m7580d(C3800a c3800a, C3800a c3800a2) {
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        short s10;
        int i17;
        Bitmap bitmap;
        int i18;
        int[] iArr = this.f12830j;
        C0069f c0069f = this.f12823c;
        if (c3800a2 == null) {
            Bitmap bitmap2 = this.f12833m;
            if (bitmap2 != null) {
                ((InterfaceC4238a) c0069f.f196b).mo5434f(bitmap2);
            }
            this.f12833m = null;
            Arrays.fill(iArr, 0);
        }
        if (c3800a2 != null && c3800a2.f12801g == 3 && this.f12833m == null) {
            Arrays.fill(iArr, 0);
        }
        if (c3800a2 != null && (i17 = c3800a2.f12801g) > 0) {
            if (i17 == 2) {
                if (c3800a.f12800f) {
                    i18 = 0;
                } else {
                    C3801b c3801b = this.f12832l;
                    i18 = c3801b.f12816k;
                    if (c3800a.f12805k != null && c3801b.f12815j == c3800a.f12802h) {
                        i18 = 0;
                    }
                }
                int i19 = c3800a2.f12798d;
                int i20 = this.f12836p;
                int i21 = i19 / i20;
                int i22 = c3800a2.f12796b / i20;
                int i23 = c3800a2.f12797c / i20;
                int i24 = c3800a2.f12795a / i20;
                int i25 = this.f12838r;
                int i26 = (i22 * i25) + i24;
                int i27 = (i21 * i25) + i26;
                while (i26 < i27) {
                    int i28 = i26 + i23;
                    for (int i29 = i26; i29 < i28; i29++) {
                        iArr[i29] = i18;
                    }
                    i26 += this.f12838r;
                }
            } else if (i17 == 3 && (bitmap = this.f12833m) != null) {
                int i30 = this.f12838r;
                bitmap.getPixels(iArr, 0, i30, 0, 0, i30, this.f12837q);
            }
        }
        this.f12824d.position(c3800a.f12804j);
        int i31 = c3800a.f12797c * c3800a.f12798d;
        byte[] bArr = this.f12829i;
        if (bArr == null || bArr.length < i31) {
            C4243f c4243f = (C4243f) c0069f.f197c;
            this.f12829i = c4243f == null ? new byte[i31] : (byte[]) c4243f.m8287d(i31, byte[].class);
        }
        byte[] bArr2 = this.f12829i;
        if (this.f12826f == null) {
            this.f12826f = new short[4096];
        }
        short[] sArr = this.f12826f;
        if (this.f12827g == null) {
            this.f12827g = new byte[4096];
        }
        byte[] bArr3 = this.f12827g;
        if (this.f12828h == null) {
            this.f12828h = new byte[4097];
        }
        byte[] bArr4 = this.f12828h;
        int i32 = this.f12824d.get() & 255;
        int i33 = 1 << i32;
        int i34 = i33 + 1;
        int i35 = i33 + 2;
        int i36 = i32 + 1;
        int i37 = (1 << i36) - 1;
        for (int i38 = 0; i38 < i33; i38++) {
            sArr[i38] = 0;
            bArr3[i38] = (byte) i38;
        }
        byte[] bArr5 = this.f12825e;
        int i39 = i36;
        int i40 = i35;
        int i41 = i37;
        int i42 = 0;
        int i43 = -1;
        int i44 = 0;
        int i45 = 0;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        int i49 = 0;
        int i50 = 0;
        while (i42 < i31) {
            if (i44 == 0) {
                int i51 = this.f12824d.get() & 255;
                if (i51 > 0) {
                    ByteBuffer byteBuffer = this.f12824d;
                    byteBuffer.get(this.f12825e, 0, Math.min(i51, byteBuffer.remaining()));
                }
                if (i51 <= 0) {
                    this.f12835o = 3;
                    break;
                }
                i44 = i51;
                i45 = 0;
            } else {
                i36 = i36;
                i42 = i42;
            }
            i47 += (bArr5[i45] & 255) << i46;
            i45++;
            i44--;
            i43 = i43;
            int i52 = i46 + 8;
            i40 = i40;
            i39 = i39;
            i42 = i42;
            bArr5 = bArr5;
            i49 = i49;
            while (true) {
                if (i52 < i39) {
                    i46 = i52;
                    break;
                }
                iArr = iArr;
                int i53 = i47 & i41;
                i47 >>= i39;
                i52 -= i39;
                if (i53 == i33) {
                    i40 = i35;
                    i41 = i37;
                    i39 = i36;
                    i43 = -1;
                } else {
                    if (i53 == i34) {
                        iArr = iArr;
                        i46 = i52;
                        break;
                    }
                    if (i43 == -1) {
                        bArr2[i48] = bArr3[i53];
                        i48++;
                        i42++;
                        i49 = i53;
                        i43 = i49;
                        i52 = i52;
                    } else {
                        if (i53 >= i40) {
                            bArr4[i50] = (byte) i49;
                            i50++;
                            s10 = i43;
                        } else {
                            s10 = i53;
                        }
                        while (s10 >= i33) {
                            bArr4[i50] = bArr3[s10];
                            i50++;
                            s10 = sArr[s10];
                        }
                        int i54 = bArr3[s10] & 255;
                        byte b8 = (byte) i54;
                        bArr2[i48] = b8;
                        while (true) {
                            i48++;
                            i42++;
                            if (i50 <= 0) {
                                break;
                            }
                            i50--;
                            bArr2[i48] = bArr4[i50];
                        }
                        if (i40 < 4096) {
                            sArr[i40] = (short) i43;
                            bArr3[i40] = b8;
                            i40++;
                            if ((i40 & i41) == 0 && i40 < 4096) {
                                i39++;
                                i41 += i40;
                            }
                        }
                        i43 = i53;
                        i52 = i52;
                        i49 = i54;
                    }
                }
            }
        }
        int[] iArr2 = iArr;
        Arrays.fill(bArr2, i48, i31, (byte) 0);
        if (c3800a.f12799e || this.f12836p != 1) {
            int[] iArr3 = this.f12830j;
            int i55 = c3800a.f12798d;
            int i56 = this.f12836p;
            int i57 = i55 / i56;
            int i58 = c3800a.f12796b / i56;
            int i59 = c3800a.f12797c / i56;
            int i60 = c3800a.f12795a / i56;
            boolean z7 = this.f12831k == 0;
            int i61 = this.f12838r;
            int i62 = this.f12837q;
            byte[] bArr6 = this.f12829i;
            int[] iArr4 = this.f12821a;
            Boolean bool = this.f12839s;
            int i63 = 0;
            int i64 = 0;
            int i65 = 1;
            int i66 = 8;
            while (i63 < i57) {
                Boolean bool2 = bool;
                if (c3800a.f12799e) {
                    if (i64 >= i57) {
                        int i67 = i65 + 1;
                        i6 = i57;
                        if (i67 == 2) {
                            i65 = i67;
                            i64 = 4;
                        } else if (i67 == 3) {
                            i65 = i67;
                            i64 = 2;
                            i66 = 4;
                        } else if (i67 != 4) {
                            i65 = i67;
                        } else {
                            i65 = i67;
                            i64 = 1;
                            i66 = 2;
                        }
                    } else {
                        i6 = i57;
                    }
                    i10 = i64 + i66;
                } else {
                    i6 = i57;
                    i10 = i64;
                    i64 = i63;
                }
                int i68 = i64 + i58;
                boolean z10 = i56 == 1;
                if (i68 < i62) {
                    int i69 = i68 * i61;
                    int i70 = i69 + i60;
                    int i71 = i70 + i59;
                    int i72 = i69 + i61;
                    if (i72 < i71) {
                        i71 = i72;
                    }
                    int i73 = i63 * i56 * c3800a.f12797c;
                    if (z10) {
                        bool = bool2;
                        int i74 = i70;
                        while (i74 < i71) {
                            int i75 = i59;
                            int i76 = iArr4[bArr6[i73] & 255];
                            if (i76 != 0) {
                                iArr3[i74] = i76;
                            } else if (z7 && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i73 += i56;
                            i74++;
                            i59 = i75;
                        }
                        i11 = i59;
                    } else {
                        i11 = i59;
                        int i77 = ((i71 - i70) * i56) + i73;
                        bool = bool2;
                        int i78 = i70;
                        while (i78 < i71) {
                            int i79 = i71;
                            int i80 = c3800a.f12797c;
                            int i81 = i60;
                            int i82 = i61;
                            int i83 = i73;
                            int i84 = 0;
                            int i85 = 0;
                            int i86 = 0;
                            int i87 = 0;
                            int i88 = 0;
                            while (true) {
                                if (i83 >= this.f12836p + i73) {
                                    i15 = i62;
                                    break;
                                }
                                byte[] bArr7 = this.f12829i;
                                i15 = i62;
                                if (i83 >= bArr7.length || i83 >= i77) {
                                    break;
                                }
                                int i89 = this.f12821a[bArr7[i83] & 255];
                                if (i89 != 0) {
                                    i84 += (i89 >> 24) & 255;
                                    i85 += (i89 >> 16) & 255;
                                    i86 += (i89 >> 8) & 255;
                                    i87 += i89 & 255;
                                    i88++;
                                }
                                i83++;
                                i62 = i15;
                            }
                            int i90 = i80 + i73;
                            for (int i91 = i90; i91 < this.f12836p + i90; i91++) {
                                byte[] bArr8 = this.f12829i;
                                if (i91 >= bArr8.length || i91 >= i77) {
                                    break;
                                }
                                int i92 = this.f12821a[bArr8[i91] & 255];
                                if (i92 != 0) {
                                    i84 += (i92 >> 24) & 255;
                                    i85 += (i92 >> 16) & 255;
                                    i86 += (i92 >> 8) & 255;
                                    i87 += i92 & 255;
                                    i88++;
                                }
                            }
                            int i93 = i88 == 0 ? 0 : ((i84 / i88) << 24) | ((i85 / i88) << 16) | ((i86 / i88) << 8) | (i87 / i88);
                            if (i93 != 0) {
                                iArr3[i78] = i93;
                            } else if (z7 && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i73 += i56;
                            i78++;
                            i71 = i79;
                            i60 = i81;
                            i61 = i82;
                            i62 = i15;
                        }
                    }
                    i12 = i60;
                    i13 = i61;
                    i14 = i62;
                } else {
                    i11 = i59;
                    i12 = i60;
                    i13 = i61;
                    i14 = i62;
                    bool = bool2;
                }
                i63++;
                i57 = i6;
                i64 = i10;
                i58 = i58;
                i59 = i11;
                i60 = i12;
                i61 = i13;
                i62 = i14;
            }
            Boolean bool3 = bool;
            if (this.f12839s == null) {
                this.f12839s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
            }
        } else {
            int[] iArr5 = this.f12830j;
            int i94 = c3800a.f12798d;
            int i95 = c3800a.f12796b;
            int i96 = c3800a.f12797c;
            int i97 = c3800a.f12795a;
            boolean z11 = this.f12831k == 0;
            int i98 = this.f12838r;
            byte[] bArr9 = this.f12829i;
            int[] iArr6 = this.f12821a;
            byte b10 = -1;
            for (int i99 = 0; i99 < i94; i99++) {
                int i100 = (i99 + i95) * i98;
                int i101 = i100 + i97;
                int i102 = i101 + i96;
                int i103 = i100 + i98;
                if (i103 < i102) {
                    i102 = i103;
                }
                int i104 = c3800a.f12797c * i99;
                while (i101 < i102) {
                    int i105 = i94;
                    byte b11 = bArr9[i104];
                    int i106 = i95;
                    int i107 = b11 & 255;
                    if (i107 != b10) {
                        int i108 = iArr6[i107];
                        if (i108 != 0) {
                            iArr5[i101] = i108;
                        } else {
                            b10 = b11;
                        }
                    }
                    i104++;
                    i101++;
                    i94 = i105;
                    i95 = i106;
                }
            }
            Boolean bool4 = this.f12839s;
            this.f12839s = Boolean.valueOf((bool4 != null && bool4.booleanValue()) || (this.f12839s == null && z11 && b10 != -1));
        }
        if (this.f12834n && ((i16 = c3800a.f12801g) == 0 || i16 == 1)) {
            if (this.f12833m == null) {
                this.f12833m = m7577a();
            }
            Bitmap bitmap3 = this.f12833m;
            int i109 = this.f12838r;
            bitmap3.setPixels(iArr2, 0, i109, 0, 0, i109, this.f12837q);
        }
        Bitmap bitmapM7577a = m7577a();
        int i110 = this.f12838r;
        bitmapM7577a.setPixels(iArr2, 0, i110, 0, 0, i110, this.f12837q);
        return bitmapM7577a;
    }
}
