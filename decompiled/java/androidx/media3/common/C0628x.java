package androidx.media3.common;

import android.content.ClipData;
import android.content.ClipDescription;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0391a;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.ReorderingSeiMessageQueue;
import androidx.media3.exoplayer.hls.C0775b;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.preload.BasePreloadManager;
import androidx.media3.exoplayer.source.preload.PreloadException;
import androidx.media3.exoplayer.source.preload.PreloadManagerListener;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.RandomTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.p010ts.SeiReader;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleExtractor;
import com.alibaba.fastjson.JSONReader;
import com.lzy.okgo.model.HttpHeaders;
import com.tencent.mars.xlog.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p000a.AbstractC0004e;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p005a4.C0051j;
import p005a4.C0060s;
import p041d7.C2288s1;
import p050e4.C2409a;
import p050e4.EnumC2411c;
import p077h4.C2659i;
import p077h4.C2660j;
import p080h7.C2664b;
import p087i4.C2702g;
import p087i4.InterfaceC2698c;
import p087i4.InterfaceC2699d;
import p090i8.InterfaceC2708b;
import p098j4.InterfaceC2775b;
import p101j7.C2782c;
import p101j7.C2784e;
import p101j7.C2785f;
import p116ka.C2917f;
import p116ka.C2924i0;
import p116ka.ViewOnKeyListenerC2925j;
import p126l8.InterfaceC3013a;
import p138n0.AbstractC3155s0;
import p138n0.C3112e;
import p138n0.InterfaceC3109d;
import p156o9.AbstractC3280d;
import p169p8.C3377b;
import p173q1.AbstractC3394b0;
import p173q1.C3412h0;
import p173q1.C3434o1;
import p173q1.C3454w;
import p173q1.InterfaceC3391a0;
import p173q1.ServiceConnectionC3428m1;
import p187r4.C3624n;
import p195s0.InterfaceC3690g;
import p260y3.C4250b;
import p260y3.C4251c;
import p260y3.C4252d;
import p270z3.C4315i;
import p270z3.C4319m;

public final class C0628x implements ListenerSet.IterationFinishedEvent, ListenerSet.Event, DefaultTrackSelector.TrackInfo.Factory, TrackSelectionUtil.AdaptiveTrackSelectionFactory, BinarySearchSeeker.SeekTimestampConverter, ReorderingSeiMessageQueue.SeiConsumer, Consumer, EventListener.Factory, InterfaceC2775b, InterfaceC2708b, InterfaceC3013a, InterfaceC3391a0 {

    public final int f2660a;

    public final Object f2661b;

    public C0628x(int i6, Object obj) {
        this.f2660a = i6;
        this.f2661b = obj;
    }

    @Override
    public void mo1735a(C3377b c3377b) {
        AbstractC0032a.m165s("9P49Wlr9DHLR9D5L\n", "vJFQPxyPbRU=\n");
        AbstractC0032a.m165s("kMlTIPlw3tKKzUw7+W/o9IPCAjryUN/ygclRJqYj\n", "4qwiVZwDqpE=\n");
        String strM165s = AbstractC0032a.m165s("sg==\n", "6duPaGdpRWY=\n");
        String str = (String) this.f2661b;
        if (str.startsWith(strM165s)) {
            String strM165s2 = AbstractC0032a.m165s("2B/OdLN3/+L9Fc1l\n", "kHCjEfUFnoU=\n");
            String strM165s3 = AbstractC0032a.m165s("/PbBaR8JZVngorL0w/7lsQ1/CJia8q/MBih1p/iFvKZ6BBL02utDQvL2/HkQj6+Teykz\n", "k5iSHHxqACo=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, strM165s3);
            return;
        }
        if (str.startsWith(AbstractC0032a.m165s("bw==\n", "FKb5BLr69gw=\n"))) {
            try {
                ChannelBean channelBean = (ChannelBean) new JSONReader(new StringReader(str)).readObject(ChannelBean.class);
                if (channelBean.getSources() == null || channelBean.getSources().isEmpty()) {
                    String strM165s4 = AbstractC0032a.m165s("wvVwd/2Ynojn/3Nm\n", "ipodErvq/+8=\n");
                    String strM165s5 = AbstractC0032a.m165s("nuKKUTaDqK2CtvnCykUpZnxpUZSzdX04fCI=\n", "8YzZJFXgzd4=\n");
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s4, strM165s5);
                } else {
                    String strM165s6 = AbstractC0032a.m165s("ZfsXQnu5pFpA8RRT\n", "LZR6Jz3LxT0=\n");
                    String str2 = AbstractC0032a.m165s("V/+WgxlHqdZLq+U=\n", "OJHF9nokzKU=\n") + channelBean.getSources().size();
                    boolean z11 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s6, str2);
                    c3377b.m6873c(channelBean);
                }
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    @Override
    public void accept(Object obj) {
        switch (this.f2660a) {
            case 7:
                ((SubtitleExtractor) this.f2661b).lambda$parseAndWriteToOutput$0((CuesWithTiming) obj);
                break;
            case 8:
                ((C2288s1) this.f2661b).m5255a((CuesWithTiming) obj);
                break;
            default:
                ViewOnKeyListenerC2925j viewOnKeyListenerC2925j = ((C2917f) this.f2661b).f9897b;
                viewOnKeyListenerC2925j.f9931Z.setVisibility(8);
                viewOnKeyListenerC2925j.f9930Y.setVisibility(0);
                C3333o c3333o = C3333o.f11249f;
                c3333o.m6770c((ChannelBean) obj, AbstractC0032a.m165s("GMYHaw==\n", "cKlqDhvdsOU=\n"));
                C2924i0 c2924i0M6769a = c3333o.m6769a(viewOnKeyListenerC2925j, viewOnKeyListenerC2925j.f9930Y, viewOnKeyListenerC2925j.f9927V, viewOnKeyListenerC2925j.f9931Z);
                AbstractC0410j0 abstractC0410j0M1320i = viewOnKeyListenerC2925j.m1320i();
                abstractC0410j0M1320i.getClass();
                C0391a c0391a = new C0391a(abstractC0410j0M1320i);
                c0391a.m1194i(com.p2serv.android.p032ds.R.id.vod_detail_container, c2924i0M6769a);
                c0391a.m1188c();
                c0391a.m1190e(false);
                break;
        }
    }

    public C4251c m1736b(Object obj) {
        C4250b c4250b = (C4250b) obj;
        C4252d c4252d = (C4252d) this.f2661b;
        AbstractC3280d.m6591i("CctTransportBackend", "Making request to: %s", c4250b.f14439a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) c4250b.f14439a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(c4252d.f14451g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST);
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.3 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "gzip");
        String str = c4250b.f14441c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    C2782c c2782c = c4252d.f14445a;
                    C4315i c4315i = c4250b.f14440b;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    C2784e c2784e = (C2784e) c2782c.f9501b;
                    C2785f c2785f = new C2785f(bufferedWriter, c2784e.f9507a, c2784e.f9508b, c2784e.f9509c, c2784e.f9510d);
                    c2785f.m5767e(c4315i);
                    c2785f.m5769g();
                    c2785f.f9512b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    android.util.Log.i("TransportRuntime.".concat("CctTransportBackend"), AbstractC0004e.m20n(responseCode, "Status Code: "));
                    android.util.Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    android.util.Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new C4251c(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new C4251c(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            C4251c c4251c = new C4251c(responseCode, null, C4319m.m8355a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f14674a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return c4251c;
                        } catch (Throwable th) {
                            if (gZIPInputStream == null) {
                                throw th;
                            }
                            try {
                                gZIPInputStream.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        if (inputStream == null) {
                            throw th3;
                        }
                        try {
                            inputStream.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        gZIPOutputStream.close();
                        throw th5;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                if (outputStream == null) {
                    throw th7;
                }
                try {
                    outputStream.close();
                    throw th7;
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                    throw th7;
                }
            }
        } catch (C2664b e5) {
            e = e5;
            android.util.Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new C4251c(400, null, 0L);
        } catch (ConnectException e10) {
            e = e10;
            android.util.Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new C4251c(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            android.util.Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new C4251c(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            android.util.Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new C4251c(400, null, 0L);
        }
    }

    @Override
    public void mo1737c(AbstractC3394b0 abstractC3394b0, C3454w c3454w, ArrayList arrayList) {
        ((C3412h0) this.f2661b).f11514i.m7082g(abstractC3394b0, c3454w, arrayList);
    }

    @Override
    public void consume(long j10, ParsableByteArray parsableByteArray) {
        switch (this.f2660a) {
            case 6:
                ((FragmentedMp4Extractor) this.f2661b).lambda$new$2(j10, parsableByteArray);
                break;
            default:
                ((SeiReader) this.f2661b).lambda$new$0(j10, parsableByteArray);
                break;
        }
    }

    @Override
    public List create(int i6, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.lambda$selectImageTrack$5((DefaultTrackSelector.Parameters) this.f2661b, i6, trackGroup, iArr);
    }

    @Override
    public ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition) {
        return ((RandomTrackSelection.Factory) this.f2661b).lambda$createTrackSelections$0(definition);
    }

    public boolean m1738d(C3624n c3624n, int i6, Bundle bundle) {
        InterfaceC3109d c2782c;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 25 && (i6 & 1) != 0) {
            try {
                ((InterfaceC3690g) c3624n.f12182b).mo7327d();
                Parcelable parcelable = (Parcelable) ((InterfaceC3690g) c3624n.f12182b).mo7325b();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e5) {
                android.util.Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e5);
                return false;
            }
        }
        ClipDescription clipDescriptionMo7324a = ((InterfaceC3690g) c3624n.f12182b).mo7324a();
        InterfaceC3690g interfaceC3690g = (InterfaceC3690g) c3624n.f12182b;
        ClipData clipData = new ClipData(clipDescriptionMo7324a, new ClipData.Item(interfaceC3690g.mo7326c()));
        if (i10 >= 31) {
            c2782c = new C2782c(clipData, 2);
        } else {
            C3112e c3112e = new C3112e();
            c3112e.f10586b = clipData;
            c3112e.f10587c = 2;
            c2782c = c3112e;
        }
        c2782c.mo5756l(interfaceC3690g.mo7328e());
        c2782c.setExtras(bundle);
        return AbstractC3155s0.m6342l((AppCompatEditText) this.f2661b, c2782c.mo5753f()) == null;
    }

    @Override
    public Object execute() {
        boolean z7 = false;
        Object obj = this.f2661b;
        switch (this.f2660a) {
            case 11:
                C2702g c2702g = (C2702g) ((InterfaceC2698c) obj);
                c2702g.getClass();
                int i6 = C2409a.f8399e;
                C0023f c0023f = new C0023f(3, z7);
                c0023f.f44b = null;
                c0023f.f46d = new ArrayList();
                c0023f.f45c = null;
                c0023f.f47e = "";
                HashMap map = new HashMap();
                SQLiteDatabase sQLiteDatabaseM5697a = c2702g.m5697a();
                sQLiteDatabaseM5697a.beginTransaction();
                try {
                    C2409a c2409a = (C2409a) C2702g.m5696g(sQLiteDatabaseM5697a.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new C0775b(c2702g, map, c0023f, 7));
                    sQLiteDatabaseM5697a.setTransactionSuccessful();
                    return c2409a;
                } finally {
                    sQLiteDatabaseM5697a.endTransaction();
                }
            case 12:
                C2702g c2702g2 = (C2702g) ((InterfaceC2699d) obj);
                long jMo5893c = c2702g2.f9388b.mo5893c() - c2702g2.f9390d.f9379d;
                SQLiteDatabase sQLiteDatabaseM5697a2 = c2702g2.m5697a();
                sQLiteDatabaseM5697a2.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(jMo5893c)};
                    Cursor cursorRawQuery = sQLiteDatabaseM5697a2.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            c2702g2.m5699d(cursorRawQuery.getInt(0), EnumC2411c.MESSAGE_TOO_OLD, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = sQLiteDatabaseM5697a2.delete("events", "timestamp_ms < ?", strArr);
                    sQLiteDatabaseM5697a2.setTransactionSuccessful();
                    sQLiteDatabaseM5697a2.endTransaction();
                    return Integer.valueOf(iDelete);
                } catch (Throwable th2) {
                    sQLiteDatabaseM5697a2.endTransaction();
                    throw th2;
                }
            case 13:
                C2702g c2702g3 = (C2702g) ((C2659i) obj).f9285i;
                SQLiteDatabase sQLiteDatabaseM5697a3 = c2702g3.m5697a();
                sQLiteDatabaseM5697a3.beginTransaction();
                try {
                    sQLiteDatabaseM5697a3.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseM5697a3.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + c2702g3.f9388b.mo5893c()).execute();
                    sQLiteDatabaseM5697a3.setTransactionSuccessful();
                    return null;
                } finally {
                    sQLiteDatabaseM5697a3.endTransaction();
                }
            default:
                C2660j c2660j = (C2660j) obj;
                Iterator it = ((Iterable) ((C2702g) c2660j.f9287b).m5698c(new C0060s(25))).iterator();
                while (it.hasNext()) {
                    c2660j.f9288c.m5668a((C0051j) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override
    public void invoke(Object obj) {
        switch (this.f2660a) {
            case 1:
                BasePreloadManager.lambda$onPreloadCompleted$1((MediaSource) this.f2661b, (PreloadManagerListener) obj);
                break;
            default:
                ((PreloadManagerListener) obj).onError((PreloadException) this.f2661b);
                break;
        }
    }

    @Override
    public long timeUsToTargetTime(long j10) {
        return ((FlacStreamMetadata) this.f2661b).getSampleNumber(j10);
    }

    public C0628x(C3434o1 c3434o1, ServiceConnectionC3428m1 serviceConnectionC3428m1) {
        this.f2660a = 19;
        this.f2661b = c3434o1;
    }

    @Override
    public EventListener create(Call call) {
        return Util.asFactory$lambda$8((EventListener) this.f2661b, call);
    }

    @Override
    public void invoke(Object obj, FlagSet flagSet) {
        ((SimpleBasePlayer) this.f2661b).lambda$new$0((Player.Listener) obj, flagSet);
    }
}
