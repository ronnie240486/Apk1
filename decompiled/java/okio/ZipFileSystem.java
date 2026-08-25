package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p253x8.AbstractC4147j;

public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }

        private Companion() {
        }
    }

    public ZipFileSystem(Path path, FileSystem fileSystem, Map<Path, ZipEntry> map, String str) {
        AbstractC2796i.m5785f(path, "zipPath");
        AbstractC2796i.m5785f(fileSystem, "fileSystem");
        AbstractC2796i.m5785f(map, "entries");
        this.zipPath = path;
        this.fileSystem = fileSystem;
        this.entries = map;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override
    public Sink appendingSink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void atomicMove(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public Path canonicalize(Path path) throws FileNotFoundException {
        AbstractC2796i.m5785f(path, "path");
        Path pathCanonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(pathCanonicalizeInternal)) {
            return pathCanonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override
    public void createDirectory(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void createSymlink(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void delete(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public List<Path> list(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "dir");
        List<Path> list = list(path, true);
        AbstractC2796i.m5782c(list);
        return list;
    }

    @Override
    public List<Path> listOrNull(Path path) {
        AbstractC2796i.m5785f(path, "dir");
        return list(path, false);
    }

    @Override
    public FileMetadata metadataOrNull(Path path) throws Throwable {
        FileMetadata localHeader;
        Throwable th;
        AbstractC2796i.m5785f(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        Throwable th2 = null;
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.isDirectory(), zipEntry.isDirectory(), null, zipEntry.isDirectory() ? null : Long.valueOf(zipEntry.getSize()), null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getOffset() == -1) {
            return fileMetadata;
        }
        FileHandle fileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(zipEntry.getOffset()));
            try {
                localHeader = ZipFilesKt.readLocalHeader(bufferedSourceBuffer, fileMetadata);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th5) {
                        AbstractC2973a.m6013a(th4, th5);
                    }
                }
                th = th4;
                localHeader = null;
            }
            if (th != null) {
                throw th;
            }
            AbstractC2796i.m5782c(localHeader);
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th6) {
                    th2 = th6;
                }
            }
            if (th2 != null) {
                throw th2;
            }
            AbstractC2796i.m5782c(localHeader);
            return localHeader;
        } catch (Throwable th7) {
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th8) {
                    AbstractC2973a.m6013a(th7, th8);
                }
            }
            localHeader = null;
            th2 = th7;
        }
    }

    @Override
    public FileHandle openReadOnly(Path path) {
        AbstractC2796i.m5785f(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override
    public FileHandle openReadWrite(Path path, boolean z7, boolean z10) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override
    public Sink sink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public Source source(Path path) throws Throwable {
        BufferedSource bufferedSourceBuffer;
        AbstractC2796i.m5785f(path, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry == null) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
        FileHandle fileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        Throwable th = null;
        try {
            bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(zipEntry.getOffset()));
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    AbstractC2973a.m6013a(th3, th4);
                }
            }
            bufferedSourceBuffer = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        AbstractC2796i.m5782c(bufferedSourceBuffer);
        ZipFilesKt.skipLocalHeader(bufferedSourceBuffer);
        return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(bufferedSourceBuffer, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSourceBuffer, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
    }

    private final List<Path> list(Path path, boolean z7) throws IOException {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return AbstractC4147j.m8189c0(zipEntry.getChildren());
        }
        if (z7) {
            throw new IOException(AbstractC2460q.m5497k(path, "not a directory: "));
        }
        return null;
    }
}
