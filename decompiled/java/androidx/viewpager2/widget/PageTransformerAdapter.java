package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override
    public void onPageScrolled(int i6, float f, int i10) {
        if (this.mPageTransformer == null) {
            return;
        }
        float f3 = -f;
        for (int i11 = 0; i11 < this.mLayoutManager.getChildCount(); i11++) {
            View childAt = this.mLayoutManager.getChildAt(i11);
            if (childAt == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException("LayoutManager returned a null child at pos " + i11 + "/" + this.mLayoutManager.getChildCount() + " while transforming pages");
            }
            this.mPageTransformer.transformPage(childAt, (this.mLayoutManager.getPosition(childAt) - i6) + f3);
        }
    }

    public void setPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    @Override
    public void onPageScrollStateChanged(int i6) {
    }

    @Override
    public void onPageSelected(int i6) {
    }
}
