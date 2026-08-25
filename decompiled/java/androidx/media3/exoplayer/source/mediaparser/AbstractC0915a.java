package androidx.media3.exoplayer.source.mediaparser;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public abstract class AbstractC0915a {
    public static boolean m2494A(Object obj) {
        return obj instanceof OptionalLong;
    }

    public static Class m2495B() {
        return OptionalDouble.class;
    }

    public static boolean m2496C(Object obj) {
        return obj instanceof OptionalDouble;
    }

    public static boolean m2497D(Object obj) {
        return obj instanceof OptionalInt;
    }

    public static Class m2502e() {
        return OptionalInt.class;
    }

    public static Optional m2505h(Object obj) {
        return (Optional) obj;
    }

    public static OptionalDouble m2506i(Object obj) {
        return (OptionalDouble) obj;
    }

    public static OptionalInt m2509l(Object obj) {
        return (OptionalInt) obj;
    }

    public static OptionalLong m2512o(Object obj) {
        return (OptionalLong) obj;
    }

    public static boolean m2514q(Object obj) {
        return obj instanceof Optional;
    }

    public static Class m2521x() {
        return OptionalLong.class;
    }
}
