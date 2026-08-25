package p116ka;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.RunnableC0126c;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import com.youth.banner.Banner;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.util.BannerUtils;
import ga.C2621d;
import ga.C2630m;
import ga.C2632o;
import ga.EnumC2629l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.AuthInfo;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EventBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p000a.RunnableC0005f;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p055ea.C2428a;
import p055ea.EnumC2432c;
import p155o8.C3276a;
import p156o9.AbstractC3280d;
import p214ta.C3877a;

public class ViewOnKeyListenerC2925j extends C2909b implements View.OnKeyListener, View.OnClickListener, View.OnFocusChangeListener {

    public static final String f9925d0 = AbstractC0032a.m165s("qkAb4XeWHJKPShjw\n", "4i92hDHkffU=\n");

    public View f9926U;

    public Banner f9927V;

    public EventBean f9928W;

    public C3877a f9929X;

    public FrameLayout f9930Y;

    public RelativeLayout f9931Z;

    public FrameLayout f9932b0;

    public C3276a f9933c0 = null;

    public static void m5920Q(ViewOnKeyListenerC2925j viewOnKeyListenerC2925j, ArrayList arrayList) {
        viewOnKeyListenerC2925j.getClass();
        if (arrayList.isEmpty()) {
            return;
        }
        viewOnKeyListenerC2925j.m5925V(0, arrayList);
        if (viewOnKeyListenerC2925j.m1319h() == null) {
            return;
        }
        viewOnKeyListenerC2925j.f9927V.setAdapter(new C2923i(viewOnKeyListenerC2925j, arrayList));
        viewOnKeyListenerC2925j.f9927V.addOnPageChangeListener(new C0069f(viewOnKeyListenerC2925j, 28, arrayList));
        RectangleIndicator rectangleIndicator = (RectangleIndicator) viewOnKeyListenerC2925j.f9926U.findViewById(R.id.indicator);
        viewOnKeyListenerC2925j.f9927V.setIndicator(rectangleIndicator, false);
        String str = AbstractC2442h.f8595a;
        viewOnKeyListenerC2925j.f9927V.setIndicatorWidth(10, 100);
        viewOnKeyListenerC2925j.f9927V.setIndicatorNormalColorRes(R.color.home_banner_indicator_normal);
        viewOnKeyListenerC2925j.f9927V.setIndicatorSelectedColorRes(R.color.home_banner_indicator_selected);
        viewOnKeyListenerC2925j.f9927V.setIndicatorHeight(10);
        View viewFindViewById = viewOnKeyListenerC2925j.f9926U.findViewById(R.id.indicator_bg);
        if (viewFindViewById != null) {
            rectangleIndicator.post(new RunnableC0126c(viewOnKeyListenerC2925j, rectangleIndicator, viewFindViewById));
        }
        viewOnKeyListenerC2925j.f9927V.start();
    }

    public static String m5921T(int i6, EnumC2432c enumC2432c) {
        ChannelBean.TagsBean tagsBeanM5654b;
        if (i6 == 0) {
            return null;
        }
        if (enumC2432c == EnumC2432c.f8520a && C2621d.f9110d != null) {
            for (Map.Entry entry : C2621d.f9110d.entrySet()) {
                if (((Integer) entry.getKey()).intValue() == i6) {
                    return ((Group) entry.getValue()).name;
                }
            }
        }
        if (enumC2432c != EnumC2432c.f8521b || (tagsBeanM5654b = C2632o.m5654b(i6)) == null) {
            return null;
        }
        return tagsBeanM5654b.getName().getInit();
    }

    public final void m5922R(EventBean eventBean) {
        Spark spark;
        if (eventBean == null || (spark = (Spark) m1319h()) == null) {
            return;
        }
        if (eventBean.tag == 0) {
            int i6 = eventBean.channel;
            if (i6 == 0) {
                return;
            }
            String strM5648e = C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9137h) + AbstractC0032a.m165s("Rbs=\n", "avvx8MHRJ+0=\n") + i6);
            try {
                OkGo.getInstance().cancelTag(this);
                ((GetRequest) ((GetRequest) ((GetRequest) ((GetRequest) OkGo.get(strM5648e).removeHeader(AbstractC0032a.m165s("Gt3+rzY3PvQh2g==\n", "T66b3Rt2WZE=\n"))).headers(AbstractC0032a.m165s("5YtF1FQWsSTejA==\n", "sPggpnlX1kE=\n"), C2428a.f8504m)).tag(this)).cacheMode(CacheMode.NO_CACHE)).execute(new C2917f(this, 1));
                return;
            } catch (Exception unused) {
                String strM165s = AbstractC0032a.m165s("pxTragfK4MCoEPEkFMmk4rAYvy8D1+vx4Q==\n", "wHGfSnGlhIM=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(f9925d0, strM165s);
                return;
            }
        }
        AbstractC0032a.m165s("yl1LvECFuSGUFA==\n", "rjQ52SPx7U4=\n");
        if (m5921T(eventBean.tag, EnumC2432c.f8520a) != null) {
            AbstractC3280d.m6606y(spark.f11033B);
            Message message = new Message();
            message.what = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
            message.arg1 = eventBean.tag;
            Spark.f11002X1.sendMessageDelayed(message, 100L);
            return;
        }
        if (m5921T(eventBean.tag, EnumC2432c.f8521b) != null) {
            int i10 = eventBean.tag;
            AbstractC3280d.m6606y(spark.f11036C);
            Message message2 = new Message();
            message2.what = 131;
            message2.arg1 = i10;
            Spark.f11002X1.sendMessageDelayed(message2, 200L);
        }
    }

    public final void m5923S() {
        String strM165s = AbstractC0032a.m165s("7WnKPHL9tlnlacwsOtiyQ/9l0Dggnw==\n", "iwy+Xxq/1zc=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9925d0, strM165s);
        m5926W();
        String strM5649h = C2630m.m5649h(EnumC2629l.f9139j);
        if (strM5649h == null || strM5649h.isEmpty()) {
            return;
        }
        ((GetRequest) ((GetRequest) ((GetRequest) ((GetRequest) OkGo.get(strM5649h).removeHeader(AbstractC0032a.m165s("zZvS1sCnmo/2nA==\n", "mOi3pO3m/eo=\n"))).headers(AbstractC0032a.m165s("3COs5KH1bfvnJA==\n", "iVDJloy0Cp4=\n"), C2428a.f8504m)).tag(this)).cacheMode(CacheMode.NO_CACHE)).execute(new C2917f(this, 0));
    }

    public final void m5924U() {
        String strM165s = AbstractC0032a.m165s("INKCovmE6EMz0Jyy+pWUEQ==\n", "Urfx15ThrjE=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9925d0, strM165s);
        C3333o c3333o = C3333o.f11249f;
        if (!c3333o.f11254e) {
            AbstractC3280d.m6606y(this.f9927V);
        } else {
            if (c3333o.m6773f()) {
                return;
            }
            this.f9929X.m7736f();
        }
    }

    public final void m5925V(int i6, ArrayList arrayList) {
        TextView textView;
        this.f9928W = (EventBean) arrayList.get(i6);
        AbstractC0032a.m165s("N+qraOCzBJ0227Ze7bhQ2A==\n", "RI/fKoHdavg=\n");
        String str = this.f9928W.title;
        View view = this.f9926U;
        if (view == null || (textView = (TextView) view.findViewById(R.id.home_banner_title)) == null) {
            return;
        }
        textView.setText(this.f9928W.title);
        textView.post(new RunnableC0005f(21, textView));
    }

    public final void m5926W() {
        AuthInfo authInfo;
        View view = this.f9926U;
        if (view == null || (authInfo = C2630m.f9145e) == null || authInfo.user == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.home_username);
        if (C2630m.f9145e.user.user_name != null) {
            if (AbstractC3331m.m6756f(0, AbstractC2440g.f8553b).intValue() == 2) {
                textView.setText(AbstractC0032a.m165s("kZ48Vg==\n", "sch1BhGMSJk=\n"));
            } else {
                textView.setText(C2630m.f9145e.user.user_name.replace(AbstractC2442h.f8597c, ""));
            }
        }
        TextView textView2 = (TextView) this.f9926U.findViewById(R.id.home_expire);
        if (C2630m.f9145e.user.EndTime > 0) {
            textView2.setText(new SimpleDateFormat(AbstractC0032a.m165s("Rm26ZZSTZbdbcA==\n", "IgmXKNm+HM4=\n"), Locale.getDefault()).format(Long.valueOf(C2630m.f9145e.user.EndTime)));
        } else {
            textView2.setText(m1324m().getString(R.string.nolimit));
        }
    }

    @Override
    public final void onClick(View view) {
        if (view.getId() == this.f9927V.getId()) {
            Spark.f11002X1.sendEmptyMessage(111);
        }
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        view.getId();
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        int currentItem;
        if (keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 0) {
            return false;
        }
        if (view.getId() == this.f9927V.getId()) {
            int itemCount = this.f9927V.getItemCount();
            if (i6 != 4) {
                if (i6 != 66) {
                    switch (i6) {
                        case 19:
                            return true;
                        case 20:
                            String str = AbstractC2442h.f8595a;
                            return true;
                        case 21:
                            if (this.f9927V.getRealCount() != 0) {
                                int currentItem2 = (this.f9927V.getCurrentItem() - 1) % itemCount;
                                if (currentItem2 == 0) {
                                    if (m1319h() != null) {
                                        ((Spark) m1319h()).m6731x0(Boolean.TRUE);
                                        AbstractC3280d.m6606y(((Spark) m1319h()).f11051H);
                                    }
                                    Banner banner = this.f9927V;
                                    if (banner != null) {
                                        banner.isAutoLoop(true);
                                        this.f9927V.start();
                                    }
                                    return true;
                                }
                                if (currentItem2 == itemCount - 1) {
                                    currentItem2 = 1;
                                }
                                this.f9927V.setCurrentItem(currentItem2, true);
                            }
                            if (this.f9927V.getRealCount() > 1 && this.f9927V.getIndicator() != null) {
                                this.f9927V.getIndicator().onPageSelected(BannerUtils.getRealPosition(this.f9927V.isInfiniteLoop(), this.f9927V.getCurrentItem(), this.f9927V.getRealCount()));
                            }
                            break;
                        case 22:
                            if (this.f9927V.getRealCount() != 0 && (currentItem = (this.f9927V.getCurrentItem() + 1) % itemCount) != itemCount - 1) {
                                this.f9927V.setCurrentItem(currentItem, true);
                            }
                            if (this.f9927V.getRealCount() > 1) {
                                this.f9927V.getIndicator().onPageSelected(BannerUtils.getRealPosition(this.f9927V.isInfiniteLoop(), this.f9927V.getCurrentItem(), this.f9927V.getRealCount()));
                            }
                            break;
                        case 23:
                            break;
                        default:
                            if (this.f9927V.getRealCount() > 1) {
                                this.f9927V.getIndicator().onPageSelected(BannerUtils.getRealPosition(this.f9927V.isInfiniteLoop(), this.f9927V.getCurrentItem(), this.f9927V.getRealCount()));
                            }
                            break;
                    }
                }
                m5922R(this.f9928W);
                return true;
            }
            if (C3333o.f11249f.f11254e) {
                this.f9929X.m7736f();
                return true;
            }
            if (m1319h() != null) {
                ((Spark) m1319h()).m6731x0(Boolean.TRUE);
                AbstractC3280d.m6606y(((Spark) m1319h()).f11051H);
            }
            Banner banner2 = this.f9927V;
            if (banner2 != null) {
                banner2.isAutoLoop(true);
                this.f9927V.start();
            }
        }
        return true;
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = AbstractC2442h.f8595a;
        this.f9926U = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        this.f9929X = (C3877a) new C0026b(m1311J()).m136o(C3877a.class);
        this.f9927V = (Banner) this.f9926U.findViewById(R.id.banner);
        this.f9932b0 = (FrameLayout) this.f9926U.findViewById(R.id.home_root_view);
        this.f9930Y = (FrameLayout) this.f9926U.findViewById(R.id.vod_detail_container);
        this.f9931Z = (RelativeLayout) this.f9926U.findViewById(R.id.home_layout);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EventBean(Integer.valueOf(R.mipmap.home_banner), "", 1));
        this.f9927V.setAdapter(new C2919g(this, arrayList));
        m5926W();
        this.f9927V.setOnClickListener(this);
        this.f9927V.setOnKeyListener(this);
        this.f9927V.setOnFocusChangeListener(this);
        return this.f9926U;
    }
}
