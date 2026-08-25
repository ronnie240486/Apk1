package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p138n0.C3107c0;

public final class C1809z extends AbstractC1174p1 {

    public final TextView f6247a;

    public final MaterialCalendarGridView f6248b;

    public C1809z(LinearLayout linearLayout, boolean z7) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f6247a = textView;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        new C3107c0(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).m3247d(textView, Boolean.TRUE);
        this.f6248b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z7) {
            return;
        }
        textView.setVisibility(8);
    }
}
