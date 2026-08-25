package com.google.android.material.datepicker;

import com.tencent.bugly.proguard.C2098r;
import p187r4.AbstractC3612b;

public final class RunnableC1790i implements Runnable {

    public final int f6170a;

    public final long f6171b;

    public final Object f6172c;

    public RunnableC1790i(Object obj, long j10, int i6) {
        this.f6170a = i6;
        this.f6172c = obj;
        this.f6171b = j10;
    }

    @Override
    public final void run() {
        long j10 = this.f6171b;
        Object obj = this.f6172c;
        switch (this.f6170a) {
            case 0:
                AbstractC1792j abstractC1792j = (AbstractC1792j) obj;
                abstractC1792j.f6174a.setError(String.format(abstractC1792j.f6177d, AbstractC3612b.m7271m(j10)));
                abstractC1792j.mo4189a();
                break;
            default:
                C2098r c2098r = (C2098r) obj;
                c2098r.m4969b();
                c2098r.m4968a(j10);
                break;
        }
    }
}
