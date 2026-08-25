package p025c2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import androidx.lifecycle.AbstractC0541p;
import com.bumptech.glide.AbstractC1466d;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;
import p002a1.C0026b;
import p008a9.C0075e;
import p008a9.C0080j;
import p008a9.InterfaceC0079i;
import p021b9.EnumC1367a;
import p030c9.AbstractC1433c;
import p036d2.C2134c;
import p067g2.C2594a;
import p067g2.C2602i;
import p076h2.C2648i;
import p085i2.C2682a;
import p085i2.C2684c;
import p096j2.C2769a;
import p103j9.AbstractC2796i;
import p108k2.C2864b;
import p130m2.AbstractC3062j;
import p130m2.C3053a;
import p130m2.C3055c;
import p130m2.C3057e;
import p130m2.C3060h;
import p130m2.C3061i;
import p130m2.C3063k;
import p130m2.C3064l;
import p130m2.C3069q;
import p130m2.C3071s;
import p130m2.InterfaceC3068p;
import p130m2.ViewOnAttachStateChangeListenerC3073u;
import p140n2.C3183h;
import p140n2.InterfaceC3184i;
import p150o2.C3246a;
import p156o9.AbstractC3280d;
import p174q2.C3464c;
import p174q2.InterfaceC3466e;
import p185r2.AbstractC3585d;
import p185r2.AbstractC3587f;
import p185r2.C3591j;
import p185r2.ComponentCallbacks2C3594m;
import p187r4.AbstractC3612b;
import p213t9.AbstractC3815a;
import p213t9.AbstractC3819b0;
import p213t9.AbstractC3855p;
import p213t9.AbstractC3865u;
import p213t9.C3826d1;
import p213t9.C3857q;
import p213t9.C3864t0;
import p213t9.C3871x;
import p213t9.InterfaceC3858q0;
import p243w8.C4064f;
import p243w8.C4067i;
import p253x8.AbstractC4147j;
import p254x9.AbstractC4172n;
import p254x9.C4162d;
import p275z9.C4362d;

public final class C1391l {

    public final Context f4233a;

    public final C3055c f4234b;

    public final C4067i f4235c;

    public final C3591j f4236d;

    public final C4162d f4237e;

    public final C0026b f4238f;

    public final C1382c f4239g;

    public final ArrayList f4240h;

    public C1391l(Context context, C3055c c3055c, C4067i c4067i, C4067i c4067i2, C4067i c4067i3, C1382c c1382c, C3591j c3591j) {
        int i6 = 3;
        int i10 = 4;
        int i11 = 1;
        int i12 = 5;
        int i13 = 2;
        int i14 = 0;
        this.f4233a = context;
        this.f4234b = c3055c;
        this.f4235c = c4067i;
        this.f4236d = c3591j;
        C3826d1 c3826d1 = new C3826d1(null);
        C4362d c4362d = AbstractC3819b0.f12901a;
        InterfaceC0079i interfaceC0079iMo253f = AbstractC1466d.m3482A(c3826d1, AbstractC4172n.f14112a.f13237f).mo253f(new C1390k(this));
        this.f4237e = new C4162d(interfaceC0079iMo253f.mo252e(C3857q.f12952b) == null ? interfaceC0079iMo253f.mo253f(new C3864t0(null)) : interfaceC0079iMo253f);
        ComponentCallbacks2C3594m componentCallbacks2C3594m = new ComponentCallbacks2C3594m(this);
        C0026b c0026b = new C0026b(this, componentCallbacks2C3594m);
        this.f4238f = c0026b;
        C1381b c1381b = new C1381b(c1382c);
        c1381b.m3252b(new C2769a(i13), HttpUrl.class);
        c1381b.m3252b(new C2769a(i12), String.class);
        c1381b.m3252b(new C2769a(i11), Uri.class);
        c1381b.m3252b(new C2769a(i10), Uri.class);
        c1381b.m3252b(new C2769a(i6), Integer.class);
        c1381b.m3252b(new C2769a(i14), byte[].class);
        C2684c c2684c = new C2684c();
        ArrayList arrayList = (ArrayList) c1381b.f4200d;
        arrayList.add(new C4064f(c2684c, Uri.class));
        arrayList.add(new C4064f(new C2682a(c3591j.f12075a), File.class));
        c1381b.m3251a(new C2602i(c4067i3, c4067i2, c3591j.f12077c), Uri.class);
        c1381b.m3251a(new C2594a(i12), File.class);
        c1381b.m3251a(new C2594a(i14), Uri.class);
        c1381b.m3251a(new C2594a(i6), Uri.class);
        c1381b.m3251a(new C2594a(6), Uri.class);
        c1381b.m3251a(new C2594a(i10), Drawable.class);
        c1381b.m3251a(new C2594a(1), Bitmap.class);
        c1381b.m3251a(new C2594a(2), ByteBuffer.class);
        C2134c c2134c = new C2134c(c3591j.f12078d, c3591j.f12079e);
        ArrayList arrayList2 = (ArrayList) c1381b.f4202f;
        arrayList2.add(c2134c);
        List listM6571J = AbstractC3280d.m6571J((ArrayList) c1381b.f4198b);
        this.f4239g = new C1382c(listM6571J, AbstractC3280d.m6571J((ArrayList) c1381b.f4199c), AbstractC3280d.m6571J(arrayList), AbstractC3280d.m6571J((ArrayList) c1381b.f4201e), AbstractC3280d.m6571J(arrayList2));
        this.f4240h = AbstractC4147j.m8187a0(listM6571J, new C2648i(this, componentCallbacks2C3594m, c0026b));
        new AtomicBoolean(false);
    }

    public static final Object m3264a(C1391l c1391l, C3061i c3061i, AbstractC1433c abstractC1433c) {
        C1388i c1388i;
        int i6;
        ?? r10;
        ?? r11;
        C1383d c1383d;
        C1391l c1391l2;
        Bitmap bitmap;
        Object objMo6380a;
        C1383d c1383d2;
        C1391l c1391l3;
        Object objM7701p;
        C1383d c1383d3;
        C1391l c1391l4;
        ?? r12;
        ?? r13;
        AbstractC3062j abstractC3062j;
        ?? r14;
        InterfaceC3068p interfaceC3068p;
        C3061i c3061i2;
        AbstractC3062j abstractC3062j2;
        C3069q c3069q;
        C3246a c3246a;
        C3061i c3061i3;
        boolean z7;
        Drawable drawable;
        InterfaceC3466e interfaceC3466eMo7097a;
        InterfaceC3068p interfaceC3068p2;
        C3061i c3061i4;
        InterfaceC3068p interfaceC3068p3;
        C3061i c3061i5;
        Drawable drawableM7207b;
        C3246a c3246a2;
        Object obj;
        InterfaceC3068p c3071s;
        C3061i c3061iM6109a;
        C1383d c1383d4;
        int i10;
        C1391l c1391l5 = c1391l;
        c1391l.getClass();
        if (abstractC1433c instanceof C1388i) {
            c1388i = (C1388i) abstractC1433c;
            i10 = c1388i.f4225h;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                int i11 = i10 - Integer.MIN_VALUE;
                c1388i.f4225h = i11;
                i6 = i11;
            } else {
                c1388i = new C1388i(c1391l5, abstractC1433c);
                i6 = i10;
            }
        } else {
            c1388i = new C1388i(c1391l5, abstractC1433c);
            i6 = i10;
        }
        C1388i c1388i2 = c1388i;
        Object obj2 = c1388i2.f4223f;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i12 = c1388i2.f4225h;
        if (i12 != 0) {
            try {
                if (i12 == 1) {
                    C1383d c1383d5 = c1388i2.f4221d;
                    C3061i c3061i6 = c1388i2.f4220c;
                    InterfaceC3068p interfaceC3068p4 = c1388i2.f4219b;
                    C1391l c1391l6 = c1388i2.f4218a;
                    AbstractC3280d.m6570I(obj2);
                    c1383d = c1383d5;
                    c1391l2 = c1391l6;
                    c3061i5 = c3061i6;
                    interfaceC3068p3 = interfaceC3068p4;
                    c1391l2 = c1391l5;
                    c1383d = c1383d4;
                    c3061i5 = c3061iM6109a;
                    interfaceC3068p3 = c3071s;
                    if (((C2864b) c1391l2.f4235c.getValue()) != null) {
                        c3061i5.getClass();
                    }
                    drawableM7207b = AbstractC3585d.m7207b(c3061i5, c3061i5.f10493z, c3061i5.f10492y, c3061i5.f10467D.f10428j);
                    c3246a2 = c3061i5.f10470c;
                    if (c3246a2 != null) {
                        c3246a2.m6555g(drawableM7207b);
                    }
                    c1383d.getClass();
                    InterfaceC3184i interfaceC3184i = c3061i5.f10489v;
                    c1388i2.f4218a = c1391l2;
                    c1388i2.f4219b = interfaceC3068p3;
                    c1388i2.f4220c = c3061i5;
                    c1388i2.f4221d = c1383d;
                    c1388i2.f4222e = null;
                    c1388i2.f4225h = 2;
                    objMo6380a = interfaceC3184i.mo6380a(c1388i2);
                    if (objMo6380a == enumC1367a) {
                        obj = enumC1367a;
                    } else {
                        bitmap = null;
                        c1391l3 = c1391l2;
                        c1383d2 = c1383d;
                        c3061i4 = c3061i5;
                        interfaceC3068p2 = interfaceC3068p3;
                        C3183h c3183h = (C3183h) objMo6380a;
                        c1383d2.getClass();
                        AbstractC3855p abstractC3855p = c3061i4.f10484q;
                        C1389j c1389j = new C1389j(c3061i4, c1391l3, c3183h, c1383d2, bitmap, null);
                        c1388i2.f4218a = c1391l3;
                        c1388i2.f4219b = interfaceC3068p2;
                        c1388i2.f4220c = c3061i4;
                        c1388i2.f4221d = c1383d2;
                        c1388i2.f4222e = null;
                        c1388i2.f4225h = 3;
                        objM7701p = AbstractC3865u.m7701p(abstractC3855p, c1389j, c1388i2);
                        c1391l4 = c1391l3;
                        c1383d3 = c1383d2;
                        c3061i2 = c3061i4;
                        interfaceC3068p = interfaceC3068p2;
                        if (objM7701p == enumC1367a) {
                            obj = enumC1367a;
                        }
                    }
                } else if (i12 == 2) {
                    Bitmap bitmap2 = c1388i2.f4222e;
                    C1383d c1383d6 = c1388i2.f4221d;
                    C3061i c3061i7 = c1388i2.f4220c;
                    InterfaceC3068p interfaceC3068p5 = c1388i2.f4219b;
                    C1391l c1391l7 = c1388i2.f4218a;
                    AbstractC3280d.m6570I(obj2);
                    bitmap = bitmap2;
                    objMo6380a = obj2;
                    c1383d2 = c1383d6;
                    c1391l3 = c1391l7;
                    c3061i4 = c3061i7;
                    interfaceC3068p2 = interfaceC3068p5;
                    C3183h c3183h2 = (C3183h) objMo6380a;
                    c1383d2.getClass();
                    AbstractC3855p abstractC3855p2 = c3061i4.f10484q;
                    C1389j c1389j2 = new C1389j(c3061i4, c1391l3, c3183h2, c1383d2, bitmap, null);
                    c1388i2.f4218a = c1391l3;
                    c1388i2.f4219b = interfaceC3068p2;
                    c1388i2.f4220c = c3061i4;
                    c1388i2.f4221d = c1383d2;
                    c1388i2.f4222e = null;
                    c1388i2.f4225h = 3;
                    objM7701p = AbstractC3865u.m7701p(abstractC3855p2, c1389j2, c1388i2);
                    c1391l4 = c1391l3;
                    c1383d3 = c1383d2;
                    c3061i2 = c3061i4;
                    interfaceC3068p = interfaceC3068p2;
                    if (objM7701p == enumC1367a) {
                        obj = enumC1367a;
                    }
                } else {
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C1383d c1383d7 = c1388i2.f4221d;
                    C3061i c3061i8 = c1388i2.f4220c;
                    InterfaceC3068p interfaceC3068p6 = c1388i2.f4219b;
                    C1391l c1391l8 = c1388i2.f4218a;
                    AbstractC3280d.m6570I(obj2);
                    objM7701p = obj2;
                    c1383d3 = c1383d7;
                    c1391l4 = c1391l8;
                    c3061i2 = c3061i8;
                    interfaceC3068p = interfaceC3068p6;
                }
                abstractC3062j2 = (AbstractC3062j) objM7701p;
                if (abstractC3062j2 instanceof C3069q) {
                    c3069q = (C3069q) abstractC3062j2;
                    c3246a = c3061i2.f10470c;
                    c1391l4.getClass();
                    c3061i3 = c3069q.f10515b;
                    z7 = c3246a instanceof C3246a;
                    drawable = c3069q.f10514a;
                    if (!z7) {
                        interfaceC3466eMo7097a = c3061i3.f10474g.mo7097a(c3246a, c3069q);
                        if (interfaceC3466eMo7097a instanceof C3464c) {
                            c3246a.m6555g(drawable);
                        } else {
                            c1383d3.getClass();
                            interfaceC3466eMo7097a.mo3274a();
                        }
                    } else if (c3246a != null) {
                        c3246a.m6555g(drawable);
                    }
                    c1383d3.getClass();
                    c3061i3.getClass();
                    r14 = interfaceC3068p;
                    abstractC3062j = abstractC3062j2;
                } else if (abstractC3062j2 instanceof C3057e) {
                    r14 = interfaceC3068p;
                    abstractC3062j = abstractC3062j2;
                    C3246a c3246a3 = c3061i2.f10470c;
                    c1391l4.getClass();
                    m3265c((C3057e) abstractC3062j2, c3246a3, c1383d3);
                    r14 = interfaceC3068p;
                    abstractC3062j = abstractC3062j2;
                }
            } catch (Throwable th) {
                th = th;
                r10 = c1391l5;
                r11 = -2147483648;
                r13 = i12;
                r12 = i6;
                try {
                    if (!(th instanceof CancellationException)) {
                        r11.getClass();
                        r10.getClass();
                        r13.getClass();
                        throw th;
                    }
                    r11.f4238f.getClass();
                    C3057e c3057eM115k = C0026b.m115k(r13, th);
                    m3265c(c3057eM115k, r13.f10470c, r10);
                    r14 = r12;
                    abstractC3062j = c3057eM115k;
                } catch (Throwable th2) {
                    r12.mo6105a();
                    throw th2;
                }
            }
            r14 = interfaceC3068p;
            abstractC3062j = abstractC3062j2;
            r14.mo6105a();
            obj = abstractC3062j;
        } else {
            AbstractC3280d.m6570I(obj2);
            InterfaceC3858q0 interfaceC3858q0M7692g = AbstractC3865u.m7692g(c1388i2.getContext());
            C0026b c0026b = c1391l5.f4238f;
            c0026b.getClass();
            AbstractC0541p abstractC0541p = c3061i.f10488u;
            C3246a c3246a4 = c3061i.f10470c;
            c3071s = c3246a4 instanceof C3246a ? new C3071s((C1391l) c0026b.f54b, c3061i, c3246a4, abstractC0541p, interfaceC3858q0M7692g) : new C3053a(abstractC0541p, interfaceC3858q0M7692g);
            c3071s.mo6106f();
            C3060h c3060h = new C3060h(c3061i, c3061i.f10468a);
            c3060h.f10444b = c1391l5.f4234b;
            c3060h.f10463u = null;
            c3061iM6109a = c3060h.m6109a();
            c1383d4 = C1383d.f4208a;
            try {
                if (c3061iM6109a.f10469b == C3063k.f10494b) {
                    throw new C3064l("The request's data is null.");
                }
                c3071s.start();
                AbstractC0541p abstractC0541p2 = c3061iM6109a.f10488u;
                c1388i2.f4218a = c1391l5;
                c1388i2.f4219b = c3071s;
                c1388i2.f4220c = c3061iM6109a;
                c1388i2.f4221d = c1383d4;
                c1388i2.f4225h = 1;
                if (AbstractC3612b.m7262b(abstractC0541p2, c1388i2) == enumC1367a) {
                    c1391l2 = c1391l5;
                    c1383d = c1383d4;
                    c3061i5 = c3061iM6109a;
                    interfaceC3068p3 = c3071s;
                    obj = enumC1367a;
                } else {
                    c1391l2 = c1391l5;
                    c1383d = c1383d4;
                    c3061i5 = c3061iM6109a;
                    interfaceC3068p3 = c3071s;
                    if (((C2864b) c1391l2.f4235c.getValue()) != null) {
                        c3061i5.getClass();
                    }
                    drawableM7207b = AbstractC3585d.m7207b(c3061i5, c3061i5.f10493z, c3061i5.f10492y, c3061i5.f10467D.f10428j);
                    c3246a2 = c3061i5.f10470c;
                    if (c3246a2 != null) {
                        c3246a2.m6555g(drawableM7207b);
                    }
                    c1383d.getClass();
                    InterfaceC3184i interfaceC3184i2 = c3061i5.f10489v;
                    c1388i2.f4218a = c1391l2;
                    c1388i2.f4219b = interfaceC3068p3;
                    c1388i2.f4220c = c3061i5;
                    c1388i2.f4221d = c1383d;
                    c1388i2.f4222e = null;
                    c1388i2.f4225h = 2;
                    objMo6380a = interfaceC3184i2.mo6380a(c1388i2);
                    if (objMo6380a == enumC1367a) {
                        obj = enumC1367a;
                    } else {
                        bitmap = null;
                        c1391l3 = c1391l2;
                        c1383d2 = c1383d;
                        c3061i4 = c3061i5;
                        interfaceC3068p2 = interfaceC3068p3;
                        C3183h c3183h3 = (C3183h) objMo6380a;
                        c1383d2.getClass();
                        AbstractC3855p abstractC3855p3 = c3061i4.f10484q;
                        C1389j c1389j3 = new C1389j(c3061i4, c1391l3, c3183h3, c1383d2, bitmap, null);
                        c1388i2.f4218a = c1391l3;
                        c1388i2.f4219b = interfaceC3068p2;
                        c1388i2.f4220c = c3061i4;
                        c1388i2.f4221d = c1383d2;
                        c1388i2.f4222e = null;
                        c1388i2.f4225h = 3;
                        objM7701p = AbstractC3865u.m7701p(abstractC3855p3, c1389j3, c1388i2);
                        c1391l4 = c1391l3;
                        c1383d3 = c1383d2;
                        c3061i2 = c3061i4;
                        interfaceC3068p = interfaceC3068p2;
                        if (objM7701p == enumC1367a) {
                            obj = enumC1367a;
                        } else {
                            abstractC3062j2 = (AbstractC3062j) objM7701p;
                            if (abstractC3062j2 instanceof C3069q) {
                                c3069q = (C3069q) abstractC3062j2;
                                c3246a = c3061i2.f10470c;
                                c1391l4.getClass();
                                c3061i3 = c3069q.f10515b;
                                z7 = c3246a instanceof C3246a;
                                drawable = c3069q.f10514a;
                                if (!z7) {
                                    interfaceC3466eMo7097a = c3061i3.f10474g.mo7097a(c3246a, c3069q);
                                    if (interfaceC3466eMo7097a instanceof C3464c) {
                                        c3246a.m6555g(drawable);
                                    } else {
                                        c1383d3.getClass();
                                        interfaceC3466eMo7097a.mo3274a();
                                    }
                                } else if (c3246a != null) {
                                    c3246a.m6555g(drawable);
                                }
                                c1383d3.getClass();
                                c3061i3.getClass();
                                r14 = interfaceC3068p;
                                abstractC3062j = abstractC3062j2;
                            } else if (abstractC3062j2 instanceof C3057e) {
                                r14 = interfaceC3068p;
                                abstractC3062j = abstractC3062j2;
                                C3246a c3246a5 = c3061i2.f10470c;
                                c1391l4.getClass();
                                m3265c((C3057e) abstractC3062j2, c3246a5, c1383d3);
                                r14 = interfaceC3068p;
                                abstractC3062j = abstractC3062j2;
                            }
                            r14 = interfaceC3068p;
                            abstractC3062j = abstractC3062j2;
                            r14.mo6105a();
                            obj = abstractC3062j;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r11 = c1391l5;
                r10 = c1383d4;
                r13 = c3061iM6109a;
                r12 = c3071s;
                if (!(th instanceof CancellationException)) {
                    r11.getClass();
                    r10.getClass();
                    r13.getClass();
                    throw th;
                }
                r11.f4238f.getClass();
                C3057e c3057eM115k2 = C0026b.m115k(r13, th);
                m3265c(c3057eM115k2, r13.f10470c, r10);
                r14 = r12;
                abstractC3062j = c3057eM115k2;
            }
        }
        return obj;
    }

    public static void m3265c(C3057e c3057e, C3246a c3246a, C1383d c1383d) {
        C3061i c3061i = c3057e.f10439b;
        boolean z7 = c3246a instanceof C3246a;
        Drawable drawable = c3057e.f10438a;
        if (z7) {
            InterfaceC3466e interfaceC3466eMo7097a = c3061i.f10474g.mo7097a(c3246a, c3057e);
            if (interfaceC3466eMo7097a instanceof C3464c) {
                c3246a.m6555g(drawable);
            } else {
                c1383d.getClass();
                interfaceC3466eMo7097a.mo3274a();
            }
        } else if (c3246a != null) {
            c3246a.m6555g(drawable);
        }
        c1383d.getClass();
        c3061i.getClass();
    }

    public final C3063k m3266b(C3061i c3061i) {
        C4162d c4162d = this.f4237e;
        C1387h c1387h = new C1387h(this, c3061i, null);
        boolean z7 = true;
        InterfaceC0079i interfaceC0079iM7690e = AbstractC3865u.m7690e(c4162d.mo1512d(), C0080j.f206a, true);
        C4362d c4362d = AbstractC3819b0.f12901a;
        if (interfaceC0079iM7690e != c4362d && interfaceC0079iM7690e.mo252e(C0075e.f205a) == null) {
            interfaceC0079iM7690e = interfaceC0079iM7690e.mo253f(c4362d);
        }
        AbstractC3815a c3871x = new C3871x(interfaceC0079iM7690e, z7, 0);
        c3871x.m7635I(1, c3871x, c1387h);
        C3246a c3246a = c3061i.f10470c;
        if (!(c3246a instanceof C3246a)) {
            return new C3063k(1);
        }
        ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073uM7210c = AbstractC3587f.m7210c(c3246a.f10870b);
        synchronized (viewOnAttachStateChangeListenerC3073uM7210c) {
            C3063k c3063k = viewOnAttachStateChangeListenerC3073uM7210c.f10530b;
            if (c3063k != null && AbstractC2796i.m5780a(Looper.myLooper(), Looper.getMainLooper()) && viewOnAttachStateChangeListenerC3073uM7210c.f10533e) {
                viewOnAttachStateChangeListenerC3073uM7210c.f10533e = false;
                return c3063k;
            }
            C3871x c3871x2 = viewOnAttachStateChangeListenerC3073uM7210c.f10531c;
            if (c3871x2 != null) {
                AbstractC3865u.m7688c(c3871x2);
            }
            viewOnAttachStateChangeListenerC3073uM7210c.f10531c = null;
            C3063k c3063k2 = new C3063k(viewOnAttachStateChangeListenerC3073uM7210c.f10529a);
            viewOnAttachStateChangeListenerC3073uM7210c.f10530b = c3063k2;
            return c3063k2;
        }
    }
}
