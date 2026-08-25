package p125l7;

import java.io.Serializable;
import java.math.BigInteger;
import p144n7.C3210h;

public final class C3010q extends AbstractC3006m {

    public final Serializable f10304a;

    public C3010q(Boolean bool) {
        bool.getClass();
        this.f10304a = bool;
    }

    public static boolean m6086e(C3010q c3010q) {
        Serializable serializable = c3010q.f10304a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final Number m6087c() {
        Serializable serializable = this.f10304a;
        return serializable instanceof String ? new C3210h((String) serializable) : (Number) serializable;
    }

    public final String m6088d() {
        Serializable serializable = this.f10304a;
        if (serializable instanceof Number) {
            return m6087c().toString();
        }
        return serializable instanceof Boolean ? ((Boolean) serializable).toString() : (String) serializable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3010q.class != obj.getClass()) {
            return false;
        }
        C3010q c3010q = (C3010q) obj;
        Serializable serializable = this.f10304a;
        Serializable serializable2 = c3010q.f10304a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (m6086e(this) && m6086e(c3010q)) {
            return m6087c().longValue() == c3010q.m6087c().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        double dDoubleValue = m6087c().doubleValue();
        double dDoubleValue2 = c3010q.m6087c().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f10304a;
        if (serializable == null) {
            return 31;
        }
        if (m6086e(this)) {
            jDoubleToLongBits = m6087c().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(m6087c().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public C3010q(Number number) {
        number.getClass();
        this.f10304a = number;
    }

    public C3010q(String str) {
        str.getClass();
        this.f10304a = str;
    }
}
