package p124l6;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import p056f0.AbstractC2478a;
import p086i3.C2687c;
import p221u6.AbstractC3914n;
import p221u6.C3913m;
import p221u6.C3915o;
import p221u6.InterfaceC3903c;

public final class C2977c extends Drawable {

    public final Paint f10201b;

    public float f10207h;

    public int f10208i;

    public int f10209j;

    public int f10210k;

    public int f10211l;

    public int f10212m;

    public C3913m f10214o;

    public ColorStateList f10215p;

    public final C3915o f10200a = AbstractC3914n.f13176a;

    public final Path f10202c = new Path();

    public final Rect f10203d = new Rect();

    public final RectF f10204e = new RectF();

    public final RectF f10205f = new RectF();

    public final C2687c f10206g = new C2687c(this);

    public boolean f10213n = true;

    public C2977c(C3913m c3913m) {
        this.f10214o = c3913m;
        Paint paint = new Paint(1);
        this.f10201b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public final void draw(Canvas canvas) {
        boolean z7 = this.f10213n;
        Paint paint = this.f10201b;
        Rect rect = this.f10203d;
        if (z7) {
            copyBounds(rect);
            float fHeight = this.f10207h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{AbstractC2478a.m5511f(this.f10208i, this.f10212m), AbstractC2478a.m5511f(this.f10209j, this.f10212m), AbstractC2478a.m5511f(AbstractC2478a.m5513h(this.f10209j, 0), this.f10212m), AbstractC2478a.m5511f(AbstractC2478a.m5513h(this.f10211l, 0), this.f10212m), AbstractC2478a.m5511f(this.f10211l, this.f10212m), AbstractC2478a.m5511f(this.f10210k, this.f10212m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.f10213n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f10204e;
        rectF.set(rect);
        InterfaceC3903c interfaceC3903c = this.f10214o.f13168e;
        RectF rectF2 = this.f10205f;
        rectF2.set(getBounds());
        float fMin = Math.min(interfaceC3903c.mo7794a(rectF2), rectF.width() / 2.0f);
        C3913m c3913m = this.f10214o;
        rectF2.set(getBounds());
        if (c3913m.m7825e(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
        }
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        return this.f10206g;
    }

    @Override
    public final int getOpacity() {
        return this.f10207h > 0.0f ? -3 : -2;
    }

    @Override
    public final void getOutline(Outline outline) {
        C3913m c3913m = this.f10214o;
        RectF rectF = this.f10205f;
        rectF.set(getBounds());
        if (c3913m.m7825e(rectF)) {
            InterfaceC3903c interfaceC3903c = this.f10214o.f13168e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), interfaceC3903c.mo7794a(rectF));
            return;
        }
        Rect rect = this.f10203d;
        copyBounds(rect);
        RectF rectF2 = this.f10204e;
        rectF2.set(rect);
        C3913m c3913m2 = this.f10214o;
        Path path = this.f10202c;
        this.f10200a.m7827a(c3913m2, 1.0f, rectF2, null, path);
        if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    @Override
    public final boolean getPadding(Rect rect) {
        C3913m c3913m = this.f10214o;
        RectF rectF = this.f10205f;
        rectF.set(getBounds());
        if (!c3913m.m7825e(rectF)) {
            return true;
        }
        int iRound = Math.round(this.f10207h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f10215p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        this.f10213n = true;
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f10215p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f10212m)) != this.f10212m) {
            this.f10213n = true;
            this.f10212m = colorForState;
        }
        if (this.f10213n) {
            invalidateSelf();
        }
        return this.f10213n;
    }

    @Override
    public final void setAlpha(int i6) {
        this.f10201b.setAlpha(i6);
        invalidateSelf();
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f10201b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
