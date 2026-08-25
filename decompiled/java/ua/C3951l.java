package ua;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

public final class C3951l {

    public final Method f13281a;

    public final ThreadMode f13282b;

    public final Class f13283c;

    public final int f13284d;

    public final boolean f13285e;

    public String f13286f;

    public C3951l(Method method, Class cls, ThreadMode threadMode, int i6, boolean z7) {
        this.f13281a = method;
        this.f13282b = threadMode;
        this.f13283c = cls;
        this.f13284d = i6;
        this.f13285e = z7;
    }

    public final synchronized void m7878a() {
        if (this.f13286f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f13281a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f13281a.getName());
            sb.append('(');
            sb.append(this.f13283c.getName());
            this.f13286f = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3951l)) {
            return false;
        }
        m7878a();
        C3951l c3951l = (C3951l) obj;
        c3951l.m7878a();
        return this.f13286f.equals(c3951l.f13286f);
    }

    public final int hashCode() {
        return this.f13281a.hashCode();
    }
}
