package p035d1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.C0219i3;
import p014b1.C1235i;

public final class C2130h implements TextWatcher {

    public final EditText f7744a;

    public C0219i3 f7745b;

    public boolean f7746c = true;

    public C2130h(EditText editText) {
        this.f7744a = editText;
    }

    public static void m5080a(EditText editText, int i6) {
        int length;
        if (i6 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            C1235i c1235iM3106a = C1235i.m3106a();
            if (editableText == null) {
                length = 0;
            } else {
                c1235iM3106a.getClass();
                length = editableText.length();
            }
            c1235iM3106a.m3110e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        EditText editText = this.f7744a;
        if (editText.isInEditMode() || !this.f7746c || C1235i.f3923j == null || i10 > i11 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iM3107b = C1235i.m3106a().m3107b();
        if (iM3107b != 0) {
            if (iM3107b == 1) {
                C1235i.m3106a().m3110e((Spannable) charSequence, i6, i11 + i6);
                return;
            } else if (iM3107b != 3) {
                return;
            }
        }
        C1235i c1235iM3106a = C1235i.m3106a();
        if (this.f7745b == null) {
            this.f7745b = new C0219i3(editText);
        }
        c1235iM3106a.m3111f(this.f7745b);
    }

    @Override
    public final void afterTextChanged(Editable editable) {
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
    }
}
