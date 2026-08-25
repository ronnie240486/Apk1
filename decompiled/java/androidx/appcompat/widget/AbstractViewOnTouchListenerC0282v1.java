package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import p105k.InterfaceC2827c0;

public abstract class AbstractViewOnTouchListenerC0282v1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    public final float f1088a;

    public final int f1089b;

    public final int f1090c;

    public final View f1091d;

    public RunnableC0277u1 f1092e;

    public RunnableC0277u1 f1093f;

    public boolean f1094g;

    public int f1095h;

    public final int[] f1096i = new int[2];

    public AbstractViewOnTouchListenerC0282v1(View view) {
        this.f1091d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1088a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1089b = tapTimeout;
        this.f1090c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void m796a() {
        RunnableC0277u1 runnableC0277u1 = this.f1093f;
        View view = this.f1091d;
        if (runnableC0277u1 != null) {
            view.removeCallbacks(runnableC0277u1);
        }
        RunnableC0277u1 runnableC0277u2 = this.f1092e;
        if (runnableC0277u2 != null) {
            view.removeCallbacks(runnableC0277u2);
        }
    }

    public abstract InterfaceC2827c0 mo655b();

    public abstract boolean mo656c();

    public boolean mo686d() {
        InterfaceC2827c0 interfaceC2827c0Mo655b = mo655b();
        if (interfaceC2827c0Mo655b == null || !interfaceC2827c0Mo655b.mo578c()) {
            return true;
        }
        interfaceC2827c0Mo655b.dismiss();
        return true;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        C0267s1 c0267s1Mo581h;
        boolean z10 = this.f1094g;
        View view2 = this.f1091d;
        if (z10) {
            InterfaceC2827c0 interfaceC2827c0Mo655b = mo655b();
            if (interfaceC2827c0Mo655b != null && interfaceC2827c0Mo655b.mo578c() && (c0267s1Mo581h = interfaceC2827c0Mo655b.mo581h()) != null && c0267s1Mo581h.isShown()) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.f1096i;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                c0267s1Mo581h.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zM770b = c0267s1Mo581h.m770b(motionEventObtainNoHistory, this.f1095h);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z11 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (zM770b && z11) {
                    z7 = true;
                } else if (mo686d()) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            } else if (mo686d()) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.f1095h = motionEvent.getPointerId(0);
                    if (this.f1092e == null) {
                        this.f1092e = new RunnableC0277u1(this, 0);
                    }
                    view2.postDelayed(this.f1092e, this.f1089b);
                    if (this.f1093f == null) {
                        this.f1093f = new RunnableC0277u1(this, 1);
                    }
                    view2.postDelayed(this.f1093f, this.f1090c);
                } else if (actionMasked2 == 1) {
                    m796a();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f1095h);
                    if (iFindPointerIndex >= 0) {
                        float x10 = motionEvent.getX(iFindPointerIndex);
                        float y7 = motionEvent.getY(iFindPointerIndex);
                        float f = this.f1088a;
                        float f3 = -f;
                        if (x10 < f3 || y7 < f3 || x10 >= (view2.getRight() - view2.getLeft()) + f || y7 >= (view2.getBottom() - view2.getTop()) + f) {
                            m796a();
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                            z7 = mo656c();
                        }
                    }
                } else if (actionMasked2 == 3) {
                    m796a();
                }
            }
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1094g = z7;
        return z7 || z10;
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        this.f1094g = false;
        this.f1095h = -1;
        RunnableC0277u1 runnableC0277u1 = this.f1092e;
        if (runnableC0277u1 != null) {
            this.f1091d.removeCallbacks(runnableC0277u1);
        }
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
    }
}
