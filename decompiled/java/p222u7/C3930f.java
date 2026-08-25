package p222u7;

import com.youth.banner.config.BannerConfig;
import java.util.Locale;

public final class C3930f {

    public final String f13223a;

    public final int f13224b;

    public final int f13225c;

    public final long f13226d;

    public final int f13227e;

    public final String f13228f;

    public C3930f(String str, long j10) {
        this.f13223a = str;
        this.f13224b = 1;
        this.f13225c = Math.max(-1, BannerConfig.SCROLL_TIME);
        this.f13226d = j10;
        this.f13227e = 0;
        this.f13228f = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C3930f)) {
            return false;
        }
        C3930f c3930f = (C3930f) obj;
        return this.f13223a.equals(c3930f.f13223a) && this.f13224b == c3930f.f13224b && this.f13225c == c3930f.f13225c && this.f13226d == c3930f.f13226d;
    }

    public final String toString() {
        return String.format(Locale.getDefault(), "{type:%s, value:%s, source:%s, server:%s, timestamp:%d, ttl:%d}", Integer.valueOf(this.f13224b), this.f13223a, Integer.valueOf(this.f13227e), this.f13228f, Long.valueOf(this.f13226d), Integer.valueOf(this.f13225c));
    }

    public C3930f(String str, int i6, int i10, long j10, int i11, String str2) {
        this.f13223a = str;
        this.f13224b = i6;
        this.f13225c = i10 < 600 ? BannerConfig.SCROLL_TIME : i10;
        this.f13226d = j10;
        this.f13227e = i11;
        this.f13228f = str2;
    }
}
