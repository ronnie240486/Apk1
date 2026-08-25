package p081h8;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p090i8.AbstractC2711e;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;

public final class C2672c extends AbstractC2711e {

    public final Handler f9299a;

    public final boolean f9300b;

    public volatile boolean f9301c;

    public C2672c(Handler handler, boolean z7) {
        this.f9299a = handler;
        this.f9300b = z7;
    }

    @Override
    public final void mo5675a() {
        this.f9301c = true;
        this.f9299a.removeCallbacksAndMessages(this);
    }

    @Override
    public final InterfaceC2787b mo5676b(Runnable runnable, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        boolean z7 = this.f9301c;
        EnumC3086b enumC3086b = EnumC3086b.f10549a;
        if (z7) {
            return enumC3086b;
        }
        Handler handler = this.f9299a;
        RunnableC2673d runnableC2673d = new RunnableC2673d(handler, runnable);
        Message messageObtain = Message.obtain(handler, runnableC2673d);
        messageObtain.obj = this;
        if (this.f9300b) {
            messageObtain.setAsynchronous(true);
        }
        this.f9299a.sendMessageDelayed(messageObtain, timeUnit.toMillis(0L));
        if (!this.f9301c) {
            return runnableC2673d;
        }
        this.f9299a.removeCallbacks(runnableC2673d);
        return enumC3086b;
    }
}
