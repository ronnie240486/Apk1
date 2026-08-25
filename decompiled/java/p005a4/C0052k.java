package p005a4;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.appcompat.widget.C0304z3;
import androidx.media3.common.util.RunnableC0624i;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p001a0.C0023f;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p014b1.InterfaceC1234h;
import p014b1.ThreadFactoryC1227a;
import p017b4.C1298e;
import p025c2.C1381b;
import p038d4.C2151a;
import p038d4.C2153c;
import p186r3.InterfaceC3603g;
import p234v8.InterfaceC4022a;
import p249x4.C4112e;

public final class C0052k implements InterfaceC1234h, InterfaceC3603g {

    public final int f154a;

    public Context f155b;

    public C0052k() {
        this.f154a = 0;
    }

    @Override
    public void mo204a(AbstractC0032a abstractC0032a) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC1227a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new RunnableC0624i(this, abstractC0032a, threadPoolExecutor, 5));
    }

    public C0053l m205b() {
        Context context = this.f155b;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        C0053l c0053l = new C0053l();
        c0053l.f156a = C2151a.m5087a(AbstractC0056o.f163a);
        C2153c c2153c = new C2153c(context);
        c0053l.f157b = c2153c;
        c0053l.f158c = C2151a.m5087a(new C0069f(8, c2153c, new C1298e(c2153c, 0), false));
        C2153c c2153c2 = c0053l.f157b;
        InterfaceC4022a interfaceC4022aM5087a = C2151a.m5087a(new C0069f(23, new C1298e(c2153c2, 2), new C1298e(c2153c2, 1), false));
        c0053l.f159d = interfaceC4022aM5087a;
        C4112e c4112e = new C4112e(13);
        C2153c c2153c3 = c0053l.f157b;
        C0026b c0026b = new C0026b(c2153c3, interfaceC4022aM5087a, c4112e, 20);
        InterfaceC4022a interfaceC4022a = c0053l.f156a;
        InterfaceC4022a interfaceC4022a2 = c0053l.f158c;
        C1381b c1381b = new C1381b(interfaceC4022a, interfaceC4022a2, c0026b, interfaceC4022aM5087a, interfaceC4022aM5087a);
        C0304z3 c0304z3 = new C0304z3();
        c0304z3.f1155a = c2153c3;
        c0304z3.f1156b = interfaceC4022a2;
        c0304z3.f1157c = interfaceC4022aM5087a;
        c0304z3.f1158d = c0026b;
        c0304z3.f1159e = interfaceC4022a;
        c0304z3.f1160f = interfaceC4022aM5087a;
        c0304z3.f1161g = interfaceC4022aM5087a;
        c0053l.f160e = C2151a.m5087a(new C0026b(c1381b, c0304z3, new C0023f(interfaceC4022a, interfaceC4022aM5087a, c0026b, interfaceC4022aM5087a), 3));
        return c0053l;
    }

    @Override
    public Object get() {
        return (ConnectivityManager) this.f155b.getSystemService("connectivity");
    }

    public C0052k(Context context, int i6) {
        this.f154a = i6;
        this.f155b = context;
    }

    public C0052k(Context context) {
        this.f154a = 1;
        this.f155b = context.getApplicationContext();
    }
}
