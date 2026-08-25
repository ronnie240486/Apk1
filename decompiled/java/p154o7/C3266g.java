package p154o7;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import p055ea.AbstractC2460q;
import p125l7.AbstractC3006m;
import p125l7.AbstractC3011r;
import p125l7.C3005l;
import p125l7.C3007n;
import p125l7.C3008o;
import p125l7.C3009p;
import p125l7.C3010q;
import p144n7.C3210h;
import p144n7.C3211i;
import p144n7.C3212j;
import p144n7.C3213k;
import p212t7.C3812a;
import p212t7.C3813b;
import p215u.AbstractC3885h;

public final class C3266g extends AbstractC3011r {

    public static final C3265f f10908b = new C3265f(new C3266g(0), 0);

    public final int f10909a;

    public C3266g(int i6) {
        this.f10909a = i6;
    }

    public static AbstractC3006m m6560c(C3812a c3812a) throws IOException {
        int iM7785a = AbstractC3885h.m7785a(c3812a.m7612u());
        if (iM7785a == 0) {
            C3005l c3005l = new C3005l();
            c3812a.m7592a();
            while (c3812a.m7599h()) {
                c3005l.f10301a.add(m6560c(c3812a));
            }
            c3812a.m7596e();
            return c3005l;
        }
        if (iM7785a == 2) {
            C3009p c3009p = new C3009p();
            c3812a.m7593b();
            while (c3812a.m7599h()) {
                c3009p.f10303a.put(c3812a.m7606o(), m6560c(c3812a));
            }
            c3812a.m7597f();
            return c3009p;
        }
        if (iM7785a == 5) {
            return new C3010q(c3812a.m7610s());
        }
        if (iM7785a == 6) {
            return new C3010q(new C3210h(c3812a.m7610s()));
        }
        if (iM7785a == 7) {
            return new C3010q(Boolean.valueOf(c3812a.m7602k()));
        }
        if (iM7785a != 8) {
            throw new IllegalArgumentException();
        }
        c3812a.m7608q();
        return C3008o.f10302a;
    }

    public static void m6561d(AbstractC3006m abstractC3006m, C3813b c3813b) throws IOException {
        if (abstractC3006m == null || (abstractC3006m instanceof C3008o)) {
            c3813b.m7626i();
            return;
        }
        boolean z7 = abstractC3006m instanceof C3010q;
        if (z7) {
            if (!z7) {
                throw new IllegalStateException("Not a JSON Primitive: " + abstractC3006m);
            }
            C3010q c3010q = (C3010q) abstractC3006m;
            Serializable serializable = c3010q.f10304a;
            if (serializable instanceof Number) {
                c3813b.m7630m(c3010q.m6087c());
                return;
            } else if (serializable instanceof Boolean) {
                c3813b.m7632o(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(c3010q.m6088d()));
                return;
            } else {
                c3813b.m7631n(c3010q.m6088d());
                return;
            }
        }
        boolean z10 = abstractC3006m instanceof C3005l;
        if (z10) {
            c3813b.m7619b();
            if (!z10) {
                throw new IllegalStateException("Not a JSON Array: " + abstractC3006m);
            }
            Iterator it = ((C3005l) abstractC3006m).f10301a.iterator();
            while (it.hasNext()) {
                m6561d((AbstractC3006m) it.next(), c3813b);
            }
            c3813b.m7622e();
            return;
        }
        boolean z11 = abstractC3006m instanceof C3009p;
        if (!z11) {
            throw new IllegalArgumentException("Couldn't write " + abstractC3006m.getClass());
        }
        c3813b.m7620c();
        if (!z11) {
            throw new IllegalStateException("Not a JSON Object: " + abstractC3006m);
        }
        Iterator it2 = ((C3212j) ((C3009p) abstractC3006m).f10303a.entrySet()).iterator();
        while (((C3211i) it2).hasNext()) {
            C3213k c3213kM6500b = ((C3211i) it2).m6500b();
            c3813b.m7624g((String) c3213kM6500b.getKey());
            m6561d((AbstractC3006m) c3213kM6500b.getValue(), c3813b);
        }
        c3813b.m7623f();
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        boolean zM7602k;
        switch (this.f10909a) {
            case 0:
                int iM7612u = c3812a.m7612u();
                int iM7785a = AbstractC3885h.m7785a(iM7612u);
                if (iM7785a == 5 || iM7785a == 6) {
                    return new C3210h(c3812a.m7610s());
                }
                if (iM7785a != 8) {
                    throw new C3007n("Expecting number, got: ".concat(AbstractC2460q.m5503q(iM7612u)));
                }
                c3812a.m7608q();
                return null;
            case 1:
                ArrayList arrayList = new ArrayList();
                c3812a.m7592a();
                while (c3812a.m7599h()) {
                    try {
                        arrayList.add(Integer.valueOf(c3812a.m7604m()));
                    } catch (NumberFormatException e5) {
                        throw new C3007n(e5);
                    }
                }
                c3812a.m7596e();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i6 = 0; i6 < size; i6++) {
                    atomicIntegerArray.set(i6, ((Integer) arrayList.get(i6)).intValue());
                }
                return atomicIntegerArray;
            case 2:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    return Long.valueOf(c3812a.m7605n());
                } catch (NumberFormatException e10) {
                    throw new C3007n(e10);
                }
            case 3:
                if (c3812a.m7612u() != 9) {
                    return Float.valueOf((float) c3812a.m7603l());
                }
                c3812a.m7608q();
                return null;
            case 4:
                if (c3812a.m7612u() != 9) {
                    return Double.valueOf(c3812a.m7603l());
                }
                c3812a.m7608q();
                return null;
            case 5:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                String strM7610s = c3812a.m7610s();
                if (strM7610s.length() == 1) {
                    return Character.valueOf(strM7610s.charAt(0));
                }
                throw new C3007n("Expecting character, got: ".concat(strM7610s));
            case 6:
                int iM7612u2 = c3812a.m7612u();
                if (iM7612u2 != 9) {
                    return iM7612u2 == 8 ? Boolean.toString(c3812a.m7602k()) : c3812a.m7610s();
                }
                c3812a.m7608q();
                return null;
            case 7:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    return new BigDecimal(c3812a.m7610s());
                } catch (NumberFormatException e11) {
                    throw new C3007n(e11);
                }
            case 8:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    return new BigInteger(c3812a.m7610s());
                } catch (NumberFormatException e12) {
                    throw new C3007n(e12);
                }
            case 9:
                if (c3812a.m7612u() != 9) {
                    return new StringBuilder(c3812a.m7610s());
                }
                c3812a.m7608q();
                return null;
            case 10:
                if (c3812a.m7612u() != 9) {
                    return new StringBuffer(c3812a.m7610s());
                }
                c3812a.m7608q();
                return null;
            case 11:
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            case 12:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                String strM7610s2 = c3812a.m7610s();
                if ("null".equals(strM7610s2)) {
                    return null;
                }
                return new URL(strM7610s2);
            case 13:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    String strM7610s3 = c3812a.m7610s();
                    if ("null".equals(strM7610s3)) {
                        return null;
                    }
                    return new URI(strM7610s3);
                } catch (URISyntaxException e13) {
                    throw new C3007n(e13);
                }
            case 14:
                if (c3812a.m7612u() != 9) {
                    return InetAddress.getByName(c3812a.m7610s());
                }
                c3812a.m7608q();
                return null;
            case 15:
                if (c3812a.m7612u() != 9) {
                    return UUID.fromString(c3812a.m7610s());
                }
                c3812a.m7608q();
                return null;
            case 16:
                return Currency.getInstance(c3812a.m7610s());
            case 17:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                c3812a.m7593b();
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (c3812a.m7612u() != 4) {
                    String strM7606o = c3812a.m7606o();
                    int iM7604m = c3812a.m7604m();
                    if ("year".equals(strM7606o)) {
                        i10 = iM7604m;
                    } else if ("month".equals(strM7606o)) {
                        i11 = iM7604m;
                    } else if ("dayOfMonth".equals(strM7606o)) {
                        i12 = iM7604m;
                    } else if ("hourOfDay".equals(strM7606o)) {
                        i13 = iM7604m;
                    } else if ("minute".equals(strM7606o)) {
                        i14 = iM7604m;
                    } else if ("second".equals(strM7606o)) {
                        i15 = iM7604m;
                    }
                }
                c3812a.m7597f();
                return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
            case 18:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(c3812a.m7610s(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (strNextToken2 == null && strNextToken3 == null) {
                    return new Locale(strNextToken);
                }
                return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            case 19:
                return m6560c(c3812a);
            case 20:
                BitSet bitSet = new BitSet();
                c3812a.m7592a();
                int iM7612u3 = c3812a.m7612u();
                int i16 = 0;
                while (iM7612u3 != 2) {
                    int iM7785a2 = AbstractC3885h.m7785a(iM7612u3);
                    boolean z7 = true;
                    if (iM7785a2 == 5) {
                        String strM7610s4 = c3812a.m7610s();
                        try {
                            if (Integer.parseInt(strM7610s4) == 0) {
                                z7 = false;
                            }
                            zM7602k = z7;
                        } catch (NumberFormatException unused) {
                            throw new C3007n(AbstractC2460q.m5501o("Error: Expecting: bitset number value (1, 0), Found: ", strM7610s4));
                        }
                    } else if (iM7785a2 == 6) {
                        if (c3812a.m7604m() == 0) {
                            z7 = false;
                        }
                        zM7602k = z7;
                    } else {
                        if (iM7785a2 != 7) {
                            throw new C3007n("Invalid bitset value type: ".concat(AbstractC2460q.m5503q(iM7612u3)));
                        }
                        zM7602k = c3812a.m7602k();
                    }
                    if (zM7602k) {
                        bitSet.set(i16);
                    }
                    i16++;
                    iM7612u3 = c3812a.m7612u();
                }
                c3812a.m7596e();
                return bitSet;
            case 21:
                int iM7612u4 = c3812a.m7612u();
                if (iM7612u4 != 9) {
                    return iM7612u4 == 6 ? Boolean.valueOf(Boolean.parseBoolean(c3812a.m7610s())) : Boolean.valueOf(c3812a.m7602k());
                }
                c3812a.m7608q();
                return null;
            case 22:
                if (c3812a.m7612u() != 9) {
                    return Boolean.valueOf(c3812a.m7610s());
                }
                c3812a.m7608q();
                return null;
            case 23:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) c3812a.m7604m());
                } catch (NumberFormatException e14) {
                    throw new C3007n(e14);
                }
            case 24:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    return Short.valueOf((short) c3812a.m7604m());
                } catch (NumberFormatException e15) {
                    throw new C3007n(e15);
                }
            case 25:
                if (c3812a.m7612u() == 9) {
                    c3812a.m7608q();
                    return null;
                }
                try {
                    return Integer.valueOf(c3812a.m7604m());
                } catch (NumberFormatException e16) {
                    throw new C3007n(e16);
                }
            case 26:
                try {
                    return new AtomicInteger(c3812a.m7604m());
                } catch (NumberFormatException e17) {
                    throw new C3007n(e17);
                }
            default:
                return new AtomicBoolean(c3812a.m7602k());
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        switch (this.f10909a) {
            case 0:
                c3813b.m7630m((Number) obj);
                return;
            case 1:
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                c3813b.m7619b();
                int length = atomicIntegerArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    c3813b.m7629l(atomicIntegerArray.get(i6));
                }
                c3813b.m7622e();
                return;
            case 2:
                c3813b.m7630m((Number) obj);
                return;
            case 3:
                c3813b.m7630m((Number) obj);
                return;
            case 4:
                c3813b.m7630m((Number) obj);
                return;
            case 5:
                Character ch = (Character) obj;
                c3813b.m7631n(ch == null ? null : String.valueOf(ch));
                return;
            case 6:
                c3813b.m7631n((String) obj);
                return;
            case 7:
                c3813b.m7630m((BigDecimal) obj);
                return;
            case 8:
                c3813b.m7630m((BigInteger) obj);
                return;
            case 9:
                StringBuilder sb = (StringBuilder) obj;
                c3813b.m7631n(sb == null ? null : sb.toString());
                return;
            case 10:
                StringBuffer stringBuffer = (StringBuffer) obj;
                c3813b.m7631n(stringBuffer == null ? null : stringBuffer.toString());
                return;
            case 11:
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            case 12:
                URL url = (URL) obj;
                c3813b.m7631n(url == null ? null : url.toExternalForm());
                return;
            case 13:
                URI uri = (URI) obj;
                c3813b.m7631n(uri == null ? null : uri.toASCIIString());
                return;
            case 14:
                InetAddress inetAddress = (InetAddress) obj;
                c3813b.m7631n(inetAddress == null ? null : inetAddress.getHostAddress());
                return;
            case 15:
                UUID uuid = (UUID) obj;
                c3813b.m7631n(uuid == null ? null : uuid.toString());
                return;
            case 16:
                c3813b.m7631n(((Currency) obj).getCurrencyCode());
                return;
            case 17:
                Calendar calendar = (Calendar) obj;
                if (calendar == null) {
                    c3813b.m7626i();
                    return;
                }
                c3813b.m7620c();
                c3813b.m7624g("year");
                c3813b.m7629l(calendar.get(1));
                c3813b.m7624g("month");
                c3813b.m7629l(calendar.get(2));
                c3813b.m7624g("dayOfMonth");
                c3813b.m7629l(calendar.get(5));
                c3813b.m7624g("hourOfDay");
                c3813b.m7629l(calendar.get(11));
                c3813b.m7624g("minute");
                c3813b.m7629l(calendar.get(12));
                c3813b.m7624g("second");
                c3813b.m7629l(calendar.get(13));
                c3813b.m7623f();
                return;
            case 18:
                Locale locale = (Locale) obj;
                c3813b.m7631n(locale == null ? null : locale.toString());
                return;
            case 19:
                m6561d((AbstractC3006m) obj, c3813b);
                return;
            case 20:
                BitSet bitSet = (BitSet) obj;
                c3813b.m7619b();
                int length2 = bitSet.length();
                for (int i10 = 0; i10 < length2; i10++) {
                    c3813b.m7629l(bitSet.get(i10) ? 1L : 0L);
                }
                c3813b.m7622e();
                return;
            case 21:
                Boolean bool = (Boolean) obj;
                if (bool == null) {
                    c3813b.m7626i();
                    return;
                }
                c3813b.m7633p();
                c3813b.m7618a();
                c3813b.f12889a.write(bool.booleanValue() ? "true" : "false");
                return;
            case 22:
                Boolean bool2 = (Boolean) obj;
                c3813b.m7631n(bool2 == null ? "null" : bool2.toString());
                return;
            case 23:
                c3813b.m7630m((Number) obj);
                return;
            case 24:
                c3813b.m7630m((Number) obj);
                return;
            case 25:
                c3813b.m7630m((Number) obj);
                return;
            case 26:
                c3813b.m7629l(((AtomicInteger) obj).get());
                return;
            default:
                c3813b.m7632o(((AtomicBoolean) obj).get());
                return;
        }
    }
}
