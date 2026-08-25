package p263y6;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p093j.C2743d;

public abstract class AbstractC4275a {

    public static final int[] f14484a = {R.attr.theme, com.p2serv.android.p032ds.R.attr.theme};

    public static final int[] f14485b = {com.p2serv.android.p032ds.R.attr.materialThemeOverlay};

    public static Context m8323a(Context context, AttributeSet attributeSet, int i6, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f14485b, i6, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z7 = (context instanceof C2743d) && ((C2743d) context).f9410a == resourceId;
        if (resourceId == 0 || z7) {
            return context;
        }
        C2743d c2743d = new C2743d(context, resourceId);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f14484a);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            c2743d.getTheme().applyStyle(resourceId2, true);
        }
        return c2743d;
    }
}
