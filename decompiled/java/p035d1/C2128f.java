package p035d1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1466d;

public final class C2128f extends AbstractC1466d {

    public final TextView f7740a;

    public final C2126d f7741b;

    public boolean f7742c = true;

    public C2128f(TextView textView) {
        this.f7740a = textView;
        this.f7741b = new C2126d(textView);
    }

    @Override
    public final void mo3509E(boolean z7) {
        if (z7) {
            TextView textView = this.f7740a;
            textView.setTransformationMethod(mo3511I(textView.getTransformationMethod()));
        }
    }

    @Override
    public final void mo3510F(boolean z7) {
        this.f7742c = z7;
        TextView textView = this.f7740a;
        textView.setTransformationMethod(mo3511I(textView.getTransformationMethod()));
        textView.setFilters(mo3515o(textView.getFilters()));
    }

    @Override
    public final TransformationMethod mo3511I(TransformationMethod transformationMethod) {
        if (this.f7742c) {
            return ((transformationMethod instanceof C2131i) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new C2131i(transformationMethod);
        }
        return transformationMethod instanceof C2131i ? ((C2131i) transformationMethod).f7747a : transformationMethod;
    }

    @Override
    public final InputFilter[] mo3515o(InputFilter[] inputFilterArr) {
        if (!this.f7742c) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i6 = 0; i6 < inputFilterArr.length; i6++) {
                InputFilter inputFilter = inputFilterArr[i6];
                if (inputFilter instanceof C2126d) {
                    sparseArray.put(i6, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArray.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i12 = 0;
        while (true) {
            C2126d c2126d = this.f7741b;
            if (i12 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = c2126d;
                return inputFilterArr3;
            }
            if (inputFilterArr[i12] == c2126d) {
                return inputFilterArr;
            }
            i12++;
        }
    }

    @Override
    public final boolean mo3516t() {
        return this.f7742c;
    }
}
