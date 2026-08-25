package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import p124l6.C2982h;
import p137n.AbstractC3099a;
import p147o.C3224a;
import p221u6.C3905e;

public class CardView extends FrameLayout {

    public static final int[] f1162f = {R.attr.colorBackground};

    public static final C3905e f1163g = new C3905e(28);

    public boolean f1164a;

    public boolean f1165b;

    public final Rect f1166c;

    public final Rect f1167d;

    public final C2982h f1168e;

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.cardViewStyle);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((C3224a) ((Drawable) this.f1168e.f10225b)).f10832h;
    }

    public float getCardElevation() {
        return ((CardView) this.f1168e.f10226c).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f1166c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1166c.left;
    }

    public int getContentPaddingRight() {
        return this.f1166c.right;
    }

    public int getContentPaddingTop() {
        return this.f1166c.top;
    }

    public float getMaxCardElevation() {
        return ((C3224a) ((Drawable) this.f1168e.f10225b)).f10829e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f1165b;
    }

    public float getRadius() {
        return ((C3224a) ((Drawable) this.f1168e.f10225b)).f10825a;
    }

    public boolean getUseCompatPadding() {
        return this.f1164a;
    }

    @Override
    public void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
    }

    public void setCardBackgroundColor(int i6) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i6);
        C3224a c3224a = (C3224a) ((Drawable) this.f1168e.f10225b);
        if (colorStateListValueOf == null) {
            c3224a.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        c3224a.f10832h = colorStateListValueOf;
        c3224a.f10826b.setColor(colorStateListValueOf.getColorForState(c3224a.getState(), c3224a.f10832h.getDefaultColor()));
        c3224a.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.f1168e.f10226c).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        f1163g.m7797i(this.f1168e, f);
    }

    @Override
    public void setMinimumHeight(int i6) {
        super.setMinimumHeight(i6);
    }

    @Override
    public void setMinimumWidth(int i6) {
        super.setMinimumWidth(i6);
    }

    public void setPreventCornerOverlap(boolean z7) {
        if (z7 != this.f1165b) {
            this.f1165b = z7;
            C3905e c3905e = f1163g;
            C2982h c2982h = this.f1168e;
            c3905e.m7797i(c2982h, ((C3224a) ((Drawable) c2982h.f10225b)).f10829e);
        }
    }

    public void setRadius(float f) {
        C3224a c3224a = (C3224a) ((Drawable) this.f1168e.f10225b);
        if (f == c3224a.f10825a) {
            return;
        }
        c3224a.f10825a = f;
        c3224a.m6509b(null);
        c3224a.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f1164a != z7) {
            this.f1164a = z7;
            C3905e c3905e = f1163g;
            C2982h c2982h = this.f1168e;
            c3905e.m7797i(c2982h, ((C3224a) ((Drawable) c2982h.f10225b)).f10829e);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i6) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i6);
        Rect rect = new Rect();
        this.f1166c = rect;
        this.f1167d = new Rect();
        C2982h c2982h = new C2982h(this);
        this.f1168e = c2982h;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3099a.f10567a, i6, com.p2serv.android.p032ds.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f1162f);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(com.p2serv.android.p032ds.R.color.cardview_light_background) : getResources().getColor(com.p2serv.android.p032ds.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.f1164a = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f1165b = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        C3905e c3905e = f1163g;
        C3224a c3224a = new C3224a(colorStateListValueOf, dimension);
        c2982h.f10225b = c3224a;
        setBackgroundDrawable(c3224a);
        setClipToOutline(true);
        setElevation(dimension2);
        c3905e.m7797i(c2982h, dimension3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        C3224a c3224a = (C3224a) ((Drawable) this.f1168e.f10225b);
        if (colorStateList == null) {
            c3224a.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        c3224a.f10832h = colorStateList;
        c3224a.f10826b.setColor(colorStateList.getColorForState(c3224a.getState(), c3224a.f10832h.getDefaultColor()));
        c3224a.invalidateSelf();
    }

    @Override
    public final void setPadding(int i6, int i10, int i11, int i12) {
    }

    @Override
    public final void setPaddingRelative(int i6, int i10, int i11, int i12) {
    }
}
