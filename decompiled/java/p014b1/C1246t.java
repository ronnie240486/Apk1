package p014b1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p024c1.C1377a;

public final class C1246t extends ReplacementSpan {

    public final C1239m f3966b;

    public final Paint.FontMetricsInt f3965a = new Paint.FontMetricsInt();

    public float f3967c = 1.0f;

    public C1246t(C1239m c1239m) {
        AbstractC0032a.m162p(c1239m, "metadata cannot be null");
        this.f3966b = c1239m;
    }

    @Override
    public final void draw(Canvas canvas, CharSequence charSequence, int i6, int i10, float f, int i11, int i12, int i13, Paint paint) {
        C1235i.m3106a().getClass();
        C1239m c1239m = this.f3966b;
        C0023f c0023f = c1239m.f3939b;
        Typeface typeface = (Typeface) c0023f.f47e;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) c0023f.f45c, c1239m.f3938a * 2, 2, f, i12, paint);
        paint.setTypeface(typeface2);
    }

    @Override
    public final int getSize(Paint paint, CharSequence charSequence, int i6, int i10, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f3965a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        C1239m c1239m = this.f3966b;
        C1377a c1377aM3115c = c1239m.m3115c();
        int iM3244a = c1377aM3115c.m3244a(14);
        this.f3967c = fAbs / (iM3244a != 0 ? ((ByteBuffer) c1377aM3115c.f4194d).getShort(iM3244a + c1377aM3115c.f4191a) : (short) 0);
        C1377a c1377aM3115c2 = c1239m.m3115c();
        int iM3244a2 = c1377aM3115c2.m3244a(14);
        if (iM3244a2 != 0) {
            ((ByteBuffer) c1377aM3115c2.f4194d).getShort(iM3244a2 + c1377aM3115c2.f4191a);
        }
        C1377a c1377aM3115c3 = c1239m.m3115c();
        int iM3244a3 = c1377aM3115c3.m3244a(12);
        short s10 = (short) ((iM3244a3 != 0 ? ((ByteBuffer) c1377aM3115c3.f4194d).getShort(iM3244a3 + c1377aM3115c3.f4191a) : (short) 0) * this.f3967c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s10;
    }
}
