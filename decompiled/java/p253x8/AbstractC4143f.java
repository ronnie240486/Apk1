package p253x8;

import java.util.AbstractList;
import java.util.List;
import p115k9.InterfaceC2906b;

public abstract class AbstractC4143f extends AbstractList implements List, InterfaceC2906b {
    public abstract int mo8160c();

    public abstract Object mo8161d(int i6);

    @Override
    public final Object remove(int i6) {
        return mo8161d(i6);
    }

    @Override
    public final int size() {
        return mo8160c();
    }
}
