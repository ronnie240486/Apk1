package androidx.media;

import p003a2.AbstractC0033b;
import p003a2.InterfaceC0035d;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0033b abstractC0033b) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        InterfaceC0035d interfaceC0035dM186h = audioAttributesCompat.f2564a;
        if (abstractC0033b.mo183e(1)) {
            interfaceC0035dM186h = abstractC0033b.m186h();
        }
        audioAttributesCompat.f2564a = (AudioAttributesImpl) interfaceC0035dM186h;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0033b abstractC0033b) {
        abstractC0033b.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f2564a;
        abstractC0033b.mo187i(1);
        abstractC0033b.m190l(audioAttributesImpl);
    }
}
