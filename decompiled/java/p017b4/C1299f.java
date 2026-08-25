package p017b4;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;
import p007a7.C0069f;

public final class C1299f {

    public final C0069f f4077a;

    public final C1297d f4078b;

    public final HashMap f4079c;

    public C1299f(Context context, C1297d c1297d) {
        C0069f c0069f = new C0069f(7, context);
        this.f4079c = new HashMap();
        this.f4077a = c0069f;
        this.f4078b = c1297d;
    }

    public final synchronized InterfaceC1300g m3175a(String str) {
        if (this.f4079c.containsKey(str)) {
            return (InterfaceC1300g) this.f4079c.get(str);
        }
        CctBackendFactory cctBackendFactoryM218A = this.f4077a.m218A(str);
        if (cctBackendFactoryM218A == null) {
            return null;
        }
        C1297d c1297d = this.f4078b;
        InterfaceC1300g interfaceC1300gCreate = cctBackendFactoryM218A.create(new C1295b(c1297d.f4072a, c1297d.f4073b, c1297d.f4074c, str));
        this.f4079c.put(str, interfaceC1300gCreate);
        return interfaceC1300gCreate;
    }
}
