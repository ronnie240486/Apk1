package p116ka;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.RunnableC0126c;
import androidx.appcompat.widget.RunnableC0261r0;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.VerticalGridView;
import androidx.media3.exoplayer.hls.C0775b;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.C1160l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.C1474l;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.p2serv.android.p032ds.R;
import ga.C2626i;
import java.util.ArrayList;
import org.bitspark.android.R$drawable;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.utils.C3320b;
import org.bitspark.android.utils.C3333o;
import org.bitspark.android.view.AlwaysMarqueeTextView;
import org.bitspark.android.view.LeanbackTabLayout;
import org.bitspark.android.view.MyProcessRelativeLayout;
import p000a.RunnableC0005f;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p049e3.C2390h;
import p049e3.C2396n;
import p049e3.C2398p;
import p049e3.C2406x;
import p055ea.EnumC2434d;
import p063fa.C2543m0;
import p063fa.C2555q0;
import p063fa.ViewOnKeyListenerC2539l;
import p065g0.C2587g;
import p068g3.C2608b;
import p086i3.AbstractC2694j;
import p101j7.C2782c;
import p141n3.AbstractC3187a;
import p141n3.C3191e;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p214ta.C3877a;
import p228v2.C3980g;
import p228v2.EnumC3974a;
import p247x2.C4089k;
import p251x6.C4129h;
import p251x6.C4133l;
import p251x6.C4134m;
import p251x6.C4135n;
import p251x6.C4136o;
import sa.C3731b;
import sa.C3741l;

public class C2924i0 extends C2909b {

    public static final String f9911i0;

    public C3877a f9912U;

    public ViewStub f9913V;

    public LeanbackTabLayout f9915X;

    public ImageView f9917Z;

    public View f9918b0;

    public MyProcessRelativeLayout f9919c0;

    public ViewPager2 f9921e0;

    public RelativeLayout f9922f0;

    public RecyclerView f9923g0;

    public C2555q0 f9914W = null;

    public int f9916Y = 7;

    public final Handler f9920d0 = new Handler(Looper.myLooper());

    public boolean f9924h0 = false;

    static {
        AbstractC0032a.m165s("6tzvdVGiScvQ9flQU7tNzMg=\n", "vLOLMTTWKKI=\n");
        f9911i0 = AbstractC0032a.m165s("1/cRlOz2wA==\n", "v55i4IOEucc=\n");
        AbstractC0032a.m165s("Cd+wIA==\n", "YbDdRceIL2s=\n");
    }

    public final void m5915Q() {
        int i6 = this.f9912U.f13006s;
        int currentItem = this.f9921e0.getCurrentItem();
        String str = AbstractC0032a.m165s("Ig==\n", "RAk8i4OdXUM=\n") + this.f9912U.f13006s;
        if (((C3741l) m1319h().m1184k().m1264z(str)) != null && i6 == currentItem) {
            m5916R(str);
            return;
        }
        this.f9924h0 = true;
        LeanbackTabLayout leanbackTabLayout = this.f9915X;
        leanbackTabLayout.m4345l(leanbackTabLayout.m4341h(i6), true);
    }

    public final void m5916R(String str) {
        C3741l c3741l = (C3741l) m1319h().m1184k().m1264z(str);
        if (c3741l != null) {
            C2543m0 c2543m0 = c3741l.f12539T;
            if ((c2543m0 != null ? c2543m0.f8866d : null) != null) {
                int iM7735e = this.f9912U.m7735e(c2543m0 != null ? c2543m0.f8866d : null);
                if (iM7735e != -1) {
                    this.f9920d0.postDelayed(new RunnableC0261r0(this, str, iM7735e, 7, false), 200L);
                    return;
                }
                C4129h c4129hM4341h = this.f9915X.m4341h(this.f9912U.f13006s);
                if (c4129hM4341h != null) {
                    AbstractC3280d.m6606y(c4129hM4341h.f14033g);
                }
            }
        }
    }

    public final void m5917S(ChannelBean channelBean, String str) {
        if (C3333o.f11249f.f11254e) {
            int seasons = channelBean.getSeasons();
            String str2 = f9911i0;
            if (seasons <= 1) {
                if (channelBean.getSources() == null || channelBean.getSources().isEmpty()) {
                    this.f9919c0.setVisibility(0);
                    this.f9919c0.setOnClickListener(new ViewOnClickListenerC2916e0(this, 1));
                    this.f9919c0.requestFocus();
                    return;
                }
                if (channelBean.getSources() != null && channelBean.getSources().size() == 1) {
                    m5918T();
                    this.f9919c0.setVisibility(0);
                    this.f9919c0.setOnClickListener(new ViewOnClickListenerC2920g0(this, channelBean));
                    this.f9919c0.requestFocus();
                    return;
                }
                C2543m0 c2543m0 = new C2543m0();
                c2543m0.f8865c = 7;
                ArrayList arrayList = new ArrayList();
                c2543m0.f8866d = arrayList;
                c2543m0.f8867e = channelBean;
                arrayList.addAll(channelBean.getSources());
                c2543m0.f8864b = new ViewOnKeyListenerC2908a0(this, 0);
                c2543m0.f8863a = new C2922h0(this, c2543m0, channelBean);
                c2543m0.f8865c = this.f9916Y;
                this.f9923g0.setAdapter(c2543m0);
                this.f9923g0.setVisibility(0);
                if (!str.equals(str2)) {
                    AbstractC3280d.m6606y(this.f9923g0);
                    return;
                }
                RecyclerView recyclerView = this.f9923g0;
                if (recyclerView != null) {
                    C2543m0 c2543m1 = (C2543m0) recyclerView.getAdapter();
                    c2543m1.notifyDataSetChanged();
                    this.f9920d0.postDelayed(new RunnableC0038c(this, 21, c2543m1), 200L);
                    return;
                }
                return;
            }
            this.f9923g0.setVisibility(8);
            this.f9922f0.setVisibility(0);
            this.f9915X.setupWithViewPager(this.f9921e0);
            ViewPager2 viewPager2 = this.f9921e0;
            viewPager2.setAdapter(new C2914d0(this, (FragmentActivity) m1321j(), channelBean, viewPager2, seasons));
            this.f9915X.m4334a(new C2910b0());
            LeanbackTabLayout leanbackTabLayout = this.f9915X;
            ViewPager2 viewPager3 = this.f9921e0;
            C4136o c4136o = new C4136o(leanbackTabLayout, viewPager3, new C2782c(7, this));
            if (c4136o.f14061e) {
                throw new IllegalStateException("TabLayoutMediator is already attached");
            }
            AbstractC1158k0 adapter = viewPager3.getAdapter();
            c4136o.f14060d = adapter;
            if (adapter == null) {
                throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
            }
            c4136o.f14061e = true;
            viewPager3.registerOnPageChangeCallback(new C4135n(leanbackTabLayout));
            leanbackTabLayout.m4334a(new C4133l(viewPager3, 1));
            c4136o.f14060d.registerAdapterDataObserver(new C4134m(c4136o));
            c4136o.m8156a();
            leanbackTabLayout.m4347n(viewPager3.getCurrentItem(), 0.0f, true, true);
            for (int i6 = 0; i6 < this.f9915X.getTabCount(); i6++) {
                C4129h c4129hM4341h = this.f9915X.m4341h(i6);
                if (c4129hM4341h != null) {
                    c4129hM4341h.f14033g.setNextFocusDownId(R.id.episode_list_view);
                    c4129hM4341h.f14033g.setOnKeyListener(new ViewOnKeyListenerC2539l(this, 3, c4129hM4341h));
                }
            }
            if (this.f9915X.getVisibility() == 0) {
                if (str.equals(str2)) {
                    ViewPager2 viewPager4 = this.f9921e0;
                    if (viewPager4 != null) {
                        viewPager4.post(new RunnableC0005f(22, this));
                        return;
                    }
                    return;
                }
                C4129h c4129hM4341h2 = this.f9915X.m4341h(0);
                if (c4129hM4341h2 != null) {
                    AbstractC3280d.m6606y(c4129hM4341h2.f14033g);
                }
            }
        }
    }

    public final void m5918T() {
        int i6;
        ChannelBean channelBean = this.f9912U.f13004q;
        if (channelBean == null || this.f9918b0 == null || this.f9919c0 == null) {
            return;
        }
        int i10 = 0;
        ChannelBean.SourcesBean sourcesBean = channelBean.getSources().get(0);
        HistoryBean historyBeanM5633a = C2626i.m5633a(channelBean.getChid(), "" + sourcesBean.getId());
        long j10 = 0;
        if (historyBeanM5633a != null) {
            long j11 = historyBeanM5633a.lastPosition;
            if (j11 > 0) {
                j10 = j11;
            }
        }
        if (historyBeanM5633a != null && (i6 = historyBeanM5633a.duration) > 0) {
            i10 = (((int) j10) * 100) / i6;
        }
        this.f9919c0.setProgress(i10);
    }

    public final void m5919U(ChannelBean channelBean, String str) {
        this.f9912U.f13004q = channelBean;
        View view = this.f9918b0;
        if (view == null || channelBean == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.vod_image);
        ImageView imageView2 = (ImageView) this.f9918b0.findViewById(R.id.iv_vod_detail_bg);
        AlwaysMarqueeTextView alwaysMarqueeTextView = (AlwaysMarqueeTextView) this.f9918b0.findViewById(R.id.vod_detail_name);
        this.f9919c0.setBackgroundPaintColor(m1321j().getResources().getColor(R.color.white));
        TextView textView = (TextView) this.f9918b0.findViewById(R.id.tv_ratingbar);
        LinearLayout linearLayout = (LinearLayout) this.f9918b0.findViewById(R.id.ll_ratingbar);
        TextView textView2 = (TextView) this.f9918b0.findViewById(R.id.vod_tag);
        textView2.setText(str);
        textView2.setVisibility(0);
        TextView textView3 = (TextView) this.f9918b0.findViewById(R.id.vod_description);
        this.f9922f0 = (RelativeLayout) this.f9918b0.findViewById(R.id.vod_season_layout);
        this.f9923g0.setVisibility(8);
        this.f9922f0.setVisibility(8);
        if (channelBean.getLogo() != null && channelBean.getLogo().getImage() != null && channelBean.getLogo().getImage().getBig() != null) {
            Context contextM1321j = m1321j();
            String big = channelBean.getLogo().getImage().getBig();
            if (big == null || big.isEmpty()) {
                big = channelBean.getLogo().getImage().getSmall();
            }
            C1474l c1474l = (C1474l) ComponentCallbacks2C1464b.m3465f(this).m3572o(big).m6385f(m1324m().getDrawable(R$drawable.shape_leftbg));
            C4089k c4089k = C4089k.f13831d;
            C1474l c1474l2 = (C1474l) ((C1474l) c1474l.m6383d(c4089k)).m6395q(false);
            C3191e c3191e = new C3191e();
            EnumC3974a enumC3974a = EnumC3974a.f13505b;
            C3980g c3980g = C2398p.f8365f;
            AbstractC3187a abstractC3187aM6393o = c3191e.m6393o(c3980g, enumC3974a);
            C3980g c3980g2 = AbstractC2694j.f9370a;
            C1474l c1474lM3540x = c1474l2.mo3537a(abstractC3187aM6393o.m6393o(c3980g2, enumC3974a));
            C2608b c2608b = new C2608b();
            c2608b.f4512a = new C2782c(23, false);
            c1474lM3540x.m3536D(c2608b).m3533A(imageView2);
            C2587g c2587g = new C2587g(contextM1321j.getResources(), BitmapFactory.decodeResource(contextM1321j.getResources(), R.mipmap.loading));
            float fM6469q = AbstractC3198d.m6469q(m1319h(), 4);
            c2587g.m5603a(fM6469q);
            c2587g.f9019d.setAntiAlias(true);
            c2587g.invalidateSelf();
            C2587g c2587g2 = new C2587g(contextM1321j.getResources(), BitmapFactory.decodeResource(contextM1321j.getResources(), R.mipmap.load_error));
            c2587g2.m5603a(fM6469q);
            c2587g2.f9019d.setAntiAlias(true);
            c2587g2.invalidateSelf();
            if (this.f9912U.m7738h()) {
                C3320b.m6737d().getClass();
            }
            C1474l c1474l3 = (C1474l) ((C1474l) ((C1474l) ComponentCallbacks2C1464b.m3464e(m1321j()).m3572o(big).m6385f(c2587g2)).m6383d(c4089k)).m6395q(false);
            c1474l3.getClass();
            C1474l c1474l4 = (C1474l) c1474l3.m6397s(C2396n.f8359d, new C2390h());
            C1474l c1474lM3540x2 = c1474l4.mo3537a((C3191e) new C3191e().m6399u(new C2406x(8), true));
            C2608b c2608b2 = new C2608b();
            c2608b2.f4512a = new C2782c(23, false);
            c1474lM3540x2.m3536D(c2608b2).m3533A(imageView);
        }
        if (channelBean.getRating() > 0.0f) {
            this.f9914W.f8897a = channelBean.getRating() / 2.0f;
            this.f9914W.notifyDataSetChanged();
            textView.setText(channelBean.getRating() + "");
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        TextView textView4 = (TextView) this.f9918b0.findViewById(R.id.tv_year);
        if (channelBean.getYear() != 0) {
            textView4.setText(channelBean.getYear() + "");
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        if (channelBean.getName() != null && channelBean.getName().getInit() != null && !channelBean.getName().getInit().equals("")) {
            alwaysMarqueeTextView.setText(channelBean.getName().getInit());
            alwaysMarqueeTextView.setVisibility(0);
        }
        if (channelBean.getDescription() == null || channelBean.getDescription().isEmpty()) {
            textView3.setVisibility(8);
            return;
        }
        textView3.setMaxLines(8);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setText(channelBean.getDescription());
        textView3.setVisibility(0);
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9912U = (C3877a) new C0026b(m1311J()).m136o(C3877a.class);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_vod_detail, (ViewGroup) null, false);
        this.f9918b0 = viewInflate;
        this.f9913V = (ViewStub) viewInflate.findViewById(R.id.vod_vg);
        this.f9917Z = (ImageView) this.f9918b0.findViewById(R.id.backImage);
        C3731b c3731b = new C3731b(0, 0, AbstractC3198d.m6469q(m1319h(), 5), AbstractC3198d.m6469q(m1319h(), 11));
        if (this.f9912U.m7738h()) {
            this.f9917Z.setVisibility(0);
            this.f9913V.setLayoutResource(R.layout.layout_vod_recyclerview);
            this.f9913V.inflate();
            RecyclerView recyclerView = (RecyclerView) this.f9918b0.findViewById(R.id.vod_rv);
            recyclerView.addItemDecoration(c3731b);
            this.f9923g0 = recyclerView;
        } else {
            this.f9917Z.setVisibility(8);
            this.f9913V.setLayoutResource(R.layout.layout_vertical_grid_view);
            this.f9913V.inflate();
            VerticalGridView verticalGridView = (VerticalGridView) this.f9918b0.findViewById(R.id.vod_vgv);
            verticalGridView.addItemDecoration(c3731b);
            this.f9923g0 = verticalGridView;
        }
        C3877a c3877a = this.f9912U;
        String str = c3877a.f13002o;
        ChannelBean channelBean = c3877a.f13004q;
        if (str == null || !str.equals(f9911i0)) {
            this.f9912U.f13003p = EnumC2434d.f8533e;
        } else {
            this.f9912U.f13003p = EnumC2434d.f8534f;
        }
        Context contextM1321j = m1321j();
        this.f9917Z.setOnClickListener(new ViewOnClickListenerC2916e0(this, 0));
        this.f9915X = (LeanbackTabLayout) this.f9918b0.findViewById(R.id.tab_layout);
        this.f9919c0 = (MyProcessRelativeLayout) this.f9918b0.findViewById(R.id.vod_play);
        ViewPager2 viewPager2 = (ViewPager2) this.f9918b0.findViewById(R.id.view_pager);
        this.f9921e0 = viewPager2;
        viewPager2.registerOnPageChangeCallback(new C2918f0(this));
        this.f9919c0.setOnKeyListener(new ViewOnKeyListenerC2908a0(this, 1));
        RecyclerView recyclerView2 = (RecyclerView) this.f9918b0.findViewById(R.id.hg_ratingbar);
        C2555q0 c2555q0 = new C2555q0();
        c2555q0.f8897a = 0.0f;
        this.f9914W = c2555q0;
        recyclerView2.setAdapter(c2555q0);
        C1160l c1160l = new C1160l(contextM1321j);
        Drawable drawable = contextM1321j.getResources().getDrawable(R$drawable.shape_rating_bar_divider);
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        c1160l.f3613a = drawable;
        recyclerView2.setLayoutManager(new LinearLayoutManager(0));
        recyclerView2.addItemDecoration(c1160l);
        m5919U(channelBean, str);
        View viewFindViewById = this.f9918b0.findViewById(R.id.detail_content);
        viewFindViewById.post(new RunnableC0126c(this, viewFindViewById, new C0775b(this, channelBean, str, 8), 4));
        return this.f9918b0;
    }

    @Override
    public final void mo1280v() {
        super.mo1280v();
        View view = this.f9918b0;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.vod_image);
            ImageView imageView2 = (ImageView) this.f9918b0.findViewById(R.id.iv_vod_detail_bg);
            ComponentCallbacks2C1464b.m3465f(this).m3568k(imageView);
            ComponentCallbacks2C1464b.m3465f(this).m3568k(imageView2);
        }
    }
}
