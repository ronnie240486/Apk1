package androidx.mediarouter.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import com.p2serv.android.p032ds.R;
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

public final class AsyncTaskC1085e0 extends AsyncTask {

    public final Bitmap f3217a;

    public final Uri f3218b;

    public int f3219c;

    public final DialogC1109q0 f3220d;

    public AsyncTaskC1085e0(DialogC1109q0 dialogC1109q0) {
        this.f3220d = dialogC1109q0;
        MediaDescriptionCompat mediaDescriptionCompat = dialogC1109q0.f3318K;
        Bitmap iconBitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.getIconBitmap();
        if (iconBitmap != null && iconBitmap.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
            iconBitmap = null;
        }
        this.f3217a = iconBitmap;
        MediaDescriptionCompat mediaDescriptionCompat2 = dialogC1109q0.f3318K;
        this.f3218b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.getIconUri() : null;
    }

    public final BufferedInputStream m2742a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream;
        String lowerCase = uri.getScheme().toLowerCase();
        if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
            inputStreamOpenInputStream = this.f3220d.f3334m.getContentResolver().openInputStream(uri);
        } else {
            URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(30000);
            uRLConnectionOpenConnection.setReadTimeout(30000);
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
        BufferedInputStream bufferedInputStreamM2742a;
        InputStream inputStream2 = null;
        Bitmap bitmapDecodeStream = this.f3217a;
        if (bitmapDecodeStream == null) {
            Uri uri = this.f3218b;
            try {
                if (uri != null) {
                    try {
                        bufferedInputStreamM2742a = m2742a(uri);
                        try {
                            if (bufferedInputStreamM2742a == null) {
                                Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri);
                                if (bufferedInputStreamM2742a == null) {
                                    return null;
                                }
                            } else {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(bufferedInputStreamM2742a, null, options);
                                if (options.outWidth != 0 && options.outHeight != 0) {
                                    try {
                                        bufferedInputStreamM2742a.reset();
                                    } catch (IOException unused) {
                                        bufferedInputStreamM2742a.close();
                                        bufferedInputStreamM2742a = m2742a(uri);
                                        if (bufferedInputStreamM2742a == null) {
                                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri);
                                            if (bufferedInputStreamM2742a == null) {
                                                return null;
                                            }
                                        }
                                        bufferedInputStreamM2742a.close();
                                        return null;
                                    }
                                    options.inJustDecodeBounds = false;
                                    options.inSampleSize = Math.max(1, Integer.highestOneBit(options.outHeight / this.f3220d.f3334m.getResources().getDimensionPixelSize(R.dimen.mr_cast_meta_art_size)));
                                    if (!isCancelled()) {
                                        bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStreamM2742a, null, options);
                                        try {
                                            bufferedInputStreamM2742a.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedInputStreamM2742a.close();
                                return null;
                            } catch (IOException unused3) {
                                return null;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri, e);
                            if (bufferedInputStreamM2742a != null) {
                                try {
                                    bufferedInputStreamM2742a.close();
                                } catch (IOException unused4) {
                                }
                            }
                            bitmapDecodeStream = null;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        bufferedInputStreamM2742a = null;
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
            this.f3219c = Collections.unmodifiableList(arrayList).isEmpty() ? 0 : ((C3694d) Collections.unmodifiableList(arrayList).get(0)).f12363d;
        }
        return bitmapDecodeStream;
    }

    @Override
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        DialogC1109q0 dialogC1109q0 = this.f3220d;
        dialogC1109q0.f3319L = null;
        Bitmap bitmap2 = dialogC1109q0.f3320M;
        Bitmap bitmap3 = this.f3217a;
        boolean zEquals = Objects.equals(bitmap2, bitmap3);
        Uri uri = this.f3218b;
        if (zEquals && Objects.equals(dialogC1109q0.f3321N, uri)) {
            return;
        }
        dialogC1109q0.f3320M = bitmap3;
        dialogC1109q0.f3323P = bitmap;
        dialogC1109q0.f3321N = uri;
        dialogC1109q0.f3324Q = this.f3219c;
        dialogC1109q0.f3322O = true;
        dialogC1109q0.m2777n();
    }

    @Override
    public final void onPreExecute() {
        DialogC1109q0 dialogC1109q0 = this.f3220d;
        dialogC1109q0.f3322O = false;
        dialogC1109q0.f3323P = null;
        dialogC1109q0.f3324Q = 0;
    }
}
