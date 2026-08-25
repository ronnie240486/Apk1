package p209t3;

import androidx.appcompat.app.AbstractC0127c0;
import androidx.recyclerview.widget.GridLayoutManager;

public final class C3805b extends AbstractC0127c0 {

    public final GridLayoutManager f12842c;

    public final AbstractC3806c f12843d;

    public C3805b(AbstractC3806c abstractC3806c, GridLayoutManager gridLayoutManager) {
        this.f12843d = abstractC3806c;
        this.f12842c = gridLayoutManager;
    }

    @Override
    public final int mo377j(int i6) {
        int itemViewType = this.f12843d.getItemViewType(i6);
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            return this.f12842c.f3446b;
        }
        return 1;
    }
}
