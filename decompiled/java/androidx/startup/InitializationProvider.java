package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;
import androidx.fragment.app.C0423q;
import p238w1.C4046a;

public class InitializationProvider extends ContentProvider {
    @Override
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override
    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            throw new C0423q("Context cannot be null", 10);
        }
        if (context.getApplicationContext() == null) {
            return true;
        }
        C4046a c4046aM8050c = C4046a.m8050c(context);
        Context context2 = c4046aM8050c.f13707c;
        try {
            try {
                Trace.beginSection("Startup");
                c4046aM8050c.m8051a(context2.getPackageManager().getProviderInfo(new ComponentName(context2.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                Trace.endSection();
                return true;
            } catch (PackageManager.NameNotFoundException e5) {
                throw new C0423q(e5, 10);
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
