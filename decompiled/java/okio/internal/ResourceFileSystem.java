package okio.internal;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p243w8.C4064f;
import p243w8.C4067i;
import p243w8.InterfaceC4061c;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4149l;
import p253x8.AbstractC4153p;

public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final ClassLoader classLoader;
    private final InterfaceC4061c roots$delegate;
    private final FileSystem systemFileSystem;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final boolean keepPath(Path path) {
            return !AbstractC3656n.m7397O(path.name(), ".class", true);
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path path2) {
            AbstractC2796i.m5785f(path, "<this>");
            AbstractC2796i.m5785f(path2, TtmlNode.RUBY_BASE);
            return getROOT().resolve(AbstractC3656n.m7401S('\\', AbstractC3648f.m7385g0(path.toString(), path2.toString()), '/'));
        }

        private Companion() {
        }
    }

    public ResourceFileSystem(ClassLoader classLoader, boolean z7, FileSystem fileSystem, int i6, AbstractC2793f abstractC2793f) {
        this(classLoader, z7, (i6 & 4) != 0 ? FileSystem.SYSTEM : fileSystem);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<C4064f> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    public final List<C4064f> toClasspathRoots(ClassLoader classLoader) throws IOException {
        Enumeration<URL> resources = classLoader.getResources("");
        AbstractC2796i.m5784e(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        AbstractC2796i.m5784e(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            AbstractC2796i.m5782c(url);
            C4064f fileRoot = toFileRoot(url);
            if (fileRoot != null) {
                arrayList.add(fileRoot);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        AbstractC2796i.m5784e(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        AbstractC2796i.m5784e(list2, "list(...)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            AbstractC2796i.m5782c(url2);
            C4064f jarRoot = toJarRoot(url2);
            if (jarRoot != null) {
                arrayList2.add(jarRoot);
            }
        }
        return AbstractC4147j.m8186Z(arrayList, arrayList2);
    }

    private final C4064f toFileRoot(URL url) {
        if (AbstractC2796i.m5780a(url.getProtocol(), "file")) {
            return new C4064f(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
        }
        return null;
    }

    private final C4064f toJarRoot(URL url) {
        String string = url.toString();
        AbstractC2796i.m5784e(string, "toString(...)");
        if (!AbstractC3656n.m7404V(string, "jar:file:", false)) {
            return null;
        }
        int iM7378Z = AbstractC3648f.m7378Z(string);
        AbstractC2796i.m5785f(string, "<this>");
        int iLastIndexOf = string.lastIndexOf("!", iM7378Z);
        if (iLastIndexOf == -1) {
            return null;
        }
        Path.Companion companion = Path.Companion;
        String strSubstring = string.substring(4, iLastIndexOf);
        AbstractC2796i.m5784e(strSubstring, "substring(...)");
        return new C4064f(ZipFilesKt.openZip(Path.Companion.get$default(companion, new File(URI.create(strSubstring)), false, 1, (Object) null), this.systemFileSystem, ResourceFileSystem$toJarRoot$zip$1.INSTANCE), ROOT);
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Override
    public Sink appendingSink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void atomicMove(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        throw new IOException(this + " is read-only");
    }

    @Override
    public Path canonicalize(Path path) {
        AbstractC2796i.m5785f(path, "path");
        return canonicalizeInternal(path);
    }

    @Override
    public void createDirectory(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void createSymlink(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void delete(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override
    public List<Path> list(Path path) throws FileNotFoundException {
        AbstractC2796i.m5785f(path, "dir");
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z7 = false;
        for (C4064f c4064f : getRoots()) {
            FileSystem fileSystem = (FileSystem) c4064f.f13727a;
            Path path2 = (Path) c4064f.f13728b;
            try {
                List<Path> list = fileSystem.list(path2.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(AbstractC4149l.m8193Q(arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.removeBase((Path) it.next(), path2));
                }
                AbstractC4153p.m8195S(linkedHashSet, arrayList2);
                z7 = true;
            } catch (IOException unused) {
            }
        }
        if (z7) {
            return AbstractC4147j.m8189c0(linkedHashSet);
        }
        throw new FileNotFoundException(AbstractC2460q.m5497k(path, "file not found: "));
    }

    @Override
    public List<Path> listOrNull(Path path) {
        AbstractC2796i.m5785f(path, "dir");
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<C4064f> it = getRoots().iterator();
        boolean z7 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            C4064f next = it.next();
            FileSystem fileSystem = (FileSystem) next.f13727a;
            Path path2 = (Path) next.f13728b;
            List<Path> listListOrNull = fileSystem.listOrNull(path2.resolve(relativePath));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(AbstractC4149l.m8193Q(arrayList2));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(Companion.removeBase((Path) it2.next(), path2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                AbstractC4153p.m8195S(linkedHashSet, arrayList);
                z7 = true;
            }
        }
        if (z7) {
            return AbstractC4147j.m8189c0(linkedHashSet);
        }
        return null;
    }

    @Override
    public FileMetadata metadataOrNull(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (C4064f c4064f : getRoots()) {
            FileMetadata fileMetadataMetadataOrNull = ((FileSystem) c4064f.f13727a).metadataOrNull(((Path) c4064f.f13728b).resolve(relativePath));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override
    public FileHandle openReadOnly(Path path) throws FileNotFoundException {
        AbstractC2796i.m5785f(path, "file");
        if (!Companion.keepPath(path)) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "file not found: "));
        }
        String relativePath = toRelativePath(path);
        for (C4064f c4064f : getRoots()) {
            try {
                return ((FileSystem) c4064f.f13727a).openReadOnly(((Path) c4064f.f13728b).resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(AbstractC2460q.m5497k(path, "file not found: "));
    }

    @Override
    public FileHandle openReadWrite(Path path, boolean z7, boolean z10) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        throw new IOException("resources are not writable");
    }

    @Override
    public Sink sink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        throw new IOException(this + " is read-only");
    }

    @Override
    public Source source(Path path) throws FileNotFoundException {
        Source source;
        AbstractC2796i.m5785f(path, "file");
        if (!Companion.keepPath(path)) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "file not found: "));
        }
        Path path2 = ROOT;
        InputStream resourceAsStream = this.classLoader.getResourceAsStream(Path.resolve$default(path2, path, false, 2, (Object) null).relativeTo(path2).toString());
        if (resourceAsStream == null || (source = Okio.source(resourceAsStream)) == null) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "file not found: "));
        }
        return source;
    }

    public ResourceFileSystem(ClassLoader classLoader, boolean z7, FileSystem fileSystem) {
        AbstractC2796i.m5785f(classLoader, "classLoader");
        AbstractC2796i.m5785f(fileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = fileSystem;
        this.roots$delegate = new C4067i(new ResourceFileSystem$roots$2(this));
        if (z7) {
            getRoots().size();
        }
    }
}
