package p226v0;

import android.graphics.Rect;
import java.util.Comparator;
import p148o0.C3233h;
import p171q.C3388b;

public final class C3967c implements Comparator {

    public final Rect f13473a = new Rect();

    public final Rect f13474b = new Rect();

    public final boolean f13475c;

    public final C3388b f13476d;

    public C3967c(boolean z7, C3388b c3388b) {
        this.f13475c = z7;
        this.f13476d = c3388b;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        this.f13476d.getClass();
        Rect rect = this.f13473a;
        ((C3233h) obj).m6544f(rect);
        Rect rect2 = this.f13474b;
        ((C3233h) obj2).m6544f(rect2);
        int i6 = rect.top;
        int i10 = rect2.top;
        if (i6 < i10) {
            return -1;
        }
        if (i6 > i10) {
            return 1;
        }
        int i11 = rect.left;
        int i12 = rect2.left;
        boolean z7 = this.f13475c;
        if (i11 < i12) {
            return z7 ? 1 : -1;
        }
        if (i11 > i12) {
            return z7 ? -1 : 1;
        }
        int i13 = rect.bottom;
        int i14 = rect2.bottom;
        if (i13 < i14) {
            return -1;
        }
        if (i13 > i14) {
            return 1;
        }
        int i15 = rect.right;
        int i16 = rect2.right;
        if (i15 < i16) {
            return z7 ? 1 : -1;
        }
        if (i15 > i16) {
            return z7 ? -1 : 1;
        }
        return 0;
    }
}
