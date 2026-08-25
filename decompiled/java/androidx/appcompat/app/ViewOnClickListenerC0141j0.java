package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p124l6.C2982h;
import sa.DialogC3734e;

public final class ViewOnClickListenerC0141j0 implements View.OnClickListener {

    public final int f390a = 0;

    public final View f391b;

    public final Object f392c;

    public Object f393d;

    public Object f394e;

    public ViewOnClickListenerC0141j0(C2982h c2982h, EditText editText, TextView textView, DialogC3734e dialogC3734e) {
        this.f394e = c2982h;
        this.f391b = editText;
        this.f392c = textView;
        this.f393d = dialogC3734e;
    }

    @Override
    public final void onClick(View view) {
        Method method;
        Object obj = this.f392c;
        String string = "";
        View view2 = this.f391b;
        boolean z7 = true;
        switch (this.f390a) {
            case 0:
                if (((Method) this.f393d) == null) {
                    Context context = view2.getContext();
                    while (true) {
                        String str = (String) obj;
                        if (context == null) {
                            int id = view2.getId();
                            string = id != -1 ? " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'" : "";
                            StringBuilder sbM30x = AbstractC0004e.m30x("Could not find method ", str, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                            sbM30x.append(view2.getClass());
                            sbM30x.append(string);
                            throw new IllegalStateException(sbM30x.toString());
                        }
                        try {
                            if (!context.isRestricted() && (method = context.getClass().getMethod(str, View.class)) != null) {
                                this.f393d = method;
                                this.f394e = context;
                            }
                            break;
                        } catch (NoSuchMethodException unused) {
                        }
                        context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                    }
                }
                try {
                    ((Method) this.f393d).invoke((Context) this.f394e, view);
                    return;
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException("Could not execute non-public method for android:onClick", e5);
                } catch (InvocationTargetException e10) {
                    throw new IllegalStateException("Could not execute method for android:onClick", e10);
                }
            default:
                String strTrim = ((EditText) view2).getText().toString().trim();
                boolean zIsEmpty = TextUtils.isEmpty(strTrim);
                C2982h c2982h = (C2982h) this.f394e;
                if (zIsEmpty) {
                    string = ((Context) c2982h.f10225b).getString(R.string.password_cannot_blank);
                } else if (strTrim.length() < 4) {
                    string = String.format(((Context) c2982h.f10225b).getString(R.string.password_too_short), 4);
                } else if (AbstractC3331m.m6757g(AbstractC2440g.f8558g, AbstractC2442h.f8615u).equals(strTrim)) {
                    z7 = false;
                } else {
                    string = ((Context) c2982h.f10225b).getString(R.string.password_err);
                }
                if (z7) {
                    TextView textView = (TextView) obj;
                    textView.setText(string);
                    textView.setVisibility(0);
                    return;
                } else {
                    DialogInterface.OnClickListener onClickListener = (DialogInterface.OnClickListener) c2982h.f10226c;
                    DialogC3734e dialogC3734e = (DialogC3734e) this.f393d;
                    onClickListener.onClick(dialogC3734e, -1);
                    dialogC3734e.dismiss();
                    return;
                }
        }
    }

    public ViewOnClickListenerC0141j0(View view, String str) {
        this.f391b = view;
        this.f392c = str;
    }
}
