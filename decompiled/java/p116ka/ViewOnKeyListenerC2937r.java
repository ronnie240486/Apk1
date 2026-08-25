package p116ka;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.C0253p2;
import androidx.appcompat.widget.C0287w1;
import androidx.appcompat.widget.RunnableC0261r0;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import androidx.leanback.widget.VerticalGridView;
import androidx.mediarouter.app.HandlerC1080c;
import androidx.recyclerview.widget.AbstractC1174p1;
import ba.C1371d;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import ga.C2625h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p055ea.C2428a;
import p055ea.DialogInterfaceOnDismissListenerC2466t;
import p055ea.EnumC2434d;
import p063fa.C2516d0;
import p063fa.C2525g0;
import p063fa.C2536k;
import p124l6.C2982h;
import p156o9.AbstractC3280d;
import p193ra.C3663f;
import p214ta.C3877a;
import sa.DialogC3734e;

public class ViewOnKeyListenerC2937r extends C2909b implements View.OnKeyListener {

    public static HandlerC1080c f9994t0;

    public View f9998U;

    public VerticalGridView f9999V;

    public VerticalGridView f10000W;

    public C2525g0 f10001X;

    public C2516d0 f10002Y;

    public ExpandableListView f10003Z;

    public C2536k f10004b0;

    public RelativeLayout f10005c0;

    public EditText f10006d0;

    public View f10007e0;

    public EnumC2434d f10008f0;

    public final boolean f10009g0;

    public View f10010h0;

    public boolean f10011i0;

    public final HashMap f10012j0;

    public C3877a f10013k0;

    public boolean f10014l0;

    public int f10015m0;

    public boolean f10016n0;

    public final ArrayList f10017o0;

    public int f10018p0;

    public Boolean f10019q0;

    public boolean f10020r0;

    public static final String f9993s0 = AbstractC0032a.m165s("+P02mtF1\n", "uq57/78AG8I=\n");

    public static int f9995u0 = 0;

    public static int f9996v0 = 0;

    public static int f9997w0 = 0;

    public ViewOnKeyListenerC2937r() {
        String str = AbstractC2442h.f8595a;
        this.f10009g0 = true;
        this.f10010h0 = null;
        this.f10011i0 = false;
        this.f10012j0 = new HashMap();
        f9994t0 = new HandlerC1080c(this, Looper.getMainLooper(), 3);
        this.f10014l0 = false;
        this.f10015m0 = 0;
        this.f10016n0 = false;
        this.f10017o0 = new ArrayList();
        this.f10018p0 = 0;
        this.f10019q0 = Boolean.FALSE;
        this.f10020r0 = false;
    }

    public static void m5944Q(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, String str) {
        viewOnKeyListenerC2937r.getClass();
        if (C2621d.f9108b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!str.isEmpty()) {
            for (ChannelBean channelBean : C2621d.f9108b) {
                if (channelBean.getName().getInit().toLowerCase().contains(str.toLowerCase()) && channelBean.getLevel() != 18) {
                    Iterator<ChannelBean.TagsBean> it = channelBean.getTags().iterator();
                    do {
                        if (!it.hasNext()) {
                            arrayList.add(channelBean);
                            break;
                        }
                    } while (!it.next().isRestrictedAccess());
                }
            }
        }
        Collections.sort(arrayList, new C2936q());
        viewOnKeyListenerC2937r.f10015m0 = -1000;
        viewOnKeyListenerC2937r.m5957d0(arrayList);
    }

    public static void m5945R(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, ExpandableListView expandableListView, int i6) {
        int i10 = viewOnKeyListenerC2937r.f10004b0.f8838e;
        if (i6 != i10) {
            if (expandableListView.isGroupExpanded(i6)) {
                expandableListView.collapseGroup(i6);
                return;
            } else {
                expandableListView.expandGroup(i6);
                return;
            }
        }
        if (expandableListView.isGroupExpanded(i10)) {
            expandableListView.collapseGroup(viewOnKeyListenerC2937r.f10004b0.f8838e);
            viewOnKeyListenerC2937r.f10004b0.f8839f = false;
        } else {
            expandableListView.expandGroup(viewOnKeyListenerC2937r.f10004b0.f8838e);
            viewOnKeyListenerC2937r.f10004b0.f8839f = true;
        }
    }

    public static boolean m5946S(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, View view, int i6, int i10, int i11) {
        String playbackUrl;
        if (viewOnKeyListenerC2937r.f10003Z == null || view == null) {
            return true;
        }
        viewOnKeyListenerC2937r.f10020r0 = true;
        EpgBeans.EpgBean epgBean = (EpgBeans.EpgBean) view.getTag();
        if (epgBean == null || (playbackUrl = epgBean.getPlaybackUrl()) == null || playbackUrl.equals("")) {
            return true;
        }
        C3333o c3333o = C3333o.f11249f;
        c3333o.m6771d();
        c3333o.f11251b.m7741k();
        c3333o.m6772e();
        viewOnKeyListenerC2937r.f10003Z.setSelectedChild(i6, i10, true);
        Message message = new Message();
        message.what = 80;
        Bundle bundle = new Bundle();
        int iIntValue = ((Integer) view.getTag(R.id.chid)).intValue();
        ChannelBean channelBean = (ChannelBean) C2621d.f9109c.get(Integer.valueOf(i11));
        String strM165s = channelBean == null ? AbstractC0032a.m165s("rfjhS2zNKg==\n", "7pCAJQKoRnw=\n") : channelBean.getName().getInit();
        int level = channelBean == null ? 0 : channelBean.getLevel();
        bundle.putInt(AbstractC0032a.m165s("oLyKzA==\n", "w9TjqNBe8tQ=\n"), iIntValue);
        bundle.putInt(AbstractC0032a.m165s("3HfeZxg=\n", "sBKoAnTyLnc=\n"), level);
        bundle.putString(AbstractC0032a.m165s("CZY44ek=\n", "euNaqI2cxBM=\n"), epgBean.getId());
        bundle.putString(AbstractC0032a.m165s("7WKN\n", "mBDhkMfAtk0=\n"), playbackUrl);
        bundle.putString(AbstractC0032a.m165s("tze1yA==\n", "2VbYrQqE78E=\n"), strM165s);
        bundle.putString(AbstractC0032a.m165s("cKwjIWbVBt8=\n", "A9lBVQ+haro=\n"), epgBean.getName());
        bundle.putString(AbstractC0032a.m165s("yEA9xA==\n", "vDlNoTNVMMM=\n"), Constants$VIDEO_TYPE.BSPALYBACK.name());
        bundle.putString(AbstractC0032a.m165s("+D1JWjV0Gps=\n", "lVgnL2ENav4=\n"), EnumC2434d.f8530b.name());
        message.setData(bundle);
        Spark.f11002X1.sendMessage(message);
        C2536k.f8833n = epgBean.getId();
        viewOnKeyListenerC2937r.f10004b0.notifyDataSetChanged();
        viewOnKeyListenerC2937r.m5961h0(EnumC2434d.f8531c);
        viewOnKeyListenerC2937r.f10010h0 = view;
        return false;
    }

    @Override
    public final void mo1270B() {
        String strM165s = AbstractC0032a.m165s("HMNYYyXn29I=\n", "UaY2FmOVurU=\n");
        String strM165s2 = AbstractC0032a.m165s("q8b6jJ/Abg==\n", "xKip+P6yGqo=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        super.mo1270B();
        this.f10011i0 = true;
    }

    public final void m5947T(int i6) {
        this.f10015m0 = ((Integer) this.f10001X.f8799d.get(i6)).intValue();
        View view = this.f10001X.f8800e;
        if (view != null) {
            view.setSelected(false);
            this.f10001X.m5554a(this.f10015m0, null);
        }
        VerticalGridView verticalGridView = this.f9999V;
        verticalGridView.smoothScrollToPosition(i6);
        AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = verticalGridView.findViewHolderForAdapterPosition(i6);
        View view2 = abstractC1174p1FindViewHolderForAdapterPosition != null ? abstractC1174p1FindViewHolderForAdapterPosition.itemView : null;
        String str = f9993s0;
        String str2 = AbstractC0032a.m165s("08f6SxMcCGDF38tJFSI5Z9HB9UAYYVo=\n", "sK+bJXRbeg8=\n") + view2 + AbstractC0032a.m165s("IsxoPE7cyq9whCVIFw==\n", "H/FVAXPhrd0=\n") + this.f10015m0 + AbstractC0032a.m165s("sk5/pKIX\n", "j3NCmZ8qfNs=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(str, str2);
        if (view2 != null) {
            view2.setSelected(true);
            this.f10001X.m5554a(this.f10015m0, view2);
        }
        if (C2621d.f9110d != null && C2621d.f9110d.get(Integer.valueOf(this.f10015m0)) != null) {
            Spark.f11006b2 = ((Group) C2621d.f9110d.get(Integer.valueOf(this.f10015m0))).type;
        }
        m5956c0();
    }

    public final void m5948U(Boolean bool, ChannelBean channelBean) {
        int iM5631d = C2625h.m5631d(channelBean);
        if (bool.booleanValue() && f9997w0 != channelBean.getChid()) {
            f9997w0 = channelBean.getChid();
            m5960g0(iM5631d);
        } else {
            if (channelBean.getSources() == null || channelBean.getSources().isEmpty() || channelBean.getSources().get(0).getAddress() == null) {
                return;
            }
            C2536k c2536k = this.f10004b0;
            if (c2536k != null) {
                C2536k.f8833n = "";
                c2536k.notifyDataSetChanged();
            }
        }
        if (C2625h.m5628a(iM5631d) != null) {
            ArrayList arrayListM5630c = C2625h.m5630c(iM5631d);
            if (arrayListM5630c != null) {
                this.f10013k0.f12999l.m1488h((EpgBeans.EpgBean) arrayListM5630c.get(0));
                if (arrayListM5630c.size() > 1) {
                    this.f10013k0.f13000m.m1488h((EpgBeans.EpgBean) arrayListM5630c.get(1));
                } else {
                    this.f10013k0.f13000m.m1488h(null);
                }
            } else {
                this.f10013k0.f12999l.m1488h(null);
            }
        } else {
            this.f10013k0.f12999l.m1488h(null);
            this.f10013k0.f13000m.m1488h(null);
        }
        String address = channelBean.getSources().get(0).getAddress();
        if (address != null && !address.equals("")) {
            m5955b0(channelBean);
            m5961h0(EnumC2434d.f8530b);
        }
        this.f10013k0.f12998k.m1488h(channelBean);
    }

    public final void m5949V(int i6) {
        HashMap map;
        VerticalGridView verticalGridView = this.f9999V;
        if (verticalGridView == null || verticalGridView.getVisibility() != 0 || (map = this.f10012j0) == null) {
            return;
        }
        Integer[] numArr = (Integer[]) map.keySet().toArray(new Integer[0]);
        int i10 = 0;
        while (true) {
            if (i10 >= numArr.length) {
                Arrays.sort(numArr);
                break;
            } else if (numArr[i10] == null) {
                break;
            } else {
                i10++;
            }
        }
        int length = numArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length && numArr[i12].intValue() != i6; i12++) {
            i11++;
        }
        View view = this.f10001X.f8800e;
        if (view != null) {
            view.setSelected(false);
        }
        C2525g0 c2525g0 = this.f10001X;
        c2525g0.f8802g = true;
        AbstractC3280d.m6564A(this.f9999V, c2525g0, i11);
    }

    public final int m5950W() {
        View view;
        C2525g0 c2525g0 = this.f10001X;
        if (c2525g0 == null || (view = c2525g0.f8800e) == null) {
            return 0;
        }
        return this.f9999V.getChildViewHolder(view).getAbsoluteAdapterPosition();
    }

    public final boolean m5951X(int i6) {
        Integer num = (Integer) this.f10001X.f8799d.get(i6);
        int iIntValue = num.intValue();
        String str = f9993s0;
        String str2 = AbstractC0032a.m165s("hNU4b1JieeWB4xZ3R3UtoIrUFHJDRXO6\n", "7aZ7BzMMF4A=\n") + iIntValue;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(str, str2);
        if (iIntValue == -3) {
            return true;
        }
        if (C2621d.f9110d == null) {
            Log.m5049i(str, AbstractC0032a.m165s("jTTdYJXWLEmIAvN4gMF4DKcv/2aa3S4CgzXxfYT7Kk2KKftkudky\n", "5EeeCPS4Qiw=\n"));
            return true;
        }
        HashMap map = this.f10012j0;
        if (map != null && map.get(num) != null) {
            Group group = (Group) this.f10012j0.get(num);
            Objects.requireNonNull(group);
            if (group.restrictedAccess) {
                return true;
            }
        }
        Group group2 = (Group) C2621d.f9110d.get(num);
        Log.m5049i(str, AbstractC0032a.m165s("IaoY27VBPVMjoBXMzAk=\n", "TcV5v/YpXD0=\n") + group2);
        if (group2 == null) {
            return true;
        }
        Log.m5049i(str, AbstractC0032a.m165s("NM459g71row2xDThd70=\n", "WKFYkk2dz+I=\n") + group2.channnels);
        List<ChannelBean> list = group2.channnels;
        if (list == null || list.isEmpty()) {
            return true;
        }
        this.f10015m0 = iIntValue;
        Log.m5049i(str, AbstractC0032a.m165s("fKT9eGPg8C55ktNgdveka3yknn5t+r4OeKfKaQ==\n", "Fde+EAKOnks=\n"));
        return false;
    }

    public final void m5952Y(int i6) {
        Group group;
        List<ChannelBean> list;
        if (C2621d.f9110d == null || (group = (Group) C2621d.f9110d.get(Integer.valueOf(i6))) == null || (list = group.channnels) == null) {
            this.f10019q0 = Boolean.FALSE;
        } else {
            this.f10015m0 = i6;
            m5957d0(list);
        }
    }

    public final void m5953Z() {
        int i6 = 1;
        if (!this.f10011i0) {
            String str = f9993s0;
            String strM165s = AbstractC0032a.m165s("pTJBu+Qz3U2tMFuqrXePTrgpWqE=\n", "zFwoz4FX/Ss=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(str, strM165s);
            return;
        }
        if (this.f9999V.getAdapter() != null) {
            return;
        }
        this.f10012j0.clear();
        if (C2621d.f9110d != null) {
            this.f10012j0.putAll(C2621d.f9110d);
        }
        HashMap map = this.f10012j0;
        C2933n c2933n = new C2933n(this, i6);
        C2525g0 c2525g0 = new C2525g0();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c2525g0.f8798c = linkedHashMap;
        ArrayList arrayList = new ArrayList();
        c2525g0.f8799d = arrayList;
        c2525g0.f8802g = true;
        c2525g0.f8803h = false;
        c2525g0.f8801f = c2933n;
        linkedHashMap.putAll(map);
        arrayList.addAll(new ArrayList(linkedHashMap.keySet()));
        Collections.sort(arrayList);
        this.f10001X = c2525g0;
        this.f9999V.setAdapter(c2525g0);
        HashMap map2 = this.f10012j0;
        if (map2 == null || map2.size() == 0) {
            String str2 = f9993s0;
            String strM165s2 = AbstractC0032a.m165s("A2lNMCSZe7cDaUB6e9sj6m0sAXNn0TrXTzRAc3zYOrpBNkAtJZQk/1oxEnM=\n", "LkRgHQm0Vpo=\n");
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(str2, strM165s2);
            return;
        }
        if (this.f9999V.getVisibility() == 8) {
            this.f9999V.setVisibility(0);
        }
        Set setKeySet = this.f10012j0.keySet();
        Integer[] numArr = (Integer[]) setKeySet.toArray(new Integer[setKeySet.size()]);
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        for (Integer num : numArr) {
            if (num == null) {
                this.f10015m0 = numArr[0].intValue();
                m5956c0();
            }
        }
        Arrays.sort(numArr);
        this.f10015m0 = numArr[0].intValue();
        m5956c0();
    }

    public final void m5954a0(int i6) {
        ArrayList arrayList = this.f10017o0;
        if (i6 >= arrayList.size() || i6 < 0) {
            return;
        }
        ChannelBean channelBean = (ChannelBean) arrayList.get(i6);
        String str = AbstractC0032a.m165s("Rf5ZDlbVYZlF/lkOVtVhmUX+WkIbvzbfC54WRBadYg==\n", "Zt16LXX2Qro=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9993s0, str);
        if (channelBean != null) {
            m5948U(Boolean.FALSE, channelBean);
        }
    }

    public final void m5955b0(ChannelBean channelBean) {
        if (Spark.f11007c2 || channelBean.getLevel() < 18) {
            C3663f.m7415b().m7420f(channelBean, Boolean.TRUE, 0, EnumC2434d.f8530b.name());
        } else {
            if (this.f10016n0) {
                return;
            }
            this.f10016n0 = true;
            C2982h c2982h = new C2982h(m1321j());
            c2982h.f10226c = new DialogInterfaceOnClickListenerC2931m(this, channelBean);
            DialogC3734e dialogC3734eM6042o = c2982h.m6042o();
            dialogC3734eM6042o.show();
            dialogC3734eM6042o.setOnDismissListener(new DialogInterfaceOnDismissListenerC2466t(1, this));
        }
    }

    public final void m5956c0() {
        f9994t0.removeMessages(2);
        f9994t0.sendMessage(Message.obtain(f9994t0, 2, this.f10015m0, 0));
    }

    public final void m5957d0(List list) {
        View view;
        View view2;
        ArrayList arrayListM5630c;
        int i6;
        View view3;
        View view4;
        int i10;
        int i11 = 2;
        int i12 = 0;
        if (this.f10000W == null) {
            this.f10019q0 = Boolean.FALSE;
            AbstractC0032a.m165s("udwo3xVacUG71iX/N0ZxA/XQIdo4XHVDmdo6zwBbdVj12jqbOEd8Q/mTO94iR2JB\n", "1bNJu1YyEC8=\n");
            return;
        }
        if (list == null || list.isEmpty()) {
            C2516d0 c2516d0 = this.f10002Y;
            if ((c2516d0 != null && (view2 = c2516d0.f8768e) != null && view2.hasFocus()) || ((view = this.f10010h0) != null && view.hasFocus())) {
                m5961h0(EnumC2434d.f8529a);
            }
            this.f10000W.setVisibility(8);
            this.f10003Z.setVisibility(8);
            this.f10019q0 = Boolean.FALSE;
            return;
        }
        ArrayList arrayList = this.f10017o0;
        arrayList.clear();
        arrayList.addAll(list);
        boolean z7 = Spark.f11007c2;
        HashMap map = this.f10012j0;
        if (z7 && (i10 = this.f10015m0) > 0 && !((Group) map.get(Integer.valueOf(i10))).restrictedAccess) {
            Spark.f11007c2 = false;
            this.f10001X.notifyItemChanged(m5950W());
            Spark.f11002X1.sendEmptyMessage(83);
        }
        if (!Spark.f11007c2 && (i6 = this.f10015m0) > 0 && ((Group) map.get(Integer.valueOf(i6))).restrictedAccess) {
            C2516d0 c2516d1 = this.f10002Y;
            if ((c2516d1 != null && (view4 = c2516d1.f8768e) != null && view4.hasFocus()) || ((view3 = this.f10010h0) != null && view3.hasFocus())) {
                m5961h0(EnumC2434d.f8529a);
            }
            this.f10000W.setVisibility(8);
            this.f10003Z.setVisibility(8);
            if (f9996v0 < AbstractC2442h.f8610p) {
                f9996v0++;
                Spark.m6676s0(R.string.Click_Restricted_Group);
            }
            this.f10019q0 = Boolean.FALSE;
            String strM165s = AbstractC0032a.m165s("ENdpyzJZDrUH1lvcI1UeskLVaNA1QEHhENduyjJe\n", "YrIav0AwbcE=\n");
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(f9993s0, strM165s);
            return;
        }
        try {
            m5962i0();
            C2516d0 c2516d2 = this.f10002Y;
            if (c2516d2 == null) {
                C2516d0 c2516d3 = new C2516d0(this.f10015m0, new C2933n(this, i11), arrayList);
                this.f10002Y = c2516d3;
                this.f10000W.setAdapter(c2516d3);
                this.f10002Y.f8818b = new C2933n(this, 3);
            } else {
                int i13 = this.f10015m0;
                c2516d2.m5551b(null);
                c2516d2.f8766c = i13;
                ArrayList arrayList2 = c2516d2.f8767d;
                arrayList2.clear();
                arrayList2.addAll(arrayList);
                c2516d2.notifyDataSetChanged();
                this.f10000W.post(new RunnableC2927k(this, i12));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (this.f10000W.getVisibility() == 8) {
            this.f10000W.setVisibility(0);
        }
        int iM5631d = C2625h.m5631d((ChannelBean) arrayList.get(0));
        m5960g0(iM5631d);
        HashMap mapM5628a = C2625h.m5628a(iM5631d);
        Message message = new Message();
        if (mapM5628a != null && (arrayListM5630c = C2625h.m5630c(iM5631d)) != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(C2428a.f8508q, (Serializable) arrayListM5630c.get(0));
            if (arrayListM5630c.size() > 1) {
                bundle.putSerializable(C2428a.f8509r, (Serializable) arrayListM5630c.get(1));
            }
            message.setData(bundle);
        }
        message.what = 142;
        Spark.f11002X1.sendMessage(message);
        int i14 = this.f10018p0;
        if (i14 == 1) {
            m5954a0(0);
        } else if (i14 == 2) {
            m5954a0(arrayList.size() - 1);
        }
        this.f10019q0 = Boolean.FALSE;
        this.f10018p0 = 0;
    }

    public final void m5958e0() {
        m5961h0(EnumC2434d.f8530b);
        C2525g0 c2525g0 = this.f10001X;
        c2525g0.f8802g = false;
        View view = c2525g0.f8800e;
        if (view != null) {
            view.setSelected(true);
        }
        if (this.f10002Y.f8768e != null) {
            this.f10000W.post(new RunnableC2927k(this, 1));
        } else {
            m5959f0();
        }
    }

    public final void m5959f0() {
        VerticalGridView verticalGridView;
        if (this.f10002Y == null || (verticalGridView = this.f10000W) == null) {
            return;
        }
        verticalGridView.post(new RunnableC2927k(this, 3));
    }

    public final void m5960g0(int i6) {
        int i10 = 0;
        String str = AbstractC0032a.m165s("SFWbXSY/M0h+QJJ8HDU8WBcQ\n", "OzD1OWpQUiw=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        String str2 = f9993s0;
        Log.m5049i(str2, str);
        if (m1319h() != null && m1319h().getCurrentFocus() != null && m1319h().getCurrentFocus().getId() == R.id.group_ch_search) {
            this.f10003Z.setVisibility(8);
            return;
        }
        if (this.f10003Z == null) {
            return;
        }
        HashMap mapM5628a = C2625h.m5628a(i6);
        if (mapM5628a == null) {
            this.f10003Z.setVisibility(8);
            return;
        }
        this.f10010h0 = null;
        try {
            C2536k c2536k = new C2536k(mapM5628a, this, this.f10003Z, this.f10009g0, i6, new C2933n(this, i10));
            this.f10004b0 = c2536k;
            if (c2536k.getGroupCount() == 0) {
                Log.m5049i(str2, AbstractC0032a.m165s("e9ZJD50KoxB2zUlR+D2BIFDLRx6oGYshec0VVug=\n", "F7koa9ha5FQ=\n"));
                this.f10003Z.setVisibility(8);
                return;
            }
            if (this.f10004b0.getGroupCount() == 1 && this.f10004b0.getChildrenCount(0) == 0) {
                Log.m5049i(str2, AbstractC0032a.m165s("ReilT3zm2FlI86URGdH6aW71q15J9fBoR/P5FgiWvz1K761HXfXwaEfz5BYZhg==\n", "KYfEKzm2nx0=\n"));
                this.f10003Z.setVisibility(8);
                return;
            }
            this.f10003Z.setAdapter(this.f10004b0);
            if (this.f10003Z.getVisibility() == 8) {
                this.f10003Z.setVisibility(0);
            }
            this.f10003Z.setGroupIndicator(null);
            this.f10003Z.setOnItemSelectedListener(new C0287w1(2, this));
            this.f10003Z.setOnGroupClickListener(new C2934o(this));
            this.f10003Z.setOnChildClickListener(new C2935p(this, i6));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void m5961h0(EnumC2434d enumC2434d) {
        C2516d0 c2516d0;
        String str = AbstractC0032a.m165s("NrTHIhJpvT0qssYdPn+nDhGowwtJOg==\n", "RdGzbnMayXs=\n") + enumC2434d;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9993s0, str);
        this.f10008f0 = enumC2434d;
        if (enumC2434d == EnumC2434d.f8529a) {
            C2525g0 c2525g0 = this.f10001X;
            if (c2525g0 != null) {
                c2525g0.f8802g = true;
                return;
            }
            return;
        }
        if (enumC2434d != EnumC2434d.f8530b || (c2516d0 = this.f10002Y) == null) {
            return;
        }
        c2516d0.f8770g = true;
    }

    public final void m5962i0() {
        if (this.f10015m0 == -3) {
            String strM165s = AbstractC0032a.m165s("MCzkDWnM994B\n", "c0SlaQi8g7s=\n");
            StringBuilder sb = new StringBuilder();
            sb.append(AbstractC0032a.m165s("n2+y7+rW6EmdZb/PyMroC7Jfiava0ftTlmT/q9rX80LJ\n", "8wDTi6m+iSc=\n"));
            ArrayList arrayList = this.f10017o0;
            sb.append(arrayList.size());
            String string = sb.toString();
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, string);
            Collections.sort(arrayList, new C2929l());
        }
    }

    public final void m5963j0(ChannelBean channelBean, int i6) {
        if (channelBean.getSources() == null || channelBean.getSources().size() == 0 || channelBean.getSources().get(0).getAddress() == null) {
            return;
        }
        C2536k c2536k = this.f10004b0;
        if (c2536k != null) {
            C2536k.f8833n = "";
            c2536k.notifyDataSetChanged();
        }
        int chid = channelBean.getChid();
        if (!C2621d.f9112f.contains("" + chid)) {
            if (channelBean.getLevel() >= 18) {
                return;
            }
            C1371d.m3242a(m1321j(), 0, channelBean.getName().getInit() + " " + m1321j().getString(R.string.favorited)).show();
            HashSet hashSet = C2621d.f9112f;
            StringBuilder sb = new StringBuilder("");
            sb.append(chid);
            hashSet.add(sb.toString());
            AbstractC3331m.m6765o(AbstractC0032a.m165s("ceqi8Jox31Br7LjpmC/BUmz/sQ==\n", "Irr9tttngBw=\n"), C2621d.f9112f);
            C2621d.m5627a();
            this.f10012j0.clear();
            if (C2621d.f9110d != null) {
                this.f10012j0.putAll(C2621d.f9110d);
            }
            if (!this.f10012j0.isEmpty()) {
                C2525g0 c2525g0 = this.f10001X;
                HashMap map = this.f10012j0;
                LinkedHashMap linkedHashMap = c2525g0.f8798c;
                linkedHashMap.clear();
                linkedHashMap.putAll(map);
                Set setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = c2525g0.f8799d;
                arrayList.clear();
                arrayList.addAll(new ArrayList(setKeySet));
                Collections.sort(arrayList);
            }
            this.f10002Y.notifyItemChanged(i6);
            return;
        }
        C1371d.m3242a(m1321j(), 0, channelBean.getName().getInit() + " " + m1321j().getString(R.string.remove_fav)).show();
        HashSet hashSet2 = C2621d.f9112f;
        StringBuilder sb2 = new StringBuilder("");
        sb2.append(chid);
        hashSet2.remove(sb2.toString());
        AbstractC3331m.m6765o(AbstractC0032a.m165s("6o88RB5JC7fwiSZdHFcVtfeaLw==\n", "ud9jAl8fVPs=\n"), C2621d.f9112f);
        C2621d.m5627a();
        if (this.f10015m0 != -5) {
            this.f10002Y.notifyItemChanged(i6);
            return;
        }
        List<ChannelBean> list = ((Group) C2621d.f9110d.get(-5)).channnels;
        if (list == null || list.isEmpty()) {
            Spark.f11002X1.sendEmptyMessage(111);
            m5952Y(-5);
            return;
        }
        m5962i0();
        C2516d0 c2516d0 = this.f10002Y;
        int i10 = this.f10015m0;
        c2516d0.m5551b(null);
        c2516d0.f8766c = i10;
        ArrayList arrayList2 = c2516d0.f8767d;
        arrayList2.clear();
        arrayList2.addAll(list);
        c2516d0.notifyDataSetChanged();
        this.f10000W.postDelayed(new RunnableC0261r0(this, i6, list, 6), 300L);
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        VerticalGridView verticalGridView;
        String str = AbstractC0032a.m165s("QSGtLgpL925BIa0vTFb4Qkk9+Xs=\n", "LETDW2w5lgk=\n") + keyEvent + AbstractC0032a.m165s("197R9GzzXA==\n", "6uPsyVHOYa4=\n") + view;
        boolean z7 = AbstractC3331m.f11244b;
        String str2 = f9993s0;
        Log.m5049i(str2, str);
        int id = view.getId();
        boolean z10 = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (z10) {
            if (id == R.id.group_item) {
                if (i6 != 22) {
                    if (i6 != 21 && i6 != 4) {
                        return false;
                    }
                    this.f10001X.f8802g = false;
                    Spark spark = (Spark) m1319h();
                    spark.m6731x0(Boolean.TRUE);
                    AbstractC3280d.m6606y(spark.f11033B);
                    spark.f11033B.setChecked(true);
                    this.f10008f0 = null;
                    return true;
                }
                Log.m5049i(str2, AbstractC0032a.m165s("ZMBdYL+NwLpwxkR8qqWMmEbrcVqLl/OXU/N2Sp2b65tX\n", "A7IyFc/SrNM=\n"));
                VerticalGridView verticalGridView2 = this.f10000W;
                if (verticalGridView2 != null && verticalGridView2.getVisibility() == 0) {
                    Log.m5049i(str2, AbstractC0032a.m165s("qM9jMl+hHyii1HYKWKEERKXIdnxfsR8I\n", "y6cCXDHEc2Q=\n"));
                    m5958e0();
                    return true;
                }
                VerticalGridView verticalGridView3 = this.f10000W;
                if (verticalGridView3 != null || verticalGridView3.getVisibility() == 8) {
                    Log.m5049i(str2, AbstractC0032a.m165s("h2YLE0FATkONfR4rRkBVL4p7BhE=\n", "5A5qfS8lIg8=\n"));
                    View view2 = this.f10001X.f8800e;
                    if (view2 != null && view2.getTag() != null && ((Integer) this.f10001X.f8800e.getTag()).intValue() == -5 && f9995u0 < AbstractC2442h.f8609o) {
                        f9995u0++;
                        Spark.m6676s0(R.string.Fav_channel);
                    }
                }
                return true;
            }
            if (id == R.id.group_ch_search) {
                if (i6 == 22) {
                    VerticalGridView verticalGridView4 = this.f10000W;
                    if (verticalGridView4 != null && verticalGridView4.getVisibility() != 8) {
                        AbstractC0032a.m165s("8vUCFvJXaiL47hcu9VdxTv/yF1jyR2oC\n", "kZ1jeJwyBm4=\n");
                        m5958e0();
                    }
                    return true;
                }
                if (i6 == 21 || i6 == 4) {
                    Spark spark2 = (Spark) m1319h();
                    if (spark2 != null) {
                        spark2.m6731x0(Boolean.TRUE);
                        AbstractC3280d.m6606y(spark2.f11033B);
                        spark2.f11033B.setChecked(true);
                    }
                    return true;
                }
            } else {
                if (id == R.id.epg_day_item || id == R.id.epg_item || id == R.id.epg_item_1line) {
                    if (i6 != 21 && i6 != 4) {
                        if (i6 == 22) {
                            return true;
                        }
                        if (i6 != 23 && i6 != 66) {
                            return false;
                        }
                        ExpandableListView expandableListView = this.f10003Z;
                        expandableListView.performItemClick(view, expandableListView.getSelectedItemPosition(), 0L);
                        return true;
                    }
                    View view3 = this.f10010h0;
                    if (view3 != null) {
                        view3.setSelected(false);
                    }
                    if (this.f10000W != null) {
                        m5961h0(EnumC2434d.f8530b);
                        C2516d0 c2516d0 = this.f10002Y;
                        if (c2516d0 != null && (verticalGridView = this.f10000W) != null && c2516d0.f8768e != null) {
                            verticalGridView.post(new RunnableC2927k(this, 2));
                        }
                    }
                    return true;
                }
                if (id == R.id.channel_item_content) {
                    if ((i6 == 22 || i6 == 21) && keyEvent.getAction() == 1) {
                        return true;
                    }
                    if (i6 == 22) {
                        ExpandableListView expandableListView2 = this.f10003Z;
                        if (expandableListView2 != null && expandableListView2.getVisibility() != 8) {
                            m5961h0(EnumC2434d.f8531c);
                            this.f10002Y.f8770g = false;
                            View view4 = this.f10010h0;
                            if (view4 != null) {
                                AbstractC3280d.m6606y(view4);
                            } else {
                                View childAt = this.f10003Z.getChildAt(0);
                                if (childAt != null) {
                                    AbstractC3280d.m6606y(childAt);
                                }
                            }
                        }
                        return true;
                    }
                    if (i6 == 21 || i6 == 4) {
                        this.f10002Y.f8770g = false;
                        m5961h0(EnumC2434d.f8529a);
                        C2525g0 c2525g0 = this.f10001X;
                        if (c2525g0 != null) {
                            AbstractC3280d.m6606y(c2525g0.f8800e);
                        }
                        return true;
                    }
                }
            }
        }
        if (id == R.id.group_ch_search && i6 == 66) {
            if (keyEvent.getAction() == 1) {
                EditText editText = this.f10006d0;
                ((InputMethodManager) editText.getContext().getSystemService(AbstractC0032a.m165s("BV/rXDTFsoEYWfRN\n", "bDGbKUCa3+Q=\n"))).hideSoftInputFromWindow(editText.getWindowToken(), 2);
                AbstractC3280d.m6606y(this.f10006d0);
            }
            return true;
        }
        if ((id == R.id.group_item || id == R.id.channel_item_content || id == R.id.epg_day_item || id == R.id.epg_item || id == R.id.epg_item_1line) && i6 == 22 && keyEvent.getRepeatCount() > 0) {
            return true;
        }
        if (i6 != 4) {
            Log.m5049i(str2, AbstractC0032a.m165s("PXQepcfEHssifyfu0ZAm2ysyI+zVmxT9PX4w7NuICNAmM27g\n", "UhpVwL7+bb4=\n"));
            return false;
        }
        if (z10) {
            boolean zBooleanValue = AbstractC3331m.m6766p(m1321j()).booleanValue();
            if (!Spark.f11014j2 && !zBooleanValue) {
                Spark.f11002X1.sendEmptyMessage(100);
            }
        }
        return true;
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9998U = layoutInflater.inflate(R.layout.fragment_live, (ViewGroup) null);
        this.f10013k0 = (C3877a) new C0026b(m1319h()).m136o(C3877a.class);
        RelativeLayout relativeLayout = (RelativeLayout) this.f9998U.findViewById(R.id.live_menu);
        this.f10005c0 = relativeLayout;
        relativeLayout.setOnKeyListener(this);
        VerticalGridView verticalGridView = (VerticalGridView) this.f9998U.findViewById(R.id.vg_group);
        this.f9999V = verticalGridView;
        verticalGridView.setAnimation(null);
        ExpandableListView expandableListView = (ExpandableListView) this.f9998U.findViewById(R.id.epg_listview);
        this.f10003Z = expandableListView;
        expandableListView.setItemsCanFocus(true);
        VerticalGridView verticalGridView2 = (VerticalGridView) this.f9998U.findViewById(R.id.rv_channel);
        this.f10000W = verticalGridView2;
        verticalGridView2.setItemAnimator(null);
        this.f10006d0 = (EditText) this.f9998U.findViewById(R.id.group_ch_search);
        this.f10007e0 = this.f9998U.findViewById(R.id.grouch_ch_search_v);
        this.f10006d0.setImeOptions(3);
        this.f10006d0.setOnKeyListener(this);
        this.f10006d0.addTextChangedListener(new C0253p2(3, this));
        this.f10006d0.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0263r2(6, this));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9999V.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f10000W.getLayoutParams();
        layoutParams2.width = (layoutParams.width * 420) / 335;
        String str = AbstractC2442h.f8595a;
        this.f10000W.setLayoutParams(layoutParams2);
        m1319h().setRequestedOrientation(0);
        return this.f9998U;
    }

    @Override
    public final void mo1332z() {
        String strM165s = AbstractC0032a.m165s("aqObIjAaxVE=\n", "J8b1V3ZopDY=\n");
        String strM165s2 = AbstractC0032a.m165s("Q5+RlL8ylUg=\n", "LPHD8cxH+C0=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        super.mo1332z();
    }
}
