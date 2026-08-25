package p262y5;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import p160p.C3347k;

public final class C4272e {

    public final C3347k f14477a = new C3347k(0);

    public final C3347k f14478b = new C3347k(0);

    public static C4272e m8313a(Context context, TypedArray typedArray, int i6) {
        int resourceId;
        if (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0) {
            return null;
        }
        return m8314b(context, resourceId);
    }

    public static C4272e m8314b(Context context, int i6) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i6);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return m8315c(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return m8315c(arrayList);
        } catch (Exception e5) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i6), e5);
            return null;
        }
    }

    public static C4272e m8315c(ArrayList arrayList) {
        C4272e c4272e = new C4272e();
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Animator animator = (Animator) arrayList.get(i6);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c4272e.m8320h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = AbstractC4268a.f14470b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = AbstractC4268a.f14471c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = AbstractC4268a.f14472d;
            }
            C4273f c4273f = new C4273f();
            c4273f.f14482d = 0;
            c4273f.f14483e = 1;
            c4273f.f14479a = startDelay;
            c4273f.f14480b = duration;
            c4273f.f14481c = interpolator;
            c4273f.f14482d = objectAnimator.getRepeatCount();
            c4273f.f14483e = objectAnimator.getRepeatMode();
            c4272e.f14477a.put(propertyName, c4273f);
        }
        return c4272e;
    }

    public final ObjectAnimator m8316d(String str, Object obj, Property property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, m8317e(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        m8318f(str).m8321a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public final PropertyValuesHolder[] m8317e(String str) {
        if (!m8319g(str)) {
            throw new IllegalArgumentException();
        }
        PropertyValuesHolder[] propertyValuesHolderArr = (PropertyValuesHolder[]) this.f14478b.get(str);
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i6 = 0; i6 < propertyValuesHolderArr.length; i6++) {
            propertyValuesHolderArr2[i6] = propertyValuesHolderArr[i6].clone();
        }
        return propertyValuesHolderArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C4272e) {
            return this.f14477a.equals(((C4272e) obj).f14477a);
        }
        return false;
    }

    public final C4273f m8318f(String str) {
        C3347k c3347k = this.f14477a;
        if (c3347k.get(str) != null) {
            return (C4273f) c3347k.get(str);
        }
        throw new IllegalArgumentException();
    }

    public final boolean m8319g(String str) {
        return this.f14478b.get(str) != null;
    }

    public final void m8320h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f14478b.put(str, propertyValuesHolderArr);
    }

    public final int hashCode() {
        return this.f14477a.hashCode();
    }

    public final String toString() {
        return "\n" + C4272e.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f14477a + "}\n";
    }
}
