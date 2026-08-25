package p035d1;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import p014b1.C1235i;

public final class C2126d implements InputFilter {

    public final TextView f7736a;

    public C2125c f7737b;

    public C2126d(TextView textView) {
        this.f7736a = textView;
    }

    @Override
    public final CharSequence filter(CharSequence charSequence, int i6, int i10, Spanned spanned, int i11, int i12) {
        TextView textView = this.f7736a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iM3107b = C1235i.m3106a().m3107b();
        if (iM3107b != 0) {
            if (iM3107b == 1) {
                if ((i12 == 0 && i11 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i6 != 0 || i10 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i6, i10);
                }
                return C1235i.m3106a().m3110e(charSequence, 0, charSequence.length());
            }
            if (iM3107b != 3) {
                return charSequence;
            }
        }
        C1235i c1235iM3106a = C1235i.m3106a();
        if (this.f7737b == null) {
            this.f7737b = new C2125c(textView, this);
        }
        c1235iM3106a.m3111f(this.f7737b);
        return charSequence;
    }
}
