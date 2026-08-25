package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import p246x.C4076b;
import p246x.C4077c;
import p256y.AbstractC4193j;

public class ImageFilterView extends AppCompatImageView {

    public final C4077c f1261d;

    public boolean f1262e;

    public float f1263f;

    public float f1264g;

    public float f1265h;

    public Path f1266i;

    public ViewOutlineProvider f1267j;

    public RectF f1268k;

    public Drawable[] f1269l;

    public LayerDrawable f1270m;

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1261d = new C4077c();
        this.f1262e = true;
        this.f1263f = 0.0f;
        this.f1264g = 0.0f;
        this.f1265h = Float.NaN;
        m866c(attributeSet);
    }

    private void setOverlay(boolean z7) {
        this.f1262e = z7;
    }

    public final void m866c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14240f);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 3) {
                    this.f1263f = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
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
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f1262e));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f1269l = drawableArr;
                drawableArr[0] = getDrawable();
                this.f1269l[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f1269l);
                this.f1270m = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f1263f * 255.0f));
                super.setImageDrawable(this.f1270m);
            }
        }
    }

    public float getBrightness() {
        return this.f1261d.f13747d;
    }

    public float getContrast() {
        return this.f1261d.f13749f;
    }

    public float getCrossfade() {
        return this.f1263f;
    }

    public float getRound() {
        return this.f1265h;
    }

    public float getRoundPercent() {
        return this.f1264g;
    }

    public float getSaturation() {
        return this.f1261d.f13748e;
    }

    public float getWarmth() {
        return this.f1261d.f13750g;
    }

    public void setBrightness(float f) {
        C4077c c4077c = this.f1261d;
        c4077c.f13747d = f;
        c4077c.m8066a(this);
    }

    public void setContrast(float f) {
        C4077c c4077c = this.f1261d;
        c4077c.f13749f = f;
        c4077c.m8066a(this);
    }

    public void setCrossfade(float f) {
        this.f1263f = f;
        if (this.f1269l != null) {
            if (!this.f1262e) {
                this.f1270m.getDrawable(0).setAlpha((int) ((1.0f - this.f1263f) * 255.0f));
            }
            this.f1270m.getDrawable(1).setAlpha((int) (this.f1263f * 255.0f));
            super.setImageDrawable(this.f1270m);
        }
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.f1265h = f;
            float f3 = this.f1264g;
            this.f1264g = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z7 = this.f1265h != f;
        this.f1265h = f;
        if (f != 0.0f) {
            if (this.f1266i == null) {
                this.f1266i = new Path();
            }
            if (this.f1268k == null) {
                this.f1268k = new RectF();
            }
            if (this.f1267j == null) {
                C4076b c4076b = new C4076b(this, 1);
                this.f1267j = c4076b;
                setOutlineProvider(c4076b);
            }
            setClipToOutline(true);
            this.f1268k.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1266i.reset();
            Path path = this.f1266i;
            RectF rectF = this.f1268k;
            float f4 = this.f1265h;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z7 = this.f1264g != f;
        this.f1264g = f;
        if (f != 0.0f) {
            if (this.f1266i == null) {
                this.f1266i = new Path();
            }
            if (this.f1268k == null) {
                this.f1268k = new RectF();
            }
            if (this.f1267j == null) {
                C4076b c4076b = new C4076b(this, 0);
                this.f1267j = c4076b;
                setOutlineProvider(c4076b);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f1264g) / 2.0f;
            this.f1268k.set(0.0f, 0.0f, width, height);
            this.f1266i.reset();
            this.f1266i.addRoundRect(this.f1268k, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        C4077c c4077c = this.f1261d;
        c4077c.f13748e = f;
        c4077c.m8066a(this);
    }

    public void setWarmth(float f) {
        C4077c c4077c = this.f1261d;
        c4077c.f13750g = f;
        c4077c.m8066a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1261d = new C4077c();
        this.f1262e = true;
        this.f1263f = 0.0f;
        this.f1264g = 0.0f;
        this.f1265h = Float.NaN;
        m866c(attributeSet);
    }
}
