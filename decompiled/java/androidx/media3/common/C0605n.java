package androidx.media3.common;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import p005a4.C0051j;
import p077h4.C2659i;
import p098j4.InterfaceC2775b;

public final class C0605n implements ListenerSet.Event, InterfaceC2775b {

    public final int f2610a;

    public final int f2611b;

    public final Object f2612c;

    public final Object f2613d;

    public C0605n(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
        this.f2610a = 0;
        this.f2611b = i6;
        this.f2612c = positionInfo;
        this.f2613d = positionInfo2;
    }

    @Override
    public Object execute() {
        ((C2659i) this.f2612c).f9280d.m5668a((C0051j) this.f2613d, this.f2611b + 1, false);
        return null;
    }

    @Override
    public void invoke(Object obj) {
        switch (this.f2610a) {
            case 0:
                SimpleBasePlayer.lambda$updateStateAndInformListeners$33(this.f2611b, (Player.PositionInfo) this.f2612c, (Player.PositionInfo) this.f2613d, (Player.Listener) obj);
                break;
            default:
                ((AnalyticsListener) obj).onMediaItemTransition((AnalyticsListener.EventTime) this.f2612c, (MediaItem) this.f2613d, this.f2611b);
                break;
        }
    }

    public C0605n(Object obj, Object obj2, int i6, int i10) {
        this.f2610a = i10;
        this.f2612c = obj;
        this.f2613d = obj2;
        this.f2611b = i6;
    }
}
