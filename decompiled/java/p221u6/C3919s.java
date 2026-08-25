package p221u6;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

public final class C3919s extends AbstractC3921u {

    public static final RectF f13195h = new RectF();

    public final float f13196b;

    public final float f13197c;

    public final float f13198d;

    public final float f13199e;

    public float f13200f;

    public float f13201g;

    public C3919s(float f, float f3, float f4, float f5) {
        this.f13196b = f;
        this.f13197c = f3;
        this.f13198d = f4;
        this.f13199e = f5;
    }

    @Override
    public final void mo7831a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f13204a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f13195h;
        rectF.set(this.f13196b, this.f13197c, this.f13198d, this.f13199e);
        path.arcTo(rectF, this.f13200f, this.f13201g, false);
        path.transform(matrix);
    }
}
