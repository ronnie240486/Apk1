package p025c2;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import java.io.File;
import okio.FileSystem;
import okio.Path;
import p007a7.C0069f;
import p028c6.C1399b;
import p048e2.C2366a;
import p048e2.C2376k;
import p071g9.AbstractC2617a;
import p091i9.InterfaceC2713a;
import p101j7.C2782c;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p108k2.C2864b;
import p185r2.AbstractC3587f;
import p185r2.C3593l;
import p213t9.AbstractC3819b0;
import p222u7.AbstractC3928d;

public final class C1384e extends AbstractC2797j implements InterfaceC2713a {

    public final int f4209a;

    public final C1386g f4210b;

    public C1384e(C1386g c1386g, int i6) {
        super(0);
        this.f4209a = i6;
        this.f4210b = c1386g;
    }

    @Override
    public final Object invoke() {
        int largeMemoryClass;
        C2376k c2376kM5378a;
        int i6 = 3;
        int i10 = 0;
        switch (this.f4209a) {
            case 0:
                Context context = this.f4210b.f4212a;
                Bitmap.Config[] configArr = AbstractC3587f.f12065a;
                double d = 0.2d;
                try {
                    Object objM7851o = AbstractC3928d.m7851o(context, ActivityManager.class);
                    AbstractC2796i.m5782c(objM7851o);
                    if (((ActivityManager) objM7851o).isLowRamDevice()) {
                        d = 0.15d;
                    }
                } catch (Exception unused) {
                }
                C1399b c1399b = new C1399b(3);
                if (d > 0.0d) {
                    Bitmap.Config[] configArr2 = AbstractC3587f.f12065a;
                    try {
                        Object objM7851o2 = AbstractC3928d.m7851o(context, ActivityManager.class);
                        AbstractC2796i.m5782c(objM7851o2);
                        ActivityManager activityManager = (ActivityManager) objM7851o2;
                        largeMemoryClass = (context.getApplicationInfo().flags & ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                    } catch (Exception unused2) {
                        largeMemoryClass = 256;
                    }
                    double d10 = d * ((double) largeMemoryClass);
                    double d11 = 1024;
                    i10 = (int) (d10 * d11 * d11);
                    break;
                }
                return new C2864b(i10 > 0 ? new C0069f(i10, c1399b) : new C2782c(i6, c1399b), c1399b);
            default:
                C3593l c3593l = C3593l.f12081a;
                Context context2 = this.f4210b.f4212a;
                synchronized (c3593l) {
                    try {
                        c2376kM5378a = C3593l.f12082b;
                        if (c2376kM5378a == null) {
                            C2366a c2366a = new C2366a();
                            c2366a.f8281b = FileSystem.SYSTEM;
                            c2366a.f8282c = 0.02d;
                            c2366a.f8283d = 10485760L;
                            c2366a.f8284e = 262144000L;
                            c2366a.f8285f = AbstractC3819b0.f12902b;
                            Bitmap.Config[] configArr3 = AbstractC3587f.f12065a;
                            File cacheDir = context2.getCacheDir();
                            if (cacheDir == null) {
                                throw new IllegalStateException("cacheDir == null");
                            }
                            cacheDir.mkdirs();
                            c2366a.f8280a = Path.Companion.get$default(Path.Companion, AbstractC2617a.m5625p(cacheDir), false, 1, (Object) null);
                            c2376kM5378a = c2366a.m5378a();
                            C3593l.f12082b = c2376kM5378a;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c2376kM5378a;
        }
    }
}
