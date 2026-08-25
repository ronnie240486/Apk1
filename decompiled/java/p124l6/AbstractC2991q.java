package p124l6;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomappbar.C1760b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import p001a0.ViewTreeObserverOnPreDrawListenerC0021d;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p065g0.AbstractC2581a;
import p066g1.C2592a;
import p101j7.C2782c;
import p156o9.AbstractC3280d;
import p201s6.AbstractC3722c;
import p221u6.C3908h;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;
import p262y5.AbstractC4268a;
import p262y5.C4272e;

public abstract class AbstractC2991q {

    public static final C2592a f10254C = AbstractC4268a.f14471c;

    public static final int[] f10255D = {R.attr.state_pressed, R.attr.state_enabled};

    public static final int[] f10256E = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    public static final int[] f10257F = {R.attr.state_focused, R.attr.state_enabled};

    public static final int[] f10258G = {R.attr.state_hovered, R.attr.state_enabled};

    public static final int[] f10259H = {R.attr.state_enabled};

    public static final int[] f10260I = new int[0];

    public ViewTreeObserverOnPreDrawListenerC0021d f10262B;

    public C3913m f10263a;

    public C3908h f10264b;

    public Drawable f10265c;

    public C2977c f10266d;

    public LayerDrawable f10267e;

    public boolean f10268f;

    public float f10270h;

    public float f10271i;

    public float f10272j;

    public int f10273k;

    public Animator f10274l;

    public C4272e f10275m;

    public C4272e f10276n;

    public float f10277o;

    public int f10279q;

    public ArrayList f10281s;

    public ArrayList f10282t;

    public ArrayList f10283u;

    public final FloatingActionButton f10284v;

    public final C2782c f10285w;

    public boolean f10269g = true;

    public float f10278p = 1.0f;

    public int f10280r = 0;

    public final Rect f10286x = new Rect();

    public final RectF f10287y = new RectF();

    public final RectF f10288z = new RectF();

    public final Matrix f10261A = new Matrix();

    public AbstractC2991q(FloatingActionButton floatingActionButton, C2782c c2782c) {
        this.f10284v = floatingActionButton;
        this.f10285w = c2782c;
        C0026b c0026b = new C0026b(16);
        C2993s c2993s = (C2993s) this;
        c0026b.m129g(f10255D, m6055d(new C2989o(c2993s, 1)));
        c0026b.m129g(f10256E, m6055d(new C2989o(c2993s, 0)));
        c0026b.m129g(f10257F, m6055d(new C2989o(c2993s, 0)));
        c0026b.m129g(f10258G, m6055d(new C2989o(c2993s, 0)));
        c0026b.m129g(f10259H, m6055d(new C2989o(c2993s, 2)));
        c0026b.m129g(f10260I, m6055d(new C2988n(c2993s)));
        this.f10277o = floatingActionButton.getRotation();
    }

    public static ValueAnimator m6055d(AbstractC2990p abstractC2990p) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f10254C);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(abstractC2990p);
        valueAnimator.addUpdateListener(abstractC2990p);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void m6056a(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f10284v.getDrawable();
        if (drawable == null || this.f10279q == 0) {
            return;
        }
        RectF rectF = this.f10287y;
        RectF rectF2 = this.f10288z;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        float f3 = this.f10279q;
        rectF2.set(0.0f, 0.0f, f3, f3);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f4 = this.f10279q / 2.0f;
        matrix.postScale(f, f, f4, f4);
    }

    public final AnimatorSet m6057b(C4272e c4272e, float f, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        int i6 = 0;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.f10284v;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        c4272e.m8318f("opacity").m8321a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        c4272e.m8318f("scale").m8321a(objectAnimatorOfFloat2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26) {
            C2987m c2987m = new C2987m(i6);
            c2987m.f10247b = new FloatEvaluator();
            objectAnimatorOfFloat2.setEvaluator(c2987m);
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        c4272e.m8318f("scale").m8321a(objectAnimatorOfFloat3);
        if (i10 == 26) {
            C2987m c2987m2 = new C2987m(i6);
            c2987m2.f10247b = new FloatEvaluator();
            objectAnimatorOfFloat3.setEvaluator(c2987m2);
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.f10261A;
        m6056a(f4, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new C2975a(), new C2985k(this), new Matrix(matrix));
        c4272e.m8318f("iconScale").m8321a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC3280d.m6605x(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet m6058c(float f, float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.f10284v;
        valueAnimatorOfFloat.addUpdateListener(new C2986l(this, floatingActionButton.getAlpha(), f, floatingActionButton.getScaleX(), f3, floatingActionButton.getScaleY(), this.f10278p, f4, new Matrix(this.f10261A)));
        arrayList.add(valueAnimatorOfFloat);
        AbstractC3280d.m6605x(animatorSet, arrayList);
        Context context = floatingActionButton.getContext();
        int integer = floatingActionButton.getContext().getResources().getInteger(com.p2serv.android.p032ds.R.integer.material_motion_duration_long_1);
        TypedValue typedValueM3477l = AbstractC1465c.m3477l(context, com.p2serv.android.p032ds.R.attr.motionDurationLong1);
        if (typedValueM3477l != null && typedValueM3477l.type == 16) {
            integer = typedValueM3477l.data;
        }
        animatorSet.setDuration(integer);
        animatorSet.setInterpolator(AbstractC0032a.m155K(floatingActionButton.getContext(), AbstractC4268a.f14470b));
        return animatorSet;
    }

    public abstract float mo6059e();

    public void mo6060f(Rect rect) {
        int sizeDimension = this.f10268f ? (this.f10273k - this.f10284v.getSizeDimension()) / 2 : 0;
        float fMo6059e = this.f10269g ? mo6059e() + this.f10272j : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fMo6059e));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fMo6059e * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public abstract void mo6061g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i6);

    public abstract void mo6062h();

    public abstract void mo6063i();

    public abstract void mo6064j(int[] iArr);

    public abstract void mo6065k(float f, float f3, float f4);

    public final void m6066l() {
        ArrayList<C2983i> arrayList = this.f10283u;
        if (arrayList != null) {
            for (C2983i c2983i : arrayList) {
                C1760b c1760b = c2983i.f10227a;
                c1760b.getClass();
                C3908h c3908h = c1760b.f5938a.f5913W;
                FloatingActionButton floatingActionButton = c2983i.f10228b;
                c3908h.m7810o(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        }
    }

    public final void m6067m() {
        ArrayList<C2983i> arrayList = this.f10283u;
        if (arrayList != null) {
            for (C2983i c2983i : arrayList) {
                C1760b c1760b = c2983i.f10227a;
                c1760b.getClass();
                FloatingActionButton floatingActionButton = c2983i.f10228b;
                float translationX = floatingActionButton.getTranslationX();
                BottomAppBar bottomAppBar = c1760b.f5938a;
                float f = bottomAppBar.getTopEdgeTreatment().f5956g;
                C3908h c3908h = bottomAppBar.f5913W;
                if (f != translationX) {
                    bottomAppBar.getTopEdgeTreatment().f5956g = translationX;
                    c3908h.invalidateSelf();
                }
                float scaleY = 0.0f;
                float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
                if (bottomAppBar.getTopEdgeTreatment().f5955f != fMax) {
                    bottomAppBar.getTopEdgeTreatment().m4120k(fMax);
                    c3908h.invalidateSelf();
                }
                if (floatingActionButton.getVisibility() == 0) {
                    scaleY = floatingActionButton.getScaleY();
                }
                c3908h.m7810o(scaleY);
            }
        }
    }

    public void mo6068n(ColorStateList colorStateList) {
        Drawable drawable = this.f10265c;
        if (drawable != null) {
            AbstractC2581a.m5586h(drawable, AbstractC3722c.m7485b(colorStateList));
        }
    }

    public final void m6069o(C3913m c3913m) {
        this.f10263a = c3913m;
        C3908h c3908h = this.f10264b;
        if (c3908h != null) {
            c3908h.setShapeAppearanceModel(c3913m);
        }
        Object obj = this.f10265c;
        if (obj instanceof InterfaceC3924x) {
            ((InterfaceC3924x) obj).setShapeAppearanceModel(c3913m);
        }
        C2977c c2977c = this.f10266d;
        if (c2977c != null) {
            c2977c.f10214o = c3913m;
            c2977c.invalidateSelf();
        }
    }

    public abstract boolean mo6070p();

    public abstract void mo6071q();

    public final void m6072r() {
        Rect rect = this.f10286x;
        mo6060f(rect);
        AbstractC0032a.m162p(this.f10267e, "Didn't initialize content background");
        boolean zMo6070p = mo6070p();
        C2782c c2782c = this.f10285w;
        if (zMo6070p) {
            super/*android.widget.ImageButton*/.setBackgroundDrawable(new InsetDrawable((Drawable) this.f10267e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            LayerDrawable layerDrawable = this.f10267e;
            if (layerDrawable != null) {
                super/*android.widget.ImageButton*/.setBackgroundDrawable(layerDrawable);
            } else {
                c2782c.getClass();
            }
        }
        int i6 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        FloatingActionButton floatingActionButton = (FloatingActionButton) c2782c.f9501b;
        floatingActionButton.f6292l.set(i6, i10, i11, i12);
        int i13 = floatingActionButton.f6289i;
        floatingActionButton.setPadding(i6 + i13, i10 + i13, i11 + i13, i12 + i13);
    }
}
