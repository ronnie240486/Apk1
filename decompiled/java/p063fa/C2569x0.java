package p063fa;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.AsyncTaskC0330h;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.C0628x;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.bumptech.glide.C1474l;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.p2serv.android.p032ds.R;
import ga.C2632o;
import java.util.ArrayList;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.view.GradientBorderView;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p049e3.C2390h;
import p049e3.C2396n;
import p049e3.C2406x;
import p055ea.AbstractC2460q;
import p055ea.EnumC2434d;
import p065g0.C2587g;
import p141n3.C3191e;
import p143n5.AbstractC3198d;
import p222u7.AbstractC3928d;
import p228v2.EnumC3974a;
import p247x2.C4089k;

public final class C2569x0 extends AbstractC2548o implements Filterable {

    public ArrayList f8932j;

    public FragmentActivity f8933k;

    public int f8934l;

    public final AsyncTask f8935m;

    public C2587g f8936n;

    public C2587g f8937o;

    public InterfaceC2549o0 f8938p;

    public int[] f8939q;

    public C0628x f8940r;

    static {
        AbstractC0032a.m165s("jHw2sU/JK9e/fxOWRtgx3Kg=\n", "2hNS8ieoRbk=\n");
    }

    public C2569x0(String str, FragmentActivity fragmentActivity, int i6) {
        super(fragmentActivity, EnumC2434d.f8533e);
        ArrayList arrayList = new ArrayList();
        this.f8932j = arrayList;
        this.f8938p = null;
        this.f8939q = null;
        this.f8940r = null;
        this.f8933k = fragmentActivity;
        arrayList.clear();
        this.f8934l = i6;
        m5561b();
        AbstractC0032a.m165s("4LT8R0Bfy6XTt9lgSU7RrsQ=\n", "ttuYBCg+pcs=\n");
        AbstractC0032a.m165s("5TactYxcaBvnOKuSxUpkLtAsrJzNHzU=\n", "s1nY+eUvHEs=\n");
        this.f8935m = new AsyncTaskC0330h(this).execute(str);
        AbstractC0032a.m165s("O1/f1DM2cLwIXPrzOidqtx8=\n", "bTC7l1tXHtI=\n");
        AbstractC0032a.m165s("IOqpmyOqEA0i5J68arwcOBXwmbJi6E0=\n", "doXt10rZZF0=\n");
    }

    public final void m5561b() {
        FragmentActivity fragmentActivity = this.f8933k;
        this.f8936n = new C2587g(fragmentActivity.getResources(), BitmapFactory.decodeResource(fragmentActivity.getResources(), R.mipmap.loading));
        float fM6469q = AbstractC3198d.m6469q(fragmentActivity, 9);
        this.f8936n.m5603a(fM6469q);
        C2587g c2587g = this.f8936n;
        c2587g.f9019d.setAntiAlias(true);
        c2587g.invalidateSelf();
        C2587g c2587g2 = new C2587g(fragmentActivity.getResources(), BitmapFactory.decodeResource(fragmentActivity.getResources(), R.mipmap.load_error));
        this.f8937o = c2587g2;
        c2587g2.m5603a(fM6469q);
        C2587g c2587g3 = this.f8937o;
        c2587g3.f9019d.setAntiAlias(true);
        c2587g3.invalidateSelf();
    }

    @Override
    public final Filter getFilter() {
        return new C2565v0(this);
    }

    @Override
    public final int getItemCount() {
        return this.f8932j.size();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C2567w0 c2567w0 = (C2567w0) abstractC1174p1;
        AbstractC0032a.m165s("uHCD5PWFpQHyPw==\n", "yB/wjYHsym8=\n");
        AbstractC0032a.m165s("DaydEGnsgQBJlowZYbXV\n", "Ld/4fAyP9WU=\n");
        AbstractC0032a.m165s("5Pr/Dyti9Gyh9+4+K1T8OuQ=\n", "xJSad18xkQA=\n");
        boolean z7 = i6 == this.f8875b && this.f8877d >= 0;
        if (this.f8932j.size() == 0) {
            return;
        }
        int size = i6 >= this.f8932j.size() ? this.f8932j.size() - 1 : i6;
        if (C2632o.f9152e == null) {
            return;
        }
        ChannelBean channelBean = (ChannelBean) this.f8932j.get(size);
        String init = channelBean.getName().getInit();
        String big = channelBean.getLogo().getImage().getBig();
        if (big == null || big.isEmpty()) {
            big = channelBean.getLogo().getImage().getSmall();
        }
        if (C2632o.f9152e.contains("" + ((ChannelBean) this.f8932j.get(size)).getChid())) {
            init = AbstractC2460q.m5496j("0mMU\n", "MPuRSrcWk1I=\n", new StringBuilder(), init);
        }
        c2567w0.f8926b.setText(init);
        if (z7) {
            GradientBorderView gradientBorderView = c2567w0.f8929e;
            if (this.f8939q == null) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = {AbstractC0032a.m165s("K5bHJLjYyr04i/wYtdvXqwKK1xqoww==\n", "Xfmje9q3uNk=\n"), AbstractC0032a.m165s("4pzx4G6e1R/xgcrcY53ICcue/NtoncI=\n", "lPOVvwzxp3s=\n"), AbstractC0032a.m165s("GSkayvTm1SoKNCH2+eXIPDAjEPE=\n", "b0Z+lZaJp04=\n"), AbstractC0032a.m165s("xiPGRldIqpjVPv16Wku3ju8pzH0H\n", "sEyiGTUn2Pw=\n")};
                for (int i10 = 0; i10 < 4; i10++) {
                    String str = strArr[i10];
                    FragmentActivity fragmentActivity = this.f8933k;
                    int identifier = fragmentActivity.getResources().getIdentifier(str, AbstractC0032a.m165s("ye7VoHA=\n", "qoG5zwL1dnk=\n"), fragmentActivity.getPackageName());
                    if (identifier != 0) {
                        arrayList.add(Integer.valueOf(AbstractC3928d.m7847i(fragmentActivity, identifier)));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add((Integer) arrayList.get(0));
                }
                int[] iArr = new int[arrayList.size()];
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    iArr[i11] = ((Integer) arrayList.get(i11)).intValue();
                }
                this.f8939q = iArr;
            }
            gradientBorderView.setColor(this.f8939q);
            int i12 = this.f8875b;
            if (i12 != this.f8876c) {
                this.f8876c = i12;
            }
            c2567w0.f8926b.getPaint().setFakeBoldText(true);
        } else {
            c2567w0.f8929e.setColor(0);
            c2567w0.f8926b.getPaint().setFakeBoldText(false);
        }
        c2567w0.itemView.setSelected(z7);
        c2567w0.f8927c.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2528h0());
        int chid = channelBean.getChid();
        if (C2632o.f9152e.contains("" + chid)) {
            c2567w0.f8928d.setVisibility(0);
        } else {
            c2567w0.f8928d.setVisibility(8);
        }
        int iM6469q = AbstractC3198d.m6469q(this.f8933k, 9);
        C1474l c1474l = (C1474l) ((C1474l) ((C1474l) ((C1474l) ComponentCallbacks2C1464b.m3464e(this.f8933k).m3572o(big).m6389k(this.f8936n)).m6385f(this.f8937o)).m6383d(C4089k.f13831d)).m6395q(false);
        c1474l.getClass();
        C1474l c1474l2 = (C1474l) c1474l.m6397s(C2396n.f8359d, new C2390h());
        C3191e c3191e = new C3191e();
        EnumC3974a enumC3974a = EnumC3974a.f13505b;
        c1474l2.mo3537a((C3191e) new C3191e().m6399u(new C2406x(iM6469q), true)).m3533A(c2567w0.f8925a);
        c2567w0.itemView.setOnLongClickListener(new ViewOnLongClickListenerC2561t0(this, channelBean, chid, i6));
        c2567w0.itemView.setOnClickListener(new ViewOnClickListenerC2563u0(this, i6, c2567w0, channelBean));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        View viewM15i = AbstractC0004e.m15i(viewGroup, R.layout.vod_channel_item, viewGroup, false);
        C2567w0 c2567w0 = new C2567w0(viewM15i);
        c2567w0.f8927c = viewM15i.findViewById(R.id.cell_root);
        c2567w0.f8925a = (ImageView) viewM15i.findViewById(R.id.image);
        c2567w0.f8926b = (TextView) viewM15i.findViewById(R.id.channel_name);
        c2567w0.f8929e = (GradientBorderView) viewM15i.findViewById(R.id.image_border);
        c2567w0.f8928d = (ImageView) viewM15i.findViewById(R.id.collectedIcon);
        return c2567w0;
    }

    @Override
    public final void onViewRecycled(AbstractC1174p1 abstractC1174p1) {
        C2567w0 c2567w0 = (C2567w0) abstractC1174p1;
        super.onViewRecycled(c2567w0);
        ComponentCallbacks2C1464b.m3464e(c2567w0.f8925a.getContext()).m3568k(c2567w0.f8925a);
    }
}
