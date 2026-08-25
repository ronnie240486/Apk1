package ma;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.mediarouter.app.ViewOnClickListenerC1121z;
import com.google.android.material.textfield.ViewOnTouchListenerC1874l;
import com.p2serv.android.p032ds.R;
import na.C3222a;
import org.bitspark.android.R$drawable;
import p003a2.AbstractC0032a;
import p063fa.InterfaceC2546n0;
import p063fa.ViewOnKeyListenerC2521f;
import p063fa.ViewOnTouchListenerC2534j0;
import p157oa.C3286a;
import p209t3.AbstractC3804a;
import p209t3.C3807d;
import pa.AbstractC3386a;

public final class C3091a extends AbstractC3804a {

    public C3222a f10554e;

    public C3222a f10555f;

    public C3222a f10556g;

    public long f10557h;

    public long f10558i;

    public long f10559j;

    public boolean f10560k;

    public boolean f10561l;

    public InterfaceC2546n0 f10562m;

    public Handler f10563n;

    static {
        AbstractC0032a.m165s("aL1PTAUItlVivFd+Hgy2\n", "I9g2DmppxDE=\n");
    }

    @Override
    public final void mo6117a(C3807d c3807d, Object obj) {
        C3286a c3286a = (C3286a) obj;
        View view = c3807d.f12848b;
        int itemViewType = c3807d.getItemViewType();
        if (itemViewType != 0) {
            switch (itemViewType) {
                case 3:
                    ((ImageView) c3807d.m7583b(R.id.tv_kb)).setImageResource(R$drawable.iv_common_kb_delete_smaller);
                    c3807d.m7583b(R.id.tv_kb).setOnTouchListener(new ViewOnTouchListenerC2534j0(this, c3807d, c3807d.getLayoutPosition(), 4));
                    break;
                case 4:
                    ((ImageView) c3807d.m7583b(R.id.tv_kb)).setImageResource(R$drawable.iv_common_kb_delete_small);
                    c3807d.m7583b(R.id.tv_kb).setOnTouchListener(new ViewOnTouchListenerC2534j0(this, c3807d, c3807d.getLayoutPosition(), 4));
                    break;
                case 5:
                    ((ImageView) c3807d.m7583b(R.id.tv_kb)).setImageResource(R$drawable.iv_commom_kb_lowercase);
                    c3807d.m7583b(R.id.tv_kb).setBackgroundResource(R$drawable.selector_keyboard_key_alphabet);
                    break;
                case 6:
                    ((TextView) c3807d.m7583b(R.id.tv_kb)).setText(c3286a.f10997a);
                    break;
                case 7:
                    ((TextView) c3807d.m7583b(R.id.tv_kb)).setText(c3286a.f10997a);
                    break;
                case 8:
                    ((TextView) c3807d.m7583b(R.id.tv_kb)).setText(c3286a.f10997a);
                    break;
                case 9:
                    ((ImageView) c3807d.m7583b(R.id.tv_kb)).setImageResource(R$drawable.iv_commom_kb_space);
                    break;
                default:
                    if (!AbstractC3386a.m6875a(c3286a.f10997a)) {
                        String str = c3286a.f10997a;
                        if (AbstractC0032a.m165s("cd2Y6TqxStZ51ZDhMrlCzmHNiPkqoVrGacU=\n", "EL/7jV/XLb4=\n").contains(str.toLowerCase())) {
                            ((TextView) c3807d.m7583b(R.id.tv_kb)).setText(str.toLowerCase());
                        }
                    }
                    break;
            }
        } else {
            ((TextView) c3807d.m7583b(R.id.tv_kb)).setText(c3286a.f10997a);
            ((TextView) c3807d.f12848b).setTextSize(20.0f);
        }
        c3807d.m7583b(R.id.tv_kb).setOnTouchListener(new ViewOnTouchListenerC1874l(this, 1, c3807d));
        c3807d.m7583b(R.id.tv_kb).setOnKeyListener(new ViewOnKeyListenerC2521f(this, c3807d));
        c3807d.m7583b(R.id.tv_kb).setOnClickListener(new ViewOnClickListenerC1121z(this, 3, c3807d));
    }
}
