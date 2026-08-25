package p055ea;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import org.bitspark.android.Spark;

public final class C2439f0 implements ValueAnimator.AnimatorUpdateListener {

    public final int f8550a;

    public final Spark f8551b;

    public C2439f0(Spark spark, int i6) {
        this.f8550a = i6;
        this.f8551b = spark;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f8550a) {
            case 0:
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                Spark spark = this.f8551b;
                ViewGroup.LayoutParams layoutParams = spark.f11153y.getLayoutParams();
                layoutParams.width = iIntValue;
                spark.f11153y.setLayoutParams(layoutParams);
                break;
            default:
                int iIntValue2 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                Spark spark2 = this.f8551b;
                ViewGroup.LayoutParams layoutParams2 = spark2.f11153y.getLayoutParams();
                layoutParams2.width = iIntValue2;
                spark2.f11153y.setLayoutParams(layoutParams2);
                break;
        }
    }
}
