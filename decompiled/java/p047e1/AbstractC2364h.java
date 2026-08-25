package p047e1;

import android.system.ErrnoException;
import android.system.Os;
import java.io.FileDescriptor;

public abstract class AbstractC2364h {
    public static void m5374a(FileDescriptor fileDescriptor) throws ErrnoException {
        Os.close(fileDescriptor);
    }

    public static FileDescriptor m5375b(FileDescriptor fileDescriptor) throws ErrnoException {
        return Os.dup(fileDescriptor);
    }

    public static long m5376c(FileDescriptor fileDescriptor, long j10, int i6) throws ErrnoException {
        return Os.lseek(fileDescriptor, j10, i6);
    }
}
