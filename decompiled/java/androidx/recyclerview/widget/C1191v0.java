package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

public final class C1191v0 implements InterfaceC1125a2 {

    public final AbstractC1197x0 f3718a;

    public C1191v0(AbstractC1197x0 abstractC1197x0) {
        this.f3718a = abstractC1197x0;
    }

    @Override
    public final int mo2866a() {
        AbstractC1197x0 abstractC1197x0 = this.f3718a;
        return abstractC1197x0.getHeight() - abstractC1197x0.getPaddingBottom();
    }

    @Override
    public final int mo2867b(View view) {
        return this.f3718a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override
    public final View mo2868c(int i6) {
        return this.f3718a.getChildAt(i6);
    }

    @Override
    public final int mo2869d() {
        return this.f3718a.getPaddingTop();
    }

    @Override
    public final int mo2870e(View view) {
        return this.f3718a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }
}
