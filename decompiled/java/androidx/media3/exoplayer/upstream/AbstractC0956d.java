package androidx.media3.exoplayer.upstream;

import androidx.media3.common.MediaItem;
import java.util.UUID;
import p041d7.C2313w1;

public abstract class AbstractC0956d {
    public static CmcdConfiguration m2594a(MediaItem mediaItem) {
        String string = UUID.randomUUID().toString();
        String str = mediaItem.mediaId;
        if (str == null) {
            str = "";
        }
        return new CmcdConfiguration(string, str, new CmcdConfiguration.RequestConfig() {
            @Override
            public final C2313w1 getCustomData() {
                return AbstractC0957e.m2595a(this);
            }

            @Override
            public final int getRequestedMaximumThroughputKbps(int i6) {
                return AbstractC0957e.m2596b(this, i6);
            }

            @Override
            public final boolean isKeyAllowed(String str2) {
                return AbstractC0957e.m2597c(this, str2);
            }
        });
    }
}
