package com.google.android.material.timepicker;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.p2serv.android.p032ds.R;
import p138n0.C3103b;
import p148o0.C3228c;
import p148o0.C3232g;
import p148o0.C3233h;

public final class C1886c extends C3103b {

    public final ClockFaceView f6945d;

    public C1886c(ClockFaceView clockFaceView) {
        this.f6945d = clockFaceView;
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        View.AccessibilityDelegate accessibilityDelegate = this.f10576a;
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (iIntValue > 0) {
            View view2 = (View) this.f6945d.f6920w.get(iIntValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(view2);
            }
        }
        c3233h.m6549k(C3232g.m6538a(0, 1, iIntValue, 1, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        c3233h.m6541b(C3228c.f10843g);
    }

    @Override
    public final boolean mo1137g(View view, int i6, Bundle bundle) {
        if (i6 != 16) {
            return super.mo1137g(view, i6, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        float x10 = view.getX() + (view.getWidth() / 2.0f);
        float height = (view.getHeight() / 2.0f) + view.getY();
        ClockFaceView clockFaceView = this.f6945d;
        clockFaceView.f6917t.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, x10, height, 0));
        clockFaceView.f6917t.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, x10, height, 0));
        return true;
    }
}
