package androidx.appcompat.widget;

import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p138n0.InterfaceC3105b1;

public final class C0172a implements InterfaceC3105b1 {

    public boolean f860a;

    public int f861b;

    public final View f862c;

    public C0172a(FloatingActionButton floatingActionButton) {
        this.f860a = false;
        this.f861b = 0;
        this.f862c = floatingActionButton;
    }

    @Override
    public void mo463a() {
        if (this.f860a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f862c;
        actionBarContextView.f531f = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f861b);
    }

    @Override
    public void mo633b() {
        this.f860a = true;
    }

    @Override
    public void mo464c() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f860a = false;
    }

    public C0172a(ActionBarContextView actionBarContextView) {
        this.f862c = actionBarContextView;
        this.f860a = false;
    }
}
