package retrofit2.converter.gson;

import java.io.IOException;
import java.io.Reader;
import okhttp3.ResponseBody;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.C3007n;
import p212t7.C3812a;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final AbstractC3011r adapter;
    private final C3004k gson;

    public GsonResponseBodyConverter(C3004k c3004k, AbstractC3011r abstractC3011r) {
        this.gson = c3004k;
        this.adapter = abstractC3011r;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        C3004k c3004k = this.gson;
        Reader readerCharStream = responseBody.charStream();
        c3004k.getClass();
        C3812a c3812a = new C3812a(readerCharStream);
        c3812a.f12873b = false;
        try {
            T t5 = (T) this.adapter.mo6077a(c3812a);
            if (c3812a.m7612u() != 10) {
                throw new C3007n("JSON document was not fully consumed.");
            }
            responseBody.close();
            return t5;
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
