package p271z4;

import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import p000a.AbstractC0004e;
import p187r4.C3633w;
import p261y4.InterfaceC4264l;

public final class HandlerC4333d extends HandlerC1731y0 {
    @Override
    public final void handleMessage(Message message) {
        int i6 = message.what;
        if (i6 != 1) {
            if (i6 != 2) {
                Log.wtf("BasePendingResult", AbstractC0004e.m20n(i6, "Don't know how to handle message: "), new Exception());
                return;
            } else {
                ((BasePendingResult) message.obj).m3640d0(Status.f4992f);
                return;
            }
        }
        Pair pair = (Pair) message.obj;
        try {
            ((C3633w) pair.first).m7359a((InterfaceC4264l) pair.second);
        } catch (RuntimeException e5) {
            int i10 = BasePendingResult.f4998q;
            throw e5;
        }
    }
}
