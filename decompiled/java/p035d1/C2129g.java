package p035d1;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1466d;
import p014b1.C1235i;

public final class C2129g extends AbstractC1466d {

    public final C2128f f7743a;

    public C2129g(TextView textView) {
        this.f7743a = new C2128f(textView);
    }

    @Override
    public final void mo3509E(boolean z7) {
        if (C1235i.f3923j != null) {
            this.f7743a.mo3509E(z7);
        }
    }

    @Override
    public final void mo3510F(boolean z7) {
        boolean z10 = C1235i.f3923j != null;
        C2128f c2128f = this.f7743a;
        if (z10) {
            c2128f.mo3510F(z7);
        } else {
            c2128f.f7742c = z7;
        }
    }

    @Override
    public final TransformationMethod mo3511I(TransformationMethod transformationMethod) {
        return !(C1235i.f3923j != null) ? transformationMethod : this.f7743a.mo3511I(transformationMethod);
    }

    @Override
    public final InputFilter[] mo3515o(InputFilter[] inputFilterArr) {
        return !(C1235i.f3923j != null) ? inputFilterArr : this.f7743a.mo3515o(inputFilterArr);
    }

    @Override
    public final boolean mo3516t() {
        return this.f7743a.f7742c;
    }
}
