package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p138n0.AbstractC3155s0;

public class VerticalGridView extends AbstractC0474j {
    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setColumnWidth(TypedArray typedArray) {
        if (typedArray.peekValue(0) != null) {
            setColumnWidth(typedArray.getLayoutDimension(0, 0));
        }
    }

    public void setNumColumns(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (i6 < 0) {
            gridLayoutManager.getClass();
            throw new IllegalArgumentException();
        }
        gridLayoutManager.f2094F = i6;
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2345a.setOrientation(1);
        m1440b(context, attributeSet);
        int[] iArr = AbstractC0483m0.f2370c;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        setColumnWidth(typedArrayObtainStyledAttributes);
        setNumColumns(typedArrayObtainStyledAttributes.getInt(1, 1));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setColumnWidth(int i6) {
        this.f2345a.m1357I(i6);
        requestLayout();
    }
}
