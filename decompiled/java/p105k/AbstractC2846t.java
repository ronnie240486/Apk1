package p105k;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

public abstract class AbstractC2846t implements InterfaceC2827c0, InterfaceC2851y, AdapterView.OnItemClickListener {

    public Rect f9753a;

    public static int m5851o(ListAdapter listAdapter, Context context, int i6) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        FrameLayout frameLayout = null;
        View view = null;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = listAdapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i12, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i6) {
                return i6;
            }
            if (measuredWidth > i10) {
                i10 = measuredWidth;
            }
        }
        return i10;
    }

    public static boolean m5852w(MenuC2838l menuC2838l) {
        int size = menuC2838l.f9692f.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = menuC2838l.getItem(i6);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean mo763d(C2840n c2840n) {
        return false;
    }

    @Override
    public final boolean mo764f(C2840n c2840n) {
        return false;
    }

    @Override
    public final int getId() {
        return 0;
    }

    public abstract void mo5805n(MenuC2838l menuC2838l);

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (C2835i) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C2835i) listAdapter).f9680a.m5832q((MenuItem) listAdapter.getItem(i6), this, !(this instanceof ViewOnKeyListenerC2832f) ? 0 : 4);
    }

    public abstract void mo5806p(View view);

    public abstract void mo5807q(boolean z7);

    public abstract void mo5808r(int i6);

    public abstract void mo5809s(int i6);

    public abstract void mo5810t(PopupWindow.OnDismissListener onDismissListener);

    public abstract void mo5811u(boolean z7);

    public abstract void mo5812v(int i6);

    @Override
    public final void mo713k(Context context, MenuC2838l menuC2838l) {
    }
}
