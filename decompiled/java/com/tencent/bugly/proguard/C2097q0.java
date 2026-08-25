package com.tencent.bugly.proguard;

public final class C2097q0 extends Thread {

    public final int f7663a = 4;

    public int f7664b;

    public String f7665c;

    public byte[] f7666d;

    public final C2103w f7667e;

    public C2097q0(C2103w c2103w) {
        this.f7667e = c2103w;
    }

    @Override
    public final void run() {
        if (this.f7663a != 4) {
            return;
        }
        this.f7667e.m5016a(this.f7664b, this.f7665c, this.f7666d, (InterfaceC2102v) null);
    }
}
