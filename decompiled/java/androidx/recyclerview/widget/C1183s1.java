package androidx.recyclerview.widget;

public final class C1183s1 extends AbstractC1128b1 {

    public boolean f3693a = false;

    public final AbstractC1186t1 f3694b;

    public C1183s1(AbstractC1186t1 abstractC1186t1) {
        this.f3694b = abstractC1186t1;
    }

    @Override
    public final void onScrollStateChanged(RecyclerView recyclerView, int i6) {
        if (i6 == 0 && this.f3693a) {
            this.f3693a = false;
            this.f3694b.snapToTargetExistingView();
        }
    }

    @Override
    public final void onScrolled(RecyclerView recyclerView, int i6, int i10) {
        if (i6 == 0 && i10 == 0) {
            return;
        }
        this.f3693a = true;
    }
}
