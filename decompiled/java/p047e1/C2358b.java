package p047e1;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import p055ea.AbstractC2460q;

public class C2358b extends InputStream implements DataInput {

    public final DataInputStream f8225a;

    public int f8226b;

    public ByteOrder f8227c;

    public byte[] f8228d;

    public final int f8229e;

    public C2358b(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        this.f8229e = bArr.length;
    }

    public final void m5340a(int i6) throws IOException {
        int i10 = 0;
        while (i10 < i6) {
            DataInputStream dataInputStream = this.f8225a;
            int i11 = i6 - i10;
            int iSkip = (int) dataInputStream.skip(i11);
            if (iSkip <= 0) {
                if (this.f8228d == null) {
                    this.f8228d = new byte[8192];
                }
                iSkip = dataInputStream.read(this.f8228d, 0, Math.min(8192, i11));
                if (iSkip == -1) {
                    throw new EOFException(AbstractC2460q.m5492f(i6, "Reached EOF while skipping ", " bytes."));
                }
            }
            i10 += iSkip;
        }
        this.f8226b += i10;
    }

    @Override
    public final int available() {
        return this.f8225a.available();
    }

    @Override
    public final void mark(int i6) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override
    public final int read() {
        this.f8226b++;
        return this.f8225a.read();
    }

    @Override
    public final boolean readBoolean() {
        this.f8226b++;
        return this.f8225a.readBoolean();
    }

    @Override
    public final byte readByte() throws IOException {
        this.f8226b++;
        int i6 = this.f8225a.read();
        if (i6 >= 0) {
            return (byte) i6;
        }
        throw new EOFException();
    }

    @Override
    public final char readChar() {
        this.f8226b += 2;
        return this.f8225a.readChar();
    }

    @Override
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override
    public final void readFully(byte[] bArr, int i6, int i10) throws IOException {
        this.f8226b += i10;
        this.f8225a.readFully(bArr, i6, i10);
    }

    @Override
    public final int readInt() throws IOException {
        this.f8226b += 4;
        DataInputStream dataInputStream = this.f8225a;
        int i6 = dataInputStream.read();
        int i10 = dataInputStream.read();
        int i11 = dataInputStream.read();
        int i12 = dataInputStream.read();
        if ((i6 | i10 | i11 | i12) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8227c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i12 << 24) + (i11 << 16) + (i10 << 8) + i6;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i6 << 24) + (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IOException("Invalid byte order: " + this.f8227c);
    }

    @Override
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override
    public final long readLong() throws IOException {
        this.f8226b += 8;
        DataInputStream dataInputStream = this.f8225a;
        int i6 = dataInputStream.read();
        int i10 = dataInputStream.read();
        int i11 = dataInputStream.read();
        int i12 = dataInputStream.read();
        int i13 = dataInputStream.read();
        int i14 = dataInputStream.read();
        int i15 = dataInputStream.read();
        int i16 = dataInputStream.read();
        if ((i6 | i10 | i11 | i12 | i13 | i14 | i15 | i16) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8227c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (((long) i16) << 56) + (((long) i15) << 48) + (((long) i14) << 40) + (((long) i13) << 32) + (((long) i12) << 24) + (((long) i11) << 16) + (((long) i10) << 8) + ((long) i6);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (((long) i6) << 56) + (((long) i10) << 48) + (((long) i11) << 40) + (((long) i12) << 32) + (((long) i13) << 24) + (((long) i14) << 16) + (((long) i15) << 8) + ((long) i16);
        }
        throw new IOException("Invalid byte order: " + this.f8227c);
    }

    @Override
    public final short readShort() throws IOException {
        this.f8226b += 2;
        DataInputStream dataInputStream = this.f8225a;
        int i6 = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i6 | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8227c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (short) ((i10 << 8) + i6);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((i6 << 8) + i10);
        }
        throw new IOException("Invalid byte order: " + this.f8227c);
    }

    @Override
    public final String readUTF() {
        this.f8226b += 2;
        return this.f8225a.readUTF();
    }

    @Override
    public final int readUnsignedByte() {
        this.f8226b++;
        return this.f8225a.readUnsignedByte();
    }

    @Override
    public final int readUnsignedShort() throws IOException {
        this.f8226b += 2;
        DataInputStream dataInputStream = this.f8225a;
        int i6 = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i6 | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8227c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i10 << 8) + i6;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i6 << 8) + i10;
        }
        throw new IOException("Invalid byte order: " + this.f8227c);
    }

    @Override
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override
    public final int skipBytes(int i6) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public C2358b(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    @Override
    public final int read(byte[] bArr, int i6, int i10) throws IOException {
        int i11 = this.f8225a.read(bArr, i6, i10);
        this.f8226b += i11;
        return i11;
    }

    @Override
    public final void readFully(byte[] bArr) throws IOException {
        this.f8226b += bArr.length;
        this.f8225a.readFully(bArr);
    }

    public C2358b(InputStream inputStream, ByteOrder byteOrder) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f8225a = dataInputStream;
        dataInputStream.mark(0);
        this.f8226b = 0;
        this.f8227c = byteOrder;
        this.f8229e = inputStream instanceof C2358b ? ((C2358b) inputStream).f8229e : -1;
    }
}
