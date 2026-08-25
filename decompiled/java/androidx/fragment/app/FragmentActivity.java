package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.C0280v;
import androidx.core.app.InterfaceC0316b;
import androidx.core.app.InterfaceC0319c;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.EnumC0539o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p007a7.C0069f;

public class FragmentActivity extends ComponentActivity implements InterfaceC0316b, InterfaceC0319c {

    public boolean f1767t;

    public boolean f1768u;

    public final C0397d f1765r = new C0397d(2, new C0433v(this));

    public final C0559y f1766s = new C0559y(this);

    public boolean f1769v = true;

    public FragmentActivity() {
        ((C0280v) this.f229e.f9833d).m790f("android:support:fragments", new C0429t(this));
        m361i(new C0431u(this));
    }

    public static boolean m1183l(AbstractC0410j0 abstractC0410j0) {
        boolean zM1183l = false;
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : abstractC0410j0.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                C0433v c0433v = abstractComponentCallbacksC0427s.f1983t;
                if ((c0433v == null ? null : c0433v.f2006j) != null) {
                    zM1183l |= m1183l(abstractComponentCallbacksC0427s.m1320i());
                }
                C0428s0 c0428s0 = abstractComponentCallbacksC0427s.f1959N;
                EnumC0539o enumC0539o = EnumC0539o.f2510d;
                if (c0428s0 != null) {
                    c0428s0.m1334g();
                    if (c0428s0.f1993d.f2553d.compareTo(enumC0539o) >= 0) {
                        abstractComponentCallbacksC0427s.f1959N.f1993d.m1523h();
                        zM1183l = true;
                    }
                }
                if (abstractComponentCallbacksC0427s.f1958M.f2553d.compareTo(enumC0539o) >= 0) {
                    abstractComponentCallbacksC0427s.f1958M.m1523h();
                    zM1183l = true;
                }
            }
        }
        return zM1183l;
    }

    @Override
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1767t);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1768u);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1769v);
        if (getApplication() != null) {
            new C0069f(this, mo359e()).m249z(str2, printWriter);
        }
        ((C0433v) this.f1765r.f1833b).f2005i.m1256r(str, fileDescriptor, printWriter, strArr);
    }

    public final C0412k0 m1184k() {
        return ((C0433v) this.f1765r.f1833b).f2005i;
    }

    @Override
    public final void onActivityResult(int i6, int i10, Intent intent) {
        this.f1765r.m1199b();
        super.onActivityResult(i6, i10, intent);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        C0397d c0397d = this.f1765r;
        c0397d.m1199b();
        super.onConfigurationChanged(configuration);
        ((C0433v) c0397d.f1833b).f2005i.m1246h(configuration);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1766s.m1521f(EnumC0537n.ON_CREATE);
        C0412k0 c0412k0 = ((C0433v) this.f1765r.f1833b).f2005i;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(1);
    }

    @Override
    public final boolean onCreatePanelMenu(int i6, Menu menu) {
        if (i6 != 0) {
            super.onCreatePanelMenu(i6, menu);
            return true;
        }
        super.onCreatePanelMenu(i6, menu);
        getMenuInflater();
        ((C0433v) this.f1765r.f1833b).f2005i.m1248j();
        return true;
    }

    @Override
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((C0433v) this.f1765r.f1833b).f2005i.f1866f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((C0433v) this.f1765r.f1833b).f2005i.m1249k();
        this.f1766s.m1521f(EnumC0537n.ON_DESTROY);
    }

    @Override
    public final void onLowMemory() {
        super.onLowMemory();
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : ((C0433v) this.f1765r.f1833b).f2005i.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.m1308G();
            }
        }
    }

    @Override
    public boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        if (super.onMenuItemSelected(i6, menuItem)) {
            return true;
        }
        C0397d c0397d = this.f1765r;
        if (i6 == 0) {
            return ((C0433v) c0397d.f1833b).f2005i.m1250l();
        }
        if (i6 != 6) {
            return false;
        }
        return ((C0433v) c0397d.f1833b).f2005i.m1247i();
    }

    @Override
    public final void onMultiWindowModeChanged(boolean z7) {
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : ((C0433v) this.f1765r.f1833b).f2005i.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.m1309H(z7);
            }
        }
    }

    @Override
    public final void onNewIntent(Intent intent) {
        this.f1765r.m1199b();
        super.onNewIntent(intent);
    }

    @Override
    public void onPanelClosed(int i6, Menu menu) {
        if (i6 == 0) {
            ((C0433v) this.f1765r.f1833b).f2005i.m1251m();
        }
        super.onPanelClosed(i6, menu);
    }

    @Override
    public void onPause() {
        super.onPause();
        this.f1768u = false;
        ((C0433v) this.f1765r.f1833b).f2005i.m1254p(5);
        this.f1766s.m1521f(EnumC0537n.ON_PAUSE);
    }

    @Override
    public final void onPictureInPictureModeChanged(boolean z7) {
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : ((C0433v) this.f1765r.f1833b).f2005i.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.m1310I(z7);
            }
        }
    }

    @Override
    public void onPostResume() {
        super.onPostResume();
        this.f1766s.m1521f(EnumC0537n.ON_RESUME);
        C0412k0 c0412k0 = ((C0433v) this.f1765r.f1833b).f2005i;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(7);
    }

    @Override
    public final boolean onPreparePanel(int i6, View view, Menu menu) {
        if (i6 != 0) {
            super.onPreparePanel(i6, view, menu);
            return true;
        }
        super.onPreparePanel(0, view, menu);
        ((C0433v) this.f1765r.f1833b).f2005i.m1253o();
        return true;
    }

    @Override
    public final void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        this.f1765r.m1199b();
        super.onRequestPermissionsResult(i6, strArr, iArr);
    }

    @Override
    public void onResume() {
        C0397d c0397d = this.f1765r;
        c0397d.m1199b();
        super.onResume();
        this.f1768u = true;
        ((C0433v) c0397d.f1833b).f2005i.m1259u(true);
    }

    @Override
    public void onStart() {
        C0397d c0397d = this.f1765r;
        c0397d.m1199b();
        super.onStart();
        this.f1769v = false;
        boolean z7 = this.f1767t;
        C0433v c0433v = (C0433v) c0397d.f1833b;
        if (!z7) {
            this.f1767t = true;
            C0412k0 c0412k0 = c0433v.f2005i;
            c0412k0.f1885y = false;
            c0412k0.f1886z = false;
            c0412k0.f1859F.f1896i = false;
            c0412k0.m1254p(4);
        }
        c0433v.f2005i.m1259u(true);
        this.f1766s.m1521f(EnumC0537n.ON_START);
        C0412k0 c0412k1 = c0433v.f2005i;
        c0412k1.f1885y = false;
        c0412k1.f1886z = false;
        c0412k1.f1859F.f1896i = false;
        c0412k1.m1254p(5);
    }

    @Override
    public final void onStateNotSaved() {
        this.f1765r.m1199b();
    }

    @Override
    public void onStop() {
        super.onStop();
        this.f1769v = true;
        while (m1183l(m1184k())) {
        }
        C0412k0 c0412k0 = ((C0433v) this.f1765r.f1833b).f2005i;
        c0412k0.f1886z = true;
        c0412k0.f1859F.f1896i = true;
        c0412k0.m1254p(4);
        this.f1766s.m1521f(EnumC0537n.ON_STOP);
    }

    @Override
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((C0433v) this.f1765r.f1833b).f2005i.f1866f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }
}
