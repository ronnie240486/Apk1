package p129m1;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi26;
import p101j7.C2782c;

public final class C3029a extends C2782c {
    @Override
    public final AudioAttributesImpl mo5758q() {
        return new AudioAttributesImplApi26(((AudioAttributes.Builder) this.f9501b).build());
    }
}
