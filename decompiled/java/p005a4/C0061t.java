package p005a4;

import android.content.Context;
import p000a.RunnableC0001b;
import p069g4.InterfaceC2612b;
import p077h4.C2659i;
import p077h4.C2660j;
import p110k4.InterfaceC2890a;

public final class C0061t {

    public static volatile C0053l f170e;

    public final InterfaceC2890a f171a;

    public final InterfaceC2890a f172b;

    public final InterfaceC2612b f173c;

    public final C2659i f174d;

    public C0061t(InterfaceC2890a interfaceC2890a, InterfaceC2890a interfaceC2890a2, InterfaceC2612b interfaceC2612b, C2659i c2659i, C2660j c2660j) {
        this.f171a = interfaceC2890a;
        this.f172b = interfaceC2890a2;
        this.f173c = interfaceC2612b;
        this.f174d = c2659i;
        c2660j.getClass();
        c2660j.f9286a.execute(new RunnableC0001b(10, c2660j));
    }

    public static C0061t m206a() {
        C0053l c0053l = f170e;
        if (c0053l != null) {
            return (C0061t) c0053l.f160e.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void m207b(Context context) {
        if (f170e == null) {
            synchronized (C0061t.class) {
                try {
                    if (f170e == null) {
                        C0052k c0052k = new C0052k();
                        context.getClass();
                        c0052k.f155b = context;
                        f170e = c0052k.m205b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
