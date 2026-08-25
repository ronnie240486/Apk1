package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p057f1.AbstractC2490a;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;

public final class FragmentContainerView extends FrameLayout {

    public ArrayList f1770a;

    public ArrayList f1771b;

    public View.OnApplyWindowInsetsListener f1772c;

    public boolean f1773d;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m1185a(View view) {
        ArrayList arrayList = this.f1771b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f1770a == null) {
            this.f1770a = new ArrayList();
        }
        this.f1770a.add(view);
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof AbstractComponentCallbacksC0427s ? (AbstractComponentCallbacksC0427s) tag : null) != null) {
            super.addView(view, i6, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override
    public final boolean addViewInLayout(View view, int i6, ViewGroup.LayoutParams layoutParams, boolean z7) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof AbstractComponentCallbacksC0427s ? (AbstractComponentCallbacksC0427s) tag : null) != null) {
            return super.addViewInLayout(view, i6, layoutParams, z7);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C3153r1 c3153r1M6324h = C3153r1.m6324h(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1772c;
        C3153r1 c3153r1M6324h2 = onApplyWindowInsetsListener != null ? C3153r1.m6324h(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets), null) : AbstractC3155s0.m6341k(this, c3153r1M6324h);
        if (!c3153r1M6324h2.f10641a.mo6239n()) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                AbstractC3155s0.m6332b(getChildAt(i6), c3153r1M6324h2);
            }
        }
        return windowInsets;
    }

    @Override
    public final void dispatchDraw(Canvas canvas) {
        if (this.f1773d && this.f1770a != null) {
            for (int i6 = 0; i6 < this.f1770a.size(); i6++) {
                super.drawChild(canvas, (View) this.f1770a.get(i6), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        ArrayList arrayList;
        if (!this.f1773d || (arrayList = this.f1770a) == null || arrayList.size() <= 0 || !this.f1770a.contains(view)) {
            return super.drawChild(canvas, view, j10);
        }
        return false;
    }

    @Override
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.f1771b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f1770a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1773d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            m1185a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override
    public final void removeDetachedView(View view, boolean z7) {
        if (z7) {
            m1185a(view);
        }
        super.removeDetachedView(view, z7);
    }

    @Override
    public final void removeView(View view) {
        m1185a(view);
        super.removeView(view);
    }

    @Override
    public final void removeViewAt(int i6) {
        m1185a(getChildAt(i6));
        super.removeViewAt(i6);
    }

    @Override
    public final void removeViewInLayout(View view) {
        m1185a(view);
        super.removeViewInLayout(view);
    }

    @Override
    public final void removeViews(int i6, int i10) {
        for (int i11 = i6; i11 < i6 + i10; i11++) {
            m1185a(getChildAt(i11));
        }
        super.removeViews(i6, i10);
    }

    @Override
    public final void removeViewsInLayout(int i6, int i10) {
        for (int i11 = i6; i11 < i6 + i10; i11++) {
            m1185a(getChildAt(i11));
        }
        super.removeViewsInLayout(i6, i10);
    }

    public void setDrawDisappearingViewsLast(boolean z7) {
        this.f1773d = z7;
    }

    @Override
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f1772c = onApplyWindowInsetsListener;
    }

    @Override
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1771b == null) {
                this.f1771b = new ArrayList();
            }
            this.f1771b.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i6) {
        String str;
        super(context, attributeSet, i6);
        this.f1773d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2490a.f8707b);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    @Override
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }
}
