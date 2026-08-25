package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0175a2;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p007a7.C0066c;
import p015b2.AbstractC1249a;
import p015b2.InterfaceC1254f;
import p045e.AbstractC2341a;
import p101j7.C2782c;
import p128m0.C3027c;
import p128m0.C3028d;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;
import p171q.C3388b;
import p221u6.C3908h;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p251x6.C4122a;
import p251x6.C4123b;
import p251x6.C4128g;
import p251x6.C4129h;
import p251x6.C4130i;
import p251x6.C4132k;
import p251x6.C4133l;
import p251x6.InterfaceC4124c;
import p251x6.InterfaceC4125d;
import p262y5.AbstractC4268a;
import p263y6.AbstractC4275a;

@InterfaceC1254f
public class TabLayout extends HorizontalScrollView {

    public static final C3028d f6689R = new C3028d(16);

    public boolean f6690A;

    public boolean f6691B;

    public int f6692C;

    public int f6693D;

    public boolean f6694E;

    public C3388b f6695F;

    public InterfaceC4124c f6696G;

    public final ArrayList f6697H;

    public C4133l f6698I;

    public ValueAnimator f6699J;

    public ViewPager f6700K;

    public AbstractC1249a f6701L;

    public C0175a2 f6702M;

    public C4130i f6703N;

    public C4123b f6704O;

    public boolean f6705P;

    public final C3027c f6706Q;

    public final ArrayList f6707a;

    public C4129h f6708b;

    public final C4128g f6709c;

    public final int f6710d;

    public final int f6711e;

    public final int f6712f;

    public final int f6713g;

    public final int f6714h;

    public ColorStateList f6715i;

    public ColorStateList f6716j;

    public ColorStateList f6717k;

    public Drawable f6718l;

    public int f6719m;

    public final PorterDuff.Mode f6720n;

    public final float f6721o;

    public final float f6722p;

    public final int f6723q;

    public int f6724r;

    public final int f6725s;

    public final int f6726t;

    public final int f6727u;

    public final int f6728v;

    public int f6729w;

    public final int f6730x;

    public int f6731y;

    public int f6732z;

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f6707a;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C4129h c4129h = (C4129h) arrayList.get(i6);
            if (c4129h != null && c4129h.f14027a != null && !TextUtils.isEmpty(c4129h.f14028b)) {
                if (!this.f6690A) {
                    return 72;
                }
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i6 = this.f6725s;
        if (i6 != -1) {
            return i6;
        }
        int i10 = this.f6732z;
        if (i10 == 0 || i10 == 2) {
            return this.f6727u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f6709c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i6) {
        C4128g c4128g = this.f6709c;
        int childCount = c4128g.getChildCount();
        if (i6 < childCount) {
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = c4128g.getChildAt(i10);
                boolean z7 = true;
                childAt.setSelected(i10 == i6);
                if (i10 != i6) {
                    z7 = false;
                }
                childAt.setActivated(z7);
                i10++;
            }
        }
    }

    public final void m4334a(InterfaceC4124c interfaceC4124c) {
        ArrayList arrayList = this.f6697H;
        if (arrayList.contains(interfaceC4124c)) {
            return;
        }
        arrayList.add(interfaceC4124c);
    }

    @Override
    public final void addView(View view) {
        m4336c(view);
    }

    public final void m4335b(C4129h c4129h, boolean z7) {
        ArrayList arrayList = this.f6707a;
        int size = arrayList.size();
        if (c4129h.f14032f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        c4129h.f14030d = size;
        arrayList.add(size, c4129h);
        int size2 = arrayList.size();
        for (int i6 = size + 1; i6 < size2; i6++) {
            ((C4129h) arrayList.get(i6)).f14030d = i6;
        }
        C4132k c4132k = c4129h.f14033g;
        c4132k.setSelected(false);
        c4132k.setActivated(false);
        int i10 = c4129h.f14030d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.f6732z == 1 && this.f6729w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f6709c.addView(c4132k, i10, layoutParams);
        if (z7) {
            TabLayout tabLayout = c4129h.f14032f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.m4345l(c4129h, true);
        }
    }

    public final void m4336c(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        C4129h c4129hM4342i = m4342i();
        CharSequence charSequence = tabItem.f6686a;
        if (charSequence != null) {
            if (TextUtils.isEmpty(c4129hM4342i.f14029c) && !TextUtils.isEmpty(charSequence)) {
                c4129hM4342i.f14033g.setContentDescription(charSequence);
            }
            c4129hM4342i.f14028b = charSequence;
            c4129hM4342i.m8145a();
        }
        Drawable drawable = tabItem.f6687b;
        if (drawable != null) {
            c4129hM4342i.f14027a = drawable;
            TabLayout tabLayout = c4129hM4342i.f14032f;
            if (tabLayout.f6729w == 1 || tabLayout.f6732z == 2) {
                tabLayout.m4349p(true);
            }
            c4129hM4342i.m8145a();
        }
        int i6 = tabItem.f6688c;
        if (i6 != 0) {
            c4129hM4342i.f14031e = LayoutInflater.from(c4129hM4342i.f14033g.getContext()).inflate(i6, (ViewGroup) c4129hM4342i.f14033g, false);
            c4129hM4342i.m8145a();
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            c4129hM4342i.f14029c = tabItem.getContentDescription();
            c4129hM4342i.m8145a();
        }
        m4335b(c4129hM4342i, this.f6707a.isEmpty());
    }

    public final void m4337d(int i6) {
        if (i6 == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (isLaidOut()) {
                C4128g c4128g = this.f6709c;
                int childCount = c4128g.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    if (c4128g.getChildAt(i10).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iM4339f = m4339f(i6, 0.0f);
                if (scrollX != iM4339f) {
                    m4340g();
                    this.f6699J.setIntValues(scrollX, iM4339f);
                    this.f6699J.start();
                }
                ValueAnimator valueAnimator = c4128g.f14022a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    c4128g.f14022a.cancel();
                }
                c4128g.m8144d(i6, this.f6730x, true);
                return;
            }
        }
        m4347n(i6, 0.0f, true, true);
    }

    public final void m4338e() {
        int i6 = this.f6732z;
        int iMax = (i6 == 0 || i6 == 2) ? Math.max(0, this.f6728v - this.f6710d) : 0;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        C4128g c4128g = this.f6709c;
        c4128g.setPaddingRelative(iMax, 0, 0, 0);
        int i10 = this.f6732z;
        if (i10 == 0) {
            int i11 = this.f6729w;
            if (i11 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i11 == 1) {
                c4128g.setGravity(1);
            } else if (i11 == 2) {
            }
            c4128g.setGravity(8388611);
        } else if (i10 == 1 || i10 == 2) {
            if (this.f6729w == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            c4128g.setGravity(1);
        }
        m4349p(true);
    }

    public final int m4339f(int i6, float f) {
        C4128g c4128g;
        View childAt;
        int i10 = this.f6732z;
        if ((i10 != 0 && i10 != 2) || (childAt = (c4128g = this.f6709c).getChildAt(i6)) == null) {
            return 0;
        }
        int i11 = i6 + 1;
        View childAt2 = i11 < c4128g.getChildCount() ? c4128g.getChildAt(i11) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i12 = (int) ((width + width2) * 0.5f * f);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return getLayoutDirection() == 0 ? left + i12 : left - i12;
    }

    public final void m4340g() {
        if (this.f6699J == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f6699J = valueAnimator;
            valueAnimator.setInterpolator(AbstractC4268a.f14470b);
            this.f6699J.setDuration(this.f6730x);
            this.f6699J.addUpdateListener(new C0066c(7, this));
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        C4129h c4129h = this.f6708b;
        if (c4129h != null) {
            return c4129h.f14030d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f6707a.size();
    }

    public int getTabGravity() {
        return this.f6729w;
    }

    public ColorStateList getTabIconTint() {
        return this.f6716j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f6693D;
    }

    public int getTabIndicatorGravity() {
        return this.f6731y;
    }

    public int getTabMaxWidth() {
        return this.f6724r;
    }

    public int getTabMode() {
        return this.f6732z;
    }

    public ColorStateList getTabRippleColor() {
        return this.f6717k;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f6718l;
    }

    public ColorStateList getTabTextColors() {
        return this.f6715i;
    }

    public final C4129h m4341h(int i6) {
        if (i6 < 0 || i6 >= getTabCount()) {
            return null;
        }
        return (C4129h) this.f6707a.get(i6);
    }

    public final C4129h m4342i() {
        C4129h c4129h = (C4129h) f6689R.mo6099a();
        if (c4129h == null) {
            c4129h = new C4129h();
            c4129h.f14030d = -1;
        }
        c4129h.f14032f = this;
        C3027c c3027c = this.f6706Q;
        C4132k c4132k = c3027c != null ? (C4132k) c3027c.mo6099a() : null;
        if (c4132k == null) {
            c4132k = new C4132k(this, getContext());
        }
        c4132k.setTab(c4129h);
        c4132k.setFocusable(true);
        c4132k.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(c4129h.f14029c)) {
            c4132k.setContentDescription(c4129h.f14028b);
        } else {
            c4132k.setContentDescription(c4129h.f14029c);
        }
        c4129h.f14033g = c4132k;
        return c4129h;
    }

    public final void m4343j() {
        int currentItem;
        m4344k();
        AbstractC1249a abstractC1249a = this.f6701L;
        if (abstractC1249a != null) {
            int iMo3131c = abstractC1249a.mo3131c();
            for (int i6 = 0; i6 < iMo3131c; i6++) {
                C4129h c4129hM4342i = m4342i();
                this.f6701L.getClass();
                if (TextUtils.isEmpty(c4129hM4342i.f14029c) && !TextUtils.isEmpty(null)) {
                    c4129hM4342i.f14033g.setContentDescription(null);
                }
                c4129hM4342i.f14028b = null;
                c4129hM4342i.m8145a();
                m4335b(c4129hM4342i, false);
            }
            ViewPager viewPager = this.f6700K;
            if (viewPager == null || iMo3131c <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            m4345l(m4341h(currentItem), true);
        }
    }

    public final void m4344k() {
        C4128g c4128g = this.f6709c;
        int childCount = c4128g.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            C4132k c4132k = (C4132k) c4128g.getChildAt(childCount);
            c4128g.removeViewAt(childCount);
            if (c4132k != null) {
                c4132k.setTab(null);
                c4132k.setSelected(false);
                this.f6706Q.mo6101c(c4132k);
            }
            requestLayout();
        }
        Iterator it = this.f6707a.iterator();
        while (it.hasNext()) {
            C4129h c4129h = (C4129h) it.next();
            it.remove();
            c4129h.f14032f = null;
            c4129h.f14033g = null;
            c4129h.f14027a = null;
            c4129h.f14028b = null;
            c4129h.f14029c = null;
            c4129h.f14030d = -1;
            c4129h.f14031e = null;
            f6689R.mo6101c(c4129h);
        }
        this.f6708b = null;
    }

    public final void m4345l(C4129h c4129h, boolean z7) {
        C4129h c4129h2 = this.f6708b;
        ArrayList arrayList = this.f6697H;
        if (c4129h2 == c4129h) {
            if (c4129h2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((InterfaceC4124c) arrayList.get(size)).mo5905a(c4129h);
                }
                m4337d(c4129h.f14030d);
                return;
            }
            return;
        }
        int i6 = c4129h != null ? c4129h.f14030d : -1;
        if (z7) {
            if ((c4129h2 == null || c4129h2.f14030d == -1) && i6 != -1) {
                m4347n(i6, 0.0f, true, true);
            } else {
                m4337d(i6);
            }
            if (i6 != -1) {
                setSelectedTabView(i6);
            }
        }
        this.f6708b = c4129h;
        if (c4129h2 != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((InterfaceC4124c) arrayList.get(size2)).mo5906b(c4129h2);
            }
        }
        if (c4129h != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((InterfaceC4124c) arrayList.get(size3)).mo5907c(c4129h);
            }
        }
    }

    public final void m4346m(AbstractC1249a abstractC1249a, boolean z7) {
        C0175a2 c0175a2;
        AbstractC1249a abstractC1249a2 = this.f6701L;
        if (abstractC1249a2 != null && (c0175a2 = this.f6702M) != null) {
            abstractC1249a2.f3970a.unregisterObserver(c0175a2);
        }
        this.f6701L = abstractC1249a;
        if (z7 && abstractC1249a != null) {
            if (this.f6702M == null) {
                this.f6702M = new C0175a2(3, this);
            }
            abstractC1249a.f3970a.registerObserver(this.f6702M);
        }
        m4343j();
    }

    public final void m4347n(int i6, float f, boolean z7, boolean z10) {
        int iRound = Math.round(i6 + f);
        if (iRound >= 0) {
            C4128g c4128g = this.f6709c;
            if (iRound >= c4128g.getChildCount()) {
                return;
            }
            if (z10) {
                ValueAnimator valueAnimator = c4128g.f14022a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    c4128g.f14022a.cancel();
                }
                c4128g.f14023b = i6;
                c4128g.f14024c = f;
                c4128g.m8143c(c4128g.getChildAt(i6), c4128g.getChildAt(c4128g.f14023b + 1), c4128g.f14024c);
            }
            ValueAnimator valueAnimator2 = this.f6699J;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f6699J.cancel();
            }
            scrollTo(i6 < 0 ? 0 : m4339f(i6, f), 0);
            if (z7) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void m4348o(ViewPager viewPager, boolean z7) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ViewPager viewPager2 = this.f6700K;
        if (viewPager2 != null) {
            C4130i c4130i = this.f6703N;
            if (c4130i != null && (arrayList2 = viewPager2.f3870Q) != null) {
                arrayList2.remove(c4130i);
            }
            C4123b c4123b = this.f6704O;
            if (c4123b != null && (arrayList = this.f6700K.f3873T) != null) {
                arrayList.remove(c4123b);
            }
        }
        C4133l c4133l = this.f6698I;
        if (c4133l != null) {
            this.f6697H.remove(c4133l);
            this.f6698I = null;
        }
        if (viewPager != null) {
            this.f6700K = viewPager;
            if (this.f6703N == null) {
                this.f6703N = new C4130i(this);
            }
            C4130i c4130i2 = this.f6703N;
            c4130i2.f14036c = 0;
            c4130i2.f14035b = 0;
            if (viewPager.f3870Q == null) {
                viewPager.f3870Q = new ArrayList();
            }
            viewPager.f3870Q.add(c4130i2);
            C4133l c4133l2 = new C4133l(viewPager, 0);
            this.f6698I = c4133l2;
            m4334a(c4133l2);
            AbstractC1249a adapter = viewPager.getAdapter();
            if (adapter != null) {
                m4346m(adapter, true);
            }
            if (this.f6704O == null) {
                this.f6704O = new C4123b(this);
            }
            C4123b c4123b2 = this.f6704O;
            c4123b2.f14014a = true;
            if (viewPager.f3873T == null) {
                viewPager.f3873T = new ArrayList();
            }
            viewPager.f3873T.add(c4123b2);
            m4347n(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.f6700K = null;
            m4346m(null, false);
        }
        this.f6705P = z7;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6568E(this);
        if (this.f6700K == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m4348o((ViewPager) parent, true);
            }
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6705P) {
            setupWithViewPager(null);
            this.f6705P = false;
        }
    }

    @Override
    public final void onDraw(Canvas canvas) {
        C4132k c4132k;
        Drawable drawable;
        int i6 = 0;
        while (true) {
            C4128g c4128g = this.f6709c;
            if (i6 >= c4128g.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = c4128g.getChildAt(i6);
            if ((childAt instanceof C4132k) && (drawable = (c4132k = (C4132k) childAt).f14048i) != null) {
                drawable.setBounds(c4132k.getLeft(), c4132k.getTop(), c4132k.getRight(), c4132k.getBottom());
                c4132k.f14048i.draw(canvas);
            }
            i6++;
        }
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) C2782c.m5751x(1, getTabCount(), 1, false).f9501b);
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int iRound = Math.round(AbstractC1811a0.m4245e(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i10 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i10) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i6);
        if (View.MeasureSpec.getMode(i6) != 0) {
            int iM4245e = this.f6726t;
            if (iM4245e <= 0) {
                iM4245e = (int) (size - AbstractC1811a0.m4245e(getContext(), 56));
            }
            this.f6724r = iM4245e;
        }
        super.onMeasure(i6, i10);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i11 = this.f6732z;
            if (i11 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i11 != 1) {
                if (i11 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void m4349p(boolean z7) {
        int i6 = 0;
        while (true) {
            C4128g c4128g = this.f6709c;
            if (i6 >= c4128g.getChildCount()) {
                return;
            }
            View childAt = c4128g.getChildAt(i6);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.f6732z == 1 && this.f6729w == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z7) {
                childAt.requestLayout();
            }
            i6++;
        }
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC3280d.m6565B(this, f);
    }

    public void setInlineLabel(boolean z7) {
        if (this.f6690A == z7) {
            return;
        }
        this.f6690A = z7;
        int i6 = 0;
        while (true) {
            C4128g c4128g = this.f6709c;
            if (i6 >= c4128g.getChildCount()) {
                m4338e();
                return;
            }
            View childAt = c4128g.getChildAt(i6);
            if (childAt instanceof C4132k) {
                C4132k c4132k = (C4132k) childAt;
                c4132k.setOrientation(!c4132k.f14050k.f6690A ? 1 : 0);
                TextView textView = c4132k.f14046g;
                if (textView == null && c4132k.f14047h == null) {
                    c4132k.m8151f(c4132k.f14041b, c4132k.f14042c);
                } else {
                    c4132k.m8151f(textView, c4132k.f14047h);
                }
            }
            i6++;
        }
    }

    public void setInlineLabelResource(int i6) {
        setInlineLabel(getResources().getBoolean(i6));
    }

    @Deprecated
    public void setOnTabSelectedListener(InterfaceC4125d interfaceC4125d) {
        setOnTabSelectedListener((InterfaceC4124c) interfaceC4125d);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        m4340g();
        this.f6699J.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f6718l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f6718l = drawable;
            int intrinsicHeight = this.f6692C;
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable.getIntrinsicHeight();
            }
            this.f6709c.m8142b(intrinsicHeight);
        }
    }

    public void setSelectedTabIndicatorColor(int i6) {
        this.f6719m = i6;
        m4349p(false);
    }

    public void setSelectedTabIndicatorGravity(int i6) {
        if (this.f6731y != i6) {
            this.f6731y = i6;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            this.f6709c.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i6) {
        this.f6692C = i6;
        this.f6709c.m8142b(i6);
    }

    public void setTabGravity(int i6) {
        if (this.f6729w != i6) {
            this.f6729w = i6;
            m4338e();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f6716j != colorStateList) {
            this.f6716j = colorStateList;
            ArrayList arrayList = this.f6707a;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((C4129h) arrayList.get(i6)).m8145a();
            }
        }
    }

    public void setTabIconTintResource(int i6) {
        setTabIconTint(AbstractC3928d.m7848k(getContext(), i6));
    }

    public void setTabIndicatorAnimationMode(int i6) {
        this.f6693D = i6;
        if (i6 == 0) {
            this.f6695F = new C3388b(10);
            return;
        }
        if (i6 == 1) {
            this.f6695F = new C4122a(0);
        } else {
            if (i6 == 2) {
                this.f6695F = new C4122a(1);
                return;
            }
            throw new IllegalArgumentException(i6 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z7) {
        this.f6691B = z7;
        int i6 = C4128g.f14021f;
        C4128g c4128g = this.f6709c;
        c4128g.m8141a();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        c4128g.postInvalidateOnAnimation();
    }

    public void setTabMode(int i6) {
        if (i6 != this.f6732z) {
            this.f6732z = i6;
            m4338e();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f6717k == colorStateList) {
            return;
        }
        this.f6717k = colorStateList;
        int i6 = 0;
        while (true) {
            C4128g c4128g = this.f6709c;
            if (i6 >= c4128g.getChildCount()) {
                return;
            }
            View childAt = c4128g.getChildAt(i6);
            if (childAt instanceof C4132k) {
                Context context = getContext();
                int i10 = C4132k.f14039l;
                ((C4132k) childAt).m8150e(context);
            }
            i6++;
        }
    }

    public void setTabRippleColorResource(int i6) {
        setTabRippleColor(AbstractC3928d.m7848k(getContext(), i6));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f6715i != colorStateList) {
            this.f6715i = colorStateList;
            ArrayList arrayList = this.f6707a;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((C4129h) arrayList.get(i6)).m8145a();
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(AbstractC1249a abstractC1249a) {
        m4346m(abstractC1249a, false);
    }

    public void setUnboundedRipple(boolean z7) {
        if (this.f6694E == z7) {
            return;
        }
        this.f6694E = z7;
        int i6 = 0;
        while (true) {
            C4128g c4128g = this.f6709c;
            if (i6 >= c4128g.getChildCount()) {
                return;
            }
            View childAt = c4128g.getChildAt(i6);
            if (childAt instanceof C4132k) {
                Context context = getContext();
                int i10 = C4132k.f14039l;
                ((C4132k) childAt).m8150e(context);
            }
            i6++;
        }
    }

    public void setUnboundedRippleResource(int i6) {
        setUnboundedRipple(getResources().getBoolean(i6));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m4348o(viewPager, false);
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_Design_TabLayout), attributeSet, i6);
        this.f6707a = new ArrayList();
        this.f6718l = new GradientDrawable();
        this.f6719m = 0;
        this.f6724r = Integer.MAX_VALUE;
        this.f6692C = -1;
        this.f6697H = new ArrayList();
        this.f6706Q = new C3027c(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        C4128g c4128g = new C4128g(this, context2);
        this.f6709c = c4128g;
        super.addView(c4128g, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13981Y, i6, R.style.Widget_Design_TabLayout, 23);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            C3908h c3908h = new C3908h();
            c3908h.m7809n(ColorStateList.valueOf(colorDrawable.getColor()));
            c3908h.m7806k(context2);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            c3908h.m7808m(AbstractC3119g0.m6170i(this));
            setBackground(c3908h);
        }
        setSelectedTabIndicator(AbstractC1466d.m3496n(context2, typedArrayM4250j, 5));
        setSelectedTabIndicatorColor(typedArrayM4250j.getColor(8, 0));
        c4128g.m8142b(typedArrayM4250j.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(typedArrayM4250j.getInt(10, 0));
        setTabIndicatorAnimationMode(typedArrayM4250j.getInt(7, 0));
        setTabIndicatorFullWidth(typedArrayM4250j.getBoolean(9, true));
        int dimensionPixelSize = typedArrayM4250j.getDimensionPixelSize(16, 0);
        this.f6713g = dimensionPixelSize;
        this.f6712f = dimensionPixelSize;
        this.f6711e = dimensionPixelSize;
        this.f6710d = dimensionPixelSize;
        this.f6710d = typedArrayM4250j.getDimensionPixelSize(19, dimensionPixelSize);
        this.f6711e = typedArrayM4250j.getDimensionPixelSize(20, dimensionPixelSize);
        this.f6712f = typedArrayM4250j.getDimensionPixelSize(18, dimensionPixelSize);
        this.f6713g = typedArrayM4250j.getDimensionPixelSize(17, dimensionPixelSize);
        int resourceId = typedArrayM4250j.getResourceId(23, R.style.TextAppearance_Design_Tab);
        this.f6714h = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, AbstractC2341a.f8177y);
        try {
            this.f6721o = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f6715i = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 3);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayM4250j.hasValue(24)) {
                this.f6715i = AbstractC1466d.m3493k(context2, typedArrayM4250j, 24);
            }
            if (typedArrayM4250j.hasValue(22)) {
                this.f6715i = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{typedArrayM4250j.getColor(22, 0), this.f6715i.getDefaultColor()});
            }
            this.f6716j = AbstractC1466d.m3493k(context2, typedArrayM4250j, 3);
            this.f6720n = AbstractC1811a0.m4252l(typedArrayM4250j.getInt(4, -1), null);
            this.f6717k = AbstractC1466d.m3493k(context2, typedArrayM4250j, 21);
            this.f6730x = typedArrayM4250j.getInt(6, 300);
            this.f6725s = typedArrayM4250j.getDimensionPixelSize(14, -1);
            this.f6726t = typedArrayM4250j.getDimensionPixelSize(13, -1);
            this.f6723q = typedArrayM4250j.getResourceId(0, 0);
            this.f6728v = typedArrayM4250j.getDimensionPixelSize(1, 0);
            this.f6732z = typedArrayM4250j.getInt(15, 1);
            this.f6729w = typedArrayM4250j.getInt(2, 0);
            this.f6690A = typedArrayM4250j.getBoolean(12, false);
            this.f6694E = typedArrayM4250j.getBoolean(25, false);
            typedArrayM4250j.recycle();
            Resources resources = getResources();
            this.f6722p = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f6727u = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            m4338e();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override
    public final void addView(View view, int i6) {
        m4336c(view);
    }

    @Override
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(InterfaceC4124c interfaceC4124c) {
        InterfaceC4124c interfaceC4124c2 = this.f6696G;
        if (interfaceC4124c2 != null) {
            this.f6697H.remove(interfaceC4124c2);
        }
        this.f6696G = interfaceC4124c;
        if (interfaceC4124c != null) {
            m4334a(interfaceC4124c);
        }
    }

    @Override
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m4336c(view);
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        m4336c(view);
    }

    public void setSelectedTabIndicator(int i6) {
        if (i6 != 0) {
            setSelectedTabIndicator(AbstractC1465c.m3473h(getContext(), i6));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
