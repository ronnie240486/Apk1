package androidx.mediarouter.app;

import android.app.Activity;
import android.view.View;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.List;
import org.bitspark.android.R$drawable;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.SettingBean;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import qa.C3554b;
import qa.C3556d;
import qa.C3559g;
import qa.C3564l;
import qa.C3567o;

public final class ViewOnClickListenerC1078b implements View.OnClickListener {

    public final int f3183a;

    public final Object f3184b;

    public ViewOnClickListenerC1078b(int i6, Object obj) {
        this.f3183a = i6;
        this.f3184b = obj;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f3183a) {
            case 0:
                ((DialogC1086f) this.f3184b).dismiss();
                break;
            default:
                C3559g c3559g = (C3559g) this.f3184b;
                ChannelBean channelBean = (ChannelBean) c3559g.f11971a.f11120i0.f12998k.m1484d();
                if (channelBean != null) {
                    c3559g.f11971a.m6709Z();
                    C3567o c3567oM7173a = c3559g.m7173a();
                    List<ChannelBean.SourcesBean> sources = channelBean.getSources();
                    boolean z7 = false;
                    if (sources != null && sources.size() > 1) {
                        z7 = true;
                    }
                    c3567oM7173a.getClass();
                    String strM165s = AbstractC0032a.m165s("e9K5X90=\n", "GL7QPLY1G+w=\n");
                    C3554b c3554b = c3559g.f11973c;
                    AbstractC2796i.m5785f(c3554b, strM165s);
                    C3564l c3564lM7186b = c3567oM7173a.m7186b();
                    ArrayList arrayList = c3564lM7186b.f11985C;
                    arrayList.clear();
                    Activity activity = c3564lM7186b.f11990a;
                    if (z7) {
                        int i6 = R$drawable.selector_setting_source;
                        String string = activity.getString(R.string.Source);
                        AbstractC2796i.m5784e(string, AbstractC0032a.m165s("D0j6oNF6cG0PBaDdiyE=\n", "aC2O86UIGQM=\n"));
                        arrayList.add(new SettingBean(i6, string));
                    }
                    int i10 = R$drawable.selector_setting_fullscreen;
                    String string2 = activity.getString(R.string.Display_mode);
                    AbstractC2796i.m5784e(string2, AbstractC0032a.m165s("kqAAOn+D2X+S7VpHJdg=\n", "9cV0aQvxsBE=\n"));
                    arrayList.add(new SettingBean(i10, string2));
                    AbstractC0032a.m165s("kbzsGd1fcVqRpvRVn1kwV5669FWJUzBakKetG4hQfBSLsPAQ3VNiU9Gr6QGOTHFGlOfhG5lOf12b\n59MFnE57\n", "/8mAdf08EDQ=\n");
                    if (Spark.f11017m2 == 1) {
                        int i11 = R$drawable.selector_setting_subtitle;
                        String string3 = activity.getString(R.string.Subtitles_Language);
                        AbstractC2796i.m5784e(string3, AbstractC0032a.m165s("6+v5XJRGPIHrpqMhzh0=\n", "jI6ND+A0Ve8=\n"));
                        arrayList.add(new SettingBean(i11, string3));
                    }
                    AbstractC1466d.m3485H(c3564lM7186b.f12009t, arrayList);
                    c3564lM7186b.f11996g = new C3556d(c3567oM7173a, 2, c3554b);
                    if (c3564lM7186b.f11993d != null && !c3564lM7186b.m7175a().isShowing()) {
                        c3564lM7186b.m7175a().show();
                    }
                    c3564lM7186b.m7176b();
                }
                break;
        }
    }
}
