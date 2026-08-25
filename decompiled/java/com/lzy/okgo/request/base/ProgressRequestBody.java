package com.lzy.okgo.request.base;

import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.utils.HttpUtils;
import com.lzy.okgo.utils.OkLogger;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody<T> extends RequestBody {
    private Callback<T> callback;
    private UploadInterceptor interceptor;
    private RequestBody requestBody;

    public final class CountingSink extends ForwardingSink {
        private Progress progress;

        public CountingSink(Sink sink) {
            super(sink);
            Progress progress = new Progress();
            this.progress = progress;
            progress.totalSize = ProgressRequestBody.this.contentLength();
        }

        @Override
        public void write(Buffer buffer, long j10) throws IOException {
            super.write(buffer, j10);
            Progress.changeProgress(this.progress, j10, new Progress.Action() {
                @Override
                public void call(Progress progress) {
                    if (ProgressRequestBody.this.interceptor != null) {
                        ProgressRequestBody.this.interceptor.uploadProgress(progress);
                    } else {
                        ProgressRequestBody.this.onProgress(progress);
                    }
                }
            });
        }
    }

    public interface UploadInterceptor {
        void uploadProgress(Progress progress);
    }

    public ProgressRequestBody(RequestBody requestBody, Callback<T> callback) {
        this.requestBody = requestBody;
        this.callback = callback;
    }

    public void onProgress(final Progress progress) {
        HttpUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (ProgressRequestBody.this.callback != null) {
                    ProgressRequestBody.this.callback.uploadProgress(progress);
                }
            }
        });
    }

    @Override
    public long contentLength() {
        try {
            return this.requestBody.contentLength();
        } catch (IOException e5) {
            OkLogger.printStackTrace(e5);
            return -1L;
        }
    }

    @Override
    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public void setInterceptor(UploadInterceptor uploadInterceptor) {
        this.interceptor = uploadInterceptor;
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink bufferedSinkBuffer = Okio.buffer(new CountingSink(bufferedSink));
        this.requestBody.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }
}
