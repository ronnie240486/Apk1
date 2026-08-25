package p008a9;

import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;

public final class C0072b implements InterfaceC2728p {

    public final int f202a;

    public C0072b(int i6) {
        this.f202a = i6;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        C0073c c0073c;
        switch (this.f202a) {
            case 0:
                String str = (String) obj;
                InterfaceC0077g interfaceC0077g = (InterfaceC0077g) obj2;
                AbstractC2796i.m5785f(str, "acc");
                if (str.length() == 0) {
                    return interfaceC0077g.toString();
                }
                return str + ", " + interfaceC0077g;
            default:
                InterfaceC0079i interfaceC0079i = (InterfaceC0079i) obj;
                InterfaceC0077g interfaceC0077g2 = (InterfaceC0077g) obj2;
                AbstractC2796i.m5785f(interfaceC0079i, "acc");
                InterfaceC0079i interfaceC0079iMo251c = interfaceC0079i.mo251c(interfaceC0077g2.getKey());
                C0080j c0080j = C0080j.f206a;
                if (interfaceC0079iMo251c == c0080j) {
                    return interfaceC0077g2;
                }
                C0075e c0075e = C0075e.f205a;
                InterfaceC0076f interfaceC0076f = (InterfaceC0076f) interfaceC0079iMo251c.mo252e(c0075e);
                if (interfaceC0076f == null) {
                    c0073c = new C0073c(interfaceC0077g2, interfaceC0079iMo251c);
                } else {
                    InterfaceC0079i interfaceC0079iMo251c2 = interfaceC0079iMo251c.mo251c(c0075e);
                    if (interfaceC0079iMo251c2 == c0080j) {
                        return new C0073c(interfaceC0076f, interfaceC0077g2);
                    }
                    c0073c = new C0073c(interfaceC0076f, new C0073c(interfaceC0077g2, interfaceC0079iMo251c2));
                }
                return c0073c;
        }
    }
}
