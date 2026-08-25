package p106k0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;
import com.tencent.bugly.proguard.ThreadFactoryC2069c0;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p025c2.C1381b;
import p028c6.C1399b;
import p056f0.AbstractC2484g;
import p160p.C3347k;

public abstract class AbstractC2858f {

    public static final C1498f f9778a = new C1498f(16);

    public static final ThreadPoolExecutor f9779b;

    public static final Object f9780c;

    public static final C3347k f9781d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactoryC2069c0(1));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f9779b = threadPoolExecutor;
        f9780c = new Object();
        f9781d = new C3347k(0);
    }

    public static C2857e m5859a(String str, Context context, C1381b c1381b, int i6) {
        C1498f c1498f = f9778a;
        Typeface typeface = (Typeface) c1498f.m3612b(str);
        if (typeface != null) {
            return new C2857e(typeface);
        }
        try {
            C1399b c1399bM5858a = AbstractC2854b.m5858a(context, c1381b);
            int i10 = 1;
            C2859g[] c2859gArr = (C2859g[]) c1399bM5858a.f4262b;
            int i11 = c1399bM5858a.f4261a;
            if (i11 != 0) {
                if (i11 != 1) {
                    i10 = -3;
                    break;
                }
                i10 = -2;
            } else if (c2859gArr != null && c2859gArr.length != 0) {
                i10 = 0;
                for (C2859g c2859g : c2859gArr) {
                    int i12 = c2859g.f9786e;
                    if (i12 != 0) {
                        if (i12 >= 0) {
                            i10 = i12;
                            break;
                        }
                        i10 = -3;
                        break;
                    }
                }
            }
            if (i10 != 0) {
                return new C2857e(i10);
            }
            Typeface typefaceMo5526m = AbstractC2484g.f8688a.mo5526m(context, c2859gArr, i6);
            if (typefaceMo5526m == null) {
                return new C2857e(-3);
            }
            c1498f.m3614d(str, typefaceMo5526m);
            return new C2857e(typefaceMo5526m);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C2857e(-1);
        }
    }
}
