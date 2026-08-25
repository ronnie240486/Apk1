package p262y5;

import android.util.Property;
import android.view.ViewGroup;
import com.p2serv.android.p032ds.R;

public final class C4270c extends Property {

    public static final C4270c f14475a = new C4270c(Float.class, "childrenAlpha");

    @Override
    public final Object get(Object obj) {
        Float f = (Float) ((ViewGroup) obj).getTag(R.id.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    @Override
    public final void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        Float f = (Float) obj2;
        float fFloatValue = f.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f);
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            viewGroup.getChildAt(i6).setAlpha(fFloatValue);
        }
    }
}
