package p055ea;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.RadioButton;
import androidx.leanback.widget.VerticalGridView;
import androidx.lifecycle.InterfaceC0520e0;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.tencent.mars.xlog.Log;
import com.tvbus.engine.TVCore;
import com.tvbus.engine.TVListener;
import ga.C2621d;
import org.bitspark.android.R$drawable;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.SpeedBean;
import org.bitspark.android.beans.SubtitleMenu;
import org.bitspark.android.beans.VodMenu;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3320b;
import p000a.RunnableC0005f;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p007a7.C0069f;
import p014b1.RunnableC1238l;
import p063fa.C2550o1;
import p063fa.C2569x0;
import p063fa.InterfaceC2549o0;
import p116ka.ViewOnKeyListenerC2932m0;
import p156o9.AbstractC3280d;
import p214ta.C3877a;
import sa.InterfaceC3735f;

public final class C2448k implements InterfaceC0520e0, InterfaceC3735f, InterfaceC2549o0, TVListener {

    public final int f8629a;

    public final Spark f8630b;

    public C2448k(Spark spark, int i6) {
        this.f8629a = i6;
        this.f8630b = spark;
    }

    @Override
    public void mo5482a(int i6, View view) {
        int i10;
        TrackGroupArray trackGroups;
        switch (this.f8629a) {
            case 10:
                AbstractC3280d.m6607z(this.f8630b.f11034B0, i6);
                break;
            case 11:
            default:
                Spark spark = this.f8630b;
                spark.f11059J1.setPlaybackSpeed(((SpeedBean) spark.f11120i0.f13012y.get(i6)).getSpeed());
                spark.f11120i0.f13010w = i6;
                C2550o1 c2550o1 = spark.f11142t0;
                c2550o1.f8752e = i6;
                c2550o1.notifyDataSetChanged();
                break;
            case 12:
                Spark spark2 = this.f8630b;
                if (i6 < 0) {
                    spark2.getClass();
                } else if (i6 < spark2.f11120i0.f12987D.size()) {
                    MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = spark2.f11074O1.getCurrentMappedTrackInfo();
                    SubtitleMenu subtitleMenu = (SubtitleMenu) spark2.f11120i0.f12987D.get(i6);
                    MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo2 = spark2.f11074O1.getCurrentMappedTrackInfo();
                    if (currentMappedTrackInfo2 == null) {
                        i10 = -1;
                    } else {
                        i10 = 0;
                        while (true) {
                            if (i10 >= currentMappedTrackInfo2.getRendererCount()) {
                                i10 = -1;
                            } else if (currentMappedTrackInfo2.getRendererType(i10) != 1 || (trackGroups = currentMappedTrackInfo2.getTrackGroups(i10)) == null || trackGroups.length <= 0) {
                                i10++;
                            }
                        }
                    }
                    if (i10 != -1) {
                        TrackGroupArray trackGroups2 = currentMappedTrackInfo.getTrackGroups(i10);
                        DefaultTrackSelector defaultTrackSelector = spark2.f11074O1;
                        defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setSelectionOverride(i10, trackGroups2, new DefaultTrackSelector.SelectionOverride(subtitleMenu.getGroupIndex(), subtitleMenu.getTrackIndex())).build());
                    }
                }
                C2550o1 c2550o2 = spark2.f11151x0;
                c2550o2.f8752e = i6;
                c2550o2.notifyDataSetChanged();
                spark2.f11120i0.f13008u = i6;
                break;
            case 13:
                Spark spark3 = this.f8630b;
                spark3.f11120i0.f13007t = i6;
                if (i6 == spark3.f11154y0.f8755h.size() - 1) {
                    spark3.m6705U();
                } else {
                    spark3.m6727r0(i6, spark3.f11120i0.f12985B);
                }
                C2550o1 c2550o3 = spark3.f11154y0;
                c2550o3.f8752e = i6;
                c2550o3.notifyDataSetChanged();
                break;
        }
    }

    public void m5485b() {
        AbstractC0032a.m165s("+hWVKhPd\n", "uEbYS3qzjDE=\n");
        AbstractC0032a.m165s("Ps1gwrSyyR8mx0zDgr7FSnI=\n", "UqIBpubXpHA=\n");
        String str = C3320b.m6737d().f11215m;
        try {
            this.f8630b.runOnUiThread(new RunnableC2431b0(this));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override
    public void mo1200c(Object obj) {
        switch (this.f8629a) {
            case 0:
                int iIntValue = ((Integer) obj).intValue();
                Spark spark = this.f8630b;
                if (iIntValue == 1) {
                    VerticalGridView verticalGridView = spark.f11054I.f10000W;
                    if (verticalGridView != null) {
                        verticalGridView.setFocusScrollStrategy(1);
                    }
                    spark.f11138r0.setVisibility(0);
                    spark.m6719k0(true);
                    return;
                }
                spark.f11138r0.setVisibility(8);
                if (spark.getCurrentFocus() == null || !(spark.getCurrentFocus() instanceof RadioButton)) {
                    spark.m6731x0(Boolean.FALSE);
                    return;
                } else {
                    spark.m6731x0(Boolean.TRUE);
                    return;
                }
            case 1:
                Integer num = (Integer) obj;
                Spark spark2 = this.f8630b;
                if (spark2.f11120i0.m7738h()) {
                    return;
                }
                if (num.intValue() != 0) {
                    spark2.m6719k0(true);
                    return;
                } else if (spark2.getCurrentFocus() == null || !(spark2.getCurrentFocus() instanceof RadioButton)) {
                    spark2.m6704T(true);
                    return;
                } else {
                    spark2.m6719k0(true);
                    return;
                }
            case 2:
                this.f8630b.f11140s0.post(new RunnableC0038c(this, 13, (String) obj));
                return;
            case 3:
                int iIntValue2 = ((Integer) obj).intValue();
                Spark spark3 = this.f8630b;
                if (iIntValue2 == 1) {
                    if (spark3.f11065L1.isPlaying() && Spark.f11011g2) {
                        Spark.f11002X1.sendEmptyMessage(100);
                        return;
                    }
                    String strM165s = AbstractC0032a.m165s("ah05X69h\n", "KE50PsYPdzU=\n");
                    String strM165s2 = AbstractC0032a.m165s("214SWNxvkM7sXxxD4n0=\n", "qDZ9L40a+bo=\n");
                    boolean z7 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, strM165s2);
                    AbstractC3331m.m6766p(spark3);
                    return;
                }
                if (iIntValue2 == 2) {
                    if (spark3.f11065L1.isPlaying() && Spark.f11011g2) {
                        Spark.f11002X1.sendEmptyMessage(100);
                        return;
                    } else {
                        Spark.f11002X1.sendEmptyMessage(105);
                        return;
                    }
                }
                if (iIntValue2 == 3) {
                    C2569x0 c2569x0 = spark3.f11057J.f9965d0;
                    if (c2569x0 != null) {
                        boolean zIsPlaying = spark3.f11065L1.isPlaying();
                        boolean z10 = Spark.f11011g2;
                        c2569x0.getClass();
                        if (zIsPlaying && z10) {
                            Spark.f11002X1.sendEmptyMessage(100);
                            return;
                        } else if (c2569x0.f8875b <= 0) {
                            Spark.f11002X1.sendEmptyMessage(144);
                            return;
                        } else {
                            c2569x0.f8878e.getLayoutManager();
                            c2569x0.m5558a(-c2569x0.f8875b);
                            return;
                        }
                    }
                    return;
                }
                if (iIntValue2 == 4) {
                    spark3.getClass();
                    throw null;
                }
                if (iIntValue2 == 5) {
                    AbstractC3280d.m6606y(spark3.f11057J.f9958V);
                    return;
                }
                if (iIntValue2 != 120) {
                    return;
                }
                ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = spark3.f11057J;
                viewOnKeyListenerC2932m0.getClass();
                String strM165s3 = AbstractC0032a.m165s("iEfE6F22cvqVZM7zdot46I5Whrx1vGn7oE3f6WifY+CLcNX7c60=\n", "5iK8nBvZEY8=\n");
                boolean z11 = AbstractC3331m.f11244b;
                Log.m5049i(ViewOnKeyListenerC2932m0.f9947B0, strM165s3);
                if (viewOnKeyListenerC2932m0.f9979r0) {
                    viewOnKeyListenerC2932m0.f9964c0.f8888e = new C0069f((Object) viewOnKeyListenerC2932m0, 29, (Object) 5);
                    return;
                } else if (ViewOnKeyListenerC2932m0.f9952G0) {
                    AbstractC3280d.m6606y(viewOnKeyListenerC2932m0.f9971j0);
                    return;
                } else {
                    AbstractC3280d.m6606y(viewOnKeyListenerC2932m0.f9960X);
                    return;
                }
            default:
                ChannelBean channelBean = (ChannelBean) obj;
                Spark spark4 = this.f8630b;
                spark4.getClass();
                spark4.m6717h0(Spark.m6671Y(), R$drawable.home_live_channel_not_uploaded_2x, this.f8630b.f11037C0);
                int chid = channelBean.getChid();
                if (channelBean.getLevel() >= 18) {
                    this.f8630b.f11137q1.setVisibility(8);
                } else {
                    this.f8630b.f11137q1.setVisibility(0);
                    if (C2621d.f9112f.contains(chid + "")) {
                        this.f8630b.f11137q1.setChecked(true);
                    } else {
                        this.f8630b.f11137q1.setChecked(false);
                    }
                }
                this.f8630b.f11120i0.f12986C.clear();
                return;
        }
    }

    public void m5486d(int i6, Object obj) {
        switch (this.f8629a) {
            case 9:
                VodMenu vodMenu = (VodMenu) obj;
                Spark spark = this.f8630b;
                spark.f11120i0.f13011x = i6;
                spark.f11144u0.f8752e = i6;
                spark.f11031A0.setVisibility(0);
                if (vodMenu.getName().equals(EnumC2436e.f8538b.name())) {
                    spark.f11148w0.mo5549a(spark.f11120i0.f13013z);
                    if (spark.f11120i0.f13013z.size() <= 1) {
                        spark.f11120i0.f12984A.clear();
                        C3877a c3877a = spark.f11120i0;
                        c3877a.f12984A.addAll(c3877a.f13004q.getSources());
                    } else if (spark.f11120i0.f13013z.size() > 1) {
                        C2550o1 c2550o1 = spark.f11148w0;
                        C3877a c3877a2 = spark.f11120i0;
                        int i10 = c3877a2.f13006s;
                        c2550o1.f8752e = i10;
                        c3877a2.m7743m(i10);
                    }
                    if (!spark.f11120i0.f12984A.isEmpty()) {
                        spark.f11146v0.mo5549a(spark.f11120i0.f12984A);
                        spark.f11146v0.f8752e = spark.f11120i0.m7734d(-1);
                    }
                    if (spark.f11120i0.f13013z.size() <= 1) {
                        spark.f11034B0.setVisibility(8);
                    } else {
                        spark.f11034B0.setAdapter(spark.f11148w0);
                        spark.f11034B0.setVisibility(0);
                        spark.f11148w0.notifyDataSetChanged();
                    }
                    spark.f11031A0.setAdapter(spark.f11146v0);
                    spark.f11146v0.notifyDataSetChanged();
                    spark.f11031A0.setVisibility(0);
                    spark.f11031A0.smoothScrollToPosition(spark.f11146v0.f8752e);
                } else if (vodMenu.getName().equals(EnumC2436e.f8539c.name())) {
                    spark.f11151x0.mo5549a(spark.f11120i0.f12987D);
                    C2550o1 c2550o2 = spark.f11151x0;
                    c2550o2.f8752e = spark.f11120i0.f13008u;
                    spark.f11031A0.setAdapter(c2550o2);
                    spark.f11034B0.setVisibility(8);
                } else if (vodMenu.getName().equals(EnumC2436e.f8540d.name())) {
                    spark.f11154y0.mo5549a(spark.f11120i0.f12985B);
                    C2550o1 c2550o3 = spark.f11154y0;
                    c2550o3.f8752e = spark.f11120i0.f13007t;
                    spark.f11031A0.setAdapter(c2550o3);
                    spark.f11034B0.setVisibility(8);
                } else if (vodMenu.getName().equals(EnumC2436e.f8541e.name())) {
                    spark.f11142t0.mo5549a(spark.f11120i0.f13012y);
                    C2550o1 c2550o4 = spark.f11142t0;
                    c2550o4.f8752e = spark.f11120i0.f13010w;
                    spark.f11031A0.setAdapter(c2550o4);
                    spark.f11034B0.setVisibility(8);
                }
                break;
            default:
                Spark spark2 = this.f8630b;
                C3877a c3877a3 = spark2.f11120i0;
                c3877a3.f13006s = i6;
                c3877a3.m7743m(i6);
                spark2.f11146v0.f8752e = spark2.f11120i0.m7734d(-1);
                spark2.f11146v0.mo5549a(spark2.f11120i0.f12984A);
                spark2.f11146v0.notifyDataSetChanged();
                ViewOnKeyListenerC2932m0.f9950E0.postDelayed(new RunnableC0005f(15, this), 100L);
                break;
        }
    }

    @Override
    public void onInfo(String str) {
        AbstractC0032a.m165s("l1VaMHDy\n", "1QYXURmcG0U=\n");
        AbstractC0032a.m165s("T6OPkzCt91R1vKKaLej5FTXV\n", "G/XM/ELI1zs=\n");
        if (Spark.m6669Q(this.f8630b, AbstractC0032a.m165s("JHyEHP1L\n", "SxLNcpskaeg=\n"), str)) {
            Spark.f11002X1.sendEmptyMessage(71);
        }
        Spark.f11002X1.sendEmptyMessage(201);
    }

    @Override
    public void onInited(String str) {
        String strM165s = AbstractC0032a.m165s("5fmGQQpu\n", "p6rLIGMAQPw=\n");
        String strM5496j = AbstractC2460q.m5496j("9Gpj+tHX2KLTHEn7ysadr4ASDruD\n", "oDwglaOy+Ms=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        Log.m5049i(AbstractC0032a.m165s("RPgMe/oj\n", "BqtBGpNNdWw=\n"), AbstractC0032a.m165s("lAGpdnyhqZqPFK5wfLv51t5J9T0xv+fW3kn1PTG/0w==\n", "4HfLAw+B2eg=\n") + TVCore.getInstance().getVersion(2026) + AbstractC0032a.m165s("YldQZofIB6ZUV1Bmh8gHplRXUFA=\n", "aGtsWrv0O5o=\n"));
        Spark.m6669Q(this.f8630b, AbstractC0032a.m165s("UxQXggnFiBQ=\n", "PHpe7GCx7XA=\n"), str);
    }

    @Override
    public void onPrepared(String str) {
        String strM165s = AbstractC0032a.m165s("7OTWahAf\n", "rrebC3lxFyg=\n");
        String strM5496j = AbstractC2460q.m5496j("zTNihETdSlX3NVOORtkYX/1FD8UYmA==\n", "mWUh6za4ajo=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        String strM165s2 = AbstractC0032a.m165s("1m5G02MWW4DcZA==\n", "uQAWoQZmOvI=\n");
        Spark spark = this.f8630b;
        boolean zM6669Q = Spark.m6669Q(spark, strM165s2, str);
        if (spark.m6712c0()) {
            Spark.f11002X1.post(new RunnableC1238l(3));
        }
        if (C3320b.m6737d().f11204b) {
            C3320b.m6737d().f11203a.m5485b();
            return;
        }
        if (zM6669Q) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString(AbstractC0032a.m165s("AAC9Fg3Y6Coe\n", "dmnZc2KIiV4=\n"), Spark.f11012h2);
            message.what = 81;
            message.setData(bundle);
            Spark.f11002X1.sendMessage(message);
            Spark.f11014j2 = false;
            String str2 = AbstractC2442h.f8595a;
        }
    }

    @Override
    public void onQuit(String str) {
        String strM165s = AbstractC0032a.m165s("zSDkvOBl\n", "j3Op3YkLuzY=\n");
        String strM5496j = AbstractC2460q.m5496j("ibqTyn8m0j6zvaXMeWPcf/PM\n", "3ezQpQ1D8lE=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
    }

    @Override
    public void onStart(String str) {
        String strM165s = AbstractC0032a.m165s("l6Mk2b5e\n", "1fBpuNcwaPE=\n");
        String strM5496j = AbstractC2460q.m5496j("eTUg3FBSab5DMBfSUENp/wNNQw==\n", "LWNjsyI3SdE=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        String strM165s2 = AbstractC0032a.m165s("/MJTpFAM3w==\n", "k6wA0DF+qzc=\n");
        Spark spark = this.f8630b;
        Spark.m6669Q(spark, strM165s2, str);
        if (Spark.f11011g2) {
            spark.m6688D0(0.9f);
        } else {
            spark.f11106b0.post(new RunnableC2470v(spark, 0));
        }
    }

    @Override
    public void onStop(String str) {
        String strM165s = AbstractC0032a.m165s("MmXd2RhY\n", "cDaQuHE2Mx4=\n");
        String strM5496j = AbstractC2460q.m5496j("nO8vz9Z7Rzam6hjP1D5Jd+aZ\n", "yLlsoKQeZ1k=\n", new StringBuilder(), str);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM5496j);
        Spark.m6669Q(this.f8630b, AbstractC0032a.m165s("uZQYHPly\n", "1vpLaJYCecs=\n"), str);
    }
}
