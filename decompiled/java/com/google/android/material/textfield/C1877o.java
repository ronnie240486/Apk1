package com.google.android.material.textfield;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import p187r4.C3624n;

public final class C1877o extends View.AccessibilityDelegate {

    public final int f6871a;

    public final Object f6872b;

    public C1877o(int i6, Object obj) {
        this.f6871a = i6;
        this.f6872b = obj;
    }

    @Override
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6871a) {
            case 1:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(SeekBar.class.getName());
                CastSeekBar castSeekBar = (CastSeekBar) this.f6872b;
                accessibilityEvent.setItemCount(castSeekBar.f4883a.f13089b);
                accessibilityEvent.setCurrentItemIndex(castSeekBar.getProgress());
                break;
            default:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        switch (this.f6871a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                EditText editText = ((C1878p) this.f6872b).f6874b.getEditText();
                if (editText != null) {
                    accessibilityNodeInfo.setLabeledBy(editText);
                }
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName(SeekBar.class.getName());
                if (view.isEnabled()) {
                    accessibilityNodeInfo.addAction(4096);
                    accessibilityNodeInfo.addAction(8192);
                }
                break;
        }
    }

    @Override
    public boolean performAccessibilityAction(View view, int i6, Bundle bundle) {
        switch (this.f6871a) {
            case 1:
                if (!view.isEnabled()) {
                    return false;
                }
                if (super.performAccessibilityAction(view, i6, bundle)) {
                    return true;
                }
                if (i6 != 4096 && i6 != 8192) {
                    return false;
                }
                int i10 = CastSeekBar.f4882t;
                CastSeekBar castSeekBar = (CastSeekBar) this.f6872b;
                castSeekBar.m3627e();
                int i11 = castSeekBar.f4883a.f13089b / 20;
                if (i6 == 8192) {
                    i11 = -i11;
                }
                castSeekBar.m3626d(castSeekBar.getProgress() + i11);
                castSeekBar.f4884b = false;
                C3624n c3624n = castSeekBar.f4888f;
                if (c3624n == null) {
                    return false;
                }
                c3624n.m7343k(castSeekBar);
                return false;
            default:
                return super.performAccessibilityAction(view, i6, bundle);
        }
    }
}
