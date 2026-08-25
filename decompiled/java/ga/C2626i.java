package ga;

import com.tencent.mars.xlog.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.LimitQueue;
import p003a2.AbstractC0032a;
import p044da.C2340c;

public final class C2626i {

    public static final String f9120a = AbstractC0032a.m165s("ljqXbVd7oJ2t\n", "1GnfBCQPz+8=\n");

    public static final String f9121b = AbstractC0032a.m165s("xaS10bA/HofdorHNsCFG\n", "qc3DtO9Xd/Q=\n");

    public static final String f9122c = AbstractC0032a.m165s("UV9t9Rj755ZIQnD1BqM=\n", "JzAJqnCSlOI=\n");

    public static final String f9123d = AbstractC0032a.m165s("h5y2B2dToZKOj7kHeQs=\n", "4f3AWA860uY=\n");

    public static LimitQueue f9124e;

    public static LimitQueue f9125f;

    public static LimitQueue f9126g;

    public static HistoryBean m5633a(int i6, String str) {
        AbstractC0032a.m165s("/Pacwe9FY0bS4Jzi/E83\n", "u5PojY42Fw4=\n");
        LimitQueue limitQueue = f9125f;
        if (limitQueue == null) {
            return null;
        }
        for (HistoryBean historyBean : m5634c(limitQueue.toArray())) {
            if (historyBean.chid == i6 && historyBean.subId.equals(str)) {
                String str2 = AbstractC0032a.m165s("buZr+B3asiRA8GvbDtDmHkz3asYSiQ==\n", "KYMftHypxmw=\n") + historyBean.lastPosition;
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(f9120a, str2);
                return historyBean;
            }
        }
        return null;
    }

    public static List m5634c(Object[] objArr) {
        List listAsList = Arrays.asList(objArr);
        Collections.reverse(listAsList);
        return listAsList;
    }

    public final synchronized List m5635b() {
        return m5634c(f9126g.toArray());
    }

    public final synchronized void m5636d(ChannelBean channelBean) {
        try {
            Iterator it = f9126g.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                if (((ChannelBean) it.next()).getChid() == channelBean.getChid()) {
                    f9126g.set(i6, channelBean);
                }
                i6++;
            }
            C2340c c2340c = Spark.f11008d2;
            String str = f9123d;
            c2340c.m5311g(str);
            Spark.f11008d2.m5308d(str, f9126g, 315360000);
        } catch (Throwable th) {
            throw th;
        }
    }
}
