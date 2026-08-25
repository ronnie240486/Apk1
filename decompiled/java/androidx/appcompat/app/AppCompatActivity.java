package androidx.appcompat.app;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AbstractC0177a4;
import androidx.appcompat.widget.C0280v;
import androidx.appcompat.widget.C0285w;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Objects;
import p003a2.AbstractC0032a;
import p046e0.AbstractC2343b;
import p093j.C2743d;
import p093j.C2748i;
import p094j0.AbstractC2754b;
import p094j0.C2761i;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p143n5.AbstractC3198d;

public class AppCompatActivity extends FragmentActivity implements InterfaceC0146m {

    public LayoutInflaterFactory2C0135g0 f250w;

    public AppCompatActivity() {
        ((C0280v) this.f229e.f9833d).m790f("androidx:appcompat", new C0142k(this));
        m361i(new C0144l(this));
    }

    @Override
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m366o();
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        layoutInflaterFactory2C0135g0.m409w();
        ((ViewGroup) layoutInflaterFactory2C0135g0.f307B.findViewById(R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C0135g0.f343m.m525a(layoutInflaterFactory2C0135g0.f342l.getCallback());
    }

    @Override
    public void attachBaseContext(Context context) {
        int i6;
        Configuration configuration;
        Configuration configuration2;
        C2743d c2743d;
        float f;
        float f3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        layoutInflaterFactory2C0135g0.f321P = true;
        int i46 = layoutInflaterFactory2C0135g0.f325T;
        if (i46 == -100) {
            i46 = AbstractC0154q.f416b;
        }
        int iM386D = layoutInflaterFactory2C0135g0.m386D(context, i46);
        if (AbstractC0154q.m437c(context) && AbstractC0154q.m437c(context)) {
            if (!AbstractC2754b.m5721a()) {
                synchronized (AbstractC0154q.f423i) {
                    try {
                        C2761i c2761i = AbstractC0154q.f417c;
                        if (c2761i == null) {
                            if (AbstractC0154q.f418d == null) {
                                AbstractC0154q.f418d = C2761i.m5733b(AbstractC3198d.m6437L(context));
                            }
                            if (!AbstractC0154q.f418d.f9475a.isEmpty()) {
                                AbstractC0154q.f417c = AbstractC0154q.f418d;
                            }
                        } else if (!c2761i.equals(AbstractC0154q.f418d)) {
                            C2761i c2761i2 = AbstractC0154q.f417c;
                            AbstractC0154q.f418d = c2761i2;
                            AbstractC3198d.m6430E(context, c2761i2.f9475a.mo5734a());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (!AbstractC0154q.f420f) {
                AbstractC0154q.f415a.execute(new RunnableC0148n(context, 0));
            }
        }
        C2761i c2761iM380p = LayoutInflaterFactory2C0135g0.m380p(context);
        Configuration configuration3 = null;
        if (LayoutInflaterFactory2C0135g0.f305m0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(LayoutInflaterFactory2C0135g0.m381t(context, iM386D, c2761iM380p, null, false));
            } catch (IllegalStateException unused) {
                if (context instanceof C2743d) {
                    ((C2743d) context).m5708a(LayoutInflaterFactory2C0135g0.m381t(context, iM386D, c2761iM380p, null, false));
                } else if (LayoutInflaterFactory2C0135g0.f304l0) {
                    i6 = Build.VERSION.SDK_INT;
                    Configuration configuration4 = new Configuration();
                    configuration4.uiMode = -1;
                    configuration4.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration4).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (!configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f3 = configuration2.fontScale;
                            if (f != f3) {
                                configuration3.fontScale = f3;
                            }
                            i10 = configuration.mcc;
                            i11 = configuration2.mcc;
                            if (i10 != i11) {
                                configuration3.mcc = i11;
                            }
                            i12 = configuration.mnc;
                            i13 = configuration2.mnc;
                            if (i12 != i13) {
                                configuration3.mnc = i13;
                            }
                            if (i6 >= 24) {
                                AbstractC0166w.m469a(configuration, configuration2, configuration3);
                            } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                                configuration3.locale = configuration2.locale;
                            }
                            i14 = configuration.touchscreen;
                            i15 = configuration2.touchscreen;
                            if (i14 != i15) {
                                configuration3.touchscreen = i15;
                            }
                            i16 = configuration.keyboard;
                            i17 = configuration2.keyboard;
                            if (i16 != i17) {
                                configuration3.keyboard = i17;
                            }
                            i18 = configuration.keyboardHidden;
                            i19 = configuration2.keyboardHidden;
                            if (i18 != i19) {
                                configuration3.keyboardHidden = i19;
                            }
                            i20 = configuration.navigation;
                            i21 = configuration2.navigation;
                            if (i20 != i21) {
                                configuration3.navigation = i21;
                            }
                            i22 = configuration.navigationHidden;
                            i23 = configuration2.navigationHidden;
                            if (i22 != i23) {
                                configuration3.navigationHidden = i23;
                            }
                            i24 = configuration.orientation;
                            i25 = configuration2.orientation;
                            if (i24 != i25) {
                                configuration3.orientation = i25;
                            }
                            i26 = configuration.screenLayout & 15;
                            i27 = configuration2.screenLayout & 15;
                            if (i26 != i27) {
                                configuration3.screenLayout |= i27;
                            }
                            i28 = configuration.screenLayout & 192;
                            i29 = configuration2.screenLayout & 192;
                            if (i28 != i29) {
                                configuration3.screenLayout |= i29;
                            }
                            i30 = configuration.screenLayout & 48;
                            i31 = configuration2.screenLayout & 48;
                            if (i30 != i31) {
                                configuration3.screenLayout |= i31;
                            }
                            i32 = configuration.screenLayout & 768;
                            i33 = configuration2.screenLayout & 768;
                            if (i32 != i33) {
                                configuration3.screenLayout |= i33;
                            }
                            if (i6 >= 26) {
                                if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                                    configuration3.colorMode |= configuration2.colorMode & 3;
                                }
                                if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                                    configuration3.colorMode |= configuration2.colorMode & 12;
                                }
                            }
                            i34 = configuration.uiMode & 15;
                            i35 = configuration2.uiMode & 15;
                            if (i34 != i35) {
                                configuration3.uiMode |= i35;
                            }
                            i36 = configuration.uiMode & 48;
                            i37 = configuration2.uiMode & 48;
                            if (i36 != i37) {
                                configuration3.uiMode |= i37;
                            }
                            i38 = configuration.screenWidthDp;
                            i39 = configuration2.screenWidthDp;
                            if (i38 != i39) {
                                configuration3.screenWidthDp = i39;
                            }
                            i40 = configuration.screenHeightDp;
                            i41 = configuration2.screenHeightDp;
                            if (i40 != i41) {
                                configuration3.screenHeightDp = i41;
                            }
                            i42 = configuration.smallestScreenWidthDp;
                            i43 = configuration2.smallestScreenWidthDp;
                            if (i42 != i43) {
                                configuration3.smallestScreenWidthDp = i43;
                            }
                            i44 = configuration.densityDpi;
                            i45 = configuration2.densityDpi;
                            if (i44 != i45) {
                                configuration3.densityDpi = i45;
                            }
                        }
                    }
                    Configuration configurationM381t = LayoutInflaterFactory2C0135g0.m381t(context, iM386D, c2761iM380p, configuration3, true);
                    c2743d = new C2743d(context, com.p2serv.android.p032ds.R.style.Theme_AppCompat_Empty);
                    c2743d.m5708a(configurationM381t);
                    if (context.getTheme() != null) {
                        AbstractC2343b.m5325m(c2743d.getTheme());
                    }
                    context = c2743d;
                }
            }
        } else if (context instanceof C2743d) {
            try {
                ((C2743d) context).m5708a(LayoutInflaterFactory2C0135g0.m381t(context, iM386D, c2761iM380p, null, false));
            } catch (IllegalStateException unused2) {
                if (LayoutInflaterFactory2C0135g0.f304l0) {
                    i6 = Build.VERSION.SDK_INT;
                    Configuration configuration5 = new Configuration();
                    configuration5.uiMode = -1;
                    configuration5.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration5).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (!configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f3 = configuration2.fontScale;
                            if (f != f3) {
                                configuration3.fontScale = f3;
                            }
                            i10 = configuration.mcc;
                            i11 = configuration2.mcc;
                            if (i10 != i11) {
                                configuration3.mcc = i11;
                            }
                            i12 = configuration.mnc;
                            i13 = configuration2.mnc;
                            if (i12 != i13) {
                                configuration3.mnc = i13;
                            }
                            if (i6 >= 24) {
                                AbstractC0166w.m469a(configuration, configuration2, configuration3);
                            } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                                configuration3.locale = configuration2.locale;
                            }
                            i14 = configuration.touchscreen;
                            i15 = configuration2.touchscreen;
                            if (i14 != i15) {
                                configuration3.touchscreen = i15;
                            }
                            i16 = configuration.keyboard;
                            i17 = configuration2.keyboard;
                            if (i16 != i17) {
                                configuration3.keyboard = i17;
                            }
                            i18 = configuration.keyboardHidden;
                            i19 = configuration2.keyboardHidden;
                            if (i18 != i19) {
                                configuration3.keyboardHidden = i19;
                            }
                            i20 = configuration.navigation;
                            i21 = configuration2.navigation;
                            if (i20 != i21) {
                                configuration3.navigation = i21;
                            }
                            i22 = configuration.navigationHidden;
                            i23 = configuration2.navigationHidden;
                            if (i22 != i23) {
                                configuration3.navigationHidden = i23;
                            }
                            i24 = configuration.orientation;
                            i25 = configuration2.orientation;
                            if (i24 != i25) {
                                configuration3.orientation = i25;
                            }
                            i26 = configuration.screenLayout & 15;
                            i27 = configuration2.screenLayout & 15;
                            if (i26 != i27) {
                                configuration3.screenLayout |= i27;
                            }
                            i28 = configuration.screenLayout & 192;
                            i29 = configuration2.screenLayout & 192;
                            if (i28 != i29) {
                                configuration3.screenLayout |= i29;
                            }
                            i30 = configuration.screenLayout & 48;
                            i31 = configuration2.screenLayout & 48;
                            if (i30 != i31) {
                                configuration3.screenLayout |= i31;
                            }
                            i32 = configuration.screenLayout & 768;
                            i33 = configuration2.screenLayout & 768;
                            if (i32 != i33) {
                                configuration3.screenLayout |= i33;
                            }
                            if (i6 >= 26) {
                                if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                                    configuration3.colorMode |= configuration2.colorMode & 3;
                                }
                                if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                                    configuration3.colorMode |= configuration2.colorMode & 12;
                                }
                            }
                            i34 = configuration.uiMode & 15;
                            i35 = configuration2.uiMode & 15;
                            if (i34 != i35) {
                                configuration3.uiMode |= i35;
                            }
                            i36 = configuration.uiMode & 48;
                            i37 = configuration2.uiMode & 48;
                            if (i36 != i37) {
                                configuration3.uiMode |= i37;
                            }
                            i38 = configuration.screenWidthDp;
                            i39 = configuration2.screenWidthDp;
                            if (i38 != i39) {
                                configuration3.screenWidthDp = i39;
                            }
                            i40 = configuration.screenHeightDp;
                            i41 = configuration2.screenHeightDp;
                            if (i40 != i41) {
                                configuration3.screenHeightDp = i41;
                            }
                            i42 = configuration.smallestScreenWidthDp;
                            i43 = configuration2.smallestScreenWidthDp;
                            if (i42 != i43) {
                                configuration3.smallestScreenWidthDp = i43;
                            }
                            i44 = configuration.densityDpi;
                            i45 = configuration2.densityDpi;
                            if (i44 != i45) {
                                configuration3.densityDpi = i45;
                            }
                        }
                    }
                    Configuration configurationM381t2 = LayoutInflaterFactory2C0135g0.m381t(context, iM386D, c2761iM380p, configuration3, true);
                    c2743d = new C2743d(context, com.p2serv.android.p032ds.R.style.Theme_AppCompat_Empty);
                    c2743d.m5708a(configurationM381t2);
                    try {
                        if (context.getTheme() != null) {
                            AbstractC2343b.m5325m(c2743d.getTheme());
                        }
                    } catch (NullPointerException unused3) {
                    }
                    context = c2743d;
                }
            }
        } else if (LayoutInflaterFactory2C0135g0.f304l0) {
            i6 = Build.VERSION.SDK_INT;
            Configuration configuration6 = new Configuration();
            configuration6.uiMode = -1;
            configuration6.fontScale = 0.0f;
            configuration = context.createConfigurationContext(configuration6).getResources().getConfiguration();
            configuration2 = context.getResources().getConfiguration();
            configuration.uiMode = configuration2.uiMode;
            if (!configuration.equals(configuration2)) {
                configuration3 = new Configuration();
                configuration3.fontScale = 0.0f;
                if (configuration.diff(configuration2) != 0) {
                    f = configuration.fontScale;
                    f3 = configuration2.fontScale;
                    if (f != f3) {
                        configuration3.fontScale = f3;
                    }
                    i10 = configuration.mcc;
                    i11 = configuration2.mcc;
                    if (i10 != i11) {
                        configuration3.mcc = i11;
                    }
                    i12 = configuration.mnc;
                    i13 = configuration2.mnc;
                    if (i12 != i13) {
                        configuration3.mnc = i13;
                    }
                    if (i6 >= 24) {
                        AbstractC0166w.m469a(configuration, configuration2, configuration3);
                    } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                        configuration3.locale = configuration2.locale;
                    }
                    i14 = configuration.touchscreen;
                    i15 = configuration2.touchscreen;
                    if (i14 != i15) {
                        configuration3.touchscreen = i15;
                    }
                    i16 = configuration.keyboard;
                    i17 = configuration2.keyboard;
                    if (i16 != i17) {
                        configuration3.keyboard = i17;
                    }
                    i18 = configuration.keyboardHidden;
                    i19 = configuration2.keyboardHidden;
                    if (i18 != i19) {
                        configuration3.keyboardHidden = i19;
                    }
                    i20 = configuration.navigation;
                    i21 = configuration2.navigation;
                    if (i20 != i21) {
                        configuration3.navigation = i21;
                    }
                    i22 = configuration.navigationHidden;
                    i23 = configuration2.navigationHidden;
                    if (i22 != i23) {
                        configuration3.navigationHidden = i23;
                    }
                    i24 = configuration.orientation;
                    i25 = configuration2.orientation;
                    if (i24 != i25) {
                        configuration3.orientation = i25;
                    }
                    i26 = configuration.screenLayout & 15;
                    i27 = configuration2.screenLayout & 15;
                    if (i26 != i27) {
                        configuration3.screenLayout |= i27;
                    }
                    i28 = configuration.screenLayout & 192;
                    i29 = configuration2.screenLayout & 192;
                    if (i28 != i29) {
                        configuration3.screenLayout |= i29;
                    }
                    i30 = configuration.screenLayout & 48;
                    i31 = configuration2.screenLayout & 48;
                    if (i30 != i31) {
                        configuration3.screenLayout |= i31;
                    }
                    i32 = configuration.screenLayout & 768;
                    i33 = configuration2.screenLayout & 768;
                    if (i32 != i33) {
                        configuration3.screenLayout |= i33;
                    }
                    if (i6 >= 26) {
                        if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                            configuration3.colorMode |= configuration2.colorMode & 3;
                        }
                        if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                            configuration3.colorMode |= configuration2.colorMode & 12;
                        }
                    }
                    i34 = configuration.uiMode & 15;
                    i35 = configuration2.uiMode & 15;
                    if (i34 != i35) {
                        configuration3.uiMode |= i35;
                    }
                    i36 = configuration.uiMode & 48;
                    i37 = configuration2.uiMode & 48;
                    if (i36 != i37) {
                        configuration3.uiMode |= i37;
                    }
                    i38 = configuration.screenWidthDp;
                    i39 = configuration2.screenWidthDp;
                    if (i38 != i39) {
                        configuration3.screenWidthDp = i39;
                    }
                    i40 = configuration.screenHeightDp;
                    i41 = configuration2.screenHeightDp;
                    if (i40 != i41) {
                        configuration3.screenHeightDp = i41;
                    }
                    i42 = configuration.smallestScreenWidthDp;
                    i43 = configuration2.smallestScreenWidthDp;
                    if (i42 != i43) {
                        configuration3.smallestScreenWidthDp = i43;
                    }
                    i44 = configuration.densityDpi;
                    i45 = configuration2.densityDpi;
                    if (i44 != i45) {
                        configuration3.densityDpi = i45;
                    }
                }
            }
            Configuration configurationM381t3 = LayoutInflaterFactory2C0135g0.m381t(context, iM386D, c2761iM380p, configuration3, true);
            c2743d = new C2743d(context, com.p2serv.android.p032ds.R.style.Theme_AppCompat_Empty);
            c2743d.m5708a(configurationM381t3);
            if (context.getTheme() != null) {
                AbstractC2343b.m5325m(c2743d.getTheme());
            }
            context = c2743d;
        }
        super.attachBaseContext(context);
    }

    @Override
    public final void closeOptionsMenu() {
        AbstractC2973a abstractC2973aM365n = m365n();
        if (getWindow().hasFeature(0)) {
            if (abstractC2973aM365n == null || !abstractC2973aM365n.mo457h()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC2973a abstractC2973aM365n = m365n();
        if (keyCode == 82 && abstractC2973aM365n != null && abstractC2973aM365n.mo447G(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public final View findViewById(int i6) {
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        layoutInflaterFactory2C0135g0.m409w();
        return layoutInflaterFactory2C0135g0.f342l.findViewById(i6);
    }

    @Override
    public final void mo363g() {
        m364m().mo394b();
    }

    @Override
    public final MenuInflater getMenuInflater() {
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        if (layoutInflaterFactory2C0135g0.f346p == null) {
            layoutInflaterFactory2C0135g0.m384B();
            AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
            layoutInflaterFactory2C0135g0.f346p = new C2748i(abstractC2973a != null ? abstractC2973a.mo461v() : layoutInflaterFactory2C0135g0.f341k);
        }
        return layoutInflaterFactory2C0135g0.f346p;
    }

    @Override
    public Resources getResources() {
        int i6 = AbstractC0177a4.f868a;
        return super.getResources();
    }

    @Override
    public final void invalidateOptionsMenu() {
        m364m().mo394b();
    }

    public final AbstractC0154q m364m() {
        if (this.f250w == null) {
            ExecutorC0149n0 executorC0149n0 = AbstractC0154q.f415a;
            this.f250w = new LayoutInflaterFactory2C0135g0(this, null, this, this);
        }
        return this.f250w;
    }

    public final AbstractC2973a m365n() {
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        layoutInflaterFactory2C0135g0.m384B();
        return layoutInflaterFactory2C0135g0.f345o;
    }

    public final void m366o() {
        View decorView = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView, "<this>");
        decorView.setTag(com.p2serv.android.p032ds.R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView2, "<this>");
        decorView2.setTag(com.p2serv.android.p032ds.R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView3, "<this>");
        decorView3.setTag(com.p2serv.android.p032ds.R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView4, "<this>");
        decorView4.setTag(com.p2serv.android.p032ds.R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) throws IllegalAccessException {
        super.onConfigurationChanged(configuration);
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        if (layoutInflaterFactory2C0135g0.f312G && layoutInflaterFactory2C0135g0.f306A) {
            layoutInflaterFactory2C0135g0.m384B();
            AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
            if (abstractC2973a != null) {
                abstractC2973a.mo444B();
            }
        }
        C0285w c0285wM801a = C0285w.m801a();
        Context context = layoutInflaterFactory2C0135g0.f341k;
        synchronized (c0285wM801a) {
            c0285wM801a.f1115a.m731l(context);
        }
        layoutInflaterFactory2C0135g0.f324S = new Configuration(layoutInflaterFactory2C0135g0.f341k.getResources().getConfiguration());
        layoutInflaterFactory2C0135g0.m402m(false, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        m364m().mo396e();
    }

    @Override
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i6, keyEvent);
        }
        return true;
    }

    @Override
    public final boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        Intent intentM149A;
        if (super.onMenuItemSelected(i6, menuItem)) {
            return true;
        }
        AbstractC2973a abstractC2973aM365n = m365n();
        if (menuItem.getItemId() != 16908332 || abstractC2973aM365n == null || (abstractC2973aM365n.mo460u() & 4) == 0 || (intentM149A = AbstractC0032a.m149A(this)) == null) {
            return false;
        }
        if (!shouldUpRecreateTask(intentM149A)) {
            navigateUpTo(intentM149A);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        Intent intentM149A2 = AbstractC0032a.m149A(this);
        if (intentM149A2 == null) {
            intentM149A2 = AbstractC0032a.m149A(this);
        }
        if (intentM149A2 != null) {
            ComponentName component = intentM149A2.getComponent();
            if (component == null) {
                component = intentM149A2.resolveActivity(getPackageManager());
            }
            int size = arrayList.size();
            try {
                Intent intentM172z = AbstractC0032a.m172z(this, component);
                while (intentM172z != null) {
                    arrayList.add(size, intentM172z);
                    intentM172z = AbstractC0032a.m172z(this, intentM172z.getComponent());
                }
                arrayList.add(intentM149A2);
            } catch (PackageManager.NameNotFoundException e5) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e5);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        startActivities(intentArr, null);
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((LayoutInflaterFactory2C0135g0) m364m()).m409w();
    }

    @Override
    public final void onPostResume() {
        super.onPostResume();
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        layoutInflaterFactory2C0135g0.m384B();
        AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
        if (abstractC2973a != null) {
            abstractC2973a.mo452N(true);
        }
    }

    @Override
    public void onStart() throws IllegalAccessException {
        super.onStart();
        ((LayoutInflaterFactory2C0135g0) m364m()).m402m(true, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) m364m();
        layoutInflaterFactory2C0135g0.m384B();
        AbstractC2973a abstractC2973a = layoutInflaterFactory2C0135g0.f345o;
        if (abstractC2973a != null) {
            abstractC2973a.mo452N(false);
        }
    }

    @Override
    public final void onTitleChanged(CharSequence charSequence, int i6) {
        super.onTitleChanged(charSequence, i6);
        m364m().mo401l(charSequence);
    }

    @Override
    public final void openOptionsMenu() {
        AbstractC2973a abstractC2973aM365n = m365n();
        if (getWindow().hasFeature(0)) {
            if (abstractC2973aM365n == null || !abstractC2973aM365n.mo448H()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override
    public final void setContentView(int i6) {
        m366o();
        m364m().mo398h(i6);
    }

    @Override
    public final void setTheme(int i6) {
        super.setTheme(i6);
        ((LayoutInflaterFactory2C0135g0) m364m()).f326U = i6;
    }

    @Override
    public void setContentView(View view) {
        m366o();
        m364m().mo399i(view);
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m366o();
        m364m().mo400k(view, layoutParams);
    }

    @Override
    public final void onContentChanged() {
    }
}
