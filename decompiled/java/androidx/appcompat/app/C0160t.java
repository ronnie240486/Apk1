package androidx.appcompat.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import p007a7.C0069f;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;

public final class C0160t extends AbstractC3280d {

    public final int f440j;

    public final Object f441k;

    public C0160t(int i6, Object obj) {
        this.f440j = i6;
        this.f441k = obj;
    }

    @Override
    public final void mo463a() {
        Object obj = this.f441k;
        switch (this.f440j) {
            case 0:
                RunnableC0156r runnableC0156r = (RunnableC0156r) obj;
                runnableC0156r.f426b.f352v.setAlpha(1.0f);
                LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = runnableC0156r.f426b;
                layoutInflaterFactory2C0135g0.f355y.m6124d(null);
                layoutInflaterFactory2C0135g0.f355y = null;
                break;
            case 1:
                LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g1 = (LayoutInflaterFactory2C0135g0) obj;
                layoutInflaterFactory2C0135g1.f352v.setAlpha(1.0f);
                layoutInflaterFactory2C0135g1.f355y.m6124d(null);
                layoutInflaterFactory2C0135g1.f355y = null;
                break;
            default:
                C0069f c0069f = (C0069f) obj;
                ((LayoutInflaterFactory2C0135g0) c0069f.f197c).f352v.setVisibility(8);
                LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g2 = (LayoutInflaterFactory2C0135g0) c0069f.f197c;
                PopupWindow popupWindow = layoutInflaterFactory2C0135g2.f353w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflaterFactory2C0135g2.f352v.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C0135g2.f352v.getParent();
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    AbstractC3113e0.m6130c(view);
                }
                layoutInflaterFactory2C0135g2.f352v.m543e();
                layoutInflaterFactory2C0135g2.f355y.m6124d(null);
                layoutInflaterFactory2C0135g2.f355y = null;
                ViewGroup viewGroup = layoutInflaterFactory2C0135g2.f307B;
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                AbstractC3113e0.m6130c(viewGroup);
                break;
        }
    }

    @Override
    public void mo464c() {
        Object obj = this.f441k;
        switch (this.f440j) {
            case 0:
                ((RunnableC0156r) obj).f426b.f352v.setVisibility(0);
                break;
            case 1:
                LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) obj;
                layoutInflaterFactory2C0135g0.f352v.setVisibility(0);
                if (layoutInflaterFactory2C0135g0.f352v.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C0135g0.f352v.getParent();
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    AbstractC3113e0.m6130c(view);
                }
                break;
        }
    }
}
