package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import p105k.AbstractC2824b;
import p105k.InterfaceC2827c0;
import p105k.InterfaceC2837k;

public final class C0210h extends AbstractViewOnTouchListenerC0282v1 {

    public final int f937j;

    public final View f938k;

    public C0210h(View view, View view2, int i6) {
        super(view2);
        this.f937j = i6;
        this.f938k = view;
    }

    @Override
    public final InterfaceC2827c0 mo655b() {
        C0195e c0195e;
        switch (this.f937j) {
            case 0:
                C0195e c0195e2 = ((C0215i) this.f938k).f943d.f971t;
                if (c0195e2 == null) {
                    return null;
                }
                return c0195e2.m5854a();
            case 1:
                return ((ActivityChooserView) this.f938k).getListPopupWindow();
            default:
                AbstractC2824b abstractC2824b = ((ActionMenuItemView) this.f938k).f492m;
                if (abstractC2824b == null || (c0195e = ((C0200f) abstractC2824b).f903a.f972u) == null) {
                    return null;
                }
                return c0195e.m5854a();
        }
    }

    @Override
    public final boolean mo656c() {
        InterfaceC2827c0 interfaceC2827c0Mo655b;
        switch (this.f937j) {
            case 0:
                ((C0215i) this.f938k).f943d.m716n();
                return true;
            case 1:
                ActivityChooserView activityChooserView = (ActivityChooserView) this.f938k;
                if (activityChooserView.m565b() || !activityChooserView.f603k) {
                    return true;
                }
                activityChooserView.f593a.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
            default:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f938k;
                InterfaceC2837k interfaceC2837k = actionMenuItemView.f490k;
                return interfaceC2837k != null && interfaceC2837k.mo535a(actionMenuItemView.f487h) && (interfaceC2827c0Mo655b = mo655b()) != null && interfaceC2827c0Mo655b.mo578c();
        }
    }

    @Override
    public boolean mo686d() {
        switch (this.f937j) {
            case 0:
                C0225k c0225k = ((C0215i) this.f938k).f943d;
                if (c0225k.f973v != null) {
                    return false;
                }
                c0225k.m708c();
                return true;
            case 1:
                ((ActivityChooserView) this.f938k).m564a();
                return true;
            default:
                return super.mo686d();
        }
    }

    public C0210h(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f937j = 2;
        this.f938k = actionMenuItemView;
    }
}
