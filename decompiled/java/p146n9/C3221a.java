package p146n9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import p103j9.AbstractC2796i;
import p136m9.AbstractC3087a;

public final class C3221a extends AbstractC3087a {
    @Override
    public final Random mo6116a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        AbstractC2796i.m5784e(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
