package p247x2;

import com.bumptech.glide.load.data.InterfaceC1478d;
import java.io.File;
import java.util.List;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p228v2.InterfaceC3978e;

public final class C4081c implements InterfaceC4084f, InterfaceC1478d {

    public final List f13761a;

    public final C4085g f13762b;

    public final InterfaceC4083e f13763c;

    public int f13764d = -1;

    public InterfaceC3978e f13765e;

    public List f13766f;

    public int f13767g;

    public volatile C1287t f13768h;

    public File f13769i;

    public C4081c(List list, C4085g c4085g, InterfaceC4083e interfaceC4083e) {
        this.f13761a = list;
        this.f13762b = c4085g;
        this.f13763c = interfaceC4083e;
    }

    @Override
    public final boolean mo8068b() {
        while (true) {
            List list = this.f13766f;
            boolean z7 = false;
            if (list != null && this.f13767g < list.size()) {
                this.f13768h = null;
                while (!z7 && this.f13767g < this.f13766f.size()) {
                    List list2 = this.f13766f;
                    int i6 = this.f13767g;
                    this.f13767g = i6 + 1;
                    InterfaceC1288u interfaceC1288u = (InterfaceC1288u) list2.get(i6);
                    File file = this.f13769i;
                    C4085g c4085g = this.f13762b;
                    this.f13768h = interfaceC1288u.mo3137a(file, c4085g.f13776e, c4085g.f13777f, c4085g.f13780i);
                    if (this.f13768h != null && this.f13762b.m8073c(this.f13768h.f4054c.mo3151a()) != null) {
                        this.f13768h.f4054c.mo3154f(this.f13762b.f13786o, this);
                        z7 = true;
                    }
                }
                return z7;
            }
            int i10 = this.f13764d + 1;
            this.f13764d = i10;
            if (i10 >= this.f13761a.size()) {
                return false;
            }
            InterfaceC3978e interfaceC3978e = (InterfaceC3978e) this.f13761a.get(this.f13764d);
            C4085g c4085g2 = this.f13762b;
            File fileMo6926h = c4085g2.f13779h.m3103a().mo6926h(new C4082d(interfaceC3978e, c4085g2.f13785n));
            this.f13769i = fileMo6926h;
            if (fileMo6926h != null) {
                this.f13765e = interfaceC3978e;
                this.f13766f = this.f13762b.f13774c.m3518b().m3527g(fileMo6926h);
                this.f13767g = 0;
            }
        }
    }

    @Override
    public final void mo3172c(Exception exc) {
        this.f13763c.mo8067a(this.f13765e, exc, this.f13768h.f4054c, 3);
    }

    @Override
    public final void cancel() {
        C1287t c1287t = this.f13768h;
        if (c1287t != null) {
            c1287t.f4054c.cancel();
        }
    }

    @Override
    public final void mo3173e(Object obj) {
        this.f13763c.mo8069c(this.f13765e, obj, this.f13768h.f4054c, 3, this.f13765e);
    }
}
