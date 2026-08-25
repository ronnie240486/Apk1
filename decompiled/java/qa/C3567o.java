package qa;

import android.app.Activity;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p243w8.C4067i;

public final class C3567o {

    public final Activity f12022a;

    public final C4067i f12023b;

    public C3567o(Activity activity) {
        AbstractC2796i.m5785f(activity, AbstractC0032a.m165s("7+vNjiN4Rw==\n", "jISj+kYAMzQ=\n"));
        this.f12022a = activity;
        this.f12023b = new C4067i(new C3553a(2, this));
    }

    public final void m7185a() {
        C3564l c3564lM7186b = m7186b();
        if (c3564lM7186b.f11993d == null || !c3564lM7186b.m7175a().isShowing()) {
            return;
        }
        c3564lM7186b.m7175a().dismiss();
    }

    public final C3564l m7186b() {
        return (C3564l) this.f12023b.getValue();
    }
}
