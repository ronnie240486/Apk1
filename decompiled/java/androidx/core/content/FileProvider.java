package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.lzy.okgo.cookie.SerializableCookie;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import p034d0.AbstractC2120f;
import p034d0.C2121g;
import p055ea.AbstractC2460q;

public class FileProvider extends ContentProvider {

    public static final String[] f1599d = {"_display_name", "_size"};

    public static final File f1600e = new File("/");

    public static final HashMap f1601f = new HashMap();

    public final Object f1602a = new Object();

    public String f1603b;

    public C2121g f1604c;

    public static String m1079a(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    public static C2121g m1080c(Context context, String str) {
        C2121g c2121gM1081d;
        HashMap map = f1601f;
        synchronized (map) {
            try {
                c2121gM1081d = (C2121g) map.get(str);
                if (c2121gM1081d == null) {
                    try {
                        try {
                            c2121gM1081d = m1081d(context, str);
                            map.put(str, c2121gM1081d);
                        } catch (IOException e5) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e5);
                        }
                    } catch (XmlPullParserException e10) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2121gM1081d;
    }

    public static C2121g m1081d(Context context, String str) throws XmlPullParserException, IOException {
        C2121g c2121g = new C2121g(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException(AbstractC2460q.m5501o("Couldn't find meta-data for provider with authority ", str));
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return c2121g;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, SerializableCookie.NAME);
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f1600e;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    if (externalFilesDirs.length > 0) {
                        externalStorageDirectory = externalFilesDirs[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] externalCacheDirs = context.getExternalCacheDirs();
                    if (externalCacheDirs.length > 0) {
                        externalStorageDirectory = externalCacheDirs[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] fileArrM5077a = AbstractC2120f.m5077a(context);
                    if (fileArrM5077a.length > 0) {
                        externalStorageDirectory = fileArrM5077a[0];
                    }
                }
                if (externalStorageDirectory == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        externalStorageDirectory = new File(externalStorageDirectory, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        c2121g.f7727b.put(attributeValue, externalStorageDirectory.getCanonicalFile());
                    } catch (IOException e5) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + externalStorageDirectory, e5);
                    }
                }
            }
        }
    }

    @Override
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        synchronized (this.f1602a) {
            this.f1603b = str;
        }
        HashMap map = f1601f;
        synchronized (map) {
            map.remove(str);
        }
    }

    public final C2121g m1082b() {
        C2121g c2121g;
        synchronized (this.f1602a) {
            try {
                if (this.f1603b == null) {
                    throw new NullPointerException("mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                }
                if (this.f1604c == null) {
                    this.f1604c = m1080c(getContext(), this.f1603b);
                }
                c2121g = this.f1604c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2121g;
    }

    @Override
    public final int delete(Uri uri, String str, String[] strArr) {
        return m1082b().m5079b(uri).delete() ? 1 : 0;
    }

    @Override
    public final String getType(Uri uri) {
        File fileM5079b = m1082b().m5079b(uri);
        int iLastIndexOf = fileM5079b.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileM5079b.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override
    public final String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override
    public final boolean onCreate() {
        return true;
    }

    @Override
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        int i6;
        File fileM5079b = m1082b().m5079b(uri);
        if ("r".equals(str)) {
            i6 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i6 = 738197504;
        } else if ("wa".equals(str)) {
            i6 = 704643072;
        } else if ("rw".equals(str)) {
            i6 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException(AbstractC2460q.m5501o("Invalid mode: ", str));
            }
            i6 = 1006632960;
        }
        return ParcelFileDescriptor.open(fileM5079b, i6);
    }

    @Override
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i6;
        File fileM5079b = m1082b().m5079b(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f1599d;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i10 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i10] = "_display_name";
                i6 = i10 + 1;
                objArr[i10] = queryParameter == null ? fileM5079b.getName() : queryParameter;
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i10] = "_size";
                    i6 = i10 + 1;
                    objArr[i10] = Long.valueOf(fileM5079b.length());
                }
            }
            i10 = i6;
        }
        String[] strArr4 = new String[i10];
        System.arraycopy(strArr3, 0, strArr4, 0, i10);
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
