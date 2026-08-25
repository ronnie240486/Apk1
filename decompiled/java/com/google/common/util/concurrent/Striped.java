package com.google.common.util.concurrent;

import androidx.media3.exoplayer.mediacodec.C0812b;
import com.bumptech.glide.AbstractC1465c;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2227j3;
import p041d7.EnumC2234k3;
import p055ea.AbstractC2460q;
import p060f7.AbstractC2499c;
import p109k3.C2888t;

@ElementTypesAreNonnullByDefault
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        @Override
        public L getAt(int i6) {
            return (L) this.array[i6];
        }

        @Override
        public int size() {
            return this.array.length;
        }

        private CompactStriped(int i6, InterfaceC1339e0 interfaceC1339e0) {
            super(i6);
            int i10 = 0;
            AbstractC1332b.m3214e("Stripes must be <= 2^30)", i6 <= 1073741824);
            this.array = new Object[this.mask + 1];
            while (true) {
                Object[] objArr = this.array;
                if (i10 >= objArr.length) {
                    return;
                }
                objArr[i10] = interfaceC1339e0.get();
                i10++;
            }
        }
    }

    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final InterfaceC1339e0 supplier;

        public LargeLazyStriped(int i6, InterfaceC1339e0 interfaceC1339e0) {
            super(i6);
            int i10 = this.mask;
            this.size = i10 == -1 ? Integer.MAX_VALUE : i10 + 1;
            this.supplier = interfaceC1339e0;
            C2888t c2888t = new C2888t(2);
            C2227j3 c2227j3 = EnumC2234k3.f7975b;
            C2227j3 c2227j4 = (C2227j3) c2888t.f9833d;
            AbstractC1332b.m3222m(c2227j4, "Value strength was already set to %s", c2227j4 == null);
            c2888t.f9833d = c2227j3;
            c2888t.f9831b = true;
            this.locks = c2888t.m5886c();
        }

        @Override
        public L getAt(int i6) {
            if (this.size != Integer.MAX_VALUE) {
                AbstractC1332b.m3217h(i6, size());
            }
            L l9 = this.locks.get(Integer.valueOf(i6));
            if (l9 != null) {
                return l9;
            }
            Object obj = this.supplier.get();
            return (L) AbstractC1332b.m3227r(this.locks.putIfAbsent(Integer.valueOf(i6), (L) obj), obj);
        }

        @Override
        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i6) {
            super(i6, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        public PowerOfTwoStriped(int i6) {
            super();
            AbstractC1332b.m3214e("Stripes must be positive", i6 > 0);
            this.mask = i6 > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i6) - 1;
        }

        @Override
        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        @Override
        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final InterfaceC1339e0 supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            public ArrayReference(L l9, int i6, ReferenceQueue<L> referenceQueue) {
                super(l9, referenceQueue);
                this.index = i6;
            }
        }

        public SmallLazyStriped(int i6, InterfaceC1339e0 interfaceC1339e0) {
            super(i6);
            this.queue = new ReferenceQueue<>();
            int i10 = this.mask;
            int i11 = i10 == -1 ? Integer.MAX_VALUE : i10 + 1;
            this.size = i11;
            this.locks = new AtomicReferenceArray<>(i11);
            this.supplier = interfaceC1339e0;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> referencePoll = this.queue.poll();
                if (referencePoll == null) {
                    return;
                }
                ArrayReference<? extends L> arrayReference = (ArrayReference) referencePoll;
                AtomicReferenceArray<ArrayReference<? extends L>> atomicReferenceArray = this.locks;
                int i6 = arrayReference.index;
                while (!atomicReferenceArray.compareAndSet(i6, arrayReference, null) && atomicReferenceArray.get(i6) == arrayReference) {
                }
            }
        }

        @Override
        public L getAt(int i6) {
            L l9;
            if (this.size != Integer.MAX_VALUE) {
                AbstractC1332b.m3217h(i6, size());
            }
            ArrayReference<? extends L> arrayReference = this.locks.get(i6);
            L l10 = arrayReference == null ? null : arrayReference.get();
            if (l10 != null) {
                return l10;
            }
            L l11 = (L) this.supplier.get();
            ArrayReference<? extends L> arrayReference2 = new ArrayReference<>(l11, i6, this.queue);
            do {
                AtomicReferenceArray<ArrayReference<? extends L>> atomicReferenceArray = this.locks;
                do {
                    if (atomicReferenceArray.compareAndSet(i6, arrayReference, arrayReference2)) {
                        drainQueue();
                        return l11;
                    }
                } while (atomicReferenceArray.get(i6) == arrayReference);
                arrayReference = this.locks.get(i6);
                l9 = arrayReference == null ? null : arrayReference.get();
            } while (l9 == null);
            return l9;
        }

        @Override
        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override
        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override
        public Lock delegate() {
            return this.delegate;
        }

        @Override
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        @Override
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    public static int ceilToPowerOfTwo(int i6) {
        int iNumberOfLeadingZeros;
        RoundingMode roundingMode = RoundingMode.CEILING;
        if (i6 <= 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "x (", ") must be > 0"));
        }
        switch (AbstractC2499c.f8729a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1465c.m3469d((((i6 + (-1)) & i6) == 0) & (i6 > 0));
            case 2:
            case 3:
                iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i6);
                return 1 << iNumberOfLeadingZeros;
            case 4:
            case 5:
                iNumberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i6 - 1);
                return 1 << iNumberOfLeadingZeros;
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i6);
                iNumberOfLeadingZeros = (31 - iNumberOfLeadingZeros2) + ((~(~(((-1257966797) >>> iNumberOfLeadingZeros2) - i6))) >>> 31);
                return 1 << iNumberOfLeadingZeros;
            default:
                throw new AssertionError();
        }
    }

    public static <L> Striped<L> custom(int i6, InterfaceC1339e0 interfaceC1339e0) {
        return new CompactStriped(i6, interfaceC1339e0);
    }

    public static Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    public static Semaphore lambda$lazyWeakSemaphore$2(int i6) {
        return new Semaphore(i6, false);
    }

    public static Semaphore lambda$semaphore$1(int i6) {
        return new PaddedSemaphore(i6);
    }

    public static <L> Striped<L> lazyWeakCustom(int i6, InterfaceC1339e0 interfaceC1339e0) {
        return i6 < 1024 ? new SmallLazyStriped(i6, interfaceC1339e0) : new LargeLazyStriped(i6, interfaceC1339e0);
    }

    public static Striped<Lock> lazyWeakLock(int i6) {
        return lazyWeakCustom(i6, new C1973q(2));
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i6) {
        return lazyWeakCustom(i6, new C1973q(0));
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i6, int i10) {
        return lazyWeakCustom(i6, new C0812b(i10, 3));
    }

    public static Striped<Lock> lock(int i6) {
        return custom(i6, new C1973q(1));
    }

    public static Striped<ReadWriteLock> readWriteLock(int i6) {
        return custom(i6, new C1973q(3));
    }

    public static Striped<Semaphore> semaphore(int i6, int i10) {
        return custom(i6, new C0812b(i10, 2));
    }

    public static int smear(int i6) {
        int i10 = i6 ^ ((i6 >>> 20) ^ (i6 >>> 12));
        return (i10 >>> 4) ^ ((i10 >>> 7) ^ i10);
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        iterable.getClass();
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList((Collection) iterable) : AbstractC2182d0.m5156s(iterable.iterator());
        if (arrayList.isEmpty()) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            return C2180c5.f7862e;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr[i6] = indexFor(arrayList.get(i6));
        }
        Arrays.sort(iArr);
        int i10 = iArr[0];
        arrayList.set(0, getAt(i10));
        for (int i11 = 1; i11 < arrayList.size(); i11++) {
            int i12 = iArr[i11];
            if (i12 == i10) {
                arrayList.set(i11, arrayList.get(i11 - 1));
            } else {
                arrayList.set(i11, getAt(i12));
                i10 = i12;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i6);

    public abstract int indexFor(Object obj);

    public abstract int size();

    private Striped() {
    }
}
