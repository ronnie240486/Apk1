package p138n0;

import android.view.ContentInfo;
import android.view.View;
import androidx.media3.exoplayer.analytics.AbstractC0685b0;
import java.util.Objects;
import p101j7.C2782c;

public abstract class AbstractC3143o0 {
    public static String[] m6288a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static C3118g m6289b(View view, C3118g c3118g) {
        ContentInfo contentInfoMo5755i = c3118g.f10600a.mo5755i();
        Objects.requireNonNull(contentInfoMo5755i);
        ContentInfo contentInfoM2097m = AbstractC0685b0.m2097m(contentInfoMo5755i);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoM2097m);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoM2097m ? c3118g : new C3118g(new C2782c(contentInfoPerformReceiveContent));
    }

    public static void m6290c(View view, String[] strArr, InterfaceC3157t interfaceC3157t) {
        if (interfaceC3157t == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerC3146p0(interfaceC3157t));
        }
    }
}
