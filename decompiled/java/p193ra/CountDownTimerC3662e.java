package p193ra;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.media3.exoplayer.Renderer;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import sa.C3736g;

public final class CountDownTimerC3662e extends CountDownTimer {

    public final TextView f12262a;

    public final Spark f12263b;

    public final C3736g f12264c;

    public final C3663f f12265d;

    public CountDownTimerC3662e(C3663f c3663f, TextView textView, Spark spark, C3736g c3736g) {
        super(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, 1000L);
        this.f12265d = c3663f;
        this.f12262a = textView;
        this.f12263b = spark;
        this.f12264c = c3736g;
    }

    @Override
    public final void onFinish() {
        C3736g c3736g = this.f12264c;
        if (c3736g != null) {
            c3736g.dismiss();
        }
        String strM165s = AbstractC0032a.m165s("9p7eoRtwXKjIldqq\n", "pvK/2H4CEck=\n");
        String strM165s2 = AbstractC0032a.m165s("bzVQQsSI6zA6ezZ7xoDhPXIWd0XLhv0qLjxzX+OP6yxhNXVOgsi2KmUrekrTsvctcjhzA4Pa\n", "AFsWK6rhmFg=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        C3663f c3663fM7415b = C3663f.m7415b();
        String str = this.f12265d.f12279l;
        ChannelBean channelBean = c3663fM7415b.f12272e;
        if (channelBean != null) {
            c3663fM7415b.m7420f(channelBean, Boolean.valueOf(c3663fM7415b.f12274g), 0, str);
        }
    }

    @Override
    public final void onTick(long j10) {
        TextView textView = this.f12262a;
        if (textView != null) {
            textView.setText(this.f12263b.getString(R.string.connecting) + (j10 / 1000));
        }
    }
}
