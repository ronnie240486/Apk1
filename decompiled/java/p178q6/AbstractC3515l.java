package p178q6;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import androidx.appcompat.widget.C0209g3;
import java.util.ArrayList;
import p262y5.AbstractC4268a;

public abstract class AbstractC3515l extends Drawable implements Animatable {

    public static final C0209g3 f11842k = new C0209g3("growFraction", Float.class, 7);

    public final Context f11843a;

    public final AbstractC3508e f11844b;

    public ObjectAnimator f11846d;

    public ObjectAnimator f11847e;

    public ArrayList f11848f;

    public boolean f11849g;

    public float f11850h;

    public int f11852j;

    public final Paint f11851i = new Paint();

    public C3504a f11845c = new C3504a();

    public AbstractC3515l(Context context, AbstractC3508e abstractC3508e) {
        this.f11843a = context;
        this.f11844b = abstractC3508e;
        setAlpha(255);
    }

    public final float m7163b() {
        AbstractC3508e abstractC3508e = this.f11844b;
        if (abstractC3508e.f11813e == 0 && abstractC3508e.f11814f == 0) {
            return 1.0f;
        }
        return this.f11850h;
    }

    public final boolean m7164c() {
        ObjectAnimator objectAnimator = this.f11847e;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public final boolean m7165d() {
        ObjectAnimator objectAnimator = this.f11846d;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public final boolean m7166e(boolean z7, boolean z10, boolean z11) {
        C3504a c3504a = this.f11845c;
        ContentResolver contentResolver = this.f11843a.getContentResolver();
        c3504a.getClass();
        return mo7161f(z7, z10, z11 && Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) > 0.0f);
    }

    public boolean mo7161f(boolean z7, boolean z10, boolean z11) {
        int i6 = 1;
        int i10 = 0;
        ObjectAnimator objectAnimator = this.f11846d;
        C0209g3 c0209g3 = f11842k;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, c0209g3, 0.0f, 1.0f);
            this.f11846d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f11846d.setInterpolator(AbstractC4268a.f14470b);
            ObjectAnimator objectAnimator2 = this.f11846d;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f11846d = objectAnimator2;
            objectAnimator2.addListener(new C3514k(this, i10));
        }
        if (this.f11847e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, c0209g3, 1.0f, 0.0f);
            this.f11847e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f11847e.setInterpolator(AbstractC4268a.f14470b);
            ObjectAnimator objectAnimator3 = this.f11847e;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.f11847e = objectAnimator3;
            objectAnimator3.addListener(new C3514k(this, i6));
        }
        if (!isVisible() && !z7) {
            return false;
        }
        ObjectAnimator objectAnimator4 = z7 ? this.f11846d : this.f11847e;
        if (!z11) {
            if (objectAnimator4.isRunning()) {
                objectAnimator4.end();
            } else {
                boolean z12 = this.f11849g;
                this.f11849g = true;
                new ValueAnimator[]{objectAnimator4}[0].end();
                this.f11849g = z12;
            }
            return super.setVisible(z7, false);
        }
        if (z11 && objectAnimator4.isRunning()) {
            return false;
        }
        boolean z13 = !z7 || super.setVisible(z7, false);
        AbstractC3508e abstractC3508e = this.f11844b;
        if (!z7 ? abstractC3508e.f11814f != 0 : abstractC3508e.f11813e != 0) {
            boolean z14 = this.f11849g;
            this.f11849g = true;
            new ValueAnimator[]{objectAnimator4}[0].end();
            this.f11849g = z14;
            return z13;
        }
        if (z10 || !objectAnimator4.isPaused()) {
            objectAnimator4.start();
        } else {
            objectAnimator4.resume();
        }
        return z13;
    }

    public final void m7167g(C3506c c3506c) {
        ArrayList arrayList = this.f11848f;
        if (arrayList == null || !arrayList.contains(c3506c)) {
            return;
        }
        this.f11848f.remove(c3506c);
        if (this.f11848f.isEmpty()) {
            this.f11848f = null;
        }
    }

    @Override
    public final int getAlpha() {
        return this.f11852j;
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final boolean isRunning() {
        return m7165d() || m7164c();
    }

    @Override
    public final void setAlpha(int i6) {
        this.f11852j = i6;
        invalidateSelf();
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f11851i.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        return m7166e(z7, z10, true);
    }

    @Override
    public final void start() {
        mo7161f(true, true, false);
    }

    @Override
    public final void stop() {
        mo7161f(false, true, false);
    }
}
