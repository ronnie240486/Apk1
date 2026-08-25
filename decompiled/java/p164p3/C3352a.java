package p164p3;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import p151o3.C3247a;

public final class C3352a implements InterfaceC3354c, InterfaceC3355d {
    @Override
    public boolean mo6824a(Object obj, C3247a c3247a) {
        Drawable drawable = (Drawable) obj;
        ImageView imageView = c3247a.f10871a;
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 == null) {
            drawable2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        transitionDrawable.setCrossFadeEnabled(false);
        transitionDrawable.startTransition(300);
        imageView.setImageDrawable(transitionDrawable);
        return true;
    }

    @Override
    public InterfaceC3354c mo5754g(int i6) {
        return C3353b.f11344a;
    }
}
