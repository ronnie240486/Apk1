package com.lzy.okgo.cache.policy;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

public class NoCachePolicy<T> extends BaseCachePolicy<T> {
    public NoCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override
    public void onError(final Response<T> response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NoCachePolicy.this.mCallback.onError(response);
                NoCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NoCachePolicy.this.mCallback.onSuccess(response);
                NoCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NoCachePolicy noCachePolicy = NoCachePolicy.this;
                noCachePolicy.mCallback.onStart(noCachePolicy.request);
                try {
                    NoCachePolicy.this.prepareRawCall();
                    NoCachePolicy.this.requestNetworkAsync();
                } catch (Throwable th) {
                    NoCachePolicy.this.mCallback.onError(Response.error(false, NoCachePolicy.this.rawCall, null, th));
                }
            }
        });
    }

    @Override
    public Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            return requestNetworkSync();
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
