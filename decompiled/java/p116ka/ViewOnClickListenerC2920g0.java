package p116ka;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import ba.C1371d;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import p003a2.AbstractC0032a;
import p214ta.C3877a;

public final class ViewOnClickListenerC2920g0 implements View.OnClickListener {

    public final ChannelBean f9900a;

    public final C2924i0 f9901b;

    public ViewOnClickListenerC2920g0(C2924i0 c2924i0, ChannelBean channelBean) {
        this.f9901b = c2924i0;
        this.f9900a = channelBean;
    }

    @Override
    public final void onClick(View view) {
        C2924i0 c2924i0 = this.f9901b;
        C3877a c3877a = c2924i0.f9912U;
        if (!c3877a.f13009v) {
            C1371d.m3242a(c2924i0.m1321j(), 0, c2924i0.m1324m().getString(R.string.advise_delete_outdated_programs)).show();
            return;
        }
        ChannelBean channelBean = this.f9900a;
        c3877a.f13005r = channelBean.getSources().get(0);
        C3877a c3877a2 = c2924i0.f9912U;
        c3877a2.f12990G = true;
        Message message = new Message();
        message.what = 80;
        ChannelBean.SourcesBean sourcesBean = channelBean.getSources().get(0);
        String address = sourcesBean.getAddress();
        if (TextUtils.isEmpty(address)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AbstractC0032a.m165s("iC1Q\n", "/V88EZp38RM=\n"), address);
        bundle.putInt(AbstractC0032a.m165s("bxcOKA==\n", "DH9nTMFCsFo=\n"), channelBean.getChid());
        bundle.putInt(AbstractC0032a.m165s("0Yfv4Bk=\n", "veKZhXUn4og=\n"), channelBean.getLevel());
        bundle.putString(AbstractC0032a.m165s("HKpDmg==\n", "cssu/8RRKB4=\n"), channelBean.getName().getInit());
        bundle.putString(AbstractC0032a.m165s("aGZU+4Q=\n", "GxM2suBVYb4=\n"), String.valueOf(sourcesBean.getId()));
        bundle.putString(AbstractC0032a.m165s("jhj4r56Mwaw=\n", "/W2a2/f4rck=\n"), sourcesBean.getSubTitle());
        bundle.putString(AbstractC0032a.m165s("ulf8ThhhMMs=\n", "1zKSO0wYQK4=\n"), c3877a2.f13003p.name());
        bundle.putString(AbstractC0032a.m165s("A8kzZg==\n", "d7BDA0svVuQ=\n"), ((address.startsWith(AbstractC0032a.m165s("bJnAvtGdsAQ=\n", "GO+j36Onnys=\n")) || address.startsWith(AbstractC0032a.m165s("M6DBwChggEho\n", "R9aioVoTumc=\n"))) ? Constants$VIDEO_TYPE.BSVOD : Constants$VIDEO_TYPE.STATIC).name());
        message.setData(bundle);
        Spark.f11002X1.sendMessage(message);
    }
}
