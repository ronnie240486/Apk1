package p251x6;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import p171q.C3388b;
import p262y5.AbstractC4268a;

public final class C4122a extends C3388b {

    public final int f14013c;

    public C4122a(int i6) {
        super(10);
        this.f14013c = i6;
    }

    @Override
    public final void mo6881e(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.f14013c) {
            case 0:
                RectF rectFM6878c = C3388b.m6878c(tabLayout, view);
                RectF rectFM6878c2 = C3388b.m6878c(tabLayout, view2);
                if (rectFM6878c.left < rectFM6878c2.left) {
                    double d = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d));
                    fCos = (float) Math.sin(d);
                } else {
                    double d10 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d10);
                    fCos = (float) (1.0d - Math.cos(d10));
                }
                drawable.setBounds(AbstractC4268a.m8311c(fSin, (int) rectFM6878c.left, (int) rectFM6878c2.left), drawable.getBounds().top, AbstractC4268a.m8311c(fCos, (int) rectFM6878c.right, (int) rectFM6878c2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFM6878c3 = C3388b.m6878c(tabLayout, view);
                float fM8310b = f < 0.5f ? AbstractC4268a.m8310b(1.0f, 0.0f, 0.0f, 0.5f, f) : AbstractC4268a.m8310b(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFM6878c3.left, drawable.getBounds().top, (int) rectFM6878c3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fM8310b * 255.0f));
                break;
        }
    }
}
