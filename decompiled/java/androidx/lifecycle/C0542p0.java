package androidx.lifecycle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.C0423q;
import androidx.media3.common.MimeTypes;
import com.alibaba.fastjson.asm.Opcodes;
import java.util.LinkedHashSet;
import okio.BufferedSource;
import okio.Okio;
import p003a2.AbstractC0032a;
import p036d2.AbstractC2142k;
import p036d2.AbstractC2143l;
import p036d2.AbstractC2145n;
import p036d2.C2133b;
import p036d2.C2136e;
import p036d2.C2138g;
import p036d2.C2139h;
import p036d2.C2140i;
import p036d2.C2146o;
import p047e1.C2363g;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p130m2.C3065m;
import p140n2.C3183h;
import p140n2.EnumC3182g;
import p143n5.AbstractC3198d;
import p185r2.AbstractC3587f;
import p187r4.AbstractC3612b;

public final class C0542p0 extends AbstractC2797j implements InterfaceC2713a {

    public final int f2517a;

    public final Object f2518b;

    public C0542p0(int i6, Object obj) {
        super(0);
        this.f2517a = i6;
        this.f2518b = obj;
    }

    @Override
    public final Object invoke() throws Exception {
        C2139h c2139h;
        BufferedSource bufferedSource;
        Context context;
        int i6;
        boolean z7;
        int i10;
        int i11;
        int iMin;
        double dMax;
        Bitmap bitmapDecodeStream;
        Exception exc;
        Matrix matrix;
        float width;
        float height;
        RectF rectF;
        float f;
        Bitmap.Config config;
        Bitmap bitmapCreateBitmap;
        ColorSpace colorSpace;
        int i12;
        Object obj = this.f2518b;
        switch (this.f2517a) {
            case 0:
                return AbstractC0540o0.m1507e((ComponentActivity) obj);
            default:
                BitmapFactory.Options options = new BitmapFactory.Options();
                C2136e c2136e = (C2136e) obj;
                AbstractC2145n abstractC2145n = c2136e.f7756a;
                C2133b c2133b = new C2133b(abstractC2145n.mo5085b());
                BufferedSource bufferedSourceBuffer = Okio.buffer(c2133b);
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(bufferedSourceBuffer.peek().inputStream(), null, options);
                Exception exc2 = c2133b.f7748a;
                if (exc2 != null) {
                    throw exc2;
                }
                options.inJustDecodeBounds = false;
                Paint paint = AbstractC2142k.f7775a;
                String str = options.outMimeType;
                LinkedHashSet linkedHashSet = AbstractC2143l.f7776a;
                int iOrdinal = c2136e.f7759d.ordinal();
                if (iOrdinal == 0) {
                    c2139h = C2139h.f7767c;
                } else {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new C0423q(13);
                        }
                    } else if (str == null || !AbstractC2143l.f7776a.contains(str)) {
                        c2139h = C2139h.f7767c;
                    }
                    C2363g c2363g = new C2363g(new C2140i(bufferedSourceBuffer.peek().inputStream()));
                    int iM5352c = c2363g.m5352c();
                    boolean z10 = iM5352c == 2 || iM5352c == 7 || iM5352c == 4 || iM5352c == 5;
                    switch (c2363g.m5352c()) {
                        case 3:
                        case 4:
                            i12 = Opcodes.GETFIELD;
                            break;
                        case 5:
                        case 8:
                            i12 = 270;
                            break;
                        case 6:
                        case 7:
                            i12 = 90;
                            break;
                        default:
                            i12 = 0;
                            break;
                    }
                    c2139h = new C2139h(z10, i12);
                }
                Exception exc3 = c2133b.f7748a;
                if (exc3 != null) {
                    throw exc3;
                }
                options.inMutable = false;
                int i13 = Build.VERSION.SDK_INT;
                C3065m c3065m = c2136e.f7757b;
                if (i13 >= 26 && (colorSpace = c3065m.f10498c) != null) {
                    options.inPreferredColorSpace = colorSpace;
                }
                options.inPremultiplied = c3065m.f10503h;
                int i14 = c2139h.f7769b;
                Bitmap.Config config2 = c3065m.f10497b;
                boolean z11 = c2139h.f7768a;
                if ((z11 || i14 > 0) && (config2 == null || AbstractC3198d.m6426A(config2))) {
                    config2 = Bitmap.Config.ARGB_8888;
                }
                if (c3065m.f10502g && config2 == Bitmap.Config.ARGB_8888 && AbstractC2796i.m5780a(options.outMimeType, MimeTypes.IMAGE_JPEG)) {
                    config2 = Bitmap.Config.RGB_565;
                }
                if (i13 >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && config2 != Bitmap.Config.HARDWARE) {
                    config2 = Bitmap.Config.RGBA_F16;
                }
                options.inPreferredConfig = config2;
                AbstractC3198d abstractC3198dMo5084a = abstractC2145n.mo5084a();
                boolean z12 = abstractC3198dMo5084a instanceof C2146o;
                Context context2 = c3065m.f10496a;
                C3183h c3183h = c3065m.f10499d;
                try {
                    if (!z12 || !AbstractC2796i.m5780a(c3183h, C3183h.f10677c)) {
                        int i15 = options.outWidth;
                        if (i15 <= 0 || (i10 = options.outHeight) <= 0) {
                            bufferedSource = bufferedSourceBuffer;
                            context = context2;
                            i6 = i14;
                            options.inSampleSize = 1;
                            z7 = false;
                            options.inScaled = false;
                        } else {
                            int i16 = (i14 == 90 || i14 == 270) ? i10 : i15;
                            if (i14 != 90 && i14 != 270) {
                                i15 = i10;
                            }
                            C3183h c3183h2 = C3183h.f10677c;
                            boolean zM5780a = AbstractC2796i.m5780a(c3183h, c3183h2);
                            EnumC3182g enumC3182g = c3065m.f10500e;
                            int iM7212e = zM5780a ? i16 : AbstractC3587f.m7212e(c3183h.f10678a, enumC3182g);
                            int iM7212e2 = AbstractC2796i.m5780a(c3183h, c3183h2) ? i15 : AbstractC3587f.m7212e(c3183h.f10679b, enumC3182g);
                            int iHighestOneBit = Integer.highestOneBit(i16 / iM7212e);
                            int iHighestOneBit2 = Integer.highestOneBit(i15 / iM7212e2);
                            int iOrdinal2 = enumC3182g.ordinal();
                            if (iOrdinal2 != 0) {
                                i11 = 1;
                                if (iOrdinal2 != 1) {
                                    throw new C0423q(13);
                                }
                                iMin = Math.max(iHighestOneBit, iHighestOneBit2);
                            } else {
                                i11 = 1;
                                iMin = Math.min(iHighestOneBit, iHighestOneBit2);
                            }
                            if (iMin < i11) {
                                iMin = 1;
                            }
                            options.inSampleSize = iMin;
                            double d = iMin;
                            bufferedSource = bufferedSourceBuffer;
                            context = context2;
                            double d10 = ((double) i15) / d;
                            i6 = i14;
                            double d11 = ((double) iM7212e) / (((double) i16) / d);
                            double d12 = ((double) iM7212e2) / d10;
                            int iOrdinal3 = enumC3182g.ordinal();
                            if (iOrdinal3 == 0) {
                                dMax = Math.max(d11, d12);
                            } else {
                                if (iOrdinal3 != 1) {
                                    throw new C0423q(13);
                                }
                                dMax = Math.min(d11, d12);
                            }
                            if (c3065m.f10501f && dMax > 1.0d) {
                                dMax = 1.0d;
                            }
                            boolean z13 = dMax == 1.0d;
                            options.inScaled = !z13;
                            if (!z13) {
                                if (dMax > 1.0d) {
                                    options.inDensity = AbstractC3612b.m7254J(((double) Integer.MAX_VALUE) / dMax);
                                    options.inTargetDensity = Integer.MAX_VALUE;
                                } else {
                                    options.inDensity = Integer.MAX_VALUE;
                                    options.inTargetDensity = AbstractC3612b.m7254J(((double) Integer.MAX_VALUE) * dMax);
                                }
                            }
                        }
                        bitmapDecodeStream = BitmapFactory.decodeStream(bufferedSource.inputStream(), null, options);
                        AbstractC0032a.m164r(bufferedSource, null);
                        exc = c2133b.f7748a;
                        if (exc == null) {
                            throw exc;
                        }
                        if (bitmapDecodeStream != null) {
                            throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                        }
                        bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                        if (z11 || i6 > 0) {
                            matrix = new Matrix();
                            width = bitmapDecodeStream.getWidth() / 2.0f;
                            height = bitmapDecodeStream.getHeight() / 2.0f;
                            if (z11) {
                                matrix.postScale(-1.0f, 1.0f, width, height);
                            }
                            if (i6 > 0) {
                                matrix.postRotate(i6, width, height);
                            }
                            rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                            matrix.mapRect(rectF);
                            f = rectF.left;
                            if (f == 0.0f || rectF.top != 0.0f) {
                                matrix.postTranslate(-f, -rectF.top);
                            }
                            if (i6 != 90 || i6 == 270) {
                                int height2 = bitmapDecodeStream.getHeight();
                                int width2 = bitmapDecodeStream.getWidth();
                                config = bitmapDecodeStream.getConfig();
                                if (config == null) {
                                    config = Bitmap.Config.ARGB_8888;
                                }
                                bitmapCreateBitmap = Bitmap.createBitmap(height2, width2, config);
                            } else {
                                int width3 = bitmapDecodeStream.getWidth();
                                int height3 = bitmapDecodeStream.getHeight();
                                Bitmap.Config config3 = bitmapDecodeStream.getConfig();
                                if (config3 == null) {
                                    config3 = Bitmap.Config.ARGB_8888;
                                }
                                bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, config3);
                            }
                            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, AbstractC2142k.f7775a);
                            bitmapDecodeStream.recycle();
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                        if (options.inSampleSize <= 1 || options.inScaled) {
                            z7 = true;
                        }
                        return new C2138g(bitmapDrawable, z7);
                    }
                    options.inSampleSize = 1;
                    options.inScaled = true;
                    options.inDensity = ((C2146o) abstractC3198dMo5084a).f7783g;
                    options.inTargetDensity = context2.getResources().getDisplayMetrics().densityDpi;
                    bufferedSource = bufferedSourceBuffer;
                    context = context2;
                    i6 = i14;
                    bitmapDecodeStream = BitmapFactory.decodeStream(bufferedSource.inputStream(), null, options);
                    AbstractC0032a.m164r(bufferedSource, null);
                    exc = c2133b.f7748a;
                    if (exc == null) {
                        throw exc;
                    }
                    if (bitmapDecodeStream != null) {
                        throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                    }
                    bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                    if (z11) {
                        matrix = new Matrix();
                        width = bitmapDecodeStream.getWidth() / 2.0f;
                        height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z11) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i6 > 0) {
                            matrix.postRotate(i6, width, height);
                        }
                        rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF);
                        f = rectF.left;
                        if (f == 0.0f) {
                            matrix.postTranslate(-f, -rectF.top);
                        } else {
                            matrix.postTranslate(-f, -rectF.top);
                        }
                        if (i6 != 90) {
                            int height4 = bitmapDecodeStream.getHeight();
                            int width4 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height4, width4, config);
                        } else {
                            int height5 = bitmapDecodeStream.getHeight();
                            int width5 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height5, width5, config);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, AbstractC2142k.f7775a);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    } else {
                        matrix = new Matrix();
                        width = bitmapDecodeStream.getWidth() / 2.0f;
                        height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z11) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i6 > 0) {
                            matrix.postRotate(i6, width, height);
                        }
                        rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF);
                        f = rectF.left;
                        if (f == 0.0f) {
                            matrix.postTranslate(-f, -rectF.top);
                        } else {
                            matrix.postTranslate(-f, -rectF.top);
                        }
                        if (i6 != 90) {
                            int height6 = bitmapDecodeStream.getHeight();
                            int width6 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height6, width6, config);
                        } else {
                            int height7 = bitmapDecodeStream.getHeight();
                            int width7 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height7, width7, config);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, AbstractC2142k.f7775a);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    }
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                    if (options.inSampleSize <= 1) {
                        z7 = true;
                    } else {
                        z7 = true;
                    }
                    return new C2138g(bitmapDrawable2, z7);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AbstractC0032a.m164r(bufferedSource, th);
                        throw th2;
                    }
                }
                z7 = false;
                break;
        }
    }
}
