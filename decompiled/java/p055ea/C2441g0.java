package p055ea;

import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p193ra.RunnableC3661d;

public final class C2441g0 {

    public final HandlerC2468u f8571e;

    public final Spark f8578l;

    public final String f8567a = AbstractC0032a.m165s("BcF23pqfJZws4HbJnooLiw==\n", "Va0Xp//tbvk=\n");

    public boolean f8568b = false;

    public boolean f8569c = false;

    public long f8570d = 0;

    public final RunnableC3661d f8572f = new RunnableC3661d(this, 0);

    public long f8573g = 0;

    public int f8574h = 5;

    public final int f8575i = 4;

    public int f8576j = 0;

    public final RunnableC3661d f8577k = new RunnableC3661d(this, 1);

    public C2441g0(Spark spark, HandlerC2468u handlerC2468u) {
        this.f8578l = spark;
        this.f8571e = handlerC2468u;
    }

    public final boolean m5483a() {
        return this.f8568b || this.f8569c;
    }

    public final void m5484b(long j10) {
        if (j10 < 0) {
            return;
        }
        Spark spark = this.f8578l;
        long duration = spark.f11065L1.getDuration();
        if (duration <= 0) {
            return;
        }
        spark.f11158z1.setProgress((int) ((100 * j10) / duration));
        spark.f11035B1.setText(AbstractC3331m.m6767q((int) (j10 / 1000)));
        spark.f11035B1.setX(((spark.f11158z1.getX() + spark.f11158z1.getThumb().getBounds().centerX()) - (spark.f11035B1.getWidth() / 2.0f)) + 100.0f);
        if (spark.f11035B1.getWidth() < 84) {
            spark.f11035B1.setVisibility(4);
        } else {
            spark.f11035B1.setVisibility(0);
        }
    }
}
