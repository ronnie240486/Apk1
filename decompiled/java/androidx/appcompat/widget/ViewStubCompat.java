package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import p045e.AbstractC2341a;

public final class ViewStubCompat extends View {

    public int f856a;

    public int f857b;

    public WeakReference f858c;

    public LayoutInflater f859d;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View m632a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f856a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f859d;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f856a, viewGroup, false);
        int i6 = this.f857b;
        if (i6 != -1) {
            viewInflate.setId(i6);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f858c = new WeakReference(viewInflate);
        return viewInflate;
    }

    public int getInflatedId() {
        return this.f857b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f859d;
    }

    public int getLayoutResource() {
        return this.f856a;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i6) {
        this.f857b = i6;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f859d = layoutInflater;
    }

    public void setLayoutResource(int i6) {
        this.f856a = i6;
    }

    @Override
    public void setVisibility(int i6) {
        WeakReference weakReference = this.f858c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i6);
            return;
        }
        super.setVisibility(i6);
        if (i6 == 0 || i6 == 4) {
            m632a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f856a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8152C, i6, 0);
        this.f857b = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f856a = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(0, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override
    public final void draw(Canvas canvas) {
    }

    public void setOnInflateListener(InterfaceC0183b4 interfaceC0183b4) {
    }
}
