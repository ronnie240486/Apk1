package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1810a;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.InterfaceC1821g;
import com.p2serv.android.p032ds.R;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p051e6.C2420e;
import p051e6.InterfaceC2421f;
import p051e6.InterfaceC2422g;
import p051e6.ViewGroupOnHierarchyChangeListenerC2423h;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class ChipGroup extends FlowLayout {

    public int f6103e;

    public int f6104f;

    public InterfaceC2422g f6105g;

    public final C1810a f6106h;

    public final int f6107i;

    public final ViewGroupOnHierarchyChangeListenerC2423h f6108j;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    private int getChipCount() {
        int i6 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (getChildAt(i10) instanceof Chip) {
                i6++;
            }
        }
        return i6;
    }

    @Override
    public final boolean mo4164a() {
        return this.f6325c;
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.f6106h.m4238c();
    }

    public List<Integer> getCheckedChipIds() {
        return this.f6106h.m4237b(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f6103e;
    }

    public int getChipSpacingVertical() {
        return this.f6104f;
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i6 = this.f6107i;
        if (i6 != -1) {
            C1810a c1810a = this.f6106h;
            InterfaceC1821g interfaceC1821g = (InterfaceC1821g) c1810a.f6350a.get(Integer.valueOf(i6));
            if (interfaceC1821g != null && c1810a.m4236a(interfaceC1821g)) {
                c1810a.m4239d();
            }
        }
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) C2782c.m5751x(getRowCount(), this.f6325c ? getChipCount() : -1, this.f6106h.f6353d ? 1 : 2, false).f9501b);
    }

    public void setChipSpacing(int i6) {
        setChipSpacingHorizontal(i6);
        setChipSpacingVertical(i6);
    }

    public void setChipSpacingHorizontal(int i6) {
        if (this.f6103e != i6) {
            this.f6103e = i6;
            setItemSpacing(i6);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i6) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i6));
    }

    public void setChipSpacingResource(int i6) {
        setChipSpacing(getResources().getDimensionPixelOffset(i6));
    }

    public void setChipSpacingVertical(int i6) {
        if (this.f6104f != i6) {
            this.f6104f = i6;
            setLineSpacing(i6);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i6) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i6));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i6) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(InterfaceC2421f interfaceC2421f) {
        if (interfaceC2421f == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new C2420e(this));
        }
    }

    public void setOnCheckedStateChangeListener(InterfaceC2422g interfaceC2422g) {
        this.f6105g = interfaceC2422g;
    }

    @Override
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f6108j.f8489a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z7) {
        this.f6106h.f6354e = z7;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i6) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i6) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override
    public void setSingleLine(boolean z7) {
        super.setSingleLine(z7);
    }

    public void setSingleSelection(boolean z7) {
        C1810a c1810a = this.f6106h;
        if (c1810a.f6353d != z7) {
            c1810a.f6353d = z7;
            boolean zIsEmpty = c1810a.f6351b.isEmpty();
            Iterator it = c1810a.f6350a.values().iterator();
            while (it.hasNext()) {
                c1810a.m4240e((InterfaceC1821g) it.next(), false);
            }
            if (zIsEmpty) {
                return;
            }
            c1810a.m4239d();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_ChipGroup), attributeSet, i6);
        C1810a c1810a = new C1810a();
        this.f6106h = c1810a;
        ViewGroupOnHierarchyChangeListenerC2423h viewGroupOnHierarchyChangeListenerC2423h = new ViewGroupOnHierarchyChangeListenerC2423h(this);
        this.f6108j = viewGroupOnHierarchyChangeListenerC2423h;
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(getContext(), attributeSet, AbstractC4121a.f13996j, i6, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = typedArrayM4250j.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(typedArrayM4250j.getDimensionPixelOffset(2, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayM4250j.getDimensionPixelOffset(3, dimensionPixelOffset));
        setSingleLine(typedArrayM4250j.getBoolean(5, false));
        setSingleSelection(typedArrayM4250j.getBoolean(6, false));
        setSelectionRequired(typedArrayM4250j.getBoolean(4, false));
        this.f6107i = typedArrayM4250j.getResourceId(0, -1);
        typedArrayM4250j.recycle();
        c1810a.f6352c = new C2420e(this);
        super.setOnHierarchyChangeListener(viewGroupOnHierarchyChangeListenerC2423h);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setImportantForAccessibility(1);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(int i6) {
        setSingleLine(getResources().getBoolean(i6));
    }

    public void setSingleSelection(int i6) {
        setSingleSelection(getResources().getBoolean(i6));
    }
}
