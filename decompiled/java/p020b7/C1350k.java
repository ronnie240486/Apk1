package p020b7;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class C1350k {

    public final String f4167a;

    public C1350k(String str) {
        str.getClass();
        this.f4167a = str;
    }

    public final void m3240a(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f4167a);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    public final String m3241b(List list) {
        Iterator it = list.iterator();
        StringBuilder sb = new StringBuilder();
        m3240a(sb, it);
        return sb.toString();
    }
}
