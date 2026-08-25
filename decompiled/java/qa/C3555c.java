package qa;

import androidx.lifecycle.AbstractC0540o0;
import java.io.Serializable;
import java.util.ArrayList;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Source;
import org.bitspark.android.beans.SubtitleMenu;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p193ra.C3663f;
import p213t9.AbstractC3865u;
import p214ta.C3877a;
import p243w8.C4070l;
import p253x8.AbstractC4148k;

public final class C3555c implements InterfaceC2724l {

    public final int f11960a = 0;

    public final C3559g f11961b;

    public final Spark f11962c;

    public final Serializable f11963d;

    public C3555c(Spark spark, ArrayList arrayList, C3559g c3559g) {
        this.f11962c = spark;
        this.f11963d = arrayList;
        this.f11961b = c3559g;
    }

    @Override
    public final Object invoke(Object obj) {
        switch (this.f11960a) {
            case 0:
                Source source = (Source) obj;
                AbstractC2796i.m5785f(source, AbstractC0032a.m165s("0S8dSW6a\n", "okBoOw3/Nr4=\n"));
                Spark spark = this.f11962c;
                spark.f11049G0 = false;
                spark.f11120i0.f12986C.clear();
                C3663f.m7415b().m7416a();
                C3663f.m7415b().f12275h = false;
                ArrayList arrayList = (ArrayList) this.f11963d;
                int iIndexOf = arrayList.indexOf(source);
                C3663f c3663fM7415b = C3663f.m7415b();
                ChannelBean channelBean = c3663fM7415b.f12272e;
                if (channelBean != null) {
                    c3663fM7415b.m7420f(channelBean, Boolean.valueOf(c3663fM7415b.f12274g), iIndexOf, c3663fM7415b.f12279l);
                }
                source.getShort_title();
                C3559g c3559g = this.f11961b;
                c3559g.getClass();
                int i6 = 0;
                for (Object obj2 : arrayList) {
                    int i10 = i6 + 1;
                    if (i6 < 0) {
                        AbstractC4148k.m8192P();
                        throw null;
                    }
                    ((Source) obj2).setSelected(i6 == iIndexOf);
                    i6 = i10;
                }
                c3559g.m7173a().m7185a();
                return C4070l.f13734a;
            default:
                SubtitleMenu subtitleMenu = (SubtitleMenu) obj;
                AbstractC2796i.m5785f(subtitleMenu, AbstractC0032a.m165s("pJAs7wFRkQmVgC/1\n", "1+VOm2gl/Ww=\n"));
                C3559g c3559g2 = this.f11961b;
                int size = c3559g2.f11971a.f11120i0.f12986C.size();
                int i11 = 0;
                while (true) {
                    Spark spark2 = c3559g2.f11971a;
                    if (i11 >= size) {
                        AbstractC3865u.m7696k(AbstractC0540o0.m1506d(this.f11962c), null, new C3557e((ChannelBean) this.f11963d, subtitleMenu, null), 3);
                        C3877a c3877a = spark2.f11120i0;
                        spark2.m6727r0(c3877a.f12994g, c3877a.f12986C);
                        c3559g2.m7173a().m7185a();
                        return C4070l.f13734a;
                    }
                    SubtitleMenu subtitleMenu2 = (SubtitleMenu) spark2.f11120i0.f12986C.get(i11);
                    subtitleMenu2.setSelected(AbstractC2796i.m5780a(subtitleMenu.getLanguage(), subtitleMenu2.getLanguage()));
                    if (subtitleMenu2.isSelected()) {
                        spark2.f11120i0.f12994g = i11;
                    }
                    i11++;
                }
                break;
        }
    }

    public C3555c(C3559g c3559g, Spark spark, ChannelBean channelBean) {
        this.f11961b = c3559g;
        this.f11962c = spark;
        this.f11963d = channelBean;
    }
}
