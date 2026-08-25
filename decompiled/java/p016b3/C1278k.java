package p016b3;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import p186r3.AbstractC3602f;
import p228v2.InterfaceC3978e;

public final class C1278k implements InterfaceC3978e {

    public final C1282o f4032b;

    public final URL f4033c;

    public final String f4034d;

    public String f4035e;

    public URL f4036f;

    public volatile byte[] f4037g;

    public int f4038h;

    public C1278k(URL url) {
        C1282o c1282o = InterfaceC1279l.f4039a;
        AbstractC3602f.m7225c(url, "Argument must not be null");
        this.f4033c = url;
        this.f4034d = null;
        AbstractC3602f.m7225c(c1282o, "Argument must not be null");
        this.f4032b = c1282o;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        if (this.f4037g == null) {
            this.f4037g = m3161c().getBytes(InterfaceC3978e.f13509a);
        }
        messageDigest.update(this.f4037g);
    }

    public final String m3161c() {
        String str = this.f4034d;
        if (str != null) {
            return str;
        }
        URL url = this.f4033c;
        AbstractC3602f.m7225c(url, "Argument must not be null");
        return url.toString();
    }

    public final String m3162d() {
        if (TextUtils.isEmpty(this.f4035e)) {
            String string = this.f4034d;
            if (TextUtils.isEmpty(string)) {
                URL url = this.f4033c;
                AbstractC3602f.m7225c(url, "Argument must not be null");
                string = url.toString();
            }
            this.f4035e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f4035e;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C1278k)) {
            return false;
        }
        C1278k c1278k = (C1278k) obj;
        return m3161c().equals(c1278k.m3161c()) && this.f4032b.equals(c1278k.f4032b);
    }

    @Override
    public final int hashCode() {
        if (this.f4038h == 0) {
            int iHashCode = m3161c().hashCode();
            this.f4038h = iHashCode;
            this.f4038h = this.f4032b.f4042b.hashCode() + (iHashCode * 31);
        }
        return this.f4038h;
    }

    public final String toString() {
        return m3161c();
    }

    public C1278k(String str) {
        C1282o c1282o = InterfaceC1279l.f4039a;
        this.f4033c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f4034d = str;
            AbstractC3602f.m7225c(c1282o, "Argument must not be null");
            this.f4032b = c1282o;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
