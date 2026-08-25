package androidx.leanback.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
class CheckableImageView extends ImageView implements Checkable {

    public static final int[] f2083b = {R.attr.state_checked};

    public boolean f2084a;

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final boolean isChecked() {
        return this.f2084a;
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        if (this.f2084a) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2083b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void setChecked(boolean z7) {
        if (this.f2084a != z7) {
            this.f2084a = z7;
            refreshDrawableState();
        }
    }

    @Override
    public final void toggle() {
        setChecked(!this.f2084a);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
