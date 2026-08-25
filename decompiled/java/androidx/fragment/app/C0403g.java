package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AbstractC0127c0;
import com.p2serv.android.p032ds.R;
import p007a7.C0069f;

public final class C0403g extends AbstractC0127c0 {

    public boolean f1843c;

    public boolean f1844d;

    public C0069f f1845e;

    public final C0069f m1205n(Context context) {
        int i6;
        C0069f c0069f;
        Animator animatorLoadAnimator;
        int i10;
        if (this.f1844d) {
            return this.f1845e;
        }
        C0434v0 c0434v0 = (C0434v0) this.f268a;
        boolean z7 = c0434v0.f2007a == 2;
        boolean z10 = this.f1843c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0434v0.f2009c;
        C0421p c0421p = abstractComponentCallbacksC0427s.f1954I;
        int i11 = c0421p == null ? 0 : c0421p.f1925f;
        if (z10) {
            if (z7) {
                if (c0421p == null) {
                    i6 = 0;
                } else {
                    i6 = c0421p.f1923d;
                }
            } else if (c0421p == null) {
                i6 = 0;
            } else {
                i6 = c0421p.f1924e;
            }
        } else if (z7) {
            if (c0421p == null) {
                i6 = 0;
            } else {
                i6 = c0421p.f1921b;
            }
        } else if (c0421p == null) {
            i6 = 0;
        } else {
            i6 = c0421p.f1922c;
        }
        abstractComponentCallbacksC0427s.m1315N(0, 0, 0, 0);
        ViewGroup viewGroup = abstractComponentCallbacksC0427s.f1950E;
        C0069f c0069f2 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            abstractComponentCallbacksC0427s.f1950E.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = abstractComponentCallbacksC0427s.f1950E;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            if (i6 == 0 && i11 != 0) {
                if (i11 == 4097) {
                    i10 = z7 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                } else if (i11 == 4099) {
                    i10 = z7 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                } else if (i11 != 8194) {
                    i6 = -1;
                } else {
                    i10 = z7 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                }
                i6 = i10;
            }
            if (i6 != 0) {
                boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(i6));
                if (zEquals) {
                    try {
                        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i6);
                        if (animationLoadAnimation != null) {
                            c0069f = new C0069f(2, animationLoadAnimation);
                            c0069f2 = c0069f;
                        }
                    } catch (Resources.NotFoundException e5) {
                        throw e5;
                    } catch (RuntimeException unused) {
                        try {
                            animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i6);
                            if (animatorLoadAnimator != null) {
                                c0069f = new C0069f(animatorLoadAnimator);
                                c0069f2 = c0069f;
                            }
                        } catch (RuntimeException e10) {
                            if (zEquals) {
                                throw e10;
                            }
                            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, i6);
                            if (animationLoadAnimation2 != null) {
                                c0069f2 = new C0069f(2, animationLoadAnimation2);
                            }
                        }
                    }
                } else {
                    animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i6);
                    if (animatorLoadAnimator != null) {
                        c0069f = new C0069f(animatorLoadAnimator);
                        c0069f2 = c0069f;
                    }
                }
            }
        }
        this.f1845e = c0069f2;
        this.f1844d = true;
        return c0069f2;
    }
}
