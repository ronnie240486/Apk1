package p258y1;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.Visibility;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractC4233v implements InterfaceC4232u {

    public static final int[] f14371a = {R.attr.interpolator, R.attr.duration, R.attr.startDelay, R.attr.matchOrder};

    public static final int[] f14372b = {R.attr.resizeClip};

    public static final int[] f14373c = {R.attr.transitionVisibilityMode};

    public static final int[] f14374d = {R.attr.fadingMode};

    public static final int[] f14375e = {R.attr.reparent, R.attr.reparentWithOverlay};

    public static final int[] f14376f = {R.attr.slideEdge};

    public static final int[] f14377g = {R.attr.transitionOrdering};

    public static final int[] f14378h = {R.attr.minimumHorizontalAngle, R.attr.minimumVerticalAngle, R.attr.maximumAngle};

    public static final int[] f14379i = {R.attr.patternPathData};

    public static final String[] f14380j = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static Method f14381k = null;

    public static Method f14382l = null;

    public static boolean f14383m = false;

    public static boolean f14384n = true;

    public static boolean f14385o = true;

    public static Method f14386p;

    public static boolean f14387q;

    public static Method f14388r;

    public static boolean f14389s;

    public static Field f14390t;

    public static boolean f14391u;

    public static ObjectAnimator m8273c(View view, C4206e0 c4206e0, int i6, int i10, float f, float f3, float f4, float f5, TimeInterpolator timeInterpolator, Visibility visibility) {
        float f10;
        float f11;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c4206e0.f14293b.getTag(com.p2serv.android.p032ds.R.id.transition_position);
        if (iArr != null) {
            f10 = (iArr[0] - i6) + translationX;
            f11 = (iArr[1] - i10) + translationY;
        } else {
            f10 = f;
            f11 = f3;
        }
        int iRound = Math.round(f10 - translationX) + i6;
        int iRound2 = Math.round(f11 - translationY) + i10;
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        if (f10 == f4 && f11 == f5) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f10, f4), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f11, f5));
        C4208f0 c4208f0 = new C4208f0(view, c4206e0.f14293b, iRound, iRound2, translationX, translationY);
        visibility.m3052a(c4208f0);
        objectAnimatorOfPropertyValuesHolder.addListener(c4208f0);
        objectAnimatorOfPropertyValuesHolder.addPauseListener(c4208f0);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static void m8274d(Canvas canvas, boolean z7) {
        Method method;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            if (z7) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (i6 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f14383m) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                f14381k = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                f14382l = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f14383m = true;
        }
        if (z7) {
            try {
                Method method2 = f14381k;
                if (method2 != null) {
                    method2.invoke(canvas, null);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5.getCause());
            }
        }
        if (z7 || (method = f14382l) == null) {
            return;
        }
        method.invoke(canvas, null);
    }

    public static int m8275f(C4206e0 c4206e0, int i6) {
        int[] iArr;
        if (c4206e0 == null || (iArr = (int[]) c4206e0.f14292a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i6];
    }

    public static void m8276j(ViewGroup viewGroup, boolean z7) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z7);
        } else if (f14385o) {
            try {
                viewGroup.suppressLayout(z7);
            } catch (NoSuchMethodError unused) {
                f14385o = false;
            }
        }
    }

    @Override
    public float mo8272a(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }

    @Override
    public float mo8271b(ViewGroup viewGroup, View view) {
        return view.getTranslationX();
    }

    public abstract long mo8267e(ViewGroup viewGroup, Transition transition, C4206e0 c4206e0, C4206e0 c4206e1);

    public abstract Rect m8277g();

    public void mo8265h(View view, int i6, int i10, int i11, int i12) {
        if (!f14389s) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                f14388r = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e5) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e5);
            }
            f14389s = true;
        }
        Method method = f14388r;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i6), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    public void mo8266i(int i6, View view) {
        if (!f14391u) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f14390t = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f14391u = true;
        }
        Field field = f14390t;
        if (field != null) {
            try {
                f14390t.setInt(view, i6 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
