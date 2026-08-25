package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4152o;

public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(Path path) throws IOException {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void requireExist(Path path) throws IOException {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override
    public Sink appendingSink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        if (z7) {
            requireExist(path);
        }
        return Okio.sink(path.toFile(), true);
    }

    @Override
    public void atomicMove(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        if (path.toFile().renameTo(path2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + path + " to " + path2);
    }

    @Override
    public Path canonicalize(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            return Path.Companion.get$default(Path.Companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    @Override
    public void createDirectory(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "dir");
        if (path.toFile().mkdir()) {
            return;
        }
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull == null || !fileMetadataMetadataOrNull.isDirectory()) {
            throw new IOException(AbstractC2460q.m5497k(path, "failed to create directory: "));
        }
        if (z7) {
            throw new IOException(path + " already exists.");
        }
    }

    @Override
    public void createSymlink(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        throw new IOException("unsupported");
    }

    @Override
    public void delete(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(AbstractC2460q.m5497k(path, "failed to delete "));
        }
        if (z7) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
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
    public FileMetadata metadataOrNull(Path path) {
        AbstractC2796i.m5785f(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
    }

    @Override
    public FileHandle openReadOnly(Path path) {
        AbstractC2796i.m5785f(path, "file");
        return new JvmFileHandle(false, new RandomAccessFile(path.toFile(), "r"));
    }

    @Override
    public FileHandle openReadWrite(Path path, boolean z7, boolean z10) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        if (z7 && z10) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z7) {
            requireCreate(path);
        }
        if (z10) {
            requireExist(path);
        }
        return new JvmFileHandle(true, new RandomAccessFile(path.toFile(), "rw"));
    }

    @Override
    public Sink sink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        if (z7) {
            requireCreate(path);
        }
        return Okio__JvmOkioKt.sink$default(path.toFile(), false, 1, null);
    }

    @Override
    public Source source(Path path) {
        AbstractC2796i.m5785f(path, "file");
        return Okio.source(path.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final List<Path> list(Path path, boolean z7) throws IOException {
        File file = path.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z7) {
                return null;
            }
            if (file.exists()) {
                throw new IOException(AbstractC2460q.m5497k(path, "failed to list "));
            }
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            AbstractC2796i.m5782c(str);
            arrayList.add(path.resolve(str));
        }
        AbstractC4152o.m8194R(arrayList);
        return arrayList;
    }
}
