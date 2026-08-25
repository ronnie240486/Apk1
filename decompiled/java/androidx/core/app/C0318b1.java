package androidx.core.app;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.Objects;

public final class C0318b1 {

    public CharSequence f1481a;

    public IconCompat f1482b;

    public String f1483c;

    public String f1484d;

    public boolean f1485e;

    public boolean f1486f;

    public static C0318b1 m948a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        CharSequence charSequence = bundle.getCharSequence(SerializableCookie.NAME);
        IconCompat iconCompatM1084b = bundle2 != null ? IconCompat.m1084b(bundle2) : null;
        String string = bundle.getString("uri");
        String string2 = bundle.getString(CacheEntity.KEY);
        boolean z7 = bundle.getBoolean("isBot");
        boolean z10 = bundle.getBoolean("isImportant");
        C0318b1 c0318b1 = new C0318b1();
        c0318b1.f1481a = charSequence;
        c0318b1.f1482b = iconCompatM1084b;
        c0318b1.f1483c = string;
        c0318b1.f1484d = string2;
        c0318b1.f1485e = z7;
        c0318b1.f1486f = z10;
        return c0318b1;
    }

    public final Bundle m949b() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(SerializableCookie.NAME, this.f1481a);
        IconCompat iconCompat = this.f1482b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.m1095m() : null);
        bundle.putString("uri", this.f1483c);
        bundle.putString(CacheEntity.KEY, this.f1484d);
        bundle.putBoolean("isBot", this.f1485e);
        bundle.putBoolean("isImportant", this.f1486f);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0318b1)) {
            return false;
        }
        C0318b1 c0318b1 = (C0318b1) obj;
        String str = this.f1484d;
        String str2 = c0318b1.f1484d;
        if (str == null && str2 == null) {
            return Objects.equals(Objects.toString(this.f1481a), Objects.toString(c0318b1.f1481a)) && Objects.equals(this.f1483c, c0318b1.f1483c) && Boolean.valueOf(this.f1485e).equals(Boolean.valueOf(c0318b1.f1485e)) && Boolean.valueOf(this.f1486f).equals(Boolean.valueOf(c0318b1.f1486f));
        }
        return Objects.equals(str, str2);
    }

    public final int hashCode() {
        String str = this.f1484d;
        if (str != null) {
            return str.hashCode();
        }
        return Objects.hash(this.f1481a, this.f1483c, Boolean.valueOf(this.f1485e), Boolean.valueOf(this.f1486f));
    }
}
