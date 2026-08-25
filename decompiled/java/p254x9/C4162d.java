package p254x9;

import p008a9.InterfaceC0079i;
import p213t9.InterfaceC3861s;

public final class C4162d implements InterfaceC3861s {

    public final InterfaceC0079i f14086a;

    public C4162d(InterfaceC0079i interfaceC0079i) {
        this.f14086a = interfaceC0079i;
    }

    @Override
    public final InterfaceC0079i mo1512d() {
        return this.f14086a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f14086a + ')';
    }
}
