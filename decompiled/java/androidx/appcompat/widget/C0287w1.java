package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p116ka.ViewOnKeyListenerC2937r;

public final class C0287w1 implements AdapterView.OnItemSelectedListener {

    public final int f1116a;

    public final Object f1117b;

    public C0287w1(int i6, Object obj) {
        this.f1116a = i6;
        this.f1117b = obj;
    }

    @Override
    public final void onItemSelected(AdapterView adapterView, View view, int i6, long j10) {
        C0267s1 c0267s1;
        Object obj = this.f1117b;
        switch (this.f1116a) {
            case 0:
                if (i6 != -1 && (c0267s1 = ((ListPopupWindow) obj).f693c) != null) {
                    c0267s1.setListSelectionHidden(false);
                    break;
                }
                break;
            case 1:
                ((SearchView) obj).m595q(i6);
                break;
            default:
                if (view != null) {
                    ViewOnKeyListenerC2937r viewOnKeyListenerC2937r = (ViewOnKeyListenerC2937r) obj;
                    viewOnKeyListenerC2937r.f10010h0 = view;
                    String strM165s = AbstractC0032a.m165s("PPSnLRoM\n", "fqfqSHR52Ks=\n");
                    String str = AbstractC0032a.m165s("E6pkMzOznoAQoU4zM7rtiR23WQE5vbiWObRKET+7ut9c\n", "fMQtR1bezeU=\n") + view + AbstractC0032a.m165s("IUfKX9dKZMQhR8pf\n", "HHr3Yup3Wfk=\n") + viewOnKeyListenerC2937r.m1319h().getCurrentFocus();
                    boolean z7 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, str);
                }
                break;
        }
    }

    @Override
    public final void onNothingSelected(AdapterView adapterView) {
        int i6 = this.f1116a;
    }

    private final void m807a(AdapterView adapterView) {
    }

    private final void m808b(AdapterView adapterView) {
    }

    private final void m809c(AdapterView adapterView) {
    }
}
