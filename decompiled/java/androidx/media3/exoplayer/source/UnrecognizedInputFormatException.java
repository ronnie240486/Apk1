package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SniffFailure;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public class UnrecognizedInputFormatException extends ParserException {
    public final AbstractC2301u1 sniffFailures;
    public final Uri uri;

    @Deprecated
    public UnrecognizedInputFormatException(String str, Uri uri) {
        this(str, uri, C2180c5.f7862e);
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
    }

    public UnrecognizedInputFormatException(String str, Uri uri, List<? extends SniffFailure> list) {
        super(str, null, false, 1);
        this.uri = uri;
        this.sniffFailures = AbstractC2301u1.m5272n(list);
    }
}
