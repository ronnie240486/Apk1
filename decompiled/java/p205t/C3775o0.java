package p205t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import p256y.AbstractC4193j;

public final class C3775o0 {

    public static final float[][] f12673v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    public static final float[][] f12674w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    public final int f12675a;

    public final int f12676b;

    public final int f12677c;

    public final int f12678d;

    public final int f12679e;

    public final int f12680f;

    public float f12681g;

    public float f12682h;

    public float f12683i;

    public float f12684j;

    public boolean f12685k = false;

    public final float[] f12686l = new float[2];

    public float f12687m;

    public float f12688n;

    public final MotionLayout f12689o;

    public final float f12690p;

    public final float f12691q;

    public final boolean f12692r;

    public final float f12693s;

    public final int f12694t;

    public final float f12695u;

    public C3775o0(Context context, MotionLayout motionLayout, XmlResourceParser xmlResourceParser) {
        this.f12675a = 0;
        this.f12676b = 0;
        this.f12677c = 0;
        this.f12678d = -1;
        this.f12679e = -1;
        this.f12680f = -1;
        this.f12681g = 0.5f;
        this.f12682h = 0.5f;
        this.f12683i = 0.0f;
        this.f12684j = 1.0f;
        this.f12690p = 4.0f;
        this.f12691q = 1.2f;
        this.f12692r = true;
        this.f12693s = 1.0f;
        this.f12694t = 0;
        this.f12695u = 10.0f;
        this.f12689o = motionLayout;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14249o);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 9) {
                this.f12678d = typedArrayObtainStyledAttributes.getResourceId(index, this.f12678d);
            } else if (index == 10) {
                int i10 = typedArrayObtainStyledAttributes.getInt(index, this.f12675a);
                this.f12675a = i10;
                float[] fArr = f12673v[i10];
                this.f12682h = fArr[0];
                this.f12681g = fArr[1];
            } else if (index == 0) {
                int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f12676b);
                this.f12676b = i11;
                float[] fArr2 = f12674w[i11];
                this.f12683i = fArr2[0];
                this.f12684j = fArr2[1];
            } else if (index == 5) {
                this.f12690p = typedArrayObtainStyledAttributes.getFloat(index, this.f12690p);
            } else if (index == 4) {
                this.f12691q = typedArrayObtainStyledAttributes.getFloat(index, this.f12691q);
            } else if (index == 6) {
                this.f12692r = typedArrayObtainStyledAttributes.getBoolean(index, this.f12692r);
            } else if (index == 1) {
                this.f12693s = typedArrayObtainStyledAttributes.getFloat(index, this.f12693s);
            } else if (index == 2) {
                this.f12695u = typedArrayObtainStyledAttributes.getFloat(index, this.f12695u);
            } else if (index == 11) {
                this.f12679e = typedArrayObtainStyledAttributes.getResourceId(index, this.f12679e);
            } else if (index == 8) {
                this.f12677c = typedArrayObtainStyledAttributes.getInt(index, this.f12677c);
            } else if (index == 7) {
                this.f12694t = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == 3) {
                this.f12680f = typedArrayObtainStyledAttributes.getResourceId(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final RectF m7522a(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i6 = this.f12679e;
        if (i6 == -1 || (viewFindViewById = viewGroup.findViewById(i6)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public final void m7523b(boolean z7) {
        float[][] fArr = f12673v;
        float[][] fArr2 = f12674w;
        if (z7) {
            fArr2[4] = fArr2[3];
            fArr2[5] = fArr2[2];
            fArr[5] = fArr[2];
            fArr[6] = fArr[1];
        } else {
            fArr2[4] = fArr2[2];
            fArr2[5] = fArr2[3];
            fArr[5] = fArr[1];
            fArr[6] = fArr[2];
        }
        float[] fArr3 = fArr[this.f12675a];
        this.f12682h = fArr3[0];
        this.f12681g = fArr3[1];
        float[] fArr4 = fArr2[this.f12676b];
        this.f12683i = fArr4[0];
        this.f12684j = fArr4[1];
    }

    public final String toString() {
        return this.f12683i + " , " + this.f12684j;
    }
}
