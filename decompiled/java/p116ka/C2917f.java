package p116ka;

import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.C0628x;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.C1474l;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.bitspark.android.beans.EventBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p081h8.AbstractC2671b;
import p090i8.AbstractC2712f;
import p135m8.EnumC3085a;
import p151o3.C3252f;
import p155o8.C3276a;
import p169p8.C3378c;
import p169p8.C3380e;
import p169p8.C3382g;
import p180q8.C3533h;
import p223u8.AbstractC3935e;
import p247x2.C4089k;

public final class C2917f extends StringCallback {

    public final int f9896a;

    public final ViewOnKeyListenerC2925j f9897b;

    public C2917f(ViewOnKeyListenerC2925j viewOnKeyListenerC2925j, int i6) {
        this.f9896a = i6;
        this.f9897b = viewOnKeyListenerC2925j;
    }

    @Override
    public void onCacheSuccess(Response response) {
        switch (this.f9896a) {
            case 1:
                String strM165s = AbstractC0032a.m165s("ii29wBgGa72vJ77R\n", "wkLQpV50Cto=\n");
                String strM165s2 = AbstractC0032a.m165s("pNymE9gmhyur2LxdyyXDDrHWvxPNKIAAppm9WA==\n", "w7nSM65J42g=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, strM165s2);
                break;
            default:
                super.onCacheSuccess(response);
                break;
        }
    }

    @Override
    public final void onError(Response response) {
        int i6 = this.f9896a;
    }

    @Override
    public final void onSuccess(Response response) {
        List<EventBean> array;
        switch (this.f9896a) {
            case 0:
                String strM165s = AbstractC0032a.m165s("qzDD/+4yUmaOOsDu\n", "41+umqhAMwE=\n");
                String str = AbstractC0032a.m165s("08bN6CC1hSnbxsv4aJWLI8yZmQ==\n", "taO5i0j35Ec=\n") + ((String) response.body());
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                try {
                    array = JSON.parseArray((String) response.body(), EventBean.class);
                    break;
                } catch (Exception e5) {
                    Log.m5049i(AbstractC0032a.m165s("agLD0thdoUZPCMDD\n", "Im2ut54vwCE=\n"), e5.toString());
                    array = null;
                }
                if (array == null || array.isEmpty()) {
                    return;
                }
                Log.m5049i(AbstractC0032a.m165s("PHs2qwvspHkZcTW6\n", "dBRbzk2exR4=\n"), AbstractC0032a.m165s("hR8sii5Fgd2NHyqaZmuJwJdAeA==\n", "43pY6UYH4LM=\n") + array);
                ViewOnKeyListenerC2925j viewOnKeyListenerC2925j = this.f9897b;
                viewOnKeyListenerC2925j.getClass();
                if (array.isEmpty()) {
                    return;
                }
                AtomicInteger atomicInteger = new AtomicInteger(0);
                int size = array.size();
                ArrayList arrayList = new ArrayList(size);
                AbstractC0032a.m165s("1J1VpytSMMXIg3mmJVQx9/CHVaUXWzvz5o5epSFBdNfwrmKfZB55qYnP\n", "pO8wy0QzVIQ=\n");
                for (EventBean eventBean : array) {
                    FragmentActivity fragmentActivityM1319h = viewOnKeyListenerC2925j.m1319h();
                    C1474l c1474lM3539w = ((C1474l) ComponentCallbacks2C1464b.m3462b(fragmentActivityM1319h).m5865c(fragmentActivityM1319h).m3572o(eventBean.image).m6383d(C4089k.f13830c)).m3539w(new C2921h(viewOnKeyListenerC2925j, atomicInteger, size, arrayList, eventBean));
                    c1474lM3539w.getClass();
                    c1474lM3539w.m3534B(new C3252f(c1474lM3539w.f4464u), c1474lM3539w);
                }
                return;
            default:
                C3378c c3378c = new C3378c(new C0628x(15, (String) response.body()));
                ViewOnKeyListenerC2925j viewOnKeyListenerC2925j2 = this.f9897b;
                C3276a c3276a = viewOnKeyListenerC2925j2.f9933c0;
                if (c3276a != null && !c3276a.m6563g()) {
                    C3276a c3276a2 = viewOnKeyListenerC2925j2.f9933c0;
                    c3276a2.getClass();
                    EnumC3085a.m6113b(c3276a2);
                }
                C3533h c3533h = AbstractC3935e.f13233a;
                Objects.requireNonNull(c3533h, "scheduler is null");
                C3382g c3382g = new C3382g(c3378c, c3533h);
                AbstractC2712f abstractC2712f = AbstractC2671b.f9298a;
                if (abstractC2712f == null) {
                    throw new NullPointerException("scheduler == null");
                }
                C3380e c3380eM6610v = c3382g.m6610v(abstractC2712f);
                C3276a c3276a3 = new C3276a(new C0628x(16, this));
                c3380eM6610v.m6608F(c3276a3);
                viewOnKeyListenerC2925j2.f9933c0 = c3276a3;
                return;
        }
    }

    private final void m5911a(Response response) {
    }

    private final void m5912b(Response response) {
    }
}
