package androidx.transition;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;
import p046e0.AbstractC2343b;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4229r;
import p258y1.C4230s;
import p258y1.C4231t;
import p258y1.InterfaceC4232u;

public class Slide extends Visibility {

    public static final DecelerateInterpolator f3779A = new DecelerateInterpolator();

    public static final AccelerateInterpolator f3780B = new AccelerateInterpolator();

    public static final C4230s f3781C = new C4230s(0);

    public static final C4230s f3782D = new C4230s(1);

    public static final C4231t f3783E = new C4231t(0);

    public static final C4230s f3784F = new C4230s(2);

    public static final C4230s f3785G = new C4230s(3);

    public static final C4231t f3786H = new C4231t(1);

    public final InterfaceC4232u f3787z;

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C4231t c4231t = f3786H;
        this.f3787z = c4231t;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14376f);
        int iM5317c = AbstractC2343b.m5317c(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        if (iM5317c == 3) {
            this.f3787z = f3781C;
        } else if (iM5317c == 5) {
            this.f3787z = f3784F;
        } else if (iM5317c == 48) {
            this.f3787z = f3783E;
        } else if (iM5317c == 80) {
            this.f3787z = c4231t;
        } else if (iM5317c == 8388611) {
            this.f3787z = f3782D;
        } else {
            if (iM5317c != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f3787z = f3785G;
        }
        C4229r c4229r = new C4229r();
        c4229r.f14368v = iM5317c;
        this.f3809s = c4229r;
    }

    @Override
    public final Animator mo3038H(ViewGroup viewGroup, View view, C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e1 == null) {
            return null;
        }
        int[] iArr = (int[]) c4206e1.f14292a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return AbstractC4233v.m8273c(view, c4206e1, iArr[0], iArr[1], this.f3787z.mo8271b(viewGroup, view), this.f3787z.mo8272a(viewGroup, view), translationX, translationY, f3779A, this);
    }

    @Override
    public final Animator mo3039I(ViewGroup viewGroup, View view, C4206e0 c4206e0) {
        if (c4206e0 == null) {
            return null;
        }
        int[] iArr = (int[]) c4206e0.f14292a.get("android:slide:screenPosition");
        return AbstractC4233v.m8273c(view, c4206e0, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f3787z.mo8271b(viewGroup, view), this.f3787z.mo8272a(viewGroup, view), f3780B, this);
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        Visibility.m3075F(c4206e0);
        int[] iArr = new int[2];
        c4206e0.f14293b.getLocationOnScreen(iArr);
        c4206e0.f14292a.put("android:slide:screenPosition", iArr);
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        Visibility.m3075F(c4206e0);
        int[] iArr = new int[2];
        c4206e0.f14293b.getLocationOnScreen(iArr);
        c4206e0.f14292a.put("android:slide:screenPosition", iArr);
    }
}
