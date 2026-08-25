package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.AbstractC0530j0;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.FragmentC0534l0;
import androidx.lifecycle.InterfaceC0555w;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p138n0.InterfaceC3133l;

public class ComponentActivity extends Activity implements InterfaceC0555w, InterfaceC3133l {

    public final C0559y f1458a = new C0559y(this);

    @Override
    public final boolean mo415b(KeyEvent keyEvent) {
        AbstractC2796i.m5785f(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AbstractC2796i.m5785f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        AbstractC2796i.m5784e(decorView, "window.decorView");
        if (AbstractC2973a.m6019p(decorView, keyEvent)) {
            return true;
        }
        return AbstractC2973a.m6020q(this, decorView, this, keyEvent);
    }

    @Override
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        AbstractC2796i.m5785f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        AbstractC2796i.m5784e(decorView, "window.decorView");
        if (AbstractC2973a.m6019p(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public AbstractC0541p mo360f() {
        return this.f1458a;
    }

    public void mo363g() {
        invalidateOptionsMenu();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i6 = FragmentC0534l0.f2495b;
        AbstractC0530j0.m1497b(this);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC2796i.m5785f(bundle, "outState");
        this.f1458a.m1523h();
        super.onSaveInstanceState(bundle);
    }
}
