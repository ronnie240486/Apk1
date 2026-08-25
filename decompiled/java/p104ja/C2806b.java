package p104ja;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.R$drawable;
import p003a2.AbstractC0032a;
import p025c2.C1380a;
import p025c2.C1391l;
import p103j9.AbstractC2796i;
import p130m2.C3060h;
import p130m2.EnumC3054b;
import p140n2.EnumC3182g;
import p150o2.C3246a;
import p156o9.AbstractC3280d;
import p163p2.C3351a;
import p174q2.C3462a;
import p237w0.AbstractC4044e;
import p253x8.AbstractC4146i;

public final class C2806b extends AbstractC2805a {

    public static final SparseIntArray f9544o;

    public long f9545n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9544o = sparseIntArray;
        sparseIntArray.put(R.id.image_border, 2);
    }

    public C2806b(View view) {
        Object[] objArrM8047R = AbstractC4044e.m8047R(view, 3, f9544o);
        super(view, (ConstraintLayout) objArrM8047R[0], (ImageView) objArrM8047R[1]);
        this.f9545n = -1L;
        this.f9542l.setTag(null);
        this.f9543m.setTag(null);
        m8049T(view);
        synchronized (this) {
            this.f9545n = 2L;
        }
        m8048S();
    }

    @Override
    public final void mo5800O() {
        long j10;
        synchronized (this) {
            j10 = this.f9545n;
            this.f9545n = 0L;
        }
        if ((j10 & 3) != 0) {
            ImageView imageView = this.f9543m;
            Drawable drawableM3473h = AbstractC1465c.m3473h(imageView.getContext(), R$drawable.home_nor_2x);
            Drawable drawableM3473h2 = AbstractC1465c.m3473h(this.f9543m.getContext(), R$drawable.home_movie_not_uploaded_2x);
            float dimension = this.f9543m.getResources().getDimension(R.dimen.dimen4);
            AbstractC0032a.m165s("rLOdDRp1B/Cy\n", "xd78an8jbpU=\n");
            AbstractC2796i.m5785f(drawableM3473h2, AbstractC0032a.m165s("zIWeW1M=\n", "qffsNCFSYcM=\n"));
            C1391l c1391lM3249a = C1380a.m3249a(imageView.getContext());
            C3060h c3060h = new C3060h(imageView.getContext());
            c3060h.f10445c = "";
            c3060h.f10446d = new C3246a(imageView);
            c3060h.f10461s = null;
            c3060h.f10462t = null;
            c3060h.f10463u = null;
            c3060h.f10448f = new C3462a(100);
            if (drawableM3473h == null) {
                drawableM3473h = drawableM3473h2;
            }
            c3060h.f10457o = drawableM3473h;
            c3060h.f10456n = 0;
            c3060h.f10459q = drawableM3473h2;
            c3060h.f10458p = 0;
            c3060h.f10460r = EnumC3182g.f10674a;
            c3060h.f10447e = AbstractC3280d.m6571J(AbstractC4146i.m8179L(new C3351a[]{new C3351a(dimension)}));
            EnumC3054b enumC3054b = EnumC3054b.ENABLED;
            c3060h.f10453k = enumC3054b;
            c3060h.f10454l = enumC3054b;
            c1391lM3249a.m3266b(c3060h.m6109a());
        }
    }

    @Override
    public final boolean mo5801P() {
        synchronized (this) {
            try {
                return this.f9545n != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
