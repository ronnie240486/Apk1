package p192r9;

import java.nio.charset.Charset;
import p103j9.AbstractC2796i;

public abstract class AbstractC3643a {

    public static final Charset f12236a;

    public static volatile Charset f12237b;

    public static volatile Charset f12238c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        AbstractC2796i.m5784e(charsetForName, "forName(...)");
        f12236a = charsetForName;
        AbstractC2796i.m5784e(Charset.forName("UTF-16"), "forName(...)");
        AbstractC2796i.m5784e(Charset.forName("UTF-16BE"), "forName(...)");
        AbstractC2796i.m5784e(Charset.forName("UTF-16LE"), "forName(...)");
        AbstractC2796i.m5784e(Charset.forName("US-ASCII"), "forName(...)");
        AbstractC2796i.m5784e(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
