package okio.internal;

import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;

public final class ResourceFileSystem$toJarRoot$zip$1 extends AbstractC2797j implements InterfaceC2724l {
    public static final ResourceFileSystem$toJarRoot$zip$1 INSTANCE = new ResourceFileSystem$toJarRoot$zip$1();

    public ResourceFileSystem$toJarRoot$zip$1() {
        super(1);
    }

    @Override
    public final Boolean invoke(ZipEntry zipEntry) {
        AbstractC2796i.m5785f(zipEntry, "entry");
        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(zipEntry.getCanonicalPath()));
    }
}
