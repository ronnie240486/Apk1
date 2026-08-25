package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.appcompat.app.RunnableC0126c;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p007a7.C0069f;
import p094j0.C2757e;
import p138n0.AbstractC3155s0;
import p215u.AbstractC3885h;

public final class C0407i {

    public final ViewGroup f1846a;

    public final ArrayList f1847b = new ArrayList();

    public final ArrayList f1848c = new ArrayList();

    public boolean f1849d = false;

    public boolean f1850e = false;

    public C0407i(ViewGroup viewGroup) {
        this.f1846a = viewGroup;
    }

    public static C0407i m1206f(ViewGroup viewGroup, C0396c0 c0396c0) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof C0407i) {
            return (C0407i) tag;
        }
        c0396c0.getClass();
        C0407i c0407i = new C0407i(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0407i);
        return c0407i;
    }

    public final void m1207a(int i6, int i10, C0422p0 c0422p0) {
        synchronized (this.f1847b) {
            try {
                C2757e c2757e = new C2757e();
                C0434v0 c0434v0M1210d = m1210d(c0422p0.f1933c);
                if (c0434v0M1210d != null) {
                    c0434v0M1210d.m1338c(i6, i10);
                    return;
                }
                C0434v0 c0434v0 = new C0434v0(i6, i10, c0422p0, c2757e);
                this.f1847b.add(c0434v0);
                c0434v0.f2010d.add(new RunnableC0432u0(this, c0434v0, 0));
                c0434v0.f2010d.add(new RunnableC0432u0(this, c0434v0, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m1208b(ArrayList arrayList, boolean z7) {
        Iterator it = arrayList.iterator();
        C0434v0 c0434v0 = null;
        C0434v0 c0434v1 = null;
        while (it.hasNext()) {
            C0434v0 c0434v2 = (C0434v0) it.next();
            int iM9c = AbstractC0004e.m9c(c0434v2.f2009c.f1951F);
            int iM7785a = AbstractC3885h.m7785a(c0434v2.f2007a);
            if (iM7785a != 0) {
                if (iM7785a != 1) {
                    if (iM7785a == 2 || iM7785a == 3) {
                    }
                } else if (iM9c != 2) {
                    c0434v1 = c0434v2;
                }
            }
            if (iM9c == 2 && c0434v0 == null) {
                c0434v0 = c0434v2;
            }
        }
        ArrayList<C0403g> arrayList2 = new ArrayList();
        ArrayList<C0405h> arrayList3 = new ArrayList();
        ArrayList<C0434v0> arrayList4 = new ArrayList(arrayList);
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z10 = false;
            if (!it2.hasNext()) {
                break;
            }
            C0434v0 c0434v3 = (C0434v0) it2.next();
            C2757e c2757e = new C2757e();
            c0434v3.m1339d();
            HashSet hashSet = c0434v3.f2011e;
            hashSet.add(c2757e);
            C0403g c0403g = new C0403g(c0434v3, c2757e);
            c0403g.f1844d = false;
            c0403g.f1843c = z7;
            arrayList2.add(c0403g);
            C2757e c2757e2 = new C2757e();
            c0434v3.m1339d();
            hashSet.add(c2757e2);
            if (!z7 ? c0434v3 == c0434v1 : c0434v3 == c0434v0) {
                z10 = true;
            }
            C0405h c0405h = new C0405h(c0434v3, c2757e2);
            int i6 = c0434v3.f2007a;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0434v3.f2009c;
            if (i6 == 2) {
                if (z7) {
                    abstractComponentCallbacksC0427s.getClass();
                } else {
                    abstractComponentCallbacksC0427s.getClass();
                }
                if (z7) {
                    abstractComponentCallbacksC0427s.getClass();
                } else {
                    abstractComponentCallbacksC0427s.getClass();
                }
            } else if (z7) {
                abstractComponentCallbacksC0427s.getClass();
            } else {
                abstractComponentCallbacksC0427s.getClass();
            }
            if (z10) {
                if (z7) {
                    abstractComponentCallbacksC0427s.getClass();
                } else {
                    abstractComponentCallbacksC0427s.getClass();
                }
            }
            arrayList3.add(c0405h);
            c0434v3.f2010d.add(new RunnableC0126c(this, arrayList4, c0434v3, 1));
        }
        HashMap map = new HashMap();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            C0434v0 c0434v4 = (C0434v0) ((C0405h) it3.next()).f268a;
            AbstractC0004e.m9c(c0434v4.f2009c.f1951F);
            int i10 = c0434v4.f2007a;
        }
        for (C0405h c0405h2 : arrayList3) {
            map.put((C0434v0) c0405h2.f268a, Boolean.FALSE);
            c0405h2.m373d();
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.f1846a;
        Context context = viewGroup.getContext();
        ArrayList<C0403g> arrayList5 = new ArrayList();
        boolean z11 = false;
        for (C0403g c0403g2 : arrayList2) {
            C0434v0 c0434v5 = (C0434v0) c0403g2.f268a;
            int iM9c2 = AbstractC0004e.m9c(c0434v5.f2009c.f1951F);
            int i11 = c0434v5.f2007a;
            if (iM9c2 == i11 || !(iM9c2 == 2 || i11 == 2)) {
                c0403g2.m373d();
            } else {
                C0069f c0069fM1205n = c0403g2.m1205n(context);
                if (c0069fM1205n == null) {
                    c0403g2.m373d();
                } else {
                    Animator animator = (Animator) c0069fM1205n.f197c;
                    if (animator == null) {
                        arrayList5.add(c0403g2);
                    } else {
                        C0434v0 c0434v6 = (C0434v0) c0403g2.f268a;
                        boolean zEquals = Boolean.TRUE.equals(map.get(c0434v6));
                        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = c0434v6.f2009c;
                        if (zEquals) {
                            if (Log.isLoggable("FragmentManager", 2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + abstractComponentCallbacksC0427s2 + " as this Fragment was involved in a Transition.");
                            }
                            c0403g2.m373d();
                        } else {
                            boolean z12 = c0434v6.f2007a == 3;
                            if (z12) {
                                arrayList4.remove(c0434v6);
                            }
                            View view = abstractComponentCallbacksC0427s2.f1951F;
                            viewGroup.startViewTransition(view);
                            animator.addListener(new C0395c(viewGroup, view, z12, c0434v6, c0403g2));
                            animator.setTarget(view);
                            animator.start();
                            ((C2757e) c0403g2.f269b).m5724a(new C0397d(0, animator));
                            z11 = true;
                        }
                    }
                }
            }
        }
        for (C0403g c0403g3 : arrayList5) {
            C0434v0 c0434v7 = (C0434v0) c0403g3.f268a;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 = c0434v7.f2009c;
            if (zContainsValue) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0427s3 + " as Animations cannot run alongside Transitions.");
                }
                c0403g3.m373d();
            } else if (z11) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0427s3 + " as Animations cannot run alongside Animators.");
                }
                c0403g3.m373d();
            } else {
                View view2 = abstractComponentCallbacksC0427s3.f1951F;
                C0069f c0069fM1205n2 = c0403g3.m1205n(context);
                c0069fM1205n2.getClass();
                Animation animation = (Animation) c0069fM1205n2.f196b;
                animation.getClass();
                if (c0434v7.f2007a != 1) {
                    view2.startAnimation(animation);
                    c0403g3.m373d();
                } else {
                    viewGroup.startViewTransition(view2);
                    RunnableC0435w runnableC0435w = new RunnableC0435w(animation, viewGroup, view2);
                    runnableC0435w.setAnimationListener(new AnimationAnimationListenerC0401f(viewGroup, view2, c0403g3));
                    view2.startAnimation(runnableC0435w);
                }
                ((C2757e) c0403g3.f269b).m5724a(new C0026b(view2, viewGroup, c0403g3, 6));
            }
        }
        for (C0434v0 c0434v8 : arrayList4) {
            AbstractC0004e.m7a(c0434v8.f2007a, c0434v8.f2009c.f1951F);
        }
        arrayList4.clear();
    }

    public final void m1209c() {
        if (this.f1850e) {
            return;
        }
        ViewGroup viewGroup = this.f1846a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (!viewGroup.isAttachedToWindow()) {
            m1211e();
            this.f1849d = false;
            return;
        }
        synchronized (this.f1847b) {
            try {
                if (!this.f1847b.isEmpty()) {
                    ArrayList<C0434v0> arrayList = new ArrayList(this.f1848c);
                    this.f1848c.clear();
                    for (C0434v0 c0434v0 : arrayList) {
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + c0434v0);
                        }
                        c0434v0.m1336a();
                        if (!c0434v0.f2013g) {
                            this.f1848c.add(c0434v0);
                        }
                    }
                    m1212g();
                    ArrayList arrayList2 = new ArrayList(this.f1847b);
                    this.f1847b.clear();
                    this.f1848c.addAll(arrayList2);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((C0434v0) it.next()).m1339d();
                    }
                    m1208b(arrayList2, this.f1849d);
                    this.f1849d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C0434v0 m1210d(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        for (C0434v0 c0434v0 : this.f1847b) {
            if (c0434v0.f2009c.equals(abstractComponentCallbacksC0427s) && !c0434v0.f2012f) {
                return c0434v0;
            }
        }
        return null;
    }

    public final void m1211e() {
        ViewGroup viewGroup = this.f1846a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f1847b) {
            try {
                m1212g();
                Iterator it = this.f1847b.iterator();
                while (it.hasNext()) {
                    ((C0434v0) it.next()).m1339d();
                }
                for (C0434v0 c0434v0 : new ArrayList(this.f1848c)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        sb.append(zIsAttachedToWindow ? "" : "Container " + this.f1846a + " is not attached to window. ");
                        sb.append("Cancelling running operation ");
                        sb.append(c0434v0);
                        Log.v("FragmentManager", sb.toString());
                    }
                    c0434v0.m1336a();
                }
                for (C0434v0 c0434v1 : new ArrayList(this.f1847b)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zIsAttachedToWindow ? "" : "Container " + this.f1846a + " is not attached to window. ");
                        sb2.append("Cancelling pending operation ");
                        sb2.append(c0434v1);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    c0434v1.m1336a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m1212g() {
        for (C0434v0 c0434v0 : this.f1847b) {
            if (c0434v0.f2008b == 2) {
                c0434v0.m1338c(AbstractC0004e.m8b(c0434v0.f2009c.m1313L().getVisibility()), 1);
            }
        }
    }
}
