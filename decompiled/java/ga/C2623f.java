package ga;

import java.util.Comparator;
import org.bitspark.android.beans.EpgBeans;
import p055ea.AbstractC2442h;

public final class C2623f implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        EpgBeans.EpgBean epgBean = (EpgBeans.EpgBean) obj;
        EpgBeans.EpgBean epgBean2 = (EpgBeans.EpgBean) obj2;
        if (epgBean.getTime() == epgBean2.getTime()) {
            return 0;
        }
        String str = AbstractC2442h.f8595a;
        return epgBean.getTime().longValue() < epgBean2.getTime().longValue() ? -1 : 1;
    }
}
