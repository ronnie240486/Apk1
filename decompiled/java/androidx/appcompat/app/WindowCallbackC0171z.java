package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import com.p2serv.android.p032ds.R;
import java.util.List;
import java.util.WeakHashMap;
import p001a0.C0023f;
import p007a7.C0069f;
import p093j.AbstractC2740a;
import p093j.AbstractC2750k;
import p093j.AbstractC2751l;
import p093j.AbstractC2752m;
import p093j.C2743d;
import p093j.C2744e;
import p093j.C2745f;
import p105k.MenuC2838l;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;
import p138n0.C3102a1;

public final class WindowCallbackC0171z implements Window.Callback {

    public final Window.Callback f481a;

    public C0155q0 f482b;

    public boolean f483c;

    public boolean f484d;

    public boolean f485e;

    public final LayoutInflaterFactory2C0135g0 f486f;

    public WindowCallbackC0171z(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0, Window.Callback callback) {
        this.f486f = layoutInflaterFactory2C0135g0;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f481a = callback;
    }

    public final void m525a(Window.Callback callback) {
        try {
            this.f483c = true;
            callback.onContentChanged();
        } finally {
            this.f483c = false;
        }
    }

    public final boolean m526b(int i6, Menu menu) {
        return this.f481a.onMenuOpened(i6, menu);
    }

    public final void m527c(int i6, Menu menu) {
        this.f481a.onPanelClosed(i6, menu);
    }

    public final void m528d(List list, Menu menu, int i6) {
        AbstractC2751l.m5718a(this.f481a, list, menu, i6);
    }

    @Override
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f481a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z7 = this.f484d;
        Window.Callback callback = this.f481a;
        if (z7) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        return this.f486f.m407u(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.f481a.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f486f;
        layoutInflaterFactory2C0135g0.m384B();
        AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
        if (abstractC2973a != null && abstractC2973a.mo446F(keyCode, keyEvent)) {
            return true;
        }
        C0133f0 c0133f0 = layoutInflaterFactory2C0135g0.f319N;
        if (c0133f0 != null && layoutInflaterFactory2C0135g0.m389G(c0133f0, keyEvent.getKeyCode(), keyEvent)) {
            C0133f0 c0133f1 = layoutInflaterFactory2C0135g0.f319N;
            if (c0133f1 == null) {
                return true;
            }
            c0133f1.f297l = true;
            return true;
        }
        if (layoutInflaterFactory2C0135g0.f319N == null) {
            C0133f0 c0133f0M383A = layoutInflaterFactory2C0135g0.m383A(0);
            layoutInflaterFactory2C0135g0.m390H(c0133f0M383A, keyEvent);
            boolean zM389G = layoutInflaterFactory2C0135g0.m389G(c0133f0M383A, keyEvent.getKeyCode(), keyEvent);
            c0133f0M383A.f296k = false;
            if (zM389G) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f481a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f481a.dispatchTouchEvent(motionEvent);
    }

    @Override
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f481a.dispatchTrackballEvent(motionEvent);
    }

    public final C2745f m529e(ActionMode.Callback callback) {
        boolean z7;
        ViewGroup viewGroup;
        int i6 = 1;
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f486f;
        C0023f c0023f = new C0023f(layoutInflaterFactory2C0135g0.f341k, callback);
        AbstractC2740a abstractC2740a = layoutInflaterFactory2C0135g0.f351u;
        if (abstractC2740a != null) {
            abstractC2740a.mo473a();
        }
        C0069f c0069f = new C0069f(layoutInflaterFactory2C0135g0, i6, c0023f);
        layoutInflaterFactory2C0135g0.m384B();
        AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
        if (abstractC2973a != null) {
            layoutInflaterFactory2C0135g0.f351u = abstractC2973a.mo517T(c0069f);
        }
        if (layoutInflaterFactory2C0135g0.f351u == null) {
            C3102a1 c3102a1 = layoutInflaterFactory2C0135g0.f355y;
            if (c3102a1 != null) {
                c3102a1.m6122b();
            }
            AbstractC2740a abstractC2740a2 = layoutInflaterFactory2C0135g0.f351u;
            if (abstractC2740a2 != null) {
                abstractC2740a2.mo473a();
            }
            if (layoutInflaterFactory2C0135g0.f352v == null) {
                boolean z10 = layoutInflaterFactory2C0135g0.f315J;
                Context context = layoutInflaterFactory2C0135g0.f341k;
                if (z10) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        C2743d c2743d = new C2743d(context, 0);
                        c2743d.getTheme().setTo(themeNewTheme);
                        context = c2743d;
                    }
                    layoutInflaterFactory2C0135g0.f352v = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    layoutInflaterFactory2C0135g0.f353w = popupWindow;
                    AbstractC2973a.m6012Q(popupWindow, 2);
                    layoutInflaterFactory2C0135g0.f353w.setContentView(layoutInflaterFactory2C0135g0.f352v);
                    layoutInflaterFactory2C0135g0.f353w.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    layoutInflaterFactory2C0135g0.f352v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    layoutInflaterFactory2C0135g0.f353w.setHeight(-2);
                    layoutInflaterFactory2C0135g0.f354x = new RunnableC0156r(layoutInflaterFactory2C0135g0, i6);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) layoutInflaterFactory2C0135g0.f307B.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        layoutInflaterFactory2C0135g0.m384B();
                        AbstractC2973a abstractC2973a2 = layoutInflaterFactory2C0135g0.f345o;
                        Context contextMo461v = abstractC2973a2 != null ? abstractC2973a2.mo461v() : null;
                        if (contextMo461v != null) {
                            context = contextMo461v;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                        layoutInflaterFactory2C0135g0.f352v = (ActionBarContextView) viewStubCompat.m632a();
                    }
                }
            }
            if (layoutInflaterFactory2C0135g0.f352v != null) {
                C3102a1 c3102a2 = layoutInflaterFactory2C0135g0.f355y;
                if (c3102a2 != null) {
                    c3102a2.m6122b();
                }
                layoutInflaterFactory2C0135g0.f352v.m543e();
                Context context2 = layoutInflaterFactory2C0135g0.f352v.getContext();
                ActionBarContextView actionBarContextView = layoutInflaterFactory2C0135g0.f352v;
                C2744e c2744e = new C2744e();
                c2744e.f9415c = context2;
                c2744e.f9416d = actionBarContextView;
                c2744e.f9417e = c0069f;
                MenuC2838l menuC2838l = new MenuC2838l(actionBarContextView.getContext());
                menuC2838l.f9698l = 1;
                c2744e.f9420h = menuC2838l;
                menuC2838l.f9691e = c2744e;
                if (((C0023f) c0069f.f196b).m108h(c2744e, menuC2838l)) {
                    c2744e.mo479g();
                    layoutInflaterFactory2C0135g0.f352v.m541c(c2744e);
                    layoutInflaterFactory2C0135g0.f351u = c2744e;
                    if (!layoutInflaterFactory2C0135g0.f306A || (viewGroup = layoutInflaterFactory2C0135g0.f307B) == null) {
                        z7 = false;
                    } else {
                        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                        if (viewGroup.isLaidOut()) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                    }
                    if (z7) {
                        layoutInflaterFactory2C0135g0.f352v.setAlpha(0.0f);
                        C3102a1 c3102a1M6331a = AbstractC3155s0.m6331a(layoutInflaterFactory2C0135g0.f352v);
                        c3102a1M6331a.m6121a(1.0f);
                        layoutInflaterFactory2C0135g0.f355y = c3102a1M6331a;
                        c3102a1M6331a.m6124d(new C0160t(i6, layoutInflaterFactory2C0135g0));
                    } else {
                        layoutInflaterFactory2C0135g0.f352v.setAlpha(1.0f);
                        layoutInflaterFactory2C0135g0.f352v.setVisibility(0);
                        if (layoutInflaterFactory2C0135g0.f352v.getParent() instanceof View) {
                            View view = (View) layoutInflaterFactory2C0135g0.f352v.getParent();
                            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                            AbstractC3113e0.m6130c(view);
                        }
                    }
                    if (layoutInflaterFactory2C0135g0.f353w != null) {
                        layoutInflaterFactory2C0135g0.f342l.getDecorView().post(layoutInflaterFactory2C0135g0.f354x);
                    }
                } else {
                    layoutInflaterFactory2C0135g0.f351u = null;
                }
            }
            layoutInflaterFactory2C0135g0.m392J();
            layoutInflaterFactory2C0135g0.f351u = layoutInflaterFactory2C0135g0.f351u;
        }
        layoutInflaterFactory2C0135g0.m392J();
        AbstractC2740a abstractC2740a3 = layoutInflaterFactory2C0135g0.f351u;
        if (abstractC2740a3 != null) {
            return c0023f.m106f(abstractC2740a3);
        }
        return null;
    }

    @Override
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f481a.onActionModeFinished(actionMode);
    }

    @Override
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f481a.onActionModeStarted(actionMode);
    }

    @Override
    public final void onAttachedToWindow() {
        this.f481a.onAttachedToWindow();
    }

    @Override
    public final void onContentChanged() {
        if (this.f483c) {
            this.f481a.onContentChanged();
        }
    }

    @Override
    public final boolean onCreatePanelMenu(int i6, Menu menu) {
        if (i6 != 0 || (menu instanceof MenuC2838l)) {
            return this.f481a.onCreatePanelMenu(i6, menu);
        }
        return false;
    }

    @Override
    public final View onCreatePanelView(int i6) {
        C0155q0 c0155q0 = this.f482b;
        if (c0155q0 != null) {
            View view = i6 == 0 ? new View(c0155q0.f424a.f432r.f1098a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.f481a.onCreatePanelView(i6);
    }

    @Override
    public final void onDetachedFromWindow() {
        this.f481a.onDetachedFromWindow();
    }

    @Override
    public final boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        return this.f481a.onMenuItemSelected(i6, menuItem);
    }

    @Override
    public final boolean onMenuOpened(int i6, Menu menu) {
        m526b(i6, menu);
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f486f;
        if (i6 == 108) {
            layoutInflaterFactory2C0135g0.m384B();
            AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
            if (abstractC2973a != null) {
                abstractC2973a.mo459r(true);
            }
        } else {
            layoutInflaterFactory2C0135g0.getClass();
        }
        return true;
    }

    @Override
    public final void onPanelClosed(int i6, Menu menu) {
        if (this.f485e) {
            this.f481a.onPanelClosed(i6, menu);
            return;
        }
        m527c(i6, menu);
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f486f;
        if (i6 == 108) {
            layoutInflaterFactory2C0135g0.m384B();
            AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
            if (abstractC2973a != null) {
                abstractC2973a.mo459r(false);
                return;
            }
            return;
        }
        if (i6 != 0) {
            layoutInflaterFactory2C0135g0.getClass();
            return;
        }
        C0133f0 c0133f0M383A = layoutInflaterFactory2C0135g0.m383A(i6);
        if (c0133f0M383A.f298m) {
            layoutInflaterFactory2C0135g0.m406s(c0133f0M383A, false);
        }
    }

    @Override
    public final void onPointerCaptureChanged(boolean z7) {
        AbstractC2752m.m5719a(this.f481a, z7);
    }

    @Override
    public final boolean onPreparePanel(int i6, View view, Menu menu) {
        MenuC2838l menuC2838l = menu instanceof MenuC2838l ? (MenuC2838l) menu : null;
        if (i6 == 0 && menuC2838l == null) {
            return false;
        }
        if (menuC2838l != null) {
            menuC2838l.f9710x = true;
        }
        C0155q0 c0155q0 = this.f482b;
        if (c0155q0 != null && i6 == 0) {
            C0159s0 c0159s0 = c0155q0.f424a;
            if (!c0159s0.f435u) {
                c0159s0.f432r.f1109l = true;
                c0159s0.f435u = true;
            }
        }
        boolean zOnPreparePanel = this.f481a.onPreparePanel(i6, view, menu);
        if (menuC2838l != null) {
            menuC2838l.f9710x = false;
        }
        return zOnPreparePanel;
    }

    @Override
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i6) {
        MenuC2838l menuC2838l = this.f486f.m383A(0).f293h;
        if (menuC2838l != null) {
            m528d(list, menuC2838l, i6);
        } else {
            m528d(list, menu, i6);
        }
    }

    @Override
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return AbstractC2750k.m5716a(this.f481a, searchEvent);
    }

    @Override
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f481a.onWindowAttributesChanged(layoutParams);
    }

    @Override
    public final void onWindowFocusChanged(boolean z7) {
        this.f481a.onWindowFocusChanged(z7);
    }

    @Override
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i6) {
        return (this.f486f.f356z && i6 == 0) ? m529e(callback) : AbstractC2750k.m5717b(this.f481a, callback, i6);
    }

    @Override
    public final boolean onSearchRequested() {
        return this.f481a.onSearchRequested();
    }

    @Override
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        if (this.f486f.f356z) {
            return m529e(callback);
        }
        return this.f481a.onWindowStartingActionMode(callback);
    }
}
