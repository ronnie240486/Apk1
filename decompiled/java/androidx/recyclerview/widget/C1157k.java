package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;
import p000a.AbstractC0004e;

public final class C1157k extends AbstractC1182s0 {

    public static TimeInterpolator f3599s;

    public boolean f3600g;

    public ArrayList f3601h;

    public ArrayList f3602i;

    public ArrayList f3603j;

    public ArrayList f3604k;

    public ArrayList f3605l;

    public ArrayList f3606m;

    public ArrayList f3607n;

    public ArrayList f3608o;

    public ArrayList f3609p;

    public ArrayList f3610q;

    public ArrayList f3611r;

    public static void m2952h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((AbstractC1174p1) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override
    public final boolean mo2953a(AbstractC1174p1 abstractC1174p1, AbstractC1174p1 abstractC1174p2, C1179r0 c1179r0, C1179r0 c1179r1) {
        int i6;
        int i10;
        int i11 = c1179r0.f3678a;
        int i12 = c1179r0.f3679b;
        if (abstractC1174p2.shouldIgnore()) {
            int i13 = c1179r0.f3678a;
            i10 = c1179r0.f3679b;
            i6 = i13;
        } else {
            i6 = c1179r1.f3678a;
            i10 = c1179r1.f3679b;
        }
        if (abstractC1174p1 == abstractC1174p2) {
            return m2957g(abstractC1174p1, i11, i12, i6, i10);
        }
        float translationX = abstractC1174p1.itemView.getTranslationX();
        float translationY = abstractC1174p1.itemView.getTranslationY();
        float alpha = abstractC1174p1.itemView.getAlpha();
        m2961l(abstractC1174p1);
        abstractC1174p1.itemView.setTranslationX(translationX);
        abstractC1174p1.itemView.setTranslationY(translationY);
        abstractC1174p1.itemView.setAlpha(alpha);
        m2961l(abstractC1174p2);
        abstractC1174p2.itemView.setTranslationX(-((int) ((i6 - i11) - translationX)));
        abstractC1174p2.itemView.setTranslationY(-((int) ((i10 - i12) - translationY)));
        abstractC1174p2.itemView.setAlpha(0.0f);
        ArrayList arrayList = this.f3604k;
        C1151i c1151i = new C1151i();
        c1151i.f3578a = abstractC1174p1;
        c1151i.f3579b = abstractC1174p2;
        c1151i.f3580c = i11;
        c1151i.f3581d = i12;
        c1151i.f3582e = i6;
        c1151i.f3583f = i10;
        arrayList.add(c1151i);
        return true;
    }

    @Override
    public final void mo2954d(AbstractC1174p1 abstractC1174p1) {
        View view = abstractC1174p1.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f3603j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((C1154j) arrayList.get(size)).f3592a == abstractC1174p1) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m2990c(abstractC1174p1);
                arrayList.remove(size);
            }
        }
        m2959j(this.f3604k, abstractC1174p1);
        if (this.f3601h.remove(abstractC1174p1)) {
            view.setAlpha(1.0f);
            m2990c(abstractC1174p1);
        }
        if (this.f3602i.remove(abstractC1174p1)) {
            view.setAlpha(1.0f);
            m2990c(abstractC1174p1);
        }
        ArrayList arrayList2 = this.f3607n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            m2959j(arrayList3, abstractC1174p1);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f3606m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            for (int size4 = arrayList5.size() - 1; size4 >= 0; size4--) {
                if (((C1154j) arrayList5.get(size4)).f3592a == abstractC1174p1) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m2990c(abstractC1174p1);
                    arrayList5.remove(size4);
                    if (!arrayList5.isEmpty()) {
                        break;
                    }
                    arrayList4.remove(size3);
                    break;
                }
            }
        }
        ArrayList arrayList6 = this.f3605l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(abstractC1174p1)) {
                view.setAlpha(1.0f);
                m2990c(abstractC1174p1);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f3610q.remove(abstractC1174p1);
        this.f3608o.remove(abstractC1174p1);
        this.f3611r.remove(abstractC1174p1);
        this.f3609p.remove(abstractC1174p1);
        m2958i();
    }

    @Override
    public final void mo2955e() {
        ArrayList arrayList = this.f3603j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C1154j c1154j = (C1154j) arrayList.get(size);
            View view = c1154j.f3592a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m2990c(c1154j.f3592a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f3601h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            m2990c((AbstractC1174p1) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f3602i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) arrayList3.get(size3);
            abstractC1174p1.itemView.setAlpha(1.0f);
            m2990c(abstractC1174p1);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f3604k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            C1151i c1151i = (C1151i) arrayList4.get(size4);
            AbstractC1174p1 abstractC1174p2 = c1151i.f3578a;
            if (abstractC1174p2 != null) {
                m2960k(c1151i, abstractC1174p2);
            }
            AbstractC1174p1 abstractC1174p3 = c1151i.f3579b;
            if (abstractC1174p3 != null) {
                m2960k(c1151i, abstractC1174p3);
            }
        }
        arrayList4.clear();
        if (mo2956f()) {
            ArrayList arrayList5 = this.f3606m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    C1154j c1154j2 = (C1154j) arrayList6.get(size6);
                    View view2 = c1154j2.f3592a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m2990c(c1154j2.f3592a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f3605l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    AbstractC1174p1 abstractC1174p4 = (AbstractC1174p1) arrayList8.get(size8);
                    abstractC1174p4.itemView.setAlpha(1.0f);
                    m2990c(abstractC1174p4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.f3607n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    C1151i c1151i2 = (C1151i) arrayList10.get(size10);
                    AbstractC1174p1 abstractC1174p5 = c1151i2.f3578a;
                    if (abstractC1174p5 != null) {
                        m2960k(c1151i2, abstractC1174p5);
                    }
                    AbstractC1174p1 abstractC1174p6 = c1151i2.f3579b;
                    if (abstractC1174p6 != null) {
                        m2960k(c1151i2, abstractC1174p6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            m2952h(this.f3610q);
            m2952h(this.f3609p);
            m2952h(this.f3608o);
            m2952h(this.f3611r);
            ArrayList arrayList11 = this.f3688b;
            if (arrayList11.size() > 0) {
                throw AbstractC0004e.m17k(0, arrayList11);
            }
            arrayList11.clear();
        }
    }

    @Override
    public final boolean mo2956f() {
        return (this.f3602i.isEmpty() && this.f3604k.isEmpty() && this.f3603j.isEmpty() && this.f3601h.isEmpty() && this.f3609p.isEmpty() && this.f3610q.isEmpty() && this.f3608o.isEmpty() && this.f3611r.isEmpty() && this.f3606m.isEmpty() && this.f3605l.isEmpty() && this.f3607n.isEmpty()) ? false : true;
    }

    public final boolean m2957g(AbstractC1174p1 abstractC1174p1, int i6, int i10, int i11, int i12) {
        View view = abstractC1174p1.itemView;
        int translationX = i6 + ((int) view.getTranslationX());
        int translationY = i10 + ((int) abstractC1174p1.itemView.getTranslationY());
        m2961l(abstractC1174p1);
        int i13 = i11 - translationX;
        int i14 = i12 - translationY;
        if (i13 == 0 && i14 == 0) {
            m2990c(abstractC1174p1);
            return false;
        }
        if (i13 != 0) {
            view.setTranslationX(-i13);
        }
        if (i14 != 0) {
            view.setTranslationY(-i14);
        }
        ArrayList arrayList = this.f3603j;
        C1154j c1154j = new C1154j();
        c1154j.f3592a = abstractC1174p1;
        c1154j.f3593b = translationX;
        c1154j.f3594c = translationY;
        c1154j.f3595d = i11;
        c1154j.f3596e = i12;
        arrayList.add(c1154j);
        return true;
    }

    public final void m2958i() {
        if (mo2956f()) {
            return;
        }
        ArrayList arrayList = this.f3688b;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
        arrayList.clear();
    }

    public final void m2959j(ArrayList arrayList, AbstractC1174p1 abstractC1174p1) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C1151i c1151i = (C1151i) arrayList.get(size);
            if (m2960k(c1151i, abstractC1174p1) && c1151i.f3578a == null && c1151i.f3579b == null) {
                arrayList.remove(c1151i);
            }
        }
    }

    public final boolean m2960k(C1151i c1151i, AbstractC1174p1 abstractC1174p1) {
        if (c1151i.f3579b == abstractC1174p1) {
            c1151i.f3579b = null;
        } else {
            if (c1151i.f3578a != abstractC1174p1) {
                return false;
            }
            c1151i.f3578a = null;
        }
        abstractC1174p1.itemView.setAlpha(1.0f);
        abstractC1174p1.itemView.setTranslationX(0.0f);
        abstractC1174p1.itemView.setTranslationY(0.0f);
        m2990c(abstractC1174p1);
        return true;
    }

    public final void m2961l(AbstractC1174p1 abstractC1174p1) {
        if (f3599s == null) {
            f3599s = new ValueAnimator().getInterpolator();
        }
        abstractC1174p1.itemView.animate().setInterpolator(f3599s);
        mo2954d(abstractC1174p1);
    }
}
