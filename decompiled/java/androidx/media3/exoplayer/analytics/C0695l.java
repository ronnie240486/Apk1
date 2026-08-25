package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;

public final class C0695l implements ListenerSet.Event, Consumer {

    public final LoadEventInfo f2716a;

    public final MediaLoadData f2717b;

    public final IOException f2718c;

    public final boolean f2719d;

    public final Object f2720e;

    public C0695l(Object obj, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z7) {
        this.f2720e = obj;
        this.f2716a = loadEventInfo;
        this.f2717b = mediaLoadData;
        this.f2718c = iOException;
        this.f2719d = z7;
    }

    @Override
    public void accept(Object obj) {
        MediaLoadData mediaLoadData = this.f2717b;
        IOException iOException = this.f2718c;
        ((MediaSourceEventListener.EventDispatcher) this.f2720e).lambda$loadError$3(this.f2716a, mediaLoadData, iOException, this.f2719d, (MediaSourceEventListener) obj);
    }

    @Override
    public void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadError((AnalyticsListener.EventTime) this.f2720e, this.f2716a, this.f2717b, this.f2718c, this.f2719d);
    }
}
