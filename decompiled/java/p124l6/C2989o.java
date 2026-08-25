package p124l6;

public final class C2989o extends AbstractC2990p {

    public final int f10248e;

    public final C2993s f10249f;

    public C2989o(C2993s c2993s, int i6) {
        super(c2993s);
        this.f10248e = i6;
        this.f10249f = c2993s;
    }

    @Override
    public final float mo6054a() {
        switch (this.f10248e) {
            case 0:
                C2993s c2993s = this.f10249f;
                return c2993s.f10270h + c2993s.f10271i;
            case 1:
                C2993s c2993s2 = this.f10249f;
                return c2993s2.f10270h + c2993s2.f10272j;
            default:
                return this.f10249f.f10270h;
        }
    }
}
