package com.google.android.gms.tasks;

import p176q4.C3477d;
import p242w5.InterfaceC4053a;

public class NativeOnCompleteListener implements InterfaceC4053a {
    @Override
    public final void mo3998b(C3477d c3477d) {
        Object objM7131d;
        String message;
        if (c3477d.m7132e()) {
            objM7131d = c3477d.m7131d();
            message = null;
        } else {
            Exception excM7130c = c3477d.m7130c();
            if (excM7130c != null) {
                message = excM7130c.getMessage();
                objM7131d = null;
            } else {
                objM7131d = null;
                message = null;
            }
        }
        nativeOnComplete(0L, objM7131d, c3477d.m7132e(), false, message);
    }

    public native void nativeOnComplete(long j10, Object obj, boolean z7, boolean z10, String str);
}
