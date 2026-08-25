package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p045e.AbstractC2341a;
import p093j.AbstractC2740a;
import p105k.InterfaceC2823a0;
import p105k.MenuC2838l;
import p138n0.AbstractC3155s0;
import p138n0.C3102a1;

public class ActionBarContextView extends ViewGroup {

    public final C0172a f526a;

    public final Context f527b;

    public ActionMenuView f528c;

    public C0225k f529d;

    public int f530e;

    public C3102a1 f531f;

    public boolean f532g;

    public boolean f533h;

    public CharSequence f534i;

    public CharSequence f535j;

    public View f536k;

    public View f537l;

    public View f538m;

    public LinearLayout f539n;

    public TextView f540o;

    public TextView f541p;

    public final int f542q;

    public final int f543r;

    public boolean f544s;

    public final int f545t;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public static int m539f(View view, int i6, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE), i10);
        return Math.max(0, i6 - view.getMeasuredWidth());
    }

    public static int m540g(int i6, int i10, int i11, View view, boolean z7) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = ((i11 - measuredHeight) / 2) + i10;
        if (z7) {
            view.layout(i6 - measuredWidth, i12, i6, measuredHeight + i12);
        } else {
            view.layout(i6, i12, i6 + measuredWidth, measuredHeight + i12);
        }
        return z7 ? -measuredWidth : measuredWidth;
    }

    public final void m541c(AbstractC2740a abstractC2740a) {
        int i6 = 1;
        View view = this.f536k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f545t, (ViewGroup) this, false);
            this.f536k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f536k);
        }
        View viewFindViewById = this.f536k.findViewById(R.id.action_mode_close_button);
        this.f537l = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0122a(i6, abstractC2740a));
        MenuC2838l menuC2838lMo475c = abstractC2740a.mo475c();
        C0225k c0225k = this.f529d;
        if (c0225k != null) {
            c0225k.m708c();
            C0195e c0195e = c0225k.f972u;
            if (c0195e != null && c0195e.m5855b()) {
                c0195e.f9763i.dismiss();
            }
        }
        C0225k c0225k2 = new C0225k(getContext());
        this.f529d = c0225k2;
        c0225k2.f964m = true;
        c0225k2.f965n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuC2838lMo475c.m5826b(this.f529d, this.f527b);
        C0225k c0225k3 = this.f529d;
        InterfaceC2823a0 interfaceC2823a0 = c0225k3.f9616h;
        if (interfaceC2823a0 == null) {
            InterfaceC2823a0 interfaceC2823a1 = (InterfaceC2823a0) c0225k3.f9612d.inflate(c0225k3.f9614f, (ViewGroup) this, false);
            c0225k3.f9616h = interfaceC2823a1;
            interfaceC2823a1.mo536d(c0225k3.f9611c);
            c0225k3.mo712j(true);
        }
        InterfaceC2823a0 interfaceC2823a2 = c0225k3.f9616h;
        if (interfaceC2823a0 != interfaceC2823a2) {
            ((ActionMenuView) interfaceC2823a2).setPresenter(c0225k3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) interfaceC2823a2;
        this.f528c = actionMenuView;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        actionMenuView.setBackground(null);
        addView(this.f528c, layoutParams);
    }

    public final void m542d() {
        if (this.f539n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f539n = linearLayout;
            this.f540o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f541p = (TextView) this.f539n.findViewById(R.id.action_bar_subtitle);
            int i6 = this.f542q;
            if (i6 != 0) {
                this.f540o.setTextAppearance(getContext(), i6);
            }
            int i10 = this.f543r;
            if (i10 != 0) {
                this.f541p.setTextAppearance(getContext(), i10);
            }
        }
        this.f540o.setText(this.f534i);
        this.f541p.setText(this.f535j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f534i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f535j);
        this.f541p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f539n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f539n.getParent() == null) {
            addView(this.f539n);
        }
    }

    public final void m543e() {
        removeAllViews();
        this.f538m = null;
        this.f528c = null;
        this.f529d = null;
        View view = this.f537l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f531f != null ? this.f526a.f861b : getVisibility();
    }

    public int getContentHeight() {
        return this.f530e;
    }

    public CharSequence getSubtitle() {
        return this.f535j;
    }

    public CharSequence getTitle() {
        return this.f534i;
    }

    @Override
    public final void setVisibility(int i6) {
        if (i6 != getVisibility()) {
            C3102a1 c3102a1 = this.f531f;
            if (c3102a1 != null) {
                c3102a1.m6122b();
            }
            super.setVisibility(i6);
        }
    }

    public final C3102a1 m545i(int i6, long j10) {
        C3102a1 c3102a1 = this.f531f;
        if (c3102a1 != null) {
            c3102a1.m6122b();
        }
        C0172a c0172a = this.f526a;
        if (i6 != 0) {
            C3102a1 c3102a1M6331a = AbstractC3155s0.m6331a(this);
            c3102a1M6331a.m6121a(0.0f);
            c3102a1M6331a.m6123c(j10);
            ((ActionBarContextView) c0172a.f862c).f531f = c3102a1M6331a;
            c0172a.f861b = i6;
            c3102a1M6331a.m6124d(c0172a);
            return c3102a1M6331a;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C3102a1 c3102a1M6331a2 = AbstractC3155s0.m6331a(this);
        c3102a1M6331a2.m6121a(1.0f);
        c3102a1M6331a2.m6123c(j10);
        ((ActionBarContextView) c0172a.f862c).f531f = c3102a1M6331a2;
        c0172a.f861b = i6;
        c3102a1M6331a2.m6124d(c0172a);
        return c3102a1M6331a2;
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        int i6;
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC2341a.f8153a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0225k c0225k = this.f529d;
        if (c0225k != null) {
            Configuration configuration2 = c0225k.f9610b.getResources().getConfiguration();
            int i10 = configuration2.screenWidthDp;
            int i11 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp > 600 || i10 > 600 || ((i10 > 960 && i11 > 720) || (i10 > 720 && i11 > 960))) {
                i6 = 5;
            } else if (i10 >= 500 || ((i10 > 640 && i11 > 480) || (i10 > 480 && i11 > 640))) {
                i6 = 4;
            } else {
                i6 = i10 >= 360 ? 3 : 2;
            }
            c0225k.f968q = i6;
            MenuC2838l menuC2838l = c0225k.f9611c;
            if (menuC2838l != null) {
                menuC2838l.mo4279p(true);
            }
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0225k c0225k = this.f529d;
        if (c0225k != null) {
            c0225k.m708c();
            C0195e c0195e = this.f529d.f972u;
            if (c0195e == null || !c0195e.m5855b()) {
                return;
            }
            c0195e.f9763i.dismiss();
        }
    }

    @Override
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f533h = false;
        }
        if (!this.f533h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f533h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f533h = false;
        }
        return true;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        boolean zM648a = AbstractC0189c4.m648a(this);
        int paddingRight = zM648a ? (i11 - i6) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
        View view = this.f536k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f536k.getLayoutParams();
            int i13 = zM648a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i14 = zM648a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i15 = zM648a ? paddingRight - i13 : paddingRight + i13;
            int iM540g = m540g(i15, paddingTop, paddingTop2, this.f536k, zM648a) + i15;
            paddingRight = zM648a ? iM540g - i14 : iM540g + i14;
        }
        LinearLayout linearLayout = this.f539n;
        if (linearLayout != null && this.f538m == null && linearLayout.getVisibility() != 8) {
            paddingRight += m540g(paddingRight, paddingTop, paddingTop2, this.f539n, zM648a);
        }
        View view2 = this.f538m;
        if (view2 != null) {
            m540g(paddingRight, paddingTop, paddingTop2, view2, zM648a);
        }
        int paddingLeft = zM648a ? getPaddingLeft() : (i11 - i6) - getPaddingRight();
        ActionMenuView actionMenuView = this.f528c;
        if (actionMenuView != null) {
            m540g(paddingLeft, paddingTop, paddingTop2, actionMenuView, !zM648a);
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        if (View.MeasureSpec.getMode(i6) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i10) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i6);
        int size2 = this.f530e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i10);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f536k;
        if (view != null) {
            int iM539f = m539f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f536k.getLayoutParams();
            paddingLeft = iM539f - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f528c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = m539f(this.f528c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f539n;
        if (linearLayout != null && this.f538m == null) {
            if (this.f544s) {
                this.f539n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f539n.getMeasuredWidth();
                boolean z7 = measuredWidth <= paddingLeft;
                if (z7) {
                    paddingLeft -= measuredWidth;
                }
                this.f539n.setVisibility(z7 ? 0 : 8);
            } else {
                paddingLeft = m539f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f538m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = i11 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i11 >= 0) {
                paddingLeft = Math.min(i11, paddingLeft);
            }
            int i13 = layoutParams.height;
            int i14 = i13 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i13 >= 0) {
                iMin = Math.min(i13, iMin);
            }
            this.f538m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(iMin, i14));
        }
        if (this.f530e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            int measuredHeight = getChildAt(i16).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i15) {
                i15 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i15);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f532g = false;
        }
        if (!this.f532g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f532g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f532g = false;
        }
        return true;
    }

    public void setContentHeight(int i6) {
        this.f530e = i6;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f538m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f538m = view;
        if (view != null && (linearLayout = this.f539n) != null) {
            removeView(linearLayout);
            this.f539n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f535j = charSequence;
        m542d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f534i = charSequence;
        m542d();
        AbstractC3155s0.m6348r(this, charSequence);
    }

    public void setTitleOptional(boolean z7) {
        if (z7 != this.f544s) {
            requestLayout();
        }
        this.f544s = z7;
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i6) {
        int resourceId;
        super(context, attributeSet, i6);
        this.f526a = new C0172a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f527b = context;
        } else {
            this.f527b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8156d, i6, 0);
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : AbstractC1465c.m3473h(context, resourceId);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(drawable);
        this.f542q = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f543r = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f530e = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f545t = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }
}
