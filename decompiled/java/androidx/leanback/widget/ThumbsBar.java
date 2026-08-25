package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.p2serv.android.p032ds.R;

public class ThumbsBar extends LinearLayout {

    public int f2294a;

    public final int f2295b;

    public final int f2296c;

    public final int f2297d;

    public final int f2298e;

    public int f2299f;

    public boolean f2300g;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m1403a() {
        int i6;
        int i10;
        while (getChildCount() > this.f2294a) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (true) {
            int childCount = getChildCount();
            int i11 = this.f2294a;
            i6 = this.f2296c;
            i10 = this.f2295b;
            if (childCount >= i11) {
                break;
            } else {
                addView(new ImageView(getContext()), new LinearLayout.LayoutParams(i10, i6));
            }
        }
        int heroIndex = getHeroIndex();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i12) {
                layoutParams.width = this.f2297d;
                layoutParams.height = this.f2298e;
            } else {
                layoutParams.width = i10;
                layoutParams.height = i6;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredWidth = (childAt.getMeasuredWidth() / 2) + (getWidth() / 2);
        childAt.layout(width, getPaddingTop(), measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
        int measuredHeight = (childAt.getMeasuredHeight() / 2) + getPaddingTop();
        for (int i13 = heroIndex - 1; i13 >= 0; i13--) {
            int i14 = width - this.f2299f;
            View childAt2 = getChildAt(i13);
            childAt2.layout(i14 - childAt2.getMeasuredWidth(), measuredHeight - (childAt2.getMeasuredHeight() / 2), i14, (childAt2.getMeasuredHeight() / 2) + measuredHeight);
            width = i14 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex >= this.f2294a) {
                return;
            }
            int i15 = measuredWidth + this.f2299f;
            View childAt3 = getChildAt(heroIndex);
            childAt3.layout(i15, measuredHeight - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i15, (childAt3.getMeasuredHeight() / 2) + measuredHeight);
            measuredWidth = i15 + childAt3.getMeasuredWidth();
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int measuredWidth = getMeasuredWidth();
        if (this.f2300g) {
            return;
        }
        int i11 = measuredWidth - this.f2297d;
        int i12 = this.f2295b + this.f2299f;
        int i13 = ((i11 + i12) - 1) / i12;
        if (i13 < 2) {
            i13 = 2;
        } else if ((i13 & 1) != 0) {
            i13++;
        }
        int i14 = i13 + 1;
        if (this.f2294a != i14) {
            this.f2294a = i14;
            m1403a();
        }
    }

    public void setNumberOfThumbs(int i6) {
        this.f2300g = true;
        this.f2294a = i6;
        m1403a();
    }

    public void setThumbSpace(int i6) {
        this.f2299f = i6;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2294a = -1;
        new SparseArray();
        this.f2300g = false;
        this.f2295b = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_width);
        this.f2296c = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_height);
        this.f2298e = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_width);
        this.f2297d = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_height);
        this.f2299f = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_margin);
    }
}
