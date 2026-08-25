package com.bumptech.glide.load.data;

import androidx.media3.common.C0565C;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import p259y2.C4243f;

public final class C1477c extends OutputStream {

    public final FileOutputStream f4477a;

    public byte[] f4478b;

    public final C4243f f4479c;

    public int f4480d;

    public C1477c(FileOutputStream fileOutputStream, C4243f c4243f) {
        this.f4477a = fileOutputStream;
        this.f4479c = c4243f;
        this.f4478b = (byte[]) c4243f.m8287d(C0565C.DEFAULT_BUFFER_SEGMENT_SIZE, byte[].class);
    }

    @Override
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f4477a;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f4478b;
            if (bArr != null) {
                this.f4479c.m8291h(bArr);
                this.f4478b = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override
    public final void flush() throws IOException {
        int i6 = this.f4480d;
        FileOutputStream fileOutputStream = this.f4477a;
        if (i6 > 0) {
            fileOutputStream.write(this.f4478b, 0, i6);
            this.f4480d = 0;
        }
        fileOutputStream.flush();
    }

    @Override
    public final void write(int i6) throws IOException {
        byte[] bArr = this.f4478b;
        int i10 = this.f4480d;
        int i11 = i10 + 1;
        this.f4480d = i11;
        bArr[i10] = (byte) i6;
        if (i11 != bArr.length || i11 <= 0) {
            return;
        }
        this.f4477a.write(bArr, 0, i11);
        this.f4480d = 0;
    }

    @Override
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override
    public final void write(byte[] bArr, int i6, int i10) throws IOException {
        int i11 = 0;
        do {
            int i12 = i10 - i11;
            int i13 = i6 + i11;
            int i14 = this.f4480d;
            FileOutputStream fileOutputStream = this.f4477a;
            if (i14 == 0 && i12 >= this.f4478b.length) {
                fileOutputStream.write(bArr, i13, i12);
                return;
            }
            int iMin = Math.min(i12, this.f4478b.length - i14);
            System.arraycopy(bArr, i13, this.f4478b, this.f4480d, iMin);
            int i15 = this.f4480d + iMin;
            this.f4480d = i15;
            i11 += iMin;
            byte[] bArr2 = this.f4478b;
            if (i15 == bArr2.length && i15 > 0) {
                fileOutputStream.write(bArr2, 0, i15);
                this.f4480d = 0;
            }
        } while (i11 < i10);
    }
}
