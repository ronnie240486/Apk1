package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.p2serv.android.p032ds.R;
import java.util.Random;
import java.util.regex.Pattern;
import p143n5.AbstractC3198d;

@SuppressLint({"AppCompatCustomView"})
class StreamingTextView extends EditText {

    public static final Pattern f2287f = Pattern.compile("\\S+");

    public static final C0464f1 f2288g = new C0464f1("streamPosition", Integer.class, 0);

    public final Random f2289a;

    public Bitmap f2290b;

    public Bitmap f2291c;

    public int f2292d;

    public ObjectAnimator f2293e;

    public StreamingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2289a = new Random();
    }

    public int getStreamPosition() {
        return this.f2292d;
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lb_text_dot_one);
        this.f2290b = Bitmap.createScaledBitmap(bitmapDecodeResource, (int) (bitmapDecodeResource.getWidth() * 1.3f), (int) (bitmapDecodeResource.getHeight() * 1.3f), false);
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.lb_text_dot_two);
        this.f2291c = Bitmap.createScaledBitmap(bitmapDecodeResource2, (int) (bitmapDecodeResource2.getWidth() * 1.3f), (int) (bitmapDecodeResource2.getHeight() * 1.3f), false);
        this.f2292d = -1;
        ObjectAnimator objectAnimator = this.f2293e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setText("");
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.leanback.widget.StreamingTextView");
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public void setStreamPosition(int i6) {
        this.f2292d = i6;
        invalidate();
    }

    public StreamingTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2289a = new Random();
    }
}
