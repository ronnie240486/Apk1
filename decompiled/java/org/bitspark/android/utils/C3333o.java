package org.bitspark.android.utils;

import android.view.View;
import com.nmmedit.protect.NativeUtil;
import java.util.ArrayList;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import p116ka.C2909b;
import p116ka.C2924i0;
import p214ta.C3877a;

public final class C3333o {

    public static final C3333o f11249f;

    public Spark f11250a;

    public C3877a f11251b;

    public C2924i0 f11252c;

    public C2909b f11253d;

    public boolean f11254e;

    public static native int m6768b(ArrayList arrayList, String str);

    public final native C2924i0 m6769a(C2909b c2909b, View view, View view2, View view3);

    public final native void m6770c(ChannelBean channelBean, String str);

    public final native void m6771d();

    public final native void m6772e();

    public final native boolean m6773f();

    public final native void m6774g();

    static {
        NativeUtil.classesInit0(2);
        C3333o c3333o = new C3333o();
        c3333o.f11253d = null;
        c3333o.f11254e = false;
        f11249f = c3333o;
    }
}
