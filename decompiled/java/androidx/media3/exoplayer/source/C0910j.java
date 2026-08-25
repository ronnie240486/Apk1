package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Consumer;

public final class C0910j implements Consumer {

    public final int f2986a;

    public final MediaSourceEventListener.EventDispatcher f2987b;

    public final LoadEventInfo f2988c;

    public final MediaLoadData f2989d;

    public C0910j(MediaSourceEventListener.EventDispatcher eventDispatcher, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i6) {
        this.f2986a = i6;
        this.f2987b = eventDispatcher;
        this.f2988c = loadEventInfo;
        this.f2989d = mediaLoadData;
    }

    @Override
    public final void accept(Object obj) {
        MediaSourceEventListener mediaSourceEventListener = (MediaSourceEventListener) obj;
        switch (this.f2986a) {
            case 0:
                this.f2987b.lambda$loadCompleted$1(this.f2988c, this.f2989d, mediaSourceEventListener);
                break;
            default:
                this.f2987b.lambda$loadCanceled$2(this.f2988c, this.f2989d, mediaSourceEventListener);
                break;
        }
    }
}
