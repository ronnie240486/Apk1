package p069g4;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p005a4.C0061t;
import p017b4.C1299f;
import p077h4.C2654d;
import p087i4.InterfaceC2699d;
import p098j4.InterfaceC2776c;

public final class C2611a implements InterfaceC2612b {

    public static final Logger f9084f = Logger.getLogger(C0061t.class.getName());

    public final C2654d f9085a;

    public final Executor f9086b;

    public final C1299f f9087c;

    public final InterfaceC2699d f9088d;

    public final InterfaceC2776c f9089e;

    public C2611a(Executor executor, C1299f c1299f, C2654d c2654d, InterfaceC2699d interfaceC2699d, InterfaceC2776c interfaceC2776c) {
        this.f9086b = executor;
        this.f9087c = c1299f;
        this.f9085a = c2654d;
        this.f9088d = interfaceC2699d;
        this.f9089e = interfaceC2776c;
    }
}
