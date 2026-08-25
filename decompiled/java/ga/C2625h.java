package ga;

import com.alibaba.fastjson.JSONReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;

public final class C2625h {

    public static final String f9116b = AbstractC0032a.m165s("cZ5RCq8=\n", "M80UWug8O+A=\n");

    public static final String f9117c = AbstractC0032a.m165s("3jmyHYWObOaQNbIKhQ==\n", "vVHTc6jrHIE=\n");

    public static final SimpleDateFormat f9118d;

    public SimpleDateFormat f9119a;

    static {
        AbstractC0032a.m165s("nuam/m2S+MqD+/jTZ5f93Yry5fQz8ea0tMU=\n", "55/fh0Dftec=\n");
        f9118d = new SimpleDateFormat(AbstractC0032a.m165s("l5uiTdAkT8uKhvxg2iFK3IOP4UeOR1G1vbg=\n", "7uLbNP1pAuY=\n"), Locale.getDefault());
    }

    public static HashMap m5628a(int i6) {
        Object objM5307b = Spark.f11008d2.m5307b(f9117c + i6);
        if (objM5307b == null) {
            return null;
        }
        return (HashMap) objM5307b;
    }

    public static EpgBeans.EpgBean m5629b(int i6, String str) {
        HashMap mapM5628a = m5628a(i6);
        if (mapM5628a == null) {
            return null;
        }
        Iterator it = mapM5628a.entrySet().iterator();
        while (it.hasNext()) {
            for (EpgBeans.EpgBean epgBean : (List) ((Map.Entry) it.next()).getValue()) {
                if (epgBean.getId().equals(str)) {
                    return epgBean;
                }
            }
        }
        return null;
    }

    public static ArrayList m5630c(int i6) {
        long jLongValue;
        long jLongValue2;
        long jLongValue3;
        int i10;
        HashMap mapM5628a = m5628a(i6);
        if (mapM5628a == null) {
            return null;
        }
        long time = new Date().getTime() + AbstractC3331m.f11243a;
        ArrayList arrayList = new ArrayList(mapM5628a.keySet());
        Collections.sort(arrayList);
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                jLongValue = 0;
                jLongValue2 = 0;
                jLongValue3 = 0;
                break;
            }
            if (((Long) arrayList.get(i11)).longValue() > time && (i10 = i11 - 1) >= 0) {
                jLongValue2 = ((Long) arrayList.get(i10)).longValue();
                jLongValue3 = ((Long) arrayList.get(i11)).longValue();
                int i12 = i11 - 2;
                if (i12 < 0) {
                    jLongValue = 0;
                    break;
                }
                jLongValue = ((Long) arrayList.get(i12)).longValue();
                break;
            }
            i11++;
        }
        if (jLongValue2 == 0 && arrayList.size() >= 1) {
            long jLongValue4 = ((Long) AbstractC2460q.m5491e(1, arrayList)).longValue();
            if (jLongValue4 + 86400000 > time) {
                if (arrayList.size() >= 2) {
                    jLongValue = ((Long) AbstractC2460q.m5491e(2, arrayList)).longValue();
                }
                jLongValue2 = jLongValue4;
            }
        }
        List list = (List) mapM5628a.get(Long.valueOf(jLongValue2));
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i13 = 0; i13 < list.size(); i13++) {
            if (((EpgBeans.EpgBean) list.get(i13)).getTime().longValue() <= time && time <= ((EpgBeans.EpgBean) list.get(i13)).getEndTime().longValue()) {
                arrayList2.add((EpgBeans.EpgBean) list.get(i13));
                int i14 = i13 + 1;
                if (i14 < list.size()) {
                    arrayList2.add((EpgBeans.EpgBean) list.get(i14));
                } else if (mapM5628a.get(Long.valueOf(jLongValue3)) != null && !((List) mapM5628a.get(Long.valueOf(jLongValue3))).isEmpty()) {
                    arrayList2.add((EpgBeans.EpgBean) ((List) mapM5628a.get(Long.valueOf(jLongValue3))).get(0));
                }
                return arrayList2;
            }
        }
        List list2 = (List) mapM5628a.get(Long.valueOf(jLongValue));
        if (list2 == null) {
            return null;
        }
        for (int i15 = 0; i15 < list2.size(); i15++) {
            if (((EpgBeans.EpgBean) list2.get(i15)).getTime().longValue() <= time && time <= ((EpgBeans.EpgBean) list2.get(i15)).getEndTime().longValue()) {
                arrayList2.add((EpgBeans.EpgBean) list2.get(i15));
                int i16 = i15 + 1;
                if (i16 < list2.size()) {
                    arrayList2.add((EpgBeans.EpgBean) list2.get(i16));
                } else if (!list.isEmpty()) {
                    arrayList2.add((EpgBeans.EpgBean) list.get(0));
                }
                return arrayList2;
            }
        }
        return null;
    }

    public static int m5631d(ChannelBean channelBean) {
        return channelBean.getEpgSameAs() > 0 ? channelBean.getEpgSameAs() : channelBean.getChid();
    }

    public static ArrayList m5632e(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        JSONReader jSONReader = new JSONReader(fileReader);
        jSONReader.startArray();
        ArrayList arrayList = new ArrayList();
        while (jSONReader.hasNext()) {
            jSONReader.startObject();
            EpgBeans epgBeans = new EpgBeans();
            while (jSONReader.hasNext()) {
                String string = jSONReader.readString();
                if (string.equals(AbstractC0032a.m165s("JUvi\n", "QDuFSBOZMKM=\n"))) {
                    jSONReader.startArray();
                    ArrayList arrayList2 = new ArrayList();
                    while (jSONReader.hasNext()) {
                        jSONReader.startObject();
                        EpgBeans.EpgBean epgBean = new EpgBeans.EpgBean();
                        while (jSONReader.hasNext()) {
                            String string2 = jSONReader.readString();
                            Object object = jSONReader.readObject();
                            String string3 = object != null ? object.toString() : "";
                            boolean zEquals = string2.equals(AbstractC0032a.m165s("45Z2kXuc+Q==\n", "hvgSxRLxnGg=\n"));
                            SimpleDateFormat simpleDateFormat = f9118d;
                            if (zEquals) {
                                epgBean.setEndTime(Long.valueOf(simpleDateFormat.parse(string3.replace(AbstractC0032a.m165s("7Q==\n", "t2oyKDe/Klc=\n"), AbstractC0032a.m165s("hB7CB2M=\n", "ry7yN1MjrJU=\n"))).getTime()));
                            }
                            if (string2.equals(AbstractC0032a.m165s("wH8=\n", "qRsoGpbxLaw=\n"))) {
                                epgBean.setId(string3);
                            }
                            if (string2.equals(AbstractC0032a.m165s("KhwTLg==\n", "RH1+S3OSMfs=\n"))) {
                                epgBean.setName(string3);
                            }
                            if (string2.equals(AbstractC0032a.m165s("1PGAYmDrx7Dx740=\n", "pJ3hGwKKpNs=\n"))) {
                                epgBean.setPlaybackUrl(string3);
                            } else if (string2.equals(AbstractC0032a.m165s("foZ75Q==\n", "Cu8WgJ6+4+A=\n"))) {
                                epgBean.setTime(Long.valueOf(simpleDateFormat.parse(string3.replace(AbstractC0032a.m165s("Cg==\n", "UJiss5/kv9E=\n"), AbstractC0032a.m165s("tJD6BzU=\n", "n6DKNwUS2RM=\n"))).getTime()));
                            }
                        }
                        jSONReader.endObject();
                        arrayList2.add(epgBean);
                    }
                    jSONReader.endArray();
                    epgBeans.setEpg(arrayList2);
                } else if (string.equals(AbstractC0032a.m165s("Lc/H4xAI1OIkzd8=\n", "Ra60s3xpraA=\n"))) {
                    epgBeans.setHasPlayBack(Boolean.parseBoolean(jSONReader.readObject().toString()));
                } else if (string.equals(AbstractC0032a.m165s("1yg=\n", "vkxET0TAE04=\n"))) {
                    epgBeans.setId(Integer.parseInt(jSONReader.readObject().toString()));
                } else {
                    jSONReader.readObject();
                }
            }
            arrayList.add(epgBeans);
            jSONReader.endObject();
        }
        jSONReader.endArray();
        jSONReader.close();
        fileReader.close();
        return arrayList;
    }
}
