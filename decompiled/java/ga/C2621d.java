package ga;

import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2442h;

public final class C2621d {

    public static final String f9107a = AbstractC0032a.m165s("LRSdtfn3U/UD\n", "b0fe3ZiZPZA=\n");

    public static volatile List f9108b;

    public static volatile HashMap f9109c;

    public static volatile HashMap f9110d;

    public static volatile HashMap f9111e;

    public static volatile HashSet f9112f;

    public static void m5627a() {
        String strM165s = AbstractC0032a.m165s("FZOZiZl0APQPlYOQm2oe9giGig==\n", "RsPGz9giX7g=\n");
        HashSet hashSet = new HashSet();
        boolean z7 = AbstractC3331m.f11244b;
        f9112f = new HashSet(SpkApplication.f11160c.getApplicationContext().getSharedPreferences(AbstractC0032a.m165s("TZWZKdliOHk=\n", "L+bpW7wEXQs=\n"), 0).getStringSet(strM165s, hashSet));
        String str = f9107a;
        Log.m5049i(str, AbstractC0032a.m165s("WUcd3SQ7N5lZRx3dJ3t82xQKW5JAanvPCg1QmSc=\n", "emQ+/gcYFLo=\n") + f9112f.toString());
        f9109c = new HashMap();
        f9110d = new HashMap();
        f9111e = new HashMap();
        if (f9108b == null || f9108b.size() == 0) {
            Log.m5049i(str, AbstractC0032a.m165s("pVZ/z7KvADOlVn/Pse9LcegbOYDW/kxl9hwyi7GsQHjnGzKJ/cBKY/JIYYLk4E8w+gl8j/ntTX7j\nGRCF4vgNY+8POcS4sR4g\n", "hnVc7JGMIxA=\n"));
            return;
        }
        Group group = new Group();
        group.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Favorites_live);
        group.type = -5;
        group.channnels = new ArrayList();
        f9110d.put(-5, group);
        if (AbstractC2442h.f8579A) {
            Group group2 = new Group();
            group2.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.Playback);
            group2.type = -4;
            group2.channnels = new ArrayList();
            f9110d.put(-4, group2);
        }
        Group group3 = new Group();
        group3.name = SpkApplication.f11160c.getApplicationContext().getString(R.string.All_A_Z);
        group3.type = -3;
        group3.channnels = new ArrayList();
        f9110d.put(-3, group3);
        for (ChannelBean channelBean : f9108b) {
            List<ChannelBean.TagsBean> tags = channelBean.getTags();
            f9109c.put(Integer.valueOf(channelBean.getChid()), channelBean);
            if (channelBean.getSid() > 0) {
                f9111e.put(Integer.valueOf(channelBean.getSid()), channelBean);
            }
            for (ChannelBean.TagsBean tagsBean : tags) {
                if (f9110d.get(Integer.valueOf(tagsBean.getId())) == null) {
                    Group group4 = new Group();
                    group4.name = tagsBean.getName().getInit();
                    boolean zIsRestrictedAccess = tagsBean.isRestrictedAccess();
                    group4.restrictedAccess = zIsRestrictedAccess;
                    if (zIsRestrictedAccess || channelBean.getLevel() != 18) {
                        if (!AbstractC2442h.f8620z || tagsBean.getType() != 104) {
                            group4.type = tagsBean.getType();
                            ArrayList arrayList = new ArrayList();
                            group4.channnels = arrayList;
                            arrayList.add(channelBean);
                            f9110d.put(Integer.valueOf(tagsBean.getId()), group4);
                            if (!f9112f.contains("" + channelBean.getChid())) {
                            }
                        }
                    }
                } else if (((Group) f9110d.get(Integer.valueOf(tagsBean.getId()))).restrictedAccess || channelBean.getLevel() != 18) {
                    if (!AbstractC2442h.f8620z || tagsBean.getType() != 104) {
                        ((Group) f9110d.get(Integer.valueOf(tagsBean.getId()))).channnels.add(channelBean);
                        if (!f9112f.contains("" + channelBean.getChid()) && ((Group) f9110d.get(-5)).channnels.indexOf(channelBean) < 0) {
                            ((Group) f9110d.get(-5)).channnels.add(channelBean);
                        }
                    }
                }
            }
            if (channelBean.getLevel() < 18) {
                ((Group) f9110d.get(-3)).channnels.add(channelBean);
                if (channelBean.isHasPlayBack() && AbstractC2442h.f8579A) {
                    ((Group) f9110d.get(-4)).channnels.add(channelBean);
                }
            }
        }
        if (!AbstractC2442h.f8608n && f9110d.get(-5) != null && ((Group) f9110d.get(-5)).channnels != null && ((Group) f9110d.get(-5)).channnels.size() == 0) {
            f9110d.remove(-5);
        }
        Log.m5049i(f9107a, AbstractC0032a.m165s("ggucrXUV586CC5ytdlG2gtRY/OY3WKqIzWXe/nY=\n", "oSi/jlY2xO0=\n") + f9110d.size());
    }
}
