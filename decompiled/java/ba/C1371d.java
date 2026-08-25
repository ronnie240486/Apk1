package ba;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;

public final class C1371d extends Toast {

    public final Toast f4185a;

    public C1371d(Context context, Toast toast) {
        super(context);
        this.f4185a = toast;
    }

    public static C1371d m3242a(Context context, int i6, String str) {
        Toast toastMakeText = Toast.makeText(context, str, i6);
        m3243b(toastMakeText.getView(), new C1370c(context));
        return new C1371d(context, toastMakeText);
    }

    public static void m3243b(View view, C1370c c1370c) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, c1370c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override
    public final int getDuration() {
        return this.f4185a.getDuration();
    }

    @Override
    public final int getGravity() {
        return this.f4185a.getGravity();
    }

    @Override
    public final float getHorizontalMargin() {
        return this.f4185a.getHorizontalMargin();
    }

    @Override
    public final float getVerticalMargin() {
        return this.f4185a.getVerticalMargin();
    }

    @Override
    public final View getView() {
        return this.f4185a.getView();
    }

    @Override
    public final int getXOffset() {
        return this.f4185a.getXOffset();
    }

    @Override
    public final int getYOffset() {
        return this.f4185a.getYOffset();
    }

    @Override
    public final void setDuration(int i6) {
        this.f4185a.setDuration(i6);
    }

    @Override
    public final void setGravity(int i6, int i10, int i11) {
        this.f4185a.setGravity(i6, i10, i11);
    }

    @Override
    public final void setMargin(float f, float f3) {
        this.f4185a.setMargin(f, f3);
    }

    @Override
    public final void setText(int i6) {
        this.f4185a.setText(i6);
    }

    @Override
    public final void setView(View view) {
        this.f4185a.setView(view);
        m3243b(view, new C1370c(view.getContext()));
    }

    @Override
    public final void show() {
        this.f4185a.show();
    }

    @Override
    public final void setText(CharSequence charSequence) {
        this.f4185a.setText(charSequence);
    }
}
