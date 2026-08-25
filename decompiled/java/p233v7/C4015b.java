package p233v7;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.IDN;

public final class C4015b extends AbstractC4014a {

    public final String f13616e;

    public C4015b(short s10, String str) {
        this.f13612a = s10;
        this.f13613b = 0;
        this.f13614c = 1;
        this.f13616e = str;
    }

    public final byte[] m8005a() throws IOException {
        String str = this.f13616e;
        if (str == null || str.length() == 0) {
            throw new IOException("host can not empty");
        }
        int i6 = this.f13613b;
        if (i6 != 0 && i6 != 1 && i6 != 2 && i6 != 5) {
            throw new IOException("opCode is not valid");
        }
        int i10 = this.f13614c;
        if (i10 != 0 && i10 != 1) {
            throw new IOException("rd is not valid");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(this.f13612a);
        dataOutputStream.writeByte((this.f13613b << 3) + this.f13614c);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        for (String str2 : str.split("[.。．｡]")) {
            if (str2.length() > 63) {
                throw new IOException("host part is too long");
            }
            byte[] bytes = IDN.toASCII(str2).getBytes();
            dataOutputStream.write(bytes.length);
            dataOutputStream.write(bytes, 0, bytes.length);
        }
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        dataOutputStream.writeByte(0);
        dataOutputStream.writeByte(1);
        return byteArrayOutputStream.toByteArray();
    }
}
