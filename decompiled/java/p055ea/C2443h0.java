package p055ea;

import android.media.MediaPlayer;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2443h0 implements MediaPlayer.OnBufferingUpdateListener {

    public final C2445i0 f8621a;

    public C2443h0(C2445i0 c2445i0) {
        this.f8621a = c2445i0;
    }

    @Override
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i6) {
        String strM165s = AbstractC0032a.m165s("hrMM3rPC\n", "xOBBv9qs9+k=\n");
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("eJgDc35IVzJ50Qh4U2tYMWuDDnh2S04zb4UCNmd3WjJhpR5mdCQe\n", "DvFnFhEePlc=\n"));
        C2445i0 c2445i0 = this.f8621a;
        sb.append(c2445i0.f8624a.f11044E1);
        sb.append(AbstractC0032a.m165s("4StogPfxUD+kKi+D9+pCI7M8dY398C5/\n", "wV0B5JKeBlY=\n"));
        sb.append(Spark.f11015k2.getDuration());
        String string = sb.toString();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, string);
        Spark spark = c2445i0.f8624a;
        Constants$VIDEO_TYPE constants$VIDEO_TYPE = spark.f11044E1;
        if (constants$VIDEO_TYPE == Constants$VIDEO_TYPE.BSPALYBACK || constants$VIDEO_TYPE == Constants$VIDEO_TYPE.BSVOD || constants$VIDEO_TYPE == Constants$VIDEO_TYPE.STATIC) {
            spark.f11050G1 = Spark.f11015k2.getCurrentPosition();
            spark.f11047F1 = Spark.f11015k2.getDuration();
            Log.m5049i(AbstractC0032a.m165s("E8ug6rVY\n", "UZjti9w2nrY=\n"), AbstractC0032a.m165s("IG8ywx+yBNwhJjXTApYI1yJWOdUZkATWOCY=\n", "VgZWpnDkbbk=\n") + spark.f11050G1 + AbstractC0032a.m165s("/VNkM+2GsQ+zFw==\n", "3TcRQYzy2GA=\n") + spark.f11047F1 + AbstractC0032a.m165s("6U9FbTAbDfKsX1NuOApf\n", "yS0wC1Z+f6I=\n") + i6);
            int i10 = spark.f11047F1;
            if (i10 > 0) {
                long j10 = spark.f11050G1;
                long j11 = (100 * j10) / ((long) i10);
                spark.f11152x1.setText(AbstractC3331m.m6767q(j10 / 1000));
                spark.f11155y1.setText(AbstractC3331m.m6767q(spark.f11047F1 / 1000));
                if (!spark.f11053H1.m5483a()) {
                    int i11 = (int) j11;
                    spark.f11158z1.setProgress(i11);
                    spark.f11032A1.setProgress(i11);
                }
                spark.f11158z1.setSecondaryProgress(i6);
                spark.f11032A1.setSecondaryProgress(i6);
                Log.m5049i(AbstractC0032a.m165s("nVULHF02\n", "3wZGfTRYULw=\n"), AbstractC0032a.m165s("SGoS+EoKtWU=\n", "Kh90ni94j0U=\n") + i6);
                String strM6672i0 = Spark.m6672i0(spark.f11101Y);
                if (((long) spark.f11047F1) - spark.f11050G1 >= 20000 || strM6672i0 == null) {
                    return;
                }
                spark.f11123j1.setText(String.format(AbstractC0032a.m165s("050aQ6wM\n", "9u4gY4l/FB0=\n"), spark.getString(R.string.video_playback_auto_start_next), strM6672i0));
                spark.m6691G0(2000);
            }
        }
    }
}
