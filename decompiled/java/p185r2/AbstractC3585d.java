package p185r2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.C0423q;
import com.bumptech.glide.AbstractC1465c;
import p000a.AbstractC0004e;
import p130m2.C3055c;
import p130m2.C3061i;
import p140n2.C3178c;
import p140n2.C3181f;
import p140n2.InterfaceC3184i;
import p150o2.C3246a;

public abstract class AbstractC3585d {

    public static final C3055c f12063a = new C3055c();

    public static final boolean m7206a(C3061i c3061i) {
        int iOrdinal = c3061i.f10472e.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new C0423q(13);
            }
            InterfaceC3184i interfaceC3184i = c3061i.f10489v;
            if (!(interfaceC3184i instanceof C3178c)) {
                C3246a c3246a = c3061i.f10470c;
                if (!(c3246a instanceof C3246a) || !(interfaceC3184i instanceof C3181f)) {
                    return false;
                }
                ImageView imageView = c3246a.f10870b;
                if (!(imageView instanceof ImageView) || imageView != ((C3181f) interfaceC3184i).f10672a) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final Drawable m7207b(C3061i c3061i, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        Context context = c3061i.f10468a;
        int iIntValue = num.intValue();
        Drawable drawableM3473h = AbstractC1465c.m3473h(context, iIntValue);
        if (drawableM3473h != null) {
            return drawableM3473h;
        }
        throw new IllegalStateException(AbstractC0004e.m20n(iIntValue, "Invalid resource ID: ").toString());
    }
}
