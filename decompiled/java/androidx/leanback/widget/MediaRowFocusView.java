package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.p2serv.android.p032ds.R;

class MediaRowFocusView extends View {

    public final Paint f2170a;

    public final RectF f2171b;

    public int f2172c;

    public MediaRowFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2171b = new RectF();
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.lb_playback_media_row_highlight_color));
        this.f2170a = paint;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.f2172c = height;
        int height2 = ((height * 2) - getHeight()) / 2;
        float f = -height2;
        float width = getWidth();
        float height3 = getHeight() + height2;
        RectF rectF = this.f2171b;
        rectF.set(0.0f, f, width, height3);
        int i6 = this.f2172c;
        canvas.drawRoundRect(rectF, i6, i6, this.f2170a);
    }

    public MediaRowFocusView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2171b = new RectF();
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.lb_playback_media_row_highlight_color));
        this.f2170a = paint;
    }
}
