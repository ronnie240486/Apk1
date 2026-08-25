package p016b3;

import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p186r3.AbstractC3597a;
import p228v2.C3981h;
import p228v2.InterfaceC3975b;

public final class C1263c implements InterfaceC3975b {

    public final int f3999a;

    public C1263c(int i6) {
        this.f3999a = i6;
    }

    public static ByteArrayInputStream m3145a(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, iIndexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    public Class m3146b() {
        switch (this.f3999a) {
            case 0:
                return ByteBuffer.class;
            case 1:
                return InputStream.class;
            case 2:
            case 3:
            default:
                return InputStream.class;
            case 4:
                return ParcelFileDescriptor.class;
        }
    }

    @Override
    public boolean mo93i(Object obj, File file, C3981h c3981h) throws Throwable {
        try {
            AbstractC3597a.m7220d((ByteBuffer) obj, file);
            return true;
        } catch (IOException e5) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e5);
            }
            return false;
        }
    }
}
