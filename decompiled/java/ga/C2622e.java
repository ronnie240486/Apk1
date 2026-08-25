package ga;

import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import java.io.File;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2622e extends FileCallback {

    public final C2625h f9113a;

    public C2622e(C2625h c2625h, String str, String str2) {
        super(str, str2);
        this.f9113a = c2625h;
    }

    @Override
    public final void onError(Response response) {
        String strM165s = AbstractC0032a.m165s("hAbLZ2I=\n", "xlWONyXTKyA=\n");
        String strM165s2 = AbstractC0032a.m165s("JwYqHRQuko4mETFQUS2Q3DYGLB0XP5zCbEMsWBA61cgyDDMdEj+WxiU=\n", "QGNePXFe9a4=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        Spark.f11002X1.sendEmptyMessage(30);
    }

    @Override
    public final void onSuccess(Response response) {
        File file = (File) response.body();
        C2625h c2625h = this.f9113a;
        c2625h.getClass();
        new C2624g(c2625h, file).start();
    }
}
