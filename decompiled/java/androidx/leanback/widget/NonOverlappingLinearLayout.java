package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class NonOverlappingLinearLayout extends LinearLayout {

    public boolean f2173a;

    public boolean f2174b;

    public final ArrayList f2175c;

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void focusableViewAvailable(View view) {
        int iIndexOfChild;
        if (!this.f2174b) {
            super.focusableViewAvailable(view);
            return;
        }
        View view2 = view;
        while (true) {
            if (view2 == this || view2 == null) {
                iIndexOfChild = -1;
                break;
            } else {
                if (view2.getParent() == this) {
                    iIndexOfChild = indexOfChild(view2);
                    break;
                }
                view2 = (View) view2.getParent();
            }
        }
        if (iIndexOfChild != -1) {
            ((ArrayList) this.f2175c.get(iIndexOfChild)).add(view);
        }
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        ?? r10 = this.f2175c;
        ?? r11 = 0;
        int i13 = 0;
        try {
            boolean z10 = this.f2173a && getOrientation() == 0 && getLayoutDirection() == 1;
            this.f2174b = z10;
            if (z10) {
                while (r10.size() > getChildCount()) {
                    r10.remove(r10.size() - 1);
                }
                while (r10.size() < getChildCount()) {
                    r10.add(new ArrayList());
                }
            }
            super.onLayout(z7, i6, i10, i11, i12);
            if (this.f2174b) {
                for (int i14 = 0; i14 < r10.size(); i14++) {
                    for (int i15 = 0; i15 < ((ArrayList) r10.get(i14)).size(); i15++) {
                        super.focusableViewAvailable((View) ((ArrayList) r10.get(i14)).get(i15));
                    }
                }
            }
        } finally {
            if (this.f2174b) {
                this.f2174b = false;
                while (r11 < r10.size()) {
                    ((ArrayList) r10.get(r11)).clear();
                    r11++;
                }
            }
        }
    }

    public void setFocusableViewAvailableFixEnabled(boolean z7) {
        this.f2173a = z7;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2173a = false;
        this.f2175c = new ArrayList();
    }
}
