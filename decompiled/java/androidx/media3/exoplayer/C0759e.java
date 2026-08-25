package androidx.media3.exoplayer;

import androidx.media3.common.text.CueGroup;
import androidx.media3.exoplayer.text.AbstractC0936b;
import androidx.media3.exoplayer.text.TextOutput;
import java.util.List;

public final class C0759e implements TextOutput {
    @Override
    public final void onCues(CueGroup cueGroup) {
        DefaultRendererCapabilitiesList.Factory.lambda$createRendererCapabilitiesList$0(cueGroup);
    }

    @Override
    public final void onCues(List list) {
        AbstractC0936b.m2558a(this, list);
    }
}
