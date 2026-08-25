package p247x2;

public final class C4089k {

    public static final C4089k f13829b = new C4089k(0);

    public static final C4089k f13830c = new C4089k(1);

    public static final C4089k f13831d = new C4089k(2);

    public final int f13832a;

    public C4089k(int i6) {
        this.f13832a = i6;
    }

    public final boolean m8094a(int i6) {
        switch (this.f13832a) {
            case 0:
                return false;
            case 1:
                return (i6 == 3 || i6 == 5) ? false : true;
            default:
                return i6 == 2;
        }
    }
}
