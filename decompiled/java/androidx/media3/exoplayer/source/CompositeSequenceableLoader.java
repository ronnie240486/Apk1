package androidx.media3.exoplayer.source;

import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import java.util.Collections;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

@UnstableApi
public final class CompositeSequenceableLoader implements SequenceableLoader {
    private long lastAudioVideoBufferedPositionUs;
    private final AbstractC2301u1 loadersWithTrackTypes;

    public static final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {
        private final SequenceableLoader loader;
        private final AbstractC2301u1 trackTypes;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List<Integer> list) {
            this.loader = sequenceableLoader;
            this.trackTypes = AbstractC2301u1.m5272n(list);
        }

        @Override
        public boolean continueLoading(LoadingInfo loadingInfo) {
            return this.loader.continueLoading(loadingInfo);
        }

        @Override
        public long getBufferedPositionUs() {
            return this.loader.getBufferedPositionUs();
        }

        @Override
        public long getNextLoadPositionUs() {
            return this.loader.getNextLoadPositionUs();
        }

        public AbstractC2301u1 getTrackTypes() {
            return this.trackTypes;
        }

        @Override
        public boolean isLoading() {
            return this.loader.isLoading();
        }

        @Override
        public void reevaluateBuffer(long j10) {
            this.loader.reevaluateBuffer(j10);
        }
    }

    @Deprecated
    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this(AbstractC2301u1.m5273o(sequenceableLoaderArr), Collections.nCopies(sequenceableLoaderArr.length, AbstractC2301u1.m5275r(-1)));
    }

    @Override
    public boolean continueLoading(LoadingInfo loadingInfo) {
        boolean zContinueLoading;
        boolean z7 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zContinueLoading = false;
            for (int i6 = 0; i6 < this.loadersWithTrackTypes.size(); i6++) {
                long nextLoadPositionUs2 = ((SequenceableLoaderWithTrackTypes) this.loadersWithTrackTypes.get(i6)).getNextLoadPositionUs();
                boolean z10 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= loadingInfo.playbackPositionUs;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z10) {
                    zContinueLoading |= ((SequenceableLoaderWithTrackTypes) this.loadersWithTrackTypes.get(i6)).continueLoading(loadingInfo);
                }
            }
            z7 |= zContinueLoading;
        } while (zContinueLoading);
        return z7;
    }

    @Override
    public long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < this.loadersWithTrackTypes.size(); i6++) {
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = (SequenceableLoaderWithTrackTypes) this.loadersWithTrackTypes.get(i6);
            long bufferedPositionUs = sequenceableLoaderWithTrackTypes.getBufferedPositionUs();
            if ((sequenceableLoaderWithTrackTypes.getTrackTypes().contains(1) || sequenceableLoaderWithTrackTypes.getTrackTypes().contains(2) || sequenceableLoaderWithTrackTypes.getTrackTypes().contains(4)) && bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, bufferedPositionUs);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.lastAudioVideoBufferedPositionUs = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j10 = this.lastAudioVideoBufferedPositionUs;
        return j10 != C0565C.TIME_UNSET ? j10 : jMin2;
    }

    @Override
    public long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (int i6 = 0; i6 < this.loadersWithTrackTypes.size(); i6++) {
            long nextLoadPositionUs = ((SequenceableLoaderWithTrackTypes) this.loadersWithTrackTypes.get(i6)).getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override
    public boolean isLoading() {
        for (int i6 = 0; i6 < this.loadersWithTrackTypes.size(); i6++) {
            if (((SequenceableLoaderWithTrackTypes) this.loadersWithTrackTypes.get(i6)).isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void reevaluateBuffer(long j10) {
        for (int i6 = 0; i6 < this.loadersWithTrackTypes.size(); i6++) {
            ((SequenceableLoaderWithTrackTypes) this.loadersWithTrackTypes.get(i6)).reevaluateBuffer(j10);
        }
    }

    public CompositeSequenceableLoader(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        Assertions.checkArgument(list.size() == list2.size());
        for (int i6 = 0; i6 < list.size(); i6++) {
            c2288s1M5269k.m5255a(new SequenceableLoaderWithTrackTypes(list.get(i6), list2.get(i6)));
        }
        this.loadersWithTrackTypes = c2288s1M5269k.m5262g();
        this.lastAudioVideoBufferedPositionUs = C0565C.TIME_UNSET;
    }
}
