package p056f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.appcompat.app.RunnableC0126c;
import androidx.appcompat.app.RunnableC0147m0;
import androidx.leanback.widget.RunnableC0485n0;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p001a0.C0019b;
import p004a3.RunnableC0038c;
import p007a7.C0069f;
import p025c2.C1381b;
import p046e0.AbstractC2343b;
import p046e0.C2347f;
import p046e0.C2349h;
import p046e0.InterfaceC2346e;
import p106k0.AbstractC2858f;
import p106k0.C2856d;
import p106k0.C2857e;
import p106k0.CallableC2855c;
import p123l5.AbstractC2973a;
import p160p.C3347k;

public abstract class AbstractC2484g {

    public static final AbstractC2973a f8688a;

    public static final C1498f f8689b;

    static {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            f8688a = new C2489l();
        } else if (i6 >= 28) {
            f8688a = new C2488k();
        } else if (i6 >= 26) {
            f8688a = new C2487j();
        } else if (i6 < 24) {
            f8688a = new C2485h();
        } else {
            Method method = C2486i.f8697t;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                f8688a = new C2486i();
            } else {
                f8688a = new C2485h();
            }
        }
        f8689b = new C1498f(16);
    }

    public static Typeface m5521a(Context context, InterfaceC2346e interfaceC2346e, Resources resources, int i6, String str, int i10, int i11, AbstractC2343b abstractC2343b, boolean z7) {
        Typeface typefaceMo5525l;
        Typeface typefaceCreate;
        Typeface typeface;
        int i12 = 17;
        int i13 = 1;
        int i14 = 12;
        boolean z10 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        int i15 = -3;
        if (interfaceC2346e instanceof C2349h) {
            C2349h c2349h = (C2349h) interfaceC2346e;
            String str2 = c2349h.f8203d;
            typefaceMo5525l = null;
            if (str2 == null || str2.isEmpty()) {
                typefaceCreate = null;
            } else {
                typefaceCreate = Typeface.create(str2, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                    typefaceCreate = null;
                }
            }
            if (typefaceCreate != null) {
                if (abstractC2343b != null) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0147m0(abstractC2343b, i14, typefaceCreate));
                }
                return typefaceCreate;
            }
            boolean z11 = !z7 ? abstractC2343b != null : c2349h.f8202c != 0;
            int i16 = z7 ? c2349h.f8201b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            C0019b c0019b = new C0019b(28);
            c0019b.f38b = abstractC2343b;
            C1381b c1381b = c2349h.f8200a;
            C0069f c0069f = new C0069f(24, c0019b, handler, z10);
            if (z11) {
                C1498f c1498f = AbstractC2858f.f9778a;
                String str3 = ((String) c1381b.f4202f) + "-" + i11;
                typeface = (Typeface) AbstractC2858f.f9778a.m3612b(str3);
                if (typeface != null) {
                    handler.post(new RunnableC0038c(i12, c0019b, typeface, objArr3 == true ? 1 : 0));
                    typefaceMo5525l = typeface;
                } else if (i16 == -1) {
                    C2857e c2857eM5859a = AbstractC2858f.m5859a(str3, context, c1381b, i11);
                    c0069f.m224G(c2857eM5859a);
                    typefaceMo5525l = c2857eM5859a.f9776a;
                } else {
                    try {
                        try {
                            try {
                                C2857e c2857e = (C2857e) AbstractC2858f.f9779b.submit(new CallableC2855c(str3, context, c1381b, i11, 0)).get(i16, TimeUnit.MILLISECONDS);
                                c0069f.m224G(c2857e);
                                typefaceMo5525l = c2857e.f9776a;
                            } catch (InterruptedException e5) {
                                throw e5;
                            }
                        } catch (ExecutionException e10) {
                            throw new RuntimeException(e10);
                        } catch (TimeoutException unused) {
                            throw new InterruptedException("timeout");
                        }
                    } catch (InterruptedException unused2) {
                        ((Handler) c0069f.f197c).post(new RunnableC0485n0(i15, 4, (C0019b) c0069f.f196b));
                    }
                }
            } else {
                C1498f c1498f2 = AbstractC2858f.f9778a;
                String str4 = ((String) c1381b.f4202f) + "-" + i11;
                typeface = (Typeface) AbstractC2858f.f9778a.m3612b(str4);
                if (typeface != null) {
                    handler.post(new RunnableC0038c(i12, c0019b, typeface, objArr2 == true ? 1 : 0));
                    typefaceMo5525l = typeface;
                } else {
                    C2856d c2856d = new C2856d(objArr == true ? 1 : 0, c0069f);
                    synchronized (AbstractC2858f.f9780c) {
                        try {
                            C3347k c3347k = AbstractC2858f.f9781d;
                            ArrayList arrayList = (ArrayList) c3347k.get(str4);
                            if (arrayList != null) {
                                arrayList.add(c2856d);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(c2856d);
                                c3347k.put(str4, arrayList2);
                                CallableC2855c callableC2855c = new CallableC2855c(str4, context, c1381b, i11, 1);
                                ThreadPoolExecutor threadPoolExecutor = AbstractC2858f.f9779b;
                                C2856d c2856d2 = new C2856d(i13, str4);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                RunnableC0126c runnableC0126c = new RunnableC0126c();
                                runnableC0126c.f265b = callableC2855c;
                                runnableC0126c.f266c = c2856d2;
                                runnableC0126c.f267d = handler2;
                                threadPoolExecutor.execute(runnableC0126c);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        } else {
            typefaceMo5525l = f8688a.mo5525l(context, (C2347f) interfaceC2346e, resources, i11);
            if (abstractC2343b != null) {
                if (typefaceMo5525l != null) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0147m0(abstractC2343b, i14, typefaceMo5525l));
                } else {
                    abstractC2343b.m5328a(-3);
                }
            }
        }
        if (typefaceMo5525l != null) {
            f8689b.m3614d(m5522b(resources, i6, str, i10, i11), typefaceMo5525l);
        }
        return typefaceMo5525l;
    }

    public static String m5522b(Resources resources, int i6, String str, int i10, int i11) {
        return resources.getResourcePackageName(i6) + '-' + str + '-' + i10 + '-' + i6 + '-' + i11;
    }
}
