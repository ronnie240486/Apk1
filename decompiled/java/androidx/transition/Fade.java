package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import p007a7.C0070g;
import p046e0.AbstractC2343b;
import p258y1.AbstractC4210g0;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4219l;

public class Fade extends Visibility {
    public Fade(int i6) {
        m3077J(i6);
    }

    @Override
    public final Animator mo3038H(ViewGroup viewGroup, View view, C4206e0 c4206e0, C4206e0 c4206e1) {
        Float f;
        float fFloatValue = (c4206e0 == null || (f = (Float) c4206e0.f14292a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f.floatValue();
        return m3042K(view, fFloatValue != 1.0f ? fFloatValue : 0.0f, 1.0f);
    }

    @Override
    public final Animator mo3039I(ViewGroup viewGroup, View view, C4206e0 c4206e0) {
        Float f;
        AbstractC4210g0.f14313a.getClass();
        return m3042K(view, (c4206e0 == null || (f = (Float) c4206e0.f14292a.get("android:fade:transitionAlpha")) == null) ? 1.0f : f.floatValue(), 0.0f);
    }

    public final ObjectAnimator m3042K(View view, float f, float f3) {
        if (f == f3) {
            return null;
        }
        AbstractC4210g0.m8257b(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, AbstractC4210g0.f14314b, f3);
        objectAnimatorOfFloat.addListener(new C0070g(view));
        m3052a(new C4219l(0, view));
        return objectAnimatorOfFloat;
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        Visibility.m3075F(c4206e0);
        c4206e0.f14292a.put("android:fade:transitionAlpha", Float.valueOf(AbstractC4210g0.f14313a.mo8259k(c4206e0.f14293b)));
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14374d);
        m3077J(AbstractC2343b.m5317c(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, this.f3817x));
        typedArrayObtainStyledAttributes.recycle();
    }
}
