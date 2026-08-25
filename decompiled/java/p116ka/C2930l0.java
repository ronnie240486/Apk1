package p116ka;

import androidx.media3.exoplayer.analytics.C0706w;
import androidx.media3.exoplayer.hls.C0775b;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import java.util.Objects;
import org.bitspark.android.beans.ChannelBean;
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

public final class C2930l0 extends StringCallback {

    public final String f9941a;

    public final ChannelBean f9942b;

    public final int f9943c;

    public final ViewOnKeyListenerC2932m0 f9944d;

    public C2930l0(ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0, String str, ChannelBean channelBean, int i6) {
        this.f9944d = viewOnKeyListenerC2932m0;
        this.f9941a = str;
        this.f9942b = channelBean;
        this.f9943c = i6;
    }

    @Override
    public final void onCacheSuccess(Response response) {
        String strM165s = AbstractC0032a.m165s("28e8HlY=\n", "mZTqcTI7SGE=\n");
        String strM165s2 = AbstractC0032a.m165s("cd0im3Kl/s9+2TjVYaa66mTXO5tnq/nkc5g50A==\n", "FrhWuwTKmow=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
    }

    @Override
    public final void onSuccess(Response response) {
        String str = (String) response.body();
        String str2 = this.f9941a;
        C3378c c3378c = new C3378c(new C0775b(this, str, str2, 9));
        ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = this.f9944d;
        C3276a c3276a = viewOnKeyListenerC2932m0.f9956A0;
        if (c3276a != null && !c3276a.m6563g()) {
            C3276a c3276a2 = viewOnKeyListenerC2932m0.f9956A0;
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
        C3276a c3276a3 = new C3276a(new C0706w(this, str2, this.f9942b, this.f9943c, 3));
        c3380eM6610v.m6608F(c3276a3);
        viewOnKeyListenerC2932m0.f9956A0 = c3276a3;
    }

    @Override
    public final void onError(Response response) {
    }
}
