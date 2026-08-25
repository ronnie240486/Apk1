package retrofit2;

import com.lzy.okgo.model.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p000a.AbstractC0004e;

abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;

        private final int f12280p;

        public Body(Method method, int i6, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f12280p = i6;
            this.converter = converter;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) {
            if (t5 == null) {
                throw Utils.parameterError(this.method, this.f12280p, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.setBody(this.converter.convert(t5));
            } catch (IOException e5) {
                throw Utils.parameterError(this.method, e5, this.f12280p, "Unable to convert " + t5 + " to RequestBody", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z7) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z7;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) throws IOException {
            String strConvert;
            if (t5 == null || (strConvert = this.valueConverter.convert(t5)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, strConvert, this.encoded);
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        private final int f12281p;
        private final Converter<T, String> valueConverter;

        public FieldMap(Method method, int i6, Converter<T, String> converter, boolean z7) {
            this.method = method;
            this.f12281p = i6;
            this.valueConverter = converter;
            this.encoded = z7;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f12281p, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f12281p, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f12281p, AbstractC0004e.m24r("Field map contained null value for key '", key, "'."), new Object[0]);
                }
                String strConvert = this.valueConverter.convert(value);
                if (strConvert == null) {
                    throw Utils.parameterError(this.method, this.f12281p, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addFormField(key, strConvert, this.encoded);
            }
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) throws IOException {
            String strConvert;
            if (t5 == null || (strConvert = this.valueConverter.convert(t5)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, strConvert);
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        private final int f12282p;
        private final Converter<T, String> valueConverter;

        public HeaderMap(Method method, int i6, Converter<T, String> converter) {
            this.method = method;
            this.f12282p = i6;
            this.valueConverter = converter;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f12282p, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f12282p, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f12282p, AbstractC0004e.m24r("Header map contained null value for key '", key, "'."), new Object[0]);
                }
                requestBuilder.addHeader(key, this.valueConverter.convert(value));
            }
        }
    }

    public static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;

        private final int f12283p;

        public Headers(Method method, int i6) {
            this.method = method;
            this.f12283p = i6;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers == null) {
                throw Utils.parameterError(this.method, this.f12283p, "Headers parameter must not be null.", new Object[0]);
            }
            requestBuilder.addHeaders(headers);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;

        private final int f12284p;

        public Part(Method method, int i6, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f12284p = i6;
            this.headers = headers;
            this.converter = converter;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) {
            if (t5 == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, this.converter.convert(t5));
            } catch (IOException e5) {
                throw Utils.parameterError(this.method, this.f12284p, "Unable to convert " + t5 + " to RequestBody", e5);
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        private final int f12285p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        public PartMap(Method method, int i6, Converter<T, RequestBody> converter, String str) {
            this.method = method;
            this.f12285p = i6;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f12285p, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f12285p, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f12285p, AbstractC0004e.m24r("Part map contained null value for key '", key, "'."), new Object[0]);
                }
                requestBuilder.addPart(okhttp3.Headers.m6638of(HttpHeaders.HEAD_KEY_CONTENT_DISPOSITION, AbstractC0004e.m24r("form-data; name=\"", key, "\""), "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
            }
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        private final int f12286p;
        private final Converter<T, String> valueConverter;

        public Path(Method method, int i6, String str, Converter<T, String> converter, boolean z7) {
            this.method = method;
            this.f12286p = i6;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z7;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) throws IOException {
            if (t5 == null) {
                throw Utils.parameterError(this.method, this.f12286p, AbstractC0004e.m26t(new StringBuilder("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
            }
            requestBuilder.addPathParam(this.name, this.valueConverter.convert(t5), this.encoded);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z7) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z7;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) throws IOException {
            String strConvert;
            if (t5 == null || (strConvert = this.valueConverter.convert(t5)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, strConvert, this.encoded);
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        private final int f12287p;
        private final Converter<T, String> valueConverter;

        public QueryMap(Method method, int i6, Converter<T, String> converter, boolean z7) {
            this.method = method;
            this.f12287p = i6;
            this.valueConverter = converter;
            this.encoded = z7;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f12287p, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f12287p, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f12287p, AbstractC0004e.m24r("Query map contained null value for key '", key, "'."), new Object[0]);
                }
                String strConvert = this.valueConverter.convert(value);
                if (strConvert == null) {
                    throw Utils.parameterError(this.method, this.f12287p, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addQueryParam(key, strConvert, this.encoded);
            }
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z7) {
            this.nameConverter = converter;
            this.encoded = z7;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) throws IOException {
            if (t5 == null) {
                return;
            }
            requestBuilder.addQueryParam(this.nameConverter.convert(t5), null, this.encoded);
        }
    }

    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        @Override
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        private final int f12288p;

        public RelativeUrl(Method method, int i6) {
            this.method = method;
            this.f12288p = i6;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.f12288p, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.setRelativeUrl(obj);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override
        public void apply(RequestBuilder requestBuilder, T t5) {
            requestBuilder.addTag(this.cls, t5);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t5) throws IOException;

    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            @Override
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i6 = 0; i6 < length; i6++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i6));
                }
            }
        };
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            @Override
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.apply(requestBuilder, it.next());
                }
            }
        };
    }
}
