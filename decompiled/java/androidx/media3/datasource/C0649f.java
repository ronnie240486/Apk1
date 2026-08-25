package androidx.media3.datasource;

import java.util.Map;
import p020b7.InterfaceC1354n;

public final class C0649f implements InterfaceC1354n {

    public final int f2675a;

    public C0649f(int i6) {
        this.f2675a = i6;
    }

    @Override
    public final boolean apply(Object obj) {
        switch (this.f2675a) {
            case 0:
                return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$entrySet$1((Map.Entry) obj);
            case 1:
                return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$keySet$0((String) obj);
            default:
                return AbstractC0650g.m1781a((String) obj);
        }
    }
}
