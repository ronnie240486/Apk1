package p199s4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import p230v4.C3988b;

public final class C3714h implements InterfaceC3707a {

    public final int f12445a;

    public final C3716j f12446b;

    public C3714h(C3716j c3716j, int i6) {
        this.f12445a = i6;
        this.f12446b = c3716j;
    }

    @Override
    public final void mo3999f(Bitmap bitmap) {
        C3716j c3716j = this.f12446b;
        switch (this.f12445a) {
            case 0:
                C3988b c3988b = C3716j.f12448v;
                Bitmap bitmap2 = null;
                if (bitmap != null) {
                    int width = bitmap.getWidth();
                    float f = width;
                    int height = bitmap.getHeight();
                    int i6 = (int) (((9.0f * f) / 16.0f) + 0.5f);
                    float f3 = (i6 - height) / 2.0f;
                    RectF rectF = new RectF(0.0f, f3, f, height + f3);
                    Bitmap.Config config = bitmap.getConfig();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, i6, config);
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
                    bitmap2 = bitmapCreateBitmap;
                }
                c3716j.m7473b(bitmap2, 0);
                break;
            default:
                c3716j.m7473b(bitmap, 3);
                break;
        }
    }
}
