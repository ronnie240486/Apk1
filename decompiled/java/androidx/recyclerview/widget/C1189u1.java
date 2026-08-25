package androidx.recyclerview.widget;

import java.util.Arrays;

public final class C1189u1 {

    public int f3702a;

    public int f3703b;

    public boolean f3704c;

    public boolean f3705d;

    public boolean f3706e;

    public int[] f3707f;

    public final StaggeredGridLayoutManager f3708g;

    public C1189u1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f3708g = staggeredGridLayoutManager;
        m2994a();
    }

    public final void m2994a() {
        this.f3702a = -1;
        this.f3703b = Integer.MIN_VALUE;
        this.f3704c = false;
        this.f3705d = false;
        this.f3706e = false;
        int[] iArr = this.f3707f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
