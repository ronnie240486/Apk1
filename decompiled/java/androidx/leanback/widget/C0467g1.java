package androidx.leanback.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

public final class C0467g1 extends ReplacementSpan {

    public final int f2332a;

    public final int f2333b;

    public final StreamingTextView f2334c;

    public C0467g1(StreamingTextView streamingTextView, int i6, int i10) {
        this.f2334c = streamingTextView;
        this.f2332a = i6;
        this.f2333b = i10;
    }

    @Override
    public final void draw(Canvas canvas, CharSequence charSequence, int i6, int i10, float f, int i11, int i12, int i13, Paint paint) {
        int iMeasureText = (int) paint.measureText(charSequence, i6, i10);
        StreamingTextView streamingTextView = this.f2334c;
        int width = streamingTextView.f2290b.getWidth();
        int i14 = width * 2;
        int i15 = iMeasureText / i14;
        int i16 = (iMeasureText % i14) / 2;
        boolean z7 = 1 == streamingTextView.getLayoutDirection();
        streamingTextView.f2289a.setSeed(this.f2332a);
        int alpha = paint.getAlpha();
        for (int i17 = 0; i17 < i15 && this.f2333b + i17 < streamingTextView.f2292d; i17++) {
            float f3 = (width / 2) + (i17 * i14) + i16;
            float f4 = z7 ? ((f + iMeasureText) - f3) - width : f + f3;
            paint.setAlpha((streamingTextView.f2289a.nextInt(4) + 1) * 63);
            if (streamingTextView.f2289a.nextBoolean()) {
                Bitmap bitmap = streamingTextView.f2291c;
                canvas.drawBitmap(bitmap, f4, i12 - bitmap.getHeight(), paint);
            } else {
                Bitmap bitmap2 = streamingTextView.f2290b;
                canvas.drawBitmap(bitmap2, f4, i12 - bitmap2.getHeight(), paint);
            }
        }
        paint.setAlpha(alpha);
    }

    @Override
    public final int getSize(Paint paint, CharSequence charSequence, int i6, int i10, Paint.FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence, i6, i10);
    }
}
