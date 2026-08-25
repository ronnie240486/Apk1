package p193ra;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mars.xlog.Log;
import java.util.HashMap;
import java.util.Map;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.C2448k;
import p055ea.C2477z;
import p125l7.C3004k;

public final class C3663f {

    public static final String f12266m = AbstractC0032a.m165s("+NhKmTfSimvG006S\n", "qLQr4FKgxwo=\n");

    public static C3663f f12267n;

    public C2477z f12276i;

    public final String f12268a = AbstractC0032a.m165s("ravVtkx7tHmSvdyRQES+b5S73Y9EWA==\n", "4N65wiUo2ww=\n");

    public final String f12269b = AbstractC0032a.m165s("2YUbb1ghVNf8mAFvRjVG\n", "lextCgtUNqM=\n");

    public final HashMap f12270c = new HashMap();

    public final HashMap f12271d = new HashMap();

    public ChannelBean f12272e = null;

    public int f12273f = 0;

    public boolean f12274g = false;

    public boolean f12275h = true;

    public int f12277j = 0;

    public C2448k f12278k = null;

    public String f12279l = "";

    public static C3663f m7415b() {
        if (f12267n == null) {
            f12267n = new C3663f();
        }
        return f12267n;
    }

    public final void m7416a() {
        ChannelBean channelBean = this.f12272e;
        if (channelBean != null) {
            this.f12270c.remove(String.valueOf(channelBean.getChid()));
        }
    }

    public final boolean m7417c() {
        ChannelBean channelBean = this.f12272e;
        return (channelBean == null || channelBean.getSources() == null || this.f12272e.getSources().size() <= 1) ? false : true;
    }

    public final boolean m7418d() {
        return this.f12272e.getSources().size() > 1 && this.f12273f == this.f12272e.getSources().size() - 1;
    }

    public final void m7419e() {
        Map map = (Map) new C3004k().m6080b(AbstractC3331m.m6757g(this.f12269b, ""));
        if (map != null) {
            this.f12271d.putAll(map);
        }
    }

    public final void m7420f(ChannelBean channelBean, Boolean bool, int i6, String str) {
        C2448k c2448k;
        String str2 = AbstractC0032a.m165s("PvToKFVxWnYhoqk=\n", "TpiJUQMYPhM=\n") + new C3004k().m6083e(channelBean);
        boolean z7 = AbstractC3331m.f11244b;
        String str3 = f12266m;
        Log.m5049i(str3, str2);
        this.f12273f = i6;
        Message message = new Message();
        message.what = 80;
        Bundle bundle = new Bundle();
        bundle.putInt(AbstractC0032a.m165s("1Cxbow==\n", "t0Qyx9RUy5g=\n"), channelBean.getChid());
        if (bool.booleanValue()) {
            bundle.putInt(AbstractC0032a.m165s("FeNKMm4=\n", "eYY8VwI4J6E=\n"), channelBean.getLevel());
        }
        Log.m5049i(str3, AbstractC0032a.m165s("gLOmFMLPF32f/64D8MMLIg==\n", "8N/HbZSmcxg=\n") + this.f12273f);
        this.f12274g = bool.booleanValue();
        if (this.f12272e != null && channelBean.getChid() != this.f12272e.getChid() && (c2448k = this.f12278k) != null) {
            c2448k.f8630b.getClass();
        }
        this.f12272e = channelBean;
        C2477z c2477z = this.f12276i;
        if (c2477z != null) {
            ChannelBean.NameBean name = channelBean.getName();
            Spark spark = c2477z.f8678a;
            if (name != null && channelBean.getName().getInit() != null) {
                Log.m5049i(AbstractC0032a.m165s("/52NBNWi\n", "vc7AZbzMmD8=\n"), AbstractC0032a.m165s("Elq83dERXRs=\n", "fTTssbBoZzs=\n") + channelBean.getName().getInit());
                spark.f11128m0.setText(channelBean.getName().getInit());
            }
            m7415b().f12277j = spark.f11054I.f10015m0;
        }
        HashMap map = this.f12270c;
        String str4 = (String) map.get(String.valueOf(this.f12272e.getChid()));
        if (str4 == null && this.f12275h) {
            str4 = AbstractC2442h.f8589K;
        } else {
            this.f12275h = true;
        }
        int size = channelBean.getSources().size();
        if (size == 0) {
            return;
        }
        if (!TextUtils.isEmpty(str4) && this.f12273f == 0) {
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    if (this.f12273f >= size) {
                        break;
                    }
                    bundle.putString(AbstractC0032a.m165s("cjw3\n", "B05bO26oRSY=\n"), channelBean.getSources().get(this.f12273f).getAddress());
                    break;
                } else {
                    ChannelBean.SourcesBean sourcesBean = channelBean.getSources().get(i10);
                    if (str4.equals(sourcesBean.getSubTitle())) {
                        this.f12273f = i10;
                        bundle.putString(AbstractC0032a.m165s("G7O1\n", "bsHZ2Oq9pa4=\n"), sourcesBean.getAddress());
                        break;
                    }
                    i10++;
                }
            }
        } else if (this.f12273f < size) {
            bundle.putString(AbstractC0032a.m165s("sVvH\n", "xCmrzH7+CN4=\n"), channelBean.getSources().get(this.f12273f).getAddress());
        }
        if (this.f12273f >= size) {
            Log.m5049i(str3, AbstractC0032a.m165s("t5uxli5qmIGozfAJ7bMbX0Mfd32eo3sMcX03evQ=\n", "x/fQ73gD/OQ=\n") + this.f12273f + AbstractC0032a.m165s("RCgonQ==\n", "aQUFsM9ybxM=\n") + size);
            this.f12273f = 0;
            bundle.putString(AbstractC0032a.m165s("Z5tK\n", "EukmAe7+4Qg=\n"), channelBean.getSources().get(this.f12273f).getAddress());
        }
        map.put(String.valueOf(this.f12272e.getChid()), channelBean.getSources().get(this.f12273f).getSubTitle());
        if (channelBean.getSid() > 0) {
            bundle.putString(AbstractC0032a.m165s("yoS1hQ==\n", "pOXY4Ce5Rh0=\n"), channelBean.getSid() + AbstractC0032a.m165s("Cw==\n", "JWM8rHZD4Gc=\n") + channelBean.getName().getInit());
        } else {
            bundle.putString(AbstractC0032a.m165s("jd86Qw==\n", "475XJh7wytk=\n"), channelBean.getName().getInit());
        }
        bundle.putString(AbstractC0032a.m165s("Sp7iaKc=\n", "OeuAIcNyIsU=\n"), "");
        bundle.putString(AbstractC0032a.m165s("xxFv41ojKVg=\n", "tGQNlzNXRT0=\n"), "");
        bundle.putString(AbstractC0032a.m165s("RXRo2w==\n", "MQ0YviK9qRw=\n"), Constants$VIDEO_TYPE.BSLIVE.name());
        bundle.putString(AbstractC0032a.m165s("BLgTyJT3Gpw=\n", "ad19vcCOavk=\n"), str);
        this.f12279l = str;
        message.setData(bundle);
        Spark.f11002X1.sendMessage(message);
    }
}
