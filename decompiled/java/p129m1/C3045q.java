package p129m1;

import android.os.Build;
import android.text.TextUtils;
import p118l0.AbstractC2955f;

public final class C3045q {

    public C3047s f10400a;

    public C3045q(String str, int i6, int i10) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT < 28) {
            this.f10400a = new C3047s(str, i6, i10);
            return;
        }
        C3046r c3046r = new C3046r(str, i6, i10);
        AbstractC2955f.m5994n(i6, i10, str);
        this.f10400a = c3046r;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3045q)) {
            return false;
        }
        return this.f10400a.equals(((C3045q) obj).f10400a);
    }

    public final int hashCode() {
        return this.f10400a.hashCode();
    }
}
