package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;

public class ActionBarContainer extends FrameLayout {

    public boolean f517a;

    public View f518b;

    public View f519c;

    public Drawable f520d;

    public Drawable f521e;

    public Drawable f522f;

    public final boolean f523g;

    public boolean f524h;

    public final int f525i;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0178b c0178b = new C0178b(this);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(c0178b);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8153a);
        boolean z7 = false;
        this.f520d = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f521e = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f525i = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f523g = true;
            this.f522f = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f523g ? !(this.f520d != null || this.f521e != null) : this.f522f == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f520d;
        if (drawable != null && drawable.isStateful()) {
            this.f520d.setState(getDrawableState());
        }
        Drawable drawable2 = this.f521e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f521e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f522f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f522f.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f520d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f521e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f522f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f518b = findViewById(R.id.action_bar);
        this.f519c = findViewById(R.id.action_context_bar);
    }

    @Override
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f517a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        boolean z10 = true;
        if (this.f523g) {
            Drawable drawable = this.f522f;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z10 = false;
            }
        } else {
            if (this.f520d == null) {
                z10 = false;
            } else if (this.f518b.getVisibility() == 0) {
                this.f520d.setBounds(this.f518b.getLeft(), this.f518b.getTop(), this.f518b.getRight(), this.f518b.getBottom());
            } else {
                View view = this.f519c;
                if (view == null || view.getVisibility() != 0) {
                    this.f520d.setBounds(0, 0, 0, 0);
                } else {
                    this.f520d.setBounds(this.f519c.getLeft(), this.f519c.getTop(), this.f519c.getRight(), this.f519c.getBottom());
                }
            }
            this.f524h = false;
        }
        if (z10) {
            invalidate();
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int i11;
        if (this.f518b == null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && (i11 = this.f525i) >= 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i10)), Integer.MIN_VALUE);
        }
        super.onMeasure(i6, i10);
        if (this.f518b == null) {
            return;
        }
        View.MeasureSpec.getMode(i10);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f520d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f520d);
        }
        this.f520d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f518b;
            if (view != null) {
                this.f520d.setBounds(view.getLeft(), this.f518b.getTop(), this.f518b.getRight(), this.f518b.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f523g ? !(this.f520d != null || this.f521e != null) : this.f522f == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f522f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f522f);
        }
        this.f522f = drawable;
        boolean z7 = this.f523g;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z7 && (drawable2 = this.f522f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z7 ? !(this.f520d != null || this.f521e != null) : this.f522f == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f521e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f521e);
        }
        this.f521e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f524h && this.f521e != null) {
                throw null;
            }
        }
        boolean z7 = false;
        if (!this.f523g ? !(this.f520d != null || this.f521e != null) : this.f522f == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z7) {
        this.f517a = z7;
        setDescendantFocusability(z7 ? 393216 : 262144);
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        boolean z7 = i6 == 0;
        Drawable drawable = this.f520d;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
        Drawable drawable2 = this.f521e;
        if (drawable2 != null) {
            drawable2.setVisible(z7, false);
        }
        Drawable drawable3 = this.f522f;
        if (drawable3 != null) {
            drawable3.setVisible(z7, false);
        }
    }

    @Override
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f520d;
        boolean z7 = this.f523g;
        return (drawable == drawable2 && !z7) || (drawable == this.f521e && this.f524h) || ((drawable == this.f522f && z7) || super.verifyDrawable(drawable));
    }

    @Override
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i6) {
        if (i6 != 0) {
            return super.startActionModeForChild(view, callback, i6);
        }
        return null;
    }

    public void setTabContainer(AbstractC0248o2 abstractC0248o2) {
    }
}
