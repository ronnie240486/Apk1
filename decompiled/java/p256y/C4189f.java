package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.C0308d;

public final class C4189f {

    public boolean f14216a;

    public int f14217b;

    public int f14218c;

    public float f14219d;

    public float f14220e;

    public final void m8245a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14250p);
        this.f14216a = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 1) {
                this.f14219d = typedArrayObtainStyledAttributes.getFloat(index, this.f14219d);
            } else if (index == 0) {
                int i10 = typedArrayObtainStyledAttributes.getInt(index, this.f14217b);
                this.f14217b = i10;
                this.f14217b = C0308d.f1412d[i10];
            } else if (index == 4) {
                this.f14218c = typedArrayObtainStyledAttributes.getInt(index, this.f14218c);
            } else if (index == 3) {
                this.f14220e = typedArrayObtainStyledAttributes.getFloat(index, this.f14220e);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
