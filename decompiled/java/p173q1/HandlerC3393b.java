package p173q1;

import android.os.Handler;
import android.os.Message;
import androidx.media3.extractor.p010ts.TsExtractor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class HandlerC3393b extends Handler {

    public final ArrayList f11427a = new ArrayList();

    public final ArrayList f11428b = new ArrayList();

    public final C3411h f11429c;

    public HandlerC3393b(C3411h c3411h) {
        this.f11429c = c3411h;
    }

    public static void m6885a(C3430n0 c3430n0, int i6, Object obj, int i10) {
        C3445s0 c3445s0;
        C3445s0 c3445s1;
        C3451u0 c3451u0 = c3430n0.f11592a;
        int i11 = 65280 & i6;
        AbstractC3427m0 abstractC3427m0 = c3430n0.f11593b;
        if (i11 != 256) {
            if (i11 != 512) {
                if (i11 == 768 && i6 == 769) {
                    abstractC3427m0.mo2759n((C3457x0) obj);
                    return;
                }
                return;
            }
            switch (i6) {
                case 513:
                    abstractC3427m0.mo2750a();
                    return;
                case 514:
                    abstractC3427m0.mo2752c();
                    return;
                case 515:
                    abstractC3427m0.mo2751b();
                    return;
                default:
                    return;
            }
        }
        if (i6 == 264 || i6 == 262) {
            C3408g c3408g = (C3408g) obj;
            C3445s0 c3445s2 = c3408g.f11474b;
            c3445s0 = c3408g.f11473a;
            c3445s1 = c3445s2;
        } else {
            if (i6 == 265 || i6 == 266) {
                obj.getClass();
                throw new ClassCastException();
            }
            c3445s1 = (C3445s0) obj;
            c3445s0 = null;
        }
        if (c3445s1 != null) {
            boolean zM7021d = true;
            if ((c3430n0.f11595d & 2) == 0 && !c3445s1.m7025h(c3430n0.f11594c)) {
                C3457x0 c3457x0 = C3451u0.m7068c().f11508u;
                zM7021d = ((c3457x0 == null ? false : c3457x0.f11710c) && c3445s1.m7021d() && i6 == 262 && i10 == 3 && c3445s0 != null) ? true ^ c3445s0.m7021d() : false;
            }
            if (zM7021d) {
                switch (i6) {
                    case TsExtractor.TS_STREAM_TYPE_AIT:
                        abstractC3427m0.mo2753d(c3451u0, c3445s1);
                        return;
                    case 258:
                        abstractC3427m0.mo2755h(c3451u0, c3445s1);
                        return;
                    case 259:
                        abstractC3427m0.mo2754e(c3451u0, c3445s1);
                        return;
                    case 260:
                        abstractC3427m0.mo2758m(c3445s1);
                        return;
                    case 261:
                        abstractC3427m0.getClass();
                        return;
                    case 262:
                        abstractC3427m0.mo3965j(c3451u0, c3445s1, i10, c3445s1);
                        return;
                    case 263:
                        abstractC3427m0.mo3966l(c3451u0, c3445s1, i10);
                        return;
                    case 264:
                        abstractC3427m0.mo3965j(c3451u0, c3445s1, i10, c3445s0);
                        return;
                    case 265:
                        abstractC3427m0.mo3963f(c3445s0, c3445s1);
                        return;
                    case 266:
                        abstractC3427m0.mo3964g(c3445s0, c3445s1, i10);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void m6886b(int i6, Object obj) {
        obtainMessage(i6, obj).sendToTarget();
    }

    @Override
    public final void handleMessage(Message message) {
        int iM6914k;
        ArrayList arrayList = this.f11427a;
        int i6 = message.what;
        Object obj = message.obj;
        int i10 = message.arg1;
        C3411h c3411h = this.f11429c;
        if (i6 == 259 && c3411h.m6940g().f11654c.equals(((C3445s0) obj).f11654c)) {
            c3411h.m6949p(true);
        }
        ArrayList arrayList2 = this.f11428b;
        if (i6 == 262) {
            C3408g c3408g = (C3408g) obj;
            C3445s0 c3445s0 = c3408g.f11474b;
            if (c3408g.f11475c) {
                c3411h.f11506s.m6918q(c3445s0);
            }
            if (c3411h.f11509v != null && c3445s0.m7021d()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    c3411h.f11506s.m6917p((C3445s0) it.next());
                }
                arrayList2.clear();
            }
        } else if (i6 != 264) {
            switch (i6) {
                case TsExtractor.TS_STREAM_TYPE_AIT:
                    c3411h.f11506s.m6916o((C3445s0) obj);
                    break;
                case 258:
                    c3411h.f11506s.m6917p((C3445s0) obj);
                    break;
                case 259:
                    C3404e1 c3404e1 = c3411h.f11506s;
                    C3445s0 c3445s1 = (C3445s0) obj;
                    c3404e1.getClass();
                    if (c3445s1.m7020c() != c3404e1 && (iM6914k = c3404e1.m6914k(c3445s1)) >= 0) {
                        C3404e1.m6910t((C3401d1) c3404e1.f11469r.get(iM6914k));
                    }
                    break;
            }
        } else {
            C3408g c3408g2 = (C3408g) obj;
            C3445s0 c3445s2 = c3408g2.f11474b;
            arrayList2.add(c3445s2);
            c3411h.f11506s.m6916o(c3445s2);
            if (c3408g2.f11475c) {
                c3411h.f11506s.m6918q(c3445s2);
            }
        }
        try {
            int size = c3411h.f11495h.size();
            while (true) {
                size--;
                if (size < 0) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        m6885a((C3430n0) it2.next(), i6, obj, i10);
                    }
                    return;
                } else {
                    ArrayList arrayList3 = c3411h.f11495h;
                    C3451u0 c3451u0 = (C3451u0) ((WeakReference) arrayList3.get(size)).get();
                    if (c3451u0 == null) {
                        arrayList3.remove(size);
                    } else {
                        arrayList.addAll(c3451u0.f11689b);
                    }
                }
            }
        } finally {
            arrayList.clear();
        }
    }
}
