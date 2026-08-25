package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p001a0.C0023f;
import p006a6.C0062a;
import p007a7.C0067d;
import p046e0.AbstractC2343b;
import p055ea.AbstractC2460q;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p160p.C3341e;
import p160p.C3345i;
import p258y1.AbstractC4210g0;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4212h0;
import p258y1.C4226o0;
import p258y1.C4234w;
import p258y1.C4235x;
import p258y1.InterfaceC4236y;

public abstract class Transition implements Cloneable {

    public static final int[] f3788u = {2, 1, 3, 4};

    public static final C4234w f3789v = new C4234w();

    public static final ThreadLocal f3790w = new ThreadLocal();

    public final String f3791a;

    public long f3792b;

    public long f3793c;

    public TimeInterpolator f3794d;

    public final ArrayList f3795e;

    public final ArrayList f3796f;

    public C0023f f3797g;

    public C0023f f3798h;

    public TransitionSet f3799i;

    public final int[] f3800j;

    public ArrayList f3801k;

    public ArrayList f3802l;

    public final ArrayList f3803m;

    public int f3804n;

    public boolean f3805o;

    public boolean f3806p;

    public ArrayList f3807q;

    public ArrayList f3808r;

    public AbstractC4233v f3809s;

    public C4234w f3810t;

    public Transition() {
        this.f3791a = getClass().getName();
        this.f3792b = -1L;
        this.f3793c = -1L;
        this.f3794d = null;
        this.f3795e = new ArrayList();
        this.f3796f = new ArrayList();
        this.f3797g = new C0023f(12);
        this.f3798h = new C0023f(12);
        this.f3799i = null;
        this.f3800j = f3788u;
        this.f3803m = new ArrayList();
        this.f3804n = 0;
        this.f3805o = false;
        this.f3806p = false;
        this.f3807q = null;
        this.f3808r = new ArrayList();
        this.f3810t = f3789v;
    }

    public static void m3044b(C0023f c0023f, View view, C4206e0 c4206e0) {
        ((C3341e) c0023f.f44b).put(view, c4206e0);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) c0023f.f45c;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        String strM6172k = AbstractC3119g0.m6172k(view);
        if (strM6172k != null) {
            C3341e c3341e = (C3341e) c0023f.f47e;
            if (c3341e.containsKey(strM6172k)) {
                c3341e.put(strM6172k, null);
            } else {
                c3341e.put(strM6172k, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                C3345i c3345i = (C3345i) c0023f.f46d;
                if (c3345i.m6799f(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    c3345i.m6801h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) c3345i.m6797d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    c3345i.m6801h(itemIdAtPosition, null);
                }
            }
        }
    }

    public static C3341e m3045n() {
        ThreadLocal threadLocal = f3790w;
        C3341e c3341e = (C3341e) threadLocal.get();
        if (c3341e != null) {
            return c3341e;
        }
        C3341e c3341e2 = new C3341e(0);
        threadLocal.set(c3341e2);
        return c3341e2;
    }

    public static boolean m3046s(C4206e0 c4206e0, C4206e0 c4206e1, String str) {
        Object obj = c4206e0.f14292a.get(str);
        Object obj2 = c4206e1.f14292a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void mo3047A(C4234w c4234w) {
        if (c4234w == null) {
            this.f3810t = f3789v;
        } else {
            this.f3810t = c4234w;
        }
    }

    public void mo3048B(AbstractC4233v abstractC4233v) {
        this.f3809s = abstractC4233v;
    }

    public void mo3049C(long j10) {
        this.f3792b = j10;
    }

    public final void m3050D() {
        if (this.f3804n == 0) {
            ArrayList arrayList = this.f3807q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f3807q.clone();
                int size = arrayList2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((InterfaceC4236y) arrayList2.get(i6)).mo8255a();
                }
            }
            this.f3806p = false;
        }
        this.f3804n++;
    }

    public String mo3051E(String str) {
        StringBuilder sbM5498l = AbstractC2460q.m5498l(str);
        sbM5498l.append(getClass().getSimpleName());
        sbM5498l.append("@");
        sbM5498l.append(Integer.toHexString(hashCode()));
        sbM5498l.append(": ");
        String string = sbM5498l.toString();
        if (this.f3793c != -1) {
            string = AbstractC0004e.m25s(AbstractC0004e.m29w(string, "dur("), this.f3793c, ") ");
        }
        if (this.f3792b != -1) {
            string = AbstractC0004e.m25s(AbstractC0004e.m29w(string, "dly("), this.f3792b, ") ");
        }
        if (this.f3794d != null) {
            StringBuilder sbM29w = AbstractC0004e.m29w(string, "interp(");
            sbM29w.append(this.f3794d);
            sbM29w.append(") ");
            string = sbM29w.toString();
        }
        ArrayList arrayList = this.f3795e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f3796f;
        if (size <= 0 && arrayList2.size() <= 0) {
            return string;
        }
        String strM5494h = AbstractC2460q.m5494h(string, "tgts(");
        if (arrayList.size() > 0) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (i6 > 0) {
                    strM5494h = AbstractC2460q.m5494h(strM5494h, ", ");
                }
                StringBuilder sbM5498l2 = AbstractC2460q.m5498l(strM5494h);
                sbM5498l2.append(arrayList.get(i6));
                strM5494h = sbM5498l2.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                if (i10 > 0) {
                    strM5494h = AbstractC2460q.m5494h(strM5494h, ", ");
                }
                StringBuilder sbM5498l3 = AbstractC2460q.m5498l(strM5494h);
                sbM5498l3.append(arrayList2.get(i10));
                strM5494h = sbM5498l3.toString();
            }
        }
        return AbstractC2460q.m5494h(strM5494h, ")");
    }

    public void m3052a(InterfaceC4236y interfaceC4236y) {
        if (this.f3807q == null) {
            this.f3807q = new ArrayList();
        }
        this.f3807q.add(interfaceC4236y);
    }

    public abstract void mo3030c(C4206e0 c4206e0);

    public final void m3053d(View view, boolean z7) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            C4206e0 c4206e0 = new C4206e0(view);
            if (z7) {
                mo3031f(c4206e0);
            } else {
                mo3030c(c4206e0);
            }
            c4206e0.f14294c.add(this);
            mo3054e(c4206e0);
            if (z7) {
                m3044b(this.f3797g, view, c4206e0);
            } else {
                m3044b(this.f3798h, view, c4206e0);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                m3053d(viewGroup.getChildAt(i6), z7);
            }
        }
    }

    public void mo3054e(C4206e0 c4206e0) {
        if (this.f3809s != null) {
            HashMap map = c4206e0.f14292a;
            if (map.isEmpty()) {
                return;
            }
            this.f3809s.getClass();
            String[] strArr = AbstractC4233v.f14380j;
            for (int i6 = 0; i6 < 2; i6++) {
                if (!map.containsKey(strArr[i6])) {
                    this.f3809s.getClass();
                    Integer numValueOf = (Integer) map.get("android:visibility:visibility");
                    View view = c4206e0.f14293b;
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(view.getVisibility());
                    }
                    map.put("android:visibilityPropagation:visibility", numValueOf);
                    int[] iArr = {iRound, 0};
                    view.getLocationOnScreen(iArr);
                    int iRound = Math.round(view.getTranslationX()) + iArr[0];
                    iArr[0] = (view.getWidth() / 2) + iRound;
                    int iRound2 = Math.round(view.getTranslationY()) + iArr[1];
                    iArr[1] = iRound2;
                    iArr[1] = (view.getHeight() / 2) + iRound2;
                    map.put("android:visibilityPropagation:center", iArr);
                    return;
                }
            }
        }
    }

    public abstract void mo3031f(C4206e0 c4206e0);

    public final void m3055g(ViewGroup viewGroup, boolean z7) {
        m3056h(z7);
        ArrayList arrayList = this.f3795e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f3796f;
        if (size <= 0 && arrayList2.size() <= 0) {
            m3053d(viewGroup, z7);
            return;
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i6)).intValue());
            if (viewFindViewById != null) {
                C4206e0 c4206e0 = new C4206e0(viewFindViewById);
                if (z7) {
                    mo3031f(c4206e0);
                } else {
                    mo3030c(c4206e0);
                }
                c4206e0.f14294c.add(this);
                mo3054e(c4206e0);
                if (z7) {
                    m3044b(this.f3797g, viewFindViewById, c4206e0);
                } else {
                    m3044b(this.f3798h, viewFindViewById, c4206e0);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            View view = (View) arrayList2.get(i10);
            C4206e0 c4206e1 = new C4206e0(view);
            if (z7) {
                mo3031f(c4206e1);
            } else {
                mo3030c(c4206e1);
            }
            c4206e1.f14294c.add(this);
            mo3054e(c4206e1);
            if (z7) {
                m3044b(this.f3797g, view, c4206e1);
            } else {
                m3044b(this.f3798h, view, c4206e1);
            }
        }
    }

    public final void m3056h(boolean z7) {
        if (z7) {
            ((C3341e) this.f3797g.f44b).clear();
            ((SparseArray) this.f3797g.f45c).clear();
            ((C3345i) this.f3797g.f46d).m6795b();
        } else {
            ((C3341e) this.f3798h.f44b).clear();
            ((SparseArray) this.f3798h.f45c).clear();
            ((C3345i) this.f3798h.f46d).m6795b();
        }
    }

    @Override
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.f3808r = new ArrayList();
            transition.f3797g = new C0023f(12);
            transition.f3798h = new C0023f(12);
            transition.f3801k = null;
            transition.f3802l = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        return null;
    }

    public void mo3058k(ViewGroup viewGroup, C0023f c0023f, C0023f c0023f2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorMo3032j;
        int i6;
        View view;
        C4206e0 c4206e0;
        C3341e c3341eM3045n = m3045n();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i10 = 0;
        while (i10 < size) {
            C4206e0 c4206e1 = (C4206e0) arrayList.get(i10);
            C4206e0 c4206e2 = (C4206e0) arrayList2.get(i10);
            if (c4206e1 != null && !c4206e1.f14294c.contains(this)) {
                c4206e1 = null;
            }
            if (c4206e2 != null && !c4206e2.f14294c.contains(this)) {
                c4206e2 = null;
            }
            if (!(c4206e1 == null && c4206e2 == null) && ((c4206e1 == null || c4206e2 == null || mo3062q(c4206e1, c4206e2)) && (animatorMo3032j = mo3032j(viewGroup, c4206e1, c4206e2)) != null)) {
                String str = this.f3791a;
                if (c4206e2 != null) {
                    String[] strArrMo3033o = mo3033o();
                    view = c4206e2.f14293b;
                    if (strArrMo3033o != null && strArrMo3033o.length > 0) {
                        c4206e0 = new C4206e0(view);
                        C4206e0 c4206e3 = (C4206e0) ((C3341e) c0023f2.f44b).get(view);
                        if (c4206e3 != null) {
                            int i11 = 0;
                            while (i11 < strArrMo3033o.length) {
                                HashMap map = c4206e0.f14292a;
                                int i12 = i10;
                                String str2 = strArrMo3033o[i11];
                                map.put(str2, c4206e3.f14292a.get(str2));
                                i11++;
                                i10 = i12;
                                strArrMo3033o = strArrMo3033o;
                            }
                            i6 = i10;
                        } else {
                            i6 = i10;
                        }
                        int i13 = c3341eM3045n.f11334c;
                        for (int i14 = 0; i14 < i13; i14++) {
                            C4235x c4235x = (C4235x) c3341eM3045n.get((Animator) c3341eM3045n.m6812f(i14));
                            if (c4235x.f14394c != null && c4235x.f14392a == view && c4235x.f14393b.equals(str) && c4235x.f14394c.equals(c4206e0)) {
                                animatorMo3032j = null;
                                break;
                            }
                        }
                    } else {
                        i6 = i10;
                        animatorMo3032j = animatorMo3032j;
                        c4206e0 = null;
                    }
                    animatorMo3032j = animatorMo3032j;
                } else {
                    i6 = i10;
                    view = c4206e1.f14293b;
                    c4206e0 = null;
                }
                if (animatorMo3032j != null) {
                    AbstractC4233v abstractC4233v = this.f3809s;
                    if (abstractC4233v != null) {
                        long jMo8267e = abstractC4233v.mo8267e(viewGroup, this, c4206e1, c4206e2);
                        sparseIntArray.put(this.f3808r.size(), (int) jMo8267e);
                        jMin = Math.min(jMo8267e, jMin);
                    }
                    C4212h0 c4212h0 = AbstractC4210g0.f14313a;
                    C4226o0 c4226o0 = new C4226o0(viewGroup);
                    C4235x c4235x2 = new C4235x();
                    c4235x2.f14392a = view;
                    c4235x2.f14393b = str;
                    c4235x2.f14394c = c4206e0;
                    c4235x2.f14395d = c4226o0;
                    c4235x2.f14396e = this;
                    c3341eM3045n.put(animatorMo3032j, c4235x2);
                    this.f3808r.add(animatorMo3032j);
                }
            } else {
                size = size;
                i6 = i10;
            }
            i10 = i6 + 1;
            size = size;
        }
        if (sparseIntArray.size() != 0) {
            for (int i15 = 0; i15 < sparseIntArray.size(); i15++) {
                Animator animator = (Animator) this.f3808r.get(sparseIntArray.keyAt(i15));
                animator.setStartDelay(animator.getStartDelay() + (((long) sparseIntArray.valueAt(i15)) - jMin));
            }
        }
    }

    public final void m3059l() {
        int i6 = this.f3804n - 1;
        this.f3804n = i6;
        if (i6 == 0) {
            ArrayList arrayList = this.f3807q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f3807q.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((InterfaceC4236y) arrayList2.get(i10)).mo8254e(this);
                }
            }
            for (int i11 = 0; i11 < ((C3345i) this.f3797g.f46d).m6803j(); i11++) {
                View view = (View) ((C3345i) this.f3797g.f46d).m6804k(i11);
                if (view != null) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    view.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < ((C3345i) this.f3798h.f46d).m6803j(); i12++) {
                View view2 = (View) ((C3345i) this.f3798h.f46d).m6804k(i12);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                    view2.setHasTransientState(false);
                }
            }
            this.f3806p = true;
        }
    }

    public final C4206e0 m3060m(View view, boolean z7) {
        TransitionSet transitionSet = this.f3799i;
        if (transitionSet != null) {
            return transitionSet.m3060m(view, z7);
        }
        ArrayList arrayList = z7 ? this.f3801k : this.f3802l;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            }
            C4206e0 c4206e0 = (C4206e0) arrayList.get(i6);
            if (c4206e0 == null) {
                return null;
            }
            if (c4206e0.f14293b == view) {
                break;
            }
            i6++;
        }
        if (i6 >= 0) {
            return (C4206e0) (z7 ? this.f3802l : this.f3801k).get(i6);
        }
        return null;
    }

    public String[] mo3033o() {
        return null;
    }

    public final C4206e0 m3061p(View view, boolean z7) {
        TransitionSet transitionSet = this.f3799i;
        if (transitionSet != null) {
            return transitionSet.m3061p(view, z7);
        }
        return (C4206e0) ((C3341e) (z7 ? this.f3797g : this.f3798h).f44b).get(view);
    }

    public boolean mo3062q(C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e0 == null || c4206e1 == null) {
            return false;
        }
        String[] strArrMo3033o = mo3033o();
        if (strArrMo3033o == null) {
            Iterator it = c4206e0.f14292a.keySet().iterator();
            while (it.hasNext()) {
                if (m3046s(c4206e0, c4206e1, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrMo3033o) {
            if (!m3046s(c4206e0, c4206e1, str)) {
            }
        }
        return false;
        return true;
    }

    public final boolean m3063r(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f3795e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f3796f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public void mo3064t(ViewGroup viewGroup) {
        if (this.f3806p) {
            return;
        }
        C3341e c3341eM3045n = m3045n();
        int i6 = c3341eM3045n.f11334c;
        C4212h0 c4212h0 = AbstractC4210g0.f14313a;
        WindowId windowId = viewGroup.getWindowId();
        for (int i10 = i6 - 1; i10 >= 0; i10--) {
            C4235x c4235x = (C4235x) c3341eM3045n.m6816j(i10);
            if (c4235x.f14392a != null && c4235x.f14395d.f14366a.equals(windowId)) {
                ((Animator) c3341eM3045n.m6812f(i10)).pause();
            }
        }
        ArrayList arrayList = this.f3807q;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f3807q.clone();
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((InterfaceC4236y) arrayList2.get(i11)).mo8251b();
            }
        }
        this.f3805o = true;
    }

    public final String toString() {
        return mo3051E("");
    }

    public void m3065u(InterfaceC4236y interfaceC4236y) {
        ArrayList arrayList = this.f3807q;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC4236y);
        if (this.f3807q.size() == 0) {
            this.f3807q = null;
        }
    }

    public void mo3066v(View view) {
        if (this.f3805o) {
            if (!this.f3806p) {
                C3341e c3341eM3045n = m3045n();
                int i6 = c3341eM3045n.f11334c;
                C4212h0 c4212h0 = AbstractC4210g0.f14313a;
                WindowId windowId = view.getWindowId();
                for (int i10 = i6 - 1; i10 >= 0; i10--) {
                    C4235x c4235x = (C4235x) c3341eM3045n.m6816j(i10);
                    if (c4235x.f14392a != null && c4235x.f14395d.f14366a.equals(windowId)) {
                        ((Animator) c3341eM3045n.m6812f(i10)).resume();
                    }
                }
                ArrayList arrayList = this.f3807q;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f3807q.clone();
                    int size = arrayList2.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((InterfaceC4236y) arrayList2.get(i11)).mo8252c();
                    }
                }
            }
            this.f3805o = false;
        }
    }

    public void mo3067w() {
        m3050D();
        C3341e c3341eM3045n = m3045n();
        for (Animator animator : this.f3808r) {
            if (c3341eM3045n.containsKey(animator)) {
                m3050D();
                if (animator != null) {
                    animator.addListener(new C0067d(4, this, c3341eM3045n, false));
                    long j10 = this.f3793c;
                    if (j10 >= 0) {
                        animator.setDuration(j10);
                    }
                    long j11 = this.f3792b;
                    if (j11 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j11);
                    }
                    TimeInterpolator timeInterpolator = this.f3794d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new C0062a(8, this));
                    animator.start();
                }
            }
        }
        this.f3808r.clear();
        m3059l();
    }

    public void mo3068x(long j10) {
        this.f3793c = j10;
    }

    public void mo3070z(TimeInterpolator timeInterpolator) {
        this.f3794d = timeInterpolator;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        this.f3791a = getClass().getName();
        this.f3792b = -1L;
        this.f3793c = -1L;
        this.f3794d = null;
        this.f3795e = new ArrayList();
        this.f3796f = new ArrayList();
        this.f3797g = new C0023f(12);
        this.f3798h = new C0023f(12);
        this.f3799i = null;
        int[] iArr = f3788u;
        this.f3800j = iArr;
        this.f3803m = new ArrayList();
        this.f3804n = 0;
        this.f3805o = false;
        this.f3806p = false;
        this.f3807q = null;
        this.f3808r = new ArrayList();
        this.f3810t = f3789v;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14371a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jM5317c = AbstractC2343b.m5317c(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (jM5317c >= 0) {
            mo3068x(jM5317c);
        }
        long j10 = AbstractC2343b.m5319e(xmlResourceParser, "startDelay") ? typedArrayObtainStyledAttributes.getInt(2, -1) : -1;
        if (j10 > 0) {
            mo3049C(j10);
        }
        int resourceId = !AbstractC2343b.m5319e(xmlResourceParser, "interpolator") ? 0 : typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            mo3070z(AnimationUtils.loadInterpolator(context, resourceId));
        }
        String strM5318d = AbstractC2343b.m5318d(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strM5318d != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM5318d, ",");
            int[] iArr2 = new int[stringTokenizer.countTokens()];
            int i6 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String strTrim = stringTokenizer.nextToken().trim();
                if (TtmlNode.ATTR_ID.equalsIgnoreCase(strTrim)) {
                    iArr2[i6] = 3;
                } else if ("instance".equalsIgnoreCase(strTrim)) {
                    iArr2[i6] = 1;
                } else if (SerializableCookie.NAME.equalsIgnoreCase(strTrim)) {
                    iArr2[i6] = 2;
                } else if ("itemId".equalsIgnoreCase(strTrim)) {
                    iArr2[i6] = 4;
                } else if (strTrim.isEmpty()) {
                    int[] iArr3 = new int[iArr2.length - 1];
                    System.arraycopy(iArr2, 0, iArr3, 0, i6);
                    i6--;
                    iArr2 = iArr3;
                } else {
                    throw new InflateException(AbstractC0004e.m24r("Unknown match type in matchOrder: '", strTrim, "'"));
                }
                i6++;
            }
            if (iArr2.length == 0) {
                this.f3800j = iArr;
            } else {
                for (int i10 = 0; i10 < iArr2.length; i10++) {
                    int i11 = iArr2[i10];
                    if (i11 < 1 || i11 > 4) {
                        throw new IllegalArgumentException("matches contains invalid value");
                    }
                    for (int i12 = 0; i12 < i10; i12++) {
                        if (iArr2[i12] == i11) {
                            throw new IllegalArgumentException("matches contains a duplicate value");
                        }
                    }
                }
                this.f3800j = (int[]) iArr2.clone();
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void mo3069y(AbstractC4233v abstractC4233v) {
    }
}
