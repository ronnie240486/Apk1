package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.mediarouter.app.DialogC1086f;
import p109k3.C2887s;
import p109k3.RunnableC2886r;
import p173q1.C3434o1;

public final class C0125b0 extends BroadcastReceiver {

    public final int f262a;

    public final Object f263b;

    public C0125b0(int i6, Object obj) {
        this.f262a = i6;
        this.f263b = obj;
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        switch (this.f262a) {
            case 0:
                ((AbstractC0127c0) this.f263b).mo370l();
                break;
            case 1:
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    ((DialogC1086f) this.f263b).dismiss();
                }
                break;
            case 2:
                C2887s c2887s = (C2887s) this.f263b;
                c2887s.getClass();
                C2887s.f9822g.execute(new RunnableC2886r(c2887s, 2));
                break;
            default:
                ((C3434o1) this.f263b).m7009a();
                break;
        }
    }
}
