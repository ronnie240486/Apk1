package p041d7;

import java.util.Map;
import p001a0.C0019b;
import p020b7.InterfaceC1346i;

public final class C2186d4 extends AbstractC2293t {

    public final Map.Entry f7869a;

    public final C0019b f7870b;

    public C2186d4(Map.Entry entry, C0019b c0019b) {
        this.f7869a = entry;
        this.f7870b = c0019b;
    }

    @Override
    public final Object getKey() {
        return this.f7869a.getKey();
    }

    @Override
    public final Object getValue() {
        Map.Entry entry = this.f7869a;
        entry.getKey();
        return ((InterfaceC1346i) this.f7870b.f38b).apply(entry.getValue());
    }
}
