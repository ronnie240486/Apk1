package androidx.media3.common.util;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.hls.C0775b;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.preload.BasePreloadManager;
import androidx.media3.exoplayer.source.preload.PreloadException;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import p003a2.AbstractC0032a;
import p005a4.C0050i;
import p005a4.C0051j;
import p005a4.C0052k;
import p005a4.C0060s;
import p014b1.C1237k;
import p014b1.C1241o;
import p014b1.C1242p;
import p017b4.InterfaceC1300g;
import p069g4.C2611a;
import p087i4.C2702g;
import p222u7.AbstractC3928d;
import p260y3.C4252d;

public final class RunnableC0624i implements Runnable {

    public final int f2649a;

    public final Object f2650b;

    public final Object f2651c;

    public final Object f2652d;

    public RunnableC0624i(SettableFuture settableFuture, Runnable runnable, Object obj) {
        this.f2649a = 1;
        this.f2650b = settableFuture;
        this.f2651c = runnable;
        this.f2652d = obj;
    }

    @Override
    public final void run() {
        switch (this.f2649a) {
            case 0:
                Util.lambda$transformFutureAsync$2((ListenableFuture) this.f2651c, (SettableFuture) this.f2650b, (AsyncFunction) this.f2652d);
                return;
            case 1:
                Util.lambda$postOrRunWithCompletion$0((SettableFuture) this.f2650b, (Runnable) this.f2651c, this.f2652d);
                return;
            case 2:
                ((AudioRendererEventListener.EventDispatcher) this.f2651c).lambda$inputFormatChanged$2((Format) this.f2650b, (DecoderReuseEvaluation) this.f2652d);
                return;
            case 3:
                ((DrmSessionEventListener.EventDispatcher) this.f2651c).lambda$drmSessionManagerError$2((DrmSessionEventListener) this.f2650b, (Exception) this.f2652d);
                return;
            case 4:
                ((BasePreloadManager) this.f2651c).lambda$onPreloadError$4((PreloadException) this.f2650b, (MediaSource) this.f2652d);
                return;
            case 5:
                C0052k c0052k = (C0052k) this.f2651c;
                AbstractC0032a abstractC0032a = (AbstractC0032a) this.f2650b;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f2652d;
                c0052k.getClass();
                try {
                    C1242p c1242pM7845f = AbstractC3928d.m7845f(c0052k.f155b);
                    if (c1242pM7845f == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    C1241o c1241o = (C1241o) c1242pM7845f.f3956a;
                    synchronized (c1241o.f3950d) {
                        c1241o.f3952f = threadPoolExecutor;
                        break;
                    }
                    c1242pM7845f.f3956a.mo204a(new C1237k(abstractC0032a, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    abstractC0032a.mo174H(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            default:
                C0051j c0051j = (C0051j) this.f2650b;
                String str = c0051j.f151a;
                C0050i c0050i = (C0050i) this.f2652d;
                C2611a c2611a = (C2611a) this.f2651c;
                c2611a.getClass();
                Logger logger = C2611a.f9084f;
                try {
                    InterfaceC1300g interfaceC1300gM3175a = c2611a.f9087c.m3175a(str);
                    if (interfaceC1300gM3175a == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((C2702g) c2611a.f9089e).m5700e(new C0775b(c2611a, c0051j, ((C4252d) interfaceC1300gM3175a).m8303a(c0050i), 4));
                    }
                    return;
                } catch (Exception e5) {
                    logger.warning("Error scheduling event " + e5.getMessage());
                    return;
                }
        }
    }

    public RunnableC0624i(C2611a c2611a, C0051j c0051j, C0060s c0060s, C0050i c0050i) {
        this.f2649a = 6;
        this.f2651c = c2611a;
        this.f2650b = c0051j;
        this.f2652d = c0050i;
    }

    public RunnableC0624i(Object obj, Object obj2, Object obj3, int i6) {
        this.f2649a = i6;
        this.f2651c = obj;
        this.f2650b = obj2;
        this.f2652d = obj3;
    }
}
