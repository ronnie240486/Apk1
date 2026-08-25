package p222u7;

import com.tencent.mars.xlog.Log;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import org.bitspark.android.utils.AbstractC3331m;
import p055ea.AbstractC2460q;
import p187r4.C3624n;
import p233v7.AbstractC4017d;
import p252x7.C4137a;

public final class C3925a {

    public final InterfaceC3927c[] f13214a;

    public final C4137a f13215b;

    public final C3624n f13216c;

    public final C3929e f13217d;

    public volatile C3929e f13218e;

    public C3925a(InterfaceC3927c[] interfaceC3927cArr) {
        C3929e c3929e = C3929e.f13222a;
        this.f13216c = new C3624n(7);
        this.f13218e = null;
        this.f13218e = c3929e;
        this.f13214a = (InterfaceC3927c[]) interfaceC3927cArr.clone();
        C4137a c4137a = new C4137a(256, 1.0f, true);
        c4137a.f14062a = 256;
        this.f13215b = c4137a;
        C3929e c3929e2 = new C3929e();
        new AtomicInteger();
        this.f13217d = c3929e2;
    }

    public static C3930f[] m7837a(C3930f[] c3930fArr) {
        String str;
        if (c3930fArr == null || c3930fArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(c3930fArr.length);
        for (C3930f c3930f : c3930fArr) {
            if (c3930f != null && (str = c3930f.f13223a) != null && str.length() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                int i6 = c3930f.f13225c;
                if (i6 == -1 || c3930f.f13226d + ((long) i6) >= jCurrentTimeMillis) {
                    arrayList.add(c3930f);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (C3930f[]) arrayList.toArray(new C3930f[arrayList.size()]);
    }

    public final C3930f[] m7838b(String str) throws IOException {
        C3930f[] c3930fArrM7837a;
        int i6;
        int i10;
        int iIndexOf;
        int i11;
        int iIndexOf2;
        C3926b c3926b = new C3926b(str, 0);
        if (str == null || str.trim().length() == 0) {
            throw new IOException(AbstractC2460q.m5501o("empty domain ", str));
        }
        if (str.length() >= 7 && str.length() <= 15 && !str.contains("-")) {
            try {
                int iIndexOf3 = str.indexOf(46);
                if ((iIndexOf3 == -1 || Integer.parseInt(str.substring(0, iIndexOf3)) <= 255) && (((iIndexOf = str.indexOf(46, (i10 = iIndexOf3 + 1))) == -1 || Integer.parseInt(str.substring(i10, iIndexOf)) <= 255) && ((iIndexOf2 = str.indexOf(46, (i11 = iIndexOf + 1))) == -1 || Integer.parseInt(str.substring(i11, iIndexOf2)) <= 255 || Integer.parseInt(str.substring(iIndexOf2 + 1, str.length() - 1)) <= 255 || str.charAt(str.length() - 1) == '.'))) {
                    return new C3930f[]{new C3930f(str, new Date().getTime())};
                }
            } catch (NumberFormatException unused) {
            }
        }
        synchronized (this.f13215b) {
            try {
                if (this.f13218e.equals(C3929e.f13222a) && AbstractC3928d.m7857u()) {
                    this.f13215b.clear();
                    synchronized (this.f13214a) {
                    }
                } else {
                    c3930fArrM7837a = m7837a((C3930f[]) this.f13215b.get(c3926b.f13220b));
                    if (c3930fArrM7837a != null && c3930fArrM7837a.length > 0) {
                        this.f13215b.size();
                    }
                }
                C3930f[] c3930fArrM8007b = null;
                IOException e5 = null;
                int i12 = 0;
                while (true) {
                    InterfaceC3927c[] interfaceC3927cArr = this.f13214a;
                    if (i12 >= interfaceC3927cArr.length) {
                        break;
                    }
                    int length = i12 % interfaceC3927cArr.length;
                    C3929e c3929e = this.f13218e;
                    try {
                        String str2 = "doh resolver resolve[0]:" + c3926b.f13220b + " " + i12 + "/" + this.f13214a.length;
                        boolean z7 = AbstractC3331m.f11244b;
                        Log.m5049i("DNSMgr", str2);
                        c3930fArrM8007b = ((AbstractC4017d) this.f13214a[length]).m8007b(c3926b);
                    } catch (IOException e10) {
                        e5 = e10;
                        String str3 = "doh resolver resolve[4]:" + c3926b.f13220b + " from:" + this.f13214a[length] + " " + e5;
                        boolean z10 = AbstractC3331m.f11244b;
                        Log.m5049i("DNSMgr", str3);
                    } catch (Exception e11) {
                        String str4 = "doh resolver resolve[6]:" + c3926b + " from:" + this.f13214a[length] + " " + e11;
                        boolean z11 = AbstractC3331m.f11244b;
                        Log.m5049i("DNSMgr", str4);
                        e5 = new IOException(e11);
                    }
                    if (this.f13218e != c3929e || (c3930fArrM8007b != null && c3930fArrM8007b.length != 0)) {
                        break;
                    }
                    i12++;
                }
                if (c3930fArrM8007b == null || c3930fArrM8007b.length == 0) {
                    boolean z12 = AbstractC3331m.f11244b;
                    Log.m5049i("DNSMgr", "doh resolver resolve[8]: null ");
                    c3930fArrM7837a = m7837a(this.f13216c.m7341h(c3926b));
                    if (c3930fArrM7837a == null || c3930fArrM7837a.length == 0) {
                        if (e5 == null) {
                            throw new UnknownHostException(c3926b.f13220b);
                        }
                        throw e5;
                    }
                } else {
                    ArrayList arrayList = new ArrayList(c3930fArrM8007b.length);
                    for (C3930f c3930f : c3930fArrM8007b) {
                        if (c3930f != null && ((i6 = c3930f.f13224b) == 1 || i6 == 28)) {
                            arrayList.add(c3930f);
                        }
                    }
                    c3930fArrM7837a = (C3930f[]) arrayList.toArray(new C3930f[arrayList.size()]);
                    if (c3930fArrM7837a.length == 0) {
                        throw new UnknownHostException("no A/AAAA records");
                    }
                    synchronized (this.f13215b) {
                        this.f13215b.put(c3926b.f13220b, c3930fArrM7837a);
                    }
                    String str5 = "doh resolver resolve[9]:" + c3926b.f13220b + " " + c3930fArrM7837a.length;
                    boolean z13 = AbstractC3331m.f11244b;
                    Log.m5049i("DNSMgr", str5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f13217d.getClass();
        return c3930fArrM7837a;
    }
}
