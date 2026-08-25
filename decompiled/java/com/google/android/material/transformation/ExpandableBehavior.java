package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p007a7.ViewTreeObserverOnPreDrawListenerC0064a;
import p112k6.InterfaceC2893a;
import p138n0.AbstractC3155s0;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    public int f6951a;

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6951a = 0;
    }

    @Override
    public abstract boolean mo920b(View view, View view2);

    @Override
    public final boolean mo922d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object obj = (InterfaceC2893a) view2;
        boolean z7 = ((FloatingActionButton) obj).f6295o.f860a;
        if (z7) {
            int i6 = this.f6951a;
            if (i6 != 0 && i6 != 2) {
                return false;
            }
        } else if (this.f6951a != 1) {
            return false;
        }
        this.f6951a = z7 ? 1 : 2;
        mo4413s((View) obj, view, z7, true);
        return true;
    }

    @Override
    public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
        InterfaceC2893a interfaceC2893a;
        boolean z7;
        int i10;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (!view.isLaidOut()) {
            ArrayList arrayListM909o = coordinatorLayout.m909o(view);
            int size = arrayListM909o.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    interfaceC2893a = null;
                    break;
                }
                View view2 = (View) arrayListM909o.get(i11);
                if (mo920b(view, view2)) {
                    interfaceC2893a = (InterfaceC2893a) view2;
                    break;
                }
                i11++;
            }
            if (interfaceC2893a != null && (!(z7 = ((FloatingActionButton) interfaceC2893a).f6295o.f860a) ? this.f6951a == 1 : !((i10 = this.f6951a) != 0 && i10 != 2))) {
                int i12 = z7 ? 1 : 2;
                this.f6951a = i12;
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0064a(this, view, i12, interfaceC2893a));
            }
        }
        return false;
    }

    public abstract void mo4413s(View view, View view2, boolean z7, boolean z10);

    public ExpandableBehavior() {
        this.f6951a = 0;
    }
}
