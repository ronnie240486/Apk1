package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

public final class C4190g {

    public static final SparseIntArray f14221n;

    public boolean f14222a;

    public float f14223b;

    public float f14224c;

    public float f14225d;

    public float f14226e;

    public float f14227f;

    public float f14228g;

    public float f14229h;

    public float f14230i;

    public float f14231j;

    public float f14232k;

    public boolean f14233l;

    public float f14234m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14221n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
    }

    public final void m8246a(C4190g c4190g) {
        this.f14222a = c4190g.f14222a;
        this.f14223b = c4190g.f14223b;
        this.f14224c = c4190g.f14224c;
        this.f14225d = c4190g.f14225d;
        this.f14226e = c4190g.f14226e;
        this.f14227f = c4190g.f14227f;
        this.f14228g = c4190g.f14228g;
        this.f14229h = c4190g.f14229h;
        this.f14230i = c4190g.f14230i;
        this.f14231j = c4190g.f14231j;
        this.f14232k = c4190g.f14232k;
        this.f14233l = c4190g.f14233l;
        this.f14234m = c4190g.f14234m;
    }

    public final void m8247b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14253s);
        this.f14222a = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            switch (f14221n.get(index)) {
                case 1:
                    this.f14223b = typedArrayObtainStyledAttributes.getFloat(index, this.f14223b);
                    break;
                case 2:
                    this.f14224c = typedArrayObtainStyledAttributes.getFloat(index, this.f14224c);
                    break;
                case 3:
                    this.f14225d = typedArrayObtainStyledAttributes.getFloat(index, this.f14225d);
                    break;
                case 4:
                    this.f14226e = typedArrayObtainStyledAttributes.getFloat(index, this.f14226e);
                    break;
                case 5:
                    this.f14227f = typedArrayObtainStyledAttributes.getFloat(index, this.f14227f);
                    break;
                case 6:
                    this.f14228g = typedArrayObtainStyledAttributes.getDimension(index, this.f14228g);
                    break;
                case 7:
                    this.f14229h = typedArrayObtainStyledAttributes.getDimension(index, this.f14229h);
                    break;
                case 8:
                    this.f14230i = typedArrayObtainStyledAttributes.getDimension(index, this.f14230i);
                    break;
                case 9:
                    this.f14231j = typedArrayObtainStyledAttributes.getDimension(index, this.f14231j);
                    break;
                case 10:
                    this.f14232k = typedArrayObtainStyledAttributes.getDimension(index, this.f14232k);
                    break;
                case 11:
                    this.f14233l = true;
                    this.f14234m = typedArrayObtainStyledAttributes.getDimension(index, this.f14234m);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
