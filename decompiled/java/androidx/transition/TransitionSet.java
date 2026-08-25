package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.AbstractC0004e;
import p001a0.C0023f;
import p046e0.AbstractC2343b;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4219l;
import p258y1.C4234w;

public class TransitionSet extends Transition {

    public boolean f3811A;

    public int f3812B;

    public ArrayList f3813x;

    public boolean f3814y;

    public int f3815z;

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3813x = new ArrayList();
        this.f3814y = true;
        this.f3811A = false;
        this.f3812B = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14377g);
        m3074I(AbstractC2343b.m5317c(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override
    public final void mo3047A(C4234w c4234w) {
        super.mo3047A(c4234w);
        this.f3812B |= 4;
        if (this.f3813x != null) {
            for (int i6 = 0; i6 < this.f3813x.size(); i6++) {
                ((Transition) this.f3813x.get(i6)).mo3047A(c4234w);
            }
        }
    }

    @Override
    public final void mo3048B(AbstractC4233v abstractC4233v) {
        this.f3809s = abstractC4233v;
        this.f3812B |= 2;
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Transition) this.f3813x.get(i6)).mo3048B(abstractC4233v);
        }
    }

    @Override
    public final void mo3049C(long j10) {
        this.f3792b = j10;
    }

    @Override
    public final String mo3051E(String str) {
        String strMo3051E = super.mo3051E(str);
        for (int i6 = 0; i6 < this.f3813x.size(); i6++) {
            StringBuilder sbM29w = AbstractC0004e.m29w(strMo3051E, "\n");
            sbM29w.append(((Transition) this.f3813x.get(i6)).mo3051E(str + "  "));
            strMo3051E = sbM29w.toString();
        }
        return strMo3051E;
    }

    public final void m3071F(Transition transition) {
        this.f3813x.add(transition);
        transition.f3799i = this;
        long j10 = this.f3793c;
        if (j10 >= 0) {
            transition.mo3068x(j10);
        }
        if ((this.f3812B & 1) != 0) {
            transition.mo3070z(this.f3794d);
        }
        if ((this.f3812B & 2) != 0) {
            transition.mo3048B(this.f3809s);
        }
        if ((this.f3812B & 4) != 0) {
            transition.mo3047A(this.f3810t);
        }
        if ((this.f3812B & 8) != 0) {
            transition.mo3069y(null);
        }
    }

    @Override
    public final void mo3068x(long j10) {
        ArrayList arrayList;
        this.f3793c = j10;
        if (j10 < 0 || (arrayList = this.f3813x) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Transition) this.f3813x.get(i6)).mo3068x(j10);
        }
    }

    @Override
    public final void mo3070z(TimeInterpolator timeInterpolator) {
        this.f3812B |= 1;
        ArrayList arrayList = this.f3813x;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((Transition) this.f3813x.get(i6)).mo3070z(timeInterpolator);
            }
        }
        this.f3794d = timeInterpolator;
    }

    public final void m3074I(int i6) {
        if (i6 == 0) {
            this.f3814y = true;
        } else {
            if (i6 != 1) {
                throw new AndroidRuntimeException(AbstractC0004e.m20n(i6, "Invalid parameter for TransitionSet ordering: "));
            }
            this.f3814y = false;
        }
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        if (m3063r(c4206e0.f14293b)) {
            for (Transition transition : this.f3813x) {
                if (transition.m3063r(c4206e0.f14293b)) {
                    transition.mo3030c(c4206e0);
                    c4206e0.f14294c.add(transition);
                }
            }
        }
    }

    @Override
    public final void mo3054e(C4206e0 c4206e0) {
        super.mo3054e(c4206e0);
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Transition) this.f3813x.get(i6)).mo3054e(c4206e0);
        }
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        if (m3063r(c4206e0.f14293b)) {
            for (Transition transition : this.f3813x) {
                if (transition.m3063r(c4206e0.f14293b)) {
                    transition.mo3031f(c4206e0);
                    c4206e0.f14294c.add(transition);
                }
            }
        }
    }

    @Override
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f3813x = new ArrayList();
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            Transition transitionClone = ((Transition) this.f3813x.get(i6)).clone();
            transitionSet.f3813x.add(transitionClone);
            transitionClone.f3799i = transitionSet;
        }
        return transitionSet;
    }

    @Override
    public final void mo3058k(ViewGroup viewGroup, C0023f c0023f, C0023f c0023f2, ArrayList arrayList, ArrayList arrayList2) {
        long j10 = this.f3792b;
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            Transition transition = (Transition) this.f3813x.get(i6);
            if (j10 > 0 && (this.f3814y || i6 == 0)) {
                long j11 = transition.f3792b;
                if (j11 > 0) {
                    transition.mo3049C(j11 + j10);
                } else {
                    transition.mo3049C(j10);
                }
            }
            transition.mo3058k(viewGroup, c0023f, c0023f2, arrayList, arrayList2);
        }
    }

    @Override
    public final void mo3064t(ViewGroup viewGroup) {
        super.mo3064t(viewGroup);
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Transition) this.f3813x.get(i6)).mo3064t(viewGroup);
        }
    }

    @Override
    public final void mo3066v(View view) {
        super.mo3066v(view);
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Transition) this.f3813x.get(i6)).mo3066v(view);
        }
    }

    @Override
    public final void mo3067w() {
        if (this.f3813x.isEmpty()) {
            m3050D();
            m3059l();
            return;
        }
        C4219l c4219l = new C4219l();
        c4219l.f14339b = this;
        Iterator it = this.f3813x.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).m3052a(c4219l);
        }
        this.f3815z = this.f3813x.size();
        if (this.f3814y) {
            Iterator it2 = this.f3813x.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).mo3067w();
            }
            return;
        }
        for (int i6 = 1; i6 < this.f3813x.size(); i6++) {
            ((Transition) this.f3813x.get(i6 - 1)).m3052a(new C4219l(1, (Transition) this.f3813x.get(i6)));
        }
        Transition transition = (Transition) this.f3813x.get(0);
        if (transition != null) {
            transition.mo3067w();
        }
    }

    @Override
    public final void mo3069y(AbstractC4233v abstractC4233v) {
        this.f3812B |= 8;
        int size = this.f3813x.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Transition) this.f3813x.get(i6)).mo3069y(abstractC4233v);
        }
    }
}
