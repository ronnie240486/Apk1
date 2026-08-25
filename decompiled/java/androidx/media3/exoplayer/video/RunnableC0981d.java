package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;

public final class RunnableC0981d implements Runnable {

    public final int f3047a;

    public final Object f3048b;

    public final Object f3049c;

    public RunnableC0981d(Object obj, int i6, Object obj2) {
        this.f3047a = i6;
        this.f3049c = obj;
        this.f3048b = obj2;
    }

    @Override
    public final void run() {
        switch (this.f3047a) {
            case 0:
                ((DefaultVideoSink.FrameRendererImpl) this.f3049c).lambda$onVideoSizeChanged$0((VideoSize) this.f3048b);
                break;
            case 1:
                ((VideoRendererEventListener.EventDispatcher) this.f3049c).lambda$videoSizeChanged$5((VideoSize) this.f3048b);
                break;
            case 2:
                ((VideoRendererEventListener.EventDispatcher) this.f3049c).lambda$videoCodecError$9((Exception) this.f3048b);
                break;
            default:
                ((VideoRendererEventListener.EventDispatcher) this.f3049c).lambda$decoderReleased$7((String) this.f3048b);
                break;
        }
    }
}
