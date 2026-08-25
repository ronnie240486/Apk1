package p258y1;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.Visibility;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;

public final class C4220l0 extends AbstractC4237z {

    public final ViewGroup f14340a;

    public final View f14341b;

    public final View f14342c;

    public final Visibility f14343d;

    public C4220l0(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
        this.f14343d = visibility;
        this.f14340a = viewGroup;
        this.f14341b = view;
        this.f14342c = view2;
    }

    @Override
    public final void mo8251b() {
        this.f14340a.getOverlay().remove(this.f14341b);
    }

    @Override
    public final void mo8252c() {
        View view = this.f14341b;
        if (view.getParent() == null) {
            this.f14340a.getOverlay().add(view);
            return;
        }
        Visibility visibility = this.f14343d;
        ArrayList arrayList = visibility.f3803m;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = visibility.f3807q;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) visibility.f3807q.clone();
        int size2 = arrayList3.size();
        for (int i6 = 0; i6 < size2; i6++) {
            ((InterfaceC4236y) arrayList3.get(i6)).mo8253d();
        }
    }

    @Override
    public final void mo8254e(Transition transition) {
        this.f14342c.setTag(R.id.save_overlay_view, null);
        this.f14340a.getOverlay().remove(this.f14341b);
        transition.m3065u(this);
    }
}
