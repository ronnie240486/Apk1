package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2802o;
import p253x8.AbstractC4147j;
import p253x8.AbstractC4152o;
import p264y8.C4278c;

public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {
    private final java.nio.file.FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(java.nio.file.FileSystem fileSystem) {
        AbstractC2796i.m5785f(fileSystem, "nioFileSystem");
        this.nioFileSystem = fileSystem;
    }

    private final java.nio.file.Path resolve(Path path) {
        java.nio.file.Path path2 = this.nioFileSystem.getPath(path.toString(), new String[0]);
        AbstractC2796i.m5784e(path2, "getPath(...)");
        return path2;
    }

    @Override
    public Sink appendingSink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        C4278c c4278c = new C4278c(10);
        c4278c.add(StandardOpenOption.APPEND);
        if (!z7) {
            c4278c.add(StandardOpenOption.CREATE);
        }
        C4278c c4278cM159m = AbstractC0032a.m159m(c4278c);
        java.nio.file.Path pathResolve = resolve(path);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) c4278cM159m.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathResolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        AbstractC2796i.m5784e(outputStreamNewOutputStream, "newOutputStream(...)");
        return Okio.sink(outputStreamNewOutputStream);
    }

    @Override
    public void atomicMove(Path path, Path path2) throws IOException {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        try {
            AbstractC2796i.m5784e(Files.move(resolve(path), resolve(path2), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(...)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e5) {
            throw new FileNotFoundException(e5.getMessage());
        }
    }

    @Override
    public Path canonicalize(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        try {
            Path.Companion companion = Path.Companion;
            java.nio.file.Path realPath = resolve(path).toRealPath(new LinkOption[0]);
            AbstractC2796i.m5784e(realPath, "toRealPath(...)");
            return Path.Companion.get$default(companion, realPath, false, 1, (Object) null);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
    }

    @Override
    public void createDirectory(Path path, boolean z7) throws IOException {
        boolean z10;
        AbstractC2796i.m5785f(path, "dir");
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            z10 = fileMetadataMetadataOrNull.isDirectory();
        }
        if (z10 && z7) {
            throw new IOException(path + " already exists.");
        }
        try {
            AbstractC2796i.m5784e(Files.createDirectory(resolve(path), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createDirectory(...)");
        } catch (IOException e5) {
            if (!z10) {
                throw new IOException(AbstractC2460q.m5497k(path, "failed to create directory: "), e5);
            }
        }
    }

    @Override
    public void createSymlink(Path path, Path path2) {
        AbstractC2796i.m5785f(path, "source");
        AbstractC2796i.m5785f(path2, "target");
        AbstractC2796i.m5784e(Files.createSymbolicLink(resolve(path), resolve(path2), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createSymbolicLink(...)");
    }

    @Override
    public void delete(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        java.nio.file.Path pathResolve = resolve(path);
        try {
            Files.delete(pathResolve);
        } catch (NoSuchFileException unused) {
            if (z7) {
                throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
            }
        } catch (IOException unused2) {
            if (Files.exists(pathResolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(AbstractC2460q.m5497k(path, "failed to delete "));
            }
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
        return metadataOrNull(resolve(path));
    }

    @Override
    public FileHandle openReadOnly(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        try {
            FileChannel fileChannelOpen = FileChannel.open(resolve(path), StandardOpenOption.READ);
            AbstractC2796i.m5782c(fileChannelOpen);
            return new NioFileSystemFileHandle(false, fileChannelOpen);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
    }

    @Override
    public FileHandle openReadWrite(Path path, boolean z7, boolean z10) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        if (z7 && z10) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        C4278c c4278c = new C4278c(10);
        c4278c.add(StandardOpenOption.READ);
        c4278c.add(StandardOpenOption.WRITE);
        if (z7) {
            c4278c.add(StandardOpenOption.CREATE_NEW);
        } else if (!z10) {
            c4278c.add(StandardOpenOption.CREATE);
        }
        C4278c c4278cM159m = AbstractC0032a.m159m(c4278c);
        try {
            java.nio.file.Path pathResolve = resolve(path);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) c4278cM159m.toArray(new StandardOpenOption[0]);
            FileChannel fileChannelOpen = FileChannel.open(pathResolve, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            AbstractC2796i.m5782c(fileChannelOpen);
            return new NioFileSystemFileHandle(true, fileChannelOpen);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
    }

    @Override
    public Sink sink(Path path, boolean z7) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        C4278c c4278c = new C4278c(10);
        if (z7) {
            c4278c.add(StandardOpenOption.CREATE_NEW);
        }
        C4278c c4278cM159m = AbstractC0032a.m159m(c4278c);
        try {
            java.nio.file.Path pathResolve = resolve(path);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) c4278cM159m.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathResolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            AbstractC2796i.m5784e(outputStreamNewOutputStream, "newOutputStream(...)");
            return Okio.sink(outputStreamNewOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
    }

    @Override
    public Source source(Path path) throws IOException {
        AbstractC2796i.m5785f(path, "file");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(resolve(path), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            AbstractC2796i.m5784e(inputStreamNewInputStream, "newInputStream(...)");
            return Okio.source(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
    }

    @Override
    public String toString() {
        String strM5778b = AbstractC2802o.m5794a(this.nioFileSystem.getClass()).m5778b();
        AbstractC2796i.m5782c(strM5778b);
        return strM5778b;
    }

    private final List<Path> list(Path path, boolean z7) throws IOException {
        java.nio.file.Path pathResolve = resolve(path);
        try {
            AbstractC2796i.m5785f(pathResolve, "<this>");
            DirectoryStream<java.nio.file.Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(pathResolve, "*");
            try {
                AbstractC2796i.m5782c(directoryStreamNewDirectoryStream);
                List listM8189c0 = AbstractC4147j.m8189c0(directoryStreamNewDirectoryStream);
                AbstractC0032a.m164r(directoryStreamNewDirectoryStream, null);
                ArrayList arrayList = new ArrayList();
                Iterator it = listM8189c0.iterator();
                while (it.hasNext()) {
                    arrayList.add(Path.Companion.get$default(Path.Companion, (java.nio.file.Path) it.next(), false, 1, (Object) null));
                }
                AbstractC4152o.m8194R(arrayList);
                return arrayList;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0032a.m164r(directoryStreamNewDirectoryStream, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            if (!z7) {
                return null;
            }
            if (Files.exists(pathResolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(AbstractC2460q.m5497k(path, "failed to list "));
            }
            throw new FileNotFoundException(AbstractC2460q.m5497k(path, "no such file: "));
        }
    }
}
