package okio;

import java.io.Closeable;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;

final class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSource buffer(Source source) {
        AbstractC2796i.m5785f(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final <T extends Closeable, R> R use(T t5, InterfaceC2724l interfaceC2724l) throws Throwable {
        R r10;
        AbstractC2796i.m5785f(interfaceC2724l, "block");
        Throwable th = null;
        try {
            r10 = (R) interfaceC2724l.invoke(t5);
            if (t5 != null) {
                try {
                    t5.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (t5 != null) {
                try {
                    t5.close();
                } catch (Throwable th4) {
                    AbstractC2973a.m6013a(th3, th4);
                }
            }
            th = th3;
            r10 = null;
        }
        if (th != null) {
            throw th;
        }
        AbstractC2796i.m5782c(r10);
        return r10;
    }

    public static final BufferedSink buffer(Sink sink) {
        AbstractC2796i.m5785f(sink, "<this>");
        return new RealBufferedSink(sink);
    }
}
