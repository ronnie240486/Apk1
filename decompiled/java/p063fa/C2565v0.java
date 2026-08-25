package p063fa;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.ViewOnClickListenerC0204f3;
import com.tencent.mars.xlog.Log;
import ga.C2632o;
import java.util.ArrayList;
import java.util.List;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p206t0.AbstractC3788b;

public final class C2565v0 extends Filter {

    public final int f8922a = 1;

    public Filterable f8923b;

    public C2565v0() {
    }

    @Override
    public CharSequence convertResultToString(Object obj) {
        switch (this.f8922a) {
            case 1:
                return ((ViewOnClickListenerC0204f3) ((AbstractC3788b) this.f8923b)).mo665c((Cursor) obj);
            default:
                return super.convertResultToString(obj);
        }
    }

    @Override
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        String string;
        Cursor cursorM669g;
        switch (this.f8922a) {
            case 0:
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                String lowerCase = charSequence.toString().toLowerCase();
                List<ChannelBean> list = ((Group) C2632o.f9150c.get(-20)).channnels;
                String strM165s = AbstractC0032a.m165s("mQcasUfmbeWqBD+WTvd37r0=\n", "z2h+8i+HA4s=\n");
                String str = AbstractC0032a.m165s("PqQSJGWHvG80thtt\n", "Xcx+TRbznBw=\n") + list.size();
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                for (int i6 = 0; i6 < list.size(); i6++) {
                    Log.m5049i(AbstractC0032a.m165s("XCDyr8fKwjVvI9eIztvYPng=\n", "Ck+W7K+rrFs=\n"), list.get(i6).getSearch() + " " + lowerCase + " " + list.get(i6).getSearch().toLowerCase().indexOf(lowerCase));
                    if (list.get(i6).getSearch().toLowerCase().indexOf(lowerCase) >= 0) {
                        arrayList.add(list.get(i6));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
                Log.m5049i(AbstractC0032a.m165s("Gm5zYx6/pEwpbVZEF66+Rz4=\n", "TAEXIHbeyiI=\n"), AbstractC0032a.m165s("widoH3DNspnTLW4EaA==\n", "sEIbahy5wbc=\n") + filterResults.count);
                return filterResults;
            default:
                ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3 = (ViewOnClickListenerC0204f3) ((AbstractC3788b) this.f8923b);
                if (charSequence == null) {
                    string = "";
                } else {
                    viewOnClickListenerC0204f3.getClass();
                    string = charSequence.toString();
                }
                SearchView searchView = viewOnClickListenerC0204f3.f908k;
                if (searchView.getVisibility() == 0 && searchView.getWindowVisibility() == 0) {
                    try {
                        cursorM669g = viewOnClickListenerC0204f3.m669g(viewOnClickListenerC0204f3.f909l, string);
                        if (cursorM669g != null) {
                            cursorM669g.getCount();
                        } else {
                            cursorM669g = null;
                        }
                    } catch (RuntimeException e5) {
                        android.util.Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e5);
                    }
                    break;
                } else {
                    cursorM669g = null;
                }
                Filter.FilterResults filterResults2 = new Filter.FilterResults();
                if (cursorM669g != null) {
                    filterResults2.count = cursorM669g.getCount();
                    filterResults2.values = cursorM669g;
                } else {
                    filterResults2.count = 0;
                    filterResults2.values = null;
                }
                return filterResults2;
        }
    }

    @Override
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        switch (this.f8922a) {
            case 0:
                C2569x0 c2569x0 = (C2569x0) this.f8923b;
                c2569x0.f8932j.clear();
                c2569x0.f8932j.addAll((List) filterResults.values);
                c2569x0.notifyDataSetChanged();
                break;
            default:
                AbstractC3788b abstractC3788b = (AbstractC3788b) this.f8923b;
                Cursor cursor = abstractC3788b.f12752c;
                Object obj = filterResults.values;
                if (obj != null && obj != cursor) {
                    ((ViewOnClickListenerC0204f3) abstractC3788b).mo664b((Cursor) obj);
                    break;
                }
                break;
        }
    }

    public C2565v0(C2569x0 c2569x0) {
        this.f8923b = c2569x0;
    }
}
