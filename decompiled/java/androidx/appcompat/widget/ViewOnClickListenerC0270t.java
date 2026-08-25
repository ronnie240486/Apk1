package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import p105k.MenuC2838l;
import p138n0.AbstractC3106c;

public final class ViewOnClickListenerC0270t implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

    public final ActivityChooserView f1065a;

    public ViewOnClickListenerC0270t(ActivityChooserView activityChooserView) {
        this.f1065a = activityChooserView;
    }

    @Override
    public final void onClick(View view) {
        ActivityChooserView activityChooserView = this.f1065a;
        FrameLayout frameLayout = activityChooserView.f598f;
        C0265s c0265s = activityChooserView.f593a;
        if (view == frameLayout) {
            activityChooserView.m564a();
            c0265s.getClass();
            throw null;
        }
        if (view != activityChooserView.f596d) {
            throw new IllegalArgumentException();
        }
        c0265s.getClass();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    @Override
    public final void onDismiss() {
        C0225k c0225k;
        MenuC2838l menuC2838l;
        ActivityChooserView activityChooserView = this.f1065a;
        PopupWindow.OnDismissListener onDismissListener = activityChooserView.f602j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        AbstractC3106c abstractC3106c = activityChooserView.f599g;
        if (abstractC3106c == null || (c0225k = abstractC3106c.f10578a) == null || (menuC2838l = c0225k.f9611c) == null) {
            return;
        }
        menuC2838l.m5827c(false);
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        ((C0265s) adapterView.getAdapter()).getClass();
        ActivityChooserView activityChooserView = this.f1065a;
        activityChooserView.m564a();
        activityChooserView.f593a.getClass();
        throw null;
    }

    @Override
    public final boolean onLongClick(View view) {
        ActivityChooserView activityChooserView = this.f1065a;
        if (view != activityChooserView.f598f) {
            throw new IllegalArgumentException();
        }
        activityChooserView.f593a.getClass();
        throw null;
    }
}
