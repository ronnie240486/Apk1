package p221u6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.BitSet;
import java.util.Objects;
import p065g0.InterfaceC2588h;
import p100j6.C2779a;
import p187r4.C3624n;
import p211t6.C3811a;

public class C3908h extends Drawable implements InterfaceC2588h, InterfaceC3924x {

    public static final Paint f13125w;

    public C3907g f13126a;

    public final AbstractC3922v[] f13127b;

    public final AbstractC3922v[] f13128c;

    public final BitSet f13129d;

    public boolean f13130e;

    public final Matrix f13131f;

    public final Path f13132g;

    public final Path f13133h;

    public final RectF f13134i;

    public final RectF f13135j;

    public final Region f13136k;

    public final Region f13137l;

    public C3913m f13138m;

    public final Paint f13139n;

    public final Paint f13140o;

    public final C3811a f13141p;

    public final C3624n f13142q;

    public final C3915o f13143r;

    public PorterDuffColorFilter f13144s;

    public PorterDuffColorFilter f13145t;

    public final RectF f13146u;

    public boolean f13147v;

    static {
        Paint paint = new Paint(1);
        f13125w = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public C3908h() {
        this(new C3913m());
    }

    public void mo4284a() {
        invalidateSelf();
    }

    public final void m7798b(RectF rectF, Path path) {
        C3907g c3907g = this.f13126a;
        this.f13143r.m7827a(c3907g.f13107a, c3907g.f13115i, rectF, this.f13142q, path);
        if (this.f13126a.f13114h != 1.0f) {
            Matrix matrix = this.f13131f;
            matrix.reset();
            float f = this.f13126a.f13114h;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f13146u, true);
    }

    public final int m7799c(int i6) {
        C3907g c3907g = this.f13126a;
        float f = c3907g.f13119m + 0.0f + c3907g.f13118l;
        C2779a c2779a = c3907g.f13108b;
        return c2779a != null ? c2779a.m5749a(i6, f) : i6;
    }

    public final void m7800d(Canvas canvas) {
        if (this.f13129d.cardinality() > 0) {
            Log.w(CmcdData.STREAMING_FORMAT_HLS, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i6 = this.f13126a.f13122p;
        Path path = this.f13132g;
        C3811a c3811a = this.f13141p;
        if (i6 != 0) {
            canvas.drawPath(path, c3811a.f12864a);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            AbstractC3922v abstractC3922v = this.f13127b[i10];
            int i11 = this.f13126a.f13121o;
            Matrix matrix = AbstractC3922v.f13205a;
            abstractC3922v.mo7829a(matrix, c3811a, i11, canvas);
            this.f13128c[i10].mo7829a(matrix, c3811a, this.f13126a.f13121o, canvas);
        }
        if (this.f13147v) {
            C3907g c3907g = this.f13126a;
            int iSin = (int) (Math.sin(Math.toRadians(c3907g.f13123q)) * ((double) c3907g.f13122p));
            int iM7803h = m7803h();
            canvas.translate(-iSin, -iM7803h);
            canvas.drawPath(path, f13125w);
            canvas.translate(iSin, iM7803h);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int iWidth;
        Paint paint = this.f13139n;
        paint.setColorFilter(this.f13144s);
        int alpha = paint.getAlpha();
        int i6 = this.f13126a.f13117k;
        paint.setAlpha(((i6 + (i6 >>> 7)) * alpha) >>> 8);
        Paint paint2 = this.f13140o;
        paint2.setColorFilter(this.f13145t);
        paint2.setStrokeWidth(this.f13126a.f13116j);
        int alpha2 = paint2.getAlpha();
        int i10 = this.f13126a.f13117k;
        paint2.setAlpha(((i10 + (i10 >>> 7)) * alpha2) >>> 8);
        boolean z7 = this.f13130e;
        Path path = this.f13132g;
        if (z7) {
            float f = -(m7805j() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            C3913m c3913m = this.f13126a.f13107a;
            C3912l c3912lM7826f = c3913m.m7826f();
            InterfaceC3903c c3902b = c3913m.f13168e;
            if (!(c3902b instanceof C3910j)) {
                c3902b = new C3902b(f, c3902b);
            }
            c3912lM7826f.f13155e = c3902b;
            InterfaceC3903c c3902b2 = c3913m.f13169f;
            if (!(c3902b2 instanceof C3910j)) {
                c3902b2 = new C3902b(f, c3902b2);
            }
            c3912lM7826f.f13156f = c3902b2;
            InterfaceC3903c c3902b3 = c3913m.f13171h;
            if (!(c3902b3 instanceof C3910j)) {
                c3902b3 = new C3902b(f, c3902b3);
            }
            c3912lM7826f.f13158h = c3902b3;
            InterfaceC3903c c3902b4 = c3913m.f13170g;
            if (!(c3902b4 instanceof C3910j)) {
                c3902b4 = new C3902b(f, c3902b4);
            }
            c3912lM7826f.f13157g = c3902b4;
            C3913m c3913mM7819a = c3912lM7826f.m7819a();
            this.f13138m = c3913mM7819a;
            float f3 = this.f13126a.f13115i;
            RectF rectF = this.f13135j;
            rectF.set(m7802g());
            float strokeWidth = m7805j() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.f13143r.m7827a(c3913mM7819a, f3, rectF, null, this.f13133h);
            m7798b(m7802g(), path);
            this.f13130e = false;
        }
        C3907g c3907g = this.f13126a;
        int i11 = c3907g.f13120n;
        if (i11 != 1 && c3907g.f13121o > 0) {
            if (i11 != 2) {
                int i12 = Build.VERSION.SDK_INT;
                if (!m7807l() && !path.isConvex() && i12 < 29) {
                    canvas.save();
                    C3907g c3907g2 = this.f13126a;
                    canvas.translate((int) (Math.sin(Math.toRadians(c3907g2.f13123q)) * ((double) c3907g2.f13122p)), m7803h());
                    if (!this.f13147v) {
                        RectF rectF2 = this.f13146u;
                        iWidth = (int) (rectF2.width() - getBounds().width());
                        int iHeight = (int) (rectF2.height() - getBounds().height());
                        if (iWidth >= 0 || iHeight < 0) {
                            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f13126a.f13121o * 2) + ((int) rectF2.width()) + iWidth, (this.f13126a.f13121o * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                        float f4 = (getBounds().left - this.f13126a.f13121o) - iWidth;
                        float f5 = (getBounds().top - this.f13126a.f13121o) - iHeight;
                        canvas2.translate(-f4, -f5);
                        m7800d(canvas2);
                        canvas.drawBitmap(bitmapCreateBitmap, f4, f5, (Paint) null);
                        bitmapCreateBitmap.recycle();
                        canvas.restore();
                    } else {
                        m7800d(canvas);
                        canvas.restore();
                    }
                }
            } else {
                canvas.save();
                C3907g c3907g3 = this.f13126a;
                canvas.translate((int) (Math.sin(Math.toRadians(c3907g3.f13123q)) * ((double) c3907g3.f13122p)), m7803h());
                if (!this.f13147v) {
                    RectF rectF3 = this.f13146u;
                    iWidth = (int) (rectF3.width() - getBounds().width());
                    int iHeight2 = (int) (rectF3.height() - getBounds().height());
                    if (iWidth >= 0) {
                    }
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                m7800d(canvas);
                canvas.restore();
            }
        }
        C3907g c3907g4 = this.f13126a;
        Paint.Style style = c3907g4.f13124r;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            m7801e(canvas, paint, path, c3907g4.f13107a, m7802g());
        }
        if (m7805j()) {
            mo4382f(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void m7801e(Canvas canvas, Paint paint, Path path, C3913m c3913m, RectF rectF) {
        if (!c3913m.m7825e(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fMo7794a = c3913m.f13169f.mo7794a(rectF) * this.f13126a.f13115i;
            canvas.drawRoundRect(rectF, fMo7794a, fMo7794a, paint);
        }
    }

    public void mo4382f(Canvas canvas) {
        Paint paint = this.f13140o;
        Path path = this.f13133h;
        C3913m c3913m = this.f13138m;
        RectF rectF = this.f13135j;
        rectF.set(m7802g());
        float strokeWidth = m7805j() ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        m7801e(canvas, paint, path, c3913m, rectF);
    }

    public final RectF m7802g() {
        RectF rectF = this.f13134i;
        rectF.set(getBounds());
        return rectF;
    }

    @Override
    public int getAlpha() {
        return this.f13126a.f13117k;
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        return this.f13126a;
    }

    @Override
    public int getOpacity() {
        return -3;
    }

    @Override
    public void getOutline(Outline outline) {
        if (this.f13126a.f13120n == 2) {
            return;
        }
        if (m7807l()) {
            outline.setRoundRect(getBounds(), m7804i() * this.f13126a.f13115i);
            return;
        }
        RectF rectFM7802g = m7802g();
        Path path = this.f13132g;
        m7798b(rectFM7802g, path);
        if (path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f13126a.f13113g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f13136k;
        region.set(bounds);
        RectF rectFM7802g = m7802g();
        Path path = this.f13132g;
        m7798b(rectFM7802g, path);
        Region region2 = this.f13137l;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final int m7803h() {
        C3907g c3907g = this.f13126a;
        return (int) (Math.cos(Math.toRadians(c3907g.f13123q)) * ((double) c3907g.f13122p));
    }

    public final float m7804i() {
        return this.f13126a.f13107a.f13168e.mo7794a(m7802g());
    }

    @Override
    public final void invalidateSelf() {
        this.f13130e = true;
        super.invalidateSelf();
    }

    @Override
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        if (!super.isStateful() && ((colorStateList = this.f13126a.f13111e) == null || !colorStateList.isStateful())) {
            this.f13126a.getClass();
            ColorStateList colorStateList3 = this.f13126a.f13110d;
            if ((colorStateList3 == null || !colorStateList3.isStateful()) && ((colorStateList2 = this.f13126a.f13109c) == null || !colorStateList2.isStateful())) {
                return false;
            }
        }
        return true;
    }

    public final boolean m7805j() {
        Paint.Style style = this.f13126a.f13124r;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f13140o.getStrokeWidth() > 0.0f;
    }

    public final void m7806k(Context context) {
        this.f13126a.f13108b = new C2779a(context);
        m7817v();
    }

    public final boolean m7807l() {
        return this.f13126a.f13107a.m7825e(m7802g());
    }

    public final void m7808m(float f) {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13119m != f) {
            c3907g.f13119m = f;
            m7817v();
        }
    }

    @Override
    public final Drawable mutate() {
        C3907g c3907g = this.f13126a;
        C3907g c3907g2 = new C3907g();
        c3907g2.f13109c = null;
        c3907g2.f13110d = null;
        c3907g2.f13111e = null;
        c3907g2.f13112f = PorterDuff.Mode.SRC_IN;
        c3907g2.f13113g = null;
        c3907g2.f13114h = 1.0f;
        c3907g2.f13115i = 1.0f;
        c3907g2.f13117k = 255;
        c3907g2.f13118l = 0.0f;
        c3907g2.f13119m = 0.0f;
        c3907g2.f13120n = 0;
        c3907g2.f13121o = 0;
        c3907g2.f13122p = 0;
        c3907g2.f13123q = 0;
        c3907g2.f13124r = Paint.Style.FILL_AND_STROKE;
        c3907g2.f13107a = c3907g.f13107a;
        c3907g2.f13108b = c3907g.f13108b;
        c3907g2.f13116j = c3907g.f13116j;
        c3907g2.f13109c = c3907g.f13109c;
        c3907g2.f13110d = c3907g.f13110d;
        c3907g2.f13112f = c3907g.f13112f;
        c3907g2.f13111e = c3907g.f13111e;
        c3907g2.f13117k = c3907g.f13117k;
        c3907g2.f13114h = c3907g.f13114h;
        c3907g2.f13122p = c3907g.f13122p;
        c3907g2.f13120n = c3907g.f13120n;
        c3907g2.f13115i = c3907g.f13115i;
        c3907g2.f13118l = c3907g.f13118l;
        c3907g2.f13119m = c3907g.f13119m;
        c3907g2.f13121o = c3907g.f13121o;
        c3907g2.f13123q = c3907g.f13123q;
        c3907g2.f13124r = c3907g.f13124r;
        if (c3907g.f13113g != null) {
            c3907g2.f13113g = new Rect(c3907g.f13113g);
        }
        this.f13126a = c3907g2;
        return this;
    }

    public final void m7809n(ColorStateList colorStateList) {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13109c != colorStateList) {
            c3907g.f13109c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void m7810o(float f) {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13115i != f) {
            c3907g.f13115i = f;
            this.f13130e = true;
            invalidateSelf();
        }
    }

    @Override
    public void onBoundsChange(Rect rect) {
        this.f13130e = true;
        super.onBoundsChange(rect);
    }

    @Override
    public boolean onStateChange(int[] iArr) {
        boolean z7 = m7815t(iArr) || m7816u();
        if (z7) {
            invalidateSelf();
        }
        return z7;
    }

    public final void m7811p(Paint.Style style) {
        this.f13126a.f13124r = style;
        super.invalidateSelf();
    }

    public final void m7812q() {
        this.f13141p.m7590a(-12303292);
        this.f13126a.getClass();
        super.invalidateSelf();
    }

    public final void m7813r() {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13120n != 2) {
            c3907g.f13120n = 2;
            super.invalidateSelf();
        }
    }

    public final void m7814s(ColorStateList colorStateList) {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13110d != colorStateList) {
            c3907g.f13110d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override
    public void setAlpha(int i6) {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13117k != i6) {
            c3907g.f13117k = i6;
            super.invalidateSelf();
        }
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13126a.getClass();
        super.invalidateSelf();
    }

    @Override
    public final void setShapeAppearanceModel(C3913m c3913m) {
        this.f13126a.f13107a = c3913m;
        invalidateSelf();
    }

    @Override
    public final void setTint(int i6) {
        setTintList(ColorStateList.valueOf(i6));
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        this.f13126a.f13111e = colorStateList;
        m7816u();
        super.invalidateSelf();
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        C3907g c3907g = this.f13126a;
        if (c3907g.f13112f != mode) {
            c3907g.f13112f = mode;
            m7816u();
            super.invalidateSelf();
        }
    }

    public final boolean m7815t(int[] iArr) {
        boolean z7;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f13126a.f13109c == null || color2 == (colorForState2 = this.f13126a.f13109c.getColorForState(iArr, (color2 = (paint2 = this.f13139n).getColor())))) {
            z7 = false;
        } else {
            paint2.setColor(colorForState2);
            z7 = true;
        }
        if (this.f13126a.f13110d == null || color == (colorForState = this.f13126a.f13110d.getColorForState(iArr, (color = (paint = this.f13140o).getColor())))) {
            return z7;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean m7816u() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f13144s;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f13145t;
        C3907g c3907g = this.f13126a;
        ColorStateList colorStateList = c3907g.f13111e;
        PorterDuff.Mode mode = c3907g.f13112f;
        Paint paint = this.f13139n;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int iM7799c = m7799c(color);
            porterDuffColorFilter = iM7799c != color ? new PorterDuffColorFilter(iM7799c, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(m7799c(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.f13144s = porterDuffColorFilter;
        this.f13126a.getClass();
        this.f13145t = null;
        this.f13126a.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.f13144s) && Objects.equals(porterDuffColorFilter3, this.f13145t)) ? false : true;
    }

    public final void m7817v() {
        C3907g c3907g = this.f13126a;
        float f = c3907g.f13119m + 0.0f;
        c3907g.f13121o = (int) Math.ceil(0.75f * f);
        this.f13126a.f13122p = (int) Math.ceil(f * 0.25f);
        m7816u();
        super.invalidateSelf();
    }

    public C3908h(Context context, AttributeSet attributeSet, int i6, int i10) {
        this(C3913m.m7822b(context, attributeSet, i6, i10).m7819a());
    }

    public C3908h(C3913m c3913m) {
        C3907g c3907g = new C3907g();
        c3907g.f13109c = null;
        c3907g.f13110d = null;
        c3907g.f13111e = null;
        c3907g.f13112f = PorterDuff.Mode.SRC_IN;
        c3907g.f13113g = null;
        c3907g.f13114h = 1.0f;
        c3907g.f13115i = 1.0f;
        c3907g.f13117k = 255;
        c3907g.f13118l = 0.0f;
        c3907g.f13119m = 0.0f;
        c3907g.f13120n = 0;
        c3907g.f13121o = 0;
        c3907g.f13122p = 0;
        c3907g.f13123q = 0;
        c3907g.f13124r = Paint.Style.FILL_AND_STROKE;
        c3907g.f13107a = c3913m;
        c3907g.f13108b = null;
        this(c3907g);
    }

    public C3908h(C3907g c3907g) {
        C3915o c3915o;
        this.f13127b = new AbstractC3922v[4];
        this.f13128c = new AbstractC3922v[4];
        this.f13129d = new BitSet(8);
        this.f13131f = new Matrix();
        this.f13132g = new Path();
        this.f13133h = new Path();
        this.f13134i = new RectF();
        this.f13135j = new RectF();
        this.f13136k = new Region();
        this.f13137l = new Region();
        Paint paint = new Paint(1);
        this.f13139n = paint;
        Paint paint2 = new Paint(1);
        this.f13140o = paint2;
        this.f13141p = new C3811a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c3915o = AbstractC3914n.f13176a;
        } else {
            c3915o = new C3915o();
        }
        this.f13143r = c3915o;
        this.f13146u = new RectF();
        this.f13147v = true;
        this.f13126a = c3907g;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m7816u();
        m7815t(getState());
        this.f13142q = new C3624n(5, this);
    }
}
