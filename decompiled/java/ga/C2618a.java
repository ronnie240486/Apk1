package ga;

import android.os.Handler;
import com.alibaba.fastjson.JSON;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import java.util.List;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.MessageInfo;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.RunnableC0005f;
import p003a2.AbstractC0032a;

public final class C2618a extends StringCallback {

    public final Spark f9100a;

    public final C2619b f9101b;

    public C2618a(C2619b c2619b, Spark spark) {
        this.f9101b = c2619b;
        this.f9100a = spark;
    }

    @Override
    public final void onError(Response response) {
        Spark.f11002X1.sendEmptyMessage(651);
    }

    @Override
    public final void onSuccess(Response response) {
        C2619b c2619b = this.f9101b;
        try {
            try {
                List array = JSON.parseArray((String) response.body(), MessageInfo.class);
                int size = array.size();
                if (size > 0) {
                    String str = null;
                    for (int i6 = 0; i6 < size; i6++) {
                        str = str == null ? ((MessageInfo) array.get(i6)).content.init : str + "\n" + ((MessageInfo) array.get(i6)).content.init;
                    }
                    if (str != null && c2619b.f9103a == null) {
                        String strM165s = AbstractC0032a.m165s("A/uissc=\n", "QajvwaCMoyM=\n");
                        boolean z7 = AbstractC3331m.f11244b;
                        Log.m5049i(strM165s, str);
                        C2619b.m5626a(c2619b, str, this.f9100a);
                        new Handler().postDelayed(new RunnableC0005f(18, this), 20000L);
                    }
                }
            } catch (Exception unused) {
                String strM165s2 = AbstractC0032a.m165s("w3LZulw=\n", "gSGUyTuSExE=\n");
                String strM165s3 = AbstractC0032a.m165s("wXSE4y/JNL7WNZLxPoh5qMNnmeJr\n", "sRX2kErpWc0=\n");
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s2, strM165s3);
            }
        } finally {
            Spark.f11002X1.sendEmptyMessage(50);
        }
    }
}
