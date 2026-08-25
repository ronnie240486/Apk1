package la;

import android.view.KeyEvent;
import android.view.View;

public final class ViewOnKeyListenerC3016c implements View.OnKeyListener {

    public final int f10308a;

    public final ViewOnClickListenerC3017d f10309b;

    public ViewOnKeyListenerC3016c(ViewOnClickListenerC3017d viewOnClickListenerC3017d, int i6) {
        this.f10308a = i6;
        this.f10309b = viewOnClickListenerC3017d;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        switch (this.f10308a) {
            case 0:
                ViewOnClickListenerC3017d viewOnClickListenerC3017d = this.f10309b;
                int selectionStart = viewOnClickListenerC3017d.f10315Y.getSelectionStart();
                int length = viewOnClickListenerC3017d.f10315Y.getText().length();
                if (viewOnClickListenerC3017d.f10322g0 && i6 == 66) {
                    if (keyEvent.getAction() != 1) {
                        return true;
                    }
                    viewOnClickListenerC3017d.f10316Z.requestFocus();
                    return true;
                }
                if ((selectionStart == length || length == 0) && i6 == 22) {
                    return true;
                }
                if (selectionStart == 0 && i6 == 21) {
                    return true;
                }
                if (i6 != 19 || keyEvent.getAction() != 0) {
                    return false;
                }
                viewOnClickListenerC3017d.f10323h0.requestFocus();
                return true;
            default:
                return this.f10309b.f10316Z.getSelectionStart() == 0 && i6 == 21;
        }
    }
}
