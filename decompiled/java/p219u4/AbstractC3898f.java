package p219u4;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import p056f0.AbstractC2478a;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;
import p222u7.AbstractC3928d;
import p230v4.C3988b;

public abstract class AbstractC3898f {

    public static final C3988b f13098a = new C3988b("WidgetUtil", null);

    public static Drawable m7793a(ExpandedControllerActivity expandedControllerActivity, int i6, int i10) {
        ColorStateList colorStateList;
        Drawable drawableM6448W = AbstractC3198d.m6448W(expandedControllerActivity.getResources().getDrawable(i10).mutate());
        AbstractC2581a.m5587i(drawableM6448W, PorterDuff.Mode.SRC_IN);
        if (i6 != 0) {
            colorStateList = AbstractC3928d.m7848k(expandedControllerActivity, i6);
        } else {
            int iM7847i = AbstractC3928d.m7847i(expandedControllerActivity, R.color.white);
            colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{iM7847i, AbstractC2478a.m5513h(iM7847i, 128)});
        }
        AbstractC2581a.m5586h(drawableM6448W, colorStateList);
        return drawableM6448W;
    }
}
