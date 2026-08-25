package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.util.Arrays;
import p103j9.AbstractC2796i;

public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final Sink appendingSink(File file) {
        AbstractC2796i.m5785f(file, "file");
        return Okio.appendingSink(file);
    }

    public final Sink blackhole() {
        return Okio.blackhole();
    }

    public final BufferedSink buffer(Sink sink) {
        AbstractC2796i.m5785f(sink, "sink");
        return Okio.buffer(sink);
    }

    public final Sink sink(File file) {
        AbstractC2796i.m5785f(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    public final Source source(File file) {
        AbstractC2796i.m5785f(file, "file");
        return Okio.source(file);
    }

    public final BufferedSource buffer(Source source) {
        AbstractC2796i.m5785f(source, "source");
        return Okio.buffer(source);
    }

    public final Sink sink(OutputStream outputStream) {
        AbstractC2796i.m5785f(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        AbstractC2796i.m5785f(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    public final Sink sink(java.nio.file.Path path, OpenOption... openOptionArr) {
        AbstractC2796i.m5785f(path, "path");
        AbstractC2796i.m5785f(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Source source(java.nio.file.Path path, OpenOption... openOptionArr) {
        AbstractC2796i.m5785f(path, "path");
        AbstractC2796i.m5785f(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Sink sink(Socket socket) {
        AbstractC2796i.m5785f(socket, "socket");
        return Okio.sink(socket);
    }

    public final Source source(Socket socket) {
        AbstractC2796i.m5785f(socket, "socket");
        return Okio.source(socket);
    }
}
