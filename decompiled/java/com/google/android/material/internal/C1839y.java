package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import java.util.HashMap;
import p007a7.C0066c;
import p258y1.C4206e0;

public final class C1839y extends Transition {
    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        View view = c4206e0.f14293b;
        if (view instanceof TextView) {
            c4206e0.f14292a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        View view = c4206e0.f14293b;
        if (view instanceof TextView) {
            c4206e0.f14292a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override
    public final Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e0 == null || c4206e1 == null || !(c4206e0.f14293b instanceof TextView)) {
            return null;
        }
        View view = c4206e1.f14293b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        HashMap map = c4206e0.f14292a;
        HashMap map2 = c4206e1.f14292a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new C0066c(3, textView));
        return valueAnimatorOfFloat;
    }
}
