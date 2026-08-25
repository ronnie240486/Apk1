package p180q8;

import p090i8.AbstractC2711e;
import p090i8.AbstractC2712f;

public final class C3534i extends AbstractC2712f {

    public static final ThreadFactoryC3536k f11919b = new ThreadFactoryC3536k("RxNewThreadScheduler", false, Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    public final ThreadFactoryC3536k f11920a = f11919b;

    @Override
    public final AbstractC2711e mo5677a() {
        return new C3535j(this.f11920a);
    }
}
