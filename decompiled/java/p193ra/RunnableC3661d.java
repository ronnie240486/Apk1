package p193ra;

import p003a2.AbstractC0032a;
import p055ea.C2441g0;
import p055ea.HandlerC2468u;

public final class RunnableC3661d implements Runnable {

    public final int f12260a;

    public final C2441g0 f12261b;

    public RunnableC3661d(C2441g0 c2441g0, int i6) {
        this.f12260a = i6;
        this.f12261b = c2441g0;
    }

    @Override
    public final void run() {
        switch (this.f12260a) {
            case 0:
                C2441g0 c2441g0 = this.f12261b;
                if (c2441g0.f8568b) {
                    int i6 = c2441g0.f8576j;
                    if (i6 == 2) {
                        c2441g0.f8574h += c2441g0.f8575i;
                        c2441g0.f8576j = 0;
                    } else {
                        c2441g0.f8576j = i6 + 1;
                    }
                    long j10 = c2441g0.f8570d - ((long) (c2441g0.f8574h * 1000));
                    c2441g0.f8570d = j10;
                    if (j10 < 0) {
                        c2441g0.f8570d = 0L;
                    }
                    AbstractC0032a.m165s("c9eKLgyXJrdv3JwlDpZUsHTcx2c=\n", "AbL9R2LzdMI=\n");
                    AbstractC0032a.m165s("g6wx+Q==\n", "roEc1E+QvZ0=\n");
                    c2441g0.m5484b(c2441g0.f8570d);
                    HandlerC2468u handlerC2468u = c2441g0.f8571e;
                    handlerC2468u.removeCallbacks(this);
                    handlerC2468u.postDelayed(this, 100L);
                }
                break;
            default:
                C2441g0 c2441g1 = this.f12261b;
                if (c2441g1.f8569c) {
                    int i10 = c2441g1.f8576j;
                    if (i10 == 2) {
                        c2441g1.f8574h += c2441g1.f8575i;
                        c2441g1.f8576j = 0;
                    } else {
                        c2441g1.f8576j = i10 + 1;
                    }
                    long j11 = c2441g1.f8570d + ((long) (c2441g1.f8574h * 1000));
                    c2441g1.f8570d = j11;
                    long j12 = c2441g1.f8573g;
                    if (j11 > j12) {
                        c2441g1.f8570d = j12;
                    }
                    c2441g1.m5484b(c2441g1.f8570d);
                    AbstractC0032a.m165s("1SNfef24P+jSMEhfzrkj/tEuSS3JoiOlkw==\n", "s0IsDbvXTZ8=\n");
                    AbstractC0032a.m165s("IGhC4Q==\n", "DUVvzNMW6aA=\n");
                    HandlerC2468u handlerC2468u2 = c2441g1.f8571e;
                    handlerC2468u2.removeCallbacks(this);
                    handlerC2468u2.postDelayed(this, 100L);
                }
                break;
        }
    }
}
