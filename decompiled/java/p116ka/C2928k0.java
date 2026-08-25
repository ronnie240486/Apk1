package p116ka;

import android.view.View;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0391a;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.C3333o;
import p063fa.C2569x0;
import p063fa.InterfaceC2549o0;

public final class C2928k0 implements InterfaceC2549o0 {

    public final int f9938a;

    public final int f9939b;

    public final ViewOnKeyListenerC2932m0 f9940c;

    public C2928k0(ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0, int i6, int i10) {
        this.f9938a = i10;
        this.f9940c = viewOnKeyListenerC2932m0;
        this.f9939b = i6;
    }

    @Override
    public final void mo5482a(int i6, View view) {
        switch (this.f9938a) {
            case 0:
                this.f9940c.f9986y0.setVisibility(4);
                this.f9940c.f9985x0.setVisibility(0);
                if (this.f9939b != -5) {
                    this.f9940c.f9983v0.f13009v = true;
                }
                if (i6 < this.f9940c.f9965d0.f8932j.size()) {
                    ChannelBean channelBean = (ChannelBean) this.f9940c.f9965d0.f8932j.get(i6);
                    C3333o c3333o = C3333o.f11249f;
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = this.f9940c;
                    c3333o.m6770c(channelBean, viewOnKeyListenerC2932m0.m5933W(viewOnKeyListenerC2932m0.f9982u0));
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m1 = this.f9940c;
                    viewOnKeyListenerC2932m1.getClass();
                    C2924i0 c2924i0M6769a = C3333o.f11249f.m6769a(viewOnKeyListenerC2932m1, viewOnKeyListenerC2932m1.f9985x0, ViewOnKeyListenerC2932m0.f9948C0, viewOnKeyListenerC2932m1.f9986y0);
                    AbstractC0410j0 abstractC0410j0M1320i = this.f9940c.m1320i();
                    abstractC0410j0M1320i.getClass();
                    C0391a c0391a = new C0391a(abstractC0410j0M1320i);
                    c0391a.m1194i(R.id.vod_detail_container, c2924i0M6769a);
                    c0391a.m1188c();
                    c0391a.m1190e(false);
                }
                break;
            default:
                C2569x0 c2569x0 = this.f9940c.f9965d0;
                if (c2569x0 != null || i6 <= c2569x0.f8932j.size() - 1) {
                    if (this.f9939b != -5) {
                        this.f9940c.f9983v0.f13009v = true;
                    }
                    ChannelBean channelBean2 = (ChannelBean) this.f9940c.f9965d0.f8932j.get(i6);
                    this.f9940c.f9986y0.setVisibility(4);
                    this.f9940c.f9985x0.setVisibility(0);
                    C3333o c3333o2 = C3333o.f11249f;
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m2 = this.f9940c;
                    c3333o2.m6770c(channelBean2, viewOnKeyListenerC2932m2.m5933W(viewOnKeyListenerC2932m2.f9982u0));
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m3 = this.f9940c;
                    viewOnKeyListenerC2932m3.getClass();
                    C2924i0 c2924i0M6769a2 = C3333o.f11249f.m6769a(viewOnKeyListenerC2932m3, viewOnKeyListenerC2932m3.f9985x0, ViewOnKeyListenerC2932m0.f9948C0, viewOnKeyListenerC2932m3.f9986y0);
                    AbstractC0410j0 abstractC0410j0M1320i2 = this.f9940c.m1320i();
                    abstractC0410j0M1320i2.getClass();
                    C0391a c0391a2 = new C0391a(abstractC0410j0M1320i2);
                    c0391a2.m1194i(R.id.vod_detail_container, c2924i0M6769a2);
                    c0391a2.m1188c();
                    c0391a2.m1190e(false);
                }
                break;
        }
    }
}
