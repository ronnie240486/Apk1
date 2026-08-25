package p063fa;

import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import androidx.mediarouter.app.HandlerC1080c;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.Group;
import p116ka.C2933n;
import p116ka.ViewOnKeyListenerC2932m0;
import p156o9.AbstractC3280d;

public final class DialogInterfaceOnClickListenerC2517d1 implements DialogInterface.OnClickListener {

    public final int f8772a;

    public final int f8773b;

    public final Object f8774c;

    public final Object f8775d;

    public DialogInterfaceOnClickListenerC2517d1(Object obj, Object obj2, int i6, int i10) {
        this.f8772a = i10;
        this.f8775d = obj;
        this.f8774c = obj2;
        this.f8773b = i6;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        switch (this.f8772a) {
            case 0:
                Spark.f11007c2 = true;
                ((C2520e1) this.f8774c).f8781a.setImageResource(R.mipmap.group_type_lock_0);
                C2523f1 c2523f1 = (C2523f1) this.f8775d;
                c2523f1.notifyItemChanged(c2523f1.f8884a);
                ViewOnKeyListenerC2932m0.f9950E0.removeMessages(3);
                HandlerC1080c handlerC1080c = ViewOnKeyListenerC2932m0.f9950E0;
                int i10 = this.f8773b;
                Message messageObtain = Message.obtain(handlerC1080c, 3, i10, 0);
                messageObtain.obj = ((Group) c2523f1.f8792h.get(i10)).url;
                ViewOnKeyListenerC2932m0.f9950E0.sendMessage(messageObtain);
                break;
            default:
                Spark.f11007c2 = true;
                C2933n c2933n = (C2933n) this.f8775d;
                c2933n.f9989b.m5956c0();
                AbstractC3280d.m6606y((View) this.f8774c);
                c2933n.f9989b.f10001X.notifyItemChanged(this.f8773b);
                break;
        }
    }
}
