package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.C0308d;
import p194s.C3681e;

public final class C4188e {

    public static final SparseIntArray f14208h;

    public boolean f14209a;

    public int f14210b;

    public String f14211c;

    public int f14212d;

    public int f14213e;

    public float f14214f;

    public float f14215g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14208h = sparseIntArray;
        sparseIntArray.append(2, 1);
        sparseIntArray.append(4, 2);
        sparseIntArray.append(5, 3);
        sparseIntArray.append(1, 4);
        sparseIntArray.append(0, 5);
        sparseIntArray.append(3, 6);
    }

    public final void m8243a(C4188e c4188e) {
        this.f14209a = c4188e.f14209a;
        this.f14210b = c4188e.f14210b;
        this.f14211c = c4188e.f14211c;
        this.f14212d = c4188e.f14212d;
        this.f14213e = c4188e.f14213e;
        this.f14215g = c4188e.f14215g;
        this.f14214f = c4188e.f14214f;
    }

    public final void m8244b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14243i);
        this.f14209a = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            switch (f14208h.get(index)) {
                case 1:
                    this.f14215g = typedArrayObtainStyledAttributes.getFloat(index, this.f14215g);
                    break;
                case 2:
                    this.f14212d = typedArrayObtainStyledAttributes.getInt(index, this.f14212d);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        this.f14211c = typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        this.f14211c = C3681e.f12322c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case 4:
                    this.f14213e = typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f14210b = C0308d.m892j(typedArrayObtainStyledAttributes, index, this.f14210b);
                    break;
                case 6:
                    this.f14214f = typedArrayObtainStyledAttributes.getFloat(index, this.f14214f);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
