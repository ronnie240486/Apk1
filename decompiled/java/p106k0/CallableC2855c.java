package p106k0;

import android.content.Context;
import java.util.concurrent.Callable;
import p025c2.C1381b;

public final class CallableC2855c implements Callable {

    public final int f9769a;

    public final String f9770b;

    public final Context f9771c;

    public final C1381b f9772d;

    public final int f9773e;

    public CallableC2855c(String str, Context context, C1381b c1381b, int i6, int i10) {
        this.f9769a = i10;
        this.f9770b = str;
        this.f9771c = context;
        this.f9772d = c1381b;
        this.f9773e = i6;
    }

    @Override
    public final Object call() {
        switch (this.f9769a) {
            case 0:
                return AbstractC2858f.m5859a(this.f9770b, this.f9771c, this.f9772d, this.f9773e);
            default:
                try {
                    return AbstractC2858f.m5859a(this.f9770b, this.f9771c, this.f9772d, this.f9773e);
                } catch (Throwable unused) {
                    return new C2857e(-3);
                }
        }
    }
}
