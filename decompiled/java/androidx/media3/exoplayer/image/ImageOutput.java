package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface ImageOutput {
    public static final ImageOutput NO_OP = new ImageOutput() {
        @Override
        public void onDisabled() {
        }

        @Override
        public void onImageAvailable(long j10, Bitmap bitmap) {
        }
    };

    void onDisabled();

    void onImageAvailable(long j10, Bitmap bitmap);
}
