package p261y4;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.Collections;
import java.util.Set;
import p002a1.C0026b;
import p018b5.AbstractC1312l;
import p028c6.C1400c;
import p124l6.C2982h;
import p160p.C3342f;
import p176q4.C3477d;
import p230v4.InterfaceC3992f;
import p242w5.C4056d;
import p271z4.C4330a;
import p271z4.C4331b;
import p271z4.C4334e;
import p271z4.C4336g;
import p271z4.C4337h;
import p271z4.C4349t;
import p271z4.C4354y;

public abstract class AbstractC4259g {

    public final Context f14457a;

    public final String f14458b;

    public final C2982h f14459c;

    public final InterfaceC4254b f14460d;

    public final C4331b f14461e;

    public final Looper f14462f;

    public final int f14463g;

    public final C4330a f14464h;

    public final C4334e f14465i;

    public AbstractC4259g(Context context, C2982h c2982h, InterfaceC4254b interfaceC4254b, C4258f c4258f) {
        AbstractC1312l.m3199f(context, "Null context is not permitted.");
        AbstractC1312l.m3199f(c2982h, "Api must not be null.");
        AbstractC1312l.m3199f(c4258f, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        AbstractC1312l.m3199f(applicationContext, "The provided context did not have an application context.");
        this.f14457a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f14458b = attributionTag;
        this.f14459c = c2982h;
        this.f14460d = interfaceC4254b;
        this.f14462f = c4258f.f14456b;
        this.f14461e = new C4331b(c2982h, interfaceC4254b, attributionTag);
        C4334e c4334eM8359f = C4334e.m8359f(applicationContext);
        this.f14465i = c4334eM8359f;
        this.f14463g = c4334eM8359f.f14705h.getAndIncrement();
        this.f14464h = c4258f.f14455a;
        HandlerC1731y0 handlerC1731y0 = c4334eM8359f.f14710m;
        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(7, this));
    }

    public final C0026b m8304a() {
        C0026b c0026b = new C0026b(12, false);
        Set setEmptySet = Collections.emptySet();
        if (((C3342f) c0026b.f54b) == null) {
            c0026b.f54b = new C3342f(0);
        }
        ((C3342f) c0026b.f54b).addAll(setEmptySet);
        Context context = this.f14457a;
        c0026b.f56d = context.getClass().getName();
        c0026b.f55c = context.getPackageName();
        return c0026b;
    }

    public final C4337h m8305b(InterfaceC3992f interfaceC3992f) {
        Looper looper = this.f14462f;
        AbstractC1312l.m3199f(interfaceC3992f, "Listener must not be null");
        AbstractC1312l.m3199f(looper, "Looper must not be null");
        C4337h c4337h = new C4337h();
        new HandlerC1731y0(looper, 5);
        AbstractC1312l.m3196c("castDeviceControllerListenerKey");
        c4337h.f14713a = new C4336g(interfaceC3992f);
        return c4337h;
    }

    public final C3477d m8306c(int i6, C1400c c1400c) {
        C4056d c4056d = new C4056d();
        C4334e c4334e = this.f14465i;
        c4334e.getClass();
        c4334e.m8363e(c4056d, c1400c.f4263a, this);
        C4349t c4349t = new C4349t(new C4354y(i6, c1400c, c4056d, this.f14464h), c4334e.f14706i.get(), this);
        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(4, c4349t));
        return c4056d.f13720a;
    }
}
