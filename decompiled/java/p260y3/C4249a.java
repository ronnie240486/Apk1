package p260y3;

import com.bumptech.glide.AbstractC1466d;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p005a4.InterfaceC0054m;
import p248x3.C4106b;

public final class C4249a implements InterfaceC0054m {

    public static final String f14434c;

    public static final Set f14435d;

    public static final C4249a f14436e;

    public final String f14437a;

    public final String f14438b;

    static {
        String strM3503w = AbstractC1466d.m3503w("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f14434c = strM3503w;
        AbstractC1466d.m3503w("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        AbstractC1466d.m3503w("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f14435d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C4106b("proto"), new C4106b("json"))));
        f14436e = new C4249a(strM3503w, null);
    }

    public C4249a(String str, String str2) {
        this.f14437a = str;
        this.f14438b = str2;
    }

    public static C4249a m8301a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new C4249a(str2, str3);
    }
}
