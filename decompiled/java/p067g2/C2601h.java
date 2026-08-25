package p067g2;

import android.webkit.MimeTypeMap;
import java.io.File;
import okio.FileSystem;
import okio.Path;
import p008a9.InterfaceC0074d;
import p036d2.C2144m;
import p036d2.EnumC2137f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;

public final class C2601h implements InterfaceC2600g {

    public final File f9055a;

    public C2601h(File file) {
        this.f9055a = file;
    }

    @Override
    public final Object mo5615a(InterfaceC0074d interfaceC0074d) {
        Path.Companion companion = Path.Companion;
        File file = this.f9055a;
        C2144m c2144m = new C2144m(Path.Companion.get$default(companion, file, false, 1, (Object) null), FileSystem.SYSTEM, null, null);
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String name = file.getName();
        AbstractC2796i.m5784e(name, "getName(...)");
        return new C2606m(c2144m, singleton.getMimeTypeFromExtension(AbstractC3648f.m7389k0('.', name, "")), EnumC2137f.f7762c);
    }
}
