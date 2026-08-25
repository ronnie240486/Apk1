package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import p225v.C3961h;
import p256y.AbstractC4193j;

public abstract class VirtualLayout extends ConstraintHelper {

    public boolean f1396h;

    public boolean f1397i;

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public void mo841g(AttributeSet attributeSet) {
        super.mo841g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 6) {
                    this.f1396h = true;
                } else if (index == 13) {
                    this.f1397i = true;
                }
            }
        }
    }

    @Override
    public final void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f1396h || this.f1397i) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i6 = 0; i6 < this.f1293b; i6++) {
                View viewM878d = constraintLayout.m878d(this.f1292a[i6]);
                if (viewM878d != null) {
                    if (this.f1396h) {
                        viewM878d.setVisibility(visibility);
                    }
                    if (this.f1397i && elevation > 0.0f) {
                        viewM878d.setTranslationZ(viewM878d.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        m872c();
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        m872c();
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    public void mo844m(C3961h c3961h, int i6, int i10) {
    }
}
