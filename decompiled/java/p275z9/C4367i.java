package p275z9;

import androidx.leanback.widget.C0486o;
import p213t9.AbstractC3865u;

public final class C4367i extends AbstractRunnableC4366h {

    public final Runnable f14829c;

    public C4367i(Runnable runnable, long j10, C0486o c0486o) {
        super(j10, c0486o);
        this.f14829c = runnable;
    }

    @Override
    public final void run() {
        try {
            this.f14829c.run();
        } finally {
            this.f14828b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f14829c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC3865u.m7691f(runnable));
        sb.append(", ");
        sb.append(this.f14827a);
        sb.append(", ");
        sb.append(this.f14828b);
        sb.append(']');
        return sb.toString();
    }
}
