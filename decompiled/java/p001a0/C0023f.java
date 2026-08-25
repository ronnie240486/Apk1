package p001a0;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.leanback.widget.C0479k1;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.mediarouter.app.MediaRouteButton;
import com.lzy.okgo.cookie.SerializableCookie;
import com.tencent.bugly.proguard.ThreadFactoryC2069c0;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.C3320b;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p014b1.C1239m;
import p014b1.C1243q;
import p024c1.C1377a;
import p024c1.C1378b;
import p038d4.InterfaceC2152b;
import p074h0.InterfaceMenuItemC2638a;
import p077h4.C2654d;
import p077h4.C2660j;
import p087i4.InterfaceC2699d;
import p093j.AbstractC2740a;
import p093j.C2745f;
import p098j4.InterfaceC2776c;
import p105k.MenuC2825b0;
import p105k.MenuC2838l;
import p105k.MenuItemC2845s;
import p128m0.C3027c;
import p143n5.AbstractC3198d;
import p160p.C3341e;
import p160p.C3345i;
import p160p.C3347k;
import p173q1.C3454w;
import p173q1.RunnableC3431n1;
import p234v8.InterfaceC4022a;
import p247x2.C4078a;
import p247x2.C4090l;
import p247x2.C4095q;
import p247x2.C4096r;
import p247x2.InterfaceC4102x;

public final class C0023f implements InterfaceC2152b {

    public final int f43a;

    public Object f44b;

    public Object f45c;

    public Object f46d;

    public Object f47e;

    public C0023f(int i6, boolean z7) {
        this.f43a = i6;
    }

    public synchronized void m101a(C4095q c4095q, C4096r c4096r) {
        C4078a c4078a = (C4078a) ((HashMap) this.f45c).put(c4095q, new C4078a(c4095q, c4096r, (ReferenceQueue) this.f46d));
        if (c4078a != null) {
            c4078a.f13753c = null;
            c4078a.clear();
        }
    }

    public void m102b(ArrayList arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("filters must not be null");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IntentFilter intentFilter = (IntentFilter) it.next();
            if (intentFilter != null) {
                ArrayList arrayList2 = (ArrayList) this.f45c;
                if (!arrayList2.contains(intentFilter)) {
                    arrayList2.add(intentFilter);
                }
            }
        }
    }

    public C3454w m103c() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>((ArrayList) this.f45c);
        Bundle bundle = (Bundle) this.f44b;
        bundle.putParcelableArrayList("controlFilters", arrayList);
        bundle.putStringArrayList("groupMemberIds", new ArrayList<>((ArrayList) this.f46d));
        bundle.putStringArrayList("allowedPackages", new ArrayList<>((HashSet) this.f47e));
        return new C3454w(bundle);
    }

    public void m104d(C4078a c4078a) {
        InterfaceC4102x interfaceC4102x;
        synchronized (this) {
            ((HashMap) this.f45c).remove(c4078a.f13751a);
            if (c4078a.f13752b && (interfaceC4102x = c4078a.f13753c) != null) {
                ((C4090l) this.f47e).m8101f(c4078a.f13751a, new C4096r(interfaceC4102x, true, false, c4078a.f13751a, (C4090l) this.f47e));
            }
        }
    }

    public void m105e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((C3347k) this.f45c).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i6 = 0; i6 < size; i6++) {
                m105e(arrayList2.get(i6), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public C2745f m106f(AbstractC2740a abstractC2740a) {
        ArrayList arrayList = (ArrayList) this.f46d;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C2745f c2745f = (C2745f) arrayList.get(i6);
            if (c2745f != null && c2745f.f9422b == abstractC2740a) {
                return c2745f;
            }
        }
        C2745f c2745f2 = new C2745f((Context) this.f47e, abstractC2740a);
        arrayList.add(c2745f2);
        return c2745f2;
    }

    public boolean m107g(AbstractC2740a abstractC2740a, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f44b).onActionItemClicked(m106f(abstractC2740a), new MenuItemC2845s((Context) this.f47e, (InterfaceMenuItemC2638a) menuItem));
    }

    @Override
    public Object get() {
        return new C2660j((Executor) ((InterfaceC4022a) this.f44b).get(), (InterfaceC2699d) ((InterfaceC4022a) this.f45c).get(), (C2654d) ((C0026b) this.f46d).get(), (InterfaceC2776c) ((InterfaceC4022a) this.f47e).get());
    }

    public boolean m108h(AbstractC2740a abstractC2740a, MenuC2838l menuC2838l) {
        C2745f c2745fM106f = m106f(abstractC2740a);
        C3347k c3347k = (C3347k) this.f45c;
        Menu menuC2825b0 = (Menu) c3347k.get(menuC2838l);
        if (menuC2825b0 == null) {
            menuC2825b0 = new MenuC2825b0((Context) this.f47e, menuC2838l);
            c3347k.put(menuC2838l, menuC2825b0);
        }
        return ((ActionMode.Callback) this.f44b).onCreateActionMode(c2745fM106f, menuC2825b0);
    }

    public String toString() {
        switch (this.f43a) {
            case 1:
                return "horizontal=" + ((C0479k1) this.f45c) + "; vertical=" + ((C0479k1) this.f44b);
            default:
                return super.toString();
        }
    }

    public C0023f(InterfaceC4022a interfaceC4022a, InterfaceC4022a interfaceC4022a2, C0026b c0026b, InterfaceC4022a interfaceC4022a3) {
        this.f43a = 4;
        this.f44b = interfaceC4022a;
        this.f45c = interfaceC4022a2;
        this.f46d = c0026b;
        this.f47e = interfaceC4022a3;
    }

    public C0023f(int i6) {
        this.f43a = i6;
        switch (i6) {
            case 1:
                C0479k1 c0479k1 = new C0479k1();
                this.f44b = c0479k1;
                C0479k1 c0479k2 = new C0479k1();
                this.f45c = c0479k2;
                this.f46d = c0479k2;
                this.f47e = c0479k1;
                break;
            case 11:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC2069c0(2));
                this.f45c = new HashMap();
                this.f46d = new ReferenceQueue();
                this.f44b = executorServiceNewSingleThreadExecutor;
                executorServiceNewSingleThreadExecutor.execute(new RunnableC3431n1(7, this));
                break;
            case 12:
                this.f44b = new C3341e(0);
                this.f45c = new SparseArray();
                this.f46d = new C3345i();
                this.f47e = new C3341e(0);
                break;
            default:
                this.f44b = new C3027c(10);
                this.f45c = new C3347k(0);
                this.f46d = new ArrayList();
                this.f47e = new HashSet();
                break;
        }
    }

    public C0023f(Locale locale) {
        this.f43a = 5;
        this.f44b = locale;
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        AbstractC3198d.m6465m(1, 12);
        this.f45c = AbstractC3198d.m6465m(0, 23);
        this.f46d = AbstractC3198d.m6465m(0, 59);
        this.f47e = dateFormatSymbols.getAmPmStrings();
    }

    public C0023f(Typeface typeface, C1378b c1378b) {
        int i6;
        int i10;
        this.f43a = 2;
        this.f47e = typeface;
        this.f44b = c1378b;
        this.f46d = new C1243q(1024);
        int iM3244a = c1378b.m3244a(6);
        if (iM3244a != 0) {
            int i11 = iM3244a + c1378b.f4191a;
            i6 = ((ByteBuffer) c1378b.f4194d).getInt(((ByteBuffer) c1378b.f4194d).getInt(i11) + i11);
        } else {
            i6 = 0;
        }
        this.f45c = new char[i6 * 2];
        int iM3244a2 = c1378b.m3244a(6);
        if (iM3244a2 != 0) {
            int i12 = iM3244a2 + c1378b.f4191a;
            i10 = ((ByteBuffer) c1378b.f4194d).getInt(((ByteBuffer) c1378b.f4194d).getInt(i12) + i12);
        } else {
            i10 = 0;
        }
        for (int i13 = 0; i13 < i10; i13++) {
            C1239m c1239m = new C1239m(this, i13);
            C1377a c1377aM3115c = c1239m.m3115c();
            int iM3244a3 = c1377aM3115c.m3244a(4);
            Character.toChars(iM3244a3 != 0 ? ((ByteBuffer) c1377aM3115c.f4194d).getInt(iM3244a3 + c1377aM3115c.f4191a) : 0, (char[]) this.f45c, i13 * 2);
            AbstractC0032a.m160n("invalid metadata codepoint length", c1239m.m3114b() > 0);
            ((C1243q) this.f46d).m3123a(c1239m, 0, c1239m.m3114b() - 1);
        }
    }

    public C0023f(Context context, ActionMode.Callback callback) {
        this.f43a = 6;
        this.f47e = context;
        this.f44b = callback;
        this.f46d = new ArrayList();
        this.f45c = new C3347k(0);
    }

    public C0023f(C3320b c3320b, Spark spark, MediaRouteButton mediaRouteButton, MediaRouteButton mediaRouteButton2) {
        this.f43a = 7;
        this.f47e = c3320b;
        this.f44b = spark;
        this.f45c = mediaRouteButton;
        this.f46d = mediaRouteButton2;
    }

    public C0023f(String str, String str2) {
        this.f43a = 8;
        this.f46d = new ArrayList();
        this.f45c = new ArrayList();
        this.f47e = new HashSet();
        Bundle bundle = new Bundle();
        this.f44b = bundle;
        if (str != null) {
            bundle.putString(TtmlNode.ATTR_ID, str);
            if (str2 != null) {
                bundle.putString(SerializableCookie.NAME, str2);
                return;
            }
            throw new NullPointerException("name must not be null");
        }
        throw new NullPointerException("id must not be null");
    }

    public C0023f(C3454w c3454w) {
        this.f43a = 8;
        this.f46d = new ArrayList();
        this.f45c = new ArrayList();
        this.f47e = new HashSet();
        this.f44b = new Bundle(c3454w.f11701a);
        this.f46d = c3454w.m7087d();
        this.f45c = c3454w.m7085b();
        this.f47e = c3454w.m7084a();
    }
}
