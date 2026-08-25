package okhttp3.internal.p158io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;
import p103j9.AbstractC2796i;

public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        static final Companion $$INSTANCE = new Companion();

        public static final class SystemFileSystem implements FileSystem {
            @Override
            public Sink appendingSink(File file) throws FileNotFoundException {
                AbstractC2796i.m5785f(file, "file");
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            @Override
            public void delete(File file) throws IOException {
                AbstractC2796i.m5785f(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            @Override
            public void deleteContents(File file) throws IOException {
                AbstractC2796i.m5785f(file, "directory");
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException("not a readable directory: " + file);
                }
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
            }

            @Override
            public boolean exists(File file) {
                AbstractC2796i.m5785f(file, "file");
                return file.exists();
            }

            @Override
            public void rename(File file, File file2) throws IOException {
                AbstractC2796i.m5785f(file, "from");
                AbstractC2796i.m5785f(file2, "to");
                delete(file2);
                if (file.renameTo(file2)) {
                    return;
                }
                throw new IOException("failed to rename " + file + " to " + file2);
            }

            @Override
            public Sink sink(File file) throws FileNotFoundException {
                AbstractC2796i.m5785f(file, "file");
                try {
                    return Okio__JvmOkioKt.sink$default(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.sink$default(file, false, 1, null);
                }
            }

            @Override
            public long size(File file) {
                AbstractC2796i.m5785f(file, "file");
                return file.length();
            }

            @Override
            public Source source(File file) throws FileNotFoundException {
                AbstractC2796i.m5785f(file, "file");
                return Okio.source(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
