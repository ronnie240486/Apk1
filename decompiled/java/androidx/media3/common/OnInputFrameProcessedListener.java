package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface OnInputFrameProcessedListener {
    void onInputFrameProcessed(int i6, long j10) throws VideoFrameProcessingException;
}
