package retrofit2.converter.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p125l7.C3004k;
import p202s7.C3723a;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class GsonConverterFactory extends Converter.Factory {
    private final C3004k gson;

    private GsonConverterFactory(C3004k c3004k) {
        this.gson = c3004k;
    }

    public static GsonConverterFactory create() {
        return create(new C3004k());
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.m6081c(new C3723a(type)));
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.m6081c(new C3723a(type)));
    }

    public static GsonConverterFactory create(C3004k c3004k) {
        if (c3004k != null) {
            return new GsonConverterFactory(c3004k);
        }
        throw new NullPointerException("gson == null");
    }
}
