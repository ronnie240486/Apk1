package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.C0280v;
import androidx.lifecycle.AbstractC0530j0;
import androidx.lifecycle.AbstractC0540o0;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0544q0;
import androidx.lifecycle.C0548s0;
import androidx.lifecycle.C0556w0;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.FragmentC0534l0;
import androidx.lifecycle.InterfaceC0512a1;
import androidx.lifecycle.InterfaceC0529j;
import androidx.lifecycle.InterfaceC0560y0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.AbstractC0004e;
import p000a.AbstractC0008i;
import p000a.C0002c;
import p000a.C0006g;
import p000a.C0007h;
import p000a.C0009j;
import p000a.C0016q;
import p000a.InterfaceC0017r;
import p000a.RunnableC0001b;
import p000a.RunnableC0005f;
import p012b.C1224a;
import p012b.InterfaceC1225b;
import p022c.InterfaceC1373b;
import p041d7.AbstractC2177c2;
import p094j0.AbstractC2754b;
import p095j1.C2767a;
import p095j1.C2768b;
import p103j9.AbstractC2796i;
import p109k3.C2888t;
import p124l6.C2982h;
import p128m0.InterfaceC3025a;
import p187r4.AbstractC3612b;
import p221u6.C3905e;
import p227v1.C3969a;
import p227v1.InterfaceC3973e;
import p249x4.C4112e;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements InterfaceC0512a1, InterfaceC0529j, InterfaceC3973e, InterfaceC0017r, InterfaceC1373b {

    public static final int f225q = 0;

    public final C1224a f226b = new C1224a();

    public final C2982h f227c = new C2982h(new RunnableC0001b(0, this));

    public final C0559y f228d;

    public final C2888t f229e;

    public C0562z0 f230f;

    public C0548s0 f231g;

    public final C0016q f232h;

    public final C0006g f233i;

    public final CopyOnWriteArrayList f234j;

    public final CopyOnWriteArrayList f235k;

    public final CopyOnWriteArrayList f236l;

    public final CopyOnWriteArrayList f237m;

    public final CopyOnWriteArrayList f238n;

    public boolean f239o;

    public boolean f240p;

    public ComponentActivity() {
        C0559y c0559y = new C0559y(this);
        this.f228d = c0559y;
        C2888t c2888t = new C2888t((InterfaceC3973e) this);
        this.f229e = c2888t;
        this.f232h = new C0016q(new RunnableC0005f(0, this));
        new AtomicInteger();
        this.f233i = new C0006g(this);
        this.f234j = new CopyOnWriteArrayList();
        this.f235k = new CopyOnWriteArrayList();
        this.f236l = new CopyOnWriteArrayList();
        this.f237m = new CopyOnWriteArrayList();
        this.f238n = new CopyOnWriteArrayList();
        this.f239o = false;
        this.f240p = false;
        int i6 = Build.VERSION.SDK_INT;
        c0559y.mo1508a(new C0007h(this, 0));
        c0559y.mo1508a(new C0007h(this, 1));
        c0559y.mo1508a(new C0007h(this, 2));
        c2888t.m5887d();
        EnumC0539o enumC0539o = c0559y.f2553d;
        if (enumC0539o != EnumC0539o.f2508b && enumC0539o != EnumC0539o.f2509c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        C0280v c0280v = (C0280v) c2888t.f9833d;
        if (c0280v.m788d() == null) {
            C0544q0 c0544q0 = new C0544q0(c0280v, this);
            c0280v.m790f("androidx.lifecycle.internal.SavedStateHandlesProvider", c0544q0);
            c0559y.mo1508a(new C3969a(2, c0544q0));
        }
        if (i6 <= 23) {
            C0007h c0007h = new C0007h();
            c0007h.f20b = this;
            c0559y.mo1508a(c0007h);
        }
        c0280v.m790f("android:support:activity-result", new C0002c(0, this));
        m361i(new InterfaceC1225b() {
            @Override
            public final void mo0a() {
                ComponentActivity componentActivity = this.f4a;
                Bundle bundleM787c = ((C0280v) componentActivity.f229e.f9833d).m787c("android:support:activity-result");
                if (bundleM787c != null) {
                    C0006g c0006g = componentActivity.f233i;
                    c0006g.getClass();
                    ArrayList<Integer> integerArrayList = bundleM787c.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleM787c.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    c0006g.f11e = bundleM787c.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    c0006g.f7a = (Random) bundleM787c.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    Bundle bundle = bundleM787c.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    Bundle bundle2 = c0006g.f14h;
                    bundle2.putAll(bundle);
                    for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                        String str = stringArrayList.get(i10);
                        HashMap map = c0006g.f9c;
                        boolean zContainsKey = map.containsKey(str);
                        HashMap map2 = c0006g.f8b;
                        if (zContainsKey) {
                            Integer num = (Integer) map.remove(str);
                            if (!bundle2.containsKey(str)) {
                                map2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i10);
                        num2.intValue();
                        String str2 = stringArrayList.get(i10);
                        map2.put(num2, str2);
                        map.put(str2, num2);
                    }
                }
            }
        });
    }

    @Override
    public final C0280v mo356a() {
        return (C0280v) this.f229e.f9833d;
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m362j();
        super.addContentView(view, layoutParams);
    }

    @Override
    public final InterfaceC0560y0 mo357c() {
        if (this.f231g == null) {
            this.f231g = new C0548s0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f231g;
    }

    @Override
    public final AbstractC2177c2 mo358d() {
        C2768b c2768b = new C2768b(C2767a.f9482b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = (LinkedHashMap) c2768b.f7850a;
        if (application != null) {
            linkedHashMap.put(C0556w0.f2543b, getApplication());
        }
        linkedHashMap.put(AbstractC0540o0.f2513a, this);
        linkedHashMap.put(AbstractC0540o0.f2514b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(AbstractC0540o0.f2515c, getIntent().getExtras());
        }
        return c2768b;
    }

    @Override
    public final C0562z0 mo359e() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f230f == null) {
            C0009j c0009j = (C0009j) getLastNonConfigurationInstance();
            if (c0009j != null) {
                this.f230f = c0009j.f21a;
            }
            if (this.f230f == null) {
                this.f230f = new C0562z0();
            }
        }
        return this.f230f;
    }

    @Override
    public final AbstractC0541p mo360f() {
        return this.f228d;
    }

    public final void m361i(InterfaceC1225b interfaceC1225b) {
        C1224a c1224a = this.f226b;
        if (((ComponentActivity) c1224a.f3908a) != null) {
            interfaceC1225b.mo0a();
        }
        ((CopyOnWriteArraySet) c1224a.f3909b).add(interfaceC1225b);
    }

    public final void m362j() {
        View decorView = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView, "<this>");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView2, "<this>");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView3, "<this>");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        AbstractC2796i.m5785f(decorView4, "<this>");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override
    public void onActivityResult(int i6, int i10, Intent intent) {
        if (this.f233i.m33a(i6, i10, intent)) {
            return;
        }
        super.onActivityResult(i6, i10, intent);
    }

    @Override
    public void onBackPressed() {
        this.f232h.m50c();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f234j.iterator();
        while (it.hasNext()) {
            ((InterfaceC3025a) it.next()).accept(configuration);
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.f229e.m5888e(bundle);
        C1224a c1224a = this.f226b;
        c1224a.f3908a = this;
        Iterator it = ((CopyOnWriteArraySet) c1224a.f3909b).iterator();
        while (it.hasNext()) {
            ((InterfaceC1225b) it.next()).mo0a();
        }
        super.onCreate(bundle);
        int i6 = FragmentC0534l0.f2495b;
        AbstractC0530j0.m1497b(this);
        if (AbstractC2754b.m5721a()) {
            C0016q c0016q = this.f232h;
            c0016q.f36f = AbstractC0008i.m35a(this);
            c0016q.m51d();
        }
    }

    @Override
    public boolean onCreatePanelMenu(int i6, Menu menu) {
        if (i6 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i6, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f227c.f10226c).iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        if (super.onMenuItemSelected(i6, menuItem)) {
            return true;
        }
        if (i6 != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.f227c.f10226c).iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        return false;
    }

    @Override
    public void onMultiWindowModeChanged(boolean z7) {
        if (this.f239o) {
            return;
        }
        Iterator it = this.f237m.iterator();
        while (it.hasNext()) {
            ((InterfaceC3025a) it.next()).accept(new C4112e(1));
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f236l.iterator();
        while (it.hasNext()) {
            ((InterfaceC3025a) it.next()).accept(intent);
        }
    }

    @Override
    public void onPanelClosed(int i6, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f227c.f10226c).iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        super.onPanelClosed(i6, menu);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean z7) {
        if (this.f240p) {
            return;
        }
        Iterator it = this.f238n.iterator();
        while (it.hasNext()) {
            ((InterfaceC3025a) it.next()).accept(new C3905e(2));
        }
    }

    @Override
    public boolean onPreparePanel(int i6, View view, Menu menu) {
        if (i6 != 0) {
            return true;
        }
        super.onPreparePanel(i6, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f227c.f10226c).iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        if (this.f233i.m33a(i6, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i6, strArr, iArr);
    }

    @Override
    public final Object onRetainNonConfigurationInstance() {
        C0009j c0009j;
        C0562z0 c0562z0 = this.f230f;
        if (c0562z0 == null && (c0009j = (C0009j) getLastNonConfigurationInstance()) != null) {
            c0562z0 = c0009j.f21a;
        }
        if (c0562z0 == null) {
            return null;
        }
        C0009j c0009j2 = new C0009j();
        c0009j2.f21a = c0562z0;
        return c0009j2;
    }

    @Override
    public final void onSaveInstanceState(Bundle bundle) {
        C0559y c0559y = this.f228d;
        if (c0559y instanceof C0559y) {
            c0559y.m1523h();
        }
        super.onSaveInstanceState(bundle);
        this.f229e.m5889f(bundle);
    }

    @Override
    public final void onTrimMemory(int i6) {
        super.onTrimMemory(i6);
        Iterator it = this.f235k.iterator();
        while (it.hasNext()) {
            ((InterfaceC3025a) it.next()).accept(Integer.valueOf(i6));
        }
    }

    @Override
    public final void reportFullyDrawn() {
        try {
            if (AbstractC3612b.m7252B()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    @Override
    public void setContentView(int i6) {
        m362j();
        super.setContentView(i6);
    }

    @Override
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        m362j();
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m362j();
        super.setContentView(view, layoutParams);
    }

    @Override
    public final void onMultiWindowModeChanged(boolean z7, Configuration configuration) {
        this.f239o = true;
        try {
            super.onMultiWindowModeChanged(z7, configuration);
            this.f239o = false;
            for (InterfaceC3025a interfaceC3025a : this.f237m) {
                AbstractC2796i.m5785f(configuration, "newConfig");
                interfaceC3025a.accept(new C4112e(1));
            }
        } catch (Throwable th) {
            this.f239o = false;
            throw th;
        }
    }

    @Override
    public final void onPictureInPictureModeChanged(boolean z7, Configuration configuration) {
        this.f240p = true;
        try {
            super.onPictureInPictureModeChanged(z7, configuration);
            this.f240p = false;
            for (InterfaceC3025a interfaceC3025a : this.f238n) {
                AbstractC2796i.m5785f(configuration, "newConfig");
                interfaceC3025a.accept(new C3905e(2));
            }
        } catch (Throwable th) {
            this.f240p = false;
            throw th;
        }
    }
}
