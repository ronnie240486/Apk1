package p009aa;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Locale;
import p048e2.C2373h;
import p061f8.C2502b;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;
import p221u6.C3905e;
import p243w8.C4070l;

public final class C0083c extends AbstractC2797j implements InterfaceC2724l {

    public final int f208a;

    public final Object f209b;

    public C0083c(int i6, Object obj) {
        super(1);
        this.f208a = i6;
        this.f209b = obj;
    }

    @Override
    public final Object invoke(Object obj) {
        switch (this.f208a) {
            case 0:
                ((C0085e) this.f209b).m255b();
                break;
            case 1:
                ((C2373h) this.f209b).f8314k = true;
                break;
            default:
                Activity activity = (Activity) obj;
                AbstractC2796i.m5786g(activity, "it");
                Locale localeM219B = ((C2502b) this.f209b).f8736b.m219B();
                AbstractC2796i.m5786g(localeM219B, "locale");
                C3905e.m7795j(activity, localeM219B);
                Context applicationContext = activity.getApplicationContext();
                if (applicationContext != activity) {
                    AbstractC2796i.m5781b(applicationContext, "appContext");
                    C3905e.m7795j(applicationContext, localeM219B);
                }
                try {
                    int i6 = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128).labelRes;
                    if (i6 != 0) {
                        activity.setTitle(i6);
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    e5.printStackTrace();
                }
                break;
        }
        return C4070l.f13734a;
    }
}
