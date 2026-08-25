package androidx.appcompat.widget;

public final class C0243n2 {

    public int f1011a;

    public int f1012b;

    public int f1013c;

    public int f1014d;

    public int f1015e;

    public int f1016f;

    public boolean f1017g;

    public boolean f1018h;

    public final void m739a(int i6, int i10) {
        this.f1013c = i6;
        this.f1014d = i10;
        this.f1018h = true;
        if (this.f1017g) {
            if (i10 != Integer.MIN_VALUE) {
                this.f1011a = i10;
            }
            if (i6 != Integer.MIN_VALUE) {
                this.f1012b = i6;
                return;
            }
            return;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f1011a = i6;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1012b = i10;
        }
    }
}
