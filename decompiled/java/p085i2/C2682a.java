package p085i2;

import java.io.File;
import p130m2.C3065m;

public final class C2682a implements InterfaceC2683b {

    public final boolean f9326a;

    public C2682a(boolean z7) {
        this.f9326a = z7;
    }

    @Override
    public final String mo5684a(Object obj, C3065m c3065m) {
        File file = (File) obj;
        if (!this.f9326a) {
            return file.getPath();
        }
        return file.getPath() + ':' + file.lastModified();
    }
}
