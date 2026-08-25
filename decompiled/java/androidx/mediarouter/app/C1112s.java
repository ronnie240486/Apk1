package androidx.mediarouter.app;

import android.widget.SeekBar;
import p173q1.C3445s0;

public final class C1112s implements SeekBar.OnSeekBarChangeListener {

    public final RunnableC1092i f3361a = new RunnableC1092i(1, this);

    public final DialogC1116u f3362b;

    public C1112s(DialogC1116u dialogC1116u) {
        this.f3362b = dialogC1116u;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i6, boolean z7) {
        if (z7) {
            C3445s0 c3445s0 = (C3445s0) seekBar.getTag();
            int i10 = DialogC1116u.f3365p0;
            c3445s0.m7027j(i6);
        }
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
        DialogC1116u dialogC1116u = this.f3362b;
        if (dialogC1116u.f3377L != null) {
            dialogC1116u.f3375J.removeCallbacks(this.f3361a);
        }
        dialogC1116u.f3377L = (C3445s0) seekBar.getTag();
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.f3362b.f3375J.postDelayed(this.f3361a, 500L);
    }
}
