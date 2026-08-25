package qa;

import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.SubtitleMenu;
import p008a9.InterfaceC0074d;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p156o9.AbstractC3280d;
import p193ra.C3663f;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C3557e extends AbstractC1439i implements InterfaceC2728p {

    public final ChannelBean f11967b;

    public final SubtitleMenu f11968c;

    public C3557e(ChannelBean channelBean, SubtitleMenu subtitleMenu, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f11967b = channelBean;
        this.f11968c = subtitleMenu;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C3557e(this.f11967b, this.f11968c, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        C3557e c3557e = (C3557e) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2);
        C4070l c4070l = C4070l.f13734a;
        c3557e.invokeSuspend(c4070l);
        return c4070l;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        AbstractC3280d.m6570I(obj);
        C3663f c3663fM7415b = C3663f.m7415b();
        int chid = this.f11967b.getChid();
        c3663fM7415b.f12271d.put(String.valueOf(chid), this.f11968c.getLanguage());
        return C4070l.f13734a;
    }
}
