package p026c3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.io.File;
import java.io.FileNotFoundException;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p228v2.C3981h;

public final class C1394c implements InterfaceC1479e {

    public static final String[] f4245k = {"_data"};

    public final Context f4246a;

    public final InterfaceC1288u f4247b;

    public final InterfaceC1288u f4248c;

    public final Uri f4249d;

    public final int f4250e;

    public final int f4251f;

    public final C3981h f4252g;

    public final Class f4253h;

    public volatile boolean f4254i;

    public volatile InterfaceC1479e f4255j;

    public C1394c(Context context, InterfaceC1288u interfaceC1288u, InterfaceC1288u interfaceC1288u2, Uri uri, int i6, int i10, C3981h c3981h, Class cls) {
        this.f4246a = context.getApplicationContext();
        this.f4247b = interfaceC1288u;
        this.f4248c = interfaceC1288u2;
        this.f4249d = uri;
        this.f4250e = i6;
        this.f4251f = i10;
        this.f4252g = c3981h;
        this.f4253h = cls;
    }

    @Override
    public final Class mo3151a() {
        return this.f4253h;
    }

    @Override
    public final void mo3152b() {
        InterfaceC1479e interfaceC1479e = this.f4255j;
        if (interfaceC1479e != null) {
            interfaceC1479e.mo3152b();
        }
    }

    public final InterfaceC1479e m3267c() throws Throwable {
        C1287t c1287tMo3137a;
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.f4246a;
        C3981h c3981h = this.f4252g;
        int i6 = this.f4251f;
        int i10 = this.f4250e;
        if (zIsExternalStorageLegacy) {
            Uri uri = this.f4249d;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, f4245k, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            cursorQuery.close();
                            c1287tMo3137a = this.f4247b.mo3137a(file, i10, i6, c3981h);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri requireOriginal = this.f4249d;
            boolean zM3474i = AbstractC1465c.m3474i(requireOriginal);
            InterfaceC1288u interfaceC1288u = this.f4248c;
            if (zM3474i && requireOriginal.getPathSegments().contains("picker")) {
                c1287tMo3137a = interfaceC1288u.mo3137a(requireOriginal, i10, i6, c3981h);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                c1287tMo3137a = interfaceC1288u.mo3137a(requireOriginal, i10, i6, c3981h);
            }
        }
        if (c1287tMo3137a != null) {
            return c1287tMo3137a.f4054c;
        }
        return null;
    }

    @Override
    public final void cancel() {
        this.f4254i = true;
        InterfaceC1479e interfaceC1479e = this.f4255j;
        if (interfaceC1479e != null) {
            interfaceC1479e.cancel();
        }
    }

    @Override
    public final int mo3153d() {
        return 1;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) throws Throwable {
        try {
            InterfaceC1479e interfaceC1479eM3267c = m3267c();
            if (interfaceC1479eM3267c == null) {
                interfaceC1478d.mo3172c(new IllegalArgumentException("Failed to build fetcher for: " + this.f4249d));
            } else {
                this.f4255j = interfaceC1479eM3267c;
                if (this.f4254i) {
                    cancel();
                } else {
                    interfaceC1479eM3267c.mo3154f(enumC1469g, interfaceC1478d);
                }
            }
        } catch (FileNotFoundException e5) {
            interfaceC1478d.mo3172c(e5);
        }
    }
}
