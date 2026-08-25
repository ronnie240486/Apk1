package com.google.android.gms.internal.cast;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class C1568g6 extends AbstractC1503a1 {

    public static final AtomicReferenceFieldUpdater f5319d = AtomicReferenceFieldUpdater.newUpdater(C1598j6.class, Thread.class, CmcdData.OBJECT_TYPE_AUDIO_ONLY);

    public static final AtomicReferenceFieldUpdater f5320e = AtomicReferenceFieldUpdater.newUpdater(C1598j6.class, C1598j6.class, "b");

    public static final AtomicReferenceFieldUpdater f5321f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1608k6.class, C1598j6.class, "f");

    public static final AtomicReferenceFieldUpdater f5322g = AtomicReferenceFieldUpdater.newUpdater(AbstractC1608k6.class, C1548e6.class, "e");

    public static final AtomicReferenceFieldUpdater f5323h = AtomicReferenceFieldUpdater.newUpdater(AbstractC1608k6.class, Object.class, "d");

    @Override
    public final C1548e6 mo3703d(AbstractC1558f6 abstractC1558f6) {
        return (C1548e6) f5322g.getAndSet(abstractC1558f6, C1548e6.f5282d);
    }

    @Override
    public final C1598j6 mo3704k(AbstractC1558f6 abstractC1558f6) {
        return (C1598j6) f5321f.getAndSet(abstractC1558f6, C1598j6.f5365c);
    }

    @Override
    public final void mo3705m(C1598j6 c1598j6, C1598j6 c1598j7) {
        f5320e.lazySet(c1598j6, c1598j7);
    }

    @Override
    public final void mo3706o(C1598j6 c1598j6, Thread thread) {
        f5319d.lazySet(c1598j6, thread);
    }

    @Override
    public final boolean mo3707q(AbstractC1558f6 abstractC1558f6, C1548e6 c1548e6, C1548e6 c1548e7) {
        return AbstractC1503a1.m3699j(f5322g, abstractC1558f6, c1548e6, c1548e7);
    }

    @Override
    public final boolean mo3708r(AbstractC1608k6 abstractC1608k6, Object obj, Object obj2) {
        return AbstractC1503a1.m3699j(f5323h, abstractC1608k6, obj, obj2);
    }

    @Override
    public final boolean mo3709s(AbstractC1608k6 abstractC1608k6, C1598j6 c1598j6, C1598j6 c1598j7) {
        return AbstractC1503a1.m3699j(f5321f, abstractC1608k6, c1598j6, c1598j7);
    }
}
