package p086i3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import p222u7.AbstractC3928d;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;

public final class C2695k implements InterfaceC3983j {

    public final ArrayList f9372a;

    public final C2686b f9373b;

    public final C4243f f9374c;

    public C2695k(ArrayList arrayList, C2686b c2686b, C4243f c4243f) {
        this.f9372a = arrayList;
        this.f9373b = c2686b;
        this.f9374c = c4243f;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        byte[] byteArray;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i11 = inputStream.read(bArr);
                if (i11 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i11);
            }
            byteArrayOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e5);
            }
            byteArray = null;
        }
        if (byteArray == null) {
            return null;
        }
        return this.f9373b.mo5398a(ByteBuffer.wrap(byteArray), i6, i10, c3981h);
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        return !((Boolean) c3981h.m7967c(AbstractC2694j.f9371b)).booleanValue() && AbstractC3928d.m7852p(this.f9372a, (InputStream) obj, this.f9374c) == ImageHeaderParser$ImageType.GIF;
    }
}
