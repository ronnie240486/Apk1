package androidx.mediarouter.app;

import android.widget.SeekBar;
import p173q1.C3445s0;

public final class C1107p0 implements SeekBar.OnSeekBarChangeListener {

    public final DialogC1109q0 f3301a;

    public C1107p0(DialogC1109q0 dialogC1109q0) {
        this.f3301a = dialogC1109q0;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i6, boolean z7) {
        if (z7) {
            C3445s0 c3445s0 = (C3445s0) seekBar.getTag();
            AbstractC1091h0 abstractC1091h0 = (AbstractC1091h0) this.f3301a.f3342u.get(c3445s0.f11654c);
            if (abstractC1091h0 != null) {
                abstractC1091h0.m2749c(i6 == 0);
            }
            c3445s0.m7027j(i6);
        }
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
        DialogC1109q0 dialogC1109q0 = this.f3301a;
        if (dialogC1109q0.f3343v != null) {
            dialogC1109q0.f3338q.removeMessages(2);
        }
        dialogC1109q0.f3343v = (C3445s0) seekBar.getTag();
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.f3301a.f3338q.sendEmptyMessageDelayed(2, 500L);
    }
}
