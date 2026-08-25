package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.p2serv.android.p032ds.R;
import p156o9.AbstractC3280d;

class MediaRouteVolumeSlider extends AppCompatSeekBar {

    public final float f3169b;

    public boolean f3170c;

    public Drawable f3171d;

    public int f3172e;

    public int f3173f;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public final void m2736a(int i6, int i10) {
        if (this.f3172e != i6) {
            if (Color.alpha(i6) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i6));
            }
            this.f3172e = i6;
        }
        if (this.f3173f != i10) {
            if (Color.alpha(i10) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i10));
            }
            this.f3173f = i10;
        }
    }

    public final void m2737b(boolean z7) {
        if (this.f3170c == z7) {
            return;
        }
        this.f3170c = z7;
        super.setThumb(z7 ? null : this.f3171d);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int i6 = isEnabled() ? 255 : (int) (this.f3169b * 255.0f);
        Drawable drawable = this.f3171d;
        int i10 = this.f3172e;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        drawable.setColorFilter(i10, mode);
        this.f3171d.setAlpha(i6);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
            layerDrawable.findDrawableByLayerId(android.R.id.background).setColorFilter(this.f3173f, mode);
            progressDrawable = drawableFindDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.f3172e, mode);
        progressDrawable.setAlpha(i6);
    }

    @Override
    public final void setThumb(Drawable drawable) {
        this.f3171d = drawable;
        if (this.f3170c) {
            drawable = null;
        }
        super.setThumb(drawable);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f3169b = AbstractC3280d.m6595m(context);
    }
}
