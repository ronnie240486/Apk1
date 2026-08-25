package androidx.media3.datasource;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1354n;
import p055ea.AbstractC2460q;

public interface HttpDataSource extends DataSource {

    @UnstableApi
    public static final InterfaceC1354n REJECT_PAYWALL_TYPES = new C0649f(2);

    @UnstableApi
    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @Override
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        @Override
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        @UnstableApi
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, dataSpec, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
        }
    }

    public interface Factory extends DataSource.Factory {
        @Override
        @UnstableApi
        DataSource createDataSource();

        @Override
        @UnstableApi
        HttpDataSource createDataSource();

        @UnstableApi
        Factory setDefaultRequestProperties(Map<String, String> map);
    }

    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;

        @UnstableApi
        public final DataSpec dataSpec;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(DataSpec dataSpec, int i6) {
            this(dataSpec, 2000, i6);
        }

        private static int assignErrorCode(int i6, int i10) {
            return (i6 == 2000 && i10 == 1) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : i6;
        }

        @UnstableApi
        public static HttpDataSourceException createForIOException(IOException iOException, DataSpec dataSpec, int i6) {
            int i10;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i10 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
            } else if (iOException instanceof InterruptedIOException) {
                i10 = 1004;
            } else {
                i10 = (message == null || !AbstractC1332b.m3231v(message).matches("cleartext.*not permitted.*")) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED;
            }
            return i10 == 2007 ? new CleartextNotPermittedException(iOException, dataSpec) : new HttpDataSourceException(iOException, dataSpec, i10, i6);
        }

        @UnstableApi
        public HttpDataSourceException(DataSpec dataSpec, int i6, int i10) {
            super(assignErrorCode(i6, i10));
            this.dataSpec = dataSpec;
            this.type = i10;
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(String str, DataSpec dataSpec, int i6) {
            this(str, dataSpec, 2000, i6);
        }

        @UnstableApi
        public HttpDataSourceException(String str, DataSpec dataSpec, int i6, int i10) {
            super(str, assignErrorCode(i6, i10));
            this.dataSpec = dataSpec;
            this.type = i10;
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i6) {
            this(iOException, dataSpec, 2000, i6);
        }

        @UnstableApi
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i6, int i10) {
            super(iOException, assignErrorCode(i6, i10));
            this.dataSpec = dataSpec;
            this.type = i10;
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i6) {
            this(str, iOException, dataSpec, 2000, i6);
        }

        @UnstableApi
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i6, int i10) {
            super(str, iOException, assignErrorCode(i6, i10));
            this.dataSpec = dataSpec;
            this.type = i10;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        @UnstableApi
        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super(AbstractC2460q.m5501o("Invalid content type: ", str), dataSpec, PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {

        @UnstableApi
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;

        @UnstableApi
        public InvalidResponseCodeException(int i6, String str, IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
            super(AbstractC0004e.m20n(i6, "Response code: "), iOException, dataSpec, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, 1);
            this.responseCode = i6;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }

    @UnstableApi
    void clearAllRequestProperties();

    @UnstableApi
    void clearRequestProperty(String str);

    @Override
    @UnstableApi
    void close() throws HttpDataSourceException;

    @UnstableApi
    int getResponseCode();

    @Override
    @UnstableApi
    Map<String, List<String>> getResponseHeaders();

    @Override
    @UnstableApi
    long open(DataSpec dataSpec) throws HttpDataSourceException;

    @Override
    @UnstableApi
    int read(byte[] bArr, int i6, int i10) throws HttpDataSourceException;

    @UnstableApi
    void setRequestProperty(String str, String str2);

    @UnstableApi
    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public synchronized Map<String, String> getSnapshot() {
            try {
                if (this.requestPropertiesSnapshot == null) {
                    this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.requestPropertiesSnapshot;
        }

        public synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }
    }
}
