package androidx.media3.exoplayer.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@UnstableApi
public final class OfflineLicenseHelper {
    private static final Format FORMAT_WITH_EMPTY_DRM_INIT_DATA = new Format.Builder().setDrmInitData(new DrmInitData(new DrmInitData.SchemeData[0])).build();
    private final ConditionVariable drmListenerConditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final DrmSessionEventListener.EventDispatcher eventDispatcher;
    private final Handler handler;
    private final HandlerThread handlerThread;

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = eventDispatcher;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
        this.drmListenerConditionVariable = new ConditionVariable();
        eventDispatcher.addEventListener(new Handler(handlerThread.getLooper()), new DrmSessionEventListener() {
            @Override
            public void onDrmKeysLoaded(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override
            public void onDrmKeysRemoved(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override
            public void onDrmKeysRestored(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override
            public final void onDrmSessionAcquired(int i6, MediaSource.MediaPeriodId mediaPeriodId, int i10) {
                AbstractC0748f.m2211d(this, i6, mediaPeriodId, i10);
            }

            @Override
            public void onDrmSessionManagerError(int i6, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override
            public final void onDrmSessionReleased(int i6, MediaSource.MediaPeriodId mediaPeriodId) {
                AbstractC0748f.m2213f(this, i6, mediaPeriodId);
            }
        });
    }

    private DrmSession acquireFirstSessionOnHandlerThread(final int i6, final byte[] bArr, final Format format) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(format.drmInitData);
        final SettableFuture settableFutureCreate = SettableFuture.create();
        this.drmListenerConditionVariable.close();
        this.handler.post(new Runnable() {
            @Override
            public final void run() {
                this.f2835a.lambda$acquireFirstSessionOnHandlerThread$2(i6, bArr, settableFutureCreate, format);
            }
        });
        try {
            DrmSession drmSession = (DrmSession) settableFutureCreate.get();
            this.drmListenerConditionVariable.block();
            SettableFuture settableFutureCreate2 = SettableFuture.create();
            this.handler.post(new RunnableC0757o(drmSession, this, settableFutureCreate2));
            try {
                if (settableFutureCreate2.get() == 0) {
                    return drmSession;
                }
                throw ((DrmSession.DrmSessionException) settableFutureCreate2.get());
            } catch (InterruptedException | ExecutionException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (InterruptedException | ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private byte[] acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(int i6, byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        DrmSession drmSessionAcquireFirstSessionOnHandlerThread = acquireFirstSessionOnHandlerThread(i6, bArr, format);
        SettableFuture settableFutureCreate = SettableFuture.create();
        this.handler.post(new RunnableC0757o(this, settableFutureCreate, drmSessionAcquireFirstSessionOnHandlerThread, 2));
        try {
            try {
                byte[] bArr2 = (byte[]) Assertions.checkNotNull((byte[]) settableFutureCreate.get());
                releaseManagerOnHandlerThread();
                return bArr2;
            } catch (Throwable th) {
                releaseManagerOnHandlerThread();
                throw th;
            }
        } catch (InterruptedException | ExecutionException e5) {
            throw new IllegalStateException(e5);
        }
    }

    public void lambda$acquireFirstSessionOnHandlerThread$2(int i6, byte[] bArr, SettableFuture settableFuture, Format format) {
        try {
            this.drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), PlayerId.UNSET);
            this.drmSessionManager.prepare();
            try {
                this.drmSessionManager.setMode(i6, bArr);
                settableFuture.set((DrmSession) Assertions.checkNotNull(this.drmSessionManager.acquireSession(this.eventDispatcher, format)));
            } catch (Throwable th) {
                this.drmSessionManager.release();
                throw th;
            }
        } catch (Throwable th2) {
            settableFuture.setException(th2);
        }
    }

    public void lambda$acquireFirstSessionOnHandlerThread$3(DrmSession drmSession, SettableFuture settableFuture) {
        try {
            DrmSession.DrmSessionException error = drmSession.getError();
            if (drmSession.getState() == 1) {
                drmSession.release(this.eventDispatcher);
                this.drmSessionManager.release();
            }
            settableFuture.set(error);
        } catch (Throwable th) {
            settableFuture.setException(th);
            drmSession.release(this.eventDispatcher);
            this.drmSessionManager.release();
        }
    }

    public void m2205xfae744aa(SettableFuture settableFuture, DrmSession drmSession) {
        try {
            settableFuture.set(drmSession.getOfflineLicenseKeySetId());
        } catch (Throwable th) {
            try {
                settableFuture.setException(th);
            } finally {
                drmSession.release(this.eventDispatcher);
            }
        }
    }

    public void lambda$getLicenseDurationRemainingSec$0(SettableFuture settableFuture, DrmSession drmSession) {
        try {
            settableFuture.set((Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(drmSession)));
        } catch (Throwable th) {
            try {
                settableFuture.setException(th);
            } finally {
                drmSession.release(this.eventDispatcher);
            }
        }
    }

    public void lambda$releaseManagerOnHandlerThread$4(SettableFuture settableFuture) {
        try {
            this.drmSessionManager.release();
            settableFuture.set(null);
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, false, factory, eventDispatcher);
    }

    private void releaseManagerOnHandlerThread() {
        SettableFuture settableFutureCreate = SettableFuture.create();
        this.handler.post(new RunnableC0745c(this, 1, settableFutureCreate));
        try {
            settableFutureCreate.get();
        } catch (InterruptedException | ExecutionException e5) {
            throw new IllegalStateException(e5);
        }
    }

    public synchronized byte[] downloadLicense(Format format) throws DrmSession.DrmSessionException {
        Assertions.checkArgument(format.drmInitData != null);
        return acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(2, null, format);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Pair<Long, Long> pair;
        Assertions.checkNotNull(bArr);
        try {
            DrmSession drmSessionAcquireFirstSessionOnHandlerThread = acquireFirstSessionOnHandlerThread(1, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
            SettableFuture settableFutureCreate = SettableFuture.create();
            this.handler.post(new RunnableC0757o(this, settableFutureCreate, drmSessionAcquireFirstSessionOnHandlerThread, 0));
            try {
                try {
                    pair = (Pair) settableFutureCreate.get();
                    releaseManagerOnHandlerThread();
                } catch (Throwable th) {
                    releaseManagerOnHandlerThread();
                    throw th;
                }
            } catch (InterruptedException | ExecutionException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (DrmSession.DrmSessionException e10) {
            if (e10.getCause() instanceof KeysExpiredException) {
                return Pair.create(0L, 0L);
            }
            throw e10;
        }
        return pair;
    }

    public void release() {
        this.handlerThread.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(3, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(2, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z7, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, z7, factory, null, eventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z7, DataSource.Factory factory, Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z7, factory)), eventDispatcher);
    }
}
