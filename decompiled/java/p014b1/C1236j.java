package p014b1;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0519e;
import androidx.lifecycle.InterfaceC0555w;
import p103j9.AbstractC2796i;

public final class C1236j implements InterfaceC0519e {

    public final AbstractC0541p f3932a;

    public final EmojiCompatInitializer f3933b;

    public C1236j(EmojiCompatInitializer emojiCompatInitializer, AbstractC0541p abstractC0541p) {
        this.f3933b = emojiCompatInitializer;
        this.f3932a = abstractC0541p;
    }

    @Override
    public final void mo1491b(InterfaceC0555w interfaceC0555w) {
        this.f3933b.getClass();
        (Build.VERSION.SDK_INT >= 28 ? AbstractC1228b.m3104a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new RunnableC1238l(0), 500L);
        this.f3932a.mo1510c(this);
    }

    @Override
    public final void mo1492c(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void onStart(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void mo1493e(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onDestroy(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onStop(InterfaceC0555w interfaceC0555w) {
    }
}
