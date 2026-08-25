package p191r8;

import com.google.android.gms.internal.cast.C1528c6;

public abstract class AbstractC3642a {
    static {
        new C1528c6("No further exceptions", 1);
    }

    public static NullPointerException m7372a(String str) {
        return new NullPointerException(str.concat(" Null values are generally not allowed in 3.x operators and sources."));
    }

    public static RuntimeException m7373b(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }
}
