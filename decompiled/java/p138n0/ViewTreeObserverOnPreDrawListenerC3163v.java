package p138n0;

import android.view.View;
import android.view.ViewTreeObserver;

public final class ViewTreeObserverOnPreDrawListenerC3163v implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    public final View f10650a;

    public ViewTreeObserver f10651b;

    public final Runnable f10652c;

    public ViewTreeObserverOnPreDrawListenerC3163v(View view, Runnable runnable) {
        this.f10650a = view;
        this.f10651b = view.getViewTreeObserver();
        this.f10652c = runnable;
    }

    public static void m6358a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        ViewTreeObserverOnPreDrawListenerC3163v viewTreeObserverOnPreDrawListenerC3163v = new ViewTreeObserverOnPreDrawListenerC3163v(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3163v);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC3163v);
    }

    @Override
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f10651b.isAlive();
        View view = this.f10650a;
        if (zIsAlive) {
            this.f10651b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f10652c.run();
        return true;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        this.f10651b = view.getViewTreeObserver();
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f10651b.isAlive();
        View view2 = this.f10650a;
        if (zIsAlive) {
            this.f10651b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
