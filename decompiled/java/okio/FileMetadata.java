package okio;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.bumptech.glide.AbstractC1466d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2802o;
import p103j9.AbstractC2804q;
import p103j9.C2792e;
import p170p9.InterfaceC3384b;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4158u;
import p253x8.C4156s;

public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<InterfaceC3384b, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public final FileMetadata copy(boolean z7, boolean z10, Path path, Long l9, Long l10, Long l11, Long l12, Map<InterfaceC3384b, ? extends Object> map) {
        AbstractC2796i.m5785f(map, "extras");
        return new FileMetadata(z7, z10, path, l9, l10, l11, l12, map);
    }

    public final <T> T extra(InterfaceC3384b interfaceC3384b) {
        boolean zIsInstance;
        String str;
        AbstractC2796i.m5785f(interfaceC3384b, SessionDescription.ATTR_TYPE);
        T t5 = (T) this.extras.get(interfaceC3384b);
        String canonicalName = null;
        if (t5 == null) {
            return null;
        }
        Class cls = ((C2792e) interfaceC3384b).f9533a;
        AbstractC2796i.m5785f(cls, "jClass");
        Map map = C2792e.f9530b;
        AbstractC2796i.m5783d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            zIsInstance = AbstractC2804q.m5798c(num.intValue(), t5);
        } else {
            zIsInstance = (cls.isPrimitive() ? AbstractC1466d.m3497p(AbstractC2802o.m5794a(cls)) : cls).isInstance(t5);
        }
        if (zIsInstance) {
            return t5;
        }
        StringBuilder sb = new StringBuilder("Value cannot be cast to ");
        if (!cls.isAnonymousClass() && !cls.isLocalClass()) {
            boolean zIsArray = cls.isArray();
            HashMap map2 = C2792e.f9531c;
            if (zIsArray) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) map2.get(componentType.getName())) != null) {
                    canonicalName = str.concat("Array");
                }
                if (canonicalName == null) {
                    canonicalName = "kotlin.Array";
                }
            } else {
                canonicalName = (String) map2.get(cls.getName());
                if (canonicalName == null) {
                    canonicalName = cls.getCanonicalName();
                }
            }
        }
        sb.append(canonicalName);
        throw new ClassCastException(sb.toString());
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map<InterfaceC3384b, Object> getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size);
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis);
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return AbstractC4147j.m8184X(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public FileMetadata(boolean z7, boolean z10, Path path, Long l9, Long l10, Long l11, Long l12, Map<InterfaceC3384b, ? extends Object> map) {
        AbstractC2796i.m5785f(map, "extras");
        this.isRegularFile = z7;
        this.isDirectory = z10;
        this.symlinkTarget = path;
        this.size = l9;
        this.createdAtMillis = l10;
        this.lastModifiedAtMillis = l11;
        this.lastAccessedAtMillis = l12;
        this.extras = AbstractC4158u.m8198r(map);
    }

    public FileMetadata(boolean z7, boolean z10, Path path, Long l9, Long l10, Long l11, Long l12, Map map, int i6, AbstractC2793f abstractC2793f) {
        this((i6 & 1) != 0 ? false : z7, (i6 & 2) == 0 ? z10 : false, (i6 & 4) != 0 ? null : path, (i6 & 8) != 0 ? null : l9, (i6 & 16) != 0 ? null : l10, (i6 & 32) != 0 ? null : l11, (i6 & 64) == 0 ? l12 : null, (i6 & 128) != 0 ? C4156s.f14075a : map);
    }
}
