package p061f8;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import com.bumptech.glide.AbstractC1466d;
import java.util.Locale;
import org.bitspark.android.SpkApplication;
import org.json.JSONException;
import p007a7.C0069f;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p221u6.C3905e;
import p243w8.C4070l;

public final class C2501a extends AbstractC2797j implements InterfaceC2724l {

    public final C2502b f8731a;

    public final SpkApplication f8732b;

    public C2501a(C2502b c2502b, SpkApplication spkApplication) {
        super(1);
        this.f8731a = c2502b;
        this.f8732b = spkApplication;
    }

    @Override
    public final Object invoke(Object obj) throws JSONException {
        Configuration configuration = (Configuration) obj;
        AbstractC2796i.m5786g(configuration, "it");
        C2502b c2502b = this.f8731a;
        c2502b.f8735a = AbstractC1466d.m3498q(configuration);
        C0069f c0069f = c2502b.f8736b;
        boolean z7 = ((SharedPreferences) c0069f.f196b).getBoolean("follow_system_locale_key", false);
        SpkApplication spkApplication = this.f8732b;
        if (z7) {
            c2502b.m5548a(spkApplication, c2502b.f8735a);
        } else {
            Locale localeM219B = c0069f.m219B();
            AbstractC2796i.m5786g(localeM219B, "locale");
            C3905e.m7795j(spkApplication, localeM219B);
            Context applicationContext = spkApplication.getApplicationContext();
            if (applicationContext != spkApplication) {
                AbstractC2796i.m5781b(applicationContext, "appContext");
                C3905e.m7795j(applicationContext, localeM219B);
            }
        }
        return C4070l.f13734a;
    }
}
