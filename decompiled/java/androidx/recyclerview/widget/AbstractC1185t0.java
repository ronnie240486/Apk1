package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public abstract class AbstractC1185t0 {
    @Deprecated
    public void getItemOffsets(Rect rect, int i6, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    @Deprecated
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
    }

    @Deprecated
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1162l1 c1162l1) {
        getItemOffsets(rect, ((RecyclerView.LayoutParams) view.getLayoutParams()).f3465a.getLayoutPosition(), recyclerView);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, C1162l1 c1162l1) {
        onDraw(canvas, recyclerView);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C1162l1 c1162l1) {
        onDrawOver(canvas, recyclerView);
    }
}
