package p079h6;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public final class ViewOnTouchListenerC2662a implements View.OnTouchListener {

    public final Dialog f9291a;

    public final int f9292b;

    public final int f9293c;

    public final int f9294d;

    public ViewOnTouchListenerC2662a(Dialog dialog, Rect rect) {
        this.f9291a = dialog;
        this.f9292b = rect.left;
        this.f9293c = rect.top;
        this.f9294d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f9292b;
        int width = viewFindViewById.getWidth() + left;
        int top = viewFindViewById.getTop() + this.f9293c;
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i6 = this.f9294d;
            motionEventObtain.setLocation((-i6) - 1, (-i6) - 1);
        }
        view.performClick();
        return this.f9291a.onTouchEvent(motionEventObtain);
    }
}
