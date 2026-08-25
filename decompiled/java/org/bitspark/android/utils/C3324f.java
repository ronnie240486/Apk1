package org.bitspark.android.utils;

import androidx.recyclerview.widget.AbstractC1128b1;
import androidx.recyclerview.widget.RecyclerView;
import com.nmmedit.protect.NativeUtil;

public final class C3324f extends AbstractC1128b1 {

    public final RecyclerView f11229a;

    public final int f11230b;

    static {
        NativeUtil.classesInit0(12);
    }

    public C3324f(RecyclerView recyclerView, int i6) {
        this.f11229a = recyclerView;
        this.f11230b = i6;
    }

    @Override
    public final native void onScrollStateChanged(RecyclerView recyclerView, int i6);
}
