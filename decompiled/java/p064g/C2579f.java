package p064g;

import android.graphics.drawable.Drawable;
import p268z1.C4288c;

public final class C2579f implements Drawable.Callback {

    public final int f9001a = 0;

    public Object f9002b;

    public C2579f() {
    }

    @Override
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f9001a) {
            case 0:
                break;
            default:
                ((C4288c) this.f9002b).invalidateSelf();
                break;
        }
    }

    @Override
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        switch (this.f9001a) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f9002b;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j10);
                }
                break;
            default:
                ((C4288c) this.f9002b).scheduleSelf(runnable, j10);
                break;
        }
    }

    @Override
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f9001a) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f9002b;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                }
                break;
            default:
                ((C4288c) this.f9002b).unscheduleSelf(runnable);
                break;
        }
    }

    public C2579f(C4288c c4288c) {
        this.f9002b = c4288c;
    }

    private final void m5575a(Drawable drawable) {
    }
}
