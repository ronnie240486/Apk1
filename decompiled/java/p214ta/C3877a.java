package p214ta;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.C0391a;
import androidx.lifecycle.AbstractC0554v0;
import androidx.lifecycle.C0518d0;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import java.util.Iterator;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.SeasonMenu;
import org.bitspark.android.beans.VodMenu;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p003a2.AbstractC0032a;
import p025c2.C1381b;
import p055ea.AbstractC2442h;
import p055ea.EnumC2434d;
import p055ea.EnumC2436e;
import p116ka.C2909b;
import p156o9.AbstractC3280d;

public class C3877a extends AbstractC0554v0 {

    public final ArrayList f12988E;

    public final ArrayList f12989F;

    public boolean f12990G;

    public C1381b f13001n;

    public String f13002o;

    public ChannelBean f13004q;

    public ChannelBean.SourcesBean f13005r;

    public int f13007t;

    public int f13008u;

    public final C0518d0 f12991d = new C0518d0();

    public final C0518d0 f12992e = new C0518d0();

    public int f12993f = 0;

    public int f12994g = 0;

    public final ArrayList f12995h = new ArrayList();

    public final C0518d0 f12996i = new C0518d0();

    public final C0518d0 f12997j = new C0518d0();

    public final C0518d0 f12998k = new C0518d0();

    public final C0518d0 f12999l = new C0518d0();

    public final C0518d0 f13000m = new C0518d0();

    public EnumC2434d f13003p = EnumC2434d.f8533e;

    public int f13006s = 0;

    public boolean f13009v = true;

    public int f13010w = 2;

    public int f13011x = 0;

    public final ArrayList f13012y = new ArrayList();

    public final ArrayList f13013z = new ArrayList();

    public final ArrayList f12984A = new ArrayList();

    public final ArrayList f12985B = new ArrayList();

    public final ArrayList f12986C = new ArrayList();

    public final ArrayList f12987D = new ArrayList();

    public C3877a() {
        new ArrayList();
        this.f12988E = new ArrayList();
        this.f12989F = new ArrayList();
        this.f12990G = true;
    }

    public final void m7733c() {
        int seasons = this.f13004q.getSeasons();
        int i6 = 0;
        while (i6 < seasons) {
            StringBuilder sb = new StringBuilder();
            sb.append(AbstractC0032a.m165s("ehn65DRp5Q==\n", "KXybl1sHxcA=\n"));
            int i10 = i6 + 1;
            sb.append(i10);
            this.f13013z.add(new SeasonMenu(sb.toString(), i6 == 0, this.f13004q.getSeasonSources(i10)));
            i6 = i10;
        }
    }

    public final int m7734d(int i6) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f12984A;
            if (i10 >= arrayList.size()) {
                return i6;
            }
            if (((ChannelBean.SourcesBean) arrayList.get(i10)).getId() == this.f13005r.getId()) {
                return i10;
            }
            i10++;
        }
    }

    public final int m7735e(ArrayList arrayList) {
        if (arrayList == null) {
            return -1;
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ChannelBean.SourcesBean sourcesBean = (ChannelBean.SourcesBean) arrayList.get(i6);
            if (this.f13005r != null && sourcesBean != null && sourcesBean.getId() == this.f13005r.getId()) {
                return i6;
            }
        }
        return -1;
    }

    public final void m7736f() {
        boolean z7;
        C1381b c1381b = this.f13001n;
        if (c1381b != null) {
            C3333o c3333o = C3333o.f11249f;
            C2909b c2909b = (C2909b) c1381b.f4198b;
            ArrayList arrayList = c2909b.m1320i().f1864d;
            int size = arrayList != null ? arrayList.size() : 0;
            String strM165s = AbstractC0032a.m165s("VzH1\n", "A3Cy8hnqGDw=\n");
            String str = AbstractC0032a.m165s("3FDfqJQD3UbSXfaKnwngVdZap+k=\n", "sz6dyfdojjI=\n") + size;
            boolean z10 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, str);
            if (size <= 0 || c3333o.f11252c == null) {
                z7 = false;
            } else {
                AbstractC0410j0 abstractC0410j0M1320i = c2909b.m1320i();
                abstractC0410j0M1320i.getClass();
                C0391a c0391a = new C0391a(abstractC0410j0M1320i);
                c0391a.m1193h(c3333o.f11252c);
                c0391a.m1190e(false);
                c3333o.f11252c = null;
                c3333o.f11254e = false;
                z7 = true;
            }
            C3333o c3333o2 = (C3333o) c1381b.f4202f;
            if (z7) {
                ((View) c1381b.f4199c).setVisibility(8);
                ((View) c1381b.f4200d).setVisibility(0);
                AbstractC3280d.m6606y((View) c1381b.f4201e);
                c3333o2.m6771d();
            }
            c3333o2.f11251b.m7741k();
            c3333o2.m6772e();
        }
    }

    public final boolean m7737g() {
        int iIntValue;
        C0518d0 c0518d0 = this.f12992e;
        if (c0518d0 == null || c0518d0.m1484d() == null) {
            iIntValue = AbstractC3331m.m6756f(-1, AbstractC0032a.m165s("mLFZC5A3CLaYqEIGmzIf\n", "y+EGQ9lzTek=\n")).intValue();
            if (iIntValue == -1) {
                iIntValue = AbstractC2442h.f8593O ? 0 : 1;
            }
        } else {
            iIntValue = ((Integer) c0518d0.m1484d()).intValue();
        }
        return iIntValue == 0;
    }

    public final boolean m7738h() {
        C0518d0 c0518d0 = this.f12991d;
        return (c0518d0.m1484d() == null ? AbstractC3331m.m6756f(0, AbstractC0032a.m165s("cPBx3/W46Edm/3rC4Ks=\n", "I6Aum7DuoQQ=\n")).intValue() : ((Integer) c0518d0.m1484d()).intValue()) == 1;
    }

    public final void m7739i(int i6, ChannelBean channelBean, ArrayList arrayList) {
        this.f12990G = true;
        Message message = new Message();
        message.what = 85;
        Bundle bundle = new Bundle();
        bundle.putString(AbstractC0032a.m165s("WaAFwM+CGRY=\n", "NMVrtZv7aXM=\n"), this.f13003p.name());
        bundle.putInt(AbstractC0032a.m165s("NAXv7w==\n", "V22Gix6nAic=\n"), channelBean.getChid());
        bundle.putInt(AbstractC0032a.m165s("F++ZeRE=\n", "e4rvHH2P0G8=\n"), channelBean.getLevel());
        bundle.putString(AbstractC0032a.m165s("VXOZzQ==\n", "OxL0qFZrMgw=\n"), channelBean.getName().getInit());
        bundle.putInt(AbstractC0032a.m165s("aDor3d8=\n", "AVRPuKcz79M=\n"), i6);
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ChannelBean.SourcesBean sourcesBean = (ChannelBean.SourcesBean) it.next();
            arrayList2.add("" + sourcesBean.getId());
            arrayList3.add(sourcesBean.getSubTitle());
            arrayList4.add(sourcesBean.getAddress());
        }
        bundle.putStringArrayList(AbstractC0032a.m165s("uoROp9FT1Ja9\n", "yfEs7rUfveU=\n"), arrayList2);
        bundle.putStringArrayList(AbstractC0032a.m165s("72UrpWHKBTDQeTql\n", "nBBJ0Qi+aVU=\n"), arrayList3);
        bundle.putStringArrayList(AbstractC0032a.m165s("bcaHBUkOQw==\n", "GLTrSSB9N0w=\n"), arrayList4);
        message.setData(bundle);
        Spark.f11002X1.sendMessage(message);
    }

    public final void m7740j() {
        this.f13010w = 2;
        this.f13006s = 0;
        this.f13005r = null;
        this.f13008u = 0;
        this.f13007t = -1;
        this.f12990G = true;
    }

    public final void m7741k() {
        m7740j();
        this.f13013z.clear();
        this.f12984A.clear();
        this.f12985B.clear();
        this.f12987D.clear();
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f12989F;
            if (i6 >= arrayList.size()) {
                return;
            }
            VodMenu vodMenu = (VodMenu) arrayList.get(i6);
            if (i6 != EnumC2436e.f8541e.f8544a) {
                vodMenu.setEnable(false);
            } else {
                vodMenu.setEnable(true);
            }
            i6++;
        }
    }

    public final void m7742l() {
        int seasons;
        this.f13013z.clear();
        this.f12984A.clear();
        ChannelBean channelBean = this.f13004q;
        ArrayList arrayList = this.f12984A;
        boolean z7 = true;
        if (channelBean != null && (seasons = channelBean.getSeasons()) != 0) {
            if (seasons == 1) {
                arrayList.addAll(this.f13004q.getSources());
            } else {
                m7733c();
                m7743m(this.f13006s);
            }
        }
        VodMenu vodMenu = (VodMenu) this.f12989F.get(0);
        if (this.f13013z.size() <= 1 && arrayList.size() <= 1) {
            z7 = false;
        }
        vodMenu.setEnable(z7);
    }

    public final void m7743m(int i6) {
        ArrayList arrayList = this.f12984A;
        arrayList.clear();
        ArrayList arrayList2 = this.f13013z;
        if (i6 < arrayList2.size()) {
            arrayList.addAll(((SeasonMenu) arrayList2.get(i6)).getSourceList());
        }
    }

    public final void m7744n() {
        ArrayList arrayList = this.f12988E;
        arrayList.clear();
        int i6 = 0;
        while (true) {
            ArrayList arrayList2 = this.f12989F;
            if (i6 >= arrayList2.size()) {
                return;
            }
            VodMenu vodMenu = (VodMenu) arrayList2.get(i6);
            if (vodMenu.isEnable()) {
                arrayList.add(vodMenu);
            }
            i6++;
        }
    }

    public final void m7745o(int i6) {
        ArrayList arrayList = this.f12984A;
        if (i6 < arrayList.size()) {
            this.f13005r = (ChannelBean.SourcesBean) arrayList.get(i6);
        }
    }
}
