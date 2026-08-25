package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final class C0735c0 implements ListenerSet.Event {

    public final int f2802a;

    public final int f2803b;

    public C0735c0(int i6, int i10) {
        this.f2802a = i10;
        this.f2803b = i6;
    }

    @Override
    public final void invoke(Object obj) {
        switch (this.f2802a) {
            case 0:
                ((Player.Listener) obj).onRepeatModeChanged(this.f2803b);
                break;
            default:
                ((Player.Listener) obj).onAudioSessionIdChanged(this.f2803b);
                break;
        }
    }
}
