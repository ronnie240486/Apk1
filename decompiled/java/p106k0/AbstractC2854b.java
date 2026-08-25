package p106k0;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import androidx.media3.datasource.cache.C0646c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p025c2.C1381b;
import p028c6.C1399b;
import p046e0.AbstractC2343b;
import p055ea.AbstractC2460q;

public abstract class AbstractC2854b {

    public static final C0646c f9768a = new C0646c(2);

    public static C1399b m5858a(Context context, C1381b c1381b) throws PackageManager.NameNotFoundException {
        Cursor cursor;
        Cursor cursorQuery;
        int columnIndex;
        int columnIndex2;
        int columnIndex3;
        int columnIndex4;
        int columnIndex5;
        int columnIndex6;
        int i6;
        int i10;
        Uri uriWithAppendedId;
        int i11;
        boolean z7;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) c1381b.f4198b;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(AbstractC2460q.m5501o("No package found for authority: ", str));
        }
        String str2 = providerInfoResolveContentProvider.packageName;
        String str3 = (String) c1381b.f4199c;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str3);
        }
        Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        C0646c c0646c = f9768a;
        Collections.sort(arrayList, c0646c);
        List listM5324l = (List) c1381b.f4201e;
        if (listM5324l == null) {
            listM5324l = AbstractC2343b.m5324l(resources, 0);
        }
        int i12 = 0;
        loop1: while (true) {
            cursor = null;
            if (i12 >= listM5324l.size()) {
                providerInfoResolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) listM5324l.get(i12));
            Collections.sort(arrayList2, c0646c);
            if (arrayList.size() == arrayList2.size()) {
                int i13 = 0;
                while (true) {
                    if (i13 >= arrayList.size()) {
                        break loop1;
                    }
                    if (!Arrays.equals((byte[]) arrayList.get(i13), (byte[]) arrayList2.get(i13))) {
                        break;
                    }
                    i13++;
                }
            }
            i12++;
        }
        if (providerInfoResolveContentProvider == null) {
            return new C1399b(1, (C2859g[]) null);
        }
        String str4 = providerInfoResolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str4).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str4).appendPath("file").build();
        C2853a c2853a = Build.VERSION.SDK_INT < 24 ? new C2853a(context, uriBuild, 0) : new C2853a(context, uriBuild, 1);
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            String[] strArr2 = {(String) c1381b.f4200d};
            switch (c2853a.f9766a) {
                case 0:
                    cursorQuery = null;
                    ContentProviderClient contentProviderClient = c2853a.f9767b;
                    if (contentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClient.query(uriBuild, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e5) {
                            Log.w("FontsProvider", "Unable to query the content provider", e5);
                        }
                        break;
                    }
                    cursor = cursorQuery;
                    if (cursor != null && cursor.getCount() > 0) {
                        columnIndex = cursor.getColumnIndex("result_code");
                        arrayList3 = new ArrayList();
                        columnIndex2 = cursor.getColumnIndex("_id");
                        columnIndex3 = cursor.getColumnIndex("file_id");
                        columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        columnIndex5 = cursor.getColumnIndex("font_weight");
                        columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i6 = cursor.getInt(columnIndex);
                            } else {
                                i6 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i10 = cursor.getInt(columnIndex4);
                            } else {
                                i10 = 0;
                            }
                            if (columnIndex3 == -1) {
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursor.getLong(columnIndex2));
                            } else {
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursor.getLong(columnIndex3));
                            }
                            Uri uri = uriWithAppendedId;
                            if (columnIndex5 != -1) {
                                i11 = cursor.getInt(columnIndex5);
                            } else {
                                i11 = 400;
                            }
                            if (columnIndex6 == -1 && cursor.getInt(columnIndex6) == 1) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            arrayList3.add(new C2859g(uri, i10, i11, z7, i6));
                            break;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2853a.m5857a();
                    return new C1399b(0, (C2859g[]) arrayList3.toArray(new C2859g[0]));
                default:
                    cursorQuery = null;
                    ContentProviderClient contentProviderClient2 = c2853a.f9767b;
                    if (contentProviderClient2 != null) {
                        try {
                            cursorQuery = contentProviderClient2.query(uriBuild, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e10) {
                            Log.w("FontsProvider", "Unable to query the content provider", e10);
                        }
                        break;
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        columnIndex = cursor.getColumnIndex("result_code");
                        arrayList3 = new ArrayList();
                        columnIndex2 = cursor.getColumnIndex("_id");
                        columnIndex3 = cursor.getColumnIndex("file_id");
                        columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        columnIndex5 = cursor.getColumnIndex("font_weight");
                        columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i6 = cursor.getInt(columnIndex);
                            } else {
                                i6 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i10 = cursor.getInt(columnIndex4);
                            } else {
                                i10 = 0;
                            }
                            if (columnIndex3 == -1) {
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursor.getLong(columnIndex2));
                            } else {
                                uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursor.getLong(columnIndex3));
                            }
                            Uri uri2 = uriWithAppendedId;
                            if (columnIndex5 != -1) {
                                i11 = cursor.getInt(columnIndex5);
                            } else {
                                i11 = 400;
                            }
                            if (columnIndex6 == -1) {
                                z7 = false;
                            } else {
                                z7 = false;
                            }
                            arrayList3.add(new C2859g(uri2, i10, i11, z7, i6));
                            break;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2853a.m5857a();
                    return new C1399b(0, (C2859g[]) arrayList3.toArray(new C2859g[0]));
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            c2853a.m5857a();
            throw th;
        }
    }
}
