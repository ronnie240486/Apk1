package p116ka;

import android.content.DialogInterface;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import p063fa.C2525g0;

public final class DialogInterfaceOnClickListenerC2931m implements DialogInterface.OnClickListener {

    public final ChannelBean f9945a;

    public final ViewOnKeyListenerC2937r f9946b;

    public DialogInterfaceOnClickListenerC2931m(ViewOnKeyListenerC2937r viewOnKeyListenerC2937r, ChannelBean channelBean) {
        this.f9946b = viewOnKeyListenerC2937r;
        this.f9945a = channelBean;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        Spark.f11007c2 = true;
        ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = this.f9946b;
        viewOnKeyListenerC2937r.m5956c0();
        C2525g0 c2525g0 = viewOnKeyListenerC2937r.f10001X;
        if (c2525g0 != null) {
            c2525g0.notifyDataSetChanged();
        }
        viewOnKeyListenerC2937r.m5955b0(this.f9945a);
    }
}
