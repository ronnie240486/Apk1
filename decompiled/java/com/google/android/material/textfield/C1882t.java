package com.google.android.material.textfield;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import p138n0.C3103b;
import p148o0.C3233h;

public class C1882t extends C3103b {

    public final TextInputLayout f6907d;

    public C1882t(TextInputLayout textInputLayout) {
        this.f6907d = textInputLayout;
    }

    @Override
    public void mo1136d(View view, C3233h c3233h) {
        View.AccessibilityDelegate accessibilityDelegate = this.f10576a;
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f6907d;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z7 = textInputLayout.f6744C0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z10 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        C1880r c1880r = textInputLayout.f6772b;
        AppCompatTextView appCompatTextView = c1880r.f6898b;
        if (appCompatTextView.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(appCompatTextView);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(appCompatTextView);
            }
        } else if (Build.VERSION.SDK_INT >= 22) {
            accessibilityNodeInfo.setTraversalAfter(c1880r.f6900d);
        }
        if (!zIsEmpty) {
            c3233h.m6553o(text);
        } else if (!TextUtils.isEmpty(string)) {
            c3233h.m6553o(string);
            if (!z7 && placeholderText != null) {
                c3233h.m6553o(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            c3233h.m6553o(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 26) {
                c3233h.m6551m(string);
            } else {
                if (!zIsEmpty) {
                    string = ((Object) text) + ", " + string;
                }
                c3233h.m6553o(string);
            }
            if (i6 >= 26) {
                accessibilityNodeInfo.setShowingHintText(zIsEmpty);
            } else {
                c3233h.m6546h(4, zIsEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z10) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        AppCompatTextView appCompatTextView2 = textInputLayout.f6790k.f6890r;
        if (appCompatTextView2 != null) {
            accessibilityNodeInfo.setLabelFor(appCompatTextView2);
        }
    }
}
