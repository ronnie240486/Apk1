package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    @Override
    public SequenceableLoader create(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        return new CompositeSequenceableLoader(list, list2);
    }

    @Override
    @Deprecated
    public SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader... sequenceableLoaderArr) {
        return new CompositeSequenceableLoader(sequenceableLoaderArr);
    }

    @Override
    public SequenceableLoader empty() {
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        C2180c5 c2180c5 = C2180c5.f7862e;
        return new CompositeSequenceableLoader(c2180c5, c2180c5);
    }
}
