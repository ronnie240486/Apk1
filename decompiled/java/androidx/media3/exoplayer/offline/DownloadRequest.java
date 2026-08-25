package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        @Override
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override
        public DownloadRequest[] newArray(int i6) {
            return new DownloadRequest[i6];
        }
    };
    public final ByteRange byteRange;
    public final String customCacheKey;
    public final byte[] data;

    public final String f2915id;
    public final byte[] keySetId;
    public final String mimeType;
    public final List<StreamKey> streamKeys;
    public final Uri uri;

    public static class Builder {
        private ByteRange byteRange = null;
        private String customCacheKey;
        private byte[] data;

        private final String f2916id;
        private byte[] keySetId;
        private String mimeType;
        private List<StreamKey> streamKeys;
        private final Uri uri;

        public Builder(String str, Uri uri) {
            this.f2916id = str;
            this.uri = uri;
        }

        public DownloadRequest build() {
            String str = this.f2916id;
            Uri uri = this.uri;
            String str2 = this.mimeType;
            List list = this.streamKeys;
            if (list == null) {
                C2204g1 c2204g1 = AbstractC2301u1.f8069b;
                list = C2180c5.f7862e;
            }
            return new DownloadRequest(str, uri, str2, list, this.keySetId, this.customCacheKey, this.data, this.byteRange);
        }

        public Builder setByteRange(long j10, long j11) {
            this.byteRange = new ByteRange(j10, j11);
            return this;
        }

        public Builder setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder setKeySetId(byte[] bArr) {
            this.keySetId = bArr;
            return this;
        }

        public Builder setMimeType(String str) {
            this.mimeType = MimeTypes.normalizeMimeType(str);
            return this;
        }

        public Builder setStreamKeys(List<StreamKey> list) {
            this.streamKeys = list;
            return this;
        }
    }

    public static class UnsupportedRequestException extends IOException {
    }

    public DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data, this.byteRange);
    }

    public DownloadRequest copyWithKeySetId(byte[] bArr) {
        return new DownloadRequest(this.f2915id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data, this.byteRange);
    }

    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        ?? EmptyList;
        Assertions.checkArgument(this.f2915id.equals(downloadRequest.f2915id));
        if (this.streamKeys.isEmpty() || downloadRequest.streamKeys.isEmpty()) {
            EmptyList = Collections.emptyList();
        } else {
            EmptyList = new ArrayList(this.streamKeys);
            for (int i6 = 0; i6 < downloadRequest.streamKeys.size(); i6++) {
                StreamKey streamKey = downloadRequest.streamKeys.get(i6);
                if (!EmptyList.contains(streamKey)) {
                    EmptyList.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f2915id, downloadRequest.uri, downloadRequest.mimeType, EmptyList, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data, downloadRequest.byteRange);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f2915id.equals(downloadRequest.f2915id) && this.uri.equals(downloadRequest.uri) && Objects.equals(this.mimeType, downloadRequest.mimeType) && this.streamKeys.equals(downloadRequest.streamKeys) && Arrays.equals(this.keySetId, downloadRequest.keySetId) && Objects.equals(this.customCacheKey, downloadRequest.customCacheKey) && Arrays.equals(this.data, downloadRequest.data) && Objects.equals(this.byteRange, downloadRequest.byteRange);
    }

    public int hashCode() {
        int iHashCode = (this.uri.hashCode() + (this.f2915id.hashCode() * 961)) * 31;
        String str = this.mimeType;
        int iHashCode2 = (Arrays.hashCode(this.keySetId) + ((this.streamKeys.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        String str2 = this.customCacheKey;
        int iHashCode3 = (Arrays.hashCode(this.data) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31;
        ByteRange byteRange = this.byteRange;
        return iHashCode3 + (byteRange != null ? byteRange.hashCode() : 0);
    }

    public MediaItem toMediaItem() {
        return new MediaItem.Builder().setMediaId(this.f2915id).setUri(this.uri).setCustomCacheKey(this.customCacheKey).setMimeType(this.mimeType).setStreamKeys(this.streamKeys).build();
    }

    public String toString() {
        return this.mimeType + ":" + this.f2915id;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f2915id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i10 = 0; i10 < this.streamKeys.size(); i10++) {
            parcel.writeParcelable(this.streamKeys.get(i10), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
        parcel.writeParcelable(this.byteRange, 0);
    }

    private DownloadRequest(String str, Uri uri, String str2, List<StreamKey> list, byte[] bArr, String str3, byte[] bArr2, ByteRange byteRange) {
        int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(uri, str2);
        if (iInferContentTypeForUriAndMimeType == 0 || iInferContentTypeForUriAndMimeType == 2 || iInferContentTypeForUriAndMimeType == 1) {
            Assertions.checkArgument(str3 == null, "customCacheKey must be null for type: " + iInferContentTypeForUriAndMimeType);
            this.byteRange = null;
        } else {
            this.byteRange = byteRange;
        }
        this.f2915id = str;
        this.uri = uri;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.EMPTY_BYTE_ARRAY;
    }

    public static final class ByteRange implements Parcelable {
        public static final Parcelable.Creator<ByteRange> CREATOR = new Parcelable.Creator<ByteRange>() {
            @Override
            public ByteRange createFromParcel(Parcel parcel) {
                return new ByteRange(parcel);
            }

            @Override
            public ByteRange[] newArray(int i6) {
                return new ByteRange[i6];
            }
        };
        public final long length;
        public final long offset;

        public ByteRange(long j10, long j11) {
            Assertions.checkArgument(j10 >= 0);
            Assertions.checkArgument(j11 >= 0 || j11 == -1);
            this.offset = j10;
            this.length = j11;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ByteRange)) {
                return false;
            }
            ByteRange byteRange = (ByteRange) obj;
            return this.offset == byteRange.offset && this.length == byteRange.length;
        }

        public int hashCode() {
            return (((int) this.offset) * 961) + ((int) this.length);
        }

        @Override
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeLong(this.offset);
            parcel.writeLong(this.length);
        }

        public ByteRange(Parcel parcel) {
            this(parcel.readLong(), parcel.readLong());
        }
    }

    public DownloadRequest(Parcel parcel) {
        this.f2915id = (String) Util.castNonNull(parcel.readString());
        this.uri = Uri.parse((String) Util.castNonNull(parcel.readString()));
        this.mimeType = parcel.readString();
        int i6 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i6);
        for (int i10 = 0; i10 < i6; i10++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
        this.byteRange = (ByteRange) parcel.readParcelable(ByteRange.class.getClassLoader());
    }
}
