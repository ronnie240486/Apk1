package p205t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import p256y.AbstractC4193j;

public final class ViewOnClickListenerC3747a0 implements View.OnClickListener {

    public final C3749b0 f12555a;

    public final int f12556b;

    public final int f12557c;

    public ViewOnClickListenerC3747a0(Context context, C3749b0 c3749b0, XmlResourceParser xmlResourceParser) {
        this.f12556b = -1;
        this.f12557c = 17;
        this.f12555a = c3749b0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14248n);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            if (index == 1) {
                this.f12556b = typedArrayObtainStyledAttributes.getResourceId(index, this.f12556b);
            } else if (index == 0) {
                this.f12557c = typedArrayObtainStyledAttributes.getInt(index, this.f12557c);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void m7489a(MotionLayout motionLayout, int i6, C3749b0 c3749b0) {
        boolean z7;
        View viewFindViewById;
        int i10 = this.f12556b;
        View view = motionLayout;
        if (i10 != -1) {
            viewFindViewById = motionLayout.findViewById(i10);
        }
        if (view == null) {
            view = viewFindViewById;
            Log.e("MotionScene", "OnClick could not find id " + i10);
            return;
        }
        int i11 = c3749b0.f12561d;
        int i12 = c3749b0.f12560c;
        if (i11 == -1) {
            view = viewFindViewById;
            view.setOnClickListener(this);
            return;
        }
        int i13 = this.f12557c;
        int i14 = i13 & 1;
        if (i14 == 0 || i6 != i11) {
            view = viewFindViewById;
            z7 = false;
        } else {
            z7 = true;
        }
        if (((i14 != 0 && i6 == i11) | z7 | ((i13 & 256) != 0 && i6 == i11) | ((i13 & 16) != 0 && i6 == i12)) || ((i13 & 4096) != 0 && i6 == i12)) {
            view.setOnClickListener(this);
        }
    }

    public final void m7490b(MotionLayout motionLayout) {
        int i6 = this.f12556b;
        if (i6 == -1) {
            return;
        }
        View viewFindViewById = motionLayout.findViewById(i6);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(null);
            return;
        }
        Log.e("MotionScene", " (*)  could not find id " + i6);
    }

    @Override
    public final void onClick(View view) {
        C3749b0 c3749b0 = this.f12555a;
        C3751c0 c3751c0 = c3749b0.f12567j;
        MotionLayout motionLayout = c3751c0.f12576a;
        if (motionLayout.f1247y) {
            if (c3749b0.f12561d == -1) {
                int currentState = motionLayout.getCurrentState();
                if (currentState == -1) {
                    motionLayout.m851B(c3749b0.f12560c);
                    return;
                }
                C3749b0 c3749b1 = new C3749b0(c3751c0, c3749b0);
                c3749b1.f12561d = currentState;
                c3749b1.f12560c = c3749b0.f12560c;
                motionLayout.setTransition(c3749b1);
                motionLayout.m853o(1.0f);
                return;
            }
            C3749b0 c3749b2 = c3751c0.f12578c;
            int i6 = this.f12557c;
            int i10 = i6 & 1;
            boolean z7 = true;
            boolean z10 = false;
            boolean z11 = (i10 == 0 && (i6 & 256) == 0) ? false : true;
            int i11 = i6 & 16;
            if (i11 == 0 && (i6 & 4096) == 0) {
                z7 = false;
            }
            if (z11 && z7) {
                if (c3749b2 != c3749b0) {
                    motionLayout.setTransition(c3749b0);
                }
                if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                    z10 = z11;
                    z7 = false;
                }
            } else {
                z10 = z11;
            }
            if (c3749b0 != c3749b2) {
                int i12 = c3749b0.f12560c;
                int i13 = c3749b0.f12561d;
                if (i13 != -1) {
                    int i14 = motionLayout.f1239u;
                    if (i14 != i13 && i14 != i12) {
                        return;
                    }
                } else if (motionLayout.f1239u == i12) {
                    return;
                }
            }
            if (z10 && i10 != 0) {
                motionLayout.setTransition(c3749b0);
                motionLayout.m853o(1.0f);
                return;
            }
            if (z7 && i11 != 0) {
                motionLayout.setTransition(c3749b0);
                motionLayout.m853o(0.0f);
            } else if (z10 && (i6 & 256) != 0) {
                motionLayout.setTransition(c3749b0);
                motionLayout.setProgress(1.0f);
            } else {
                if (!z7 || (i6 & 4096) == 0) {
                    return;
                }
                motionLayout.setTransition(c3749b0);
                motionLayout.setProgress(0.0f);
            }
        }
    }
}
