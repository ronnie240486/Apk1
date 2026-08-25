package p275z9;

public final class C4362d extends AbstractC4365g {

    public static final C4362d f14824d;

    static {
        int i6 = AbstractC4368j.f14832c;
        int i10 = AbstractC4368j.f14833d;
        long j10 = AbstractC4368j.f14834e;
        String str = AbstractC4368j.f14830a;
        C4362d c4362d = new C4362d();
        c4362d.f14826c = new ExecutorC4360b(i6, i10, j10, str);
        f14824d = c4362d;
    }

    @Override
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override
    public final String toString() {
        return "Dispatchers.Default";
    }
}
