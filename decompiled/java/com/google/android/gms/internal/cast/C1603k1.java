package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.Choreographer;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.textfield.C1878p;
import p160p.C3347k;

public final class C1603k1 extends AnimatorListenerAdapter {

    public final int f5381a;

    public final int f5382b;

    public int f5383c;

    public final Object f5384d;

    public final Object f5385e;

    public final Object f5386f;

    public C1603k1(AnimatorSet animatorSet) {
        this.f5381a = 0;
        this.f5384d = new C3347k(0);
        C1712w c1712w = new C1712w();
        c1712w.f5715b = this;
        this.f5386f = c1712w;
        this.f5385e = animatorSet;
        this.f5382b = -1;
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        switch (this.f5381a) {
            case 0:
                ((C3347k) this.f5384d).put(animator, Boolean.TRUE);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        AppCompatTextView appCompatTextView;
        switch (this.f5381a) {
            case 0:
                C3347k c3347k = (C3347k) this.f5384d;
                if (!c3347k.containsKey(animator) || !((Boolean) c3347k.get(animator)).booleanValue()) {
                    C1633n1 c1633n1 = (C1633n1) C1633n1.f5422b.get();
                    c1633n1.getClass();
                    final C1712w c1712w = (C1712w) this.f5386f;
                    if (((ChoreographerFrameCallbackC1623m1) c1712w.f5714a) == null) {
                        c1712w.f5714a = new Choreographer.FrameCallback() {
                            @Override
                            public final void doFrame(long j10) {
                                C1603k1 c1603k1 = (C1603k1) c1712w.f5715b;
                                c1603k1.f5383c++;
                                C3347k c3347k2 = (C3347k) c1603k1.f5384d;
                                AnimatorSet animatorSet = (AnimatorSet) c1603k1.f5385e;
                                if ((c3347k2.containsKey(animatorSet) && ((Boolean) c3347k2.get(animatorSet)).booleanValue()) || animatorSet.isStarted()) {
                                    return;
                                }
                                if (c1603k1.f5382b != -1 && c1603k1.f5383c >= 0) {
                                    return;
                                }
                                animatorSet.start();
                            }
                        };
                    }
                    c1633n1.f5423a.postFrameCallback((ChoreographerFrameCallbackC1623m1) c1712w.f5714a);
                }
                break;
            default:
                int i6 = this.f5382b;
                C1878p c1878p = (C1878p) this.f5386f;
                c1878p.f6880h = i6;
                c1878p.f6878f = null;
                TextView textView = (TextView) this.f5384d;
                if (textView != null) {
                    textView.setVisibility(4);
                    if (this.f5383c == 1 && (appCompatTextView = c1878p.f6884l) != null) {
                        appCompatTextView.setText((CharSequence) null);
                    }
                }
                TextView textView2 = (TextView) this.f5385e;
                if (textView2 != null) {
                    textView2.setTranslationY(0.0f);
                    textView2.setAlpha(1.0f);
                }
                break;
        }
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        switch (this.f5381a) {
            case 0:
                ((C3347k) this.f5384d).put(animator, Boolean.FALSE);
                break;
            default:
                TextView textView = (TextView) this.f5385e;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                break;
        }
    }

    public C1603k1(C1878p c1878p, int i6, TextView textView, int i10, TextView textView2) {
        this.f5381a = 1;
        this.f5386f = c1878p;
        this.f5382b = i6;
        this.f5384d = textView;
        this.f5383c = i10;
        this.f5385e = textView2;
    }
}
