package p231v5;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.AbstractC1500a;
import p005a4.C0049h;
import p261y4.InterfaceC4255c;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;

public final class C4010a extends AbstractC1500a implements InterfaceC4255c {

    public final C0049h f13600A;

    public final Bundle f13601B;

    public final Integer f13602C;

    public final boolean f13603z;

    public C4010a(Context context, Looper looper, C0049h c0049h, Bundle bundle, InterfaceC4260h interfaceC4260h, InterfaceC4261i interfaceC4261i) {
        super(context, looper, 44, c0049h, interfaceC4260h, interfaceC4261i);
        this.f13603z = true;
        this.f13600A = c0049h;
        this.f13601B = bundle;
        this.f13602C = (Integer) c0049h.f140b;
    }

    @Override
    public final int mo3875d() {
        return 12451000;
    }

    @Override
    public final boolean mo3658k() {
        return this.f13603z;
    }

    @Override
    public final IInterface mo3659l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof C4011b ? (C4011b) iInterfaceQueryLocalInterface : new C4011b(iBinder, "com.google.android.gms.signin.internal.ISignInService", 1);
    }

    @Override
    public final Bundle mo3662o() {
        C0049h c0049h = this.f13600A;
        boolean zEquals = this.f5071c.getPackageName().equals((String) c0049h.f139a);
        Bundle bundle = this.f13601B;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) c0049h.f139a);
        }
        return bundle;
    }

    @Override
    public final String mo3664q() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override
    public final String mo3665r() {
        return "com.google.android.gms.signin.service.START";
    }
}
