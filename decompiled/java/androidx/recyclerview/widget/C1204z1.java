package androidx.recyclerview.widget;

public final class C1204z1 {

    public int f3748a;

    public int f3749b;

    public int f3750c;

    public int f3751d;

    public int f3752e;

    public final boolean m3026a() {
        int i6;
        int i10;
        int i11;
        int i12 = this.f3748a;
        int i13 = 2;
        if ((i12 & 7) != 0) {
            int i14 = this.f3751d;
            int i15 = this.f3749b;
            if (i14 > i15) {
                i11 = 1;
            } else {
                i11 = i14 == i15 ? 2 : 4;
            }
            if ((i11 & i12) == 0) {
                return false;
            }
        }
        if ((i12 & 112) != 0) {
            int i16 = this.f3751d;
            int i17 = this.f3750c;
            if (i16 > i17) {
                i10 = 1;
            } else {
                i10 = i16 == i17 ? 2 : 4;
            }
            if (((i10 << 4) & i12) == 0) {
                return false;
            }
        }
        if ((i12 & 1792) != 0) {
            int i18 = this.f3752e;
            int i19 = this.f3749b;
            if (i18 > i19) {
                i6 = 1;
            } else {
                i6 = i18 == i19 ? 2 : 4;
            }
            if (((i6 << 8) & i12) == 0) {
                return false;
            }
        }
        if ((i12 & 28672) != 0) {
            int i20 = this.f3752e;
            int i21 = this.f3750c;
            if (i20 > i21) {
                i13 = 1;
            } else if (i20 != i21) {
                i13 = 4;
            }
            if ((i12 & (i13 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
