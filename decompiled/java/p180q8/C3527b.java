package p180q8;

public final class C3527b {

    public final int f11892a;

    public final C3528c[] f11893b;

    public long f11894c;

    public C3527b(int i6, ThreadFactoryC3536k threadFactoryC3536k) {
        this.f11892a = i6;
        this.f11893b = new C3528c[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            this.f11893b[i10] = new C3528c(threadFactoryC3536k);
        }
    }
}
