package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class C1100m extends Animation {

    public final int f3269a;

    public final int f3270b;

    public final int f3271c;

    public final View f3272d;

    public C1100m(int i6, int i10, int i11, View view) {
        this.f3269a = i11;
        this.f3270b = i6;
        this.f3271c = i10;
        this.f3272d = view;
    }

    @Override
    public final void applyTransformation(float f, Transformation transformation) {
        View view = this.f3272d;
        int i6 = this.f3271c;
        int i10 = this.f3270b;
        switch (this.f3269a) {
            case 0:
                DialogC1116u.m2790q(i10 - ((int) ((i10 - i6) * f)), view);
                break;
            default:
                int i11 = i6 + ((int) ((i10 - i6) * f));
                int i12 = DialogC1109q0.f3307S;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = i11;
                view.setLayoutParams(layoutParams);
                break;
        }
    }
}
