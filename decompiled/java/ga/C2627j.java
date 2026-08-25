package ga;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.RegisterInfo;
import org.bitspark.android.beans.UpdateInfo;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2440g;

public final class C2627j extends StringCallback {

    public final int f9127a;

    public C2627j(int i6) {
        this.f9127a = i6;
    }

    @Override
    public void onError(Response response) {
        switch (this.f9127a) {
            case 0:
                Spark.f11002X1.sendEmptyMessage(61);
                break;
            case 1:
            default:
                super.onError(response);
                break;
            case 2:
            case 3:
            case 4:
                break;
        }
    }

    @Override
    public final void onSuccess(Response response) {
        switch (this.f9127a) {
            case 0:
                if (!response.isSuccessful()) {
                    Spark.f11002X1.sendEmptyMessage(61);
                } else {
                    try {
                        C2628k.f9129b = (UpdateInfo) JSON.parseObject((String) response.body(), UpdateInfo.class);
                        Spark.f11002X1.sendEmptyMessage(60);
                        String strM165s = AbstractC0032a.m165s("t1vX+XmjxqU=\n", "9QiCiR3CssA=\n");
                        String str = (String) response.body();
                        boolean z7 = AbstractC3331m.f11244b;
                        Log.m5049i(strM165s, str);
                    } catch (Exception unused) {
                        String strM165s2 = AbstractC0032a.m165s("WsWvwTvzQh0=\n", "GJb6sV+SNng=\n");
                        String strM165s3 = AbstractC0032a.m165s("1V2i9X4AckPBXaTjO0RmR8QctfRpT3US\n", "pTzQhhsgBzM=\n");
                        boolean z10 = AbstractC3331m.f11244b;
                        Log.m5049i(strM165s2, strM165s3);
                        Spark.f11002X1.sendEmptyMessage(61);
                        return;
                    }
                }
                break;
            case 1:
                if (response.isSuccessful()) {
                    RegisterInfo registerInfo = (RegisterInfo) JSON.parseObject((String) response.body(), RegisterInfo.class);
                    int i6 = registerInfo.code;
                    if (i6 == 0 || i6 == -20) {
                        AbstractC3331m.m6764n(AbstractC2440g.f8556e, registerInfo.user_name);
                        AbstractC3331m.m6764n(AbstractC2440g.f8557f, AbstractC0032a.m165s("/YlbsCCg\n", "zLhqgRGRkfs=\n"));
                        AbstractC3331m.m6763m(2, AbstractC2440g.f8553b);
                        Spark.f11002X1.sendEmptyMessage(11);
                    } else {
                        Spark.m6678t0(0, AbstractC0032a.m165s("dPHzecTv8QcG8eZi2Om4VVTx4GLOu/gUUvHmMQ==\n", "JpSUELeblHU=\n"));
                        Spark.f11002X1.sendEmptyMessage(12);
                    }
                }
                break;
        }
    }

    private final void m5637a(Response response) {
    }

    private final void m5638b(Response response) {
    }

    private final void m5639c(Response response) {
    }

    private final void m5640d(Response response) {
    }

    private final void m5641e(Response response) {
    }

    private final void m5642f(Response response) {
    }
}
