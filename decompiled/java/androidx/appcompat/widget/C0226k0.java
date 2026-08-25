package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

public final class C0226k0 implements AdapterView.OnItemClickListener {

    public final int f977a;

    public final Object f978b;

    public C0226k0(int i6, Object obj) {
        this.f977a = i6;
        this.f978b = obj;
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        Object item;
        switch (this.f977a) {
            case 0:
                C0236m0 c0236m0 = (C0236m0) this.f978b;
                c0236m0.f1007G.setSelection(i6);
                AppCompatSpinner appCompatSpinner = c0236m0.f1007G;
                if (appCompatSpinner.getOnItemClickListener() != null) {
                    appCompatSpinner.performItemClick(view, i6, c0236m0.f1004D.getItemId(i6));
                }
                c0236m0.dismiss();
                break;
            case 1:
                ((SearchView) this.f978b).m594p(i6);
                break;
            default:
                MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) this.f978b;
                if (i6 < 0) {
                    ListPopupWindow listPopupWindow = materialAutoCompleteTextView.f6733e;
                    item = !listPopupWindow.f715y.isShowing() ? null : listPopupWindow.f693c.getSelectedItem();
                } else {
                    item = materialAutoCompleteTextView.getAdapter().getItem(i6);
                }
                MaterialAutoCompleteTextView.m4350a(materialAutoCompleteTextView, item);
                AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
                ListPopupWindow listPopupWindow2 = materialAutoCompleteTextView.f6733e;
                if (onItemClickListener != null) {
                    if (view == null || i6 < 0) {
                        view = listPopupWindow2.f715y.isShowing() ? listPopupWindow2.f693c.getSelectedView() : null;
                        i6 = !listPopupWindow2.f715y.isShowing() ? -1 : listPopupWindow2.f693c.getSelectedItemPosition();
                        j10 = !listPopupWindow2.f715y.isShowing() ? Long.MIN_VALUE : listPopupWindow2.f693c.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(listPopupWindow2.f693c, view, i6, j10);
                }
                listPopupWindow2.dismiss();
                break;
        }
    }
}
