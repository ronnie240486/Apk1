package p055ea;

import android.media.MediaPlayer;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2447j0 implements MediaPlayer.OnCompletionListener {

    public final Spark f8628a;

    public C2447j0(Spark spark) {
        this.f8628a = spark;
    }

    @Override
    public final void onCompletion(MediaPlayer mediaPlayer) {
        Spark spark = this.f8628a;
        long currentPosition = spark.f11065L1.getCurrentPosition();
        if (Spark.f11017m2 == 0) {
            String strM165s = AbstractC0032a.m165s("IQwW/asC\n", "Y19bnMJsxVA=\n");
            String strM165s2 = AbstractC0032a.m165s("RdXFyuWF1PFEnM7BybzQ5F/Z1cblvZ26HZKP\n", "M7yhr4rTvZQ=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, strM165s2);
            Log.m5049i(AbstractC0032a.m165s("gbwInUwO\n", "w+9F/CVgXR0=\n"), AbstractC0032a.m165s("54HsHGCMOeDmyOcXTLU99f2N/BBgtHD1/pvhDWa1PmotZ+wMfbsk7P6Gslk=\n", "keiIeQ/aUIU=\n") + currentPosition + AbstractC0032a.m165s("k35x\n", "fML+R4tjVzo=\n") + spark.f11047F1);
            spark.f11121i1 = System.currentTimeMillis();
            if (spark.m6712c0()) {
                spark.f11121i1 = System.currentTimeMillis();
                return;
            }
            Constants$VIDEO_TYPE constants$VIDEO_TYPE = spark.f11044E1;
            if (constants$VIDEO_TYPE != Constants$VIDEO_TYPE.BSPALYBACK && constants$VIDEO_TYPE != Constants$VIDEO_TYPE.BSVOD && constants$VIDEO_TYPE != Constants$VIDEO_TYPE.STATIC) {
                if (currentPosition == 0 || spark.f11047F1 == currentPosition) {
                    return;
                }
                spark.f11121i1 = System.currentTimeMillis();
                spark.f11050G1 = currentPosition;
                Spark.f11015k2.pause();
                return;
            }
            Log.m5049i(AbstractC0032a.m165s("50o+tOcn\n", "pRlz1Y5JQUQ=\n"), AbstractC0032a.m165s("Osc4NP89PCQ7ji8l/xsFLS3XPjDzAHUXBeoZHs8/DBEJjg==\n", "TK5cUZBrVUE=\n") + spark.f11044E1);
            spark.m6729v0();
            spark.m6726q0();
            spark.f11065L1.mo7407c();
            if (Spark.m6658F(spark, spark.f11101Y)) {
                return;
            }
            spark.m6697M0(true);
        }
    }
}
