package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0555w;
import com.p2serv.android.p032ds.R;
import p000a.C0016q;
import p000a.InterfaceC0017r;
import p000a.RunnableC0001b;
import p123l5.AbstractC2973a;
import p138n0.InterfaceC3133l;

public abstract class AbstractDialogC0139i0 extends Dialog implements InterfaceC0146m, InterfaceC0555w, InterfaceC0017r {

    public C0559y f385a;

    public final C0016q f386b;

    public LayoutInflaterFactory2C0135g0 f387c;

    public final C0137h0 f388d;

    public AbstractDialogC0139i0(ContextThemeWrapper contextThemeWrapper, int i6) {
        int i10;
        if (i6 == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i10 = typedValue.resourceId;
        } else {
            i10 = i6;
        }
        super(contextThemeWrapper, i10);
        this.f386b = new C0016q(new RunnableC0001b(1, this));
        this.f388d = new InterfaceC3133l() {
            @Override
            public final boolean mo415b(KeyEvent keyEvent) {
                return this.f382a.m423h(keyEvent);
            }
        };
        AbstractC0154q abstractC0154qM419c = m419c();
        if (i6 == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            i6 = typedValue2.resourceId;
        }
        ((LayoutInflaterFactory2C0135g0) abstractC0154qM419c).f326U = i6;
        abstractC0154qM419c.mo395d();
    }

    public static void m418b(AbstractDialogC0139i0 abstractDialogC0139i0) {
        super.onBackPressed();
    }

    @Override
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m419c();
        layoutInflaterFactory2C0135g0.m409w();
        ((ViewGroup) layoutInflaterFactory2C0135g0.f307B.findViewById(android.R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C0135g0.f343m.m525a(layoutInflaterFactory2C0135g0.f342l.getCallback());
    }

    public final AbstractC0154q m419c() {
        if (this.f387c == null) {
            ExecutorC0149n0 executorC0149n0 = AbstractC0154q.f415a;
            this.f387c = new LayoutInflaterFactory2C0135g0(getContext(), getWindow(), this, this);
        }
        return this.f387c;
    }

    public final C0559y m420d() {
        C0559y c0559y = this.f385a;
        if (c0559y != null) {
            return c0559y;
        }
        C0559y c0559y2 = new C0559y(this);
        this.f385a = c0559y2;
        return c0559y2;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        m419c().mo396e();
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC2973a.m6020q(this.f388d, getWindow().getDecorView(), this, keyEvent);
    }

    public final void m421e(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            C0016q c0016q = this.f386b;
            c0016q.f36f = onBackInvokedDispatcher;
            c0016q.m51d();
        }
        m420d().m1521f(EnumC0537n.ON_CREATE);
    }

    @Override
    public final AbstractC0541p mo360f() {
        return m420d();
    }

    @Override
    public final View findViewById(int i6) {
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m419c();
        layoutInflaterFactory2C0135g0.m409w();
        return layoutInflaterFactory2C0135g0.f342l.findViewById(i6);
    }

    public final void m422g() {
        m420d().m1521f(EnumC0537n.ON_DESTROY);
        this.f385a = null;
        super.onStop();
    }

    public final boolean m423h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public final void invalidateOptionsMenu() {
        m419c().mo394b();
    }

    @Override
    public final void onBackPressed() {
        this.f386b.m50c();
    }

    @Override
    public void onCreate(Bundle bundle) {
        m419c().mo393a();
        m421e(bundle);
        m419c().mo395d();
    }

    @Override
    public final void onStart() {
        super.onStart();
        m420d().m1521f(EnumC0537n.ON_RESUME);
    }

    @Override
    public final void onStop() {
        m422g();
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m419c();
        layoutInflaterFactory2C0135g0.m384B();
        AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
        if (abstractC2973a != null) {
            abstractC2973a.mo452N(false);
        }
    }

    @Override
    public final void setContentView(int i6) {
        m419c().mo398h(i6);
    }

    @Override
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m419c().mo401l(charSequence);
    }

    @Override
    public final void setContentView(View view) {
        m419c().mo399i(view);
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m419c().mo400k(view, layoutParams);
    }

    @Override
    public void setTitle(int i6) {
        super.setTitle(i6);
        m419c().mo401l(getContext().getString(i6));
    }
}
