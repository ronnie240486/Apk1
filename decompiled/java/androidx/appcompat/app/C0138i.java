package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import p105k.DialogInterfaceOnKeyListenerC2839m;

public class C0138i {

    public final C0130e f383a;

    public final int f384b;

    public C0138i(Context context) {
        int iM424i = DialogInterfaceC0140j.m424i(context, 0);
        this.f383a = new C0130e(new ContextThemeWrapper(context, DialogInterfaceC0140j.m424i(context, iM424i)));
        this.f384b = iM424i;
    }

    public static Context m416b() {
        throw null;
    }

    public final DialogInterfaceC0140j m417a() {
        C0130e c0130e = this.f383a;
        DialogInterfaceC0140j dialogInterfaceC0140j = new DialogInterfaceC0140j(c0130e.f273a, this.f384b);
        View view = c0130e.f277e;
        C0136h c0136h = dialogInterfaceC0140j.f389e;
        if (view != null) {
            c0136h.f372p = view;
        } else {
            CharSequence charSequence = c0130e.f276d;
            if (charSequence != null) {
                c0136h.f360d = charSequence;
                TextView textView = c0136h.f370n;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c0130e.f275c;
            if (drawable != null) {
                c0136h.f368l = drawable;
                ImageView imageView = c0136h.f369m;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c0136h.f369m.setImageDrawable(drawable);
                }
            }
        }
        if (c0130e.f279g != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c0130e.f274b.inflate(c0136h.f376t, (ViewGroup) null);
            int i6 = c0130e.f282j ? c0136h.f377u : c0136h.f378v;
            Object obj = c0130e.f279g;
            ?? c0134g = obj;
            if (obj == null) {
                c0134g = new C0134g(c0130e.f273a, i6, R.id.text1, null);
            }
            c0136h.f373q = c0134g;
            c0136h.f374r = c0130e.f283k;
            if (c0130e.f280h != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0128d(c0130e, c0136h));
            }
            if (c0130e.f282j) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            c0136h.f361e = alertController$RecycleListView;
        }
        View view2 = c0130e.f281i;
        if (view2 != null) {
            c0136h.f362f = view2;
            c0136h.f363g = false;
        }
        dialogInterfaceC0140j.setCancelable(true);
        dialogInterfaceC0140j.setCanceledOnTouchOutside(true);
        dialogInterfaceC0140j.setOnCancelListener(null);
        dialogInterfaceC0140j.setOnDismissListener(null);
        DialogInterfaceOnKeyListenerC2839m dialogInterfaceOnKeyListenerC2839m = c0130e.f278f;
        if (dialogInterfaceOnKeyListenerC2839m != null) {
            dialogInterfaceC0140j.setOnKeyListener(dialogInterfaceOnKeyListenerC2839m);
        }
        return dialogInterfaceC0140j;
    }
}
