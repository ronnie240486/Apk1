package p143n5;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader;
import com.google.android.gms.internal.cast.C1613l1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import p018b5.AbstractC1312l;
import p049e3.AbstractC2382c0;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p188r5.AbstractC3635a;
import p221u6.C3905e;
import p249x4.C4110c;
import p249x4.C4112e;

public final class C3197c {

    public static Boolean f10756c = null;

    public static String f10757d = null;

    public static boolean f10758e = false;

    public static int f10759f = -1;

    public static Boolean f10760g;

    public static C3201g f10764k;

    public static C3202h f10765l;

    public final Context f10766a;

    public static final ThreadLocal f10761h = new ThreadLocal();

    public static final C1613l1 f10762i = new C1613l1(2);

    public static final C3905e f10763j = new C3905e(21);

    public static final C4112e f10755b = new C4112e(21);

    public C3197c(Context context) {
        this.f10766a = context;
    }

    public static C3197c m6420a(Context context, C4112e c4112e) throws Throwable {
        Cursor cursor;
        C3197c c3197c;
        int i6;
        Boolean bool;
        C3201g c3201gM6425f;
        int i10;
        InterfaceC3078a interfaceC3078aM6482z;
        Object objM6112y;
        C3197c c3197c2;
        C3200f c3200f;
        C3202h c3202h;
        C3200f c3200f2;
        InterfaceC3078a interfaceC3078aM6484z;
        Cursor cursor2;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new C3195a("null application Context");
        }
        ThreadLocal threadLocal = f10761h;
        C3200f c3200f3 = (C3200f) threadLocal.get();
        C3200f c3200f4 = new C3200f();
        threadLocal.set(c3200f4);
        C1613l1 c1613l1 = f10762i;
        Long l9 = (Long) c1613l1.get();
        long jLongValue = l9.longValue();
        try {
            c1613l1.set(Long.valueOf(SystemClock.uptimeMillis()));
            C3196b c3196bM8137u = c4112e.m8137u(context, f10763j);
            try {
                Log.i("DynamiteModule", "Considering local module com.google.android.gms.cast.framework.dynamite:" + c3196bM8137u.f10752a + " and remote module com.google.android.gms.cast.framework.dynamite:" + c3196bM8137u.f10753b);
                int i11 = c3196bM8137u.f10754c;
                if (i11 != 0) {
                    if (i11 != -1) {
                        boolean z7 = true;
                        if (i11 == 1 || c3196bM8137u.f10753b != 0) {
                            if (i11 == -1) {
                                Log.i("DynamiteModule", "Selected local version of ".concat("com.google.android.gms.cast.framework.dynamite"));
                                c3197c = new C3197c(applicationContext);
                            } else {
                                if (i11 == 1) {
                                    throw new C3195a("VersionPolicy returned invalid code:" + i11);
                                }
                                try {
                                    i6 = c3196bM8137u.f10753b;
                                    try {
                                        synchronized (C3197c.class) {
                                            if (m6424e(context)) {
                                                throw new C3195a("Remote loading disabled");
                                            }
                                            bool = f10756c;
                                        }
                                        if (bool != null) {
                                            throw new C3195a("Failed to determine which loading route to use.");
                                        }
                                        if (bool.booleanValue()) {
                                            Log.i("DynamiteModule", "Selected remote version of com.google.android.gms.cast.framework.dynamite, version >= " + i6);
                                            synchronized (C3197c.class) {
                                                c3202h = f10765l;
                                            }
                                            if (c3202h != null) {
                                                throw new C3195a("DynamiteLoaderV2 was not cached.");
                                            }
                                            c3200f2 = (C3200f) threadLocal.get();
                                            if (c3200f2 != null || c3200f2.f10773a == null) {
                                                throw new C3195a("No result cursor");
                                            }
                                            Context applicationContext2 = context.getApplicationContext();
                                            Cursor cursor3 = c3200f2.f10773a;
                                            new BinderC3079b(null);
                                            synchronized (C3197c.class) {
                                                if (f10759f < 2) {
                                                    z7 = false;
                                                }
                                            }
                                            if (z7) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                interfaceC3078aM6484z = c3202h.m6483A(new BinderC3079b(applicationContext2), i6, new BinderC3079b(cursor3));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                interfaceC3078aM6484z = c3202h.m6484z(new BinderC3079b(applicationContext2), i6, new BinderC3079b(cursor3));
                                            }
                                            Context context2 = (Context) BinderC3079b.m6112y(interfaceC3078aM6484z);
                                            if (context2 == null) {
                                                throw new C3195a("Failed to get module context");
                                            }
                                            c3197c2 = new C3197c(context2);
                                        } else {
                                            Log.i("DynamiteModule", "Selected remote version of com.google.android.gms.cast.framework.dynamite, version >= " + i6);
                                            c3201gM6425f = m6425f(context);
                                            if (c3201gM6425f != null) {
                                                throw new C3195a("Failed to create IDynamiteLoader.");
                                            }
                                            Parcel parcelM3686g = c3201gM6425f.m3686g(c3201gM6425f.m3687l(), 6);
                                            i10 = parcelM3686g.readInt();
                                            parcelM3686g.recycle();
                                            if (i10 >= 3) {
                                                c3200f = (C3200f) threadLocal.get();
                                                if (c3200f != null) {
                                                    throw new C3195a("No cached result cursor holder");
                                                }
                                                interfaceC3078aM6482z = c3201gM6425f.m6479A(new BinderC3079b(context), i6, new BinderC3079b(c3200f.f10773a));
                                            } else if (i10 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                interfaceC3078aM6482z = c3201gM6425f.m6480B(new BinderC3079b(context), i6);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                interfaceC3078aM6482z = c3201gM6425f.m6482z(new BinderC3079b(context), i6);
                                            }
                                            objM6112y = BinderC3079b.m6112y(interfaceC3078aM6482z);
                                            if (objM6112y != null) {
                                                throw new C3195a("Failed to load remote module.");
                                            }
                                            c3197c2 = new C3197c((Context) objM6112y);
                                        }
                                        c3197c = c3197c2;
                                    } catch (RemoteException e5) {
                                        throw new C3195a("Failed to load remote module.", e5);
                                    } catch (C3195a e10) {
                                        throw e10;
                                    } catch (Throwable th) {
                                        throw new C3195a("Failed to load remote module.", th);
                                    }
                                } catch (C3195a e11) {
                                    Log.w("DynamiteModule", "Failed to load remote module: " + e11.getMessage());
                                    int i12 = c3196bM8137u.f10752a;
                                    if (i12 != 0) {
                                        try {
                                            C3196b c3196b = new C3196b();
                                            c3196b.f10753b = 0;
                                            c3196b.f10752a = i12;
                                            if (i12 != 0) {
                                                c3196b.f10754c = -1;
                                            }
                                            if (c3196b.f10754c == -1) {
                                                try {
                                                    Log.i("DynamiteModule", "Selected local version of ".concat("com.google.android.gms.cast.framework.dynamite"));
                                                    c3197c = new C3197c(applicationContext);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    c3200f3 = c3200f3;
                                                    if (jLongValue == 0) {
                                                        f10762i.remove();
                                                    } else {
                                                        f10762i.set(l9);
                                                    }
                                                    cursor = c3200f4.f10773a;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    f10761h.set(c3200f3);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                    throw new C3195a("Remote load failed. No local fallback found.", e11);
                                }
                            }
                            if (jLongValue == 0) {
                                f10762i.remove();
                            } else {
                                f10762i.set(l9);
                            }
                            cursor2 = c3200f4.f10773a;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            f10761h.set(c3200f3);
                            return c3197c;
                        }
                    } else if (c3196bM8137u.f10752a != 0) {
                        i11 = -1;
                        boolean z10 = true;
                        if (i11 == 1) {
                        }
                        if (i11 == -1) {
                            Log.i("DynamiteModule", "Selected local version of ".concat("com.google.android.gms.cast.framework.dynamite"));
                            c3197c = new C3197c(applicationContext);
                        } else {
                            if (i11 == 1) {
                                throw new C3195a("VersionPolicy returned invalid code:" + i11);
                            }
                            i6 = c3196bM8137u.f10753b;
                            synchronized (C3197c.class) {
                                if (m6424e(context)) {
                                    throw new C3195a("Remote loading disabled");
                                }
                                bool = f10756c;
                                if (bool != null) {
                                    throw new C3195a("Failed to determine which loading route to use.");
                                }
                                if (bool.booleanValue()) {
                                    Log.i("DynamiteModule", "Selected remote version of com.google.android.gms.cast.framework.dynamite, version >= " + i6);
                                    synchronized (C3197c.class) {
                                        c3202h = f10765l;
                                        if (c3202h != null) {
                                            throw new C3195a("DynamiteLoaderV2 was not cached.");
                                        }
                                        c3200f2 = (C3200f) threadLocal.get();
                                        if (c3200f2 != null) {
                                        }
                                        throw new C3195a("No result cursor");
                                    }
                                }
                                Log.i("DynamiteModule", "Selected remote version of com.google.android.gms.cast.framework.dynamite, version >= " + i6);
                                c3201gM6425f = m6425f(context);
                                if (c3201gM6425f != null) {
                                    throw new C3195a("Failed to create IDynamiteLoader.");
                                }
                                Parcel parcelM3686g2 = c3201gM6425f.m3686g(c3201gM6425f.m3687l(), 6);
                                i10 = parcelM3686g2.readInt();
                                parcelM3686g2.recycle();
                                if (i10 >= 3) {
                                    c3200f = (C3200f) threadLocal.get();
                                    if (c3200f != null) {
                                        throw new C3195a("No cached result cursor holder");
                                    }
                                    interfaceC3078aM6482z = c3201gM6425f.m6479A(new BinderC3079b(context), i6, new BinderC3079b(c3200f.f10773a));
                                } else if (i10 == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                    interfaceC3078aM6482z = c3201gM6425f.m6480B(new BinderC3079b(context), i6);
                                } else {
                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                    interfaceC3078aM6482z = c3201gM6425f.m6482z(new BinderC3079b(context), i6);
                                }
                                objM6112y = BinderC3079b.m6112y(interfaceC3078aM6482z);
                                if (objM6112y != null) {
                                    throw new C3195a("Failed to load remote module.");
                                }
                                c3197c2 = new C3197c((Context) objM6112y);
                                c3197c = c3197c2;
                            }
                        }
                        if (jLongValue == 0) {
                            f10762i.remove();
                        } else {
                            f10762i.set(l9);
                        }
                        cursor2 = c3200f4.f10773a;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        f10761h.set(c3200f3);
                        return c3197c;
                    }
                    if (jLongValue == 0) {
                        f10762i.remove();
                    } else {
                        f10762i.set(l9);
                    }
                    cursor = c3200f4.f10773a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    f10761h.set(c3200f3);
                    throw th;
                }
                throw new C3195a("No acceptable module com.google.android.gms.cast.framework.dynamite found. Local version is " + c3196bM8137u.f10752a + " and remote version is " + c3196bM8137u.f10753b + ".");
            } catch (Throwable th4) {
                th = th4;
                c3200f3 = c3200f3;
                if (jLongValue == 0) {
                    f10762i.remove();
                } else {
                    f10762i.set(l9);
                }
                cursor = c3200f4.f10773a;
                if (cursor != null) {
                    cursor.close();
                }
                f10761h.set(c3200f3);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static int m6421b(Context context, String str, boolean z7) {
        Throwable th;
        RemoteException e5;
        int i6;
        Cursor cursor;
        try {
            synchronized (C3197c.class) {
                Boolean bool = f10756c;
                boolean z10 = true;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule$DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else if (classLoader != null) {
                                    try {
                                        m6423d(classLoader);
                                    } catch (C3195a unused) {
                                    }
                                    bool = Boolean.TRUE;
                                } else {
                                    if (!m6424e(context)) {
                                        return 0;
                                    }
                                    if (f10758e) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        Boolean bool2 = Boolean.TRUE;
                                        if (bool2.equals(null)) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        } else {
                                            try {
                                                int iM6422c = m6422c(context, str, z7, true);
                                                String str2 = f10757d;
                                                if (str2 != null && !str2.isEmpty()) {
                                                    ClassLoader classLoaderM6450Y = AbstractC3198d.m6450Y();
                                                    if (classLoaderM6450Y == null) {
                                                        if (Build.VERSION.SDK_INT >= 29) {
                                                            AbstractC2382c0.m5409c();
                                                            String str3 = f10757d;
                                                            AbstractC1312l.m3198e(str3);
                                                            classLoaderM6450Y = AbstractC2382c0.m5408b(str3, ClassLoader.getSystemClassLoader());
                                                        } else {
                                                            String str4 = f10757d;
                                                            AbstractC1312l.m3198e(str4);
                                                            classLoaderM6450Y = new C3199e(str4, ClassLoader.getSystemClassLoader());
                                                        }
                                                    }
                                                    m6423d(classLoaderM6450Y);
                                                    declaredField.set(null, classLoaderM6450Y);
                                                    f10756c = bool2;
                                                    return iM6422c;
                                                }
                                                return iM6422c;
                                            } catch (C3195a unused2) {
                                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                bool = Boolean.FALSE;
                                            }
                                        }
                                    }
                                }
                                f10756c = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e10) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e10.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return m6422c(context, str, z7, false);
                    } catch (C3195a e11) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e11.getMessage());
                        return 0;
                    }
                }
                C3201g c3201gM6425f = m6425f(context);
                try {
                    if (c3201gM6425f == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelM3686g = c3201gM6425f.m3686g(c3201gM6425f.m3687l(), 6);
                        int i10 = parcelM3686g.readInt();
                        parcelM3686g.recycle();
                        if (i10 >= 3) {
                            ThreadLocal threadLocal = f10761h;
                            C3200f c3200f = (C3200f) threadLocal.get();
                            if (c3200f != null && (cursor = c3200f.f10773a) != null) {
                                return cursor.getInt(0);
                            }
                            Cursor cursor3 = (Cursor) BinderC3079b.m6112y(c3201gM6425f.m6481C(new BinderC3079b(context), str, z7, ((Long) f10762i.get()).longValue()));
                            if (cursor3 != null) {
                                try {
                                    if (cursor3.moveToFirst()) {
                                        i6 = cursor3.getInt(0);
                                        if (i6 > 0) {
                                            C3200f c3200f2 = (C3200f) threadLocal.get();
                                            if (c3200f2 == null || c3200f2.f10773a != null) {
                                                z10 = false;
                                            } else {
                                                c3200f2.f10773a = cursor3;
                                            }
                                            cursor2 = z10 ? null : cursor3;
                                        }
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e12) {
                                    e5 = e12;
                                    cursor2 = cursor3;
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e5.getMessage());
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor2 = cursor3;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor3 == null) {
                                return 0;
                            }
                            cursor3.close();
                            return 0;
                        }
                        if (i10 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            BinderC3079b binderC3079b = new BinderC3079b(context);
                            Parcel parcelM3687l = c3201gM6425f.m3687l();
                            AbstractC3635a.m7362c(parcelM3687l, binderC3079b);
                            parcelM3687l.writeString(str);
                            parcelM3687l.writeInt(z7 ? 1 : 0);
                            Parcel parcelM3686g2 = c3201gM6425f.m3686g(parcelM3687l, 5);
                            i6 = parcelM3686g2.readInt();
                            parcelM3686g2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            BinderC3079b binderC3079b2 = new BinderC3079b(context);
                            Parcel parcelM3687l2 = c3201gM6425f.m3687l();
                            AbstractC3635a.m7362c(parcelM3687l2, binderC3079b2);
                            parcelM3687l2.writeString(str);
                            parcelM3687l2.writeInt(z7 ? 1 : 0);
                            Parcel parcelM3686g3 = c3201gM6425f.m3686g(parcelM3687l2, 3);
                            i6 = parcelM3686g3.readInt();
                            parcelM3686g3.recycle();
                        }
                        return i6;
                    } catch (RemoteException e13) {
                        e5 = e13;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            try {
                AbstractC1312l.m3198e(context);
            } catch (Exception e14) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e14);
            }
            throw th5;
        }
    }

    public static int m6422c(Context context, String str, boolean z7, boolean z10) throws Throwable {
        MatrixCursor matrixCursor;
        boolean z11;
        MatrixCursor matrixCursor2 = null;
        try {
            try {
                boolean z12 = true;
                Uri uriBuild = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z7 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(((Long) f10762i.get()).longValue())).build();
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                boolean z13 = false;
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    matrixCursor = null;
                } else {
                    try {
                        Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, null, null, null, null);
                        if (cursorQuery == null) {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                            matrixCursor = null;
                        } else {
                            try {
                                int count = cursorQuery.getCount();
                                int columnCount = cursorQuery.getColumnCount();
                                matrixCursor = new MatrixCursor(cursorQuery.getColumnNames(), count);
                                for (int i6 = 0; i6 < count; i6++) {
                                    if (!cursorQuery.moveToPosition(i6)) {
                                        throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                    }
                                    Object[] objArr = new Object[columnCount];
                                    for (int i10 = 0; i10 < columnCount; i10++) {
                                        int type = cursorQuery.getType(i10);
                                        if (type == 0) {
                                            objArr[i10] = null;
                                        } else if (type == 1) {
                                            objArr[i10] = Long.valueOf(cursorQuery.getLong(i10));
                                        } else if (type == 2) {
                                            objArr[i10] = Double.valueOf(cursorQuery.getDouble(i10));
                                        } else if (type == 3) {
                                            objArr[i10] = cursorQuery.getString(i10);
                                        } else {
                                            if (type != 4) {
                                                throw new RemoteException("Unknown column type");
                                            }
                                            objArr[i10] = cursorQuery.getBlob(i10);
                                        }
                                    }
                                    matrixCursor.addRow(objArr);
                                }
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                            } catch (Throwable th) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                    } catch (RemoteException unused) {
                    } catch (Throwable th3) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        throw th3;
                    }
                }
                if (matrixCursor != null) {
                    try {
                        if (matrixCursor.moveToFirst()) {
                            int i11 = matrixCursor.getInt(0);
                            if (i11 > 0) {
                                synchronized (C3197c.class) {
                                    try {
                                        f10757d = matrixCursor.getString(2);
                                        int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            f10759f = matrixCursor.getInt(columnIndex);
                                        }
                                        int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            z11 = matrixCursor.getInt(columnIndex2) != 0;
                                            f10758e = z11;
                                        } else {
                                            z11 = false;
                                        }
                                    } catch (Throwable th4) {
                                        throw th4;
                                    }
                                }
                                C3200f c3200f = (C3200f) f10761h.get();
                                if (c3200f == null || c3200f.f10773a != null) {
                                    z12 = false;
                                } else {
                                    c3200f.f10773a = matrixCursor;
                                }
                                z13 = z11;
                                matrixCursor2 = z12 ? null : matrixCursor;
                            }
                            if (z10 && z13) {
                                throw new C3195a("forcing fallback to container DynamiteLoader impl");
                            }
                            if (matrixCursor2 != null) {
                                matrixCursor2.close();
                            }
                            return i11;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        if (e instanceof C3195a) {
                            throw e;
                        }
                        throw new C3195a("V2 version check failed: " + e.getMessage(), e);
                    } catch (Throwable th5) {
                        th = th5;
                        matrixCursor2 = matrixCursor;
                        if (matrixCursor2 != null) {
                            matrixCursor2.close();
                        }
                        throw th;
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new C3195a("Failed to connect to dynamite module ContentResolver.");
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void m6423d(ClassLoader classLoader) throws C3195a {
        try {
            C3202h c3202h = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                c3202h = iInterfaceQueryLocalInterface instanceof C3202h ? (C3202h) iInterfaceQueryLocalInterface : new C3202h(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 2);
            }
            f10765l = c3202h;
        } catch (ClassNotFoundException e5) {
            e = e5;
            throw new C3195a("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e10) {
            e = e10;
            throw new C3195a("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e11) {
            e = e11;
            throw new C3195a("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e12) {
            e = e12;
            throw new C3195a("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e13) {
            e = e13;
            throw new C3195a("Failed to instantiate dynamite loader", e);
        }
    }

    public static boolean m6424e(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f10760g)) {
            return true;
        }
        boolean z7 = false;
        if (f10760g == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", Build.VERSION.SDK_INT >= 29 ? 268435456 : 0);
            if (C4110c.f13935b.m8129b(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z7 = true;
            }
            f10760g = Boolean.valueOf(z7);
            if (z7 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f10758e = true;
            }
        }
        if (!z7) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z7;
    }

    public static C3201g m6425f(Context context) {
        C3201g c3201g;
        synchronized (C3197c.class) {
            C3201g c3201g2 = f10764k;
            if (c3201g2 != null) {
                return c3201g2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    c3201g = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    c3201g = iInterfaceQueryLocalInterface instanceof C3201g ? (C3201g) iInterfaceQueryLocalInterface : new C3201g(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 2);
                }
                if (c3201g != null) {
                    f10764k = c3201g;
                    return c3201g;
                }
            } catch (Exception e5) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e5.getMessage());
            }
            return null;
        }
    }
}
