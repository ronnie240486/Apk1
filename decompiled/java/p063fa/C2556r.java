package p063fa;

import android.widget.Filter;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import ga.C2625h;
import java.util.ArrayList;
import java.util.List;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.HistoryBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2556r extends Filter {

    public final C2560t f8898a;

    public C2556r(C2560t c2560t) {
        this.f8898a = c2560t;
    }

    @Override
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Constants$VIDEO_TYPE constants$VIDEO_TYPE;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE2;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE3;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE4;
        String str;
        Filter.FilterResults filterResults = new Filter.FilterResults();
        ArrayList arrayList = new ArrayList();
        AbstractC0032a.m165s("MQ0Ity22k3gdBQu3J7Y=\n", "eWR7w0LE6jk=\n");
        AbstractC0032a.m165s("j5thHxOYIdSPm2EfEshwhtrVMkcS03CPy4A=\n", "rrpAPjKgGfU=\n");
        this.f8898a.f8903g.size();
        this.f8898a.f8905i.name();
        if (this.f8898a.f8903g != null) {
            for (int i6 = 0; i6 < this.f8898a.f8903g.size(); i6++) {
                HistoryBean historyBean = (HistoryBean) this.f8898a.f8903g.get(i6);
                if (Spark.f11007c2) {
                    constants$VIDEO_TYPE = historyBean.type;
                    constants$VIDEO_TYPE2 = Constants$VIDEO_TYPE.BSLIVE;
                    if (constants$VIDEO_TYPE != constants$VIDEO_TYPE2) {
                        constants$VIDEO_TYPE3 = Constants$VIDEO_TYPE.BSPALYBACK;
                        if (constants$VIDEO_TYPE != constants$VIDEO_TYPE3) {
                            constants$VIDEO_TYPE4 = Constants$VIDEO_TYPE.BSVOD;
                            if (constants$VIDEO_TYPE != constants$VIDEO_TYPE4 || constants$VIDEO_TYPE == Constants$VIDEO_TYPE.STATIC) {
                                arrayList.add(historyBean);
                            } else if (constants$VIDEO_TYPE == null && (str = historyBean.address) != null) {
                                if (str.contains(AbstractC0032a.m165s("VDcDVsA=\n", "IEFhI7ODvqg=\n"))) {
                                    arrayList.add(historyBean);
                                    historyBean.type = constants$VIDEO_TYPE2;
                                } else if (!historyBean.address.contains(AbstractC0032a.m165s("9Yi4ZqE=\n", "gf7bB9MqT/g=\n"))) {
                                    arrayList.add(historyBean);
                                    historyBean.type = constants$VIDEO_TYPE4;
                                } else if (C2625h.m5629b(historyBean.chid, historyBean.subId) == null) {
                                    arrayList.add(historyBean);
                                    historyBean.type = constants$VIDEO_TYPE4;
                                } else {
                                    arrayList.add(historyBean);
                                    historyBean.type = constants$VIDEO_TYPE3;
                                }
                            }
                        } else if (C2621d.f9109c == null && ((ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid))) != null && C2625h.m5629b(historyBean.chid, historyBean.subId) != null) {
                            arrayList.add(historyBean);
                        }
                    } else if (C2621d.f9109c == null && C2621d.f9109c.get(Integer.valueOf(historyBean.chid)) != null) {
                        arrayList.add(historyBean);
                    }
                } else {
                    Constants$VIDEO_TYPE constants$VIDEO_TYPE5 = historyBean.type;
                    if (constants$VIDEO_TYPE5 == Constants$VIDEO_TYPE.BSLIVE || constants$VIDEO_TYPE5 == Constants$VIDEO_TYPE.BSPALYBACK) {
                        if (C2621d.f9109c == null || C2621d.f9109c.get(Integer.valueOf(historyBean.chid)) == null || ((ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid))).getLevel() < 18) {
                            constants$VIDEO_TYPE = historyBean.type;
                            constants$VIDEO_TYPE2 = Constants$VIDEO_TYPE.BSLIVE;
                            if (constants$VIDEO_TYPE != constants$VIDEO_TYPE2) {
                                constants$VIDEO_TYPE3 = Constants$VIDEO_TYPE.BSPALYBACK;
                                if (constants$VIDEO_TYPE != constants$VIDEO_TYPE3) {
                                    constants$VIDEO_TYPE4 = Constants$VIDEO_TYPE.BSVOD;
                                    if (constants$VIDEO_TYPE != constants$VIDEO_TYPE4) {
                                        arrayList.add(historyBean);
                                    } else {
                                        arrayList.add(historyBean);
                                    }
                                } else if (C2621d.f9109c == null) {
                                    arrayList.add(historyBean);
                                }
                            } else if (C2621d.f9109c == null) {
                            }
                        } else {
                            String strM165s = AbstractC0032a.m165s("pH/2GLZccOqId/UYvFw=\n", "7BaFbNkuCas=\n");
                            String strM165s2 = AbstractC0032a.m165s("P0imTmsJG+Q8U6kLTwUe9T8B7hYDUVC8c1K7QlMQAf40Af4FDQ==\n", "UyHQKyNgaJA=\n");
                            boolean z7 = AbstractC3331m.f11244b;
                            Log.m5049i(strM165s, strM165s2);
                        }
                    } else if (constants$VIDEO_TYPE5 != Constants$VIDEO_TYPE.BSVOD || C2621d.f9109c == null || C2621d.f9109c.get(Integer.valueOf(historyBean.chid)) == null || ((ChannelBean) C2621d.f9109c.get(Integer.valueOf(historyBean.chid))).getLevel() < 18) {
                        constants$VIDEO_TYPE = historyBean.type;
                        constants$VIDEO_TYPE2 = Constants$VIDEO_TYPE.BSLIVE;
                        if (constants$VIDEO_TYPE != constants$VIDEO_TYPE2) {
                            constants$VIDEO_TYPE3 = Constants$VIDEO_TYPE.BSPALYBACK;
                            if (constants$VIDEO_TYPE != constants$VIDEO_TYPE3) {
                                constants$VIDEO_TYPE4 = Constants$VIDEO_TYPE.BSVOD;
                                if (constants$VIDEO_TYPE != constants$VIDEO_TYPE4) {
                                    arrayList.add(historyBean);
                                } else {
                                    arrayList.add(historyBean);
                                }
                            } else if (C2621d.f9109c == null) {
                                arrayList.add(historyBean);
                            }
                        } else if (C2621d.f9109c == null) {
                        }
                    } else {
                        String strM165s3 = AbstractC0032a.m165s("p0Nwu1Evl/mLS3O7Wy8=\n", "7yoDzz5d7rg=\n");
                        String strM165s4 = AbstractC0032a.m165s("TfLUs3hFl6hJ5JCXdECGqxujjdsgDs/nSPbZi2FfjaAbs57V\n", "O52w+xE248c=\n");
                        boolean z10 = AbstractC3331m.f11244b;
                        Log.m5049i(strM165s3, strM165s4);
                    }
                }
            }
        }
        filterResults.count = arrayList.size();
        filterResults.values = arrayList;
        AbstractC0032a.m165s("jUiOIHhVlnehQI0gclU=\n", "xSH9VBcn7zY=\n");
        AbstractC0032a.m165s("KfXJcRY0678p9clxF3627X24nCMZb7zrZqDScA==\n", "CNToUDcM054=\n");
        this.f8898a.f8905i.name();
        return filterResults;
    }

    @Override
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        List list = (List) filterResults.values;
        C2560t c2560t = this.f8898a;
        c2560t.f8903g = list;
        AbstractC0032a.m165s("R4RU61N1z3ZrjFfrWXU=\n", "D+0nnzwHtjc=\n");
        AbstractC0032a.m165s("0C4WzONMnJTQLhbM4gTR151mRIWQEdfAnXtEzQ==\n", "8Q837cJ0pLU=\n");
        c2560t.f8905i.name();
        c2560t.notifyDataSetChanged();
    }
}
