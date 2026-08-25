package la;

import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.InterfaceC3328j;
import p003a2.AbstractC0032a;
import sa.InterfaceC3744o;

public final class C3014a implements InterfaceC3328j, InterfaceC3744o {

    public final ViewOnClickListenerC3017d f10305a;

    public C3014a(ViewOnClickListenerC3017d viewOnClickListenerC3017d) {
        this.f10305a = viewOnClickListenerC3017d;
    }

    @Override
    public void mo5964a(String str) {
        String strM165s = AbstractC0032a.m165s("K2GCJqP70YgRbZoi\n", "ZQT2UcyJut0=\n");
        String strConcat = AbstractC0032a.m165s("Bp2pmDFDBVszm7OPdFQUQTHStIM3QxRBNsjn\n", "RfLH9lQgcTI=\n").concat(str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strConcat);
    }

    @Override
    public void mo5965b(String str) {
        String strM165s = AbstractC0032a.m165s("JLkPEvFTepsetRcW\n", "atx7ZZ4hEc4=\n");
        String strConcat = AbstractC0032a.m165s("D64IkswAVQ06qBKFiRdEFzjhAJ3AD0QAduE=\n", "TMFm/KljIWQ=\n").concat(str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strConcat);
        ViewOnClickListenerC3017d viewOnClickListenerC3017d = this.f10305a;
        viewOnClickListenerC3017d.getClass();
        viewOnClickListenerC3017d.f10327l0 = true;
        viewOnClickListenerC3017d.m6093T(str);
        viewOnClickListenerC3017d.f10323h0.setImageResource(R.mipmap.network_icon_no_3x);
    }

    @Override
    public void onDismiss() {
        this.f10305a.f10314X.setVisibility(0);
    }
}
