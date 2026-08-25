package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.C0226k0;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.Locale;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    public final ListPopupWindow f6733e;

    public final AccessibilityManager f6734f;

    public final Rect f6735g;

    public final int f6736h;

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public static void m4350a(MaterialAutoCompleteTextView materialAutoCompleteTextView, Object obj) {
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj), false);
    }

    public final TextInputLayout m4351b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override
    public CharSequence getHint() {
        TextInputLayout textInputLayoutM4351b = m4351b();
        return (textInputLayoutM4351b == null || !textInputLayoutM4351b.f6747E) ? super.getHint() : textInputLayoutM4351b.getHint();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutM4351b = m4351b();
        if (textInputLayoutM4351b != null && textInputLayoutM4351b.f6747E && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutM4351b = m4351b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutM4351b != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                ListPopupWindow listPopupWindow = this.f6733e;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !listPopupWindow.f715y.isShowing() ? -1 : listPopupWindow.f693c.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutM4351b);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = listPopupWindow.f715y.getBackground();
                if (background != null) {
                    Rect rect = this.f6735g;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutM4351b.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i6)), getMeasuredHeight());
        }
    }

    @Override
    public <T extends ListAdapter & Filterable> void setAdapter(T t5) {
        super.setAdapter(t5);
        this.f6733e.mo586q(getAdapter());
    }

    public void setSimpleItems(int i6) {
        setSimpleItems(getResources().getStringArray(i6));
    }

    @Override
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.f6734f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f6733e.mo576a();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, 0), attributeSet, i6);
        this.f6735g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f14010x, i6, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayM4250j.hasValue(0) && typedArrayM4250j.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f6736h = typedArrayM4250j.getResourceId(1, R.layout.mtrl_auto_complete_simple_item);
        this.f6734f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f6733e = listPopupWindow;
        listPopupWindow.f714x = true;
        listPopupWindow.f715y.setFocusable(true);
        listPopupWindow.f705o = this;
        listPopupWindow.f715y.setInputMethodMode(2);
        listPopupWindow.mo586q(getAdapter());
        listPopupWindow.f706p = new C0226k0(2, this);
        if (typedArrayM4250j.hasValue(2)) {
            setSimpleItems(typedArrayM4250j.getResourceId(2, 0));
        }
        typedArrayM4250j.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.f6736h, strArr));
    }
}
