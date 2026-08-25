package p258y1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.transition.Transition;
import com.p2serv.android.p032ds.R;

public final class C4208f0 extends AnimatorListenerAdapter implements InterfaceC4236y {

    public final View f14296a;

    public final View f14297b;

    public final int f14298c;

    public final int f14299d;

    public int[] f14300e;

    public float f14301f;

    public float f14302g;

    public final float f14303h;

    public final float f14304i;

    public C4208f0(View view, View view2, int i6, int i10, float f, float f3) {
        this.f14297b = view;
        this.f14296a = view2;
        this.f14298c = i6 - Math.round(view.getTranslationX());
        this.f14299d = i10 - Math.round(view.getTranslationY());
        this.f14303h = f;
        this.f14304i = f3;
        int[] iArr = (int[]) view2.getTag(R.id.transition_position);
        this.f14300e = iArr;
        if (iArr != null) {
            view2.setTag(R.id.transition_position, null);
        }
    }

    @Override
    public final void mo8254e(Transition transition) {
        View view = this.f14297b;
        view.setTranslationX(this.f14303h);
        view.setTranslationY(this.f14304i);
        transition.m3065u(this);
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        if (this.f14300e == null) {
            this.f14300e = new int[2];
        }
        int[] iArr = this.f14300e;
        float f = this.f14298c;
        View view = this.f14297b;
        iArr[0] = Math.round(view.getTranslationX() + f);
        this.f14300e[1] = Math.round(view.getTranslationY() + this.f14299d);
        this.f14296a.setTag(R.id.transition_position, this.f14300e);
    }

    @Override
    public final void onAnimationPause(Animator animator) {
        View view = this.f14297b;
        this.f14301f = view.getTranslationX();
        this.f14302g = view.getTranslationY();
        view.setTranslationX(this.f14303h);
        view.setTranslationY(this.f14304i);
    }

    @Override
    public final void onAnimationResume(Animator animator) {
        float f = this.f14301f;
        View view = this.f14297b;
        view.setTranslationX(f);
        view.setTranslationY(this.f14302g);
    }

    @Override
    public final void mo8255a() {
    }

    @Override
    public final void mo8251b() {
    }

    @Override
    public final void mo8252c() {
    }

    @Override
    public final void mo8253d() {
    }
}
