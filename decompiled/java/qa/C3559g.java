package qa;

import androidx.mediarouter.app.ViewOnClickListenerC1078b;
import org.bitspark.android.Spark;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p243w8.C4067i;

public final class C3559g {

    public final Spark f11971a;

    public final C4067i f11972b;

    public final C3554b f11973c;

    public C3559g(Spark spark) {
        AbstractC2796i.m5785f(spark, AbstractC0032a.m165s("caZks40=\n", "AtYFweZOa2s=\n"));
        this.f11971a = spark;
        this.f11972b = new C4067i(new C3553a(0, this));
        this.f11973c = new C3554b(0, this);
        spark.f11040D0.setOnClickListener(new ViewOnClickListenerC1078b(1, this));
    }

    public final C3567o m7173a() {
        return (C3567o) this.f11972b.getValue();
    }
}
