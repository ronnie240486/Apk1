package p083i;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public final class C2677a implements TransformationMethod {

    public Locale f9313a;

    @Override
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f9313a);
        }
        return null;
    }

    @Override
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z7, int i6, Rect rect) {
    }
}
