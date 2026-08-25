package p184r1;

import java.io.File;
import java.io.FileFilter;

public final class C3578b implements FileFilter {
    @Override
    public final boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
