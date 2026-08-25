package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public final class C1131c0 extends AbstractC1135d0 {
    @Override
    public final int mo2883b(View view) {
        return this.f3538a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override
    public final int mo2884c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f3538a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override
    public final int mo2885d(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f3538a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override
    public final int mo2886e(View view) {
        return this.f3538a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override
    public final int mo2887f() {
        return this.f3538a.getHeight();
    }

    @Override
    public final int mo2888g() {
        AbstractC1197x0 abstractC1197x0 = this.f3538a;
        return abstractC1197x0.getHeight() - abstractC1197x0.getPaddingBottom();
    }

    @Override
    public final int mo2889h() {
        return this.f3538a.getPaddingBottom();
    }

    @Override
    public final int mo2890i() {
        return this.f3538a.getHeightMode();
    }

    @Override
    public final int mo2891j() {
        return this.f3538a.getWidthMode();
    }

    @Override
    public final int mo2892k() {
        return this.f3538a.getPaddingTop();
    }

    @Override
    public final int mo2893l() {
        AbstractC1197x0 abstractC1197x0 = this.f3538a;
        return (abstractC1197x0.getHeight() - abstractC1197x0.getPaddingTop()) - abstractC1197x0.getPaddingBottom();
    }

    @Override
    public final int mo2894n(View view) {
        AbstractC1197x0 abstractC1197x0 = this.f3538a;
        Rect rect = this.f3540c;
        abstractC1197x0.getTransformedBoundingBox(view, true, rect);
        return rect.bottom;
    }

    @Override
    public final int mo2895o(View view) {
        AbstractC1197x0 abstractC1197x0 = this.f3538a;
        Rect rect = this.f3540c;
        abstractC1197x0.getTransformedBoundingBox(view, true, rect);
        return rect.top;
    }

    @Override
    public final void mo2896p(int i6) {
        this.f3538a.offsetChildrenVertical(i6);
    }
}
