package p138n0;

import android.text.TextUtils;
import android.view.View;
import p024c1.AbstractC1379c;

public final class C3107c0 extends AbstractC1379c {

    public final int f10579e;

    public C3107c0(int i6, Class cls, int i10, int i11, int i12) {
        this.f10579e = i12;
        this.f4191a = i6;
        this.f4194d = cls;
        this.f4193c = i10;
        this.f4192b = i11;
    }

    @Override
    public final Object mo3245b(View view) {
        switch (this.f10579e) {
            case 0:
                return Boolean.valueOf(AbstractC3134l0.m6244d(view));
            case 1:
                return AbstractC3134l0.m6242b(view);
            case 2:
                return AbstractC3140n0.m6276b(view);
            default:
                return Boolean.valueOf(AbstractC3134l0.m6243c(view));
        }
    }

    @Override
    public final void mo3246c(View view, Object obj) {
        switch (this.f10579e) {
            case 0:
                AbstractC3134l0.m6250j(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                AbstractC3134l0.m6248h(view, (CharSequence) obj);
                break;
            case 2:
                AbstractC3140n0.m6279e(view, (CharSequence) obj);
                break;
            default:
                AbstractC3134l0.m6247g(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override
    public final boolean mo3248e(Object obj, Object obj2) {
        switch (this.f10579e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            case 2:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
