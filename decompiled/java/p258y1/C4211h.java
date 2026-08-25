package p258y1;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.transition.Transition;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import p160p.C3341e;
import p187r4.C3624n;

public final class C4211h extends AbstractC4237z {

    public final int f14316a = 0;

    public Object f14317b;

    public Object f14318c;

    public C4211h() {
    }

    @Override
    public void mo8251b() {
        switch (this.f14316a) {
            case 0:
                ((InterfaceC4221m) this.f14318c).setVisibility(4);
                break;
        }
    }

    @Override
    public void mo8252c() {
        switch (this.f14316a) {
            case 0:
                ((InterfaceC4221m) this.f14318c).setVisibility(0);
                break;
        }
    }

    @Override
    public final void mo8254e(Transition transition) {
        switch (this.f14316a) {
            case 0:
                transition.m3065u(this);
                int i6 = Build.VERSION.SDK_INT;
                View view = (View) this.f14317b;
                if (i6 == 28) {
                    if (!C3624n.f12180h) {
                        try {
                            C3624n.m7336f();
                            Method declaredMethod = C3624n.f12175c.getDeclaredMethod("removeGhost", View.class);
                            C3624n.f12179g = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e5) {
                            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e5);
                        }
                        C3624n.f12180h = true;
                    }
                    Method method = C3624n.f12179g;
                    if (method != null) {
                        try {
                            method.invoke(null, view);
                            break;
                        } catch (IllegalAccessException unused) {
                        } catch (InvocationTargetException e10) {
                            throw new RuntimeException(e10.getCause());
                        }
                    }
                    break;
                } else {
                    int i10 = C4225o.f14359g;
                    C4225o c4225o = (C4225o) view.getTag(R.id.ghost_view);
                    if (c4225o != null) {
                        int i11 = c4225o.f14363d - 1;
                        c4225o.f14363d = i11;
                        if (i11 <= 0) {
                            ((C4223n) c4225o.getParent()).removeView(c4225o);
                        }
                    }
                }
                view.setTag(R.id.transition_transform, null);
                view.setTag(R.id.parent_matrix, null);
                return;
            default:
                ((ArrayList) ((C3341e) this.f14317b).get(((ViewTreeObserverOnPreDrawListenerC4198a0) this.f14318c).f14266b)).remove(transition);
                transition.m3065u(this);
                return;
        }
    }

    public C4211h(ViewTreeObserverOnPreDrawListenerC4198a0 viewTreeObserverOnPreDrawListenerC4198a0, C3341e c3341e) {
        this.f14318c = viewTreeObserverOnPreDrawListenerC4198a0;
        this.f14317b = c3341e;
    }
}
