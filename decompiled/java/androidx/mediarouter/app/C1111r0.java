package androidx.mediarouter.app;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Interpolator;
import p007a7.C0069f;

public final class C1111r0 {

    public final BitmapDrawable f3349a;

    public final Rect f3351c;

    public Interpolator f3352d;

    public long f3353e;

    public final Rect f3354f;

    public int f3355g;

    public long f3357i;

    public boolean f3358j;

    public boolean f3359k;

    public C0069f f3360l;

    public float f3350b = 1.0f;

    public float f3356h = 1.0f;

    public C1111r0(BitmapDrawable bitmapDrawable, Rect rect) {
        this.f3349a = bitmapDrawable;
        this.f3354f = rect;
        Rect rect2 = new Rect(rect);
        this.f3351c = rect2;
        if (bitmapDrawable != null) {
            bitmapDrawable.setAlpha((int) (this.f3350b * 255.0f));
            bitmapDrawable.setBounds(rect2);
        }
    }
}
