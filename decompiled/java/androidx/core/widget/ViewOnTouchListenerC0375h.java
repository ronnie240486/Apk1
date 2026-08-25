package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.widget.C0267s1;
import java.util.WeakHashMap;
import p000a.RunnableC0005f;
import p138n0.AbstractC3155s0;

public final class ViewOnTouchListenerC0375h implements View.OnTouchListener {

    public static final int f1663r = ViewConfiguration.getTapTimeout();

    public final C0368a f1664a;

    public final AccelerateInterpolator f1665b;

    public final ListView f1666c;

    public RunnableC0005f f1667d;

    public final float[] f1668e;

    public final float[] f1669f;

    public final int f1670g;

    public final int f1671h;

    public final float[] f1672i;

    public final float[] f1673j;

    public final float[] f1674k;

    public boolean f1675l;

    public boolean f1676m;

    public boolean f1677n;

    public boolean f1678o;

    public boolean f1679p;

    public final C0267s1 f1680q;

    public ViewOnTouchListenerC0375h(C0267s1 c0267s1) {
        C0368a c0368a = new C0368a();
        c0368a.f1656e = Long.MIN_VALUE;
        c0368a.f1658g = -1L;
        c0368a.f1657f = 0L;
        this.f1664a = c0368a;
        this.f1665b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f1668e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1669f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f1672i = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f1673j = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1674k = fArr5;
        this.f1666c = c0267s1;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f3 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f3;
        fArr5[1] = f3;
        float f4 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f4;
        fArr4[1] = f4;
        this.f1670g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f1671h = f1663r;
        c0368a.f1652a = 500;
        c0368a.f1653b = 500;
        this.f1680q = c0267s1;
    }

    public static float m1130b(float f, float f3, float f4) {
        if (f > f4) {
            return f4;
        }
        return f < f3 ? f3 : f;
    }

    public final float m1131a(float f, int i6, float f3, float f4) {
        float fM1130b;
        float interpolation;
        float fM1130b2 = m1130b(this.f1668e[i6] * f3, 0.0f, this.f1669f[i6]);
        float fM1132c = m1132c(f3 - f, fM1130b2) - m1132c(f, fM1130b2);
        AccelerateInterpolator accelerateInterpolator = this.f1665b;
        if (fM1132c >= 0.0f) {
            if (fM1132c > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fM1132c);
            } else {
                fM1130b = 0.0f;
            }
            if (fM1130b == 0.0f) {
                return 0.0f;
            }
            float f5 = this.f1672i[i6];
            float f10 = this.f1673j[i6];
            float f11 = this.f1674k[i6];
            float f12 = f5 * f4;
            return fM1130b > 0.0f ? m1130b(fM1130b * f12, f10, f11) : -m1130b((-fM1130b) * f12, f10, f11);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fM1132c);
        fM1130b = m1130b(interpolation, -1.0f, 1.0f);
        if (fM1130b == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f1672i[i6];
        float f14 = this.f1673j[i6];
        float f15 = this.f1674k[i6];
        float f16 = f13 * f4;
        if (fM1130b > 0.0f) {
        }
    }

    public final float m1132c(float f, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i6 = this.f1670g;
        if (i6 == 0 || i6 == 1) {
            if (f < f3) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f3);
                }
                if (this.f1678o && i6 == 1) {
                    return 1.0f;
                }
            }
        } else if (i6 == 2 && f < 0.0f) {
            return f / (-f3);
        }
        return 0.0f;
    }

    public final void m1133d() {
        int i6 = 0;
        if (this.f1676m) {
            this.f1678o = false;
            return;
        }
        C0368a c0368a = this.f1664a;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i10 = (int) (jCurrentAnimationTimeMillis - c0368a.f1656e);
        int i11 = c0368a.f1653b;
        if (i10 > i11) {
            i6 = i11;
        } else if (i10 >= 0) {
            i6 = i10;
        }
        c0368a.f1660i = i6;
        c0368a.f1659h = c0368a.m1116a(jCurrentAnimationTimeMillis);
        c0368a.f1658g = jCurrentAnimationTimeMillis;
    }

    public final boolean m1134e() {
        C0267s1 c0267s1;
        int count;
        C0368a c0368a = this.f1664a;
        float f = c0368a.f1655d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(c0368a.f1654c);
        if (iAbs == 0 || (count = (c0267s1 = this.f1680q).getCount()) == 0) {
            return false;
        }
        int childCount = c0267s1.getChildCount();
        int firstVisiblePosition = c0267s1.getFirstVisiblePosition();
        int i6 = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i6 >= count && c0267s1.getChildAt(childCount - 1).getBottom() <= c0267s1.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && c0267s1.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i6;
        if (!this.f1679p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                m1133d();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    m1133d();
                }
            }
            return false;
        }
        this.f1677n = true;
        this.f1675l = false;
        float x10 = motionEvent.getX();
        float width = view.getWidth();
        ListView listView = this.f1666c;
        float fM1131a = m1131a(x10, 0, width, listView.getWidth());
        float fM1131a2 = m1131a(motionEvent.getY(), 1, view.getHeight(), listView.getHeight());
        C0368a c0368a = this.f1664a;
        c0368a.f1654c = fM1131a;
        c0368a.f1655d = fM1131a2;
        if (!this.f1678o && m1134e()) {
            if (this.f1667d == null) {
                this.f1667d = new RunnableC0005f(4, this);
            }
            this.f1678o = true;
            this.f1676m = true;
            if (this.f1675l || (i6 = this.f1671h) <= 0) {
                this.f1667d.run();
            } else {
                RunnableC0005f runnableC0005f = this.f1667d;
                long j10 = i6;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                listView.postOnAnimationDelayed(runnableC0005f, j10);
            }
            this.f1675l = true;
        }
        return false;
    }
}
