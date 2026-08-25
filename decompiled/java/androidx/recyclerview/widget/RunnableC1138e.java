package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

public final class RunnableC1138e implements Runnable {

    public final int f3544a;

    public final ArrayList f3545b;

    public final C1157k f3546c;

    public RunnableC1138e(C1157k c1157k, ArrayList arrayList, int i6) {
        this.f3544a = i6;
        this.f3546c = c1157k;
        this.f3545b = arrayList;
    }

    @Override
    public final void run() {
        switch (this.f3544a) {
            case 0:
                ArrayList arrayList = this.f3545b;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    C1157k c1157k = this.f3546c;
                    if (!zHasNext) {
                        arrayList.clear();
                        c1157k.f3606m.remove(arrayList);
                    } else {
                        C1154j c1154j = (C1154j) it.next();
                        AbstractC1174p1 abstractC1174p1 = c1154j.f3592a;
                        c1157k.getClass();
                        View view = abstractC1174p1.itemView;
                        int i6 = c1154j.f3595d - c1154j.f3593b;
                        int i10 = c1154j.f3596e - c1154j.f3594c;
                        if (i6 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i10 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        c1157k.f3609p.add(abstractC1174p1);
                        viewPropertyAnimatorAnimate.setDuration(c1157k.f3691e).setListener(new C1145g(c1157k, abstractC1174p1, i6, view, i10, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.f3545b;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    C1157k c1157k2 = this.f3546c;
                    if (!zHasNext2) {
                        arrayList2.clear();
                        c1157k2.f3607n.remove(arrayList2);
                        break;
                    } else {
                        C1151i c1151i = (C1151i) it2.next();
                        c1157k2.getClass();
                        AbstractC1174p1 abstractC1174p2 = c1151i.f3578a;
                        View view2 = abstractC1174p2 == null ? null : abstractC1174p2.itemView;
                        AbstractC1174p1 abstractC1174p3 = c1151i.f3579b;
                        View view3 = abstractC1174p3 != null ? abstractC1174p3.itemView : null;
                        ArrayList arrayList3 = c1157k2.f3611r;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(c1157k2.f3692f);
                            arrayList3.add(c1151i.f3578a);
                            duration.translationX(c1151i.f3582e - c1151i.f3580c);
                            duration.translationY(c1151i.f3583f - c1151i.f3581d);
                            duration.alpha(0.0f).setListener(new C1148h(c1157k2, c1151i, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(c1151i.f3579b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(c1157k2.f3692f).alpha(1.0f).setListener(new C1148h(c1157k2, c1151i, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.f3545b;
                Iterator it3 = arrayList4.iterator();
                while (true) {
                    boolean zHasNext3 = it3.hasNext();
                    C1157k c1157k3 = this.f3546c;
                    if (!zHasNext3) {
                        arrayList4.clear();
                        c1157k3.f3605l.remove(arrayList4);
                    } else {
                        AbstractC1174p1 abstractC1174p4 = (AbstractC1174p1) it3.next();
                        c1157k3.getClass();
                        View view4 = abstractC1174p4.itemView;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        c1157k3.f3608o.add(abstractC1174p4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(c1157k3.f3689c).setListener(new C1142f(c1157k3, abstractC1174p4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
