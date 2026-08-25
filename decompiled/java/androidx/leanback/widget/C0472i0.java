package androidx.leanback.widget;

import android.graphics.Color;

public final class C0472i0 {

    public float f2335a;

    public int f2336b;

    public float f2337c;

    public float f2338d;

    public float f2339e;

    public float f2340f;

    public float f2341g;

    public float f2342h = 1.0f;

    public float f2343i;

    public final PagingIndicator f2344j;

    public C0472i0(PagingIndicator pagingIndicator) {
        this.f2344j = pagingIndicator;
        this.f2343i = pagingIndicator.f2183a ? 1.0f : -1.0f;
    }

    public final void m1438a() {
        int iRound = Math.round(this.f2335a * 255.0f);
        PagingIndicator pagingIndicator = this.f2344j;
        this.f2336b = Color.argb(iRound, Color.red(pagingIndicator.f2198p), Color.green(pagingIndicator.f2198p), Color.blue(pagingIndicator.f2198p));
    }

    public final void m1439b() {
        this.f2337c = 0.0f;
        this.f2338d = 0.0f;
        PagingIndicator pagingIndicator = this.f2344j;
        this.f2339e = pagingIndicator.f2184b;
        float f = pagingIndicator.f2185c;
        this.f2340f = f;
        this.f2341g = f * pagingIndicator.f2204v;
        this.f2335a = 0.0f;
        m1438a();
    }
}
