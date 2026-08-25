package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p002a1.C0026b;
import p065g0.AbstractC2581a;
import p093j.C2748i;
import p105k.InterfaceC2823a0;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;
import p201s6.AbstractC3722c;
import p221u6.C3901a;
import p221u6.C3908h;
import p221u6.C3913m;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public abstract class AbstractC1852l extends FrameLayout {

    public final C1845e f6586a;

    public final AbstractC1846f f6587b;

    public final C1848h f6588c;

    public ColorStateList f6589d;

    public C2748i f6590e;

    public AbstractC1852l(Context context, AttributeSet attributeSet, int i6, int i10) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, i10), attributeSet, i6);
        C1848h c1848h = new C1848h();
        c1848h.f6584b = false;
        this.f6588c = c1848h;
        Context context2 = getContext();
        C0026b c0026bM4251k = AbstractC1811a0.m4251k(context2, attributeSet, AbstractC4121a.f13968L, i6, i10, 10, 9);
        C1845e c1845e = new C1845e(context2, getClass(), getMaxItemCount());
        this.f6586a = c1845e;
        AbstractC1846f abstractC1846fMo4121a = mo4121a(context2);
        this.f6587b = abstractC1846fMo4121a;
        c1848h.f6583a = abstractC1846fMo4121a;
        c1848h.f6585c = 1;
        abstractC1846fMo4121a.setPresenter(c1848h);
        c1845e.m5826b(c1848h, c1845e.f9687a);
        getContext();
        c1848h.f6583a.f6556B = c1845e;
        TypedArray typedArray = (TypedArray) c0026bM4251k.f55c;
        if (typedArray.hasValue(5)) {
            abstractC1846fMo4121a.setIconTintList(c0026bM4251k.m139s(5));
        } else {
            abstractC1846fMo4121a.setIconTintList(abstractC1846fMo4121a.m4300b());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(4, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(10)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(10, 0));
        }
        if (typedArray.hasValue(9)) {
            setItemTextAppearanceActive(typedArray.getResourceId(9, 0));
        }
        if (typedArray.hasValue(11)) {
            setItemTextColor(c0026bM4251k.m139s(11));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            C3908h c3908h = new C3908h();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                c3908h.m7809n(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            c3908h.m7806k(context2);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            setBackground(c3908h);
        }
        if (typedArray.hasValue(7)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(7, 0));
        }
        if (typedArray.hasValue(6)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(6, 0));
        }
        if (typedArray.hasValue(1)) {
            setElevation(typedArray.getDimensionPixelSize(1, 0));
        }
        AbstractC2581a.m5586h(getBackground().mutate(), AbstractC1466d.m3492j(context2, c0026bM4251k, 0));
        setLabelVisibilityMode(typedArray.getInteger(12, -1));
        int resourceId = typedArray.getResourceId(3, 0);
        if (resourceId != 0) {
            abstractC1846fMo4121a.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(AbstractC1466d.m3492j(context2, c0026bM4251k, 8));
        }
        int resourceId2 = typedArray.getResourceId(2, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, AbstractC4121a.f13967K);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setItemActiveIndicatorColor(AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 2));
            setItemActiveIndicatorShapeAppearance(C3913m.m7821a(context2, typedArrayObtainStyledAttributes.getResourceId(4, 0), 0, new C3901a(0)).m7819a());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(13)) {
            int resourceId3 = typedArray.getResourceId(13, 0);
            c1848h.f6584b = true;
            getMenuInflater().inflate(resourceId3, c1845e);
            c1848h.f6584b = false;
            c1848h.mo712j(true);
        }
        c0026bM4251k.m120F();
        addView(abstractC1846fMo4121a);
        c1845e.f9691e = new C0019b(19, this);
    }

    private MenuInflater getMenuInflater() {
        if (this.f6590e == null) {
            this.f6590e = new C2748i(getContext());
        }
        return this.f6590e;
    }

    public abstract AbstractC1846f mo4121a(Context context);

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f6587b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f6587b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f6587b.getItemActiveIndicatorMarginHorizontal();
    }

    public C3913m getItemActiveIndicatorShapeAppearance() {
        return this.f6587b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f6587b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f6587b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f6587b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f6587b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f6587b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f6587b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f6587b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f6589d;
    }

    public int getItemTextAppearanceActive() {
        return this.f6587b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f6587b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f6587b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f6587b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f6586a;
    }

    public InterfaceC2823a0 getMenuView() {
        return this.f6587b;
    }

    public C1848h getPresenter() {
        return this.f6588c;
    }

    public int getSelectedItemId() {
        return this.f6587b.getSelectedItemId();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6568E(this);
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof NavigationBarView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        NavigationBarView$SavedState navigationBarView$SavedState = (NavigationBarView$SavedState) parcelable;
        super.onRestoreInstanceState(navigationBarView$SavedState.f1689a);
        this.f6586a.m5835t(navigationBarView$SavedState.f6502c);
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        NavigationBarView$SavedState navigationBarView$SavedState = new NavigationBarView$SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        navigationBarView$SavedState.f6502c = bundle;
        this.f6586a.m5837v(bundle);
        return navigationBarView$SavedState;
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC3280d.m6565B(this, f);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f6587b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z7) {
        this.f6587b.setItemActiveIndicatorEnabled(z7);
    }

    public void setItemActiveIndicatorHeight(int i6) {
        this.f6587b.setItemActiveIndicatorHeight(i6);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i6) {
        this.f6587b.setItemActiveIndicatorMarginHorizontal(i6);
    }

    public void setItemActiveIndicatorShapeAppearance(C3913m c3913m) {
        this.f6587b.setItemActiveIndicatorShapeAppearance(c3913m);
    }

    public void setItemActiveIndicatorWidth(int i6) {
        this.f6587b.setItemActiveIndicatorWidth(i6);
    }

    public void setItemBackground(Drawable drawable) {
        this.f6587b.setItemBackground(drawable);
        this.f6589d = null;
    }

    public void setItemBackgroundResource(int i6) {
        this.f6587b.setItemBackgroundRes(i6);
        this.f6589d = null;
    }

    public void setItemIconSize(int i6) {
        this.f6587b.setItemIconSize(i6);
    }

    public void setItemIconSizeRes(int i6) {
        setItemIconSize(getResources().getDimensionPixelSize(i6));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f6587b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i6) {
        this.f6587b.setItemPaddingBottom(i6);
    }

    public void setItemPaddingTop(int i6) {
        this.f6587b.setItemPaddingTop(i6);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.f6589d;
        AbstractC1846f abstractC1846f = this.f6587b;
        if (colorStateList2 == colorStateList) {
            if (colorStateList != null || abstractC1846f.getItemBackground() == null) {
                return;
            }
            abstractC1846f.setItemBackground(null);
            return;
        }
        this.f6589d = colorStateList;
        if (colorStateList == null) {
            abstractC1846f.setItemBackground(null);
        } else {
            abstractC1846f.setItemBackground(new RippleDrawable(AbstractC3722c.m7484a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(int i6) {
        this.f6587b.setItemTextAppearanceActive(i6);
    }

    public void setItemTextAppearanceInactive(int i6) {
        this.f6587b.setItemTextAppearanceInactive(i6);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f6587b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i6) {
        AbstractC1846f abstractC1846f = this.f6587b;
        if (abstractC1846f.getLabelVisibilityMode() != i6) {
            abstractC1846f.setLabelVisibilityMode(i6);
            this.f6588c.mo712j(false);
        }
    }

    public void setSelectedItemId(int i6) {
        C1845e c1845e = this.f6586a;
        MenuItem menuItemFindItem = c1845e.findItem(i6);
        if (menuItemFindItem == null || c1845e.m5832q(menuItemFindItem, this.f6588c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public void setOnItemReselectedListener(InterfaceC1849i interfaceC1849i) {
    }

    public void setOnItemSelectedListener(InterfaceC1850j interfaceC1850j) {
    }
}
