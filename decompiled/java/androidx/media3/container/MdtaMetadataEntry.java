package androidx.media3.container;

import androidx.media3.common.AbstractC0600i;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p020b7.C1350k;
import p055ea.AbstractC2460q;

@UnstableApi
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final byte AUXILIARY_TRACKS_SAMPLES_INTERLEAVED = 1;
    public static final byte AUXILIARY_TRACKS_SAMPLES_NOT_INTERLEAVED = 0;
    public static final int DEFAULT_LOCALE_INDICATOR = 0;
    public static final String KEY_ANDROID_CAPTURE_FPS = "com.android.capture.fps";
    public static final String KEY_AUXILIARY_TRACKS_INTERLEAVED = "auxiliary.tracks.interleaved";
    public static final String KEY_AUXILIARY_TRACKS_LENGTH = "auxiliary.tracks.length";
    public static final String KEY_AUXILIARY_TRACKS_MAP = "auxiliary.tracks.map";
    public static final String KEY_AUXILIARY_TRACKS_OFFSET = "auxiliary.tracks.offset";
    public static final int TYPE_INDICATOR_8_BIT_UNSIGNED_INT = 75;
    public static final int TYPE_INDICATOR_FLOAT32 = 23;
    public static final int TYPE_INDICATOR_INT32 = 67;
    public static final int TYPE_INDICATOR_RESERVED = 0;
    public static final int TYPE_INDICATOR_STRING = 1;
    public static final int TYPE_INDICATOR_UNSIGNED_INT64 = 78;
    public final String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    public MdtaMetadataEntry(String str, byte[] bArr, int i6) {
        this(str, bArr, 0, i6);
    }

    private static String getFormattedValueForAuxiliaryTracksMap(List<Integer> list) {
        StringBuilder sbM5498l = AbstractC2460q.m5498l("track types = ");
        new C1350k(String.valueOf(',')).m3240a(sbM5498l, list.iterator());
        return sbM5498l.toString();
    }

    private static void validateData(String str, byte[] bArr, int i6) {
        byte b8;
        str.getClass();
        boolean z7 = false;
        switch (str) {
            case "com.android.capture.fps":
                if (i6 == 23 && bArr.length == 4) {
                    z7 = true;
                }
                Assertions.checkArgument(z7);
                break;
            case "auxiliary.tracks.interleaved":
                if (i6 == 75 && bArr.length == 1 && ((b8 = bArr[0]) == 0 || b8 == 1)) {
                    z7 = true;
                }
                Assertions.checkArgument(z7);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i6 == 78 && bArr.length == 8) {
                    z7 = true;
                }
                Assertions.checkArgument(z7);
                break;
            case "auxiliary.tracks.map":
                Assertions.checkArgument(i6 == 0);
                break;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.key.equals(mdtaMetadataEntry.key) && Arrays.equals(this.value, mdtaMetadataEntry.value) && this.localeIndicator == mdtaMetadataEntry.localeIndicator && this.typeIndicator == mdtaMetadataEntry.typeIndicator;
    }

    public List<Integer> getAuxiliaryTrackTypesFromMap() {
        Assertions.checkState(this.key.equals(KEY_AUXILIARY_TRACKS_MAP), "Metadata is not an auxiliary tracks map");
        byte b8 = this.value[1];
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < b8; i6++) {
            arrayList.add(Integer.valueOf(this.value[i6 + 2]));
        }
        return arrayList;
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
        return ((((Arrays.hashCode(this.value) + AbstractC0004e.m14h(527, 31, this.key)) * 31) + this.localeIndicator) * 31) + this.typeIndicator;
    }

    @Override
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        AbstractC0600i.m1664c(this, builder);
    }

    public String toString() {
        String formattedValueForAuxiliaryTracksMap;
        int i6 = this.typeIndicator;
        if (i6 != 0) {
            if (i6 == 1) {
                formattedValueForAuxiliaryTracksMap = Util.fromUtf8Bytes(this.value);
            } else if (i6 == 23) {
                byte[] bArr = this.value;
                AbstractC1332b.m3213d("array too small: %s < %s", bArr.length, 4, bArr.length >= 4);
                byte b8 = bArr[0];
                formattedValueForAuxiliaryTracksMap = String.valueOf(Float.intBitsToFloat((bArr[3] & 255) | ((bArr[1] & 255) << 16) | (b8 << 24) | ((bArr[2] & 255) << 8)));
            } else if (i6 == 67) {
                byte[] bArr2 = this.value;
                AbstractC1332b.m3213d("array too small: %s < %s", bArr2.length, 4, bArr2.length >= 4);
                byte b10 = bArr2[0];
                formattedValueForAuxiliaryTracksMap = String.valueOf((bArr2[3] & 255) | ((bArr2[1] & 255) << 16) | (b10 << 24) | ((bArr2[2] & 255) << 8));
            } else if (i6 == 75) {
                formattedValueForAuxiliaryTracksMap = String.valueOf(this.value[0] & 255);
            } else if (i6 != 78) {
                formattedValueForAuxiliaryTracksMap = Util.toHexString(this.value);
            } else {
                formattedValueForAuxiliaryTracksMap = String.valueOf(new ParsableByteArray(this.value).readUnsignedLongToLong());
            }
        } else if (this.key.equals(KEY_AUXILIARY_TRACKS_MAP)) {
            formattedValueForAuxiliaryTracksMap = getFormattedValueForAuxiliaryTracksMap(getAuxiliaryTrackTypesFromMap());
        } else {
            formattedValueForAuxiliaryTracksMap = Util.toHexString(this.value);
        }
        return "mdta: key=" + this.key + ", value=" + formattedValueForAuxiliaryTracksMap;
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i6, int i10) {
        validateData(str, bArr, i10);
        this.key = str;
        this.value = bArr;
        this.localeIndicator = i6;
        this.typeIndicator = i10;
    }
}
