package com.tencent.bugly.proguard;

public final class RunnableC2091n0 implements Runnable {

    public final int f7652a;

    public final C2098r f7653b;

    public RunnableC2091n0(C2098r c2098r, int i6) {
        this.f7652a = i6;
        this.f7653b = c2098r;
    }

    @Override
    public final void run() {
        switch (this.f7652a) {
            case 0:
                try {
                    this.f7653b.m4959a(false);
                } catch (Throwable th) {
                    C2029al.m4641a(th);
                    return;
                }
                break;
            default:
                long jCurrentTimeMillis = System.currentTimeMillis();
                C2098r c2098r = this.f7653b;
                if (jCurrentTimeMillis >= c2098r.f7670b) {
                    c2098r.m4967a(3, false);
                    c2098r.m4966a();
                } else {
                    C2028ak.m4631a().m4634a(new RunnableC2091n0(c2098r, 1), (c2098r.f7670b - jCurrentTimeMillis) + 5000);
                }
                break;
        }
    }
}
