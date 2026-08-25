package p068g3;

import android.graphics.ImageDecoder;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import p007a7.C0069f;
import p186r3.AbstractC3597a;
import p222u7.AbstractC3928d;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;

public final class C2607a implements InterfaceC3983j {

    public final int f9078a;

    public final C0069f f9079b;

    public C2607a(int i6, C0069f c0069f) {
        this.f9078a = i6;
        this.f9079b = c0069f;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f9078a) {
            case 0:
                return C0069f.m216e(ImageDecoder.createSource((ByteBuffer) obj), i6, i10, c3981h);
            default:
                return C0069f.m216e(ImageDecoder.createSource(AbstractC3597a.m7218b((InputStream) obj)), i6, i10, c3981h);
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) throws IOException {
        switch (this.f9078a) {
            case 0:
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeM7853q = AbstractC3928d.m7853q((ArrayList) this.f9079b.f196b, (ByteBuffer) obj);
                return imageHeaderParser$ImageTypeM7853q == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeM7853q == ImageHeaderParser$ImageType.ANIMATED_AVIF);
            default:
                C0069f c0069f = this.f9079b;
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeM7852p = AbstractC3928d.m7852p((ArrayList) c0069f.f196b, (InputStream) obj, (C4243f) c0069f.f197c);
                return imageHeaderParser$ImageTypeM7852p == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeM7852p == ImageHeaderParser$ImageType.ANIMATED_AVIF);
        }
    }
}
