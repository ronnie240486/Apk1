package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

public final class C1188u0 implements InterfaceC1125a2 {

    public final AbstractC1197x0 f3701a;

    public C1188u0(AbstractC1197x0 abstractC1197x0) {
        this.f3701a = abstractC1197x0;
    }

    @Override
    public final int mo2866a() {
        AbstractC1197x0 abstractC1197x0 = this.f3701a;
        return abstractC1197x0.getWidth() - abstractC1197x0.getPaddingRight();
    }

    @Override
    public final int mo2867b(View view) {
        return this.f3701a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override
    public final View mo2868c(int i6) {
        return this.f3701a.getChildAt(i6);
    }

    @Override
    public final int mo2869d() {
        return this.f3701a.getPaddingLeft();
    }

    @Override
    public final int mo2870e(View view) {
        return this.f3701a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }
}
