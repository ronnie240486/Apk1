package p213t9;

import java.util.concurrent.CancellationException;
import p103j9.AbstractC2796i;

public final class C3860r0 extends CancellationException {

    public final transient C3874y0 f12953a;

    public C3860r0(String str, Throwable th, C3874y0 c3874y0) {
        super(str);
        this.f12953a = c3874y0;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C3860r0) {
                C3860r0 c3860r0 = (C3860r0) obj;
                if (!AbstractC2796i.m5780a(c3860r0.getMessage(), getMessage()) || !AbstractC2796i.m5780a(c3860r0.f12953a, this.f12953a) || !AbstractC2796i.m5780a(c3860r0.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        AbstractC2796i.m5782c(message);
        int iHashCode = (this.f12953a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override
    public final String toString() {
        return super.toString() + "; job=" + this.f12953a;
    }
}
