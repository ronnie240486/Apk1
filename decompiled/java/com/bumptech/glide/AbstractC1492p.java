package com.bumptech.glide;

import p164p3.C3353b;
import p164p3.InterfaceC3355d;
import p186r3.AbstractC3610n;

public abstract class AbstractC1492p implements Cloneable {

    public InterfaceC3355d f4512a = C3353b.f11345b;

    public final AbstractC1492p clone() {
        try {
            return (AbstractC1492p) super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC1492p) {
            return AbstractC3610n.m7234b(this.f4512a, ((AbstractC1492p) obj).f4512a);
        }
        return false;
    }

    public int hashCode() {
        InterfaceC3355d interfaceC3355d = this.f4512a;
        if (interfaceC3355d != null) {
            return interfaceC3355d.hashCode();
        }
        return 0;
    }
}
