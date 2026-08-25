package p154o7;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import p125l7.AbstractC3011r;
import p125l7.C3007n;
import p144n7.AbstractC3209g;
import p168p7.AbstractC3375a;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3263d extends AbstractC3011r {

    public static final C3260a f10900b = new C3260a(1);

    public final ArrayList f10901a;

    public C3263d() {
        ArrayList arrayList = new ArrayList();
        this.f10901a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (AbstractC3209g.f10790a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        if (c3812a.m7612u() == 9) {
            c3812a.m7608q();
            return null;
        }
        String strM7610s = c3812a.m7610s();
        synchronized (this) {
            try {
                Iterator it = this.f10901a.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(strM7610s);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return AbstractC3375a.m6870b(strM7610s, new ParsePosition(0));
                } catch (ParseException e5) {
                    throw new C3007n(strM7610s, e5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) {
        Date date = (Date) obj;
        synchronized (this) {
            try {
                if (date == null) {
                    c3813b.m7626i();
                } else {
                    c3813b.m7631n(((DateFormat) this.f10901a.get(0)).format(date));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
