package p055ea;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.media3.exoplayer.Renderer;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.Spark;
import sa.DialogC3734e;
import sa.ViewOnKeyListenerC3733d;

public final class CountDownTimerC2464s extends CountDownTimer {

    public final String f8655a;

    public final ViewOnKeyListenerC3733d f8656b;

    public final DialogC3734e f8657c;

    public CountDownTimerC2464s(String str, ViewOnKeyListenerC3733d viewOnKeyListenerC3733d, DialogC3734e dialogC3734e) {
        super(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, 1000L);
        this.f8655a = str;
        this.f8656b = viewOnKeyListenerC3733d;
        this.f8657c = dialogC3734e;
    }

    @Override
    public final void onFinish() {
        Spark.f11002X1.sendEmptyMessage(9999);
        this.f8657c.dismiss();
    }

    @Override
    public final void onTick(long j10) {
        String str = this.f8655a + "\n" + (j10 / 1000);
        ViewOnKeyListenerC3733d viewOnKeyListenerC3733d = this.f8656b;
        viewOnKeyListenerC3733d.getClass();
        TextView textView = (TextView) viewOnKeyListenerC3733d.f12508e.findViewById(R.id.message);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
