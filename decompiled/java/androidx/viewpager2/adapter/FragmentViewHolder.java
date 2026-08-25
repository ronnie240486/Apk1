package androidx.viewpager2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.AbstractC1174p1;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class FragmentViewHolder extends AbstractC1174p1 {
    private FragmentViewHolder(FrameLayout frameLayout) {
        super(frameLayout);
    }

    public static FragmentViewHolder create(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
