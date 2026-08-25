package androidx.appcompat.app;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.C0169x0;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.C0259q3;
import androidx.appcompat.widget.C0279u3;
import androidx.appcompat.widget.C0284v3;
import androidx.appcompat.widget.InterfaceC0190d;
import androidx.appcompat.widget.InterfaceC0222j1;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.AbstractC1465c;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p001a0.C0019b;
import p001a0.C0023f;
import p007a7.C0069f;
import p045e.AbstractC2341a;
import p093j.AbstractC2740a;
import p093j.C2749j;
import p105k.C2840n;
import p105k.MenuC2838l;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3102a1;

public final class C0169x0 extends AbstractC2973a implements InterfaceC0190d {

    public static final AccelerateInterpolator f455P = new AccelerateInterpolator();

    public static final DecelerateInterpolator f456Q = new DecelerateInterpolator();

    public C0167w0 f457A;

    public C0069f f458B;

    public boolean f459C;

    public final ArrayList f460D;

    public int f461E;

    public boolean f462F;

    public boolean f463G;

    public boolean f464H;

    public boolean f465I;

    public C2749j f466J;

    public boolean f467K;

    public boolean f468L;

    public final C0165v0 f469M;

    public final C0165v0 f470N;

    public final C0019b f471O;

    public Context f472r;

    public Context f473s;

    public ActionBarOverlayLayout f474t;

    public ActionBarContainer f475u;

    public InterfaceC0222j1 f476v;

    public ActionBarContextView f477w;

    public final View f478x;

    public boolean f479y;

    public C0167w0 f480z;

    public C0169x0(Activity activity, boolean z7) {
        new ArrayList();
        this.f460D = new ArrayList();
        this.f461E = 0;
        this.f462F = true;
        this.f465I = true;
        this.f469M = new C0165v0(this, 0);
        this.f470N = new C0165v0(this, 1);
        this.f471O = new C0019b(3, this);
        View decorView = activity.getWindow().getDecorView();
        m519W(decorView);
        if (z7) {
            return;
        }
        this.f478x = decorView.findViewById(R.id.content);
    }

    @Override
    public final void mo444B() {
        m520X(this.f472r.getResources().getBoolean(com.p2serv.android.p032ds.R.bool.abc_action_bar_embed_tabs));
    }

    @Override
    public final boolean mo446F(int i6, KeyEvent keyEvent) {
        MenuC2838l menuC2838l;
        C0167w0 c0167w0 = this.f480z;
        if (c0167w0 == null || (menuC2838l = c0167w0.f451d) == null) {
            return false;
        }
        menuC2838l.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuC2838l.performShortcut(i6, keyEvent, 0);
    }

    @Override
    public final void mo449J(boolean z7) {
        if (this.f479y) {
            return;
        }
        mo450K(z7);
    }

    @Override
    public final void mo450K(boolean z7) {
        int i6 = z7 ? 4 : 0;
        C0284v3 c0284v3 = (C0284v3) this.f476v;
        int i10 = c0284v3.f1099b;
        this.f479y = true;
        c0284v3.m797a((i6 & 4) | (i10 & (-5)));
    }

    @Override
    public final void mo451L() {
        C0284v3 c0284v3 = (C0284v3) this.f476v;
        Drawable drawableM3473h = AbstractC1465c.m3473h(c0284v3.f1098a.getContext(), com.p2serv.android.p032ds.R.drawable.quantum_ic_keyboard_arrow_down_white_36);
        c0284v3.f1103f = drawableM3473h;
        int i6 = c0284v3.f1099b & 4;
        Toolbar toolbar = c0284v3.f1098a;
        if (i6 == 0) {
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        if (drawableM3473h == null) {
            drawableM3473h = c0284v3.f1112o;
        }
        toolbar.setNavigationIcon(drawableM3473h);
    }

    @Override
    public final void mo452N(boolean z7) {
        C2749j c2749j;
        this.f467K = z7;
        if (z7 || (c2749j = this.f466J) == null) {
            return;
        }
        c2749j.m5714a();
    }

    @Override
    public final void mo453O(String str) {
        ((C0284v3) this.f476v).m798b(str);
    }

    @Override
    public final void mo454P(String str) {
        C0284v3 c0284v3 = (C0284v3) this.f476v;
        c0284v3.f1104g = true;
        c0284v3.f1105h = str;
        if ((c0284v3.f1099b & 8) != 0) {
            Toolbar toolbar = c0284v3.f1098a;
            toolbar.setTitle(str);
            if (c0284v3.f1104g) {
                AbstractC3155s0.m6348r(toolbar.getRootView(), str);
            }
        }
    }

    @Override
    public final void mo455R(CharSequence charSequence) {
        C0284v3 c0284v3 = (C0284v3) this.f476v;
        if (c0284v3.f1104g) {
            return;
        }
        c0284v3.f1105h = charSequence;
        if ((c0284v3.f1099b & 8) != 0) {
            Toolbar toolbar = c0284v3.f1098a;
            toolbar.setTitle(charSequence);
            if (c0284v3.f1104g) {
                AbstractC3155s0.m6348r(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override
    public final AbstractC2740a mo517T(C0069f c0069f) {
        C0167w0 c0167w0 = this.f480z;
        if (c0167w0 != null) {
            c0167w0.mo473a();
        }
        this.f474t.setHideOnContentScrollEnabled(false);
        this.f477w.m543e();
        C0167w0 c0167w1 = new C0167w0(this, this.f477w.getContext(), c0069f);
        MenuC2838l menuC2838l = c0167w1.f451d;
        menuC2838l.m5840y();
        try {
            boolean zM108h = ((C0023f) c0167w1.f452e.f196b).m108h(c0167w1, menuC2838l);
            menuC2838l.m5839x();
            if (!zM108h) {
                return null;
            }
            this.f480z = c0167w1;
            c0167w1.mo479g();
            this.f477w.m541c(c0167w1);
            m518V(true);
            return c0167w1;
        } catch (Throwable th) {
            menuC2838l.m5839x();
            throw th;
        }
    }

    public final void m518V(boolean z7) {
        C3102a1 c3102a1M545i;
        C3102a1 c3102a1M545i2;
        if (z7) {
            if (!this.f464H) {
                this.f464H = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f474t;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                m521Y(false);
            }
        } else if (this.f464H) {
            this.f464H = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f474t;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            m521Y(false);
        }
        ActionBarContainer actionBarContainer = this.f475u;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (!actionBarContainer.isLaidOut()) {
            if (z7) {
                ((C0284v3) this.f476v).f1098a.setVisibility(4);
                this.f477w.setVisibility(0);
                return;
            } else {
                ((C0284v3) this.f476v).f1098a.setVisibility(0);
                this.f477w.setVisibility(8);
                return;
            }
        }
        if (z7) {
            C0284v3 c0284v3 = (C0284v3) this.f476v;
            c3102a1M545i = AbstractC3155s0.m6331a(c0284v3.f1098a);
            c3102a1M545i.m6121a(0.0f);
            c3102a1M545i.m6123c(100L);
            c3102a1M545i.m6124d(new C0279u3(c0284v3, 4));
            c3102a1M545i2 = this.f477w.m545i(0, 200L);
        } else {
            C0284v3 c0284v4 = (C0284v3) this.f476v;
            C3102a1 c3102a1M6331a = AbstractC3155s0.m6331a(c0284v4.f1098a);
            c3102a1M6331a.m6121a(1.0f);
            c3102a1M6331a.m6123c(200L);
            c3102a1M6331a.m6124d(new C0279u3(c0284v4, 0));
            c3102a1M545i = this.f477w.m545i(8, 100L);
            c3102a1M545i2 = c3102a1M6331a;
        }
        C2749j c2749j = new C2749j();
        ArrayList arrayList = c2749j.f9463a;
        arrayList.add(c3102a1M545i);
        View view = (View) c3102a1M545i.f10574a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) c3102a1M545i2.f10574a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(c3102a1M545i2);
        c2749j.m5715b();
    }

    public final void m519W(View view) {
        InterfaceC0222j1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.p2serv.android.p032ds.R.id.decor_content_parent);
        this.f474t = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.p2serv.android.p032ds.R.id.action_bar);
        if (callbackFindViewById instanceof InterfaceC0222j1) {
            wrapper = (InterfaceC0222j1) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f476v = wrapper;
        this.f477w = (ActionBarContextView) view.findViewById(com.p2serv.android.p032ds.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.p2serv.android.p032ds.R.id.action_bar_container);
        this.f475u = actionBarContainer;
        InterfaceC0222j1 interfaceC0222j1 = this.f476v;
        if (interfaceC0222j1 == null || this.f477w == null || actionBarContainer == null) {
            throw new IllegalStateException(C0169x0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((C0284v3) interfaceC0222j1).f1098a.getContext();
        this.f472r = context;
        if ((((C0284v3) this.f476v).f1099b & 4) != 0) {
            this.f479y = true;
        }
        int i6 = context.getApplicationInfo().targetSdkVersion;
        this.f476v.getClass();
        m520X(context.getResources().getBoolean(com.p2serv.android.p032ds.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f472r.obtainStyledAttributes(null, AbstractC2341a.f8153a, com.p2serv.android.p032ds.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f474t;
            if (!actionBarOverlayLayout2.f555h) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f468L = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f475u;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            AbstractC3119g0.m6180s(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void m520X(boolean z7) {
        if (z7) {
            this.f475u.setTabContainer(null);
            ((C0284v3) this.f476v).getClass();
        } else {
            ((C0284v3) this.f476v).getClass();
            this.f475u.setTabContainer(null);
        }
        this.f476v.getClass();
        ((C0284v3) this.f476v).f1098a.setCollapsible(false);
        this.f474t.setHasNonEmbeddedTabs(false);
    }

    public final void m521Y(boolean z7) {
        boolean z10 = this.f464H || !this.f463G;
        View view = this.f478x;
        final C0019b c0019b = this.f471O;
        if (!z10) {
            if (this.f465I) {
                this.f465I = false;
                C2749j c2749j = this.f466J;
                if (c2749j != null) {
                    c2749j.m5714a();
                }
                int i6 = this.f461E;
                C0165v0 c0165v0 = this.f469M;
                if (i6 != 0 || (!this.f467K && !z7)) {
                    c0165v0.mo463a();
                    return;
                }
                this.f475u.setAlpha(1.0f);
                this.f475u.setTransitioning(true);
                C2749j c2749j2 = new C2749j();
                float f = -this.f475u.getHeight();
                if (z7) {
                    int[] iArr = {0, 0};
                    this.f475u.getLocationInWindow(iArr);
                    f -= iArr[1];
                }
                C3102a1 c3102a1M6331a = AbstractC3155s0.m6331a(this.f475u);
                c3102a1M6331a.m6125e(f);
                final View view2 = (View) c3102a1M6331a.f10574a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(c0019b != null ? new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((C0169x0) c0019b.f38b).f475u.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z11 = c2749j2.f9467e;
                ArrayList arrayList = c2749j2.f9463a;
                if (!z11) {
                    arrayList.add(c3102a1M6331a);
                }
                if (this.f462F && view != null) {
                    C3102a1 c3102a1M6331a2 = AbstractC3155s0.m6331a(view);
                    c3102a1M6331a2.m6125e(f);
                    if (!c2749j2.f9467e) {
                        arrayList.add(c3102a1M6331a2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f455P;
                boolean z12 = c2749j2.f9467e;
                if (!z12) {
                    c2749j2.f9465c = accelerateInterpolator;
                }
                if (!z12) {
                    c2749j2.f9464b = 250L;
                }
                if (!z12) {
                    c2749j2.f9466d = c0165v0;
                }
                this.f466J = c2749j2;
                c2749j2.m5715b();
                return;
            }
            return;
        }
        if (this.f465I) {
            return;
        }
        this.f465I = true;
        C2749j c2749j3 = this.f466J;
        if (c2749j3 != null) {
            c2749j3.m5714a();
        }
        this.f475u.setVisibility(0);
        int i10 = this.f461E;
        C0165v0 c0165v1 = this.f470N;
        if (i10 == 0 && (this.f467K || z7)) {
            this.f475u.setTranslationY(0.0f);
            float f3 = -this.f475u.getHeight();
            if (z7) {
                int[] iArr2 = {0, 0};
                this.f475u.getLocationInWindow(iArr2);
                f3 -= iArr2[1];
            }
            this.f475u.setTranslationY(f3);
            C2749j c2749j4 = new C2749j();
            C3102a1 c3102a1M6331a3 = AbstractC3155s0.m6331a(this.f475u);
            c3102a1M6331a3.m6125e(0.0f);
            final View view3 = (View) c3102a1M6331a3.f10574a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(c0019b != null ? new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) ((C0169x0) c0019b.f38b).f475u.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z13 = c2749j4.f9467e;
            ArrayList arrayList2 = c2749j4.f9463a;
            if (!z13) {
                arrayList2.add(c3102a1M6331a3);
            }
            if (this.f462F && view != null) {
                view.setTranslationY(f3);
                C3102a1 c3102a1M6331a4 = AbstractC3155s0.m6331a(view);
                c3102a1M6331a4.m6125e(0.0f);
                if (!c2749j4.f9467e) {
                    arrayList2.add(c3102a1M6331a4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = f456Q;
            boolean z14 = c2749j4.f9467e;
            if (!z14) {
                c2749j4.f9465c = decelerateInterpolator;
            }
            if (!z14) {
                c2749j4.f9464b = 250L;
            }
            if (!z14) {
                c2749j4.f9466d = c0165v1;
            }
            this.f466J = c2749j4;
            c2749j4.m5715b();
        } else {
            this.f475u.setAlpha(1.0f);
            this.f475u.setTranslationY(0.0f);
            if (this.f462F && view != null) {
                view.setTranslationY(0.0f);
            }
            c0165v1.mo463a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f474t;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            AbstractC3113e0.m6130c(actionBarOverlayLayout);
        }
    }

    @Override
    public final boolean mo458i() {
        C0259q3 c0259q3;
        InterfaceC0222j1 interfaceC0222j1 = this.f476v;
        if (interfaceC0222j1 == null || (c0259q3 = ((C0284v3) interfaceC0222j1).f1098a.f819M) == null || c0259q3.f1041b == null) {
            return false;
        }
        C0259q3 c0259q4 = ((C0284v3) interfaceC0222j1).f1098a.f819M;
        C2840n c2840n = c0259q4 == null ? null : c0259q4.f1041b;
        if (c2840n == null) {
            return true;
        }
        c2840n.collapseActionView();
        return true;
    }

    @Override
    public final void mo459r(boolean z7) {
        if (z7 == this.f459C) {
            return;
        }
        this.f459C = z7;
        ArrayList arrayList = this.f460D;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
    }

    @Override
    public final int mo460u() {
        return ((C0284v3) this.f476v).f1099b;
    }

    @Override
    public final Context mo461v() {
        if (this.f473s == null) {
            TypedValue typedValue = new TypedValue();
            this.f472r.getTheme().resolveAttribute(com.p2serv.android.p032ds.R.attr.actionBarWidgetTheme, typedValue, true);
            int i6 = typedValue.resourceId;
            if (i6 != 0) {
                this.f473s = new ContextThemeWrapper(this.f472r, i6);
            } else {
                this.f473s = this.f472r;
            }
        }
        return this.f473s;
    }

    public C0169x0(Dialog dialog) {
        new ArrayList();
        this.f460D = new ArrayList();
        this.f461E = 0;
        this.f462F = true;
        this.f465I = true;
        this.f469M = new C0165v0(this, 0);
        this.f470N = new C0165v0(this, 1);
        this.f471O = new C0019b(3, this);
        m519W(dialog.getWindow().getDecorView());
    }
}
