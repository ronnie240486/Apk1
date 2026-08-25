package p036d2;

import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import p103j9.AbstractC2796i;
import p143n5.AbstractC3198d;
import p185r2.AbstractC3587f;

public final class C2147p extends AbstractC2145n {

    public final AbstractC3198d f7784a;

    public boolean f7785b;

    public BufferedSource f7786c;

    public C2147p(BufferedSource bufferedSource, AbstractC3198d abstractC3198d) {
        this.f7784a = abstractC3198d;
        this.f7786c = bufferedSource;
    }

    @Override
    public final AbstractC3198d mo5084a() {
        return this.f7784a;
    }

    @Override
    public final synchronized BufferedSource mo5085b() {
        if (this.f7785b) {
            throw new IllegalStateException("closed");
        }
        BufferedSource bufferedSource = this.f7786c;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        FileSystem fileSystem = FileSystem.SYSTEM;
        AbstractC2796i.m5782c(null);
        BufferedSource bufferedSourceBuffer = Okio.buffer(fileSystem.source(null));
        this.f7786c = bufferedSourceBuffer;
        return bufferedSourceBuffer;
    }

    @Override
    public final synchronized void close() {
        this.f7785b = true;
        BufferedSource bufferedSource = this.f7786c;
        if (bufferedSource != null) {
            AbstractC3587f.m7208a(bufferedSource);
        }
    }
}
