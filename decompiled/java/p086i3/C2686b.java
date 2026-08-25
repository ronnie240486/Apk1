package p086i3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import p000a.AbstractC0004e;
import p007a7.C0069f;
import p068g3.C2609c;
import p186r3.AbstractC3604h;
import p208t2.C3801b;
import p208t2.C3802c;
import p208t2.C3803d;
import p221u6.C3905e;
import p222u7.AbstractC3928d;
import p228v2.C3981h;
import p228v2.EnumC3974a;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;

public final class C2686b implements InterfaceC3983j {

    public static final C3905e f9328f = new C3905e(14);

    public static final C2685a f9329g = new C2685a(0);

    public final Context f9330a;

    public final ArrayList f9331b;

    public final C2685a f9332c;

    public final C3905e f9333d;

    public final C0069f f9334e;

    public C2686b(Context context, ArrayList arrayList, InterfaceC4238a interfaceC4238a, C4243f c4243f) {
        C3905e c3905e = f9328f;
        this.f9330a = context.getApplicationContext();
        this.f9331b = arrayList;
        this.f9333d = c3905e;
        this.f9334e = new C0069f(22, interfaceC4238a, c4243f, false);
        this.f9332c = f9329g;
    }

    public static int m5688d(C3801b c3801b, int i6, int i10) {
        int iMin = Math.min(c3801b.f12812g / i10, c3801b.f12811f / i6);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            StringBuilder sbM28v = AbstractC0004e.m28v("Downsampling GIF, sampleSize: ", iMax, ", target dimens: [", i6, "x");
            sbM28v.append(i10);
            sbM28v.append("], actual dimens: [");
            sbM28v.append(c3801b.f12811f);
            sbM28v.append("x");
            sbM28v.append(c3801b.f12812g);
            sbM28v.append("]");
            Log.v("BufferGifDecoder", sbM28v.toString());
        }
        return iMax;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        C3802c c3802c;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        C2685a c2685a = this.f9332c;
        synchronized (c2685a) {
            try {
                C3802c c3802c2 = (C3802c) c2685a.f9327a.poll();
                if (c3802c2 == null) {
                    c3802c2 = new C3802c();
                }
                c3802c = c3802c2;
                c3802c.f12818b = null;
                Arrays.fill(c3802c.f12817a, (byte) 0);
                c3802c.f12819c = new C3801b();
                c3802c.f12820d = 0;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                c3802c.f12818b = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                c3802c.f12818b.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            return m5689c(byteBuffer, i6, i10, c3802c, c3981h);
        } finally {
            this.f9332c.m5687c(c3802c);
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        return !((Boolean) c3981h.m7967c(AbstractC2694j.f9371b)).booleanValue() && AbstractC3928d.m7853q(this.f9331b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    public final C2609c m5689c(ByteBuffer byteBuffer, int i6, int i10, C3802c c3802c, C3981h c3981h) throws Throwable {
        Bitmap.Config config;
        int i11 = AbstractC3604h.f12101b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int i12 = 2;
        try {
            C3801b c3801bM7572b = c3802c.m7572b();
            if (c3801bM7572b.f12808c > 0 && c3801bM7572b.f12807b == 0) {
                if (c3981h.m7967c(AbstractC2694j.f9370a) == EnumC3974a.f13505b) {
                    try {
                        config = Bitmap.Config.RGB_565;
                    } catch (Throwable th) {
                        th = th;
                    }
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                int iM5688d = m5688d(c3801bM7572b, i6, i10);
                C3905e c3905e = this.f9333d;
                C0069f c0069f = this.f9334e;
                c3905e.getClass();
                C3803d c3803d = new C3803d(c0069f, c3801bM7572b, byteBuffer, iM5688d);
                c3803d.m7579c(config);
                c3803d.f12831k = (c3803d.f12831k + 1) % c3803d.f12832l.f12808c;
                Bitmap bitmapM7578b = c3803d.m7578b();
                if (bitmapM7578b == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
                    }
                    return null;
                }
                C2609c c2609c = new C2609c(new C2688d(new C2687c(0, new C2693i(ComponentCallbacks2C1464b.m3461a(this.f9330a), c3803d, i6, i10, bitmapM7578b))), 1);
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
                }
                return c2609c;
                if (Log.isLoggable("BufferGifDecoder", i12)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
                }
                throw th;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            i12 = 2;
        }
    }
}
