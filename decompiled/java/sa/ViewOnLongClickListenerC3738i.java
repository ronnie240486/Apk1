package sa;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p124l6.C2982h;

public final class ViewOnLongClickListenerC3738i implements View.OnLongClickListener {

    public final EditText f12517a;

    public final C2982h f12518b;

    public ViewOnLongClickListenerC3738i(C2982h c2982h, EditText editText) {
        this.f12518b = c2982h;
        this.f12517a = editText;
    }

    @Override
    public final boolean onLongClick(View view) {
        String strM165s = AbstractC0032a.m165s("OL4wNddV8w==\n", "aMlUcbsywf8=\n");
        String strM165s2 = AbstractC0032a.m165s("xZyWj4fEQ1TDkbHAhs0gSMuBqZeG0WR93g==\n", "qvLa4OmjADg=\n");
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, strM165s2);
        EditText editText = this.f12517a;
        editText.setInputType(16);
        editText.setImeOptions(6);
        InputMethodManager inputMethodManager = (InputMethodManager) ((Context) this.f12518b.f10225b).getSystemService(AbstractC0032a.m165s("kYJAgQorEzmMhF+Q\n", "+Oww9H50flw=\n"));
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.showSoftInput(editText, 0);
        return true;
    }
}
