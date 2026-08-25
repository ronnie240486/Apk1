package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p103j9.AbstractC2802o;
import p181q9.C3552j;
import p181q9.InterfaceC3545c;
import p253x8.AbstractC4152o;

public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public static final class C33071 extends AbstractC2797j implements InterfaceC2724l {
        public C33071() {
            super(1);
        }

        @Override
        public final Path invoke(Path path) {
            AbstractC2796i.m5785f(path, "it");
            return ForwardingFileSystem.this.onPathResult(path, "listRecursively");
        }
    }

    public ForwardingFileSystem(FileSystem fileSystem) {
        AbstractC2796i.m5785f(fileSystem, "delegate");
        this.delegate = fileSystem;
    }

    @Override
    public Sink appendingSink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        return this.delegate.appendingSink(onPathParameter(path, "appendingSink", "file"), z7);
    }

    @Override
    public void atomicMove(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        this.delegate.atomicMove(onPathParameter(path, "atomicMove", "source"), onPathParameter(path2, "atomicMove", "target"));
    }

    @Override
    public Path canonicalize(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override
    public void createDirectory(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "dir");
        this.delegate.createDirectory(onPathParameter(path, "createDirectory", "dir"), z7);
    }

    @Override
    public void createSymlink(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        this.delegate.createSymlink(onPathParameter(path, "createSymlink", "source"), onPathParameter(path2, "createSymlink", "target"));
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    @Override
    public void delete(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z7);
    }

    @Override
    public List<Path> list(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "dir");
        List<Path> list = this.delegate.list(onPathParameter(path, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "list"));
        }
        AbstractC4152o.m8194R(arrayList);
        return arrayList;
    }

    @Override
    public List<Path> listOrNull(Path path) {
        AbstractC2796i.m5785f(path, "dir");
        List<Path> listListOrNull = this.delegate.listOrNull(onPathParameter(path, "listOrNull", "dir"));
        if (listListOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listListOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "listOrNull"));
        }
        AbstractC4152o.m8194R(arrayList);
        return arrayList;
    }

    @Override
    public InterfaceC3545c listRecursively(Path path, boolean z7) {
        AbstractC2796i.m5785f(path, "dir");
        InterfaceC3545c interfaceC3545cListRecursively = this.delegate.listRecursively(onPathParameter(path, "listRecursively", "dir"), z7);
        C33071 c33071 = new C33071();
        AbstractC2796i.m5785f(interfaceC3545cListRecursively, "<this>");
        return new C3552j(interfaceC3545cListRecursively, c33071);
    }

    @Override
    public FileMetadata metadataOrNull(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        FileMetadata fileMetadataMetadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (fileMetadataMetadataOrNull == null) {
            return null;
        }
        return fileMetadataMetadataOrNull.getSymlinkTarget() == null ? fileMetadataMetadataOrNull : fileMetadataMetadataOrNull.copy((251 & 1) != 0 ? fileMetadataMetadataOrNull.isRegularFile : false, (251 & 2) != 0 ? fileMetadataMetadataOrNull.isDirectory : false, (251 & 4) != 0 ? fileMetadataMetadataOrNull.symlinkTarget : onPathResult(fileMetadataMetadataOrNull.getSymlinkTarget(), "metadataOrNull"), (251 & 8) != 0 ? fileMetadataMetadataOrNull.size : null, (251 & 16) != 0 ? fileMetadataMetadataOrNull.createdAtMillis : null, (251 & 32) != 0 ? fileMetadataMetadataOrNull.lastModifiedAtMillis : null, (251 & 64) != 0 ? fileMetadataMetadataOrNull.lastAccessedAtMillis : null, (251 & 128) != 0 ? fileMetadataMetadataOrNull.extras : null);
    }

    public Path onPathParameter(Path path, String str, String str2) {
        AbstractC2796i.m5785f(path, "path");
        AbstractC2796i.m5785f(str, "functionName");
        AbstractC2796i.m5785f(str2, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String str) {
        AbstractC2796i.m5785f(path, "path");
        AbstractC2796i.m5785f(str, "functionName");
        return path;
    }

    @Override
    public FileHandle openReadOnly(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        return this.delegate.openReadOnly(onPathParameter(path, "openReadOnly", "file"));
    }

    @Override
    public FileHandle openReadWrite(Path path, boolean z7, boolean z10) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        return this.delegate.openReadWrite(onPathParameter(path, "openReadWrite", "file"), z7, z10);
    }

    @Override
    public Sink sink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        return this.delegate.sink(onPathParameter(path, "sink", "file"), z7);
    }

    @Override
    public Source source(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        return this.delegate.source(onPathParameter(path, "source", "file"));
    }

    public String toString() {
        return AbstractC2802o.m5794a(getClass()).m5778b() + '(' + this.delegate + ')';
    }
}
