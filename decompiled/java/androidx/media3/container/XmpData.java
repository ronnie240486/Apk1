package androidx.media3.container;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
public final class XmpData implements Metadata.Entry {
    public final byte[] data;

    public XmpData(byte[] bArr) {
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.data, ((XmpData) obj).data);
    }

    @Override
    public final byte[] getWrappedMetadataBytes() {
        return AbstractC0600i.m1662a(this);
    }

    @Override
    public final Format getWrappedMetadataFormat() {
        return AbstractC0600i.m1663b(this);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    @Override
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        AbstractC0600i.m1664c(this, builder);
    }

    public String toString() {
        return "XMP: " + Util.toHexString(this.data);
    }
}
