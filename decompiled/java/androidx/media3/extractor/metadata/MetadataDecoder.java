package androidx.media3.extractor.metadata;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface MetadataDecoder {
    Metadata decode(MetadataInputBuffer metadataInputBuffer);
}
