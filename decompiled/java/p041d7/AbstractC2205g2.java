package p041d7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractC2205g2 extends AbstractC2168b0 implements Serializable {

    public final transient C2215h5 f7907f;

    public final transient int f7908g;

    public AbstractC2205g2(C2215h5 c2215h5, int i6) {
        this.f7907f = c2215h5;
        this.f7908g = i6;
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsKey(Object obj) {
        return this.f7907f.containsKey(obj);
    }

    @Override
    public final InterfaceC2310v4 mo5174f() {
        return (C2191e2) super.mo5174f();
    }

    @Override
    public final boolean mo5175h(Object obj) {
        return obj != null && super.mo5175h(obj);
    }

    @Override
    public final Map mo5112i() {
        throw new AssertionError("should never be called");
    }

    @Override
    public final Collection mo5113j() {
        return new C2184d2(this);
    }

    @Override
    public final Set mo5114k() {
        throw new AssertionError("unreachable");
    }

    @Override
    public final Set keySet() {
        return this.f7907f.keySet();
    }

    @Override
    public final InterfaceC2310v4 mo5115l() {
        return new C2191e2(this);
    }

    @Override
    public final Collection mo5116m() {
        return new C2198f2(this);
    }

    @Override
    public AbstractC2331z1 mo5173d() {
        return this.f7907f;
    }

    @Override
    public AbstractC2274q1 mo5108a() {
        return (AbstractC2274q1) super.mo5108a();
    }

    @Override
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final AbstractC2233k2 m5178q() {
        return this.f7907f.keySet();
    }

    public final AbstractC2274q1 m5179r() {
        return (AbstractC2274q1) super.values();
    }

    @Override
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        return this.f7908g;
    }

    @Override
    public final Collection values() {
        return (AbstractC2274q1) super.values();
    }
}
