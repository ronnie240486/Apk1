package p180q8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p090i8.AbstractC2711e;
import p102j8.C2786a;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;

public final class RunnableC3531f extends AbstractC2711e implements Runnable {

    public final RunnableC3530e f11907b;

    public final C3532g f11908c;

    public final AtomicBoolean f11909d = new AtomicBoolean();

    public final C2786a f11906a = new C2786a(0);

    public RunnableC3531f(RunnableC3530e runnableC3530e) {
        C3532g c3532g;
        C3532g c3532g2;
        this.f11907b = runnableC3530e;
        if (runnableC3530e.f11902c.f9518b) {
            c3532g2 = C3533h.f11915f;
        } else {
            do {
                if (runnableC3530e.f11901b.isEmpty()) {
                    c3532g = new C3532g(runnableC3530e.f11905f);
                    runnableC3530e.f11902c.m5773b(c3532g);
                    break;
                }
                c3532g = (C3532g) runnableC3530e.f11901b.poll();
            } while (c3532g == null);
            c3532g2 = c3532g;
        }
        this.f11908c = c3532g2;
    }

    @Override
    public final void mo5675a() {
        if (this.f11909d.compareAndSet(false, true)) {
            this.f11906a.mo5675a();
            boolean z7 = C3533h.f11916g;
            C3532g c3532g = this.f11908c;
            if (z7) {
                c3532g.m7169d(this, TimeUnit.NANOSECONDS, null);
                return;
            }
            RunnableC3530e runnableC3530e = this.f11907b;
            runnableC3530e.getClass();
            c3532g.f11910c = System.nanoTime() + runnableC3530e.f11900a;
            runnableC3530e.f11901b.offer(c3532g);
        }
    }

    @Override
    public final InterfaceC2787b mo5676b(Runnable runnable, TimeUnit timeUnit) {
        return this.f11906a.f9518b ? EnumC3086b.f10549a : this.f11908c.m7169d(runnable, timeUnit, this.f11906a);
    }

    @Override
    public final void run() {
        RunnableC3530e runnableC3530e = this.f11907b;
        runnableC3530e.getClass();
        long jNanoTime = System.nanoTime() + runnableC3530e.f11900a;
        C3532g c3532g = this.f11908c;
        c3532g.f11910c = jNanoTime;
        runnableC3530e.f11901b.offer(c3532g);
    }
}
