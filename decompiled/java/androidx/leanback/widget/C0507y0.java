package androidx.leanback.widget;

import android.graphics.Color;

public final class C0507y0 {

    public final int f2449a;

    public final int f2450b;

    public final int f2451c;

    public C0507y0(int i6, int i10, int i11) {
        this.f2449a = i6;
        if (i10 == i6) {
            i10 = Color.argb((int) ((Color.alpha(i6) * 0.85f) + 38.25f), (int) ((Color.red(i6) * 0.85f) + 38.25f), (int) ((Color.green(i6) * 0.85f) + 38.25f), (int) ((Color.blue(i6) * 0.85f) + 38.25f));
        }
        this.f2450b = i10;
        this.f2451c = i11;
    }
}
