package p201s6;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import p056f0.AbstractC2478a;

public abstract class AbstractC3722c {

    public static final int[] f12475a = {R.attr.state_pressed};

    public static final int[] f12476b = {R.attr.state_selected, R.attr.state_pressed};

    public static final int[] f12477c = {R.attr.state_selected};

    public static final int[] f12478d = {R.attr.state_enabled, R.attr.state_pressed};

    public static final String f12479e = AbstractC3722c.class.getSimpleName();

    public static ColorStateList m7484a(ColorStateList colorStateList) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(f12476b, colorStateList.getDefaultColor()) : 0;
        int iM5513h = AbstractC2478a.m5513h(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
        int[][] iArr = {f12477c, StateSet.NOTHING};
        int colorForState2 = colorStateList != null ? colorStateList.getColorForState(f12475a, colorStateList.getDefaultColor()) : 0;
        return new ColorStateList(iArr, new int[]{iM5513h, AbstractC2478a.m5513h(colorForState2, Math.min(Color.alpha(colorForState2) * 2, 255))});
    }

    public static ColorStateList m7485b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 22 && i6 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f12478d, 0)) != 0) {
            Log.w(f12479e, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean m7486c(int[] iArr) {
        boolean z7 = false;
        boolean z10 = false;
        for (int i6 : iArr) {
            if (i6 == 16842910) {
                z7 = true;
            } else if (i6 == 16842908 || i6 == 16842919 || i6 == 16843623) {
                z10 = true;
            }
        }
        return z7 && z10;
    }
}
