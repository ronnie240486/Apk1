package p178q6;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3281e;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public abstract class AbstractC3507d extends ProgressBar {

    public final AbstractC3508e f11798a;

    public int f11799b;

    public final boolean f11800c;

    public final int f11801d;

    public C3504a f11802e;

    public boolean f11803f;

    public int f11804g;

    public final RunnableC3505b f11805h;

    public final RunnableC3505b f11806i;

    public final C3506c f11807j;

    public final C3506c f11808k;

    public AbstractC3507d(Context context, AttributeSet attributeSet, int i6, int i10) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_ProgressIndicator), attributeSet, i6);
        this.f11803f = false;
        this.f11804g = 4;
        this.f11805h = new RunnableC3505b(this, 0);
        this.f11806i = new RunnableC3505b(this, 1);
        this.f11807j = new C3506c(this, 0);
        this.f11808k = new C3506c(this, 1);
        Context context2 = getContext();
        this.f11798a = mo4302a(context2, attributeSet);
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13989d, i6, i10, new int[0]);
        typedArrayM4250j.getInt(5, -1);
        this.f11801d = Math.min(typedArrayM4250j.getInt(3, -1), 1000);
        typedArrayM4250j.recycle();
        this.f11802e = new C3504a();
        this.f11800c = true;
    }

    private AbstractC3516m getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f11858l;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().f11835l;
    }

    public abstract AbstractC3508e mo4302a(Context context, AttributeSet attributeSet);

    public void mo4304b(int i6) {
        if (!isIndeterminate()) {
            super.setProgress(i6);
            if (getProgressDrawable() != null) {
                getProgressDrawable().jumpToCurrentState();
                return;
            }
            return;
        }
        if (getProgressDrawable() != null) {
            this.f11799b = i6;
            this.f11803f = true;
            if (getIndeterminateDrawable().isVisible()) {
                C3504a c3504a = this.f11802e;
                ContentResolver contentResolver = getContext().getContentResolver();
                c3504a.getClass();
                if (Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) != 0.0f) {
                    getIndeterminateDrawable().f11859m.mo7158d();
                    return;
                }
            }
            getIndeterminateDrawable();
            this.f11807j.m7147a();
        }
    }

    public final boolean m7148c() {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (isAttachedToWindow() && getWindowVisibility() == 0) {
            View view = this;
            while (view.getVisibility() == 0) {
                Object parent = view.getParent();
                if (parent == null) {
                    if (getWindowVisibility() == 0) {
                    }
                } else if (parent instanceof View) {
                    view = (View) parent;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f11798a.f11814f;
    }

    public int[] getIndicatorColor() {
        return this.f11798a.f11811c;
    }

    public int getShowAnimationBehavior() {
        return this.f11798a.f11813e;
    }

    public int getTrackColor() {
        return this.f11798a.f11812d;
    }

    public int getTrackCornerRadius() {
        return this.f11798a.f11810b;
    }

    public int getTrackThickness() {
        return this.f11798a.f11809a;
    }

    @Override
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f11859m.mo7157c(this.f11807j);
        }
        C3513j progressDrawable = getProgressDrawable();
        C3506c c3506c = this.f11808k;
        if (progressDrawable != null) {
            C3513j progressDrawable2 = getProgressDrawable();
            if (progressDrawable2.f11848f == null) {
                progressDrawable2.f11848f = new ArrayList();
            }
            if (!progressDrawable2.f11848f.contains(c3506c)) {
                progressDrawable2.f11848f.add(c3506c);
            }
        }
        if (getIndeterminateDrawable() != null) {
            C3518o indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.f11848f == null) {
                indeterminateDrawable.f11848f = new ArrayList();
            }
            if (!indeterminateDrawable.f11848f.contains(c3506c)) {
                indeterminateDrawable.f11848f.add(c3506c);
            }
        }
        if (m7148c()) {
            if (this.f11801d > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f11806i);
        removeCallbacks(this.f11805h);
        ((AbstractC3515l) getCurrentDrawable()).m7166e(false, false, false);
        C3518o indeterminateDrawable = getIndeterminateDrawable();
        C3506c c3506c = this.f11808k;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().m7167g(c3506c);
            getIndeterminateDrawable().f11859m.mo7160f();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m7167g(c3506c);
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public final synchronized void onMeasure(int i6, int i10) {
        try {
            super.onMeasure(i6, i10);
            AbstractC3516m currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            int iMo7153e = currentDrawingDelegate.mo7153e();
            int iMo7152d = currentDrawingDelegate.mo7152d();
            setMeasuredDimension(iMo7153e < 0 ? getMeasuredWidth() : iMo7153e + getPaddingLeft() + getPaddingRight(), iMo7152d < 0 ? getMeasuredHeight() : iMo7152d + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public final void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        boolean z7 = i6 == 0;
        if (this.f11800c) {
            ((AbstractC3515l) getCurrentDrawable()).m7166e(m7148c(), false, z7);
        }
    }

    @Override
    public final void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        if (this.f11800c) {
            ((AbstractC3515l) getCurrentDrawable()).m7166e(m7148c(), false, false);
        }
    }

    public void setAnimatorDurationScaleProvider(C3504a c3504a) {
        this.f11802e = c3504a;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f11845c = c3504a;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f11845c = c3504a;
        }
    }

    public void setHideAnimationBehavior(int i6) {
        this.f11798a.f11814f = i6;
        invalidate();
    }

    @Override
    public synchronized void setIndeterminate(boolean z7) {
        try {
            if (z7 == isIndeterminate()) {
                return;
            }
            AbstractC3515l abstractC3515l = (AbstractC3515l) getCurrentDrawable();
            if (abstractC3515l != null) {
                abstractC3515l.m7166e(false, false, false);
            }
            super.setIndeterminate(z7);
            AbstractC3515l abstractC3515l2 = (AbstractC3515l) getCurrentDrawable();
            if (abstractC3515l2 != null) {
                abstractC3515l2.m7166e(m7148c(), false, false);
            }
            if ((abstractC3515l2 instanceof C3518o) && m7148c()) {
                ((C3518o) abstractC3515l2).f11859m.mo7159e();
            }
            this.f11803f = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof C3518o)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((AbstractC3515l) drawable).m7166e(false, false, false);
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{AbstractC3281e.m6627q(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f11798a.f11811c = iArr;
        getIndeterminateDrawable().f11859m.mo7156b();
        invalidate();
    }

    @Override
    public synchronized void setProgress(int i6) {
        if (isIndeterminate()) {
            return;
        }
        mo4304b(i6);
    }

    @Override
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof C3513j)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            C3513j c3513j = (C3513j) drawable;
            c3513j.m7166e(false, false, false);
            super.setProgressDrawable(c3513j);
            c3513j.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        }
    }

    public void setShowAnimationBehavior(int i6) {
        this.f11798a.f11813e = i6;
        invalidate();
    }

    public void setTrackColor(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        if (abstractC3508e.f11812d != i6) {
            abstractC3508e.f11812d = i6;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        if (abstractC3508e.f11810b != i6) {
            abstractC3508e.f11810b = Math.min(i6, abstractC3508e.f11809a / 2);
        }
    }

    public void setTrackThickness(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        if (abstractC3508e.f11809a != i6) {
            abstractC3508e.f11809a = i6;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i6) {
        if (i6 != 0 && i6 != 4 && i6 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f11804g = i6;
    }

    @Override
    public C3518o getIndeterminateDrawable() {
        return (C3518o) super.getIndeterminateDrawable();
    }

    @Override
    public C3513j getProgressDrawable() {
        return (C3513j) super.getProgressDrawable();
    }
}
