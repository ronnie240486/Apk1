package p035d1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import p014b1.AbstractC1233g;
import p014b1.C1235i;

public final class C2125c extends AbstractC1233g {

    public final WeakReference f7734a;

    public final WeakReference f7735b;

    public C2125c(TextView textView, C2126d c2126d) {
        this.f7734a = new WeakReference(textView);
        this.f7735b = new WeakReference(c2126d);
    }

    @Override
    public final void mo701b() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f7734a.get();
        InputFilter inputFilter = (InputFilter) this.f7735b.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    C1235i c1235iM3106a = C1235i.m3106a();
                    if (text == null) {
                        length = 0;
                    } else {
                        c1235iM3106a.getClass();
                        length = text.length();
                    }
                    CharSequence charSequenceM3110e = c1235iM3106a.m3110e(text, 0, length);
                    if (text == charSequenceM3110e) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(charSequenceM3110e);
                    int selectionEnd = Selection.getSelectionEnd(charSequenceM3110e);
                    textView.setText(charSequenceM3110e);
                    if (charSequenceM3110e instanceof Spannable) {
                        Spannable spannable = (Spannable) charSequenceM3110e;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
