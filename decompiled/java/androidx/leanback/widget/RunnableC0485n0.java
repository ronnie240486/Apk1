package androidx.leanback.widget;

import com.google.android.material.navigation.AbstractC1844d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import p001a0.C0019b;
import p003a2.AbstractC0032a;
import p014b1.AbstractC1233g;
import p046e0.AbstractC2343b;
import p230v4.C4008v;
import p271z4.C4343n;

public final class RunnableC0485n0 implements Runnable {

    public final int f2371a;

    public final int f2372b;

    public final Object f2373c;

    public RunnableC0485n0(int i6, int i10, Object obj) {
        this.f2371a = i10;
        this.f2373c = obj;
        this.f2372b = i6;
    }

    @Override
    public final void run() {
        Runnable runnable;
        switch (this.f2371a) {
            case 0:
                SearchBar searchBar = (SearchBar) this.f2373c;
                searchBar.f2243t.play(searchBar.f2244u.get(this.f2372b), 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case 1:
                ArrayList arrayList = (ArrayList) this.f2373c;
                int size = arrayList.size();
                int i6 = 0;
                if (this.f2372b != 1) {
                    while (i6 < size) {
                        ((AbstractC1233g) arrayList.get(i6)).mo700a();
                        i6++;
                    }
                } else {
                    while (i6 < size) {
                        ((AbstractC1233g) arrayList.get(i6)).mo701b();
                        i6++;
                    }
                }
                break;
            case 2:
                ((AbstractC1844d) this.f2373c).m4296g(this.f2372b);
                break;
            case 3:
                for (int i10 = 0; i10 < this.f2372b && (runnable = (Runnable) ((LinkedBlockingQueue) this.f2373c).poll()) != null; i10++) {
                    runnable.run();
                }
                break;
            case 4:
                AbstractC2343b abstractC2343b = (AbstractC2343b) ((C0019b) this.f2373c).f38b;
                if (abstractC2343b != null) {
                    abstractC2343b.mo757i(this.f2372b);
                }
                break;
            case 5:
                ((C4008v) this.f2373c).f13577B.m3906c(this.f2372b);
                break;
            default:
                ((C4343n) this.f2373c).m8373h(this.f2372b);
                break;
        }
    }

    public RunnableC0485n0(int i6, LinkedBlockingQueue linkedBlockingQueue) {
        this.f2371a = 3;
        this.f2372b = i6;
        this.f2373c = linkedBlockingQueue;
    }

    public RunnableC0485n0(List list, int i6, Throwable th) {
        this.f2371a = 1;
        AbstractC0032a.m162p(list, "initCallbacks cannot be null");
        this.f2373c = new ArrayList(list);
        this.f2372b = i6;
    }
}
