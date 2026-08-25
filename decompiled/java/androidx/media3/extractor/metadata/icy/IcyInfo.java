package androidx.media3.extractor.metadata.icy;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
public final class IcyInfo implements Metadata.Entry {
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.rawMetadata = bArr;
        this.title = str;
        this.url = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.rawMetadata, ((IcyInfo) obj).rawMetadata);
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
        return Arrays.hashCode(this.rawMetadata);
    }

    @Override
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.title;
        if (str != null) {
            builder.setTitle(str);
        }
    }

    public String toString() {
        return "ICY: title=\"" + this.title + "\", url=\"" + this.url + "\", rawMetadata.length=\"" + this.rawMetadata.length + "\"";
    }
}
