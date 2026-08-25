package p049e3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.media3.common.C0565C;
import com.alibaba.fastjson.asm.Opcodes;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.C1483i;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p186r3.AbstractC3597a;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3604h;
import p186r3.AbstractC3610n;
import p222u7.AbstractC3928d;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.EnumC3974a;
import p228v2.EnumC3982i;
import p228v2.InterfaceC3977d;
import p249x4.C4112e;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;

public final class C2398p {

    public static final C3980g f8365f = C3980g.m7966a(EnumC3974a.f13506c, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    public static final C3980g f8366g = new C3980g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, C3980g.f13510e);

    public static final C3980g f8367h;

    public static final C3980g f8368i;

    public static final Set f8369j;

    public static final C4112e f8370k;

    public static final ArrayDeque f8371l;

    public final InterfaceC4238a f8372a;

    public final DisplayMetrics f8373b;

    public final C4243f f8374c;

    public final ArrayList f8375d;

    public final C2404v f8376e = C2404v.m5436a();

    static {
        C2396n c2396n = C2396n.f8357b;
        Boolean bool = Boolean.FALSE;
        f8367h = C3980g.m7966a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f8368i = C3980g.m7966a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        f8369j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f8370k = new C4112e(8);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = AbstractC3610n.f12112a;
        f8371l = new ArrayDeque(0);
    }

    public C2398p(ArrayList arrayList, DisplayMetrics displayMetrics, InterfaceC4238a interfaceC4238a, C4243f c4243f) {
        this.f8375d = arrayList;
        AbstractC3602f.m7225c(displayMetrics, "Argument must not be null");
        this.f8373b = displayMetrics;
        AbstractC3602f.m7225c(interfaceC4238a, "Argument must not be null");
        this.f8372a = interfaceC4238a;
        AbstractC3602f.m7225c(c4243f, "Argument must not be null");
        this.f8374c = c4243f;
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m5428c(C0026b c0026b, BitmapFactory.Options options, InterfaceC2397o interfaceC2397o, InterfaceC4238a interfaceC4238a) {
        if (!options.inJustDecodeBounds) {
            interfaceC2397o.mo234k();
            switch (c0026b.f53a) {
                case 18:
                    C2405w c2405w = (C2405w) ((C1483i) c0026b.f54b).f4484b;
                    synchronized (c2405w) {
                        c2405w.f8391c = c2405w.f8389a.length;
                        break;
                    }
                    break;
            }
        }
        int i6 = options.outWidth;
        int i10 = options.outHeight;
        String str = options.outMimeType;
        Lock lock = AbstractC2408z.f8398b;
        lock.lock();
        try {
            try {
                Bitmap bitmapM131i = c0026b.m131i(options);
                lock.unlock();
                return bitmapM131i;
            } catch (IllegalArgumentException e5) {
                StringBuilder sbM28v = AbstractC0004e.m28v("Exception decoding bitmap, outWidth: ", i6, ", outHeight: ", i10, ", outMimeType: ");
                sbM28v.append(str);
                sbM28v.append(", inBitmap: ");
                sbM28v.append(m5429d(options.inBitmap));
                IOException iOException = new IOException(sbM28v.toString(), e5);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOException);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOException;
                }
                try {
                    interfaceC4238a.mo5434f(bitmap);
                    options.inBitmap = null;
                    Bitmap bitmapM5428c = m5428c(c0026b, options, interfaceC2397o, interfaceC4238a);
                    AbstractC2408z.f8398b.unlock();
                    return bitmapM5428c;
                } catch (IOException unused) {
                    throw iOException;
                }
            }
        } catch (Throwable th) {
            AbstractC2408z.f8398b.unlock();
            throw th;
        }
    }

    public static String m5429d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void m5430e(BitmapFactory.Options options) {
        m5431f(options);
        ArrayDeque arrayDeque = f8371l;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void m5431f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final C2383d m5432a(C0026b c0026b, int i6, int i10, C3981h c3981h, InterfaceC2397o interfaceC2397o) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f8374c.m8287d(C0565C.DEFAULT_BUFFER_SEGMENT_SIZE, byte[].class);
        synchronized (C2398p.class) {
            ArrayDeque arrayDeque = f8371l;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                m5431f(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        EnumC3974a enumC3974a = (EnumC3974a) c3981h.m7967c(f8365f);
        EnumC3982i enumC3982i = (EnumC3982i) c3981h.m7967c(f8366g);
        C2396n c2396n = (C2396n) c3981h.m7967c(C2396n.f8362g);
        boolean zBooleanValue = ((Boolean) c3981h.m7967c(f8367h)).booleanValue();
        C3980g c3980g = f8368i;
        try {
            return C2383d.m5410b(m5433b(c0026b, options2, c2396n, enumC3974a, enumC3982i, c3981h.m7967c(c3980g) != null && ((Boolean) c3981h.m7967c(c3980g)).booleanValue(), i6, i10, zBooleanValue, interfaceC2397o), this.f8372a);
        } finally {
            m5430e(options2);
            this.f8374c.m8291h(bArr);
        }
    }

    public final Bitmap m5433b(C0026b c0026b, BitmapFactory.Options options, C2396n c2396n, EnumC3974a enumC3974a, EnumC3982i enumC3982i, boolean z7, int i6, int i10, boolean z10, InterfaceC2397o interfaceC2397o) throws Throwable {
        String str;
        boolean z11;
        int iMo5424c;
        int iM7850n;
        int i11;
        boolean z12;
        String str2;
        int i12;
        int i13;
        boolean zM5438c;
        boolean zHasAlpha;
        Bitmap.Config config;
        int i14;
        int i15;
        boolean z13;
        float f;
        int i16;
        int i17;
        int iRound;
        int iRound2;
        int i18;
        int i19;
        Bitmap bitmapM5428c;
        Matrix matrix;
        Bitmap.Config config2;
        Bitmap bitmapMo6925e;
        boolean z14;
        ColorSpace.Named named;
        Bitmap.Config config3;
        int i20;
        int i21;
        int iMax;
        int iFloor;
        int iFloor2;
        double dM5427b;
        double d;
        int i22;
        double d10;
        int i23;
        C2405w c2405w;
        int i24 = AbstractC3604h.f12101b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        options.inJustDecodeBounds = true;
        InterfaceC4238a interfaceC4238a = this.f8372a;
        m5428c(c0026b, options, interfaceC2397o, interfaceC4238a);
        options.inJustDecodeBounds = false;
        int[] iArr = {options.outWidth, options.outHeight};
        int i25 = iArr[0];
        int i26 = iArr[1];
        String str3 = options.outMimeType;
        boolean z15 = (i25 == -1 || i26 == -1) ? false : z7;
        switch (c0026b.f53a) {
            case 17:
                str = str3;
                z11 = z15;
                ByteBuffer byteBufferM7219c = AbstractC3597a.m7219c((ByteBuffer) c0026b.f54b);
                C4243f c4243f = (C4243f) c0026b.f56d;
                if (byteBufferM7219c == null) {
                    iMo5424c = -1;
                } else {
                    ArrayList arrayList = (ArrayList) c0026b.f55c;
                    int size = arrayList.size();
                    int i27 = 0;
                    while (true) {
                        if (i27 < size) {
                            try {
                                iMo5424c = ((InterfaceC3977d) arrayList.get(i27)).mo5424c(byteBufferM7219c, c4243f);
                                if (iMo5424c == -1) {
                                    i27++;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        } else {
                            iMo5424c = -1;
                        }
                    }
                }
                iM7850n = iMo5424c;
                break;
            case 18:
                str = str3;
                z11 = z15;
                C2405w c2405w2 = (C2405w) ((C1483i) c0026b.f54b).f4484b;
                c2405w2.reset();
                iM7850n = AbstractC3928d.m7850n((ArrayList) c0026b.f56d, c2405w2, (C4243f) c0026b.f55c);
                break;
            default:
                C1483i c1483i = (C1483i) c0026b.f56d;
                C4243f c4243f2 = (C4243f) c0026b.f54b;
                str = str3;
                ArrayList arrayList2 = (ArrayList) c0026b.f55c;
                int size2 = arrayList2.size();
                int i28 = 0;
                while (true) {
                    if (i28 >= size2) {
                        z11 = z15;
                        iM7850n = -1;
                    } else {
                        int i29 = size2;
                        InterfaceC3977d interfaceC3977d = (InterfaceC3977d) arrayList2.get(i28);
                        ArrayList arrayList3 = arrayList2;
                        try {
                            z11 = z15;
                            C2405w c2405w3 = new C2405w(new FileInputStream(c1483i.m3554d().getFileDescriptor()), c4243f2);
                            try {
                                iM7850n = interfaceC3977d.mo5423b(c2405w3, c4243f2);
                                c2405w3.m5441b();
                                c1483i.m3554d();
                                if (iM7850n == -1) {
                                    i28++;
                                    size2 = i29;
                                    arrayList2 = arrayList3;
                                    z15 = z11;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                c2405w = c2405w3;
                                if (c2405w != null) {
                                    c2405w.m5441b();
                                }
                                c1483i.m3554d();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c2405w = null;
                        }
                    }
                    break;
                }
                break;
        }
        switch (iM7850n) {
            case 3:
            case 4:
                i11 = Opcodes.GETFIELD;
                break;
            case 5:
            case 6:
                i11 = 90;
                break;
            case 7:
            case 8:
                i11 = 270;
                break;
            default:
                i11 = 0;
                break;
        }
        switch (iM7850n) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z12 = true;
                break;
            default:
                z12 = false;
                break;
        }
        int i30 = i6 == Integer.MIN_VALUE ? (i11 == 90 || i11 == 270) ? i26 : i25 : i6;
        int i31 = i10 == Integer.MIN_VALUE ? (i11 == 90 || i11 == 270) ? i25 : i26 : i10;
        ImageHeaderParser$ImageType imageHeaderParser$ImageTypeM144x = c0026b.m144x();
        int i32 = iM7850n;
        String str4 = ", density: ";
        String str5 = "x";
        boolean z16 = z12;
        if (i25 > 0) {
            if (i26 <= 0) {
                i13 = 3;
                str2 = ", target density: ";
                i12 = i30;
            } else {
                if (i11 == 90 || i11 == 270) {
                    i20 = i26;
                    i21 = i25;
                } else {
                    i21 = i26;
                    i20 = i25;
                }
                float fM5427b = c2396n.m5427b(i20, i21, i30, i31);
                if (fM5427b <= 0.0f) {
                    throw new IllegalArgumentException("Cannot scale with factor: " + fM5427b + " from: " + c2396n + ", source: [" + i25 + "x" + i26 + "], target: [" + i30 + "x" + i31 + "]");
                }
                int i33 = i11;
                int iM5426a = c2396n.m5426a(i20, i21, i30, i31);
                if (iM5426a == 0) {
                    throw new IllegalArgumentException("Cannot round with null rounding");
                }
                float f3 = i20;
                i31 = i31;
                i12 = i30;
                float f4 = i21;
                int i34 = i20 / ((int) (((double) (fM5427b * f3)) + 0.5d));
                int i35 = i21 / ((int) (((double) (fM5427b * f4)) + 0.5d));
                int iMax2 = iM5426a == 1 ? Math.max(i34, i35) : Math.min(i34, i35);
                int i36 = Build.VERSION.SDK_INT;
                if (i36 > 23 || !f8369j.contains(options.outMimeType)) {
                    iMax = Math.max(1, Integer.highestOneBit(iMax2));
                    if (iM5426a == 1 && iMax < 1.0f / fM5427b) {
                        iMax <<= 1;
                    }
                } else {
                    iMax = 1;
                }
                options.inSampleSize = iMax;
                if (imageHeaderParser$ImageTypeM144x == ImageHeaderParser$ImageType.JPEG) {
                    float fMin = Math.min(iMax, 8);
                    iFloor = (int) Math.ceil(f3 / fMin);
                    iFloor2 = (int) Math.ceil(f4 / fMin);
                    int i37 = iMax / 8;
                    if (i37 > 0) {
                        iFloor /= i37;
                        iFloor2 /= i37;
                    }
                } else {
                    if (imageHeaderParser$ImageTypeM144x == ImageHeaderParser$ImageType.PNG || imageHeaderParser$ImageTypeM144x == ImageHeaderParser$ImageType.PNG_A) {
                        interfaceC4238a = interfaceC4238a;
                        float f5 = iMax;
                        iFloor = (int) Math.floor(f3 / f5);
                        iFloor2 = (int) Math.floor(f4 / f5);
                    } else if (imageHeaderParser$ImageTypeM144x.isWebp()) {
                        if (i36 >= 24) {
                            float f10 = iMax;
                            iFloor = Math.round(f3 / f10);
                            iFloor2 = Math.round(f4 / f10);
                        } else {
                            float f11 = iMax;
                            iFloor = (int) Math.floor(f3 / f11);
                            iFloor2 = (int) Math.floor(f4 / f11);
                        }
                    } else if (i20 % iMax == 0 && i21 % iMax == 0) {
                        iFloor = i20 / iMax;
                        iFloor2 = i21 / iMax;
                    } else {
                        options.inJustDecodeBounds = true;
                        interfaceC4238a = interfaceC4238a;
                        m5428c(c0026b, options, interfaceC2397o, interfaceC4238a);
                        options.inJustDecodeBounds = false;
                        int[] iArr2 = {options.outWidth, options.outHeight};
                        int i38 = iArr2[0];
                        iFloor2 = iArr2[1];
                        iFloor = i38;
                    }
                    dM5427b = c2396n.m5427b(iFloor, iFloor2, i12, i31);
                    if (dM5427b <= 1.0d) {
                        d = dM5427b;
                    } else {
                        d = 1.0d / dM5427b;
                    }
                    int iRound3 = (int) Math.round(d * 2.147483647E9d);
                    i22 = iMax;
                    int i39 = (int) ((((double) iRound3) * dM5427b) + 0.5d);
                    options.inTargetDensity = (int) (((dM5427b / ((double) (i39 / iRound3))) * ((double) i39)) + 0.5d);
                    if (dM5427b <= 1.0d) {
                        d10 = dM5427b;
                    } else {
                        d10 = 1.0d / dM5427b;
                    }
                    int iRound4 = (int) Math.round(d10 * 2.147483647E9d);
                    options.inDensity = iRound4;
                    i23 = options.inTargetDensity;
                    if (i23 > 0 || iRound4 <= 0 || i23 == iRound4) {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    } else {
                        options.inScaled = true;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        str5 = "x";
                        i26 = i26;
                        i25 = i25;
                        StringBuilder sbM28v = AbstractC0004e.m28v("Calculate scaling, source: [", i25, str5, i26, "], degreesToRotate: ");
                        sbM28v.append(i33);
                        sbM28v.append(", target: [");
                        sbM28v.append(i12);
                        sbM28v.append(str5);
                        sbM28v.append(i31);
                        sbM28v.append("], power of two scaled: [");
                        sbM28v.append(iFloor);
                        sbM28v.append(str5);
                        sbM28v.append(iFloor2);
                        sbM28v.append("], exact scale factor: ");
                        sbM28v.append(fM5427b);
                        sbM28v.append(", power of 2 sample size: ");
                        sbM28v.append(i22);
                        sbM28v.append(", adjusted scale factor: ");
                        sbM28v.append(dM5427b);
                        str2 = ", target density: ";
                        sbM28v.append(str2);
                        sbM28v.append(options.inTargetDensity);
                        str4 = ", density: ";
                        sbM28v.append(str4);
                        sbM28v.append(options.inDensity);
                        Log.v("Downsampler", sbM28v.toString());
                    } else {
                        str4 = str4;
                        str2 = r4;
                        str5 = "x";
                        i26 = i26;
                        i25 = i25;
                    }
                }
                interfaceC4238a = interfaceC4238a;
                dM5427b = c2396n.m5427b(iFloor, iFloor2, i12, i31);
                if (dM5427b <= 1.0d) {
                    d = dM5427b;
                } else {
                    d = 1.0d / dM5427b;
                }
                int iRound5 = (int) Math.round(d * 2.147483647E9d);
                i22 = iMax;
                int i310 = (int) ((((double) iRound5) * dM5427b) + 0.5d);
                options.inTargetDensity = (int) (((dM5427b / ((double) (i310 / iRound5))) * ((double) i310)) + 0.5d);
                if (dM5427b <= 1.0d) {
                    d10 = dM5427b;
                } else {
                    d10 = 1.0d / dM5427b;
                }
                int iRound6 = (int) Math.round(d10 * 2.147483647E9d);
                options.inDensity = iRound6;
                i23 = options.inTargetDensity;
                if (i23 > 0) {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    str5 = "x";
                    i26 = i26;
                    i25 = i25;
                    StringBuilder sbM28v2 = AbstractC0004e.m28v("Calculate scaling, source: [", i25, str5, i26, "], degreesToRotate: ");
                    sbM28v2.append(i33);
                    sbM28v2.append(", target: [");
                    sbM28v2.append(i12);
                    sbM28v2.append(str5);
                    sbM28v2.append(i31);
                    sbM28v2.append("], power of two scaled: [");
                    sbM28v2.append(iFloor);
                    sbM28v2.append(str5);
                    sbM28v2.append(iFloor2);
                    sbM28v2.append("], exact scale factor: ");
                    sbM28v2.append(fM5427b);
                    sbM28v2.append(", power of 2 sample size: ");
                    sbM28v2.append(i22);
                    sbM28v2.append(", adjusted scale factor: ");
                    sbM28v2.append(dM5427b);
                    str2 = ", target density: ";
                    sbM28v2.append(str2);
                    sbM28v2.append(options.inTargetDensity);
                    str4 = ", density: ";
                    sbM28v2.append(str4);
                    sbM28v2.append(options.inDensity);
                    Log.v("Downsampler", sbM28v2.toString());
                } else {
                    str4 = str4;
                    str2 = r4;
                    str5 = "x";
                    i26 = i26;
                    i25 = i25;
                }
            }
            zM5438c = this.f8376e.m5438c(i12, i31, z11, z16);
            if (zM5438c) {
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                options.inMutable = false;
            }
            if (!zM5438c) {
                if (enumC3974a != EnumC3974a.f13504a) {
                    try {
                        zHasAlpha = c0026b.m144x().hasAlpha();
                    } catch (IOException e5) {
                        if (Log.isLoggable("Downsampler", 3)) {
                            Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + enumC3974a, e5);
                        }
                        zHasAlpha = false;
                    }
                    if (zHasAlpha) {
                        config = Bitmap.Config.ARGB_8888;
                    } else {
                        config = Bitmap.Config.RGB_565;
                    }
                    options.inPreferredConfig = config;
                    if (config == Bitmap.Config.RGB_565) {
                        options.inDither = true;
                    }
                } else {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
            }
            i14 = Build.VERSION.SDK_INT;
            if (i25 >= 0 || i26 < 0 || !z10) {
                i15 = options.inTargetDensity;
                if (i15 > 0 || (i19 = options.inDensity) <= 0 || i15 == i19) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    f = i15 / options.inDensity;
                } else {
                    f = 1.0f;
                }
                i16 = options.inSampleSize;
                float f12 = i16;
                i17 = i25;
                int iCeil = (int) Math.ceil(i25 / f12);
                int iCeil2 = (int) Math.ceil(i26 / f12);
                iRound = Math.round(iCeil * f);
                iRound2 = Math.round(iCeil2 * f);
                if (Log.isLoggable("Downsampler", 2)) {
                    StringBuilder sbM28v3 = AbstractC0004e.m28v("Calculated target [", iRound, str5, iRound2, "] for source [");
                    i18 = i17;
                    sbM28v3.append(i18);
                    sbM28v3.append(str5);
                    sbM28v3.append(i26);
                    sbM28v3.append("], sampleSize: ");
                    sbM28v3.append(i16);
                    sbM28v3.append(", targetDensity: ");
                    sbM28v3.append(options.inTargetDensity);
                    sbM28v3.append(str4);
                    sbM28v3.append(options.inDensity);
                    sbM28v3.append(", density multiplier: ");
                    sbM28v3.append(f);
                    Log.v("Downsampler", sbM28v3.toString());
                } else {
                    i18 = i17;
                }
                i12 = iRound;
            } else {
                iRound2 = i31;
                i18 = i25;
            }
            if (i12 > 0 && iRound2 > 0) {
                if (i14 >= 26) {
                    config3 = options.inPreferredConfig != Bitmap.Config.HARDWARE ? options.outConfig : null;
                }
                if (config3 == null) {
                    config3 = options.inPreferredConfig;
                }
                options.inBitmap = interfaceC4238a.mo6924d(i12, iRound2, config3);
            }
            if (enumC3982i != null) {
                if (i14 >= 28) {
                    if (enumC3982i == EnumC3982i.f13516a || options.outColorSpace == null || !options.outColorSpace.isWideGamut()) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14) {
                        named = ColorSpace.Named.DISPLAY_P3;
                    } else {
                        named = ColorSpace.Named.SRGB;
                    }
                    options.inPreferredColorSpace = ColorSpace.get(named);
                } else if (i14 >= 26) {
                    options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                }
            }
            bitmapM5428c = m5428c(c0026b, options, interfaceC2397o, interfaceC4238a);
            interfaceC2397o.mo230d(bitmapM5428c, interfaceC4238a);
            if (Log.isLoggable("Downsampler", 2)) {
                Log.v("Downsampler", "Decoded " + m5429d(bitmapM5428c) + " from [" + i18 + str5 + i26 + "] " + str + " with inBitmap " + m5429d(options.inBitmap) + " for [" + i6 + str5 + i10 + "], sample size: " + options.inSampleSize + str4 + options.inDensity + str2 + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
            }
            if (bitmapM5428c != null) {
                return null;
            }
            bitmapM5428c.setDensity(this.f8373b.densityDpi);
            switch (i32) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    matrix = new Matrix();
                    switch (i32) {
                        case 2:
                            matrix.setScale(-1.0f, 1.0f);
                            break;
                        case 3:
                            matrix.setRotate(180.0f);
                            break;
                        case 4:
                            matrix.setRotate(180.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 5:
                            matrix.setRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 6:
                            matrix.setRotate(90.0f);
                            break;
                        case 7:
                            matrix.setRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 8:
                            matrix.setRotate(-90.0f);
                            break;
                    }
                    RectF rectF = new RectF(0.0f, 0.0f, bitmapM5428c.getWidth(), bitmapM5428c.getHeight());
                    matrix.mapRect(rectF);
                    int iRound7 = Math.round(rectF.width());
                    int iRound8 = Math.round(rectF.height());
                    if (bitmapM5428c.getConfig() != null) {
                        config2 = bitmapM5428c.getConfig();
                    } else {
                        config2 = Bitmap.Config.ARGB_8888;
                    }
                    bitmapMo6925e = interfaceC4238a.mo6925e(iRound7, iRound8, config2);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    bitmapMo6925e.setHasAlpha(bitmapM5428c.hasAlpha());
                    AbstractC2408z.m5442a(bitmapM5428c, bitmapMo6925e, matrix);
                    break;
                default:
                    bitmapMo6925e = bitmapM5428c;
                    break;
            }
            if (!bitmapM5428c.equals(bitmapMo6925e)) {
                interfaceC4238a.mo5434f(bitmapM5428c);
            }
            return bitmapMo6925e;
        }
        str2 = ", target density: ";
        i12 = i30;
        i13 = 3;
        if (Log.isLoggable("Downsampler", i13)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeM144x + " with target [" + i12 + str5 + i31 + "]");
        }
        zM5438c = this.f8376e.m5438c(i12, i31, z11, z16);
        if (zM5438c) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        if (!zM5438c) {
            if (enumC3974a != EnumC3974a.f13504a) {
                zHasAlpha = c0026b.m144x().hasAlpha();
                if (zHasAlpha) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                }
            } else {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
        }
        i14 = Build.VERSION.SDK_INT;
        if (i25 >= 0) {
            i15 = options.inTargetDensity;
            if (i15 > 0) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (z13) {
                f = i15 / options.inDensity;
            } else {
                f = 1.0f;
            }
            i16 = options.inSampleSize;
            float f13 = i16;
            i17 = i25;
            int iCeil3 = (int) Math.ceil(i25 / f13);
            int iCeil4 = (int) Math.ceil(i26 / f13);
            iRound = Math.round(iCeil3 * f);
            iRound2 = Math.round(iCeil4 * f);
            if (Log.isLoggable("Downsampler", 2)) {
                StringBuilder sbM28v4 = AbstractC0004e.m28v("Calculated target [", iRound, str5, iRound2, "] for source [");
                i18 = i17;
                sbM28v4.append(i18);
                sbM28v4.append(str5);
                sbM28v4.append(i26);
                sbM28v4.append("], sampleSize: ");
                sbM28v4.append(i16);
                sbM28v4.append(", targetDensity: ");
                sbM28v4.append(options.inTargetDensity);
                sbM28v4.append(str4);
                sbM28v4.append(options.inDensity);
                sbM28v4.append(", density multiplier: ");
                sbM28v4.append(f);
                Log.v("Downsampler", sbM28v4.toString());
            } else {
                i18 = i17;
            }
            i12 = iRound;
        } else {
            i15 = options.inTargetDensity;
            if (i15 > 0) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (z13) {
                f = i15 / options.inDensity;
            } else {
                f = 1.0f;
            }
            i16 = options.inSampleSize;
            float f14 = i16;
            i17 = i25;
            int iCeil5 = (int) Math.ceil(i25 / f14);
            int iCeil6 = (int) Math.ceil(i26 / f14);
            iRound = Math.round(iCeil5 * f);
            iRound2 = Math.round(iCeil6 * f);
            if (Log.isLoggable("Downsampler", 2)) {
                StringBuilder sbM28v5 = AbstractC0004e.m28v("Calculated target [", iRound, str5, iRound2, "] for source [");
                i18 = i17;
                sbM28v5.append(i18);
                sbM28v5.append(str5);
                sbM28v5.append(i26);
                sbM28v5.append("], sampleSize: ");
                sbM28v5.append(i16);
                sbM28v5.append(", targetDensity: ");
                sbM28v5.append(options.inTargetDensity);
                sbM28v5.append(str4);
                sbM28v5.append(options.inDensity);
                sbM28v5.append(", density multiplier: ");
                sbM28v5.append(f);
                Log.v("Downsampler", sbM28v5.toString());
            } else {
                i18 = i17;
            }
            i12 = iRound;
        }
        if (i12 > 0) {
            if (i14 >= 26) {
                if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
                }
            }
            if (config3 == null) {
                config3 = options.inPreferredConfig;
            }
            options.inBitmap = interfaceC4238a.mo6924d(i12, iRound2, config3);
        }
        if (enumC3982i != null) {
            if (i14 >= 28) {
                if (enumC3982i == EnumC3982i.f13516a) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                if (z14) {
                    named = ColorSpace.Named.DISPLAY_P3;
                } else {
                    named = ColorSpace.Named.SRGB;
                }
                options.inPreferredColorSpace = ColorSpace.get(named);
            } else if (i14 >= 26) {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        bitmapM5428c = m5428c(c0026b, options, interfaceC2397o, interfaceC4238a);
        interfaceC2397o.mo230d(bitmapM5428c, interfaceC4238a);
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Decoded " + m5429d(bitmapM5428c) + " from [" + i18 + str5 + i26 + "] " + str + " with inBitmap " + m5429d(options.inBitmap) + " for [" + i6 + str5 + i10 + "], sample size: " + options.inSampleSize + str4 + options.inDensity + str2 + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
        }
        if (bitmapM5428c != null) {
            return null;
        }
        bitmapM5428c.setDensity(this.f8373b.densityDpi);
        switch (i32) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                matrix = new Matrix();
                switch (i32) {
                    case 2:
                        matrix.setScale(-1.0f, 1.0f);
                        break;
                    case 3:
                        matrix.setRotate(180.0f);
                        break;
                    case 4:
                        matrix.setRotate(180.0f);
                        matrix.postScale(-1.0f, 1.0f);
                        break;
                    case 5:
                        matrix.setRotate(90.0f);
                        matrix.postScale(-1.0f, 1.0f);
                        break;
                    case 6:
                        matrix.setRotate(90.0f);
                        break;
                    case 7:
                        matrix.setRotate(-90.0f);
                        matrix.postScale(-1.0f, 1.0f);
                        break;
                    case 8:
                        matrix.setRotate(-90.0f);
                        break;
                }
                RectF rectF2 = new RectF(0.0f, 0.0f, bitmapM5428c.getWidth(), bitmapM5428c.getHeight());
                matrix.mapRect(rectF2);
                int iRound9 = Math.round(rectF2.width());
                int iRound10 = Math.round(rectF2.height());
                if (bitmapM5428c.getConfig() != null) {
                    config2 = bitmapM5428c.getConfig();
                } else {
                    config2 = Bitmap.Config.ARGB_8888;
                }
                bitmapMo6925e = interfaceC4238a.mo6925e(iRound9, iRound10, config2);
                matrix.postTranslate(-rectF2.left, -rectF2.top);
                bitmapMo6925e.setHasAlpha(bitmapM5428c.hasAlpha());
                AbstractC2408z.m5442a(bitmapM5428c, bitmapMo6925e, matrix);
                break;
            default:
                bitmapMo6925e = bitmapM5428c;
                break;
        }
        if (!bitmapM5428c.equals(bitmapMo6925e)) {
            interfaceC4238a.mo5434f(bitmapM5428c);
        }
        return bitmapMo6925e;
    }
}
