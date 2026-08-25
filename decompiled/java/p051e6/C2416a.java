package p051e6;

import android.widget.CompoundButton;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.C1810a;
import com.google.android.material.internal.InterfaceC1820f;
import la.ViewOnClickListenerC3017d;
import p001a0.C0019b;

public final class C2416a implements CompoundButton.OnCheckedChangeListener {

    public final int f8423a;

    public final Object f8424b;

    public C2416a(int i6, Object obj) {
        this.f8423a = i6;
        this.f8424b = obj;
    }

    @Override
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
        switch (this.f8423a) {
            case 0:
                Chip chip = (Chip) this.f8424b;
                InterfaceC1820f interfaceC1820f = chip.f6089j;
                if (interfaceC1820f != null) {
                    C0019b c0019b = (C0019b) interfaceC1820f;
                    c0019b.getClass();
                    C1810a c1810a = (C1810a) c0019b.f38b;
                    if (!z7 ? c1810a.m4240e(chip, c1810a.f6354e) : c1810a.m4236a(chip)) {
                        c1810a.m4239d();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.f6088i;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z7);
                }
                break;
            default:
                ViewOnClickListenerC3017d viewOnClickListenerC3017d = (ViewOnClickListenerC3017d) this.f8424b;
                if (!z7) {
                    viewOnClickListenerC3017d.f10316Z.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                } else {
                    viewOnClickListenerC3017d.f10316Z.setInputType(145);
                }
                break;
        }
    }
}
