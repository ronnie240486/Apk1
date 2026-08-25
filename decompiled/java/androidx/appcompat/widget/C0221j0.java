package androidx.appcompat.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

public final class C0221j0 implements ListAdapter, SpinnerAdapter {

    public SpinnerAdapter f952a;

    public ListAdapter f953b;

    @Override
    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f953b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override
    public final int getCount() {
        SpinnerAdapter spinnerAdapter = this.f952a;
        if (spinnerAdapter == null) {
            return 0;
        }
        return spinnerAdapter.getCount();
    }

    @Override
    public final View getDropDownView(int i6, View view, ViewGroup viewGroup) {
        SpinnerAdapter spinnerAdapter = this.f952a;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getDropDownView(i6, view, viewGroup);
    }

    @Override
    public final Object getItem(int i6) {
        SpinnerAdapter spinnerAdapter = this.f952a;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getItem(i6);
    }

    @Override
    public final long getItemId(int i6) {
        SpinnerAdapter spinnerAdapter = this.f952a;
        if (spinnerAdapter == null) {
            return -1L;
        }
        return spinnerAdapter.getItemId(i6);
    }

    @Override
    public final int getItemViewType(int i6) {
        return 0;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        return getDropDownView(i6, view, viewGroup);
    }

    @Override
    public final int getViewTypeCount() {
        return 1;
    }

    @Override
    public final boolean hasStableIds() {
        SpinnerAdapter spinnerAdapter = this.f952a;
        return spinnerAdapter != null && spinnerAdapter.hasStableIds();
    }

    @Override
    public final boolean isEmpty() {
        return getCount() == 0;
    }

    @Override
    public final boolean isEnabled(int i6) {
        ListAdapter listAdapter = this.f953b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i6);
        }
        return true;
    }

    @Override
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f952a;
        if (spinnerAdapter != null) {
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f952a;
        if (spinnerAdapter != null) {
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
