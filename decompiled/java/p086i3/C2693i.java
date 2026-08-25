package p086i3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.C1468f;
import com.bumptech.glide.C1474l;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.bumptech.glide.ComponentCallbacks2C1491o;
import java.util.ArrayList;
import p037d3.C2150c;
import p141n3.C3191e;
import p175q3.C3470d;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p208t2.C3800a;
import p208t2.C3801b;
import p208t2.C3803d;
import p228v2.InterfaceC3985l;
import p247x2.C4089k;
import p259y2.InterfaceC4238a;

public final class C2693i {

    public final C3803d f9354a;

    public final Handler f9355b;

    public final ArrayList f9356c;

    public final ComponentCallbacks2C1491o f9357d;

    public final InterfaceC4238a f9358e;

    public boolean f9359f;

    public boolean f9360g;

    public C1474l f9361h;

    public C2690f f9362i;

    public boolean f9363j;

    public C2690f f9364k;

    public Bitmap f9365l;

    public C2690f f9366m;

    public int f9367n;

    public int f9368o;

    public int f9369p;

    public C2693i(ComponentCallbacks2C1464b componentCallbacks2C1464b, C3803d c3803d, int i6, int i10, Bitmap bitmap) {
        C2150c c2150c = C2150c.f7794b;
        InterfaceC4238a interfaceC4238a = componentCallbacks2C1464b.f4406a;
        C1468f c1468f = componentCallbacks2C1464b.f4408c;
        ComponentCallbacks2C1491o componentCallbacks2C1491oM3464e = ComponentCallbacks2C1464b.m3464e(c1468f.getBaseContext());
        ComponentCallbacks2C1491o componentCallbacks2C1491oM3464e2 = ComponentCallbacks2C1464b.m3464e(c1468f.getBaseContext());
        componentCallbacks2C1491oM3464e2.getClass();
        C1474l c1474lM3540x = new C1474l(componentCallbacks2C1491oM3464e2.f4502a, componentCallbacks2C1491oM3464e2, Bitmap.class, componentCallbacks2C1491oM3464e2.f4503b).mo3537a(ComponentCallbacks2C1491o.f4501k).mo3537a(((C3191e) ((C3191e) ((C3191e) new C3191e().m6383d(C4089k.f13829b)).m6400v()).m6395q(true)).m6388j(i6, i10));
        this.f9356c = new ArrayList();
        this.f9357d = componentCallbacks2C1491oM3464e;
        Handler handler = new Handler(Looper.getMainLooper(), new C2692h(0, this));
        this.f9358e = interfaceC4238a;
        this.f9355b = handler;
        this.f9361h = c1474lM3540x;
        this.f9354a = c3803d;
        m5693c(c2150c, bitmap);
    }

    public final void m5691a() {
        int i6;
        int i10;
        if (!this.f9359f || this.f9360g) {
            return;
        }
        C2690f c2690f = this.f9366m;
        if (c2690f != null) {
            this.f9366m = null;
            m5692b(c2690f);
            return;
        }
        this.f9360g = true;
        C3803d c3803d = this.f9354a;
        C3801b c3801b = c3803d.f12832l;
        int i11 = c3801b.f12808c;
        if (i11 <= 0 || (i10 = c3803d.f12831k) < 0) {
            i6 = 0;
        } else {
            i6 = (i10 < 0 || i10 >= i11) ? -1 : ((C3800a) c3801b.f12810e.get(i10)).f12803i;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) i6);
        int i12 = (c3803d.f12831k + 1) % c3803d.f12832l.f12808c;
        c3803d.f12831k = i12;
        this.f9364k = new C2690f(this.f9355b, i12, jUptimeMillis);
        C1474l c1474lM3535C = this.f9361h.mo3537a((C3191e) new C3191e().m6394p(new C3470d(Double.valueOf(Math.random())))).m3535C(c3803d);
        c1474lM3535C.m3534B(this.f9364k, c1474lM3535C);
    }

    public final void m5692b(C2690f c2690f) {
        this.f9360g = false;
        boolean z7 = this.f9363j;
        Handler handler = this.f9355b;
        if (z7) {
            handler.obtainMessage(2, c2690f).sendToTarget();
            return;
        }
        if (!this.f9359f) {
            this.f9366m = c2690f;
            return;
        }
        if (c2690f.f9351g != null) {
            Bitmap bitmap = this.f9365l;
            if (bitmap != null) {
                this.f9358e.mo5434f(bitmap);
                this.f9365l = null;
            }
            C2690f c2690f2 = this.f9362i;
            this.f9362i = c2690f;
            ArrayList arrayList = this.f9356c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C2688d c2688d = (C2688d) ((InterfaceC2691g) arrayList.get(size));
                Object callback = c2688d.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    c2688d.stop();
                    c2688d.invalidateSelf();
                } else {
                    c2688d.invalidateSelf();
                    C2693i c2693i = (C2693i) c2688d.f9337a.f9336b;
                    C2690f c2690f3 = c2693i.f9362i;
                    if ((c2690f3 != null ? c2690f3.f9349e : -1) == c2693i.f9354a.f12832l.f12808c - 1) {
                        c2688d.f9342f++;
                    }
                    int i6 = c2688d.f9343g;
                    if (i6 != -1 && c2688d.f9342f >= i6) {
                        c2688d.stop();
                    }
                }
            }
            if (c2690f2 != null) {
                handler.obtainMessage(2, c2690f2).sendToTarget();
            }
        }
        m5691a();
    }

    public final void m5693c(InterfaceC3985l interfaceC3985l, Bitmap bitmap) {
        AbstractC3602f.m7225c(interfaceC3985l, "Argument must not be null");
        AbstractC3602f.m7225c(bitmap, "Argument must not be null");
        this.f9365l = bitmap;
        this.f9361h = this.f9361h.mo3537a(new C3191e().m6399u(interfaceC3985l, true));
        this.f9367n = AbstractC3610n.m7235c(bitmap);
        this.f9368o = bitmap.getWidth();
        this.f9369p = bitmap.getHeight();
    }
}
