package p124l6;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import p262y5.AbstractC4268a;

public final class C2975a extends Property {

    public final int f10192a = 2;

    public Object f10193b;

    public C2975a(Class cls, String str) {
        super(cls, str);
    }

    @Override
    public final Object get(Object obj) {
        switch (this.f10192a) {
            case 0:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                return Float.valueOf(AbstractC4268a.m8309a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.f6270E.getColorForState(extendedFloatingActionButton.getDrawableState(), ((AbstractC2976b) this.f10193b).f10195b.f6270E.getDefaultColor()))));
            case 1:
                Rect rect = (Rect) this.f10193b;
                ((Drawable) obj).copyBounds(rect);
                return new PointF(rect.left, rect.top);
            default:
                Matrix matrix = (Matrix) this.f10193b;
                matrix.set(((ImageView) obj).getImageMatrix());
                return matrix;
        }
    }

    @Override
    public final void set(Object obj, Object obj2) {
        switch (this.f10192a) {
            case 0:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                Float f = (Float) obj2;
                int colorForState = extendedFloatingActionButton.f6270E.getColorForState(extendedFloatingActionButton.getDrawableState(), ((AbstractC2976b) this.f10193b).f10195b.f6270E.getDefaultColor());
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AbstractC4268a.m8309a(0.0f, Color.alpha(colorForState) / 255.0f, f.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                if (f.floatValue() != 1.0f) {
                    extendedFloatingActionButton.m4215g(colorStateListValueOf);
                } else {
                    extendedFloatingActionButton.m4215g(extendedFloatingActionButton.f6270E);
                }
                break;
            case 1:
                Drawable drawable = (Drawable) obj;
                PointF pointF = (PointF) obj2;
                Rect rect = (Rect) this.f10193b;
                drawable.copyBounds(rect);
                rect.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(rect);
                break;
            default:
                ((ImageView) obj).setImageMatrix((Matrix) obj2);
                break;
        }
    }

    public C2975a() {
        super(Matrix.class, "imageMatrixProperty");
        this.f10193b = new Matrix();
    }

    public C2975a(AbstractC2976b abstractC2976b) {
        super(Float.class, "LABEL_OPACITY_PROPERTY");
        this.f10193b = abstractC2976b;
    }
}
