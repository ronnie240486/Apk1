package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p046e0.AbstractC2343b;
import p138n0.AbstractC3155s0;

public final class C0256q0 extends AbstractC2343b {

    public final int f1032h;

    public final int f1033i;

    public final WeakReference f1034j;

    public final C0291x0 f1035k;

    public C0256q0(C0291x0 c0291x0, int i6, int i10, WeakReference weakReference) {
        this.f1035k = c0291x0;
        this.f1032h = i6;
        this.f1033i = i10;
        this.f1034j = weakReference;
    }

    @Override
    public final void mo758j(Typeface typeface) {
        int i6;
        if (Build.VERSION.SDK_INT >= 28 && (i6 = this.f1032h) != -1) {
            typeface = AbstractC0286w0.m806a(typeface, i6, (this.f1033i & 2) != 0);
        }
        C0291x0 c0291x0 = this.f1035k;
        if (c0291x0.f1131m) {
            c0291x0.f1130l = typeface;
            TextView textView = (TextView) this.f1034j.get();
            if (textView != null) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (textView.isAttachedToWindow()) {
                    textView.post(new RunnableC0261r0(textView, typeface, c0291x0.f1128j, 0));
                } else {
                    textView.setTypeface(typeface, c0291x0.f1128j);
                }
            }
        }
    }

    @Override
    public final void mo757i(int i6) {
    }
}
