package p036d2;

import java.io.Closeable;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import p143n5.AbstractC3198d;
import p185r2.AbstractC3587f;

public final class C2144m extends AbstractC2145n {

    public final Path f7777a;

    public final FileSystem f7778b;

    public final String f7779c;

    public final Closeable f7780d;

    public boolean f7781e;

    public BufferedSource f7782f;

    public C2144m(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        this.f7777a = path;
        this.f7778b = fileSystem;
        this.f7779c = str;
        this.f7780d = closeable;
    }

    @Override
    public final AbstractC3198d mo5084a() {
        return null;
    }

    @Override
    public final synchronized BufferedSource mo5085b() {
        if (this.f7781e) {
            throw new IllegalStateException("closed");
        }
        BufferedSource bufferedSource = this.f7782f;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(this.f7778b.source(this.f7777a));
        this.f7782f = bufferedSourceBuffer;
        return bufferedSourceBuffer;
    }

    @Override
    public final synchronized void close() {
        try {
            this.f7781e = true;
            BufferedSource bufferedSource = this.f7782f;
            if (bufferedSource != null) {
                AbstractC3587f.m7208a(bufferedSource);
            }
            Closeable closeable = this.f7780d;
            if (closeable != null) {
                AbstractC3587f.m7208a(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
