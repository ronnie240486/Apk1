package androidx.media3.extractor.metadata.icy;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p000a.AbstractC0004e;

@UnstableApi
public final class IcyHeaders implements Metadata.Entry {
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final String RESPONSE_HEADER_NAME = "icy-name";
    private static final String RESPONSE_HEADER_PUB = "icy-pub";
    private static final String RESPONSE_HEADER_URL = "icy-url";
    private static final String TAG = "IcyHeaders";
    public final int bitrate;
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    public final String name;
    public final String url;

    public IcyHeaders(int i6, String str, String str2, String str3, boolean z7, int i10) {
        Assertions.checkArgument(i10 == -1 || i10 > 0);
        this.bitrate = i6;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z7;
        this.metadataInterval = i10;
    }

    public static IcyHeaders parse(Map<String, List<String>> map) {
        boolean z7;
        int i6;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i10;
        int i11;
        List<String> list = map.get(RESPONSE_HEADER_BITRATE);
        boolean z10 = true;
        int i12 = -1;
        if (list != null) {
            String str4 = list.get(0);
            try {
                i11 = Integer.parseInt(str4) * 1000;
                if (i11 > 0) {
                    z7 = true;
                } else {
                    try {
                        Log.m1719w(TAG, "Invalid bitrate: " + str4);
                        z7 = false;
                        i11 = -1;
                    } catch (NumberFormatException unused) {
                        AbstractC0004e.m4D("Invalid bitrate header: ", str4, TAG);
                        i6 = i11;
                        z7 = false;
                    }
                }
                i6 = i11;
            } catch (NumberFormatException unused2) {
                i11 = -1;
            }
        } else {
            z7 = false;
            i6 = -1;
        }
        List<String> list2 = map.get(RESPONSE_HEADER_GENRE);
        if (list2 != null) {
            str = list2.get(0);
            z7 = true;
        } else {
            str = null;
        }
        List<String> list3 = map.get(RESPONSE_HEADER_NAME);
        if (list3 != null) {
            str2 = list3.get(0);
            z7 = true;
        } else {
            str2 = null;
        }
        List<String> list4 = map.get(RESPONSE_HEADER_URL);
        if (list4 != null) {
            str3 = list4.get(0);
            z7 = true;
        } else {
            str3 = null;
        }
        List<String> list5 = map.get(RESPONSE_HEADER_PUB);
        if (list5 != null) {
            zEquals = list5.get(0).equals(REQUEST_HEADER_ENABLE_METADATA_VALUE);
            z7 = true;
        } else {
            zEquals = false;
        }
        List<String> list6 = map.get(RESPONSE_HEADER_METADATA_INTERVAL);
        if (list6 != null) {
            String str5 = list6.get(0);
            try {
                int i13 = Integer.parseInt(str5);
                if (i13 > 0) {
                    i12 = i13;
                } else {
                    try {
                        Log.m1719w(TAG, "Invalid metadata interval: " + str5);
                        z10 = z7;
                    } catch (NumberFormatException unused3) {
                        i12 = i13;
                        AbstractC0004e.m4D("Invalid metadata interval: ", str5, TAG);
                    }
                }
                z7 = z10;
            } catch (NumberFormatException unused4) {
            }
            i10 = i12;
        } else {
            i10 = -1;
        }
        if (z7) {
            return new IcyHeaders(i6, str, str2, str3, zEquals, i10);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.bitrate == icyHeaders.bitrate && Objects.equals(this.genre, icyHeaders.genre) && Objects.equals(this.name, icyHeaders.name) && Objects.equals(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval;
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
        int i6 = (527 + this.bitrate) * 31;
        String str = this.genre;
        int iHashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    @Override
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.name;
        if (str != null) {
            builder.setStation(str);
        }
        String str2 = this.genre;
        if (str2 != null) {
            builder.setGenre(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.name + "\", genre=\"" + this.genre + "\", bitrate=" + this.bitrate + ", metadataInterval=" + this.metadataInterval;
    }
}
