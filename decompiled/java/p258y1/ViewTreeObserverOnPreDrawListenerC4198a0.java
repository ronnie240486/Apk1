package p258y1;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import p001a0.C0023f;
import p160p.C3341e;
import p160p.C3345i;

public final class ViewTreeObserverOnPreDrawListenerC4198a0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    public Transition f14265a;

    public ViewGroup f14266b;

    @Override
    public final boolean onPreDraw() {
        ArrayList arrayList;
        Transition transition;
        C0023f c0023f;
        C0023f c0023f2;
        C3341e c3341e;
        C3341e c3341e2;
        int i6;
        int[] iArr;
        int i10;
        int i11;
        C3341e c3341eM3045n;
        int i12;
        Animator animator;
        C4235x c4235x;
        View view;
        C4206e0 c4206e0;
        C4206e0 c4206e1;
        int i13;
        C0023f c0023f3;
        int i14;
        View view2;
        C4206e0 c4206e2;
        C3341e c3341e3;
        int i15;
        int i16;
        View view3;
        View view4;
        SparseArray sparseArray;
        int size;
        int i17;
        View view5;
        View view6;
        C3345i c3345i;
        int iM6803j;
        int i18;
        View view7;
        C0023f c0023f4;
        Iterator it;
        int i19 = 1;
        ViewGroup viewGroup = this.f14266b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList2 = AbstractC4200b0.f14276c;
        ViewGroup viewGroup2 = this.f14266b;
        if (!arrayList2.remove(viewGroup2)) {
            return true;
        }
        C3341e c3341eM8250b = AbstractC4200b0.m8250b();
        ArrayList arrayList3 = (ArrayList) c3341eM8250b.get(viewGroup2);
        if (arrayList3 != null) {
            arrayList = arrayList3.size() > 0 ? new ArrayList(arrayList3) : null;
            transition = this.f14265a;
            arrayList3.add(transition);
            transition.m3052a(new C4211h(this, c3341eM8250b));
            transition.m3055g(viewGroup2, false);
            if (arrayList != null) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo3066v(viewGroup2);
                }
            }
            transition.f3801k = new ArrayList();
            transition.f3802l = new ArrayList();
            c0023f = transition.f3797g;
            c0023f2 = transition.f3798h;
            c3341e = new C3341e((C3341e) c0023f.f44b);
            c3341e2 = new C3341e((C3341e) c0023f2.f44b);
            i6 = 0;
            while (true) {
                iArr = transition.f3800j;
                if (i6 < iArr.length) {
                    break;
                }
                i13 = iArr[i6];
                if (i13 != i19) {
                    c0023f3 = c0023f;
                    for (i14 = c3341e.f11334c - 1; i14 >= 0; i14--) {
                        view2 = (View) c3341e.m6812f(i14);
                        if (view2 == null && transition.m3063r(view2) && (c4206e2 = (C4206e0) c3341e2.remove(view2)) != null && transition.m3063r(c4206e2.f14293b)) {
                            transition.f3801k.add((C4206e0) c3341e.mo6814h(i14));
                            transition.f3802l.add(c4206e2);
                        }
                    }
                } else if (i13 != 2) {
                    c0023f3 = c0023f;
                    c3341e3 = (C3341e) c0023f3.f47e;
                    C3341e c3341e4 = (C3341e) c0023f2.f47e;
                    i15 = c3341e3.f11334c;
                    for (i16 = 0; i16 < i15; i16++) {
                        view3 = (View) c3341e3.m6816j(i16);
                        if (view3 == null && transition.m3063r(view3) && (view4 = (View) c3341e4.get(c3341e3.m6812f(i16))) != null && transition.m3063r(view4)) {
                            C4206e0 c4206e3 = (C4206e0) c3341e.get(view3);
                            C4206e0 c4206e4 = (C4206e0) c3341e2.get(view4);
                            if (c4206e3 != null && c4206e4 != null) {
                                transition.f3801k.add(c4206e3);
                                transition.f3802l.add(c4206e4);
                                c3341e.remove(view3);
                                c3341e2.remove(view4);
                            }
                        }
                    }
                } else if (i13 != 3) {
                    if (i13 == 4) {
                        c3345i = (C3345i) c0023f.f46d;
                        iM6803j = c3345i.m6803j();
                        i18 = 0;
                        while (i18 < iM6803j) {
                            view7 = (View) c3345i.m6804k(i18);
                            if (view7 == null && transition.m3063r(view7)) {
                                c0023f4 = c0023f;
                                View view8 = (View) ((C3345i) c0023f2.f46d).m6797d(c3345i.m6800g(i18));
                                if (view8 != null && transition.m3063r(view8)) {
                                    C4206e0 c4206e5 = (C4206e0) c3341e.get(view7);
                                    C4206e0 c4206e6 = (C4206e0) c3341e2.get(view8);
                                    if (c4206e5 != null && c4206e6 != null) {
                                        transition.f3801k.add(c4206e5);
                                        transition.f3802l.add(c4206e6);
                                        c3341e.remove(view7);
                                        c3341e2.remove(view8);
                                    }
                                }
                            } else {
                                c0023f4 = c0023f;
                            }
                            i18 += i19;
                            c0023f = c0023f4;
                        }
                    }
                    c0023f3 = c0023f;
                } else {
                    c0023f3 = c0023f;
                    sparseArray = (SparseArray) c0023f3.f45c;
                    SparseArray sparseArray2 = (SparseArray) c0023f2.f45c;
                    size = sparseArray.size();
                    for (i17 = 0; i17 < size; i17++) {
                        view5 = (View) sparseArray.valueAt(i17);
                        if (view5 == null && transition.m3063r(view5) && (view6 = (View) sparseArray2.get(sparseArray.keyAt(i17))) != null && transition.m3063r(view6)) {
                            C4206e0 c4206e7 = (C4206e0) c3341e.get(view5);
                            C4206e0 c4206e8 = (C4206e0) c3341e2.get(view6);
                            if (c4206e7 != null && c4206e8 != null) {
                                transition.f3801k.add(c4206e7);
                                transition.f3802l.add(c4206e8);
                                c3341e.remove(view5);
                                c3341e2.remove(view6);
                            }
                        }
                    }
                }
                i6++;
                c0023f = c0023f3;
                i19 = 1;
            }
            for (i10 = 0; i10 < c3341e.f11334c; i10++) {
                c4206e1 = (C4206e0) c3341e.m6816j(i10);
                if (transition.m3063r(c4206e1.f14293b)) {
                    transition.f3801k.add(c4206e1);
                    transition.f3802l.add(null);
                }
            }
            for (i11 = 0; i11 < c3341e2.f11334c; i11++) {
                c4206e0 = (C4206e0) c3341e2.m6816j(i11);
                if (transition.m3063r(c4206e0.f14293b)) {
                    transition.f3802l.add(c4206e0);
                    transition.f3801k.add(null);
                }
            }
            c3341eM3045n = Transition.m3045n();
            int i20 = c3341eM3045n.f11334c;
            C4212h0 c4212h0 = AbstractC4210g0.f14313a;
            WindowId windowId = viewGroup2.getWindowId();
            for (i12 = i20 - 1; i12 >= 0; i12--) {
                animator = (Animator) c3341eM3045n.m6812f(i12);
                if (animator == null && (c4235x = (C4235x) c3341eM3045n.get(animator)) != null && (view = c4235x.f14392a) != null && c4235x.f14395d.f14366a.equals(windowId)) {
                    C4206e0 c4206e0M3061p = transition.m3061p(view, true);
                    C4206e0 c4206e0M3060m = transition.m3060m(view, true);
                    if (c4206e0M3061p == null && c4206e0M3060m == null) {
                        c4206e0M3060m = (C4206e0) ((C3341e) transition.f3798h.f44b).get(view);
                    }
                    if ((c4206e0M3061p != null || c4206e0M3060m != null) && c4235x.f14396e.mo3062q(c4235x.f14394c, c4206e0M3060m)) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            c3341eM3045n.remove(animator);
                        }
                    }
                }
            }
            transition.mo3058k(viewGroup2, transition.f3797g, transition.f3798h, transition.f3801k, transition.f3802l);
            transition.mo3067w();
            return true;
        }
        arrayList3 = new ArrayList();
        c3341eM8250b.put(viewGroup2, arrayList3);
        transition = this.f14265a;
        arrayList3.add(transition);
        transition.m3052a(new C4211h(this, c3341eM8250b));
        transition.m3055g(viewGroup2, false);
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).mo3066v(viewGroup2);
            }
        }
        transition.f3801k = new ArrayList();
        transition.f3802l = new ArrayList();
        c0023f = transition.f3797g;
        c0023f2 = transition.f3798h;
        c3341e = new C3341e((C3341e) c0023f.f44b);
        c3341e2 = new C3341e((C3341e) c0023f2.f44b);
        i6 = 0;
        while (true) {
            iArr = transition.f3800j;
            if (i6 < iArr.length) {
                break;
                break;
            }
            i13 = iArr[i6];
            if (i13 != i19) {
                c0023f3 = c0023f;
                while (i14 >= 0) {
                    view2 = (View) c3341e.m6812f(i14);
                    if (view2 == null) {
                    }
                }
            } else if (i13 != 2) {
                c0023f3 = c0023f;
                c3341e3 = (C3341e) c0023f3.f47e;
                C3341e c3341e5 = (C3341e) c0023f2.f47e;
                i15 = c3341e3.f11334c;
                while (i16 < i15) {
                    view3 = (View) c3341e3.m6816j(i16);
                    if (view3 == null) {
                    }
                }
            } else if (i13 != 3) {
                if (i13 == 4) {
                    c3345i = (C3345i) c0023f.f46d;
                    iM6803j = c3345i.m6803j();
                    i18 = 0;
                    while (i18 < iM6803j) {
                        view7 = (View) c3345i.m6804k(i18);
                        if (view7 == null) {
                            c0023f4 = c0023f;
                        } else {
                            c0023f4 = c0023f;
                        }
                        i18 += i19;
                        c0023f = c0023f4;
                    }
                }
                c0023f3 = c0023f;
            } else {
                c0023f3 = c0023f;
                sparseArray = (SparseArray) c0023f3.f45c;
                SparseArray sparseArray3 = (SparseArray) c0023f2.f45c;
                size = sparseArray.size();
                while (i17 < size) {
                    view5 = (View) sparseArray.valueAt(i17);
                    if (view5 == null) {
                    }
                }
            }
            i6++;
            c0023f = c0023f3;
            i19 = 1;
        }
        while (i10 < c3341e.f11334c) {
            c4206e1 = (C4206e0) c3341e.m6816j(i10);
            if (transition.m3063r(c4206e1.f14293b)) {
                transition.f3801k.add(c4206e1);
                transition.f3802l.add(null);
            }
        }
        while (i11 < c3341e2.f11334c) {
            c4206e0 = (C4206e0) c3341e2.m6816j(i11);
            if (transition.m3063r(c4206e0.f14293b)) {
                transition.f3802l.add(c4206e0);
                transition.f3801k.add(null);
            }
        }
        c3341eM3045n = Transition.m3045n();
        int i21 = c3341eM3045n.f11334c;
        C4212h0 c4212h1 = AbstractC4210g0.f14313a;
        WindowId windowId2 = viewGroup2.getWindowId();
        while (i12 >= 0) {
            animator = (Animator) c3341eM3045n.m6812f(i12);
            if (animator == null) {
            }
        }
        transition.mo3058k(viewGroup2, transition.f3797g, transition.f3798h, transition.f3801k, transition.f3802l);
        transition.mo3067w();
        return true;
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f14266b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList = AbstractC4200b0.f14276c;
        ViewGroup viewGroup2 = this.f14266b;
        arrayList.remove(viewGroup2);
        ArrayList arrayList2 = (ArrayList) AbstractC4200b0.m8250b().get(viewGroup2);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).mo3066v(viewGroup2);
            }
        }
        this.f14265a.m3056h(true);
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
    }
}
