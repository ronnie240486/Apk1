package p192r9;

import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p243w8.C4064f;

public final class C3657o implements InterfaceC2728p {

    public final char[] f12255a;

    public final boolean f12256b;

    public C3657o(char[] cArr, boolean z7) {
        this.f12255a = cArr;
        this.f12256b = z7;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        CharSequence charSequence = (CharSequence) obj;
        int iIntValue = ((Integer) obj2).intValue();
        AbstractC2796i.m5785f(charSequence, "$this$DelimitedRangesSequence");
        int iM7382d0 = AbstractC3648f.m7382d0(charSequence, this.f12255a, iIntValue, this.f12256b);
        if (iM7382d0 < 0) {
            return null;
        }
        return new C4064f(Integer.valueOf(iM7382d0), 1);
    }
}
