package com.google.android.material.slider;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.List;
import p148o0.C3228c;
import p148o0.C3233h;
import p226v0.AbstractC3966b;

public final class C1859e extends AbstractC3966b {

    public final BaseSlider f6674q;

    public final Rect f6675r;

    public C1859e(BaseSlider baseSlider) {
        super(baseSlider);
        this.f6675r = new Rect();
        this.f6674q = baseSlider;
    }

    @Override
    public final int mo4329n(float f, float f3) {
        int i6 = 0;
        while (true) {
            BaseSlider baseSlider = this.f6674q;
            if (i6 >= baseSlider.getValues().size()) {
                return -1;
            }
            Rect rect = this.f6675r;
            baseSlider.m4326v(i6, rect);
            if (rect.contains((int) f, (int) f3)) {
                return i6;
            }
            i6++;
        }
    }

    @Override
    public final void mo4330o(ArrayList arrayList) {
        for (int i6 = 0; i6 < this.f6674q.getValues().size(); i6++) {
            arrayList.add(Integer.valueOf(i6));
        }
    }

    @Override
    public final boolean mo4331s(int i6, int i10, Bundle bundle) {
        BaseSlider baseSlider = this.f6674q;
        if (!baseSlider.isEnabled()) {
            return false;
        }
        if (i10 != 4096 && i10 != 8192) {
            if (i10 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                float f = bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
                int i11 = BaseSlider.f6606d0;
                if (baseSlider.m4324t(i6, f)) {
                    baseSlider.m4327w();
                    baseSlider.postInvalidate();
                    m7941p(i6);
                    return true;
                }
            }
            return false;
        }
        int i12 = BaseSlider.f6606d0;
        float fRound = baseSlider.f6616J;
        if (fRound == 0.0f) {
            fRound = 1.0f;
        }
        float f3 = (baseSlider.f6612F - baseSlider.f6611E) / fRound;
        float f4 = 20;
        if (f3 > f4) {
            fRound *= Math.round(f3 / f4);
        }
        if (i10 == 8192) {
            fRound = -fRound;
        }
        if (baseSlider.m4315k()) {
            fRound = -fRound;
        }
        float fFloatValue = baseSlider.getValues().get(i6).floatValue() + fRound;
        float valueFrom = baseSlider.getValueFrom();
        float valueTo = baseSlider.getValueTo();
        if (fFloatValue < valueFrom) {
            fFloatValue = valueFrom;
        } else if (fFloatValue > valueTo) {
            fFloatValue = valueTo;
        }
        if (!baseSlider.m4324t(i6, fFloatValue)) {
            return false;
        }
        baseSlider.m4327w();
        baseSlider.postInvalidate();
        m7941p(i6);
        return true;
    }

    @Override
    public final void mo4332u(int i6, C3233h c3233h) {
        String string;
        c3233h.m6541b(C3228c.f10854r);
        BaseSlider baseSlider = this.f6674q;
        List<Float> values = baseSlider.getValues();
        float fFloatValue = values.get(i6).floatValue();
        float valueFrom = baseSlider.getValueFrom();
        float valueTo = baseSlider.getValueTo();
        if (baseSlider.isEnabled()) {
            if (fFloatValue > valueFrom) {
                c3233h.m6540a(8192);
            }
            if (fFloatValue < valueTo) {
                c3233h.m6540a(4096);
            }
        }
        AccessibilityNodeInfo.RangeInfo rangeInfoObtain = AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, fFloatValue);
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        accessibilityNodeInfo.setRangeInfo(rangeInfoObtain);
        c3233h.m6547i(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (baseSlider.getContentDescription() != null) {
            sb.append(baseSlider.getContentDescription());
            sb.append(",");
        }
        if (values.size() > 1) {
            if (i6 == baseSlider.getValues().size() - 1) {
                string = baseSlider.getContext().getString(R.string.material_slider_range_end);
            } else {
                string = i6 == 0 ? baseSlider.getContext().getString(R.string.material_slider_range_start) : "";
            }
            sb.append(string);
            sb.append(baseSlider.m4310f(fFloatValue));
        }
        c3233h.m6550l(sb.toString());
        Rect rect = this.f6675r;
        baseSlider.m4326v(i6, rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
