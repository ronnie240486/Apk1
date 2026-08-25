package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

class ControlBar extends LinearLayout {

    public int f2085a;

    public final boolean f2086b;

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2085a = -1;
        this.f2086b = true;
    }

    @Override
    public final void addFocusables(ArrayList arrayList, int i6, int i10) {
        if (i6 != 33 && i6 != 130) {
            super.addFocusables(arrayList, i6, i10);
            return;
        }
        int i11 = this.f2085a;
        if (i11 >= 0 && i11 < getChildCount()) {
            arrayList.add(getChildAt(this.f2085a));
        } else if (getChildCount() > 0) {
            arrayList.add(getChildAt(this.f2086b ? getChildCount() / 2 : 0));
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
    }

    @Override
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int childCount;
        if (getChildCount() > 0) {
            int i10 = this.f2085a;
            if (i10 < 0 || i10 >= getChildCount()) {
                childCount = this.f2086b ? getChildCount() / 2 : 0;
            } else {
                childCount = this.f2085a;
            }
            if (getChildAt(childCount).requestFocus(i6, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i6, rect);
    }

    @Override
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f2085a = indexOfChild(view);
    }

    public ControlBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2085a = -1;
        this.f2086b = true;
    }
}
