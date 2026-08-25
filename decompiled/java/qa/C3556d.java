package qa;

import android.app.Activity;
import androidx.appcompat.app.RunnableC0147m0;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.Menu;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p243w8.C4070l;

public final class C3556d implements InterfaceC2724l {

    public final int f11964a;

    public final Object f11965b;

    public final Object f11966c;

    public C3556d(Object obj, int i6, Object obj2) {
        this.f11964a = i6;
        this.f11966c = obj;
        this.f11965b = obj2;
    }

    @Override
    public final Object invoke(Object obj) {
        switch (this.f11964a) {
            case 0:
                String str = (String) obj;
                AbstractC2796i.m5785f(str, AbstractC0032a.m165s("dohvC4th6cY=\n", "GucMav8Ihqg=\n"));
                Spark spark = (Spark) this.f11966c;
                int i6 = !str.equals(spark.getString(R.string.Top)) ? 1 : 0;
                C3559g c3559g = (C3559g) this.f11965b;
                c3559g.f11971a.f11120i0.f12993f = i6;
                spark.f11140s0.post(new RunnableC0147m0(c3559g, 16, str));
                c3559g.m7173a().m7185a();
                break;
            case 1:
                Menu menu = (Menu) obj;
                AbstractC2796i.m5785f(menu, AbstractC0032a.m165s("YZM=\n", "COdLvCOql4k=\n"));
                C3559g c3559g2 = (C3559g) this.f11965b;
                int resizeMode = c3559g2.f11971a.f11062K1.getResizeMode();
                boolean zM5780a = AbstractC2796i.m5780a(menu.getName(), ((Spark) this.f11966c).getResources().getString(R.string.original));
                Spark spark2 = c3559g2.f11971a;
                if (zM5780a) {
                    if (2 != resizeMode) {
                        spark2.f11062K1.setResizeMode(2);
                    }
                } else if (1 != resizeMode) {
                    spark2.f11062K1.setResizeMode(1);
                }
                c3559g2.m7173a().m7185a();
                break;
            default:
                String str2 = (String) obj;
                AbstractC2796i.m5785f(str2, AbstractC0032a.m165s("s1N5WMffOtChW2g=\n", "wDYNLK6xXZ4=\n"));
                Activity activity = ((C3567o) this.f11966c).f12022a;
                boolean zEquals = str2.equals(activity.getString(R.string.Source));
                C3554b c3554b = (C3554b) this.f11965b;
                if (zEquals || str2.equals(activity.getString(R.string.Subtitles_Language)) || str2.equals(activity.getString(R.string.Display_mode))) {
                    c3554b.invoke(str2);
                }
                break;
        }
        return C4070l.f13734a;
    }

    public C3556d(C3559g c3559g, Spark spark) {
        this.f11964a = 1;
        this.f11965b = c3559g;
        this.f11966c = spark;
    }
}
