package p105k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

public final class C2835i extends BaseAdapter {

    public final MenuC2838l f9680a;

    public int f9681b = -1;

    public boolean f9682c;

    public final boolean f9683d;

    public final LayoutInflater f9684e;

    public final int f9685f;

    public C2835i(MenuC2838l menuC2838l, LayoutInflater layoutInflater, boolean z7, int i6) {
        this.f9683d = z7;
        this.f9684e = layoutInflater;
        this.f9680a = menuC2838l;
        this.f9685f = i6;
        m5824a();
    }

    public final void m5824a() {
        MenuC2838l menuC2838l = this.f9680a;
        C2840n c2840n = menuC2838l.f9708v;
        if (c2840n != null) {
            menuC2838l.m5830i();
            ArrayList arrayList = menuC2838l.f9696j;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (((C2840n) arrayList.get(i6)) == c2840n) {
                    this.f9681b = i6;
                    return;
                }
            }
        }
        this.f9681b = -1;
    }

    @Override
    public final C2840n getItem(int i6) {
        ArrayList arrayListM5831l;
        MenuC2838l menuC2838l = this.f9680a;
        if (this.f9683d) {
            menuC2838l.m5830i();
            arrayListM5831l = menuC2838l.f9696j;
        } else {
            arrayListM5831l = menuC2838l.m5831l();
        }
        int i10 = this.f9681b;
        if (i10 >= 0 && i6 >= i10) {
            i6++;
        }
        return (C2840n) arrayListM5831l.get(i6);
    }

    @Override
    public final int getCount() {
        ArrayList arrayListM5831l;
        MenuC2838l menuC2838l = this.f9680a;
        if (this.f9683d) {
            menuC2838l.m5830i();
            arrayListM5831l = menuC2838l.f9696j;
        } else {
            arrayListM5831l = menuC2838l.m5831l();
        }
        return this.f9681b < 0 ? arrayListM5831l.size() : arrayListM5831l.size() - 1;
    }

    @Override
    public final long getItemId(int i6) {
        return i6;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        boolean z7 = false;
        if (view == null) {
            view = this.f9684e.inflate(this.f9685f, viewGroup, false);
        }
        int i10 = getItem(i6).f9718b;
        int i11 = i6 - 1;
        int i12 = i11 >= 0 ? getItem(i11).f9718b : i10;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f9680a.mo5818m() && i10 != i12) {
            z7 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z7);
        InterfaceC2852z interfaceC2852z = (InterfaceC2852z) view;
        if (this.f9682c) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC2852z.mo532c(getItem(i6));
        return view;
    }

    @Override
    public final void notifyDataSetChanged() {
        m5824a();
        super.notifyDataSetChanged();
    }
}
