package okio.internal;

import java.util.List;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2797j;
import p243w8.C4064f;

public final class ResourceFileSystem$roots$2 extends AbstractC2797j implements InterfaceC2713a {
    final ResourceFileSystem this$0;

    public ResourceFileSystem$roots$2(ResourceFileSystem resourceFileSystem) {
        super(0);
        this.this$0 = resourceFileSystem;
    }

    @Override
    public final List<C4064f> invoke() {
        ResourceFileSystem resourceFileSystem = this.this$0;
        return resourceFileSystem.toClasspathRoots(resourceFileSystem.classLoader);
    }
}
