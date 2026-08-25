package sa;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import p003a2.AbstractC0032a;

public final class ViewOnKeyListenerC3733d implements View.OnKeyListener {

    public final Context f12504a;

    public String f12505b;

    public String f12506c;

    public String f12507d;

    public View f12508e;

    public DialogInterface.OnClickListener f12509f;

    public DialogInterface.OnClickListener f12510g;

    public Button f12511h;

    public Button f12512i;

    public ViewOnKeyListenerC3733d(Context context) {
        this.f12504a = context;
    }

    public final DialogC3734e m7487a() {
        String strM165s = AbstractC0032a.m165s("Hd9wAqOXG24f2GUMooY2\n", "cb4JbdbjRAc=\n");
        Context context = this.f12504a;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(strM165s);
        DialogC3734e dialogC3734e = new DialogC3734e(context, R.style.Dialog);
        View viewInflate = layoutInflater.inflate(R.layout.dialog_logout_layout, (ViewGroup) null);
        dialogC3734e.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        if (this.f12506c != null) {
            Button button = (Button) viewInflate.findViewById(R.id.positiveButton);
            this.f12511h = button;
            button.setText(this.f12506c);
            this.f12511h.setOnKeyListener(this);
            if (this.f12509f != null) {
                this.f12511h.setOnClickListener(new ViewOnClickListenerC3732c(this, dialogC3734e, 0));
            }
        } else {
            viewInflate.findViewById(R.id.positiveButton).setVisibility(8);
        }
        if (this.f12507d != null) {
            Button button2 = (Button) viewInflate.findViewById(R.id.negativeButton);
            this.f12512i = button2;
            button2.setText(this.f12507d);
            this.f12512i.setOnKeyListener(this);
            if (this.f12510g != null) {
                this.f12512i.setOnClickListener(new ViewOnClickListenerC3732c(this, dialogC3734e, 1));
            }
        } else {
            viewInflate.findViewById(R.id.negativeButton).setVisibility(8);
        }
        if (this.f12505b != null) {
            ((TextView) viewInflate.findViewById(R.id.message)).setText(this.f12505b);
        } else if (this.f12508e != null) {
            ((ViewGroup) viewInflate.findViewById(R.id.content)).removeAllViews();
            ((ViewGroup) viewInflate.findViewById(R.id.content)).addView(this.f12508e, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.f12508e == null) {
            this.f12508e = viewInflate;
        }
        dialogC3734e.setContentView(viewInflate);
        return dialogC3734e;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        int id = view.getId();
        if (id == R.id.negativeButton) {
            if (i6 != 4) {
                return false;
            }
            this.f12512i.requestFocus();
            return true;
        }
        if (id != R.id.positiveButton || i6 != 4) {
            return false;
        }
        this.f12511h.requestFocus();
        return true;
    }
}
