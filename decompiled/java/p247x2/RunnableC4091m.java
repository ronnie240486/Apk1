package p247x2;

import p141n3.C3192f;
import p186r3.AbstractC3602f;

public final class RunnableC4091m implements Runnable {

    public final int f13841a;

    public final C3192f f13842b;

    public final C4094p f13843c;

    public RunnableC4091m(C4094p c4094p, C3192f c3192f, int i6) {
        this.f13841a = i6;
        this.f13843c = c4094p;
        this.f13842b = c3192f;
    }

    private final void m8103a() {
        C3192f c3192f = this.f13842b;
        c3192f.f10716b.m7468a();
        synchronized (c3192f.f10717c) {
            synchronized (this.f13843c) {
                try {
                    C4093o c4093o = this.f13843c.f13848a;
                    C3192f c3192f2 = this.f13842b;
                    c4093o.getClass();
                    if (c4093o.f13846a.contains(new C4092n(c3192f2, AbstractC3602f.f12099b))) {
                        C4094p c4094p = this.f13843c;
                        C3192f c3192f3 = this.f13842b;
                        c4094p.getClass();
                        try {
                            c3192f3.m6415j(c4094p.f13864q, 5);
                        } catch (Throwable th) {
                            throw new C4080b(th);
                        }
                    }
                    this.f13843c.m8106d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override
    public final void run() {
        switch (this.f13841a) {
            case 0:
                m8103a();
                return;
            default:
                C3192f c3192f = this.f13842b;
                c3192f.f10716b.m7468a();
                synchronized (c3192f.f10717c) {
                    synchronized (this.f13843c) {
                        try {
                            C4093o c4093o = this.f13843c.f13848a;
                            C3192f c3192f2 = this.f13842b;
                            c4093o.getClass();
                            if (c4093o.f13846a.contains(new C4092n(c3192f2, AbstractC3602f.f12099b))) {
                                this.f13843c.f13866s.m8114b();
                                C4094p c4094p = this.f13843c;
                                C3192f c3192f3 = this.f13842b;
                                c4094p.getClass();
                                try {
                                    c3192f3.m6416k(c4094p.f13866s, c4094p.f13862o, c4094p.f13869v);
                                    this.f13843c.m8112j(this.f13842b);
                                } catch (Throwable th) {
                                    throw new C4080b(th);
                                }
                            }
                            this.f13843c.m8106d();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
