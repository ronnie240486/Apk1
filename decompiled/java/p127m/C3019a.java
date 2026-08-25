package p127m;

import java.util.HashMap;

public final class C3019a extends C3024f {

    public final HashMap f10339e = new HashMap();

    @Override
    public final C3021c mo6095c(Object obj) {
        return (C3021c) this.f10339e.get(obj);
    }

    @Override
    public final Object mo6096d(Object obj) {
        Object objMo6096d = super.mo6096d(obj);
        this.f10339e.remove(obj);
        return objMo6096d;
    }
}
