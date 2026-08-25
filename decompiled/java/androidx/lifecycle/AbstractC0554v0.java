package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

public abstract class AbstractC0554v0 {

    public final HashMap f2540a = new HashMap();

    public final LinkedHashSet f2541b = new LinkedHashSet();

    public volatile boolean f2542c = false;

    public static void m1516a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    public void mo1267b() {
    }
}
