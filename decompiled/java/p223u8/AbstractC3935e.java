package p223u8;

import java.util.Objects;
import p180q8.AbstractC3542q;
import p180q8.C3533h;
import p191r8.AbstractC3642a;

public abstract class AbstractC3935e {

    public static final C3533h f13233a;

    static {
        try {
            Objects.requireNonNull(AbstractC3934d.f13232a, "Scheduler Supplier result can't be null");
            try {
                Objects.requireNonNull(AbstractC3931a.f13229a, "Scheduler Supplier result can't be null");
                try {
                    C3533h c3533h = AbstractC3932b.f13230a;
                    Objects.requireNonNull(c3533h, "Scheduler Supplier result can't be null");
                    f13233a = c3533h;
                    int i6 = AbstractC3542q.f11943a;
                    try {
                        Objects.requireNonNull(AbstractC3933c.f13231a, "Scheduler Supplier result can't be null");
                    } catch (Throwable th) {
                        throw AbstractC3642a.m7373b(th);
                    }
                } catch (Throwable th2) {
                    throw AbstractC3642a.m7373b(th2);
                }
            } catch (Throwable th3) {
                throw AbstractC3642a.m7373b(th3);
            }
        } catch (Throwable th4) {
            throw AbstractC3642a.m7373b(th4);
        }
    }
}
