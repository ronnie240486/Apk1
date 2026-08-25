package androidx.core.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import p138n0.C3103b;
import p148o0.C3228c;
import p148o0.C3233h;

public final class C0376i extends C3103b {

    public final int f1681d;

    public C0376i(int i6) {
        this.f1681d = i6;
    }

    @Override
    public void mo1135c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f1681d) {
            case 0:
                super.mo1135c(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
                break;
            default:
                super.mo1135c(view, accessibilityEvent);
                break;
        }
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        int scrollRange;
        switch (this.f1681d) {
            case 0:
                this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                c3233h.m6547i(ScrollView.class.getName());
                if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                    c3233h.m6552n(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c3233h.m6541b(C3228c.f10845i);
                        c3233h.m6541b(C3228c.f10850n);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        c3233h.m6541b(C3228c.f10844h);
                        c3233h.m6541b(C3228c.f10852p);
                    }
                    break;
                }
                break;
            case 1:
                this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
                c3233h.m6548j(null);
                break;
            case 2:
                this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
                c3233h.m6548j(null);
                break;
            default:
                View.AccessibilityDelegate accessibilityDelegate = this.f10576a;
                AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (!DrawerLayout.m1161i(view)) {
                    accessibilityNodeInfo.setParent(null);
                }
                break;
        }
    }

    @Override
    public boolean mo1137g(View view, int i6, Bundle bundle) {
        int iMin;
        switch (this.f1681d) {
            case 0:
                if (super.mo1137g(view, i6, bundle)) {
                    return true;
                }
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                if (nestedScrollView.isEnabled()) {
                    int height = nestedScrollView.getHeight();
                    Rect rect = new Rect();
                    if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                        height = rect.height();
                    }
                    if (i6 == 4096) {
                        iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                        if (iMin != nestedScrollView.getScrollY()) {
                            nestedScrollView.m1112v(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                            return true;
                        }
                    } else if (i6 == 8192 || i6 == 16908344) {
                        int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                        if (iMax != nestedScrollView.getScrollY()) {
                            nestedScrollView.m1112v(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                            return true;
                        }
                    } else if (i6 == 16908346) {
                        iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                        if (iMin != nestedScrollView.getScrollY()) {
                            nestedScrollView.m1112v(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                            return true;
                        }
                    }
                }
                return false;
            default:
                return super.mo1137g(view, i6, bundle);
        }
    }
}
