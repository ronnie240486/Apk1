package p116ka;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.RunnableC0005f;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p063fa.C2569x0;

public final class C2926j0 extends StringCallback {

    public final int f9934a;

    public final ViewOnKeyListenerC2932m0 f9935b;

    public C2926j0(ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0, int i6) {
        this.f9935b = viewOnKeyListenerC2932m0;
        this.f9934a = i6;
    }

    @Override
    public final void onCacheSuccess(Response response) {
        String strM165s = AbstractC0032a.m165s("UTJoJes=\n", "E2E+So/n/JA=\n");
        String strM165s2 = AbstractC0032a.m165s("AqbkUwxniDQNov4dH2TMERes/VMZaY8fAOP/GA==\n", "ZcOQc3oI7Hc=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        ViewOnKeyListenerC2932m0.f9950E0.post(new RunnableC0005f(24, this));
    }

    @Override
    public final void onError(Response response) {
        this.f9935b.f9968g0.setVisibility(8);
        String strM165s = AbstractC0032a.m165s("S7iweUg=\n", "CevmFix5i/s=\n");
        String str = AbstractC0032a.m165s("xti3ujHq0MnJ3K30IumU5c/4sego944=\n", "ob3DmkeFtIo=\n") + response.getException().toString();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
    }

    @Override
    public final void onSuccess(Response response) {
        int i6 = 0;
        String strM165s = AbstractC0032a.m165s("2HUPLwc=\n", "miZZQGMbCA8=\n");
        String str = AbstractC0032a.m165s("zjnwQ4apJBnBPeoNlapgPNsz6UODozIszC6kB5+oJWCJ\n", "qVyEY/DGQFo=\n") + ((String) response.body()).length();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = this.f9935b;
        String str2 = (String) response.body();
        int i10 = this.f9934a;
        String str3 = ViewOnKeyListenerC2932m0.f9947B0;
        viewOnKeyListenerC2932m0.getClass();
        AbstractC0032a.m165s("baeaeFTefhJujKx1btNaMHOhlXs6gSk=\n", "Acj7HBq7CUQ=\n");
        AbstractC0032a.m165s("TfZderpeT7FN9l16ul4=\n", "cMtgR4djcow=\n");
        if (i10 == viewOnKeyListenerC2932m0.f9982u0) {
            if (str2.isEmpty()) {
                ViewOnKeyListenerC2932m0.f9948C0.setVisibility(8);
                if (i10 == -5) {
                    ViewOnKeyListenerC2932m0.f9949D0.setVisibility(0);
                }
            } else if (viewOnKeyListenerC2932m0.m5929R(i10)) {
                try {
                    C2569x0 c2569x0 = new C2569x0(str2, viewOnKeyListenerC2932m0.m1319h(), i10);
                    viewOnKeyListenerC2932m0.f9965d0 = c2569x0;
                    if (ViewOnKeyListenerC2932m0.f9952G0) {
                        c2569x0.f8880g = 5;
                    }
                    c2569x0.f8881h = new C0069f((Object) viewOnKeyListenerC2932m0, 29, (Object) 3);
                    viewOnKeyListenerC2932m0.f9965d0.f8938p = new C2928k0(viewOnKeyListenerC2932m0, i10, i6);
                } catch (Exception e5) {
                    String str4 = ViewOnKeyListenerC2932m0.f9947B0;
                    String string = e5.toString();
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(str4, string);
                }
                ViewOnKeyListenerC2932m0.f9949D0.setVisibility(8);
                ViewOnKeyListenerC2932m0.f9948C0.setAdapter(viewOnKeyListenerC2932m0.f9965d0);
                if (ViewOnKeyListenerC2932m0.f9948C0.getVisibility() == 8) {
                    ViewOnKeyListenerC2932m0.f9948C0.setVisibility(0);
                }
                ViewOnKeyListenerC2932m0.f9948C0.setItemAnimator(null);
            }
        }
        this.f9935b.f9968g0.setVisibility(8);
    }
}
