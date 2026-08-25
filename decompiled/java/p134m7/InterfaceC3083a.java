package p134m7;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC3083a {
    boolean nullSafe() default true;

    Class value();
}
