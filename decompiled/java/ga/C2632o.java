package ga;

import android.util.SparseArray;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bitspark.android.Spark;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.beans.GroupBeanModel;
import org.bitspark.android.beans.GroupL1;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p116ka.ViewOnKeyListenerC2932m0;

public final class C2632o {

    public static final String f9148a = AbstractC0032a.m165s("PWzgcEiGkfsRUdNz\n", "fz+2HyzF+Zo=\n");

    public static HashMap f9149b;

    public static volatile SparseArray f9150c;

    public static volatile SparseArray f9151d;

    public static volatile HashSet f9152e;

    public static volatile List f9153f;

    static {
        AbstractC0032a.m165s("stDL6Glou26vzZXFY22+eabEiOI3C6UQmPM=\n", "y6mykUQl9kM=\n");
        new SimpleDateFormat(AbstractC0032a.m165s("N3dxP25NOPQqai8SZEg94yNjMjUwLiaKHVQ=\n", "Tg4IRkMAddk=\n"), Locale.getDefault());
    }

    public static void m5653a() {
        HashSet hashSet;
        if (f9153f == null) {
            return;
        }
        long time = new Date().getTime();
        String str = f9148a;
        String str2 = AbstractC0032a.m165s("SeHBc4GrqXpetcNplOWxcFa153Oa/q98VPKOL9ur\n", "OpWgAfWL3xU=\n") + time;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(str, str2);
        f9152e = new HashSet();
        C2626i c2626i = Spark.f11003Y1;
        if (c2626i != null) {
            synchronized (c2626i) {
                hashSet = new HashSet();
                Iterator it = C2626i.f9126g.iterator();
                while (it.hasNext()) {
                    hashSet.add(String.valueOf(((ChannelBean) it.next()).getChid()));
                }
            }
            f9152e = hashSet;
        }
        String str3 = f9148a;
        Log.m5049i(str3, AbstractC0032a.m165s("AbIOqDD++3UBsg6oM6u3MkH5TOV9uLQRUP5Y+3qzv3Y=\n", "IpEtixPd2FY=\n") + f9152e.toString());
        f9150c = new SparseArray();
        f9149b = new HashMap();
        f9151d = new SparseArray();
        GroupL1 groupL1 = new GroupL1();
        groupL1.f11179id = 0;
        groupL1.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Recommend);
        groupL1.groups = new HashSet<>();
        f9151d.put(groupL1.f11179id, groupL1);
        f9149b.put(groupL1.name, Integer.valueOf(groupL1.f11179id));
        Group group = new Group();
        group.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Popular);
        group.f11178id = -10;
        group.channnels = new ArrayList();
        f9150c.put(-10, group);
        groupL1.groups.add(Integer.valueOf(group.f11178id));
        Group group2 = new Group();
        group2.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Favorites);
        group2.f11178id = -5;
        group2.channnels = new ArrayList();
        f9150c.put(-5, group2);
        groupL1.groups.add(Integer.valueOf(group2.f11178id));
        Log.m5049i(str3, AbstractC0032a.m165s("98ZyL+2WSS33xnFaodEsfLWCPGmgwURHh7oCSY/nKUaLtgVNmvBQLg==\n", "1OVRDM61ag4=\n") + ViewOnKeyListenerC2932m0.f9952G0);
        new HashMap();
        for (GroupBeanModel groupBeanModel : f9153f) {
            if (!ViewOnKeyListenerC2932m0.f9952G0) {
                Group group3 = new Group();
                group3.f11178id = groupBeanModel.group_id;
                group3.name = groupBeanModel.group_name;
                group3.restrictedAccess = groupBeanModel.restrictedAccess;
                group3.channnels = new ArrayList();
                GroupL1 groupL2 = new GroupL1();
                groupL2.name = groupBeanModel.group_name;
                groupL2.f11179id = groupBeanModel.group_id;
                HashSet<Integer> hashSet2 = new HashSet<>();
                groupL2.groups = hashSet2;
                hashSet2.add(Integer.valueOf(groupBeanModel.group_id));
                f9151d.put(groupL2.f11179id, groupL2);
                f9149b.put(groupL2.name, Integer.valueOf(groupL2.f11179id));
            }
        }
    }

    public static ChannelBean.TagsBean m5654b(int i6) {
        if (f9153f == null) {
            return null;
        }
        Iterator it = f9153f.iterator();
        while (it.hasNext()) {
            for (ChannelBean.TagsBean tagsBean : ((GroupBeanModel) it.next()).items) {
                if (tagsBean.getId() == i6) {
                    return tagsBean;
                }
            }
        }
        return null;
    }
}
