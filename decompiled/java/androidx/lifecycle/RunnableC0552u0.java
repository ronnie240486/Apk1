package androidx.lifecycle;

import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2098r;
import p103j9.AbstractC2796i;

public final class RunnableC0552u0 implements Runnable {

    public final int f2536a = 0;

    public boolean f2537b;

    public final Object f2538c;

    public final Object f2539d;

    public RunnableC0552u0(C0559y c0559y, EnumC0537n enumC0537n) {
        AbstractC2796i.m5785f(c0559y, "registry");
        AbstractC2796i.m5785f(enumC0537n, "event");
        this.f2538c = c0559y;
        this.f2539d = enumC0537n;
    }

    @Override
    public final void run() {
        switch (this.f2536a) {
            case 0:
                if (!this.f2537b) {
                    ((C0559y) this.f2538c).m1521f((EnumC0537n) this.f2539d);
                    this.f2537b = true;
                }
                break;
            default:
                C2098r c2098r = (C2098r) this.f2539d;
                if (c2098r.f7672d) {
                    UserInfoBean userInfoBean = (UserInfoBean) this.f2538c;
                    if (userInfoBean != null) {
                        try {
                            C2098r.m4953a(userInfoBean);
                            C2029al.m4644c("[UserInfo] Record user info.", new Object[0]);
                            c2098r.m4954a(userInfoBean, false);
                        } catch (Throwable th) {
                            if (C2029al.m4641a(th)) {
                                return;
                            }
                            th.printStackTrace();
                        }
                    }
                    if (this.f2537b) {
                        c2098r.m4969b();
                    }
                    break;
                }
                break;
        }
    }

    public RunnableC0552u0(C2098r c2098r, UserInfoBean userInfoBean, boolean z7) {
        this.f2539d = c2098r;
        this.f2538c = userInfoBean;
        this.f2537b = z7;
    }
}
