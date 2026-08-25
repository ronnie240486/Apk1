package p258y1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;

public final class C4209g extends AnimatorListenerAdapter {

    public boolean f14305a;

    public final Matrix f14306b = new Matrix();

    public final boolean f14307c;

    public final Matrix f14308d;

    public final View f14309e;

    public final C4215j f14310f;

    public final C4213i f14311g;

    public final ChangeTransform f14312h;

    public C4209g(ChangeTransform changeTransform, boolean z7, Matrix matrix, View view, C4215j c4215j, C4213i c4213i) {
        this.f14312h = changeTransform;
        this.f14307c = z7;
        this.f14308d = matrix;
        this.f14309e = view;
        this.f14310f = c4215j;
        this.f14311g = c4213i;
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        this.f14305a = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        boolean z7 = this.f14305a;
        C4215j c4215j = this.f14310f;
        View view = this.f14309e;
        if (!z7) {
            if (this.f14307c && this.f14312h.f3771x) {
                Matrix matrix = this.f14308d;
                Matrix matrix2 = this.f14306b;
                matrix2.set(matrix);
                view.setTag(R.id.transition_transform, matrix2);
                c4215j.getClass();
                String[] strArr = ChangeTransform.f3767A;
                view.setTranslationX(c4215j.f14329a);
                view.setTranslationY(c4215j.f14330b);
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3119g0.m6184w(view, c4215j.f14331c);
                view.setScaleX(c4215j.f14332d);
                view.setScaleY(c4215j.f14333e);
                view.setRotationX(c4215j.f14334f);
                view.setRotationY(c4215j.f14335g);
                view.setRotation(c4215j.f14336h);
            } else {
                view.setTag(R.id.transition_transform, null);
                view.setTag(R.id.parent_matrix, null);
            }
        }
        AbstractC4210g0.f14313a.mo8260l(view, null);
        c4215j.getClass();
        String[] strArr2 = ChangeTransform.f3767A;
        view.setTranslationX(c4215j.f14329a);
        view.setTranslationY(c4215j.f14330b);
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6184w(view, c4215j.f14331c);
        view.setScaleX(c4215j.f14332d);
        view.setScaleY(c4215j.f14333e);
        view.setRotationX(c4215j.f14334f);
        view.setRotationY(c4215j.f14335g);
        view.setRotation(c4215j.f14336h);
    }

    @Override
    public final void onAnimationPause(Animator animator) {
        Matrix matrix = this.f14311g.f14323a;
        Matrix matrix2 = this.f14306b;
        matrix2.set(matrix);
        View view = this.f14309e;
        view.setTag(R.id.transition_transform, matrix2);
        C4215j c4215j = this.f14310f;
        c4215j.getClass();
        String[] strArr = ChangeTransform.f3767A;
        view.setTranslationX(c4215j.f14329a);
        view.setTranslationY(c4215j.f14330b);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6184w(view, c4215j.f14331c);
        view.setScaleX(c4215j.f14332d);
        view.setScaleY(c4215j.f14333e);
        view.setRotationX(c4215j.f14334f);
        view.setRotationY(c4215j.f14335g);
        view.setRotation(c4215j.f14336h);
    }

    @Override
    public final void onAnimationResume(Animator animator) {
        String[] strArr = ChangeTransform.f3767A;
        View view = this.f14309e;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6184w(view, 0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }
}
