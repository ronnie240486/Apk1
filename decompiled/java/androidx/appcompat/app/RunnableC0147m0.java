package androidx.appcompat.app;

import android.app.job.JobParameters;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.AbstractC0540o0;
import androidx.lifecycle.C0545r;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.p011ui.PlayerView;
import androidx.mediarouter.media.MediaRouteProviderService;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Random;
import p003a2.AbstractC0032a;
import p046e0.AbstractC2343b;
import p128m0.InterfaceC3025a;
import p173q1.C3409g0;
import p207t1.AbstractC3795g;
import p213t9.AbstractC3819b0;
import p213t9.AbstractC3865u;
import qa.C3558f;
import qa.C3559g;

public final class RunnableC0147m0 implements Runnable {

    public final int f406a;

    public final Object f407b;

    public final Object f408c;

    public RunnableC0147m0(Object obj, int i6, Object obj2) {
        this.f406a = i6;
        this.f407b = obj;
        this.f408c = obj2;
    }

    @Override
    public final void run() {
        C0157r0 c0157r0;
        int i6 = 1;
        Object obj = this.f408c;
        Object obj2 = this.f407b;
        switch (this.f406a) {
            case 0:
                Runnable runnable = (Runnable) obj;
                ExecutorC0149n0 executorC0149n0 = (ExecutorC0149n0) obj2;
                executorC0149n0.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    executorC0149n0.m432a();
                }
            case 1:
                ((SimpleBasePlayer) obj2).lambda$updateStateForPendingOperation$62((ListenableFuture) obj);
                return;
            case 2:
                AudioManagerCompat.lambda$getAudioManager$0((Context) obj2, (ConditionVariable) obj);
                return;
            case 3:
                ((MediaMetricsListener) obj2).lambda$reportTrackChangeEvent$3((TrackChangeEvent) obj);
                return;
            case 4:
                ((MediaMetricsListener) obj2).lambda$maybeReportNetworkChange$1((NetworkEvent) obj);
                return;
            case 5:
                ((MediaMetricsListener) obj2).lambda$maybeReportPlaybackError$0((PlaybackErrorEvent) obj);
                return;
            case 6:
                ((MediaMetricsListener) obj2).lambda$finishCurrentSession$4((PlaybackMetrics) obj);
                return;
            case 7:
                ((MediaMetricsListener) obj2).lambda$maybeReportPlaybackStateChange$2((PlaybackStateEvent) obj);
                return;
            case 8:
                ((AudioRendererEventListener.EventDispatcher) obj2).lambda$decoderReleased$5((String) obj);
                return;
            case 9:
                ((AudioSink.Listener) obj2).onAudioTrackReleased((AudioSink.AudioTrackConfig) obj);
                return;
            case 10:
                ((SphericalGLSurfaceView) obj2).lambda$onSurfaceTextureAvailable$1((SurfaceTexture) obj);
                return;
            case 11:
                ((PlayerView) obj2).lambda$onImageAvailable$1((Bitmap) obj);
                return;
            case 12:
                ((AbstractC2343b) obj2).mo758j((Typeface) obj);
                return;
            case 13:
                int i10 = JobInfoSchedulerService.f4537a;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                return;
            case 14:
                C3409g0 c3409g0 = (C3409g0) obj2;
                if (c3409g0.f11478k.remove((String) obj) == null || (c0157r0 = c3409g0.f11479l.f11538a.f3441d.f11456g) == null) {
                    return;
                }
                MediaRouteProviderService.m2806e(c3409g0.f11528a, 5, 0, 0, c3409g0.mo6928a(c0157r0), null);
                return;
            case 15:
                ((InterfaceC3025a) obj2).accept((ArrayList) obj);
                return;
            case 16:
                C3559g c3559g = (C3559g) obj2;
                C0545r c0545rM1506d = AbstractC0540o0.m1506d(c3559g.f11971a);
                C3558f c3558f = new C3558f(c3559g, (String) obj, null);
                AbstractC0032a.m165s("NnbQ7Yev\n", "CgK4hPSRgv0=\n");
                AbstractC0032a.m165s("Ufl4BV8=\n", "M5UXZjTWEL0=\n");
                AbstractC3865u.m7696k(c0545rM1506d, AbstractC3819b0.f12902b, c3558f, 2);
                return;
            default:
                ((ProfileInstallerInitializer) obj2).getClass();
                (Build.VERSION.SDK_INT >= 28 ? AbstractC3795g.m7564a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new RunnableC0148n((Context) obj, i6), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
        }
    }
}
