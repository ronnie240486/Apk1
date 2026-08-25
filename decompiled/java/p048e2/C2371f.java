package p048e2;

import java.io.IOException;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;

public final class C2371f extends ForwardingFileSystem {
    @Override
    public final Sink sink(Path path, boolean z7) throws IOException {
        Path pathParent = path.parent();
        if (pathParent != null) {
            createDirectories(pathParent);
        }
        return super.sink(path, z7);
    }
}
