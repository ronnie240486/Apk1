package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import p138n0.AbstractC3155s0;

public class HorizontalGridView extends AbstractC0474j {

    public boolean f2142g;

    public boolean f2143h;

    public final Paint f2144i;

    public Bitmap f2145j;

    public LinearGradient f2146k;

    public int f2147l;

    public int f2148m;

    public Bitmap f2149n;

    public LinearGradient f2150o;

    public int f2151p;

    public int f2152q;

    public final Rect f2153r;

    public HorizontalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Bitmap getTempBitmapHigh() {
        Bitmap bitmap = this.f2149n;
        if (bitmap == null || bitmap.getWidth() != this.f2151p || this.f2149n.getHeight() != getHeight()) {
            this.f2149n = Bitmap.createBitmap(this.f2151p, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f2149n;
    }

    private Bitmap getTempBitmapLow() {
        Bitmap bitmap = this.f2145j;
        if (bitmap == null || bitmap.getWidth() != this.f2147l || this.f2145j.getHeight() != getHeight()) {
            this.f2145j = Bitmap.createBitmap(this.f2147l, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f2145j;
    }

    public final void m1387c() {
        if (this.f2142g || this.f2143h) {
            setLayerType(2, null);
            setWillNotDraw(false);
        } else {
            setLayerType(0, null);
            setWillNotDraw(true);
        }
    }

    @Override
    public final void draw(Canvas canvas) {
        boolean z7;
        boolean z10 = true;
        if (!this.f2142g) {
            z7 = false;
            break;
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                z7 = false;
                break;
            }
            View childAt = getChildAt(i6);
            this.f2345a.getClass();
            C0496t c0496t = (C0496t) childAt.getLayoutParams();
            c0496t.getClass();
            if (childAt.getLeft() + c0496t.f2437e < getPaddingLeft() - this.f2148m) {
                z7 = true;
                break;
            }
            i6++;
        }
        if (!this.f2143h) {
            z10 = false;
            break;
        }
        int childCount2 = getChildCount() - 1;
        while (true) {
            if (childCount2 < 0) {
                z10 = false;
                break;
            }
            View childAt2 = getChildAt(childCount2);
            this.f2345a.getClass();
            C0496t c0496t2 = (C0496t) childAt2.getLayoutParams();
            c0496t2.getClass();
            if (childAt2.getRight() - c0496t2.f2439g > (getWidth() - getPaddingRight()) + this.f2152q) {
                break;
            } else {
                childCount2--;
            }
        }
        if (!z7) {
            this.f2145j = null;
        }
        if (!z10) {
            this.f2149n = null;
        }
        if (!z7 && !z10) {
            super.draw(canvas);
            return;
        }
        int paddingLeft = this.f2142g ? (getPaddingLeft() - this.f2148m) - this.f2147l : 0;
        int width = this.f2143h ? (getWidth() - getPaddingRight()) + this.f2152q + this.f2151p : getWidth();
        int iSave = canvas.save();
        canvas.clipRect((this.f2142g ? this.f2147l : 0) + paddingLeft, 0, width - (this.f2143h ? this.f2151p : 0), getHeight());
        super.draw(canvas);
        canvas.restoreToCount(iSave);
        Canvas canvas2 = new Canvas();
        Rect rect = this.f2153r;
        rect.top = 0;
        rect.bottom = getHeight();
        if (z7 && this.f2147l > 0) {
            Bitmap tempBitmapLow = getTempBitmapLow();
            tempBitmapLow.eraseColor(0);
            canvas2.setBitmap(tempBitmapLow);
            int iSave2 = canvas2.save();
            canvas2.clipRect(0, 0, this.f2147l, getHeight());
            float f = -paddingLeft;
            canvas2.translate(f, 0.0f);
            super.draw(canvas2);
            canvas2.restoreToCount(iSave2);
            this.f2144i.setShader(this.f2146k);
            canvas2.drawRect(0.0f, 0.0f, this.f2147l, getHeight(), this.f2144i);
            rect.left = 0;
            rect.right = this.f2147l;
            canvas.translate(paddingLeft, 0.0f);
            canvas.drawBitmap(tempBitmapLow, rect, rect, (Paint) null);
            canvas.translate(f, 0.0f);
        }
        if (!z10 || this.f2151p <= 0) {
            return;
        }
        Bitmap tempBitmapHigh = getTempBitmapHigh();
        tempBitmapHigh.eraseColor(0);
        canvas2.setBitmap(tempBitmapHigh);
        int iSave3 = canvas2.save();
        canvas2.clipRect(0, 0, this.f2151p, getHeight());
        canvas2.translate(-(width - this.f2151p), 0.0f);
        super.draw(canvas2);
        canvas2.restoreToCount(iSave3);
        this.f2144i.setShader(this.f2150o);
        canvas2.drawRect(0.0f, 0.0f, this.f2151p, getHeight(), this.f2144i);
        rect.left = 0;
        int i10 = this.f2151p;
        rect.right = i10;
        canvas.translate(width - i10, 0.0f);
        canvas.drawBitmap(tempBitmapHigh, rect, rect, (Paint) null);
        canvas.translate(-(width - this.f2151p), 0.0f);
    }

    @SuppressLint({"GetterSetterNames"})
    public final boolean getFadingLeftEdge() {
        return this.f2142g;
    }

    public final int getFadingLeftEdgeLength() {
        return this.f2147l;
    }

    public final int getFadingLeftEdgeOffset() {
        return this.f2148m;
    }

    @SuppressLint({"GetterSetterNames"})
    public final boolean getFadingRightEdge() {
        return this.f2143h;
    }

    public final int getFadingRightEdgeLength() {
        return this.f2151p;
    }

    public final int getFadingRightEdgeOffset() {
        return this.f2152q;
    }

    public final void setFadingLeftEdge(boolean z7) {
        if (this.f2142g != z7) {
            this.f2142g = z7;
            if (!z7) {
                this.f2145j = null;
            }
            invalidate();
            m1387c();
        }
    }

    public final void setFadingLeftEdgeLength(int i6) {
        if (this.f2147l != i6) {
            this.f2147l = i6;
            if (i6 != 0) {
                this.f2146k = new LinearGradient(0.0f, 0.0f, this.f2147l, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
            } else {
                this.f2146k = null;
            }
            invalidate();
        }
    }

    public final void setFadingLeftEdgeOffset(int i6) {
        if (this.f2148m != i6) {
            this.f2148m = i6;
            invalidate();
        }
    }

    public final void setFadingRightEdge(boolean z7) {
        if (this.f2143h != z7) {
            this.f2143h = z7;
            if (!z7) {
                this.f2149n = null;
            }
            invalidate();
            m1387c();
        }
    }

    public final void setFadingRightEdgeLength(int i6) {
        if (this.f2151p != i6) {
            this.f2151p = i6;
            if (i6 != 0) {
                this.f2150o = new LinearGradient(0.0f, 0.0f, this.f2151p, 0.0f, -16777216, 0, Shader.TileMode.CLAMP);
            } else {
                this.f2150o = null;
            }
            invalidate();
        }
    }

    public final void setFadingRightEdgeOffset(int i6) {
        if (this.f2152q != i6) {
            this.f2152q = i6;
            invalidate();
        }
    }

    public void setNumRows(int i6) {
        GridLayoutManager gridLayoutManager = this.f2345a;
        if (i6 < 0) {
            gridLayoutManager.getClass();
            throw new IllegalArgumentException();
        }
        gridLayoutManager.f2094F = i6;
        requestLayout();
    }

    public void setRowHeight(TypedArray typedArray) {
        if (typedArray.peekValue(1) != null) {
            setRowHeight(typedArray.getLayoutDimension(1, 0));
        }
    }

    public HorizontalGridView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2144i = new Paint();
        this.f2153r = new Rect();
        this.f2345a.setOrientation(0);
        m1440b(context, attributeSet);
        int[] iArr = AbstractC0483m0.f2369b;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        setRowHeight(typedArrayObtainStyledAttributes);
        setNumRows(typedArrayObtainStyledAttributes.getInt(0, 1));
        typedArrayObtainStyledAttributes.recycle();
        m1387c();
        Paint paint = new Paint();
        this.f2144i = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRowHeight(int i6) {
        this.f2345a.m1357I(i6);
        requestLayout();
    }
}
