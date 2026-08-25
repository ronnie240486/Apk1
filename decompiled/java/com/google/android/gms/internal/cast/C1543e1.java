package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.alibaba.fastjson.asm.Opcodes;
import p005a4.C0049h;
import p018b5.AbstractC1312l;
import p018b5.C1305e;
import p039d5.C2156c;
import p123l5.AbstractC2973a;
import p165p4.C3356a;
import p230v4.C4005s;
import p230v4.C4008v;
import p230v4.C4009w;
import p231v5.C4010a;
import p261y4.InterfaceC4255c;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;
import p271z4.C4343n;

public final class C1543e1 extends AbstractC2973a {

    public final int f5278r;

    public C1543e1(int i6) {
        this.f5278r = i6;
    }

    @Override
    public InterfaceC4255c mo3811c(Context context, Looper looper, C0049h c0049h, Object obj, InterfaceC4260h interfaceC4260h, InterfaceC4261i interfaceC4261i) {
        switch (this.f5278r) {
            case 0:
                return new C1593j1(context, looper, c0049h, (C4343n) interfaceC4260h, (C4343n) interfaceC4261i);
            case 1:
            default:
                return super.mo3811c(context, looper, c0049h, obj, interfaceC4260h, interfaceC4261i);
            case 2:
                return new C1704v0(context, looper, 83, c0049h, interfaceC4260h, interfaceC4261i);
            case 3:
                C3356a c3356a = (C3356a) obj;
                AbstractC1312l.m3199f(c3356a, "Setting the API options is required.");
                return new C4009w(context, looper, c0049h, c3356a.f11346a, 0, c3356a.f11348c, c3356a.f11349d, (C4343n) interfaceC4260h, (C4343n) interfaceC4261i);
            case 4:
                C3356a c3356a2 = (C3356a) obj;
                AbstractC1312l.m3199f(c3356a2, "Setting the API options is required.");
                return new C4008v(context, looper, c0049h, c3356a2.f11346a, 0, c3356a2.f11347b, c3356a2.f11348c, (C4343n) interfaceC4260h, (C4343n) interfaceC4261i);
            case 5:
                if (obj != null) {
                    throw new ClassCastException();
                }
                new Bundle();
                throw null;
            case 6:
                c0049h.getClass();
                Integer num = (Integer) c0049h.f140b;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new C4010a(context, looper, c0049h, bundle, interfaceC4260h, interfaceC4261i);
            case 7:
                obj.getClass();
                throw new ClassCastException();
            case 8:
                return new C4005s(context, looper, Opcodes.IF_ICMPLT, c0049h, interfaceC4260h, interfaceC4261i);
        }
    }

    @Override
    public InterfaceC4255c mo3812d(Context context, Looper looper, C0049h c0049h, Object obj, C4343n c4343n, C4343n c4343n2) {
        switch (this.f5278r) {
            case 1:
                return new C2156c(context, looper, c0049h, (C1305e) obj, c4343n, c4343n2);
            default:
                return super.mo3812d(context, looper, c0049h, obj, c4343n, c4343n2);
        }
    }
}
