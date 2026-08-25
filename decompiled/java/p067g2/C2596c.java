package p067g2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import java.nio.ByteBuffer;
import okio.Buffer;
import p008a9.InterfaceC0074d;
import p036d2.C2147p;
import p036d2.EnumC2137f;
import p130m2.C3065m;
import p185r2.AbstractC3587f;
import p222u7.AbstractC3928d;
import p268z1.C4299n;

public final class C2596c implements InterfaceC2600g {

    public final int f9049a;

    public final C3065m f9050b;

    public final Object f9051c;

    public C2596c(Object obj, C3065m c3065m, int i6) {
        this.f9049a = i6;
        this.f9051c = obj;
        this.f9050b = c3065m;
    }

    @Override
    public final Object mo5615a(InterfaceC0074d interfaceC0074d) {
        EnumC2137f enumC2137f = EnumC2137f.f7761b;
        C3065m c3065m = this.f9050b;
        Object obj = this.f9051c;
        switch (this.f9049a) {
            case 0:
                return new C2597d(new BitmapDrawable(c3065m.f10496a.getResources(), (Bitmap) obj), false, enumC2137f);
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    Buffer buffer = new Buffer();
                    buffer.write(byteBuffer);
                    byteBuffer.position(0);
                    Context context = c3065m.f10496a;
                    return new C2606m(new C2147p(buffer, null), null, enumC2137f);
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    throw th;
                }
            default:
                Drawable bitmapDrawable = (Drawable) obj;
                Bitmap.Config[] configArr = AbstractC3587f.f12065a;
                boolean z7 = (bitmapDrawable instanceof VectorDrawable) || (bitmapDrawable instanceof C4299n);
                if (z7) {
                    bitmapDrawable = new BitmapDrawable(c3065m.f10496a.getResources(), AbstractC3928d.m7843d(bitmapDrawable, c3065m.f10497b, c3065m.f10499d, c3065m.f10500e, c3065m.f10501f));
                }
                return new C2597d(bitmapDrawable, z7, enumC2137f);
        }
    }
}
