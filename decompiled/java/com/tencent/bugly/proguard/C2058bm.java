package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

public final class C2058bm extends AbstractC2088m implements Cloneable {

    static ArrayList<String> f7484c;

    public String f7485a = "";

    public ArrayList<String> f7486b = null;

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4934a(this.f7485a, 0);
        ArrayList<String> arrayList = this.f7486b;
        if (arrayList != null) {
            c2086l.m4935a((Collection) arrayList, 1);
        }
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7485a = c2084k.m4915b(0, true);
        if (f7484c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f7484c = arrayList;
            arrayList.add("");
        }
        this.f7486b = (ArrayList) c2084k.m4910a(f7484c, 1, false);
    }
}
