package androidx.media;

import java.util.Arrays;
import p000a.AbstractC0004e;

public class AudioAttributesImplBase implements AudioAttributesImpl {

    public int f2567a = 0;

    public int f2568b = 0;

    public int f2569c = 0;

    public int f2570d = -1;

    @Override
    public final int mo1530a() {
        int i6 = this.f2570d;
        return i6 != -1 ? i6 : AudioAttributesCompat.m1528b(this.f2569c, this.f2567a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f2568b != audioAttributesImplBase.f2568b) {
            return false;
        }
        int i6 = this.f2569c;
        int i10 = audioAttributesImplBase.f2569c;
        int iMo1530a = audioAttributesImplBase.mo1530a();
        if (iMo1530a == 6) {
            i10 |= 4;
        } else if (iMo1530a == 7) {
            i10 |= 1;
        }
        return i6 == (i10 & 273) && this.f2567a == audioAttributesImplBase.f2567a && this.f2570d == audioAttributesImplBase.f2570d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2568b), Integer.valueOf(this.f2569c), Integer.valueOf(this.f2567a), Integer.valueOf(this.f2570d)});
    }

    public final String toString() {
        String strM20n;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2570d != -1) {
            sb.append(" stream=");
            sb.append(this.f2570d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i6 = this.f2567a;
        int i10 = AudioAttributesCompat.f2563b;
        switch (i6) {
            case 0:
                strM20n = "USAGE_UNKNOWN";
                break;
            case 1:
                strM20n = "USAGE_MEDIA";
                break;
            case 2:
                strM20n = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strM20n = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strM20n = "USAGE_ALARM";
                break;
            case 5:
                strM20n = "USAGE_NOTIFICATION";
                break;
            case 6:
                strM20n = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strM20n = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strM20n = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strM20n = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strM20n = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strM20n = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strM20n = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strM20n = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strM20n = "USAGE_GAME";
                break;
            case 15:
            default:
                strM20n = AbstractC0004e.m20n(i6, "unknown usage ");
                break;
            case 16:
                strM20n = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strM20n);
        sb.append(" content=");
        sb.append(this.f2568b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2569c).toUpperCase());
        return sb.toString();
    }
}
