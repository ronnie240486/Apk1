package p258y1;

import android.view.ViewGroup;
import androidx.transition.Transition;

public final class C4217k extends AbstractC4233v {
    @Override
    public final long mo8267e(ViewGroup viewGroup, Transition transition, C4206e0 c4206e0, C4206e0 c4206e1) {
        int i6;
        Integer num;
        if (c4206e0 == null && c4206e1 == null) {
            return 0L;
        }
        if (c4206e1 != null) {
            int iIntValue = 8;
            if (c4206e0 != null && (num = (Integer) c4206e0.f14292a.get("android:visibilityPropagation:visibility")) != null) {
                iIntValue = num.intValue();
            }
            if (iIntValue == 0) {
                i6 = -1;
            } else {
                c4206e0 = c4206e1;
                i6 = 1;
            }
        } else {
            i6 = -1;
        }
        int iM8275f = AbstractC4233v.m8275f(c4206e0, 0);
        int iM8275f2 = AbstractC4233v.m8275f(c4206e0, 1);
        transition.getClass();
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        float fRound = Math.round(viewGroup.getTranslationX() + ((viewGroup.getWidth() / 2) + iArr[0])) - iM8275f;
        float fRound2 = Math.round(viewGroup.getTranslationY() + ((viewGroup.getHeight() / 2) + iArr[1])) - iM8275f2;
        float fSqrt = (float) Math.sqrt((fRound2 * fRound2) + (fRound * fRound));
        float width = viewGroup.getWidth() - 0.0f;
        float height = viewGroup.getHeight() - 0.0f;
        float fSqrt2 = fSqrt / ((float) Math.sqrt((height * height) + (width * width)));
        long j10 = transition.f3793c;
        if (j10 < 0) {
            j10 = 300;
        }
        return Math.round(((j10 * ((long) i6)) / 3.0f) * fSqrt2);
    }
}
