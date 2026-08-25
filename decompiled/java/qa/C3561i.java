package qa;

import android.view.View;
import org.bitspark.android.beans.SettingBean;
import p003a2.AbstractC0032a;
import p091i9.InterfaceC2729q;
import p103j9.AbstractC2796i;

public final class C3561i implements InterfaceC2729q {

    public final C3564l f11976a;

    public final void m7174a(Object obj, Object obj2, Object obj3) {
        SettingBean settingBean = (SettingBean) obj3;
        AbstractC2796i.m5785f((View) obj, AbstractC0032a.m165s("CQ==\n", "f3Gyt3FHtsI=\n"));
        AbstractC2796i.m5785f(settingBean, AbstractC0032a.m165s("reM6+Q3ARHC75yA=\n", "3oZOjWSuIzI=\n"));
        C3564l c3564l = this.f11976a;
        int iIndexOf = c3564l.f11985C.indexOf(settingBean);
        if (iIndexOf < 0) {
            iIndexOf = 0;
        }
        c3564l.f11989G = iIndexOf;
    }
}
