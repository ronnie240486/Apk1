package p063fa;

import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public abstract class AbstractC2562u extends AbstractC1158k0 {

    public static final String f8911e = AbstractC0032a.m165s("t6WXttr40hKar52h2e/ZFpapk4PR69s0mr4=\n", "/8zkwrWKq0A=\n");

    public static int f8912f = 0;

    public final Constants$VIDEO_TYPE f8913a;

    public int f8914b = 0;

    public int f8915c = -1;

    public RecyclerView f8916d;

    public AbstractC2562u(Constants$VIDEO_TYPE constants$VIDEO_TYPE) {
        this.f8913a = constants$VIDEO_TYPE;
        f8912f = 0;
    }

    public static boolean m5560a(AbstractC2562u abstractC2562u, int i6) {
        abstractC2562u.f8915c = abstractC2562u.f8914b + i6;
        String str = AbstractC0032a.m165s("tb6N420wBEy8pJzqZWlQ\n", "2O3ojwhTcCk=\n") + abstractC2562u.f8914b + AbstractC0032a.m165s("dEQ0F8hDnxcxSSUmyHWXQXQ=\n", "VCpRb7wQ+ns=\n") + abstractC2562u.f8915c;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f8911e, str);
        int i10 = abstractC2562u.f8915c;
        if (i10 < 0) {
            abstractC2562u.notifyItemChanged(abstractC2562u.f8914b);
            return false;
        }
        if (i10 >= 0 && i10 < abstractC2562u.getItemCount()) {
            abstractC2562u.notifyItemChanged(abstractC2562u.f8914b);
            int i11 = abstractC2562u.f8915c;
            abstractC2562u.f8914b = i11;
            abstractC2562u.notifyItemChanged(i11);
            abstractC2562u.f8916d.scrollToPosition(abstractC2562u.f8914b);
        } else if (abstractC2562u.f8915c < abstractC2562u.getItemCount()) {
            return false;
        }
        return true;
    }

    @Override
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f8916d = recyclerView;
        recyclerView.getItemAnimator().f3692f = 0L;
        recyclerView.setOnKeyListener(new ViewOnKeyListenerC2539l(this, 2, recyclerView));
        recyclerView.setOnLongClickListener(new ViewOnLongClickListenerC2542m(this, 1));
        recyclerView.setOnClickListener(new ViewOnClickListenerC0122a(11, this));
        recyclerView.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0263r2(4, this));
    }
}
