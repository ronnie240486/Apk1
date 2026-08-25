package p063fa;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import p156o9.AbstractC3280d;

public final class ViewOnKeyListenerC2537k0 implements View.OnKeyListener {

    public final int f8847a;

    public final C2540l0 f8848b;

    public final C2543m0 f8849c;

    public ViewOnKeyListenerC2537k0(C2543m0 c2543m0, int i6, C2540l0 c2540l0) {
        this.f8849c = c2543m0;
        this.f8847a = i6;
        this.f8848b = c2540l0;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        RecyclerView recyclerView;
        int i10 = this.f8847a;
        C2543m0 c2543m0 = this.f8849c;
        if (i6 == 20) {
            if (keyEvent.getAction() == 1) {
                int size = c2543m0.f8866d.size();
                int i11 = c2543m0.f8865c;
                int i12 = size % i11;
                int i13 = i10 % i11;
                boolean z7 = size / i11 == (i10 / i11) + 1;
                if (i12 != 0 && z7 && i13 >= i12) {
                    ViewParent parent = this.f8848b.itemView.getParent();
                    while (true) {
                        if (parent == null) {
                            recyclerView = null;
                            break;
                        }
                        if (parent instanceof RecyclerView) {
                            recyclerView = (RecyclerView) parent;
                            break;
                        }
                        parent = parent.getParent();
                    }
                    if (recyclerView != null) {
                        AbstractC3280d.m6607z(recyclerView, size);
                    }
                }
            } else if (c2543m0.f8864b != null) {
                view.setTag(Integer.valueOf(i10));
                return c2543m0.f8864b.onKey(view, i6, keyEvent);
            }
        } else if (c2543m0.f8864b != null) {
            view.setTag(Integer.valueOf(i10));
            return c2543m0.f8864b.onKey(view, i6, keyEvent);
        }
        return false;
    }
}
