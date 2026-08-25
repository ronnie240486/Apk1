package p101j7;

import java.util.Map;
import p080h7.C2664b;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2898e;

public final class C2780a implements InterfaceC2666d {

    public final int f9498a;

    @Override
    public final void mo192a(Object obj, Object obj2) {
        switch (this.f9498a) {
            case 0:
                throw new C2664b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
                interfaceC2667e.mo5672d(C2898e.f9841g, entry.getKey());
                interfaceC2667e.mo5672d(C2898e.f9842h, entry.getValue());
                return;
            default:
                throw new C2664b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
