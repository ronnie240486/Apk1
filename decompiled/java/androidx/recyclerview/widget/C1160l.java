package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public final class C1160l extends AbstractC1185t0 {

    public static final int[] f3612c = {R.attr.listDivider};

    public Drawable f3613a;

    public final Rect f3614b = new Rect();

    public C1160l(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f3612c);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f3613a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1162l1 c1162l1) {
        Drawable drawable = this.f3613a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, C1162l1 c1162l1) {
        int height;
        int paddingTop;
        if (recyclerView.getLayoutManager() == null || this.f3613a == null) {
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = recyclerView.getChildAt(i6);
            AbstractC1197x0 layoutManager = recyclerView.getLayoutManager();
            Rect rect = this.f3614b;
            layoutManager.getDecoratedBoundsWithMargins(childAt, rect);
            int iRound = Math.round(childAt.getTranslationX()) + rect.right;
            this.f3613a.setBounds(iRound - this.f3613a.getIntrinsicWidth(), paddingTop, iRound, height);
            this.f3613a.draw(canvas);
        }
        canvas.restore();
    }
}
