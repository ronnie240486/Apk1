package p063fa;

import android.view.View;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class ViewOnFocusChangeListenerC2519e0 implements View.OnFocusChangeListener {

    public final C2522f0 f8777a;

    public final int f8778b;

    public final int f8779c;

    public final C2525g0 f8780d;

    public ViewOnFocusChangeListenerC2519e0(C2525g0 c2525g0, C2522f0 c2522f0, int i6, int i10) {
        this.f8780d = c2525g0;
        this.f8777a = c2522f0;
        this.f8778b = i6;
        this.f8779c = i10;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        String strM165s = AbstractC0032a.m165s("M2RnG2WMkTYafFAdb4s=\n", "fh0gaQr54Xc=\n");
        String str = AbstractC0032a.m165s("Ddju3qydHTcK18bWqtJO\n", "Yraosc/obnQ=\n") + z7 + AbstractC0032a.m165s("tuG2LOY=\n", "i9yLEdsNLC0=\n") + view + AbstractC0032a.m165s("OunmIB12DNY=\n", "B9TbHSBLMes=\n") + ((Spark) this.f8777a.itemView.getContext()).getCurrentFocus();
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        C2525g0 c2525g0 = this.f8780d;
        if (c2525g0.f8802g) {
            view.setSelected(z7);
            if (z7) {
                c2525g0.m5554a(this.f8778b, view);
                Log.m5049i(AbstractC0032a.m165s("c7MMPrbzfkNaqzs4vPQ=\n", "PspLTNmGDgI=\n"), AbstractC0032a.m165s("+1GCMTbWMu38Xqo5MJlh3fFToT0hxiX4/Vqzfmg=\n", "lD/EXlWjQa4=\n") + view);
            }
            if (this.f8779c < c2525g0.f8799d.size()) {
                c2525g0.f8801f.m5943b(view, z7);
            }
        }
    }
}
