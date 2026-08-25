package com.lzy.okgo.cache.policy;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

public class RequestFailedCachePolicy<T> extends BaseCachePolicy<T> {
    public RequestFailedCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override
    public void onError(final Response<T> response) {
        CacheEntity<T> cacheEntity = this.cacheEntity;
        if (cacheEntity == null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    RequestFailedCachePolicy.this.mCallback.onError(response);
                    RequestFailedCachePolicy.this.mCallback.onFinish();
                }
            });
        } else {
            final Response responseSuccess = Response.success(true, cacheEntity.getData(), response.getRawCall(), response.getRawResponse());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    RequestFailedCachePolicy.this.mCallback.onCacheSuccess(responseSuccess);
                    RequestFailedCachePolicy.this.mCallback.onFinish();
                }
            });
        }
    }

    @Override
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RequestFailedCachePolicy.this.mCallback.onSuccess(response);
                RequestFailedCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RequestFailedCachePolicy requestFailedCachePolicy = RequestFailedCachePolicy.this;
                requestFailedCachePolicy.mCallback.onStart(requestFailedCachePolicy.request);
                try {
                    RequestFailedCachePolicy.this.prepareRawCall();
                    RequestFailedCachePolicy.this.requestNetworkAsync();
                } catch (Throwable th) {
                    RequestFailedCachePolicy.this.mCallback.onError(Response.error(false, RequestFailedCachePolicy.this.rawCall, null, th));
                }
            }
        });
    }

    @Override
    public Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            Response<T> responseRequestNetworkSync = requestNetworkSync();
            return (responseRequestNetworkSync.isSuccessful() || cacheEntity == null) ? responseRequestNetworkSync : Response.success(true, cacheEntity.getData(), this.rawCall, responseRequestNetworkSync.getRawResponse());
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
