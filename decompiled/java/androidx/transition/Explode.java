package androidx.transition;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.p2serv.android.p032ds.R;
import p258y1.AbstractC4233v;
import p258y1.C4206e0;
import p258y1.C4217k;

public class Explode extends Visibility {

    public static final DecelerateInterpolator f3774A = new DecelerateInterpolator();

    public static final AccelerateInterpolator f3775B = new AccelerateInterpolator();

    public final int[] f3776z;

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3776z = new int[2];
        this.f3809s = new C4217k();
    }

    @Override
    public final Animator mo3038H(ViewGroup viewGroup, View view, C4206e0 c4206e0, C4206e0 c4206e1) {
        if (c4206e1 == null) {
            return null;
        }
        Rect rect = (Rect) c4206e1.f14292a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = this.f3776z;
        m3040K(viewGroup, rect, iArr);
        return AbstractC4233v.m8273c(view, c4206e1, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f3774A, this);
    }

    @Override
    public final Animator mo3039I(ViewGroup viewGroup, View view, C4206e0 c4206e0) {
        float f;
        float f3;
        if (c4206e0 == null) {
            return null;
        }
        Rect rect = (Rect) c4206e0.f14292a.get("android:explode:screenBounds");
        int i6 = rect.left;
        int i10 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c4206e0.f14293b.getTag(R.id.transition_position);
        if (iArr != null) {
            int i11 = iArr[0];
            f = (i11 - rect.left) + translationX;
            int i12 = iArr[1];
            f3 = (i12 - rect.top) + translationY;
            rect.offsetTo(i11, i12);
        } else {
            f = translationX;
            f3 = translationY;
        }
        int[] iArr2 = this.f3776z;
        m3040K(viewGroup, rect, iArr2);
        return AbstractC4233v.m8273c(view, c4206e0, i6, i10, translationX, translationY, f + iArr2[0], f3 + iArr2[1], f3775B, this);
    }

    public final void m3040K(ViewGroup viewGroup, Rect rect, int[] iArr) {
        int[] iArr2 = this.f3776z;
        viewGroup.getLocationOnScreen(iArr2);
        int i6 = iArr2[0];
        int i10 = iArr2[1];
        int iRound = Math.round(viewGroup.getTranslationX()) + (viewGroup.getWidth() / 2) + i6;
        int iRound2 = Math.round(viewGroup.getTranslationY()) + (viewGroup.getHeight() / 2) + i10;
        float fCenterX = rect.centerX() - iRound;
        float fCenterY = rect.centerY() - iRound2;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fSqrt = (float) Math.sqrt((fCenterY * fCenterY) + (fCenterX * fCenterX));
        int i11 = iRound - i6;
        int i12 = iRound2 - i10;
        float fMax = Math.max(i11, viewGroup.getWidth() - i11);
        float fMax2 = Math.max(i12, viewGroup.getHeight() - i12);
        float fSqrt2 = (float) Math.sqrt((fMax2 * fMax2) + (fMax * fMax));
        iArr[0] = Math.round((fCenterX / fSqrt) * fSqrt2);
        iArr[1] = Math.round(fSqrt2 * (fCenterY / fSqrt));
    }

    public final void m3041L(C4206e0 c4206e0) {
        View view = c4206e0.f14293b;
        int[] iArr = this.f3776z;
        view.getLocationOnScreen(iArr);
        int i6 = iArr[0];
        int i10 = iArr[1];
        c4206e0.f14292a.put("android:explode:screenBounds", new Rect(i6, i10, view.getWidth() + i6, view.getHeight() + i10));
    }

    @Override
    public final void mo3030c(C4206e0 c4206e0) {
        Visibility.m3075F(c4206e0);
        m3041L(c4206e0);
    }

    @Override
    public final void mo3031f(C4206e0 c4206e0) {
        Visibility.m3075F(c4206e0);
        m3041L(c4206e0);
    }
}
