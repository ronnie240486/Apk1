package p190r7;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import p125l7.AbstractC3011r;
import p125l7.C3007n;
import p154o7.C3260a;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3640a extends AbstractC3011r {

    public static final C3260a f12227c = new C3260a(4);

    public static final C3260a f12228d = new C3260a(5);

    public static final C3260a f12229e = new C3260a(6);

    public final int f12230a;

    public final Object f12231b;

    public C3640a(int i6) {
        this.f12230a = i6;
        switch (i6) {
            case 1:
                this.f12231b = new SimpleDateFormat("hh:mm:ss a");
                break;
            default:
                this.f12231b = new SimpleDateFormat("MMM d, yyyy");
                break;
        }
    }

    private final Object m7370c(C3812a c3812a) {
        synchronized (this) {
            if (c3812a.m7612u() == 9) {
                c3812a.m7608q();
                return null;
            }
            try {
                return new Time(((SimpleDateFormat) this.f12231b).parse(c3812a.m7610s()).getTime());
            } catch (ParseException e5) {
                throw new C3007n(e5);
            }
        }
    }

    private final void m7371d(C3813b c3813b, Object obj) {
        Time time = (Time) obj;
        synchronized (this) {
            c3813b.m7631n(time == null ? null : ((SimpleDateFormat) this.f12231b).format((Date) time));
        }
    }

    @Override
    public final Object mo6077a(C3812a c3812a) {
        switch (this.f12230a) {
            case 0:
                synchronized (this) {
                    if (c3812a.m7612u() == 9) {
                        c3812a.m7608q();
                        return null;
                    }
                    try {
                        return new java.sql.Date(((SimpleDateFormat) this.f12231b).parse(c3812a.m7610s()).getTime());
                    } catch (ParseException e5) {
                        throw new C3007n(e5);
                    }
                }
            case 1:
                return m7370c(c3812a);
            default:
                Date date = (Date) ((AbstractC3011r) this.f12231b).mo6077a(c3812a);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) {
        switch (this.f12230a) {
            case 0:
                java.sql.Date date = (java.sql.Date) obj;
                synchronized (this) {
                    c3813b.m7631n(date == null ? null : ((SimpleDateFormat) this.f12231b).format((Date) date));
                }
                return;
            case 1:
                m7371d(c3813b, obj);
                return;
            default:
                ((AbstractC3011r) this.f12231b).mo6078b(c3813b, (Timestamp) obj);
                return;
        }
    }

    public C3640a(AbstractC3011r abstractC3011r) {
        this.f12230a = 2;
        this.f12231b = abstractC3011r;
    }
}
