package androidx.media3.common;

import android.util.Pair;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public interface VideoCompositorSettings {
    public static final VideoCompositorSettings DEFAULT = new VideoCompositorSettings() {
        @Override
        public Size getOutputSize(List<Size> list) {
            return list.get(0);
        }

        @Override
        public OverlaySettings getOverlaySettings(int i6, long j10) {
            return new OverlaySettings() {
                @Override
                public final float getAlphaScale() {
                    return AbstractC0601j.m1665a(this);
                }

                @Override
                public final Pair getBackgroundFrameAnchor() {
                    return AbstractC0601j.m1666b(this);
                }

                @Override
                public final float getHdrLuminanceMultiplier() {
                    return AbstractC0601j.m1667c(this);
                }

                @Override
                public final Pair getOverlayFrameAnchor() {
                    return AbstractC0601j.m1668d(this);
                }

                @Override
                public final float getRotationDegrees() {
                    return AbstractC0601j.m1669e(this);
                }

                @Override
                public final Pair getScale() {
                    return AbstractC0601j.m1670f(this);
                }
            };
        }
    };

    Size getOutputSize(List<Size> list);

    OverlaySettings getOverlaySettings(int i6, long j10);
}
