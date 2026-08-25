package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3155s0;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    public RunnableC1756i f5841c;

    public OverScroller f5842d;

    public boolean f5843e;

    public int f5844f;

    public int f5845g;

    public int f5846h;

    public VelocityTracker f5847i;

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5844f = -1;
        this.f5846h = -1;
    }

    public int mo4074A(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11) {
        int iM6016g;
        int iM4097s = m4097s();
        if (i10 == 0 || iM4097s < i10 || iM4097s > i11 || iM4097s == (iM6016g = AbstractC2973a.m6016g(i6, i10, i11))) {
            return 0;
        }
        m4098v(iM6016g);
        return iM4097s - iM6016g;
    }

    public final void m4094B(CoordinatorLayout coordinatorLayout, View view, int i6) {
        mo4074A(coordinatorLayout, view, i6, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public boolean mo925g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f5846h < 0) {
            this.f5846h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f5843e) {
            int i6 = this.f5844f;
            if (i6 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i6)) == -1) {
                return false;
            }
            int y7 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y7 - this.f5845g) > this.f5846h) {
                this.f5845g = y7;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f5844f = -1;
            int x10 = (int) motionEvent.getX();
            int y9 = (int) motionEvent.getY();
            boolean z7 = mo4081w(view) && coordinatorLayout.m912t(view, x10, y9);
            this.f5843e = z7;
            if (z7) {
                this.f5845g = y9;
                this.f5844f = motionEvent.getPointerId(0);
                if (this.f5847i == null) {
                    this.f5847i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f5842d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f5842d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f5847i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    @Override
    public boolean mo936r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z7;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f5844f);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y7 = (int) motionEvent.getY(iFindPointerIndex);
                int i6 = this.f5845g - y7;
                this.f5845g = y7;
                mo4074A(coordinatorLayout, view, mo4080t() - i6, mo4082x(view), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i10 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f5844f = motionEvent.getPointerId(i10);
                    this.f5845g = (int) (motionEvent.getY(i10) + 0.5f);
                }
            }
            z7 = false;
            velocityTracker2 = this.f5847i;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.f5843e || z7;
        }
        VelocityTracker velocityTracker3 = this.f5847i;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f5847i.computeCurrentVelocity(1000);
            float yVelocity = this.f5847i.getYVelocity(this.f5844f);
            int i11 = -mo4083y(view);
            Runnable runnable = this.f5841c;
            if (runnable != null) {
                view.removeCallbacks(runnable);
                this.f5841c = null;
            }
            if (this.f5842d == null) {
                this.f5842d = new OverScroller(view.getContext());
            }
            this.f5842d.fling(0, m4097s(), 0, Math.round(yVelocity), 0, 0, i11, 0);
            if (this.f5842d.computeScrollOffset()) {
                RunnableC1756i runnableC1756i = new RunnableC1756i(this, coordinatorLayout, view);
                this.f5841c = runnableC1756i;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                view.postOnAnimation(runnableC1756i);
            } else {
                mo4084z(coordinatorLayout, view);
            }
            z7 = true;
        }
        this.f5843e = false;
        this.f5844f = -1;
        velocityTracker = this.f5847i;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5847i = null;
        }
        velocityTracker2 = this.f5847i;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f5843e) {
            return true;
        }
        z7 = false;
        this.f5843e = false;
        this.f5844f = -1;
        velocityTracker = this.f5847i;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5847i = null;
        }
        velocityTracker2 = this.f5847i;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f5843e) {
            return true;
        }
    }

    public boolean mo4081w(View view) {
        return false;
    }

    public int mo4082x(View view) {
        return -view.getHeight();
    }

    public int mo4083y(View view) {
        return view.getHeight();
    }

    public void mo4084z(CoordinatorLayout coordinatorLayout, View view) {
    }
}
