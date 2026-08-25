package p124l6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;
import p101j7.C2782c;
import p156o9.AbstractC3280d;
import p262y5.C4272e;

public abstract class AbstractC2976b {

    public final Context f10194a;

    public final ExtendedFloatingActionButton f10195b;

    public final ArrayList f10196c = new ArrayList();

    public final C2782c f10197d;

    public C4272e f10198e;

    public C4272e f10199f;

    public AbstractC2976b(ExtendedFloatingActionButton extendedFloatingActionButton, C2782c c2782c) {
        this.f10195b = extendedFloatingActionButton;
        this.f10194a = extendedFloatingActionButton.getContext();
        this.f10197d = c2782c;
    }

    public AnimatorSet mo6026a() {
        C4272e c4272e = this.f10199f;
        if (c4272e == null) {
            if (this.f10198e == null) {
                this.f10198e = C4272e.m8314b(this.f10194a, mo6028c());
            }
            c4272e = this.f10198e;
            c4272e.getClass();
        }
        return m6027b(c4272e);
    }

    public final AnimatorSet m6027b(C4272e c4272e) {
        ArrayList arrayList = new ArrayList();
        boolean zM8319g = c4272e.m8319g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10195b;
        if (zM8319g) {
            arrayList.add(c4272e.m8316d("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (c4272e.m8319g("scale")) {
            arrayList.add(c4272e.m8316d("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(c4272e.m8316d("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (c4272e.m8319g("width")) {
            arrayList.add(c4272e.m8316d("width", extendedFloatingActionButton, ExtendedFloatingActionButton.f6262F));
        }
        if (c4272e.m8319g("height")) {
            arrayList.add(c4272e.m8316d("height", extendedFloatingActionButton, ExtendedFloatingActionButton.f6263G));
        }
        if (c4272e.m8319g("paddingStart")) {
            arrayList.add(c4272e.m8316d("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.f6264H));
        }
        if (c4272e.m8319g("paddingEnd")) {
            arrayList.add(c4272e.m8316d("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.f6265I));
        }
        if (c4272e.m8319g("labelOpacity")) {
            arrayList.add(c4272e.m8316d("labelOpacity", extendedFloatingActionButton, new C2975a(this)));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC3280d.m6605x(animatorSet, arrayList);
        return animatorSet;
    }

    public abstract int mo6028c();

    public void mo6029d() {
        this.f10197d.f9501b = null;
    }

    public abstract void mo6030e();

    public abstract void mo6031f(Animator animator);

    public abstract void mo6032g();

    public abstract boolean mo6033h();
}
