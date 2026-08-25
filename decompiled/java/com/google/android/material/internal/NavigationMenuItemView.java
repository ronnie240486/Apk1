package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import java.util.WeakHashMap;
import p015b2.C1256h;
import p046e0.AbstractC2350i;
import p046e0.AbstractC2355n;
import p065g0.AbstractC2581a;
import p105k.C2840n;
import p105k.InterfaceC2852z;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p187r4.AbstractC3612b;

public class NavigationMenuItemView extends ForegroundLinearLayout implements InterfaceC2852z {

    public static final int[] f6333F = {R.attr.state_checked};

    public C2840n f6334A;

    public ColorStateList f6335B;

    public boolean f6336C;

    public Drawable f6337D;

    public final C1256h f6338E;

    public int f6339v;

    public boolean f6340w;

    public boolean f6341x;

    public final CheckedTextView f6342y;

    public FrameLayout f6343z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f6343z == null) {
                this.f6343z = (FrameLayout) ((ViewStub) findViewById(com.p2serv.android.p032ds.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f6343z.removeAllViews();
            this.f6343z.addView(view);
        }
    }

    @Override
    public final void mo532c(C2840n c2840n) {
        StateListDrawable stateListDrawable;
        this.f6334A = c2840n;
        int i6 = c2840n.f9717a;
        if (i6 > 0) {
            setId(i6);
        }
        setVisibility(c2840n.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.p2serv.android.p032ds.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f6333F, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            setBackground(stateListDrawable);
        }
        setCheckable(c2840n.isCheckable());
        setChecked(c2840n.isChecked());
        setEnabled(c2840n.isEnabled());
        setTitle(c2840n.f9721e);
        setIcon(c2840n.getIcon());
        setActionView(c2840n.getActionView());
        setContentDescription(c2840n.f9733q);
        AbstractC3612b.m7256L(this, c2840n.f9734r);
        C2840n c2840n2 = this.f6334A;
        CharSequence charSequence = c2840n2.f9721e;
        CheckedTextView checkedTextView = this.f6342y;
        if (charSequence == null && c2840n2.getIcon() == null && this.f6334A.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.f6343z;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.f6343z.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.f6343z;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.f6343z.setLayoutParams(layoutParams2);
        }
    }

    @Override
    public C2840n getItemData() {
        return this.f6334A;
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        C2840n c2840n = this.f6334A;
        if (c2840n != null && c2840n.isCheckable() && this.f6334A.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6333F);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z7) {
        refreshDrawableState();
        if (this.f6341x != z7) {
            this.f6341x = z7;
            this.f6338E.mo2984h(this.f6342y, 2048);
        }
    }

    public void setChecked(boolean z7) {
        refreshDrawableState();
        this.f6342y.setChecked(z7);
    }

    public void setHorizontalPadding(int i6) {
        setPadding(i6, getPaddingTop(), i6, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f6336C) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = AbstractC3198d.m6448W(drawable).mutate();
                AbstractC2581a.m5586h(drawable, this.f6335B);
            }
            int i6 = this.f6339v;
            drawable.setBounds(0, 0, i6, i6);
        } else if (this.f6340w) {
            if (this.f6337D == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = AbstractC2355n.f8209a;
                Drawable drawableM5332a = AbstractC2350i.m5332a(resources, com.p2serv.android.p032ds.R.drawable.navigation_empty_icon, theme);
                this.f6337D = drawableM5332a;
                if (drawableM5332a != null) {
                    int i10 = this.f6339v;
                    drawableM5332a.setBounds(0, 0, i10, i10);
                }
            }
            drawable = this.f6337D;
        }
        this.f6342y.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i6) {
        this.f6342y.setCompoundDrawablePadding(i6);
    }

    public void setIconSize(int i6) {
        this.f6339v = i6;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f6335B = colorStateList;
        this.f6336C = colorStateList != null;
        C2840n c2840n = this.f6334A;
        if (c2840n != null) {
            setIcon(c2840n.getIcon());
        }
    }

    public void setMaxLines(int i6) {
        this.f6342y.setMaxLines(i6);
    }

    public void setNeedsEmptyIcon(boolean z7) {
        this.f6340w = z7;
    }

    public void setTextAppearance(int i6) {
        AbstractC3198d.m6443R(this.f6342y, i6);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f6342y.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f6342y.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        C1256h c1256h = new C1256h(4, this);
        this.f6338E = c1256h;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.p2serv.android.p032ds.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.p2serv.android.p032ds.R.id.design_menu_item_text);
        this.f6342y = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        AbstractC3155s0.m6347q(checkedTextView, c1256h);
    }
}
