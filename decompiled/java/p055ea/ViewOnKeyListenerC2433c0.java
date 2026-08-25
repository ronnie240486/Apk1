package p055ea;

import android.view.KeyEvent;
import android.view.View;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.VodMenu;
import p156o9.AbstractC3280d;
import p214ta.C3877a;

public final class ViewOnKeyListenerC2433c0 implements View.OnKeyListener {

    public final int f8527a;

    public final Spark f8528b;

    public ViewOnKeyListenerC2433c0(Spark spark, int i6) {
        this.f8527a = i6;
        this.f8528b = spark;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        String name;
        switch (this.f8527a) {
            case 0:
                int iM7734d = 0;
                Spark spark = this.f8528b;
                if (19 == i6) {
                    if (keyEvent.getAction() == 0) {
                        C3877a c3877a = spark.f11120i0;
                        if (c3877a.f13011x < c3877a.f12987D.size() && (name = ((VodMenu) c3877a.f12988E.get(c3877a.f13011x)).getName()) != null) {
                            if (name.equals(EnumC2436e.f8539c.name())) {
                                iM7734d = c3877a.f13008u;
                            } else if (name.equals(EnumC2436e.f8538b.name())) {
                                iM7734d = c3877a.m7734d(0);
                            } else if (name.equals(EnumC2436e.f8541e.name())) {
                                iM7734d = c3877a.f13010w;
                            }
                        }
                        AbstractC3280d.m6607z(spark.f11031A0, iM7734d);
                    }
                } else if (!spark.m6702R0(i6, keyEvent) && (i6 != 20 || !view.isShown())) {
                    return false;
                }
                return true;
            case 1:
                Spark spark2 = this.f8528b;
                if (i6 == 20) {
                    if (keyEvent.getAction() != 0) {
                        return true;
                    }
                    AbstractC3280d.m6607z(spark2.f11157z0, spark2.f11144u0.f8752e);
                    return true;
                }
                if (i6 != 19) {
                    return spark2.m6702R0(i6, keyEvent);
                }
                if (!spark2.f11034B0.isShown() || keyEvent.getAction() != 0) {
                    return true;
                }
                AbstractC3280d.m6607z(spark2.f11034B0, spark2.f11120i0.f13006s);
                return true;
            case 2:
                Spark spark3 = this.f8528b;
                if (i6 != 20) {
                    return spark3.m6702R0(i6, keyEvent);
                }
                if (keyEvent.getAction() != 0) {
                    return true;
                }
                AbstractC3280d.m6607z(spark3.f11031A0, spark3.f11120i0.m7734d(0));
                return true;
            case 3:
                return this.f8528b.m6702R0(i6, keyEvent);
            case 4:
                return this.f8528b.m6702R0(i6, keyEvent);
            default:
                return this.f8528b.m6702R0(i6, keyEvent);
        }
    }
}
