package p254x9;

import androidx.media3.common.C0565C;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p009aa.C0087g;
import p213t9.InterfaceC3820b1;

public abstract class AbstractC4177s extends AbstractC4161c implements InterfaceC3820b1 {

    public static final AtomicIntegerFieldUpdater f14115d = AtomicIntegerFieldUpdater.newUpdater(AbstractC4177s.class, "cleanedAndPointers");

    public final long f14116c;
    private volatile int cleanedAndPointers;

    public AbstractC4177s(long j10, C0087g c0087g, int i6) {
        super(c0087g);
        this.f14116c = j10;
        this.cleanedAndPointers = i6 << 16;
    }

    @Override
    public final boolean mo8211a() {
        if (f14115d.get(this) == mo256d()) {
            Object obj = AbstractC4161c.f14084a.get(this);
            if ((obj == AbstractC4159a.f14078b ? null : (AbstractC4161c) obj) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean m8230c() {
        if (f14115d.addAndGet(this, -65536) == mo256d()) {
            Object obj = AbstractC4161c.f14084a.get(this);
            if ((obj == AbstractC4159a.f14078b ? null : (AbstractC4161c) obj) != null) {
                return true;
            }
        }
        return false;
    }

    public abstract int mo256d();

    public abstract void mo257e(int i6);

    public final boolean m8231f() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f14115d;
            i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 == mo256d()) {
                Object obj = AbstractC4161c.f14084a.get(this);
                if ((obj == AbstractC4159a.f14078b ? null : (AbstractC4161c) obj) != null) {
                    return false;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, C0565C.DEFAULT_BUFFER_SEGMENT_SIZE + i6));
        return true;
    }
}
