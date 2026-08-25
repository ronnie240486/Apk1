package p055ea;

import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class RunnableC2470v implements Runnable {

    public final int f8665a;

    public final Spark f8666b;

    public RunnableC2470v(Spark spark, int i6) {
        this.f8665a = i6;
        this.f8666b = spark;
    }

    @Override
    public final void run() {
        int i6;
        Spark spark = this.f8666b;
        switch (this.f8665a) {
            case 0:
                spark.f11106b0.setVisibility(8);
                String strM165s = AbstractC0032a.m165s("17M4ZCHH\n", "leB1BUip/8c=\n");
                String strM165s2 = AbstractC0032a.m165s("NPkP2ydkTBQQ+RjKKWoAUQ==\n", "XJBrvmsNOnE=\n");
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, strM165s2);
                break;
            case 1:
                spark.f11153y.setTranslationX(0.0f);
                break;
            default:
                HandlerC2468u handlerC2468u = Spark.f11002X1;
                if (!spark.m6712c0()) {
                    spark.f11050G1 = spark.f11065L1.getCurrentPosition();
                    spark.f11047F1 = (int) spark.f11065L1.getDuration();
                    int bufferedPercentage = spark.f11065L1.getBufferedPercentage();
                    int i10 = spark.f11047F1;
                    if (i10 > 0) {
                        long j10 = i10;
                        long j11 = spark.f11050G1;
                        if (j10 > j11) {
                            long j12 = (j11 * 100) / j10;
                            spark.f11155y1.setText(AbstractC3331m.m6767q(i10 / 1000));
                            if (!spark.f11053H1.m5483a()) {
                                spark.f11152x1.setText(AbstractC3331m.m6767q(spark.f11050G1 / 1000));
                                int i11 = (int) j12;
                                spark.f11158z1.setProgress(i11);
                                spark.f11032A1.setProgress(i11);
                            }
                            spark.f11158z1.setSecondaryProgress(bufferedPercentage);
                            String strM6672i0 = Spark.m6672i0(spark.f11101Y);
                            int i12 = spark.f11047F1;
                            if (i12 > 20000) {
                                long j13 = spark.f11050G1;
                                if (j13 > 20000 && ((long) i12) - j13 < 20000 && strM6672i0 != null) {
                                    spark.f11123j1.setText(String.format(AbstractC0032a.m165s("grWpSJF4\n", "p8aTaLQLRzo=\n"), spark.getString(R.string.video_playback_auto_start_next), strM6672i0));
                                    if (!spark.f11129m1.isShown()) {
                                        spark.m6691G0(95);
                                    }
                                }
                            }
                        }
                    }
                }
                C2459p0 c2459p0 = spark.f11077P1;
                if (c2459p0 != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j14 = jCurrentTimeMillis - c2459p0.f8651c;
                    if (j14 < 1000) {
                        i6 = -1;
                    } else {
                        long j15 = c2459p0.f8649a;
                        long j16 = j15 - c2459p0.f8650b;
                        c2459p0.f8650b = j15;
                        c2459p0.f8651c = jCurrentTimeMillis;
                        i6 = (int) ((j16 * 1000) / j14);
                    }
                    if (i6 >= 0 && spark.f11044E1 == Constants$VIDEO_TYPE.STATIC) {
                        spark.m6728u0(AbstractC3331m.m6752b(i6));
                    }
                }
                Spark.f11002X1.postDelayed(this, 1000L);
                break;
        }
    }
}
