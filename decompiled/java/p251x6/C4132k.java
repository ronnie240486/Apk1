package p251x6;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p065g0.AbstractC2581a;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p138n0.AbstractC3166w;
import p143n5.AbstractC3198d;
import p148o0.C3228c;
import p148o0.C3232g;
import p187r4.AbstractC3612b;
import p201s6.AbstractC3722c;
import p272z5.C4355a;

public final class C4132k extends LinearLayout {

    public static final int f14039l = 0;

    public C4129h f14040a;

    public TextView f14041b;

    public ImageView f14042c;

    public View f14043d;

    public C4355a f14044e;

    public View f14045f;

    public TextView f14046g;

    public ImageView f14047h;

    public Drawable f14048i;

    public int f14049j;

    public final TabLayout f14050k;

    public C4132k(TabLayout tabLayout, Context context) {
        super(context);
        int i6 = 17;
        this.f14050k = tabLayout;
        this.f14049j = 2;
        m8150e(context);
        int i10 = tabLayout.f6710d;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setPaddingRelative(i10, tabLayout.f6711e, tabLayout.f6712f, tabLayout.f6713g);
        setGravity(17);
        setOrientation(!tabLayout.f6690A ? 1 : 0);
        setClickable(true);
        AbstractC3155s0.m6350t(this, Build.VERSION.SDK_INT >= 24 ? new C2782c(i6, AbstractC3166w.m6362b(getContext(), 1002)) : new C2782c(i6, (Object) null));
    }

    private C4355a getBadge() {
        return this.f14044e;
    }

    private C4355a getOrCreateBadge() {
        if (this.f14044e == null) {
            this.f14044e = new C4355a(getContext(), null);
        }
        m8147b();
        C4355a c4355a = this.f14044e;
        if (c4355a != null) {
            return c4355a;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    public final void m8146a() {
        if (this.f14044e != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.f14043d;
            if (view != null) {
                C4355a c4355a = this.f14044e;
                if (c4355a != null) {
                    WeakReference weakReference = c4355a.f14777m;
                    if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                        WeakReference weakReference2 = c4355a.f14777m;
                        (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                    } else {
                        view.getOverlay().remove(c4355a);
                    }
                }
                this.f14043d = null;
            }
        }
    }

    public final void m8147b() {
        C4129h c4129h;
        if (this.f14044e != null) {
            if (this.f14045f != null) {
                m8146a();
                return;
            }
            ImageView imageView = this.f14042c;
            if (imageView != null && (c4129h = this.f14040a) != null && c4129h.f14027a != null) {
                if (this.f14043d == imageView) {
                    m8148c(imageView);
                    return;
                }
                m8146a();
                ImageView imageView2 = this.f14042c;
                if (this.f14044e == null || imageView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                C4355a c4355a = this.f14044e;
                Rect rect = new Rect();
                imageView2.getDrawingRect(rect);
                c4355a.setBounds(rect);
                c4355a.m8397f(imageView2, null);
                WeakReference weakReference = c4355a.f14777m;
                if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = c4355a.f14777m;
                    (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(c4355a);
                } else {
                    imageView2.getOverlay().add(c4355a);
                }
                this.f14043d = imageView2;
                return;
            }
            TextView textView = this.f14041b;
            if (textView == null || this.f14040a == null) {
                m8146a();
                return;
            }
            if (this.f14043d == textView) {
                m8148c(textView);
                return;
            }
            m8146a();
            TextView textView2 = this.f14041b;
            if (this.f14044e == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) getParent();
            if (viewGroup2 != null) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
            }
            C4355a c4355a2 = this.f14044e;
            Rect rect2 = new Rect();
            textView2.getDrawingRect(rect2);
            c4355a2.setBounds(rect2);
            c4355a2.m8397f(textView2, null);
            WeakReference weakReference3 = c4355a2.f14777m;
            if ((weakReference3 != null ? (FrameLayout) weakReference3.get() : null) != null) {
                WeakReference weakReference4 = c4355a2.f14777m;
                (weakReference4 != null ? (FrameLayout) weakReference4.get() : null).setForeground(c4355a2);
            } else {
                textView2.getOverlay().add(c4355a2);
            }
            this.f14043d = textView2;
        }
    }

    public final void m8148c(View view) {
        C4355a c4355a = this.f14044e;
        if (c4355a == null || view != this.f14043d) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        c4355a.setBounds(rect);
        c4355a.m8397f(view, null);
    }

    public final void m8149d() {
        C4129h c4129h = this.f14040a;
        View view = c4129h != null ? c4129h.f14031e : null;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
            }
            this.f14045f = view;
            TextView textView = this.f14041b;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.f14042c;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.f14042c.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.f14046g = textView2;
            if (textView2 != null) {
                this.f14049j = textView2.getMaxLines();
            }
            this.f14047h = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view2 = this.f14045f;
            if (view2 != null) {
                removeView(view2);
                this.f14045f = null;
            }
            this.f14046g = null;
            this.f14047h = null;
        }
        boolean z7 = false;
        if (this.f14045f == null) {
            if (this.f14042c == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.p2serv.android.p032ds.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                this.f14042c = imageView2;
                addView(imageView2, 0);
            }
            if (this.f14041b == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.p2serv.android.p032ds.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                this.f14041b = textView3;
                addView(textView3);
                this.f14049j = this.f14041b.getMaxLines();
            }
            TextView textView4 = this.f14041b;
            TabLayout tabLayout = this.f14050k;
            AbstractC3198d.m6443R(textView4, tabLayout.f6714h);
            ColorStateList colorStateList = tabLayout.f6715i;
            if (colorStateList != null) {
                this.f14041b.setTextColor(colorStateList);
            }
            m8151f(this.f14041b, this.f14042c);
            m8147b();
            ImageView imageView3 = this.f14042c;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC4131j(this, imageView3));
            }
            TextView textView5 = this.f14041b;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC4131j(this, textView5));
            }
        } else {
            TextView textView6 = this.f14046g;
            if (textView6 != null || this.f14047h != null) {
                m8151f(textView6, this.f14047h);
            }
        }
        if (c4129h != null && !TextUtils.isEmpty(c4129h.f14029c)) {
            setContentDescription(c4129h.f14029c);
        }
        if (c4129h != null) {
            TabLayout tabLayout2 = c4129h.f14032f;
            if (tabLayout2 == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout2.getSelectedTabPosition();
            if (selectedTabPosition != -1 && selectedTabPosition == c4129h.f14030d) {
                z7 = true;
            }
        }
        setSelected(z7);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f14048i;
        if ((drawable == null || !drawable.isStateful()) ? false : this.f14048i.setState(drawableState)) {
            invalidate();
            this.f14050k.invalidate();
        }
    }

    public final void m8150e(Context context) {
        GradientDrawable gradientDrawable;
        TabLayout tabLayout = this.f14050k;
        int i6 = tabLayout.f6723q;
        if (i6 != 0) {
            Drawable drawableM3473h = AbstractC1465c.m3473h(context, i6);
            this.f14048i = drawableM3473h;
            if (drawableM3473h != null && drawableM3473h.isStateful()) {
                this.f14048i.setState(getDrawableState());
            }
        } else {
            this.f14048i = null;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        Drawable rippleDrawable = gradientDrawable2;
        if (tabLayout.f6717k != null) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setCornerRadius(1.0E-5f);
            gradientDrawable3.setColor(-1);
            ColorStateList colorStateListM7484a = AbstractC3722c.m7484a(tabLayout.f6717k);
            boolean z7 = tabLayout.f6694E;
            if (z7) {
                gradientDrawable = gradientDrawable2;
                gradientDrawable = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListM7484a, gradientDrawable, z7 ? null : gradientDrawable3);
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void m8151f(TextView textView, ImageView imageView) {
        Drawable drawable;
        C4129h c4129h = this.f14040a;
        Drawable drawableMutate = (c4129h == null || (drawable = c4129h.f14027a) == null) ? null : AbstractC3198d.m6448W(drawable).mutate();
        TabLayout tabLayout = this.f14050k;
        if (drawableMutate != null) {
            AbstractC2581a.m5586h(drawableMutate, tabLayout.f6716j);
            PorterDuff.Mode mode = tabLayout.f6720n;
            if (mode != null) {
                AbstractC2581a.m5587i(drawableMutate, mode);
            }
        }
        C4129h c4129h2 = this.f14040a;
        CharSequence charSequence = c4129h2 != null ? c4129h2.f14028b : null;
        if (imageView != null) {
            if (drawableMutate != null) {
                imageView.setImageDrawable(drawableMutate);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                textView.setVisibility(8);
                textView.setText((CharSequence) null);
            } else {
                textView.setText(charSequence);
                this.f14040a.getClass();
                textView.setVisibility(0);
                setVisibility(0);
            }
        }
        if (imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iM4245e = (zIsEmpty || imageView.getVisibility() != 0) ? 0 : (int) AbstractC1811a0.m4245e(getContext(), 8);
            if (tabLayout.f6690A) {
                if (iM4245e != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iM4245e);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iM4245e != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iM4245e;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        C4129h c4129h3 = this.f14040a;
        CharSequence charSequence2 = c4129h3 != null ? c4129h3.f14029c : null;
        if (Build.VERSION.SDK_INT > 23) {
            if (zIsEmpty) {
                charSequence = charSequence2;
            }
            AbstractC3612b.m7256L(this, charSequence);
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.f14041b, this.f14042c, this.f14045f};
        int iMax = 0;
        int iMin = 0;
        boolean z7 = false;
        for (int i6 = 0; i6 < 3; i6++) {
            View view = viewArr[i6];
            if (view != null && view.getVisibility() == 0) {
                iMin = z7 ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z7 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z7 = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.f14041b, this.f14042c, this.f14045f};
        int iMax = 0;
        int iMin = 0;
        boolean z7 = false;
        for (int i6 = 0; i6 < 3; i6++) {
            View view = viewArr[i6];
            if (view != null && view.getVisibility() == 0) {
                iMin = z7 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z7 ? Math.max(iMax, view.getRight()) : view.getRight();
                z7 = true;
            }
        }
        return iMax - iMin;
    }

    public C4129h getTab() {
        return this.f14040a;
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C4355a c4355a = this.f14044e;
        if (c4355a != null && c4355a.isVisible()) {
            accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f14044e.m8394c()));
        }
        accessibilityNodeInfo.setCollectionItemInfo(C3232g.m6538a(0, 1, this.f14040a.f14030d, 1, isSelected()).f10860a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) C3228c.f10843g.f10856a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(com.p2serv.android.p032ds.R.string.item_view_role_description));
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        TabLayout tabLayout = this.f14050k;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i6 = View.MeasureSpec.makeMeasureSpec(tabLayout.f6724r, Integer.MIN_VALUE);
        }
        super.onMeasure(i6, i10);
        if (this.f14041b != null) {
            float f = tabLayout.f6721o;
            int i11 = this.f14049j;
            ImageView imageView = this.f14042c;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.f14041b;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.f6722p;
                }
            } else {
                i11 = 1;
            }
            float textSize = this.f14041b.getTextSize();
            int lineCount = this.f14041b.getLineCount();
            int maxLines = this.f14041b.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i11 != maxLines)) {
                if (tabLayout.f6732z == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.f14041b.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.f14041b.setTextSize(0, f);
                this.f14041b.setMaxLines(i11);
                super.onMeasure(i6, i10);
            }
        }
    }

    @Override
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.f14040a == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        C4129h c4129h = this.f14040a;
        TabLayout tabLayout = c4129h.f14032f;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.m4345l(c4129h, true);
        return true;
    }

    @Override
    public void setSelected(boolean z7) {
        isSelected();
        super.setSelected(z7);
        TextView textView = this.f14041b;
        if (textView != null) {
            textView.setSelected(z7);
        }
        ImageView imageView = this.f14042c;
        if (imageView != null) {
            imageView.setSelected(z7);
        }
        View view = this.f14045f;
        if (view != null) {
            view.setSelected(z7);
        }
    }

    public void setTab(C4129h c4129h) {
        if (c4129h != this.f14040a) {
            this.f14040a = c4129h;
            m8149d();
        }
    }
}
