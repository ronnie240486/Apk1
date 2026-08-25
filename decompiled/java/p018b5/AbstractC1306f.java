package p018b5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.p2serv.android.p032ds.R;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import p094j0.AbstractC2758f;
import p094j0.C2761i;
import p094j0.C2764l;
import p123l5.C2974b;
import p156o9.AbstractC3281e;
import p160p.C3347k;
import p249x4.AbstractC4111d;

public abstract class AbstractC1306f {

    public static final C3347k f4086a = new C3347k(0);

    public static Locale f4087b;

    public static String m3180a(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = C2974b.m6025a(context).f155b;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String m3181b(Context context, int i6) {
        Resources resources = context.getResources();
        String strM3180a = m3180a(context);
        if (i6 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, strM3180a);
        }
        if (i6 == 2) {
            return AbstractC3281e.m6633w(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, strM3180a);
        }
        if (i6 == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, strM3180a);
        }
        if (i6 == 5) {
            return m3183d(context, "common_google_play_services_invalid_account_text", strM3180a);
        }
        if (i6 == 7) {
            return m3183d(context, "common_google_play_services_network_error_text", strM3180a);
        }
        if (i6 == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, strM3180a);
        }
        if (i6 == 20) {
            return m3183d(context, "common_google_play_services_restricted_profile_text", strM3180a);
        }
        switch (i6) {
            case 16:
                return m3183d(context, "common_google_play_services_api_unavailable_text", strM3180a);
            case 17:
                return m3183d(context, "common_google_play_services_sign_in_failed_text", strM3180a);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, strM3180a);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue, strM3180a);
        }
    }

    public static String m3182c(Context context, int i6) {
        Resources resources = context.getResources();
        switch (i6) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m3184e(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m3184e(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i6);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m3184e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m3184e(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String m3183d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strM3184e = m3184e(context, str);
        if (strM3184e == null) {
            strM3184e = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strM3184e, str2);
    }

    public static String m3184e(Context context, String str) {
        Resources resourcesForApplication;
        C3347k c3347k = f4086a;
        synchronized (c3347k) {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                Locale locale = (Build.VERSION.SDK_INT >= 24 ? new C2761i(new C2764l(AbstractC2758f.m5725a(configuration))) : C2761i.m5732a(configuration.locale)).f9475a.get(0);
                if (!locale.equals(f4087b)) {
                    c3347k.clear();
                    f4087b = locale;
                }
                String str2 = (String) c3347k.get(str);
                if (str2 != null) {
                    return str2;
                }
                AtomicBoolean atomicBoolean = AbstractC4111d.f13936a;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication == null) {
                    return null;
                }
                int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: ".concat(str));
                    return null;
                }
                String string = resourcesForApplication.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    Log.w("GoogleApiAvailability", "Got empty resource: ".concat(str));
                    return null;
                }
                f4086a.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
