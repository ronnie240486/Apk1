package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.p2serv.android.p032ds.R;

public class AppCompatSeekBar extends SeekBar {

    public final C0191d0 f641a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    @Override
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0191d0 c0191d0 = this.f641a;
        Drawable drawable = c0191d0.f883f;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        AppCompatSeekBar appCompatSeekBar = c0191d0.f882e;
        if (drawable.setState(appCompatSeekBar.getDrawableState())) {
            appCompatSeekBar.invalidateDrawable(drawable);
        }
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f641a.f883f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f641a.m650g(canvas);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0224j3.m702a(this, getContext());
        C0191d0 c0191d0 = new C0191d0(this);
        this.f641a = c0191d0;
        c0191d0.mo640b(attributeSet, i6);
    }
}
