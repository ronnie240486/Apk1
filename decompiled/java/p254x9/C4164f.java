package p254x9;

import p008a9.InterfaceC0079i;

public final class C4164f extends RuntimeException {

    public final transient InterfaceC0079i f14088a;

    public C4164f(InterfaceC0079i interfaceC0079i) {
        this.f14088a = interfaceC0079i;
    }

    @Override
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override
    public final String getLocalizedMessage() {
        return this.f14088a.toString();
    }
}
