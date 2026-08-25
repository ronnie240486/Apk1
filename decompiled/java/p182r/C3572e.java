package p182r;

import com.bumptech.glide.AbstractC1466d;

public final class C3572e extends AbstractC1466d {
    @Override
    public final void mo3507B(C3573f c3573f, C3573f c3573f2) {
        c3573f.f12038b = c3573f2;
    }

    @Override
    public final void mo3508C(C3573f c3573f, Thread thread) {
        c3573f.f12037a = thread;
    }

    @Override
    public final boolean mo3512b(AbstractC3574g abstractC3574g, C3570c c3570c, C3570c c3570c2) {
        synchronized (abstractC3574g) {
            try {
                if (abstractC3574g.f12044b != c3570c) {
                    return false;
                }
                abstractC3574g.f12044b = c3570c2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo3513c(AbstractC3574g abstractC3574g, Object obj, Object obj2) {
        synchronized (abstractC3574g) {
            try {
                if (abstractC3574g.f12043a != obj) {
                    return false;
                }
                abstractC3574g.f12043a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo3514d(AbstractC3574g abstractC3574g, C3573f c3573f, C3573f c3573f2) {
        synchronized (abstractC3574g) {
            try {
                if (abstractC3574g.f12045c != c3573f) {
                    return false;
                }
                abstractC3574g.f12045c = c3573f2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
