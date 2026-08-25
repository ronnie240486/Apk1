package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.lzy.okgo.model.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import p000a.AbstractC0004e;
import p020b7.InterfaceC1354n;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2232k1;
import p041d7.C2215h5;
import p052e7.AbstractC2425b;
import p055ea.AbstractC2460q;

public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {

    @UnstableApi
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;

    @UnstableApi
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesToRead;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private final InterfaceC1354n contentTypePredicate;
    private final boolean crossProtocolRedirectsForceOriginal;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private final boolean keepPostFor302Redirects;
    private final int readTimeoutMillis;
    private final HttpDataSource.RequestProperties requestProperties;
    private int responseCode;
    private boolean transferStarted;
    private final String userAgent;

    public static final class Factory implements HttpDataSource.Factory {
        private boolean allowCrossProtocolRedirects;
        private InterfaceC1354n contentTypePredicate;
        private boolean crossProtocolRedirectsForceOriginal;
        private boolean keepPostFor302Redirects;
        private TransferListener transferListener;
        private String userAgent;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private int connectTimeoutMs = 8000;
        private int readTimeoutMs = 8000;

        @UnstableApi
        public Factory setAllowCrossProtocolRedirects(boolean z7) {
            this.allowCrossProtocolRedirects = z7;
            return this;
        }

        @UnstableApi
        public Factory setConnectTimeoutMs(int i6) {
            this.connectTimeoutMs = i6;
            return this;
        }

        @UnstableApi
        public Factory setContentTypePredicate(InterfaceC1354n interfaceC1354n) {
            this.contentTypePredicate = interfaceC1354n;
            return this;
        }

        @UnstableApi
        public Factory setCrossProtocolRedirectsForceOriginal(boolean z7) {
            this.crossProtocolRedirectsForceOriginal = z7;
            return this;
        }

        @Override
        @UnstableApi
        public HttpDataSource.Factory setDefaultRequestProperties(Map map) {
            return setDefaultRequestProperties((Map<String, String>) map);
        }

        @UnstableApi
        public Factory setKeepPostFor302Redirects(boolean z7) {
            this.keepPostFor302Redirects = z7;
            return this;
        }

        @UnstableApi
        public Factory setReadTimeoutMs(int i6) {
            this.readTimeoutMs = i6;
            return this;
        }

        @UnstableApi
        public Factory setTransferListener(TransferListener transferListener) {
            this.transferListener = transferListener;
            return this;
        }

        @UnstableApi
        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        @Override
        @UnstableApi
        public Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        @Override
        @UnstableApi
        public DefaultHttpDataSource createDataSource() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMs, this.readTimeoutMs, this.allowCrossProtocolRedirects, this.crossProtocolRedirectsForceOriginal, this.defaultRequestProperties, this.contentTypePredicate, this.keepPostFor302Redirects);
            TransferListener transferListener = this.transferListener;
            if (transferListener != null) {
                defaultHttpDataSource.addTransferListener(transferListener);
            }
            return defaultHttpDataSource;
        }
    }

    public static class NullFilteringHeadersMap extends AbstractC2232k1 {
        private final Map<String, List<String>> headers;

        public NullFilteringHeadersMap(Map<String, List<String>> map) {
            this.headers = map;
        }

        public static boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public static boolean lambda$keySet$0(String str) {
            return str != null;
        }

        @Override
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override
        public boolean containsValue(Object obj) {
            return super.standardContainsValue(obj);
        }

        @Override
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return AbstractC2182d0.m5149l(super.entrySet(), new C0649f(0));
        }

        @Override
        public boolean equals(Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override
        public int hashCode() {
            return super.standardHashCode();
        }

        @Override
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override
        public Set<String> keySet() {
            return AbstractC2182d0.m5149l(super.keySet(), new C0649f(1));
        }

        @Override
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override
        public Map<String, List<String>> delegate() {
            return this.headers;
        }

        @Override
        public List<String> get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e5) {
                Log.m1716e(TAG, "Unexpected error while disconnecting", e5);
            }
        }
    }

    private URL handleRedirect(URL url, String str, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException(AbstractC2460q.m5501o("Unsupported protocol redirect: ", protocol), dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
            if (this.allowCrossProtocolRedirects || protocol.equals(url.getProtocol())) {
                return url2;
            }
            if (this.crossProtocolRedirectsForceOriginal) {
                try {
                    return new URL(url2.toString().replaceFirst(protocol, url.getProtocol()));
                } catch (MalformedURLException e5) {
                    throw new HttpDataSource.HttpDataSourceException(e5, dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
                }
            }
            throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
        } catch (MalformedURLException e10) {
            throw new HttpDataSource.HttpDataSourceException(e10, dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
        }
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec) throws IOException {
        URL url = new URL(dataSpec.uri.toString());
        int i6 = dataSpec.httpMethod;
        byte[] bArr = dataSpec.httpBody;
        long j10 = dataSpec.position;
        long j11 = dataSpec.length;
        boolean zIsFlagSet = dataSpec.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects && !this.crossProtocolRedirectsForceOriginal && !this.keepPostFor302Redirects) {
            return makeConnection(url, i6, bArr, j10, j11, zIsFlagSet, true, dataSpec.httpRequestHeaders);
        }
        int i10 = 0;
        URL urlHandleRedirect = url;
        int i11 = i6;
        byte[] bArr2 = bArr;
        while (true) {
            int i12 = i10 + 1;
            if (i10 > 20) {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException(AbstractC0004e.m20n(i12, "Too many redirects: ")), dataSpec, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 1);
            }
            long j12 = j10;
            long j13 = j10;
            int i13 = i11;
            URL url2 = urlHandleRedirect;
            long j14 = j11;
            HttpURLConnection httpURLConnectionMakeConnection = makeConnection(urlHandleRedirect, i11, bArr2, j12, j11, zIsFlagSet, false, dataSpec.httpRequestHeaders);
            int responseCode = httpURLConnectionMakeConnection.getResponseCode();
            String headerField = httpURLConnectionMakeConnection.getHeaderField("Location");
            if ((i13 == 1 || i13 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionMakeConnection.disconnect();
                urlHandleRedirect = handleRedirect(url2, headerField, dataSpec);
                i11 = i13;
            } else {
                if (i13 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionMakeConnection;
                }
                httpURLConnectionMakeConnection.disconnect();
                if (this.keepPostFor302Redirects && responseCode == 302) {
                    i11 = i13;
                } else {
                    bArr2 = null;
                    i11 = 1;
                }
                urlHandleRedirect = handleRedirect(url2, headerField, dataSpec);
            }
            i10 = i12;
            j10 = j13;
            j11 = j14;
        }
    }

    private int readInternal(byte[] bArr, int i6, int i10) throws IOException {
        if (i10 == 0) {
            return 0;
        }
        long j10 = this.bytesToRead;
        if (j10 != -1) {
            long j11 = j10 - this.bytesRead;
            if (j11 == 0) {
                return -1;
            }
            i10 = (int) Math.min(i10, j11);
        }
        int i11 = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i6, i10);
        if (i11 == -1) {
            return -1;
        }
        this.bytesRead += (long) i11;
        bytesTransferred(i11);
        return i11;
    }

    private void skipFully(long j10, DataSpec dataSpec) throws IOException {
        if (j10 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j10 > 0) {
            int i6 = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, 0, (int) Math.min(j10, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), dataSpec, 2000, 1);
            }
            if (i6 == -1) {
                throw new HttpDataSource.HttpDataSourceException(dataSpec, 2008, 1);
            }
            j10 -= (long) i6;
            bytesTransferred(i6);
        }
    }

    @Override
    @UnstableApi
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override
    @UnstableApi
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override
    @UnstableApi
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    throw new HttpDataSource.HttpDataSourceException(e5, (DataSpec) Util.castNonNull(this.dataSpec), 2000, 3);
                }
            }
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.transferStarted) {
                this.transferStarted = false;
                transferEnded();
            }
            this.connection = null;
            this.dataSpec = null;
        } catch (Throwable th) {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.transferStarted) {
                this.transferStarted = false;
                transferEnded();
            }
            this.connection = null;
            this.dataSpec = null;
            throw th;
        }
    }

    @Override
    @UnstableApi
    public int getResponseCode() {
        int i6;
        if (this.connection == null || (i6 = this.responseCode) <= 0) {
            return -1;
        }
        return i6;
    }

    @Override
    @UnstableApi
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        return httpURLConnection == null ? C2215h5.f7927g : new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    @Override
    @UnstableApi
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override
    @UnstableApi
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrM5481b;
        this.dataSpec = dataSpec;
        long j10 = 0;
        this.bytesRead = 0L;
        this.bytesToRead = 0L;
        transferInitializing(dataSpec);
        try {
            HttpURLConnection httpURLConnectionMakeConnection = makeConnection(dataSpec);
            this.connection = httpURLConnectionMakeConnection;
            this.responseCode = httpURLConnectionMakeConnection.getResponseCode();
            String responseMessage = httpURLConnectionMakeConnection.getResponseMessage();
            int i6 = this.responseCode;
            if (i6 < 200 || i6 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionMakeConnection.getHeaderFields();
                if (this.responseCode == 416) {
                    if (dataSpec.position == HttpUtil.getDocumentSize(httpURLConnectionMakeConnection.getHeaderField(HttpHeaders.HEAD_KEY_CONTENT_RANGE))) {
                        this.transferStarted = true;
                        transferStarted(dataSpec);
                        long j11 = dataSpec.length;
                        if (j11 != -1) {
                            return j11;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionMakeConnection.getErrorStream();
                try {
                    bArrM5481b = errorStream != null ? AbstractC2425b.m5481b(errorStream) : Util.EMPTY_BYTE_ARRAY;
                } catch (IOException unused) {
                    bArrM5481b = Util.EMPTY_BYTE_ARRAY;
                }
                byte[] bArr = bArrM5481b;
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidResponseCodeException(this.responseCode, responseMessage, this.responseCode == 416 ? new DataSourceException(2008) : null, headerFields, dataSpec, bArr);
            }
            String contentType = httpURLConnectionMakeConnection.getContentType();
            InterfaceC1354n interfaceC1354n = this.contentTypePredicate;
            if (interfaceC1354n != null && !interfaceC1354n.apply(contentType)) {
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
            }
            if (this.responseCode == 200) {
                long j12 = dataSpec.position;
                if (j12 != 0) {
                    j10 = j12;
                }
            }
            boolean zIsCompressed = isCompressed(httpURLConnectionMakeConnection);
            if (zIsCompressed) {
                this.bytesToRead = dataSpec.length;
            } else {
                long j13 = dataSpec.length;
                if (j13 != -1) {
                    this.bytesToRead = j13;
                } else {
                    long contentLength = HttpUtil.getContentLength(httpURLConnectionMakeConnection.getHeaderField("Content-Length"), httpURLConnectionMakeConnection.getHeaderField(HttpHeaders.HEAD_KEY_CONTENT_RANGE));
                    this.bytesToRead = contentLength != -1 ? contentLength - j10 : -1L;
                }
            }
            try {
                this.inputStream = httpURLConnectionMakeConnection.getInputStream();
                if (zIsCompressed) {
                    this.inputStream = new GZIPInputStream(this.inputStream);
                }
                this.transferStarted = true;
                transferStarted(dataSpec);
                try {
                    skipFully(j10, dataSpec);
                    return this.bytesToRead;
                } catch (IOException e5) {
                    closeConnectionQuietly();
                    if (e5 instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e5);
                    }
                    throw new HttpDataSource.HttpDataSourceException(e5, dataSpec, 2000, 1);
                }
            } catch (IOException e10) {
                closeConnectionQuietly();
                throw new HttpDataSource.HttpDataSourceException(e10, dataSpec, 2000, 1);
            }
        } catch (IOException e11) {
            closeConnectionQuietly();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e11, dataSpec, 1);
        }
    }

    public HttpURLConnection openConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @Override
    @UnstableApi
    public int read(byte[] bArr, int i6, int i10) throws HttpDataSource.HttpDataSourceException {
        try {
            return readInternal(bArr, i6, i10);
        } catch (IOException e5) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e5, (DataSpec) Util.castNonNull(this.dataSpec), 2);
        }
    }

    @Override
    @UnstableApi
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    private DefaultHttpDataSource(String str, int i6, int i10, boolean z7, boolean z10, HttpDataSource.RequestProperties requestProperties, InterfaceC1354n interfaceC1354n, boolean z11) {
        super(true);
        this.userAgent = str;
        this.connectTimeoutMillis = i6;
        this.readTimeoutMillis = i10;
        this.allowCrossProtocolRedirects = z7;
        this.crossProtocolRedirectsForceOriginal = z10;
        if (z7 && z10) {
            throw new IllegalArgumentException("crossProtocolRedirectsForceOriginal should not be set if allowCrossProtocolRedirects is true");
        }
        this.defaultRequestProperties = requestProperties;
        this.contentTypePredicate = interfaceC1354n;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.keepPostFor302Redirects = z11;
    }

    private HttpURLConnection makeConnection(URL url, int i6, byte[] bArr, long j10, long j11, boolean z7, boolean z10, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionOpenConnection = openConnection(url);
        httpURLConnectionOpenConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnectionOpenConnection.setReadTimeout(this.readTimeoutMillis);
        HashMap map2 = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            map2.putAll(requestProperties.getSnapshot());
        }
        map2.putAll(this.requestProperties.getSnapshot());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionOpenConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strBuildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j10, j11);
        if (strBuildRangeRequestHeader != null) {
            httpURLConnectionOpenConnection.setRequestProperty("Range", strBuildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            httpURLConnectionOpenConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, z7 ? "gzip" : "identity");
        httpURLConnectionOpenConnection.setInstanceFollowRedirects(z10);
        httpURLConnectionOpenConnection.setDoOutput(bArr != null);
        httpURLConnectionOpenConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i6));
        if (bArr != null) {
            httpURLConnectionOpenConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionOpenConnection.connect();
            OutputStream outputStream = httpURLConnectionOpenConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionOpenConnection.connect();
        }
        return httpURLConnectionOpenConnection;
    }
}
