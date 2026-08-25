package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;

public final class C0181b2 implements AbsListView.OnScrollListener {

    public final ListPopupWindow f874a;

    public C0181b2(ListPopupWindow listPopupWindow) {
        this.f874a = listPopupWindow;
    }

    @Override
    public final void onScrollStateChanged(AbsListView absListView, int i6) {
        if (i6 == 1) {
            ListPopupWindow listPopupWindow = this.f874a;
            if (listPopupWindow.f715y.getInputMethodMode() == 2 || listPopupWindow.f715y.getContentView() == null) {
                return;
            }
            Handler handler = listPopupWindow.f711u;
            RunnableC0302z1 runnableC0302z1 = listPopupWindow.f707q;
            handler.removeCallbacks(runnableC0302z1);
            runnableC0302z1.run();
        }
    }

    @Override
    public final void onScroll(AbsListView absListView, int i6, int i10, int i11) {
    }
}
