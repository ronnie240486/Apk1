package p221u6;

import android.graphics.Matrix;
import android.graphics.Path;

public final class C3920t extends AbstractC3921u {

    public float f13202b;

    public float f13203c;

    @Override
    public final void mo7831a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f13204a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f13202b, this.f13203c);
        path.transform(matrix);
    }
}
