package p049e3;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.C0423q;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000a.AbstractC0004e;
import p221u6.C3905e;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;
import p259y2.InterfaceC4238a;

public final class C2388f0 implements InterfaceC3983j {

    public static final C3980g f8342d = new C3980g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new C2392j(2));

    public static final C3980g f8343e = new C3980g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new C2392j(3));

    public static final C3905e f8344f = new C3905e(10);

    public static final List f8345g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    public final InterfaceC2386e0 f8346a;

    public final InterfaceC4238a f8347b;

    public final C3905e f8348c = f8344f;

    public C2388f0(InterfaceC4238a interfaceC4238a, InterfaceC2386e0 interfaceC2386e0) {
        this.f8347b = interfaceC4238a;
        this.f8346a = interfaceC2386e0;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) throws IOException {
        long jLongValue = ((Long) c3981h.m7967c(f8342d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(jLongValue, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer num = (Integer) c3981h.m7967c(f8343e);
        if (num == null) {
            num = 2;
        }
        C2396n c2396n = (C2396n) c3981h.m7967c(C2396n.f8362g);
        if (c2396n == null) {
            c2396n = C2396n.f8361f;
        }
        C2396n c2396n2 = c2396n;
        this.f8348c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f8346a.mo5412e(mediaMetadataRetriever, obj);
            return C2383d.m5410b(m5414c(obj, mediaMetadataRetriever, jLongValue, num.intValue(), i6, i10, c2396n2), this.f8347b);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetriever.release();
            } else {
                mediaMetadataRetriever.release();
            }
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        return true;
    }

    public final Bitmap m5414c(Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j10, int i6, int i10, int i11, C2396n c2396n) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        MediaExtractor mediaExtractor;
        String str = Build.DEVICE;
        Bitmap bitmapCreateBitmap = null;
        if (str != null && str.matches(".+_cheets|cheets_.+")) {
            try {
                if (MimeTypes.VIDEO_WEBM.equals(mediaMetadataRetriever.extractMetadata(12))) {
                    mediaExtractor = new MediaExtractor();
                    try {
                        this.f8346a.mo5413f(mediaExtractor, obj);
                        int trackCount = mediaExtractor.getTrackCount();
                        for (int i17 = 0; i17 < trackCount; i17++) {
                            if (MimeTypes.VIDEO_VP8.equals(mediaExtractor.getTrackFormat(i17).getString("mime"))) {
                                mediaExtractor.release();
                                throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (Log.isLoggable("VideoDecoder", 3)) {
                                Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                            }
                            if (mediaExtractor != null) {
                            }
                            if (Build.VERSION.SDK_INT >= 27) {
                                try {
                                    i14 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                                    i15 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                                    i16 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                                    if (i16 != 90) {
                                        i15 = i14;
                                        i14 = i15;
                                    } else {
                                        i15 = i14;
                                        i14 = i15;
                                    }
                                    float fM5427b = c2396n.m5427b(i14, i15, i10, i11);
                                    bitmapCreateBitmap = mediaMetadataRetriever.getScaledFrameAtTime(j10, i6, Math.round(i14 * fM5427b), Math.round(fM5427b * i15));
                                } catch (Throwable th2) {
                                    if (Log.isLoggable("VideoDecoder", 3)) {
                                        Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th2);
                                    }
                                }
                            }
                            if (bitmapCreateBitmap == null) {
                                bitmapCreateBitmap = mediaMetadataRetriever.getFrameAtTime(j10, i6);
                            }
                            if (Build.MODEL.startsWith("Pixel")) {
                                i12 = Build.VERSION.SDK_INT;
                                if (i12 >= 30) {
                                    try {
                                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
                                        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
                                        i13 = Integer.parseInt(strExtractMetadata);
                                        int i18 = Integer.parseInt(strExtractMetadata2);
                                        if (i13 != 7) {
                                            if (Log.isLoggable("VideoDecoder", 3)) {
                                                Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                                            }
                                            Matrix matrix = new Matrix();
                                            matrix.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                                            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
                                        } else {
                                            if (Log.isLoggable("VideoDecoder", 3)) {
                                                Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                                            }
                                            Matrix matrix2 = new Matrix();
                                            matrix2.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                                            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix2, true);
                                        }
                                    } catch (NumberFormatException unused) {
                                        if (Log.isLoggable("VideoDecoder", 3)) {
                                            Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
                                        }
                                    }
                                }
                            } else {
                                i12 = Build.VERSION.SDK_INT;
                                if (i12 >= 30) {
                                    String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(36);
                                    String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(35);
                                    i13 = Integer.parseInt(strExtractMetadata3);
                                    int i19 = Integer.parseInt(strExtractMetadata4);
                                    if (i13 != 7) {
                                        if (Log.isLoggable("VideoDecoder", 3)) {
                                            Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                                        }
                                        Matrix matrix3 = new Matrix();
                                        matrix3.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                                        bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix3, true);
                                    } else {
                                        if (Log.isLoggable("VideoDecoder", 3)) {
                                            Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                                        }
                                        Matrix matrix4 = new Matrix();
                                        matrix4.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                                        bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix4, true);
                                    }
                                }
                            }
                            if (bitmapCreateBitmap != null) {
                                return bitmapCreateBitmap;
                            }
                            throw new C0423q("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details", 4);
                        } catch (Throwable th3) {
                            if (mediaExtractor != null) {
                                mediaExtractor.release();
                            }
                            throw th3;
                        }
                    }
                    mediaExtractor.release();
                }
            } catch (Throwable th4) {
                th = th4;
                mediaExtractor = null;
            }
        }
        if (Build.VERSION.SDK_INT >= 27 && i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && c2396n != C2396n.f8360e) {
            i14 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            i15 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            i16 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i16 != 90 || i16 == 270) {
                i15 = i14;
                i14 = i15;
            }
            float fM5427b2 = c2396n.m5427b(i14, i15, i10, i11);
            bitmapCreateBitmap = mediaMetadataRetriever.getScaledFrameAtTime(j10, i6, Math.round(i14 * fM5427b2), Math.round(fM5427b2 * i15));
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = mediaMetadataRetriever.getFrameAtTime(j10, i6);
        }
        if (Build.MODEL.startsWith("Pixel") || Build.VERSION.SDK_INT != 33) {
            i12 = Build.VERSION.SDK_INT;
            if (i12 >= 30 && i12 < 33) {
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(36);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(35);
                i13 = Integer.parseInt(strExtractMetadata5);
                int i110 = Integer.parseInt(strExtractMetadata6);
                if ((i13 != 7 || i13 == 6) && i110 == 6 && Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix5 = new Matrix();
                    matrix5.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix5, true);
                }
            }
        } else {
            Iterator it = f8345g.iterator();
            do {
                if (it.hasNext()) {
                }
            } while (!Build.ID.startsWith((String) it.next()));
            String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(36);
            String strExtractMetadata8 = mediaMetadataRetriever.extractMetadata(35);
            i13 = Integer.parseInt(strExtractMetadata7);
            int i111 = Integer.parseInt(strExtractMetadata8);
            if (i13 != 7) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                }
                Matrix matrix6 = new Matrix();
                matrix6.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix6, true);
            } else {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                }
                Matrix matrix7 = new Matrix();
                matrix7.postRotate(180.0f, bitmapCreateBitmap.getWidth() / 2.0f, bitmapCreateBitmap.getHeight() / 2.0f);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix7, true);
            }
        }
        if (bitmapCreateBitmap != null) {
            return bitmapCreateBitmap;
        }
        throw new C0423q("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details", 4);
    }
}
