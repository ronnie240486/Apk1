package p061f8;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p007a7.C0069f;
import p103j9.AbstractC2796i;
import p221u6.C3905e;

public final class C2502b {

    public static final Locale f8733c;

    public static C2502b f8734d;

    public Locale f8735a = f8733c;

    public final C0069f f8736b;

    static {
        Locale locale = Locale.getDefault();
        AbstractC2796i.m5781b(locale, "Locale.getDefault()");
        f8733c = locale;
    }

    public C2502b(C0069f c0069f, C3905e c3905e) {
        this.f8736b = c0069f;
    }

    public final void m5548a(Context context, Locale locale) throws JSONException {
        C0069f c0069f = this.f8736b;
        AbstractC2796i.m5786g(locale, "locale");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("language", locale.getLanguage());
        jSONObject.put("country", locale.getCountry());
        jSONObject.put("variant", locale.getVariant());
        ((SharedPreferences) c0069f.f196b).edit().putString("language_key", jSONObject.toString()).apply();
        AbstractC2796i.m5786g(context, "context");
        C3905e.m7795j(context, locale);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != context) {
            AbstractC2796i.m5781b(applicationContext, "appContext");
            C3905e.m7795j(applicationContext, locale);
        }
    }
}
