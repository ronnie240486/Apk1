package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import p103j9.AbstractC2796i;

public final class NioFileSystemFileHandle extends FileHandle {
    private final FileChannel fileChannel;

    public NioFileSystemFileHandle(boolean z7, FileChannel fileChannel) {
        super(z7);
        AbstractC2796i.m5785f(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    @Override
    public synchronized void protectedClose() {
        this.fileChannel.close();
    }

    @Override
    public synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    @Override
    public synchronized int protectedRead(long j10, byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "array");
        this.fileChannel.position(j10);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i6, i10);
        int i11 = 0;
        while (i11 < i10) {
            int i12 = this.fileChannel.read(byteBufferWrap);
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
                this.fileChannel.truncate(j10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    @Override
    public synchronized void protectedWrite(long j10, byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "array");
        this.fileChannel.position(j10);
        this.fileChannel.write(ByteBuffer.wrap(bArr, i6, i10));
    }
}
