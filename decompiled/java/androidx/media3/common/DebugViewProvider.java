package androidx.media3.common;

import android.view.SurfaceView;
import androidx.media3.common.util.UnstableApi;
import p005a4.C0060s;

@UnstableApi
public interface DebugViewProvider {
    public static final DebugViewProvider NONE = new C0060s(1);

    SurfaceView getDebugPreviewSurfaceView(int i6, int i10);
}
