package p005a4;

import java.io.Closeable;
import p038d4.C2153c;
import p087i4.C2702g;
import p087i4.InterfaceC2699d;
import p234v8.InterfaceC4022a;

public final class C0053l implements Closeable {

    public InterfaceC4022a f156a;

    public C2153c f157b;

    public InterfaceC4022a f158c;

    public InterfaceC4022a f159d;

    public InterfaceC4022a f160e;

    @Override
    public final void close() {
        ((C2702g) ((InterfaceC2699d) this.f159d.get())).close();
    }
}
