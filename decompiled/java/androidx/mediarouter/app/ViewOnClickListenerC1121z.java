package androidx.mediarouter.app;

import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import ma.C3091a;
import na.C3222a;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Menu;
import org.bitspark.android.keyboard.custom.MyKeyBoardView;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3320b;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.C2448k;
import p063fa.C2566w;
import p063fa.C2568x;
import p173q1.C3445s0;
import p193ra.C3663f;
import p209t3.C3807d;

public final class ViewOnClickListenerC1121z implements View.OnClickListener {

    public final int f3434a;

    public final Object f3435b;

    public final Object f3436c;

    public ViewOnClickListenerC1121z(Object obj, int i6, Object obj2) {
        this.f3434a = i6;
        this.f3436c = obj;
        this.f3435b = obj2;
    }

    @Override
    public final void onClick(View view) {
        int bindingAdapterPosition;
        switch (this.f3434a) {
            case 0:
                C1077a0 c1077a0 = (C1077a0) this.f3436c;
                DialogC1081c0 dialogC1081c0 = c1077a0.f3182e.f3191g;
                C3445s0 c3445s0 = (C3445s0) this.f3435b;
                dialogC1081c0.f3202m = c3445s0;
                c3445s0.m7029l(true);
                c1077a0.f3179b.setVisibility(4);
                c1077a0.f3180c.setVisibility(0);
                break;
            case 1:
                Spark spark = (Spark) this.f3436c;
                if (spark.f11132o0) {
                    spark.f11120i0.f12991d.m1488h(1);
                    AbstractC3331m.m6763m(1, AbstractC0032a.m165s("vIwpCn+VBYeqgyIXaoY=\n", "79x2TjrDTMQ=\n"));
                    if (C3320b.m6737d().m6739e(spark) && AbstractC2442h.f8594P) {
                        spark.m6710a0();
                        C3320b.m6737d().m6738c();
                        spark.f11043E0.setVisibility(0);
                        spark.f11089T1.setVisibility(0);
                    } else {
                        spark.f11043E0.setVisibility(8);
                        spark.f11089T1.setVisibility(8);
                    }
                } else {
                    spark.f11043E0.setVisibility(8);
                    spark.f11089T1.setVisibility(8);
                    spark.f11120i0.f12991d.m1488h(0);
                    AbstractC3331m.m6763m(0, AbstractC0032a.m165s("iOzoCmrlcvee4+MXf/Y=\n", "27y3Ti+zO7Q=\n"));
                }
                ((Dialog) this.f3435b).dismiss();
                spark.f11087T.m5652i();
                break;
            case 2:
                C2568x c2568x = (C2568x) this.f3436c;
                if (c2568x.f8931d != null && (bindingAdapterPosition = ((C2566w) this.f3435b).getBindingAdapterPosition()) != -1) {
                    int i6 = 0;
                    while (i6 < c2568x.f8930c.size()) {
                        ((Menu) c2568x.f8930c.get(i6)).setSelected(i6 == bindingAdapterPosition);
                        i6++;
                    }
                    c2568x.notifyDataSetChanged();
                    if (bindingAdapterPosition < c2568x.f8930c.size()) {
                        C2448k c2448k = c2568x.f8931d;
                        Spark spark2 = c2448k.f8630b;
                        spark2.f11049G0 = false;
                        spark2.f11120i0.f12986C.clear();
                        C3663f.m7415b().m7416a();
                        C3663f.m7415b().f12275h = false;
                        C3663f c3663fM7415b = C3663f.m7415b();
                        ChannelBean channelBean = c3663fM7415b.f12272e;
                        if (channelBean != null) {
                            c3663fM7415b.m7420f(channelBean, Boolean.valueOf(c3663fM7415b.f12274g), bindingAdapterPosition, c3663fM7415b.f12279l);
                            break;
                        }
                    }
                }
                break;
            default:
                C3091a c3091a = (C3091a) this.f3436c;
                C3222a c3222a = c3091a.f10554e;
                if (c3222a != null) {
                    MyKeyBoardView.m6734a(c3222a.f10824a, view, ((C3807d) this.f3435b).getLayoutPosition());
                }
                C3222a c3222a2 = c3091a.f10556g;
                if (c3222a2 != null && c3222a2.f10824a.f11194i != null) {
                    String string = view instanceof TextView ? ((TextView) view).getText().toString() : null;
                    Log.e(AbstractC0032a.m165s("SN6kUF4n\n", "deOZOzteN6g=\n"), string + "");
                    break;
                }
                break;
        }
    }
}
