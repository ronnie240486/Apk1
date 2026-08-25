package p173q1;

import android.media.MediaRouter2;
import java.util.List;

public final class C3429n extends MediaRouter2.RouteCallback {

    public final int f11590a;

    public final C3435p f11591b;

    public C3429n(C3435p c3435p, int i6) {
        this.f11590a = i6;
        this.f11591b = c3435p;
    }

    @Override
    public void onRoutesAdded(List list) {
        switch (this.f11590a) {
            case 0:
                this.f11591b.m7011i();
                break;
            default:
                super.onRoutesAdded(list);
                break;
        }
    }

    @Override
    public void onRoutesChanged(List list) {
        switch (this.f11590a) {
            case 0:
                this.f11591b.m7011i();
                break;
            default:
                super.onRoutesChanged(list);
                break;
        }
    }

    @Override
    public void onRoutesRemoved(List list) {
        switch (this.f11590a) {
            case 0:
                this.f11591b.m7011i();
                break;
            default:
                super.onRoutesRemoved(list);
                break;
        }
    }

    @Override
    public void onRoutesUpdated(List list) {
        switch (this.f11590a) {
            case 1:
                this.f11591b.m7011i();
                break;
            default:
                super.onRoutesUpdated(list);
                break;
        }
    }
}
