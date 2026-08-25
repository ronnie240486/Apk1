package com.google.android.material.textfield;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import p105k.ViewOnKeyListenerC2829d0;
import p105k.ViewOnKeyListenerC2832f;
import p148o0.AccessibilityManagerTouchExplorationStateChangeListenerC3227b;

public final class ViewOnAttachStateChangeListenerC1873k implements View.OnAttachStateChangeListener {

    public final int f6847a;

    public final Object f6848b;

    public ViewOnAttachStateChangeListenerC1873k(int i6, Object obj) {
        this.f6847a = i6;
        this.f6848b = obj;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        switch (this.f6847a) {
            case 0:
                ((C1875m) this.f6848b).m4390f();
                break;
        }
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f6847a) {
            case 0:
                C1875m c1875m = (C1875m) this.f6848b;
                AccessibilityManager accessibilityManager = c1875m.f6864q;
                if (accessibilityManager != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC3227b(c1875m.f6858k));
                }
                break;
            case 1:
                ViewOnKeyListenerC2832f viewOnKeyListenerC2832f = (ViewOnKeyListenerC2832f) this.f6848b;
                ViewTreeObserver viewTreeObserver = viewOnKeyListenerC2832f.f9669x;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viewOnKeyListenerC2832f.f9669x = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC2832f.f9669x.removeGlobalOnLayoutListener(viewOnKeyListenerC2832f.f9654i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                ViewOnKeyListenerC2829d0 viewOnKeyListenerC2829d0 = (ViewOnKeyListenerC2829d0) this.f6848b;
                ViewTreeObserver viewTreeObserver2 = viewOnKeyListenerC2829d0.f9636o;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        viewOnKeyListenerC2829d0.f9636o = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC2829d0.f9636o.removeGlobalOnLayoutListener(viewOnKeyListenerC2829d0.f9630i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void m4384a(View view) {
    }

    private final void m4385b(View view) {
    }
}
