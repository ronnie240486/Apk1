package p016b3;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import java.io.InputStream;

public final class C1273h implements InterfaceC1289v {

    public final int f4020a;

    public final Context f4021b;

    public C1273h(Context context, int i6) {
        this.f4020a = i6;
        this.f4021b = context;
    }

    @Override
    public final InterfaceC1288u mo3136a(C1262b0 c1262b0) {
        switch (this.f4020a) {
            case 0:
                return new C1261b(this.f4021b, this);
            case 1:
                return new C1261b(this.f4021b, this);
            case 2:
                return new C1261b(this.f4021b, this);
            case 3:
                return new C1284q(this.f4021b, 0);
            case 4:
                return new C1261b(this.f4021b, c1262b0.m3140b(Integer.class, AssetFileDescriptor.class));
            case 5:
                return new C1261b(this.f4021b, c1262b0.m3140b(Integer.class, InputStream.class));
            case 6:
                return new C1284q(this.f4021b, 1);
            default:
                return new C1284q(this.f4021b, 2);
        }
    }
}
