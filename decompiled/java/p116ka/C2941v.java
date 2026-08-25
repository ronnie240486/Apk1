package p116ka;

import androidx.lifecycle.InterfaceC0520e0;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.InterfaceC3328j;
import p003a2.AbstractC0032a;

public final class C2941v implements InterfaceC0520e0, InterfaceC3328j {

    public final ViewOnKeyListenerC2944y f10026a;

    @Override
    public void mo5964a(String str) {
        String strM165s = AbstractC0032a.m165s("BAVJEPPTZS4+CVEU\n", "SmA9Z5yhDns=\n");
        String strConcat = AbstractC0032a.m165s("ilWwMjme/V6/U6olfInsRL0arSk/nuxEugD+\n", "yTreXFz9iTc=\n").concat(str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strConcat);
    }

    @Override
    public void mo5965b(String str) {
        String strM165s = AbstractC0032a.m165s("Xia1dB2jYrZkKq1w\n", "EEPBA3LRCeM=\n");
        String strConcat = AbstractC0032a.m165s("wM5fuoFrL5j1yEWtxHw+gveBV7WNZD6VuYE=\n", "g6Ex1OQIW/E=\n").concat(str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strConcat);
        ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = this.f10026a;
        viewOnKeyListenerC2944y.getClass();
        viewOnKeyListenerC2944y.f10096q1 = true;
        viewOnKeyListenerC2944y.m5966Q(str);
        viewOnKeyListenerC2944y.f10084k1.setImageResource(R.mipmap.network_icon_no_3x);
    }

    @Override
    public void mo1200c(Object obj) {
        this.f10026a.f10095q0.setText((String) obj);
    }
}
