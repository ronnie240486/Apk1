package com.google.android.material.button;

import java.util.Comparator;

public final class C1772d implements Comparator {

    public final MaterialButtonToggleGroup f6064a;

    public C1772d(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.f6064a = materialButtonToggleGroup;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        MaterialButton materialButton = (MaterialButton) obj;
        MaterialButton materialButton2 = (MaterialButton) obj2;
        int iCompareTo = Boolean.valueOf(materialButton.f6028n).compareTo(Boolean.valueOf(materialButton2.f6028n));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f6064a;
        return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
    }
}
