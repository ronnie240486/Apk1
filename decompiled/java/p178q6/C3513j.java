package p178q6;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.provider.Settings;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import java.util.ArrayList;
import p002a1.C0026b;
import p002a1.C0027c;
import p002a1.C0030f;
import p002a1.C0031g;
import p002a1.ChoreographerFrameCallbackC0025a;
import p156o9.AbstractC3281e;

public final class C3513j extends AbstractC3515l {

    public static final C3512i f11834q = new C3512i();

    public final AbstractC3516m f11835l;

    public final C0031g f11836m;

    public final C0030f f11837n;

    public float f11838o;

    public boolean f11839p;

    public C3513j(Context context, AbstractC3508e abstractC3508e, AbstractC3516m abstractC3516m) {
        super(context, abstractC3508e);
        this.f11839p = false;
        this.f11835l = abstractC3516m;
        abstractC3516m.f11854b = this;
        C0031g c0031g = new C0031g();
        this.f11836m = c0031g;
        c0031g.f85b = 1.0f;
        c0031g.f86c = false;
        c0031g.f84a = Math.sqrt(50.0f);
        c0031g.f86c = false;
        C0030f c0030f = new C0030f(this);
        this.f11837n = c0030f;
        c0030f.f81k = c0031g;
        if (this.f11850h != 1.0f) {
            this.f11850h = 1.0f;
            invalidateSelf();
        }
    }

    @Override
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            AbstractC3516m abstractC3516m = this.f11835l;
            float fM7163b = m7163b();
            abstractC3516m.f11853a.mo4303a();
            abstractC3516m.mo7149a(canvas, fM7163b);
            AbstractC3516m abstractC3516m2 = this.f11835l;
            Paint paint = this.f11851i;
            abstractC3516m2.mo7151c(canvas, paint);
            this.f11835l.mo7150b(canvas, paint, 0.0f, this.f11838o, AbstractC3281e.m6620j(this.f11844b.f11811c[0], this.f11852j));
            canvas.restore();
        }
    }

    @Override
    public final boolean mo7161f(boolean z7, boolean z10, boolean z11) {
        boolean zMo7161f = super.mo7161f(z7, z10, z11);
        C3504a c3504a = this.f11845c;
        ContentResolver contentResolver = this.f11843a.getContentResolver();
        c3504a.getClass();
        float f = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (f == 0.0f) {
            this.f11839p = true;
        } else {
            this.f11839p = false;
            float f3 = 50.0f / f;
            C0031g c0031g = this.f11836m;
            c0031g.getClass();
            if (f3 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            c0031g.f84a = Math.sqrt(f3);
            c0031g.f86c = false;
        }
        return zMo7161f;
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f11835l.mo7152d();
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f11835l.mo7153e();
    }

    @Override
    public final void jumpToCurrentState() {
        this.f11837n.m147b();
        this.f11838o = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override
    public final boolean onLevelChange(int i6) {
        boolean z7 = this.f11839p;
        C0030f c0030f = this.f11837n;
        if (z7) {
            c0030f.m147b();
            this.f11838o = i6 / 10000.0f;
            invalidateSelf();
        } else {
            c0030f.f72b = this.f11838o * 10000.0f;
            c0030f.f73c = true;
            float f = i6;
            if (c0030f.f76f) {
                c0030f.f82l = f;
            } else {
                if (c0030f.f81k == null) {
                    c0030f.f81k = new C0031g(f);
                }
                C0031g c0031g = c0030f.f81k;
                double d = f;
                c0031g.f92i = d;
                double d10 = (float) d;
                if (d10 > Float.MAX_VALUE) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                }
                if (d10 < -3.4028235E38f) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
                double dAbs = Math.abs(c0030f.f78h * 0.75f);
                c0031g.f87d = dAbs;
                c0031g.f88e = dAbs * 62.5d;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new AndroidRuntimeException("Animations may only be started on the main thread");
                }
                boolean z10 = c0030f.f76f;
                if (!z10 && !z10) {
                    c0030f.f76f = true;
                    if (!c0030f.f73c) {
                        c0030f.f75e.getClass();
                        c0030f.f72b = c0030f.f74d.f11838o * 10000.0f;
                    }
                    float f3 = c0030f.f72b;
                    if (f3 > Float.MAX_VALUE || f3 < -3.4028235E38f) {
                        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                    }
                    ThreadLocal threadLocal = C0027c.f57f;
                    if (threadLocal.get() == null) {
                        threadLocal.set(new C0027c());
                    }
                    C0027c c0027c = (C0027c) threadLocal.get();
                    ArrayList arrayList = c0027c.f59b;
                    if (arrayList.size() == 0) {
                        if (c0027c.f61d == null) {
                            c0027c.f61d = new C0026b(c0027c.f60c);
                        }
                        C0026b c0026b = c0027c.f61d;
                        ((Choreographer) c0026b.f55c).postFrameCallback((ChoreographerFrameCallbackC0025a) c0026b.f56d);
                    }
                    if (!arrayList.contains(c0030f)) {
                        arrayList.add(c0030f);
                    }
                }
            }
        }
        return true;
    }
}
