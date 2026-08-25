package p124l6;

import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public final class C2978d {

    public final int f10216a;

    public final ExtendedFloatingActionButton f10217b;

    public C2978d(ExtendedFloatingActionButton extendedFloatingActionButton, int i6) {
        this.f10216a = i6;
        this.f10217b = extendedFloatingActionButton;
    }

    public final ViewGroup.LayoutParams m6034a() {
        switch (this.f10216a) {
            case 0:
                return new ViewGroup.LayoutParams(-2, -2);
            default:
                ExtendedFloatingActionButton extendedFloatingActionButton = this.f10217b;
                return new ViewGroup.LayoutParams(extendedFloatingActionButton.getCollapsedSize(), extendedFloatingActionButton.getCollapsedSize());
        }
    }

    public final int m6035b() {
        switch (this.f10216a) {
            case 0:
                return this.f10217b.f6278z;
            default:
                return this.f10217b.getCollapsedPadding();
        }
    }

    public final int m6036c() {
        switch (this.f10216a) {
            case 0:
                return this.f10217b.f6277y;
            default:
                return this.f10217b.getCollapsedPadding();
        }
    }
}
