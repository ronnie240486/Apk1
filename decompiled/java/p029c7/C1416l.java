package p029c7;

public final class C1416l extends AbstractC1418n {

    public final int f4307j;

    public C1416l(ConcurrentMapC1404b0 concurrentMapC1404b0, int i6) {
        super(concurrentMapC1404b0);
        this.f4307j = i6;
    }

    @Override
    public Object next() {
        switch (this.f4307j) {
            case 1:
                return m3311d().f4267a;
            case 2:
                return m3311d().f4268b;
            default:
                return super.next();
        }
    }
}
