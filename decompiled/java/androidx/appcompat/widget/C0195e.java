package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import com.p2serv.android.p032ds.R;
import p001a0.C0019b;
import p105k.AbstractC2846t;
import p105k.C2849w;
import p105k.MenuC2838l;
import p105k.SubMenuC2831e0;

public final class C0195e extends C2849w {

    public final int f894l = 0;

    public final C0225k f895m;

    public C0195e(C0225k c0225k, Context context, MenuC2838l menuC2838l, View view) {
        super(R.attr.actionOverflowMenuStyle, context, view, menuC2838l, true);
        this.f895m = c0225k;
        this.f9760f = 8388613;
        C0019b c0019b = c0225k.f975x;
        this.f9762h = c0019b;
        AbstractC2846t abstractC2846t = this.f9763i;
        if (abstractC2846t != null) {
            abstractC2846t.mo5804i(c0019b);
        }
    }

    @Override
    public final void mo654c() {
        switch (this.f894l) {
            case 0:
                C0225k c0225k = this.f895m;
                c0225k.f972u = null;
                c0225k.f976y = 0;
                super.mo654c();
                break;
            default:
                C0225k c0225k2 = this.f895m;
                MenuC2838l menuC2838l = c0225k2.f9611c;
                if (menuC2838l != null) {
                    menuC2838l.m5827c(true);
                }
                c0225k2.f971t = null;
                super.mo654c();
                break;
        }
    }

    public C0195e(C0225k c0225k, Context context, SubMenuC2831e0 subMenuC2831e0, View view) {
        super(R.attr.actionOverflowMenuStyle, context, view, subMenuC2831e0, false);
        this.f895m = c0225k;
        if (!subMenuC2831e0.f9645A.m5844f()) {
            View view2 = c0225k.f961j;
            this.f9759e = view2 == null ? (View) c0225k.f9616h : view2;
        }
        C0019b c0019b = c0225k.f975x;
        this.f9762h = c0019b;
        AbstractC2846t abstractC2846t = this.f9763i;
        if (abstractC2846t != null) {
            abstractC2846t.mo5804i(c0019b);
        }
    }
}
