package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import android.view.Window;
import p105k.C2822a;

public final class ViewOnClickListenerC0274t3 implements View.OnClickListener {

    public final C2822a f1067a;

    public final C0284v3 f1068b;

    public ViewOnClickListenerC0274t3(C0284v3 c0284v3) {
        this.f1068b = c0284v3;
        Context context = c0284v3.f1098a.getContext();
        CharSequence charSequence = c0284v3.f1105h;
        C2822a c2822a = new C2822a();
        c2822a.f9596e = 4096;
        c2822a.f9598g = 4096;
        c2822a.f9603l = null;
        c2822a.f9604m = null;
        c2822a.f9605n = false;
        c2822a.f9606o = false;
        c2822a.f9607p = 16;
        c2822a.f9600i = context;
        c2822a.f9592a = charSequence;
        this.f1067a = c2822a;
    }

    @Override
    public final void onClick(View view) {
        C0284v3 c0284v3 = this.f1068b;
        Window.Callback callback = c0284v3.f1108k;
        if (callback == null || !c0284v3.f1109l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f1067a);
    }
}
