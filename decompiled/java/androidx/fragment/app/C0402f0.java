package androidx.fragment.app;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import java.util.ArrayList;
import java.util.Iterator;
import p003a2.AbstractC0032a;
import p243w8.C4064f;
import p253x8.AbstractC4146i;
import p253x8.AbstractC4149l;
import p253x8.AbstractC4158u;
import p253x8.C4156s;

public final class C0402f0 extends AbstractC0032a {

    public final int f1842b;

    public C0402f0(int i6) {
        this.f1842b = i6;
    }

    @Override
    public final Object mo176J(Intent intent, int i6) {
        switch (this.f1842b) {
            case 0:
                return new ActivityResult(intent, i6);
            case 1:
                C4156s c4156s = C4156s.f14075a;
                if (i6 != -1 || intent == null) {
                    return c4156s;
                }
                String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra == null || stringArrayExtra == null) {
                    return c4156s;
                }
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i10 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i10 == 0));
                }
                ArrayList arrayListM8177J = AbstractC4146i.m8177J(stringArrayExtra);
                Iterator it = arrayListM8177J.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(AbstractC4149l.m8193Q(arrayListM8177J), AbstractC4149l.m8193Q(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new C4064f(it.next(), it2.next()));
                }
                return AbstractC4158u.m8197q(arrayList2);
            default:
                return new ActivityResult(intent, i6);
        }
    }
}
