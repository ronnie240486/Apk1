package p048e2;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import p009aa.C0083c;

public final class C2374i extends ForwardingSink {

    public final C0083c f8320a;

    public boolean f8321b;

    public C2374i(Sink sink, C0083c c0083c) {
        super(sink);
        this.f8320a = c0083c;
    }

    @Override
    public final void close() {
        try {
            super.close();
        } catch (IOException e5) {
            this.f8321b = true;
            this.f8320a.invoke(e5);
        }
    }

    @Override
    public final void flush() {
        try {
            super.flush();
        } catch (IOException e5) {
            this.f8321b = true;
            this.f8320a.invoke(e5);
        }
    }

    @Override
    public final void write(Buffer buffer, long j10) throws EOFException {
        if (this.f8321b) {
            buffer.skip(j10);
            return;
        }
        try {
            super.write(buffer, j10);
        } catch (IOException e5) {
            this.f8321b = true;
            this.f8320a.invoke(e5);
        }
    }
}
