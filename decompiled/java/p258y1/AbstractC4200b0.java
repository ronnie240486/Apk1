package p258y1;

import android.view.ViewGroup;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p160p.C3341e;

public abstract class AbstractC4200b0 {

    public static final AutoTransition f14274a = new AutoTransition();

    public static final ThreadLocal f14275b = new ThreadLocal();

    public static final ArrayList f14276c = new ArrayList();

    public static void m8249a(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = f14276c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (viewGroup.isLaidOut()) {
            arrayList.add(viewGroup);
            if (transition == null) {
                transition = f14274a;
            }
            Transition transitionClone = transition.clone();
            ArrayList arrayList2 = (ArrayList) m8250b().get(viewGroup);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo3064t(viewGroup);
                }
            }
            if (transitionClone != null) {
                transitionClone.m3055g(viewGroup, true);
            }
            if (viewGroup.getTag(R.id.transition_current_scene) != null) {
                throw new ClassCastException();
            }
            viewGroup.setTag(R.id.transition_current_scene, null);
            if (transitionClone != null) {
                ViewTreeObserverOnPreDrawListenerC4198a0 viewTreeObserverOnPreDrawListenerC4198a0 = new ViewTreeObserverOnPreDrawListenerC4198a0();
                viewTreeObserverOnPreDrawListenerC4198a0.f14265a = transitionClone;
                viewTreeObserverOnPreDrawListenerC4198a0.f14266b = viewGroup;
                viewGroup.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC4198a0);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC4198a0);
            }
        }
    }

    public static C3341e m8250b() {
        C3341e c3341e;
        ThreadLocal threadLocal = f14275b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (c3341e = (C3341e) weakReference.get()) != null) {
            return c3341e;
        }
        C3341e c3341e2 = new C3341e(0);
        threadLocal.set(new WeakReference(c3341e2));
        return c3341e2;
    }
}
