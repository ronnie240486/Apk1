package p178q6;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import p156o9.AbstractC3281e;
import p250x5.AbstractC4121a;

public abstract class AbstractC3508e {

    public int f11809a;

    public int f11810b;

    public int[] f11811c;

    public int f11812d;

    public int f11813e;

    public int f11814f;

    public AbstractC3508e(Context context, AttributeSet attributeSet, int i6, int i10) {
        this.f11811c = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        int[] iArr = AbstractC4121a.f13989d;
        AbstractC1811a0.m4241a(context, attributeSet, i6, i10);
        AbstractC1811a0.m4242b(context, attributeSet, iArr, i6, i10, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, i10);
        this.f11809a = AbstractC1466d.m3494l(context, typedArrayObtainStyledAttributes, 8, dimensionPixelSize);
        this.f11810b = Math.min(AbstractC1466d.m3494l(context, typedArrayObtainStyledAttributes, 7, 0), this.f11809a / 2);
        this.f11813e = typedArrayObtainStyledAttributes.getInt(4, 0);
        this.f11814f = typedArrayObtainStyledAttributes.getInt(1, 0);
        if (!typedArrayObtainStyledAttributes.hasValue(2)) {
            this.f11811c = new int[]{AbstractC3281e.m6627q(context, R.attr.colorPrimary, -1)};
        } else if (typedArrayObtainStyledAttributes.peekValue(2).type != 1) {
            this.f11811c = new int[]{typedArrayObtainStyledAttributes.getColor(2, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(2, -1));
            this.f11811c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f11812d = typedArrayObtainStyledAttributes.getColor(6, -1);
        } else {
            this.f11812d = this.f11811c[0];
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
            float f = typedArrayObtainStyledAttributes2.getFloat(0, 0.2f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f11812d = AbstractC3281e.m6620j(this.f11812d, (int) (f * 255.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract void mo4303a();
}
