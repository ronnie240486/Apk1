package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.p2serv.android.p032ds.R;

public class AppCompatRatingBar extends RatingBar {

    public final C0179b0 f640a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    @Override
    public final synchronized void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        Bitmap bitmap = (Bitmap) this.f640a.f873c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i6, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0224j3.m702a(this, getContext());
        C0179b0 c0179b0 = new C0179b0(this);
        this.f640a = c0179b0;
        c0179b0.mo640b(attributeSet, i6);
    }
}
