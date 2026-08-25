package p081h8;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p004a3.RunnableC0038c;
import p090i8.AbstractC2711e;
import p090i8.AbstractC2712f;
import p102j8.InterfaceC2787b;

public final class C2674e extends AbstractC2712f {

    public final Handler f9304a;

    public final boolean f9305b;

    public C2674e(Handler handler, boolean z7) {
        this.f9304a = handler;
        this.f9305b = z7;
    }

    @Override
    public final AbstractC2711e mo5677a() {
        return new C2672c(this.f9304a, this.f9305b);
    }

    @Override
    public final InterfaceC2787b mo5678b(RunnableC0038c runnableC0038c, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        Handler handler = this.f9304a;
        RunnableC2673d runnableC2673d = new RunnableC2673d(handler, runnableC0038c);
        Message messageObtain = Message.obtain(handler, runnableC2673d);
        if (this.f9305b) {
            messageObtain.setAsynchronous(true);
        }
        handler.sendMessageDelayed(messageObtain, timeUnit.toMillis(0L));
        return runnableC2673d;
    }
}
