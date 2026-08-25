package p051e6;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p148o0.C3228c;
import p148o0.C3233h;
import p226v0.AbstractC3966b;

public final class C2417b extends AbstractC3966b {

    public final Chip f8425q;

    public C2417b(Chip chip, Chip chip2) {
        super(chip2);
        this.f8425q = chip;
    }

    @Override
    public final int mo4329n(float f, float f3) {
        Rect rect = Chip.f6081x;
        Chip chip = this.f8425q;
        return (chip.m4158d() && chip.getCloseIconTouchBounds().contains(f, f3)) ? 1 : 0;
    }

    @Override
    public final void mo4330o(ArrayList arrayList) {
        boolean z7 = false;
        arrayList.add(0);
        Rect rect = Chip.f6081x;
        Chip chip = this.f8425q;
        if (chip.m4158d()) {
            C2419d c2419d = chip.f6084e;
            if (c2419d != null && c2419d.f8444K) {
                z7 = true;
            }
            if (!z7 || chip.f6087h == null) {
                return;
            }
            arrayList.add(1);
        }
    }

    @Override
    public final boolean mo4331s(int i6, int i10, Bundle bundle) {
        boolean z7 = false;
        if (i10 == 16) {
            Chip chip = this.f8425q;
            if (i6 == 0) {
                return chip.performClick();
            }
            if (i6 == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.f6087h;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z7 = true;
                }
                if (chip.f6099t) {
                    chip.f6098s.m7945x(1, 1);
                }
            }
        }
        return z7;
    }

    @Override
    public final void mo5445t(C3233h c3233h) {
        Chip chip = this.f8425q;
        boolean zM4159e = chip.m4159e();
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        accessibilityNodeInfo.setCheckable(zM4159e);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        c3233h.m6547i(chip.getAccessibilityClassName());
        CharSequence text = chip.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            c3233h.m6553o(text);
        } else {
            c3233h.m6550l(text);
        }
    }

    @Override
    public final void mo4332u(int i6, C3233h c3233h) {
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        if (i6 != 1) {
            c3233h.m6550l("");
            accessibilityNodeInfo.setBoundsInParent(Chip.f6081x);
            return;
        }
        Chip chip = this.f8425q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            c3233h.m6550l(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            c3233h.m6550l(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        c3233h.m6541b(C3228c.f10843g);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }

    @Override
    public final void mo5446v(int i6, boolean z7) {
        if (i6 == 1) {
            Chip chip = this.f8425q;
            chip.f6093n = z7;
            chip.refreshDrawableState();
        }
    }
}
