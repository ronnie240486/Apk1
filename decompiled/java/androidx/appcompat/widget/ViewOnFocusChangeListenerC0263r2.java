package androidx.appcompat.widget;

import android.view.View;
import com.google.android.material.textfield.C1867e;
import com.google.android.material.textfield.C1875m;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import org.bitspark.android.R$drawable;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p063fa.AbstractC2551p;
import p063fa.AbstractC2562u;
import p063fa.C2543m0;
import p116ka.ViewOnKeyListenerC2937r;
import p116ka.ViewOnKeyListenerC2944y;

public final class ViewOnFocusChangeListenerC0263r2 implements View.OnFocusChangeListener {

    public final int f1048a;

    public final Object f1049b;

    public ViewOnFocusChangeListenerC0263r2(int i6, Object obj) {
        this.f1048a = i6;
        this.f1049b = obj;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        Object obj = this.f1049b;
        switch (this.f1048a) {
            case 0:
                SearchView searchView = (SearchView) obj;
                View.OnFocusChangeListener onFocusChangeListener = searchView.f727K;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z7);
                }
                break;
            case 1:
                C1867e c1867e = (C1867e) obj;
                c1867e.m4381e(C1867e.m4378d(c1867e));
                break;
            case 2:
                C1875m c1875m = (C1875m) obj;
                c1875m.f6867a.setEndIconActivated(z7);
                if (!z7) {
                    c1875m.m4392i(false);
                    c1875m.f6859l = false;
                }
                break;
            case 3:
                AbstractC2551p abstractC2551p = (AbstractC2551p) obj;
                if (z7) {
                    abstractC2551p.f8885b = 0;
                } else {
                    abstractC2551p.f8885b = -1;
                }
                abstractC2551p.notifyItemChanged(abstractC2551p.f8884a);
                break;
            case 4:
                AbstractC2562u abstractC2562u = (AbstractC2562u) obj;
                if (z7) {
                    abstractC2562u.f8915c = 0;
                }
                String str = AbstractC2562u.f8911e;
                String str2 = AbstractC0032a.m165s("rEpMhNCbuWisSkzGk/D7JvQUIsGc2PMgoQ==\n", "gWdhqf22lEU=\n") + z7 + AbstractC0032a.m165s("+7jaZPIGVhK+scB1+w4V\n", "29WJAZ5jNWY=\n") + abstractC2562u.f8914b;
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(str, str2);
                abstractC2562u.notifyItemChanged(abstractC2562u.f8914b);
                break;
            case 5:
                view.setSelected(z7);
                if (z7) {
                    ((C2543m0) obj).getClass();
                }
                break;
            case 6:
                ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = (ViewOnKeyListenerC2937r) obj;
                if (!z7) {
                    viewOnKeyListenerC2937r.f10007e0.setBackgroundResource(R.color.transparency);
                } else {
                    viewOnKeyListenerC2937r.f10014l0 = true;
                    viewOnKeyListenerC2937r.f10007e0.setBackgroundResource(R$drawable.kb_menu_item_bg_focused);
                    if (!viewOnKeyListenerC2937r.f10006d0.getText().toString().isEmpty()) {
                        ViewOnKeyListenerC2937r.m5944Q(viewOnKeyListenerC2937r, viewOnKeyListenerC2937r.f10006d0.getText().toString());
                    } else {
                        ViewOnKeyListenerC2937r.f9994t0.removeMessages(2);
                        viewOnKeyListenerC2937r.f10015m0 = -1000;
                        viewOnKeyListenerC2937r.m5957d0(new ArrayList());
                    }
                }
                break;
            default:
                ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = (ViewOnKeyListenerC2944y) obj;
                if (!z7) {
                    viewOnKeyListenerC2944y.f10091o0.setVisibility(4);
                    viewOnKeyListenerC2944y.f10093p0.setVisibility(4);
                } else {
                    viewOnKeyListenerC2944y.f10091o0.setVisibility(0);
                    viewOnKeyListenerC2944y.f10093p0.setVisibility(0);
                }
                break;
        }
    }
}
