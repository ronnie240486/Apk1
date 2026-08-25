package p258y1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;

public final class C4223n extends FrameLayout {

    public static final int f14350c = 0;

    public ViewGroup f14351a;

    public boolean f14352b;

    public static void m8269a(View view, ArrayList arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            m8269a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override
    public final void onViewAdded(View view) {
        if (!this.f14352b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            ViewGroup viewGroup = this.f14351a;
            viewGroup.setTag(R.id.ghost_view_holder, null);
            viewGroup.getOverlay().remove(this);
            this.f14352b = false;
        }
    }
}
