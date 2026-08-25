package p063fa;

import android.view.View;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p116ka.C2933n;
import p116ka.ViewOnKeyListenerC2937r;

public final class ViewOnLongClickListenerC2510b0 implements View.OnLongClickListener {

    public final int f8748a;

    public final C2516d0 f8749b;

    public ViewOnLongClickListenerC2510b0(C2516d0 c2516d0, int i6) {
        this.f8749b = c2516d0;
        this.f8748a = i6;
    }

    @Override
    public final boolean onLongClick(View view) {
        C2516d0 c2516d0 = this.f8749b;
        c2516d0.f8771h = true;
        C2933n c2933n = c2516d0.f8769f;
        int i6 = this.f8748a;
        c2933n.getClass();
        String strM165s = AbstractC0032a.m165s("tLlY3lot\n", "9uoVuzRYjIU=\n");
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("YKkVK1u6N8hgqRUrW7o3yGCpFmcW0GCOLsZZZh/aeIIg4Q==\n", "Q4o2CHiZFOs=\n"));
        ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = c2933n.f9989b;
        sb.append(viewOnKeyListenerC2937r.f10015m0);
        String string = sb.toString();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, string);
        ChannelBean channelBean = (ChannelBean) view.getTag();
        if (channelBean != null) {
            viewOnKeyListenerC2937r.m5963j0(channelBean, i6);
        }
        return true;
    }
}
