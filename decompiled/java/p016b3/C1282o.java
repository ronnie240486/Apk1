package p016b3;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C1282o implements InterfaceC1279l {

    public final Map f4042b;

    public volatile Map f4043c;

    public C1282o(Map map) {
        this.f4042b = Collections.unmodifiableMap(map);
    }

    public final HashMap m3163a() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f4042b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                String str = ((C1281n) list.get(i6)).f4041a;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i6 != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put(entry.getKey(), string);
            }
        }
        return map;
    }

    public final Map m3164b() {
        if (this.f4043c == null) {
            synchronized (this) {
                try {
                    if (this.f4043c == null) {
                        this.f4043c = Collections.unmodifiableMap(m3163a());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4043c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1282o) {
            return this.f4042b.equals(((C1282o) obj).f4042b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4042b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f4042b + '}';
    }
}
