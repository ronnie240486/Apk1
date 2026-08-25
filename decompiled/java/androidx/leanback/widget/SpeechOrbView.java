package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.p2serv.android.p032ds.R;

public class SpeechOrbView extends SearchOrbView {

    public final float f2282t;

    public C0507y0 f2283u;

    public C0507y0 f2284v;

    public int f2285w;

    public boolean f2286x;

    public SpeechOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m1402c() {
        setOrbColors(this.f2284v);
        setOrbIcon(getResources().getDrawable(R.drawable.lb_ic_search_mic_out));
        m1399a(hasFocus());
        View view = this.f2251c;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.f2286x = false;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.lb_speech_orb;
    }

    public void setListeningOrbColors(C0507y0 c0507y0) {
        this.f2283u = c0507y0;
    }

    public void setNotListeningOrbColors(C0507y0 c0507y0) {
        this.f2284v = c0507y0;
    }

    public void setSoundLevel(int i6) {
        if (this.f2286x) {
            int i10 = this.f2285w;
            if (i6 > i10) {
                this.f2285w = ((i6 - i10) / 2) + i10;
            } else {
                this.f2285w = (int) (i10 * 0.7f);
            }
            float focusedZoom = (((this.f2282t - getFocusedZoom()) * this.f2285w) / 100.0f) + 1.0f;
            View view = this.f2251c;
            view.setScaleX(focusedZoom);
            view.setScaleY(focusedZoom);
        }
    }

    public SpeechOrbView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2285w = 0;
        this.f2286x = false;
        Resources resources = context.getResources();
        this.f2282t = resources.getFraction(R.fraction.lb_search_bar_speech_orb_max_level_zoom, 1, 1);
        this.f2284v = new C0507y0(resources.getColor(R.color.lb_speech_orb_not_recording), resources.getColor(R.color.lb_speech_orb_not_recording_pulsed), resources.getColor(R.color.lb_speech_orb_not_recording_icon));
        this.f2283u = new C0507y0(resources.getColor(R.color.lb_speech_orb_recording), resources.getColor(R.color.lb_speech_orb_recording), 0);
        m1402c();
    }
}
