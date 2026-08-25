package androidx.media3.p011ui;

import android.view.View;

public final class ViewOnLayoutChangeListenerC1063h implements View.OnLayoutChangeListener {

    public final int f3131a;

    public final Object f3132b;

    public ViewOnLayoutChangeListenerC1063h(int i6, Object obj) {
        this.f3131a = i6;
        this.f3132b = obj;
    }

    @Override
    public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        switch (this.f3131a) {
            case 0:
                ((PlayerControlViewLayoutManager) this.f3132b).onLayoutChange(view, i6, i10, i11, i12, i13, i14, i15, i16);
                break;
            default:
                ((PlayerControlView) this.f3132b).onLayoutChange(view, i6, i10, i11, i12, i13, i14, i15, i16);
                break;
        }
    }
}
