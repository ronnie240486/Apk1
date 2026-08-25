package p041d7;

import p029c7.AbstractC1418n;

public final class C2185d3 extends AbstractC1418n {

    public final int f7868j;

    public C2185d3(ConcurrentMapC2179c4 concurrentMapC2179c4, int i6) {
        super(concurrentMapC2179c4);
        this.f7868j = i6;
    }

    @Override
    public Object next() {
        switch (this.f7868j) {
            case 1:
                return m3312e().f7837a;
            case 2:
                return m3312e().f7838b;
            default:
                return super.next();
        }
    }
}
