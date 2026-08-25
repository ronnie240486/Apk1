package p192r9;

import java.io.Serializable;
import java.util.regex.Pattern;
import p103j9.AbstractC2796i;

public final class C3647e implements Serializable {

    public final Pattern f12254a;

    public C3647e(String str) {
        Pattern patternCompile = Pattern.compile(str);
        AbstractC2796i.m5784e(patternCompile, "compile(...)");
        this.f12254a = patternCompile;
    }

    public final String toString() {
        String string = this.f12254a.toString();
        AbstractC2796i.m5784e(string, "toString(...)");
        return string;
    }
}
