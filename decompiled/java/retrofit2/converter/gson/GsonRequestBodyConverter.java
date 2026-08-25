package retrofit2.converter.gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p212t7.C3813b;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final AbstractC3011r adapter;
    private final C3004k gson;

    public GsonRequestBodyConverter(C3004k c3004k, AbstractC3011r abstractC3011r) {
        this.gson = c3004k;
        this.adapter = abstractC3011r;
    }

    @Override
    public RequestBody convert(T t5) throws IOException {
        Buffer buffer = new Buffer();
        C3813b c3813bM6082d = this.gson.m6082d(new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.mo6078b(c3813bM6082d, t5);
        c3813bM6082d.close();
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}
