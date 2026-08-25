package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import p256y.AbstractC4193j;
import p256y.C4187d;

public class Constraints extends ViewGroup {

    public C0308d f1379a;

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public C0308d getConstraintSet() {
        if (this.f1379a == null) {
            this.f1379a = new C0308d();
        }
        C0308d c0308d = this.f1379a;
        c0308d.getClass();
        int childCount = getChildCount();
        HashMap map = c0308d.f1416c;
        map.clear();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (c0308d.f1415b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new C0307c());
            }
            C0307c c0307c = (C0307c) map.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                c0307c.m889c(id, layoutParams);
                if (constraintHelper instanceof Barrier) {
                    C4187d c4187d = c0307c.f1409d;
                    c4187d.f14179d0 = 1;
                    Barrier barrier = (Barrier) constraintHelper;
                    c4187d.f14175b0 = barrier.getType();
                    c4187d.f14181e0 = barrier.getReferencedIds();
                    c4187d.f14177c0 = barrier.getMargin();
                }
            }
            c0307c.m889c(id, layoutParams);
        }
        return this.f1379a;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {

        public final float f1380m0;

        public final boolean f1381n0;

        public final float f1382o0;

        public final float f1383p0;

        public final float f1384q0;

        public final float f1385r0;

        public final float f1386s0;

        public final float f1387t0;

        public final float f1388u0;

        public final float f1389v0;

        public final float f1390w0;

        public final float f1391x0;

        public final float f1392y0;

        public LayoutParams() {
            this.f1380m0 = 1.0f;
            this.f1381n0 = false;
            this.f1382o0 = 0.0f;
            this.f1383p0 = 0.0f;
            this.f1384q0 = 0.0f;
            this.f1385r0 = 0.0f;
            this.f1386s0 = 1.0f;
            this.f1387t0 = 1.0f;
            this.f1388u0 = 0.0f;
            this.f1389v0 = 0.0f;
            this.f1390w0 = 0.0f;
            this.f1391x0 = 0.0f;
            this.f1392y0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1380m0 = 1.0f;
            this.f1381n0 = false;
            this.f1382o0 = 0.0f;
            this.f1383p0 = 0.0f;
            this.f1384q0 = 0.0f;
            this.f1385r0 = 0.0f;
            this.f1386s0 = 1.0f;
            this.f1387t0 = 1.0f;
            this.f1388u0 = 0.0f;
            this.f1389v0 = 0.0f;
            this.f1390w0 = 0.0f;
            this.f1391x0 = 0.0f;
            this.f1392y0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14238d);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 15) {
                    this.f1380m0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1380m0);
                } else if (index == 28) {
                    this.f1382o0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1382o0);
                    this.f1381n0 = true;
                } else if (index == 23) {
                    this.f1384q0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1384q0);
                } else if (index == 24) {
                    this.f1385r0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1385r0);
                } else if (index == 22) {
                    this.f1383p0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1383p0);
                } else if (index == 20) {
                    this.f1386s0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1386s0);
                } else if (index == 21) {
                    this.f1387t0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1387t0);
                } else if (index == 16) {
                    this.f1388u0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1388u0);
                } else if (index == 17) {
                    this.f1389v0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1389v0);
                } else if (index == 18) {
                    this.f1390w0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1390w0);
                } else if (index == 19) {
                    this.f1391x0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1391x0);
                } else if (index == 27) {
                    this.f1392y0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1392y0);
                }
            }
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
    }
}
