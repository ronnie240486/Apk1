package p258y1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class C4199b extends AnimatorListenerAdapter {

    public boolean f14267a;

    public final View f14268b;

    public final Rect f14269c;

    public final int f14270d;

    public final int f14271e;

    public final int f14272f;

    public final int f14273g;

    public C4199b(View view, Rect rect, int i6, int i10, int i11, int i12) {
        this.f14268b = view;
        this.f14269c = rect;
        this.f14270d = i6;
        this.f14271e = i10;
        this.f14272f = i11;
        this.f14273g = i12;
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        this.f14267a = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        if (this.f14267a) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        Rect rect = this.f14269c;
        View view = this.f14268b;
        view.setClipBounds(rect);
        AbstractC4210g0.m8256a(view, this.f14270d, this.f14271e, this.f14272f, this.f14273g);
    }
}
