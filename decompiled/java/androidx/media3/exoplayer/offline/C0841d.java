package androidx.media3.exoplayer.offline;

import android.os.Handler;
import android.os.Message;

public final class C0841d implements Handler.Callback {

    public final int f2918a;

    public final Object f2919b;

    public C0841d(int i6, Object obj) {
        this.f2918a = i6;
        this.f2919b = obj;
    }

    @Override
    public final boolean handleMessage(Message message) {
        switch (this.f2918a) {
            case 0:
                return ((DownloadHelper.MediaPreparer) this.f2919b).handleDownloadHelperCallbackMessage(message);
            default:
                return ((DownloadManager) this.f2919b).handleMainMessage(message);
        }
    }
}
