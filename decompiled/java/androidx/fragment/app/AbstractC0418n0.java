package androidx.fragment.app;

import androidx.viewpager.widget.ViewPager;
import p015b2.AbstractC1249a;

public abstract class AbstractC0418n0 extends AbstractC1249a {

    public final AbstractC0410j0 f1914c;

    public C0391a f1915d = null;

    public AbstractComponentCallbacksC0427s f1916e = null;

    public boolean f1917f;

    public AbstractC0418n0(AbstractC0410j0 abstractC0410j0) {
        this.f1914c = abstractC0410j0;
    }

    @Override
    public final void mo1283a(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (this.f1915d == null) {
            AbstractC0410j0 abstractC0410j0 = this.f1914c;
            abstractC0410j0.getClass();
            this.f1915d = new C0391a(abstractC0410j0);
        }
        C0391a c0391a = this.f1915d;
        c0391a.getClass();
        AbstractC0410j0 abstractC0410j1 = abstractComponentCallbacksC0427s.f1982s;
        if (abstractC0410j1 != null && abstractC0410j1 != c0391a.f1817q) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + abstractComponentCallbacksC0427s.toString() + " is already attached to a FragmentManager.");
        }
        c0391a.m1187b(new C0426r0(6, abstractComponentCallbacksC0427s));
        if (abstractComponentCallbacksC0427s.equals(this.f1916e)) {
            this.f1916e = null;
        }
    }

    @Override
    public final void mo1284b() {
        C0391a c0391a = this.f1915d;
        if (c0391a != null) {
            if (!this.f1917f) {
                try {
                    this.f1917f = true;
                    if (c0391a.f1807g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    c0391a.f1808h = false;
                    c0391a.f1817q.m1260v(c0391a, true);
                    this.f1917f = false;
                } catch (Throwable th) {
                    this.f1917f = false;
                    throw th;
                }
            }
            this.f1915d = null;
        }
    }

    @Override
    public void mo1285e(ViewPager viewPager, int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = this.f1916e;
        if (abstractComponentCallbacksC0427s != abstractComponentCallbacksC0427s2) {
            if (abstractComponentCallbacksC0427s2 != null) {
                if (abstractComponentCallbacksC0427s2.f1948C) {
                    abstractComponentCallbacksC0427s2.f1948C = false;
                }
                abstractComponentCallbacksC0427s2.m1317P(false);
            }
            if (!abstractComponentCallbacksC0427s.f1948C) {
                abstractComponentCallbacksC0427s.f1948C = true;
            }
            abstractComponentCallbacksC0427s.m1317P(true);
            this.f1916e = abstractComponentCallbacksC0427s;
        }
    }

    @Override
    public final void mo1286g(ViewPager viewPager) {
        if (viewPager.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract AbstractComponentCallbacksC0427s mo1287h(int i6);
}
