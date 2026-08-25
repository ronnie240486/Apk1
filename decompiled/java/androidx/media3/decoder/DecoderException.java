package androidx.media3.decoder;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public class DecoderException extends Exception {
    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(Throwable th) {
        super(th);
    }

    public DecoderException(String str, Throwable th) {
        super(str, th);
    }
}
