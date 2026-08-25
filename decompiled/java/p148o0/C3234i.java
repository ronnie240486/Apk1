package p148o0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import p101j7.C2782c;

public class C3234i extends AccessibilityNodeProvider {

    public final C2782c f10864a;

    public C3234i(C2782c c2782c) {
        this.f10864a = c2782c;
    }

    @Override
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i6) {
        C3233h c3233hMo5760s = this.f10864a.mo5760s(i6);
        if (c3233hMo5760s == null) {
            return null;
        }
        return c3233hMo5760s.f10862a;
    }

    @Override
    public final List findAccessibilityNodeInfosByText(String str, int i6) {
        this.f10864a.getClass();
        return null;
    }

    @Override
    public final AccessibilityNodeInfo findFocus(int i6) {
        C3233h c3233hMo5761t = this.f10864a.mo5761t(i6);
        if (c3233hMo5761t == null) {
            return null;
        }
        return c3233hMo5761t.f10862a;
    }

    @Override
    public final boolean performAction(int i6, int i10, Bundle bundle) {
        return this.f10864a.mo5765z(i6, i10, bundle);
    }
}
