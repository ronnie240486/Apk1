package p129m1;

import android.content.Context;
import android.service.media.MediaBrowserService;
import p101j7.C2782c;

public class C3034f extends C3032d {

    public final C3035g f10371b;

    public C3034f(C3035g c3035g, Context context) {
        super(c3035g, context);
        this.f10371b = c3035g;
    }

    @Override
    public final void onLoadItem(String str, MediaBrowserService.Result result) {
        C2782c c2782c = new C2782c(12, result);
        C3030b c3030b = this.f10371b.f10372e.f2572b;
        ((MediaBrowserService.Result) c2782c.f9501b).sendResult(null);
    }
}
