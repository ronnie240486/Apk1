package p226v0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p138n0.C3103b;
import p148o0.C3233h;
import p156o9.AbstractC3281e;
import p160p.C3348l;
import p171q.C3388b;
import p173q1.C3406f0;

public abstract class AbstractC3966b extends C3103b {

    public static final Rect f13460n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    public static final C3388b f13461o = new C3388b(6);

    public static final C3406f0 f13462p = new C3406f0(6);

    public final AccessibilityManager f13467h;

    public final View f13468i;

    public C3965a f13469j;

    public final Rect f13463d = new Rect();

    public final Rect f13464e = new Rect();

    public final Rect f13465f = new Rect();

    public final int[] f13466g = new int[2];

    public int f13470k = Integer.MIN_VALUE;

    public int f13471l = Integer.MIN_VALUE;

    public int f13472m = Integer.MIN_VALUE;

    public AbstractC3966b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f13468i = view;
        this.f13467h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @Override
    public final C2782c mo2981b(View view) {
        if (this.f13469j == null) {
            this.f13469j = new C3965a(this);
        }
        return this.f13469j;
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
        mo5445t(c3233h);
    }

    public final boolean m7937j(int i6) {
        if (this.f13471l != i6) {
            return false;
        }
        this.f13471l = Integer.MIN_VALUE;
        mo5446v(i6, false);
        m7945x(i6, 8);
        return true;
    }

    public final AccessibilityEvent m7938k(int i6, int i10) {
        View view = this.f13468i;
        if (i6 == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i10);
        C3233h c3233hM7943r = m7943r(i6);
        accessibilityEventObtain2.getText().add(c3233hM7943r.m6545g());
        AccessibilityNodeInfo accessibilityNodeInfo = c3233hM7943r.f10862a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        accessibilityEventObtain2.setSource(view, i6);
        accessibilityEventObtain2.setPackageName(view.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public final C3233h m7939l(int i6) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        C3233h c3233h = new C3233h(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        c3233h.m6547i("android.view.View");
        Rect rect = f13460n;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        View view = this.f13468i;
        accessibilityNodeInfoObtain.setParent(view);
        mo4332u(i6, c3233h);
        if (c3233h.m6545g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f13464e;
        c3233h.m6544f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        c3233h.f10863b = i6;
        accessibilityNodeInfoObtain.setSource(view, i6);
        if (this.f13470k == i6) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            c3233h.m6540a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            c3233h.m6540a(64);
        }
        boolean z7 = this.f13471l == i6;
        if (z7) {
            c3233h.m6540a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            c3233h.m6540a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z7);
        int[] iArr = this.f13466g;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f13463d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            c3233h.m6544f(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f13465f;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (parent instanceof View) {
                        View view2 = (View) parent;
                        if (view2.getAlpha() > 0.0f && view2.getVisibility() == 0) {
                            parent = view2.getParent();
                        }
                    }
                    if (parent != null) {
                        c3233h.f10862a.setVisibleToUser(true);
                    }
                }
            }
        }
        return c3233h;
    }

    public final boolean m7940m(MotionEvent motionEvent) {
        int i6;
        AccessibilityManager accessibilityManager = this.f13467h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iMo4329n = mo4329n(motionEvent.getX(), motionEvent.getY());
            int i10 = this.f13472m;
            if (i10 != iMo4329n) {
                this.f13472m = iMo4329n;
                m7945x(iMo4329n, 128);
                m7945x(i10, 256);
            }
            return iMo4329n != Integer.MIN_VALUE;
        }
        if (action != 10 || (i6 = this.f13472m) == Integer.MIN_VALUE) {
            return false;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f13472m = Integer.MIN_VALUE;
            m7945x(i6, 256);
        }
        return true;
    }

    public abstract int mo4329n(float f, float f3);

    public abstract void mo4330o(ArrayList arrayList);

    public final void m7941p(int i6) {
        View view;
        ViewParent parent;
        if (i6 == Integer.MIN_VALUE || !this.f13467h.isEnabled() || (parent = (view = this.f13468i).getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventM7938k = m7938k(i6, 2048);
        accessibilityEventM7938k.setContentChangeTypes(0);
        parent.requestSendAccessibilityEvent(view, accessibilityEventM7938k);
    }

    public final boolean m7942q(int i6, Rect rect) {
        Object obj;
        C3233h c3233h;
        int i10;
        Rect rect2;
        int i11;
        Rect rect3;
        int i12;
        C3233h c3233h2;
        int i13;
        int iM6635y;
        int iM6636z;
        ArrayList arrayList = new ArrayList();
        mo4330o(arrayList);
        C3348l c3348l = new C3348l();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            c3348l.m6820d(((Integer) arrayList.get(i14)).intValue(), m7939l(((Integer) arrayList.get(i14)).intValue()));
        }
        int i15 = this.f13471l;
        int i16 = Integer.MIN_VALUE;
        C3233h c3233h3 = i15 == Integer.MIN_VALUE ? null : (C3233h) c3348l.m6819c(i15);
        C3388b c3388b = f13461o;
        C3406f0 c3406f0 = f13462p;
        View view = this.f13468i;
        if (i6 == 1 || i6 == 2) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            boolean z7 = view.getLayoutDirection() == 1;
            c3406f0.getClass();
            int i17 = c3348l.f11337c;
            ArrayList arrayList2 = new ArrayList(i17);
            for (int i18 = 0; i18 < i17; i18++) {
                arrayList2.add((C3233h) c3348l.f11336b[i18]);
            }
            Collections.sort(arrayList2, new C3967c(z7, c3388b));
            if (i6 == 1) {
                int size = arrayList2.size();
                if (c3233h3 != null) {
                    size = arrayList2.indexOf(c3233h3);
                }
                int i19 = size - 1;
                if (i19 >= 0) {
                    obj = arrayList2.get(i19);
                } else {
                    obj = null;
                }
            } else {
                if (i6 != 2) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                int size2 = arrayList2.size();
                int iLastIndexOf = (c3233h3 == null ? -1 : arrayList2.lastIndexOf(c3233h3)) + 1;
                if (iLastIndexOf < size2) {
                    obj = arrayList2.get(iLastIndexOf);
                } else {
                    obj = null;
                }
            }
            c3233h = (C3233h) obj;
        } else {
            if (i6 != 17 && i6 != 33 && i6 != 66 && i6 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect4 = new Rect();
            int i20 = this.f13471l;
            if (i20 != Integer.MIN_VALUE) {
                m7943r(i20).m6544f(rect4);
            } else if (rect != null) {
                rect4.set(rect);
            } else {
                int width = view.getWidth();
                int height = view.getHeight();
                if (i6 == 17) {
                    rect4.set(width, 0, width, height);
                } else if (i6 == 33) {
                    rect4.set(0, height, width, height);
                } else if (i6 == 66) {
                    rect4.set(-1, 0, -1, height);
                } else {
                    if (i6 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect4.set(0, -1, width, -1);
                }
                rect2 = new Rect(rect4);
                if (i6 != 17) {
                    rect2.offset(rect4.width() + 1, 0);
                } else if (i6 != 33) {
                    rect2.offset(0, rect4.height() + 1);
                } else if (i6 != 66) {
                    rect2.offset(-(rect4.width() + 1), 0);
                } else {
                    if (i6 == 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect2.offset(0, -(rect4.height() + 1));
                }
                c3406f0.getClass();
                i11 = c3348l.f11337c;
                rect3 = new Rect();
                c3233h = null;
                for (i12 = 0; i12 < i11; i12++) {
                    c3233h2 = (C3233h) c3348l.f11336b[i12];
                    if (c3233h2 == c3233h3) {
                        c3388b.getClass();
                        c3233h2.m6544f(rect3);
                        if (AbstractC3281e.m6629s(i6, rect4, rect3)) {
                            if (AbstractC3281e.m6629s(i6, rect4, rect2) || AbstractC3281e.m6618h(i6, rect4, rect3, rect2)) {
                                rect2.set(rect3);
                                c3233h = c3233h2;
                            } else if (AbstractC3281e.m6618h(i6, rect4, rect2, rect3)) {
                                int iM6635y2 = AbstractC3281e.m6635y(i6, rect4, rect3);
                                int iM6636z2 = AbstractC3281e.m6636z(i6, rect4, rect3);
                                i13 = (iM6636z2 * iM6636z2) + (iM6635y2 * 13 * iM6635y2);
                                iM6635y = AbstractC3281e.m6635y(i6, rect4, rect2);
                                iM6636z = AbstractC3281e.m6636z(i6, rect4, rect2);
                                if (i13 < (iM6636z * iM6636z) + (iM6635y * 13 * iM6635y)) {
                                    rect2.set(rect3);
                                    c3233h = c3233h2;
                                }
                            }
                        }
                    }
                }
            }
            rect2 = new Rect(rect4);
            if (i6 != 17) {
                rect2.offset(rect4.width() + 1, 0);
            } else if (i6 != 33) {
                rect2.offset(0, rect4.height() + 1);
            } else if (i6 != 66) {
                rect2.offset(-(rect4.width() + 1), 0);
            } else {
                if (i6 == 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                rect2.offset(0, -(rect4.height() + 1));
            }
            c3406f0.getClass();
            i11 = c3348l.f11337c;
            rect3 = new Rect();
            c3233h = null;
            while (i12 < i11) {
                c3233h2 = (C3233h) c3348l.f11336b[i12];
                if (c3233h2 == c3233h3) {
                    c3388b.getClass();
                    c3233h2.m6544f(rect3);
                    if (AbstractC3281e.m6629s(i6, rect4, rect3)) {
                        if (AbstractC3281e.m6629s(i6, rect4, rect2)) {
                            rect2.set(rect3);
                            c3233h = c3233h2;
                        } else if (AbstractC3281e.m6618h(i6, rect4, rect2, rect3)) {
                            int iM6635y3 = AbstractC3281e.m6635y(i6, rect4, rect3);
                            int iM6636z3 = AbstractC3281e.m6636z(i6, rect4, rect3);
                            i13 = (iM6636z3 * iM6636z3) + (iM6635y3 * 13 * iM6635y3);
                            iM6635y = AbstractC3281e.m6635y(i6, rect4, rect2);
                            iM6636z = AbstractC3281e.m6636z(i6, rect4, rect2);
                            if (i13 < (iM6636z * iM6636z) + (iM6635y * 13 * iM6635y)) {
                                rect2.set(rect3);
                                c3233h = c3233h2;
                            }
                        }
                    }
                }
            }
        }
        C3233h c3233h4 = c3233h;
        if (c3233h4 != null) {
            int i21 = c3348l.f11337c;
            int i22 = 0;
            while (true) {
                if (i22 >= i21) {
                    i10 = -1;
                    break;
                }
                if (c3348l.f11336b[i22] == c3233h4) {
                    i10 = i22;
                    break;
                }
                i22++;
            }
            i16 = c3348l.f11335a[i10];
        }
        return m7944w(i16);
    }

    public final C3233h m7943r(int i6) {
        if (i6 != -1) {
            return m7939l(i6);
        }
        View view = this.f13468i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        C3233h c3233h = new C3233h(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        mo4330o(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            c3233h.f10862a.addChild(view, ((Integer) arrayList.get(i10)).intValue());
        }
        return c3233h;
    }

    public abstract boolean mo4331s(int i6, int i10, Bundle bundle);

    public abstract void mo4332u(int i6, C3233h c3233h);

    public final boolean m7944w(int i6) {
        int i10;
        View view = this.f13468i;
        if ((!view.isFocused() && !view.requestFocus()) || (i10 = this.f13471l) == i6) {
            return false;
        }
        if (i10 != Integer.MIN_VALUE) {
            m7937j(i10);
        }
        if (i6 == Integer.MIN_VALUE) {
            return false;
        }
        this.f13471l = i6;
        mo5446v(i6, true);
        m7945x(i6, 8);
        return true;
    }

    public final void m7945x(int i6, int i10) {
        View view;
        ViewParent parent;
        if (i6 == Integer.MIN_VALUE || !this.f13467h.isEnabled() || (parent = (view = this.f13468i).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, m7938k(i6, i10));
    }

    public void mo5445t(C3233h c3233h) {
    }

    public void mo5446v(int i6, boolean z7) {
    }
}
