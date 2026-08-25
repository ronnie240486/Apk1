package p197s2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractC3702f {

    public static final Charset f12410a = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    public static void m7465a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m7465a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
