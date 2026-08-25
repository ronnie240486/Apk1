package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

public final class C2061bp extends AbstractC2088m implements Cloneable {

    static ArrayList<C2060bo> f7520b;

    public ArrayList<C2060bo> f7521a = null;

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4935a((Collection) this.f7521a, 0);
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        if (f7520b == null) {
            f7520b = new ArrayList<>();
            f7520b.add(new C2060bo());
        }
        this.f7521a = (ArrayList) c2084k.m4910a(f7520b, 0, true);
    }
}
