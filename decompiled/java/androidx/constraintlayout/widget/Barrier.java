package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import java.util.HashMap;
import p225v.C3954a;
import p225v.C3958e;
import p225v.C3959f;
import p225v.C3963j;
import p256y.AbstractC4193j;
import p256y.C4187d;

public class Barrier extends ConstraintHelper {

    public int f1289h;

    public int f1290i;

    public C3954a f1291j;

    public Barrier(Context context) {
        super(context);
        this.f1292a = new int[32];
        this.f1297f = null;
        this.f1298g = new HashMap();
        this.f1294c = context;
        mo841g(null);
        super.setVisibility(8);
    }

    @Override
    public final void mo841g(AttributeSet attributeSet) {
        super.mo841g(attributeSet);
        this.f1291j = new C3954a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4193j.f14236b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 15) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.f1291j.f13293j0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.f1291j.f13294k0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.f1295d = this.f1291j;
        m876l();
    }

    public int getMargin() {
        return this.f1291j.f13294k0;
    }

    public int getType() {
        return this.f1289h;
    }

    @Override
    public final void mo842h(C0307c c0307c, C3963j c3963j, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        super.mo842h(c0307c, c3963j, layoutParams, sparseArray);
        if (c3963j instanceof C3954a) {
            C3954a c3954a = (C3954a) c3963j;
            boolean z7 = ((C3959f) c3963j.f13334K).f13386k0;
            C4187d c4187d = c0307c.f1409d;
            m869m(c3954a, c4187d.f14175b0, z7);
            c3954a.f13293j0 = c4187d.f14191j0;
            c3954a.f13294k0 = c4187d.f14177c0;
        }
    }

    @Override
    public final void mo843i(C3958e c3958e, boolean z7) {
        m869m(c3958e, this.f1289h, z7);
    }

    public final void m869m(C3958e c3958e, int i6, boolean z7) {
        this.f1290i = i6;
        if (z7) {
            int i10 = this.f1289h;
            if (i10 == 5) {
                this.f1290i = 1;
            } else if (i10 == 6) {
                this.f1290i = 0;
            }
        } else {
            int i11 = this.f1289h;
            if (i11 == 5) {
                this.f1290i = 0;
            } else if (i11 == 6) {
                this.f1290i = 1;
            }
        }
        if (c3958e instanceof C3954a) {
            ((C3954a) c3958e).f13292i0 = this.f1290i;
        }
    }

    public void setAllowsGoneWidget(boolean z7) {
        this.f1291j.f13293j0 = z7;
    }

    public void setDpMargin(int i6) {
        this.f1291j.f13294k0 = (int) ((i6 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i6) {
        this.f1291j.f13294k0 = i6;
    }

    public void setType(int i6) {
        this.f1289h = i6;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        super.setVisibility(8);
    }
}
