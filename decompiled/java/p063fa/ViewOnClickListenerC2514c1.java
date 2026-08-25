package p063fa;

import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.Group;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p116ka.ViewOnKeyListenerC2932m0;
import p124l6.C2982h;

public final class ViewOnClickListenerC2514c1 implements View.OnClickListener {

    public final int f8761a;

    public final C2520e1 f8762b;

    public final C2523f1 f8763c;

    public ViewOnClickListenerC2514c1(C2523f1 c2523f1, int i6, C2520e1 c2520e1) {
        this.f8763c = c2523f1;
        this.f8761a = i6;
        this.f8762b = c2520e1;
    }

    @Override
    public final void onClick(View view) {
        int i6 = 0;
        String strM165s = AbstractC0032a.m165s("2/ruyi/96N3M8ev9Kffv\n", "jZWKjV2Sna0=\n");
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("iTrUL2HXGQ==\n", "yla9TArmOU0=\n"));
        C2523f1 c2523f1 = this.f8763c;
        sb.append(c2523f1.f8886c.getChildLayoutPosition(view));
        sb.append(AbstractC0032a.m165s("Yg==\n", "Q+kvqoB1dWo=\n"));
        String string = sb.toString();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, string);
        c2523f1.notifyItemChanged(c2523f1.f8884a);
        c2523f1.f8885b = c2523f1.f8886c.getChildLayoutPosition(view);
        int childLayoutPosition = c2523f1.f8886c.getChildLayoutPosition(view);
        c2523f1.f8884a = childLayoutPosition;
        c2523f1.notifyItemChanged(childLayoutPosition);
        SparseArray sparseArray = c2523f1.f8792h;
        int i10 = this.f8761a;
        if (((Group) sparseArray.get(i10)).restrictedAccess) {
            boolean z10 = Spark.f11007c2;
            C2520e1 c2520e1 = this.f8762b;
            if (!z10) {
                C2982h c2982h = new C2982h(c2523f1.f8791g);
                c2982h.f10226c = new DialogInterfaceOnClickListenerC2517d1(c2523f1, c2520e1, i10, i6);
                c2982h.m6042o().show();
            } else {
                c2523f1.notifyItemChanged(c2523f1.f8884a);
                c2520e1.f8781a.setImageResource(R.mipmap.group_type_lock_1);
                ViewOnKeyListenerC2932m0.f9950E0.removeMessages(3);
                ViewOnKeyListenerC2932m0.f9950E0.sendMessage(Message.obtain(ViewOnKeyListenerC2932m0.f9950E0, 3, i10, 0));
            }
        }
    }
}
