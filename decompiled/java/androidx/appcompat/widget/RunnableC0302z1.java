package androidx.appcompat.widget;

import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class RunnableC0302z1 implements Runnable {

    public final int f1153a;

    public final ListPopupWindow f1154b;

    public RunnableC0302z1(ListPopupWindow listPopupWindow, int i6) {
        this.f1153a = i6;
        this.f1154b = listPopupWindow;
    }

    @Override
    public final void run() {
        ListPopupWindow listPopupWindow = this.f1154b;
        switch (this.f1153a) {
            case 0:
                C0267s1 c0267s1 = listPopupWindow.f693c;
                if (c0267s1 != null) {
                    c0267s1.setListSelectionHidden(true);
                    c0267s1.requestLayout();
                }
                break;
            default:
                C0267s1 c0267s2 = listPopupWindow.f693c;
                if (c0267s2 != null) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    if (c0267s2.isAttachedToWindow() && listPopupWindow.f693c.getCount() > listPopupWindow.f693c.getChildCount() && listPopupWindow.f693c.getChildCount() <= listPopupWindow.f703m) {
                        listPopupWindow.f715y.setInputMethodMode(2);
                        listPopupWindow.mo576a();
                        break;
                    }
                }
                break;
        }
    }
}
