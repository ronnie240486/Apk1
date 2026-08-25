package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import p205t.InterfaceC3783w;
import p256y.AbstractC4193j;

public class MotionHelper extends ConstraintHelper implements InterfaceC3783w {

    public boolean f1188h;

    public boolean f1189i;

    public float f1190j;

    public View[] f1191k;

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1188h = false;
        this.f1189i = false;
        mo841g(attributeSet);
    }

    @Override
    public final void mo841g(AttributeSet attributeSet) {
        super.mo841g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14244j);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 1) {
                    this.f1188h = typedArrayObtainStyledAttributes.getBoolean(index, this.f1188h);
                } else if (index == 0) {
                    this.f1189i = typedArrayObtainStyledAttributes.getBoolean(index, this.f1189i);
                }
            }
        }
    }

    public float getProgress() {
        return this.f1190j;
    }

    public void setProgress(float f) {
        this.f1190j = f;
        int i6 = 0;
        if (this.f1293b > 0) {
            this.f1191k = m875f((ConstraintLayout) getParent());
            while (i6 < this.f1293b) {
                View view = this.f1191k[i6];
                i6++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i6 < childCount) {
            boolean z7 = viewGroup.getChildAt(i6) instanceof MotionHelper;
            i6++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1188h = false;
        this.f1189i = false;
        mo841g(attributeSet);
    }
}
