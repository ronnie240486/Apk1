package com.google.android.gms.internal.cast;

import java.util.Iterator;
import p000a.AbstractC0004e;

public final class C1574h2 extends AbstractC1732y1 {

    public final transient Object f5336d;

    public C1574h2(Object obj) {
        this.f5336d = obj;
    }

    @Override
    public final int mo3710c(Object[] objArr) {
        objArr[0] = this.f5336d;
        return 1;
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f5336d.equals(obj);
    }

    @Override
    public final int hashCode() {
        return this.f5336d.hashCode();
    }

    @Override
    public final Iterator iterator() {
        return new C1741z1(this.f5336d);
    }

    @Override
    public final int size() {
        return 1;
    }

    @Override
    public final String toString() {
        return AbstractC0004e.m24r("[", this.f5336d.toString(), "]");
    }
}
