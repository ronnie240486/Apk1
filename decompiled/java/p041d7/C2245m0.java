package p041d7;

import java.util.Comparator;

public final class C2245m0 extends AbstractC2259o0 {
    public static AbstractC2259o0 m5243g(int i6) {
        if (i6 < 0) {
            return AbstractC2259o0.f8012b;
        }
        return i6 > 0 ? AbstractC2259o0.f8013c : AbstractC2259o0.f8011a;
    }

    @Override
    public final AbstractC2259o0 mo5244a(int i6, int i10) {
        return m5243g(Integer.compare(i6, i10));
    }

    @Override
    public final AbstractC2259o0 mo5245b(long j10, long j11) {
        return m5243g(Long.compare(j10, j11));
    }

    @Override
    public final AbstractC2259o0 mo5246c(Object obj, Object obj2, Comparator comparator) {
        return m5243g(comparator.compare(obj, obj2));
    }

    @Override
    public final AbstractC2259o0 mo5247d(boolean z7, boolean z10) {
        return m5243g(Boolean.compare(z7, z10));
    }

    @Override
    public final AbstractC2259o0 mo5248e(boolean z7, boolean z10) {
        return m5243g(Boolean.compare(z10, z7));
    }

    @Override
    public final int mo5249f() {
        return 0;
    }
}
