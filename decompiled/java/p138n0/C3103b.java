package p138n0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import p101j7.C2782c;
import p148o0.C3228c;
import p148o0.C3233h;
import p148o0.InterfaceC3244s;

public class C3103b {

    public static final View.AccessibilityDelegate f10575c = new View.AccessibilityDelegate();

    public final View.AccessibilityDelegate f10576a;

    public final C3100a f10577b;

    public C3103b() {
        this(f10575c);
    }

    public boolean mo2980a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f10576a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C2782c mo2981b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f10576a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C2782c(21, accessibilityNodeProvider);
        }
        return null;
    }

    public void mo1135c(View view, AccessibilityEvent accessibilityEvent) {
        this.f10576a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void mo1136d(View view, C3233h c3233h) {
        this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
    }

    public void mo2982e(View view, AccessibilityEvent accessibilityEvent) {
        this.f10576a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean mo2983f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f10576a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean mo1137g(View view, int i6, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        boolean z7 = false;
        int i10 = 0;
        while (true) {
            if (i10 < listEmptyList.size()) {
                C3228c c3228c = (C3228c) listEmptyList.get(i10);
                if (c3228c.m6512a() == i6) {
                    InterfaceC3244s interfaceC3244s = c3228c.f10859d;
                    if (interfaceC3244s != null) {
                        Class cls = c3228c.f10858c;
                        if (cls != null) {
                            try {
                                if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                    throw null;
                                }
                                throw new ClassCastException();
                            } catch (Exception e5) {
                                Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e5);
                            }
                        }
                        zPerformAccessibilityAction = interfaceC3244s.perform(view, null);
                        break;
                    }
                } else {
                    i10++;
                }
            }
            zPerformAccessibilityAction = false;
            break;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f10576a.performAccessibilityAction(view, i6, bundle);
        }
        if (zPerformAccessibilityAction || i6 != R.id.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i11 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i11)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            for (int i12 = 0; clickableSpanArr != null && i12 < clickableSpanArr.length; i12++) {
                if (clickableSpan.equals(clickableSpanArr[i12])) {
                    clickableSpan.onClick(view);
                    z7 = true;
                    break;
                }
            }
        }
        return z7;
    }

    public void mo2984h(View view, int i6) {
        this.f10576a.sendAccessibilityEvent(view, i6);
    }

    public void mo2985i(View view, AccessibilityEvent accessibilityEvent) {
        this.f10576a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C3103b(View.AccessibilityDelegate accessibilityDelegate) {
        this.f10576a = accessibilityDelegate;
        this.f10577b = new C3100a(this);
    }
}
