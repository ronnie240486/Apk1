package p144n7;

import java.math.BigDecimal;

public final class C3210h extends Number {

    public final String f10791a;

    public C3210h(String str) {
        this.f10791a = str;
    }

    @Override
    public final double doubleValue() {
        return Double.parseDouble(this.f10791a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3210h)) {
            return false;
        }
        Object obj2 = ((C3210h) obj).f10791a;
        String str = this.f10791a;
        return str == obj2 || str.equals(obj2);
    }

    @Override
    public final float floatValue() {
        return Float.parseFloat(this.f10791a);
    }

    public final int hashCode() {
        return this.f10791a.hashCode();
    }

    @Override
    public final int intValue() {
        String str = this.f10791a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(str).intValue();
        }
    }

    @Override
    public final long longValue() {
        String str = this.f10791a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f10791a;
    }
}
