package p205t;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C3759g0 extends AbstractC3761h0 {

    public boolean f12606f;

    @Override
    public final void mo7504c(View view, float f) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(m7507a(f));
            return;
        }
        if (this.f12606f) {
            return;
        }
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.f12606f = true;
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(m7507a(f)));
            } catch (IllegalAccessException e5) {
                Log.e("SplineSet", "unable to setProgress", e5);
            } catch (InvocationTargetException e10) {
                Log.e("SplineSet", "unable to setProgress", e10);
            }
        }
    }
}
