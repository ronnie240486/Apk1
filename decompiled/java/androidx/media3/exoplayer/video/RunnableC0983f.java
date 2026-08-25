package androidx.media3.exoplayer.video;

import androidx.media3.common.Format;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.DecoderReuseEvaluation;

public final class RunnableC0983f implements Runnable {

    public final int f3051a;

    public final Object f3052b;

    public final Object f3053c;

    public final Object f3054d;

    public RunnableC0983f(Object obj, Object obj2, Object obj3, int i6) {
        this.f3051a = i6;
        this.f3052b = obj;
        this.f3053c = obj2;
        this.f3054d = obj3;
    }

    @Override
    public final void run() {
        switch (this.f3051a) {
            case 0:
                ((PlaybackVideoGraphWrapper.InputVideoSink) this.f3052b).lambda$onVideoSizeChanged$2((VideoSink.Listener) this.f3053c, (VideoSize) this.f3054d);
                break;
            case 1:
                ((PlaybackVideoGraphWrapper.InputVideoSink) this.f3052b).lambda$onError$3((VideoSink.Listener) this.f3053c, (VideoFrameProcessingException) this.f3054d);
                break;
            default:
                ((VideoRendererEventListener.EventDispatcher) this.f3052b).lambda$inputFormatChanged$2((Format) this.f3053c, (DecoderReuseEvaluation) this.f3054d);
                break;
        }
    }
}
