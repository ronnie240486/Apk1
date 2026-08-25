package p151o3;

import android.os.Handler;
import android.os.Message;
import p247x2.InterfaceC4102x;

public final class C3251e implements Handler.Callback {

    public final int f10884a;

    public C3251e(int i6) {
        this.f10884a = i6;
    }

    @Override
    public final boolean handleMessage(Message message) {
        switch (this.f10884a) {
            case 0:
                if (message.what != 1) {
                    return false;
                }
                C3252f c3252f = (C3252f) message.obj;
                c3252f.f10886d.m3569l(c3252f);
                return true;
            default:
                if (message.what != 1) {
                    return false;
                }
                ((InterfaceC4102x) message.obj).mo5405d();
                return true;
        }
    }
}
