package p187r4;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.TimerTask;
import p018b5.AbstractC1312l;
import p230v4.AbstractC3987a;
import p230v4.C3988b;

public final class C3627q extends TimerTask {

    public final int f12187a;

    public final Object f12188b;

    public C3627q(int i6, Object obj) {
        this.f12187a = i6;
        this.f12188b = obj;
    }

    @Override
    public final void run() {
        BasePendingResult basePendingResultM7290x;
        Object obj = this.f12188b;
        switch (this.f12187a) {
            case 0:
                C3628r c3628r = (C3628r) obj;
                C3616f c3616f = c3628r.f12193e;
                HashSet hashSet = c3628r.f12189a;
                C3988b c3988b = C3616f.f12147k;
                c3616f.m7295E(hashSet);
                c3616f.f12149b.postDelayed(this, c3628r.f12190b);
                break;
            default:
                C3611a c3611a = (C3611a) obj;
                ArrayDeque arrayDeque = c3611a.f12122h;
                if (!arrayDeque.isEmpty() && c3611a.f12125k == null && c3611a.f12116b != 0) {
                    int[] iArrM7973f = AbstractC3987a.m7973f(arrayDeque);
                    C3616f c3616f2 = c3611a.f12117c;
                    c3616f2.getClass();
                    AbstractC1312l.m3195b("Must be called from the main thread.");
                    if (c3616f2.m7296F()) {
                        C3619i c3619i = new C3619i(c3616f2, iArrM7973f);
                        C3616f.m7289G(c3619i);
                        basePendingResultM7290x = c3619i;
                    } else {
                        basePendingResultM7290x = C3616f.m7290x();
                    }
                    c3611a.f12125k = basePendingResultM7290x;
                    basePendingResultM7290x.m3644h0(new C3633w(c3611a, 1));
                    arrayDeque.clear();
                }
                break;
        }
    }
}
