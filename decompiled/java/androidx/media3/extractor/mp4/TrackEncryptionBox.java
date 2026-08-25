package androidx.media3.extractor.mp4;

import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final String schemeType;

    public TrackEncryptionBox(boolean z7, String str, int i6, byte[] bArr, int i10, int i11, byte[] bArr2) {
        Assertions.checkArgument((bArr2 == null) ^ (i6 == 0));
        this.isEncrypted = z7;
        this.schemeType = str;
        this.perSampleIvSize = i6;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i10, i11);
    }

    private static int schemeToCryptoMode(String str) {
        if (str == null) {
            return 1;
        }
        byte b8 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C0565C.CENC_TYPE_cbc1)) {
                    b8 = 0;
                }
                break;
            case 3046671:
                if (str.equals(C0565C.CENC_TYPE_cbcs)) {
                    b8 = 1;
                }
                break;
            case 3049879:
                if (str.equals(C0565C.CENC_TYPE_cenc)) {
                    b8 = 2;
                }
                break;
            case 3049895:
                if (str.equals(C0565C.CENC_TYPE_cens)) {
                    b8 = 3;
                }
                break;
        }
        switch (b8) {
            case 0:
            case 1:
                return 2;
            default:
                Log.m1719w(TAG, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
