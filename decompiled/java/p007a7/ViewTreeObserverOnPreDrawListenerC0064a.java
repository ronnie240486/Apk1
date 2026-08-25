package p007a7;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;
import p112k6.InterfaceC2893a;

public final class ViewTreeObserverOnPreDrawListenerC0064a implements ViewTreeObserver.OnPreDrawListener {

    public final View f180a;

    public final int f181b;

    public final InterfaceC2893a f182c;

    public final ExpandableBehavior f183d;

    public ViewTreeObserverOnPreDrawListenerC0064a(ExpandableBehavior expandableBehavior, View view, int i6, InterfaceC2893a interfaceC2893a) {
        this.f183d = expandableBehavior;
        this.f180a = view;
        this.f181b = i6;
        this.f182c = interfaceC2893a;
    }

    @Override
    public final boolean onPreDraw() {
        View view = this.f180a;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f183d;
        if (expandableBehavior.f6951a == this.f181b) {
            Object obj = this.f182c;
            expandableBehavior.mo4413s((View) obj, view, ((FloatingActionButton) obj).f6295o.f860a, false);
        }
        return false;
    }
}
