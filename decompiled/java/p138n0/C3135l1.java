package p138n0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

public class C3135l1 extends C3132k1 {
    public C3135l1(C3153r1 c3153r1, WindowInsets windowInsets) {
        super(c3153r1, windowInsets);
    }

    @Override
    public C3153r1 mo6251a() {
        return C3153r1.m6324h(this.f10615c.consumeDisplayCutout(), null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3135l1)) {
            return false;
        }
        C3135l1 c3135l1 = (C3135l1) obj;
        return Objects.equals(this.f10615c, c3135l1.f10615c) && Objects.equals(this.f10619g, c3135l1.f10619g);
    }

    @Override
    public C3130k mo6252f() {
        DisplayCutout displayCutout = this.f10615c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C3130k(displayCutout);
    }

    @Override
    public int hashCode() {
        return this.f10615c.hashCode();
    }

    public C3135l1(C3153r1 c3153r1, C3135l1 c3135l1) {
        super(c3153r1, c3135l1);
    }
}
