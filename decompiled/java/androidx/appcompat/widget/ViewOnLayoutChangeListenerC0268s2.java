package androidx.appcompat.widget;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.navigation.AbstractC1844d;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import la.ViewOnClickListenerC3017d;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p272z5.C4355a;
import p273z6.C4357a;

public final class ViewOnLayoutChangeListenerC0268s2 implements View.OnLayoutChangeListener {

    public final int f1063a;

    public final Object f1064b;

    public ViewOnLayoutChangeListenerC0268s2(int i6, Object obj) {
        this.f1063a = i6;
        this.f1064b = obj;
    }

    @Override
    public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        C4355a c4355a;
        Object obj = this.f1064b;
        switch (this.f1063a) {
            case 0:
                SearchView searchView = (SearchView) obj;
                View view2 = searchView.f754x;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f748r.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean zM648a = AbstractC0189c4.m648a(searchView);
                    int dimensionPixelSize = searchView.f729M ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f746p;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    searchAutoComplete.setDropDownHorizontalOffset(zM648a ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                }
                break;
            case 1:
                AbstractC1844d abstractC1844d = (AbstractC1844d) obj;
                ImageView imageView = abstractC1844d.f6535k;
                if (imageView.getVisibility() == 0 && (c4355a = abstractC1844d.f6524B) != null) {
                    Rect rect2 = new Rect();
                    imageView.getDrawingRect(rect2);
                    c4355a.setBounds(rect2);
                    c4355a.m8397f(imageView, null);
                    break;
                }
                break;
            case 2:
                Rect rect3 = new Rect();
                ViewOnClickListenerC3017d viewOnClickListenerC3017d = (ViewOnClickListenerC3017d) obj;
                viewOnClickListenerC3017d.f10325j0.getWindowVisibleDisplayFrame(rect3);
                int height = viewOnClickListenerC3017d.f10325j0.getRootView().getHeight();
                if (height - rect3.bottom > ((double) height) * 0.15d) {
                    viewOnClickListenerC3017d.f10322g0 = true;
                } else {
                    viewOnClickListenerC3017d.f10322g0 = false;
                }
                String strM165s = AbstractC0032a.m165s("Hzs5Ag0=\n", "U1Rea2MLTqw=\n");
                String str = AbstractC0032a.m165s("5u5ZaYSRBDrK6HRmmptLbg==\n", "iYAVCP3+cU4=\n") + viewOnClickListenerC3017d.f10322g0;
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                break;
            default:
                C4357a c4357a = (C4357a) obj;
                c4357a.getClass();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                c4357a.f14791I = iArr[0];
                view.getWindowVisibleDisplayFrame(c4357a.f14785C);
                break;
        }
    }
}
