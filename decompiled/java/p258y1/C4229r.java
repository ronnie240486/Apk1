package p258y1;

import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class C4229r extends AbstractC4233v {

    public int f14368v;

    @Override
    public final long mo8267e(ViewGroup viewGroup, Transition transition, C4206e0 c4206e0, C4206e0 c4206e1) {
        int i6;
        int iAbs;
        Integer num;
        C4206e0 c4206e2 = c4206e0;
        if (c4206e2 == null && c4206e1 == null) {
            return 0L;
        }
        transition.getClass();
        if (c4206e1 != null) {
            int iIntValue = 8;
            if (c4206e2 != null && (num = (Integer) c4206e2.f14292a.get("android:visibilityPropagation:visibility")) != null) {
                iIntValue = num.intValue();
            }
            if (iIntValue == 0) {
                i6 = -1;
            } else {
                c4206e2 = c4206e1;
                i6 = 1;
            }
        } else {
            i6 = -1;
        }
        int iM8275f = AbstractC4233v.m8275f(c4206e2, 0);
        int iM8275f2 = AbstractC4233v.m8275f(c4206e2, 1);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = Math.round(viewGroup.getTranslationX()) + iArr[0];
        int iRound2 = Math.round(viewGroup.getTranslationY()) + iArr[1];
        int width = viewGroup.getWidth() + iRound;
        int height = viewGroup.getHeight() + iRound2;
        int i10 = (iRound + width) / 2;
        int i11 = (iRound2 + height) / 2;
        int i12 = this.f14368v;
        if (i12 == 8388611) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (viewGroup.getLayoutDirection() == 1) {
                i12 = 5;
            } else {
                i12 = 3;
            }
        } else if (i12 == 8388613) {
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            if (viewGroup.getLayoutDirection() == 1) {
                i12 = 3;
            } else {
                i12 = 5;
            }
        }
        if (i12 == 3) {
            iAbs = Math.abs(i11 - iM8275f2) + (width - iM8275f);
        } else if (i12 == 5) {
            iAbs = Math.abs(i11 - iM8275f2) + (iM8275f - iRound);
        } else if (i12 != 48) {
            iAbs = i12 != 80 ? 0 : (iM8275f2 - iRound2) + Math.abs(i10 - iM8275f);
        } else {
            iAbs = Math.abs(i10 - iM8275f) + (height - iM8275f2);
        }
        float f = iAbs;
        int i13 = this.f14368v;
        float width2 = f / ((i13 == 3 || i13 == 5 || i13 == 8388611 || i13 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight());
        long j10 = transition.f3793c;
        if (j10 < 0) {
            j10 = 300;
        }
        return Math.round(((j10 * ((long) i6)) / 3.0f) * width2);
    }
}
