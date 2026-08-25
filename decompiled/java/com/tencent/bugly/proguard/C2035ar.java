package com.tencent.bugly.proguard;

public final class C2035ar implements Comparable<C2035ar> {

    public long f7346a = -1;

    public long f7347b = -1;

    public String f7348c = null;

    public boolean f7349d = false;

    public boolean f7350e = false;

    public int f7351f = 0;

    @Override
    public final int compareTo(C2035ar c2035ar) {
        C2035ar c2035ar2 = c2035ar;
        if (c2035ar2 == null) {
            return 1;
        }
        long j10 = this.f7347b - c2035ar2.f7347b;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }
}
