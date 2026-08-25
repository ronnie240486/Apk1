package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0209g3;
import java.util.HashMap;
import java.util.WeakHashMap;
import p046e0.AbstractC2343b;
import p124l6.C2975a;
import p124l6.C2987m;
import p138n0.AbstractC3155s0;
import p258y1.AbstractC4204d0;
import p258y1.AbstractC4210g0;
import p258y1.AbstractC4233v;
import p258y1.C4197a;
import p258y1.C4199b;
import p258y1.C4201c;
import p258y1.C4203d;
import p258y1.C4206e0;

public class ChangeBounds extends Transition {

    public static final C0209g3 f3754A;

    public static final C0209g3 f3755B;

    public static final C0209g3 f3756C;

    public static final C0209g3 f3757D;

    public static final C2987m f3758E;

    public static final String[] f3759y = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    public static final C0209g3 f3760z;

    public boolean f3761x;

    static {
        new C2975a(PointF.class, "boundsOrigin").f10193b = new Rect();
        f3760z = new C0209g3("topLeft", PointF.class, 10);
        f3754A = new C0209g3("bottomRight", PointF.class, 11);
        f3755B = new C0209g3("bottomRight", PointF.class, 12);
        f3756C = new C0209g3("topLeft", PointF.class, 13);
        f3757D = new C0209g3("position", PointF.class, 14);
        f3758E = new C2987m(2);
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3761x = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4233v.f14372b);
        boolean z7 = AbstractC2343b.m5319e((XmlResourceParser) attributeSet, "resizeClip") ? typedArrayObtainStyledAttributes.getBoolean(0, false) : false;
        typedArrayObtainStyledAttributes.recycle();
        this.f3761x = z7;
    }

    public final void m3029F(C4206e0 c4206e0) {
        View view = c4206e0.f14293b;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = c4206e0.f14292a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", c4206e0.f14293b.getParent());
        if (this.f3761x) {
            map.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        m3029F(c4206e0);
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        m3029F(c4206e0);
    }

    @Override
    public final Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        int i6;
        int i10;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        boolean z7;
        Animator animatorOfObject;
        Animator animator;
        if (c4206e0 == null || c4206e1 == null) {
            return null;
        }
        HashMap map = c4206e0.f14292a;
        HashMap map2 = c4206e1.f14292a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        Rect rect2 = (Rect) map.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) map2.get("android:changeBounds:bounds");
        int i11 = rect2.left;
        int i12 = rect3.left;
        int i13 = rect2.top;
        int i14 = rect3.top;
        int i15 = rect2.right;
        int i16 = rect3.right;
        int i17 = rect2.bottom;
        int i18 = rect3.bottom;
        int i19 = i15 - i11;
        int i20 = i17 - i13;
        int i21 = i16 - i12;
        int i22 = i18 - i14;
        Rect rect4 = (Rect) map.get("android:changeBounds:clip");
        Rect rect5 = (Rect) map2.get("android:changeBounds:clip");
        if ((i19 == 0 || i20 == 0) && (i21 == 0 || i22 == 0)) {
            i6 = 0;
        } else {
            i6 = (i11 == i12 && i13 == i14) ? 0 : 1;
            if (i15 != i16 || i17 != i18) {
                i6++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i6++;
        }
        if (i6 <= 0) {
            return null;
        }
        boolean z10 = this.f3761x;
        View view = c4206e1.f14293b;
        C0209g3 c0209g3 = f3757D;
        if (z10) {
            AbstractC4210g0.m8256a(view, i11, i13, Math.max(i19, i21) + i11, Math.max(i20, i22) + i13);
            ObjectAnimator objectAnimatorOfObject2 = (i11 == i12 && i13 == i14) ? null : ObjectAnimator.ofObject(view, c0209g3, (TypeConverter) null, this.f3810t.m8278a(i11, i13, i12, i14));
            if (rect4 == null) {
                i10 = 0;
                rect = new Rect(0, 0, i19, i20);
            } else {
                i10 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i10, i10, i21, i22) : rect5;
            if (rect.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                view.setClipBounds(rect);
                C2987m c2987m = f3758E;
                Object[] objArr = new Object[2];
                objArr[i10] = rect;
                objArr[1] = rect6;
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", c2987m, objArr);
                objectAnimatorOfObject.addListener(new C4199b(view, rect5, i12, i14, i16, i18));
            }
            boolean z11 = AbstractC4204d0.f14289a;
            if (objectAnimatorOfObject2 != null) {
                if (objectAnimatorOfObject == null) {
                    animatorOfObject = objectAnimatorOfObject2;
                } else {
                    AnimatorSet animatorSet = new AnimatorSet();
                    z7 = true;
                    animatorSet.playTogether(objectAnimatorOfObject2, objectAnimatorOfObject);
                    animator = animatorSet;
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    AbstractC4233v.m8276j(viewGroup4, z7);
                    m3052a(new C4201c(viewGroup4));
                }
                return animator;
            }
            animatorOfObject = objectAnimatorOfObject;
        } else {
            AbstractC4210g0.m8256a(view, i11, i13, i15, i17);
            if (i6 != 2) {
                animatorOfObject = (i11 == i12 && i13 == i14) ? ObjectAnimator.ofObject(view, f3755B, (TypeConverter) null, this.f3810t.m8278a(i15, i17, i16, i18)) : ObjectAnimator.ofObject(view, f3756C, (TypeConverter) null, this.f3810t.m8278a(i11, i13, i12, i14));
            } else if (i19 == i21 && i20 == i22) {
                animatorOfObject = ObjectAnimator.ofObject(view, c0209g3, (TypeConverter) null, this.f3810t.m8278a(i11, i13, i12, i14));
            } else {
                C4203d c4203d = new C4203d();
                c4203d.f14286e = view;
                ObjectAnimator objectAnimatorOfObject3 = ObjectAnimator.ofObject(c4203d, f3760z, (TypeConverter) null, this.f3810t.m8278a(i11, i13, i12, i14));
                ObjectAnimator objectAnimatorOfObject4 = ObjectAnimator.ofObject(c4203d, f3754A, (TypeConverter) null, this.f3810t.m8278a(i15, i17, i16, i18));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(objectAnimatorOfObject3, objectAnimatorOfObject4);
                animatorSet2.addListener(new C4197a(c4203d));
                animatorOfObject = animatorSet2;
            }
        }
        z7 = true;
        animator = animatorOfObject;
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup5 = (ViewGroup) view.getParent();
            AbstractC4233v.m8276j(viewGroup5, z7);
            m3052a(new C4201c(viewGroup5));
        }
        return animator;
    }

    @Override
    public final String[] mo3033o() {
        return f3759y;
    }
}
