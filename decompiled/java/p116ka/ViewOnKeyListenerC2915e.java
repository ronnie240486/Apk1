package p116ka;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import ga.C2625h;
import ga.C2626i;
import ga.C2630m;
import ga.EnumC2629l;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.utils.AbstractC3331m;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.C2428a;
import p055ea.EnumC2434d;
import p063fa.C2560t;
import p155o8.C3276a;
import p193ra.C3663f;
import p214ta.C3877a;
import sa.C3731b;

public class ViewOnKeyListenerC2915e extends C2909b implements View.OnKeyListener, View.OnFocusChangeListener, View.OnTouchListener {

    public static final String f9877j0 = AbstractC0032a.m165s("MDXjq3l0Wi0L\n", "cmarwgoANV8=\n");

    public static Constants$VIDEO_TYPE f9878k0;

    public static HandlerC1731y0 f9879l0;

    public View f9880U;

    public RelativeLayout f9881V;

    public LinearLayout f9882W;

    public RecyclerView f9883X;

    public C2560t f9884Y;

    public RecyclerView f9885Z;

    public C2560t f9886b0;

    public GridLayoutManager f9887c0;

    public RelativeLayout f9888d0;

    public RelativeLayout f9889e0;

    public boolean f9890f0 = false;

    public C3877a f9891g0;

    public C3276a f9892h0;

    public FrameLayout f9893i0;

    public ViewOnKeyListenerC2915e() {
        f9879l0 = new HandlerC1731y0(Looper.getMainLooper(), 1, false);
        this.f9892h0 = null;
        this.f9893i0 = null;
    }

    @Override
    public final void mo1270B() {
        String strM165s = AbstractC0032a.m165s("EzThs4XO0lEXOuI=\n", "ZVuF/uCgpxc=\n");
        String strM165s2 = AbstractC0032a.m165s("49m/Rvu7Bg==\n", "jLfsMprJctg=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        super.mo1270B();
        this.f9890f0 = true;
    }

    public final void m5908Q() {
        int i6 = 1;
        int i10 = 0;
        String strM165s = AbstractC0032a.m165s("ojXkLVUnqsC+HuQ9c3vrmw==\n", "zlqFSRJVxbU=\n");
        boolean z7 = AbstractC3331m.f11244b;
        String str = f9877j0;
        Log.m5049i(str, strM165s);
        if (!this.f9890f0 || Spark.f11003Y1 == null) {
            Log.m5049i(str, AbstractC0032a.m165s("waPyR1CL4w7JoehWGc+xDdy46V0=\n", "qM2bMzXvw2g=\n"));
            return;
        }
        if (this.f9883X == null || C2626i.m5634c(C2626i.f9124e.toArray()).size() <= 0) {
            this.f9883X.setVisibility(8);
            this.f9888d0.setVisibility(0);
        } else {
            try {
                Spark.f11003Y1.getClass();
                C2560t c2560t = new C2560t(C2626i.m5634c(C2626i.f9124e.toArray()), Constants$VIDEO_TYPE.BSLIVE);
                this.f9884Y = c2560t;
                c2560t.f8904h = new C2913d(this, i10);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f9883X.setAdapter(this.f9884Y);
            if (f9878k0 == null) {
                f9878k0 = Constants$VIDEO_TYPE.BSLIVE;
            }
            this.f9883X.setVisibility(0);
            this.f9888d0.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("9cIKqRcvJkzx1Dy3FzklA6KQTo8LMD4=\n", "g61u4X5cUiM=\n"));
        sb.append(this.f9885Z != null);
        Log.m5049i(str, sb.toString());
        if (this.f9885Z != null) {
            Spark.f11003Y1.getClass();
            if (C2626i.m5634c(C2626i.f9125f.toArray()).size() > 0) {
                try {
                    Spark.f11003Y1.getClass();
                    this.f9886b0 = new C2560t(C2626i.m5634c(C2626i.f9125f.toArray()), Constants$VIDEO_TYPE.BSVOD);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                this.f9885Z.setAdapter(this.f9886b0);
                this.f9886b0.f8904h = new C2913d(this, i6);
                if (f9878k0 == null) {
                    f9878k0 = Constants$VIDEO_TYPE.BSVOD;
                }
                this.f9885Z.setVisibility(0);
                this.f9889e0.setVisibility(8);
            } else {
                this.f9885Z.setVisibility(8);
                this.f9889e0.setVisibility(0);
            }
        } else {
            this.f9885Z.setVisibility(8);
            this.f9889e0.setVisibility(0);
        }
        Spark.f11002X1.sendEmptyMessage(114);
    }

    public final void m5909R(HistoryBean historyBean) {
        EpgBeans.EpgBean epgBeanM5629b;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE = historyBean.type;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE2 = Constants$VIDEO_TYPE.BSLIVE;
        if (constants$VIDEO_TYPE == constants$VIDEO_TYPE2 && C2621d.f9109c != null) {
            ChannelBean channelBean = (ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid));
            if (channelBean != null) {
                C3663f.m7415b().m7420f(channelBean, Boolean.FALSE, 0, EnumC2434d.f8534f.name());
                f9878k0 = constants$VIDEO_TYPE2;
                return;
            }
            return;
        }
        Constants$VIDEO_TYPE constants$VIDEO_TYPE3 = historyBean.type;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE4 = Constants$VIDEO_TYPE.BSPALYBACK;
        if (constants$VIDEO_TYPE3 == constants$VIDEO_TYPE4 && C2621d.f9109c != null) {
            ChannelBean channelBean2 = (ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid));
            if (channelBean2 == null || (epgBeanM5629b = C2625h.m5629b(historyBean.chid, historyBean.subId)) == null) {
                return;
            }
            Message message = new Message();
            message.what = 80;
            Bundle bundle = new Bundle();
            bundle.putInt(AbstractC0032a.m165s("jDQDYA==\n", "71xqBNsE9l0=\n"), channelBean2.getChid());
            bundle.putString(AbstractC0032a.m165s("hYCUqzU=\n", "9vX24lEVpVQ=\n"), historyBean.subId);
            bundle.putString(AbstractC0032a.m165s("XKQW\n", "KdZ6/SPffks=\n"), epgBeanM5629b.getPlaybackUrl());
            bundle.putString(AbstractC0032a.m165s("fnHX+A==\n", "EBC6nVpZPZ4=\n"), channelBean2.getName().getInit());
            bundle.putString(AbstractC0032a.m165s("sdcXx4BPAdw=\n", "wqJ1s+k7bbk=\n"), epgBeanM5629b.getName());
            bundle.putString(AbstractC0032a.m165s("iBIlgw==\n", "/GtV5p4rM3c=\n"), constants$VIDEO_TYPE4.name());
            bundle.putString(AbstractC0032a.m165s("Ch3Tgr8Kv7A=\n", "Z3i99+tzz9U=\n"), EnumC2434d.f8534f.name());
            message.setData(bundle);
            Spark.f11002X1.sendMessage(message);
            f9878k0 = Constants$VIDEO_TYPE.BSVOD;
            return;
        }
        Constants$VIDEO_TYPE constants$VIDEO_TYPE5 = historyBean.type;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE6 = Constants$VIDEO_TYPE.BSVOD;
        if (constants$VIDEO_TYPE5 == constants$VIDEO_TYPE6 || constants$VIDEO_TYPE5 == Constants$VIDEO_TYPE.STATIC) {
            Message message2 = new Message();
            message2.what = 86;
            Bundle bundle2 = new Bundle();
            bundle2.putString(AbstractC0032a.m165s("AwQR4Zcxmvk=\n", "bmF/lMNI6pw=\n"), EnumC2434d.f8534f.name());
            message2.setData(bundle2);
            Spark.f11002X1.sendMessage(message2);
            f9878k0 = constants$VIDEO_TYPE6;
            this.f9891g0.f13009v = true;
            String strM5648e = C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9137h) + AbstractC0032a.m165s("HaM=\n", "MuM0LuvnOMo=\n") + historyBean.chid);
            try {
                OkGo.getInstance().cancelTag(this);
                ((GetRequest) ((GetRequest) ((GetRequest) ((GetRequest) OkGo.get(strM5648e).removeHeader(AbstractC0032a.m165s("0Owz4ZacHBPr6w==\n", "hZ9Wk7vde3Y=\n"))).headers(AbstractC0032a.m165s("mZX6FBgOwzKikg==\n", "zOafZjVPpFc=\n"), C2428a.f8504m)).tag(this)).cacheMode(CacheMode.NO_CACHE)).execute(new C2911c(this, historyBean));
            } catch (Exception unused) {
                String strM165s = AbstractC0032a.m165s("hTyD4MJwqomKOJmu0XPuq5Iw16XGbaG4ww==\n", "4ln3wLQfzso=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(f9877j0, strM165s);
            }
        }
    }

    public final void m5910S() {
        String strM165s = AbstractC0032a.m165s("6IC6n2LXIyjpkY2bYpJJZ7M=\n", "nfDe/hayZ0k=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9877j0, strM165s);
        C2560t c2560t = this.f9884Y;
        if (c2560t != null) {
            c2560t.notifyDataSetChanged();
        }
        C2560t c2560t2 = this.f9886b0;
        if (c2560t2 != null) {
            c2560t2.notifyDataSetChanged();
        }
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        int id = view.getId();
        String str = f9877j0;
        if (z7 && id == this.f9883X.getId()) {
            String strM165s = AbstractC0032a.m165s("oD9HT3N6nN6jJEh4bXqK3ew5X2xUcJrZ\n", "zFYxKjsT76o=\n");
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s);
            this.f9883X.requestFocus();
            this.f9883X.requestFocusFromTouch();
            return;
        }
        if (z7 && id == this.f9885Z.getId()) {
            String strM165s2 = AbstractC0032a.m165s("vUKrwwOQwAq5VJ3dA4bDRaRDieQJlsc=\n", "yy3Pi2rjtGU=\n");
            boolean z11 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s2);
            this.f9885Z.requestFocus();
            this.f9885Z.requestFocusFromTouch();
        }
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        int id = view.getId();
        boolean z7 = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        String str = AbstractC0032a.m165s("tkL3FgkF\n", "2Sycc3AlAUE=\n") + i6;
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(f9877j0, str);
        if (!z7 || id != this.f9888d0.getId()) {
            return super.onKey(view, i6, keyEvent);
        }
        if (i6 == 4 || i6 == 21) {
            Spark.f11002X1.sendEmptyMessage(112);
        }
        return true;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            String str = AbstractC0032a.m165s("yN4IAL4Tig==\n", "p7Bcb8tw4go=\n") + motionEvent;
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(f9877j0, str);
            view.callOnClick();
        }
        return true;
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9880U = layoutInflater.inflate(R.layout.fragment_history, (ViewGroup) null);
        this.f9891g0 = (C3877a) new C0026b(m1319h()).m136o(C3877a.class);
        this.f9881V = (RelativeLayout) this.f9880U.findViewById(R.id.history_menu);
        this.f9882W = (LinearLayout) this.f9880U.findViewById(R.id.history_layout);
        this.f9881V.setOnKeyListener(this);
        this.f9893i0 = (FrameLayout) this.f9880U.findViewById(R.id.vod_detail_container);
        C3731b c3731b = new C3731b(15, 15, 15, 15);
        this.f9883X = (RecyclerView) this.f9880U.findViewById(R.id.history_live_rview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.setOrientation(0);
        this.f9883X.setLayoutManager(linearLayoutManager);
        this.f9883X.addItemDecoration(c3731b);
        this.f9883X.setOnFocusChangeListener(this);
        this.f9883X.setOnKeyListener(this);
        this.f9885Z = (RecyclerView) this.f9880U.findViewById(R.id.history_vod_rview);
        this.f9887c0 = new GridLayoutManager(AbstractC2442h.f8612r);
        this.f9885Z.addItemDecoration(c3731b);
        this.f9885Z.setLayoutManager(this.f9887c0);
        this.f9885Z.setOnFocusChangeListener(this);
        this.f9885Z.setOnKeyListener(this);
        this.f9888d0 = (RelativeLayout) this.f9880U.findViewById(R.id.live_history_placehold);
        this.f9889e0 = (RelativeLayout) this.f9880U.findViewById(R.id.vod_history_placehold);
        this.f9888d0.setOnKeyListener(this);
        this.f9889e0.setOnKeyListener(this);
        m5908Q();
        m5908Q();
        m1319h().setRequestedOrientation(0);
        return this.f9880U;
    }

    @Override
    public final void mo1332z() {
        String strM165s = AbstractC0032a.m165s("4INP3wSkAErkjUw=\n", "luwrkmHKdQw=\n");
        String strM165s2 = AbstractC0032a.m165s("lao2q47R+Vk=\n", "+sRkzv2klDw=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        super.mo1332z();
        m5908Q();
    }
}
