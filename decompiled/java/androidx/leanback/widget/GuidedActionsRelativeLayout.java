package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.p2serv.android.p032ds.R;
import p075h1.AbstractC2639a;

class GuidedActionsRelativeLayout extends RelativeLayout {

    public final float f2140a;

    public boolean f2141b;

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        this.f2141b = false;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        View viewFindViewById;
        int size = View.MeasureSpec.getSize(i10);
        if (size > 0 && (viewFindViewById = findViewById(R.id.guidedactions_sub_list)) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
            if (marginLayoutParams.topMargin < 0 && !this.f2141b) {
                this.f2141b = true;
            }
            if (this.f2141b) {
                marginLayoutParams.topMargin = (int) ((this.f2140a * size) / 100.0f);
            }
        }
        super.onMeasure(i6, i10);
    }

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2141b = false;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(AbstractC2639a.f9157a);
        float f = typedArrayObtainStyledAttributes.getFloat(46, 40.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f2140a = f;
    }
}
