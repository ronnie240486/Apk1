package okhttp3.internal.cache;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;

public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    private final InterfaceC2724l onException;

    public FaultHidingSink(Sink sink, InterfaceC2724l interfaceC2724l) {
        super(sink);
        AbstractC2796i.m5785f(sink, "delegate");
        AbstractC2796i.m5785f(interfaceC2724l, "onException");
        this.onException = interfaceC2724l;
    }

    @Override
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e5) {
            this.hasErrors = true;
            this.onException.invoke(e5);
        }
    }

    @Override
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e5) {
            this.hasErrors = true;
            this.onException.invoke(e5);
        }
    }

    public final InterfaceC2724l getOnException() {
        return this.onException;
    }

    @Override
    public void write(Buffer buffer, long j10) throws EOFException {
        AbstractC2796i.m5785f(buffer, "source");
        if (this.hasErrors) {
            buffer.skip(j10);
            return;
        }
        try {
            super.write(buffer, j10);
        } catch (IOException e5) {
            this.hasErrors = true;
            this.onException.invoke(e5);
        }
    }
}
