package p187r4;

import android.util.LruCache;
import java.util.ArrayList;
import p018b5.AbstractC1312l;

public final class C3634x extends LruCache {

    public final C3611a f12203a;

    public C3634x(C3611a c3611a) {
        super(20);
        this.f12203a = c3611a;
    }

    @Override
    public final void entryRemoved(boolean z7, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        if (z7) {
            ArrayList arrayList = this.f12203a.f12121g;
            AbstractC1312l.m3198e(arrayList);
            arrayList.add(num);
        }
    }
}
