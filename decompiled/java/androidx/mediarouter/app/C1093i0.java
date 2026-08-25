package androidx.mediarouter.app;

import android.view.KeyEvent;
import android.widget.SeekBar;
import java.util.Collections;
import p173q1.AbstractC3427m0;
import p173q1.C3436p0;
import p173q1.C3442r0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p173q1.C3457x0;

public final class C1093i0 extends AbstractC3427m0 {

    public final int f3252a;

    public final KeyEvent.Callback f3253b;

    public C1093i0(KeyEvent.Callback callback, int i6) {
        this.f3252a = i6;
        this.f3253b = callback;
    }

    @Override
    public void mo2750a() {
        switch (this.f3252a) {
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
        }
    }

    @Override
    public void mo2751b() {
        switch (this.f3252a) {
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
        }
    }

    @Override
    public void mo2752c() {
        switch (this.f3252a) {
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
        }
    }

    @Override
    public void mo2753d(C3451u0 c3451u0, C3445s0 c3445s0) {
        switch (this.f3252a) {
            case 0:
                ((DialogC1109q0) this.f3253b).m2779p();
                break;
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
            case 2:
                ((DialogC1086f) this.f3253b).m2744j();
                break;
            case 4:
                ((DialogC1081c0) this.f3253b).m2740i();
                break;
        }
    }

    @Override
    public final void mo2754e(C3451u0 c3451u0, C3445s0 c3445s0) {
        C3436p0 c3436p0M7019a;
        switch (this.f3252a) {
            case 0:
                DialogC1109q0 dialogC1109q0 = (DialogC1109q0) this.f3253b;
                if (c3445s0 == dialogC1109q0.f3329h && C3445s0.m7018b() != null) {
                    C3442r0 c3442r0 = c3445s0.f11652a;
                    c3442r0.getClass();
                    C3451u0.m7067b();
                    for (C3445s0 c3445s1 : Collections.unmodifiableList(c3442r0.f11644b)) {
                        if (!Collections.unmodifiableList(dialogC1109q0.f3329h.f11673v).contains(c3445s1) && (c3436p0M7019a = dialogC1109q0.f3329h.m7019a()) != null && c3436p0M7019a.m7014o(c3445s1) && !dialogC1109q0.f3331j.contains(c3445s1)) {
                            dialogC1109q0.m2780q();
                            dialogC1109q0.m2778o();
                            break;
                        }
                    }
                }
                dialogC1109q0.m2779p();
                break;
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
            case 2:
                ((DialogC1086f) this.f3253b).m2744j();
                break;
            case 3:
                ((DialogC1116u) this.f3253b).m2799s(true);
                break;
            default:
                ((DialogC1081c0) this.f3253b).m2740i();
                break;
        }
    }

    @Override
    public void mo2755h(C3451u0 c3451u0, C3445s0 c3445s0) {
        switch (this.f3252a) {
            case 0:
                ((DialogC1109q0) this.f3253b).m2779p();
                break;
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
            case 2:
                ((DialogC1086f) this.f3253b).m2744j();
                break;
            case 4:
                ((DialogC1081c0) this.f3253b).m2740i();
                break;
        }
    }

    @Override
    public void mo2756i(C3445s0 c3445s0) {
        switch (this.f3252a) {
            case 0:
                DialogC1109q0 dialogC1109q0 = (DialogC1109q0) this.f3253b;
                dialogC1109q0.f3329h = c3445s0;
                dialogC1109q0.m2780q();
                dialogC1109q0.m2778o();
                break;
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
            case 2:
                ((DialogC1086f) this.f3253b).dismiss();
                break;
            case 4:
                ((DialogC1081c0) this.f3253b).dismiss();
                break;
        }
    }

    @Override
    public void mo2757k() {
        switch (this.f3252a) {
            case 0:
                ((DialogC1109q0) this.f3253b).m2779p();
                break;
            case 1:
                ((MediaRouteButton) this.f3253b).m2733b();
                break;
            case 3:
                ((DialogC1116u) this.f3253b).m2799s(false);
                break;
        }
    }

    @Override
    public void mo2758m(C3445s0 c3445s0) {
        AbstractC1091h0 abstractC1091h0;
        KeyEvent.Callback callback = this.f3253b;
        switch (this.f3252a) {
            case 0:
                int i6 = DialogC1109q0.f3307S;
                DialogC1109q0 dialogC1109q0 = (DialogC1109q0) callback;
                if (dialogC1109q0.f3343v != c3445s0 && (abstractC1091h0 = (AbstractC1091h0) dialogC1109q0.f3342u.get(c3445s0.f11654c)) != null) {
                    int i10 = abstractC1091h0.f3246a.f11667p;
                    abstractC1091h0.m2749c(i10 == 0);
                    abstractC1091h0.f3248c.setProgress(i10);
                    break;
                }
                break;
            case 3:
                DialogC1116u dialogC1116u = (DialogC1116u) callback;
                SeekBar seekBar = (SeekBar) dialogC1116u.f3382Q.get(c3445s0);
                int i11 = c3445s0.f11667p;
                int i12 = DialogC1116u.f3365p0;
                if (seekBar != null && dialogC1116u.f3377L != c3445s0) {
                    seekBar.setProgress(i11);
                    break;
                }
                break;
        }
    }

    @Override
    public void mo2759n(C3457x0 c3457x0) {
        switch (this.f3252a) {
            case 1:
                boolean z7 = c3457x0 != null ? c3457x0.f11712e.getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON") : false;
                MediaRouteButton mediaRouteButton = (MediaRouteButton) this.f3253b;
                if (mediaRouteButton.f3153f != z7) {
                    mediaRouteButton.f3153f = z7;
                    mediaRouteButton.refreshDrawableState();
                }
                break;
        }
    }
}
