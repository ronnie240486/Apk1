package p055ea;

import android.widget.SeekBar;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;

public final class C2429a0 implements SeekBar.OnSeekBarChangeListener {

    public final Spark f8511a;

    public C2429a0(Spark spark) {
        this.f8511a = spark;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i6, boolean z7) {
        Spark spark = this.f8511a;
        if (spark.f11046F0) {
            spark.f11152x1.setText(AbstractC3331m.m6767q(((int) ((spark.f11065L1.getDuration() * ((long) seekBar.getProgress())) / 100)) / 1000));
        }
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
        Spark spark = this.f8511a;
        spark.f11065L1.pause();
        spark.m6729v0();
        int duration = (int) ((spark.f11065L1.getDuration() * ((long) seekBar.getProgress())) / 100);
        spark.f11046F0 = true;
        spark.f11152x1.setText(AbstractC3331m.m6767q(duration / 1000));
        Spark.f11002X1.removeMessages(96);
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
        long progress = seekBar.getProgress();
        Spark spark = this.f8511a;
        int duration = (int) ((spark.f11065L1.getDuration() * progress) / 100);
        spark.f11065L1.seekTo(duration);
        if (Spark.f11017m2 == 1) {
            spark.f11065L1.mo7408d();
        } else {
            spark.f11065L1.start();
        }
        spark.f11046F0 = false;
        spark.m6725p0();
        Spark.f11014j2 = false;
        spark.f11081R.setSelected(false);
        spark.f11152x1.setText(AbstractC3331m.m6767q(duration / 1000));
    }
}
