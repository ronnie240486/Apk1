package p267z0;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p138n0.C3103b;
import p148o0.C3228c;
import p148o0.C3233h;

public final class C4284b extends C3103b {

    public final Rect f14508d = new Rect();

    public final DrawerLayout f14509e;

    public C4284b(DrawerLayout drawerLayout) {
        this.f14509e = drawerLayout;
    }

    @Override
    public final boolean mo2980a(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return this.f10576a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        accessibilityEvent.getText();
        DrawerLayout drawerLayout = this.f14509e;
        View viewM1170f = drawerLayout.m1170f();
        if (viewM1170f == null) {
            return true;
        }
        int iM1172h = drawerLayout.m1172h(viewM1170f);
        drawerLayout.getClass();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        Gravity.getAbsoluteGravity(iM1172h, drawerLayout.getLayoutDirection());
        return true;
    }

    @Override
    public final void mo1135c(View view, AccessibilityEvent accessibilityEvent) {
        super.mo1135c(view, accessibilityEvent);
        accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        boolean z7 = DrawerLayout.f1706E;
        View.AccessibilityDelegate accessibilityDelegate = this.f10576a;
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        if (z7) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        } else {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoObtain);
            c3233h.f10863b = -1;
            accessibilityNodeInfo.setSource(view);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            Object parentForAccessibility = view.getParentForAccessibility();
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfo.setParent((View) parentForAccessibility);
            }
            Rect rect = this.f14508d;
            accessibilityNodeInfoObtain.getBoundsInScreen(rect);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
            accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
            c3233h.m6547i(accessibilityNodeInfoObtain.getClassName());
            c3233h.m6550l(accessibilityNodeInfoObtain.getContentDescription());
            accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
            accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
            accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
            accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
            c3233h.m6540a(accessibilityNodeInfoObtain.getActions());
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if (DrawerLayout.m1161i(childAt)) {
                    accessibilityNodeInfo.addChild(childAt);
                }
            }
        }
        c3233h.m6547i("androidx.drawerlayout.widget.DrawerLayout");
        accessibilityNodeInfo.setFocusable(false);
        accessibilityNodeInfo.setFocused(false);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) C3228c.f10841e.f10856a);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) C3228c.f10842f.f10856a);
    }

    @Override
    public final boolean mo2983f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.f1706E || DrawerLayout.m1161i(view)) {
            return this.f10576a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        return false;
    }
}
