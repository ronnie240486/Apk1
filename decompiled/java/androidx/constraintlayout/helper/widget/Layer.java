package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import p225v.C3958e;
import p256y.AbstractC4193j;

public class Layer extends ConstraintHelper {

    public float f1170h;

    public float f1171i;

    public float f1172j;

    public ConstraintLayout f1173k;

    public float f1174l;

    public float f1175m;

    public float f1176n;

    public float f1177o;

    public float f1178p;

    public float f1179q;

    public float f1180r;

    public float f1181s;

    public final boolean f1182t;

    public View[] f1183u;

    public float f1184v;

    public float f1185w;

    public boolean f1186x;

    public boolean f1187y;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1170h = Float.NaN;
        this.f1171i = Float.NaN;
        this.f1172j = Float.NaN;
        this.f1174l = 1.0f;
        this.f1175m = 1.0f;
        this.f1176n = Float.NaN;
        this.f1177o = Float.NaN;
        this.f1178p = Float.NaN;
        this.f1179q = Float.NaN;
        this.f1180r = Float.NaN;
        this.f1181s = Float.NaN;
        this.f1182t = true;
        this.f1183u = null;
        this.f1184v = 0.0f;
        this.f1185w = 0.0f;
    }

    @Override
    public final void mo841g(AttributeSet attributeSet) {
        super.mo841g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 6) {
                    this.f1186x = true;
                } else if (index == 13) {
                    this.f1187y = true;
                }
            }
        }
    }

    @Override
    public final void mo845j() {
        m848n();
        this.f1176n = Float.NaN;
        this.f1177o = Float.NaN;
        C3958e c3958e = ((ConstraintLayout.LayoutParams) getLayoutParams()).f1364l0;
        c3958e.m7918z(0);
        c3958e.m7915w(0);
        m847m();
        layout(((int) this.f1180r) - getPaddingLeft(), ((int) this.f1181s) - getPaddingTop(), getPaddingRight() + ((int) this.f1178p), getPaddingBottom() + ((int) this.f1179q));
        if (Float.isNaN(this.f1172j)) {
            return;
        }
        m849o();
    }

    @Override
    public final void mo846k(ConstraintLayout constraintLayout) {
        this.f1173k = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f1172j = rotation;
        } else {
            if (Float.isNaN(this.f1172j)) {
                return;
            }
            this.f1172j = rotation;
        }
    }

    public final void m847m() {
        if (this.f1173k == null) {
            return;
        }
        if (this.f1182t || Float.isNaN(this.f1176n) || Float.isNaN(this.f1177o)) {
            if (!Float.isNaN(this.f1170h) && !Float.isNaN(this.f1171i)) {
                this.f1177o = this.f1171i;
                this.f1176n = this.f1170h;
                return;
            }
            View[] viewArrM875f = m875f(this.f1173k);
            int left = viewArrM875f[0].getLeft();
            int top = viewArrM875f[0].getTop();
            int right = viewArrM875f[0].getRight();
            int bottom = viewArrM875f[0].getBottom();
            for (int i6 = 0; i6 < this.f1293b; i6++) {
                View view = viewArrM875f[i6];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f1178p = right;
            this.f1179q = bottom;
            this.f1180r = left;
            this.f1181s = top;
            if (Float.isNaN(this.f1170h)) {
                this.f1176n = (left + right) / 2;
            } else {
                this.f1176n = this.f1170h;
            }
            if (Float.isNaN(this.f1171i)) {
                this.f1177o = (top + bottom) / 2;
            } else {
                this.f1177o = this.f1171i;
            }
        }
    }

    public final void m848n() {
        int i6;
        if (this.f1173k == null || (i6 = this.f1293b) == 0) {
            return;
        }
        View[] viewArr = this.f1183u;
        if (viewArr == null || viewArr.length != i6) {
            this.f1183u = new View[i6];
        }
        for (int i10 = 0; i10 < this.f1293b; i10++) {
            this.f1183u[i10] = this.f1173k.m878d(this.f1292a[i10]);
        }
    }

    public final void m849o() {
        if (this.f1173k == null) {
            return;
        }
        if (this.f1183u == null) {
            m848n();
        }
        m847m();
        double radians = Math.toRadians(this.f1172j);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f = this.f1174l;
        float f3 = f * fCos;
        float f4 = this.f1175m;
        float f5 = (-f4) * fSin;
        float f10 = f * fSin;
        float f11 = f4 * fCos;
        for (int i6 = 0; i6 < this.f1293b; i6++) {
            View view = this.f1183u[i6];
            int right = (view.getRight() + view.getLeft()) / 2;
            int bottom = (view.getBottom() + view.getTop()) / 2;
            float f12 = right - this.f1176n;
            float f13 = bottom - this.f1177o;
            float f14 = (((f5 * f13) + (f3 * f12)) - f12) + this.f1184v;
            float f15 = (((f11 * f13) + (f12 * f10)) - f13) + this.f1185w;
            view.setTranslationX(f14);
            view.setTranslationY(f15);
            view.setScaleY(this.f1175m);
            view.setScaleX(this.f1174l);
            view.setRotation(this.f1172j);
        }
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1173k = (ConstraintLayout) getParent();
        if (this.f1186x || this.f1187y) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i6 = 0; i6 < this.f1293b; i6++) {
                View viewM878d = this.f1173k.m878d(this.f1292a[i6]);
                if (viewM878d != null) {
                    if (this.f1186x) {
                        viewM878d.setVisibility(visibility);
                    }
                    if (this.f1187y && elevation > 0.0f) {
                        viewM878d.setTranslationZ(viewM878d.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        m872c();
    }

    @Override
    public void setPivotX(float f) {
        this.f1170h = f;
        m849o();
    }

    @Override
    public void setPivotY(float f) {
        this.f1171i = f;
        m849o();
    }

    @Override
    public void setRotation(float f) {
        this.f1172j = f;
        m849o();
    }

    @Override
    public void setScaleX(float f) {
        this.f1174l = f;
        m849o();
    }

    @Override
    public void setScaleY(float f) {
        this.f1175m = f;
        m849o();
    }

    @Override
    public void setTranslationX(float f) {
        this.f1184v = f;
        m849o();
    }

    @Override
    public void setTranslationY(float f) {
        this.f1185w = f;
        m849o();
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        m872c();
    }

    public Layer(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1170h = Float.NaN;
        this.f1171i = Float.NaN;
        this.f1172j = Float.NaN;
        this.f1174l = 1.0f;
        this.f1175m = 1.0f;
        this.f1176n = Float.NaN;
        this.f1177o = Float.NaN;
        this.f1178p = Float.NaN;
        this.f1179q = Float.NaN;
        this.f1180r = Float.NaN;
        this.f1181s = Float.NaN;
        this.f1182t = true;
        this.f1183u = null;
        this.f1184v = 0.0f;
        this.f1185w = 0.0f;
    }
}
