package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.AbstractC0516c0;
import androidx.lifecycle.C0511a0;
import androidx.lifecycle.C0514b0;
import androidx.lifecycle.C0518d0;
import com.p2serv.android.p032ds.R;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p127m.C3021c;
import p127m.C3024f;
import p156o9.AbstractC3281e;

public class DialogInterfaceOnCancelListenerC0415m extends AbstractComponentCallbacksC0427s implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    public Handler f1897T;

    public boolean f1906d0;

    public Dialog f1908f0;

    public boolean f1909g0;

    public boolean f1910h0;

    public boolean f1911i0;

    public final RunnableC0399e f1898U = new RunnableC0399e(1, this);

    public final DialogInterfaceOnCancelListenerC0409j f1899V = new DialogInterfaceOnCancelListenerC0409j(this);

    public final DialogInterfaceOnDismissListenerC0411k f1900W = new DialogInterfaceOnDismissListenerC0411k(this);

    public int f1901X = 0;

    public int f1902Y = 0;

    public boolean f1903Z = true;

    public boolean f1904b0 = true;

    public int f1905c0 = -1;

    public final C0397d f1907e0 = new C0397d(1, this);

    public boolean f1912j0 = false;

    @Override
    public void mo1269A(Bundle bundle) {
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i6 = this.f1901X;
        if (i6 != 0) {
            bundle.putInt("android:style", i6);
        }
        int i10 = this.f1902Y;
        if (i10 != 0) {
            bundle.putInt("android:theme", i10);
        }
        boolean z7 = this.f1903Z;
        if (!z7) {
            bundle.putBoolean("android:cancelable", z7);
        }
        boolean z10 = this.f1904b0;
        if (!z10) {
            bundle.putBoolean("android:showsDialog", z10);
        }
        int i11 = this.f1905c0;
        if (i11 != -1) {
            bundle.putInt("android:backStackId", i11);
        }
    }

    @Override
    public void mo1270B() {
        this.f1949D = true;
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            this.f1909g0 = false;
            dialog.show();
            View decorView = this.f1908f0.getWindow().getDecorView();
            AbstractC2796i.m5785f(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override
    public void mo1271C() {
        this.f1949D = true;
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override
    public final void mo1272E(Bundle bundle) {
        Bundle bundle2;
        this.f1949D = true;
        if (this.f1908f0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f1908f0.onRestoreInstanceState(bundle2);
    }

    @Override
    public final void mo1273F(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.mo1273F(layoutInflater, viewGroup, bundle);
        if (this.f1951F != null || this.f1908f0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f1908f0.onRestoreInstanceState(bundle2);
    }

    public final void m1274Q(boolean z7, boolean z10) {
        if (this.f1910h0) {
            return;
        }
        this.f1910h0 = true;
        this.f1911i0 = false;
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f1908f0.dismiss();
            if (!z10) {
                if (Looper.myLooper() == this.f1897T.getLooper()) {
                    onDismiss(this.f1908f0);
                } else {
                    this.f1897T.post(this.f1898U);
                }
            }
        }
        this.f1909g0 = true;
        if (this.f1905c0 >= 0) {
            AbstractC0410j0 abstractC0410j0M1323l = m1323l();
            int i6 = this.f1905c0;
            if (i6 < 0) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Bad id: "));
            }
            abstractC0410j0M1323l.m1257s(new C0408i0(abstractC0410j0M1323l, i6), false);
            this.f1905c0 = -1;
            return;
        }
        C0391a c0391a = new C0391a(m1323l());
        c0391a.m1193h(this);
        if (z7) {
            c0391a.m1190e(true);
        } else {
            c0391a.m1190e(false);
        }
    }

    public Dialog mo1275R() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(m1312K(), this.f1902Y);
    }

    public void m1276S(C0412k0 c0412k0, String str) {
        this.f1910h0 = false;
        this.f1911i0 = true;
        c0412k0.getClass();
        C0391a c0391a = new C0391a(c0412k0);
        c0391a.m1191f(0, this, str, 1);
        c0391a.m1190e(false);
    }

    @Override
    public final AbstractC3281e mo1277b() {
        return new C0413l(this, new C0417n(this));
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f1909g0) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        m1274Q(true, true);
    }

    @Override
    public final void mo1278r(FragmentActivity fragmentActivity) {
        Object obj;
        super.mo1278r(fragmentActivity);
        C0518d0 c0518d0 = this.f1960O;
        C0397d c0397d = this.f1907e0;
        c0518d0.getClass();
        C0518d0.m1481a("observeForever");
        C0511a0 c0511a0 = new C0511a0(c0518d0, c0397d);
        C3024f c3024f = c0518d0.f2473b;
        C3021c c3021cMo6095c = c3024f.mo6095c(c0397d);
        if (c3021cMo6095c != null) {
            obj = c3021cMo6095c.f10344b;
        } else {
            C3021c c3021c = new C3021c(c0397d, c0511a0);
            c3024f.f10353d++;
            C3021c c3021c2 = c3024f.f10351b;
            if (c3021c2 == null) {
                c3024f.f10350a = c3021c;
                c3024f.f10351b = c3021c;
            } else {
                c3021c2.f10345c = c3021c;
                c3021c.f10346d = c3021c2;
                c3024f.f10351b = c3021c;
            }
            obj = null;
        }
        AbstractC0516c0 abstractC0516c0 = (AbstractC0516c0) obj;
        if (abstractC0516c0 instanceof C0514b0) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0516c0 == null) {
            c0511a0.m1478d(true);
        }
        if (this.f1911i0) {
            return;
        }
        this.f1910h0 = false;
    }

    @Override
    public void mo1279s(Bundle bundle) {
        super.mo1279s(bundle);
        this.f1897T = new Handler();
        this.f1904b0 = this.f1987x == 0;
        if (bundle != null) {
            this.f1901X = bundle.getInt("android:style", 0);
            this.f1902Y = bundle.getInt("android:theme", 0);
            this.f1903Z = bundle.getBoolean("android:cancelable", true);
            this.f1904b0 = bundle.getBoolean("android:showsDialog", this.f1904b0);
            this.f1905c0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override
    public void mo1280v() {
        this.f1949D = true;
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            this.f1909g0 = true;
            dialog.setOnDismissListener(null);
            this.f1908f0.dismiss();
            if (!this.f1910h0) {
                onDismiss(this.f1908f0);
            }
            this.f1908f0 = null;
            this.f1912j0 = false;
        }
    }

    @Override
    public final void mo1281w() {
        this.f1949D = true;
        if (!this.f1911i0 && !this.f1910h0) {
            this.f1910h0 = true;
        }
        this.f1960O.mo1489i(this.f1907e0);
    }

    @Override
    public final LayoutInflater mo1282x(Bundle bundle) {
        LayoutInflater layoutInflaterMo1282x = super.mo1282x(bundle);
        boolean z7 = this.f1904b0;
        if (!z7 || this.f1906d0) {
            if (Log.isLoggable("FragmentManager", 2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (this.f1904b0) {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                } else {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                }
            }
            return layoutInflaterMo1282x;
        }
        if (z7 && !this.f1912j0) {
            try {
                this.f1906d0 = true;
                Dialog dialogMo1275R = mo1275R();
                this.f1908f0 = dialogMo1275R;
                if (this.f1904b0) {
                    int i6 = this.f1901X;
                    if (i6 == 1 || i6 == 2) {
                        dialogMo1275R.requestWindowFeature(1);
                    } else if (i6 == 3) {
                        Window window = dialogMo1275R.getWindow();
                        if (window != null) {
                            window.addFlags(24);
                        }
                        dialogMo1275R.requestWindowFeature(1);
                    }
                    Context contextM1321j = m1321j();
                    if (contextM1321j instanceof Activity) {
                        this.f1908f0.setOwnerActivity((Activity) contextM1321j);
                    }
                    this.f1908f0.setCancelable(this.f1903Z);
                    this.f1908f0.setOnCancelListener(this.f1899V);
                    this.f1908f0.setOnDismissListener(this.f1900W);
                    this.f1912j0 = true;
                } else {
                    this.f1908f0 = null;
                }
                this.f1906d0 = false;
            } catch (Throwable th) {
                this.f1906d0 = false;
                throw th;
            }
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f1908f0;
        return dialog != null ? layoutInflaterMo1282x.cloneInContext(dialog.getContext()) : layoutInflaterMo1282x;
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
    }
}
