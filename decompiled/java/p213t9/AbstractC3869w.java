package p213t9;

import p224u9.C3938c;
import p254x9.AbstractC4172n;
import p254x9.AbstractC4178t;
import p275z9.C4362d;

public abstract class AbstractC3869w {

    public static final int f12971a = 0;

    static {
        String property;
        int i6 = AbstractC4178t.f14117a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            RunnableC3867v runnableC3867v = RunnableC3867v.f12965i;
            return;
        }
        C4362d c4362d = AbstractC3819b0.f12901a;
        C3938c c3938c = AbstractC4172n.f14112a;
        C3938c c3938c2 = c3938c.f13237f;
        if (c3938c instanceof InterfaceC3873y) {
            return;
        }
        RunnableC3867v runnableC3867v2 = RunnableC3867v.f12965i;
    }
}
