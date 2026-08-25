package p173q1;

import android.os.Message;
import androidx.media3.common.C0565C;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import p000a.RunnableC0001b;

public final class C3439q0 {

    public final AbstractC3397c0 f11629a;

    public final int f11630b;

    public final boolean f11631c;

    public final C3445s0 f11632d;

    public final C3445s0 f11633e;

    public final C3445s0 f11634f;

    public final ArrayList f11635g;

    public final WeakReference f11636h;

    public boolean f11637i = false;

    public boolean f11638j = false;

    public C3439q0(C3411h c3411h, C3445s0 c3445s0, AbstractC3397c0 abstractC3397c0, int i6, boolean z7, C3445s0 c3445s1, ArrayList arrayList) {
        this.f11636h = new WeakReference(c3411h);
        this.f11633e = c3445s0;
        this.f11629a = abstractC3397c0;
        this.f11630b = i6;
        this.f11631c = z7;
        this.f11632d = c3411h.f11491d;
        this.f11634f = c3445s1;
        this.f11635g = arrayList == null ? null : new ArrayList(arrayList);
        c3411h.f11488a.postDelayed(new RunnableC0001b(15, this), C0565C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    public final void m7017a() {
        C3436p0 c3436p0M7019a;
        C3451u0.m7067b();
        if (this.f11637i || this.f11638j) {
            return;
        }
        WeakReference weakReference = this.f11636h;
        C3411h c3411h = (C3411h) weakReference.get();
        AbstractC3397c0 abstractC3397c0 = this.f11629a;
        if (c3411h == null || c3411h.f11493f != this) {
            if (this.f11637i || this.f11638j) {
                return;
            }
            this.f11638j = true;
            if (abstractC3397c0 != null) {
                abstractC3397c0.mo6900i(0);
                abstractC3397c0.mo6897e();
                return;
            }
            return;
        }
        this.f11637i = true;
        c3411h.f11493f = null;
        C3411h c3411h2 = (C3411h) weakReference.get();
        int i6 = this.f11630b;
        C3445s0 c3445s0 = this.f11632d;
        if (c3411h2 != null && c3411h2.f11491d == c3445s0) {
            Message messageObtainMessage = c3411h2.f11488a.obtainMessage(263, c3445s0);
            messageObtainMessage.arg1 = i6;
            messageObtainMessage.sendToTarget();
            AbstractC3397c0 abstractC3397c1 = c3411h2.f11492e;
            if (abstractC3397c1 != null) {
                abstractC3397c1.mo6900i(i6);
                c3411h2.f11492e.mo6897e();
            }
            HashMap map = c3411h2.f11489b;
            if (!map.isEmpty()) {
                for (AbstractC3397c0 abstractC3397c2 : map.values()) {
                    abstractC3397c2.mo6900i(i6);
                    abstractC3397c2.mo6897e();
                }
                map.clear();
            }
            c3411h2.f11492e = null;
        }
        C3411h c3411h3 = (C3411h) weakReference.get();
        if (c3411h3 == null) {
            return;
        }
        C3445s0 c3445s1 = this.f11633e;
        c3411h3.f11491d = c3445s1;
        c3411h3.f11492e = abstractC3397c0;
        boolean z7 = this.f11631c;
        HandlerC3393b handlerC3393b = c3411h3.f11488a;
        C3445s0 c3445s2 = this.f11634f;
        if (c3445s2 == null) {
            handlerC3393b.getClass();
            Message messageObtainMessage2 = handlerC3393b.obtainMessage(262, new C3408g(c3445s0, c3445s1, z7));
            messageObtainMessage2.arg1 = i6;
            messageObtainMessage2.sendToTarget();
        } else {
            handlerC3393b.getClass();
            Message messageObtainMessage3 = handlerC3393b.obtainMessage(264, new C3408g(c3445s2, c3445s1, z7));
            messageObtainMessage3.arg1 = i6;
            messageObtainMessage3.sendToTarget();
        }
        c3411h3.f11489b.clear();
        c3411h3.m6942i();
        c3411h3.m6946m();
        ArrayList arrayList = this.f11635g;
        if (arrayList == null || (c3436p0M7019a = c3411h3.f11491d.m7019a()) == null) {
            return;
        }
        c3436p0M7019a.m7015p(arrayList);
    }
}
