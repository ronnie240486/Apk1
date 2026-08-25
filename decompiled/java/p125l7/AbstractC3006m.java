package p125l7;

import java.io.IOException;
import java.io.StringWriter;
import p144n7.AbstractC3206d;
import p212t7.C3813b;

public abstract class AbstractC3006m {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C3813b c3813b = new C3813b(stringWriter);
            c3813b.f12893e = true;
            AbstractC3206d.m6495l(this, c3813b);
            return stringWriter.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }
}
