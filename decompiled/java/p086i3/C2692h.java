package p086i3;

import android.os.Handler;
import android.os.Message;
import ua.C3947h;

public final class C2692h implements Handler.Callback {

    public final int f9352a;

    public final Object f9353b;

    public C2692h(int i6, Object obj) {
        this.f9352a = i6;
        this.f9353b = obj;
    }

    @Override
    public final boolean handleMessage(Message message) {
        switch (this.f9352a) {
            case 0:
                int i6 = message.what;
                C2693i c2693i = (C2693i) this.f9353b;
                if (i6 == 1) {
                    c2693i.m5692b((C2690f) message.obj);
                    return true;
                }
                if (i6 == 2) {
                    c2693i.f9357d.m3569l((C2690f) message.obj);
                }
                return false;
            default:
                if (message.what != 0) {
                    return false;
                }
                C3947h c3947h = (C3947h) this.f9353b;
                if (message.obj != null) {
                    throw new ClassCastException();
                }
                synchronized (c3947h.f13273a) {
                    try {
                        throw null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
