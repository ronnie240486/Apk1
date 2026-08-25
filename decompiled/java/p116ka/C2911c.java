package p116ka;

import androidx.media3.exoplayer.analytics.C0684b;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import java.util.Objects;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p081h8.AbstractC2671b;
import p090i8.AbstractC2712f;
import p135m8.EnumC3085a;
import p155o8.C3276a;
import p169p8.C3378c;
import p169p8.C3380e;
import p169p8.C3382g;
import p180q8.C3533h;
import p223u8.AbstractC3935e;

public final class C2911c extends StringCallback {

    public final HistoryBean f9867a;

    public final ViewOnKeyListenerC2915e f9868b;

    public C2911c(ViewOnKeyListenerC2915e viewOnKeyListenerC2915e, HistoryBean historyBean) {
        this.f9868b = viewOnKeyListenerC2915e;
        this.f9867a = historyBean;
    }

    @Override
    public final void onCacheSuccess(Response response) {
        String strM165s = AbstractC0032a.m165s("MqpW39tXmZwJ\n", "cPketqgj9u4=\n");
        String strM165s2 = AbstractC0032a.m165s("mXtQLzkZt4yWf0phKhrzqYxxSS8sF7Cnmz5LZA==\n", "/h4kD092088=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
    }

    @Override
    public final void onSuccess(Response response) {
        C3378c c3378c = new C3378c(new C0684b(this, 14, (String) response.body()));
        ViewOnKeyListenerC2915e viewOnKeyListenerC2915e = this.f9868b;
        C3276a c3276a = viewOnKeyListenerC2915e.f9892h0;
        if (c3276a != null && !c3276a.m6563g()) {
            C3276a c3276a2 = viewOnKeyListenerC2915e.f9892h0;
            c3276a2.getClass();
            EnumC3085a.m6113b(c3276a2);
        }
        C3533h c3533h = AbstractC3935e.f13233a;
        Objects.requireNonNull(c3533h, "scheduler is null");
        C3382g c3382g = new C3382g(c3378c, c3533h);
        AbstractC2712f abstractC2712f = AbstractC2671b.f9298a;
        if (abstractC2712f == null) {
            throw new NullPointerException("scheduler == null");
        }
        C3380e c3380eM6610v = c3382g.m6610v(abstractC2712f);
        C3276a c3276a3 = new C3276a(new C0684b(this, 15, this.f9867a));
        c3380eM6610v.m6608F(c3276a3);
        viewOnKeyListenerC2915e.f9892h0 = c3276a3;
    }

    @Override
    public final void onError(Response response) {
    }
}
