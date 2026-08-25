package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.AbstractC0177a4;
import androidx.appcompat.widget.AbstractC0189c4;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.C0195e;
import androidx.appcompat.widget.C0225k;
import androidx.appcompat.widget.C0284v3;
import androidx.appcompat.widget.C0285w;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.InterfaceC0217i1;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0555w;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import p000a.RunnableC0001b;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p045e.AbstractC2341a;
import p093j.AbstractC2740a;
import p093j.C2743d;
import p093j.C2748i;
import p094j0.C2761i;
import p094j0.InterfaceC2763k;
import p105k.C2833g;
import p105k.C2834h;
import p105k.InterfaceC2836j;
import p105k.MenuC2838l;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3102a1;
import p138n0.C3107c0;
import p138n0.InterfaceC3133l;
import p156o9.AbstractC3280d;
import p160p.C3347k;

public final class LayoutInflaterFactory2C0135g0 extends AbstractC0154q implements InterfaceC2836j, LayoutInflater.Factory2 {

    public static final C3347k f302j0 = new C3347k(0);

    public static final int[] f303k0 = {R.attr.windowBackground};

    public static final boolean f304l0 = !"robolectric".equals(Build.FINGERPRINT);

    public static final boolean f305m0 = true;

    public boolean f306A;

    public ViewGroup f307B;

    public TextView f308C;

    public View f309D;

    public boolean f310E;

    public boolean f311F;

    public boolean f312G;

    public boolean f313H;

    public boolean f314I;

    public boolean f315J;

    public boolean f316K;

    public boolean f317L;

    public C0133f0[] f318M;

    public C0133f0 f319N;

    public boolean f320O;

    public boolean f321P;

    public boolean f322Q;

    public boolean f323R;

    public Configuration f324S;

    public final int f325T;

    public int f326U;

    public int f327V;

    public boolean f328W;

    public C0123a0 f329X;

    public C0123a0 f330Y;

    public boolean f331Z;

    public int f332b0;

    public boolean f334d0;

    public Rect f335e0;

    public Rect f336f0;

    public C0143k0 f337g0;

    public OnBackInvokedDispatcher f338h0;

    public OnBackInvokedCallback f339i0;

    public final Object f340j;

    public final Context f341k;

    public Window f342l;

    public WindowCallbackC0171z f343m;

    public final Object f344n;

    public AbstractC2973a f345o;

    public C2748i f346p;

    public CharSequence f347q;

    public InterfaceC0217i1 f348r;

    public C0158s f349s;

    public C0158s f350t;

    public AbstractC2740a f351u;

    public ActionBarContextView f352v;

    public PopupWindow f353w;

    public RunnableC0156r f354x;

    public C3102a1 f355y = null;

    public final boolean f356z = true;

    public final RunnableC0156r f333c0 = new RunnableC0156r(this, 0);

    public LayoutInflaterFactory2C0135g0(Context context, Window window, InterfaceC0146m interfaceC0146m, Object obj) {
        AppCompatActivity appCompatActivity = null;
        this.f325T = -100;
        this.f341k = context;
        this.f340j = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AppCompatActivity)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.f325T = ((LayoutInflaterFactory2C0135g0) appCompatActivity.m364m()).f325T;
            }
        }
        if (this.f325T == -100) {
            C3347k c3347k = f302j0;
            Integer num = (Integer) c3347k.get(this.f340j.getClass().getName());
            if (num != null) {
                this.f325T = num.intValue();
                c3347k.remove(this.f340j.getClass().getName());
            }
        }
        if (window != null) {
            m403o(window);
        }
        C0285w.m803d();
    }

    public static C2761i m380p(Context context) {
        C2761i c2761i;
        C2761i c2761iM5733b;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33 || (c2761i = AbstractC0154q.f417c) == null) {
            return null;
        }
        C2761i c2761iM382z = m382z(context.getApplicationContext().getResources().getConfiguration());
        InterfaceC2763k interfaceC2763k = c2761i.f9475a;
        int i10 = 0;
        if (i6 < 24) {
            c2761iM5733b = interfaceC2763k.isEmpty() ? C2761i.f9474b : C2761i.m5733b(interfaceC2763k.get(0).toString());
        } else if (interfaceC2763k.isEmpty()) {
            c2761iM5733b = C2761i.f9474b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i10 < c2761iM382z.f9475a.size() + interfaceC2763k.size()) {
                Locale locale = i10 < interfaceC2763k.size() ? interfaceC2763k.get(i10) : c2761iM382z.f9475a.get(i10 - interfaceC2763k.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i10++;
            }
            c2761iM5733b = C2761i.m5732a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return c2761iM5733b.f9475a.isEmpty() ? c2761iM382z : c2761iM5733b;
    }

    public static Configuration m381t(Context context, int i6, C2761i c2761i, Configuration configuration, boolean z7) {
        int i10;
        if (i6 == 1) {
            i10 = 16;
        } else if (i6 != 2) {
            i10 = z7 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i10 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i10 | (configuration2.uiMode & (-49));
        if (c2761i != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                AbstractC0166w.m472d(configuration2, c2761i);
            } else {
                InterfaceC2763k interfaceC2763k = c2761i.f9475a;
                AbstractC0162u.m467b(configuration2, interfaceC2763k.get(0));
                AbstractC0162u.m466a(configuration2, interfaceC2763k.get(0));
            }
        }
        return configuration2;
    }

    public static C2761i m382z(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? AbstractC0166w.m470b(configuration) : C2761i.m5733b(AbstractC0164v.m468a(configuration.locale));
    }

    public final C0133f0 m383A(int i6) {
        C0133f0[] c0133f0Arr = this.f318M;
        if (c0133f0Arr == null || c0133f0Arr.length <= i6) {
            C0133f0[] c0133f0Arr2 = new C0133f0[i6 + 1];
            if (c0133f0Arr != null) {
                System.arraycopy(c0133f0Arr, 0, c0133f0Arr2, 0, c0133f0Arr.length);
            }
            this.f318M = c0133f0Arr2;
            c0133f0Arr = c0133f0Arr2;
        }
        C0133f0 c0133f0 = c0133f0Arr[i6];
        if (c0133f0 != null) {
            return c0133f0;
        }
        C0133f0 c0133f1 = new C0133f0();
        c0133f1.f286a = i6;
        c0133f1.f299n = false;
        c0133f0Arr[i6] = c0133f1;
        return c0133f1;
    }

    public final void m384B() {
        m409w();
        if (this.f312G && this.f345o == null) {
            Object obj = this.f340j;
            if (obj instanceof Activity) {
                this.f345o = new C0169x0((Activity) obj, this.f313H);
            } else if (obj instanceof Dialog) {
                this.f345o = new C0169x0((Dialog) obj);
            }
            AbstractC2973a abstractC2973a = this.f345o;
            if (abstractC2973a != null) {
                abstractC2973a.mo449J(this.f334d0);
            }
        }
    }

    public final void m385C(int i6) {
        this.f332b0 = (1 << i6) | this.f332b0;
        if (this.f331Z) {
            return;
        }
        View decorView = this.f342l.getDecorView();
        RunnableC0156r runnableC0156r = this.f333c0;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        decorView.postOnAnimation(runnableC0156r);
        this.f331Z = true;
    }

    public final int m386D(Context context, int i6) {
        if (i6 == -100) {
            return -1;
        }
        if (i6 != -1) {
            if (i6 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return m411y(context).mo369f();
                }
                return -1;
            }
            if (i6 != 1 && i6 != 2) {
                if (i6 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.f330Y == null) {
                    this.f330Y = new C0123a0(this, context);
                }
                return this.f330Y.mo369f();
            }
        }
        return i6;
    }

    public final boolean m387E() {
        boolean z7 = this.f320O;
        this.f320O = false;
        C0133f0 c0133f0M383A = m383A(0);
        if (c0133f0M383A.f298m) {
            if (!z7) {
                m406s(c0133f0M383A, true);
            }
            return true;
        }
        AbstractC2740a abstractC2740a = this.f351u;
        if (abstractC2740a != null) {
            abstractC2740a.mo473a();
            return true;
        }
        m384B();
        AbstractC2973a abstractC2973a = this.f345o;
        return abstractC2973a != null && abstractC2973a.mo458i();
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m388F(C0133f0 c0133f0, KeyEvent keyEvent) {
        int i6;
        ViewGroup.LayoutParams layoutParams;
        if (c0133f0.f298m || this.f323R) {
            return;
        }
        int i10 = c0133f0.f286a;
        Context context = this.f341k;
        if (i10 == 0 && (context.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callback = this.f342l.getCallback();
        if (callback != null && !callback.onMenuOpened(i10, c0133f0.f293h)) {
            m406s(c0133f0, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && m390H(c0133f0, keyEvent)) {
            C0129d0 c0129d0 = c0133f0.f290e;
            if (c0129d0 != null && !c0133f0.f299n) {
                View view = c0133f0.f292g;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i6 = -1;
                }
                c0133f0.f297l = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i6, -2, 0, 0, 1002, 8519680, -3);
                layoutParams2.gravity = c0133f0.f288c;
                layoutParams2.windowAnimations = c0133f0.f289d;
                windowManager.addView(c0133f0.f290e, layoutParams2);
                c0133f0.f298m = true;
                if (i10 == 0) {
                    m392J();
                }
            }
            if (c0129d0 == null) {
                m384B();
                AbstractC2973a abstractC2973a = this.f345o;
                Context contextMo461v = abstractC2973a != null ? abstractC2973a.mo461v() : null;
                if (contextMo461v != null) {
                    context = contextMo461v;
                }
                TypedValue typedValue = new TypedValue();
                Resources.Theme themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(context.getTheme());
                themeNewTheme.resolveAttribute(com.p2serv.android.p032ds.R.attr.actionBarPopupTheme, typedValue, true);
                int i11 = typedValue.resourceId;
                if (i11 != 0) {
                    themeNewTheme.applyStyle(i11, true);
                }
                themeNewTheme.resolveAttribute(com.p2serv.android.p032ds.R.attr.panelMenuListTheme, typedValue, true);
                int i12 = typedValue.resourceId;
                if (i12 != 0) {
                    themeNewTheme.applyStyle(i12, true);
                } else {
                    themeNewTheme.applyStyle(com.p2serv.android.p032ds.R.style.Theme_AppCompat_CompactMenu, true);
                }
                C2743d c2743d = new C2743d(context, 0);
                c2743d.getTheme().setTo(themeNewTheme);
                c0133f0.f295j = c2743d;
                TypedArray typedArrayObtainStyledAttributes = c2743d.obtainStyledAttributes(AbstractC2341a.f8163k);
                c0133f0.f287b = typedArrayObtainStyledAttributes.getResourceId(86, 0);
                c0133f0.f289d = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                typedArrayObtainStyledAttributes.recycle();
                c0133f0.f290e = new C0129d0(this, c0133f0.f295j);
                c0133f0.f288c = 81;
            } else if (c0133f0.f299n && c0129d0.getChildCount() > 0) {
                c0133f0.f290e.removeAllViews();
            }
            View view2 = c0133f0.f292g;
            if (view2 == null) {
                if (c0133f0.f293h != null) {
                    if (this.f350t == null) {
                        this.f350t = new C0158s(this, 3);
                    }
                    C0158s c0158s = this.f350t;
                    if (c0133f0.f294i == null) {
                        C2834h c2834h = new C2834h(c0133f0.f295j);
                        c0133f0.f294i = c2834h;
                        c2834h.f9678e = c0158s;
                        MenuC2838l menuC2838l = c0133f0.f293h;
                        menuC2838l.m5826b(c2834h, menuC2838l.f9687a);
                    }
                    C2834h c2834h2 = c0133f0.f294i;
                    C0129d0 c0129d1 = c0133f0.f290e;
                    if (c2834h2.f9677d == null) {
                        c2834h2.f9677d = (ExpandedMenuView) c2834h2.f9675b.inflate(com.p2serv.android.p032ds.R.layout.abc_expanded_menu_layout, (ViewGroup) c0129d1, false);
                        if (c2834h2.f9679f == null) {
                            c2834h2.f9679f = new C2833g(c2834h2);
                        }
                        c2834h2.f9677d.setAdapter((ListAdapter) c2834h2.f9679f);
                        c2834h2.f9677d.setOnItemClickListener(c2834h2);
                    }
                    ExpandedMenuView expandedMenuView = c2834h2.f9677d;
                    c0133f0.f291f = expandedMenuView;
                    if (expandedMenuView != null) {
                    }
                }
                c0133f0.f299n = true;
                return;
            }
            c0133f0.f291f = view2;
            if (c0133f0.f291f != null) {
                if (c0133f0.f292g == null) {
                    C2834h c2834h3 = c0133f0.f294i;
                    if (c2834h3.f9679f == null) {
                        c2834h3.f9679f = new C2833g(c2834h3);
                    }
                }
                ViewGroup.LayoutParams layoutParams3 = c0133f0.f291f.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                c0133f0.f290e.setBackgroundResource(c0133f0.f287b);
                ViewParent parent = c0133f0.f291f.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(c0133f0.f291f);
                }
                c0133f0.f290e.addView(c0133f0.f291f, layoutParams3);
                if (!c0133f0.f291f.hasFocus()) {
                    c0133f0.f291f.requestFocus();
                }
            }
            c0133f0.f299n = true;
            return;
            i6 = -2;
            c0133f0.f297l = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i6, -2, 0, 0, 1002, 8519680, -3);
            layoutParams4.gravity = c0133f0.f288c;
            layoutParams4.windowAnimations = c0133f0.f289d;
            windowManager.addView(c0133f0.f290e, layoutParams4);
            c0133f0.f298m = true;
            if (i10 == 0) {
                m392J();
            }
        }
    }

    public final boolean m389G(C0133f0 c0133f0, int i6, KeyEvent keyEvent) {
        MenuC2838l menuC2838l;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0133f0.f296k || m390H(c0133f0, keyEvent)) && (menuC2838l = c0133f0.f293h) != null) {
            return menuC2838l.performShortcut(i6, keyEvent, 1);
        }
        return false;
    }

    public final boolean m390H(C0133f0 c0133f0, KeyEvent keyEvent) {
        InterfaceC0217i1 interfaceC0217i1;
        InterfaceC0217i1 interfaceC0217i2;
        Resources.Theme themeNewTheme;
        InterfaceC0217i1 interfaceC0217i3;
        InterfaceC0217i1 interfaceC0217i4;
        if (this.f323R) {
            return false;
        }
        if (c0133f0.f296k) {
            return true;
        }
        C0133f0 c0133f1 = this.f319N;
        if (c0133f1 != null && c0133f1 != c0133f0) {
            m406s(c0133f1, false);
        }
        Window.Callback callback = this.f342l.getCallback();
        int i6 = c0133f0.f286a;
        if (callback != null) {
            c0133f0.f292g = callback.onCreatePanelView(i6);
        }
        boolean z7 = i6 == 0 || i6 == 108;
        if (z7 && (interfaceC0217i4 = this.f348r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0217i4;
            actionBarOverlayLayout.m556k();
            ((C0284v3) actionBarOverlayLayout.f552e).f1109l = true;
        }
        if (c0133f0.f292g == null && (!z7 || !(this.f345o instanceof C0159s0))) {
            MenuC2838l menuC2838l = c0133f0.f293h;
            if (menuC2838l == null || c0133f0.f300o) {
                if (menuC2838l == null) {
                    Context context = this.f341k;
                    if ((i6 == 0 || i6 == 108) && this.f348r != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.p2serv.android.p032ds.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(com.p2serv.android.p032ds.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(com.p2serv.android.p032ds.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            C2743d c2743d = new C2743d(context, 0);
                            c2743d.getTheme().setTo(themeNewTheme);
                            context = c2743d;
                        }
                    }
                    MenuC2838l menuC2838l2 = new MenuC2838l(context);
                    menuC2838l2.f9691e = this;
                    MenuC2838l menuC2838l3 = c0133f0.f293h;
                    if (menuC2838l2 != menuC2838l3) {
                        if (menuC2838l3 != null) {
                            menuC2838l3.m5833r(c0133f0.f294i);
                        }
                        c0133f0.f293h = menuC2838l2;
                        C2834h c2834h = c0133f0.f294i;
                        if (c2834h != null) {
                            menuC2838l2.m5826b(c2834h, menuC2838l2.f9687a);
                        }
                    }
                    if (c0133f0.f293h == null) {
                        return false;
                    }
                }
                if (z7 && (interfaceC0217i2 = this.f348r) != null) {
                    if (this.f349s == null) {
                        this.f349s = new C0158s(this, 2);
                    }
                    ((ActionBarOverlayLayout) interfaceC0217i2).m557l(c0133f0.f293h, this.f349s);
                }
                c0133f0.f293h.m5840y();
                if (!callback.onCreatePanelMenu(i6, c0133f0.f293h)) {
                    MenuC2838l menuC2838l4 = c0133f0.f293h;
                    if (menuC2838l4 != null) {
                        if (menuC2838l4 != null) {
                            menuC2838l4.m5833r(c0133f0.f294i);
                        }
                        c0133f0.f293h = null;
                    }
                    if (z7 && (interfaceC0217i1 = this.f348r) != null) {
                        ((ActionBarOverlayLayout) interfaceC0217i1).m557l(null, this.f349s);
                    }
                    return false;
                }
                c0133f0.f300o = false;
            }
            c0133f0.f293h.m5840y();
            Bundle bundle = c0133f0.f301p;
            if (bundle != null) {
                c0133f0.f293h.m5834s(bundle);
                c0133f0.f301p = null;
            }
            if (!callback.onPreparePanel(0, c0133f0.f292g, c0133f0.f293h)) {
                if (z7 && (interfaceC0217i3 = this.f348r) != null) {
                    ((ActionBarOverlayLayout) interfaceC0217i3).m557l(null, this.f349s);
                }
                c0133f0.f293h.m5839x();
                return false;
            }
            c0133f0.f293h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            c0133f0.f293h.m5839x();
        }
        c0133f0.f296k = true;
        c0133f0.f297l = false;
        this.f319N = c0133f0;
        return true;
    }

    public final void m391I() {
        if (this.f306A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void m392J() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z7 = false;
            if (this.f338h0 != null && (m383A(0).f298m || this.f351u != null)) {
                z7 = true;
            }
            if (z7 && this.f339i0 == null) {
                this.f339i0 = AbstractC0170y.m523b(this.f338h0, this);
            } else {
                if (z7 || (onBackInvokedCallback = this.f339i0) == null) {
                    return;
                }
                AbstractC0170y.m524c(this.f338h0, onBackInvokedCallback);
            }
        }
    }

    @Override
    public final void mo393a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f341k);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof LayoutInflaterFactory2C0135g0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override
    public final void mo394b() {
        if (this.f345o != null) {
            m384B();
            if (this.f345o.mo462w()) {
                return;
            }
            m385C(0);
        }
    }

    @Override
    public final void mo395d() throws IllegalAccessException {
        String strM150B;
        this.f321P = true;
        m402m(false, true);
        m410x();
        Object obj = this.f340j;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strM150B = AbstractC0032a.m150B(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e5) {
                    throw new IllegalArgumentException(e5);
                }
            } catch (IllegalArgumentException unused) {
                strM150B = null;
            }
            if (strM150B != null) {
                AbstractC2973a abstractC2973a = this.f345o;
                if (abstractC2973a == null) {
                    this.f334d0 = true;
                } else {
                    abstractC2973a.mo449J(true);
                }
            }
            synchronized (AbstractC0154q.f422h) {
                AbstractC0154q.m438f(this);
                AbstractC0154q.f421g.add(new WeakReference(this));
            }
        }
        this.f324S = new Configuration(this.f341k.getResources().getConfiguration());
        this.f322Q = true;
    }

    @Override
    public final void mo396e() {
        if (this.f340j instanceof Activity) {
            synchronized (AbstractC0154q.f422h) {
                AbstractC0154q.m438f(this);
            }
        }
        if (this.f331Z) {
            this.f342l.getDecorView().removeCallbacks(this.f333c0);
        }
        this.f323R = true;
        if (this.f325T != -100) {
            Object obj = this.f340j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f302j0.put(this.f340j.getClass().getName(), Integer.valueOf(this.f325T));
            } else {
                f302j0.remove(this.f340j.getClass().getName());
            }
        } else {
            f302j0.remove(this.f340j.getClass().getName());
        }
        AbstractC2973a abstractC2973a = this.f345o;
        if (abstractC2973a != null) {
            abstractC2973a.mo445C();
        }
        C0123a0 c0123a0 = this.f329X;
        if (c0123a0 != null) {
            c0123a0.m372c();
        }
        C0123a0 c0123a1 = this.f330Y;
        if (c0123a1 != null) {
            c0123a1.m372c();
        }
    }

    @Override
    public final boolean mo397g(int i6) {
        if (i6 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i6 = 108;
        } else if (i6 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i6 = 109;
        }
        if (this.f316K && i6 == 108) {
            return false;
        }
        if (this.f312G && i6 == 1) {
            this.f312G = false;
        }
        if (i6 == 1) {
            m391I();
            this.f316K = true;
            return true;
        }
        if (i6 == 2) {
            m391I();
            this.f310E = true;
            return true;
        }
        if (i6 == 5) {
            m391I();
            this.f311F = true;
            return true;
        }
        if (i6 == 10) {
            m391I();
            this.f314I = true;
            return true;
        }
        if (i6 == 108) {
            m391I();
            this.f312G = true;
            return true;
        }
        if (i6 != 109) {
            return this.f342l.requestFeature(i6);
        }
        m391I();
        this.f313H = true;
        return true;
    }

    @Override
    public final void mo398h(int i6) {
        m409w();
        ViewGroup viewGroup = (ViewGroup) this.f307B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f341k).inflate(i6, viewGroup);
        this.f343m.m525a(this.f342l.getCallback());
    }

    @Override
    public final void mo399i(View view) {
        m409w();
        ViewGroup viewGroup = (ViewGroup) this.f307B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f343m.m525a(this.f342l.getCallback());
    }

    @Override
    public final boolean mo94j(MenuC2838l menuC2838l, MenuItem menuItem) {
        C0133f0 c0133f0;
        Window.Callback callback = this.f342l.getCallback();
        if (callback != null && !this.f323R) {
            MenuC2838l menuC2838lMo5817k = menuC2838l.mo5817k();
            C0133f0[] c0133f0Arr = this.f318M;
            int length = c0133f0Arr != null ? c0133f0Arr.length : 0;
            for (int i6 = 0; i6 < length; i6++) {
                c0133f0 = c0133f0Arr[i6];
                if (c0133f0 != null && c0133f0.f293h == menuC2838lMo5817k) {
                    if (c0133f0 != null) {
                        return callback.onMenuItemSelected(c0133f0.f286a, menuItem);
                    }
                }
            }
            c0133f0 = null;
            if (c0133f0 != null) {
                return callback.onMenuItemSelected(c0133f0.f286a, menuItem);
            }
        }
        return false;
    }

    @Override
    public final void mo400k(View view, ViewGroup.LayoutParams layoutParams) {
        m409w();
        ViewGroup viewGroup = (ViewGroup) this.f307B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f343m.m525a(this.f342l.getCallback());
    }

    @Override
    public final void mo401l(CharSequence charSequence) {
        this.f347q = charSequence;
        InterfaceC0217i1 interfaceC0217i1 = this.f348r;
        if (interfaceC0217i1 != null) {
            interfaceC0217i1.setWindowTitle(charSequence);
            return;
        }
        AbstractC2973a abstractC2973a = this.f345o;
        if (abstractC2973a != null) {
            abstractC2973a.mo455R(charSequence);
            return;
        }
        TextView textView = this.f308C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean m402m(boolean z7, boolean z10) throws IllegalAccessException {
        int i6;
        boolean z11;
        boolean z12;
        boolean z13;
        Map map;
        boolean z14;
        Object obj;
        Object obj2;
        Object obj3;
        int i10;
        if (this.f323R) {
            return false;
        }
        int i11 = this.f325T;
        if (i11 == -100) {
            i11 = AbstractC0154q.f416b;
        }
        int i12 = i11;
        Context context = this.f341k;
        int iM386D = m386D(context, i12);
        int i13 = Build.VERSION.SDK_INT;
        C2761i c2761iM380p = i13 < 33 ? m380p(context) : null;
        if (!z10 && c2761iM380p != null) {
            c2761iM380p = m382z(context.getResources().getConfiguration());
        }
        Configuration configurationM381t = m381t(context, iM386D, c2761iM380p, null, false);
        boolean z15 = this.f328W;
        Object obj4 = this.f340j;
        if (z15 || !(obj4 instanceof Activity)) {
            this.f328W = true;
            i6 = this.f327V;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i6 = 0;
            } else {
                if (i13 >= 29) {
                    i10 = 269221888;
                } else {
                    i10 = i13 >= 24 ? 786432 : 0;
                }
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj4.getClass()), i10);
                    if (activityInfo != null) {
                        this.f327V = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e5);
                    this.f327V = 0;
                }
                this.f328W = true;
                i6 = this.f327V;
            }
        }
        Configuration configuration = this.f324S;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i14 = configuration.uiMode & 48;
        int i15 = configurationM381t.uiMode & 48;
        C2761i c2761iM382z = m382z(configuration);
        C2761i c2761iM382z2 = c2761iM380p == null ? null : m382z(configurationM381t);
        int i16 = i14 != i15 ? 512 : 0;
        if (c2761iM382z2 != null && !c2761iM382z.equals(c2761iM382z2)) {
            i16 |= 8196;
        }
        if (((~i6) & i16) != 0 && z7 && this.f321P && ((f304l0 || this.f322Q) && (obj4 instanceof Activity))) {
            Activity activity = (Activity) obj4;
            if (activity.isChild()) {
                z11 = false;
            } else {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new RunnableC0001b(3, activity));
                }
                z11 = true;
            }
        } else {
            z11 = false;
        }
        if (z11 || i16 == 0) {
            z12 = z11;
        } else {
            boolean z16 = (i6 & i16) == i16;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i15;
            if (c2761iM382z2 != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    AbstractC0166w.m472d(configuration2, c2761iM382z2);
                } else {
                    InterfaceC2763k interfaceC2763k = c2761iM382z2.f9475a;
                    AbstractC0162u.m467b(configuration2, interfaceC2763k.get(0));
                    AbstractC0162u.m466a(configuration2, interfaceC2763k.get(0));
                }
            }
            resources.updateConfiguration(configuration2, null);
            int i17 = Build.VERSION.SDK_INT;
            if (i17 < 26 && i17 < 28) {
                if (i17 >= 24) {
                    if (!AbstractC3280d.f10982h) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                            AbstractC3280d.f10981g = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException e10) {
                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e10);
                        }
                        AbstractC3280d.f10982h = true;
                    }
                    Field field = AbstractC3280d.f10981g;
                    if (field != null) {
                        try {
                            obj2 = field.get(resources);
                        } catch (IllegalAccessException e11) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e11);
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            if (!AbstractC3280d.f10976b) {
                                try {
                                    Field declaredField2 = obj2.getClass().getDeclaredField("mDrawableCache");
                                    AbstractC3280d.f10975a = declaredField2;
                                    declaredField2.setAccessible(true);
                                } catch (NoSuchFieldException e12) {
                                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e12);
                                }
                                AbstractC3280d.f10976b = true;
                            }
                            Field field2 = AbstractC3280d.f10975a;
                            if (field2 != null) {
                                try {
                                    obj3 = field2.get(obj2);
                                } catch (IllegalAccessException e13) {
                                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e13);
                                    obj3 = null;
                                }
                            } else {
                                obj3 = null;
                            }
                            if (obj3 != null) {
                                AbstractC3280d.m6593k(obj3);
                            }
                        }
                    }
                } else if (i17 >= 23) {
                    if (!AbstractC3280d.f10976b) {
                        try {
                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                            AbstractC3280d.f10975a = declaredField3;
                            z14 = true;
                            try {
                                declaredField3.setAccessible(true);
                            } catch (NoSuchFieldException e14) {
                                e = e14;
                                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
                            }
                        } catch (NoSuchFieldException e15) {
                            e = e15;
                            z14 = true;
                        }
                        AbstractC3280d.f10976b = z14;
                    }
                    Field field3 = AbstractC3280d.f10975a;
                    if (field3 != null) {
                        try {
                            obj = field3.get(resources);
                        } catch (IllegalAccessException e16) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e16);
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        AbstractC3280d.m6593k(obj);
                    }
                } else {
                    if (!AbstractC3280d.f10976b) {
                        try {
                            Field declaredField4 = Resources.class.getDeclaredField("mDrawableCache");
                            AbstractC3280d.f10975a = declaredField4;
                            z13 = true;
                            try {
                                declaredField4.setAccessible(true);
                            } catch (NoSuchFieldException e17) {
                                e = e17;
                                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
                            }
                        } catch (NoSuchFieldException e18) {
                            e = e18;
                            z13 = true;
                        }
                        AbstractC3280d.f10976b = z13;
                    }
                    Field field4 = AbstractC3280d.f10975a;
                    if (field4 != null) {
                        try {
                            map = (Map) field4.get(resources);
                        } catch (IllegalAccessException e19) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e19);
                            map = null;
                        }
                        if (map != null) {
                            map.clear();
                        }
                    }
                }
            }
            int i18 = this.f326U;
            if (i18 != 0) {
                context.setTheme(i18);
                if (Build.VERSION.SDK_INT >= 23) {
                    context.getTheme().applyStyle(this.f326U, true);
                }
            }
            if (z16 && (obj4 instanceof Activity)) {
                Activity activity2 = (Activity) obj4;
                if (activity2 instanceof InterfaceC0555w) {
                    if (((InterfaceC0555w) activity2).mo360f().mo1509b().compareTo(EnumC0539o.f2509c) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.f322Q && !this.f323R) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
            z12 = true;
        }
        if (z12 && (obj4 instanceof AppCompatActivity)) {
            if ((i16 & 512) != 0) {
            }
            if ((i16 & 4) != 0) {
            }
        }
        if (z12 && c2761iM382z2 != null) {
            C2761i c2761iM382z3 = m382z(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                AbstractC0166w.m471c(c2761iM382z3);
            } else {
                Locale.setDefault(c2761iM382z3.f9475a.get(0));
            }
        }
        if (i12 == 0) {
            m411y(context).m379m();
        } else {
            C0123a0 c0123a0 = this.f329X;
            if (c0123a0 != null) {
                c0123a0.m372c();
            }
        }
        if (i12 == 3) {
            if (this.f330Y == null) {
                this.f330Y = new C0123a0(this, context);
            }
            this.f330Y.m379m();
        } else {
            C0123a0 c0123a1 = this.f330Y;
            if (c0123a1 != null) {
                c0123a1.m372c();
            }
        }
        return z12;
    }

    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo97n(MenuC2838l menuC2838l) {
        ActionMenuView actionMenuView;
        C0225k c0225k;
        InterfaceC0217i1 interfaceC0217i1 = this.f348r;
        if (interfaceC0217i1 != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0217i1;
            actionBarOverlayLayout.m556k();
            Toolbar toolbar = ((C0284v3) actionBarOverlayLayout.f552e).f1098a;
            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f827a) != null && actionMenuView.f579s) {
                if (ViewConfiguration.get(this.f341k).hasPermanentMenuKey()) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.f348r;
                    actionBarOverlayLayout2.m556k();
                    ActionMenuView actionMenuView2 = ((C0284v3) actionBarOverlayLayout2.f552e).f1098a.f827a;
                    if (actionMenuView2 != null) {
                        C0225k c0225k2 = actionMenuView2.f580t;
                        if (c0225k2 != null) {
                            if (c0225k2.f973v == null) {
                            }
                        }
                    }
                }
                Window.Callback callback = this.f342l.getCallback();
                ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.f348r;
                actionBarOverlayLayout3.m556k();
                if (((C0284v3) actionBarOverlayLayout3.f552e).f1098a.m624p()) {
                    ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.f348r;
                    actionBarOverlayLayout4.m556k();
                    ActionMenuView actionMenuView3 = ((C0284v3) actionBarOverlayLayout4.f552e).f1098a.f827a;
                    if (actionMenuView3 != null && (c0225k = actionMenuView3.f580t) != null) {
                        c0225k.m708c();
                    }
                    if (this.f323R) {
                        return;
                    }
                    callback.onPanelClosed(108, m383A(0).f293h);
                    return;
                }
                if (callback == null || this.f323R) {
                    return;
                }
                if (this.f331Z && (1 & this.f332b0) != 0) {
                    View decorView = this.f342l.getDecorView();
                    RunnableC0156r runnableC0156r = this.f333c0;
                    decorView.removeCallbacks(runnableC0156r);
                    runnableC0156r.run();
                }
                C0133f0 c0133f0M383A = m383A(0);
                MenuC2838l menuC2838l2 = c0133f0M383A.f293h;
                if (menuC2838l2 == null || c0133f0M383A.f300o || !callback.onPreparePanel(0, c0133f0M383A.f292g, menuC2838l2)) {
                    return;
                }
                callback.onMenuOpened(108, c0133f0M383A.f293h);
                ActionBarOverlayLayout actionBarOverlayLayout5 = (ActionBarOverlayLayout) this.f348r;
                actionBarOverlayLayout5.m556k();
                ((C0284v3) actionBarOverlayLayout5.f552e).f1098a.m630v();
                return;
            }
        }
        C0133f0 c0133f0M383A2 = m383A(0);
        c0133f0M383A2.f299n = true;
        m406s(c0133f0M383A2, false);
        m388F(c0133f0M383A2, null);
    }

    public final void m403o(Window window) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.f342l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof WindowCallbackC0171z) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        WindowCallbackC0171z windowCallbackC0171z = new WindowCallbackC0171z(this, callback);
        this.f343m = windowCallbackC0171z;
        window.setCallback(windowCallbackC0171z);
        C0026b c0026bM110B = C0026b.m110B(this.f341k, null, f303k0);
        Drawable drawableM141u = c0026bM110B.m141u(0);
        if (drawableM141u != null) {
            window.setBackgroundDrawable(drawableM141u);
        }
        c0026bM110B.m120F();
        this.f342l = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f338h0) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f339i0) != null) {
            AbstractC0170y.m524c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f339i0 = null;
        }
        Object obj = this.f340j;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f338h0 = AbstractC0170y.m522a(activity);
            } else {
                this.f338h0 = null;
            }
        } else {
            this.f338h0 = null;
        }
        m392J();
    }

    @Override
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View appCompatRatingBar;
        ?? r10;
        String attributeValue = str;
        byte b8 = 4;
        View view2 = null;
        if (this.f337g0 == null) {
            int[] iArr = AbstractC2341a.f8163k;
            Context context2 = this.f341k;
            String string = context2.obtainStyledAttributes(iArr).getString(AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID);
            if (string == null) {
                this.f337g0 = new C0143k0();
            } else {
                try {
                    this.f337g0 = (C0143k0) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f337g0 = new C0143k0();
                }
            }
        }
        C0143k0 c0143k0 = this.f337g0;
        int i6 = AbstractC0177a4.f868a;
        c0143k0.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2341a.f8150A, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        Context c2743d = (resourceId == 0 || ((context instanceof C2743d) && ((C2743d) context).f9410a == resourceId)) ? context : new C2743d(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                if (!attributeValue.equals("RatingBar")) {
                    b8 = -1;
                } else {
                    b8 = 0;
                }
                break;
            case -1455429095:
                if (!attributeValue.equals("CheckedTextView")) {
                    b8 = -1;
                } else {
                    b8 = 1;
                }
                break;
            case -1346021293:
                if (!attributeValue.equals("MultiAutoCompleteTextView")) {
                    b8 = -1;
                } else {
                    b8 = 2;
                }
                break;
            case -938935918:
                if (!attributeValue.equals("TextView")) {
                    b8 = -1;
                } else {
                    b8 = 3;
                }
                break;
            case -937446323:
                if (!attributeValue.equals("ImageButton")) {
                    b8 = -1;
                }
                break;
            case -658531749:
                if (!attributeValue.equals("SeekBar")) {
                    b8 = -1;
                } else {
                    b8 = 5;
                }
                break;
            case -339785223:
                if (!attributeValue.equals("Spinner")) {
                    b8 = -1;
                } else {
                    b8 = 6;
                }
                break;
            case 776382189:
                if (!attributeValue.equals("RadioButton")) {
                    b8 = -1;
                } else {
                    b8 = 7;
                }
                break;
            case 799298502:
                if (!attributeValue.equals("ToggleButton")) {
                    b8 = -1;
                } else {
                    b8 = 8;
                }
                break;
            case 1125864064:
                if (!attributeValue.equals("ImageView")) {
                    b8 = -1;
                } else {
                    b8 = 9;
                }
                break;
            case 1413872058:
                if (!attributeValue.equals("AutoCompleteTextView")) {
                    b8 = -1;
                } else {
                    b8 = 10;
                }
                break;
            case 1601505219:
                if (!attributeValue.equals("CheckBox")) {
                    b8 = -1;
                } else {
                    b8 = 11;
                }
                break;
            case 1666676343:
                if (!attributeValue.equals("EditText")) {
                    b8 = -1;
                } else {
                    b8 = 12;
                }
                break;
            case 2001146706:
                if (!attributeValue.equals("Button")) {
                    b8 = -1;
                } else {
                    b8 = 13;
                }
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
                appCompatRatingBar = new AppCompatRatingBar(c2743d, attributeSet);
                break;
            case 1:
                appCompatRatingBar = new AppCompatCheckedTextView(c2743d, attributeSet);
                break;
            case 2:
                appCompatRatingBar = new AppCompatMultiAutoCompleteTextView(c2743d, attributeSet);
                break;
            case 3:
                appCompatRatingBar = c0143k0.mo429e(c2743d, attributeSet);
                break;
            case 4:
                appCompatRatingBar = new AppCompatImageButton(c2743d, attributeSet);
                break;
            case 5:
                appCompatRatingBar = new AppCompatSeekBar(c2743d, attributeSet);
                break;
            case 6:
                appCompatRatingBar = new AppCompatSpinner(c2743d, attributeSet);
                break;
            case 7:
                appCompatRatingBar = c0143k0.mo428d(c2743d, attributeSet);
                break;
            case 8:
                appCompatRatingBar = new AppCompatToggleButton(c2743d, attributeSet);
                break;
            case 9:
                appCompatRatingBar = new AppCompatImageView(c2743d, attributeSet);
                break;
            case 10:
                appCompatRatingBar = c0143k0.mo425a(c2743d, attributeSet);
                break;
            case 11:
                appCompatRatingBar = c0143k0.mo427c(c2743d, attributeSet);
                break;
            case 12:
                appCompatRatingBar = new AppCompatEditText(c2743d, attributeSet);
                break;
            case 13:
                appCompatRatingBar = c0143k0.mo426b(c2743d, attributeSet);
                break;
            default:
                appCompatRatingBar = null;
                break;
        }
        if (appCompatRatingBar == null && context != c2743d) {
            Object[] objArr = c0143k0.f404a;
            if (attributeValue.equals("view")) {
                attributeValue = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = c2743d;
                objArr[1] = attributeSet;
                if (-1 == attributeValue.indexOf(46)) {
                    int i10 = 0;
                    while (true) {
                        String[] strArr = C0143k0.f402g;
                        if (i10 < 3) {
                            View viewM430f = c0143k0.m430f(c2743d, attributeValue, strArr[i10]);
                            if (viewM430f != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewM430f;
                            } else {
                                i10++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewM430f2 = c0143k0.m430f(c2743d, attributeValue, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewM430f2;
                }
            } catch (Exception unused) {
                objArr[0] = null;
                objArr[1] = null;
            } catch (Throwable th2) {
                objArr[0] = null;
                objArr[1] = null;
                throw th2;
            }
            appCompatRatingBar = view2;
        }
        if (appCompatRatingBar != null) {
            Context context3 = appCompatRatingBar.getContext();
            if (context3 instanceof ContextWrapper) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (appCompatRatingBar.hasOnClickListeners()) {
                    TypedArray typedArrayObtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, C0143k0.f398c);
                    String string2 = typedArrayObtainStyledAttributes2.getString(0);
                    if (string2 != null) {
                        appCompatRatingBar.setOnClickListener(new ViewOnClickListenerC0141j0(appCompatRatingBar, string2));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                }
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes3 = c2743d.obtainStyledAttributes(attributeSet, C0143k0.f399d);
                if (typedArrayObtainStyledAttributes3.hasValue(0)) {
                    boolean z7 = typedArrayObtainStyledAttributes3.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                    r10 = 0;
                    new C3107c0(com.p2serv.android.p032ds.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).m3247d(appCompatRatingBar, Boolean.valueOf(z7));
                } else {
                    r10 = 0;
                }
                typedArrayObtainStyledAttributes3.recycle();
                ?? ObtainStyledAttributes = c2743d.obtainStyledAttributes(attributeSet, C0143k0.f400e);
                if (ObtainStyledAttributes.hasValue(r10)) {
                    AbstractC3155s0.m6348r(appCompatRatingBar, ObtainStyledAttributes.getString(r10));
                }
                ObtainStyledAttributes.recycle();
                ?? ObtainStyledAttributes2 = c2743d.obtainStyledAttributes(attributeSet, C0143k0.f401f);
                if (ObtainStyledAttributes2.hasValue(r10)) {
                    boolean z10 = ObtainStyledAttributes2.getBoolean(r10, r10);
                    WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                    new C3107c0(com.p2serv.android.p032ds.R.id.tag_screen_reader_focusable, Boolean.class, r10 == true ? 1 : 0, 28, 0).m3247d(appCompatRatingBar, Boolean.valueOf(z10));
                }
                ObtainStyledAttributes2.recycle();
            }
        }
        return appCompatRatingBar;
    }

    public final void m404q(int i6, C0133f0 c0133f0, MenuC2838l menuC2838l) {
        if (menuC2838l == null) {
            if (c0133f0 == null && i6 >= 0) {
                C0133f0[] c0133f0Arr = this.f318M;
                if (i6 < c0133f0Arr.length) {
                    c0133f0 = c0133f0Arr[i6];
                }
            }
            if (c0133f0 != null) {
                menuC2838l = c0133f0.f293h;
            }
        }
        if ((c0133f0 == null || c0133f0.f298m) && !this.f323R) {
            WindowCallbackC0171z windowCallbackC0171z = this.f343m;
            Window.Callback callback = this.f342l.getCallback();
            windowCallbackC0171z.getClass();
            try {
                windowCallbackC0171z.f485e = true;
                callback.onPanelClosed(i6, menuC2838l);
            } finally {
                windowCallbackC0171z.f485e = false;
            }
        }
    }

    public final void m405r(MenuC2838l menuC2838l) {
        C0225k c0225k;
        if (this.f317L) {
            return;
        }
        this.f317L = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f348r;
        actionBarOverlayLayout.m556k();
        ActionMenuView actionMenuView = ((C0284v3) actionBarOverlayLayout.f552e).f1098a.f827a;
        if (actionMenuView != null && (c0225k = actionMenuView.f580t) != null) {
            c0225k.m708c();
            C0195e c0195e = c0225k.f972u;
            if (c0195e != null && c0195e.m5855b()) {
                c0195e.f9763i.dismiss();
            }
        }
        Window.Callback callback = this.f342l.getCallback();
        if (callback != null && !this.f323R) {
            callback.onPanelClosed(108, menuC2838l);
        }
        this.f317L = false;
    }

    public final void m406s(C0133f0 c0133f0, boolean z7) {
        C0129d0 c0129d0;
        InterfaceC0217i1 interfaceC0217i1;
        if (z7 && c0133f0.f286a == 0 && (interfaceC0217i1 = this.f348r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0217i1;
            actionBarOverlayLayout.m556k();
            if (((C0284v3) actionBarOverlayLayout.f552e).f1098a.m624p()) {
                m405r(c0133f0.f293h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f341k.getSystemService("window");
        if (windowManager != null && c0133f0.f298m && (c0129d0 = c0133f0.f290e) != null) {
            windowManager.removeView(c0129d0);
            if (z7) {
                m404q(c0133f0.f286a, c0133f0, null);
            }
        }
        c0133f0.f296k = false;
        c0133f0.f297l = false;
        c0133f0.f298m = false;
        c0133f0.f291f = null;
        c0133f0.f299n = true;
        if (this.f319N == c0133f0) {
            this.f319N = null;
        }
        if (c0133f0.f286a == 0) {
            m392J();
        }
    }

    public final boolean m407u(KeyEvent keyEvent) {
        View decorView;
        boolean z7;
        boolean zM630v;
        boolean zM390H;
        ActionMenuView actionMenuView;
        C0225k c0225k;
        Object obj = this.f340j;
        if (((obj instanceof InterfaceC3133l) || (obj instanceof AbstractDialogC0139i0)) && (decorView = this.f342l.getDecorView()) != null && AbstractC2973a.m6019p(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82) {
            WindowCallbackC0171z windowCallbackC0171z = this.f343m;
            Window.Callback callback = this.f342l.getCallback();
            windowCallbackC0171z.getClass();
            try {
                windowCallbackC0171z.f484d = true;
                boolean zDispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                windowCallbackC0171z.f484d = false;
                if (zDispatchKeyEvent) {
                    return true;
                }
            } catch (Throwable th) {
                windowCallbackC0171z.f484d = false;
                throw th;
            }
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                this.f320O = (keyEvent.getFlags() & 128) != 0;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                C0133f0 c0133f0M383A = m383A(0);
                if (c0133f0M383A.f298m) {
                    return true;
                }
                m390H(c0133f0M383A, keyEvent);
                return true;
            }
        } else if (keyCode != 4) {
            if (keyCode == 82) {
                if (this.f351u != null) {
                    return true;
                }
                C0133f0 c0133f0M383A2 = m383A(0);
                InterfaceC0217i1 interfaceC0217i1 = this.f348r;
                Context context = this.f341k;
                if (interfaceC0217i1 != null) {
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0217i1;
                    actionBarOverlayLayout.m556k();
                    Toolbar toolbar = ((C0284v3) actionBarOverlayLayout.f552e).f1098a;
                    if (toolbar.getVisibility() != 0 || (actionMenuView = toolbar.f827a) == null || !actionMenuView.f579s || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                        z7 = c0133f0M383A2.f298m;
                        if (!z7 || c0133f0M383A2.f297l) {
                            m406s(c0133f0M383A2, true);
                            zM630v = z7;
                        } else {
                            if (c0133f0M383A2.f296k) {
                                if (c0133f0M383A2.f300o) {
                                    c0133f0M383A2.f296k = false;
                                    zM390H = m390H(c0133f0M383A2, keyEvent);
                                } else {
                                    zM390H = true;
                                }
                                if (zM390H) {
                                    m388F(c0133f0M383A2, keyEvent);
                                    zM630v = true;
                                }
                            }
                            zM630v = false;
                        }
                    } else {
                        ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.f348r;
                        actionBarOverlayLayout2.m556k();
                        if (((C0284v3) actionBarOverlayLayout2.f552e).f1098a.m624p()) {
                            ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.f348r;
                            actionBarOverlayLayout3.m556k();
                            ActionMenuView actionMenuView2 = ((C0284v3) actionBarOverlayLayout3.f552e).f1098a.f827a;
                            if (actionMenuView2 != null && (c0225k = actionMenuView2.f580t) != null && c0225k.m708c()) {
                                zM630v = true;
                            }
                        } else if (!this.f323R && m390H(c0133f0M383A2, keyEvent)) {
                            ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.f348r;
                            actionBarOverlayLayout4.m556k();
                            zM630v = ((C0284v3) actionBarOverlayLayout4.f552e).f1098a.m630v();
                        }
                        zM630v = false;
                    }
                } else {
                    z7 = c0133f0M383A2.f298m;
                    if (z7) {
                    }
                    m406s(c0133f0M383A2, true);
                    zM630v = z7;
                }
                if (!zM630v) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
            }
        } else if (m387E()) {
            return true;
        }
        return false;
    }

    public final void m408v(int i6) {
        C0133f0 c0133f0M383A = m383A(i6);
        if (c0133f0M383A.f293h != null) {
            Bundle bundle = new Bundle();
            c0133f0M383A.f293h.m5836u(bundle);
            if (bundle.size() > 0) {
                c0133f0M383A.f301p = bundle;
            }
            c0133f0M383A.f293h.m5840y();
            c0133f0M383A.f293h.clear();
        }
        c0133f0M383A.f300o = true;
        c0133f0M383A.f299n = true;
        if ((i6 == 108 || i6 == 0) && this.f348r != null) {
            C0133f0 c0133f0M383A2 = m383A(0);
            c0133f0M383A2.f296k = false;
            m390H(c0133f0M383A2, null);
        }
    }

    public final void m409w() {
        ViewGroup viewGroup;
        int i6 = 1;
        int i10 = 0;
        if (this.f306A) {
            return;
        }
        int[] iArr = AbstractC2341a.f8163k;
        Context context = this.f341k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            mo397g(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            mo397g(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            mo397g(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            mo397g(10);
        }
        this.f315J = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        m410x();
        this.f342l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f316K) {
            viewGroup = this.f314I ? (ViewGroup) layoutInflaterFrom.inflate(com.p2serv.android.p032ds.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.p2serv.android.p032ds.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f315J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.p2serv.android.p032ds.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f313H = false;
            this.f312G = false;
        } else if (this.f312G) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.p2serv.android.p032ds.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C2743d(context, typedValue.resourceId) : context).inflate(com.p2serv.android.p032ds.R.layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC0217i1 interfaceC0217i1 = (InterfaceC0217i1) viewGroup.findViewById(com.p2serv.android.p032ds.R.id.decor_content_parent);
            this.f348r = interfaceC0217i1;
            interfaceC0217i1.setWindowCallback(this.f342l.getCallback());
            if (this.f313H) {
                ((ActionBarOverlayLayout) this.f348r).m553h(109);
            }
            if (this.f310E) {
                ((ActionBarOverlayLayout) this.f348r).m553h(2);
            }
            if (this.f311F) {
                ((ActionBarOverlayLayout) this.f348r).m553h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f312G + ", windowActionBarOverlay: " + this.f313H + ", android:windowIsFloating: " + this.f315J + ", windowActionModeOverlay: " + this.f314I + ", windowNoTitle: " + this.f316K + " }");
        }
        C0158s c0158s = new C0158s(this, i10);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6182u(viewGroup, c0158s);
        if (this.f348r == null) {
            this.f308C = (TextView) viewGroup.findViewById(com.p2serv.android.p032ds.R.id.title);
        }
        Method method = AbstractC0189c4.f880a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException e5) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e5);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.p2serv.android.p032ds.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f342l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f342l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C0158s(this, i6));
        this.f307B = viewGroup;
        Object obj = this.f340j;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f347q;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC0217i1 interfaceC0217i2 = this.f348r;
            if (interfaceC0217i2 != null) {
                interfaceC0217i2.setWindowTitle(title);
            } else {
                AbstractC2973a abstractC2973a = this.f345o;
                if (abstractC2973a != null) {
                    abstractC2973a.mo455R(title);
                } else {
                    TextView textView = this.f308C;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f307B.findViewById(R.id.content);
        View decorView = this.f342l.getDecorView();
        contentFrameLayout2.f671g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f306A = true;
        C0133f0 c0133f0M383A = m383A(0);
        if (this.f323R || c0133f0M383A.f293h != null) {
            return;
        }
        m385C(108);
    }

    public final void m410x() {
        if (this.f342l == null) {
            Object obj = this.f340j;
            if (obj instanceof Activity) {
                m403o(((Activity) obj).getWindow());
            }
        }
        if (this.f342l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final AbstractC0127c0 m411y(Context context) {
        if (this.f329X == null) {
            if (C0026b.f52e == null) {
                Context applicationContext = context.getApplicationContext();
                C0026b.f52e = new C0026b(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f329X = new C0123a0(this, C0026b.f52e);
        }
        return this.f329X;
    }

    @Override
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
