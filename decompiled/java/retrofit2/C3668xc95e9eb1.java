package retrofit2;

import p091i9.InterfaceC2724l;
import p103j9.AbstractC2797j;
import p243w8.C4070l;

public final class C3668xc95e9eb1 extends AbstractC2797j implements InterfaceC2724l {
    final Call $this_awaitResponse$inlined;

    public C3668xc95e9eb1(Call call) {
        super(1);
        this.$this_awaitResponse$inlined = call;
    }

    @Override
    public Object invoke(Object obj) {
        invoke((Throwable) obj);
        return C4070l.f13734a;
    }

    public final void invoke(Throwable th) {
        this.$this_awaitResponse$inlined.cancel();
    }
}
