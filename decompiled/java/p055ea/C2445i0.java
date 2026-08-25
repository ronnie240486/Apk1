package p055ea;

import android.media.MediaPlayer;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2445i0 implements MediaPlayer.OnPreparedListener {

    public final Spark f8624a;

    public C2445i0(Spark spark) {
        this.f8624a = spark;
    }

    @Override
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (Spark.f11017m2 == 0) {
            String strM165s = AbstractC0032a.m165s("bfwd9cc7\n", "L69QlK5VY7U=\n");
            StringBuilder sb = new StringBuilder();
            sb.append(AbstractC0032a.m165s("XLfMRTmZMhJd/sdOBr0+B0uszUR2uTITT7H8WSaqYVc=\n", "Kt6oIFbPW3c=\n"));
            Spark spark = this.f8624a;
            sb.append(spark.f11044E1);
            sb.append(AbstractC0032a.m165s("+omYfBrUxUu/iN9/Gs/XV6iehXEQ1bsL\n", "2v/xGH+7kyI=\n"));
            sb.append(Spark.f11015k2.getDuration());
            String string = sb.toString();
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, string);
            mediaPlayer.start();
            mediaPlayer.setOnBufferingUpdateListener(new C2443h0(this));
            spark.m6691G0(5000);
            spark.f11149w1.setVisibility(8);
            Log.m5049i(AbstractC0032a.m165s("YBhseOWj\n", "IkshGYzNpu8=\n"), AbstractC0032a.m165s("qNAtbxMsn7ai2kdrHzibq5HXGGpWL5uwiNAtbxMsn7ai2jF0BSibqqLMXW0EM5m2os0OPREzkKE=\n", "x759HXZc/sQ=\n"));
        }
    }
}
