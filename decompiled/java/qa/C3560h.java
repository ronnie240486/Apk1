package qa;

import com.bumptech.glide.AbstractC1466d;
import java.util.ArrayList;
import org.bitspark.android.beans.Menu;
import org.bitspark.android.beans.SettingBean;
import org.bitspark.android.beans.Source;
import org.bitspark.android.beans.SubtitleMenu;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p243w8.C4070l;

public final class C3560h implements InterfaceC2724l {

    public final int f11974a;

    public final C3564l f11975b;

    public C3560h(C3564l c3564l, int i6) {
        this.f11974a = i6;
        this.f11975b = c3564l;
    }

    @Override
    public final Object invoke(Object obj) {
        switch (this.f11974a) {
            case 0:
                Menu menu = (Menu) obj;
                AbstractC2796i.m5785f(menu, AbstractC0032a.m165s("lxE=\n", "/mWoEDdOtL4=\n"));
                C3564l c3564l = this.f11975b;
                ArrayList<Menu> arrayList = c3564l.f11986D;
                for (Menu menu2 : arrayList) {
                    menu2.setSelected(AbstractC2796i.m5780a(menu.getName(), menu2.getName()));
                }
                AbstractC1466d.m3485H(c3564l.f12012w, arrayList);
                C3556d c3556d = c3564l.f12000k;
                if (c3556d != null) {
                    c3556d.invoke(menu);
                }
                break;
            case 1:
                Source source = (Source) obj;
                AbstractC2796i.m5785f(source, AbstractC0032a.m165s("lr8=\n", "/8tHZS8MBRs=\n"));
                C3555c c3555c = this.f11975b.f11997h;
                if (c3555c != null) {
                    c3555c.invoke(source);
                }
                break;
            case 2:
                SettingBean settingBean = (SettingBean) obj;
                AbstractC2796i.m5785f(settingBean, AbstractC0032a.m165s("46g=\n", "itzwV3fwZlo=\n"));
                C3556d c3556d2 = this.f11975b.f11996g;
                if (c3556d2 != null) {
                    c3556d2.invoke(settingBean.getName());
                }
                break;
            case 3:
                SubtitleMenu subtitleMenu = (SubtitleMenu) obj;
                AbstractC2796i.m5785f(subtitleMenu, AbstractC0032a.m165s("GY8=\n", "cPvVyJ02MoM=\n"));
                C3555c c3555c2 = this.f11975b.f11998i;
                if (c3555c2 != null) {
                    c3555c2.invoke(subtitleMenu);
                }
                break;
            default:
                Menu menu3 = (Menu) obj;
                AbstractC2796i.m5785f(menu3, AbstractC0032a.m165s("+64=\n", "ktrlcDpwopw=\n"));
                C3556d c3556d3 = this.f11975b.f11999j;
                if (c3556d3 != null) {
                    c3556d3.invoke(menu3.getName());
                }
                break;
        }
        return C4070l.f13734a;
    }
}
