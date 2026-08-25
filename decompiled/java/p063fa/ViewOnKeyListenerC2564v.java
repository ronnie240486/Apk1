package p063fa;

import android.view.KeyEvent;
import android.view.View;
import org.bitspark.android.utils.AbstractC3331m;

public final class ViewOnKeyListenerC2564v implements View.OnKeyListener {

    public final int f8921a;

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        switch (this.f8921a) {
            case 0:
                return false;
            default:
                if (i6 == 19) {
                    return true;
                }
                if (i6 != 4) {
                    return false;
                }
                if (keyEvent.getAction() != 0) {
                    return true;
                }
                AbstractC3331m.m6761k();
                return true;
        }
    }
}
