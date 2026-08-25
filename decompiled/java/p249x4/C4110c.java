package p249x4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.p2serv.android.p032ds.R;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import p005a4.C0052k;
import p018b5.AbstractC1312l;
import p018b5.AbstractC1323w;
import p123l5.C2974b;
import p156o9.AbstractC3281e;

public class C4110c {

    public static final int f13934a;

    public static final C4110c f13935b;

    static {
        AtomicBoolean atomicBoolean = AbstractC4111d.f13936a;
        f13934a = 12451000;
        f13935b = new C4110c();
    }

    public Intent m8128a(Context context, int i6, String str) {
        if (i6 != 1 && i6 != 2) {
            if (i6 != 3) {
                return null;
            }
            int i10 = AbstractC1323w.f4131a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && AbstractC3281e.m6633w(context)) {
            int i11 = AbstractC1323w.f4131a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(f13934a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                C0052k c0052kM6025a = C2974b.m6025a(context);
                sb.append(c0052kM6025a.f155b.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        int i12 = AbstractC1323w.f4131a;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(TtmlNode.ATTR_ID, "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public int m8129b(Context context, int i6) {
        boolean z7;
        PackageInfo packageInfo;
        int i10;
        int i11;
        ApplicationInfo applicationInfo;
        boolean z10 = false;
        AtomicBoolean atomicBoolean = AbstractC4111d.f13936a;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !AbstractC4111d.f13937b.get()) {
            synchronized (AbstractC1312l.f4098a) {
                try {
                    if (!AbstractC1312l.f4099b) {
                        AbstractC1312l.f4099b = true;
                        try {
                            Bundle bundle = C2974b.m6025a(context).f155b.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle != null) {
                                bundle.getString("com.google.app.id");
                                AbstractC1312l.f4100c = bundle.getInt("com.google.android.gms.version");
                            }
                        } catch (PackageManager.NameNotFoundException e5) {
                            Log.wtf("MetadataValueReader", "This should never happen.", e5);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i12 = AbstractC1312l.f4100c;
            if (i12 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (i12 != 12451000) {
                throw new GooglePlayServicesIncorrectManifestValueException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f13934a + " but found " + i12 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        if (AbstractC3281e.m6633w(context)) {
            z7 = false;
        } else {
            if (AbstractC3281e.f10986c == null) {
                AbstractC3281e.f10986c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (AbstractC3281e.f10986c.booleanValue()) {
                z7 = false;
            } else {
                z7 = true;
            }
        }
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        int i13 = 9;
        if (z7) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C4112e.m8130j(context);
            if (!C4112e.m8133w(packageInfo2)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else if (z7) {
                AbstractC1312l.m3198e(packageInfo);
                if (!C4112e.m8133w(packageInfo)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else if (z7 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    i10 = packageInfo2.versionCode;
                    if (i10 == -1) {
                        i11 = -1;
                    } else {
                        i11 = i10 / 1000;
                    }
                    if (i11 < (i6 != -1 ? i6 / 1000 : -1)) {
                        Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i6 + " but found " + i10);
                        i13 = 2;
                    } else {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e10) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e10);
                                i13 = 1;
                            }
                        }
                        if (applicationInfo.enabled) {
                            i13 = 0;
                        } else {
                            i13 = 3;
                        }
                    }
                } else {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            } else if (z7) {
                i10 = packageInfo2.versionCode;
                if (i10 == -1) {
                    i11 = -1;
                } else {
                    i11 = i10 / 1000;
                }
                if (i11 < (i6 != -1 ? i6 / 1000 : -1)) {
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i6 + " but found " + i10);
                    i13 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i13 = 3;
                    } else {
                        i13 = 0;
                    }
                }
            } else {
                i10 = packageInfo2.versionCode;
                if (i10 == -1) {
                    i11 = -1;
                } else {
                    i11 = i10 / 1000;
                }
                if (i11 < (i6 != -1 ? i6 / 1000 : -1)) {
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i6 + " but found " + i10);
                    i13 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i13 = 3;
                    } else {
                        i13 = 0;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
        }
        if (i13 == 18) {
            z10 = true;
        } else if (i13 == 1) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                do {
                    if (!it.hasNext()) {
                        z10 = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                    }
                } while (!"com.google.android.gms".equals(it.next().getAppPackageName()));
                z10 = true;
            } catch (PackageManager.NameNotFoundException | Exception unused4) {
            }
        }
        if (z10) {
            return 18;
        }
        return i13;
    }
}
