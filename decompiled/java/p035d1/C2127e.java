package p035d1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import p007a7.C0069f;
import p221u6.C3905e;

public final class C2127e implements KeyListener {

    public final KeyListener f7738a;

    public final C3905e f7739b;

    public C2127e(KeyListener keyListener) {
        C3905e c3905e = new C3905e(8);
        this.f7738a = keyListener;
        this.f7739b = c3905e;
    }

    @Override
    public final void clearMetaKeyState(View view, Editable editable, int i6) {
        this.f7738a.clearMetaKeyState(view, editable, i6);
    }

    @Override
    public final int getInputType() {
        return this.f7738a.getInputType();
    }

    @Override
    public final boolean onKeyDown(View view, Editable editable, int i6, KeyEvent keyEvent) {
        boolean zM217f;
        boolean z7;
        this.f7739b.getClass();
        if (i6 != 67) {
            zM217f = i6 != 112 ? false : C0069f.m217f(editable, keyEvent, true);
        } else {
            zM217f = C0069f.m217f(editable, keyEvent, false);
        }
        if (zM217f) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z7 = true;
        } else {
            z7 = false;
        }
        return z7 || this.f7738a.onKeyDown(view, editable, i6, keyEvent);
    }

    @Override
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f7738a.onKeyOther(view, editable, keyEvent);
    }

    @Override
    public final boolean onKeyUp(View view, Editable editable, int i6, KeyEvent keyEvent) {
        return this.f7738a.onKeyUp(view, editable, i6, keyEvent);
    }
}
