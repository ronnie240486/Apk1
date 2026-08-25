package p001a0;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.session.MediaSession;
import android.os.Bundle;

public abstract class AbstractC0018a {
    public static MediaCodecInfo.VideoCapabilities.PerformancePoint m58b(int i6, int i10, int i11) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(i6, i10, i11);
    }

    public static MediaCodecInfo.VideoCapabilities.PerformancePoint m59c(Object obj) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    public static MediaSession m60d(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str, bundle);
    }

    public static void m65i() {
    }
}
