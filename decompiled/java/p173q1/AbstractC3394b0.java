package p173q1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class AbstractC3394b0 extends AbstractC3397c0 {

    public final Object f11430a = new Object();

    public Executor f11431b;

    public InterfaceC3391a0 f11432c;

    public C3454w f11433d;

    public ArrayList f11434e;

    public String mo6887k() {
        return null;
    }

    public String mo6888l() {
        return null;
    }

    public final void m6889m(C3454w c3454w, ArrayList arrayList) {
        if (c3454w == null) {
            throw new NullPointerException("groupRoute must not be null");
        }
        synchronized (this.f11430a) {
            try {
                Executor executor = this.f11431b;
                if (executor != null) {
                    executor.execute(new RunnableC3458y(this, this.f11432c, c3454w, arrayList, 0));
                } else {
                    this.f11433d = c3454w;
                    this.f11434e = new ArrayList(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void mo6890n(String str);

    public abstract void mo6891o(String str);

    public abstract void mo6892p(List list);

    public final void m6893q(Executor executor, InterfaceC3391a0 interfaceC3391a0) {
        synchronized (this.f11430a) {
            try {
                if (executor == null) {
                    throw new NullPointerException("Executor shouldn't be null");
                }
                if (interfaceC3391a0 == null) {
                    throw new NullPointerException("Listener shouldn't be null");
                }
                this.f11431b = executor;
                this.f11432c = interfaceC3391a0;
                ArrayList arrayList = this.f11434e;
                if (arrayList != null && !arrayList.isEmpty()) {
                    C3454w c3454w = this.f11433d;
                    ArrayList arrayList2 = this.f11434e;
                    this.f11433d = null;
                    this.f11434e = null;
                    this.f11431b.execute(new RunnableC3458y(this, interfaceC3391a0, c3454w, arrayList2, 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
