package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okio.Timeout;

final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    private final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        public class C36651 implements Callback<T> {
            final Callback val$callback;

            public C36651(Callback callback) {
                this.val$callback = callback;
            }

            public void lambda$onFailure$1(Callback callback, Throwable th) {
                callback.onFailure(ExecutorCallbackCall.this, th);
            }

            public void lambda$onResponse$0(Callback callback, Response response) {
                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.onResponse(ExecutorCallbackCall.this, response);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable th) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new RunnableC3676a(this, this.val$callback, th, 1));
            }

            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new RunnableC3676a(this, this.val$callback, response, 0));
            }
        }

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override
        public void cancel() {
            this.delegate.cancel();
        }

        @Override
        public void enqueue(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new C36651(callback));
        }

        @Override
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override
        public Request request() {
            return this.delegate.request();
        }

        @Override
        public Timeout timeout() {
            return this.delegate.timeout();
        }

        @Override
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
        final Executor executor = Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class) ? null : this.callbackExecutor;
        return new CallAdapter<Object, Call<?>>() {
            @Override
            public Type responseType() {
                return parameterUpperBound;
            }

            @Override
            public Call<?> adapt(Call<Object> call) {
                Executor executor2 = executor;
                return executor2 == null ? call : new ExecutorCallbackCall(executor2, call);
            }
        };
    }
}
