package p133m6;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import p221u6.C3908h;

public final class C3082a extends ViewOutlineProvider {

    public final Rect f10545a = new Rect();

    public final ShapeableImageView f10546b;

    public C3082a(ShapeableImageView shapeableImageView) {
        this.f10546b = shapeableImageView;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f10546b;
        if (shapeableImageView.f6307l == null) {
            return;
        }
        if (shapeableImageView.f6306k == null) {
            shapeableImageView.f6306k = new C3908h(shapeableImageView.f6307l);
        }
        RectF rectF = shapeableImageView.f6300e;
        Rect rect = this.f10545a;
        rectF.round(rect);
        shapeableImageView.f6306k.setBounds(rect);
        shapeableImageView.f6306k.getOutline(outline);
    }
}
