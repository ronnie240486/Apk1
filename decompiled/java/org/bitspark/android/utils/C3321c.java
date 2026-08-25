package org.bitspark.android.utils;

import com.nmmedit.protect.NativeUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dns;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p222u7.C3925a;
import p222u7.InterfaceC3927c;
import p233v7.C4020g;
import p233v7.C4021h;

public final class C3321c implements Dns {

    public static final String f11217b;

    public static final AtomicReference f11218c;

    public static final String[][] f11219d;

    public final C3925a f11220a;

    public C3321c() {
        boolean z7 = AbstractC2442h.f8591M;
        String[][] strArr = f11219d;
        this.f11220a = new C3925a(z7 ? new InterfaceC3927c[]{new C4021h(strArr[0]), new C4020g(strArr[1])} : new InterfaceC3927c[]{new C4021h(strArr[2])});
    }

    @Override
    public final native List lookup(String str);

    static {
        NativeUtil.classesInit0(15);
        f11217b = AbstractC0032a.m165s("ypvSguxNtQ==\n", "gu+m8qgjxg4=\n");
        f11218c = new AtomicReference(null);
        f11219d = new String[][]{new String[]{AbstractC0032a.m165s("Cdxxj4/BXphQhjTRzdVAmAXGdtKNjhTFGA==\n", "YagF//z7cbc=\n"), AbstractC0032a.m165s("JluR45gvK2MqQZa9jHprKyJKyveFZik9O0qX6g==\n", "Ti/lk+sVBEw=\n"), AbstractC0032a.m165s("c3/0fAT//P8iJbkiTuvq/39l8yEGsLaiYg==\n", "GwuADHfF09A=\n"), AbstractC0032a.m165s("dtozVrPlSSp6wDQIobsBcH/cIwuksRUrfcEqCaSxFShv2yJUuQ==\n", "Hq5HJsDfZgU=\n")}, new String[]{AbstractC0032a.m165s("2Vug+IC/oA==\n", "6HWR1rGRkSU=\n"), AbstractC0032a.m165s("luuBdjuEHA==\n", "rsW5WAOqJBw=\n"), AbstractC0032a.m165s("7cQWBhPIMQ==\n", "1OovKCrmCPA=\n")}, new String[]{AbstractC0032a.m165s("CGBOcxTjKnQEekktBrVsPw5nFGAItCo/DmcXchK8dyI=\n", "YBQ6A2fZBVs=\n")}};
    }
}
