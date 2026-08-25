package p001a0;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcel;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.C0155q0;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0225k;
import androidx.appcompat.widget.C0249o3;
import androidx.appcompat.widget.InterfaceC0240n;
import androidx.appcompat.widget.InterfaceC0264r3;
import androidx.appcompat.widget.InterfaceC0296y0;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.media3.common.C0565C;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.button.InterfaceC1769a;
import com.google.android.material.internal.InterfaceC1820f;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.navigation.AbstractC1852l;
import com.google.android.material.navigation.NavigationView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.AbstractC0004e;
import p007a7.C0069f;
import p016b3.C1285r;
import p016b3.C1291x;
import p035d1.C2129g;
import p039d5.C2154a;
import p039d5.C2156c;
import p048e2.C2368c;
import p048e2.C2369d;
import p048e2.C2370e;
import p048e2.C2373h;
import p048e2.C2375j;
import p049e3.C2383d;
import p049e3.C2393k;
import p049e3.InterfaceC2394l;
import p056f0.C2480c;
import p097j3.InterfaceC2770a;
import p105k.InterfaceC2836j;
import p105k.InterfaceC2850x;
import p105k.MenuC2838l;
import p105k.SubMenuC2831e0;
import p138n0.AbstractC3155s0;
import p138n0.C3144o1;
import p138n0.C3153r1;
import p138n0.InterfaceC3124i;
import p138n0.InterfaceC3154s;
import p148o0.AbstractC3236k;
import p148o0.InterfaceC3244s;
import p177q5.AbstractC3501a;
import p228v2.C3981h;
import p228v2.InterfaceC3975b;
import p242w5.C4056d;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;
import p271z4.InterfaceC4340k;

public class C0019b implements InterfaceC3154s, InterfaceC3244s, InterfaceC2850x, InterfaceC2836j, InterfaceC0296y0, InterfaceC3124i, InterfaceC3975b, InterfaceC1769a, InterfaceC1820f, InterfaceC4340k, InterfaceC2394l, InterfaceC2770a {

    public final int f37a;

    public Object f38b;

    public C0019b(int i6, Object obj) {
        this.f37a = i6;
        this.f38b = obj;
    }

    @Override
    public void mo86b(MenuC2838l menuC2838l, boolean z7) {
        if (menuC2838l instanceof SubMenuC2831e0) {
            ((SubMenuC2831e0) menuC2838l).f9646z.mo5817k().m5827c(false);
        }
        InterfaceC2850x interfaceC2850x = ((C0225k) this.f38b).f9613e;
        if (interfaceC2850x != null) {
            interfaceC2850x.mo86b(menuC2838l, z7);
        }
    }

    @Override
    public int mo87c(byte[] bArr, int i6) throws C2393k {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i6 && (i11 = ((InputStream) this.f38b).read(bArr, i10, i6 - i10)) != -1) {
            i10 += i11;
        }
        if (i10 == 0 && i11 == -1) {
            throw new C2393k();
        }
        return i10;
    }

    @Override
    public short mo88d() throws IOException {
        int i6 = ((InputStream) this.f38b).read();
        if (i6 != -1) {
            return (short) i6;
        }
        throw new C2393k();
    }

    @Override
    public InterfaceC4102x mo89e(InterfaceC4102x interfaceC4102x, C3981h c3981h) {
        if (interfaceC4102x == null) {
            return null;
        }
        return new C2383d((Resources) this.f38b, interfaceC4102x);
    }

    @Override
    public boolean mo90f(MenuC2838l menuC2838l) {
        C0225k c0225k = (C0225k) this.f38b;
        if (menuC2838l == c0225k.f9611c) {
            return false;
        }
        c0225k.f976y = ((SubMenuC2831e0) menuC2838l).f9645A.f9717a;
        InterfaceC2850x interfaceC2850x = c0225k.f9613e;
        if (interfaceC2850x != null) {
            return interfaceC2850x.mo90f(menuC2838l);
        }
        return false;
    }

    @Override
    public boolean mo91g(float f) {
        if (f == 0.0f) {
            return false;
        }
        mo98o();
        ((NestedScrollView) this.f38b).m1102k((int) f);
        return true;
    }

    @Override
    public int mo92h() {
        return (mo88d() << 8) | mo88d();
    }

    @Override
    public boolean mo93i(Object obj, File file, C3981h c3981h) throws Throwable {
        InputStream inputStream = (InputStream) obj;
        C4243f c4243f = (C4243f) this.f38b;
        byte[] bArr = (byte[]) c4243f.m8287d(C0565C.DEFAULT_BUFFER_SEGMENT_SIZE, byte[].class);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i6 = inputStream.read(bArr);
                        if (i6 == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i6);
                    } catch (IOException e5) {
                        e = e5;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        c4243f.m8291h(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        c4243f.m8291h(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                c4243f.m8291h(bArr);
                return true;
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override
    public boolean mo94j(MenuC2838l menuC2838l, MenuItem menuItem) {
        switch (this.f37a) {
            case 5:
                InterfaceC0240n interfaceC0240n = ((ActionMenuView) this.f38b).f575A;
                if (interfaceC0240n == null) {
                    return false;
                }
                Toolbar toolbar = ((C0249o3) interfaceC0240n).f1025a;
                Iterator it = ((CopyOnWriteArrayList) toolbar.f813G.f10226c).iterator();
                if (it.hasNext()) {
                    throw AbstractC0004e.m18l(it);
                }
                InterfaceC0264r3 interfaceC0264r3 = toolbar.f815I;
                return interfaceC0264r3 != null ? ((C0155q0) interfaceC0264r3).f424a.f433s.f481a.onMenuItemSelected(0, menuItem) : false;
            case 19:
                AbstractC1852l abstractC1852l = (AbstractC1852l) this.f38b;
                abstractC1852l.getClass();
                abstractC1852l.getClass();
                return false;
            default:
                ((NavigationView) this.f38b).getClass();
                return false;
        }
    }

    @Override
    public float mo96m() {
        return -((NestedScrollView) this.f38b).getVerticalScrollFactorCompat();
    }

    @Override
    public void mo97n(MenuC2838l menuC2838l) {
        switch (this.f37a) {
            case 5:
                InterfaceC2836j interfaceC2836j = ((ActionMenuView) this.f38b).f582v;
                if (interfaceC2836j != null) {
                    interfaceC2836j.mo97n(menuC2838l);
                }
                break;
        }
    }

    @Override
    public void mo98o() {
        ((NestedScrollView) this.f38b).f1628d.abortAnimation();
    }

    @Override
    public C3153r1 onApplyWindowInsets(View view, C3153r1 c3153r1) {
        C3153r1 c3153r2;
        z = false;
        boolean z7 = false;
        switch (this.f37a) {
            case 0:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f38b;
                if (!Objects.equals(coordinatorLayout.f1435n, c3153r1)) {
                    coordinatorLayout.f1435n = c3153r1;
                    boolean z10 = c3153r1.m6328d() > 0;
                    coordinatorLayout.f1436o = z10;
                    coordinatorLayout.setWillNotDraw(!z10 && coordinatorLayout.getBackground() == null);
                    C3144o1 c3144o1 = c3153r1.f10641a;
                    if (!c3144o1.mo6239n()) {
                        int childCount = coordinatorLayout.getChildCount();
                        for (int i6 = 0; i6 < childCount; i6++) {
                            View childAt = coordinatorLayout.getChildAt(i6);
                            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                            if (!childAt.getFitsSystemWindows() || ((C0311c) childAt.getLayoutParams()).f1442a == null || !c3144o1.mo6239n()) {
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return c3153r1;
            case 13:
                AppBarLayout appBarLayout = (AppBarLayout) this.f38b;
                appBarLayout.getClass();
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                c3153r2 = appBarLayout.getFitsSystemWindows() ? c3153r1 : null;
                if (!Objects.equals(appBarLayout.f5783g, c3153r2)) {
                    appBarLayout.f5783g = c3153r2;
                    if (appBarLayout.f5794r != null && appBarLayout.getTopInset() > 0) {
                        z7 = true;
                    }
                    appBarLayout.setWillNotDraw(!z7);
                    appBarLayout.requestLayout();
                }
                return c3153r1;
            case 14:
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.f38b;
                collapsingToolbarLayout.getClass();
                WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                c3153r2 = collapsingToolbarLayout.getFitsSystemWindows() ? c3153r1 : null;
                if (!Objects.equals(collapsingToolbarLayout.f5837y, c3153r2)) {
                    collapsingToolbarLayout.f5837y = c3153r2;
                    collapsingToolbarLayout.requestLayout();
                }
                return c3153r1.f10641a.mo6237c();
            default:
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = (ScrimInsetsFrameLayout) this.f38b;
                if (scrimInsetsFrameLayout.f6345b == null) {
                    scrimInsetsFrameLayout.f6345b = new Rect();
                }
                scrimInsetsFrameLayout.f6345b.set(c3153r1.m6326b(), c3153r1.m6328d(), c3153r1.m6327c(), c3153r1.m6325a());
                scrimInsetsFrameLayout.mo4234a(c3153r1);
                C3144o1 c3144o2 = c3153r1.f10641a;
                scrimInsetsFrameLayout.setWillNotDraw(c3144o2.mo6229k().equals(C2480c.f8680e) || scrimInsetsFrameLayout.f6344a == null);
                WeakHashMap weakHashMap4 = AbstractC3155s0.f10642a;
                scrimInsetsFrameLayout.postInvalidateOnAnimation();
                return c3144o2.mo6237c();
        }
    }

    @Override
    public void mo99p(Object obj, Object obj2) {
        C4056d c4056d = (C4056d) obj2;
        C2154a c2154a = (C2154a) ((C2156c) obj).m3663p();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(c2154a.f5196e);
        int i6 = AbstractC3501a.f11790a;
        TelemetryData telemetryData = (TelemetryData) this.f38b;
        if (telemetryData == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            telemetryData.writeToParcel(parcelObtain, 0);
        }
        try {
            c2154a.f5195d.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            c4056d.m8059b(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override
    public boolean perform(View view, AbstractC3236k abstractC3236k) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f38b;
        if (!swipeDismissBehavior.mo4102s(view)) {
            return false;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = view.getLayoutDirection() == 1;
        int i6 = swipeDismissBehavior.f5906c;
        AbstractC3155s0.m6339i((!(i6 == 0 && z7) && (i6 != 1 || z7)) ? view.getWidth() : -view.getWidth(), view);
        view.setAlpha(0.0f);
        return true;
    }

    public C2375j m100q() {
        C2370e c2370eM5389c;
        C2368c c2368c = (C2368c) this.f38b;
        C2373h c2373h = (C2373h) c2368c.f8289d;
        synchronized (c2373h) {
            c2368c.m5382d(true);
            c2370eM5389c = c2373h.m5389c(((C2369d) c2368c.f8287b).f8290a);
        }
        if (c2370eM5389c != null) {
            return new C2375j(c2370eM5389c);
        }
        return null;
    }

    @Override
    public long skip(long j10) throws IOException {
        if (j10 < 0) {
            return 0L;
        }
        long j11 = j10;
        while (j11 > 0) {
            InputStream inputStream = (InputStream) this.f38b;
            long jSkip = inputStream.skip(j11);
            if (jSkip > 0) {
                j11 -= jSkip;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                j11--;
            }
        }
        return j10 - j11;
    }

    public C0019b(C1291x c1291x) {
        this.f37a = 12;
        this.f38b = Collections.unmodifiableMap(new HashMap(c1291x.f4056a));
    }

    public C0019b(int i6) {
        this.f37a = i6;
        switch (i6) {
            case 28:
                break;
            default:
                this.f38b = new C1285r(500L);
                break;
        }
    }

    public C0019b(ViewGroup viewGroup) {
        this.f37a = 18;
        this.f38b = viewGroup.getOverlay();
    }

    public C0019b(TextView textView) {
        this.f37a = 23;
        this.f38b = new C2129g(textView);
    }

    public C0019b(EditText editText) {
        this.f37a = 22;
        this.f38b = new C0069f(editText);
    }

    private final void m83r(MenuC2838l menuC2838l) {
    }

    private final void m84s(MenuC2838l menuC2838l) {
    }

    @Override
    public void mo85a(int i6) {
    }

    @Override
    public void mo95k(int i6) {
    }
}
