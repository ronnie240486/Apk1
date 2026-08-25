package p187r4;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0304z3;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.C1552f0;
import com.google.android.gms.internal.cast.C1650p0;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import p004a3.ExecutorServiceC0041f;
import p012b.C1224a;
import p148o0.AbstractC3236k;
import p148o0.InterfaceC3244s;
import p165p4.C3362g;
import p176q4.C3474b0;
import p195s0.C3689f;
import p198s3.InterfaceC3703a;
import p207t1.InterfaceC3791c;
import p210t4.C3809b;
import p222u7.C3926b;
import p222u7.C3930f;
import p230v4.C3988b;
import p230v4.C3997k;
import p230v4.InterfaceC3999m;
import p247x2.C4090l;
import p247x2.C4094p;
import p247x2.RunnableC4087i;
import p258y1.InterfaceC4221m;
import p271z4.C4336g;
import p271z4.C4339j;

public final class C3624n implements InterfaceC3999m, InterfaceC3791c, InterfaceC3703a, InterfaceC4221m, InterfaceC3244s {

    public static Class f12175c;

    public static boolean f12176d;

    public static Method f12177e;

    public static boolean f12178f;

    public static Method f12179g;

    public static boolean f12180h;

    public final int f12181a;

    public Object f12182b;

    public C3624n(int i6, Object obj) {
        this.f12181a = i6;
        this.f12182b = obj;
    }

    public static void m7336f() {
        if (f12176d) {
            return;
        }
        try {
            f12175c = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e5) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e5);
        }
        f12176d = true;
    }

    @Override
    public void mo6880b(int i6, Serializable serializable) {
        String str;
        switch (i6) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i6 == 6 || i6 == 7 || i6 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f12182b).setResultCode(i6);
    }

    @Override
    public void mo7338c(String str, long j10, int i6, C3997k c3997k, long j11, long j12) {
        AbstractC3625o abstractC3625o = (AbstractC3625o) this.f12182b;
        boolean z7 = c3997k instanceof C3997k;
        try {
            try {
                abstractC3625o.m3643g0(new C3622l(new Status(i6, null, null, null), 2));
            } catch (IllegalStateException e5) {
                e = e5;
                C3988b c3988b = C3616f.f12147k;
                Log.e(c3988b.f13521a, c3988b.m7977d("Result already set when calling onRequestCompleted", new Object[0]), e);
            }
        } catch (IllegalStateException e10) {
            e = e10;
        }
        Iterator it = abstractC3625o.f12185t.f12155h.iterator();
        while (it.hasNext()) {
            ((C3474b0) it.next()).m7107e(str, j10, i6, j11, j12);
        }
    }

    @Override
    public void mo7339d(String str, long j10, long j11, long j12) {
        AbstractC3625o abstractC3625o = (AbstractC3625o) this.f12182b;
        try {
            abstractC3625o.m3643g0(new C3622l(new Status(2103, null, null, null), 1));
        } catch (IllegalStateException e5) {
            C3988b c3988b = C3616f.f12147k;
            Log.e(c3988b.f13521a, c3988b.m7977d("Result already set when calling onRequestReplaced", new Object[0]), e5);
        }
        Iterator it = abstractC3625o.f12185t.f12155h.iterator();
        while (it.hasNext()) {
            ((C3474b0) it.next()).m7107e(str, j10, 2103, j11, j12);
        }
    }

    public void m7340e() {
        for (Runnable runnable : (ConcurrentLinkedQueue) this.f12182b) {
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override
    public Object mo6882g() {
        switch (this.f12181a) {
            case 8:
                C1552f0 c1552f0 = (C1552f0) this.f12182b;
                return new RunnableC4087i((C1224a) c1552f0.f5292b, (C3621k) c1552f0.f5293c);
            default:
                C0304z3 c0304z3 = (C0304z3) this.f12182b;
                return new C4094p((ExecutorServiceC0041f) c0304z3.f1155a, (ExecutorServiceC0041f) c0304z3.f1156b, (ExecutorServiceC0041f) c0304z3.f1157c, (ExecutorServiceC0041f) c0304z3.f1158d, (C4090l) c0304z3.f1159e, (C4090l) c0304z3.f1160f, (C3621k) c0304z3.f1161g);
        }
    }

    public synchronized C3930f[] m7341h(C3926b c3926b) {
        try {
            LinkedList linkedList = (LinkedList) ((ConcurrentHashMap) this.f12182b).get(c3926b.f13220b);
            if (linkedList != null && !linkedList.isEmpty()) {
                if (linkedList.size() > 1) {
                    if (linkedList.get(0) != null) {
                        throw new ClassCastException();
                    }
                    linkedList.remove(0);
                    linkedList.add(null);
                }
                LinkedList linkedList2 = new LinkedList();
                LinkedList linkedList3 = new LinkedList();
                Iterator it = linkedList.iterator();
                if (it.hasNext()) {
                    if (it.next() == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                }
                if (linkedList3.size() != 0) {
                    linkedList2 = linkedList3;
                }
                int size = linkedList2.size();
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < size; i6++) {
                    if (linkedList2.get(i6) != null) {
                        throw new ClassCastException();
                    }
                }
                return (C3930f[]) arrayList.toArray(new C3930f[arrayList.size()]);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public void mo6883i() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    public void m7342j(boolean z7) {
        C3809b c3809b = (C3809b) this.f12182b;
        if (!z7) {
            c3809b.getClass();
            return;
        }
        for (C1650p0 c1650p0 : c3809b.f12854d) {
            c3809b.f12855e.m7351e();
            c1650p0.m3968f();
        }
    }

    public void m7343k(CastSeekBar castSeekBar) {
        C3809b c3809b = (C3809b) this.f12182b;
        c3809b.getClass();
        int progress = castSeekBar.getProgress();
        Iterator it = c3809b.f12854d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1650p0 c1650p0 = (C1650p0) it.next();
            c1650p0.f5532b = true;
            c1650p0.m3968f();
        }
        C3616f c3616fM7585p = c3809b.m7585p();
        if (c3616fM7585p == null || !c3616fM7585p.m7305i()) {
            return;
        }
        long j10 = progress;
        C3626p c3626p = c3809b.f12855e;
        long jM7351e = c3626p.m7351e() + j10;
        c3616fM7585p.m7316t(new C3362g(jM7351e, c3616fM7585p.m7307k() && c3626p.m7358l(jM7351e)));
    }

    @Override
    public boolean perform(View view, AbstractC3236k abstractC3236k) {
        DrawerLayout drawerLayout = (DrawerLayout) this.f12182b;
        drawerLayout.getClass();
        if (!DrawerLayout.m1163k(view) || drawerLayout.m1171g(view) == 2) {
            return false;
        }
        drawerLayout.m1166b(view);
        return true;
    }

    @Override
    public void setVisibility(int i6) {
        ((View) this.f12182b).setVisibility(i6);
    }

    public C3624n(C4339j c4339j, C4336g c4336g) {
        this.f12181a = 14;
        this.f12182b = c4339j;
    }

    public C3624n(int i6) {
        this.f12181a = i6;
        switch (i6) {
            case 7:
                this.f12182b = new ConcurrentHashMap();
                break;
        }
    }

    public C3624n(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f12181a = 1;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f12182b = new C3689f(uri, clipDescription, uri2);
        } else {
            this.f12182b = new C3621k(uri, clipDescription, uri2, 2);
        }
    }

    @Override
    public void mo7337a(ViewGroup viewGroup, View view) {
    }
}
