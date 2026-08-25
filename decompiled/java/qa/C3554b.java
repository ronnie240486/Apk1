package qa;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.widget.C0460e0;
import androidx.leanback.widget.VerticalGridView;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Menu;
import org.bitspark.android.beans.Source;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p104ja.AbstractC2812h;
import p104ja.AbstractC2814j;
import p104ja.AbstractC2818n;
import p104ja.AbstractC2820p;
import p193ra.C3663f;
import p237w0.AbstractC4042c;
import p243w8.C4070l;
import p253x8.AbstractC4138a;
import p253x8.C4155r;
import sa.C3731b;

public final class C3554b implements InterfaceC2724l {

    public final int f11958a;

    public final Object f11959b;

    public C3554b(int i6, Object obj) {
        this.f11958a = i6;
        this.f11959b = obj;
    }

    @Override
    public final Object invoke(Object obj) {
        VerticalGridView verticalGridView;
        VerticalGridView verticalGridView2;
        TextView textView;
        String string;
        VerticalGridView verticalGridView3;
        VerticalGridView verticalGridView4;
        VerticalGridView verticalGridView5;
        TextView textView2;
        VerticalGridView verticalGridView6;
        VerticalGridView verticalGridView7;
        TextView textView3;
        Object obj2 = this.f11959b;
        int i6 = 0;
        int i10 = 1;
        switch (this.f11958a) {
            case 0:
                String str = (String) obj;
                AbstractC2796i.m5785f(str, AbstractC0032a.m165s("8RKlKw==\n", "n3PITuHaTpY=\n"));
                C3559g c3559g = (C3559g) obj2;
                ChannelBean channelBean = (ChannelBean) c3559g.f11971a.f11120i0.f12998k.m1484d();
                if (channelBean != null) {
                    List<ChannelBean.SourcesBean> sources = channelBean.getSources();
                    AbstractC2796i.m5784e(sources, AbstractC0032a.m165s("QQontouvSJ5DHHvLyvQT\n", "Jm9T5eTaOv0=\n"));
                    ArrayList arrayList = new ArrayList();
                    for (ChannelBean.SourcesBean sourcesBean : sources) {
                        if (!TextUtils.isEmpty(sourcesBean.getSubTitle())) {
                            int id = sourcesBean.getId();
                            String address = sourcesBean.getAddress();
                            AbstractC2796i.m5784e(address, AbstractC0032a.m165s("gsJOTS0SMXCW1BIiZ1hq\n", "5ac6DEl2QxU=\n"));
                            String subTitle = sourcesBean.getSubTitle();
                            if (subTitle == null) {
                                subTitle = "";
                            }
                            arrayList.add(new Source(id, address, subTitle, C4155r.f14074a, false, 0, false));
                        }
                    }
                    Spark spark = c3559g.f11971a;
                    if (str.equals(spark.getString(R.string.Source))) {
                        int chid = channelBean.getChid();
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i11 = 0;
                            while (true) {
                                if (i11 >= size) {
                                    String str2 = (String) C3663f.m7415b().f12270c.get(String.valueOf(chid));
                                    if (str2 == null) {
                                        str2 = AbstractC2442h.f8583E;
                                    }
                                    Iterator it = arrayList.iterator();
                                    int i12 = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            i12 = -1;
                                        } else if (!AbstractC2796i.m5780a(str2, ((Source) it.next()).getShort_title())) {
                                            i12++;
                                        }
                                    }
                                    if (i12 < 0) {
                                        i12 = 0;
                                    }
                                    ((Source) arrayList.get(i12)).setSelected(true);
                                } else if (!((Source) arrayList.get(i11)).isSelected()) {
                                    i11++;
                                }
                            }
                        }
                        C3567o c3567oM7173a = c3559g.m7173a();
                        C3555c c3555c = new C3555c(spark, arrayList, c3559g);
                        c3567oM7173a.getClass();
                        AbstractC0032a.m165s("NhygI4FbuA==\n", "RXPVUeI+y+s=\n");
                        AbstractC0032a.m165s("LByBbXkgkLwu\n", "RWjkADpM+d8=\n");
                        C3564l c3564lM7186b = c3567oM7173a.m7186b();
                        c3564lM7186b.f11997h = c3555c;
                        AbstractC0032a.m165s("bIjB2W8aTg==\n", "H+e0qwx/PVU=\n");
                        if (c3564lM7186b.f12002m == null) {
                            Activity activity = c3564lM7186b.f11990a;
                            LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
                            FrameLayout frameLayout = ((AbstractC2812h) c3564lM7186b.f11995f).f9565l;
                            int i13 = AbstractC2818n.f9580o;
                            c3564lM7186b.f12002m = (AbstractC2818n) AbstractC4042c.m8044a(layoutInflaterFrom, R.layout.view_live_setting_source, frameLayout);
                            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(activity.getAssets(), AbstractC0032a.m165s("nEJI0eCRysOURFSLu6Tf\n", "+i0mpc/QvKY=\n"));
                            AbstractC2818n abstractC2818n = c3564lM7186b.f12002m;
                            if (abstractC2818n != null && (textView3 = abstractC2818n.f9582m) != null) {
                                textView3.setTypeface(typefaceCreateFromAsset);
                            }
                            AbstractC2818n abstractC2818n2 = c3564lM7186b.f12002m;
                            if (abstractC2818n2 != null && (verticalGridView7 = abstractC2818n2.f9583n) != null) {
                                verticalGridView7.setAdapter(c3564lM7186b.f12007r);
                            }
                            c3564lM7186b.f12005p.f12016a = new C3560h(c3564lM7186b, i10);
                        }
                        AbstractC1466d.m3485H(c3564lM7186b.f12006q, arrayList);
                        AbstractC2818n abstractC2818n3 = c3564lM7186b.f12002m;
                        AbstractC2796i.m5782c(abstractC2818n3);
                        String strM165s = AbstractC0032a.m165s("Wqj7zdCuG2gT46G2\n", "Pc2Pn7/Bb0A=\n");
                        View view = abstractC2818n3.f13698d;
                        AbstractC2796i.m5784e(view, strM165s);
                        c3564lM7186b.m7177c(view, EnumC3562j.f11978b);
                        AbstractC2818n abstractC2818n4 = c3564lM7186b.f12002m;
                        if (abstractC2818n4 != null && (verticalGridView6 = abstractC2818n4.f9583n) != null) {
                            AbstractC1466d.m3483D(verticalGridView6, 0);
                        }
                    } else if (str.equals(spark.getString(R.string.Subtitles_Language))) {
                        C3567o c3567oM7173a2 = c3559g.m7173a();
                        ArrayList arrayList2 = spark.f11120i0.f12986C;
                        AbstractC2796i.m5784e(arrayList2, AbstractC0032a.m165s("TZCENQKl6TBIjZ41Hbn4MA==\n", "IfnyUFHQi0Q=\n"));
                        if (spark.f11120i0.f12993f == 0) {
                            string = spark.getString(R.string.Top);
                            AbstractC2796i.m5784e(string, AbstractC0032a.m165s("hRg/qtPH2QmFVWXXiZw=\n", "4n1L+ae1sGc=\n"));
                        } else {
                            string = spark.getString(R.string.Bottom);
                            AbstractC2796i.m5784e(string, AbstractC0032a.m165s("WQ/m7xRe0jxZQrySTgU=\n", "PmqSvGAsu1I=\n"));
                        }
                        C3555c c3555c2 = new C3555c(c3559g, spark, channelBean);
                        C3556d c3556d = new C3556d(spark, i6, c3559g);
                        c3567oM7173a2.getClass();
                        AbstractC0032a.m165s("hNqBwEqb0tC7xpDA\n", "96/jtCPvvrU=\n");
                        AbstractC0032a.m165s("QMqwlha7AjF/0LGDC6YBOg==\n", "M7/S4n/PblQ=\n");
                        AbstractC0032a.m165s("41yMkC9If9XTRYeHLQ==\n", "kCnu5EY8E7A=\n");
                        AbstractC0032a.m165s("d4N1kEoMhRtImXSFVxGGEEeafodI\n", "BPYX5CN46X4=\n");
                        C3564l c3564lM7186b2 = c3567oM7173a2.m7186b();
                        c3564lM7186b2.f11998i = c3555c2;
                        c3564lM7186b2.f11999j = c3556d;
                        AbstractC0032a.m165s("el4XAZS5LDxFQgYB\n", "CSt1df3NQFk=\n");
                        AbstractC0032a.m165s("EXNQ++8THbopeUvu\n", "fRwzmpt6ctQ=\n");
                        AbstractC2820p abstractC2820p = c3564lM7186b2.f12003n;
                        Activity activity2 = c3564lM7186b2.f11990a;
                        if (abstractC2820p == null) {
                            LayoutInflater layoutInflaterFrom2 = LayoutInflater.from(activity2);
                            FrameLayout frameLayout2 = ((AbstractC2812h) c3564lM7186b2.f11995f).f9565l;
                            int i14 = AbstractC2820p.f9586o;
                            c3564lM7186b2.f12003n = (AbstractC2820p) AbstractC4042c.m8044a(layoutInflaterFrom2, R.layout.view_live_setting_subtitle, frameLayout2);
                            Typeface typefaceCreateFromAsset2 = Typeface.createFromAsset(activity2.getAssets(), AbstractC0032a.m165s("OlkHoXctqisyXxv7LBi/\n", "XDZp1Vhs3E4=\n"));
                            AbstractC2820p abstractC2820p2 = c3564lM7186b2.f12003n;
                            if (abstractC2820p2 != null && (textView2 = abstractC2820p2.f9588m) != null) {
                                textView2.setTypeface(typefaceCreateFromAsset2);
                            }
                            AbstractC2820p abstractC2820p3 = c3564lM7186b2.f12003n;
                            if (abstractC2820p3 != null && (verticalGridView5 = abstractC2820p3.f9589n) != null) {
                                AbstractC0032a.m165s("Ol7d4SxF\n", "Biq1iF97++M=\n");
                                verticalGridView5.addItemDecoration(new C3731b(0, 0, (int) (8 * activity2.getResources().getDisplayMetrics().density), 0));
                            }
                            AbstractC2820p abstractC2820p4 = c3564lM7186b2.f12003n;
                            if (abstractC2820p4 != null && (verticalGridView4 = abstractC2820p4.f9589n) != null) {
                                verticalGridView4.setAdapter(c3564lM7186b2.f11984B);
                            }
                            c3564lM7186b2.f12014y.f12016a = new C3560h(c3564lM7186b2, 3);
                            c3564lM7186b2.f12015z.f12016a = new C3560h(c3564lM7186b2, 4);
                        }
                        C0026b c0026b = c3564lM7186b2.f11983A;
                        ArrayList arrayList3 = (ArrayList) c0026b.f56d;
                        int size2 = arrayList3.size();
                        C0460e0 c0460e0 = (C0460e0) c0026b.f54b;
                        if (size2 != 0) {
                            arrayList3.clear();
                            c0460e0.m1425d(0, size2);
                        }
                        boolean zIsEmpty = arrayList2.isEmpty();
                        ArrayList arrayList4 = (ArrayList) c0026b.f56d;
                        if (!zIsEmpty) {
                            String string2 = activity2.getString(R.string.language);
                            int size3 = arrayList4.size();
                            arrayList4.add(size3, string2);
                            c0460e0.m1424c(size3, 1);
                            int size4 = arrayList4.size();
                            int size5 = arrayList2.size();
                            if (size5 != 0) {
                                arrayList4.addAll(size4, arrayList2);
                                c0460e0.m1424c(size4, size5);
                            }
                        }
                        String string3 = activity2.getString(R.string.Position);
                        int size6 = arrayList4.size();
                        arrayList4.add(size6, string3);
                        c0460e0.m1424c(size6, 1);
                        ArrayList<Menu> arrayList5 = c3564lM7186b2.f11987E;
                        for (Menu menu : arrayList5) {
                            menu.setSelected(string.equals(menu.getName()));
                        }
                        int size7 = arrayList4.size();
                        int size8 = arrayList5.size();
                        if (size8 != 0) {
                            arrayList4.addAll(size7, arrayList5);
                            c0460e0.m1424c(size7, size8);
                        }
                        AbstractC2820p abstractC2820p5 = c3564lM7186b2.f12003n;
                        AbstractC2796i.m5782c(abstractC2820p5);
                        String strM165s2 = AbstractC0032a.m165s("mbi3wZ1+6gjQ8+26\n", "/t3Dk/IRniA=\n");
                        View view2 = abstractC2820p5.f13698d;
                        AbstractC2796i.m5784e(view2, strM165s2);
                        c3564lM7186b2.m7177c(view2, EnumC3562j.f11979c);
                        AbstractC2820p abstractC2820p6 = c3564lM7186b2.f12003n;
                        if (abstractC2820p6 != null && (verticalGridView3 = abstractC2820p6.f9589n) != null) {
                            AbstractC1466d.m3483D(verticalGridView3, 1);
                        }
                    } else if (str.equals(spark.getString(R.string.Display_mode))) {
                        C3567o c3567oM7173a3 = c3559g.m7173a();
                        C3556d c3556d2 = new C3556d(c3559g, spark);
                        c3567oM7173a3.getClass();
                        AbstractC0032a.m165s("PHzTt8U=\n", "XxC61K7Tj+o=\n");
                        C3564l c3564lM7186b3 = c3567oM7173a3.m7186b();
                        c3564lM7186b3.f12000k = c3556d2;
                        if (c3564lM7186b3.f12004o == null) {
                            Activity activity3 = c3564lM7186b3.f11990a;
                            LayoutInflater layoutInflaterFrom3 = LayoutInflater.from(activity3);
                            FrameLayout frameLayout3 = ((AbstractC2812h) c3564lM7186b3.f11995f).f9565l;
                            int i15 = AbstractC2814j.f9568o;
                            c3564lM7186b3.f12004o = (AbstractC2814j) AbstractC4042c.m8044a(layoutInflaterFrom3, R.layout.view_live_setting_fullscreen, frameLayout3);
                            Typeface typefaceCreateFromAsset3 = Typeface.createFromAsset(activity3.getAssets(), AbstractC0032a.m165s("NEURwoZQRkA8Qw2Y3WVT\n", "Uip/tqkRMCU=\n"));
                            AbstractC2814j abstractC2814j = c3564lM7186b3.f12004o;
                            if (abstractC2814j != null && (textView = abstractC2814j.f9570m) != null) {
                                textView.setTypeface(typefaceCreateFromAsset3);
                            }
                            AbstractC2814j abstractC2814j2 = c3564lM7186b3.f12004o;
                            if (abstractC2814j2 != null && (verticalGridView2 = abstractC2814j2.f9571n) != null) {
                                verticalGridView2.setAdapter(c3564lM7186b3.f12013x);
                            }
                            c3564lM7186b3.f12011v.f12016a = new C3560h(c3564lM7186b3, i6);
                        }
                        AbstractC1466d.m3485H(c3564lM7186b3.f12012w, c3564lM7186b3.f11986D);
                        AbstractC2814j abstractC2814j3 = c3564lM7186b3.f12004o;
                        AbstractC2796i.m5782c(abstractC2814j3);
                        String strM165s3 = AbstractC0032a.m165s("gh7hziXEBenLVbu1\n", "5XuVnEqrccE=\n");
                        View view3 = abstractC2814j3.f13698d;
                        AbstractC2796i.m5784e(view3, strM165s3);
                        c3564lM7186b3.m7177c(view3, EnumC3562j.f11980d);
                        AbstractC2814j abstractC2814j4 = c3564lM7186b3.f12004o;
                        if (abstractC2814j4 != null && (verticalGridView = abstractC2814j4.f9571n) != null) {
                            AbstractC1466d.m3483D(verticalGridView, 0);
                        }
                    }
                }
                return C4070l.f13734a;
            default:
                return obj == ((AbstractC4138a) obj2) ? "(this Collection)" : String.valueOf(obj);
        }
    }
}
