package p015b2;

import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

public final class C1252d extends SingleLineTransformationMethod {

    public Locale f3976a;

    @Override
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        if (transformation != null) {
            return transformation.toString().toUpperCase(this.f3976a);
        }
        return null;
    }
}
