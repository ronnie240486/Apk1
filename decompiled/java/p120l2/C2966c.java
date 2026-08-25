package p120l2;

import android.graphics.Bitmap;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;
import p103j9.AbstractC2796i;
import p143n5.AbstractC3198d;
import p185r2.AbstractC3587f;
import p192r9.AbstractC3648f;

public final class C2966c {

    public final Object f10152a = AbstractC3198d.m6427B(new C2964a(this));

    public final Object f10153b = AbstractC3198d.m6427B(new C2965b(this));

    public final long f10154c;

    public final long f10155d;

    public final boolean f10156e;

    public final Headers f10157f;

    public C2966c(BufferedSource bufferedSource) throws IOException {
        this.f10154c = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.f10155d = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.f10156e = Integer.parseInt(bufferedSource.readUtf8LineStrict()) > 0;
        int i6 = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        Headers.Builder builder = new Headers.Builder();
        for (int i10 = 0; i10 < i6; i10++) {
            String utf8LineStrict = bufferedSource.readUtf8LineStrict();
            Bitmap.Config[] configArr = AbstractC3587f.f12065a;
            int iM7380b0 = AbstractC3648f.m7380b0(utf8LineStrict, ':', 0, false, 6);
            if (iM7380b0 == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(utf8LineStrict).toString());
            }
            String strSubstring = utf8LineStrict.substring(0, iM7380b0);
            AbstractC2796i.m5784e(strSubstring, "substring(...)");
            String string = AbstractC3648f.m7392n0(strSubstring).toString();
            String strSubstring2 = utf8LineStrict.substring(iM7380b0 + 1);
            AbstractC2796i.m5784e(strSubstring2, "substring(...)");
            builder.addUnsafeNonAscii(string, strSubstring2);
        }
        this.f10157f = builder.build();
    }

    public final void m6004a(BufferedSink bufferedSink) throws IOException {
        bufferedSink.writeDecimalLong(this.f10154c).writeByte(10);
        bufferedSink.writeDecimalLong(this.f10155d).writeByte(10);
        bufferedSink.writeDecimalLong(this.f10156e ? 1L : 0L).writeByte(10);
        Headers headers = this.f10157f;
        bufferedSink.writeDecimalLong(headers.size()).writeByte(10);
        int size = headers.size();
        for (int i6 = 0; i6 < size; i6++) {
            bufferedSink.writeUtf8(headers.name(i6)).writeUtf8(": ").writeUtf8(headers.value(i6)).writeByte(10);
        }
    }

    public C2966c(Response response) {
        this.f10154c = response.sentRequestAtMillis();
        this.f10155d = response.receivedResponseAtMillis();
        this.f10156e = response.handshake() != null;
        this.f10157f = response.headers();
    }
}
