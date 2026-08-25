package com.tencent.bugly.proguard;

public final class RunnableC2073e0 implements Runnable {

    public final int f7601a;

    public final String f7602b;

    public final String f7603c;

    public final String f7604d;

    public RunnableC2073e0(int i6, String str, String str2, String str3) {
        this.f7601a = i6;
        this.f7602b = str;
        this.f7603c = str2;
        this.f7604d = str3;
    }

    @Override
    public final void run() {
        switch (this.f7601a) {
            case 0:
                C2032ao.m4664d(this.f7602b, this.f7603c, this.f7604d);
                break;
            default:
                C2032ao.m4665e(this.f7602b, this.f7603c, this.f7604d);
                break;
        }
    }
}
