package p055ea;

import android.media.MediaPlayer;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2451l0 implements MediaPlayer.OnInfoListener {

    public final Spark f8634a;

    public C2451l0(Spark spark) {
        this.f8634a = spark;
    }

    @Override
    public final boolean onInfo(MediaPlayer mediaPlayer, int i6, int i10) {
        if (i6 != 3) {
            return false;
        }
        String strM165s = AbstractC0032a.m165s("rE+QlepJ\n", "7hzd9IMncAs=\n");
        String strM165s2 = AbstractC0032a.m165s("vmUTDPOR0kaKZQVF4KTQQ5ZyHgv14dBIhCBZS7zv\n", "8wB3ZZLBvic=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Spark spark = this.f8634a;
        spark.f11121i1 = jCurrentTimeMillis;
        spark.f11049G0 = true;
        spark.m6725p0();
        return false;
    }
}
