package p268z1;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import com.google.android.gms.internal.cast.C1552f0;

public final class C4292g extends AbstractC4295j {

    public C1552f0 f14530d;

    public float f14531e;

    public C1552f0 f14532f;

    public float f14533g;

    public float f14534h;

    public float f14535i;

    public float f14536j;

    public float f14537k;

    public Paint.Cap f14538l;

    public Paint.Join f14539m;

    public float f14540n;

    @Override
    public final boolean mo8348a() {
        return this.f14532f.m3815b() || this.f14530d.m3815b();
    }

    @Override
    public final boolean mo8349b(int[] iArr) {
        boolean z7;
        C1552f0 c1552f0 = this.f14532f;
        boolean z10 = false;
        if (c1552f0.m3815b()) {
            ColorStateList colorStateList = (ColorStateList) c1552f0.f5293c;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != c1552f0.f5291a) {
                c1552f0.f5291a = colorForState;
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        C1552f0 c1552f1 = this.f14530d;
        if (c1552f1.m3815b()) {
            ColorStateList colorStateList2 = (ColorStateList) c1552f1.f5293c;
            int colorForState2 = colorStateList2.getColorForState(iArr, colorStateList2.getDefaultColor());
            if (colorForState2 != c1552f1.f5291a) {
                c1552f1.f5291a = colorForState2;
                z10 = true;
            }
        }
        return z7 | z10;
    }

    public float getFillAlpha() {
        return this.f14534h;
    }

    public int getFillColor() {
        return this.f14532f.f5291a;
    }

    public float getStrokeAlpha() {
        return this.f14533g;
    }

    public int getStrokeColor() {
        return this.f14530d.f5291a;
    }

    public float getStrokeWidth() {
        return this.f14531e;
    }

    public float getTrimPathEnd() {
        return this.f14536j;
    }

    public float getTrimPathOffset() {
        return this.f14537k;
    }

    public float getTrimPathStart() {
        return this.f14535i;
    }

    public void setFillAlpha(float f) {
        this.f14534h = f;
    }

    public void setFillColor(int i6) {
        this.f14532f.f5291a = i6;
    }

    public void setStrokeAlpha(float f) {
        this.f14533g = f;
    }

    public void setStrokeColor(int i6) {
        this.f14530d.f5291a = i6;
    }

    public void setStrokeWidth(float f) {
        this.f14531e = f;
    }

    public void setTrimPathEnd(float f) {
        this.f14536j = f;
    }

    public void setTrimPathOffset(float f) {
        this.f14537k = f;
    }

    public void setTrimPathStart(float f) {
        this.f14535i = f;
    }
}
