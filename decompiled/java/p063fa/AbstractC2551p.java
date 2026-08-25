package p063fa;

import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p007a7.C0069f;
import p055ea.EnumC2434d;
import p116ka.ViewOnKeyListenerC2932m0;

public abstract class AbstractC2551p extends AbstractC1158k0 {

    public static final String f8883f = AbstractC0032a.m165s("XAhShztkKP1mDF6BNUYg+WQuUpY=\n", "FFo35EIHRJg=\n");

    public RecyclerView f8886c;

    public final int f8887d;

    public int f8884a = 0;

    public int f8885b = -1;

    public C0069f f8888e = null;

    public AbstractC2551p(int i6) {
        this.f8887d = i6;
    }

    public static boolean m5559a(AbstractC2551p abstractC2551p, int i6) {
        abstractC2551p.f8885b = abstractC2551p.f8884a + i6;
        String str = AbstractC0032a.m165s("jrsFMoSF682HoRQ7jNy/\n", "4+hgXuHmn6g=\n") + abstractC2551p.f8884a + AbstractC0032a.m165s("54jUSBZFyFOihcV5FnPABec=\n", "x+axMGIWrT8=\n") + abstractC2551p.f8885b;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f8883f, str);
        int i10 = abstractC2551p.f8885b;
        if (i10 >= 0 && i10 < abstractC2551p.getItemCount()) {
            abstractC2551p.notifyItemChanged(abstractC2551p.f8884a);
            int i11 = abstractC2551p.f8885b;
            abstractC2551p.f8884a = i11;
            abstractC2551p.notifyItemChanged(i11);
            abstractC2551p.f8886c.scrollToPosition(abstractC2551p.f8884a);
            return true;
        }
        if (abstractC2551p.f8885b == abstractC2551p.getItemCount()) {
            return true;
        }
        if (abstractC2551p.f8885b == -1) {
            ViewOnKeyListenerC2932m0.f9951F0 = EnumC2434d.f8532d;
            abstractC2551p.notifyItemChanged(0);
            if (abstractC2551p.f8887d == 2) {
                Spark.f11002X1.sendEmptyMessage(120);
                return true;
            }
        }
        return false;
    }

    @Override
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f8886c = recyclerView;
        recyclerView.setOnKeyListener(new ViewOnKeyListenerC2539l(this, 1, recyclerView));
        recyclerView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0263r2(3, this));
    }
}
