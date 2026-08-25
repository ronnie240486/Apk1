package p030c9;

import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;

public final class C1432b implements InterfaceC0074d {

    public static final C1432b f4367a = new C1432b();

    @Override
    public final InterfaceC0079i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
