package androidx.media3.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.RouteDiscoveryPreference;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.AbstractC0107a;
import androidx.media3.common.AbstractC0590d;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundThreadStateHandler;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

final class DefaultSuitableOutputChecker implements SuitableOutputChecker {
    private final SuitableOutputChecker impl;

    public static final class ImplApi23 implements SuitableOutputChecker {
        private AudioDeviceCallback audioDeviceCallback;
        private AudioManager audioManager;
        private BackgroundThreadStateHandler<Boolean> isSuitableForPlaybackState;

        private ImplApi23() {
        }

        public boolean hasSupportedAudioOutput() {
            for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) Assertions.checkStateNotNull(this.audioManager)).getDevices(2)) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i6 = Util.SDK_INT;
                if (i6 >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i6 >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i6 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i6 >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }

        public void lambda$disable$2() {
            AudioManager audioManager = this.audioManager;
            if (audioManager != null) {
                audioManager.unregisterAudioDeviceCallback(AbstractC0107a.m269h(Assertions.checkNotNull(this.audioDeviceCallback)));
            }
        }

        public static void lambda$enable$0(SuitableOutputChecker.Callback callback, Boolean bool, Boolean bool2) {
            callback.onSelectedOutputSuitabilityChanged(bool2.booleanValue());
        }

        public void lambda$enable$1(Context context) {
            AudioManager audioManager;
            Assertions.checkNotNull(this.isSuitableForPlaybackState);
            if (Util.isWear(context) && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
                this.audioManager = audioManager;
                AudioDeviceCallback audioDeviceCallback = new AudioDeviceCallback() {
                    @Override
                    public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                        ImplApi23.this.isSuitableForPlaybackState.setStateInBackground(Boolean.valueOf(ImplApi23.this.hasSupportedAudioOutput()));
                    }

                    @Override
                    public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                        ImplApi23.this.isSuitableForPlaybackState.setStateInBackground(Boolean.valueOf(ImplApi23.this.hasSupportedAudioOutput()));
                    }
                };
                this.audioDeviceCallback = audioDeviceCallback;
                audioManager.registerAudioDeviceCallback(audioDeviceCallback, new Handler((Looper) Assertions.checkNotNull(Looper.myLooper())));
                this.isSuitableForPlaybackState.setStateInBackground(Boolean.valueOf(hasSupportedAudioOutput()));
            }
        }

        @Override
        public void disable() {
            ((BackgroundThreadStateHandler) Assertions.checkNotNull(this.isSuitableForPlaybackState)).runInBackground(new RunnableC0731b(1, this));
        }

        @Override
        public void enable(SuitableOutputChecker.Callback callback, Context context, Looper looper, Looper looper2, Clock clock) {
            BackgroundThreadStateHandler<Boolean> backgroundThreadStateHandler = new BackgroundThreadStateHandler<>(Boolean.TRUE, looper2, looper, clock, new C0763g(callback, 0));
            this.isSuitableForPlaybackState = backgroundThreadStateHandler;
            backgroundThreadStateHandler.runInBackground(new RunnableC0765h(this, 0, context));
        }

        @Override
        public boolean isSelectedOutputSuitableForPlayback() {
            BackgroundThreadStateHandler<Boolean> backgroundThreadStateHandler = this.isSuitableForPlaybackState;
            if (backgroundThreadStateHandler == null) {
                return true;
            }
            return backgroundThreadStateHandler.get().booleanValue();
        }
    }

    public static final class ImplApi35 implements SuitableOutputChecker {
        private static final RouteDiscoveryPreference EMPTY_DISCOVERY_PREFERENCE;
        private MediaRouter2.ControllerCallback controllerCallback;
        private BackgroundThreadStateHandler<Boolean> isSuitableForPlaybackState;
        private MediaRouter2.RouteCallback routeCallback;
        private MediaRouter2 router;

        static {
            AbstractC0590d.m1634p();
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            EMPTY_DISCOVERY_PREFERENCE = AbstractC0590d.m1630l(C2180c5.f7862e).build();
        }

        private ImplApi35() {
        }

        private static boolean isRouteSuitableForMediaPlayback(MediaRoute2Info mediaRoute2Info, int i6, boolean z7) {
            int suitabilityStatus = mediaRoute2Info.getSuitabilityStatus();
            if (suitabilityStatus == 1) {
                return (i6 == 1 || i6 == 2) && z7;
            }
            return suitabilityStatus == 0;
        }

        public void lambda$disable$2() {
            AbstractC0590d.m1629k(Assertions.checkNotNull(this.router)).unregisterControllerCallback(AbstractC0590d.m1625g(Assertions.checkNotNull(this.controllerCallback)));
            this.controllerCallback = null;
            this.router.unregisterRouteCallback(AbstractC0590d.m1626h(Assertions.checkNotNull(this.routeCallback)));
        }

        public static void lambda$enable$0(SuitableOutputChecker.Callback callback, Boolean bool, Boolean bool2) {
            callback.onSelectedOutputSuitabilityChanged(bool2.booleanValue());
        }

        public void lambda$enable$1(Context context) {
            Assertions.checkNotNull(this.isSuitableForPlaybackState);
            this.router = MediaRouter2.getInstance(context);
            this.routeCallback = new MediaRouter2.RouteCallback() {
            };
            final BackgroundThreadStateHandler<Boolean> backgroundThreadStateHandler = this.isSuitableForPlaybackState;
            Objects.requireNonNull(backgroundThreadStateHandler);
            ?? r10 = new Executor() {
                @Override
                public final void execute(Runnable runnable) {
                    backgroundThreadStateHandler.runInBackground(runnable);
                }
            };
            this.router.registerRouteCallback(r10, this.routeCallback, EMPTY_DISCOVERY_PREFERENCE);
            MediaRouter2.ControllerCallback controllerCallback = new MediaRouter2.ControllerCallback() {
                @Override
                public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
                    ImplApi35.this.isSuitableForPlaybackState.setStateInBackground(Boolean.valueOf(ImplApi35.isSelectedOutputSuitableForPlayback(ImplApi35.this.router)));
                }
            };
            this.controllerCallback = controllerCallback;
            this.router.registerControllerCallback(r10, controllerCallback);
            this.isSuitableForPlaybackState.setStateInBackground(Boolean.valueOf(isSelectedOutputSuitableForPlayback(this.router)));
        }

        @Override
        public void disable() {
            ((BackgroundThreadStateHandler) Assertions.checkStateNotNull(this.isSuitableForPlaybackState)).runInBackground(new RunnableC0731b(2, this));
        }

        @Override
        @SuppressLint({"ThreadSafe"})
        public void enable(SuitableOutputChecker.Callback callback, Context context, Looper looper, Looper looper2, Clock clock) {
            BackgroundThreadStateHandler<Boolean> backgroundThreadStateHandler = new BackgroundThreadStateHandler<>(Boolean.TRUE, looper2, looper, clock, new C0763g(callback, 1));
            this.isSuitableForPlaybackState = backgroundThreadStateHandler;
            backgroundThreadStateHandler.runInBackground(new RunnableC0765h(this, 1, context));
        }

        @Override
        public boolean isSelectedOutputSuitableForPlayback() {
            BackgroundThreadStateHandler<Boolean> backgroundThreadStateHandler = this.isSuitableForPlaybackState;
            if (backgroundThreadStateHandler == null) {
                return true;
            }
            return backgroundThreadStateHandler.get().booleanValue();
        }

        public static boolean isSelectedOutputSuitableForPlayback(MediaRouter2 mediaRouter2) {
            int transferReason = AbstractC0590d.m1629k(Assertions.checkNotNull(mediaRouter2)).getSystemController().getRoutingSessionInfo().getTransferReason();
            boolean zWasTransferInitiatedBySelf = mediaRouter2.getSystemController().wasTransferInitiatedBySelf();
            Iterator it = mediaRouter2.getSystemController().getSelectedRoutes().iterator();
            while (it.hasNext()) {
                if (isRouteSuitableForMediaPlayback(AbstractC0590d.m1624f(it.next()), transferReason, zWasTransferInitiatedBySelf)) {
                    return true;
                }
            }
            return false;
        }
    }

    public DefaultSuitableOutputChecker() {
        int i6 = Util.SDK_INT;
        if (i6 >= 35) {
            this.impl = new ImplApi35();
        } else if (i6 >= 23) {
            this.impl = new ImplApi23();
        } else {
            this.impl = null;
        }
    }

    @Override
    public void disable() {
        SuitableOutputChecker suitableOutputChecker = this.impl;
        if (suitableOutputChecker != null) {
            suitableOutputChecker.disable();
        }
    }

    @Override
    public void enable(SuitableOutputChecker.Callback callback, Context context, Looper looper, Looper looper2, Clock clock) {
        SuitableOutputChecker suitableOutputChecker = this.impl;
        if (suitableOutputChecker != null) {
            suitableOutputChecker.enable(callback, context, looper, looper2, clock);
        }
    }

    @Override
    public boolean isSelectedOutputSuitableForPlayback() {
        SuitableOutputChecker suitableOutputChecker = this.impl;
        return suitableOutputChecker == null || suitableOutputChecker.isSelectedOutputSuitableForPlayback();
    }
}
