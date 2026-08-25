package p100j6;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import p056f0.AbstractC2478a;
import p156o9.AbstractC3281e;

public final class C2779a {

    public static final int f9492f = (int) Math.round(5.1000000000000005d);

    public final boolean f9493a;

    public final int f9494b;

    public final int f9495c;

    public final int f9496d;

    public final float f9497e;

    public C2779a(Context context) {
        TypedValue typedValueM3477l = AbstractC1465c.m3477l(context, R.attr.elevationOverlayEnabled);
        boolean z7 = (typedValueM3477l == null || typedValueM3477l.type != 18 || typedValueM3477l.data == 0) ? false : true;
        int iM6627q = AbstractC3281e.m6627q(context, R.attr.elevationOverlayColor, 0);
        int iM6627q2 = AbstractC3281e.m6627q(context, R.attr.elevationOverlayAccentColor, 0);
        int iM6627q3 = AbstractC3281e.m6627q(context, R.attr.colorSurface, 0);
        float f = context.getResources().getDisplayMetrics().density;
        this.f9493a = z7;
        this.f9494b = iM6627q;
        this.f9495c = iM6627q2;
        this.f9496d = iM6627q3;
        this.f9497e = f;
    }

    public final int m5749a(int i6, float f) {
        int i10;
        if (!this.f9493a || AbstractC2478a.m5513h(i6, 255) != this.f9496d) {
            return i6;
        }
        float f3 = this.f9497e;
        float fMin = (f3 <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i6);
        int iM6634x = AbstractC3281e.m6634x(fMin, AbstractC2478a.m5513h(i6, 255), this.f9494b);
        if (fMin > 0.0f && (i10 = this.f9495c) != 0) {
            iM6634x = AbstractC2478a.m5511f(AbstractC2478a.m5513h(i10, f9492f), iM6634x);
        }
        return AbstractC2478a.m5513h(iM6634x, iAlpha);
    }
}
