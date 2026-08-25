package androidx.mediarouter.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import p014b1.C1240n;
import p196s1.C3694d;

public final class AsyncTaskC1108q extends AsyncTask {

    public final Bitmap f3302a;

    public final Uri f3303b;

    public int f3304c;

    public long f3305d;

    public final DialogC1116u f3306e;

    public AsyncTaskC1108q(DialogC1116u dialogC1116u) {
        this.f3306e = dialogC1116u;
        MediaDescriptionCompat mediaDescriptionCompat = dialogC1116u.f3386U;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        if (iconBitmap != null && iconBitmap.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
            iconBitmap = null;
        }
        this.f3302a = iconBitmap;
        MediaDescriptionCompat mediaDescriptionCompat2 = dialogC1116u.f3386U;
        this.f3303b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
    }

    public final BufferedInputStream m2771a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream;
        String lowerCase = uri.getScheme().toLowerCase();
        if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
            inputStreamOpenInputStream = this.f3306e.f3402i.getContentResolver().openInputStream(uri);
        } else {
            URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
            int i6 = DialogC1116u.f3365p0;
            uRLConnectionOpenConnection.setConnectTimeout(i6);
            uRLConnectionOpenConnection.setReadTimeout(i6);
            inputStreamOpenInputStream = uRLConnectionOpenConnection.getInputStream();
        }
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        return new BufferedInputStream(inputStreamOpenInputStream);
    }

    @Override
    public final Object doInBackground(Object[] objArr) throws Throwable {
        InputStream inputStream;
        BufferedInputStream bufferedInputStreamM2771a;
        InputStream inputStream2 = null;
        Bitmap bitmapDecodeStream = this.f3302a;
        if (bitmapDecodeStream == null) {
            Uri uri = this.f3303b;
            try {
                if (uri != null) {
                    try {
                        bufferedInputStreamM2771a = m2771a(uri);
                        try {
                            if (bufferedInputStreamM2771a == null) {
                                Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri);
                                if (bufferedInputStreamM2771a == null) {
                                    return null;
                                }
                            } else {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(bufferedInputStreamM2771a, null, options);
                                if (options.outWidth != 0 && options.outHeight != 0) {
                                    try {
                                        bufferedInputStreamM2771a.reset();
                                    } catch (IOException unused) {
                                        bufferedInputStreamM2771a.close();
                                        bufferedInputStreamM2771a = m2771a(uri);
                                        if (bufferedInputStreamM2771a == null) {
                                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri);
                                            if (bufferedInputStreamM2771a == null) {
                                                return null;
                                            }
                                        }
                                        bufferedInputStreamM2771a.close();
                                        return null;
                                    }
                                    options.inJustDecodeBounds = false;
                                    options.inSampleSize = Math.max(1, Integer.highestOneBit(options.outHeight / this.f3306e.m2795n(options.outWidth, options.outHeight)));
                                    if (!isCancelled()) {
                                        bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStreamM2771a, null, options);
                                        try {
                                            bufferedInputStreamM2771a.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedInputStreamM2771a.close();
                                return null;
                            } catch (IOException unused3) {
                                return null;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri, e);
                            if (bufferedInputStreamM2771a != null) {
                                try {
                                    bufferedInputStreamM2771a.close();
                                } catch (IOException unused4) {
                                }
                            }
                            bitmapDecodeStream = null;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        bufferedInputStreamM2771a = null;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                } else {
                    bitmapDecodeStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
            }
        }
        if (bitmapDecodeStream != null && bitmapDecodeStream.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't use recycled bitmap: " + bitmapDecodeStream);
            return null;
        }
        if (bitmapDecodeStream != null && bitmapDecodeStream.getWidth() < bitmapDecodeStream.getHeight()) {
            C1240n c1240n = new C1240n(bitmapDecodeStream);
            c1240n.f3941a = 1;
            ArrayList arrayList = c1240n.m3117b().f12370a;
            this.f3304c = Collections.unmodifiableList(arrayList).isEmpty() ? 0 : ((C3694d) Collections.unmodifiableList(arrayList).get(0)).f12363d;
        }
        return bitmapDecodeStream;
    }

    @Override
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        DialogC1116u dialogC1116u = this.f3306e;
        dialogC1116u.f3387V = null;
        Bitmap bitmap2 = dialogC1116u.f3388W;
        Bitmap bitmap3 = this.f3302a;
        boolean zEquals = Objects.equals(bitmap2, bitmap3);
        Uri uri = this.f3303b;
        if (zEquals && Objects.equals(dialogC1116u.f3389X, uri)) {
            return;
        }
        dialogC1116u.f3388W = bitmap3;
        dialogC1116u.f3391Z = bitmap;
        dialogC1116u.f3389X = uri;
        dialogC1116u.f3392b0 = this.f3304c;
        dialogC1116u.f3390Y = true;
        dialogC1116u.m2799s(SystemClock.uptimeMillis() - this.f3305d > 120);
    }

    @Override
    public final void onPreExecute() {
        this.f3305d = SystemClock.uptimeMillis();
        DialogC1116u dialogC1116u = this.f3306e;
        dialogC1116u.f3390Y = false;
        dialogC1116u.f3391Z = null;
        dialogC1116u.f3392b0 = 0;
    }
}
