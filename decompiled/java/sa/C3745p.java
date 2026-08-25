package sa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.C0138i;
import androidx.appcompat.app.DialogInterfaceC0140j;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import com.p2serv.android.p032ds.R;
import p003a2.AbstractC0032a;

public class C3745p extends DialogInterfaceOnCancelListenerC0415m {

    public static final String f12546s0 = AbstractC0032a.m165s("djTB\n", "G0eme59MOZc=\n");

    public Runnable f12547k0;

    public Runnable f12548l0;

    public TextView f12549m0;

    public Button f12550n0;

    public Button f12551o0;

    public Button f12552p0;

    public final Handler f12553q0 = new Handler(Looper.getMainLooper());

    public InterfaceC3744o f12554r0;

    @Override
    public final void mo1270B() {
        super.mo1270B();
        Button button = this.f12551o0;
        if (button != null) {
            button.requestFocus();
        }
    }

    @Override
    public final Dialog mo1275R() {
        View viewInflate = LayoutInflater.from(m1321j()).inflate(R.layout.tv_alert_dialog_layout, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.leftBtn);
        this.f12550n0 = button;
        button.setText(m1325n(R.string.Upload_log));
        this.f12550n0.setOnClickListener(new ViewOnClickListenerC3743n(this, 0));
        Button button2 = (Button) viewInflate.findViewById(R.id.speedTestBtn);
        this.f12552p0 = button2;
        button2.setText(R.string.network_test);
        this.f12552p0.setOnClickListener(new ViewOnClickListenerC3743n(this, 1));
        Button button3 = (Button) viewInflate.findViewById(R.id.rightBtn);
        this.f12551o0 = button3;
        button3.setText(m1325n(R.string.Cancel));
        this.f12551o0.setOnClickListener(new ViewOnClickListenerC3743n(this, 2));
        this.f12549m0 = (TextView) viewInflate.findViewById(R.id.message);
        String string = this.f1970g.getString(f12546s0);
        if (string != null) {
            this.f12549m0.setText(string);
        }
        AbstractC0032a.m165s("X8kI\n", "C4hPoSN1Gt0=\n");
        AbstractC0032a.m165s("s5yV0CBOpHGYm7fOKkjwYKq/s9E2Trdx8oGz1hFKqGD0n6XFbBXw\n", "3PLWokUv0BQ=\n");
        C0138i c0138i = new C0138i(m1312K());
        c0138i.f383a.f281i = viewInflate;
        DialogInterfaceC0140j dialogInterfaceC0140jM417a = c0138i.m417a();
        dialogInterfaceC0140jM417a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialogInterfaceC0140jM417a.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                String str = C3745p.f12546s0;
                C3745p c3745p = this.f12543a;
                c3745p.getClass();
                if (i6 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                c3745p.m1274Q(false, false);
                return true;
            }
        });
        return dialogInterfaceC0140jM417a;
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f12554r0.onDismiss();
    }
}
