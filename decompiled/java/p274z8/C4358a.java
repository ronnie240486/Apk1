package p274z8;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Comparator;
import p103j9.AbstractC2796i;

public final class C4358a implements Comparator {

    public static final C4358a f14799b = new C4358a(0);

    public static final C4358a f14800c = new C4358a(1);

    public final int f14801a;

    public C4358a(int i6) {
        this.f14801a = i6;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        switch (this.f14801a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                AbstractC2796i.m5785f(comparable, CmcdData.OBJECT_TYPE_AUDIO_ONLY);
                AbstractC2796i.m5785f(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                AbstractC2796i.m5785f(comparable3, CmcdData.OBJECT_TYPE_AUDIO_ONLY);
                AbstractC2796i.m5785f(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override
    public final Comparator reversed() {
        switch (this.f14801a) {
            case 0:
                return f14800c;
            default:
                return f14799b;
        }
    }
}
