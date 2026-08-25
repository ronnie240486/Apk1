package p101j7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p080h7.InterfaceC2668f;
import p080h7.InterfaceC2669g;

public final class C2783d implements InterfaceC2668f {

    public static final SimpleDateFormat f9502a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        f9502a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        ((InterfaceC2669g) obj2).mo5673b(f9502a.format((Date) obj));
    }
}
