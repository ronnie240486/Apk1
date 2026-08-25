package androidx.appcompat.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.p2serv.android.p032ds.R;

public final class C0265s extends BaseAdapter {

    public final ActivityChooserView f1050a;

    public C0265s(ActivityChooserView activityChooserView) {
        this.f1050a = activityChooserView;
    }

    @Override
    public final int getCount() {
        throw null;
    }

    @Override
    public final Object getItem(int i6) {
        throw null;
    }

    @Override
    public final long getItemId(int i6) {
        return i6;
    }

    @Override
    public final int getItemViewType(int i6) {
        return 0;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        ActivityChooserView activityChooserView = this.f1050a;
        if (view == null || view.getId() != R.id.list_item) {
            view = LayoutInflater.from(activityChooserView.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
        }
        activityChooserView.getContext().getPackageManager();
        throw null;
    }

    @Override
    public final int getViewTypeCount() {
        return 3;
    }
}
