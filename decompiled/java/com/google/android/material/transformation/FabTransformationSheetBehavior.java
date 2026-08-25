package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.p2serv.android.p032ds.R;
import java.util.HashMap;
import java.util.WeakHashMap;
import p007a7.C0069f;
import p138n0.AbstractC3155s0;
import p262y5.C4272e;
import p262y5.C4274g;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    public HashMap f6961i;

    public FabTransformationSheetBehavior() {
    }

    @Override
    public final void mo4413s(View view, View view2, boolean z7, boolean z10) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z7) {
                this.f6961i = new HashMap(childCount);
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                boolean z11 = (childAt.getLayoutParams() instanceof C0311c) && (((C0311c) childAt.getLayoutParams()).f1442a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z11) {
                    if (z7) {
                        this.f6961i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                        childAt.setImportantForAccessibility(4);
                    } else {
                        HashMap map = this.f6961i;
                        if (map != null && map.containsKey(childAt)) {
                            int iIntValue = ((Integer) this.f6961i.get(childAt)).intValue();
                            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                            childAt.setImportantForAccessibility(iIntValue);
                        }
                    }
                }
            }
            if (!z7) {
                this.f6961i = null;
            }
        }
        super.mo4413s(view, view2, z7, z10);
    }

    @Override
    public final C0069f mo4420z(Context context, boolean z7) {
        int i6 = z7 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        C0069f c0069f = new C0069f(0);
        c0069f.f196b = C4272e.m8314b(context, i6);
        c0069f.f197c = new C4274g();
        return c0069f;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
