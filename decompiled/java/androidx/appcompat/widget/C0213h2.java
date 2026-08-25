package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import p105k.C2835i;
import p105k.C2840n;
import p105k.MenuC2838l;

public final class C0213h2 extends C0267s1 {

    public final int f939m;

    public final int f940n;

    public InterfaceC0193d2 f941o;

    public C2840n f942p;

    public C0213h2(Context context, boolean z7) {
        super(context, z7);
        if (1 == AbstractC0208g2.m685a(context.getResources().getConfiguration())) {
            this.f939m = 21;
            this.f940n = 22;
        } else {
            this.f939m = 22;
            this.f940n = 21;
        }
    }

    @Override
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        C2835i c2835i;
        int headersCount;
        int iPointToPosition;
        int i6;
        if (this.f941o != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                c2835i = (C2835i) headerViewListAdapter.getWrappedAdapter();
            } else {
                c2835i = (C2835i) adapter;
                headersCount = 0;
            }
            C2840n c2840nM5825b = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i6 = iPointToPosition - headersCount) < 0 || i6 >= c2835i.getCount()) ? null : c2835i.getItem(i6);
            C2840n c2840n = this.f942p;
            if (c2840n != c2840nM5825b) {
                MenuC2838l menuC2838l = c2835i.f9680a;
                if (c2840n != null) {
                    this.f941o.mo653k(menuC2838l, c2840n);
                }
                this.f942p = c2840nM5825b;
                if (c2840nM5825b != null) {
                    this.f941o.mo652d(menuC2838l, c2840nM5825b);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override
    public final boolean onKeyDown(int i6, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i6 == this.f939m) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i6 != this.f940n) {
            return super.onKeyDown(i6, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (C2835i) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (C2835i) adapter).f9680a.m5827c(false);
        return true;
    }

    public void setHoverListener(InterfaceC0193d2 interfaceC0193d2) {
        this.f941o = interfaceC0193d2;
    }

    @Override
    public void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
