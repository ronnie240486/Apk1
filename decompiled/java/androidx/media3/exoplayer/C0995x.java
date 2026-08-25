package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final class C0995x implements ListenerSet.Event {

    public final int f3074a;

    public final boolean f3075b;

    public C0995x(boolean z7, int i6) {
        this.f3074a = i6;
        this.f3075b = z7;
    }

    @Override
    public final void invoke(Object obj) {
        switch (this.f3074a) {
            case 0:
                ((Player.Listener) obj).onSkipSilenceEnabledChanged(this.f3075b);
                break;
            case 1:
                ((Player.Listener) obj).onShuffleModeEnabledChanged(this.f3075b);
                break;
            default:
                ((Player.Listener) obj).onSkipSilenceEnabledChanged(this.f3075b);
                break;
        }
    }
}
