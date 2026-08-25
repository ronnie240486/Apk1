package p000a;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.C0392a0;
import androidx.media3.common.C0565C;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p022c.C1372a;

public final class C0006g {

    public Random f7a = new Random();

    public final HashMap f8b = new HashMap();

    public final HashMap f9c = new HashMap();

    public final HashMap f10d = new HashMap();

    public ArrayList f11e = new ArrayList();

    public final transient HashMap f12f = new HashMap();

    public final HashMap f13g = new HashMap();

    public final Bundle f14h = new Bundle();

    public C0006g(ComponentActivity componentActivity) {
    }

    public final boolean m33a(int i6, int i10, Intent intent) {
        String str = (String) this.f8b.get(Integer.valueOf(i6));
        if (str == null) {
            return false;
        }
        C1372a c1372a = (C1372a) this.f12f.get(str);
        if (c1372a != null) {
            C0392a0 c0392a0 = c1372a.f4186a;
            if (this.f11e.contains(str)) {
                c0392a0.m1196a(c1372a.f4187b.mo176J(intent, i10));
                this.f11e.remove(str);
                return true;
            }
        }
        this.f13g.remove(str);
        this.f14h.putParcelable(str, new ActivityResult(intent, i10));
        return true;
    }

    public final C0069f m34b(String str, AbstractC0032a abstractC0032a, C0392a0 c0392a0) {
        int i6;
        HashMap map;
        HashMap map2 = this.f9c;
        if (((Integer) map2.get(str)) == null) {
            int iNextInt = this.f7a.nextInt(2147418112);
            while (true) {
                i6 = iNextInt + C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
                map = this.f8b;
                if (!map.containsKey(Integer.valueOf(i6))) {
                    break;
                }
                iNextInt = this.f7a.nextInt(2147418112);
            }
            map.put(Integer.valueOf(i6), str);
            map2.put(str, Integer.valueOf(i6));
        }
        this.f12f.put(str, new C1372a(c0392a0, abstractC0032a));
        HashMap map3 = this.f13g;
        if (map3.containsKey(str)) {
            Object obj = map3.get(str);
            map3.remove(str);
            c0392a0.m1196a(obj);
        }
        Bundle bundle = this.f14h;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            c0392a0.m1196a(abstractC0032a.mo176J(activityResult.f242b, activityResult.f241a));
        }
        return new C0069f(this, str, abstractC0032a);
    }
}
