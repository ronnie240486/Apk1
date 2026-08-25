package p249x4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import p018b5.AbstractC1312l;

public class DialogFragmentC4108a extends DialogFragment {

    public AlertDialog f13929a;

    public DialogInterface.OnCancelListener f13930b;

    public AlertDialog f13931c;

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f13930b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.f13929a;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.f13931c == null) {
            Activity activity = getActivity();
            AbstractC1312l.m3198e(activity);
            this.f13931c = new AlertDialog.Builder(activity).create();
        }
        return this.f13931c;
    }
}
