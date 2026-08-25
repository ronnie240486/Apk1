package okhttp3.internal.http;

import com.lzy.okgo.model.Progress;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import p103j9.AbstractC2796i;

public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i6, Exchange exchange, Request request, int i10, int i11, int i12) {
        AbstractC2796i.m5785f(realCall, "call");
        AbstractC2796i.m5785f(list, "interceptors");
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        this.call = realCall;
        this.interceptors = list;
        this.index = i6;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i10;
        this.readTimeoutMillis = i11;
        this.writeTimeoutMillis = i12;
    }

    public static RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i6, Exchange exchange, Request request, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i6 = realInterceptorChain.index;
        }
        if ((i13 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((i13 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        if ((i13 & 8) != 0) {
            i10 = realInterceptorChain.connectTimeoutMillis;
        }
        int i14 = i10;
        if ((i13 & 16) != 0) {
            i11 = realInterceptorChain.readTimeoutMillis;
        }
        int i15 = i11;
        if ((i13 & 32) != 0) {
            i12 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i6, exchange2, request2, i14, i15, i12);
    }

    @Override
    public Call call() {
        return this.call;
    }

    @Override
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i6, Exchange exchange, Request request, int i10, int i11, int i12) {
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        return new RealInterceptorChain(this.call, this.interceptors, i6, exchange, request, i10, i11, i12);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override
    public Response proceed(Request request) throws IOException {
        AbstractC2796i.m5785f(request, Progress.REQUEST);
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder$okhttp().sameHostAndPort(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange != null && this.index + 1 < this.interceptors.size() && realInterceptorChainCopy$okhttp$default.calls != 1) {
            throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override
    public Request request() {
        return this.request;
    }

    @Override
    public Interceptor.Chain withConnectTimeout(int i6, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", i6, timeUnit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override
    public Interceptor.Chain withReadTimeout(int i6, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", i6, timeUnit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override
    public Interceptor.Chain withWriteTimeout(int i6, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", i6, timeUnit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
