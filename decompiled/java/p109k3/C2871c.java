package p109k3;

import android.content.Context;
import com.bumptech.glide.C1490n;
import java.util.HashSet;

public final class C2871c implements InterfaceC2870b {

    public final Context f9802a;

    public final C1490n f9803b;

    public C2871c(Context context, C1490n c1490n) {
        this.f9802a = context.getApplicationContext();
        this.f9803b = c1490n;
    }

    @Override
    public final void mo3559c() {
        C2888t c2888tM5884b = C2888t.m5884b(this.f9802a);
        C1490n c1490n = this.f9803b;
        synchronized (c2888tM5884b) {
            ((HashSet) c2888tM5884b.f9833d).remove(c1490n);
            if (c2888tM5884b.f9831b && ((HashSet) c2888tM5884b.f9833d).isEmpty()) {
                ((InterfaceC2883o) c2888tM5884b.f9832c).mo5379a();
                c2888tM5884b.f9831b = false;
            }
        }
    }

    @Override
    public final void mo3565i() {
        C2888t c2888tM5884b = C2888t.m5884b(this.f9802a);
        C1490n c1490n = this.f9803b;
        synchronized (c2888tM5884b) {
            ((HashSet) c2888tM5884b.f9833d).add(c1490n);
            if (!c2888tM5884b.f9831b && !((HashSet) c2888tM5884b.f9833d).isEmpty()) {
                c2888tM5884b.f9831b = ((InterfaceC2883o) c2888tM5884b.f9832c).mo5380b();
            }
        }
    }

    @Override
    public final void mo3566j() {
    }
}
