package androidx.appcompat.app;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0407i;
import androidx.fragment.app.C0434v0;
import androidx.leanback.widget.VerticalGridView;
import androidx.media3.exoplayer.hls.C0775b;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.gms.cast.CastDevice;
import com.tencent.mars.xlog.Log;
import com.youth.banner.indicator.RectangleIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p106k0.C2856d;
import p106k0.CallableC2855c;
import p116ka.C2924i0;
import p116ka.ViewOnKeyListenerC2925j;
import p143n5.AbstractC3198d;
import p165p4.BinderC3369n;
import p165p4.C3370o;
import p165p4.InterfaceC3357b;
import p187r4.C3616f;
import p230v4.C4008v;

public final class RunnableC0126c implements Runnable {

    public final int f264a;

    public Object f265b;

    public Object f266c;

    public Object f267d;

    public RunnableC0126c() {
        this.f264a = 2;
    }

    private final void m371a() {
        InterfaceC3357b interfaceC3357b;
        BinderC3369n binderC3369n = (BinderC3369n) this.f265b;
        HashMap map = binderC3369n.f11371d.f11375B;
        String str = (String) this.f266c;
        synchronized (map) {
            interfaceC3357b = (InterfaceC3357b) map.get(str);
        }
        if (interfaceC3357b == null) {
            C3370o.f11372F.m7975b("Discarded message for unknown namespace '%s'", str);
            return;
        }
        String str2 = (String) this.f267d;
        CastDevice castDevice = binderC3369n.f11371d.f11395z;
        ((C3616f) interfaceC3357b).m7312p(str2);
    }

    @Override
    public final void run() {
        Object objCall;
        InterfaceC3357b interfaceC3357b;
        boolean z7 = false;
        switch (this.f264a) {
            case 0:
                C0136h.m413b(((C0136h) this.f267d).f361e, (View) this.f265b, (View) this.f266c);
                return;
            case 1:
                ArrayList arrayList = (ArrayList) this.f265b;
                C0434v0 c0434v0 = (C0434v0) this.f266c;
                if (arrayList.contains(c0434v0)) {
                    arrayList.remove(c0434v0);
                    ((C0407i) this.f267d).getClass();
                    AbstractC0004e.m7a(c0434v0.f2007a, c0434v0.f2009c.f1951F);
                    return;
                }
                return;
            case 2:
                try {
                    objCall = ((CallableC2855c) this.f265b).call();
                    break;
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.f267d).post(new RunnableC0038c(18, (C2856d) this.f266c, objCall, z7));
                return;
            case 3:
                int width = ((RectangleIndicator) this.f266c).getWidth();
                if (width > 0) {
                    View view = (View) this.f265b;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.width = width + 24;
                    view.setLayoutParams(layoutParams);
                    ViewOnKeyListenerC2925j viewOnKeyListenerC2925j = (ViewOnKeyListenerC2925j) this.f267d;
                    if (viewOnKeyListenerC2925j.f9927V.getItemCount() > 1) {
                        view.setVisibility(0);
                    } else {
                        view.setVisibility(4);
                    }
                    String strM165s = AbstractC0032a.m165s("21N4JxPEoWL+WXs2\n", "kzwVQlW2wAU=\n");
                    String str = AbstractC0032a.m165s("tnkj0pgJm/ytNzDSnxyHqf8=\n", "3xdHu/to75M=\n") + width + AbstractC0032a.m165s("/h6vV1jcFA==\n", "wyOSamXhKbE=\n") + viewOnKeyListenerC2925j.f9927V.getItemCount();
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, str);
                    return;
                }
                return;
            case 4:
                int width2 = ((View) this.f265b).getWidth();
                C2924i0 c2924i0 = (C2924i0) this.f267d;
                float fM6469q = width2 / AbstractC3198d.m6469q(c2924i0.m1319h(), 84);
                if (fM6469q >= 7.0f) {
                    c2924i0.f9916Y = 7;
                } else {
                    c2924i0.f9916Y = (int) fM6469q;
                }
                if (c2924i0.f9916Y != 0) {
                    if (c2924i0.f9912U.m7738h()) {
                        c2924i0.f9923g0.setLayoutManager(new GridLayoutManager(c2924i0.f9916Y));
                    } else {
                        ((VerticalGridView) c2924i0.f9923g0).setNumColumns(c2924i0.f9916Y);
                    }
                }
                C0775b c0775b = (C0775b) this.f266c;
                String str2 = C2924i0.f9911i0;
                ((C2924i0) c0775b.f2858c).m5917S((ChannelBean) c0775b.f2857b, (String) c0775b.f2859d);
                return;
            case 5:
                m371a();
                return;
            default:
                C4008v c4008v = (C4008v) this.f265b;
                synchronized (c4008v.f13578C) {
                    interfaceC3357b = (InterfaceC3357b) c4008v.f13578C.get((String) this.f266c);
                    break;
                }
                if (interfaceC3357b != null) {
                    ((C3616f) interfaceC3357b).m7312p((String) this.f267d);
                    return;
                } else {
                    C4008v.f13573S.m7975b("Discarded message for unknown namespace '%s'", (String) this.f266c);
                    return;
                }
        }
    }

    public RunnableC0126c(Object obj, Object obj2, Object obj3, int i6) {
        this.f264a = i6;
        this.f267d = obj;
        this.f265b = obj2;
        this.f266c = obj3;
    }

    public RunnableC0126c(Object obj, String str, String str2, int i6) {
        this.f264a = i6;
        this.f265b = obj;
        this.f266c = str;
        this.f267d = str2;
    }

    public RunnableC0126c(ViewOnKeyListenerC2925j viewOnKeyListenerC2925j, RectangleIndicator rectangleIndicator, View view) {
        this.f264a = 3;
        this.f267d = viewOnKeyListenerC2925j;
        this.f266c = rectangleIndicator;
        this.f265b = view;
    }
}
