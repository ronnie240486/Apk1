package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.google.android.material.textfield.C1867e;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Log;
import ga.C2630m;
import ga.EnumC2629l;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p116ka.ViewOnKeyListenerC2932m0;
import p116ka.ViewOnKeyListenerC2937r;

public final class C0253p2 implements TextWatcher {

    public final int f1028a;

    public final Object f1029b;

    public C0253p2(int i6, Object obj) {
        this.f1028a = i6;
        this.f1029b = obj;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        switch (this.f1028a) {
            case 1:
                C1867e c1867e = (C1867e) this.f1029b;
                if (c1867e.f6867a.getSuffixText() == null) {
                    c1867e.m4381e(C1867e.m4378d(c1867e));
                    break;
                }
                break;
            case 2:
                TextInputLayout textInputLayout = (TextInputLayout) this.f1029b;
                textInputLayout.m4371t(!textInputLayout.f6756I0, false);
                if (textInputLayout.f6792l) {
                    textInputLayout.m4364m(editable.length());
                }
                if (textInputLayout.f6806s) {
                    textInputLayout.m4372u(editable.length());
                }
                break;
            case 3:
                ViewOnKeyListenerC2937r.m5944Q((ViewOnKeyListenerC2937r) this.f1029b, editable.toString());
                break;
        }
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        int i12 = this.f1028a;
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        String strM5648e;
        Object obj = this.f1029b;
        switch (this.f1028a) {
            case 0:
                SearchView searchView = (SearchView) obj;
                Editable text = searchView.f746p.getText();
                searchView.f738V = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.m602x(!zIsEmpty);
                int i12 = 8;
                if (searchView.f737U && !searchView.f730N && zIsEmpty) {
                    searchView.f751u.setVisibility(8);
                    i12 = 0;
                }
                searchView.f753w.setVisibility(i12);
                searchView.m598t();
                searchView.m601w();
                charSequence.toString();
                break;
            case 1:
            case 2:
            case 3:
                break;
            default:
                String strM165s = AbstractC0032a.m165s("uxfQ/bo=\n", "+USGkt7Ipuo=\n");
                String str = AbstractC0032a.m165s("rlsZ7047PE39URbJSCsNerVfFvpIN0M=\n", "3T54nS1TeTk=\n") + charSequence.toString();
                boolean z7 = AbstractC3331m.f11244b;
                Log.m5049i(strM165s, str);
                if (charSequence.length() != 0) {
                    strM5648e = C2630m.m5648e(C2630m.m5649h(EnumC2629l.f9137h) + AbstractC0032a.m165s("Vw==\n", "eCa2c9opGpg=\n") + ((Object) charSequence));
                } else {
                    strM5648e = "";
                }
                String str2 = ViewOnKeyListenerC2932m0.f9947B0;
                ((ViewOnKeyListenerC2932m0) obj).m5935Y(-20, strM5648e);
                break;
        }
    }

    private final void m743a(Editable editable) {
    }

    private final void m744b(Editable editable) {
    }

    private final void m745c(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m746d(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m747e(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m748f(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m749g(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m750h(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m751i(int i6, int i10, int i11, CharSequence charSequence) {
    }

    private final void m752j(int i6, int i10, int i11, CharSequence charSequence) {
    }
}
