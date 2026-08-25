package androidx.media3.exoplayer.analytics;

import android.content.ClipData;
import android.media.AudioProfile;
import android.media.MediaDrm;
import android.view.ContentInfo;

public abstract class AbstractC0685b0 {
    public static AudioProfile m2090f(Object obj) {
        return (AudioProfile) obj;
    }

    public static MediaDrm.PlaybackComponent m2092h(Object obj) {
        return (MediaDrm.PlaybackComponent) obj;
    }

    public static ContentInfo.Builder m2095k(ClipData clipData, int i6) {
        return new ContentInfo.Builder(clipData, i6);
    }

    public static ContentInfo m2097m(Object obj) {
        return (ContentInfo) obj;
    }
}
