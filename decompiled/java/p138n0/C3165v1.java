package p138n0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import p156o9.AbstractC3281e;

public final class C3165v1 extends AbstractC3281e {

    public final WindowInsetsController f10653f;

    public final Window f10654g;

    public C3165v1(Window window) {
        this.f10653f = window.getInsetsController();
        this.f10654g = window;
    }

    @Override
    public final void mo6357F(boolean z7) {
        Window window = this.f10654g;
        if (z7) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f10653f.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f10653f.setSystemBarsAppearance(0, 16);
    }

    @Override
    public final void mo6354G(boolean z7) {
        Window window = this.f10654g;
        if (z7) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f10653f.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f10653f.setSystemBarsAppearance(0, 8);
    }
}
