package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    public AudioAttributes f2565a;

    public int f2566b = -1;

    public AudioAttributesImplApi21() {
    }

    @Override
    public final int mo1530a() {
        int i6 = this.f2566b;
        return i6 != -1 ? i6 : AudioAttributesCompat.m1528b(this.f2565a.getFlags(), this.f2565a.getUsage());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f2565a.equals(((AudioAttributesImplApi21) obj).f2565a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2565a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2565a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.f2565a = audioAttributes;
    }
}
