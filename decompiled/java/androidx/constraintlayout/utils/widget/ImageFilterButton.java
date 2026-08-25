package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageButton;
import p246x.C4075a;
import p246x.C4077c;
import p256y.AbstractC4193j;

public class ImageFilterButton extends AppCompatImageButton {

    public final C4077c f1251d;

    public float f1252e;

    public float f1253f;

    public float f1254g;

    public Path f1255h;

    public ViewOutlineProvider f1256i;

    public RectF f1257j;

    public Drawable[] f1258k;

    public LayerDrawable f1259l;

    public boolean f1260m;

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1251d = new C4077c();
        this.f1252e = 0.0f;
        this.f1253f = 0.0f;
        this.f1254g = Float.NaN;
        this.f1260m = true;
        m865a(attributeSet);
    }

    private void setOverlay(boolean z7) {
        this.f1260m = z7;
    }

    public final void m865a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14240f);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 3) {
                    this.f1252e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == 8) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 7) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 2) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 5) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 6) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 4) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f1260m));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f1258k = drawableArr;
                drawableArr[0] = getDrawable();
                this.f1258k[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f1258k);
                this.f1259l = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f1252e * 255.0f));
                super.setImageDrawable(this.f1259l);
            }
        }
    }

    public float getContrast() {
        return this.f1251d.f13749f;
    }

    public float getCrossfade() {
        return this.f1252e;
    }

    public float getRound() {
        return this.f1254g;
    }

    public float getRoundPercent() {
        return this.f1253f;
    }

    public float getSaturation() {
        return this.f1251d.f13748e;
    }

    public float getWarmth() {
        return this.f1251d.f13750g;
    }

    public void setBrightness(float f) {
        C4077c c4077c = this.f1251d;
        c4077c.f13747d = f;
        c4077c.m8066a(this);
    }

    public void setContrast(float f) {
        C4077c c4077c = this.f1251d;
        c4077c.f13749f = f;
        c4077c.m8066a(this);
    }

    public void setCrossfade(float f) {
        this.f1252e = f;
        if (this.f1258k != null) {
            if (!this.f1260m) {
                this.f1259l.getDrawable(0).setAlpha((int) ((1.0f - this.f1252e) * 255.0f));
            }
            this.f1259l.getDrawable(1).setAlpha((int) (this.f1252e * 255.0f));
            super.setImageDrawable(this.f1259l);
        }
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.f1254g = f;
            float f3 = this.f1253f;
            this.f1253f = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z7 = this.f1254g != f;
        this.f1254g = f;
        if (f != 0.0f) {
            if (this.f1255h == null) {
                this.f1255h = new Path();
            }
            if (this.f1257j == null) {
                this.f1257j = new RectF();
            }
            if (this.f1256i == null) {
                C4075a c4075a = new C4075a(this, 1);
                this.f1256i = c4075a;
                setOutlineProvider(c4075a);
            }
            setClipToOutline(true);
            this.f1257j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1255h.reset();
            Path path = this.f1255h;
            RectF rectF = this.f1257j;
            float f4 = this.f1254g;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z7 = this.f1253f != f;
        this.f1253f = f;
        if (f != 0.0f) {
            if (this.f1255h == null) {
                this.f1255h = new Path();
            }
            if (this.f1257j == null) {
                this.f1257j = new RectF();
            }
            if (this.f1256i == null) {
                C4075a c4075a = new C4075a(this, 0);
                this.f1256i = c4075a;
                setOutlineProvider(c4075a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f1253f) / 2.0f;
            this.f1257j.set(0.0f, 0.0f, width, height);
            this.f1255h.reset();
            this.f1255h.addRoundRect(this.f1257j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        C4077c c4077c = this.f1251d;
        c4077c.f13748e = f;
        c4077c.m8066a(this);
    }

    public void setWarmth(float f) {
        C4077c c4077c = this.f1251d;
        c4077c.f13750g = f;
        c4077c.m8066a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1251d = new C4077c();
        this.f1252e = 0.0f;
        this.f1253f = 0.0f;
        this.f1254g = Float.NaN;
        this.f1260m = true;
        m865a(attributeSet);
    }
}
