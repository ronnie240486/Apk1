package p226v0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.youth.banner.config.BannerConfig;
import java.util.Arrays;
import p015b2.InterpolatorC1253e;
import p138n0.AbstractC3155s0;
import p173q1.RunnableC3431n1;
import p187r4.AbstractC3612b;

public final class C3968d {

    public static final InterpolatorC1253e f13477x = new InterpolatorC1253e(1);

    public int f13478a;

    public int f13479b;

    public float[] f13481d;

    public float[] f13482e;

    public float[] f13483f;

    public float[] f13484g;

    public int[] f13485h;

    public int[] f13486i;

    public int[] f13487j;

    public int f13488k;

    public VelocityTracker f13489l;

    public final float f13490m;

    public float f13491n;

    public int f13492o;

    public final int f13493p;

    public int f13494q;

    public final OverScroller f13495r;

    public final AbstractC3612b f13496s;

    public View f13497t;

    public boolean f13498u;

    public final ViewGroup f13499v;

    public int f13480c = -1;

    public final RunnableC3431n1 f13500w = new RunnableC3431n1(3, this);

    public C3968d(Context context, ViewGroup viewGroup, AbstractC3612b abstractC3612b) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC3612b == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f13499v = viewGroup;
        this.f13496s = abstractC3612b;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i6 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f13493p = i6;
        this.f13492o = i6;
        this.f13479b = viewConfiguration.getScaledTouchSlop();
        this.f13490m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f13491n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f13495r = new OverScroller(context, f13477x);
    }

    public final void m7946a() {
        this.f13480c = -1;
        float[] fArr = this.f13481d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f13482e, 0.0f);
            Arrays.fill(this.f13483f, 0.0f);
            Arrays.fill(this.f13484g, 0.0f);
            Arrays.fill(this.f13485h, 0);
            Arrays.fill(this.f13486i, 0);
            Arrays.fill(this.f13487j, 0);
            this.f13488k = 0;
        }
        VelocityTracker velocityTracker = this.f13489l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f13489l = null;
        }
    }

    public final void m7947b(int i6, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f13499v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f13497t = view;
        this.f13480c = i6;
        this.f13496s.mo208F(i6, view);
        m7961p(1);
    }

    public final boolean m7948c(float f, float f3, int i6, int i10) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f3);
        if ((this.f13485h[i6] & i10) != i10 || (this.f13494q & i10) == 0 || (this.f13487j[i6] & i10) == i10 || (this.f13486i[i6] & i10) == i10) {
            return false;
        }
        float f4 = this.f13479b;
        if (fAbs <= f4 && fAbs2 <= f4) {
            return false;
        }
        if (fAbs < fAbs2 * 0.5f) {
            this.f13496s.getClass();
        }
        return (this.f13486i[i6] & i10) == 0 && fAbs > ((float) this.f13479b);
    }

    public final boolean m7949d(View view, float f, float f3) {
        if (view == null) {
            return false;
        }
        AbstractC3612b abstractC3612b = this.f13496s;
        boolean z7 = abstractC3612b.mo215x(view) > 0;
        boolean z10 = abstractC3612b.mo3268y() > 0;
        if (z7 && z10) {
            float f4 = (f3 * f3) + (f * f);
            int i6 = this.f13479b;
            return f4 > ((float) (i6 * i6));
        }
        if (z7) {
            return Math.abs(f) > ((float) this.f13479b);
        }
        return z10 && Math.abs(f3) > ((float) this.f13479b);
    }

    public final void m7950e(int i6) {
        float[] fArr = this.f13481d;
        if (fArr != null) {
            int i10 = this.f13488k;
            int i11 = 1 << i6;
            if ((i10 & i11) != 0) {
                fArr[i6] = 0.0f;
                this.f13482e[i6] = 0.0f;
                this.f13483f[i6] = 0.0f;
                this.f13484g[i6] = 0.0f;
                this.f13485h[i6] = 0;
                this.f13486i[i6] = 0;
                this.f13487j[i6] = 0;
                this.f13488k = (~i11) & i10;
            }
        }
    }

    public final int m7951f(int i6, int i10, int i11) {
        if (i6 == 0) {
            return 0;
        }
        int width = this.f13499v.getWidth();
        float f = width / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i6) / width) - 0.5f) * 0.47123894f)) * f) + f;
        int iAbs = Math.abs(i10);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / i11) + 1.0f) * 256.0f), BannerConfig.SCROLL_TIME);
    }

    public final boolean m7952g() {
        if (this.f13478a == 2) {
            OverScroller overScroller = this.f13495r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f13497t.getLeft();
            int top = currY - this.f13497t.getTop();
            if (left != 0) {
                AbstractC3155s0.m6339i(left, this.f13497t);
            }
            if (top != 0) {
                AbstractC3155s0.m6340j(top, this.f13497t);
            }
            if (left != 0 || top != 0) {
                this.f13496s.mo210H(this.f13497t, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f13499v.post(this.f13500w);
            }
        }
        return this.f13478a == 2;
    }

    public final View m7953h(int i6, int i10) {
        ViewGroup viewGroup = this.f13499v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f13496s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && i10 >= childAt.getTop() && i10 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean m7954i(int i6, int i10, int i11, int i12) {
        float f;
        float f3;
        float f4;
        float f5;
        int left = this.f13497t.getLeft();
        int top = this.f13497t.getTop();
        int i13 = i6 - left;
        int i14 = i10 - top;
        OverScroller overScroller = this.f13495r;
        if (i13 == 0 && i14 == 0) {
            overScroller.abortAnimation();
            m7961p(0);
            return false;
        }
        View view = this.f13497t;
        int i15 = (int) this.f13491n;
        int i16 = (int) this.f13490m;
        int iAbs = Math.abs(i11);
        if (iAbs < i15) {
            i11 = 0;
        } else if (iAbs > i16) {
            i11 = i11 > 0 ? i16 : -i16;
        }
        int i17 = (int) this.f13491n;
        int iAbs2 = Math.abs(i12);
        if (iAbs2 < i17) {
            i12 = 0;
        } else if (iAbs2 > i16) {
            i12 = i12 > 0 ? i16 : -i16;
        }
        int iAbs3 = Math.abs(i13);
        int iAbs4 = Math.abs(i14);
        int iAbs5 = Math.abs(i11);
        int iAbs6 = Math.abs(i12);
        int i18 = iAbs5 + iAbs6;
        int i19 = iAbs3 + iAbs4;
        if (i11 != 0) {
            f = iAbs5;
            f3 = i18;
        } else {
            f = iAbs3;
            f3 = i19;
        }
        float f10 = f / f3;
        if (i12 != 0) {
            f4 = iAbs6;
            f5 = i18;
        } else {
            f4 = iAbs4;
            f5 = i19;
        }
        float f11 = f4 / f5;
        AbstractC3612b abstractC3612b = this.f13496s;
        overScroller.startScroll(left, top, i13, i14, (int) ((m7951f(i14, i12, abstractC3612b.mo3268y()) * f11) + (m7951f(i13, i11, abstractC3612b.mo215x(view)) * f10)));
        m7961p(2);
        return true;
    }

    public final boolean m7955j(int i6) {
        if ((this.f13488k & (1 << i6)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i6 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void m7956k(MotionEvent motionEvent) {
        int i6;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m7946a();
        }
        if (this.f13489l == null) {
            this.f13489l = VelocityTracker.obtain();
        }
        this.f13489l.addMovement(motionEvent);
        int i10 = 0;
        AbstractC3612b abstractC3612b = this.f13496s;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y7 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewM7953h = m7953h((int) x10, (int) y7);
            m7959n(x10, y7, pointerId);
            m7965t(pointerId, viewM7953h);
            if ((this.f13485h[pointerId] & this.f13494q) != 0) {
                abstractC3612b.mo1179E();
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f13478a == 1) {
                m7957l();
            }
            m7946a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f13478a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i10 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i10);
                    if (m7955j(pointerId2)) {
                        float x11 = motionEvent.getX(i10);
                        float y9 = motionEvent.getY(i10);
                        float f = x11 - this.f13481d[pointerId2];
                        float f3 = y9 - this.f13482e[pointerId2];
                        m7958m(f, f3, pointerId2);
                        if (this.f13478a != 1) {
                            View viewM7953h2 = m7953h((int) x11, (int) y9);
                            if (m7949d(viewM7953h2, f, f3) && m7965t(pointerId2, viewM7953h2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i10++;
                }
                m7960o(motionEvent);
                return;
            }
            if (m7955j(this.f13480c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f13480c);
                float x12 = motionEvent.getX(iFindPointerIndex);
                float y10 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f13483f;
                int i11 = this.f13480c;
                int i12 = (int) (x12 - fArr[i11]);
                int i13 = (int) (y10 - this.f13484g[i11]);
                int left = this.f13497t.getLeft() + i12;
                int top = this.f13497t.getTop() + i13;
                int left2 = this.f13497t.getLeft();
                int top2 = this.f13497t.getTop();
                if (i12 != 0) {
                    left = abstractC3612b.mo213d(left, this.f13497t);
                    AbstractC3155s0.m6339i(left - left2, this.f13497t);
                }
                if (i13 != 0) {
                    top = abstractC3612b.mo214e(top, this.f13497t);
                    AbstractC3155s0.m6340j(top - top2, this.f13497t);
                }
                if (i12 != 0 || i13 != 0) {
                    abstractC3612b.mo210H(this.f13497t, left, top);
                }
                m7960o(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f13478a == 1) {
                this.f13498u = true;
                abstractC3612b.mo211I(this.f13497t, 0.0f, 0.0f);
                this.f13498u = false;
                if (this.f13478a == 1) {
                    m7961p(0);
                }
            }
            m7946a();
            return;
        }
        if (actionMasked != 5) {
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f13478a == 1 && pointerId3 == this.f13480c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i10 >= pointerCount2) {
                        i6 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i10);
                    if (pointerId4 != this.f13480c) {
                        View viewM7953h3 = m7953h((int) motionEvent.getX(i10), (int) motionEvent.getY(i10));
                        View view = this.f13497t;
                        if (viewM7953h3 == view && m7965t(pointerId4, view)) {
                            i6 = this.f13480c;
                            break;
                        }
                    }
                    i10++;
                }
                if (i6 == -1) {
                    m7957l();
                }
            }
            m7950e(pointerId3);
            return;
        }
        int pointerId5 = motionEvent.getPointerId(actionIndex);
        float x13 = motionEvent.getX(actionIndex);
        float y11 = motionEvent.getY(actionIndex);
        m7959n(x13, y11, pointerId5);
        if (this.f13478a == 0) {
            m7965t(pointerId5, m7953h((int) x13, (int) y11));
            if ((this.f13485h[pointerId5] & this.f13494q) != 0) {
                abstractC3612b.mo1179E();
                return;
            }
            return;
        }
        int i14 = (int) x13;
        int i15 = (int) y11;
        View view2 = this.f13497t;
        if (view2 != null && i14 >= view2.getLeft() && i14 < view2.getRight() && i15 >= view2.getTop() && i15 < view2.getBottom()) {
            i10 = 1;
        }
        if (i10 != 0) {
            m7965t(pointerId5, this.f13497t);
        }
    }

    public final void m7957l() {
        VelocityTracker velocityTracker = this.f13489l;
        float f = this.f13490m;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.f13489l.getXVelocity(this.f13480c);
        float f3 = this.f13491n;
        float fAbs = Math.abs(xVelocity);
        float f4 = 0.0f;
        if (fAbs < f3) {
            xVelocity = 0.0f;
        } else if (fAbs > f) {
            xVelocity = xVelocity > 0.0f ? f : -f;
        }
        float yVelocity = this.f13489l.getYVelocity(this.f13480c);
        float f5 = this.f13491n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f5) {
            if (fAbs2 > f) {
                if (yVelocity <= 0.0f) {
                    f = -f;
                }
                f4 = f;
            } else {
                f4 = yVelocity;
            }
        }
        this.f13498u = true;
        this.f13496s.mo211I(this.f13497t, xVelocity, f4);
        this.f13498u = false;
        if (this.f13478a == 1) {
            m7961p(0);
        }
    }

    public final void m7958m(float f, float f3, int i6) {
        int i10;
        boolean zM7948c = m7948c(f, f3, i6, 1);
        ?? r10 = zM7948c;
        if (m7948c(f3, f, i6, 4)) {
            r10 = (zM7948c ? 1 : 0) | 4;
        }
        ?? r11 = r10;
        if (m7948c(f, f3, i6, 2)) {
            r11 = (r10 == true ? 1 : 0) | 2;
        }
        ?? r12 = r11;
        if (m7948c(f3, f, i6, 8)) {
            i10 = (r11 == true ? 1 : 0) | 8;
        }
        if (r12 == 0) {
            r12 = i10;
            return;
        }
        r12 = i10;
        int[] iArr = this.f13486i;
        iArr[i6] = (iArr[i6] | r12) == true ? 1 : 0;
        this.f13496s.mo1178D(r12, i6);
    }

    public final void m7959n(float f, float f3, int i6) {
        float[] fArr = this.f13481d;
        if (fArr == null || fArr.length <= i6) {
            int i10 = i6 + 1;
            float[] fArr2 = new float[i10];
            float[] fArr3 = new float[i10];
            float[] fArr4 = new float[i10];
            float[] fArr5 = new float[i10];
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            int[] iArr3 = new int[i10];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f13482e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f13483f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f13484g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f13485h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f13486i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f13487j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f13481d = fArr2;
            this.f13482e = fArr3;
            this.f13483f = fArr4;
            this.f13484g = fArr5;
            this.f13485h = iArr;
            this.f13486i = iArr2;
            this.f13487j = iArr3;
        }
        float[] fArr9 = this.f13481d;
        this.f13483f[i6] = f;
        fArr9[i6] = f;
        float[] fArr10 = this.f13482e;
        this.f13484g[i6] = f3;
        fArr10[i6] = f3;
        int[] iArr7 = this.f13485h;
        int i11 = (int) f;
        int i12 = (int) f3;
        ViewGroup viewGroup = this.f13499v;
        int i13 = i11 < viewGroup.getLeft() + this.f13492o ? 1 : 0;
        if (i12 < viewGroup.getTop() + this.f13492o) {
            i13 |= 4;
        }
        if (i11 > viewGroup.getRight() - this.f13492o) {
            i13 |= 2;
        }
        if (i12 > viewGroup.getBottom() - this.f13492o) {
            i13 |= 8;
        }
        iArr7[i6] = i13;
        this.f13488k |= 1 << i6;
    }

    public final void m7960o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i6 = 0; i6 < pointerCount; i6++) {
            int pointerId = motionEvent.getPointerId(i6);
            if (m7955j(pointerId)) {
                float x10 = motionEvent.getX(i6);
                float y7 = motionEvent.getY(i6);
                this.f13483f[pointerId] = x10;
                this.f13484g[pointerId] = y7;
            }
        }
    }

    public final void m7961p(int i6) {
        this.f13499v.removeCallbacks(this.f13500w);
        if (this.f13478a != i6) {
            this.f13478a = i6;
            this.f13496s.mo209G(i6);
            if (this.f13478a == 0) {
                this.f13497t = null;
            }
        }
    }

    public final boolean m7962q(int i6, int i10) {
        if (this.f13498u) {
            return m7954i(i6, i10, (int) this.f13489l.getXVelocity(this.f13480c), (int) this.f13489l.getYVelocity(this.f13480c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public final boolean m7963r(MotionEvent motionEvent) {
        View viewM7953h;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m7946a();
        }
        if (this.f13489l == null) {
            this.f13489l = VelocityTracker.obtain();
        }
        this.f13489l.addMovement(motionEvent);
        AbstractC3612b abstractC3612b = this.f13496s;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y7 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            m7959n(x10, y7, pointerId);
            View viewM7953h2 = m7953h((int) x10, (int) y7);
            if (viewM7953h2 == this.f13497t && this.f13478a == 2) {
                m7965t(pointerId, viewM7953h2);
            }
            if ((this.f13485h[pointerId] & this.f13494q) != 0) {
                abstractC3612b.mo1179E();
            }
        } else if (actionMasked == 1) {
            m7946a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                m7946a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x11 = motionEvent.getX(actionIndex);
                float y9 = motionEvent.getY(actionIndex);
                m7959n(x11, y9, pointerId2);
                int i6 = this.f13478a;
                if (i6 == 0) {
                    if ((this.f13485h[pointerId2] & this.f13494q) != 0) {
                        abstractC3612b.mo1179E();
                    }
                } else if (i6 == 2 && (viewM7953h = m7953h((int) x11, (int) y9)) == this.f13497t) {
                    m7965t(pointerId2, viewM7953h);
                }
            } else if (actionMasked == 6) {
                m7950e(motionEvent.getPointerId(actionIndex));
            }
        } else if (this.f13481d != null && this.f13482e != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i10 = 0; i10 < pointerCount; i10++) {
                int pointerId3 = motionEvent.getPointerId(i10);
                if (m7955j(pointerId3)) {
                    float x12 = motionEvent.getX(i10);
                    float y10 = motionEvent.getY(i10);
                    float f = x12 - this.f13481d[pointerId3];
                    float f3 = y10 - this.f13482e[pointerId3];
                    View viewM7953h3 = m7953h((int) x12, (int) y10);
                    boolean z7 = viewM7953h3 != null && m7949d(viewM7953h3, f, f3);
                    if (!z7) {
                        m7958m(f, f3, pointerId3);
                        if (this.f13478a != 1) {
                            break;
                        }
                    } else {
                        int left = viewM7953h3.getLeft();
                        int iMo213d = abstractC3612b.mo213d(((int) f) + left, viewM7953h3);
                        int top = viewM7953h3.getTop();
                        int iMo214e = abstractC3612b.mo214e(((int) f3) + top, viewM7953h3);
                        int iMo215x = abstractC3612b.mo215x(viewM7953h3);
                        int iMo3268y = abstractC3612b.mo3268y();
                        if ((iMo215x == 0 || (iMo215x > 0 && iMo213d == left)) && (iMo3268y == 0 || (iMo3268y > 0 && iMo214e == top))) {
                            break;
                        }
                        m7958m(f, f3, pointerId3);
                        if (this.f13478a != 1 || (z7 && m7965t(pointerId3, viewM7953h3))) {
                            break;
                        }
                    }
                }
            }
            m7960o(motionEvent);
        }
        return this.f13478a == 1;
    }

    public final boolean m7964s(View view, int i6, int i10) {
        this.f13497t = view;
        this.f13480c = -1;
        boolean zM7954i = m7954i(i6, i10, 0, 0);
        if (!zM7954i && this.f13478a == 0 && this.f13497t != null) {
            this.f13497t = null;
        }
        return zM7954i;
    }

    public final boolean m7965t(int i6, View view) {
        if (view == this.f13497t && this.f13480c == i6) {
            return true;
        }
        if (view == null || !this.f13496s.mo212O(i6, view)) {
            return false;
        }
        this.f13480c = i6;
        m7947b(i6, view);
        return true;
    }
}
