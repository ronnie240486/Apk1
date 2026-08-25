package p116ka;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0253p2;
import androidx.appcompat.widget.RunnableC0261r0;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.C0628x;
import androidx.mediarouter.app.HandlerC1080c;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2630m;
import ga.C2632o;
import ga.EnumC2629l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bitspark.android.Spark;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.beans.GroupBeanModel;
import org.bitspark.android.keyboard.custom.MyKeyBoardView;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import org.bitspark.android.view.CircularProgressBar;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p007a7.C0069f;
import p020b7.AbstractC1332b;
import p029c7.C1407d;
import p029c7.C1419o;
import p029c7.ConcurrentMapC1404b0;
import p055ea.AbstractC2442h;
import p055ea.AbstractC2460q;
import p055ea.C2428a;
import p055ea.EnumC2434d;
import p063fa.AbstractC2548o;
import p063fa.C2523f1;
import p063fa.C2529h1;
import p063fa.C2535j1;
import p063fa.C2559s0;
import p063fa.C2569x0;
import p135m8.EnumC3085a;
import p143n5.AbstractC3198d;
import p155o8.C3276a;
import p156o9.AbstractC3280d;
import p214ta.C3877a;
import p221u6.C3905e;
import p249x4.C4112e;
import pa.AbstractC3386a;
import sa.C3731b;

public class ViewOnKeyListenerC2932m0 extends C2909b implements View.OnKeyListener, View.OnFocusChangeListener, View.OnClickListener, View.OnTouchListener {

    public static RecyclerView f9948C0;

    public static RelativeLayout f9949D0;

    public static HandlerC1080c f9950E0;

    public static C1419o f9953H0;

    public static View f9954I0;

    public C3276a f9956A0;

    public View f9957U;

    public RecyclerView f9958V;

    public RecyclerView f9959W;

    public RecyclerView f9960X;

    public RecyclerView f9961Y;

    public C2529h1 f9962Z;

    public C2535j1 f9963b0;

    public C2523f1 f9964c0;

    public C2569x0 f9965d0;

    public GridLayoutManager f9966e0;

    public RelativeLayout f9967f0;

    public CircularProgressBar f9968g0;

    public LinearLayout f9969h0;

    public ImageButton f9970i0;

    public FrameLayout f9971j0;

    public ImageView f9972k0;

    public TextView f9973l0;

    public ImageButton f9974m0;

    public ImageButton f9975n0;

    public EditText f9976o0;

    public MyKeyBoardView f9977p0;

    public boolean f9979r0;

    public RelativeLayout f9980s0;

    public RelativeLayout f9981t0;

    public C3877a f9983v0;

    public String f9984w0;

    public FrameLayout f9985x0;

    public RelativeLayout f9986y0;

    public final HashMap f9987z0;

    public static final String f9947B0 = AbstractC0032a.m165s("c61VSzY=\n", "Mf4DJFJAgWc=\n");

    public static EnumC2434d f9951F0 = EnumC2434d.f8532d;

    public static boolean f9952G0 = false;

    public static int f9955J0 = 0;

    public boolean f9978q0 = false;

    public volatile int f9982u0 = 0;

    public ViewOnKeyListenerC2932m0() {
        f9950E0 = new HandlerC1080c(this, Looper.getMainLooper(), 4);
        this.f9984w0 = "";
        this.f9985x0 = null;
        this.f9986y0 = null;
        this.f9987z0 = new HashMap();
        this.f9956A0 = null;
    }

    public static void m5927Q(ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0, RecyclerView recyclerView, int i6, int i10) {
        viewOnKeyListenerC2932m0.getClass();
        C2523f1 c2523f1 = (C2523f1) recyclerView.getAdapter();
        if (c2523f1 == null) {
            return;
        }
        int i11 = c2523f1.f8884a;
        c2523f1.f8884a = i6;
        c2523f1.f8885b = i10;
        c2523f1.notifyItemChanged(i6);
        if (i11 != i6) {
            c2523f1.notifyItemChanged(i11);
        }
        c2523f1.f8886c.scrollToPosition(c2523f1.f8884a);
    }

    public static void m5928V() {
        String strM165s = AbstractC0032a.m165s("0qwuJihU02r2tjknNGw=\n", "tMNNU1sCvA4=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9947B0, strM165s);
        Spark.f11002X1.sendEmptyMessage(105);
    }

    @Override
    public final void mo1270B() {
        String strM165s = AbstractC0032a.m165s("QFP0ES2RngpEXfc=\n", "NjyQXEj/60w=\n");
        String strM165s2 = AbstractC0032a.m165s("byPAsSuwzg==\n", "AE2TxUrCujk=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        super.mo1270B();
        this.f9978q0 = true;
    }

    public final boolean m5929R(int i6) {
        ChannelBean.TagsBean tagsBeanM5654b = C2632o.m5654b(i6);
        if (!(tagsBeanM5654b != null ? tagsBeanM5654b.isRestrictedAccess() : false)) {
            if (Spark.f11007c2) {
                Spark.f11007c2 = false;
            }
            return true;
        }
        if (Spark.f11007c2) {
            return true;
        }
        if (!Spark.f11011g2 || f9948C0.hasFocus()) {
            if (this.f9979r0) {
                this.f9959W.requestFocus();
            } else {
                this.f9961Y.requestFocus();
            }
            f9951F0 = EnumC2434d.f8529a;
        }
        f9948C0.setVisibility(8);
        if (f9955J0 < AbstractC2442h.f8610p) {
            f9955J0++;
            Spark.m6676s0(R.string.Click_Restricted_Group);
        }
        String strM165s = AbstractC0032a.m165s("XPkMevuOigZL+D5t6oKaAQ77DWH8l8VSXPkLe/uJ\n", "Lpx/Donn6XI=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9947B0, strM165s);
        return false;
    }

    public final void m5930S() {
        f9952G0 = false;
        if (this.f9979r0) {
            this.f9970i0.setImageResource(R.mipmap.search_icon);
            this.f9959W.setNextFocusDownId(R.id.channel_rview);
        } else {
            this.f9972k0.setImageResource(R.mipmap.search_icon);
            this.f9973l0.setText(m1325n(R.string.Search));
        }
        C2632o.m5653a();
        m5934X();
        f9951F0 = EnumC2434d.f8533e;
    }

    public final void m5931T(RecyclerView recyclerView, RecyclerView recyclerView2, int i6, int i10) {
        C2535j1 c2535j1;
        recyclerView.requestFocus();
        C2529h1 c2529h1 = this.f9962Z;
        if (c2529h1 == null || (c2535j1 = this.f9963b0) == null) {
            return;
        }
        if (this.f9979r0) {
            c2529h1.f8884a = i6;
        } else {
            c2535j1.f8884a = i6;
        }
        AbstractC3280d.m6607z(recyclerView, i6);
        recyclerView.performClick();
        AbstractC3280d.m6606y(recyclerView2);
        recyclerView2.postDelayed(new RunnableC0038c(this, 22, recyclerView2), 100L);
        recyclerView2.postDelayed(new RunnableC0261r0(this, recyclerView2, i10, 8, false), 500L);
    }

    public final void m5932U(int i6) {
        if (C2632o.f9153f == null) {
            return;
        }
        Iterator it = C2632o.f9153f.iterator();
        int i10 = -65535;
        int i11 = 0;
        while (it.hasNext()) {
            Iterator<ChannelBean.TagsBean> it2 = ((GroupBeanModel) it.next()).items.iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                if (it2.next().getId() == i6) {
                    i10 = i12;
                    break;
                }
                i12++;
            }
            if (i10 != -65535) {
                break;
            } else {
                i11++;
            }
        }
        if (i10 == -65535) {
            return;
        }
        int i13 = i11 + 1;
        if (this.f9979r0) {
            m5931T(this.f9958V, this.f9959W, i13, i10);
        } else {
            m5931T(this.f9960X, this.f9961Y, i13, i10);
        }
    }

    public final String m5933W(int i6) {
        String strReplaceAll;
        Group group;
        String str;
        if (C2632o.f9150c != null && (group = (Group) C2632o.f9150c.get(i6)) != null && (str = group.name) != null) {
            return str.replaceAll(AbstractC0032a.m165s("QxNy4Q==\n", "bTkuzknho5g=\n"), "");
        }
        C2523f1 c2523f1 = this.f9964c0;
        c2523f1.getClass();
        try {
            strReplaceAll = ((Group) c2523f1.f8792h.get(((Integer) c2523f1.f8793i.get(c2523f1.f8884a)).intValue())).name.replaceAll(AbstractC0032a.m165s("kfMofA==\n", "v9l0U6Zv+50=\n"), "");
        } catch (Exception e5) {
            e5.printStackTrace();
            strReplaceAll = "";
        }
        return !TextUtils.isEmpty(strReplaceAll) ? strReplaceAll : "";
    }

    public final void m5934X() {
        ArrayList arrayList;
        int i6 = 29;
        String str = f9947B0;
        String strM165s = AbstractC0032a.m165s("QDbYuWdpI5JcHdipQTViyQ==\n", "LFm53SAbTOc=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(str, strM165s);
        if (!this.f9978q0) {
            Log.m5049i(str, AbstractC0032a.m165s("ghMiVHT1jI+KEThFPbHejJ8IOU4=\n", "631LIBGRrOk=\n"));
            return;
        }
        if (m1319h() == null) {
            Log.m5049i(str, AbstractC0032a.m165s("F4r3DUZ1oWIakPUVDy2nJwCQ6xc=\n", "dOWZeSMN1UI=\n"));
            return;
        }
        m5937a0();
        if (this.f9958V == null || this.f9959W == null || this.f9960X == null || this.f9961Y == null || C2632o.f9150c == null || C2632o.f9150c.size() == 0) {
            return;
        }
        try {
            C2529h1 c2529h1 = new C2529h1(C2632o.f9151d, m1319h(), f9950E0);
            this.f9962Z = c2529h1;
            c2529h1.f8888e = new C0069f((Object) this, i6, (Object) 2);
            C2535j1 c2535j1 = new C2535j1(C2632o.f9151d, m1319h(), f9950E0);
            this.f9963b0 = c2535j1;
            c2535j1.f8888e = new C0069f((Object) this, i6, (Object) 2);
            this.f9964c0 = new C2523f1(C2632o.f9150c, m1319h(), f9950E0);
            m5938b0();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (this.f9979r0) {
            this.f9981t0.setVisibility(8);
            this.f9961Y.setVisibility(8);
            this.f9980s0.setVisibility(0);
            this.f9959W.setVisibility(0);
            this.f9958V.setVisibility(0);
            this.f9960X.setVisibility(0);
            this.f9958V.setAdapter(this.f9962Z);
            this.f9959W.setAdapter(this.f9964c0);
        } else {
            this.f9981t0.setVisibility(0);
            this.f9980s0.setVisibility(8);
            this.f9961Y.setVisibility(0);
            this.f9959W.setVisibility(8);
            this.f9960X.setVisibility(0);
            this.f9958V.setVisibility(8);
            this.f9960X.setAdapter(this.f9963b0);
            this.f9961Y.setAdapter(this.f9964c0);
        }
        CircularProgressBar circularProgressBar = this.f9968g0;
        if (circularProgressBar != null && circularProgressBar.getVisibility() == 0) {
            this.f9968g0.setVisibility(8);
        }
        C2523f1 c2523f1 = this.f9964c0;
        if (c2523f1 == null || (arrayList = c2523f1.f8793i) == null || arrayList.size() <= 0) {
            return;
        }
        if (((Integer) this.f9964c0.f8793i.get(1)).intValue() > -1) {
            m5935Y(((Integer) this.f9964c0.f8793i.get(1)).intValue(), "");
            return;
        }
        m5935Y(-10, C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9138i) + AbstractC0032a.m165s("9A==\n", "25mBThvzKEs=\n") + (-10)));
    }

    public final void m5935Y(int i6, String str) {
        List listM5635b;
        int i10 = 1;
        if (f9948C0 == null) {
            return;
        }
        this.f9982u0 = i6;
        String str2 = f9947B0;
        String str3 = AbstractC0032a.m165s("bvt8fUtoL41q9XN3eGsPr3auPQ==\n", "ApQdGR0HS84=\n") + i6 + AbstractC0032a.m165s("rzJmtVk=\n", "jw9YlQLNlP8=\n") + str + ']';
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(str2, str3);
        if (i6 == -5) {
            listM5635b = Spark.f11003Y1.m5635b();
        } else {
            C1419o c1419o = f9953H0;
            String strValueOf = String.valueOf(i6);
            ConcurrentMapC1404b0 concurrentMapC1404b0 = c1419o.f4320a;
            concurrentMapC1404b0.getClass();
            strValueOf.getClass();
            int iM3279c = concurrentMapC1404b0.m3279c(strValueOf);
            Object objM3322h = concurrentMapC1404b0.m3281e(iM3279c).m3322h(iM3279c, strValueOf);
            C4112e c4112e = concurrentMapC1404b0.f4288o;
            if (objM3322h == null) {
                c4112e.getClass();
            } else {
                c4112e.getClass();
            }
            listM5635b = (List) objM3322h;
        }
        if (listM5635b != null) {
            Log.m5049i(str2, AbstractC0032a.m165s("lLSXbyCU44CXn6FiGpnYv4uv1jFO\n", "+Nv2C27xlNY=\n") + i6);
            if (i6 == this.f9982u0) {
                if (listM5635b.isEmpty()) {
                    f9948C0.setVisibility(8);
                    if (i6 == -5) {
                        f9949D0.setVisibility(0);
                    }
                } else {
                    Log.m5049i(str2, AbstractC0032a.m165s("t7oRiKL/H++9oQTG9g==\n", "1NJw5syac6M=\n") + listM5635b.size());
                    if (m5929R(i6)) {
                        try {
                            FragmentActivity fragmentActivityM1319h = m1319h();
                            C2569x0 c2569x0 = new C2569x0(fragmentActivityM1319h, EnumC2434d.f8533e);
                            ArrayList arrayList = new ArrayList();
                            c2569x0.f8932j = arrayList;
                            c2569x0.f8938p = null;
                            c2569x0.f8939q = null;
                            c2569x0.f8940r = null;
                            c2569x0.f8933k = fragmentActivityM1319h;
                            arrayList.clear();
                            arrayList.addAll(listM5635b);
                            c2569x0.m5561b();
                            c2569x0.f8934l = i6;
                            this.f9965d0 = c2569x0;
                            c2569x0.f8938p = new C2928k0(this, i6, i10);
                            if (f9952G0) {
                                c2569x0.f8880g = 5;
                            }
                            c2569x0.f8881h = new C0069f((Object) this, 29, (Object) 3);
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        f9949D0.setVisibility(8);
                        f9948C0.setAdapter(this.f9965d0);
                        Log.m5049i(f9947B0, AbstractC0032a.m165s("/FTWuME0q4qh\n", "mya5zbF9z6o=\n") + i6);
                        if (i6 == -5) {
                            this.f9965d0.f8940r = new C0628x(17, this);
                        } else {
                            this.f9965d0.f8940r = null;
                        }
                        if (f9948C0.getVisibility() == 8) {
                            f9948C0.setVisibility(0);
                        }
                        f9948C0.setItemAnimator(null);
                    }
                }
            }
            this.f9968g0.setVisibility(8);
            return;
        }
        C2569x0 c2569x1 = this.f9965d0;
        if (c2569x1 != null) {
            c2569x1.f8932j.clear();
            AsyncTask asyncTask = c2569x1.f8935m;
            if (asyncTask != null) {
                AbstractC0032a.m165s("TXIAPue5pCJPfDcZrri1AX5pABP6q/0RenMnF+Li4Fs=\n", "Gx1Eco7K0HI=\n");
                asyncTask.cancel(true);
                AbstractC0032a.m165s("/BJ6slwRt9L+HE2VFRCm8c8Jep9BA+7hyxNdm1lK8qs=\n", "qn0+/jViw4I=\n");
            }
            c2569x1.notifyDataSetChanged();
        }
        if (TextUtils.isEmpty(str)) {
            if (i6 != -10) {
                if (C2632o.f9153f != null) {
                    Iterator it = C2632o.f9153f.iterator();
                    while (true) {
                        String str4 = "";
                        if (!it.hasNext()) {
                            str = "";
                            break;
                        }
                        GroupBeanModel groupBeanModel = (GroupBeanModel) it.next();
                        if (groupBeanModel.group_id == i6) {
                            int id = groupBeanModel.items.get(0).getId();
                            Iterator<ChannelBean.TagsBean> it2 = groupBeanModel.items.iterator();
                            loop1: while (true) {
                                String str5 = str4;
                                int i11 = id;
                                str = str5;
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    ChannelBean.TagsBean next = it2.next();
                                    if (i11 >= next.getId()) {
                                        id = next.getId();
                                        str4 = next.url;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    return;
                }
            } else {
                str = C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9138i) + AbstractC0032a.m165s("fg==\n", "UWOyvnu+Zwg=\n") + (-10));
            }
        }
        if (!AbstractC3386a.m6875a(this.f9984w0)) {
            if (str.contains(AbstractC0032a.m165s("vg==\n", "gVuXoBiNm08=\n"))) {
                StringBuilder sbM5498l = AbstractC2460q.m5498l(str);
                sbM5498l.append(AbstractC0032a.m165s("VA==\n", "clYMHbNdV+8=\n"));
                sbM5498l.append(this.f9984w0);
                str = sbM5498l.toString();
            } else {
                StringBuilder sbM5498l2 = AbstractC2460q.m5498l(str);
                sbM5498l2.append(AbstractC0032a.m165s("Pw==\n", "AFT24X8Agig=\n"));
                sbM5498l2.append(this.f9984w0);
                str = sbM5498l2.toString();
            }
        }
        Log.m5049i(f9947B0, AbstractC0032a.m165s("gaL/GdRBJHzP\n", "8seRfYEzSEE=\n") + str);
        this.f9968g0.setVisibility(0);
        try {
            OkGo.getInstance().cancelTag(this);
            ((GetRequest) ((GetRequest) ((GetRequest) ((GetRequest) OkGo.get(str).removeHeader(AbstractC0032a.m165s("Fo1l0BTo6/Utig==\n", "Q/4AojmpjJA=\n"))).headers(AbstractC0032a.m165s("sOQqVYEpR1uL4w==\n", "5ZdPJ6xoID4=\n"), C2428a.f8504m)).tag(this)).cacheMode(CacheMode.NO_CACHE)).execute(new C2926j0(this, i6));
        } catch (Exception unused) {
            Log.m5049i(f9947B0, AbstractC0032a.m165s("GcRLB04y1t8WwFFJXTGS/Q7IH0JKL93uXw==\n", "fqE/Jzhdspw=\n"));
        }
    }

    public final void m5936Z() {
        String strM165s = AbstractC0032a.m165s("UqLyEPqk8KVBoOwA+bWM9w==\n", "IMeBZZfBttc=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9947B0, strM165s);
        C3333o c3333o = C3333o.f11249f;
        if (!c3333o.f11254e) {
            AbstractC3280d.m6606y(f9948C0);
        } else {
            if (c3333o.m6773f()) {
                return;
            }
            this.f9983v0.m7736f();
        }
    }

    public final void m5937a0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) f9948C0.getLayoutParams();
        int iM6469q = AbstractC3198d.m6469q(m1319h(), 10);
        if (f9952G0) {
            this.f9966e0.m2811C(5);
            if (f9948C0.getAdapter() != null) {
                ((AbstractC2548o) f9948C0.getAdapter()).f8880g = 5;
                f9948C0.getAdapter().notifyDataSetChanged();
            }
            this.f9969h0.setVisibility(0);
            this.f9969h0.setFocusable(true);
            marginLayoutParams.leftMargin = iM6469q;
            f9948C0.setLayoutParams(marginLayoutParams);
            this.f9981t0.setBackgroundResource(R.color.transparency);
            return;
        }
        this.f9966e0.m2811C(AbstractC2442h.f8611q);
        if (f9948C0.getAdapter() != null) {
            ((AbstractC2548o) f9948C0.getAdapter()).f8880g = AbstractC2442h.f8611q;
            f9948C0.getAdapter().notifyDataSetChanged();
        }
        this.f9969h0.setVisibility(8);
        this.f9969h0.setFocusable(false);
        if (this.f9979r0) {
            marginLayoutParams.leftMargin = iM6469q;
            f9948C0.setLayoutParams(marginLayoutParams);
        } else {
            marginLayoutParams.leftMargin = this.f9981t0.getLayoutParams().width + iM6469q;
            f9948C0.setLayoutParams(marginLayoutParams);
        }
    }

    public final void m5938b0() {
        if (this.f9979r0) {
            this.f9964c0.f8888e = new C0069f((Object) this, 29, (Object) 5);
        } else {
            this.f9964c0.f8888e = new C0069f((Object) this, 29, (Object) 120);
        }
    }

    public final void m5939c0() {
        if (this.f9979r0) {
            this.f9981t0.setVisibility(8);
            this.f9961Y.setVisibility(8);
            this.f9980s0.setVisibility(0);
            this.f9959W.setVisibility(0);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
            linearLayoutManager.setOrientation(0);
            this.f9958V.setLayoutManager(linearLayoutManager);
            this.f9958V.setOnFocusChangeListener(this);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(1);
            linearLayoutManager2.setOrientation(0);
            this.f9959W.setLayoutManager(linearLayoutManager2);
            this.f9959W.setOnFocusChangeListener(this);
            return;
        }
        this.f9981t0.setVisibility(0);
        this.f9961Y.setVisibility(0);
        this.f9980s0.setVisibility(8);
        this.f9959W.setVisibility(8);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(1);
        linearLayoutManager3.setOrientation(1);
        this.f9960X.setLayoutManager(linearLayoutManager3);
        this.f9960X.setOnFocusChangeListener(this);
        this.f9960X.addItemDecoration(new C2559s0());
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(1);
        linearLayoutManager4.setOrientation(0);
        this.f9961Y.setLayoutManager(linearLayoutManager4);
        this.f9961Y.setOnFocusChangeListener(this);
        f9948C0.setLayoutParams((ViewGroup.MarginLayoutParams) f9948C0.getLayoutParams());
    }

    public final void m5940d0() {
        if (f9952G0) {
            m5930S();
            return;
        }
        f9952G0 = true;
        if (this.f9979r0) {
            this.f9970i0.setImageResource(R.mipmap.search_return);
            this.f9959W.setNextFocusDownId(R.id.keyboard_layout);
        } else {
            this.f9972k0.setImageResource(R.mipmap.search_return);
            this.f9973l0.setText(m1325n(R.string.Back));
        }
        C2632o.m5653a();
        m5934X();
    }

    public final void m5941e0(int i6) {
        if (i6 == 1) {
            this.f9984w0 = AbstractC0032a.m165s("iebptBI8NX6X7A==\n", "+ombwC9RQRc=\n");
            return;
        }
        if (i6 == 2) {
            this.f9984w0 = AbstractC0032a.m165s("99k97OgThpD+\n", "hLZPmNV956I=\n");
        } else if (i6 != 3) {
            this.f9984w0 = "";
        } else {
            this.f9984w0 = AbstractC0032a.m165s("Dmu75oovBz4c\n", "fQTJkrdBfQw=\n");
        }
    }

    @Override
    public final void onClick(View view) {
        int id = view.getId();
        if (id == this.f9970i0.getId() || id == this.f9971j0.getId()) {
            m5940d0();
            return;
        }
        int id2 = this.f9974m0.getId();
        String str = f9947B0;
        if (id == id2) {
            String strM165s = AbstractC0032a.m165s("qCaDIZxK/0SvBZQkz1XwZKYugyHP\n", "ykfgSu86nic=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s);
            EditText editText = this.f9976o0;
            if (editText == null || editText.length() <= 0 || this.f9976o0.getSelectionStart() <= 0) {
                return;
            }
            this.f9976o0.getText().delete(this.f9976o0.getSelectionStart() - 1, this.f9976o0.getSelectionStart());
            return;
        }
        if (id == this.f9975n0.getId()) {
            String strM165s2 = AbstractC0032a.m165s("UwejDQisgkJZQqAGP6WpVVxC\n", "N2LPaHzJwDY=\n");
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s2);
            this.f9976o0.setText("");
            return;
        }
        if (id == this.f9959W.getId()) {
            String strM165s3 = AbstractC0032a.m165s("STJ+1AtUcp5LNzHOFUVInk0rMQ==\n", "LkARoXsGJPc=\n");
            boolean z11 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s3);
        }
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        int id = view.getId();
        String str = f9947B0;
        if (z7 && id == this.f9959W.getId()) {
            String strM165s = AbstractC0032a.m165s("O32By4PR3Cs5eM7RncXlISl8\n", "XA/uvvODikI=\n");
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s);
            AbstractC3280d.m6606y(this.f9959W);
            return;
        }
        if (z7 && id == this.f9958V.getId()) {
            String strM165s2 = AbstractC0032a.m165s("WnLeHBW+EUNradQeRZ1OV1JjxBo=\n", "PQCxaWXyIBE=\n");
            boolean z11 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s2);
            AbstractC3280d.m6606y(this.f9958V);
            return;
        }
        if (z7 && id == f9948C0.getId()) {
            String strM165s3 = AbstractC0032a.m165s("p+fCxqZAT4CW/MjE9mMQlK/22MA=\n", "wJWts9YMftI=\n");
            boolean z12 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s3);
            AbstractC3280d.m6606y(this.f9958V);
            return;
        }
        if (z7 && id == this.f9961Y.getId()) {
            String strM165s4 = AbstractC0032a.m165s("y49JnHUX5XjJinDJaiv1fs+IVQ==\n", "rP0m6QVFsxE=\n");
            boolean z13 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s4);
            AbstractC3280d.m6606y(this.f9961Y);
            return;
        }
        if (z7 && id == this.f9960X.getId()) {
            String strM165s5 = AbstractC0032a.m165s("vOIT3E2W8+SN+Rnea/qt2J3/H9xO\n", "25B8qT3awrY=\n");
            boolean z14 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s5);
            AbstractC3280d.m6606y(this.f9960X);
        }
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        int id = view.getId();
        boolean z7 = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        String str = AbstractC0032a.m165s("NHaqdA2F+FwHd7oSEIrUVBs5\n", "YhnOMn/knzE=\n") + i6 + AbstractC0032a.m165s("P1jV8xM=\n", "EnX43j4E3M4=\n") + keyEvent.getRepeatCount() + AbstractC0032a.m165s("60aO3Q==\n", "xmuj8E64ooI=\n") + keyEvent.getAction() + AbstractC0032a.m165s("QV7va7pX\n", "bHPCRsxtClo=\n") + view;
        boolean z10 = AbstractC3331m.f11244b;
        String str2 = f9947B0;
        Log.m5049i(str2, str);
        if (z7) {
            if (id == this.f9959W.getId() || id == this.f9961Y.getId()) {
                Log.m5049i(str2, AbstractC0032a.m165s("0XT5nLISHhzTcbaCpzloEMBj+J3i\n", "tgaW6cJASHU=\n") + keyEvent);
                if (i6 == 22) {
                    Log.m5049i(str2, AbstractC0032a.m165s("lJM+G+ma5vuWlnEl3JHz3bekDirJifTNoagWJs0=\n", "8+FRbpnIsJI=\n"));
                } else if (i6 == 21) {
                    Log.m5049i(str2, AbstractC0032a.m165s("xd1QtLtodxzH2B+KjmNiOubqYIWbe2Uq7up5lQ==\n", "oq8/wcs6IXU=\n"));
                }
                if (i6 == 20 && f9948C0.getVisibility() == 8) {
                    Log.m5049i(str2, AbstractC0032a.m165s("aQa1j6ngxW9rA/qxnOvQSUoxhb6J89dZSjuNtA==\n", "DnTa+tmykwY=\n"));
                    return true;
                }
            } else if (id == this.f9970i0.getId() || id == this.f9971j0.getId()) {
                Log.m5049i(str2, AbstractC0032a.m165s("JbbVXOtQ7pc4899L8RjJlTO9wA4=\n", "VtO0Log4rOM=\n") + keyEvent);
                if (i6 == 23) {
                    m5940d0();
                    return true;
                }
                if (i6 == 21) {
                    f9951F0 = EnumC2434d.f8532d;
                    m5928V();
                    return true;
                }
                if (i6 == 20 && f9952G0 && !this.f9979r0) {
                    AbstractC3280d.m6606y(this.f9976o0);
                    return true;
                }
            } else if (id == this.f9976o0.getId()) {
                Log.m5049i(str2, AbstractC0032a.m165s("Ad6TVlGRGjNS0JddEpwpIhzP0g==\n", "crvyJDL5X0c=\n") + keyEvent);
                if (i6 == 23) {
                    return true;
                }
                if (i6 == 21) {
                    f9951F0 = EnumC2434d.f8533e;
                    m5928V();
                    return true;
                }
                if (i6 == 20) {
                    this.f9974m0.requestFocus();
                    this.f9974m0.requestFocusFromTouch();
                    return true;
                }
                if (i6 == 19) {
                    if (this.f9979r0) {
                        AbstractC3280d.m6606y(this.f9958V);
                    } else {
                        if (f9952G0) {
                            AbstractC3280d.m6606y(this.f9971j0);
                            return true;
                        }
                        AbstractC3280d.m6606y(this.f9960X);
                    }
                    return true;
                }
            } else if (id == this.f9975n0.getId()) {
                Log.m5049i(str2, AbstractC0032a.m165s("vqeDOnsYepG04oQ6dl1dk7+sm38=\n", "2sLvXw99OOU=\n") + keyEvent);
                if (i6 == 23) {
                    this.f9976o0.setText("");
                } else {
                    if (i6 == 21) {
                        f9951F0 = EnumC2434d.f8533e;
                        m5928V();
                        return true;
                    }
                    if (i6 == 19) {
                        AbstractC3280d.m6606y(this.f9976o0);
                        return true;
                    }
                }
            } else if (id == this.f9977p0.getId()) {
                Log.m5049i(str2, AbstractC0032a.m165s("BC4jOEVsSOY5Ij8tCmZf+08uLD9EeRo=\n", "b0taWioNOoI=\n") + keyEvent);
                if (i6 == 21) {
                    f9951F0 = EnumC2434d.f8533e;
                    m5928V();
                    return true;
                }
            }
        }
        if (i6 != 21 || keyEvent.getRepeatCount() <= 0 || keyEvent.getAction() != 0 || id != this.f9970i0.getId()) {
            return super.onKey(view, i6, keyEvent);
        }
        f9951F0 = EnumC2434d.f8532d;
        m5928V();
        return true;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            String str = AbstractC0032a.m165s("1/yE2uaKcg==\n", "uJLQtZPpGrk=\n") + motionEvent;
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(f9947B0, str);
            view.callOnClick();
        }
        return true;
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9983v0 = (C3877a) new C0026b(m1319h()).m136o(C3877a.class);
        m5941e0(AbstractC3331m.m6756f(0, AbstractC0032a.m165s("2Un/IODFBdzVSu8k/cgO1A==\n", "ihmgdqmBQJM=\n")).intValue());
        if (SpkApplication.f11160c.getApplicationContext().getSharedPreferences(AbstractC0032a.m165s("9JiGh7y1sxg=\n", "luv29dnT1mo=\n"), 0).contains(AbstractC0032a.m165s("Zgv0D3mI5RlnFP4J\n", "NVurWTbMul4=\n"))) {
            this.f9979r0 = AbstractC3331m.m6755e(AbstractC0032a.m165s("Ka/fjtWxSKQosNWI\n", "ev+A2Jr1F+M=\n"), false).booleanValue();
        } else {
            this.f9979r0 = AbstractC2442h.f8587I;
        }
        boolean z7 = this.f9979r0;
        if (z7) {
            AbstractC2442h.f8611q = 6;
        } else {
            AbstractC2442h.f8611q = 5;
        }
        if (z7) {
            this.f9957U = layoutInflater.inflate(R.layout.fragment_vod, (ViewGroup) null);
        } else {
            this.f9957U = layoutInflater.inflate(R.layout.fragment_vod_v, (ViewGroup) null);
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.f9957U.findViewById(R.id.vod_root_view);
        this.f9967f0 = relativeLayout;
        relativeLayout.setOnKeyListener(this);
        C3731b c3731b = new C3731b(0, 0, 0, 0);
        this.f9958V = (RecyclerView) this.f9957U.findViewById(R.id.groupL1_rview);
        this.f9959W = (RecyclerView) this.f9957U.findViewById(R.id.group_rview);
        this.f9960X = (RecyclerView) this.f9957U.findViewById(R.id.groupL1_rview_v);
        this.f9961Y = (RecyclerView) this.f9957U.findViewById(R.id.group_rview_v);
        this.f9980s0 = (RelativeLayout) this.f9957U.findViewById(R.id.l1menu);
        this.f9981t0 = (RelativeLayout) this.f9957U.findViewById(R.id.l1menu_v);
        f9948C0 = (RecyclerView) this.f9957U.findViewById(R.id.channel_rview);
        m5939c0();
        this.f9966e0 = new GridLayoutManager(AbstractC2442h.f8611q);
        f9948C0.addItemDecoration(c3731b);
        f9948C0.setLayoutManager(this.f9966e0);
        f9948C0.setOnFocusChangeListener(this);
        this.f9959W.setOnKeyListener(this);
        this.f9958V.setOnKeyListener(this);
        this.f9961Y.setOnKeyListener(this);
        this.f9960X.setOnKeyListener(this);
        f9948C0.setOnKeyListener(this);
        this.f9968g0 = (CircularProgressBar) this.f9957U.findViewById(R.id.loading_progress);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f9957U.findViewById(R.id.favorite_hint);
        f9949D0 = relativeLayout2;
        relativeLayout2.setVisibility(8);
        ImageButton imageButton = (ImageButton) this.f9957U.findViewById(R.id.searchBtn);
        this.f9970i0 = imageButton;
        imageButton.setOnKeyListener(this);
        this.f9970i0.setOnClickListener(this);
        this.f9970i0.setOnTouchListener(this);
        ImageButton imageButton2 = (ImageButton) this.f9957U.findViewById(R.id.backspace_btn);
        this.f9974m0 = imageButton2;
        imageButton2.setOnKeyListener(this);
        this.f9974m0.setOnClickListener(this);
        this.f9974m0.setOnTouchListener(this);
        ImageButton imageButton3 = (ImageButton) this.f9957U.findViewById(R.id.delete_btn);
        this.f9975n0 = imageButton3;
        imageButton3.setOnKeyListener(this);
        this.f9975n0.setOnClickListener(this);
        this.f9975n0.setOnTouchListener(this);
        this.f9971j0 = (FrameLayout) this.f9957U.findViewById(R.id.searchBtn_v);
        this.f9972k0 = (ImageView) this.f9957U.findViewById(R.id.img_search);
        this.f9973l0 = (TextView) this.f9957U.findViewById(R.id.tv_search);
        this.f9985x0 = (FrameLayout) this.f9957U.findViewById(R.id.vod_detail_container);
        this.f9986y0 = (RelativeLayout) this.f9957U.findViewById(R.id.vod_layout);
        this.f9971j0.setOnKeyListener(this);
        this.f9971j0.setOnClickListener(this);
        this.f9971j0.setOnTouchListener(this);
        this.f9977p0 = (MyKeyBoardView) this.f9957U.findViewById(R.id.keyboardView);
        EditText editText = (EditText) this.f9957U.findViewById(R.id.searchET);
        this.f9976o0 = editText;
        editText.setOnKeyListener(this);
        this.f9977p0.setOnKeyClickListener(new C3905e(20));
        this.f9977p0.setEditText(this.f9976o0);
        this.f9977p0.setOnBackDownPressedListener(new C0069f((Object) this, 29, (Object) 1));
        this.f9976o0.addTextChangedListener(new C0253p2(4, this));
        this.f9969h0 = (LinearLayout) this.f9957U.findViewById(R.id.keyboard_layout);
        m5937a0();
        C1407d c1407d = new C1407d();
        c1407d.f4297b = -1L;
        c1407d.f4296a = 200L;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        if (!(-1 == -1)) {
            throw new IllegalStateException(AbstractC1332b.m3228s("expireAfterWrite was already set to %s ns", -1L));
        }
        c1407d.f4297b = timeUnit.toNanos(60L);
        f9953H0 = new C1419o(c1407d);
        m1319h().setRequestedOrientation(0);
        return this.f9957U;
    }

    @Override
    public final void mo1330u() {
        super.mo1330u();
        C3276a c3276a = this.f9956A0;
        if (c3276a == null || c3276a.m6563g()) {
            return;
        }
        C3276a c3276a2 = this.f9956A0;
        c3276a2.getClass();
        EnumC3085a.m6113b(c3276a2);
    }

    @Override
    public final void mo1332z() {
        String strM165s = AbstractC0032a.m165s("wa0VdIl0dpPFoxY=\n", "t8JxOewaA9U=\n");
        String strM165s2 = AbstractC0032a.m165s("paGm9xtBbvU=\n", "ys/0kmg0A5A=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        super.mo1332z();
    }
}
