package ba;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public final class WindowManagerC1369b implements WindowManager {

    public final WindowManager f4182a;

    public final C1370c f4183b;

    public WindowManagerC1369b(C1370c c1370c, WindowManager windowManager) {
        this.f4183b = c1370c;
        this.f4182a = windowManager;
    }

    @Override
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            Log.d("WindowManagerWrapper", "WindowManager's addView(view, params) has been hooked.");
            this.f4182a.addView(view, layoutParams);
        } catch (WindowManager.BadTokenException e5) {
            Log.i("WindowManagerWrapper", e5.getMessage());
            int i6 = C1370c.f4184a;
            this.f4183b.getClass();
        } catch (Throwable th) {
            Log.e("WindowManagerWrapper", "[addView]", th);
        }
    }

    @Override
    public final Display getDefaultDisplay() {
        return this.f4182a.getDefaultDisplay();
    }

    @Override
    public final void removeView(View view) {
        this.f4182a.removeView(view);
    }

    @Override
    public final void removeViewImmediate(View view) {
        this.f4182a.removeViewImmediate(view);
    }

    @Override
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        this.f4182a.updateViewLayout(view, layoutParams);
    }
}
