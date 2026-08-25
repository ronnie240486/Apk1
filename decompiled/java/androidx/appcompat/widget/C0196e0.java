package androidx.appcompat.widget;

import p105k.InterfaceC2827c0;

public final class C0196e0 extends AbstractViewOnTouchListenerC0282v1 {

    public final C0236m0 f896j;

    public final AppCompatSpinner f897k;

    public C0196e0(AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, C0236m0 c0236m0) {
        super(appCompatSpinner2);
        this.f897k = appCompatSpinner;
        this.f896j = c0236m0;
    }

    @Override
    public final InterfaceC2827c0 mo655b() {
        return this.f896j;
    }

    @Override
    public final boolean mo656c() {
        AppCompatSpinner appCompatSpinner = this.f897k;
        if (appCompatSpinner.getInternalPopup().mo689c()) {
            return true;
        }
        appCompatSpinner.f648f.mo697n(AbstractC0206g0.m671b(appCompatSpinner), AbstractC0206g0.m670a(appCompatSpinner));
        return true;
    }
}
