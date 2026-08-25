package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.List;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p092ia.C2737b;
import p103j9.AbstractC2796i;
import p237w0.AbstractC4042c;
import p237w0.AbstractC4044e;
import qa.C3565m;

public final class C0457d0 extends AbstractC1158k0 {

    public final C0026b f2323a;

    public final ArrayList f2324b = new ArrayList();

    public C0457d0(C0026b c0026b) {
        C0451b0 c0451b0 = new C0451b0(this);
        C0026b c0026b2 = this.f2323a;
        if (c0026b == c0026b2) {
            return;
        }
        if (c0026b2 != null) {
            ((C0460e0) c0026b2.f54b).unregisterObserver(c0451b0);
        }
        this.f2323a = c0026b;
        ((C0460e0) c0026b.f54b).registerObserver(c0451b0);
        boolean zHasStableIds = hasStableIds();
        this.f2323a.getClass();
        if (zHasStableIds) {
            this.f2323a.getClass();
            setHasStableIds(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public final int getItemCount() {
        C0026b c0026b = this.f2323a;
        if (c0026b != null) {
            return ((ArrayList) c0026b.f56d).size();
        }
        return 0;
    }

    @Override
    public final long getItemId(int i6) {
        this.f2323a.getClass();
        return -1L;
    }

    @Override
    public final int getItemViewType(int i6) {
        C0026b c0026b = this.f2323a;
        C3565m c3565mMo1405a = ((AbstractC0481l0) c0026b.f55c).mo1405a(((ArrayList) c0026b.f56d).get(i6));
        ArrayList arrayList = this.f2324b;
        int iIndexOf = arrayList.indexOf(c3565mMo1405a);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        arrayList.add(c3565mMo1405a);
        return arrayList.indexOf(c3565mMo1405a);
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C0454c0 c0454c0 = (C0454c0) abstractC1174p1;
        Object obj = ((ArrayList) this.f2323a.f56d).get(i6);
        c0454c0.f2321c = obj;
        C3565m c3565m = c0454c0.f2319a;
        c3565m.getClass();
        String strM165s = AbstractC0032a.m165s("0P9pe68HYbzD5A==\n", "ppYMDOdoDdg=\n");
        C2737b c2737b = c0454c0.f2320b;
        AbstractC2796i.m5785f(c2737b, strM165s);
        c3565m.m7184e(c2737b, obj);
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        int i10;
        C3565m c3565m = (C3565m) this.f2324b.get(i6);
        c3565m.getClass();
        AbstractC2796i.m5785f(viewGroup, AbstractC0032a.m165s("NU23NqVJ\n", "RSzFU8s93Bc=\n"));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        switch (c3565m.f12018c) {
            case 0:
            case 3:
                i10 = R.layout.item_live_setting_subtitle_location;
                break;
            case 1:
                i10 = R.layout.item_live_setting;
                break;
            case 2:
                i10 = R.layout.item_live_setting_select;
                break;
            case 4:
                i10 = R.layout.item_live_setting_subtitle;
                break;
            default:
                i10 = R.layout.item_live_setting_subtitle_title;
                break;
        }
        AbstractC4044e abstractC4044eM8044a = AbstractC4042c.m8044a(layoutInflaterFrom, i10, viewGroup);
        AbstractC2796i.m5782c(abstractC4044eM8044a);
        C2737b c2737b = new C2737b(abstractC4044eM8044a);
        C0454c0 c0454c0 = new C0454c0(c3565m, c2737b.f9403a, c2737b);
        c0454c0.f2320b.f9403a.getOnFocusChangeListener();
        return c0454c0;
    }

    @Override
    public final boolean onFailedToRecycleView(AbstractC1174p1 abstractC1174p1) {
        onViewRecycled(abstractC1174p1);
        return false;
    }

    @Override
    public final void onViewAttachedToWindow(AbstractC1174p1 abstractC1174p1) {
        ((C0454c0) abstractC1174p1).f2319a.getClass();
    }

    @Override
    public final void onViewDetachedFromWindow(AbstractC1174p1 abstractC1174p1) {
        C0454c0 c0454c0 = (C0454c0) abstractC1174p1;
        c0454c0.f2319a.getClass();
        C3565m.m7180d(c0454c0.f2320b.f9403a);
    }

    @Override
    public final void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
        String str;
        String str2;
        C0454c0 c0454c0 = (C0454c0) abstractC1174p1;
        C3565m c3565m = c0454c0.f2319a;
        c3565m.getClass();
        String strM165s = AbstractC0032a.m165s("MjybNmDFoachJw==\n", "RFX+QSiqzcM=\n");
        C2737b c2737b = c0454c0.f2320b;
        AbstractC2796i.m5785f(c2737b, strM165s);
        switch (c3565m.f12018c) {
            case 0:
                str = "njz2i5C4n0uNJw==\n";
                str2 = "6FWT/NjX8y8=\n";
                break;
            case 1:
                str = "RWvv0H5yGhxWcA==\n";
                str2 = "MwKKpzYddng=\n";
                break;
            case 2:
                str = "pecpZ/Q7T/62/A==\n";
                str2 = "045MELxUI5o=\n";
                break;
            case 3:
                str = "5txYu9GB8KT1xw==\n";
                str2 = "kLU9zJnunMA=\n";
                break;
            case 4:
                str = "PbXvKy3eyWourg==\n";
                str2 = "S9yKXGWxpQ4=\n";
                break;
            default:
                str = "a6pGs5UUQPB4sQ==\n";
                str2 = "HcMjxN17LJQ=\n";
                break;
        }
        AbstractC2796i.m5785f(c2737b, AbstractC0032a.m165s(str, str2));
        c0454c0.f2321c = null;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6, List list) {
        C0454c0 c0454c0 = (C0454c0) abstractC1174p1;
        Object obj = ((ArrayList) this.f2323a.f56d).get(i6);
        c0454c0.f2321c = obj;
        C3565m c3565m = c0454c0.f2319a;
        c3565m.getClass();
        String strM165s = AbstractC0032a.m165s("0P9pe68HYbzD5A==\n", "ppYMDOdoDdg=\n");
        C2737b c2737b = c0454c0.f2320b;
        AbstractC2796i.m5785f(c2737b, strM165s);
        c3565m.m7184e(c2737b, obj);
    }
}
