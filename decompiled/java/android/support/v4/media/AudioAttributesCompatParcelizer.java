package android.support.v4.media;

import androidx.media.AudioAttributesCompat;
import p003a2.AbstractC0033b;

public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0033b abstractC0033b) {
        return androidx.media.AudioAttributesCompatParcelizer.read(abstractC0033b);
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0033b abstractC0033b) {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat, abstractC0033b);
    }
}
