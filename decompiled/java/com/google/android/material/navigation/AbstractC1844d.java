package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ViewOnLayoutChangeListenerC0268s2;
import androidx.leanback.widget.RunnableC0485n0;
import com.bumptech.glide.AbstractC1465c;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p003a2.AbstractC0032a;
import p034d0.AbstractC2115a;
import p065g0.AbstractC2581a;
import p101j7.C2782c;
import p105k.C2840n;
import p105k.InterfaceC2852z;
import p138n0.AbstractC3155s0;
import p138n0.AbstractC3166w;
import p143n5.AbstractC3198d;
import p148o0.C3228c;
import p148o0.C3232g;
import p187r4.AbstractC3612b;
import p250x5.AbstractC4121a;
import p262y5.AbstractC4268a;
import p272z5.C4355a;

public abstract class AbstractC1844d extends FrameLayout implements InterfaceC2852z {

    public static final int[] f6520C = {R.attr.state_checked};

    public static final C1842b f6521D = new C1842b();

    public static final C1843c f6522E = new C1843c();

    public int f6523A;

    public C4355a f6524B;

    public boolean f6525a;

    public int f6526b;

    public int f6527c;

    public float f6528d;

    public float f6529e;

    public float f6530f;

    public int f6531g;

    public boolean f6532h;

    public final FrameLayout f6533i;

    public final View f6534j;

    public final ImageView f6535k;

    public final ViewGroup f6536l;

    public final TextView f6537m;

    public final TextView f6538n;

    public int f6539o;

    public C2840n f6540p;

    public ColorStateList f6541q;

    public Drawable f6542r;

    public Drawable f6543s;

    public ValueAnimator f6544t;

    public C1842b f6545u;

    public float f6546v;

    public boolean f6547w;

    public int f6548x;

    public int f6549y;

    public boolean f6550z;

    public AbstractC1844d(Context context) {
        super(context);
        this.f6525a = false;
        this.f6539o = -1;
        this.f6545u = f6521D;
        this.f6546v = 0.0f;
        this.f6547w = false;
        this.f6548x = 0;
        this.f6549y = 0;
        this.f6550z = false;
        this.f6523A = 0;
        int i6 = 1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f6533i = (FrameLayout) findViewById(com.p2serv.android.p032ds.R.id.navigation_bar_item_icon_container);
        this.f6534j = findViewById(com.p2serv.android.p032ds.R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(com.p2serv.android.p032ds.R.id.navigation_bar_item_icon_view);
        this.f6535k = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(com.p2serv.android.p032ds.R.id.navigation_bar_item_labels_group);
        this.f6536l = viewGroup;
        TextView textView = (TextView) findViewById(com.p2serv.android.p032ds.R.id.navigation_bar_item_small_label_view);
        this.f6537m = textView;
        TextView textView2 = (TextView) findViewById(com.p2serv.android.p032ds.R.id.navigation_bar_item_large_label_view);
        this.f6538n = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f6526b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f6527c = viewGroup.getPaddingBottom();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        setFocusable(true);
        m4294a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0268s2(i6, this));
        }
    }

    public static void m4290d(TextView textView, int i6) {
        int iRound;
        AbstractC3198d.m6443R(textView, i6);
        Context context = textView.getContext();
        if (i6 == 0) {
            iRound = 0;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i6, AbstractC4121a.f13982Z);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(0, typedValue);
            typedArrayObtainStyledAttributes.recycle();
            if (value) {
                iRound = (Build.VERSION.SDK_INT >= 22 ? typedValue.getComplexUnit() : typedValue.data & 15) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            } else {
                iRound = 0;
            }
        }
        if (iRound != 0) {
            textView.setTextSize(0, iRound);
        }
    }

    public static void m4291e(View view, float f, float f3, int i6) {
        view.setScaleX(f);
        view.setScaleY(f3);
        view.setVisibility(i6);
    }

    public static void m4292f(View view, int i6, int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i6;
        layoutParams.bottomMargin = i6;
        layoutParams.gravity = i10;
        view.setLayoutParams(layoutParams);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f6533i;
        return frameLayout != null ? frameLayout : this.f6535k;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i6 = 0;
        for (int i10 = 0; i10 < iIndexOfChild; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof AbstractC1844d) && childAt.getVisibility() == 0) {
                i6++;
            }
        }
        return i6;
    }

    private int getSuggestedIconHeight() {
        C4355a c4355a = this.f6524B;
        int minimumHeight = c4355a != null ? c4355a.getMinimumHeight() / 2 : 0;
        return this.f6535k.getMeasuredWidth() + Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        C4355a c4355a = this.f6524B;
        int minimumWidth = c4355a == null ? 0 : c4355a.getMinimumWidth() - this.f6524B.f14769e.f14779b.f5894m.intValue();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.f6535k.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public static void m4293h(int i6, View view) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i6);
    }

    public final void m4294a(float f, float f3) {
        this.f6528d = f - f3;
        this.f6529e = (f3 * 1.0f) / f;
        this.f6530f = (f * 1.0f) / f3;
    }

    public final void m4295b(float f, float f3) {
        View view = this.f6534j;
        if (view != null) {
            C1842b c1842b = this.f6545u;
            c1842b.getClass();
            view.setScaleX(AbstractC4268a.m8309a(0.4f, 1.0f, f));
            view.setScaleY(c1842b.mo4289a(f, f3));
            view.setAlpha(AbstractC4268a.m8310b(0.0f, 1.0f, f3 == 0.0f ? 0.8f : 0.0f, f3 == 0.0f ? 1.0f : 0.2f, f));
        }
        this.f6546v = f;
    }

    @Override
    public final void mo532c(C2840n c2840n) {
        this.f6540p = c2840n;
        setCheckable(c2840n.isCheckable());
        setChecked(c2840n.isChecked());
        setEnabled(c2840n.isEnabled());
        setIcon(c2840n.getIcon());
        setTitle(c2840n.f9721e);
        setId(c2840n.f9717a);
        if (!TextUtils.isEmpty(c2840n.f9733q)) {
            setContentDescription(c2840n.f9733q);
        }
        CharSequence charSequence = !TextUtils.isEmpty(c2840n.f9734r) ? c2840n.f9734r : c2840n.f9721e;
        if (Build.VERSION.SDK_INT > 23) {
            AbstractC3612b.m7256L(this, charSequence);
        }
        setVisibility(c2840n.isVisible() ? 0 : 8);
        this.f6525a = true;
    }

    public final void m4296g(int i6) {
        View view = this.f6534j;
        if (view == null) {
            return;
        }
        int iMin = Math.min(this.f6548x, i6 - (this.f6523A * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.f6550z && this.f6531g == 2) ? iMin : this.f6549y;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f6534j;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public C4355a getBadge() {
        return this.f6524B;
    }

    public int getItemBackgroundResId() {
        return com.p2serv.android.p032ds.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override
    public C2840n getItemData() {
        return this.f6540p;
    }

    public int getItemDefaultMarginResId() {
        return com.p2serv.android.p032ds.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f6539o;
    }

    @Override
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.f6536l;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.f6536l;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        C2840n c2840n = this.f6540p;
        if (c2840n != null && c2840n.isCheckable() && this.f6540p.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6520C);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C4355a c4355a = this.f6524B;
        if (c4355a != null && c4355a.isVisible()) {
            C2840n c2840n = this.f6540p;
            CharSequence charSequence = c2840n.f9721e;
            if (!TextUtils.isEmpty(c2840n.f9733q)) {
                charSequence = this.f6540p.f9733q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.f6524B.m8394c()));
        }
        accessibilityNodeInfo.setCollectionItemInfo(C3232g.m6538a(0, 1, getItemVisiblePosition(), 1, isSelected()).f10860a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) C3228c.f10843g.f10856a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(com.p2serv.android.p032ds.R.string.item_view_role_description));
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        post(new RunnableC0485n0(i6, 2, this));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f6534j;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    public void setActiveIndicatorEnabled(boolean z7) {
        this.f6547w = z7;
        View view = this.f6534j;
        if (view != null) {
            view.setVisibility(z7 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i6) {
        this.f6549y = i6;
        m4296g(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i6) {
        this.f6523A = i6;
        m4296g(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z7) {
        this.f6550z = z7;
    }

    public void setActiveIndicatorWidth(int i6) {
        this.f6548x = i6;
        m4296g(getWidth());
    }

    public void setBadge(C4355a c4355a) {
        C4355a c4355a2 = this.f6524B;
        if (c4355a2 == c4355a) {
            return;
        }
        boolean z7 = c4355a2 != null;
        ImageView imageView = this.f6535k;
        if (z7 && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            if (this.f6524B != null) {
                setClipChildren(true);
                setClipToPadding(true);
                C4355a c4355a3 = this.f6524B;
                if (c4355a3 != null) {
                    WeakReference weakReference = c4355a3.f14777m;
                    if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                        WeakReference weakReference2 = c4355a3.f14777m;
                        (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                    } else {
                        imageView.getOverlay().remove(c4355a3);
                    }
                }
                this.f6524B = null;
            }
        }
        this.f6524B = c4355a;
        if (imageView == null || c4355a == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        C4355a c4355a4 = this.f6524B;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        c4355a4.setBounds(rect);
        c4355a4.m8397f(imageView, null);
        WeakReference weakReference3 = c4355a4.f14777m;
        if ((weakReference3 != null ? (FrameLayout) weakReference3.get() : null) == null) {
            imageView.getOverlay().add(c4355a4);
        } else {
            WeakReference weakReference4 = c4355a4.f14777m;
            (weakReference4 != null ? (FrameLayout) weakReference4.get() : null).setForeground(c4355a4);
        }
    }

    public void setCheckable(boolean z7) {
        refreshDrawableState();
    }

    public void setChecked(boolean z7) {
        TextView textView = this.f6538n;
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
        TextView textView2 = this.f6537m;
        textView2.setPivotX(textView2.getWidth() / 2);
        textView2.setPivotY(textView2.getBaseline());
        float f = z7 ? 1.0f : 0.0f;
        if (this.f6547w && this.f6525a) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (isAttachedToWindow()) {
                ValueAnimator valueAnimator = this.f6544t;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f6544t = null;
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f6546v, f);
                this.f6544t = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new C1841a(this, f));
                this.f6544t.setInterpolator(AbstractC0032a.m155K(getContext(), AbstractC4268a.f14470b));
                ValueAnimator valueAnimator2 = this.f6544t;
                Context context = getContext();
                int integer = getResources().getInteger(com.p2serv.android.p032ds.R.integer.material_motion_duration_long_1);
                TypedValue typedValueM3477l = AbstractC1465c.m3477l(context, com.p2serv.android.p032ds.R.attr.motionDurationLong1);
                if (typedValueM3477l != null && typedValueM3477l.type == 16) {
                    integer = typedValueM3477l.data;
                }
                valueAnimator2.setDuration(integer);
                this.f6544t.start();
            } else {
                m4295b(f, f);
            }
        } else {
            m4295b(f, f);
        }
        int i6 = this.f6531g;
        ViewGroup viewGroup = this.f6536l;
        if (i6 != -1) {
            if (i6 == 0) {
                if (z7) {
                    m4292f(getIconOrContainer(), this.f6526b, 49);
                    m4293h(this.f6527c, viewGroup);
                    textView.setVisibility(0);
                } else {
                    m4292f(getIconOrContainer(), this.f6526b, 17);
                    m4293h(0, viewGroup);
                    textView.setVisibility(4);
                }
                textView2.setVisibility(4);
            } else if (i6 == 1) {
                m4293h(this.f6527c, viewGroup);
                if (z7) {
                    m4292f(getIconOrContainer(), (int) (this.f6526b + this.f6528d), 49);
                    m4291e(textView, 1.0f, 1.0f, 0);
                    float f3 = this.f6529e;
                    m4291e(textView2, f3, f3, 4);
                } else {
                    m4292f(getIconOrContainer(), this.f6526b, 49);
                    float f4 = this.f6530f;
                    m4291e(textView, f4, f4, 4);
                    m4291e(textView2, 1.0f, 1.0f, 0);
                }
            } else if (i6 == 2) {
                m4292f(getIconOrContainer(), this.f6526b, 17);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } else if (this.f6532h) {
            if (z7) {
                m4292f(getIconOrContainer(), this.f6526b, 49);
                m4293h(this.f6527c, viewGroup);
                textView.setVisibility(0);
            } else {
                m4292f(getIconOrContainer(), this.f6526b, 17);
                m4293h(0, viewGroup);
                textView.setVisibility(4);
            }
            textView2.setVisibility(4);
        } else {
            m4293h(this.f6527c, viewGroup);
            if (z7) {
                m4292f(getIconOrContainer(), (int) (this.f6526b + this.f6528d), 49);
                m4291e(textView, 1.0f, 1.0f, 0);
                float f5 = this.f6529e;
                m4291e(textView2, f5, f5, 4);
            } else {
                m4292f(getIconOrContainer(), this.f6526b, 49);
                float f10 = this.f6530f;
                m4291e(textView, f10, f10, 4);
                m4291e(textView2, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z7);
    }

    @Override
    public void setEnabled(boolean z7) {
        C2782c c2782c;
        super.setEnabled(z7);
        this.f6537m.setEnabled(z7);
        this.f6538n.setEnabled(z7);
        this.f6535k.setEnabled(z7);
        Object obj = null;
        if (!z7) {
            AbstractC3155s0.m6350t(this, null);
            return;
        }
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 24) {
            c2782c = new C2782c(17, AbstractC3166w.m6362b(context, 1002));
        } else {
            c2782c = new C2782c(17, obj);
        }
        AbstractC3155s0.m6350t(this, c2782c);
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f6542r) {
            return;
        }
        this.f6542r = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = AbstractC3198d.m6448W(drawable).mutate();
            this.f6543s = drawable;
            ColorStateList colorStateList = this.f6541q;
            if (colorStateList != null) {
                AbstractC2581a.m5586h(drawable, colorStateList);
            }
        }
        this.f6535k.setImageDrawable(drawable);
    }

    public void setIconSize(int i6) {
        ImageView imageView = this.f6535k;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i6;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f6541q = colorStateList;
        if (this.f6540p == null || (drawable = this.f6543s) == null) {
            return;
        }
        AbstractC2581a.m5586h(drawable, colorStateList);
        this.f6543s.invalidateSelf();
    }

    public void setItemBackground(int i6) {
        setItemBackground(i6 == 0 ? null : AbstractC2115a.m5069b(getContext(), i6));
    }

    public void setItemPaddingBottom(int i6) {
        if (this.f6527c != i6) {
            this.f6527c = i6;
            C2840n c2840n = this.f6540p;
            if (c2840n != null) {
                setChecked(c2840n.isChecked());
            }
        }
    }

    public void setItemPaddingTop(int i6) {
        if (this.f6526b != i6) {
            this.f6526b = i6;
            C2840n c2840n = this.f6540p;
            if (c2840n != null) {
                setChecked(c2840n.isChecked());
            }
        }
    }

    public void setItemPosition(int i6) {
        this.f6539o = i6;
    }

    public void setLabelVisibilityMode(int i6) {
        if (this.f6531g != i6) {
            this.f6531g = i6;
            if (this.f6550z && i6 == 2) {
                this.f6545u = f6522E;
            } else {
                this.f6545u = f6521D;
            }
            m4296g(getWidth());
            C2840n c2840n = this.f6540p;
            if (c2840n != null) {
                setChecked(c2840n.isChecked());
            }
        }
    }

    public void setShifting(boolean z7) {
        if (this.f6532h != z7) {
            this.f6532h = z7;
            C2840n c2840n = this.f6540p;
            if (c2840n != null) {
                setChecked(c2840n.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i6) {
        TextView textView = this.f6538n;
        m4290d(textView, i6);
        m4294a(this.f6537m.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceInactive(int i6) {
        TextView textView = this.f6537m;
        m4290d(textView, i6);
        m4294a(textView.getTextSize(), this.f6538n.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f6537m.setTextColor(colorStateList);
            this.f6538n.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f6537m.setText(charSequence);
        this.f6538n.setText(charSequence);
        C2840n c2840n = this.f6540p;
        if (c2840n == null || TextUtils.isEmpty(c2840n.f9733q)) {
            setContentDescription(charSequence);
        }
        C2840n c2840n2 = this.f6540p;
        if (c2840n2 != null && !TextUtils.isEmpty(c2840n2.f9734r)) {
            charSequence = this.f6540p.f9734r;
        }
        if (Build.VERSION.SDK_INT > 23) {
            AbstractC3612b.m7256L(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(drawable);
    }
}
