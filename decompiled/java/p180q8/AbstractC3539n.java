package p180q8;

import com.bumptech.glide.AbstractC1466d;

public abstract class AbstractC3539n {

    public static final boolean f11936a;

    static {
        boolean zEquals = true;
        try {
            String property = System.getProperty("rx3.purge-enabled");
            if (property != null) {
                zEquals = "true".equals(property);
            }
        } catch (Throwable th) {
            AbstractC1466d.m3484G(th);
        }
        f11936a = zEquals;
    }
}
