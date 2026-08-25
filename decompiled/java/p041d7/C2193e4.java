package p041d7;

import java.util.Map;
import p001a0.C0019b;
import p020b7.InterfaceC1346i;

public final class C2193e4 implements InterfaceC1346i {

    public final C0019b f7883a;

    public C2193e4(C0019b c0019b) {
        this.f7883a = c0019b;
    }

    @Override
    public final Object apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        C0019b c0019b = this.f7883a;
        c0019b.getClass();
        entry.getClass();
        return new C2186d4(entry, c0019b);
    }
}
