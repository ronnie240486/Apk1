package p178q6;

public final class C3506c {

    public final int f11796a;

    public final AbstractC3507d f11797b;

    public C3506c(AbstractC3507d abstractC3507d, int i6) {
        this.f11796a = i6;
        this.f11797b = abstractC3507d;
    }

    public final void m7147a() {
        switch (this.f11796a) {
            case 0:
                AbstractC3507d abstractC3507d = this.f11797b;
                abstractC3507d.setIndeterminate(false);
                abstractC3507d.mo4304b(abstractC3507d.f11799b);
                break;
            default:
                AbstractC3507d abstractC3507d2 = this.f11797b;
                if (!abstractC3507d2.f11803f) {
                    abstractC3507d2.setVisibility(abstractC3507d2.f11804g);
                }
                break;
        }
    }
}
