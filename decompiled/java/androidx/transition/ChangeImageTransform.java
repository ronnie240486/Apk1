package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.C0209g3;
import java.util.HashMap;
import p258y1.AbstractC4207f;
import p258y1.AbstractC4228q;
import p258y1.C4202c0;
import p258y1.C4205e;
import p258y1.C4206e0;
import p258y1.C4227p;

public class ChangeImageTransform extends Transition {

    public static final String[] f3763x = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    public static final C4205e f3764y = new C4205e();

    public static final C0209g3 f3765z = new C0209g3("animatedTransform", Matrix.class, 15);

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void m3035F(C4206e0 c4206e0) {
        Matrix matrix;
        View view = c4206e0.f14293b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            HashMap map = c4206e0.f14292a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Drawable drawable = imageView.getDrawable();
            if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                matrix = new Matrix(imageView.getImageMatrix());
            } else {
                int i6 = AbstractC4207f.f14295a[imageView.getScaleType().ordinal()];
                if (i6 == 1) {
                    Drawable drawable2 = imageView.getDrawable();
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(imageView.getWidth() / drawable2.getIntrinsicWidth(), imageView.getHeight() / drawable2.getIntrinsicHeight());
                    matrix = matrix2;
                } else if (i6 != 2) {
                    matrix = new Matrix(imageView.getImageMatrix());
                } else {
                    Drawable drawable3 = imageView.getDrawable();
                    int intrinsicWidth = drawable3.getIntrinsicWidth();
                    float width = imageView.getWidth();
                    float f = intrinsicWidth;
                    int intrinsicHeight = drawable3.getIntrinsicHeight();
                    float height = imageView.getHeight();
                    float f3 = intrinsicHeight;
                    float fMax = Math.max(width / f, height / f3);
                    int iRound = Math.round((width - (f * fMax)) / 2.0f);
                    int iRound2 = Math.round((height - (f3 * fMax)) / 2.0f);
                    matrix = new Matrix();
                    matrix.postScale(fMax, fMax);
                    matrix.postTranslate(iRound, iRound2);
                }
            }
            map.put("android:changeImageTransform:matrix", matrix);
        }
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        m3035F(c4206e0);
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        m3035F(c4206e0);
    }

    @Override
    public final Animator mo3032j(ViewGroup viewGroup, C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e0 != null && c4206e1 != null) {
            HashMap map = c4206e0.f14292a;
            Rect rect = (Rect) map.get("android:changeImageTransform:bounds");
            HashMap map2 = c4206e1.f14292a;
            Rect rect2 = (Rect) map2.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) map.get("android:changeImageTransform:matrix");
                Object obj = (Matrix) map2.get("android:changeImageTransform:matrix");
                boolean z7 = (matrix == null && obj == null) || (matrix != null && matrix.equals(obj));
                if (rect.equals(rect2) && z7) {
                    return null;
                }
                ImageView imageView = (ImageView) c4206e1.f14293b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                C0209g3 c0209g3 = f3765z;
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    C4205e c4205e = f3764y;
                    C4227p c4227p = AbstractC4228q.f14367a;
                    return ObjectAnimator.ofObject(imageView, c0209g3, c4205e, c4227p, c4227p);
                }
                if (matrix == null) {
                    matrix = AbstractC4228q.f14367a;
                }
                if (obj == null) {
                    obj = AbstractC4228q.f14367a;
                }
                c0209g3.set(imageView, matrix);
                return ObjectAnimator.ofObject(imageView, c0209g3, new C4202c0(), matrix, obj);
            }
        }
        return null;
    }

    @Override
    public final String[] mo3033o() {
        return f3763x;
    }
}
