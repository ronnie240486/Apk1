package p080h7;

import java.util.Collections;
import java.util.Map;

public final class C2665c {

    public final String f9295a;

    public final Map f9296b;

    public C2665c(String str, Map map) {
        this.f9295a = str;
        this.f9296b = map;
    }

    public static C2665c m5670a(String str) {
        return new C2665c(str, Collections.emptyMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2665c)) {
            return false;
        }
        C2665c c2665c = (C2665c) obj;
        return this.f9295a.equals(c2665c.f9295a) && this.f9296b.equals(c2665c.f9296b);
    }

    public final int hashCode() {
        return this.f9296b.hashCode() + (this.f9295a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f9295a + ", properties=" + this.f9296b.values() + "}";
    }
}
