package p226v0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.media3.common.C0565C;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p148o0.C3233h;

public final class C3965a extends C2782c {

    public final AbstractC3966b f13459c;

    public C3965a(AbstractC3966b abstractC3966b) {
        super(21);
        this.f13459c = abstractC3966b;
    }

    @Override
    public final C3233h mo5760s(int i6) {
        return new C3233h(AccessibilityNodeInfo.obtain(this.f13459c.m7943r(i6).f10862a));
    }

    @Override
    public final C3233h mo5761t(int i6) {
        AbstractC3966b abstractC3966b = this.f13459c;
        int i10 = i6 == 2 ? abstractC3966b.f13470k : abstractC3966b.f13471l;
        if (i10 == Integer.MIN_VALUE) {
            return null;
        }
        return mo5760s(i10);
    }

    @Override
    public final boolean mo5765z(int i6, int i10, Bundle bundle) {
        int i11;
        AbstractC3966b abstractC3966b = this.f13459c;
        View view = abstractC3966b.f13468i;
        if (i6 == -1) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            return view.performAccessibilityAction(i10, bundle);
        }
        boolean z7 = true;
        if (i10 == 1) {
            return abstractC3966b.m7944w(i6);
        }
        if (i10 == 2) {
            return abstractC3966b.m7937j(i6);
        }
        if (i10 == 64) {
            AccessibilityManager accessibilityManager = abstractC3966b.f13467h;
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (i11 = abstractC3966b.f13470k) != i6) {
                if (i11 != Integer.MIN_VALUE) {
                    abstractC3966b.f13470k = Integer.MIN_VALUE;
                    abstractC3966b.f13468i.invalidate();
                    abstractC3966b.m7945x(i11, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE);
                }
                abstractC3966b.f13470k = i6;
                view.invalidate();
                abstractC3966b.m7945x(i6, 32768);
            } else {
                z7 = false;
            }
        } else {
            if (i10 != 128) {
                return abstractC3966b.mo4331s(i6, i10, bundle);
            }
            if (abstractC3966b.f13470k == i6) {
                abstractC3966b.f13470k = Integer.MIN_VALUE;
                view.invalidate();
                abstractC3966b.m7945x(i6, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE);
            } else {
                z7 = false;
            }
        }
        return z7;
    }
}
