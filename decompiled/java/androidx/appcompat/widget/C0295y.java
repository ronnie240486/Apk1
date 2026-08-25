package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1466d;
import p001a0.C0019b;
import p045e.AbstractC2341a;

public final class C0295y {

    public final TextView f1134a;

    public final C0019b f1135b;

    public C0295y(TextView textView) {
        this.f1134a = textView;
        this.f1135b = new C0019b(textView);
    }

    public final InputFilter[] m828a(InputFilter[] inputFilterArr) {
        return ((AbstractC1466d) this.f1135b.f38b).mo3515o(inputFilterArr);
    }

    public final void m829b(AttributeSet attributeSet, int i6) {
        TypedArray typedArrayObtainStyledAttributes = this.f1134a.getContext().obtainStyledAttributes(attributeSet, AbstractC2341a.f8162j, i6, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            m831d(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void m830c(boolean z7) {
        ((AbstractC1466d) this.f1135b.f38b).mo3509E(z7);
    }

    public final void m831d(boolean z7) {
        ((AbstractC1466d) this.f1135b.f38b).mo3510F(z7);
    }
}
