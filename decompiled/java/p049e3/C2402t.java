package p049e3;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import p036d2.C2140i;
import p047e1.C2363g;
import p186r3.AbstractC3597a;
import p228v2.InterfaceC3977d;
import p259y2.C4243f;

public final class C2402t implements InterfaceC3977d {
    @Override
    public final ImageHeaderParser$ImageType mo5422a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override
    public final int mo5423b(InputStream inputStream, C4243f c4243f) {
        int iM5352c = new C2363g(inputStream).m5352c();
        if (iM5352c == 0) {
            return -1;
        }
        return iM5352c;
    }

    @Override
    public final int mo5424c(ByteBuffer byteBuffer, C4243f c4243f) {
        AtomicReference atomicReference = AbstractC3597a.f12090a;
        return mo5423b(new C2140i(byteBuffer), c4243f);
    }

    @Override
    public final ImageHeaderParser$ImageType mo5425d(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
