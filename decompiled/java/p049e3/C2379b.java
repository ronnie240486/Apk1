package p049e3;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.data.C1477c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import p186r3.AbstractC3604h;
import p186r3.AbstractC3610n;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.InterfaceC3984k;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;

public final class C2379b implements InterfaceC3984k {

    public static final C3980g f8330b = C3980g.m7966a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    public static final C3980g f8331c = new C3980g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, C3980g.f13510e);

    public final C4243f f8332a;

    public C2379b(C4243f c4243f) {
        this.f8332a = c4243f;
    }

    @Override
    public final boolean mo93i(Object obj, File file, C3981h c3981h) throws Throwable {
        boolean z7;
        Bitmap bitmap = (Bitmap) ((InterfaceC4102x) obj).get();
        C3980g c3980g = f8331c;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) c3981h.m7967c(c3980g);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i6 = AbstractC3604h.f12101b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) c3981h.m7967c(f8330b)).intValue();
        OutputStream c1477c = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    C4243f c4243f = this.f8332a;
                    if (c4243f != null) {
                        try {
                            c1477c = new C1477c(fileOutputStream, c4243f);
                        } catch (IOException e5) {
                            e = e5;
                            c1477c = fileOutputStream;
                            if (Log.isLoggable("BitmapEncoder", 3)) {
                                Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                            }
                            if (c1477c != null) {
                                try {
                                    c1477c.close();
                                } catch (IOException unused) {
                                }
                            }
                            z7 = false;
                        } catch (Throwable th) {
                            th = th;
                            c1477c = fileOutputStream;
                            if (c1477c != null) {
                                try {
                                    c1477c.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        c1477c = fileOutputStream;
                    }
                    bitmap.compress(compressFormat, iIntValue, c1477c);
                    c1477c.close();
                    try {
                        c1477c.close();
                    } catch (IOException unused3) {
                    }
                    z7 = true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e10) {
                e = e10;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + AbstractC3610n.m7235c(bitmap) + " in " + AbstractC3604h.m7226a(jElapsedRealtimeNanos) + ", options format: " + c3981h.m7967c(c3980g) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z7;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override
    public final int mo235l(C3981h c3981h) {
        return 2;
    }
}
