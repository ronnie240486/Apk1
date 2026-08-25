package p048e2;

import android.os.StatFs;
import java.io.File;
import okio.FileSystem;
import okio.Path;
import p275z9.ExecutorC4361c;

public final class C2366a {

    public Path f8280a;

    public FileSystem f8281b;

    public double f8282c;

    public long f8283d;

    public long f8284e;

    public ExecutorC4361c f8285f;

    public final C2376k m5378a() {
        long j10 = this.f8283d;
        Path path = this.f8280a;
        if (path == null) {
            throw new IllegalStateException("directory == null");
        }
        double d = this.f8282c;
        if (d > 0.0d) {
            try {
                File file = path.toFile();
                file.mkdir();
                StatFs statFs = new StatFs(file.getAbsolutePath());
                long blockCountLong = (long) (d * statFs.getBlockCountLong() * statFs.getBlockSizeLong());
                long j11 = this.f8284e;
                if (j10 > j11) {
                    throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j11 + " is less than minimum " + j10 + '.');
                }
                if (blockCountLong >= j10) {
                    j10 = blockCountLong > j11 ? j11 : blockCountLong;
                }
            } catch (Exception unused) {
            }
        } else {
            j10 = 0;
        }
        return new C2376k(j10, this.f8281b, path, this.f8285f);
    }
}
