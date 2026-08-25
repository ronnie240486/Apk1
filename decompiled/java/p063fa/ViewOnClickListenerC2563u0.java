package p063fa;

import android.view.View;
import androidx.media3.common.C0628x;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.tencent.mars.xlog.Log;
import ga.C2630m;
import ga.EnumC2629l;
import java.util.HashMap;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.C2428a;
import p055ea.EnumC2434d;
import p116ka.C2930l0;
import p116ka.ViewOnKeyListenerC2932m0;

public final class ViewOnClickListenerC2563u0 implements View.OnClickListener {

    public final int f8917a;

    public final C2567w0 f8918b;

    public final ChannelBean f8919c;

    public final C2569x0 f8920d;

    public ViewOnClickListenerC2563u0(C2569x0 c2569x0, int i6, C2567w0 c2567w0, ChannelBean channelBean) {
        this.f8920d = c2569x0;
        this.f8917a = i6;
        this.f8918b = c2567w0;
        this.f8919c = channelBean;
    }

    @Override
    public final void onClick(View view) {
        C2569x0 c2569x0 = this.f8920d;
        int i6 = c2569x0.f8875b;
        int i10 = this.f8917a;
        c2569x0.f8875b = i10;
        c2569x0.notifyItemChanged(i6);
        c2569x0.notifyItemChanged(i10);
        ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8533e;
        ViewOnKeyListenerC2932m0.f9954I0 = this.f8918b.itemView;
        InterfaceC2549o0 interfaceC2549o0 = c2569x0.f8938p;
        if (interfaceC2549o0 != null) {
            interfaceC2549o0.mo5482a(i10, view);
            C0628x c0628x = c2569x0.f8940r;
            if (c0628x != null) {
                ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = (ViewOnKeyListenerC2932m0) c0628x.f2661b;
                viewOnKeyListenerC2932m0.f9983v0.f13009v = true;
                ChannelBean channelBean = this.f8919c;
                String strValueOf = String.valueOf(channelBean.getChid());
                HashMap map = viewOnKeyListenerC2932m0.f9987z0;
                boolean zContainsKey = map.containsKey(strValueOf);
                String str = ViewOnKeyListenerC2932m0.f9947B0;
                if (zContainsKey) {
                    viewOnKeyListenerC2932m0.f9983v0.f13009v = Boolean.TRUE.equals(map.get(strValueOf));
                    String strM165s = AbstractC0032a.m165s("+NtxA5VUdvLi324YlUtA1OvQOlYVkLBWMTHo2UfBszNiAYc=\n", "ir4AdvAnArE=\n");
                    boolean z7 = AbstractC3331m.f11244b;
                    Log.m5049i(str, strM165s);
                    return;
                }
                String strM5648e = C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9137h) + AbstractC0032a.m165s("nL8=\n", "s/9wDu8dJV8=\n") + channelBean.getChid());
                try {
                    OkGo.getInstance().cancelTag(viewOnKeyListenerC2932m0);
                    ((GetRequest) ((GetRequest) ((GetRequest) ((GetRequest) OkGo.get(strM5648e).removeHeader(AbstractC0032a.m165s("gT58gKa6Z+m6OQ==\n", "1E0Z8ov7AIw=\n"))).headers(AbstractC0032a.m165s("C1fY+u4kA58wUA==\n", "XiS9iMNlZPo=\n"), C2428a.f8504m)).tag(viewOnKeyListenerC2932m0)).cacheMode(CacheMode.NO_CACHE)).execute(new C2930l0(viewOnKeyListenerC2932m0, strValueOf, channelBean, i10));
                } catch (Exception unused) {
                    String strM165s2 = AbstractC0032a.m165s("JU/oVZMOzn0qS/IbgA2KXzJDvBCXE8VMYw==\n", "QiqcdeVhqj4=\n");
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(str, strM165s2);
                }
            }
        }
    }
}
