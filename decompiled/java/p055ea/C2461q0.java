package p055ea;

import android.widget.RadioButton;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p003a2.AbstractC0032a;
import p015b2.InterfaceC1258j;
import p156o9.AbstractC3280d;

public final class C2461q0 implements InterfaceC1258j {

    public final Spark f8652a;

    public C2461q0(Spark spark) {
        this.f8652a = spark;
    }

    @Override
    public final void onPageSelected(int i6) {
        String strM165s = AbstractC0032a.m165s("D0oPjrJe\n", "TRlC79swQDU=\n");
        String str = AbstractC0032a.m165s("IyTYo/LtW8QgL+u28OwygQ==\n", "TEqIwpWICKE=\n") + AbstractC2440g.f8566o.get(Integer.valueOf(i6));
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        EnumC2432c enumC2432c = (EnumC2432c) AbstractC2440g.f8566o.get(Integer.valueOf(i6));
        Spark spark = this.f8652a;
        spark.getClass();
        if (C3333o.f11249f.f11254e) {
            spark.f11120i0.m7736f();
        }
        switch (enumC2432c.ordinal()) {
            case 0:
                spark.f11033B.requestFocus();
                spark.f11156z.check(R.id.rb_menu);
                spark.f11072O.m3132d();
                spark.f11061K0 = true;
                break;
            case 1:
                spark.f11036C.requestFocus();
                spark.f11156z.check(R.id.rb_vod);
                spark.f11072O.m3132d();
                spark.f11061K0 = false;
                break;
            case 2:
                spark.f11039D.requestFocus();
                spark.f11156z.check(R.id.rb_history);
                spark.f11072O.m3132d();
                spark.f11061K0 = false;
                break;
            case 3:
                RadioButton radioButton = spark.f11042E;
                if (radioButton != null && radioButton.isShown()) {
                    AbstractC3280d.m6606y(spark.f11042E);
                }
                spark.f11156z.check(R.id.rb_user);
                spark.f11072O.m3132d();
                spark.f11061K0 = false;
                break;
            case 4:
                spark.f11045F.requestFocus();
                spark.f11156z.check(R.id.rb_apps);
                spark.f11072O.m3132d();
                spark.f11061K0 = false;
                break;
            case 5:
                spark.f11048G.requestFocus();
                spark.f11156z.check(R.id.rb_setting);
                spark.f11072O.m3132d();
                spark.f11061K0 = false;
                break;
            case 6:
                AbstractC3280d.m6606y(spark.f11051H);
                spark.f11156z.check(R.id.rb_home);
                spark.f11072O.m3132d();
                spark.f11061K0 = false;
                break;
        }
    }

    @Override
    public final void onPageScrollStateChanged(int i6) {
    }

    @Override
    public final void mo3134a(int i6, float f) {
    }
}
