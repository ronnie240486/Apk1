package p268z1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.bumptech.glide.AbstractC1466d;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p046e0.AbstractC2343b;
import p046e0.AbstractC2344c;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;
import p160p.C3341e;

public final class C4299n extends AbstractC4290e {

    public static final PorterDuff.Mode f14584j = PorterDuff.Mode.SRC_IN;

    public C4297l f14585b;

    public PorterDuffColorFilter f14586c;

    public ColorFilter f14587d;

    public boolean f14588e;

    public boolean f14589f;

    public final float[] f14590g;

    public final Matrix f14591h;

    public final Rect f14592i;

    public C4299n() {
        this.f14589f = true;
        this.f14590g = new float[9];
        this.f14591h = new Matrix();
        this.f14592i = new Rect();
        C4297l c4297l = new C4297l();
        c4297l.f14573c = null;
        c4297l.f14574d = f14584j;
        c4297l.f14572b = new C4296k();
        this.f14585b = c4297l;
    }

    public final PorterDuffColorFilter m8352a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override
    public final boolean canApplyTheme() {
        Drawable drawable = this.f14529a;
        if (drawable == null) {
            return false;
        }
        AbstractC2581a.m5580b(drawable);
        return false;
    }

    @Override
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f14592i;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f14587d;
        if (colorFilter == null) {
            colorFilter = this.f14586c;
        }
        Matrix matrix = this.f14591h;
        canvas.getMatrix(matrix);
        float[] fArr = this.f14590g;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iHeight = (int) (rect.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && AbstractC3198d.m6474w(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        C4297l c4297l = this.f14585b;
        Bitmap bitmap = c4297l.f14576f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != c4297l.f14576f.getHeight()) {
            c4297l.f14576f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            c4297l.f14581k = true;
        }
        if (this.f14589f) {
            C4297l c4297l2 = this.f14585b;
            if (c4297l2.f14581k || c4297l2.f14577g != c4297l2.f14573c || c4297l2.f14578h != c4297l2.f14574d || c4297l2.f14580j != c4297l2.f14575e || c4297l2.f14579i != c4297l2.f14572b.getRootAlpha()) {
                C4297l c4297l3 = this.f14585b;
                c4297l3.f14576f.eraseColor(0);
                Canvas canvas2 = new Canvas(c4297l3.f14576f);
                C4296k c4296k = c4297l3.f14572b;
                c4296k.m8351a(c4296k.f14562g, C4296k.f14555p, canvas2, iMin, iMin2);
                C4297l c4297l4 = this.f14585b;
                c4297l4.f14577g = c4297l4.f14573c;
                c4297l4.f14578h = c4297l4.f14574d;
                c4297l4.f14579i = c4297l4.f14572b.getRootAlpha();
                c4297l4.f14580j = c4297l4.f14575e;
                c4297l4.f14581k = false;
            }
        } else {
            C4297l c4297l5 = this.f14585b;
            c4297l5.f14576f.eraseColor(0);
            Canvas canvas3 = new Canvas(c4297l5.f14576f);
            C4296k c4296k2 = c4297l5.f14572b;
            c4296k2.m8351a(c4296k2.f14562g, C4296k.f14555p, canvas3, iMin, iMin2);
        }
        C4297l c4297l6 = this.f14585b;
        if (c4297l6.f14572b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (c4297l6.f14582l == null) {
                Paint paint2 = new Paint();
                c4297l6.f14582l = paint2;
                paint2.setFilterBitmap(true);
            }
            c4297l6.f14582l.setAlpha(c4297l6.f14572b.getRootAlpha());
            c4297l6.f14582l.setColorFilter(colorFilter);
            paint = c4297l6.f14582l;
        }
        canvas.drawBitmap(c4297l6.f14576f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override
    public final int getAlpha() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getAlpha() : this.f14585b.f14572b.getRootAlpha();
    }

    @Override
    public final int getChangingConfigurations() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f14585b.getChangingConfigurations();
    }

    @Override
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f14529a;
        return drawable != null ? AbstractC2581a.m5581c(drawable) : this.f14587d;
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        if (this.f14529a != null && Build.VERSION.SDK_INT >= 24) {
            return new C4298m(this.f14529a.getConstantState());
        }
        this.f14585b.f14571a = getChangingConfigurations();
        return this.f14585b;
    }

    @Override
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f14585b.f14572b.f14564i;
    }

    @Override
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f14585b.f14572b.f14563h;
    }

    @Override
    public final int getOpacity() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override
    public final void invalidateSelf() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.isAutoMirrored() : this.f14585b.f14575e;
    }

    @Override
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            C4297l c4297l = this.f14585b;
            if (c4297l != null) {
                C4296k c4296k = c4297l.f14572b;
                if (c4296k.f14569n == null) {
                    c4296k.f14569n = Boolean.valueOf(c4296k.f14562g.mo8348a());
                }
                if (c4296k.f14569n.booleanValue() || ((colorStateList = this.f14585b.f14573c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final Drawable mutate() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f14588e && super.mutate() == this) {
            C4297l c4297l = this.f14585b;
            C4297l c4297l2 = new C4297l();
            c4297l2.f14573c = null;
            c4297l2.f14574d = f14584j;
            if (c4297l != null) {
                c4297l2.f14571a = c4297l.f14571a;
                C4296k c4296k = new C4296k(c4297l.f14572b);
                c4297l2.f14572b = c4296k;
                if (c4297l.f14572b.f14560e != null) {
                    c4296k.f14560e = new Paint(c4297l.f14572b.f14560e);
                }
                if (c4297l.f14572b.f14559d != null) {
                    c4297l2.f14572b.f14559d = new Paint(c4297l.f14572b.f14559d);
                }
                c4297l2.f14573c = c4297l.f14573c;
                c4297l2.f14574d = c4297l.f14574d;
                c4297l2.f14575e = c4297l.f14575e;
            }
            this.f14585b = c4297l2;
            this.f14588e = true;
        }
        return this;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        boolean z7;
        PorterDuff.Mode mode;
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        C4297l c4297l = this.f14585b;
        ColorStateList colorStateList = c4297l.f14573c;
        if (colorStateList == null || (mode = c4297l.f14574d) == null) {
            z7 = false;
        } else {
            this.f14586c = m8352a(colorStateList, mode);
            invalidateSelf();
            z7 = true;
        }
        C4296k c4296k = c4297l.f14572b;
        if (c4296k.f14569n == null) {
            c4296k.f14569n = Boolean.valueOf(c4296k.f14562g.mo8348a());
        }
        if (c4296k.f14569n.booleanValue()) {
            boolean zMo8349b = c4297l.f14572b.f14562g.mo8349b(iArr);
            c4297l.f14581k |= zMo8349b;
            if (zMo8349b) {
                invalidateSelf();
                return true;
            }
        }
        return z7;
    }

    @Override
    public final void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override
    public final void setAlpha(int i6) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setAlpha(i6);
        } else if (this.f14585b.f14572b.getRootAlpha() != i6) {
            this.f14585b.f14572b.setRootAlpha(i6);
            invalidateSelf();
        }
    }

    @Override
    public final void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setAutoMirrored(z7);
        } else {
            this.f14585b.f14575e = z7;
        }
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f14587d = colorFilter;
            invalidateSelf();
        }
    }

    @Override
    public final void setTint(int i6) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC3198d.m6444S(drawable, i6);
        } else {
            setTintList(ColorStateList.valueOf(i6));
        }
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5586h(drawable, colorStateList);
            return;
        }
        C4297l c4297l = this.f14585b;
        if (c4297l.f14573c != colorStateList) {
            c4297l.f14573c = colorStateList;
            this.f14586c = m8352a(colorStateList, c4297l.f14574d);
            invalidateSelf();
        }
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5587i(drawable, mode);
            return;
        }
        C4297l c4297l = this.f14585b;
        if (c4297l.f14574d != mode) {
            c4297l.f14574d = mode;
            this.f14586c = m8352a(c4297l.f14573c, mode);
            invalidateSelf();
        }
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.setVisible(z7, z10) : super.setVisible(z7, z10);
    }

    @Override
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C4296k c4296k;
        int i6;
        Paint.Cap cap;
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5582d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C4297l c4297l = this.f14585b;
        c4297l.f14572b = new C4296k();
        TypedArray typedArrayM5322h = AbstractC2343b.m5322h(resources, theme, attributeSet, AbstractC4286a.f14510a);
        C4297l c4297l2 = this.f14585b;
        C4296k c4296k2 = c4297l2.f14572b;
        int iM5317c = AbstractC2343b.m5317c(typedArrayM5322h, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i10 = 3;
        if (iM5317c == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (iM5317c != 5) {
            if (iM5317c != 9) {
                switch (iM5317c) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        c4297l2.f14574d = mode;
        ColorStateList colorStateListM5329a = null;
        if (AbstractC2343b.m5319e(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayM5322h.getValue(1, typedValue);
            int i11 = typedValue.type;
            if (i11 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i11 >= 28 && i11 <= 31) {
                colorStateListM5329a = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayM5322h.getResources();
                int resourceId = typedArrayM5322h.getResourceId(1, 0);
                ThreadLocal threadLocal = AbstractC2344c.f8192a;
                try {
                    colorStateListM5329a = AbstractC2344c.m5329a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e5) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e5);
                }
            }
        }
        ColorStateList colorStateList = colorStateListM5329a;
        if (colorStateList != null) {
            c4297l2.f14573c = colorStateList;
        }
        boolean z7 = c4297l2.f14575e;
        if (AbstractC2343b.m5319e(xmlPullParser, "autoMirrored")) {
            z7 = typedArrayM5322h.getBoolean(5, z7);
        }
        c4297l2.f14575e = z7;
        float f = c4296k2.f14565j;
        if (AbstractC2343b.m5319e(xmlPullParser, "viewportWidth")) {
            f = typedArrayM5322h.getFloat(7, f);
        }
        c4296k2.f14565j = f;
        float f3 = c4296k2.f14566k;
        if (AbstractC2343b.m5319e(xmlPullParser, "viewportHeight")) {
            f3 = typedArrayM5322h.getFloat(8, f3);
        }
        c4296k2.f14566k = f3;
        if (c4296k2.f14565j <= 0.0f) {
            throw new XmlPullParserException(typedArrayM5322h.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f3 > 0.0f) {
            c4296k2.f14563h = typedArrayM5322h.getDimension(3, c4296k2.f14563h);
            float dimension = typedArrayM5322h.getDimension(2, c4296k2.f14564i);
            c4296k2.f14564i = dimension;
            if (c4296k2.f14563h <= 0.0f) {
                throw new XmlPullParserException(typedArrayM5322h.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = c4296k2.getAlpha();
                if (AbstractC2343b.m5319e(xmlPullParser, "alpha")) {
                    alpha = typedArrayM5322h.getFloat(4, alpha);
                }
                c4296k2.setAlpha(alpha);
                String string = typedArrayM5322h.getString(0);
                if (string != null) {
                    c4296k2.f14568m = string;
                    c4296k2.f14570o.put(string, c4296k2);
                }
                typedArrayM5322h.recycle();
                c4297l.f14571a = getChangingConfigurations();
                c4297l.f14581k = true;
                C4297l c4297l3 = this.f14585b;
                C4296k c4296k3 = c4297l3.f14572b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(c4296k3.f14562g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z10 = true;
                for (int i12 = 1; eventType != i12 && (xmlPullParser.getDepth() >= depth || eventType != i10); i12 = 1) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        C4293h c4293h = (C4293h) arrayDeque.peek();
                        boolean zEquals = "path".equals(name);
                        C3341e c3341e = c4296k3.f14570o;
                        c4296k = c4296k3;
                        if (zEquals) {
                            C4292g c4292g = new C4292g();
                            c4292g.f14531e = 0.0f;
                            c4292g.f14533g = 1.0f;
                            c4292g.f14534h = 1.0f;
                            c4292g.f14535i = 0.0f;
                            c4292g.f14536j = 1.0f;
                            c4292g.f14537k = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            c4292g.f14538l = cap2;
                            Paint.Join join = Paint.Join.MITER;
                            c4292g.f14539m = join;
                            i6 = depth;
                            c4292g.f14540n = 4.0f;
                            TypedArray typedArrayM5322h2 = AbstractC2343b.m5322h(resources, theme, attributeSet, AbstractC4286a.f14512c);
                            if (AbstractC2343b.m5319e(xmlPullParser, "pathData")) {
                                String string2 = typedArrayM5322h2.getString(0);
                                if (string2 != null) {
                                    c4292g.f14553b = string2;
                                }
                                String string3 = typedArrayM5322h2.getString(2);
                                if (string3 != null) {
                                    c4292g.f14552a = AbstractC1466d.m3488f(string3);
                                }
                                c4292g.f14532f = AbstractC2343b.m5316b(typedArrayM5322h2, xmlPullParser, theme, "fillColor", 1);
                                float f4 = c4292g.f14534h;
                                if (AbstractC2343b.m5319e(xmlPullParser, "fillAlpha")) {
                                    f4 = typedArrayM5322h2.getFloat(12, f4);
                                }
                                c4292g.f14534h = f4;
                                int i13 = !AbstractC2343b.m5319e(xmlPullParser, "strokeLineCap") ? -1 : typedArrayM5322h2.getInt(8, -1);
                                Paint.Cap cap3 = c4292g.f14538l;
                                if (i13 == 0) {
                                    cap = cap2;
                                } else if (i13 != 1) {
                                    cap = i13 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                c4292g.f14538l = cap;
                                int i14 = !AbstractC2343b.m5319e(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayM5322h2.getInt(9, -1);
                                Paint.Join join2 = c4292g.f14539m;
                                if (i14 != 0) {
                                    if (i14 != 1) {
                                        join = i14 != 2 ? join2 : Paint.Join.BEVEL;
                                    } else {
                                        join = Paint.Join.ROUND;
                                    }
                                }
                                c4292g.f14539m = join;
                                float f5 = c4292g.f14540n;
                                if (AbstractC2343b.m5319e(xmlPullParser, "strokeMiterLimit")) {
                                    f5 = typedArrayM5322h2.getFloat(10, f5);
                                }
                                c4292g.f14540n = f5;
                                c4292g.f14530d = AbstractC2343b.m5316b(typedArrayM5322h2, xmlPullParser, theme, "strokeColor", 3);
                                float f10 = c4292g.f14533g;
                                if (AbstractC2343b.m5319e(xmlPullParser, "strokeAlpha")) {
                                    f10 = typedArrayM5322h2.getFloat(11, f10);
                                }
                                c4292g.f14533g = f10;
                                float f11 = c4292g.f14531e;
                                if (AbstractC2343b.m5319e(xmlPullParser, "strokeWidth")) {
                                    f11 = typedArrayM5322h2.getFloat(4, f11);
                                }
                                c4292g.f14531e = f11;
                                float f12 = c4292g.f14536j;
                                if (AbstractC2343b.m5319e(xmlPullParser, "trimPathEnd")) {
                                    f12 = typedArrayM5322h2.getFloat(6, f12);
                                }
                                c4292g.f14536j = f12;
                                float f13 = c4292g.f14537k;
                                if (AbstractC2343b.m5319e(xmlPullParser, "trimPathOffset")) {
                                    f13 = typedArrayM5322h2.getFloat(7, f13);
                                }
                                c4292g.f14537k = f13;
                                float f14 = c4292g.f14535i;
                                if (AbstractC2343b.m5319e(xmlPullParser, "trimPathStart")) {
                                    f14 = typedArrayM5322h2.getFloat(5, f14);
                                }
                                c4292g.f14535i = f14;
                                int i15 = c4292g.f14554c;
                                if (AbstractC2343b.m5319e(xmlPullParser, "fillType")) {
                                    i15 = typedArrayM5322h2.getInt(13, i15);
                                }
                                c4292g.f14554c = i15;
                            }
                            typedArrayM5322h2.recycle();
                            c4293h.f14542b.add(c4292g);
                            if (c4292g.getPathName() != null) {
                                c3341e.put(c4292g.getPathName(), c4292g);
                            }
                            c4297l3.f14571a = c4297l3.f14571a;
                            z10 = false;
                        } else {
                            i6 = depth;
                            if ("clip-path".equals(name)) {
                                C4291f c4291f = new C4291f();
                                if (AbstractC2343b.m5319e(xmlPullParser, "pathData")) {
                                    TypedArray typedArrayM5322h3 = AbstractC2343b.m5322h(resources, theme, attributeSet, AbstractC4286a.f14513d);
                                    String string4 = typedArrayM5322h3.getString(0);
                                    if (string4 != null) {
                                        c4291f.f14553b = string4;
                                    }
                                    String string5 = typedArrayM5322h3.getString(1);
                                    if (string5 != null) {
                                        c4291f.f14552a = AbstractC1466d.m3488f(string5);
                                    }
                                    c4291f.f14554c = !AbstractC2343b.m5319e(xmlPullParser, "fillType") ? 0 : typedArrayM5322h3.getInt(2, 0);
                                    typedArrayM5322h3.recycle();
                                }
                                c4293h.f14542b.add(c4291f);
                                if (c4291f.getPathName() != null) {
                                    c3341e.put(c4291f.getPathName(), c4291f);
                                }
                                c4297l3.f14571a = c4297l3.f14571a;
                            } else if ("group".equals(name)) {
                                C4293h c4293h2 = new C4293h();
                                TypedArray typedArrayM5322h4 = AbstractC2343b.m5322h(resources, theme, attributeSet, AbstractC4286a.f14511b);
                                float f15 = c4293h2.f14543c;
                                if (AbstractC2343b.m5319e(xmlPullParser, "rotation")) {
                                    f15 = typedArrayM5322h4.getFloat(5, f15);
                                }
                                c4293h2.f14543c = f15;
                                c4293h2.f14544d = typedArrayM5322h4.getFloat(1, c4293h2.f14544d);
                                c4293h2.f14545e = typedArrayM5322h4.getFloat(2, c4293h2.f14545e);
                                float f16 = c4293h2.f14546f;
                                if (AbstractC2343b.m5319e(xmlPullParser, "scaleX")) {
                                    f16 = typedArrayM5322h4.getFloat(3, f16);
                                }
                                c4293h2.f14546f = f16;
                                float f17 = c4293h2.f14547g;
                                if (AbstractC2343b.m5319e(xmlPullParser, "scaleY")) {
                                    f17 = typedArrayM5322h4.getFloat(4, f17);
                                }
                                c4293h2.f14547g = f17;
                                float f18 = c4293h2.f14548h;
                                if (AbstractC2343b.m5319e(xmlPullParser, "translateX")) {
                                    f18 = typedArrayM5322h4.getFloat(6, f18);
                                }
                                c4293h2.f14548h = f18;
                                float f19 = c4293h2.f14549i;
                                if (AbstractC2343b.m5319e(xmlPullParser, "translateY")) {
                                    f19 = typedArrayM5322h4.getFloat(7, f19);
                                }
                                c4293h2.f14549i = f19;
                                String string6 = typedArrayM5322h4.getString(0);
                                if (string6 != null) {
                                    c4293h2.f14551k = string6;
                                }
                                c4293h2.m8350c();
                                typedArrayM5322h4.recycle();
                                c4293h.f14542b.add(c4293h2);
                                arrayDeque.push(c4293h2);
                                if (c4293h2.getGroupName() != null) {
                                    c3341e.put(c4293h2.getGroupName(), c4293h2);
                                }
                                c4297l3.f14571a = c4297l3.f14571a;
                            }
                        }
                        i10 = 3;
                    } else {
                        c4296k = c4296k3;
                        i6 = depth;
                        i10 = 3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    c4296k3 = c4296k;
                    depth = i6;
                }
                if (!z10) {
                    this.f14586c = m8352a(c4297l.f14573c, c4297l.f14574d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayM5322h.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayM5322h.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public C4299n(C4297l c4297l) {
        this.f14589f = true;
        this.f14590g = new float[9];
        this.f14591h = new Matrix();
        this.f14592i = new Rect();
        this.f14585b = c4297l;
        this.f14586c = m8352a(c4297l.f14573c, c4297l.f14574d);
    }
}
