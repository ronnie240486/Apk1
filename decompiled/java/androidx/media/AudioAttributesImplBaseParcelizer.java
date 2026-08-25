package androidx.media;

import p003a2.AbstractC0033b;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0033b abstractC0033b) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2567a = abstractC0033b.m184f(audioAttributesImplBase.f2567a, 1);
        audioAttributesImplBase.f2568b = abstractC0033b.m184f(audioAttributesImplBase.f2568b, 2);
        audioAttributesImplBase.f2569c = abstractC0033b.m184f(audioAttributesImplBase.f2569c, 3);
        audioAttributesImplBase.f2570d = abstractC0033b.m184f(audioAttributesImplBase.f2570d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0033b abstractC0033b) {
        abstractC0033b.getClass();
        abstractC0033b.m188j(audioAttributesImplBase.f2567a, 1);
        abstractC0033b.m188j(audioAttributesImplBase.f2568b, 2);
        abstractC0033b.m188j(audioAttributesImplBase.f2569c, 3);
        abstractC0033b.m188j(audioAttributesImplBase.f2570d, 4);
    }
}
