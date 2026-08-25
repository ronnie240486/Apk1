package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.appcompat.app.C0130e;
import androidx.appcompat.app.C0138i;
import androidx.appcompat.app.DialogInterfaceC0140j;

public final class DialogInterfaceOnClickListenerC0216i0 implements InterfaceC0246o0, DialogInterface.OnClickListener {

    public DialogInterfaceC0140j f944a;

    public C0221j0 f945b;

    public CharSequence f946c;

    public final AppCompatSpinner f947d;

    public DialogInterfaceOnClickListenerC0216i0(AppCompatSpinner appCompatSpinner) {
        this.f947d = appCompatSpinner;
    }

    @Override
    public final boolean mo689c() {
        DialogInterfaceC0140j dialogInterfaceC0140j = this.f944a;
        if (dialogInterfaceC0140j != null) {
            return dialogInterfaceC0140j.isShowing();
        }
        return false;
    }

    @Override
    public final void dismiss() {
        DialogInterfaceC0140j dialogInterfaceC0140j = this.f944a;
        if (dialogInterfaceC0140j != null) {
            dialogInterfaceC0140j.dismiss();
            this.f944a = null;
        }
    }

    @Override
    public final int mo690e() {
        return 0;
    }

    @Override
    public final Drawable mo691f() {
        return null;
    }

    @Override
    public final void mo692g(CharSequence charSequence) {
        this.f946c = charSequence;
    }

    @Override
    public final void mo693i(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override
    public final void mo694j(int i6) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override
    public final void mo695l(int i6) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override
    public final void mo696m(int i6) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override
    public final void mo697n(int i6, int i10) {
        if (this.f945b == null) {
            return;
        }
        AppCompatSpinner appCompatSpinner = this.f947d;
        C0138i c0138i = new C0138i(appCompatSpinner.getPopupContext());
        CharSequence charSequence = this.f946c;
        C0130e c0130e = c0138i.f383a;
        if (charSequence != null) {
            c0130e.f276d = charSequence;
        }
        C0221j0 c0221j0 = this.f945b;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        c0130e.f279g = c0221j0;
        c0130e.f280h = this;
        c0130e.f283k = selectedItemPosition;
        c0130e.f282j = true;
        DialogInterfaceC0140j dialogInterfaceC0140jM417a = c0138i.m417a();
        this.f944a = dialogInterfaceC0140jM417a;
        AlertController$RecycleListView alertController$RecycleListView = dialogInterfaceC0140jM417a.f389e.f361e;
        AbstractC0206g0.m673d(alertController$RecycleListView, i6);
        AbstractC0206g0.m672c(alertController$RecycleListView, i10);
        this.f944a.show();
    }

    @Override
    public final int mo698o() {
        return 0;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        AppCompatSpinner appCompatSpinner = this.f947d;
        appCompatSpinner.setSelection(i6);
        if (appCompatSpinner.getOnItemClickListener() != null) {
            appCompatSpinner.performItemClick(null, i6, this.f945b.getItemId(i6));
        }
        dismiss();
    }

    @Override
    public final CharSequence mo699p() {
        return this.f946c;
    }

    @Override
    public final void mo586q(ListAdapter listAdapter) {
        this.f945b = (C0221j0) listAdapter;
    }
}
