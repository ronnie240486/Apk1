package androidx.media3.common;

import androidx.media3.exoplayer.upstream.experimental.SlidingWeightedAverageBandwidthStatistic;
import java.util.Deque;

public final class C0593e0 implements SimpleBasePlayer.PositionSupplier, SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction {

    public final long f2601a;

    public C0593e0(long j10) {
        this.f2601a = j10;
    }

    @Override
    public long get() {
        return AbstractC0595f0.m1649c(this.f2601a);
    }

    @Override
    public boolean shouldEvictSample(Deque deque) {
        return SlidingWeightedAverageBandwidthStatistic.lambda$getMaxCountEvictionFunction$0(this.f2601a, deque);
    }
}
