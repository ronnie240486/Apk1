package p014b1;

import java.util.concurrent.ThreadPoolExecutor;
import p001a0.C0023f;
import p003a2.AbstractC0032a;

public final class C1237k extends AbstractC0032a {

    public final AbstractC0032a f3934b;

    public final ThreadPoolExecutor f3935c;

    public C1237k(AbstractC0032a abstractC0032a, ThreadPoolExecutor threadPoolExecutor) {
        this.f3934b = abstractC0032a;
        this.f3935c = threadPoolExecutor;
    }

    @Override
    public final void mo174H(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f3935c;
        try {
            this.f3934b.mo174H(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override
    public final void mo175I(C0023f c0023f) {
        ThreadPoolExecutor threadPoolExecutor = this.f3935c;
        try {
            this.f3934b.mo175I(c0023f);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
