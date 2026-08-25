package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.C0307c;
import androidx.constraintlayout.widget.C0308d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.p2serv.android.p032ds.R;
import java.util.HashMap;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p256y.C4187d;

class TimePickerView extends ConstraintLayout {

    public static final int f6941r = 0;

    public final MaterialButtonToggleGroup f6942q;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m4411o() {
        if (this.f6942q.getVisibility() == 0) {
            C0308d c0308d = new C0308d();
            c0308d.m896d(this);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            char c5 = getLayoutDirection() == 0 ? (char) 2 : (char) 1;
            HashMap map = c0308d.f1416c;
            if (map.containsKey(Integer.valueOf(R.id.material_clock_display))) {
                C0307c c0307c = (C0307c) map.get(Integer.valueOf(R.id.material_clock_display));
                switch (c5) {
                    case 1:
                        C4187d c4187d = c0307c.f1409d;
                        c4187d.f14188i = -1;
                        c4187d.f14186h = -1;
                        c4187d.f14149D = -1;
                        c4187d.f14155J = -1;
                        break;
                    case 2:
                        C4187d c4187d2 = c0307c.f1409d;
                        c4187d2.f14192k = -1;
                        c4187d2.f14190j = -1;
                        c4187d2.f14150E = -1;
                        c4187d2.f14157L = -1;
                        break;
                    case 3:
                        C4187d c4187d3 = c0307c.f1409d;
                        c4187d3.f14194m = -1;
                        c4187d3.f14193l = -1;
                        c4187d3.f14151F = -1;
                        c4187d3.f14156K = -1;
                        break;
                    case 4:
                        C4187d c4187d4 = c0307c.f1409d;
                        c4187d4.f14195n = -1;
                        c4187d4.f14196o = -1;
                        c4187d4.f14152G = -1;
                        c4187d4.f14158M = -1;
                        break;
                    case 5:
                        c0307c.f1409d.f14197p = -1;
                        break;
                    case 6:
                        C4187d c4187d5 = c0307c.f1409d;
                        c4187d5.f14198q = -1;
                        c4187d5.f14199r = -1;
                        c4187d5.f14154I = -1;
                        c4187d5.f14160O = -1;
                        break;
                    case 7:
                        C4187d c4187d6 = c0307c.f1409d;
                        c4187d6.f14200s = -1;
                        c4187d6.f14201t = -1;
                        c4187d6.f14153H = -1;
                        c4187d6.f14159N = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            c0308d.m894b(this);
        }
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        m4411o();
    }

    @Override
    public final void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        if (view == this && i6 == 0) {
            m4411o();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        ViewOnClickListenerC1890g viewOnClickListenerC1890g = new ViewOnClickListenerC1890g(this);
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f6942q = materialButtonToggleGroup;
        materialButtonToggleGroup.f6035c.add(new C1891h(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        ViewOnTouchListenerC1893j viewOnTouchListenerC1893j = new ViewOnTouchListenerC1893j(new GestureDetector(getContext(), new C1892i(this)));
        chip.setOnTouchListener(viewOnTouchListenerC1893j);
        chip2.setOnTouchListener(viewOnTouchListenerC1893j);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(viewOnClickListenerC1890g);
        chip2.setOnClickListener(viewOnClickListenerC1890g);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }
}
