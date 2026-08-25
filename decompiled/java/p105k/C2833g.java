package p105k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;

public final class C2833g extends BaseAdapter {

    public int f9672a = -1;

    public final C2834h f9673b;

    public C2833g(C2834h c2834h) {
        this.f9673b = c2834h;
        m5822a();
    }

    public final void m5822a() {
        MenuC2838l menuC2838l = this.f9673b.f9676c;
        C2840n c2840n = menuC2838l.f9708v;
        if (c2840n != null) {
            menuC2838l.m5830i();
            ArrayList arrayList = menuC2838l.f9696j;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (((C2840n) arrayList.get(i6)) == c2840n) {
                    this.f9672a = i6;
                    return;
                }
            }
        }
        this.f9672a = -1;
    }

    @Override
    public final C2840n getItem(int i6) {
        C2834h c2834h = this.f9673b;
        MenuC2838l menuC2838l = c2834h.f9676c;
        menuC2838l.m5830i();
        ArrayList arrayList = menuC2838l.f9696j;
        c2834h.getClass();
        int i10 = this.f9672a;
        if (i10 >= 0 && i6 >= i10) {
            i6++;
        }
        return (C2840n) arrayList.get(i6);
    }

    @Override
    public final int getCount() {
        C2834h c2834h = this.f9673b;
        MenuC2838l menuC2838l = c2834h.f9676c;
        menuC2838l.m5830i();
        int size = menuC2838l.f9696j.size();
        c2834h.getClass();
        return this.f9672a < 0 ? size : size - 1;
    }

    @Override
    public final long getItemId(int i6) {
        return i6;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f9673b.f9675b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((InterfaceC2852z) view).mo532c(getItem(i6));
        return view;
    }

    @Override
    public final void notifyDataSetChanged() {
        m5822a();
        super.notifyDataSetChanged();
    }
}
