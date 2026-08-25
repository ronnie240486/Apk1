package androidx.appcompat.widget;

import android.database.DataSetObserver;

public final class C0250p extends DataSetObserver {

    public final int f1026a;

    public final ActivityChooserView f1027b;

    public C0250p(ActivityChooserView activityChooserView, int i6) {
        this.f1026a = i6;
        this.f1027b = activityChooserView;
    }

    @Override
    public final void onChanged() {
        switch (this.f1026a) {
            case 0:
                super.onChanged();
                this.f1027b.f593a.notifyDataSetChanged();
                return;
            default:
                super.onChanged();
                this.f1027b.f593a.getClass();
                throw null;
        }
    }

    @Override
    public void onInvalidated() {
        switch (this.f1026a) {
            case 0:
                super.onInvalidated();
                this.f1027b.f593a.notifyDataSetInvalidated();
                break;
            default:
                super.onInvalidated();
                break;
        }
    }
}
