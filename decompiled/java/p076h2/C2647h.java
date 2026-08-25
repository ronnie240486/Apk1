package p076h2;

import java.util.List;
import p008a9.InterfaceC0074d;
import p025c2.C1383d;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p130m2.C3061i;
import p130m2.C3065m;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C2647h extends AbstractC1439i implements InterfaceC2728p {

    public List f9226b;

    public C3065m f9227c;

    public int f9228d;

    public int f9229e;

    public int f9230f;

    public Object f9231g;

    public final C2648i f9232h;

    public final C2640a f9233i;

    public final C3065m f9234j;

    public final List f9235k;

    public final C1383d f9236l;

    public final C3061i f9237m;

    public C2647h(C2648i c2648i, C2640a c2640a, C3065m c3065m, List list, C1383d c1383d, C3061i c3061i, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f9232h = c2648i;
        this.f9233i = c2640a;
        this.f9234j = c3065m;
        this.f9235k = list;
        this.f9236l = c1383d;
        this.f9237m = c3061i;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        C2647h c2647h = new C2647h(this.f9232h, this.f9233i, this.f9234j, this.f9235k, this.f9236l, this.f9237m, interfaceC0074d);
        c2647h.f9231g = obj;
        return c2647h;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C2647h) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p076h2.C2647h.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
