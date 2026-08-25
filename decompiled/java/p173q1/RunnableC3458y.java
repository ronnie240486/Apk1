package p173q1;

import android.media.AudioTrack;
import android.os.Handler;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import java.util.ArrayList;

public final class RunnableC3458y implements Runnable {

    public final int f11713a;

    public final Object f11714b;

    public final Object f11715c;

    public final Object f11716d;

    public final Object f11717e;

    public RunnableC3458y(Object obj, Object obj2, Object obj3, Object obj4, int i6) {
        this.f11713a = i6;
        this.f11714b = obj;
        this.f11715c = obj2;
        this.f11716d = obj3;
        this.f11717e = obj4;
    }

    @Override
    public final void run() {
        switch (this.f11713a) {
            case 0:
                AbstractC3394b0 abstractC3394b0 = (AbstractC3394b0) this.f11714b;
                abstractC3394b0.getClass();
                ((InterfaceC3391a0) this.f11715c).mo1737c(abstractC3394b0, (C3454w) this.f11716d, (ArrayList) this.f11717e);
                break;
            case 1:
                AbstractC3394b0 abstractC3394b1 = (AbstractC3394b0) this.f11714b;
                abstractC3394b1.getClass();
                ((InterfaceC3391a0) this.f11715c).mo1737c(abstractC3394b1, (C3454w) this.f11716d, (ArrayList) this.f11717e);
                break;
            default:
                DefaultAudioSink.lambda$releaseAudioTrackAsync$1((AudioTrack) this.f11714b, (AudioSink.Listener) this.f11715c, (Handler) this.f11716d, (AudioSink.AudioTrackConfig) this.f11717e);
                break;
        }
    }
}
