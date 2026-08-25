package p041d7;

public final class C2241l3 implements InterfaceC2206g3 {

    public static final C2241l3 f7982b = new C2241l3(0);

    public static final C2241l3 f7983c = new C2241l3(1);

    public static final C2241l3 f7984d = new C2241l3(2);

    public static final C2241l3 f7985e = new C2241l3(3);

    public final int f7986a;

    public C2241l3(int i6) {
        this.f7986a = i6;
    }

    @Override
    public final InterfaceC2199f3 mo5180a(AbstractC2213h3 abstractC2213h3, Object obj, int i6, InterfaceC2199f3 interfaceC2199f3) {
        switch (this.f7986a) {
            case 0:
                C2255n3 c2255n3 = (C2255n3) interfaceC2199f3;
                return c2255n3 == null ? new C2255n3(i6, obj) : new C2248m3(obj, i6, c2255n3);
            case 1:
                C2276q3 c2276q3 = (C2276q3) interfaceC2199f3;
                return c2276q3 == null ? new C2276q3(i6, obj) : new C2269p3(obj, i6, c2276q3);
            case 2:
                C2303u3 c2303u3 = (C2303u3) abstractC2213h3;
                C2297t3 c2297t3 = (C2297t3) interfaceC2199f3;
                return c2297t3 == null ? new C2297t3(obj, i6, c2303u3.f8072h) : new C2290s3(c2303u3.f8072h, obj, i6, c2297t3);
            default:
                C2321x3 c2321x3 = (C2321x3) abstractC2213h3;
                C2315w3 c2315w3 = (C2315w3) interfaceC2199f3;
                return c2315w3 == null ? new C2315w3(obj, i6, c2321x3.f8095h) : new C2309v3(c2321x3.f8095h, obj, i6, c2315w3);
        }
    }

    @Override
    public final AbstractC2213h3 mo5181b(ConcurrentMapC2179c4 concurrentMapC2179c4, int i6) {
        switch (this.f7986a) {
            case 0:
                return new C2262o3(concurrentMapC2179c4, i6);
            case 1:
                return new C2283r3(concurrentMapC2179c4, i6);
            case 2:
                return new C2303u3(concurrentMapC2179c4, i6);
            default:
                return new C2321x3(concurrentMapC2179c4, i6);
        }
    }

    @Override
    public final void mo5182c(AbstractC2213h3 abstractC2213h3, InterfaceC2199f3 interfaceC2199f3, Object obj) {
        switch (this.f7986a) {
            case 0:
                ((C2255n3) interfaceC2199f3).f8007c = obj;
                break;
            case 1:
                C2276q3 c2276q3 = (C2276q3) interfaceC2199f3;
                InterfaceC2333z3 interfaceC2333z3 = c2276q3.f8030c;
                c2276q3.f8030c = new C2165a4(((C2283r3) abstractC2213h3).f8042h, obj, c2276q3);
                interfaceC2333z3.clear();
                break;
            case 2:
                ((C2297t3) interfaceC2199f3).f8064b = obj;
                break;
            default:
                C2315w3 c2315w3 = (C2315w3) interfaceC2199f3;
                InterfaceC2333z3 interfaceC2333z4 = c2315w3.f8084b;
                c2315w3.f8084b = new C2165a4(((C2321x3) abstractC2213h3).f8096i, obj, c2315w3);
                interfaceC2333z4.clear();
                break;
        }
    }

    @Override
    public final EnumC2234k3 mo5183d() {
        switch (this.f7986a) {
            case 0:
                return EnumC2234k3.f7974a;
            case 1:
                return EnumC2234k3.f7975b;
            case 2:
                return EnumC2234k3.f7974a;
            default:
                return EnumC2234k3.f7975b;
        }
    }

    @Override
    public final InterfaceC2199f3 mo5184e(AbstractC2213h3 abstractC2213h3, InterfaceC2199f3 interfaceC2199f3, InterfaceC2199f3 interfaceC2199f4) {
        C2276q3 c2276q3 = null;
        c2315w3 = null;
        C2315w3 c2315w3 = null;
        C2297t3 c2297t3 = null;
        switch (this.f7986a) {
            case 0:
                C2255n3 c2255n3 = (C2255n3) interfaceC2199f3;
                C2255n3 c2255n4 = (C2255n3) interfaceC2199f4;
                Object obj = c2255n3.f7835a;
                int i6 = c2255n3.f7836b;
                C2255n3 c2255n5 = c2255n4 == null ? new C2255n3(i6, obj) : new C2248m3(obj, i6, c2255n4);
                c2255n5.f8007c = c2255n3.f8007c;
                return c2255n5;
            case 1:
                C2283r3 c2283r3 = (C2283r3) abstractC2213h3;
                C2276q3 c2276q4 = (C2276q3) interfaceC2199f3;
                C2276q3 c2276q5 = (C2276q3) interfaceC2199f4;
                int i10 = AbstractC2213h3.f7920g;
                if (c2276q4.getValue() != null) {
                    Object obj2 = c2276q4.f7835a;
                    int i11 = c2276q4.f7836b;
                    c2276q3 = c2276q5 == null ? new C2276q3(i11, obj2) : new C2269p3(obj2, i11, c2276q5);
                    c2276q3.f8030c = c2276q4.f8030c.mo5102b(c2283r3.f8042h, c2276q3);
                }
                return c2276q3;
            case 2:
                C2303u3 c2303u3 = (C2303u3) abstractC2213h3;
                C2297t3 c2297t4 = (C2297t3) interfaceC2199f3;
                C2297t3 c2297t5 = (C2297t3) interfaceC2199f4;
                T t5 = c2297t4.get();
                if (t5 != 0) {
                    int i12 = c2297t4.f7851a;
                    c2297t3 = c2297t5 == null ? new C2297t3(t5, i12, c2303u3.f8072h) : new C2290s3(c2303u3.f8072h, t5, i12, c2297t5);
                    c2297t3.f8064b = c2297t4.f8064b;
                }
                return c2297t3;
            default:
                C2321x3 c2321x3 = (C2321x3) abstractC2213h3;
                C2315w3 c2315w4 = (C2315w3) interfaceC2199f3;
                C2315w3 c2315w5 = (C2315w3) interfaceC2199f4;
                T t8 = c2315w4.get();
                if (t8 != 0) {
                    int i13 = AbstractC2213h3.f7920g;
                    if (c2315w4.f8084b.get() != null) {
                        int i14 = c2315w4.f7851a;
                        c2315w3 = c2315w5 == null ? new C2315w3(t8, i14, c2321x3.f8095h) : new C2309v3(c2321x3.f8095h, t8, i14, c2315w5);
                        c2315w3.f8084b = c2315w4.f8084b.mo5102b(c2321x3.f8096i, c2315w3);
                    }
                }
                return c2315w3;
        }
    }
}
