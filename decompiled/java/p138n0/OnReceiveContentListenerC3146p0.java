package p138n0;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import androidx.core.widget.C0385r;
import androidx.media3.exoplayer.analytics.AbstractC0685b0;
import java.util.Objects;
import p101j7.C2782c;

public final class OnReceiveContentListenerC3146p0 implements OnReceiveContentListener {

    public final InterfaceC3157t f10633a;

    public OnReceiveContentListenerC3146p0(InterfaceC3157t interfaceC3157t) {
        this.f10633a = interfaceC3157t;
    }

    @Override
    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        C3118g c3118g = new C3118g(new C2782c(contentInfo));
        C3118g c3118gM1157a = ((C0385r) this.f10633a).m1157a(view, c3118g);
        if (c3118gM1157a == null) {
            return null;
        }
        if (c3118gM1157a == c3118g) {
            return contentInfo;
        }
        ContentInfo contentInfoMo5755i = c3118gM1157a.f10600a.mo5755i();
        Objects.requireNonNull(contentInfoMo5755i);
        return AbstractC0685b0.m2097m(contentInfoMo5755i);
    }
}
