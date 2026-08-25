package p055ea;

import android.media.MediaPlayer;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2449k0 implements MediaPlayer.OnErrorListener {

    public final Spark f8631a;

    public C2449k0(Spark spark) {
        this.f8631a = spark;
    }

    @Override
    public final boolean onError(MediaPlayer mediaPlayer, int i6, int i10) {
        String strM165s = AbstractC0032a.m165s("ZMYItxjB\n", "JpVF1nGvW14=\n");
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("b6xwZSyrMlpu5XFyMZIpBQ==\n", "GcUUAEP9Wz8=\n"));
        sb.append(i6);
        sb.append(AbstractC0032a.m165s("NadIL3cuAqc=\n", "FcIwWwVPOIc=\n"));
        sb.append(i10);
        sb.append(AbstractC0032a.m165s("KpjLpt2Munww1Q==\n", "CvWJ07vq3w4=\n"));
        Spark spark = this.f8631a;
        sb.append(spark.f11113e1);
        String string = sb.toString();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, string);
        Spark.f11015k2.stopPlayback();
        Spark.f11015k2.setVideoURI(null);
        spark.f11121i1 = System.currentTimeMillis();
        return true;
    }
}
