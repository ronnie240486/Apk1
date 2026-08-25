package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import com.p2serv.android.p032ds.R;

public class SearchEditText extends StreamingTextView {

    public InterfaceC0503w0 f2247h;

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.TextAppearance_Leanback_SearchTextEdit);
    }

    @Override
    public final boolean onKeyPreIme(int i6, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.f2247h != null) {
            post(new RunnableC0447a(3, this));
        }
        return super.onKeyPreIme(i6, keyEvent);
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setFinalRecognizedText(CharSequence charSequence) {
        setText(charSequence);
        bringPointIntoView(length());
    }

    public void setOnKeyboardDismissListener(InterfaceC0503w0 interfaceC0503w0) {
        this.f2247h = interfaceC0503w0;
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
