package p249x4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import p018b5.AbstractC1312l;

public class C4113f extends DialogInterfaceOnCancelListenerC0415m {

    public AlertDialog f13941k0;

    public DialogInterface.OnCancelListener f13942l0;

    public AlertDialog f13943m0;

    @Override
    public final Dialog mo1275R() {
        AlertDialog alertDialog = this.f13941k0;
        if (alertDialog != null) {
            return alertDialog;
        }
        this.f1904b0 = false;
        if (this.f13943m0 == null) {
            Context contextM1321j = m1321j();
            AbstractC1312l.m3198e(contextM1321j);
            this.f13943m0 = new AlertDialog.Builder(contextM1321j).create();
        }
        return this.f13943m0;
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f13942l0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
