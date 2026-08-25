package p219u4;

import android.os.Looper;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.TimerTask;
import p004a3.RunnableC0038c;
import p187r4.C3616f;

public final class C3896d extends TimerTask {

    public final C3616f f13095a;

    public final ExpandedControllerActivity f13096b;

    public C3896d(ExpandedControllerActivity expandedControllerActivity, C3616f c3616f) {
        this.f13095a = c3616f;
        this.f13096b = expandedControllerActivity;
    }

    @Override
    public final void run() {
        new HandlerC1731y0(Looper.getMainLooper(), 0).post(new RunnableC0038c(this, 29, this.f13095a));
    }
}
