package androidx.media;

import android.media.AudioAttributes;
import p003a2.AbstractC0033b;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0033b abstractC0033b) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f2565a = (AudioAttributes) abstractC0033b.m185g(audioAttributesImplApi21.f2565a, 1);
        audioAttributesImplApi21.f2566b = abstractC0033b.m184f(audioAttributesImplApi21.f2566b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0033b abstractC0033b) {
        abstractC0033b.getClass();
        abstractC0033b.m189k(audioAttributesImplApi21.f2565a, 1);
        abstractC0033b.m188j(audioAttributesImplApi21.f2566b, 2);
    }
}
