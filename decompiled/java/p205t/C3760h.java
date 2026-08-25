package p205t;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C3760h extends AbstractC3762i {

    public boolean f12607d;

    @Override
    public final void mo7503c(View view, float f) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(m7508a(f));
            return;
        }
        if (this.f12607d) {
            return;
        }
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.f12607d = true;
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(m7508a(f)));
            } catch (IllegalAccessException e5) {
                Log.e("KeyCycleOscillator", "unable to setProgress", e5);
            } catch (InvocationTargetException e10) {
                Log.e("KeyCycleOscillator", "unable to setProgress", e10);
            }
        }
    }
}
