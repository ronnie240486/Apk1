package com.youth.banner.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1185t0;
import androidx.recyclerview.widget.AbstractC1197x0;
import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MarginDecoration extends AbstractC1185t0 {
    private int mMarginPx;

    public MarginDecoration(int i6) {
        this.mMarginPx = i6;
    }

    private LinearLayoutManager requireLinearLayoutManager(RecyclerView recyclerView) {
        AbstractC1197x0 layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }

    @Override
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1162l1 c1162l1) {
        if (requireLinearLayoutManager(recyclerView).getOrientation() == 1) {
            int i6 = this.mMarginPx;
            rect.top = i6;
            rect.bottom = i6;
        } else {
            int i10 = this.mMarginPx;
            rect.left = i10;
            rect.right = i10;
        }
    }
}
