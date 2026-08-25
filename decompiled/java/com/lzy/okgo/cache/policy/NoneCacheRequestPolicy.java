package com.lzy.okgo.cache.policy;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

public class NoneCacheRequestPolicy<T> extends BaseCachePolicy<T> {
    public NoneCacheRequestPolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override
    public void onError(final Response<T> response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NoneCacheRequestPolicy.this.mCallback.onError(response);
                NoneCacheRequestPolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NoneCacheRequestPolicy.this.mCallback.onSuccess(response);
                NoneCacheRequestPolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override
    public void requestAsync(final CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NoneCacheRequestPolicy noneCacheRequestPolicy = NoneCacheRequestPolicy.this;
                noneCacheRequestPolicy.mCallback.onStart(noneCacheRequestPolicy.request);
                try {
                    NoneCacheRequestPolicy.this.prepareRawCall();
                    CacheEntity cacheEntity2 = cacheEntity;
                    if (cacheEntity2 == null) {
                        NoneCacheRequestPolicy.this.requestNetworkAsync();
                        return;
                    }
                    NoneCacheRequestPolicy.this.mCallback.onCacheSuccess(Response.success(true, cacheEntity2.getData(), NoneCacheRequestPolicy.this.rawCall, null));
                    NoneCacheRequestPolicy.this.mCallback.onFinish();
                } catch (Throwable th) {
                    NoneCacheRequestPolicy.this.mCallback.onError(Response.error(false, NoneCacheRequestPolicy.this.rawCall, null, th));
                }
            }
        });
    }

    @Override
    public Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            Response<T> responseSuccess = cacheEntity != null ? Response.success(true, cacheEntity.getData(), this.rawCall, null) : null;
            return responseSuccess == null ? requestNetworkSync() : responseSuccess;
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
