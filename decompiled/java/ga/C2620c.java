package ga;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.p2serv.android.p032ds.R;
import com.tencent.bugly.proguard.C2081i0;
import com.tencent.mars.xlog.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.GroupBeanModel;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.InterfaceC3328j;
import p001a0.C0022e;
import p003a2.AbstractC0032a;
import p044da.C2338a;
import p044da.C2340c;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p055ea.AbstractC2460q;
import p156o9.AbstractC3281e;

public final class C2620c extends StringCallback {

    public final int f9105a;

    public final Object f9106b;

    public C2620c(int i6, Object obj) {
        this.f9105a = i6;
        this.f9106b = obj;
    }

    @Override
    public void onCacheSuccess(Response response) {
        Object obj = this.f9106b;
        switch (this.f9105a) {
            case 0:
                String strM165s = AbstractC0032a.m165s("Xi6foib8cRFw\n", "HH3cykeSH3Q=\n");
                String strM165s2 = AbstractC0032a.m165s("A7F269iYqToKsW7r3YKnOUS3Y6jTleg7Dw==\n", "ZNQCy7vwyFQ=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, strM165s2);
                String str = (String) response.body();
                ((C2621d) obj).getClass();
                new C2081i0(1, str).start();
                break;
            case 1:
                String strM165s3 = AbstractC0032a.m165s("qipj43u2\n", "6Hk2kB7EPJU=\n");
                String str2 = AbstractC0032a.m165s("l3mkWp8UhFDQeqIVk0GTWZN0tVqRCtAVzjw=\n", "8BzQev5h8Dg=\n") + ((String) response.body());
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s3, str2);
                C2630m.m5647d((C2630m) obj, (String) response.body(), response.code());
                break;
            case 2:
                String strM165s4 = AbstractC0032a.m165s("93m0UK/9yF3bRIdT\n", "tSriP8u+oDw=\n");
                String strM165s5 = AbstractC0032a.m165s("4/n3A03mWgPs/e1NXuUeJvbz7gNY6F0o4bzsSA==\n", "hJyDIzuJPkA=\n");
                boolean z11 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s4, strM165s5);
                break;
            default:
                super.onCacheSuccess(response);
                break;
        }
    }

    @Override
    public final void onError(Response response) throws Throwable {
        BufferedReader bufferedReader;
        int i6 = 1;
        Object obj = this.f9106b;
        switch (this.f9105a) {
            case 0:
                C2340c c2340c = Spark.f11008d2;
                String strM165s = AbstractC0032a.m165s("+j6B4oV9Gg==\n", "mVbgjOsYdlQ=\n");
                File fileM5302b = c2340c.f8149b.m5302b(strM165s);
                String strSubstring = null;
                strSubstring = null;
                strSubstring = null;
                strSubstring = null;
                BufferedReader bufferedReader2 = null;
                strSubstring = null;
                try {
                    if (fileM5302b.exists()) {
                        try {
                            bufferedReader = new BufferedReader(new FileReader(fileM5302b));
                            String str = "";
                            while (true) {
                                try {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line != null) {
                                            str = str + line;
                                        } else if (!AbstractC3281e.m6631u(str.getBytes())) {
                                            strSubstring = AbstractC3281e.m6628r(str.getBytes()) ? str.substring(str.indexOf(32) + 1, str.length()) : str;
                                            bufferedReader.close();
                                        } else {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                            }
                                            c2340c.m5311g(strM165s);
                                        }
                                    } catch (IOException e10) {
                                        e = e10;
                                        e.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e11) {
                                            e11.printStackTrace();
                                        }
                                        break;
                                    }
                                    throw th;
                                }
                            }
                        } catch (IOException e12) {
                            e = e12;
                            bufferedReader = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                                break;
                            }
                            throw th;
                        }
                    }
                    break;
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                String strSubstring2 = strSubstring != null ? strSubstring.substring(0, Math.min(strSubstring.length(), 50)) : AbstractC0032a.m165s("/N5huw==\n", "kqsN166ZzN0=\n");
                String strM165s2 = AbstractC0032a.m165s("L8ZHuFG70AoB\n", "bZUE0DDVvm8=\n");
                String strM5496j = AbstractC2460q.m5496j("RQexvtiiFUhMB6m+3bgbSwIRoOzNrwYGRAOs8pfqBkNDBuX4yaUZBkEDpvbe+04G\n", "ImLFnrvKdCY=\n", new StringBuilder(), strSubstring2);
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s2, strM5496j);
                if (strSubstring == null) {
                    Spark.f11002X1.sendEmptyMessage(21);
                    return;
                }
                Log.m5049i(AbstractC0032a.m165s("ihhTkTIq5Rik\n", "yEsQ+VNEi30=\n"), AbstractC0032a.m165s("ABWAedXG2DIJFZh50NzWMUcDkSvAy8t8ARGdNZqOyzkGFNQ/xMHUfAQRlzHTnA==\n", "Z3D0WbauuVw=\n"));
                ((C2621d) obj).getClass();
                new C2081i0(i6, strSubstring).start();
                return;
            case 1:
                String strM165s3 = AbstractC0032a.m165s("3Q5rYjVh\n", "n10+EVATvDg=\n");
                String str2 = AbstractC0032a.m165s("OVO7UJSeQ5Z7HaxHlYFe2CVY3mGJlVSMdg==\n", "Vj3+IubxMbY=\n") + response.code() + AbstractC0032a.m165s("i3cHnt0h+tCddw==\n", "p1dU6rxVj6M=\n") + response.message() + AbstractC0032a.m165s("OpY547k+IQ9ljFE=\n", "FrZxhthaRH0=\n") + response.headers() + AbstractC0032a.m165s("BBab8TZ618w=\n", "KDbZnlID7ew=\n") + ((String) response.body());
                boolean z10 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s3, str2);
                Throwable exception = response.getException();
                if (exception != null) {
                    String stackTraceString = android.util.Log.getStackTraceString(exception);
                    Log.m5049i(AbstractC0032a.m165s("ag5636sA\n", "KF0vrM5ykig=\n"), AbstractC0032a.m165s("KOuj0cKMW1JqpaPb04ZZBi7qiJmQ\n", "R4Xmo7DjKXI=\n") + exception.getMessage() + AbstractC0032a.m165s("BMay1uc=\n", "JOuf+8cL72Y=\n") + stackTraceString);
                }
                C2630m c2630m = (C2630m) obj;
                C2630m.m5644a(c2630m, AbstractC0032a.m165s("uA==\n", "jE8oZ9qTqrY=\n"));
                if (C2630m.m5645b(c2630m)) {
                    c2630m.m5650f();
                    return;
                }
                Spark.m6678t0(1, c2630m.f9146a.getString(R.string.login_error_msg) + AbstractC0032a.m165s("oQ==\n", "ldpx5Ha01FE=\n"));
                AbstractC3331m.m6762l(AbstractC2440g.f8552a);
                Spark.f11002X1.sendEmptyMessage(10);
                C2630m.m5646c(c2630m, AbstractC0032a.m165s("rw==\n", "m4FYO00pGEk=\n"));
                return;
            case 2:
                Spark.f11002X1.sendEmptyMessage(22);
                return;
            default:
                String strM165s4 = AbstractC0032a.m165s("9fmKP6VcaubP9ZI7\n", "u5z+SMouAbM=\n");
                String strM165s5 = AbstractC0032a.m165s("fZU19mYpQndIky/hIz5TbUraLvZwP1V9W4ko/nYmFmxbiSv3bTlTJB6fKepsOA==\n", "PvpbmANKNh4=\n");
                boolean z11 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s4, strM165s5);
                ((InterfaceC3328j) obj).mo5965b(AbstractC0032a.m165s("II1sTZ3ZdzBL0TA=\n", "Zf8eIu/5RRA=\n"));
                return;
        }
    }

    @Override
    public final void onSuccess(Response response) {
        int i6 = 1;
        switch (this.f9105a) {
            case 0:
                String strM165s = AbstractC0032a.m165s("R0hi+UYa6Jlp\n", "BRshkSd0hvw=\n");
                String strM165s2 = AbstractC0032a.m165s("5fpjzKPpEMbs+nvMpvMexaLscp625AOI7fQ=\n", "gp8X7MCBcag=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, strM165s2);
                String str = (String) response.body();
                ((C2621d) this.f9106b).getClass();
                new C2081i0(i6, str).start();
                Spark.f11008d2.m5311g(AbstractC0032a.m165s("ESHco+txmQ==\n", "ckm9zYUU9WI=\n"));
                C2340c c2340c = Spark.f11008d2;
                String strM165s3 = AbstractC0032a.m165s("TyEJqw0Xvw==\n", "LEloxWNy0xk=\n");
                String str2 = (String) response.body();
                int i10 = AbstractC2442h.f8601g / 1000;
                c2340c.getClass();
                new C2338a(c2340c, strM165s3, AbstractC3281e.m6624n(i10) + str2).start();
                return;
            case 1:
                boolean zIsSuccessful = response.isSuccessful();
                C2630m c2630m = (C2630m) this.f9106b;
                if (!zIsSuccessful) {
                    String strM165s4 = AbstractC0032a.m165s("wYybp+gX\n", "g9/O1I1laOE=\n");
                    String str3 = AbstractC0032a.m165s("fED3NbQJ5wpgFIQuuB6iEGB90SO0D/EKdVvIYA==\n", "Ey6kQNdqgnk=\n") + response.headers() + AbstractC0032a.m165s("WhjB\n", "dzXspZDSYBQ=\n") + ((String) response.body());
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s4, str3);
                    C2630m.m5644a(c2630m, AbstractC0032a.m165s("Pw==\n", "DQqJblo5ns0=\n"));
                    if (C2630m.m5645b(c2630m)) {
                        c2630m.m5650f();
                        return;
                    }
                    Spark.m6678t0(1, c2630m.f9146a.getString(R.string.login_error_msg) + AbstractC0032a.m165s("bQ==\n", "Xy0oxgoPqzE=\n"));
                    AbstractC3331m.m6762l(AbstractC2440g.f8552a);
                    Spark.f11002X1.sendEmptyMessage(10);
                    C2630m.m5646c(c2630m, AbstractC0032a.m165s("3w==\n", "7QuZWysXn/4=\n"));
                    return;
                }
                String strM165s5 = AbstractC0032a.m165s("9xE7l1sj\n", "tUJu5D5RfZY=\n");
                String str4 = AbstractC0032a.m165s("RO2ldWrFf1kD7qM6ZpB4VFH+tCcr32ARDrbx\n", "I4jRVQuwCzE=\n") + ((String) response.body());
                boolean z11 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s5, str4);
                String str5 = response.headers().get(AbstractC0032a.m165s("LKCoXA==\n", "aMHcOaUPvTI=\n"));
                Log.m5049i(AbstractC0032a.m165s("Aswm7LJM\n", "QJ9zn9c+JVE=\n"), AbstractC0032a.m165s("G0JrxaOxMdghSnyJ5g==\n", "SCcZs8bDEaw=\n") + str5);
                if (str5 != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AbstractC0032a.m165s("/OlXlC+GQqX04V+Ydptf/JnkWoJijxz2yoxo\n", "uawSuA/iJoU=\n"), Locale.US);
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(AbstractC0032a.m165s("8IDMUyiZ8f/4iKkGcYSokv2NsxJlx6LBlZ8=\n", "tcWJfwj90bI=\n"), Locale.getDefault());
                    try {
                        C2630m.f9144d = simpleDateFormat.parse(str5).getTime();
                        Log.m5049i(AbstractC0032a.m165s("ffeuFnab\n", "P6T7ZRPp90g=\n"), AbstractC0032a.m165s("DNeV56bk9Ao2w4Op4w==\n", "X67mk8OJ1H4=\n") + simpleDateFormat2.format(Long.valueOf(System.currentTimeMillis())));
                        if (Math.abs(C2630m.f9144d - System.currentTimeMillis()) > 600000) {
                            AbstractC3331m.f11243a = C2630m.f9144d - System.currentTimeMillis();
                            Log.m5049i(AbstractC0032a.m165s("smWdPPUB\n", "8DbIT5Bz378=\n"), AbstractC0032a.m165s("FGOMaBFAZbsdY/oc\n", "UCbAPFAfMfI=\n") + AbstractC3331m.m6767q((int) (AbstractC3331m.f11243a / 1000)));
                        }
                    } catch (ParseException unused) {
                        Log.m5049i(AbstractC0032a.m165s("e9t5P0Eu\n", "OYgsTCRchqA=\n"), AbstractC0032a.m165s("dKwPibiVgylo+HysuoSVP166P5mrgo81deI=\n", "G8Jc/Nv25lo=\n") + response.headers() + AbstractC0032a.m165s("GwOG\n", "Ni6rJyMNVD8=\n") + ((String) response.body()));
                        C2630m.m5644a(c2630m, AbstractC0032a.m165s("lw==\n", "pOmTjO8fjOE=\n"));
                        if (C2630m.m5645b(c2630m)) {
                            c2630m.m5650f();
                            return;
                        }
                        Spark.m6678t0(1, c2630m.f9146a.getString(R.string.login_error_msg) + AbstractC0032a.m165s("Qg==\n", "cdYxcLfHUlA=\n"));
                        AbstractC3331m.m6762l(AbstractC2440g.f8552a);
                        Spark.f11002X1.sendEmptyMessage(10);
                        C2630m.m5646c(c2630m, AbstractC0032a.m165s("gg==\n", "saPqZ1bTPUk=\n"));
                        return;
                    }
                    break;
                }
                C2630m.m5647d(c2630m, (String) response.body(), response.code());
                Log.m5049i(C2630m.f9143c, AbstractC0032a.m165s("jT1q34c0kbGCN37F00c=\n", "4VINtuln5NI=\n") + AbstractC0032a.m165s("Rg==\n", "ds2HGvLGp8M=\n") + AbstractC0032a.m165s("+rBCnQ==\n", "2p1vvayVkx8=\n") + c2630m.f9147b);
                c2630m.f9147b = 0;
                return;
            case 2:
                String strM165s6 = AbstractC0032a.m165s("YuKl7ADfoOlO35bv\n", "ILHzg2ScyIg=\n");
                String strM165s7 = AbstractC0032a.m165s("pZtg5gxQCYuqn3qoH1NNrrCReeYJWh++p4w0qRE=\n", "wv4Uxno/bcg=\n");
                boolean z12 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s6, strM165s7);
                C2632o c2632o = (C2632o) this.f9106b;
                String str6 = (String) response.body();
                c2632o.getClass();
                try {
                    try {
                        C2632o.f9153f = JSON.parseArray(str6, GroupBeanModel.class);
                        Collections.sort(C2632o.f9153f, new C0022e(4));
                        Iterator it = C2632o.f9153f.iterator();
                        while (it.hasNext()) {
                            Collections.sort(((GroupBeanModel) it.next()).items, new C2631n());
                        }
                        if (C2632o.f9153f != null) {
                            C2632o.m5653a();
                        }
                        AbstractC0032a.m165s("9JTP69XeFa7wlJ3u35pM4arbnQ==\n", "hPW9mLD+cc8=\n");
                        break;
                    } catch (Exception e5) {
                        String str7 = C2632o.f9148a;
                        String str8 = AbstractC0032a.m165s("NZpCHQoaA8chuFgPAVQQxGWfURoOGhDaN5RCT08=\n", "Rfswbm86dag=\n") + e5.toString();
                        boolean z13 = AbstractC3331m.f11244b;
                        Log.m5049i(str7, str8);
                    }
                    return;
                } finally {
                    Spark.f11002X1.sendEmptyMessage(22);
                }
            default:
                boolean zIsSuccessful2 = response.isSuccessful();
                InterfaceC3328j interfaceC3328j = (InterfaceC3328j) this.f9106b;
                if (zIsSuccessful2) {
                    interfaceC3328j.mo5964a(AbstractC0032a.m165s("hNI72mhp3A==\n", "y5kb9EZH/BM=\n"));
                    return;
                }
                String strM165s8 = AbstractC0032a.m165s("74qHxbwn6tzVhp/B\n", "oe/zstNVgYk=\n");
                String str9 = AbstractC0032a.m165s("rA1cthULxyeZC0ahUBzWPZtCR7YDHdAtihFBvgUEkzyKEUK3HhvWdM9CH/gzB9cr1UI=\n", "72Iy2HBos04=\n") + response.code();
                boolean z14 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s8, str9);
                interfaceC3328j.mo5965b(AbstractC0032a.m165s("2GzlrRW0EiqzMLk=\n", "nR6XwmeUIwo=\n"));
                return;
        }
    }
}
