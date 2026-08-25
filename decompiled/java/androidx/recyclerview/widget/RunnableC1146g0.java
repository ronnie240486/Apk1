package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class RunnableC1146g0 implements Runnable {

    public final int f3570a;

    public final RecyclerView f3571b;

    public RunnableC1146g0(RecyclerView recyclerView, int i6) {
        this.f3570a = i6;
        this.f3571b = recyclerView;
    }

    @Override
    public final void run() {
        RecyclerView recyclerView = this.f3571b;
        switch (this.f3570a) {
            case 0:
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.mIsAttached) {
                        recyclerView.requestLayout();
                    } else if (!recyclerView.mLayoutSuppressed) {
                        recyclerView.consumePendingUpdateOperations();
                    } else {
                        recyclerView.mLayoutWasDefered = true;
                    }
                    break;
                }
                break;
            default:
                AbstractC1182s0 abstractC1182s0 = recyclerView.mItemAnimator;
                if (abstractC1182s0 != null) {
                    C1157k c1157k = (C1157k) abstractC1182s0;
                    ArrayList arrayList = c1157k.f3601h;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = c1157k.f3603j;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = c1157k.f3604k;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = c1157k.f3602i;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (!zIsEmpty || !zIsEmpty2 || !zIsEmpty4 || !zIsEmpty3) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            boolean zHasNext = it.hasNext();
                            long j10 = c1157k.f3690d;
                            if (zHasNext) {
                                AbstractC1174p1 abstractC1174p1 = (AbstractC1174p1) it.next();
                                View view = abstractC1174p1.itemView;
                                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                                c1157k.f3610q.add(abstractC1174p1);
                                viewPropertyAnimatorAnimate.setDuration(j10).alpha(0.0f).setListener(new C1142f(c1157k, abstractC1174p1, viewPropertyAnimatorAnimate, view)).start();
                                it = it;
                            } else {
                                arrayList.clear();
                                if (!zIsEmpty2) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    c1157k.f3606m.add(arrayList5);
                                    arrayList2.clear();
                                    RunnableC1138e runnableC1138e = new RunnableC1138e(c1157k, arrayList5, 0);
                                    if (zIsEmpty) {
                                        runnableC1138e.run();
                                    } else {
                                        View view2 = ((C1154j) arrayList5.get(0)).f3592a.itemView;
                                        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                                        view2.postOnAnimationDelayed(runnableC1138e, j10);
                                    }
                                }
                                if (!zIsEmpty3) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    c1157k.f3607n.add(arrayList6);
                                    arrayList3.clear();
                                    RunnableC1138e runnableC1138e2 = new RunnableC1138e(c1157k, arrayList6, 1);
                                    if (zIsEmpty) {
                                        runnableC1138e2.run();
                                    } else {
                                        View view3 = ((C1151i) arrayList6.get(0)).f3578a.itemView;
                                        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                                        view3.postOnAnimationDelayed(runnableC1138e2, j10);
                                    }
                                }
                                if (!zIsEmpty4) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    c1157k.f3605l.add(arrayList7);
                                    arrayList4.clear();
                                    RunnableC1138e runnableC1138e3 = new RunnableC1138e(c1157k, arrayList7, 2);
                                    if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                                        runnableC1138e3.run();
                                    } else {
                                        if (zIsEmpty) {
                                            j10 = 0;
                                        }
                                        long jMax = Math.max(!zIsEmpty2 ? c1157k.f3691e : 0L, zIsEmpty3 ? 0L : c1157k.f3692f) + j10;
                                        View view4 = ((AbstractC1174p1) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                                        view4.postOnAnimationDelayed(runnableC1138e3, jMax);
                                    }
                                }
                            }
                        }
                    }
                }
                recyclerView.mPostedAnimatorRunner = false;
                break;
        }
    }
}
