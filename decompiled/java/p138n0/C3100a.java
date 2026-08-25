package p138n0;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p148o0.AbstractC3229d;
import p148o0.C3228c;
import p148o0.C3233h;

public final class C3100a extends View.AccessibilityDelegate {

    public final C3103b f10568a;

    public C3100a(C3103b c3103b) {
        this.f10568a = c3103b;
    }

    @Override
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f10568a.mo2980a(view, accessibilityEvent);
    }

    @Override
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        C2782c c2782cMo2981b = this.f10568a.mo2981b(view);
        if (c2782cMo2981b != null) {
            return (AccessibilityNodeProvider) c2782cMo2981b.f9501b;
        }
        return null;
    }

    @Override
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f10568a.mo1135c(view, accessibilityEvent);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        Object tag3;
        Object objM6276b;
        int iKeyAt;
        int i6 = 1;
        C3233h c3233h = new C3233h(accessibilityNodeInfo);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(AbstractC3134l0.m6244d(view));
        } else {
            tag = view.getTag(R.id.tag_screen_reader_focusable);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        boolean z7 = bool != null && bool.booleanValue();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z7);
        } else {
            c3233h.m6546h(1, z7);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(AbstractC3134l0.m6243c(view));
        } else {
            tag2 = view.getTag(R.id.tag_accessibility_heading);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        boolean z10 = bool2 != null && bool2.booleanValue();
        if (i10 >= 28) {
            accessibilityNodeInfo.setHeading(z10);
        } else {
            c3233h.m6546h(2, z10);
        }
        if (i10 >= 28) {
            tag3 = AbstractC3134l0.m6242b(view);
        } else {
            tag3 = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag3)) {
                tag3 = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag3;
        if (i10 >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            objM6276b = AbstractC3140n0.m6276b(view);
        } else {
            Object tag4 = view.getTag(R.id.tag_state_description);
            objM6276b = CharSequence.class.isInstance(tag4) ? tag4 : null;
        }
        CharSequence charSequence2 = (CharSequence) objM6276b;
        if (i10 >= 30) {
            AbstractC3229d.m6515c(accessibilityNodeInfo, charSequence2);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
        }
        this.f10568a.mo1136d(view, c3233h);
        CharSequence text = accessibilityNodeInfo.getText();
        if (i10 < 26) {
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    if (((WeakReference) sparseArray.valueAt(i11)).get() == null) {
                        arrayList.add(Integer.valueOf(i11));
                    }
                }
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    sparseArray.remove(((Integer) arrayList.get(i12)).intValue());
                }
            }
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                accessibilityNodeInfo.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                SparseArray sparseArray2 = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray2);
                }
                for (int i13 = 0; i13 < clickableSpanArr.length; i13++) {
                    ClickableSpan clickableSpan = clickableSpanArr[i13];
                    int i14 = 0;
                    while (true) {
                        if (i14 >= sparseArray2.size()) {
                            iKeyAt = C3233h.f10861c;
                            C3233h.f10861c = iKeyAt + 1;
                            break;
                        } else {
                            if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i14)).get())) {
                                iKeyAt = sparseArray2.keyAt(i14);
                                break;
                            }
                            i14 += i6;
                        }
                    }
                    sparseArray2.put(iKeyAt, new WeakReference(clickableSpanArr[i13]));
                    ClickableSpan clickableSpan2 = clickableSpanArr[i13];
                    Spanned spanned = (Spanned) text;
                    c3233h.m6542c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                    c3233h.m6542c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                    c3233h.m6542c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                    c3233h.m6542c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(iKeyAt));
                    i6 = 1;
                }
            }
        }
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (int i15 = 0; i15 < listEmptyList.size(); i15++) {
            c3233h.m6541b((C3228c) listEmptyList.get(i15));
        }
    }

    @Override
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f10568a.mo2982e(view, accessibilityEvent);
    }

    @Override
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f10568a.mo2983f(viewGroup, view, accessibilityEvent);
    }

    @Override
    public final boolean performAccessibilityAction(View view, int i6, Bundle bundle) {
        return this.f10568a.mo1137g(view, i6, bundle);
    }

    @Override
    public final void sendAccessibilityEvent(View view, int i6) {
        this.f10568a.mo2984h(view, i6);
    }

    @Override
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f10568a.mo2985i(view, accessibilityEvent);
    }
}
