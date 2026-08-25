package p207t1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public final class C3797i {

    public final int f12785a;

    public final int f12786b;

    public final long f12787c;

    public final long f12788d;

    public C3797i(long j10, int i6, int i10, long j11) {
        this.f12785a = i6;
        this.f12786b = i10;
        this.f12787c = j10;
        this.f12788d = j11;
    }

    public static C3797i m7566a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            C3797i c3797i = new C3797i(dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong());
            dataInputStream.close();
            return c3797i;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void m7567b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f12785a);
            dataOutputStream.writeInt(this.f12786b);
            dataOutputStream.writeLong(this.f12787c);
            dataOutputStream.writeLong(this.f12788d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C3797i)) {
            return false;
        }
        C3797i c3797i = (C3797i) obj;
        return this.f12786b == c3797i.f12786b && this.f12787c == c3797i.f12787c && this.f12785a == c3797i.f12785a && this.f12788d == c3797i.f12788d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12786b), Long.valueOf(this.f12787c), Integer.valueOf(this.f12785a), Long.valueOf(this.f12788d));
    }
}
