package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1185t0;
import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p055ea.AbstractC2460q;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p250x5.AbstractC4121a;

public class MaterialDividerItemDecoration extends AbstractC1185t0 {

    public final Drawable f6254a;

    public final int f6255b;

    public final int f6256c;

    public final int f6257d;

    public final int f6258e;

    public final int f6259f;

    public final boolean f6260g;

    public final Rect f6261h = new Rect();

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i6) {
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context, attributeSet, AbstractC4121a.f13961E, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f6256c = AbstractC1466d.m3493k(context, typedArrayM4250j, 0).getDefaultColor();
        this.f6255b = typedArrayM4250j.getDimensionPixelSize(3, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f6258e = typedArrayM4250j.getDimensionPixelOffset(2, 0);
        this.f6259f = typedArrayM4250j.getDimensionPixelOffset(1, 0);
        this.f6260g = typedArrayM4250j.getBoolean(4, true);
        typedArrayM4250j.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        this.f6254a = shapeDrawable;
        int i10 = this.f6256c;
        this.f6256c = i10;
        Drawable drawableM6448W = AbstractC3198d.m6448W(shapeDrawable);
        this.f6254a = drawableM6448W;
        AbstractC2581a.m5585g(drawableM6448W, i10);
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "Invalid orientation: ", ". It should be either HORIZONTAL or VERTICAL"));
        }
        this.f6257d = i6;
    }

    @Override
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1162l1 c1162l1) {
        rect.set(0, 0, 0, 0);
        int i6 = this.f6257d;
        int i10 = this.f6255b;
        if (i6 == 1) {
            rect.bottom = this.f6254a.getIntrinsicHeight() + i10;
        } else {
            rect.right = this.f6254a.getIntrinsicWidth() + i10;
        }
    }

    @Override
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, C1162l1 c1162l1) {
        int height;
        int paddingTop;
        int width;
        int paddingLeft;
        Drawable drawable = this.f6254a;
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        int i6 = this.f6257d;
        int i10 = this.f6255b;
        Rect rect = this.f6261h;
        int i11 = this.f6259f;
        int i12 = this.f6258e;
        int i13 = 0;
        if (i6 != 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingTop = recyclerView.getPaddingTop();
                height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
            } else {
                height = recyclerView.getHeight();
                paddingTop = 0;
            }
            int i14 = paddingTop + i12;
            int i15 = height - i11;
            int childCount = recyclerView.getChildCount();
            while (i13 < childCount) {
                View childAt = recyclerView.getChildAt(i13);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, rect);
                int iRound = Math.round(childAt.getTranslationX()) + rect.right;
                drawable.setBounds((iRound - drawable.getIntrinsicWidth()) - i10, i14, iRound, i15);
                drawable.draw(canvas);
                i13++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = recyclerView.getLayoutDirection() == 1;
        int i16 = paddingLeft + (z7 ? i11 : i12);
        if (z7) {
            i11 = i12;
        }
        int i17 = width - i11;
        int childCount2 = recyclerView.getChildCount();
        if (!this.f6260g) {
            childCount2--;
        }
        while (i13 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i13);
            recyclerView.getDecoratedBoundsWithMargins(childAt2, rect);
            int iRound2 = Math.round(childAt2.getTranslationY()) + rect.bottom;
            drawable.setBounds(i16, (iRound2 - drawable.getIntrinsicHeight()) - i10, i17, iRound2);
            drawable.draw(canvas);
            i13++;
        }
        canvas.restore();
    }
}
