package ga;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.PostRequest;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.UpdateInfo;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.C2428a;

public final class C2628k {

    public static final String f9128a = AbstractC0032a.m165s("rhNS8z+vdBU=\n", "7EAHg1vOAHA=\n");

    public static UpdateInfo f9129b;

    public final void m5643a(String str) {
        int i6 = 0;
        String strM5649h = C2630m.m5649h(EnumC2629l.f9134e);
        if (strM5649h.isEmpty()) {
            return;
        }
        try {
            ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkGo.post(strM5649h).removeHeader(AbstractC0032a.m165s("AH7kMLrvOOI7eQ==\n", "VQ2BQpeuX4c=\n"))).headers(AbstractC0032a.m165s("5WQHgJXHdYjeYw==\n", "sBdi8riGEu0=\n"), C2428a.f8504m)).tag(this)).cacheMode(CacheMode.NO_CACHE)).params(AbstractC0032a.m165s("HT5HIXAVLg==\n", "bV8kShFyS2o=\n"), C2428a.f8493b, new boolean[0])).params(AbstractC0032a.m165s("AcEpGueOKg==\n", "YqlIdInrRtw=\n"), AbstractC2442h.f8598d, new boolean[0])).params(AbstractC0032a.m165s("aHnG9A==\n", "DgupmclcVQU=\n"), str, new boolean[0])).params(AbstractC0032a.m165s("NRjdpD4k47UwDQ==\n", "VGit0ltWgNo=\n"), C2428a.f8496e, new boolean[0])).params(AbstractC0032a.m165s("5hvbAY6GdDXqDg==\n", "h2urd+v0GlQ=\n"), C2428a.f8498g, new boolean[0])).params(AbstractC0032a.m165s("YhO19HgYDUx1Dw==\n", "EWrGgh1qbiM=\n"), C2428a.f8495d, new boolean[0])).params(AbstractC0032a.m165s("EC38P/evXtUOMQ==\n", "Y1SPSZLdMLQ=\n"), C2428a.f8494c, new boolean[0])).execute(new C2627j(i6));
        } catch (Exception unused) {
            String strM165s = AbstractC0032a.m165s("/TEIVbPhXHzuMVwUtvgYeOgmEwfn\n", "mlR8dcaROB0=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(f9128a, strM165s);
            Spark.f11002X1.sendEmptyMessage(61);
        }
    }
}
