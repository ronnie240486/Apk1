package okio;

import java.io.RandomAccessFile;
import p103j9.AbstractC2796i;

public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean z7, RandomAccessFile randomAccessFile) {
        super(z7);
        AbstractC2796i.m5785f(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    @Override
    public synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override
    public synchronized int protectedRead(long j10, byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "array");
        this.randomAccessFile.seek(j10);
        int i11 = 0;
        while (i11 < i10) {
            int i12 = this.randomAccessFile.read(bArr, i6, i10 - i11);
            if (i12 == -1) {
                if (i11 != 0) {
                    break;
                }
                return -1;
            }
            i11 += i12;
        }
        return i11;
    }

    @Override
    public synchronized void protectedResize(long j10) {
        try {
            long size = size();
            long j11 = j10 - size;
            if (j11 > 0) {
                int i6 = (int) j11;
                protectedWrite(size, new byte[i6], 0, i6);
            } else {
                this.randomAccessFile.setLength(j10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override
    public synchronized void protectedWrite(long j10, byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "array");
        this.randomAccessFile.seek(j10);
        this.randomAccessFile.write(bArr, i6, i10);
    }
}
