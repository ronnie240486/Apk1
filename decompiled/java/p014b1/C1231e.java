package p014b1;

import androidx.leanback.widget.RunnableC0485n0;
import java.util.ArrayList;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p221u6.C3905e;

public final class C1231e extends AbstractC0032a {

    public final C1232f f3918b;

    public C1231e(C1232f c1232f) {
        this.f3918b = c1232f;
    }

    @Override
    public final void mo174H(Throwable th) {
        this.f3918b.f3919a.m3109d(th);
    }

    @Override
    public final void mo175I(C0023f c0023f) {
        C1232f c1232f = this.f3918b;
        c1232f.f3921c = c0023f;
        c1232f.f3920b = new C0069f(c1232f.f3921c, new C3905e(3), c1232f.f3919a.f3931h);
        C1235i c1235i = c1232f.f3919a;
        c1235i.getClass();
        ArrayList arrayList = new ArrayList();
        c1235i.f3924a.writeLock().lock();
        try {
            c1235i.f3926c = 1;
            arrayList.addAll(c1235i.f3925b);
            c1235i.f3925b.clear();
            c1235i.f3924a.writeLock().unlock();
            c1235i.f3927d.post(new RunnableC0485n0(arrayList, c1235i.f3926c, (Throwable) null));
        } catch (Throwable th) {
            c1235i.f3924a.writeLock().unlock();
            throw th;
        }
    }
}
