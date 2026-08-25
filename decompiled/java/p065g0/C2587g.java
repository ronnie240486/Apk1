package p065g0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.alibaba.fastjson.asm.Opcodes;

public final class C2587g extends Drawable {

    public final Bitmap f9016a;

    public final int f9017b;

    public final BitmapShader f9020e;

    public float f9022g;

    public final int f9026k;

    public final int f9027l;

    public final int f9018c = 119;

    public final Paint f9019d = new Paint(3);

    public final Matrix f9021f = new Matrix();

    public final Rect f9023h = new Rect();

    public final RectF f9024i = new RectF();

    public boolean f9025j = true;

    public C2587g(Resources resources, Bitmap bitmap) {
        this.f9017b = Opcodes.IF_ICMPNE;
        if (resources != null) {
            this.f9017b = resources.getDisplayMetrics().densityDpi;
        }
        this.f9016a = bitmap;
        if (bitmap == null) {
            this.f9027l = -1;
            this.f9026k = -1;
            this.f9020e = null;
        } else {
            int i6 = this.f9017b;
            this.f9026k = bitmap.getScaledWidth(i6);
            this.f9027l = bitmap.getScaledHeight(i6);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f9020e = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public final void m5603a(float f) {
        if (this.f9022g == f) {
            return;
        }
        boolean z7 = f > 0.05f;
        Paint paint = this.f9019d;
        if (z7) {
            paint.setShader(this.f9020e);
        } else {
            paint.setShader(null);
        }
        this.f9022g = f;
        invalidateSelf();
    }

    public final void m5604b() {
        if (this.f9025j) {
            Gravity.apply(this.f9018c, this.f9026k, this.f9027l, getBounds(), this.f9023h, 0);
            RectF rectF = this.f9024i;
            rectF.set(this.f9023h);
            BitmapShader bitmapShader = this.f9020e;
            if (bitmapShader != null) {
                Matrix matrix = this.f9021f;
                matrix.setTranslate(rectF.left, rectF.top);
                float fWidth = rectF.width();
                Bitmap bitmap = this.f9016a;
                matrix.preScale(fWidth / bitmap.getWidth(), rectF.height() / bitmap.getHeight());
                bitmapShader.setLocalMatrix(matrix);
                this.f9019d.setShader(bitmapShader);
            }
            this.f9025j = false;
        }
    }

    @Override
    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.f9016a;
        if (bitmap == null) {
            return;
        }
        m5604b();
        Paint paint = this.f9019d;
        if (paint.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f9023h, paint);
            return;
        }
        RectF rectF = this.f9024i;
        float f = this.f9022g;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override
    public final int getAlpha() {
        return this.f9019d.getAlpha();
    }

    @Override
    public final ColorFilter getColorFilter() {
        return this.f9019d.getColorFilter();
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f9027l;
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f9026k;
    }

    @Override
    public final int getOpacity() {
        Bitmap bitmap;
        return (this.f9018c != 119 || (bitmap = this.f9016a) == null || bitmap.hasAlpha() || this.f9019d.getAlpha() < 255 || this.f9022g > 0.05f) ? -3 : -1;
    }

    @Override
    public final void getOutline(Outline outline) {
        m5604b();
        outline.setRoundRect(this.f9023h, this.f9022g);
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9025j = true;
    }

    @Override
    public final void setAlpha(int i6) {
        Paint paint = this.f9019d;
        if (i6 != paint.getAlpha()) {
            paint.setAlpha(i6);
            invalidateSelf();
        }
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9019d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public final void setDither(boolean z7) {
        this.f9019d.setDither(z7);
        invalidateSelf();
    }

    @Override
    public final void setFilterBitmap(boolean z7) {
        this.f9019d.setFilterBitmap(z7);
        invalidateSelf();
    }
}
