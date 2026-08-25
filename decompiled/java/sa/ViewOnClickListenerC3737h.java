package sa;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.utils.AbstractC3331m;
import p001a0.C0023f;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p055ea.DialogInterfaceOnClickListenerC2462r;

public final class ViewOnClickListenerC3737h implements View.OnClickListener {

    public final TextView f12514a;

    public final DialogC3734e f12515b;

    public final C0023f f12516c;

    public ViewOnClickListenerC3737h(C0023f c0023f, TextView textView, DialogC3734e dialogC3734e) {
        this.f12516c = c0023f;
        this.f12514a = textView;
        this.f12515b = dialogC3734e;
    }

    @Override
    public final void onClick(View view) {
        String string;
        C0023f c0023f = this.f12516c;
        String strTrim = ((EditText) c0023f.f46d).getText().toString().trim();
        String strTrim2 = ((EditText) c0023f.f47e).getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2)) {
            string = ((Context) c0023f.f44b).getString(R.string.password_cannot_blank);
        } else if (strTrim.length() < 4 || strTrim2.length() < 4) {
            string = String.format(((Context) c0023f.f44b).getString(R.string.password_too_short), 4);
        } else {
            string = !AbstractC3331m.m6757g(AbstractC2440g.f8558g, AbstractC2442h.f8615u).equals(strTrim) ? ((Context) c0023f.f44b).getString(R.string.password_err) : "";
        }
        if (!string.isEmpty()) {
            TextView textView = this.f12514a;
            textView.setText(string);
            textView.setVisibility(0);
        } else {
            AbstractC3331m.m6764n(AbstractC2440g.f8558g, strTrim2);
            DialogInterfaceOnClickListenerC2462r dialogInterfaceOnClickListenerC2462r = (DialogInterfaceOnClickListenerC2462r) c0023f.f45c;
            DialogC3734e dialogC3734e = this.f12515b;
            dialogInterfaceOnClickListenerC2462r.getClass();
            dialogC3734e.dismiss();
            dialogC3734e.dismiss();
        }
    }
}
