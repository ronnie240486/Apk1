package androidx.fragment.app;

import android.view.View;
import p156o9.AbstractC3281e;

public final class C0417n extends AbstractC3281e {

    public final AbstractComponentCallbacksC0427s f1913f;

    public C0417n(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f1913f = abstractComponentCallbacksC0427s;
    }

    @Override
    public final View mo1265B(int i6) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1913f;
        View view = abstractComponentCallbacksC0427s.f1951F;
        if (view != null) {
            return view.findViewById(i6);
        }
        throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0427s + " does not have a view");
    }

    @Override
    public final boolean mo1266C() {
        return this.f1913f.f1951F != null;
    }
}
