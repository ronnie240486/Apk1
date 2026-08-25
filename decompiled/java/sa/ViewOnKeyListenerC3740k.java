package sa;

import android.content.Context;
import android.content.DialogInterface;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.p2serv.android.p032ds.R;
import p003a2.AbstractC0032a;
import p063fa.ViewOnKeyListenerC2564v;
import p116ka.DialogInterfaceOnClickListenerC2938s;

public final class ViewOnKeyListenerC3740k implements View.OnKeyListener {

    public final Context f12522a;

    public String f12523b;

    public String f12524c;

    public String f12525d;

    public String f12526e;

    public String f12527f;

    public DialogInterface.OnClickListener f12529h;

    public DialogInterface.OnClickListener f12530i;

    public DialogInterfaceOnClickListenerC2938s f12531j;

    public CircleProgressBar f12533l;

    public ImageView f12534m;

    public Button f12535n;

    public Button f12536o;

    public Button f12537p;

    public int f12528g = 0;

    public ViewOnKeyListenerC2564v f12532k = null;

    public ViewOnKeyListenerC3740k(Context context) {
        this.f12522a = context;
    }

    public final DialogC3734e m7488a() {
        String strM165s = AbstractC0032a.m165s("Uo4Mfs5yyShQiRlwz2Pk\n", "Pu91EbsGlkE=\n");
        Context context = this.f12522a;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(strM165s);
        DialogC3734e dialogC3734e = new DialogC3734e(context, R.style.Dialog);
        View viewInflate = layoutInflater.inflate(R.layout.dialog_normal_layout, (ViewGroup) null);
        dialogC3734e.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.f12523b);
        if (this.f12525d != null) {
            Button button = (Button) viewInflate.findViewById(R.id.positiveButton);
            this.f12535n = button;
            button.setText(this.f12525d);
            this.f12535n.setOnKeyListener(this);
            if (this.f12529h != null) {
                this.f12535n.setOnClickListener(new ViewOnClickListenerC3739j(this, dialogC3734e, 0));
            }
        } else {
            viewInflate.findViewById(R.id.positiveButton).setVisibility(8);
        }
        if (this.f12526e != null) {
            Button button2 = (Button) viewInflate.findViewById(R.id.negativeButton);
            this.f12536o = button2;
            button2.setText(this.f12526e);
            ViewOnKeyListenerC2564v viewOnKeyListenerC2564v = this.f12532k;
            if (viewOnKeyListenerC2564v != null) {
                this.f12536o.setOnKeyListener(viewOnKeyListenerC2564v);
            } else {
                this.f12536o.setOnKeyListener(this);
            }
            if (this.f12530i != null) {
                this.f12536o.setOnClickListener(new ViewOnClickListenerC3739j(this, dialogC3734e, 1));
            }
        } else {
            viewInflate.findViewById(R.id.negativeButton).setVisibility(8);
        }
        if (this.f12527f != null) {
            Button button3 = (Button) viewInflate.findViewById(R.id.cancelButton);
            this.f12537p = button3;
            button3.setVisibility(0);
            this.f12537p.setText(this.f12527f);
            this.f12537p.setOnKeyListener(this);
            if (this.f12531j != null) {
                this.f12537p.setOnClickListener(new ViewOnClickListenerC3739j(this, dialogC3734e, 2));
            }
        } else {
            viewInflate.findViewById(R.id.cancelButton).setVisibility(8);
        }
        if (this.f12524c != null) {
            TextView textView = (TextView) viewInflate.findViewById(R.id.message);
            textView.setText(this.f12524c);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        this.f12533l = (CircleProgressBar) viewInflate.findViewById(R.id.dialog_progress);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.dialog_icon);
        this.f12534m = imageView;
        int i6 = this.f12528g;
        if (i6 != 0) {
            imageView.setImageResource(i6);
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
            this.f12536o.requestFocus();
            return true;
        }
        if (id == R.id.positiveButton) {
            if (i6 != 4) {
                return false;
            }
            this.f12535n.requestFocus();
            return true;
        }
        if (id != R.id.cancelButton || i6 != 4) {
            return false;
        }
        this.f12537p.requestFocus();
        return true;
    }
}
