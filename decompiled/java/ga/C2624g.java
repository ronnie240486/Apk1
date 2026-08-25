package ga;

import com.tencent.mars.xlog.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;

public final class C2624g extends Thread {

    public final File f9114a;

    public final C2625h f9115b;

    public C2624g(C2625h c2625h, File file) {
        this.f9115b = c2625h;
        this.f9114a = file;
    }

    @Override
    public final void run() {
        long j10 = Runtime.getRuntime().totalMemory();
        String strM165s = AbstractC0032a.m165s("AZR68Ek=\n", "Q8c/oA6LwTk=\n");
        String str = AbstractC0032a.m165s("Ays/RBfSZ78DKz9EF5s19l96TxxHgCj7BDY=\n", "PhYCeSrvWoI=\n") + j10 + AbstractC0032a.m165s("mXSvf5ge8nvDcvQ8\n", "uRfOHPB7oRI=\n") + ((int) j10);
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        long jM6753c = AbstractC3331m.m6753c(new Date().getTime() + AbstractC3331m.f11243a + 86400000);
        Log.m5049i(AbstractC0032a.m165s("y9whau4=\n", "iY9kOqmJjcs=\n"), AbstractC0032a.m165s("6dX1zz+LpR7q4P3QP62+HPia\n", "nbqYolD513E=\n") + this.f9115b.f9119a.format(Long.valueOf(jM6753c)));
        try {
            long time = new Date().getTime();
            ArrayList arrayListM5632e = C2625h.m5632e(this.f9114a);
            for (int i6 = 0; i6 < arrayListM5632e.size(); i6++) {
                HashMap map = new HashMap();
                ArrayList arrayList = new ArrayList();
                List<EpgBeans.EpgBean> epg = ((EpgBeans) arrayListM5632e.get(i6)).getEpg();
                Collections.sort(epg, new C2623f());
                long j11 = 0;
                for (int i10 = 0; i10 < epg.size(); i10++) {
                    String str2 = AbstractC2442h.f8595a;
                    long jM6753c2 = AbstractC3331m.m6753c(epg.get(i10).getTime().longValue());
                    if (j11 != jM6753c2) {
                        if (j11 != 0) {
                            map.put(Long.valueOf(j11), arrayList);
                            arrayList = new ArrayList();
                        }
                        arrayList.add(epg.get(i10));
                        j11 = jM6753c2;
                    } else {
                        arrayList.add(epg.get(i10));
                    }
                }
                if (arrayList.size() > 0) {
                    map.put(Long.valueOf(j11), arrayList);
                }
                if (map.size() > 0) {
                    Spark.f11008d2.m5311g(AbstractC0032a.m165s("Sj7Ti/p9V4wEMtOc+g==\n", "KVay5dcYJ+s=\n") + ((EpgBeans) arrayListM5632e.get(i6)).getId());
                    Spark.f11008d2.m5308d(AbstractC0032a.m165s("qpKFW2J5tv3knoVMYg==\n", "yfrkNU8cxpo=\n") + ((EpgBeans) arrayListM5632e.get(i6)).getId(), map, AbstractC2442h.f8601g / 1000);
                }
            }
            Spark.f11002X1.sendEmptyMessage(301);
            Log.m5049i(AbstractC0032a.m165s("q3SwdVI=\n", "6Sf1JRUPCfA=\n"), AbstractC0032a.m165s("Y5TDe6HdBy5v0cdn5ooKNWmUgjmvhA==\n", "B/GiF4Gqblo=\n") + (new Date().getTime() - time));
        } catch (Exception e5) {
            Log.m5049i(AbstractC0032a.m165s("M07e2Es=\n", "cR2biAwS6UI=\n"), AbstractC0032a.m165s("QhEv8+Ia/XlVUDnh81u4bEACMvKm\n", "MnBdgIc6mAk=\n"));
            e5.printStackTrace();
        } catch (Throwable th) {
            throw th;
        }
    }
}
