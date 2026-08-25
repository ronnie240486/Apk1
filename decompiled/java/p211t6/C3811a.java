package p211t6;

import android.graphics.Paint;
import android.graphics.Path;
import p056f0.AbstractC2478a;

public final class C3811a {

    public static final int[] f12860i = new int[3];

    public static final float[] f12861j = {0.0f, 0.5f, 1.0f};

    public static final int[] f12862k = new int[4];

    public static final float[] f12863l = {0.0f, 0.0f, 0.5f, 1.0f};

    public final Paint f12864a;

    public final Paint f12865b;

    public final Paint f12866c;

    public int f12867d;

    public int f12868e;

    public int f12869f;

    public final Path f12870g = new Path();

    public final Paint f12871h;

    public C3811a() {
        Paint paint = new Paint();
        this.f12871h = paint;
        this.f12864a = new Paint();
        m7590a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f12865b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f12866c = new Paint(paint2);
    }

    public final void m7590a(int i6) {
        this.f12867d = AbstractC2478a.m5513h(i6, 68);
        this.f12868e = AbstractC2478a.m5513h(i6, 20);
        this.f12869f = AbstractC2478a.m5513h(i6, 0);
        this.f12864a.setColor(this.f12867d);
    }
}
