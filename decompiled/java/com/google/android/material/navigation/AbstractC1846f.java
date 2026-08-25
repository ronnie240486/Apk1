package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.transition.AutoTransition;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.material.internal.C1839y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.WeakHashMap;
import p003a2.AbstractC0032a;
import p101j7.C2782c;
import p105k.C2840n;
import p105k.InterfaceC2823a0;
import p105k.MenuC2838l;
import p128m0.C3028d;
import p138n0.AbstractC3155s0;
import p221u6.C3908h;
import p221u6.C3913m;
import p222u7.AbstractC3928d;
import p262y5.AbstractC4268a;
import p272z5.C4355a;

public abstract class AbstractC1846f extends ViewGroup implements InterfaceC2823a0 {

    public static final int[] f6553C = {R.attr.state_checked};

    public static final int[] f6554D = {-16842910};

    public C1848h f6555A;

    public MenuC2838l f6556B;

    public final AutoTransition f6557a;

    public final ViewOnClickListenerC0122a f6558b;

    public final C3028d f6559c;

    public final SparseArray f6560d;

    public int f6561e;

    public AbstractC1844d[] f6562f;

    public int f6563g;

    public int f6564h;

    public ColorStateList f6565i;

    public int f6566j;

    public ColorStateList f6567k;

    public final ColorStateList f6568l;

    public int f6569m;

    public int f6570n;

    public Drawable f6571o;

    public int f6572p;

    public final SparseArray f6573q;

    public int f6574r;

    public int f6575s;

    public boolean f6576t;

    public int f6577u;

    public int f6578v;

    public int f6579w;

    public C3913m f6580x;

    public boolean f6581y;

    public ColorStateList f6582z;

    public AbstractC1846f(Context context) {
        super(context);
        int i6 = 5;
        this.f6559c = new C3028d(5);
        this.f6560d = new SparseArray(5);
        this.f6563g = 0;
        this.f6564h = 0;
        this.f6573q = new SparseArray(5);
        this.f6574r = -1;
        this.f6575s = -1;
        this.f6581y = false;
        this.f6568l = m4300b();
        if (isInEditMode()) {
            this.f6557a = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.f6557a = autoTransition;
            autoTransition.m3074I(0);
            Context context2 = getContext();
            int integer = getResources().getInteger(com.p2serv.android.p032ds.R.integer.material_motion_duration_long_1);
            TypedValue typedValueM3477l = AbstractC1465c.m3477l(context2, com.p2serv.android.p032ds.R.attr.motionDurationLong1);
            if (typedValueM3477l != null && typedValueM3477l.type == 16) {
                integer = typedValueM3477l.data;
            }
            autoTransition.mo3068x(integer);
            autoTransition.mo3070z(AbstractC0032a.m155K(getContext(), AbstractC4268a.f14470b));
            autoTransition.m3071F(new C1839y());
        }
        this.f6558b = new ViewOnClickListenerC0122a(i6, this);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setImportantForAccessibility(1);
    }

    public static boolean m4298f(int i6, int i10) {
        if (i6 == -1) {
            if (i10 <= 3) {
                return false;
            }
        } else if (i6 != 0) {
            return false;
        }
        return true;
    }

    private AbstractC1844d getNewItem() {
        AbstractC1844d abstractC1844d = (AbstractC1844d) this.f6559c.mo6099a();
        return abstractC1844d == null ? mo3208e(getContext()) : abstractC1844d;
    }

    private void setBadgeIfNeeded(AbstractC1844d abstractC1844d) {
        C4355a c4355a;
        int id = abstractC1844d.getId();
        if (id == -1 || (c4355a = (C4355a) this.f6573q.get(id)) == null) {
            return;
        }
        abstractC1844d.setBadge(c4355a);
    }

    public final void m4299a() {
        removeAllViews();
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                if (abstractC1844d != null) {
                    this.f6559c.mo6101c(abstractC1844d);
                    if (abstractC1844d.f6524B != null) {
                        ImageView imageView = abstractC1844d.f6535k;
                        if (imageView != null) {
                            abstractC1844d.setClipChildren(true);
                            abstractC1844d.setClipToPadding(true);
                            C4355a c4355a = abstractC1844d.f6524B;
                            if (c4355a != null) {
                                WeakReference weakReference = c4355a.f14777m;
                                if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                                    WeakReference weakReference2 = c4355a.f14777m;
                                    (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(c4355a);
                                }
                            }
                        }
                        abstractC1844d.f6524B = null;
                    }
                    abstractC1844d.f6540p = null;
                    abstractC1844d.f6546v = 0.0f;
                    abstractC1844d.f6525a = false;
                }
            }
        }
        if (this.f6556B.f9692f.size() == 0) {
            this.f6563g = 0;
            this.f6564h = 0;
            this.f6562f = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < this.f6556B.f9692f.size(); i6++) {
            hashSet.add(Integer.valueOf(this.f6556B.getItem(i6).getItemId()));
        }
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f6573q;
            if (i10 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i10);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i10++;
        }
        this.f6562f = new AbstractC1844d[this.f6556B.f9692f.size()];
        boolean zM4298f = m4298f(this.f6561e, this.f6556B.m5831l().size());
        for (int i11 = 0; i11 < this.f6556B.f9692f.size(); i11++) {
            this.f6555A.f6584b = true;
            this.f6556B.getItem(i11).setCheckable(true);
            this.f6555A.f6584b = false;
            AbstractC1844d newItem = getNewItem();
            this.f6562f[i11] = newItem;
            newItem.setIconTintList(this.f6565i);
            newItem.setIconSize(this.f6566j);
            newItem.setTextColor(this.f6568l);
            newItem.setTextAppearanceInactive(this.f6569m);
            newItem.setTextAppearanceActive(this.f6570n);
            newItem.setTextColor(this.f6567k);
            int i12 = this.f6574r;
            if (i12 != -1) {
                newItem.setItemPaddingTop(i12);
            }
            int i13 = this.f6575s;
            if (i13 != -1) {
                newItem.setItemPaddingBottom(i13);
            }
            newItem.setActiveIndicatorWidth(this.f6577u);
            newItem.setActiveIndicatorHeight(this.f6578v);
            newItem.setActiveIndicatorMarginHorizontal(this.f6579w);
            newItem.setActiveIndicatorDrawable(m4301c());
            newItem.setActiveIndicatorResizeable(this.f6581y);
            newItem.setActiveIndicatorEnabled(this.f6576t);
            Drawable drawable = this.f6571o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f6572p);
            }
            newItem.setShifting(zM4298f);
            newItem.setLabelVisibilityMode(this.f6561e);
            C2840n c2840n = (C2840n) this.f6556B.getItem(i11);
            newItem.mo532c(c2840n);
            newItem.setItemPosition(i11);
            SparseArray sparseArray2 = this.f6560d;
            int i14 = c2840n.f9717a;
            newItem.setOnTouchListener((View.OnTouchListener) sparseArray2.get(i14));
            newItem.setOnClickListener(this.f6558b);
            int i15 = this.f6563g;
            if (i15 != 0 && i14 == i15) {
                this.f6564h = i11;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.f6556B.f9692f.size() - 1, this.f6564h);
        this.f6564h = iMin;
        this.f6556B.getItem(iMin).setChecked(true);
    }

    public final ColorStateList m4300b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM7848k = AbstractC3928d.m7848k(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(com.p2serv.android.p032ds.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i6 = typedValue.data;
        int defaultColor = colorStateListM7848k.getDefaultColor();
        int[] iArr = f6554D;
        return new ColorStateList(new int[][]{iArr, f6553C, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListM7848k.getColorForState(iArr, defaultColor), i6, defaultColor});
    }

    public final C3908h m4301c() {
        if (this.f6580x == null || this.f6582z == null) {
            return null;
        }
        C3908h c3908h = new C3908h(this.f6580x);
        c3908h.m7809n(this.f6582z);
        return c3908h;
    }

    @Override
    public final void mo536d(MenuC2838l menuC2838l) {
        this.f6556B = menuC2838l;
    }

    public abstract AbstractC1844d mo3208e(Context context);

    public SparseArray<C4355a> getBadgeDrawables() {
        return this.f6573q;
    }

    public ColorStateList getIconTintList() {
        return this.f6565i;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f6582z;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f6576t;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f6578v;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f6579w;
    }

    public C3913m getItemActiveIndicatorShapeAppearance() {
        return this.f6580x;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f6577u;
    }

    public Drawable getItemBackground() {
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        return (abstractC1844dArr == null || abstractC1844dArr.length <= 0) ? this.f6571o : abstractC1844dArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f6572p;
    }

    public int getItemIconSize() {
        return this.f6566j;
    }

    public int getItemPaddingBottom() {
        return this.f6575s;
    }

    public int getItemPaddingTop() {
        return this.f6574r;
    }

    public int getItemTextAppearanceActive() {
        return this.f6570n;
    }

    public int getItemTextAppearanceInactive() {
        return this.f6569m;
    }

    public ColorStateList getItemTextColor() {
        return this.f6567k;
    }

    public int getLabelVisibilityMode() {
        return this.f6561e;
    }

    public MenuC2838l getMenu() {
        return this.f6556B;
    }

    public int getSelectedItemId() {
        return this.f6563g;
    }

    public int getSelectedItemPosition() {
        return this.f6564h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) C2782c.m5751x(1, this.f6556B.m5831l().size(), 1, false).f9501b);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f6565i = colorStateList;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f6582z = colorStateList;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorDrawable(m4301c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z7) {
        this.f6576t = z7;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorEnabled(z7);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i6) {
        this.f6578v = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorHeight(i6);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i6) {
        this.f6579w = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorMarginHorizontal(i6);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z7) {
        this.f6581y = z7;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorResizeable(z7);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(C3913m c3913m) {
        this.f6580x = c3913m;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorDrawable(m4301c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i6) {
        this.f6577u = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setActiveIndicatorWidth(i6);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f6571o = drawable;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i6) {
        this.f6572p = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setItemBackground(i6);
            }
        }
    }

    public void setItemIconSize(int i6) {
        this.f6566j = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setIconSize(i6);
            }
        }
    }

    public void setItemPaddingBottom(int i6) {
        this.f6575s = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setItemPaddingBottom(i6);
            }
        }
    }

    public void setItemPaddingTop(int i6) {
        this.f6574r = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setItemPaddingTop(i6);
            }
        }
    }

    public void setItemTextAppearanceActive(int i6) {
        this.f6570n = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setTextAppearanceActive(i6);
                ColorStateList colorStateList = this.f6567k;
                if (colorStateList != null) {
                    abstractC1844d.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i6) {
        this.f6569m = i6;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setTextAppearanceInactive(i6);
                ColorStateList colorStateList = this.f6567k;
                if (colorStateList != null) {
                    abstractC1844d.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f6567k = colorStateList;
        AbstractC1844d[] abstractC1844dArr = this.f6562f;
        if (abstractC1844dArr != null) {
            for (AbstractC1844d abstractC1844d : abstractC1844dArr) {
                abstractC1844d.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i6) {
        this.f6561e = i6;
    }

    public void setPresenter(C1848h c1848h) {
        this.f6555A = c1848h;
    }
}
