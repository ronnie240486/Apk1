package androidx.appcompat.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public final class C0175a2 extends DataSetObserver {

    public final int f863a;

    public final Object f864b;

    public C0175a2(int i6, Object obj) {
        this.f863a = i6;
        this.f864b = obj;
    }

    @Override
    public final void onChanged() {
        switch (this.f863a) {
            case 0:
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.f864b;
                if (listPopupWindow.f715y.isShowing()) {
                    listPopupWindow.mo576a();
                }
                break;
            case 1:
                ((ViewPager) this.f864b).m3085e();
                break;
            case 2:
                ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3 = (ViewOnClickListenerC0204f3) this.f864b;
                viewOnClickListenerC0204f3.f12750a = true;
                viewOnClickListenerC0204f3.notifyDataSetChanged();
                break;
            default:
                ((TabLayout) this.f864b).m4343j();
                break;
        }
    }

    @Override
    public final void onInvalidated() {
        switch (this.f863a) {
            case 0:
                ((ListPopupWindow) this.f864b).dismiss();
                break;
            case 1:
                ((ViewPager) this.f864b).m3085e();
                break;
            case 2:
                ViewOnClickListenerC0204f3 viewOnClickListenerC0204f3 = (ViewOnClickListenerC0204f3) this.f864b;
                viewOnClickListenerC0204f3.f12750a = false;
                viewOnClickListenerC0204f3.notifyDataSetInvalidated();
                break;
            default:
                ((TabLayout) this.f864b).m4343j();
                break;
        }
    }
}
