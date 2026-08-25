package p124l6;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.app.ViewOnClickListenerC0141j0;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.images.WebImage;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.C3320b;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p016b3.C1287t;
import p055ea.C2448k;
import p086i3.C2685a;
import p101j7.C2782c;
import p123l5.AbstractC2973a;
import p131m3.C3076c;
import p144n7.AbstractC3206d;
import p144n7.InterfaceC3215m;
import p160p.C3341e;
import p171q.C3388b;
import p176q4.AbstractC3481g;
import p176q4.C3475c;
import p176q4.C3477d;
import p176q4.InterfaceC3483i;
import p179q7.AbstractC3524b;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p186r3.C3606j;
import p186r3.C3608l;
import p187r4.C3616f;
import p187r4.C3621k;
import p198s3.AbstractC3705c;
import p199s4.C3713g;
import p199s4.InterfaceC3707a;
import p202s7.C3723a;
import p221u6.C3905e;
import p228v2.InterfaceC3978e;
import p230v4.AbstractC3987a;
import p242w5.C4056d;
import p242w5.InterfaceC4053a;
import p247x2.C4079a0;
import p247x2.C4082d;
import p247x2.C4089k;
import p247x2.RunnableC4087i;
import p249x4.C4112e;
import p259y2.C4240c;
import p259y2.InterfaceC4245h;
import p261y4.C4256d;
import p261y4.C4257e;
import p269z2.C4301b;
import p269z2.C4306g;
import sa.DialogC3734e;
import sa.ViewOnLongClickListenerC3738i;
import ua.C3948i;

public final class C2982h implements InterfaceC3483i, InterfaceC3707a, InterfaceC1478d, InterfaceC4053a {

    public final int f10224a;

    public Object f10225b;

    public Object f10226c;

    public C2982h(Object obj, int i6, Object obj2) {
        this.f10224a = i6;
        this.f10226c = obj;
        this.f10225b = obj2;
    }

    public static String m6037D(C2982h c2982h) {
        boolean z7 = false;
        StringBuilder sb = new StringBuilder("com.google.android.gms.cast.CATEGORY_CAST");
        String str = (String) c2982h.f10225b;
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException("Invalid application ID: ".concat(str));
            }
            sb.append("/");
            sb.append(upperCase);
        }
        List<String> list = (List) c2982h.f10226c;
        if (list != null) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            boolean z10 = str != null;
            if (str == null) {
                sb.append("/");
            }
            sb.append("/");
            boolean z11 = true;
            for (String string : list) {
                AbstractC3987a.m7970c(string);
                if (!z11) {
                    sb.append(",");
                }
                if (!AbstractC3987a.f13519a.matcher(string).matches()) {
                    StringBuilder sb2 = new StringBuilder(string.length());
                    for (int i6 = 0; i6 < string.length(); i6++) {
                        char cCharAt = string.charAt(i6);
                        if ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '_' || cCharAt == '-' || cCharAt == '.' || cCharAt == ':'))) {
                            sb2.append(String.format("%%%04x", Integer.valueOf(cCharAt)));
                        } else {
                            sb2.append(cCharAt);
                        }
                    }
                    string = sb2.toString();
                }
                sb.append(string);
                z11 = false;
            }
            z7 = z10;
        } else if (str != null) {
            z7 = true;
        }
        if (true != z7 && list == null) {
            sb.append("/");
        }
        if (list == null) {
            sb.append("/");
        }
        sb.append("//ALLOW_IPV6");
        return sb.toString();
    }

    public Object m6038A() {
        C4240c c4240c = (C4240c) this.f10225b;
        C4240c c4240c2 = c4240c.f14401d;
        while (true) {
            if (c4240c2.equals(c4240c)) {
                return null;
            }
            ArrayList arrayList = c4240c2.f14399b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? c4240c2.f14399b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            C4240c c4240c3 = c4240c2.f14401d;
            c4240c3.f14400c = c4240c2.f14400c;
            c4240c2.f14400c.f14401d = c4240c3;
            HashMap map = (HashMap) this.f10226c;
            InterfaceC4245h interfaceC4245h = c4240c2.f14398a;
            map.remove(interfaceC4245h);
            interfaceC4245h.mo8282a();
            c4240c2 = c4240c2.f14401d;
        }
    }

    public void m6039B(int i6, int i10, int i11, int i12) {
        CardView cardView = (CardView) this.f10226c;
        cardView.f1167d.set(i6, i10, i11, i12);
        Rect rect = cardView.f1166c;
        super/*android.widget.FrameLayout*/.setPadding(i6 + rect.left, i10 + rect.top, i11 + rect.right, i12 + rect.bottom);
    }

    public void m6040C(boolean z7, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f10225b)) {
            map = new HashMap((Map) this.f10225b);
        }
        synchronized (((Map) this.f10226c)) {
            map2 = new HashMap((Map) this.f10226c);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z7 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m3640d0(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z7 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C4056d) entry2.getKey()).m8060c(new C4257e(status));
            }
        }
    }

    @Override
    public void mo3717a(AbstractC3481g abstractC3481g, int i6) {
        C3320b c3320b = (C3320b) this.f10226c;
        AbstractC0032a.m165s("8bYUp3Xx4QfwizOjdPbOCfe0IqY8og==\n", "nthHwgaCiGg=\n");
        C3320b.m6736b(c3320b, (Spark) this.f10225b);
    }

    @Override
    public void mo3998b(C3477d c3477d) {
        ((Map) ((C2982h) this.f10226c).f10226c).remove((C4056d) this.f10225b);
    }

    @Override
    public void mo3172c(Exception exc) {
        C4079a0 c4079a0 = (C4079a0) this.f10226c;
        C1287t c1287t = (C1287t) this.f10225b;
        C1287t c1287t2 = c4079a0.f13759f;
        if (c1287t2 == null || c1287t2 != c1287t) {
            return;
        }
        C4079a0 c4079a1 = (C4079a0) this.f10226c;
        C1287t c1287t3 = (C1287t) this.f10225b;
        RunnableC4087i runnableC4087i = c4079a1.f13755b;
        C4082d c4082d = c4079a1.f13760g;
        InterfaceC1479e interfaceC1479e = c1287t3.f4054c;
        runnableC4087i.mo8067a(c4082d, exc, interfaceC1479e, interfaceC1479e.mo3153d());
    }

    @Override
    public void mo3718d(AbstractC3481g abstractC3481g, boolean z7) {
        C3475c c3475c = (C3475c) abstractC3481g;
        C3616f c3616fM7125f = c3475c.m7125f();
        C3320b c3320b = (C3320b) this.f10226c;
        c3320b.f11216n = c3616fM7125f;
        if (c3320b.f11210h) {
            c3320b.f11208f = c3475c;
            c3320b.f11204b = true;
            C2448k c2448k = c3320b.f11203a;
            if (c2448k != null) {
                c2448k.m5485b();
            }
        }
        AbstractC0032a.m165s("xqvK0jBmc7zHl/zENnh/t5Pl\n", "qcWZt0MVGtM=\n");
    }

    @Override
    public void mo3173e(Object obj) {
        C4079a0 c4079a0 = (C4079a0) this.f10226c;
        C1287t c1287t = (C1287t) this.f10225b;
        C1287t c1287t2 = c4079a0.f13759f;
        if (c1287t2 == null || c1287t2 != c1287t) {
            return;
        }
        C4079a0 c4079a1 = (C4079a0) this.f10226c;
        C1287t c1287t3 = (C1287t) this.f10225b;
        C4089k c4089k = c4079a1.f13754a.f13787p;
        if (obj != null && c4089k.m8094a(c1287t3.f4054c.mo3153d())) {
            c4079a1.f13758e = obj;
            c4079a1.f13755b.m8088o(2);
        } else {
            RunnableC4087i runnableC4087i = c4079a1.f13755b;
            InterfaceC3978e interfaceC3978e = c1287t3.f4052a;
            InterfaceC1479e interfaceC1479e = c1287t3.f4054c;
            runnableC4087i.mo8069c(interfaceC3978e, obj, interfaceC1479e, interfaceC1479e.mo3153d(), c4079a1.f13760g);
        }
    }

    @Override
    public void mo3999f(Bitmap bitmap) {
        C2982h c2982h = (C2982h) this.f10225b;
        c2982h.f10226c = bitmap;
        C3713g c3713g = (C3713g) this.f10226c;
        c3713g.f12436l = c2982h;
        c3713g.m7471b();
    }

    @Override
    public void mo3719g(AbstractC3481g abstractC3481g, int i6) {
        AbstractC0032a.m165s("2TMx7UHVyebYDhf7QsPO7dM5WKg=\n", "tl1iiDKmoIk=\n");
    }

    @Override
    public void mo3720h(AbstractC3481g abstractC3481g, String str) {
        C3475c c3475c = (C3475c) abstractC3481g;
        C3616f c3616fM7125f = c3475c.m7125f();
        C3320b c3320b = (C3320b) this.f10226c;
        c3320b.f11216n = c3616fM7125f;
        AbstractC0032a.m165s("rMZWn58m6pit+3GbniHmk/mI\n", "w6gF+uxVg/c=\n");
        if (c3320b.f11210h) {
            c3320b.f11208f = c3475c;
            c3320b.f11204b = true;
            C2448k c2448k = c3320b.f11203a;
            if (c2448k != null) {
                c2448k.m5485b();
            }
        }
    }

    @Override
    public void mo3721i(AbstractC3481g abstractC3481g, int i6) {
        C3320b c3320b = (C3320b) this.f10226c;
        AbstractC0032a.m165s("rHkqiNln2F2tRRye33nUdKJ+FYjOLpE=\n", "wxd57aoUsTI=\n");
        C3320b.m6736b(c3320b, (Spark) this.f10225b);
    }

    public String m6041j(InterfaceC3978e interfaceC3978e) {
        String str;
        C4306g c4306g = (C4306g) ((C3621k) this.f10226c).m7329f();
        try {
            interfaceC3978e.mo3160a(c4306g.f14608a);
            byte[] bArrDigest = c4306g.f14608a.digest();
            char[] cArr = AbstractC3610n.f12113b;
            synchronized (cArr) {
                for (int i6 = 0; i6 < bArrDigest.length; i6++) {
                    byte b8 = bArrDigest[i6];
                    int i10 = i6 * 2;
                    char[] cArr2 = AbstractC3610n.f12112a;
                    cArr[i10] = cArr2[(b8 & 255) >>> 4];
                    cArr[i10 + 1] = cArr2[b8 & 15];
                }
                str = new String(cArr);
            }
            ((C3621k) this.f10226c).m7334k(c4306g);
            return str;
        } catch (Throwable th) {
            ((C3621k) this.f10226c).m7334k(c4306g);
            throw th;
        }
    }

    @Override
    public void mo3722k(AbstractC3481g abstractC3481g, String str) {
        AbstractC0032a.m165s("BWv69cIA9K0EV8zjxB70rA0/iQ==\n", "agWpkLFzncI=\n");
    }

    @Override
    public void mo3723l(AbstractC3481g abstractC3481g) {
        AbstractC0032a.m165s("AzWUnxSSjnQCHqmeDo+AIUw=\n", "bFvH+mfh5xs=\n");
    }

    @Override
    public void mo3724m(AbstractC3481g abstractC3481g, int i6) {
        C3320b c3320b = (C3320b) this.f10226c;
        AbstractC0032a.m165s("fZD6b7W4oOd8u8duo6/zqA==\n", "Ev6pCsbLyYg=\n");
        C3320b.m6736b(c3320b, (Spark) this.f10225b);
        c3320b.f11208f = null;
    }

    @Override
    public void mo3725n(AbstractC3481g abstractC3481g) {
        AbstractC0032a.m165s("Zrm5zXHu/qdnhJ7JcOn+pm7tyg==\n", "CdfqqAKdl8g=\n");
    }

    public DialogC3734e m6042o() {
        String strM165s = AbstractC0032a.m165s("mj6GQ8Yy3+WYOZNNxyPy\n", "9l//LLNGgIw=\n");
        Context context = (Context) this.f10225b;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(strM165s);
        DialogC3734e dialogC3734e = new DialogC3734e(context, R.style.Dialog);
        View viewInflate = layoutInflater.inflate(R.layout.dialog_pwd_layout, (ViewGroup) null);
        dialogC3734e.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        EditText editText = (EditText) viewInflate.findViewById(R.id.old_password);
        TextView textView = (TextView) viewInflate.findViewById(R.id.error);
        editText.setFocusable(true);
        editText.setOnLongClickListener(new ViewOnLongClickListenerC3738i(this, editText));
        Button button = (Button) viewInflate.findViewById(R.id.positiveButton);
        if (((DialogInterface.OnClickListener) this.f10226c) != null) {
            button.setOnClickListener(new ViewOnClickListenerC0141j0(this, editText, textView, dialogC3734e));
        }
        ((Button) viewInflate.findViewById(R.id.negativeButton)).setOnClickListener(new ViewOnClickListenerC0122a(19, dialogC3734e));
        dialogC3734e.setContentView(viewInflate);
        editText.requestFocus();
        dialogC3734e.getWindow().setSoftInputMode(4);
        return dialogC3734e;
    }

    public synchronized void m6043p(C3948i c3948i) {
        try {
            C3948i c3948i2 = (C3948i) this.f10226c;
            if (c3948i2 != null) {
                c3948i2.f13277c = c3948i;
                this.f10226c = c3948i;
            } else {
                if (((C3948i) this.f10225b) != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f10226c = c3948i;
                this.f10225b = c3948i;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public Object m6044q(InterfaceC4245h interfaceC4245h) {
        HashMap map = (HashMap) this.f10226c;
        C4240c c4240c = (C4240c) map.get(interfaceC4245h);
        if (c4240c == null) {
            c4240c = new C4240c(interfaceC4245h);
            map.put(interfaceC4245h, c4240c);
        } else {
            interfaceC4245h.mo8282a();
        }
        C4240c c4240c2 = c4240c.f14401d;
        c4240c2.f14400c = c4240c.f14400c;
        c4240c.f14400c.f14401d = c4240c2;
        C4240c c4240c3 = (C4240c) this.f10225b;
        c4240c.f14401d = c4240c3;
        C4240c c4240c4 = c4240c3.f14400c;
        c4240c.f14400c = c4240c4;
        c4240c4.f14401d = c4240c;
        c4240c.f14401d.f14400c = c4240c;
        ArrayList arrayList = c4240c.f14399b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return c4240c.f14399b.remove(size - 1);
        }
        return null;
    }

    public InterfaceC3215m m6045r(C3723a c3723a) {
        C2782c c2782c;
        Map map = (Map) this.f10225b;
        Type type = c3723a.f12481b;
        if (map.get(type) != null) {
            throw new ClassCastException();
        }
        Class cls = c3723a.f12480a;
        if (map.get(cls) != null) {
            throw new ClassCastException();
        }
        InterfaceC3215m c4112e = null;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                ((AbstractC3524b) this.f10226c).mo7168a(declaredConstructor);
            }
            c2782c = new C2782c(18, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            c2782c = null;
        }
        if (c2782c != null) {
            return c2782c;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                c4112e = new C3905e(24);
            } else if (EnumSet.class.isAssignableFrom(cls)) {
                c4112e = new C2782c(19, type);
            } else if (Set.class.isAssignableFrom(cls)) {
                c4112e = new C4112e(24);
            } else {
                c4112e = Queue.class.isAssignableFrom(cls) ? new C3905e(25) : new C4112e(25);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                c4112e = new C3905e(26);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                c4112e = new C3905e(22);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                c4112e = new C4112e(22);
            } else if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                type2.getClass();
                Type typeM6486b = AbstractC3206d.m6486b(type2);
                Class clsM6492h = AbstractC3206d.m6492h(typeM6486b);
                typeM6486b.hashCode();
                if (String.class.isAssignableFrom(clsM6492h)) {
                    c4112e = new C4112e(23);
                } else {
                    c4112e = new C3905e(23);
                }
            } else {
                c4112e = new C4112e(23);
            }
        }
        return c4112e != null ? c4112e : new C0026b(cls, type);
    }

    public synchronized List m6046s(String str) {
        List arrayList;
        if (!((ArrayList) this.f10225b).contains(str)) {
            ((ArrayList) this.f10225b).add(str);
        }
        arrayList = (List) ((HashMap) this.f10226c).get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            ((HashMap) this.f10226c).put(str, arrayList);
        }
        return arrayList;
    }

    public synchronized ArrayList m6047t(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = ((ArrayList) this.f10225b).iterator();
        while (it.hasNext()) {
            List<C3076c> list = (List) ((HashMap) this.f10226c).get((String) it.next());
            if (list != null) {
                for (C3076c c3076c : list) {
                    if ((c3076c.f10539a.isAssignableFrom(cls) && cls2.isAssignableFrom(c3076c.f10540b)) && !arrayList.contains(c3076c.f10540b)) {
                        arrayList.add(c3076c.f10540b);
                    }
                }
            }
        }
        return arrayList;
    }

    public String toString() {
        switch (this.f10224a) {
            case 4:
                return ((Map) this.f10225b).toString();
            case 13:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                C4240c c4240c = (C4240c) this.f10225b;
                C4240c c4240c2 = c4240c.f14400c;
                boolean z7 = false;
                while (!c4240c2.equals(c4240c)) {
                    sb.append('{');
                    sb.append(c4240c2.f14398a);
                    sb.append(':');
                    ArrayList arrayList = c4240c2.f14399b;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    c4240c2 = c4240c2.f14400c;
                    z7 = true;
                }
                if (z7) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public String m6048u(InterfaceC3978e interfaceC3978e) {
        String strM6041j;
        synchronized (((C3606j) this.f10225b)) {
            strM6041j = (String) ((C3606j) this.f10225b).m7227a(interfaceC3978e);
        }
        if (strM6041j == null) {
            strM6041j = m6041j(interfaceC3978e);
        }
        synchronized (((C3606j) this.f10225b)) {
            ((C3606j) this.f10225b).m7229d(interfaceC3978e, strM6041j);
        }
        return strM6041j;
    }

    public synchronized C3948i m6049v() {
        C3948i c3948i;
        c3948i = (C3948i) this.f10225b;
        if (c3948i != null) {
            C3948i c3948i2 = c3948i.f13277c;
            this.f10225b = c3948i2;
            if (c3948i2 == null) {
                this.f10226c = null;
            }
        }
        return c3948i;
    }

    public synchronized C3948i m6050w() {
        try {
            if (((C3948i) this.f10225b) == null) {
                wait(1000);
            }
        } catch (Throwable th) {
            throw th;
        }
        return m6049v();
    }

    public void m6051x(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((C3341e) this.f10226c)) {
            ((C3341e) this.f10226c).put(new C3608l(cls, cls2, cls3), list);
        }
    }

    public void m6052y(InterfaceC4245h interfaceC4245h, Object obj) {
        HashMap map = (HashMap) this.f10226c;
        C4240c c4240c = (C4240c) map.get(interfaceC4245h);
        if (c4240c == null) {
            c4240c = new C4240c(interfaceC4245h);
            c4240c.f14401d = c4240c;
            C4240c c4240c2 = (C4240c) this.f10225b;
            c4240c.f14401d = c4240c2.f14401d;
            c4240c.f14400c = c4240c2;
            c4240c2.f14401d = c4240c;
            c4240c.f14401d.f14400c = c4240c;
            map.put(interfaceC4245h, c4240c);
        } else {
            interfaceC4245h.mo8282a();
        }
        if (c4240c.f14399b == null) {
            c4240c.f14399b = new ArrayList();
        }
        c4240c.f14399b.add(obj);
    }

    public void m6053z(String str) {
        C4301b c4301b;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.f10225b).get(str);
                AbstractC3602f.m7225c(obj, "Argument must not be null");
                c4301b = (C4301b) obj;
                int i6 = c4301b.f14594b;
                if (i6 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + c4301b.f14594b);
                }
                int i10 = i6 - 1;
                c4301b.f14594b = i10;
                if (i10 == 0) {
                    C4301b c4301b2 = (C4301b) ((HashMap) this.f10225b).remove(str);
                    if (!c4301b2.equals(c4301b)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c4301b + ", but actually removed: " + c4301b2 + ", safeKey: " + str);
                    }
                    ((C2685a) this.f10226c).m5686b(c4301b2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c4301b.f14593a.unlock();
    }

    public C2982h(String str, List list) {
        this.f10224a = 7;
        this.f10225b = str;
        this.f10226c = list;
    }

    public C2982h(WebImage webImage) {
        this.f10224a = 9;
        this.f10225b = webImage == null ? null : webImage.f5023b;
    }

    public C2982h(String str, AbstractC2973a abstractC2973a, C4256d c4256d) {
        this.f10224a = 14;
        this.f10226c = str;
        this.f10225b = abstractC2973a;
    }

    public C2982h(int i6) {
        this.f10224a = i6;
        switch (i6) {
            case 2:
                this.f10225b = new ArrayList();
                this.f10226c = new HashMap();
                break;
            case 11:
                break;
            case 13:
                this.f10225b = new C4240c(null);
                this.f10226c = new HashMap();
                break;
            case 15:
                this.f10225b = new HashMap();
                this.f10226c = new C2685a(1);
                break;
            case 16:
                this.f10225b = new C3606j(1000L);
                this.f10226c = AbstractC3705c.m7467a(10, new C3388b(12));
                break;
            case 18:
                this.f10225b = Collections.synchronizedMap(new WeakHashMap());
                this.f10226c = Collections.synchronizedMap(new WeakHashMap());
                break;
            default:
                this.f10225b = new AtomicReference();
                this.f10226c = new C3341e(0);
                break;
        }
    }

    public C2982h(Context context) {
        this.f10224a = 10;
        this.f10225b = context;
    }

    public C2982h(Map map) {
        this.f10224a = 4;
        this.f10226c = AbstractC3524b.f11883a;
        this.f10225b = map;
    }

    public C2982h(Runnable runnable) {
        this.f10224a = 3;
        this.f10226c = new CopyOnWriteArrayList();
        new HashMap();
        this.f10225b = runnable;
    }

    public C2982h(CardView cardView) {
        this.f10224a = 5;
        this.f10226c = cardView;
    }
}
