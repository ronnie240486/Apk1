package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public abstract class Id3Frame implements Metadata.Entry {

    public final String f3093id;

    public Id3Frame(String str) {
        this.f3093id = str;
    }

    @Override
    public final byte[] getWrappedMetadataBytes() {
        return AbstractC0600i.m1662a(this);
    }

    @Override
    public final Format getWrappedMetadataFormat() {
        return AbstractC0600i.m1663b(this);
    }

    @Override
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        AbstractC0600i.m1664c(this, builder);
    }

    public String toString() {
        return this.f3093id;
    }
}
