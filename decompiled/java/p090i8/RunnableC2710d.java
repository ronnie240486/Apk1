package p090i8;

import com.bumptech.glide.AbstractC1466d;
import p004a3.RunnableC0038c;
import p102j8.InterfaceC2787b;
import p180q8.C3535j;

public final class RunnableC2710d implements InterfaceC2787b, Runnable {

    public final RunnableC0038c f9399a;

    public final AbstractC2711e f9400b;

    public Thread f9401c;

    public RunnableC2710d(RunnableC0038c runnableC0038c, AbstractC2711e abstractC2711e) {
        this.f9399a = runnableC0038c;
        this.f9400b = abstractC2711e;
    }

    @Override
    public final void mo5675a() {
        if (this.f9401c == Thread.currentThread()) {
            AbstractC2711e abstractC2711e = this.f9400b;
            if (abstractC2711e instanceof C3535j) {
                C3535j c3535j = (C3535j) abstractC2711e;
                if (c3535j.f11922b) {
                    return;
                }
                c3535j.f11922b = true;
                c3535j.f11921a.shutdown();
                return;
            }
        }
        this.f9400b.mo5675a();
    }

    @Override
    public final void run() {
        this.f9401c = Thread.currentThread();
        try {
            this.f9399a.run();
            mo5675a();
            this.f9401c = null;
        } catch (Throwable th) {
            try {
                AbstractC1466d.m3505y(th);
                throw th;
            } catch (Throwable th2) {
                mo5675a();
                this.f9401c = null;
                throw th2;
            }
        }
    }
}
