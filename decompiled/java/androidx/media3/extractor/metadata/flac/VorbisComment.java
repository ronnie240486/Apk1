package androidx.media3.extractor.metadata.flac;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p187r4.AbstractC3612b;

@UnstableApi
@Deprecated
public class VorbisComment implements Metadata.Entry {
    public final String key;
    public final String value;

    public VorbisComment(String str, String str2) {
        this.key = AbstractC1332b.m3233x(str);
        this.value = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value);
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
        return this.value.hashCode() + AbstractC0004e.m14h(527, 31, this.key);
    }

    @Override
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.key;
        str.getClass();
        switch (str) {
            case "TOTALTRACKS":
                Integer numM7259P = AbstractC3612b.m7259P(this.value);
                if (numM7259P != null) {
                    builder.setTotalTrackCount(numM7259P);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numM7259P2 = AbstractC3612b.m7259P(this.value);
                if (numM7259P2 != null) {
                    builder.setTotalDiscCount(numM7259P2);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer numM7259P3 = AbstractC3612b.m7259P(this.value);
                if (numM7259P3 != null) {
                    builder.setTrackNumber(numM7259P3);
                    break;
                }
                break;
            case "ALBUM":
                builder.setAlbumTitle(this.value);
                break;
            case "GENRE":
                builder.setGenre(this.value);
                break;
            case "TITLE":
                builder.setTitle(this.value);
                break;
            case "DESCRIPTION":
                builder.setDescription(this.value);
                break;
            case "DISCNUMBER":
                Integer numM7259P4 = AbstractC3612b.m7259P(this.value);
                if (numM7259P4 != null) {
                    builder.setDiscNumber(numM7259P4);
                    break;
                }
                break;
            case "ALBUMARTIST":
                builder.setAlbumArtist(this.value);
                break;
            case "ARTIST":
                builder.setArtist(this.value);
                break;
        }
    }

    public String toString() {
        return "VC: " + this.key + "=" + this.value;
    }
}
