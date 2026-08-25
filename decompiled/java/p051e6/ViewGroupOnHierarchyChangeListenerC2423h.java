package p051e6;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.internal.C1810a;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p138n0.AbstractC3155s0;

public final class ViewGroupOnHierarchyChangeListenerC2423h implements ViewGroup.OnHierarchyChangeListener {

    public ViewGroup.OnHierarchyChangeListener f8489a;

    public final ChipGroup f8490b;

    public ViewGroupOnHierarchyChangeListenerC2423h(ChipGroup chipGroup) {
        this.f8490b = chipGroup;
    }

    @Override
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f8490b;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                view2.setId(View.generateViewId());
            }
            C1810a c1810a = chipGroup.f6106h;
            Chip chip = (Chip) view2;
            c1810a.f6350a.put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                c1810a.m4236a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new C0019b(16, c1810a));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f8489a;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f8490b;
        if (view == chipGroup && (view2 instanceof Chip)) {
            C1810a c1810a = chipGroup.f6106h;
            Chip chip = (Chip) view2;
            c1810a.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            c1810a.f6350a.remove(Integer.valueOf(chip.getId()));
            c1810a.f6351b.remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f8489a;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
