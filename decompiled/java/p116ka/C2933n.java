package p116ka;

import android.view.View;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import ga.C2625h;
import java.util.HashMap;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p003a2.AbstractC0032a;
import p055ea.DialogInterfaceOnDismissListenerC2466t;
import p055ea.EnumC2434d;
import p063fa.C2516d0;
import p063fa.DialogInterfaceOnClickListenerC2517d1;
import p124l6.C2982h;
import sa.DialogC3734e;

public final class C2933n {

    public final int f9988a;

    public final ViewOnKeyListenerC2937r f9989b;

    public C2933n(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, int i6) {
        this.f9988a = i6;
        this.f9989b = viewOnKeyListenerC2937r;
    }

    public void m5942a(View view, int i6, Boolean bool) {
        int i10 = 1;
        ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = this.f9989b;
        switch (this.f9988a) {
            case 1:
                String strM165s = AbstractC0032a.m165s("6aNlE4zP\n", "q/AoduK6mp0=\n");
                String str = AbstractC0032a.m165s("lzJMhHLy6MiMOWa1ce776sJ8\n", "+FwL9h2HmIE=\n") + bool;
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                viewOnKeyListenerC2937r.m5961h0(EnumC2434d.f8529a);
                Log.m5049i(AbstractC0032a.m165s("4EHXOD5d\n", "ohKaXVAoVRI=\n"), String.valueOf(view.isSelected()) + AbstractC0032a.m165s("uhE=\n", "xjFiwSL41eU=\n") + view.getTag());
                if (view.getTag() != null) {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    viewOnKeyListenerC2937r.f10015m0 = iIntValue;
                    HashMap map = viewOnKeyListenerC2937r.f10012j0;
                    if (map == null || map.get(Integer.valueOf(iIntValue)) == null || !((Group) viewOnKeyListenerC2937r.f10012j0.get(Integer.valueOf(viewOnKeyListenerC2937r.f10015m0))).restrictedAccess) {
                        viewOnKeyListenerC2937r.m5956c0();
                    } else if (Spark.f11007c2) {
                        ViewOnKeyListenerC2937r.f9996v0 = 0;
                        viewOnKeyListenerC2937r.f10001X.notifyItemChanged(i6);
                        viewOnKeyListenerC2937r.m5956c0();
                    } else if (!viewOnKeyListenerC2937r.f10016n0) {
                        viewOnKeyListenerC2937r.f10016n0 = true;
                        C2982h c2982h = new C2982h(viewOnKeyListenerC2937r.m1321j());
                        c2982h.f10226c = new DialogInterfaceOnClickListenerC2517d1(this, view, i6, i10);
                        DialogC3734e dialogC3734eM6042o = c2982h.m6042o();
                        dialogC3734eM6042o.show();
                        dialogC3734eM6042o.setOnDismissListener(new DialogInterfaceOnDismissListenerC2466t(2, this));
                    }
                }
                break;
            default:
                String strM165s2 = AbstractC0032a.m165s("yMdtaJL+\n", "ipQgDfyLG9Q=\n");
                String str2 = AbstractC0032a.m165s("79DWLpkqH3/v0NYumSoff+/Q1WLUQEg5obCZZNliHHyqgZpgmn1TKa+bzy0=\n", "zPP1DboJPFw=\n") + bool;
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s2, str2);
                ChannelBean channelBean = (ChannelBean) view.getTag();
                if (viewOnKeyListenerC2937r.f10020r0) {
                    viewOnKeyListenerC2937r.f10020r0 = false;
                    C3333o c3333o = C3333o.f11249f;
                    c3333o.m6771d();
                    c3333o.f11251b.m7741k();
                    c3333o.m6772e();
                }
                if (channelBean != null) {
                    viewOnKeyListenerC2937r.m5948U(bool, channelBean);
                }
                break;
        }
    }

    public void m5943b(View view, boolean z7) {
        View view2;
        ChannelBean channelBean;
        switch (this.f9988a) {
            case 1:
                if (view == null) {
                    String strM165s = AbstractC0032a.m165s("z45p6IdH\n", "jd0kjeky7ag=\n");
                    String strM165s2 = AbstractC0032a.m165s("X6JifuRHO/9dpy1l4Qsh\n", "ONANC5RnTZY=\n");
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, strM165s2);
                    break;
                } else if (this.f9989b.f10015m0 != ((Integer) view.getTag()).intValue()) {
                    this.f9989b.f10015m0 = ((Integer) view.getTag()).intValue();
                    if (C2621d.f9110d != null && C2621d.f9110d.get(Integer.valueOf(this.f9989b.f10015m0)) != null) {
                        Spark.f11006b2 = ((Group) C2621d.f9110d.get(Integer.valueOf(this.f9989b.f10015m0))).type;
                    }
                    this.f9989b.m5956c0();
                    C2516d0 c2516d0 = this.f9989b.f10002Y;
                    if (c2516d0 != null && (view2 = c2516d0.f8768e) != null) {
                        view2.setSelected(false);
                        this.f9989b.f10002Y.m5551b(null);
                        break;
                    }
                }
                break;
            default:
                if (z7 && (channelBean = (ChannelBean) view.getTag()) != null) {
                    this.f9989b.m5960g0(C2625h.m5631d(channelBean));
                    break;
                }
                break;
        }
    }
}
