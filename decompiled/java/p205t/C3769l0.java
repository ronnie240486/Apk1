package p205t;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C3769l0 extends AbstractC3771m0 {

    public boolean f12623g;

    @Override
    public final boolean mo7510b(float f, long j10, View view, C3781u c3781u) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(m7513a(f, j10, view, c3781u));
        } else {
            if (this.f12623g) {
                return false;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f12623g = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(m7513a(f, j10, view, c3781u)));
                } catch (IllegalAccessException e5) {
                    Log.e("SplineSet", "unable to setProgress", e5);
                } catch (InvocationTargetException e10) {
                    Log.e("SplineSet", "unable to setProgress", e10);
                }
            }
        }
        return this.f12627d;
    }
}
