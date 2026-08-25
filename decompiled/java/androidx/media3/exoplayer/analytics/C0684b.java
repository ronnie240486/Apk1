package androidx.media3.exoplayer.analytics;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0391a;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.hls.C0775b;
import com.alibaba.fastjson.JSONReader;
import com.lzy.okgo.cookie.SerializableCookie;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.beans.VodMenu;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p000a.RunnableC0005f;
import p003a2.AbstractC0032a;
import p005a4.C0049h;
import p005a4.C0051j;
import p050e4.EnumC2411c;
import p077h4.C2659i;
import p087i4.C2697b;
import p087i4.C2701f;
import p087i4.C2702g;
import p087i4.InterfaceC2700e;
import p090i8.InterfaceC2708b;
import p098j4.InterfaceC2775b;
import p116ka.C2911c;
import p116ka.C2924i0;
import p116ka.ViewOnKeyListenerC2915e;
import p126l8.InterfaceC3013a;
import p169p8.C3377b;
import p214ta.C3877a;

public final class C0684b implements ListenerSet.Event, ListenerSet.IterationFinishedEvent, InterfaceC2775b, InterfaceC2700e, InterfaceC2708b, InterfaceC3013a {

    public final int f2686a;

    public final Object f2687b;

    public final Object f2688c;

    public C0684b(Object obj, int i6, Object obj2) {
        this.f2686a = i6;
        this.f2687b = obj;
        this.f2688c = obj2;
    }

    @Override
    public void mo1735a(C3377b c3377b) {
        C2911c c2911c = (C2911c) this.f2687b;
        c2911c.getClass();
        AbstractC0032a.m165s("70OTWRyl7UzU\n", "rRDbMG/Rgj4=\n");
        AbstractC0032a.m165s("fCfmbxcLtplmI/l0FxSAv28st3UcK7e5bSfkaUhY\n", "DkKXGnJ4wto=\n");
        String strM165s = AbstractC0032a.m165s("Hg==\n", "RRzbqAjWQaE=\n");
        String str = (String) this.f2688c;
        if (str.startsWith(strM165s)) {
            String strM165s2 = AbstractC0032a.m165s("yykZ/N1iaZ/w\n", "iXpRla4WBu0=\n");
            String strM165s3 = AbstractC0032a.m165s("z35E4mQeRTDTKjd/uOnF2D73jRPh5Y+lNaDwLIOSnM9JjJd/ofxjK8F+efJrmI/6SKG2\n", "oBAXlwd9IEM=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, strM165s3);
            return;
        }
        if (str.startsWith(AbstractC0032a.m165s("vQ==\n", "xvomFyPZZp0=\n"))) {
            try {
                ChannelBean channelBean = (ChannelBean) new JSONReader(new StringReader(str)).readObject(ChannelBean.class);
                if (channelBean.getSources() == null || channelBean.getSources().isEmpty()) {
                    ViewOnKeyListenerC2915e.f9879l0.post(new RunnableC0005f(20, c2911c));
                    c2911c.f9868b.f9891g0.f13009v = false;
                } else {
                    String strM165s4 = AbstractC0032a.m165s("BwEd5KD8I7o8\n", "RVJVjdOITMg=\n");
                    String str2 = AbstractC0032a.m165s("ufvp8sOmU1Wlr5o=\n", "1pW6h6DFNiY=\n") + channelBean.getSources().size();
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s4, str2);
                    c3377b.m6873c(channelBean);
                }
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    @Override
    public void accept(Object obj) {
        ChannelBean channelBean = (ChannelBean) obj;
        ViewOnKeyListenerC2915e viewOnKeyListenerC2915e = ((C2911c) this.f2687b).f9868b;
        viewOnKeyListenerC2915e.f9882W.setVisibility(8);
        viewOnKeyListenerC2915e.f9893i0.setVisibility(0);
        String strM165s = ((HistoryBean) this.f2688c).subId;
        if (TextUtils.isEmpty(strM165s)) {
            strM165s = AbstractC0032a.m165s("MUM=\n", "HHIQ3ucwfuQ=\n");
        }
        C3333o c3333o = C3333o.f11249f;
        int i6 = Integer.parseInt(strM165s);
        String strM165s2 = AbstractC0032a.m165s("pf1XxRrtuQ==\n", "zZQksXWfwBA=\n");
        c3333o.f11251b.m7740j();
        C3877a c3877a = c3333o.f11251b;
        c3877a.f13004q = channelBean;
        c3877a.f13002o = strM165s2;
        c3877a.f13013z.clear();
        c3877a.f12984A.clear();
        boolean zIsEmpty = c3877a.f13004q.getSources().isEmpty();
        ArrayList arrayList = c3877a.f12984A;
        boolean z7 = true;
        if (!zIsEmpty) {
            if (c3877a.f13004q.getSeasons() != 1) {
                c3877a.m7733c();
                int i10 = 0;
                while (i10 < c3877a.f13004q.getSeasons()) {
                    int i11 = i10 + 1;
                    List<ChannelBean.SourcesBean> seasonSources = c3877a.f13004q.getSeasonSources(i11);
                    for (int i12 = 0; i12 < seasonSources.size(); i12++) {
                        if (i6 == seasonSources.get(i12).getId()) {
                            c3877a.f13006s = i10;
                            c3877a.m7743m(i10);
                            c3877a.m7745o(i12);
                            break;
                        }
                    }
                    i10 = i11;
                }
            } else {
                arrayList.addAll(c3877a.f13004q.getSources());
                if (i6 == -1) {
                    c3877a.f13006s = 0;
                    c3877a.m7745o(0);
                } else {
                    for (int i13 = 0; i13 < c3877a.f13004q.getSources().size(); i13++) {
                        if (i6 == c3877a.f13004q.getSources().get(i13).getId()) {
                            c3877a.f13006s = 0;
                            c3877a.m7745o(i13);
                            break;
                        }
                    }
                }
            }
        }
        VodMenu vodMenu = (VodMenu) c3877a.f12989F.get(0);
        if (c3877a.f13013z.size() <= 1 && arrayList.size() <= 1) {
            z7 = false;
        }
        vodMenu.setEnable(z7);
        c3333o.f11251b.m7744n();
        C2924i0 c2924i0M6769a = C3333o.f11249f.m6769a(viewOnKeyListenerC2915e, viewOnKeyListenerC2915e.f9893i0, viewOnKeyListenerC2915e.f9885Z, viewOnKeyListenerC2915e.f9882W);
        AbstractC0410j0 abstractC0410j0M1320i = viewOnKeyListenerC2915e.m1320i();
        abstractC0410j0M1320i.getClass();
        C0391a c0391a = new C0391a(abstractC0410j0M1320i);
        c0391a.m1194i(R.id.vod_detail_container, c2924i0M6769a);
        c0391a.m1188c();
        c0391a.m1190e(false);
        Spark.f11003Y1.m5636d(channelBean);
    }

    @Override
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        C2702g c2702g = (C2702g) this.f2687b;
        c2702g.getClass();
        ArrayList arrayList = new ArrayList();
        C0051j c0051j = (C0051j) this.f2688c;
        Long lM5694b = C2702g.m5694b(sQLiteDatabase, c0051j);
        if (lM5694b != null) {
            C2702g.m5696g(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lM5694b.toString()}, null, null, null, String.valueOf(c2702g.f9390d.f9377b)), new C0775b(c2702g, arrayList, c0051j, 6));
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            sb.append(((C2697b) arrayList.get(i6)).f9381a);
            if (i6 < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", SerializableCookie.NAME, "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j10 = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j10));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j10), hashSet);
                }
                hashSet.add(new C2701f(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            C2697b c2697b = (C2697b) listIterator.next();
            if (map.containsKey(Long.valueOf(c2697b.f9381a))) {
                C0049h c0049hM202c = c2697b.f9383c.m202c();
                long j11 = c2697b.f9381a;
                for (C2701f c2701f : (Set) map.get(Long.valueOf(j11))) {
                    c0049hM202c.m197a(c2701f.f9384a, c2701f.f9385b);
                }
                listIterator.set(new C2697b(j11, c2697b.f9382b, c0049hM202c.m198c()));
            }
        }
        return arrayList;
    }

    @Override
    public Object execute() {
        switch (this.f2686a) {
            case 11:
                C2702g c2702g = (C2702g) ((C2659i) this.f2687b).f9279c;
                c2702g.getClass();
                Iterable iterable = (Iterable) this.f2688c;
                if (iterable.iterator().hasNext()) {
                    c2702g.m5697a().compileStatement("DELETE FROM events WHERE _id in " + C2702g.m5695f(iterable)).execute();
                    break;
                }
                break;
            default:
                C2659i c2659i = (C2659i) this.f2687b;
                c2659i.getClass();
                for (Map.Entry entry : ((HashMap) this.f2688c).entrySet()) {
                    ((C2702g) c2659i.f9285i).m5699d(((Integer) entry.getValue()).intValue(), EnumC2411c.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override
    public void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f2686a) {
            case 0:
                analyticsListener.onPlaybackParametersChanged((AnalyticsListener.EventTime) this.f2687b, (PlaybackParameters) this.f2688c);
                break;
            case 1:
                analyticsListener.onTrackSelectionParametersChanged((AnalyticsListener.EventTime) this.f2687b, (TrackSelectionParameters) this.f2688c);
                break;
            case 2:
                analyticsListener.onAvailableCommandsChanged((AnalyticsListener.EventTime) this.f2687b, (Player.Commands) this.f2688c);
                break;
            case 3:
            default:
                analyticsListener.onCues((AnalyticsListener.EventTime) this.f2687b, (CueGroup) this.f2688c);
                break;
            case 4:
                analyticsListener.onAudioAttributesChanged((AnalyticsListener.EventTime) this.f2687b, (AudioAttributes) this.f2688c);
                break;
            case 5:
                analyticsListener.onMetadata((AnalyticsListener.EventTime) this.f2687b, (Metadata) this.f2688c);
                break;
            case 6:
                analyticsListener.onTracksChanged((AnalyticsListener.EventTime) this.f2687b, (Tracks) this.f2688c);
                break;
            case 7:
                analyticsListener.onCues((AnalyticsListener.EventTime) this.f2687b, (List<Cue>) this.f2688c);
                break;
            case 8:
                analyticsListener.onDeviceInfoChanged((AnalyticsListener.EventTime) this.f2687b, (DeviceInfo) this.f2688c);
                break;
            case 9:
                DefaultAnalyticsCollector.lambda$onVideoSizeChanged$59((AnalyticsListener.EventTime) this.f2687b, (VideoSize) this.f2688c, analyticsListener);
                break;
        }
    }

    @Override
    public void invoke(Object obj, FlagSet flagSet) {
        ((DefaultAnalyticsCollector) this.f2687b).lambda$setPlayer$1((Player) this.f2688c, (AnalyticsListener) obj, flagSet);
    }
}
